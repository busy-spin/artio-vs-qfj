package com.github.iaw.artio;

import com.github.iaw.sbe.codecs.MessageHeaderDecoder;
import com.github.iaw.sbe.codecs.RpcConnectRequestDecoder;
import io.aeron.Aeron;
import io.aeron.Subscription;
import io.aeron.logbuffer.Header;
import org.agrona.DirectBuffer;
import org.agrona.concurrent.Agent;
import org.agrona.concurrent.IdleStrategy;
import org.agrona.concurrent.SleepingIdleStrategy;

public class RpcServerAgent implements Agent {
    private final IdleStrategy idleStrategy = new SleepingIdleStrategy();

    private final MessageHeaderDecoder headerDecoder = new MessageHeaderDecoder();
    private final RpcConnectRequestDecoder connectRequestDecoder  = new RpcConnectRequestDecoder();

    Subscription subscription;

    public RpcServerAgent(Aeron aeron) {
        // server listen on 127.0.0.1:2001 on stream 1
        subscription = aeron.addSubscription("aeron:udp?endpoint=127.0.0.1:2001", 1);
        while (!subscription.isConnected()) {
            idleStrategy.idle();
        }
    }

    @Override
    public int doWork() throws Exception {
        return subscription.poll(this::onFragment, 1);
    }

    public void onFragment(DirectBuffer buffer,
                           int offset,
                           int length,
                           Header header) {
        headerDecoder.wrap(buffer, offset);
        headerDecoder.templateId();

        System.out.println("Template id " + headerDecoder.templateId());
    }

    @Override
    public String roleName() {
        return "server-";
    }
}
