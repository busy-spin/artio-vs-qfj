package com.github.iaw.artio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger("test");
        logger.info("Hello {}", "world");
    }
}