package com.github.iaw.artio;

import baseline.LogEventEncoder;
import baseline.MessageHeaderEncoder;
import ch.qos.logback.classic.spi.ILoggingEvent;
import io.aeron.Publication;
import org.agrona.concurrent.UnsafeBuffer;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class AeronMessagePackager {


    private static final int MAX_LENGTH = 1024;
    private final MessageHeaderEncoder headerEncoder = new MessageHeaderEncoder();
    private final LogEventEncoder logEventEncoder = new LogEventEncoder();
    private final UnsafeBuffer unsafeBuffer = new UnsafeBuffer(ByteBuffer.allocateDirect(MAX_LENGTH));
    private final Publication publication;

    private final String profile;
    private final String hostname;
    private final String serviceName;
    private final String instanceId;


    public AeronMessagePackager(Publication publication, String profile, String hostname, String serviceName, String instanceId) {
        System.out.println("Getting my TL packager " + Thread.currentThread().getName());
        this.publication = publication;
        this.profile = profile;
        this.hostname = hostname;
        this.serviceName = serviceName;
        this.instanceId = instanceId;
    }

    public void log(ILoggingEvent logEvent) {
        int maxLength = Math.min(logEvent.getFormattedMessage().length(), MAX_LENGTH);
        char[] message = Arrays.copyOfRange(logEvent.getFormattedMessage().toCharArray(), 0, maxLength);

        logEventEncoder.wrapAndApplyHeader(unsafeBuffer, 0, headerEncoder);
        logEventEncoder.timestamp(logEvent.getTimeStamp());
        logEventEncoder.level(logEvent.getLevel().levelInt);
        logEventEncoder.profile(profile);
        logEventEncoder.serviceName(serviceName);
        logEventEncoder.instanceId(instanceId);
        logEventEncoder.formattedMessage(new String(message));
        logEventEncoder.hostname(hostname);
        logEventEncoder.loggerName(logEvent.getLoggerName());
        logEventEncoder.threadName(logEvent.getThreadName());

        int length = logEventEncoder.encodedLength() + headerEncoder.encodedLength();

        publication.offer(unsafeBuffer, 0, length);
    }
}
