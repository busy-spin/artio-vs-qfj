package com.github.iaw.aeron.subscriber;

import io.aeron.Aeron;
import lombok.extern.slf4j.Slf4j;
import org.agrona.concurrent.AgentRunner;
import org.agrona.concurrent.NoOpIdleStrategy;
import org.agrona.concurrent.ShutdownSignalBarrier;
import org.agrona.concurrent.SigInt;

@Slf4j
public class AeronSubscriber {

    public static void main(String[] args) {
        final Aeron.Context aeronCtx = new Aeron.Context().aeronDirectoryName(Aeron.Context.getAeronDirectoryName() + "md");
        final ShutdownSignalBarrier signalBarrier = new ShutdownSignalBarrier();
        try (Aeron aeron = Aeron.connect(aeronCtx);
             final AgentRunner agentRunner = new AgentRunner(new NoOpIdleStrategy(),
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
