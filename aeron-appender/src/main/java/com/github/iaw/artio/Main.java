package com.github.iaw.artio;

import io.aeron.Aeron;
import io.aeron.CommonContext;
import io.aeron.driver.MediaDriver;
import io.aeron.driver.ThreadingMode;
import org.agrona.concurrent.AgentRunner;
import org.agrona.concurrent.IdleStrategy;
import org.agrona.concurrent.SleepingIdleStrategy;
import org.agrona.concurrent.SystemEpochClock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        MediaDriver.Context context = new MediaDriver.Context().aeronDirectoryName(CommonContext.getAeronDirectoryName() + "log-server")
                .dirDeleteOnStart(true).dirDeleteOnShutdown(true).threadingMode(ThreadingMode.SHARED);

        MediaDriver mediaDriver = MediaDriver.launchEmbedded(context);

        Aeron aeron = Aeron.connect(new Aeron.Context().aeronDirectoryName(mediaDriver.aeronDirectoryName()));

        AeronLogServer agent = new AeronLogServer(aeron, "aeron:udp?endpoint=127.0.0.1:10001", 0);


        AgentRunner agentRunner = new AgentRunner(new SleepingIdleStrategy(), throwable -> {
        }, null, agent);

        AgentRunner.startOnThread(agentRunner);

        int threadCount = 3;
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        for (int i = 0; i < threadCount; i++) {
            executorService.submit(Main::logInAThread);
            Thread.sleep(3_000);
        }
    }

    private static void logInAThread() {
        IdleStrategy idleStrategy = new SleepingIdleStrategy();
        Logger logger = LoggerFactory.getLogger(Main.class);
        SystemEpochClock epochClock = SystemEpochClock.INSTANCE;
        long startTime = epochClock.time();
        AtomicLong counter = new AtomicLong();
        while (true) {
            if (epochClock.time() < startTime + 10_000) {
                idleStrategy.idle();
            } else {
                startTime = epochClock.time();
                logger.info("Hello {} , {}", "world", counter.getAndIncrement());
            }

        }
    }
}