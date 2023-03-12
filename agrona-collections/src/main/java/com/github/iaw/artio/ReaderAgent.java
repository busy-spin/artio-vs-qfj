package com.github.iaw.artio;

import baseline.CarDecoder;
import baseline.MessageHeaderDecoder;
import baseline.Model;
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

    int[] modelCounter = new int[Model.values().length];

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

        modelCounter[carDecoder.code().ordinal()]++;

        if (messageSoFar != 0 && messageSoFar % 1_000_000 == 0) {
            System.out.println("Serial number - " + carDecoder.serialNumber());
        }

        if (messageSoFar == totalPublishCount) {
            System.out.println("Sending signal");
            for (int i = 0; i < modelCounter.length; i++) {
                System.out.println("Production of model " + Model.values()[i] + " is " + modelCounter[i]);
            }
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
