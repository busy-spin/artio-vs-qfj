package com.github.iaw.aeron.subscriber;

import io.aeron.Aeron;
import io.aeron.driver.MediaDriver;
import io.aeron.driver.ThreadingMode;
import lombok.extern.slf4j.Slf4j;
import org.agrona.concurrent.*;

@Slf4j
public class AeronSubscriber {

    public static void main(String[] args) {
        final String aeronDir = Aeron.Context.getAeronDirectoryName() + "-subscriber";
        final MediaDriver.Context mdCtx = new MediaDriver.Context()
                .aeronDirectoryName(aeronDir);
        mdCtx.threadingMode(ThreadingMode.SHARED);
        mdCtx.senderIdleStrategy(new SleepingIdleStrategy());
        mdCtx.receiverIdleStrategy(new SleepingIdleStrategy());
        mdCtx.conductorIdleStrategy(new SleepingIdleStrategy());

        final Aeron.Context aeronCtx = new Aeron.Context().aeronDirectoryName(aeronDir);
        final ShutdownSignalBarrier signalBarrier = new ShutdownSignalBarrier();
        try (MediaDriver md = MediaDriver.launch(mdCtx); Aeron aeron = Aeron.connect(aeronCtx);
             final AgentRunner agentRunner = new AgentRunner(new SleepingIdleStrategy(),
                     error -> {
                     }, null, new HelloSubscriberAgent(aeron))) {

            log.info("Starting the subscriber program");

            AgentRunner.startOnThread(agentRunner);

            SigInt.register(() -> {
                log.info("Shutdown signal received.");
                signalBarrier.signal();
            });
            signalBarrier.await();
        } finally {
            log.info("Exiting the program.");
        }
    }
}
