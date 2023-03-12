package com.github.iaw.artio;

import baseline.CarEncoder;
import baseline.MessageHeaderEncoder;
import baseline.Model;
import org.agrona.concurrent.Agent;
import org.agrona.concurrent.AtomicBuffer;
import org.agrona.concurrent.UnsafeBuffer;
import org.agrona.concurrent.ringbuffer.OneToOneRingBuffer;

import java.nio.ByteBuffer;

public class WriterAgent implements Agent {

    private final OneToOneRingBuffer ringBuffer;
    private final long totalPublishCount;
    private Model model;

    private long soFarPublishedCount = 0;

    private final UnsafeBuffer unsafeBuffer;

    private final MessageHeaderEncoder headerEncoder = new MessageHeaderEncoder();
    private final CarEncoder carEncoder = new CarEncoder();

    public WriterAgent(OneToOneRingBuffer ringBuffer, long totalPublishCount, Model model) {
        this.ringBuffer = ringBuffer;
        this.totalPublishCount = totalPublishCount;
        this.model = model;
        unsafeBuffer = new UnsafeBuffer(ByteBuffer.allocateDirect(256));
    }

    @Override
    public int doWork() throws Exception {
        while (soFarPublishedCount < totalPublishCount) {
            soFarPublishedCount++;
            carEncoder.wrapAndApplyHeader(unsafeBuffer, 0, headerEncoder);
            carEncoder.serialNumber(soFarPublishedCount);
            carEncoder.code(model);

            int length = carEncoder.encodedLength() + headerEncoder.encodedLength();

            int claimIndex = -1;
            while ((claimIndex = ringBuffer.tryClaim(CarEncoder.TEMPLATE_ID, length)) < 0) {
            }

            AtomicBuffer buffer = ringBuffer.buffer();
            buffer.putBytes(claimIndex, unsafeBuffer, 0, length);
            ringBuffer.commit(claimIndex);

        }
        return 1;
    }

    @Override
    public String roleName() {
        return "writer";
    }
}
