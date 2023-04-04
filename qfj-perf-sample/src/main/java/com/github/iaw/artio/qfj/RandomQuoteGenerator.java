package com.github.iaw.artio.qfj;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RandomQuoteGenerator {

    private static final double[] AVAILABLE_SIZES = {1_000_000, 2_000_000, 3_000_000, 5_000_000, 10_000_000, 15_000_000};

    private Quote quote = new Quote();

    private final double mid;
    private final double spread;
    private final int levels;

    public RandomQuoteGenerator(double mid, double spread, int requestedLevels) {
        this.mid = mid;
        this.spread = spread;
        this.levels = Math.min(AVAILABLE_SIZES.length, requestedLevels);

        if (this.levels < requestedLevels) {
            log.warn("Cannot support [{}] levels, maximum levels supported is [{}]",
                    requestedLevels, AVAILABLE_SIZES.length);
        }


        quote.setBids(new double[this.levels]);
        quote.setAsks(new double[this.levels]);

        double[] sizes = new double[this.levels];
        System.arraycopy(AVAILABLE_SIZES, 0, sizes, 0, this.levels);
        quote.setSize(sizes);
    }


    @Data
    public static class Quote {
        private double[] bids;
        private double[] asks;
        private double[] size;
    }


}
