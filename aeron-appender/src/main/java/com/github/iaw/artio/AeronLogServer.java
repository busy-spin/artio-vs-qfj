package com.github.iaw.artio;

import baseline.LogEventDecoder;
import baseline.MessageHeaderDecoder;
import io.aeron.Aeron;
import io.aeron.Subscription;
import io.aeron.logbuffer.Header;
import org.agrona.DirectBuffer;
import org.agrona.concurrent.Agent;

public class AeronLogServer implements Agent {

    private final MessageHeaderDecoder headerDecoder = new MessageHeaderDecoder();
    private final LogEventDecoder logEventDecoder = new LogEventDecoder();
    private final Aeron aeron;
    private final String channelId;
    private final int streamId;

    Subscription subscription;

    public AeronLogServer(Aeron aeron, String channelId, int streamId) {
        this.aeron = aeron;
        this.channelId = channelId;
        this.streamId = streamId;
        subscription = aeron.addSubscription(channelId, streamId);
    }

    @Override
    public int doWork() throws Exception {
        return subscription.poll(this::onFragment, 1);
    }

    public void onFragment(DirectBuffer buffer,
                           int offset,
                           int length,
                           Header header) {

    }

    @Override
    public String roleName() {
        return "aeron-log-server";
    }
}
