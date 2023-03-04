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
import org.agrona.concurrent.SleepingIdleStrategy;
import uk.co.real_logic.artio.builder.TestRequestEncoder;
import uk.co.real_logic.artio.engine.EngineConfiguration;
import uk.co.real_logic.artio.engine.FixEngine;
import uk.co.real_logic.artio.library.FixLibrary;
import uk.co.real_logic.artio.library.LibraryConfiguration;
import uk.co.real_logic.artio.library.LibraryConnectHandler;
import uk.co.real_logic.artio.library.LibraryUtil;
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
    public static final String INITIATOR_COMP_ID = "BANZAI3";
    private static final TestReqIdFinder TEST_REQ_ID_FINDER = new TestReqIdFinder();

    private static final String CLIENT_AERON_DIR = "client-aeron-dir2";

    public static void main(final String[] args)
    {
        // Static configuration lasts the duration of a FIX-Gateway instance
        final String aeronChannel = "aeron:ipc";
        final EngineConfiguration configuration = new EngineConfiguration()
            .libraryAeronChannel(aeronChannel).defaultHeartbeatIntervalInS(1)
                        .logInboundMessages(false).logOutboundMessages(false).logFileDir("client-1");

        configuration.aeronContext()
            .aeronDirectoryName(CLIENT_AERON_DIR);

        cleanupOldLogFileDir(configuration);

        final MediaDriver.Context context = new MediaDriver.Context()
            .threadingMode(SHARED)
            .dirDeleteOnStart(true)
            .aeronDirectoryName(CLIENT_AERON_DIR);

        try (MediaDriver driver = MediaDriver.launch(context))
        {
            try (FixEngine ignore = FixEngine.launch(configuration))
            {
                // Each outbound session with an Exchange or broker is represented by
                // a Session object. Each session object can be configured with connection
                // details and credentials.
                final SessionConfiguration sessionConfig = SessionConfiguration.builder()
                    .address("localhost", 9999)
                    .targetCompId(ACCEPTOR_COMP_ID)
                    .senderCompId(INITIATOR_COMP_ID)
                    .build();

                final SessionConfiguration sessionConfig2 = SessionConfiguration.builder()
                        .address("localhost", 9999)
                        .targetCompId(ACCEPTOR_COMP_ID)
                        .senderCompId("BANZAI2")
                        .build();

                final SleepingIdleStrategy idleStrategy = new SleepingIdleStrategy(100);

                final LibraryConfiguration libraryConfiguration = new LibraryConfiguration()
                    .sessionAcquireHandler((session, acquiredInfo) -> onConnect(session))
                        .libraryConnectHandler(new LibraryConnectHandler() {
                            @Override
                            public void onConnect(FixLibrary fixLibrary) {

                            }

                            @Override
                            public void onDisconnect(FixLibrary fixLibrary) {

                            }
                        })
                    .libraryAeronChannels(singletonList(aeronChannel));

                libraryConfiguration.aeronContext()
                    .aeronDirectoryName(CLIENT_AERON_DIR);

                try (FixLibrary library = SampleUtil.blockingConnect(libraryConfiguration))
                {
                    // Whilst we only initiate a single Session for a given library here, it is
                    // perfectly possible to initiate multiple Sessions on a given library
                    // and manage them accordingly.
                    final Session session = LibraryUtil.initiate(
                        library,
                        sessionConfig,
                        10_000,
                        idleStrategy);

                    final Session session2 = LibraryUtil.initiate(
                            library,
                            sessionConfig2,
                            10_000,
                            idleStrategy);

                    System.out.println("############");

                    while (!session.isActive() && !session2.isActive())
                    {
                        idleStrategy.idle(library.poll(1));
                    }

                    final TestRequestEncoder testRequest = new TestRequestEncoder();
                    testRequest.testReqID("Hello World");

                    session.trySend(testRequest);

                    while (true)
                    {
                        if (!session.isConnected()) {
                            LibraryUtil.initiate(
                                    library,
                                    sessionConfig,
                                    10_000,
                                    idleStrategy);
                        }
                        idleStrategy.idle(library.poll(1));
                    }

                    /*System.out.println("Success, received reply!");
                    System.out.println(TEST_REQ_ID_FINDER.testReqId());

                    session.startLogout();
                    session.requestDisconnect();

                    while (session.state() != DISCONNECTED)
                    {
                        idleStrategy.idle(library.poll(1));
                    }

                    System.out.println("Disconnected");*/
                }
            }
        }

        //System.exit(0);
    }

    private static SessionHandler onConnect(final Session session)
    {
        return TEST_REQ_ID_FINDER;
    }

    public static void cleanupOldLogFileDir(final EngineConfiguration configuration)
    {
        IoUtil.delete(new File(configuration.logFileDir()), true);
    }
}
