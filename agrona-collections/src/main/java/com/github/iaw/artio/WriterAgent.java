package com.github.iaw.artio;

import baseline.CarEncoder;
import baseline.MessageHeaderEncoder;
import org.agrona.concurrent.Agent;
import org.agrona.concurrent.UnsafeBuffer;
import org.agrona.concurrent.ringbuffer.OneToOneRingBuffer;

import java.nio.ByteBuffer;

public class WriterAgent implements Agent {

    private final OneToOneRingBuffer ringBuffer;
    private final long totalPublishCount;

    private long soFarPublishedCount = 0;

    private final UnsafeBuffer unsafeBuffer;

    private final MessageHeaderEncoder headerEncoder = new MessageHeaderEncoder();
    private final CarEncoder carEncoder = new CarEncoder();

    public WriterAgent(OneToOneRingBuffer ringBuffer, long totalPublishCount) {
        this.ringBuffer = ringBuffer;
        this.totalPublishCount = totalPublishCount;
        unsafeBuffer = new UnsafeBuffer(ByteBuffer.allocateDirect(256));
    }

    @Override
    public int doWork() throws Exception {
        while (soFarPublishedCount < totalPublishCount) {
            soFarPublishedCount++;
            carEncoder.wrapAndApplyHeader(unsafeBuffer, 0, headerEncoder);
            carEncoder.serialNumber(soFarPublishedCount);

            int length = carEncoder.encodedLength() + headerEncoder.encodedLength();
/*            int i = -1;
            while ((i = ringBuffer.tryClaim(CarEncoder.TEMPLATE_ID, length)) < 0) {
                // try
            }*/
            boolean writeComplete = false;
            while (!writeComplete) {
                writeComplete = ringBuffer.write(CarEncoder.TEMPLATE_ID, unsafeBuffer, 0, length);
            }
        }
        return 1;
    }

    @Override
    public String roleName() {
        return "writer";
    }
}
