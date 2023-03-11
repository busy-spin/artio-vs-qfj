package com.github.iaw.artio_perf.artio;

import io.aeron.driver.MediaDriver;
import lombok.extern.slf4j.Slf4j;
import org.agrona.concurrent.AgentRunner;
import org.agrona.concurrent.BusySpinIdleStrategy;
import org.agrona.concurrent.IdGenerator;
import org.agrona.concurrent.IdleStrategy;
import org.agrona.concurrent.SleepingIdleStrategy;
import org.agrona.concurrent.SnowflakeIdGenerator;
import uk.co.real_logic.artio.engine.EngineConfiguration;
import uk.co.real_logic.artio.engine.FixEngine;
import uk.co.real_logic.artio.library.AcquiringSessionExistsHandler;
import uk.co.real_logic.artio.library.FixLibrary;
import uk.co.real_logic.artio.library.LibraryConfiguration;
import uk.co.real_logic.artio.library.SessionHandler;
import uk.co.real_logic.artio.session.Session;
import uk.co.real_logic.artio.validation.AuthenticationStrategy;
import uk.co.real_logic.artio.validation.MessageValidationStrategy;

import java.util.Arrays;
import java.util.List;

import static com.github.iaw.artio_perf.artio.SampleClient.cleanupOldLogFileDir;
import static io.aeron.driver.ThreadingMode.SHARED;
import static java.util.Collections.singletonList;

@Slf4j
public class SampleAcceptor {

    public static final String ACCEPTOR_COMP_ID = "EXEC";

    public static final List<String> validInitiatorIds = Arrays.asList("BANZAI1", "BANZAI2", "BANZAI3");

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

            final IdleStrategy idleStrategy = new BusySpinIdleStrategy();

            System.out.println("Connecting library to aeron context");
            try (FixLibrary library = SampleUtil.blockingConnect(libraryConfiguration)) {

                AcceptorAgent acceptorAgent = new AcceptorAgent(library);

                AgentRunner agentRunner = new AgentRunner(new SleepingIdleStrategy(), throwable -> {}, null, acceptorAgent);

                AgentRunner.startOnThread(agentRunner);

                try {
                    Thread.currentThread().join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        System.exit(0);
    }

    private static SessionHandler onConnect(Session session) {
        return new SimpleSessionHandler();
    }

}
