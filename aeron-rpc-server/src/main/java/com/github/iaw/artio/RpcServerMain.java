package com.github.iaw.artio;

import io.aeron.Aeron;
import io.aeron.CommonContext;
import io.aeron.driver.MediaDriver;
import io.aeron.driver.ThreadingMode;
import org.agrona.concurrent.AgentRunner;
import org.agrona.concurrent.SleepingIdleStrategy;

public class RpcServerMain {

    public static void main(String[] args) throws InterruptedException {
        MediaDriver.Context ctx = new MediaDriver.Context();
        ctx.aeronDirectoryName(CommonContext.getAeronDirectoryName() + "-server").dirDeleteOnStart(true).dirDeleteOnShutdown(true)
                        .threadingMode(ThreadingMode.SHARED);
        MediaDriver mediaDriver = MediaDriver.launchEmbedded(ctx);

        Aeron.Context context = new Aeron.Context();
        context.aeronDirectoryName(mediaDriver.aeronDirectoryName());

        Aeron aeron = Aeron.connect(context);

        RpcServerAgent rpcServerAgent = new RpcServerAgent(aeron);

        AgentRunner agentRunner = new AgentRunner(new SleepingIdleStrategy(), throwable -> {
        }, null, rpcServerAgent);

        AgentRunner.startOnThread(agentRunner);

        Thread.currentThread().join();
    }

}
