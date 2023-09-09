package com.github.iaw.aeron;

import io.aeron.Aeron;
import io.aeron.driver.MediaDriver;
import io.aeron.driver.ThreadingMode;
import lombok.extern.slf4j.Slf4j;
import org.agrona.concurrent.BusySpinIdleStrategy;
import org.agrona.concurrent.ShutdownSignalBarrier;
import org.agrona.concurrent.SigInt;

@Slf4j
public class AeronMediaDriver {

    public static void main(String[] args) {
        ShutdownSignalBarrier signalBarrier = new ShutdownSignalBarrier();
        try (MediaDriver mediaDriver = mediaDriver()) {

            log.info("Started Aeron Media Driver");

            SigInt.register(() -> {
                log.info("Shutdown signal received.");
                signalBarrier.signal();
            });
            signalBarrier.await();
        } finally {
            log.info("Exiting media driver program.");
        }

    }

    private static MediaDriver mediaDriver() {
        MediaDriver.Context mdCtx = new MediaDriver.Context()
                .aeronDirectoryName(MediaDriver.Context.getAeronDirectoryName() + "md")
                .conductorIdleStrategy(BusySpinIdleStrategy.INSTANCE)
                .receiverIdleStrategy(BusySpinIdleStrategy.INSTANCE)
                .senderIdleStrategy(BusySpinIdleStrategy.INSTANCE)
                .termBufferSparseFile(true).printConfigurationOnStart(true)
                .threadingMode(ThreadingMode.DEDICATED);

        return MediaDriver.launch(mdCtx);
    }
}
