package com.github.iaw.artio_perf.artio;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.agrona.concurrent.Agent;
import org.agrona.concurrent.EpochClock;
import org.agrona.concurrent.SystemEpochClock;
import uk.co.real_logic.artio.Reply;
import uk.co.real_logic.artio.library.FixLibrary;
import uk.co.real_logic.artio.library.SessionConfiguration;
import uk.co.real_logic.artio.messages.SessionState;
import uk.co.real_logic.artio.session.Session;

@Slf4j
@RequiredArgsConstructor
public class ArtioInitiatorPollingAgent implements Agent {

    private final SessionConfiguration sessionConfiguration;
    private final FixLibrary library;

    private final EpochClock epochClock = SystemEpochClock.INSTANCE;

    private final int connectionStatusReportMs = 5 * 1000;
    private long lastDutyCycleTime = epochClock.time();

    private Session session;

    private Reply<Session> sessionReply;

    private long sessionInitiationCounter = 0;

    @Override
    public int doWork() throws Exception {
        long timeNow = epochClock.time();
        if (timeNow > lastDutyCycleTime + connectionStatusReportMs) {
            if (session != null) {
                log.info("Session state {}", session.state());
            }
            if (sessionReply != null) {
                log.info("Session reply state {}", sessionReply.state());
            }
            lastDutyCycleTime = timeNow;
        }
        // manageConnection
        // managePolling
        if (session != null && session.isActive()) {
            return library.poll(1);
        } else {
            if (sessionReply == null) {
                initiateSession();
                return 0;
            }
            if (sessionReply.isExecuting()) {
                return library.poll(1);
            }
            if (sessionReply.hasCompleted()) {
                session = sessionReply.resultIfPresent();
                sessionReply = null;
                return library.poll(1);
            }
            if (session == null || session.state() == SessionState.DISCONNECTED) {
                initiateSession();
                return 0;
            }
            return 0;
        }
    }

    @Override
    public String roleName() {
        return sessionConfiguration.senderCompId();
    }

    public void onClose() {
        session.requestDisconnect();
        library.close();
    }

    public void onStart() {
        initiateSession();
    }

    public void initiateSession() {
        sessionReply = library.initiate(sessionConfiguration);
        log.info("Initiate session again. [{}]", sessionReply.state());
    }


}
