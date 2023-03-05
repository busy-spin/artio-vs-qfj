package com.github.iaw.artio_perf.artio;

import io.aeron.logbuffer.ControlledFragmentHandler;
import lombok.extern.slf4j.Slf4j;
import org.agrona.DirectBuffer;
import uk.co.real_logic.artio.library.OnMessageInfo;
import uk.co.real_logic.artio.library.SessionHandler;
import uk.co.real_logic.artio.messages.DisconnectReason;
import uk.co.real_logic.artio.session.Session;

import static io.aeron.logbuffer.ControlledFragmentHandler.Action.CONTINUE;

@Slf4j
public class InitiatorSessionHandler implements SessionHandler {

    @Override
    public ControlledFragmentHandler.Action onMessage(DirectBuffer buffer, int offset, int length, int libraryId, Session session, int sequenceIndex, long messageType, long timestampInNs, long position, OnMessageInfo messageInfo) {
        long heartBeatType = (long) '0';

        if (messageType == heartBeatType) {
            log.info("Heart beat !!!!");
        }

        return null;
    }

    @Override
    public void onTimeout(int libraryId, Session session) {

    }

    @Override
    public void onSlowStatus(int libraryId, Session session, boolean hasBecomeSlow) {

    }

    @Override
    public ControlledFragmentHandler.Action onDisconnect(int libraryId, Session session, DisconnectReason reason) {
        return CONTINUE;
    }

    @Override
    public void onSessionStart(Session session) {

    }
}
