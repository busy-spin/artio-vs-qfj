package com.github.iaw.artio;

import baseline.LogEventEncoder;
import baseline.MessageHeaderEncoder;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.UnsynchronizedAppenderBase;
import io.aeron.Aeron;
import io.aeron.CommonContext;
import io.aeron.Publication;
import io.aeron.driver.MediaDriver;
import io.aeron.driver.ThreadingMode;
import org.agrona.concurrent.UnsafeBuffer;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class AeronAppender extends UnsynchronizedAppenderBase<ILoggingEvent> {

    private static final int MAX_LENGTH = 1024;
    private final MessageHeaderEncoder headerEncoder = new MessageHeaderEncoder();
    private final LogEventEncoder logEventEncoder = new LogEventEncoder();
    private final UnsafeBuffer unsafeBuffer;

    private String profile;
    private String serviceName;
    private String instanceId;

    private String hostname = System.getenv("HOSTNAME");

    private String aeronChannel;

    private int streamId = 0;

    private Publication publication;

    public AeronAppender() {
        unsafeBuffer = new UnsafeBuffer(ByteBuffer.allocateDirect(2096));
    }

    @Override
    public void start() {
        MediaDriver.Context mediaDriverCtx = new MediaDriver.Context().threadingMode(ThreadingMode.SHARED)
                .dirDeleteOnShutdown(true)
                .dirDeleteOnStart(true)
                .aeronDirectoryName(CommonContext.getAeronDirectoryName() + "-" + serviceName + "-" + instanceId);

        MediaDriver mediaDriver = MediaDriver.launchEmbedded(mediaDriverCtx);

        Aeron.Context aeronCtx = new Aeron.Context();
        aeronCtx.aeronDirectoryName(mediaDriver.aeronDirectoryName());

        Aeron aeron = Aeron.connect(aeronCtx);

        publication = aeron.addPublication(aeronChannel, streamId);

        super.start();
    }

    @Override
    protected void append(ILoggingEvent logEvent) {

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

        int length = logEventEncoder.encodedLength() + headerEncoder.encodedLength();

        publication.offer(unsafeBuffer, 0, length);
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public void setAeronChannel(String aeronChannel) {
        this.aeronChannel = aeronChannel;
    }
}
