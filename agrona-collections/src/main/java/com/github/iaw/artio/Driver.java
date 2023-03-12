package com.github.iaw.artio;

import org.agrona.concurrent.AgentRunner;
import org.agrona.concurrent.IdleStrategy;
import org.agrona.concurrent.ShutdownSignalBarrier;
import org.agrona.concurrent.UnsafeBuffer;
import org.agrona.concurrent.YieldingIdleStrategy;
import org.agrona.concurrent.ringbuffer.OneToOneRingBuffer;
import org.agrona.concurrent.ringbuffer.RingBufferDescriptor;

import java.nio.ByteBuffer;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class Driver {

    public static void main(String[] args) {
        int capacity = 4096 + RingBufferDescriptor.TRAILER_LENGTH;
        int totalEventCount = 100_000_000;
        ShutdownSignalBarrier barrier = new ShutdownSignalBarrier();

        OneToOneRingBuffer ringBuffer = new OneToOneRingBuffer(new UnsafeBuffer(ByteBuffer.allocate(capacity)));

        ReaderAgent readerAgent = new ReaderAgent(ringBuffer, totalEventCount, barrier);
        WriterAgent writerAgent = new WriterAgent(ringBuffer, totalEventCount);

        IdleStrategy waitStrategy = new YieldingIdleStrategy();

        AgentRunner readerAgentRunner = new AgentRunner(waitStrategy, throwable -> {
        }, null, readerAgent);

        AgentRunner writerAgentRunner = new AgentRunner(waitStrategy, throwable -> {
        }, null, writerAgent);

        AgentRunner.startOnThread(readerAgentRunner, threadFactory("reader-", true));
        AgentRunner.startOnThread(writerAgentRunner, threadFactory("writer-", true));

        System.out.println("About to wait for signal barrier");
        barrier.await();
        System.out.println("Signal received");
    }

    public static ThreadFactory threadFactory(String prefix, boolean isDeamon) {
        return new ThreadFactory() {

            private final AtomicInteger atomicInteger = new AtomicInteger(1);
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setName(prefix + atomicInteger.getAndIncrement());
                thread.setDaemon(isDeamon);
                return thread;
            }
        };
    }

}
