package com.github.iaw.artio_perf.artio;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.HdrHistogram.Histogram;
import org.agrona.concurrent.Agent;
import org.agrona.concurrent.EpochClock;
import org.agrona.concurrent.SystemEpochClock;

@RequiredArgsConstructor
@Slf4j
public class HistogramAgent implements Agent {

    private final Histogram histogram;
    private EpochClock epochClock = SystemEpochClock.INSTANCE;
    private long startTime = epochClock.time();
    private long statPrintDelayInMs = 10 * 1000;

    private long lastWindowTotal = 0;

    @Override
    public int doWork() throws Exception {
        long timeNow = epochClock.time();
        if (timeNow > statPrintDelayInMs + startTime) {
            startTime = timeNow;
            log.info("Percentiles\n p100=[{}]\n p99.99=[{}]\n p99.9=[{}]\n p99=[{}]\n total=[{}]",
                    histogram.getValueAtPercentile(100),
                    histogram.getValueAtPercentile(99.99),
                    histogram.getValueAtPercentile(99.9),
                    histogram.getValueAtPercentile(99),
                    histogram.getTotalCount());
            histogram.reset();
        }
        return 0;
    }

    @Override
    public String roleName() {
        return "HISTO";
    }
}
