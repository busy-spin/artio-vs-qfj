package com.github.iaw.artio;

import com.github.iaw.sbe.codecs.MessageHeaderEncoder;
import com.github.iaw.sbe.codecs.RpcConnectRequestEncoder;
import io.aeron.Aeron;
import io.aeron.Publication;
import org.agrona.concurrent.Agent;
import org.agrona.concurrent.IdleStrategy;
import org.agrona.concurrent.SleepingIdleStrategy;
import org.agrona.concurrent.UnsafeBuffer;

import java.nio.ByteBuffer;

public class RpcClientAgent implements Agent {

    private final Aeron aeron;

    Publication publication;

    UnsafeBuffer unsafeBuffer = new UnsafeBuffer(ByteBuffer.allocateDirect(256));

    private MessageHeaderEncoder headerEncoder = new MessageHeaderEncoder();
    private RpcConnectRequestEncoder connectRequestEncoder = new RpcConnectRequestEncoder();

    IdleStrategy sleepingIdleStrategy = new SleepingIdleStrategy();

    public RpcClientAgent(Aeron aeron) {
        this.aeron = aeron;
        publication = aeron.addPublication("aeron:udp?endpoint=127.0.0.1:2001", 1);
    }

    @Override
    public int doWork() throws Exception {
        connectRequestEncoder.wrapAndApplyHeader(unsafeBuffer, 0, headerEncoder);
        connectRequestEncoder.returnConnectStream(1);
        connectRequestEncoder.returnConnectUri("aeron:udp?endpoint=127.0.0.1:3001");

        int length = headerEncoder.encodedLength() + connectRequestEncoder.encodedLength();

        while (publication.offer(unsafeBuffer, 0, length) < 0) {
            sleepingIdleStrategy.idle();
        }
        return 0;
    }

    @Override
    public String roleName() {
        return "client-";
    }
}
