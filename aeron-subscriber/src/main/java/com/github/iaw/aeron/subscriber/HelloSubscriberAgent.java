package com.github.iaw.aeron.subscriber;

import io.aeron.Aeron;
import io.aeron.Subscription;
import lombok.extern.slf4j.Slf4j;
import org.agrona.concurrent.Agent;

@Slf4j
public class HelloSubscriberAgent implements Agent {

    private final Aeron aeron;
    private final Subscription subscription;

    public HelloSubscriberAgent(Aeron aeron) {
        this.aeron = aeron;
        subscription = this.aeron.addSubscription("aeron:ipc", 1001);
    }

    @Override
    public void onStart() {
        log.info("Subscriber agent started.");
    }

    @Override
    public int doWork() throws Exception {
        subscription.poll((buffer, offset, length, header) -> {
            final String stringAscii = buffer.getStringAscii(offset, length);
            log.info("{}", stringAscii);
        }, 10);
        return 0;
    }

    @Override
    public void onClose() {
        subscription.close();
    }

    @Override
    public String roleName() {
        return "Hello-Subscriber";
    }
}
