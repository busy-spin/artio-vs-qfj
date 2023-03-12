package com.github.iaw.artio;

import baseline.CarDecoder;
import baseline.MessageHeaderDecoder;
import org.agrona.MutableDirectBuffer;
import org.agrona.concurrent.Agent;
import org.agrona.concurrent.ShutdownSignalBarrier;
import org.agrona.concurrent.ringbuffer.OneToOneRingBuffer;

public class ReaderAgent implements Agent {

    private final OneToOneRingBuffer ringBuffer;
    private final long totalPublishCount;

    private long messageSoFar;

    private final ShutdownSignalBarrier barrier;

    private final CarDecoder carDecoder = new CarDecoder();
    private final MessageHeaderDecoder headerDecoder = new MessageHeaderDecoder();

    public ReaderAgent(OneToOneRingBuffer ringBuffer, long totalPublishCount, ShutdownSignalBarrier barrier) {
        this.ringBuffer = ringBuffer;
        this.totalPublishCount = totalPublishCount;
        this.barrier = barrier;
    }

    @Override
    public int doWork() throws Exception {
        ringBuffer.read(this::onMessage);
        return 1;
    }

    void onMessage(int msgTypeId, MutableDirectBuffer buffer, int index, int length) {
        headerDecoder.wrap(buffer, index);
        int headerLength = headerDecoder.encodedLength();
        int actingLength = headerDecoder.blockLength();
        int actingVersion = headerDecoder.version();

        carDecoder.wrap(buffer, index + headerLength, actingLength, actingVersion);

        messageSoFar++;

        if (messageSoFar != 0 && messageSoFar % 1_000_000 == 0) {
            System.out.println("Serial number - " + carDecoder.serialNumber());
        }

        if (messageSoFar == totalPublishCount) {
            barrier.signal();
            System.out.println("Sending signal");
        }

        if (messageSoFar > totalPublishCount) {
            System.out.println("### Big Problem ###");
        }

    }

    @Override
    public String roleName() {
        return "reader";
    }
}
