package com.github.iaw.artio_perf.artio;

import io.aeron.logbuffer.ControlledFragmentHandler;
import org.agrona.DirectBuffer;
import uk.co.real_logic.artio.builder.Printer;
import uk.co.real_logic.artio.decoder.PrinterImpl;
import uk.co.real_logic.artio.library.OnMessageInfo;
import uk.co.real_logic.artio.library.SessionHandler;
import uk.co.real_logic.artio.messages.DisconnectReason;
import uk.co.real_logic.artio.session.Session;
import uk.co.real_logic.artio.util.AsciiBuffer;
import uk.co.real_logic.artio.util.MutableAsciiBuffer;

import java.util.List;

import static io.aeron.logbuffer.ControlledFragmentHandler.Action.CONTINUE;

public class SimpleSessionHandler implements SessionHandler {

    private final AsciiBuffer string = new MutableAsciiBuffer();
    private final Printer printer = new PrinterImpl();

    public SimpleSessionHandler()
    {
    }

    public ControlledFragmentHandler.Action onMessage(
            final DirectBuffer buffer,
            final int offset,
            final int length,
            final int libraryId,
            final Session session,
            final int sequenceIndex,
            final long messageType,
            final long timestampInNs,
            final long position,
            final OnMessageInfo messageInfo)
    {
        string.wrap(buffer);
        System.out.printf("%d -> %s%n", session.id(), printer.toString(string, offset, length, messageType));

        return CONTINUE;
    }

    public void onTimeout(final int libraryId, final Session session)
    {
    }

    public void onSlowStatus(final int libraryId, final Session session, final boolean hasBecomeSlow)
    {
    }

    public ControlledFragmentHandler.Action onDisconnect(final int libraryId, final Session session, final DisconnectReason reason)
    {
        System.out.printf("%d Disconnected: %s%n", session.id(), reason);
        return CONTINUE;
    }

    public void onSessionStart(final Session session)
    {
    }
}
