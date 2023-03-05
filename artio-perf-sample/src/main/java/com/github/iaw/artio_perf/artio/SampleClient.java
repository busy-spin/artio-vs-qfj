/*
 * Copyright 2015-2022 Real Logic Limited.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.iaw.artio_perf.artio;

import io.aeron.driver.MediaDriver;
import org.agrona.IoUtil;
import org.agrona.concurrent.AgentRunner;
import org.agrona.concurrent.CompositeAgent;
import org.agrona.concurrent.SleepingIdleStrategy;
import uk.co.real_logic.artio.engine.EngineConfiguration;
import uk.co.real_logic.artio.engine.FixEngine;
import uk.co.real_logic.artio.library.FixLibrary;
import uk.co.real_logic.artio.library.LibraryConfiguration;
import uk.co.real_logic.artio.library.SessionConfiguration;
import uk.co.real_logic.artio.library.SessionHandler;
import uk.co.real_logic.artio.session.Session;

import java.io.File;

import static io.aeron.driver.ThreadingMode.SHARED;
import static java.util.Collections.singletonList;

// NB: You should start the {@link SampleServer} class first before starting this client.
// This client uses a different media driver instance to the SampleServer, so it sets a bunch of
// channels to avoid clashing.
public final class SampleClient
{

    public static final String ACCEPTOR_COMP_ID = "EXEC";

    public static final String[] INITIATOR_COMP_IDS = new String[]{"BANZAI1"};
    public static final int[] CONNECT_PORTS = new int[]{9999};

    public static final ArtioInitiatorPollingAgent[] agents = new ArtioInitiatorPollingAgent[INITIATOR_COMP_IDS.length];

    private static final String CLIENT_AERON_DIR = "client-aeron-dir2";

    public static void main(final String[] args)
    {
        // Static configuration lasts the duration of a FIX-Gateway instance
        final String aeronChannel = "aeron:ipc";
        final EngineConfiguration engineConfiguration = new EngineConfiguration()
            .libraryAeronChannel(aeronChannel).defaultHeartbeatIntervalInS(1)
                        .logInboundMessages(false).logOutboundMessages(false)
                .logFileDir("client-1");

        engineConfiguration.aeronContext()
            .aeronDirectoryName(CLIENT_AERON_DIR);

        cleanupOldLogFileDir(engineConfiguration);

        final MediaDriver.Context context = new MediaDriver.Context()
            .threadingMode(SHARED)
            .dirDeleteOnStart(true)
            .aeronDirectoryName(CLIENT_AERON_DIR);

        try (MediaDriver driver = MediaDriver.launch(context))
        {
            try (FixEngine ignore = FixEngine.launch(engineConfiguration))
            {
                // Each outbound session with an Exchange or broker is represented by
                // a Session object. Each session object can be configured with connection
                // details and credentials.

                final SleepingIdleStrategy idleStrategy = new SleepingIdleStrategy(100);

                final LibraryConfiguration libraryConfiguration = new LibraryConfiguration()
                    .sessionAcquireHandler((session, acquiredInfo) -> onConnect(session))
                    .libraryAeronChannels(singletonList(aeronChannel));

                libraryConfiguration.aeronContext()
                    .aeronDirectoryName(CLIENT_AERON_DIR);

                try (FixLibrary library = FixLibrary.connect(libraryConfiguration)) {
                    while (!library.isConnected()) {
                        library.poll(1);
                        Thread.yield();
                    }
                    for (int i = 0; i < INITIATOR_COMP_IDS.length; i++) {
                        SessionConfiguration sessionConfiguration = SessionConfiguration.builder()
                                .address("localhost", CONNECT_PORTS[i])
                                .senderCompId(INITIATOR_COMP_IDS[i])
                                .targetCompId(ACCEPTOR_COMP_ID)
                                .build();

                        ArtioInitiatorPollingAgent agent = new ArtioInitiatorPollingAgent(sessionConfiguration, library);
                        agents[i] = agent;
                    }

                    CompositeAgent compositeAgent = new CompositeAgent(agents);
                    AgentRunner agentRunner = new AgentRunner(new SleepingIdleStrategy(), Throwable::printStackTrace, null, compositeAgent);

                    AgentRunner.startOnThread(agentRunner);

                    try {
                        Thread.currentThread().join();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }

        //System.exit(0);
    }

    private static SessionHandler onConnect(final Session session)
    {
        return new InitiatorSessionHandler();
    }

    public static void cleanupOldLogFileDir(final EngineConfiguration configuration)
    {
        IoUtil.delete(new File(configuration.logFileDir()), true);
    }
}
