package com.github.iaw.artio;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.UnsynchronizedAppenderBase;
import io.aeron.Aeron;
import io.aeron.CommonContext;
import io.aeron.Publication;
import io.aeron.driver.MediaDriver;
import io.aeron.driver.ThreadingMode;

public class AeronAppender extends UnsynchronizedAppenderBase<ILoggingEvent> {



    private String profile;

    private String hostname = System.getenv("HOSTNAME");
    private String serviceName;
    private String instanceId;


    private String aeronChannel;

    private int streamId = 0;

    private Publication publication;

    ThreadLocal<AeronMessagePackager> tlMessagePackager = ThreadLocal.withInitial(
            () -> new AeronMessagePackager(publication, profile, hostname, serviceName, instanceId)
    );

    public AeronAppender() {
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
        tlMessagePackager.get().log(logEvent);
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
