package com.github.iaw.aeron.publisher;

import io.aeron.Aeron;
import io.aeron.driver.MediaDriver;
import io.aeron.driver.ThreadingMode;
import lombok.extern.slf4j.Slf4j;
import org.agrona.concurrent.*;

@Slf4j
public class AeronPublisher {

    public static void main(String[] args) {
        final String aeronDir = Aeron.Context.getAeronDirectoryName() + "-publisher";
        final MediaDriver.Context mdCtx = new MediaDriver.Context()
                .aeronDirectoryName(aeronDir);
        mdCtx.threadingMode(ThreadingMode.SHARED);
        mdCtx.senderIdleStrategy(new SleepingIdleStrategy());
        mdCtx.receiverIdleStrategy(new SleepingIdleStrategy());
        mdCtx.conductorIdleStrategy(new SleepingIdleStrategy());

        final Aeron.Context aeronCtx = new Aeron.Context().aeronDirectoryName(aeronDir);

        final ShutdownSignalBarrier signalBarrier = new ShutdownSignalBarrier();
        try (MediaDriver md = MediaDriver.launch(mdCtx); Aeron aeron = Aeron.connect(aeronCtx);
             AgentRunner agentRunner = publisherAgentRunner(aeron)) {

            AgentRunner.startOnThread(agentRunner);

            SigInt.register(() -> {
                log.info("Shutdown signal received");
                signalBarrier.signal();
            });
            signalBarrier.await();
        } finally {
            log.info("Exiting the program.");
        }
    }

    public static AgentRunner publisherAgentRunner(Aeron aeron) {
        return new AgentRunner(new SleepingIdleStrategy(), error -> {}, null, new HelloPublisherAgent(aeron));
    }

}
