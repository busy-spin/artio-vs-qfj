package com.github.iaw.artio_perf.artio;

import com.github.iaw.artio.codecs.banzai.OrdType;
import com.github.iaw.artio.codecs.banzai.Side;
import com.github.iaw.artio.codecs.banzai.builder.NewOrderSingleEncoder;
import io.aeron.driver.MediaDriver;
import org.agrona.concurrent.IdGenerator;
import org.agrona.concurrent.IdleStrategy;
import org.agrona.concurrent.SigInt;
import org.agrona.concurrent.SnowflakeIdGenerator;
import org.agrona.concurrent.SystemEpochClock;
import uk.co.real_logic.artio.CommonConfiguration;
import uk.co.real_logic.artio.engine.EngineConfiguration;
import uk.co.real_logic.artio.engine.FixEngine;
import uk.co.real_logic.artio.fields.UtcTimestampEncoder;
import uk.co.real_logic.artio.library.AcquiringSessionExistsHandler;
import uk.co.real_logic.artio.library.FixLibrary;
import uk.co.real_logic.artio.library.LibraryConfiguration;
import uk.co.real_logic.artio.library.SessionHandler;
import uk.co.real_logic.artio.session.Session;
import uk.co.real_logic.artio.validation.AuthenticationStrategy;
import uk.co.real_logic.artio.validation.MessageValidationStrategy;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import static com.github.iaw.artio_perf.artio.SampleClient.cleanupOldLogFileDir;
import static io.aeron.driver.ThreadingMode.SHARED;
import static java.util.Collections.singletonList;

public class SampleAcceptor {

    public static final String ACCEPTOR_COMP_ID = "EXEC";

    public static final List<String> validInitiatorIds = Arrays.asList("BANZAI1");

    private static final String SERVER_AERON_DIR = "client-aeron-dir";

    public static void main(String[] args) {
        final MessageValidationStrategy validationStrategy = MessageValidationStrategy.targetCompId(ACCEPTOR_COMP_ID)
                .and(MessageValidationStrategy.senderCompId(validInitiatorIds));

        final AuthenticationStrategy authenticationStrategy = AuthenticationStrategy.of(validationStrategy);

        // Static configuration lasts the duration of a FIX-Gateway instance
        final String aeronChannel = "aeron:ipc";
        final EngineConfiguration configuration = new EngineConfiguration()
                .libraryAeronChannel(aeronChannel)
                .defaultHeartbeatIntervalInS(1).authenticationStrategy(authenticationStrategy)
                .bindTo("localhost", 9999)
                .logInboundMessages(false)
                .logOutboundMessages(false);

        configuration.aeronContext()
                .aeronDirectoryName(SERVER_AERON_DIR);

        cleanupOldLogFileDir(configuration);

        final MediaDriver.Context context = new MediaDriver.Context()
                .threadingMode(SHARED)
                .dirDeleteOnStart(true)
                .aeronDirectoryName(SERVER_AERON_DIR);

        final IdGenerator idGenerator = new SnowflakeIdGenerator(1L);

        try (MediaDriver driver = MediaDriver.launch(context);
             FixEngine gateway = FixEngine.launch(configuration))
        {
            final LibraryConfiguration libraryConfiguration = new LibraryConfiguration();

            // You register the new session handler - which is your application hook
            // that receives messages for new sessions
            libraryConfiguration
                    .sessionAcquireHandler((session, acquiredInfo) -> onConnect(session))
                    .sessionExistsHandler(new AcquiringSessionExistsHandler())
                    .libraryAeronChannels(singletonList(aeronChannel));

            libraryConfiguration.aeronContext().aeronDirectoryName(SERVER_AERON_DIR);

            final IdleStrategy idleStrategy = CommonConfiguration.backoffIdleStrategy();

            System.out.println("Connecting library to aeron context");
            try (FixLibrary library = SampleUtil.blockingConnect(libraryConfiguration))
            {

                System.out.println("#############");
                System.out.println(library.sessions());

                final AtomicBoolean running = new AtomicBoolean(true);
                SigInt.register(() -> running.set(false));

                System.out.println("Library connected to engine.");

                SystemEpochClock instance = SystemEpochClock.INSTANCE;

                long startTime = instance.time();
                long waitTime = 1000L;
                long throughput = 10_000;

                NewOrderSingleEncoder newOrderSingleEncoder = new NewOrderSingleEncoder();
                UtcTimestampEncoder utcTimestampEncoder = new UtcTimestampEncoder();

                long counterInThisWindow = 0;

                while (running.get())
                {
                    idleStrategy.idle(library.poll(1));
                    if (instance.time() < startTime + waitTime) {
                        continue;
                    }

                    long ordId = idGenerator.nextId();
                    char[] clientOrdId = String.valueOf(ordId).toCharArray();

                    utcTimestampEncoder.encode(instance.time());
                    newOrderSingleEncoder.transactTime(utcTimestampEncoder.buffer());
                    newOrderSingleEncoder.ordType(OrdType.LIMIT);
                    newOrderSingleEncoder.side(Side.BUY);
                    newOrderSingleEncoder.clOrdID(clientOrdId);
                    newOrderSingleEncoder.orderQtyData().orderQty(100_000, 0);
                    newOrderSingleEncoder.instrument().symbol(new char[]{'B','N','A'});
                    newOrderSingleEncoder.handlInst('1');
                    newOrderSingleEncoder.header().sendingTime(utcTimestampEncoder.buffer());

                    library.sessions().forEach(session -> {
                        if (session.isActive()) {
                            session.trySend(newOrderSingleEncoder);
                        }
                    });

                    startTime = instance.time();
                }
            }
        }

        System.exit(0);
    }

    private static SessionHandler onConnect(Session session) {
        return new SimpleSessionHandler();
    }

}
