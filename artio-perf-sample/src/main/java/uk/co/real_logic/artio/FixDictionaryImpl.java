/* Generated Fix Gateway message codec */
package uk.co.real_logic.artio;

import uk.co.real_logic.artio.dictionary.FixDictionary;
import uk.co.real_logic.artio.builder.AbstractLogonEncoder;
import uk.co.real_logic.artio.builder.LogonEncoder;
import uk.co.real_logic.artio.builder.AbstractResendRequestEncoder;
import uk.co.real_logic.artio.builder.ResendRequestEncoder;
import uk.co.real_logic.artio.builder.AbstractLogoutEncoder;
import uk.co.real_logic.artio.builder.LogoutEncoder;
import uk.co.real_logic.artio.builder.AbstractHeartbeatEncoder;
import uk.co.real_logic.artio.builder.HeartbeatEncoder;
import uk.co.real_logic.artio.builder.AbstractRejectEncoder;
import uk.co.real_logic.artio.builder.RejectEncoder;
import uk.co.real_logic.artio.builder.AbstractTestRequestEncoder;
import uk.co.real_logic.artio.builder.TestRequestEncoder;
import uk.co.real_logic.artio.builder.AbstractSequenceResetEncoder;
import uk.co.real_logic.artio.builder.SequenceResetEncoder;
import uk.co.real_logic.artio.builder.AbstractBusinessMessageRejectEncoder;
import uk.co.real_logic.artio.builder.BusinessMessageRejectEncoder;
import uk.co.real_logic.artio.builder.SessionHeaderEncoder;
import uk.co.real_logic.artio.builder.HeaderEncoder;
import uk.co.real_logic.artio.decoder.AbstractLogonDecoder;
import uk.co.real_logic.artio.decoder.LogonDecoder;
import uk.co.real_logic.artio.decoder.AbstractLogoutDecoder;
import uk.co.real_logic.artio.decoder.LogoutDecoder;
import uk.co.real_logic.artio.decoder.AbstractRejectDecoder;
import uk.co.real_logic.artio.decoder.RejectDecoder;
import uk.co.real_logic.artio.decoder.AbstractTestRequestDecoder;
import uk.co.real_logic.artio.decoder.TestRequestDecoder;
import uk.co.real_logic.artio.decoder.AbstractSequenceResetDecoder;
import uk.co.real_logic.artio.decoder.SequenceResetDecoder;
import uk.co.real_logic.artio.decoder.AbstractHeartbeatDecoder;
import uk.co.real_logic.artio.decoder.HeartbeatDecoder;
import uk.co.real_logic.artio.decoder.AbstractResendRequestDecoder;
import uk.co.real_logic.artio.decoder.ResendRequestDecoder;
import uk.co.real_logic.artio.decoder.AbstractUserRequestDecoder;
import uk.co.real_logic.artio.decoder.UserRequestDecoder;
import uk.co.real_logic.artio.decoder.SessionHeaderDecoder;
import uk.co.real_logic.artio.decoder.HeaderDecoder;
import uk.co.real_logic.artio.dictionary.Generated;

@Generated("uk.co.real_logic.artio")
public class FixDictionaryImpl implements FixDictionary
{
    public String beginString()
    {
        return "FIX.4.4";
    }

    public SessionHeaderDecoder makeHeaderDecoder()
    {
        return new HeaderDecoder();
    }

    public SessionHeaderEncoder makeHeaderEncoder()
    {
        return new HeaderEncoder();
    }

    public AbstractLogonEncoder makeLogonEncoder()
    {
        return new LogonEncoder();
    }

    public AbstractResendRequestEncoder makeResendRequestEncoder()
    {
        return new ResendRequestEncoder();
    }

    public AbstractLogoutEncoder makeLogoutEncoder()
    {
        return new LogoutEncoder();
    }

    public AbstractHeartbeatEncoder makeHeartbeatEncoder()
    {
        return new HeartbeatEncoder();
    }

    public AbstractRejectEncoder makeRejectEncoder()
    {
        return new RejectEncoder();
    }

    public AbstractTestRequestEncoder makeTestRequestEncoder()
    {
        return new TestRequestEncoder();
    }

    public AbstractSequenceResetEncoder makeSequenceResetEncoder()
    {
        return new SequenceResetEncoder();
    }

    public AbstractBusinessMessageRejectEncoder makeBusinessMessageRejectEncoder()
    {
        return new BusinessMessageRejectEncoder();
    }

    public AbstractLogonDecoder makeLogonDecoder()
    {
        return new LogonDecoder();
    }

    public AbstractLogoutDecoder makeLogoutDecoder()
    {
        return new LogoutDecoder();
    }

    public AbstractRejectDecoder makeRejectDecoder()
    {
        return new RejectDecoder();
    }

    public AbstractTestRequestDecoder makeTestRequestDecoder()
    {
        return new TestRequestDecoder();
    }

    public AbstractSequenceResetDecoder makeSequenceResetDecoder()
    {
        return new SequenceResetDecoder();
    }

    public AbstractHeartbeatDecoder makeHeartbeatDecoder()
    {
        return new HeartbeatDecoder();
    }

    public AbstractResendRequestDecoder makeResendRequestDecoder()
    {
        return new ResendRequestDecoder();
    }

    public AbstractUserRequestDecoder makeUserRequestDecoder()
    {
        return new UserRequestDecoder();
    }

}
