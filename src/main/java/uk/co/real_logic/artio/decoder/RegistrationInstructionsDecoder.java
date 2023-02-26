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
import uk.co.real_logic.artio.builder.RegistrationInstructionsEncoder;
import uk.co.real_logic.artio.builder.PartiesEncoder;
import static uk.co.real_logic.artio.builder.PartiesEncoder.PartyIDsGroupEncoder;
import static uk.co.real_logic.artio.builder.PartiesEncoder.PartyIDsGroupEncoder.PartySubIDsGroupEncoder;
import static uk.co.real_logic.artio.builder.RegistrationInstructionsEncoder.RegistDtlsGroupEncoder;
import uk.co.real_logic.artio.builder.NestedPartiesEncoder;
import static uk.co.real_logic.artio.builder.NestedPartiesEncoder.NestedPartyIDsGroupEncoder;
import static uk.co.real_logic.artio.builder.NestedPartiesEncoder.NestedPartyIDsGroupEncoder.NestedPartySubIDsGroupEncoder;
import static uk.co.real_logic.artio.builder.RegistrationInstructionsEncoder.DistribInstsGroupEncoder;

@Generated("uk.co.real_logic.artio")
public class RegistrationInstructionsDecoder extends CommonDecoderImpl implements PartiesDecoder, MessageDecoder
{
    public final IntHashSet REQUIRED_FIELDS = new IntHashSet(6);

    {
        if (CODEC_VALIDATION_ENABLED)
        {
            REQUIRED_FIELDS.add(Constants.REGIST_ID);
            REQUIRED_FIELDS.add(Constants.REGIST_TRANS_TYPE);
            REQUIRED_FIELDS.add(Constants.REGIST_REF_ID);
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
            GROUP_FIELDS.add(Constants.REGIST_ACCT_TYPE);
            GROUP_FIELDS.add(Constants.TAX_ADVANTAGE_TYPE);
            GROUP_FIELDS.add(Constants.OWNERSHIP_TYPE);
        }
    }

    private final IntHashSet alreadyVisitedFields = new IntHashSet(18);

    private final IntHashSet unknownFields = new IntHashSet(10);

    private final IntHashSet missingRequiredFields = new IntHashSet(6);

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

        if (hasTaxAdvantageType)
        {
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !TaxAdvantageType.isValid(taxAdvantageType()))
        {
            invalidTagId = 495;
            rejectReason = 5;
            return false;
        }
        }

        if (hasOwnershipType)
        {
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !OwnershipType.isValid(ownershipType()))
        {
            invalidTagId = 517;
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

        if (hasNoRegistDtlsGroupCounter)
        {
            {
                int count = 0;
                final RegistDtlsGroupIterator iterator = registDtlsGroupIterator.iterator();
                for (final RegistDtlsGroupDecoder group : iterator)
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
                    invalidTagId = 473;
                    rejectReason = 16;
                    return false;
                }
            }
        }

        if (hasNoDistribInstsGroupCounter)
        {
            {
                int count = 0;
                final DistribInstsGroupIterator iterator = distribInstsGroupIterator.iterator();
                for (final DistribInstsGroupDecoder group : iterator)
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
                    invalidTagId = 510;
                    rejectReason = 16;
                    return false;
                }
            }
        }
        return true;
    }

    public static final long MESSAGE_TYPE = 111L;

    public static final String MESSAGE_TYPE_AS_STRING = "o";

    public static final char[] MESSAGE_TYPE_CHARS = MESSAGE_TYPE_AS_STRING.toCharArray();

    public static final byte[] MESSAGE_TYPE_BYTES = MESSAGE_TYPE_AS_STRING.getBytes(US_ASCII);

    public final IntHashSet messageFields = new IntHashSet(138);

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
        messageFields.add(Constants.REGIST_ACCT_TYPE);
        messageFields.add(Constants.TAX_ADVANTAGE_TYPE);
        messageFields.add(Constants.OWNERSHIP_TYPE);
        messageFields.add(Constants.NO_REGIST_DTLS_GROUP_COUNTER);
        messageFields.add(Constants.REGIST_DTLS);
        messageFields.add(Constants.REGIST_EMAIL);
        messageFields.add(Constants.MAILING_DTLS);
        messageFields.add(Constants.MAILING_INST);
        messageFields.add(Constants.NO_NESTED_PARTY_IDS_GROUP_COUNTER);
        messageFields.add(Constants.NESTED_PARTY_ID);
        messageFields.add(Constants.NESTED_PARTY_ID_SOURCE);
        messageFields.add(Constants.NESTED_PARTY_ROLE);
        messageFields.add(Constants.NO_NESTED_PARTY_SUB_IDS_GROUP_COUNTER);
        messageFields.add(Constants.NESTED_PARTY_SUB_ID);
        messageFields.add(Constants.NESTED_PARTY_SUB_ID_TYPE);
        messageFields.add(Constants.OWNER_TYPE);
        messageFields.add(Constants.DATE_OF_BIRTH);
        messageFields.add(Constants.INVESTOR_COUNTRY_OF_RESIDENCE);
        messageFields.add(Constants.NO_DISTRIB_INSTS_GROUP_COUNTER);
        messageFields.add(Constants.DISTRIB_PAYMENT_METHOD);
        messageFields.add(Constants.DISTRIB_PERCENTAGE);
        messageFields.add(Constants.CASH_DISTRIB_CURR);
        messageFields.add(Constants.CASH_DISTRIB_AGENT_NAME);
        messageFields.add(Constants.CASH_DISTRIB_AGENT_CODE);
        messageFields.add(Constants.CASH_DISTRIB_AGENT_ACCT_NUMBER);
        messageFields.add(Constants.CASH_DISTRIB_PAY_REF);
        messageFields.add(Constants.CASH_DISTRIB_AGENT_ACCT_NAME);
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

    private char[] registAcctType = new char[1];

    private boolean hasRegistAcctType;

    /* RegistAcctType = 493 */
    public char[] registAcctType()
    {
        if (!hasRegistAcctType)
        {
            throw new IllegalArgumentException("No value for optional field: RegistAcctType");
        }

        return registAcctType;
    }

    public boolean hasRegistAcctType()
    {
        return hasRegistAcctType;
    }


    private int registAcctTypeOffset;

    private int registAcctTypeLength;

    /* RegistAcctType = 493 */
    public int registAcctTypeLength()
    {
        if (!hasRegistAcctType)
        {
            throw new IllegalArgumentException("No value for optional field: RegistAcctType");
        }

        return registAcctTypeLength;
    }

    /* RegistAcctType = 493 */
    public String registAcctTypeAsString()
    {
        return hasRegistAcctType ? new String(registAcctType, 0, registAcctTypeLength) : null;
    }

    /* RegistAcctType = 493 */
    public AsciiSequenceView registAcctType(final AsciiSequenceView view)
    {
        if (!hasRegistAcctType)
        {
            throw new IllegalArgumentException("No value for optional field: RegistAcctType");
        }

        return view.wrap(buffer, registAcctTypeOffset, registAcctTypeLength);
    }


    private final CharArrayWrapper registAcctTypeWrapper = new CharArrayWrapper();
    private int taxAdvantageType = MISSING_INT;

    private boolean hasTaxAdvantageType;

    /* TaxAdvantageType = 495 */
    public int taxAdvantageType()
    {
        if (!hasTaxAdvantageType)
        {
            throw new IllegalArgumentException("No value for optional field: TaxAdvantageType");
        }

        return taxAdvantageType;
    }

    public boolean hasTaxAdvantageType()
    {
        return hasTaxAdvantageType;
    }



    private final CharArrayWrapper taxAdvantageTypeWrapper = new CharArrayWrapper();
    /* TaxAdvantageType = 495 */
    public TaxAdvantageType taxAdvantageTypeAsEnum()
    {
        if (!hasTaxAdvantageType)
 return TaxAdvantageType.NULL_VAL;
        return TaxAdvantageType.decode(taxAdvantageType);
    }

    private char ownershipType = MISSING_CHAR;

    private boolean hasOwnershipType;

    /* OwnershipType = 517 */
    public char ownershipType()
    {
        if (!hasOwnershipType)
        {
            throw new IllegalArgumentException("No value for optional field: OwnershipType");
        }

        return ownershipType;
    }

    public boolean hasOwnershipType()
    {
        return hasOwnershipType;
    }



    private final CharArrayWrapper ownershipTypeWrapper = new CharArrayWrapper();
    /* OwnershipType = 517 */
    public OwnershipType ownershipTypeAsEnum()
    {
        if (!hasOwnershipType)
 return OwnershipType.NULL_VAL;
        return OwnershipType.decode(ownershipType);
    }


@Generated("uk.co.real_logic.artio")
public class RegistDtlsGroupDecoder extends CommonDecoderImpl implements NestedPartiesDecoder
{
    public final IntHashSet REQUIRED_FIELDS = new IntHashSet(0);

    {
        if (CODEC_VALIDATION_ENABLED)
        {
        }
    }

    public final IntHashSet GROUP_FIELDS = new IntHashSet(14);

    {
        if (CODEC_VALIDATION_ENABLED)
        {
            GROUP_FIELDS.add(Constants.REGIST_DTLS);
            GROUP_FIELDS.add(Constants.REGIST_EMAIL);
            GROUP_FIELDS.add(Constants.MAILING_DTLS);
            GROUP_FIELDS.add(Constants.MAILING_INST);
            GROUP_FIELDS.add(Constants.OWNER_TYPE);
            GROUP_FIELDS.add(Constants.DATE_OF_BIRTH);
            GROUP_FIELDS.add(Constants.INVESTOR_COUNTRY_OF_RESIDENCE);
        }
    }

    public final IntHashSet ALL_GROUP_FIELDS = new IntHashSet(14);

    {
        if (CODEC_VALIDATION_ENABLED)
        {
            ALL_GROUP_FIELDS.add(Constants.REGIST_DTLS);
            ALL_GROUP_FIELDS.add(Constants.REGIST_EMAIL);
            ALL_GROUP_FIELDS.add(Constants.MAILING_DTLS);
            ALL_GROUP_FIELDS.add(Constants.MAILING_INST);
            ALL_GROUP_FIELDS.add(Constants.OWNER_TYPE);
            ALL_GROUP_FIELDS.add(Constants.DATE_OF_BIRTH);
            ALL_GROUP_FIELDS.add(Constants.INVESTOR_COUNTRY_OF_RESIDENCE);
        }
    }

    private final IntHashSet missingRequiredFields = new IntHashSet(0);

    public boolean validate()
    {
        if (rejectReason != Decoder.NO_ERROR)
        {
            return false;
        }
        final IntIterator missingFieldsIterator = missingRequiredFields.iterator();
        if (missingFieldsIterator.hasNext())
        {
            invalidTagId = missingFieldsIterator.nextValue();
            rejectReason = 1;
            return false;
        }
        if (hasOwnerType)
        {
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !OwnerType.isValid(ownerType()))
        {
            invalidTagId = 522;
            rejectReason = 5;
            return false;
        }
        }
        if (hasNoNestedPartyIDsGroupCounter)
        {
            {
                int count = 0;
                final NestedPartyIDsGroupIterator iterator = nestedPartyIDsGroupIterator.iterator();
                for (final NestedPartyIDsGroupDecoder group : iterator)
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
                    invalidTagId = 539;
                    rejectReason = 16;
                    return false;
                }
            }
        }
        return true;
    }

    private final TrailerDecoder trailer;
    private final IntHashSet messageFields;
    public RegistDtlsGroupDecoder(final TrailerDecoder trailer, final IntHashSet messageFields)
    {
        this.trailer = trailer;
        this.messageFields = messageFields;
    }

    private RegistDtlsGroupDecoder next = null;

    public RegistDtlsGroupDecoder next()
    {
        return next;
    }

    private IntHashSet seenFields = new IntHashSet(16);

    private char[] registDtls = new char[1];

    private boolean hasRegistDtls;

    /* RegistDtls = 509 */
    public char[] registDtls()
    {
        if (!hasRegistDtls)
        {
            throw new IllegalArgumentException("No value for optional field: RegistDtls");
        }

        return registDtls;
    }

    public boolean hasRegistDtls()
    {
        return hasRegistDtls;
    }


    private int registDtlsOffset;

    private int registDtlsLength;

    /* RegistDtls = 509 */
    public int registDtlsLength()
    {
        if (!hasRegistDtls)
        {
            throw new IllegalArgumentException("No value for optional field: RegistDtls");
        }

        return registDtlsLength;
    }

    /* RegistDtls = 509 */
    public String registDtlsAsString()
    {
        return hasRegistDtls ? new String(registDtls, 0, registDtlsLength) : null;
    }

    /* RegistDtls = 509 */
    public AsciiSequenceView registDtls(final AsciiSequenceView view)
    {
        if (!hasRegistDtls)
        {
            throw new IllegalArgumentException("No value for optional field: RegistDtls");
        }

        return view.wrap(buffer, registDtlsOffset, registDtlsLength);
    }


    private final CharArrayWrapper registDtlsWrapper = new CharArrayWrapper();
    private char[] registEmail = new char[1];

    private boolean hasRegistEmail;

    /* RegistEmail = 511 */
    public char[] registEmail()
    {
        if (!hasRegistEmail)
        {
            throw new IllegalArgumentException("No value for optional field: RegistEmail");
        }

        return registEmail;
    }

    public boolean hasRegistEmail()
    {
        return hasRegistEmail;
    }


    private int registEmailOffset;

    private int registEmailLength;

    /* RegistEmail = 511 */
    public int registEmailLength()
    {
        if (!hasRegistEmail)
        {
            throw new IllegalArgumentException("No value for optional field: RegistEmail");
        }

        return registEmailLength;
    }

    /* RegistEmail = 511 */
    public String registEmailAsString()
    {
        return hasRegistEmail ? new String(registEmail, 0, registEmailLength) : null;
    }

    /* RegistEmail = 511 */
    public AsciiSequenceView registEmail(final AsciiSequenceView view)
    {
        if (!hasRegistEmail)
        {
            throw new IllegalArgumentException("No value for optional field: RegistEmail");
        }

        return view.wrap(buffer, registEmailOffset, registEmailLength);
    }


    private final CharArrayWrapper registEmailWrapper = new CharArrayWrapper();
    private char[] mailingDtls = new char[1];

    private boolean hasMailingDtls;

    /* MailingDtls = 474 */
    public char[] mailingDtls()
    {
        if (!hasMailingDtls)
        {
            throw new IllegalArgumentException("No value for optional field: MailingDtls");
        }

        return mailingDtls;
    }

    public boolean hasMailingDtls()
    {
        return hasMailingDtls;
    }


    private int mailingDtlsOffset;

    private int mailingDtlsLength;

    /* MailingDtls = 474 */
    public int mailingDtlsLength()
    {
        if (!hasMailingDtls)
        {
            throw new IllegalArgumentException("No value for optional field: MailingDtls");
        }

        return mailingDtlsLength;
    }

    /* MailingDtls = 474 */
    public String mailingDtlsAsString()
    {
        return hasMailingDtls ? new String(mailingDtls, 0, mailingDtlsLength) : null;
    }

    /* MailingDtls = 474 */
    public AsciiSequenceView mailingDtls(final AsciiSequenceView view)
    {
        if (!hasMailingDtls)
        {
            throw new IllegalArgumentException("No value for optional field: MailingDtls");
        }

        return view.wrap(buffer, mailingDtlsOffset, mailingDtlsLength);
    }


    private final CharArrayWrapper mailingDtlsWrapper = new CharArrayWrapper();
    private char[] mailingInst = new char[1];

    private boolean hasMailingInst;

    /* MailingInst = 482 */
    public char[] mailingInst()
    {
        if (!hasMailingInst)
        {
            throw new IllegalArgumentException("No value for optional field: MailingInst");
        }

        return mailingInst;
    }

    public boolean hasMailingInst()
    {
        return hasMailingInst;
    }


    private int mailingInstOffset;

    private int mailingInstLength;

    /* MailingInst = 482 */
    public int mailingInstLength()
    {
        if (!hasMailingInst)
        {
            throw new IllegalArgumentException("No value for optional field: MailingInst");
        }

        return mailingInstLength;
    }

    /* MailingInst = 482 */
    public String mailingInstAsString()
    {
        return hasMailingInst ? new String(mailingInst, 0, mailingInstLength) : null;
    }

    /* MailingInst = 482 */
    public AsciiSequenceView mailingInst(final AsciiSequenceView view)
    {
        if (!hasMailingInst)
        {
            throw new IllegalArgumentException("No value for optional field: MailingInst");
        }

        return view.wrap(buffer, mailingInstOffset, mailingInstLength);
    }


    private final CharArrayWrapper mailingInstWrapper = new CharArrayWrapper();


    private NestedPartyIDsGroupDecoder nestedPartyIDsGroup = null;
    public NestedPartyIDsGroupDecoder nestedPartyIDsGroup()
    {
        return nestedPartyIDsGroup;
    }

    private int noNestedPartyIDsGroupCounter = MISSING_INT;

    private boolean hasNoNestedPartyIDsGroupCounter;

    /* NoNestedPartyIDsGroupCounter = 539 */
    public int noNestedPartyIDsGroupCounter()
    {
        if (!hasNoNestedPartyIDsGroupCounter)
        {
            throw new IllegalArgumentException("No value for optional field: NoNestedPartyIDsGroupCounter");
        }

        return noNestedPartyIDsGroupCounter;
    }

    public boolean hasNoNestedPartyIDsGroupCounter()
    {
        return hasNoNestedPartyIDsGroupCounter;
    }




    private NestedPartyIDsGroupIterator nestedPartyIDsGroupIterator = new NestedPartyIDsGroupIterator(this);
    public NestedPartyIDsGroupIterator nestedPartyIDsGroupIterator()
    {
        return nestedPartyIDsGroupIterator.iterator();
    }


    private int ownerType = MISSING_INT;

    private boolean hasOwnerType;

    /* OwnerType = 522 */
    public int ownerType()
    {
        if (!hasOwnerType)
        {
            throw new IllegalArgumentException("No value for optional field: OwnerType");
        }

        return ownerType;
    }

    public boolean hasOwnerType()
    {
        return hasOwnerType;
    }



    private final CharArrayWrapper ownerTypeWrapper = new CharArrayWrapper();
    /* OwnerType = 522 */
    public OwnerType ownerTypeAsEnum()
    {
        if (!hasOwnerType)
 return OwnerType.NULL_VAL;
        return OwnerType.decode(ownerType);
    }

    private byte[] dateOfBirth = new byte[8];

    private boolean hasDateOfBirth;

    /* DateOfBirth = 486 */
    public byte[] dateOfBirth()
    {
        if (!hasDateOfBirth)
        {
            throw new IllegalArgumentException("No value for optional field: DateOfBirth");
        }

        return dateOfBirth;
    }

    public boolean hasDateOfBirth()
    {
        return hasDateOfBirth;
    }


    private int dateOfBirthOffset;

    private int dateOfBirthLength;

    /* DateOfBirth = 486 */
    public int dateOfBirthLength()
    {
        if (!hasDateOfBirth)
        {
            throw new IllegalArgumentException("No value for optional field: DateOfBirth");
        }

        return dateOfBirthLength;
    }

    /* DateOfBirth = 486 */
    public String dateOfBirthAsString()
    {
        return hasDateOfBirth ? new String(dateOfBirth, 0, dateOfBirthLength) : null;
    }

    /* DateOfBirth = 486 */
    public AsciiSequenceView dateOfBirth(final AsciiSequenceView view)
    {
        if (!hasDateOfBirth)
        {
            throw new IllegalArgumentException("No value for optional field: DateOfBirth");
        }

        return view.wrap(buffer, dateOfBirthOffset, dateOfBirthLength);
    }


    private char[] investorCountryOfResidence = new char[1];

    private boolean hasInvestorCountryOfResidence;

    /* InvestorCountryOfResidence = 475 */
    public char[] investorCountryOfResidence()
    {
        if (!hasInvestorCountryOfResidence)
        {
            throw new IllegalArgumentException("No value for optional field: InvestorCountryOfResidence");
        }

        return investorCountryOfResidence;
    }

    public boolean hasInvestorCountryOfResidence()
    {
        return hasInvestorCountryOfResidence;
    }


    private int investorCountryOfResidenceOffset;

    private int investorCountryOfResidenceLength;

    /* InvestorCountryOfResidence = 475 */
    public int investorCountryOfResidenceLength()
    {
        if (!hasInvestorCountryOfResidence)
        {
            throw new IllegalArgumentException("No value for optional field: InvestorCountryOfResidence");
        }

        return investorCountryOfResidenceLength;
    }

    /* InvestorCountryOfResidence = 475 */
    public String investorCountryOfResidenceAsString()
    {
        return hasInvestorCountryOfResidence ? new String(investorCountryOfResidence, 0, investorCountryOfResidenceLength) : null;
    }

    /* InvestorCountryOfResidence = 475 */
    public AsciiSequenceView investorCountryOfResidence(final AsciiSequenceView view)
    {
        if (!hasInvestorCountryOfResidence)
        {
            throw new IllegalArgumentException("No value for optional field: InvestorCountryOfResidence");
        }

        return view.wrap(buffer, investorCountryOfResidenceOffset, investorCountryOfResidenceLength);
    }


    public int decode(final AsciiBuffer buffer, final int offset, final int length)
    {
        // Decode RegistDtlsGroup
        int seenFieldCount = 0;
        if (CODEC_VALIDATION_ENABLED)
        {
            missingRequiredFields.copy(REQUIRED_FIELDS);
        }
        this.buffer = buffer;
        final int end = offset + length;
        int position = offset;
        seenFields.clear();
        int tag;

        while (position < end)
        {
            final int equalsPosition = buffer.scan(position, end, '=');
            if (equalsPosition == AsciiBuffer.UNKNOWN_INDEX)
            {
               return position;
            }
            tag = buffer.getInt(position, equalsPosition);
            if (!seenFields.add(tag))
            {
                if (next == null)
                {
                    next = new RegistDtlsGroupDecoder(trailer, messageFields);
                }
                return position - offset;
            }
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
                missingRequiredFields.remove(tag);
                seenFieldCount++;
            }

            switch (tag)
            {
            case Constants.REGIST_DTLS:
                hasRegistDtls = true;
                registDtls = buffer.getChars(registDtls, valueOffset, valueLength);
                registDtlsOffset = valueOffset;
                registDtlsLength = valueLength;
                break;

            case Constants.REGIST_EMAIL:
                hasRegistEmail = true;
                registEmail = buffer.getChars(registEmail, valueOffset, valueLength);
                registEmailOffset = valueOffset;
                registEmailLength = valueLength;
                break;

            case Constants.MAILING_DTLS:
                hasMailingDtls = true;
                mailingDtls = buffer.getChars(mailingDtls, valueOffset, valueLength);
                mailingDtlsOffset = valueOffset;
                mailingDtlsLength = valueLength;
                break;

            case Constants.MAILING_INST:
                hasMailingInst = true;
                mailingInst = buffer.getChars(mailingInst, valueOffset, valueLength);
                mailingInstOffset = valueOffset;
                mailingInstLength = valueLength;
                break;

            case Constants.NO_NESTED_PARTY_IDS_GROUP_COUNTER:
                hasNoNestedPartyIDsGroupCounter = true;
                noNestedPartyIDsGroupCounter = getInt(buffer, valueOffset, endOfField, 539, CODEC_VALIDATION_ENABLED);
                if (nestedPartyIDsGroup == null)
                {
                    nestedPartyIDsGroup = new NestedPartyIDsGroupDecoder(trailer, messageFields);
                }
                NestedPartyIDsGroupDecoder nestedPartyIDsGroupCurrent = nestedPartyIDsGroup;
                position = endOfField + 1;
                final int noNestedPartyIDsGroupCounter = this.noNestedPartyIDsGroupCounter;
                for (int i = 0; i < noNestedPartyIDsGroupCounter && position < end; i++)
                {
                    if (nestedPartyIDsGroupCurrent != null)
                    {
                        position += nestedPartyIDsGroupCurrent.decode(buffer, position, end - position);
                        nestedPartyIDsGroupCurrent = nestedPartyIDsGroupCurrent.next();
                    }
                }
                if (CODEC_VALIDATION_ENABLED)
                {
                    final int checkEqualsPosition = buffer.scan(position, end, '=');
                    if (checkEqualsPosition != AsciiBuffer.UNKNOWN_INDEX)
                    {
                        final int checkTag = buffer.getInt(position, checkEqualsPosition);
                        if (nestedPartyIDsGroup.ALL_GROUP_FIELDS.contains(checkTag))
                        {
                            invalidTagId = tag;
                            rejectReason = 16;
                            return position;
                        }
                    }
                }
                break;


            case Constants.OWNER_TYPE:
                hasOwnerType = true;
                ownerType = getInt(buffer, valueOffset, endOfField, 522, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.DATE_OF_BIRTH:
                hasDateOfBirth = true;
                dateOfBirth = buffer.getBytes(dateOfBirth, valueOffset, valueLength);
                dateOfBirthOffset = valueOffset;
                dateOfBirthLength = valueLength;
                break;

            case Constants.INVESTOR_COUNTRY_OF_RESIDENCE:
                hasInvestorCountryOfResidence = true;
                investorCountryOfResidence = buffer.getChars(investorCountryOfResidence, valueOffset, valueLength);
                investorCountryOfResidenceOffset = valueOffset;
                investorCountryOfResidenceLength = valueLength;
                break;

            default:
                if (!CODEC_REJECT_UNKNOWN_FIELD_ENABLED)
                {
                    seenFields.remove(tag);
                }
                if (CODEC_REJECT_UNKNOWN_FIELD_ENABLED || (trailer.REQUIRED_FIELDS.contains(tag) || messageFields.contains(tag)))
                {
                    return position - offset;
                }

            }

            if (position < (endOfField + 1))
            {
                position = endOfField + 1;
            }
        }
        return position - offset;
    }

    public void reset()
    {
        this.resetRegistDtls();
        this.resetRegistEmail();
        this.resetMailingDtls();
        this.resetMailingInst();
        this.resetOwnerType();
        this.resetDateOfBirth();
        this.resetInvestorCountryOfResidence();
        this.resetNestedPartyIDsGroup();
        buffer = null;
        if (CODEC_VALIDATION_ENABLED)
        {
            invalidTagId = Decoder.NO_ERROR;
            rejectReason = Decoder.NO_ERROR;
            missingRequiredFields.clear();
        }
    }

    public void resetRegistDtls()
    {
        hasRegistDtls = false;
    }

    public void resetRegistEmail()
    {
        hasRegistEmail = false;
    }

    public void resetMailingDtls()
    {
        hasMailingDtls = false;
    }

    public void resetMailingInst()
    {
        hasMailingInst = false;
    }

    public void resetOwnerType()
    {
        hasOwnerType = false;
    }

    public void resetDateOfBirth()
    {
        hasDateOfBirth = false;
    }

    public void resetInvestorCountryOfResidence()
    {
        hasInvestorCountryOfResidence = false;
    }

    public void resetNestedPartyIDsGroup()
    {
        for (final NestedPartyIDsGroupDecoder nestedPartyIDsGroupDecoder : nestedPartyIDsGroupIterator.iterator())
        {
            nestedPartyIDsGroupDecoder.reset();
            if (nestedPartyIDsGroupDecoder.next() == null)
            {
                break;
            }
        }
        noNestedPartyIDsGroupCounter = MISSING_INT;
        hasNoNestedPartyIDsGroupCounter = false;
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
        builder.append("\"MessageName\": \"RegistDtlsGroup\",\n");
        if (hasRegistDtls())
        {
            indent(builder, level);
            builder.append("\"RegistDtls\": \"");
            builder.append(this.registDtls(), 0, registDtlsLength());
            builder.append("\",\n");
        }

        if (hasRegistEmail())
        {
            indent(builder, level);
            builder.append("\"RegistEmail\": \"");
            builder.append(this.registEmail(), 0, registEmailLength());
            builder.append("\",\n");
        }

        if (hasMailingDtls())
        {
            indent(builder, level);
            builder.append("\"MailingDtls\": \"");
            builder.append(this.mailingDtls(), 0, mailingDtlsLength());
            builder.append("\",\n");
        }

        if (hasMailingInst())
        {
            indent(builder, level);
            builder.append("\"MailingInst\": \"");
            builder.append(this.mailingInst(), 0, mailingInstLength());
            builder.append("\",\n");
        }

        if (hasNoNestedPartyIDsGroupCounter)
        {
            indent(builder, level);
            builder.append("\"NestedPartyIDsGroup\": [\n");
            NestedPartyIDsGroupDecoder nestedPartyIDsGroup = this.nestedPartyIDsGroup;
            for (int i = 0, size = this.noNestedPartyIDsGroupCounter; i < size; i++)
            {
                indent(builder, level);
                nestedPartyIDsGroup.appendTo(builder, level + 1);
                if (nestedPartyIDsGroup.next() != null)
                {
                    builder.append(',');
                }
                builder.append('\n');
                nestedPartyIDsGroup = nestedPartyIDsGroup.next();            }
            indent(builder, level);
            builder.append("],\n");
        }

        if (hasOwnerType())
        {
            indent(builder, level);
            builder.append("\"OwnerType\": \"");
            builder.append(ownerType);
            builder.append("\",\n");
        }

        if (hasDateOfBirth())
        {
            indent(builder, level);
            builder.append("\"DateOfBirth\": \"");
            appendData(builder, dateOfBirth, dateOfBirthLength);
            builder.append("\",\n");
        }

        if (hasInvestorCountryOfResidence())
        {
            indent(builder, level);
            builder.append("\"InvestorCountryOfResidence\": \"");
            builder.append(this.investorCountryOfResidence(), 0, investorCountryOfResidenceLength());
            builder.append("\",\n");
        }
        indent(builder, level - 1);
        builder.append("}");
        return builder;
    }

    /**
     * {@inheritDoc}
     */
    public RegistrationInstructionsEncoder.RegistDtlsGroupEncoder toEncoder(final Encoder encoder)
    {
        return toEncoder((RegistrationInstructionsEncoder.RegistDtlsGroupEncoder)encoder);
    }

    public RegistrationInstructionsEncoder.RegistDtlsGroupEncoder toEncoder(final RegistrationInstructionsEncoder.RegistDtlsGroupEncoder encoder)
    {
        encoder.reset();
        if (hasRegistDtls())
        {
            encoder.registDtls(this.registDtls(), 0, registDtlsLength());
        }

        if (hasRegistEmail())
        {
            encoder.registEmail(this.registEmail(), 0, registEmailLength());
        }

        if (hasMailingDtls())
        {
            encoder.mailingDtls(this.mailingDtls(), 0, mailingDtlsLength());
        }

        if (hasMailingInst())
        {
            encoder.mailingInst(this.mailingInst(), 0, mailingInstLength());
        }


        final NestedPartiesEncoder nestedParties = encoder.nestedParties();        if (hasNoNestedPartyIDsGroupCounter)
        {
            final int size = this.noNestedPartyIDsGroupCounter;
            NestedPartyIDsGroupDecoder nestedPartyIDsGroup = this.nestedPartyIDsGroup;
            NestedPartyIDsGroupEncoder nestedPartyIDsGroupEncoder = nestedParties.nestedPartyIDsGroup(size);
            for (int i = 0; i < size; i++)
            {
                if (nestedPartyIDsGroup != null)
                {
                    nestedPartyIDsGroup.toEncoder(nestedPartyIDsGroupEncoder);
                    nestedPartyIDsGroup = nestedPartyIDsGroup.next();
                    nestedPartyIDsGroupEncoder = nestedPartyIDsGroupEncoder.next();
                }
            }
        }


        if (hasOwnerType())
        {
            encoder.ownerType(this.ownerType());
        }

        if (hasDateOfBirth())
        {
            encoder.dateOfBirthAsCopy(this.dateOfBirth(), 0, dateOfBirthLength());
        }

        if (hasInvestorCountryOfResidence())
        {
            encoder.investorCountryOfResidence(this.investorCountryOfResidence(), 0, investorCountryOfResidenceLength());
        }
        return encoder;
    }

}
    @Generated("uk.co.real_logic.artio")
    public class RegistDtlsGroupIterator implements Iterable<RegistDtlsGroupDecoder>, java.util.Iterator<RegistDtlsGroupDecoder>
    {
        private final RegistrationInstructionsDecoder parent;
        private int remainder;
        private RegistDtlsGroupDecoder current;

        public RegistDtlsGroupIterator(final RegistrationInstructionsDecoder parent)
        {
            this.parent = parent;
        }

        public boolean hasNext()
        {
            return remainder > 0 && current != null;
        }

        public RegistDtlsGroupDecoder next()
        {
            remainder--;
            final RegistDtlsGroupDecoder value = current;
            current = current.next();
            return value;
        }

        public int numberFieldValue()
        {
            return parent.hasNoRegistDtlsGroupCounter() ? parent.noRegistDtlsGroupCounter() : 0;
        }

        public void reset()
        {
            remainder = numberFieldValue();
            current = parent.registDtlsGroup();
        }

        public RegistDtlsGroupIterator iterator()
        {
            reset();
            return this;
        }

    }


    private RegistDtlsGroupDecoder registDtlsGroup = null;
    public RegistDtlsGroupDecoder registDtlsGroup()
    {
        return registDtlsGroup;
    }

    private int noRegistDtlsGroupCounter = MISSING_INT;

    private boolean hasNoRegistDtlsGroupCounter;

    /* NoRegistDtlsGroupCounter = 473 */
    public int noRegistDtlsGroupCounter()
    {
        if (!hasNoRegistDtlsGroupCounter)
        {
            throw new IllegalArgumentException("No value for optional field: NoRegistDtlsGroupCounter");
        }

        return noRegistDtlsGroupCounter;
    }

    public boolean hasNoRegistDtlsGroupCounter()
    {
        return hasNoRegistDtlsGroupCounter;
    }




    private RegistDtlsGroupIterator registDtlsGroupIterator = new RegistDtlsGroupIterator(this);
    public RegistDtlsGroupIterator registDtlsGroupIterator()
    {
        return registDtlsGroupIterator.iterator();
    }


@Generated("uk.co.real_logic.artio")
public class DistribInstsGroupDecoder extends CommonDecoderImpl
{
    public final IntHashSet REQUIRED_FIELDS = new IntHashSet(0);

    {
        if (CODEC_VALIDATION_ENABLED)
        {
        }
    }

    public final IntHashSet ALL_GROUP_FIELDS = new IntHashSet(16);

    {
        if (CODEC_VALIDATION_ENABLED)
        {
            ALL_GROUP_FIELDS.add(Constants.DISTRIB_PAYMENT_METHOD);
            ALL_GROUP_FIELDS.add(Constants.DISTRIB_PERCENTAGE);
            ALL_GROUP_FIELDS.add(Constants.CASH_DISTRIB_CURR);
            ALL_GROUP_FIELDS.add(Constants.CASH_DISTRIB_AGENT_NAME);
            ALL_GROUP_FIELDS.add(Constants.CASH_DISTRIB_AGENT_CODE);
            ALL_GROUP_FIELDS.add(Constants.CASH_DISTRIB_AGENT_ACCT_NUMBER);
            ALL_GROUP_FIELDS.add(Constants.CASH_DISTRIB_PAY_REF);
            ALL_GROUP_FIELDS.add(Constants.CASH_DISTRIB_AGENT_ACCT_NAME);
        }
    }

    private final IntHashSet missingRequiredFields = new IntHashSet(0);

    public boolean validate()
    {
        if (rejectReason != Decoder.NO_ERROR)
        {
            return false;
        }
        final IntIterator missingFieldsIterator = missingRequiredFields.iterator();
        if (missingFieldsIterator.hasNext())
        {
            invalidTagId = missingFieldsIterator.nextValue();
            rejectReason = 1;
            return false;
        }
        if (hasDistribPaymentMethod)
        {
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !DistribPaymentMethod.isValid(distribPaymentMethod()))
        {
            invalidTagId = 477;
            rejectReason = 5;
            return false;
        }
        }
        return true;
    }

    private final TrailerDecoder trailer;
    private final IntHashSet messageFields;
    public DistribInstsGroupDecoder(final TrailerDecoder trailer, final IntHashSet messageFields)
    {
        this.trailer = trailer;
        this.messageFields = messageFields;
    }

    private DistribInstsGroupDecoder next = null;

    public DistribInstsGroupDecoder next()
    {
        return next;
    }

    private IntHashSet seenFields = new IntHashSet(16);

    private int distribPaymentMethod = MISSING_INT;

    private boolean hasDistribPaymentMethod;

    /* DistribPaymentMethod = 477 */
    public int distribPaymentMethod()
    {
        if (!hasDistribPaymentMethod)
        {
            throw new IllegalArgumentException("No value for optional field: DistribPaymentMethod");
        }

        return distribPaymentMethod;
    }

    public boolean hasDistribPaymentMethod()
    {
        return hasDistribPaymentMethod;
    }



    private final CharArrayWrapper distribPaymentMethodWrapper = new CharArrayWrapper();
    /* DistribPaymentMethod = 477 */
    public DistribPaymentMethod distribPaymentMethodAsEnum()
    {
        if (!hasDistribPaymentMethod)
 return DistribPaymentMethod.NULL_VAL;
        return DistribPaymentMethod.decode(distribPaymentMethod);
    }

    private DecimalFloat distribPercentage = DecimalFloat.newNaNValue();

    private boolean hasDistribPercentage;

    /* DistribPercentage = 512 */
    public DecimalFloat distribPercentage()
    {
        if (!hasDistribPercentage)
        {
            throw new IllegalArgumentException("No value for optional field: DistribPercentage");
        }

        return distribPercentage;
    }

    public boolean hasDistribPercentage()
    {
        return hasDistribPercentage;
    }



    private char[] cashDistribCurr = new char[1];

    private boolean hasCashDistribCurr;

    /* CashDistribCurr = 478 */
    public char[] cashDistribCurr()
    {
        if (!hasCashDistribCurr)
        {
            throw new IllegalArgumentException("No value for optional field: CashDistribCurr");
        }

        return cashDistribCurr;
    }

    public boolean hasCashDistribCurr()
    {
        return hasCashDistribCurr;
    }


    private int cashDistribCurrOffset;

    private int cashDistribCurrLength;

    /* CashDistribCurr = 478 */
    public int cashDistribCurrLength()
    {
        if (!hasCashDistribCurr)
        {
            throw new IllegalArgumentException("No value for optional field: CashDistribCurr");
        }

        return cashDistribCurrLength;
    }

    /* CashDistribCurr = 478 */
    public String cashDistribCurrAsString()
    {
        return hasCashDistribCurr ? new String(cashDistribCurr, 0, cashDistribCurrLength) : null;
    }

    /* CashDistribCurr = 478 */
    public AsciiSequenceView cashDistribCurr(final AsciiSequenceView view)
    {
        if (!hasCashDistribCurr)
        {
            throw new IllegalArgumentException("No value for optional field: CashDistribCurr");
        }

        return view.wrap(buffer, cashDistribCurrOffset, cashDistribCurrLength);
    }


    private char[] cashDistribAgentName = new char[1];

    private boolean hasCashDistribAgentName;

    /* CashDistribAgentName = 498 */
    public char[] cashDistribAgentName()
    {
        if (!hasCashDistribAgentName)
        {
            throw new IllegalArgumentException("No value for optional field: CashDistribAgentName");
        }

        return cashDistribAgentName;
    }

    public boolean hasCashDistribAgentName()
    {
        return hasCashDistribAgentName;
    }


    private int cashDistribAgentNameOffset;

    private int cashDistribAgentNameLength;

    /* CashDistribAgentName = 498 */
    public int cashDistribAgentNameLength()
    {
        if (!hasCashDistribAgentName)
        {
            throw new IllegalArgumentException("No value for optional field: CashDistribAgentName");
        }

        return cashDistribAgentNameLength;
    }

    /* CashDistribAgentName = 498 */
    public String cashDistribAgentNameAsString()
    {
        return hasCashDistribAgentName ? new String(cashDistribAgentName, 0, cashDistribAgentNameLength) : null;
    }

    /* CashDistribAgentName = 498 */
    public AsciiSequenceView cashDistribAgentName(final AsciiSequenceView view)
    {
        if (!hasCashDistribAgentName)
        {
            throw new IllegalArgumentException("No value for optional field: CashDistribAgentName");
        }

        return view.wrap(buffer, cashDistribAgentNameOffset, cashDistribAgentNameLength);
    }


    private final CharArrayWrapper cashDistribAgentNameWrapper = new CharArrayWrapper();
    private char[] cashDistribAgentCode = new char[1];

    private boolean hasCashDistribAgentCode;

    /* CashDistribAgentCode = 499 */
    public char[] cashDistribAgentCode()
    {
        if (!hasCashDistribAgentCode)
        {
            throw new IllegalArgumentException("No value for optional field: CashDistribAgentCode");
        }

        return cashDistribAgentCode;
    }

    public boolean hasCashDistribAgentCode()
    {
        return hasCashDistribAgentCode;
    }


    private int cashDistribAgentCodeOffset;

    private int cashDistribAgentCodeLength;

    /* CashDistribAgentCode = 499 */
    public int cashDistribAgentCodeLength()
    {
        if (!hasCashDistribAgentCode)
        {
            throw new IllegalArgumentException("No value for optional field: CashDistribAgentCode");
        }

        return cashDistribAgentCodeLength;
    }

    /* CashDistribAgentCode = 499 */
    public String cashDistribAgentCodeAsString()
    {
        return hasCashDistribAgentCode ? new String(cashDistribAgentCode, 0, cashDistribAgentCodeLength) : null;
    }

    /* CashDistribAgentCode = 499 */
    public AsciiSequenceView cashDistribAgentCode(final AsciiSequenceView view)
    {
        if (!hasCashDistribAgentCode)
        {
            throw new IllegalArgumentException("No value for optional field: CashDistribAgentCode");
        }

        return view.wrap(buffer, cashDistribAgentCodeOffset, cashDistribAgentCodeLength);
    }


    private final CharArrayWrapper cashDistribAgentCodeWrapper = new CharArrayWrapper();
    private char[] cashDistribAgentAcctNumber = new char[1];

    private boolean hasCashDistribAgentAcctNumber;

    /* CashDistribAgentAcctNumber = 500 */
    public char[] cashDistribAgentAcctNumber()
    {
        if (!hasCashDistribAgentAcctNumber)
        {
            throw new IllegalArgumentException("No value for optional field: CashDistribAgentAcctNumber");
        }

        return cashDistribAgentAcctNumber;
    }

    public boolean hasCashDistribAgentAcctNumber()
    {
        return hasCashDistribAgentAcctNumber;
    }


    private int cashDistribAgentAcctNumberOffset;

    private int cashDistribAgentAcctNumberLength;

    /* CashDistribAgentAcctNumber = 500 */
    public int cashDistribAgentAcctNumberLength()
    {
        if (!hasCashDistribAgentAcctNumber)
        {
            throw new IllegalArgumentException("No value for optional field: CashDistribAgentAcctNumber");
        }

        return cashDistribAgentAcctNumberLength;
    }

    /* CashDistribAgentAcctNumber = 500 */
    public String cashDistribAgentAcctNumberAsString()
    {
        return hasCashDistribAgentAcctNumber ? new String(cashDistribAgentAcctNumber, 0, cashDistribAgentAcctNumberLength) : null;
    }

    /* CashDistribAgentAcctNumber = 500 */
    public AsciiSequenceView cashDistribAgentAcctNumber(final AsciiSequenceView view)
    {
        if (!hasCashDistribAgentAcctNumber)
        {
            throw new IllegalArgumentException("No value for optional field: CashDistribAgentAcctNumber");
        }

        return view.wrap(buffer, cashDistribAgentAcctNumberOffset, cashDistribAgentAcctNumberLength);
    }


    private final CharArrayWrapper cashDistribAgentAcctNumberWrapper = new CharArrayWrapper();
    private char[] cashDistribPayRef = new char[1];

    private boolean hasCashDistribPayRef;

    /* CashDistribPayRef = 501 */
    public char[] cashDistribPayRef()
    {
        if (!hasCashDistribPayRef)
        {
            throw new IllegalArgumentException("No value for optional field: CashDistribPayRef");
        }

        return cashDistribPayRef;
    }

    public boolean hasCashDistribPayRef()
    {
        return hasCashDistribPayRef;
    }


    private int cashDistribPayRefOffset;

    private int cashDistribPayRefLength;

    /* CashDistribPayRef = 501 */
    public int cashDistribPayRefLength()
    {
        if (!hasCashDistribPayRef)
        {
            throw new IllegalArgumentException("No value for optional field: CashDistribPayRef");
        }

        return cashDistribPayRefLength;
    }

    /* CashDistribPayRef = 501 */
    public String cashDistribPayRefAsString()
    {
        return hasCashDistribPayRef ? new String(cashDistribPayRef, 0, cashDistribPayRefLength) : null;
    }

    /* CashDistribPayRef = 501 */
    public AsciiSequenceView cashDistribPayRef(final AsciiSequenceView view)
    {
        if (!hasCashDistribPayRef)
        {
            throw new IllegalArgumentException("No value for optional field: CashDistribPayRef");
        }

        return view.wrap(buffer, cashDistribPayRefOffset, cashDistribPayRefLength);
    }


    private final CharArrayWrapper cashDistribPayRefWrapper = new CharArrayWrapper();
    private char[] cashDistribAgentAcctName = new char[1];

    private boolean hasCashDistribAgentAcctName;

    /* CashDistribAgentAcctName = 502 */
    public char[] cashDistribAgentAcctName()
    {
        if (!hasCashDistribAgentAcctName)
        {
            throw new IllegalArgumentException("No value for optional field: CashDistribAgentAcctName");
        }

        return cashDistribAgentAcctName;
    }

    public boolean hasCashDistribAgentAcctName()
    {
        return hasCashDistribAgentAcctName;
    }


    private int cashDistribAgentAcctNameOffset;

    private int cashDistribAgentAcctNameLength;

    /* CashDistribAgentAcctName = 502 */
    public int cashDistribAgentAcctNameLength()
    {
        if (!hasCashDistribAgentAcctName)
        {
            throw new IllegalArgumentException("No value for optional field: CashDistribAgentAcctName");
        }

        return cashDistribAgentAcctNameLength;
    }

    /* CashDistribAgentAcctName = 502 */
    public String cashDistribAgentAcctNameAsString()
    {
        return hasCashDistribAgentAcctName ? new String(cashDistribAgentAcctName, 0, cashDistribAgentAcctNameLength) : null;
    }

    /* CashDistribAgentAcctName = 502 */
    public AsciiSequenceView cashDistribAgentAcctName(final AsciiSequenceView view)
    {
        if (!hasCashDistribAgentAcctName)
        {
            throw new IllegalArgumentException("No value for optional field: CashDistribAgentAcctName");
        }

        return view.wrap(buffer, cashDistribAgentAcctNameOffset, cashDistribAgentAcctNameLength);
    }


    private final CharArrayWrapper cashDistribAgentAcctNameWrapper = new CharArrayWrapper();
    public int decode(final AsciiBuffer buffer, final int offset, final int length)
    {
        // Decode DistribInstsGroup
        int seenFieldCount = 0;
        if (CODEC_VALIDATION_ENABLED)
        {
            missingRequiredFields.copy(REQUIRED_FIELDS);
        }
        this.buffer = buffer;
        final int end = offset + length;
        int position = offset;
        seenFields.clear();
        int tag;

        while (position < end)
        {
            final int equalsPosition = buffer.scan(position, end, '=');
            if (equalsPosition == AsciiBuffer.UNKNOWN_INDEX)
            {
               return position;
            }
            tag = buffer.getInt(position, equalsPosition);
            if (!seenFields.add(tag))
            {
                if (next == null)
                {
                    next = new DistribInstsGroupDecoder(trailer, messageFields);
                }
                return position - offset;
            }
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
                missingRequiredFields.remove(tag);
                seenFieldCount++;
            }

            switch (tag)
            {
            case Constants.DISTRIB_PAYMENT_METHOD:
                hasDistribPaymentMethod = true;
                distribPaymentMethod = getInt(buffer, valueOffset, endOfField, 477, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.DISTRIB_PERCENTAGE:
                hasDistribPercentage = true;
                distribPercentage = getFloat(buffer, distribPercentage, valueOffset, valueLength, 512, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.CASH_DISTRIB_CURR:
                hasCashDistribCurr = true;
                cashDistribCurr = buffer.getChars(cashDistribCurr, valueOffset, valueLength);
                cashDistribCurrOffset = valueOffset;
                cashDistribCurrLength = valueLength;
                break;

            case Constants.CASH_DISTRIB_AGENT_NAME:
                hasCashDistribAgentName = true;
                cashDistribAgentName = buffer.getChars(cashDistribAgentName, valueOffset, valueLength);
                cashDistribAgentNameOffset = valueOffset;
                cashDistribAgentNameLength = valueLength;
                break;

            case Constants.CASH_DISTRIB_AGENT_CODE:
                hasCashDistribAgentCode = true;
                cashDistribAgentCode = buffer.getChars(cashDistribAgentCode, valueOffset, valueLength);
                cashDistribAgentCodeOffset = valueOffset;
                cashDistribAgentCodeLength = valueLength;
                break;

            case Constants.CASH_DISTRIB_AGENT_ACCT_NUMBER:
                hasCashDistribAgentAcctNumber = true;
                cashDistribAgentAcctNumber = buffer.getChars(cashDistribAgentAcctNumber, valueOffset, valueLength);
                cashDistribAgentAcctNumberOffset = valueOffset;
                cashDistribAgentAcctNumberLength = valueLength;
                break;

            case Constants.CASH_DISTRIB_PAY_REF:
                hasCashDistribPayRef = true;
                cashDistribPayRef = buffer.getChars(cashDistribPayRef, valueOffset, valueLength);
                cashDistribPayRefOffset = valueOffset;
                cashDistribPayRefLength = valueLength;
                break;

            case Constants.CASH_DISTRIB_AGENT_ACCT_NAME:
                hasCashDistribAgentAcctName = true;
                cashDistribAgentAcctName = buffer.getChars(cashDistribAgentAcctName, valueOffset, valueLength);
                cashDistribAgentAcctNameOffset = valueOffset;
                cashDistribAgentAcctNameLength = valueLength;
                break;

            default:
                if (!CODEC_REJECT_UNKNOWN_FIELD_ENABLED)
                {
                    seenFields.remove(tag);
                }
                if (CODEC_REJECT_UNKNOWN_FIELD_ENABLED || (trailer.REQUIRED_FIELDS.contains(tag) || messageFields.contains(tag)))
                {
                    return position - offset;
                }

            }

            if (position < (endOfField + 1))
            {
                position = endOfField + 1;
            }
        }
        return position - offset;
    }

    public void reset()
    {
        this.resetDistribPaymentMethod();
        this.resetDistribPercentage();
        this.resetCashDistribCurr();
        this.resetCashDistribAgentName();
        this.resetCashDistribAgentCode();
        this.resetCashDistribAgentAcctNumber();
        this.resetCashDistribPayRef();
        this.resetCashDistribAgentAcctName();
        buffer = null;
        if (CODEC_VALIDATION_ENABLED)
        {
            invalidTagId = Decoder.NO_ERROR;
            rejectReason = Decoder.NO_ERROR;
            missingRequiredFields.clear();
        }
    }

    public void resetDistribPaymentMethod()
    {
        hasDistribPaymentMethod = false;
    }

    public void resetDistribPercentage()
    {
        hasDistribPercentage = false;
    }

    public void resetCashDistribCurr()
    {
        hasCashDistribCurr = false;
    }

    public void resetCashDistribAgentName()
    {
        hasCashDistribAgentName = false;
    }

    public void resetCashDistribAgentCode()
    {
        hasCashDistribAgentCode = false;
    }

    public void resetCashDistribAgentAcctNumber()
    {
        hasCashDistribAgentAcctNumber = false;
    }

    public void resetCashDistribPayRef()
    {
        hasCashDistribPayRef = false;
    }

    public void resetCashDistribAgentAcctName()
    {
        hasCashDistribAgentAcctName = false;
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
        builder.append("\"MessageName\": \"DistribInstsGroup\",\n");
        if (hasDistribPaymentMethod())
        {
            indent(builder, level);
            builder.append("\"DistribPaymentMethod\": \"");
            builder.append(distribPaymentMethod);
            builder.append("\",\n");
        }

        if (hasDistribPercentage())
        {
            indent(builder, level);
            builder.append("\"DistribPercentage\": \"");
            distribPercentage.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasCashDistribCurr())
        {
            indent(builder, level);
            builder.append("\"CashDistribCurr\": \"");
            builder.append(this.cashDistribCurr(), 0, cashDistribCurrLength());
            builder.append("\",\n");
        }

        if (hasCashDistribAgentName())
        {
            indent(builder, level);
            builder.append("\"CashDistribAgentName\": \"");
            builder.append(this.cashDistribAgentName(), 0, cashDistribAgentNameLength());
            builder.append("\",\n");
        }

        if (hasCashDistribAgentCode())
        {
            indent(builder, level);
            builder.append("\"CashDistribAgentCode\": \"");
            builder.append(this.cashDistribAgentCode(), 0, cashDistribAgentCodeLength());
            builder.append("\",\n");
        }

        if (hasCashDistribAgentAcctNumber())
        {
            indent(builder, level);
            builder.append("\"CashDistribAgentAcctNumber\": \"");
            builder.append(this.cashDistribAgentAcctNumber(), 0, cashDistribAgentAcctNumberLength());
            builder.append("\",\n");
        }

        if (hasCashDistribPayRef())
        {
            indent(builder, level);
            builder.append("\"CashDistribPayRef\": \"");
            builder.append(this.cashDistribPayRef(), 0, cashDistribPayRefLength());
            builder.append("\",\n");
        }

        if (hasCashDistribAgentAcctName())
        {
            indent(builder, level);
            builder.append("\"CashDistribAgentAcctName\": \"");
            builder.append(this.cashDistribAgentAcctName(), 0, cashDistribAgentAcctNameLength());
            builder.append("\",\n");
        }
        indent(builder, level - 1);
        builder.append("}");
        return builder;
    }

    /**
     * {@inheritDoc}
     */
    public RegistrationInstructionsEncoder.DistribInstsGroupEncoder toEncoder(final Encoder encoder)
    {
        return toEncoder((RegistrationInstructionsEncoder.DistribInstsGroupEncoder)encoder);
    }

    public RegistrationInstructionsEncoder.DistribInstsGroupEncoder toEncoder(final RegistrationInstructionsEncoder.DistribInstsGroupEncoder encoder)
    {
        encoder.reset();
        if (hasDistribPaymentMethod())
        {
            encoder.distribPaymentMethod(this.distribPaymentMethod());
        }

        if (hasDistribPercentage())
        {
            encoder.distribPercentage(this.distribPercentage());
        }

        if (hasCashDistribCurr())
        {
            encoder.cashDistribCurr(this.cashDistribCurr(), 0, cashDistribCurrLength());
        }

        if (hasCashDistribAgentName())
        {
            encoder.cashDistribAgentName(this.cashDistribAgentName(), 0, cashDistribAgentNameLength());
        }

        if (hasCashDistribAgentCode())
        {
            encoder.cashDistribAgentCode(this.cashDistribAgentCode(), 0, cashDistribAgentCodeLength());
        }

        if (hasCashDistribAgentAcctNumber())
        {
            encoder.cashDistribAgentAcctNumber(this.cashDistribAgentAcctNumber(), 0, cashDistribAgentAcctNumberLength());
        }

        if (hasCashDistribPayRef())
        {
            encoder.cashDistribPayRef(this.cashDistribPayRef(), 0, cashDistribPayRefLength());
        }

        if (hasCashDistribAgentAcctName())
        {
            encoder.cashDistribAgentAcctName(this.cashDistribAgentAcctName(), 0, cashDistribAgentAcctNameLength());
        }
        return encoder;
    }

}
    @Generated("uk.co.real_logic.artio")
    public class DistribInstsGroupIterator implements Iterable<DistribInstsGroupDecoder>, java.util.Iterator<DistribInstsGroupDecoder>
    {
        private final RegistrationInstructionsDecoder parent;
        private int remainder;
        private DistribInstsGroupDecoder current;

        public DistribInstsGroupIterator(final RegistrationInstructionsDecoder parent)
        {
            this.parent = parent;
        }

        public boolean hasNext()
        {
            return remainder > 0 && current != null;
        }

        public DistribInstsGroupDecoder next()
        {
            remainder--;
            final DistribInstsGroupDecoder value = current;
            current = current.next();
            return value;
        }

        public int numberFieldValue()
        {
            return parent.hasNoDistribInstsGroupCounter() ? parent.noDistribInstsGroupCounter() : 0;
        }

        public void reset()
        {
            remainder = numberFieldValue();
            current = parent.distribInstsGroup();
        }

        public DistribInstsGroupIterator iterator()
        {
            reset();
            return this;
        }

    }


    private DistribInstsGroupDecoder distribInstsGroup = null;
    public DistribInstsGroupDecoder distribInstsGroup()
    {
        return distribInstsGroup;
    }

    private int noDistribInstsGroupCounter = MISSING_INT;

    private boolean hasNoDistribInstsGroupCounter;

    /* NoDistribInstsGroupCounter = 510 */
    public int noDistribInstsGroupCounter()
    {
        if (!hasNoDistribInstsGroupCounter)
        {
            throw new IllegalArgumentException("No value for optional field: NoDistribInstsGroupCounter");
        }

        return noDistribInstsGroupCounter;
    }

    public boolean hasNoDistribInstsGroupCounter()
    {
        return hasNoDistribInstsGroupCounter;
    }




    private DistribInstsGroupIterator distribInstsGroupIterator = new DistribInstsGroupIterator(this);
    public DistribInstsGroupIterator distribInstsGroupIterator()
    {
        return distribInstsGroupIterator.iterator();
    }

    public int decode(final AsciiBuffer buffer, final int offset, final int length)
    {
        // Decode RegistrationInstructions
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

            case Constants.REGIST_ACCT_TYPE:
                hasRegistAcctType = true;
                registAcctType = buffer.getChars(registAcctType, valueOffset, valueLength);
                registAcctTypeOffset = valueOffset;
                registAcctTypeLength = valueLength;
                break;

            case Constants.TAX_ADVANTAGE_TYPE:
                hasTaxAdvantageType = true;
                taxAdvantageType = getInt(buffer, valueOffset, endOfField, 495, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.OWNERSHIP_TYPE:
                hasOwnershipType = true;
                ownershipType = buffer.getChar(valueOffset);
                break;

            case Constants.NO_REGIST_DTLS_GROUP_COUNTER:
                hasNoRegistDtlsGroupCounter = true;
                noRegistDtlsGroupCounter = getInt(buffer, valueOffset, endOfField, 473, CODEC_VALIDATION_ENABLED);
                if (registDtlsGroup == null)
                {
                    registDtlsGroup = new RegistDtlsGroupDecoder(trailer, messageFields);
                }
                RegistDtlsGroupDecoder registDtlsGroupCurrent = registDtlsGroup;
                position = endOfField + 1;
                final int noRegistDtlsGroupCounter = this.noRegistDtlsGroupCounter;
                for (int i = 0; i < noRegistDtlsGroupCounter && position < end; i++)
                {
                    if (registDtlsGroupCurrent != null)
                    {
                        position += registDtlsGroupCurrent.decode(buffer, position, end - position);
                        registDtlsGroupCurrent = registDtlsGroupCurrent.next();
                    }
                }
                if (CODEC_VALIDATION_ENABLED)
                {
                    final int checkEqualsPosition = buffer.scan(position, end, '=');
                    if (checkEqualsPosition != AsciiBuffer.UNKNOWN_INDEX)
                    {
                        final int checkTag = buffer.getInt(position, checkEqualsPosition);
                        if (registDtlsGroup.ALL_GROUP_FIELDS.contains(checkTag))
                        {
                            invalidTagId = tag;
                            rejectReason = 16;
                            return position;
                        }
                    }
                }
                break;

            case Constants.NO_DISTRIB_INSTS_GROUP_COUNTER:
                hasNoDistribInstsGroupCounter = true;
                noDistribInstsGroupCounter = getInt(buffer, valueOffset, endOfField, 510, CODEC_VALIDATION_ENABLED);
                if (distribInstsGroup == null)
                {
                    distribInstsGroup = new DistribInstsGroupDecoder(trailer, messageFields);
                }
                DistribInstsGroupDecoder distribInstsGroupCurrent = distribInstsGroup;
                position = endOfField + 1;
                final int noDistribInstsGroupCounter = this.noDistribInstsGroupCounter;
                for (int i = 0; i < noDistribInstsGroupCounter && position < end; i++)
                {
                    if (distribInstsGroupCurrent != null)
                    {
                        position += distribInstsGroupCurrent.decode(buffer, position, end - position);
                        distribInstsGroupCurrent = distribInstsGroupCurrent.next();
                    }
                }
                if (CODEC_VALIDATION_ENABLED)
                {
                    final int checkEqualsPosition = buffer.scan(position, end, '=');
                    if (checkEqualsPosition != AsciiBuffer.UNKNOWN_INDEX)
                    {
                        final int checkTag = buffer.getInt(position, checkEqualsPosition);
                        if (distribInstsGroup.ALL_GROUP_FIELDS.contains(checkTag))
                        {
                            invalidTagId = tag;
                            rejectReason = 16;
                            return position;
                        }
                    }
                }
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
        this.resetRegistAcctType();
        this.resetTaxAdvantageType();
        this.resetOwnershipType();
        this.resetPartyIDsGroup();
        this.resetRegistDtlsGroup();
        this.resetDistribInstsGroup();
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

    public void resetRegistAcctType()
    {
        hasRegistAcctType = false;
    }

    public void resetTaxAdvantageType()
    {
        hasTaxAdvantageType = false;
    }

    public void resetOwnershipType()
    {
        hasOwnershipType = false;
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

    public void resetRegistDtlsGroup()
    {
        for (final RegistDtlsGroupDecoder registDtlsGroupDecoder : registDtlsGroupIterator.iterator())
        {
            registDtlsGroupDecoder.reset();
            if (registDtlsGroupDecoder.next() == null)
            {
                break;
            }
        }
        noRegistDtlsGroupCounter = MISSING_INT;
        hasNoRegistDtlsGroupCounter = false;
    }

    public void resetDistribInstsGroup()
    {
        for (final DistribInstsGroupDecoder distribInstsGroupDecoder : distribInstsGroupIterator.iterator())
        {
            distribInstsGroupDecoder.reset();
            if (distribInstsGroupDecoder.next() == null)
            {
                break;
            }
        }
        noDistribInstsGroupCounter = MISSING_INT;
        hasNoDistribInstsGroupCounter = false;
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
        builder.append("\"MessageName\": \"RegistrationInstructions\",\n");
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

        if (hasRegistAcctType())
        {
            indent(builder, level);
            builder.append("\"RegistAcctType\": \"");
            builder.append(this.registAcctType(), 0, registAcctTypeLength());
            builder.append("\",\n");
        }

        if (hasTaxAdvantageType())
        {
            indent(builder, level);
            builder.append("\"TaxAdvantageType\": \"");
            builder.append(taxAdvantageType);
            builder.append("\",\n");
        }

        if (hasOwnershipType())
        {
            indent(builder, level);
            builder.append("\"OwnershipType\": \"");
            builder.append(ownershipType);
            builder.append("\",\n");
        }

        if (hasNoRegistDtlsGroupCounter)
        {
            indent(builder, level);
            builder.append("\"RegistDtlsGroup\": [\n");
            RegistDtlsGroupDecoder registDtlsGroup = this.registDtlsGroup;
            for (int i = 0, size = this.noRegistDtlsGroupCounter; i < size; i++)
            {
                indent(builder, level);
                registDtlsGroup.appendTo(builder, level + 1);
                if (registDtlsGroup.next() != null)
                {
                    builder.append(',');
                }
                builder.append('\n');
                registDtlsGroup = registDtlsGroup.next();            }
            indent(builder, level);
            builder.append("],\n");
        }

        if (hasNoDistribInstsGroupCounter)
        {
            indent(builder, level);
            builder.append("\"DistribInstsGroup\": [\n");
            DistribInstsGroupDecoder distribInstsGroup = this.distribInstsGroup;
            for (int i = 0, size = this.noDistribInstsGroupCounter; i < size; i++)
            {
                indent(builder, level);
                distribInstsGroup.appendTo(builder, level + 1);
                if (distribInstsGroup.next() != null)
                {
                    builder.append(',');
                }
                builder.append('\n');
                distribInstsGroup = distribInstsGroup.next();            }
            indent(builder, level);
            builder.append("],\n");
        }
        indent(builder, level - 1);
        builder.append("}");
        return builder;
    }

    /**
     * {@inheritDoc}
     */
    public RegistrationInstructionsEncoder toEncoder(final Encoder encoder)
    {
        return toEncoder((RegistrationInstructionsEncoder)encoder);
    }

    public RegistrationInstructionsEncoder toEncoder(final RegistrationInstructionsEncoder encoder)
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

        if (hasRegistAcctType())
        {
            encoder.registAcctType(this.registAcctType(), 0, registAcctTypeLength());
        }

        if (hasTaxAdvantageType())
        {
            encoder.taxAdvantageType(this.taxAdvantageType());
        }

        if (hasOwnershipType())
        {
            encoder.ownershipType(this.ownershipType());
        }

        if (hasNoRegistDtlsGroupCounter)
        {
            final int size = this.noRegistDtlsGroupCounter;
            RegistDtlsGroupDecoder registDtlsGroup = this.registDtlsGroup;
            RegistDtlsGroupEncoder registDtlsGroupEncoder = encoder.registDtlsGroup(size);
            for (int i = 0; i < size; i++)
            {
                if (registDtlsGroup != null)
                {
                    registDtlsGroup.toEncoder(registDtlsGroupEncoder);
                    registDtlsGroup = registDtlsGroup.next();
                    registDtlsGroupEncoder = registDtlsGroupEncoder.next();
                }
            }
        }

        if (hasNoDistribInstsGroupCounter)
        {
            final int size = this.noDistribInstsGroupCounter;
            DistribInstsGroupDecoder distribInstsGroup = this.distribInstsGroup;
            DistribInstsGroupEncoder distribInstsGroupEncoder = encoder.distribInstsGroup(size);
            for (int i = 0; i < size; i++)
            {
                if (distribInstsGroup != null)
                {
                    distribInstsGroup.toEncoder(distribInstsGroupEncoder);
                    distribInstsGroup = distribInstsGroup.next();
                    distribInstsGroupEncoder = distribInstsGroupEncoder.next();
                }
            }
        }
        return encoder;
    }

}
