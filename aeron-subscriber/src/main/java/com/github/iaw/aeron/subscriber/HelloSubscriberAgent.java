package com.github.iaw.aeron.subscriber;

import baseline.CarDecoder;
import baseline.MessageHeaderDecoder;
import io.aeron.Aeron;
import io.aeron.Subscription;
import io.aeron.logbuffer.FragmentHandler;
import lombok.extern.slf4j.Slf4j;
import org.HdrHistogram.Histogram;
import org.agrona.concurrent.Agent;
import org.agrona.concurrent.SystemEpochClock;

@Slf4j
public class HelloSubscriberAgent implements Agent {

    private final Aeron aeron;
    private final Subscription subscription;

    private MessageHeaderDecoder headerDecoder = new MessageHeaderDecoder();
    private CarDecoder carDecoder = new CarDecoder();
    private Histogram histogram = new Histogram(3);

    private final int histogramReportInterval = 5_000;
    private long histogramReportStartTime = 0;

    final FragmentHandler fragmentHandler = getFragmentHandler();

    private int counter = 0;

    public HelloSubscriberAgent(Aeron aeron) {
        this.aeron = aeron;
        subscription = this.aeron.addSubscription("aeron:udp?endpoint=0.0.0.0:0|control=localhost:23009|control-mode=dynamic", 1001);
    }

    @Override
    public void onStart() {
        log.info("Subscriber agent started.");
        histogramReportStartTime = SystemEpochClock.INSTANCE.time();
    }

    @Override
    public int doWork() throws Exception {
        if (SystemEpochClock.INSTANCE.time() - histogramReportStartTime >= histogramReportInterval) {
            histogramReportStartTime = SystemEpochClock.INSTANCE.time();
            log.info("p99=[{}] p99.99=[{}] p100=[{}], throughput=[{}]", histogram.getValueAtPercentile(99),
                    histogram.getValueAtPercentile(99.99),
                    histogram.getValueAtPercentile(100.0), counter);

            counter = 0;
        }

        return subscription.poll(fragmentHandler, 10);
    }

    private FragmentHandler getFragmentHandler() {
        return (buffer, offset, length, header) -> {
            carDecoder.wrapAndApplyHeader(buffer, offset, headerDecoder);
            final long serialNumber = carDecoder.serialNumber();
            histogram.recordValue(SystemEpochClock.INSTANCE.time() - serialNumber);
            counter++;
        };
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
