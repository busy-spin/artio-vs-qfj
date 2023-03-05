package com.github.iaw.artio_perf.artio;

import com.github.iaw.artio.codecs.banzai.decoder.NewOrderCrossDecoder;
import io.aeron.logbuffer.ControlledFragmentHandler;
import lombok.extern.slf4j.Slf4j;
import org.agrona.DirectBuffer;
import org.agrona.concurrent.SystemEpochClock;
import uk.co.real_logic.artio.fields.UtcTimestampDecoder;
import uk.co.real_logic.artio.library.OnMessageInfo;
import uk.co.real_logic.artio.library.SessionHandler;
import uk.co.real_logic.artio.messages.DisconnectReason;
import uk.co.real_logic.artio.session.Session;
import uk.co.real_logic.artio.util.MutableAsciiBuffer;

import static io.aeron.logbuffer.ControlledFragmentHandler.Action.CONTINUE;

@Slf4j
public class InitiatorSessionHandler implements SessionHandler {

    long newOrderSingleMsgType = 'D';

    private final MutableAsciiBuffer asciiBuffer = new MutableAsciiBuffer(new byte[8 * 1024]);

    private final UtcTimestampDecoder timestampDecoder = new UtcTimestampDecoder(false);

    NewOrderCrossDecoder decoder = new NewOrderCrossDecoder();

    SystemEpochClock epochClock = SystemEpochClock.INSTANCE;

    @Override
    public ControlledFragmentHandler.Action onMessage(DirectBuffer buffer, int offset, int length, int libraryId, Session session, int sequenceIndex, long messageType, long timestampInNs, long position, OnMessageInfo messageInfo) {
        log.info("Message type = [{}]", (char)messageType);
        if (messageType == newOrderSingleMsgType) {
            asciiBuffer.putBytes(0, buffer, offset, length);
            decoder.decode(asciiBuffer, 0, length);

            long timestamp = timestampDecoder.decode(decoder.header().sendingTime());
            log.info("Time diff in ms = [{}]", epochClock.time() - timestamp);
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
