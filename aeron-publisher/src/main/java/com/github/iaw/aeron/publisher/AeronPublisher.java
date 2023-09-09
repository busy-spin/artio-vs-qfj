package com.github.iaw.aeron.publisher;

import io.aeron.Aeron;
import io.aeron.driver.MediaDriver;
import lombok.extern.slf4j.Slf4j;
import org.agrona.concurrent.AgentRunner;
import org.agrona.concurrent.NoOpIdleStrategy;
import org.agrona.concurrent.ShutdownSignalBarrier;
import org.agrona.concurrent.SigInt;

@Slf4j
public class AeronPublisher {

    public static void main(String[] args) {
        Aeron.Context aeronCtx = new Aeron.Context()
                .aeronDirectoryName(MediaDriver.Context.getAeronDirectoryName() + "md");
        final ShutdownSignalBarrier signalBarrier = new ShutdownSignalBarrier();
        try (Aeron aeron = Aeron.connect(aeronCtx);
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
        return new AgentRunner(new NoOpIdleStrategy(), error -> {}, null, new HelloPublisherAgent(aeron));
    }

}
