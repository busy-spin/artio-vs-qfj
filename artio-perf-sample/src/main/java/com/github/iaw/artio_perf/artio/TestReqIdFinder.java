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

import com.github.iaw.artio.codecs.banzai.decoder.NewOrderSingleDecoder;
import io.aeron.logbuffer.ControlledFragmentHandler.Action;
import org.agrona.DirectBuffer;
import uk.co.real_logic.artio.library.OnMessageInfo;
import uk.co.real_logic.artio.library.SessionHandler;
import uk.co.real_logic.artio.messages.DisconnectReason;
import uk.co.real_logic.artio.session.Session;
import uk.co.real_logic.artio.util.MutableAsciiBuffer;

import static io.aeron.logbuffer.ControlledFragmentHandler.Action.CONTINUE;

public class TestReqIdFinder implements SessionHandler {
    private final MutableAsciiBuffer asciiBuffer = new MutableAsciiBuffer(new byte[8 * 1024]);

    public Action onMessage(
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

        long newSingleOrder = 'D';

        if(messageType == newSingleOrder) {
            asciiBuffer.putBytes(0, buffer, offset, length);
            NewOrderSingleDecoder decoder = new NewOrderSingleDecoder();
            decoder.decode(asciiBuffer, 0, length);

            char[] symbol = decoder.symbol();
            System.out.println(symbol);
        }

        return CONTINUE;
    }

    public void onTimeout(final int libraryId, final Session session)
    {
    }

    public void onSlowStatus(final int libraryId, final Session session, final boolean hasBecomeSlow)
    {
    }

    public Action onDisconnect(final int libraryId, final Session session, final DisconnectReason reason)
    {
        System.out.println(reason);
        System.out.println("Hello disconnect " + session + " " + session.isConnected());
        return CONTINUE;
    }

    public void onSessionStart(final Session session)
    {
    }

}
