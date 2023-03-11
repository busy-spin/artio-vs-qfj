package com.github.iaw.artio_perf.artio;

import com.github.iaw.artio.codecs.banzai.OrdType;
import com.github.iaw.artio.codecs.banzai.Side;
import com.github.iaw.artio.codecs.banzai.builder.NewOrderSingleEncoder;
import lombok.extern.slf4j.Slf4j;
import org.agrona.concurrent.Agent;
import org.agrona.concurrent.IdGenerator;
import org.agrona.concurrent.SnowflakeIdGenerator;
import org.agrona.concurrent.SystemEpochClock;
import uk.co.real_logic.artio.fields.UtcTimestampEncoder;
import uk.co.real_logic.artio.library.FixLibrary;

@Slf4j
public class AcceptorAgent implements Agent {

    NewOrderSingleEncoder newOrderSingleEncoder = new NewOrderSingleEncoder();
    UtcTimestampEncoder utcTimestampEncoder = new UtcTimestampEncoder();

    final IdGenerator idGenerator = new SnowflakeIdGenerator(1L);
    long counterInThisWindow = 0;
    SystemEpochClock instance = SystemEpochClock.INSTANCE;
    long startTime = instance.time();
    long waitTime = 1000L;
    long throughput = 25_000;

    private final FixLibrary library;

    public AcceptorAgent(FixLibrary library) {
        this.library = library;
    }

    @Override
    public void onStart() {
        startTime = instance.time();
    }

    @Override
    public int doWork() throws Exception {
        boolean startNewWindow = instance.time() > (startTime + waitTime);
        if (startNewWindow) {
            log.info("Total in this window = [{}]", counterInThisWindow);
            counterInThisWindow = 0;
            startTime = instance.time();
        }

        if (counterInThisWindow >= throughput) {
            return 0;
        }

        counterInThisWindow++;

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

        library.poll(1000);
        return 1;
    }

    @Override
    public void onClose() {
    }

    @Override
    public String roleName() {
        return "agent";
    }
}
