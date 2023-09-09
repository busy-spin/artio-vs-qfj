package com.github.iaw.aeron.publisher;

import baseline.CarEncoder;
import baseline.MessageHeaderEncoder;
import baseline.Model;
import io.aeron.Aeron;
import io.aeron.ConcurrentPublication;
import lombok.extern.slf4j.Slf4j;
import org.agrona.concurrent.Agent;
import org.agrona.concurrent.SystemEpochClock;
import org.agrona.concurrent.UnsafeBuffer;

import java.nio.ByteBuffer;

@Slf4j
public class HelloPublisherAgent implements Agent {

    UnsafeBuffer unsafeBuffer = new UnsafeBuffer(ByteBuffer.allocateDirect(2048));

    private MessageHeaderEncoder messageHeaderEncoder = new MessageHeaderEncoder();
    private CarEncoder carEncoder = new CarEncoder();

    private final Aeron aeron;
    private final ConcurrentPublication publication;

    public HelloPublisherAgent(Aeron aeron) {
        this.aeron = aeron;
        publication = aeron.addPublication("aeron:ipc", 1001);
    }

    @Override
    public int doWork() throws Exception {
        carEncoder.wrapAndApplyHeader(unsafeBuffer, 0, messageHeaderEncoder);
        carEncoder.serialNumber(SystemEpochClock.INSTANCE.time());
        carEncoder.code(Model.A);

        int length = messageHeaderEncoder.encodedLength() + carEncoder.encodedLength();

        publication.offer(unsafeBuffer, 0, length);
        return 1;
    }

    @Override
    public String roleName() {
        return "Hello-Publisher";
    }

    @Override
    public void onStart() {
        log.info("Starting the agent.");
    }

    @Override
    public void onClose() {
        publication.close();
    }
}
