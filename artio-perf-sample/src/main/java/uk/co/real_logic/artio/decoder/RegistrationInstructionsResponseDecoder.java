/* Generated Fix Gateway message codec */
package uk.co.real_logic.artio.decoder;

import org.agrona.AsciiNumberFormatException;
import uk.co.real_logic.artio.dictionary.Generated;
import org.agrona.MutableDirectBuffer;
import org.agrona.AsciiSequenceView;
import static uk.co.real_logic.artio.dictionary.generation.CodecUtil.*;
import static uk.co.real_logic.artio.dictionary.SessionConstants.*;
import uk.co.real_logic.artio.builder.Decoder;
import uk.co.real_logic.artio.decoder.HeaderDecoder;
import uk.co.real_logic.artio.decoder.TrailerDecoder;
import uk.co.real_logic.artio.fields.ReadOnlyDecimalFloat;
import uk.co.real_logic.artio.fields.DecimalFloat;
import uk.co.real_logic.artio.util.MutableAsciiBuffer;
import uk.co.real_logic.artio.util.AsciiBuffer;
import uk.co.real_logic.artio.fields.LocalMktDateEncoder;
import uk.co.real_logic.artio.fields.UtcTimestampEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import uk.co.real_logic.artio.dictionary.CharArraySet;
import org.agrona.collections.IntHashSet;
import org.agrona.collections.IntHashSet.IntIterator;
import uk.co.real_logic.artio.EncodingException;
import uk.co.real_logic.artio.dictionary.CharArrayWrapper;
import uk.co.real_logic.artio.builder.Encoder;
import uk.co.real_logic.artio.builder.CommonDecoderImpl;
import static java.nio.charset.StandardCharsets.US_ASCII;
import static uk.co.real_logic.artio.builder.Validation.CODEC_VALIDATION_ENABLED;
import static uk.co.real_logic.artio.builder.RejectUnknownField.CODEC_REJECT_UNKNOWN_FIELD_ENABLED;
import static uk.co.real_logic.artio.builder.RejectUnknownEnumValue.CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED;
import uk.co.real_logic.artio.*;
import uk.co.real_logic.artio.builder.RegistrationInstructionsResponseEncoder;
import uk.co.real_logic.artio.builder.PartiesEncoder;
import static uk.co.real_logic.artio.builder.PartiesEncoder.PartyIDsGroupEncoder;
import static uk.co.real_logic.artio.builder.PartiesEncoder.PartyIDsGroupEncoder.PartySubIDsGroupEncoder;

@Generated("uk.co.real_logic.artio")
public class RegistrationInstructionsResponseDecoder extends CommonDecoderImpl implements PartiesDecoder, MessageDecoder
{
    public final IntHashSet REQUIRED_FIELDS = new IntHashSet(8);

    {
        if (CODEC_VALIDATION_ENABLED)
        {
            REQUIRED_FIELDS.add(Constants.REGIST_ID);
            REQUIRED_FIELDS.add(Constants.REGIST_TRANS_TYPE);
            REQUIRED_FIELDS.add(Constants.REGIST_REF_ID);
            REQUIRED_FIELDS.add(Constants.REGIST_STATUS);
        }
    }

    public final IntHashSet GROUP_FIELDS = new IntHashSet(18);

    {
        if (CODEC_VALIDATION_ENABLED)
        {
            GROUP_FIELDS.add(Constants.REGIST_ID);
            GROUP_FIELDS.add(Constants.REGIST_TRANS_TYPE);
            GROUP_FIELDS.add(Constants.REGIST_REF_ID);
            GROUP_FIELDS.add(Constants.CL_ORD_ID);
            GROUP_FIELDS.add(Constants.ACCOUNT);
            GROUP_FIELDS.add(Constants.ACCT_ID_SOURCE);
            GROUP_FIELDS.add(Constants.REGIST_STATUS);
            GROUP_FIELDS.add(Constants.REGIST_REJ_REASON_CODE);
            GROUP_FIELDS.add(Constants.REGIST_REJ_REASON_TEXT);
        }
    }

    private final IntHashSet alreadyVisitedFields = new IntHashSet(18);

    private final IntHashSet unknownFields = new IntHashSet(10);

    private final IntHashSet missingRequiredFields = new IntHashSet(8);

    public boolean validate()
    {
        if (rejectReason != Decoder.NO_ERROR)
        {
            return false;
        }
        final IntIterator missingFieldsIterator = missingRequiredFields.iterator();
        final IntIterator unknownFieldsIterator = unknownFields.iterator();
        if (CODEC_REJECT_UNKNOWN_FIELD_ENABLED && unknownFieldsIterator.hasNext())
        {
            invalidTagId = unknownFieldsIterator.nextValue();
            rejectReason = Constants.ALL_FIELDS.contains(invalidTagId) ? 2 : 0;
            return false;
        }
        if (!header.validate())
        {
            invalidTagId = header.invalidTagId();
            rejectReason = header.rejectReason();
            return false;
        }
        else if (!trailer.validate())
        {
            invalidTagId = trailer.invalidTagId();
            rejectReason = trailer.rejectReason();
            return false;
        }
        if (missingFieldsIterator.hasNext())
        {
            invalidTagId = missingFieldsIterator.nextValue();
            rejectReason = 1;
            return false;
        }
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !RegistTransType.isValid(registTransType()))
        {
            invalidTagId = 514;
            rejectReason = 5;
            return false;
        }

        if (hasAcctIDSource)
        {
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !AcctIDSource.isValid(acctIDSource()))
        {
            invalidTagId = 660;
            rejectReason = 5;
            return false;
        }
        }

        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !RegistStatus.isValid(registStatus()))
        {
            invalidTagId = 506;
            rejectReason = 5;
            return false;
        }

        if (hasRegistRejReasonCode)
        {
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !RegistRejReasonCode.isValid(registRejReasonCode()))
        {
            invalidTagId = 507;
            rejectReason = 5;
            return false;
        }
        }
        if (hasNoPartyIDsGroupCounter)
        {
            {
                int count = 0;
                final PartyIDsGroupIterator iterator = partyIDsGroupIterator.iterator();
                for (final PartyIDsGroupDecoder group : iterator)
                {
                    count++;                    if (!group.validate())
                    {
                        invalidTagId = group.invalidTagId();
                        rejectReason = group.rejectReason();
                        return false;
                    }
                }
                if (count != iterator.numberFieldValue())
                {
                    invalidTagId = 453;
                    rejectReason = 16;
                    return false;
                }
            }
        }
        return true;
    }

    public static final long MESSAGE_TYPE = 112L;

    public static final String MESSAGE_TYPE_AS_STRING = "p";

    public static final char[] MESSAGE_TYPE_CHARS = MESSAGE_TYPE_AS_STRING.toCharArray();

    public static final byte[] MESSAGE_TYPE_BYTES = MESSAGE_TYPE_AS_STRING.getBytes(US_ASCII);

    public final IntHashSet messageFields = new IntHashSet(90);

    {
        messageFields.add(Constants.BEGIN_STRING);
        messageFields.add(Constants.BODY_LENGTH);
        messageFields.add(Constants.MSG_TYPE);
        messageFields.add(Constants.SENDER_COMP_ID);
        messageFields.add(Constants.TARGET_COMP_ID);
        messageFields.add(Constants.ON_BEHALF_OF_COMP_ID);
        messageFields.add(Constants.DELIVER_TO_COMP_ID);
        messageFields.add(Constants.SECURE_DATA_LEN);
        messageFields.add(Constants.SECURE_DATA);
        messageFields.add(Constants.MSG_SEQ_NUM);
        messageFields.add(Constants.SENDER_SUB_ID);
        messageFields.add(Constants.SENDER_LOCATION_ID);
        messageFields.add(Constants.TARGET_SUB_ID);
        messageFields.add(Constants.TARGET_LOCATION_ID);
        messageFields.add(Constants.ON_BEHALF_OF_SUB_ID);
        messageFields.add(Constants.ON_BEHALF_OF_LOCATION_ID);
        messageFields.add(Constants.DELIVER_TO_SUB_ID);
        messageFields.add(Constants.DELIVER_TO_LOCATION_ID);
        messageFields.add(Constants.POSS_DUP_FLAG);
        messageFields.add(Constants.POSS_RESEND);
        messageFields.add(Constants.SENDING_TIME);
        messageFields.add(Constants.ORIG_SENDING_TIME);
        messageFields.add(Constants.XML_DATA_LEN);
        messageFields.add(Constants.XML_DATA);
        messageFields.add(Constants.MESSAGE_ENCODING);
        messageFields.add(Constants.LAST_MSG_SEQ_NUM_PROCESSED);
        messageFields.add(Constants.REGIST_ID);
        messageFields.add(Constants.REGIST_TRANS_TYPE);
        messageFields.add(Constants.REGIST_REF_ID);
        messageFields.add(Constants.CL_ORD_ID);
        messageFields.add(Constants.NO_PARTY_IDS_GROUP_COUNTER);
        messageFields.add(Constants.PARTY_ID);
        messageFields.add(Constants.PARTY_ID_SOURCE);
        messageFields.add(Constants.PARTY_ROLE);
        messageFields.add(Constants.NO_PARTY_SUB_IDS_GROUP_COUNTER);
        messageFields.add(Constants.PARTY_SUB_ID);
        messageFields.add(Constants.PARTY_SUB_ID_TYPE);
        messageFields.add(Constants.ACCOUNT);
        messageFields.add(Constants.ACCT_ID_SOURCE);
        messageFields.add(Constants.REGIST_STATUS);
        messageFields.add(Constants.REGIST_REJ_REASON_CODE);
        messageFields.add(Constants.REGIST_REJ_REASON_TEXT);
        messageFields.add(Constants.SIGNATURE_LENGTH);
        messageFields.add(Constants.SIGNATURE);
        messageFields.add(Constants.CHECK_SUM);
    }

    private final TrailerDecoder trailer = new TrailerDecoder();

    public TrailerDecoder trailer()
    {
        return trailer;
    }

    private final HeaderDecoder header = new HeaderDecoder(trailer);

    public HeaderDecoder header()
    {
        return header;
    }

    private char[] registID = new char[1];

    /* RegistID = 513 */
    public char[] registID()
    {
        return registID;
    }


    private int registIDOffset;

    private int registIDLength;

    /* RegistID = 513 */
    public int registIDLength()
    {
        return registIDLength;
    }

    /* RegistID = 513 */
    public String registIDAsString()
    {
        return new String(registID, 0, registIDLength);
    }

    /* RegistID = 513 */
    public AsciiSequenceView registID(final AsciiSequenceView view)
    {
        return view.wrap(buffer, registIDOffset, registIDLength);
    }


    private final CharArrayWrapper registIDWrapper = new CharArrayWrapper();
    private char registTransType = MISSING_CHAR;

    /* RegistTransType = 514 */
    public char registTransType()
    {
        return registTransType;
    }



    private final CharArrayWrapper registTransTypeWrapper = new CharArrayWrapper();
    /* RegistTransType = 514 */
    public RegistTransType registTransTypeAsEnum()
    {
        return RegistTransType.decode(registTransType);
    }

    private char[] registRefID = new char[1];

    /* RegistRefID = 508 */
    public char[] registRefID()
    {
        return registRefID;
    }


    private int registRefIDOffset;

    private int registRefIDLength;

    /* RegistRefID = 508 */
    public int registRefIDLength()
    {
        return registRefIDLength;
    }

    /* RegistRefID = 508 */
    public String registRefIDAsString()
    {
        return new String(registRefID, 0, registRefIDLength);
    }

    /* RegistRefID = 508 */
    public AsciiSequenceView registRefID(final AsciiSequenceView view)
    {
        return view.wrap(buffer, registRefIDOffset, registRefIDLength);
    }


    private final CharArrayWrapper registRefIDWrapper = new CharArrayWrapper();
    private char[] clOrdID = new char[1];

    private boolean hasClOrdID;

    /* ClOrdID = 11 */
    public char[] clOrdID()
    {
        if (!hasClOrdID)
        {
            throw new IllegalArgumentException("No value for optional field: ClOrdID");
        }

        return clOrdID;
    }

    public boolean hasClOrdID()
    {
        return hasClOrdID;
    }


    private int clOrdIDOffset;

    private int clOrdIDLength;

    /* ClOrdID = 11 */
    public int clOrdIDLength()
    {
        if (!hasClOrdID)
        {
            throw new IllegalArgumentException("No value for optional field: ClOrdID");
        }

        return clOrdIDLength;
    }

    /* ClOrdID = 11 */
    public String clOrdIDAsString()
    {
        return hasClOrdID ? new String(clOrdID, 0, clOrdIDLength) : null;
    }

    /* ClOrdID = 11 */
    public AsciiSequenceView clOrdID(final AsciiSequenceView view)
    {
        if (!hasClOrdID)
        {
            throw new IllegalArgumentException("No value for optional field: ClOrdID");
        }

        return view.wrap(buffer, clOrdIDOffset, clOrdIDLength);
    }


    private final CharArrayWrapper clOrdIDWrapper = new CharArrayWrapper();


    private PartyIDsGroupDecoder partyIDsGroup = null;
    public PartyIDsGroupDecoder partyIDsGroup()
    {
        return partyIDsGroup;
    }

    private int noPartyIDsGroupCounter = MISSING_INT;

    private boolean hasNoPartyIDsGroupCounter;

    /* NoPartyIDsGroupCounter = 453 */
    public int noPartyIDsGroupCounter()
    {
        if (!hasNoPartyIDsGroupCounter)
        {
            throw new IllegalArgumentException("No value for optional field: NoPartyIDsGroupCounter");
        }

        return noPartyIDsGroupCounter;
    }

    public boolean hasNoPartyIDsGroupCounter()
    {
        return hasNoPartyIDsGroupCounter;
    }




    private PartyIDsGroupIterator partyIDsGroupIterator = new PartyIDsGroupIterator(this);
    public PartyIDsGroupIterator partyIDsGroupIterator()
    {
        return partyIDsGroupIterator.iterator();
    }


    private char[] account = new char[1];

    private boolean hasAccount;

    /* Account = 1 */
    public char[] account()
    {
        if (!hasAccount)
        {
            throw new IllegalArgumentException("No value for optional field: Account");
        }

        return account;
    }

    public boolean hasAccount()
    {
        return hasAccount;
    }


    private int accountOffset;

    private int accountLength;

    /* Account = 1 */
    public int accountLength()
    {
        if (!hasAccount)
        {
            throw new IllegalArgumentException("No value for optional field: Account");
        }

        return accountLength;
    }

    /* Account = 1 */
    public String accountAsString()
    {
        return hasAccount ? new String(account, 0, accountLength) : null;
    }

    /* Account = 1 */
    public AsciiSequenceView account(final AsciiSequenceView view)
    {
        if (!hasAccount)
        {
            throw new IllegalArgumentException("No value for optional field: Account");
        }

        return view.wrap(buffer, accountOffset, accountLength);
    }


    private final CharArrayWrapper accountWrapper = new CharArrayWrapper();
    private int acctIDSource = MISSING_INT;

    private boolean hasAcctIDSource;

    /* AcctIDSource = 660 */
    public int acctIDSource()
    {
        if (!hasAcctIDSource)
        {
            throw new IllegalArgumentException("No value for optional field: AcctIDSource");
        }

        return acctIDSource;
    }

    public boolean hasAcctIDSource()
    {
        return hasAcctIDSource;
    }



    private final CharArrayWrapper acctIDSourceWrapper = new CharArrayWrapper();
    /* AcctIDSource = 660 */
    public AcctIDSource acctIDSourceAsEnum()
    {
        if (!hasAcctIDSource)
 return AcctIDSource.NULL_VAL;
        return AcctIDSource.decode(acctIDSource);
    }

    private char registStatus = MISSING_CHAR;

    /* RegistStatus = 506 */
    public char registStatus()
    {
        return registStatus;
    }



    private final CharArrayWrapper registStatusWrapper = new CharArrayWrapper();
    /* RegistStatus = 506 */
    public RegistStatus registStatusAsEnum()
    {
        return RegistStatus.decode(registStatus);
    }

    private int registRejReasonCode = MISSING_INT;

    private boolean hasRegistRejReasonCode;

    /* RegistRejReasonCode = 507 */
    public int registRejReasonCode()
    {
        if (!hasRegistRejReasonCode)
        {
            throw new IllegalArgumentException("No value for optional field: RegistRejReasonCode");
        }

        return registRejReasonCode;
    }

    public boolean hasRegistRejReasonCode()
    {
        return hasRegistRejReasonCode;
    }



    private final CharArrayWrapper registRejReasonCodeWrapper = new CharArrayWrapper();
    /* RegistRejReasonCode = 507 */
    public RegistRejReasonCode registRejReasonCodeAsEnum()
    {
        if (!hasRegistRejReasonCode)
 return RegistRejReasonCode.NULL_VAL;
        return RegistRejReasonCode.decode(registRejReasonCode);
    }

    private char[] registRejReasonText = new char[1];

    private boolean hasRegistRejReasonText;

    /* RegistRejReasonText = 496 */
    public char[] registRejReasonText()
    {
        if (!hasRegistRejReasonText)
        {
            throw new IllegalArgumentException("No value for optional field: RegistRejReasonText");
        }

        return registRejReasonText;
    }

    public boolean hasRegistRejReasonText()
    {
        return hasRegistRejReasonText;
    }


    private int registRejReasonTextOffset;

    private int registRejReasonTextLength;

    /* RegistRejReasonText = 496 */
    public int registRejReasonTextLength()
    {
        if (!hasRegistRejReasonText)
        {
            throw new IllegalArgumentException("No value for optional field: RegistRejReasonText");
        }

        return registRejReasonTextLength;
    }

    /* RegistRejReasonText = 496 */
    public String registRejReasonTextAsString()
    {
        return hasRegistRejReasonText ? new String(registRejReasonText, 0, registRejReasonTextLength) : null;
    }

    /* RegistRejReasonText = 496 */
    public AsciiSequenceView registRejReasonText(final AsciiSequenceView view)
    {
        if (!hasRegistRejReasonText)
        {
            throw new IllegalArgumentException("No value for optional field: RegistRejReasonText");
        }

        return view.wrap(buffer, registRejReasonTextOffset, registRejReasonTextLength);
    }


    private final CharArrayWrapper registRejReasonTextWrapper = new CharArrayWrapper();
    public int decode(final AsciiBuffer buffer, final int offset, final int length)
    {
        // Decode RegistrationInstructionsResponse
        int seenFieldCount = 0;
        if (CODEC_VALIDATION_ENABLED)
        {
            missingRequiredFields.copy(REQUIRED_FIELDS);
            alreadyVisitedFields.clear();
        }
        this.buffer = buffer;
        final int end = offset + length;
        int position = offset;
        position += header.decode(buffer, position, length);
        int tag;

        while (position < end)
        {
            final int equalsPosition = buffer.scan(position, end, '=');
            if (equalsPosition == AsciiBuffer.UNKNOWN_INDEX)
            {
               return position;
            }
            tag = buffer.getInt(position, equalsPosition);
            final int valueOffset = equalsPosition + 1;
            int endOfField = buffer.scan(valueOffset, end, START_OF_HEADER);
            if (endOfField == AsciiBuffer.UNKNOWN_INDEX || equalsPosition == AsciiBuffer.UNKNOWN_INDEX)
            {
                rejectReason = 5;
                break;
            }
            final int valueLength = endOfField - valueOffset;
            if (CODEC_VALIDATION_ENABLED)
            {
                if (tag <= 0)
                {
                    invalidTagId = tag;
                    rejectReason = 0;
                }
                else if (valueLength == 0)
                {
                    invalidTagId = tag;
                    rejectReason = 4;
                }
                if (!alreadyVisitedFields.add(tag))
                {
                    invalidTagId = tag;
                    rejectReason = 13;
                }
                missingRequiredFields.remove(tag);
                seenFieldCount++;
            }

            switch (tag)
            {
            case Constants.REGIST_ID:
                registID = buffer.getChars(registID, valueOffset, valueLength);
                registIDOffset = valueOffset;
                registIDLength = valueLength;
                break;

            case Constants.REGIST_TRANS_TYPE:
                registTransType = buffer.getChar(valueOffset);
                break;

            case Constants.REGIST_REF_ID:
                registRefID = buffer.getChars(registRefID, valueOffset, valueLength);
                registRefIDOffset = valueOffset;
                registRefIDLength = valueLength;
                break;

            case Constants.CL_ORD_ID:
                hasClOrdID = true;
                clOrdID = buffer.getChars(clOrdID, valueOffset, valueLength);
                clOrdIDOffset = valueOffset;
                clOrdIDLength = valueLength;
                break;

            case Constants.NO_PARTY_IDS_GROUP_COUNTER:
                hasNoPartyIDsGroupCounter = true;
                noPartyIDsGroupCounter = getInt(buffer, valueOffset, endOfField, 453, CODEC_VALIDATION_ENABLED);
                if (partyIDsGroup == null)
                {
                    partyIDsGroup = new PartyIDsGroupDecoder(trailer, messageFields);
                }
                PartyIDsGroupDecoder partyIDsGroupCurrent = partyIDsGroup;
                position = endOfField + 1;
                final int noPartyIDsGroupCounter = this.noPartyIDsGroupCounter;
                for (int i = 0; i < noPartyIDsGroupCounter && position < end; i++)
                {
                    if (partyIDsGroupCurrent != null)
                    {
                        position += partyIDsGroupCurrent.decode(buffer, position, end - position);
                        partyIDsGroupCurrent = partyIDsGroupCurrent.next();
                    }
                }
                if (CODEC_VALIDATION_ENABLED)
                {
                    final int checkEqualsPosition = buffer.scan(position, end, '=');
                    if (checkEqualsPosition != AsciiBuffer.UNKNOWN_INDEX)
                    {
                        final int checkTag = buffer.getInt(position, checkEqualsPosition);
                        if (partyIDsGroup.ALL_GROUP_FIELDS.contains(checkTag))
                        {
                            invalidTagId = tag;
                            rejectReason = 16;
                            return position;
                        }
                    }
                }
                break;


            case Constants.ACCOUNT:
                hasAccount = true;
                account = buffer.getChars(account, valueOffset, valueLength);
                accountOffset = valueOffset;
                accountLength = valueLength;
                break;

            case Constants.ACCT_ID_SOURCE:
                hasAcctIDSource = true;
                acctIDSource = getInt(buffer, valueOffset, endOfField, 660, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.REGIST_STATUS:
                registStatus = buffer.getChar(valueOffset);
                break;

            case Constants.REGIST_REJ_REASON_CODE:
                hasRegistRejReasonCode = true;
                registRejReasonCode = getInt(buffer, valueOffset, endOfField, 507, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.REGIST_REJ_REASON_TEXT:
                hasRegistRejReasonText = true;
                registRejReasonText = buffer.getChars(registRejReasonText, valueOffset, valueLength);
                registRejReasonTextOffset = valueOffset;
                registRejReasonTextLength = valueLength;
                break;

            default:
                if (!CODEC_REJECT_UNKNOWN_FIELD_ENABLED)
                {
                    alreadyVisitedFields.remove(tag);
                }
                else
                {
                    if (!(trailer.REQUIRED_FIELDS.contains(tag)))
                    {
                        unknownFields.add(tag);
                    }
                }
                if (CODEC_REJECT_UNKNOWN_FIELD_ENABLED || (trailer.REQUIRED_FIELDS.contains(tag)))
                {
                    position += trailer.decode(buffer, position, end - position);
                    return position - offset;
                }

            }

            if (position < (endOfField + 1))
            {
                position = endOfField + 1;
            }
        }
        position += trailer.decode(buffer, position, end - position);
        return position - offset;
    }

    public void reset()
    {
        header.reset();
        trailer.reset();
        resetMessage();
        buffer = null;
        if (CODEC_VALIDATION_ENABLED)
        {
            invalidTagId = Decoder.NO_ERROR;
            rejectReason = Decoder.NO_ERROR;
            missingRequiredFields.clear();
            unknownFields.clear();
            alreadyVisitedFields.clear();
        }
    }

    public void resetMessage()
    {
        this.resetRegistID();
        this.resetRegistTransType();
        this.resetRegistRefID();
        this.resetClOrdID();
        this.resetAccount();
        this.resetAcctIDSource();
        this.resetRegistStatus();
        this.resetRegistRejReasonCode();
        this.resetRegistRejReasonText();
        this.resetPartyIDsGroup();
    }

    public void resetRegistID()
    {
        registIDOffset = 0;
        registIDLength = 0;
    }

    public void resetRegistTransType()
    {
        registTransType = MISSING_CHAR;
    }

    public void resetRegistRefID()
    {
        registRefIDOffset = 0;
        registRefIDLength = 0;
    }

    public void resetClOrdID()
    {
        hasClOrdID = false;
    }

    public void resetAccount()
    {
        hasAccount = false;
    }

    public void resetAcctIDSource()
    {
        hasAcctIDSource = false;
    }

    public void resetRegistStatus()
    {
        registStatus = MISSING_CHAR;
    }

    public void resetRegistRejReasonCode()
    {
        hasRegistRejReasonCode = false;
    }

    public void resetRegistRejReasonText()
    {
        hasRegistRejReasonText = false;
    }

    public void resetPartyIDsGroup()
    {
        for (final PartyIDsGroupDecoder partyIDsGroupDecoder : partyIDsGroupIterator.iterator())
        {
            partyIDsGroupDecoder.reset();
            if (partyIDsGroupDecoder.next() == null)
            {
                break;
            }
        }
        noPartyIDsGroupCounter = MISSING_INT;
        hasNoPartyIDsGroupCounter = false;
    }

    public String toString()
    {
        return appendTo(new StringBuilder()).toString();
    }

    public StringBuilder appendTo(final StringBuilder builder)
    {
        return appendTo(builder, 1);
    }

    public StringBuilder appendTo(final StringBuilder builder, final int level)
    {
        builder.append("{\n");        indent(builder, level);
        builder.append("\"MessageName\": \"RegistrationInstructionsResponse\",\n");
        builder.append("  \"header\": ");
        header.appendTo(builder, level + 1);
        builder.append("\n");
        indent(builder, level);
        builder.append("\"RegistID\": \"");
        builder.append(this.registID(), 0, registIDLength());
        builder.append("\",\n");

        indent(builder, level);
        builder.append("\"RegistTransType\": \"");
        builder.append(registTransType);
        builder.append("\",\n");

        indent(builder, level);
        builder.append("\"RegistRefID\": \"");
        builder.append(this.registRefID(), 0, registRefIDLength());
        builder.append("\",\n");

        if (hasClOrdID())
        {
            indent(builder, level);
            builder.append("\"ClOrdID\": \"");
            builder.append(this.clOrdID(), 0, clOrdIDLength());
            builder.append("\",\n");
        }

        if (hasNoPartyIDsGroupCounter)
        {
            indent(builder, level);
            builder.append("\"PartyIDsGroup\": [\n");
            PartyIDsGroupDecoder partyIDsGroup = this.partyIDsGroup;
            for (int i = 0, size = this.noPartyIDsGroupCounter; i < size; i++)
            {
                indent(builder, level);
                partyIDsGroup.appendTo(builder, level + 1);
                if (partyIDsGroup.next() != null)
                {
                    builder.append(',');
                }
                builder.append('\n');
                partyIDsGroup = partyIDsGroup.next();            }
            indent(builder, level);
            builder.append("],\n");
        }

        if (hasAccount())
        {
            indent(builder, level);
            builder.append("\"Account\": \"");
            builder.append(this.account(), 0, accountLength());
            builder.append("\",\n");
        }

        if (hasAcctIDSource())
        {
            indent(builder, level);
            builder.append("\"AcctIDSource\": \"");
            builder.append(acctIDSource);
            builder.append("\",\n");
        }

        indent(builder, level);
        builder.append("\"RegistStatus\": \"");
        builder.append(registStatus);
        builder.append("\",\n");

        if (hasRegistRejReasonCode())
        {
            indent(builder, level);
            builder.append("\"RegistRejReasonCode\": \"");
            builder.append(registRejReasonCode);
            builder.append("\",\n");
        }

        if (hasRegistRejReasonText())
        {
            indent(builder, level);
            builder.append("\"RegistRejReasonText\": \"");
            builder.append(this.registRejReasonText(), 0, registRejReasonTextLength());
            builder.append("\",\n");
        }
        indent(builder, level - 1);
        builder.append("}");
        return builder;
    }

    /**
     * {@inheritDoc}
     */
    public RegistrationInstructionsResponseEncoder toEncoder(final Encoder encoder)
    {
        return toEncoder((RegistrationInstructionsResponseEncoder)encoder);
    }

    public RegistrationInstructionsResponseEncoder toEncoder(final RegistrationInstructionsResponseEncoder encoder)
    {
        encoder.reset();
        encoder.registID(this.registID(), 0, registIDLength());
        encoder.registTransType(this.registTransType());
        encoder.registRefID(this.registRefID(), 0, registRefIDLength());
        if (hasClOrdID())
        {
            encoder.clOrdID(this.clOrdID(), 0, clOrdIDLength());
        }


        final PartiesEncoder parties = encoder.parties();        if (hasNoPartyIDsGroupCounter)
        {
            final int size = this.noPartyIDsGroupCounter;
            PartyIDsGroupDecoder partyIDsGroup = this.partyIDsGroup;
            PartyIDsGroupEncoder partyIDsGroupEncoder = parties.partyIDsGroup(size);
            for (int i = 0; i < size; i++)
            {
                if (partyIDsGroup != null)
                {
                    partyIDsGroup.toEncoder(partyIDsGroupEncoder);
                    partyIDsGroup = partyIDsGroup.next();
                    partyIDsGroupEncoder = partyIDsGroupEncoder.next();
                }
            }
        }


        if (hasAccount())
        {
            encoder.account(this.account(), 0, accountLength());
        }

        if (hasAcctIDSource())
        {
            encoder.acctIDSource(this.acctIDSource());
        }

        encoder.registStatus(this.registStatus());
        if (hasRegistRejReasonCode())
        {
            encoder.registRejReasonCode(this.registRejReasonCode());
        }

        if (hasRegistRejReasonText())
        {
            encoder.registRejReasonText(this.registRejReasonText(), 0, registRejReasonTextLength());
        }
        return encoder;
    }

}
