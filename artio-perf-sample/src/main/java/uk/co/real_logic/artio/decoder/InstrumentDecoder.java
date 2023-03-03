/* Generated Fix Gateway message codec */
package uk.co.real_logic.artio.decoder;

import org.agrona.AsciiNumberFormatException;
import org.agrona.MutableDirectBuffer;
import org.agrona.AsciiSequenceView;
import static uk.co.real_logic.artio.dictionary.generation.CodecUtil.*;
import static uk.co.real_logic.artio.dictionary.SessionConstants.*;
import uk.co.real_logic.artio.builder.Decoder;
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
import uk.co.real_logic.artio.builder.InstrumentEncoder;
import static uk.co.real_logic.artio.builder.InstrumentEncoder.SecurityAltIDGroupEncoder;
import static uk.co.real_logic.artio.builder.InstrumentEncoder.EventsGroupEncoder;
import uk.co.real_logic.artio.dictionary.Generated;

@Generated("uk.co.real_logic.artio")
public interface InstrumentDecoder 
{

    /* Symbol = 55 */
    public char[] symbol();
    /* Symbol = 55 */
    public int symbolLength();
    /* Symbol = 55 */
    public AsciiSequenceView symbol(AsciiSequenceView view);
    /* SymbolSfx = 65 */
    public char[] symbolSfx();
    /* SymbolSfx = 65 */
    public boolean hasSymbolSfx();
    /* SymbolSfx = 65 */
    public int symbolSfxLength();
    /* SymbolSfx = 65 */
    public SymbolSfx symbolSfxAsEnum();
    /* SymbolSfx = 65 */
    public AsciiSequenceView symbolSfx(AsciiSequenceView view);
    /* SecurityID = 48 */
    public char[] securityID();
    /* SecurityID = 48 */
    public boolean hasSecurityID();
    /* SecurityID = 48 */
    public int securityIDLength();
    /* SecurityID = 48 */
    public AsciiSequenceView securityID(AsciiSequenceView view);
    /* SecurityIDSource = 22 */
    public char[] securityIDSource();
    /* SecurityIDSource = 22 */
    public boolean hasSecurityIDSource();
    /* SecurityIDSource = 22 */
    public int securityIDSourceLength();
    /* SecurityIDSource = 22 */
    public SecurityIDSource securityIDSourceAsEnum();
    /* SecurityIDSource = 22 */
    public AsciiSequenceView securityIDSource(AsciiSequenceView view);

@Generated("uk.co.real_logic.artio")
public class SecurityAltIDGroupDecoder extends CommonDecoderImpl
{
    public final IntHashSet REQUIRED_FIELDS = new IntHashSet(0);

    {
        if (CODEC_VALIDATION_ENABLED)
        {
        }
    }

    public final IntHashSet ALL_GROUP_FIELDS = new IntHashSet(4);

    {
        if (CODEC_VALIDATION_ENABLED)
        {
            ALL_GROUP_FIELDS.add(Constants.SECURITY_ALT_ID);
            ALL_GROUP_FIELDS.add(Constants.SECURITY_ALT_ID_SOURCE);
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
        return true;
    }

    private final TrailerDecoder trailer;
    private final IntHashSet messageFields;
    public SecurityAltIDGroupDecoder(final TrailerDecoder trailer, final IntHashSet messageFields)
    {
        this.trailer = trailer;
        this.messageFields = messageFields;
    }

    private SecurityAltIDGroupDecoder next = null;

    public SecurityAltIDGroupDecoder next()
    {
        return next;
    }

    private IntHashSet seenFields = new IntHashSet(4);

    private char[] securityAltID = new char[1];

    private boolean hasSecurityAltID;

    /* SecurityAltID = 455 */
    public char[] securityAltID()
    {
        if (!hasSecurityAltID)
        {
            throw new IllegalArgumentException("No value for optional field: SecurityAltID");
        }

        return securityAltID;
    }

    public boolean hasSecurityAltID()
    {
        return hasSecurityAltID;
    }


    private int securityAltIDOffset;

    private int securityAltIDLength;

    /* SecurityAltID = 455 */
    public int securityAltIDLength()
    {
        if (!hasSecurityAltID)
        {
            throw new IllegalArgumentException("No value for optional field: SecurityAltID");
        }

        return securityAltIDLength;
    }

    /* SecurityAltID = 455 */
    public String securityAltIDAsString()
    {
        return hasSecurityAltID ? new String(securityAltID, 0, securityAltIDLength) : null;
    }

    /* SecurityAltID = 455 */
    public AsciiSequenceView securityAltID(final AsciiSequenceView view)
    {
        if (!hasSecurityAltID)
        {
            throw new IllegalArgumentException("No value for optional field: SecurityAltID");
        }

        return view.wrap(buffer, securityAltIDOffset, securityAltIDLength);
    }


    private final CharArrayWrapper securityAltIDWrapper = new CharArrayWrapper();
    private char[] securityAltIDSource = new char[1];

    private boolean hasSecurityAltIDSource;

    /* SecurityAltIDSource = 456 */
    public char[] securityAltIDSource()
    {
        if (!hasSecurityAltIDSource)
        {
            throw new IllegalArgumentException("No value for optional field: SecurityAltIDSource");
        }

        return securityAltIDSource;
    }

    public boolean hasSecurityAltIDSource()
    {
        return hasSecurityAltIDSource;
    }


    private int securityAltIDSourceOffset;

    private int securityAltIDSourceLength;

    /* SecurityAltIDSource = 456 */
    public int securityAltIDSourceLength()
    {
        if (!hasSecurityAltIDSource)
        {
            throw new IllegalArgumentException("No value for optional field: SecurityAltIDSource");
        }

        return securityAltIDSourceLength;
    }

    /* SecurityAltIDSource = 456 */
    public String securityAltIDSourceAsString()
    {
        return hasSecurityAltIDSource ? new String(securityAltIDSource, 0, securityAltIDSourceLength) : null;
    }

    /* SecurityAltIDSource = 456 */
    public AsciiSequenceView securityAltIDSource(final AsciiSequenceView view)
    {
        if (!hasSecurityAltIDSource)
        {
            throw new IllegalArgumentException("No value for optional field: SecurityAltIDSource");
        }

        return view.wrap(buffer, securityAltIDSourceOffset, securityAltIDSourceLength);
    }


    private final CharArrayWrapper securityAltIDSourceWrapper = new CharArrayWrapper();
    public int decode(final AsciiBuffer buffer, final int offset, final int length)
    {
        // Decode SecurityAltIDGroup
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
                    next = new SecurityAltIDGroupDecoder(trailer, messageFields);
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
            case Constants.SECURITY_ALT_ID:
                hasSecurityAltID = true;
                securityAltID = buffer.getChars(securityAltID, valueOffset, valueLength);
                securityAltIDOffset = valueOffset;
                securityAltIDLength = valueLength;
                break;

            case Constants.SECURITY_ALT_ID_SOURCE:
                hasSecurityAltIDSource = true;
                securityAltIDSource = buffer.getChars(securityAltIDSource, valueOffset, valueLength);
                securityAltIDSourceOffset = valueOffset;
                securityAltIDSourceLength = valueLength;
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
        this.resetSecurityAltID();
        this.resetSecurityAltIDSource();
        buffer = null;
        if (CODEC_VALIDATION_ENABLED)
        {
            invalidTagId = Decoder.NO_ERROR;
            rejectReason = Decoder.NO_ERROR;
            missingRequiredFields.clear();
        }
    }

    public void resetSecurityAltID()
    {
        hasSecurityAltID = false;
    }

    public void resetSecurityAltIDSource()
    {
        hasSecurityAltIDSource = false;
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
        builder.append("\"MessageName\": \"SecurityAltIDGroup\",\n");
        if (hasSecurityAltID())
        {
            indent(builder, level);
            builder.append("\"SecurityAltID\": \"");
            builder.append(this.securityAltID(), 0, securityAltIDLength());
            builder.append("\",\n");
        }

        if (hasSecurityAltIDSource())
        {
            indent(builder, level);
            builder.append("\"SecurityAltIDSource\": \"");
            builder.append(this.securityAltIDSource(), 0, securityAltIDSourceLength());
            builder.append("\",\n");
        }
        indent(builder, level - 1);
        builder.append("}");
        return builder;
    }

    /**
     * {@inheritDoc}
     */
    public InstrumentEncoder.SecurityAltIDGroupEncoder toEncoder(final Encoder encoder)
    {
        return toEncoder((InstrumentEncoder.SecurityAltIDGroupEncoder)encoder);
    }

    public InstrumentEncoder.SecurityAltIDGroupEncoder toEncoder(final InstrumentEncoder.SecurityAltIDGroupEncoder encoder)
    {
        encoder.reset();
        if (hasSecurityAltID())
        {
            encoder.securityAltID(this.securityAltID(), 0, securityAltIDLength());
        }

        if (hasSecurityAltIDSource())
        {
            encoder.securityAltIDSource(this.securityAltIDSource(), 0, securityAltIDSourceLength());
        }
        return encoder;
    }

}
    @Generated("uk.co.real_logic.artio")
    public class SecurityAltIDGroupIterator implements Iterable<SecurityAltIDGroupDecoder>, java.util.Iterator<SecurityAltIDGroupDecoder>
    {
        private final InstrumentDecoder parent;
        private int remainder;
        private SecurityAltIDGroupDecoder current;

        public SecurityAltIDGroupIterator(final InstrumentDecoder parent)
        {
            this.parent = parent;
        }

        public boolean hasNext()
        {
            return remainder > 0 && current != null;
        }

        public SecurityAltIDGroupDecoder next()
        {
            remainder--;
            final SecurityAltIDGroupDecoder value = current;
            current = current.next();
            return value;
        }

        public int numberFieldValue()
        {
            return parent.hasNoSecurityAltIDGroupCounter() ? parent.noSecurityAltIDGroupCounter() : 0;
        }

        public void reset()
        {
            remainder = numberFieldValue();
            current = parent.securityAltIDGroup();
        }

        public SecurityAltIDGroupIterator iterator()
        {
            reset();
            return this;
        }

    }

    public SecurityAltIDGroupIterator securityAltIDGroupIterator();
    /* NoSecurityAltIDGroupCounter = 454 */
    public int noSecurityAltIDGroupCounter();
    /* NoSecurityAltIDGroupCounter = 454 */
    public boolean hasNoSecurityAltIDGroupCounter();
    public SecurityAltIDGroupDecoder securityAltIDGroup();
    /* Product = 460 */
    public int product();
    /* Product = 460 */
    public boolean hasProduct();
    /* Product = 460 */
    public Product productAsEnum();
    /* CFICode = 461 */
    public char[] cFICode();
    /* CFICode = 461 */
    public boolean hasCFICode();
    /* CFICode = 461 */
    public int cFICodeLength();
    /* CFICode = 461 */
    public AsciiSequenceView cFICode(AsciiSequenceView view);
    /* SecurityType = 167 */
    public char[] securityType();
    /* SecurityType = 167 */
    public boolean hasSecurityType();
    /* SecurityType = 167 */
    public int securityTypeLength();
    /* SecurityType = 167 */
    public SecurityType securityTypeAsEnum();
    /* SecurityType = 167 */
    public AsciiSequenceView securityType(AsciiSequenceView view);
    /* SecuritySubType = 762 */
    public char[] securitySubType();
    /* SecuritySubType = 762 */
    public boolean hasSecuritySubType();
    /* SecuritySubType = 762 */
    public int securitySubTypeLength();
    /* SecuritySubType = 762 */
    public AsciiSequenceView securitySubType(AsciiSequenceView view);
    /* MaturityMonthYear = 200 */
    public byte[] maturityMonthYear();
    /* MaturityMonthYear = 200 */
    public boolean hasMaturityMonthYear();
    /* MaturityMonthYear = 200 */
    public int maturityMonthYearLength();
    /* MaturityMonthYear = 200 */
    public AsciiSequenceView maturityMonthYear(AsciiSequenceView view);
    /* MaturityDate = 541 */
    public byte[] maturityDate();
    /* MaturityDate = 541 */
    public boolean hasMaturityDate();
    /* MaturityDate = 541 */
    public int maturityDateLength();
    /* MaturityDate = 541 */
    public AsciiSequenceView maturityDate(AsciiSequenceView view);
    /* CouponPaymentDate = 224 */
    public byte[] couponPaymentDate();
    /* CouponPaymentDate = 224 */
    public boolean hasCouponPaymentDate();
    /* CouponPaymentDate = 224 */
    public int couponPaymentDateLength();
    /* CouponPaymentDate = 224 */
    public AsciiSequenceView couponPaymentDate(AsciiSequenceView view);
    /* IssueDate = 225 */
    public byte[] issueDate();
    /* IssueDate = 225 */
    public boolean hasIssueDate();
    /* IssueDate = 225 */
    public int issueDateLength();
    /* IssueDate = 225 */
    public AsciiSequenceView issueDate(AsciiSequenceView view);
    /* RepoCollateralSecurityType = 239 */
    public int repoCollateralSecurityType();
    /* RepoCollateralSecurityType = 239 */
    public boolean hasRepoCollateralSecurityType();
    /* RepurchaseTerm = 226 */
    public int repurchaseTerm();
    /* RepurchaseTerm = 226 */
    public boolean hasRepurchaseTerm();
    /* RepurchaseRate = 227 */
    public DecimalFloat repurchaseRate();
    /* RepurchaseRate = 227 */
    public boolean hasRepurchaseRate();
    /* Factor = 228 */
    public DecimalFloat factor();
    /* Factor = 228 */
    public boolean hasFactor();
    /* CreditRating = 255 */
    public char[] creditRating();
    /* CreditRating = 255 */
    public boolean hasCreditRating();
    /* CreditRating = 255 */
    public int creditRatingLength();
    /* CreditRating = 255 */
    public AsciiSequenceView creditRating(AsciiSequenceView view);
    /* InstrRegistry = 543 */
    public char[] instrRegistry();
    /* InstrRegistry = 543 */
    public boolean hasInstrRegistry();
    /* InstrRegistry = 543 */
    public int instrRegistryLength();
    /* InstrRegistry = 543 */
    public AsciiSequenceView instrRegistry(AsciiSequenceView view);
    /* CountryOfIssue = 470 */
    public char[] countryOfIssue();
    /* CountryOfIssue = 470 */
    public boolean hasCountryOfIssue();
    /* CountryOfIssue = 470 */
    public int countryOfIssueLength();
    /* CountryOfIssue = 470 */
    public AsciiSequenceView countryOfIssue(AsciiSequenceView view);
    /* StateOrProvinceOfIssue = 471 */
    public char[] stateOrProvinceOfIssue();
    /* StateOrProvinceOfIssue = 471 */
    public boolean hasStateOrProvinceOfIssue();
    /* StateOrProvinceOfIssue = 471 */
    public int stateOrProvinceOfIssueLength();
    /* StateOrProvinceOfIssue = 471 */
    public AsciiSequenceView stateOrProvinceOfIssue(AsciiSequenceView view);
    /* LocaleOfIssue = 472 */
    public char[] localeOfIssue();
    /* LocaleOfIssue = 472 */
    public boolean hasLocaleOfIssue();
    /* LocaleOfIssue = 472 */
    public int localeOfIssueLength();
    /* LocaleOfIssue = 472 */
    public AsciiSequenceView localeOfIssue(AsciiSequenceView view);
    /* RedemptionDate = 240 */
    public byte[] redemptionDate();
    /* RedemptionDate = 240 */
    public boolean hasRedemptionDate();
    /* RedemptionDate = 240 */
    public int redemptionDateLength();
    /* RedemptionDate = 240 */
    public AsciiSequenceView redemptionDate(AsciiSequenceView view);
    /* StrikePrice = 202 */
    public DecimalFloat strikePrice();
    /* StrikePrice = 202 */
    public boolean hasStrikePrice();
    /* StrikeCurrency = 947 */
    public char[] strikeCurrency();
    /* StrikeCurrency = 947 */
    public boolean hasStrikeCurrency();
    /* StrikeCurrency = 947 */
    public int strikeCurrencyLength();
    /* StrikeCurrency = 947 */
    public AsciiSequenceView strikeCurrency(AsciiSequenceView view);
    /* OptAttribute = 206 */
    public char optAttribute();
    /* OptAttribute = 206 */
    public boolean hasOptAttribute();
    /* ContractMultiplier = 231 */
    public DecimalFloat contractMultiplier();
    /* ContractMultiplier = 231 */
    public boolean hasContractMultiplier();
    /* CouponRate = 223 */
    public DecimalFloat couponRate();
    /* CouponRate = 223 */
    public boolean hasCouponRate();
    /* SecurityExchange = 207 */
    public char[] securityExchange();
    /* SecurityExchange = 207 */
    public boolean hasSecurityExchange();
    /* SecurityExchange = 207 */
    public int securityExchangeLength();
    /* SecurityExchange = 207 */
    public AsciiSequenceView securityExchange(AsciiSequenceView view);
    /* Issuer = 106 */
    public char[] issuer();
    /* Issuer = 106 */
    public boolean hasIssuer();
    /* Issuer = 106 */
    public int issuerLength();
    /* Issuer = 106 */
    public AsciiSequenceView issuer(AsciiSequenceView view);
    /* EncodedIssuerLen = 348 */
    public int encodedIssuerLen();
    /* EncodedIssuerLen = 348 */
    public boolean hasEncodedIssuerLen();
    /* EncodedIssuer = 349 */
    public byte[] encodedIssuer();
    /* EncodedIssuer = 349 */
    public boolean hasEncodedIssuer();
    /* SecurityDesc = 107 */
    public char[] securityDesc();
    /* SecurityDesc = 107 */
    public boolean hasSecurityDesc();
    /* SecurityDesc = 107 */
    public int securityDescLength();
    /* SecurityDesc = 107 */
    public AsciiSequenceView securityDesc(AsciiSequenceView view);
    /* EncodedSecurityDescLen = 350 */
    public int encodedSecurityDescLen();
    /* EncodedSecurityDescLen = 350 */
    public boolean hasEncodedSecurityDescLen();
    /* EncodedSecurityDesc = 351 */
    public byte[] encodedSecurityDesc();
    /* EncodedSecurityDesc = 351 */
    public boolean hasEncodedSecurityDesc();
    /* Pool = 691 */
    public char[] pool();
    /* Pool = 691 */
    public boolean hasPool();
    /* Pool = 691 */
    public int poolLength();
    /* Pool = 691 */
    public AsciiSequenceView pool(AsciiSequenceView view);
    /* ContractSettlMonth = 667 */
    public byte[] contractSettlMonth();
    /* ContractSettlMonth = 667 */
    public boolean hasContractSettlMonth();
    /* ContractSettlMonth = 667 */
    public int contractSettlMonthLength();
    /* ContractSettlMonth = 667 */
    public AsciiSequenceView contractSettlMonth(AsciiSequenceView view);
    /* CPProgram = 875 */
    public int cPProgram();
    /* CPProgram = 875 */
    public boolean hasCPProgram();
    /* CPRegType = 876 */
    public char[] cPRegType();
    /* CPRegType = 876 */
    public boolean hasCPRegType();
    /* CPRegType = 876 */
    public int cPRegTypeLength();
    /* CPRegType = 876 */
    public AsciiSequenceView cPRegType(AsciiSequenceView view);

@Generated("uk.co.real_logic.artio")
public class EventsGroupDecoder extends CommonDecoderImpl
{
    public final IntHashSet REQUIRED_FIELDS = new IntHashSet(0);

    {
        if (CODEC_VALIDATION_ENABLED)
        {
        }
    }

    public final IntHashSet ALL_GROUP_FIELDS = new IntHashSet(8);

    {
        if (CODEC_VALIDATION_ENABLED)
        {
            ALL_GROUP_FIELDS.add(Constants.EVENT_TYPE);
            ALL_GROUP_FIELDS.add(Constants.EVENT_DATE);
            ALL_GROUP_FIELDS.add(Constants.EVENT_PX);
            ALL_GROUP_FIELDS.add(Constants.EVENT_TEXT);
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
        if (hasEventType)
        {
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !EventType.isValid(eventType()))
        {
            invalidTagId = 865;
            rejectReason = 5;
            return false;
        }
        }
        return true;
    }

    private final TrailerDecoder trailer;
    private final IntHashSet messageFields;
    public EventsGroupDecoder(final TrailerDecoder trailer, final IntHashSet messageFields)
    {
        this.trailer = trailer;
        this.messageFields = messageFields;
    }

    private EventsGroupDecoder next = null;

    public EventsGroupDecoder next()
    {
        return next;
    }

    private IntHashSet seenFields = new IntHashSet(8);

    private int eventType = MISSING_INT;

    private boolean hasEventType;

    /* EventType = 865 */
    public int eventType()
    {
        if (!hasEventType)
        {
            throw new IllegalArgumentException("No value for optional field: EventType");
        }

        return eventType;
    }

    public boolean hasEventType()
    {
        return hasEventType;
    }



    private final CharArrayWrapper eventTypeWrapper = new CharArrayWrapper();
    /* EventType = 865 */
    public EventType eventTypeAsEnum()
    {
        if (!hasEventType)
 return EventType.NULL_VAL;
        return EventType.decode(eventType);
    }

    private byte[] eventDate = new byte[8];

    private boolean hasEventDate;

    /* EventDate = 866 */
    public byte[] eventDate()
    {
        if (!hasEventDate)
        {
            throw new IllegalArgumentException("No value for optional field: EventDate");
        }

        return eventDate;
    }

    public boolean hasEventDate()
    {
        return hasEventDate;
    }


    private int eventDateOffset;

    private int eventDateLength;

    /* EventDate = 866 */
    public int eventDateLength()
    {
        if (!hasEventDate)
        {
            throw new IllegalArgumentException("No value for optional field: EventDate");
        }

        return eventDateLength;
    }

    /* EventDate = 866 */
    public String eventDateAsString()
    {
        return hasEventDate ? new String(eventDate, 0, eventDateLength) : null;
    }

    /* EventDate = 866 */
    public AsciiSequenceView eventDate(final AsciiSequenceView view)
    {
        if (!hasEventDate)
        {
            throw new IllegalArgumentException("No value for optional field: EventDate");
        }

        return view.wrap(buffer, eventDateOffset, eventDateLength);
    }


    private DecimalFloat eventPx = DecimalFloat.newNaNValue();

    private boolean hasEventPx;

    /* EventPx = 867 */
    public DecimalFloat eventPx()
    {
        if (!hasEventPx)
        {
            throw new IllegalArgumentException("No value for optional field: EventPx");
        }

        return eventPx;
    }

    public boolean hasEventPx()
    {
        return hasEventPx;
    }



    private char[] eventText = new char[1];

    private boolean hasEventText;

    /* EventText = 868 */
    public char[] eventText()
    {
        if (!hasEventText)
        {
            throw new IllegalArgumentException("No value for optional field: EventText");
        }

        return eventText;
    }

    public boolean hasEventText()
    {
        return hasEventText;
    }


    private int eventTextOffset;

    private int eventTextLength;

    /* EventText = 868 */
    public int eventTextLength()
    {
        if (!hasEventText)
        {
            throw new IllegalArgumentException("No value for optional field: EventText");
        }

        return eventTextLength;
    }

    /* EventText = 868 */
    public String eventTextAsString()
    {
        return hasEventText ? new String(eventText, 0, eventTextLength) : null;
    }

    /* EventText = 868 */
    public AsciiSequenceView eventText(final AsciiSequenceView view)
    {
        if (!hasEventText)
        {
            throw new IllegalArgumentException("No value for optional field: EventText");
        }

        return view.wrap(buffer, eventTextOffset, eventTextLength);
    }


    private final CharArrayWrapper eventTextWrapper = new CharArrayWrapper();
    public int decode(final AsciiBuffer buffer, final int offset, final int length)
    {
        // Decode EventsGroup
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
                    next = new EventsGroupDecoder(trailer, messageFields);
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
            case Constants.EVENT_TYPE:
                hasEventType = true;
                eventType = getInt(buffer, valueOffset, endOfField, 865, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.EVENT_DATE:
                hasEventDate = true;
                eventDate = buffer.getBytes(eventDate, valueOffset, valueLength);
                eventDateOffset = valueOffset;
                eventDateLength = valueLength;
                break;

            case Constants.EVENT_PX:
                hasEventPx = true;
                eventPx = getFloat(buffer, eventPx, valueOffset, valueLength, 867, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.EVENT_TEXT:
                hasEventText = true;
                eventText = buffer.getChars(eventText, valueOffset, valueLength);
                eventTextOffset = valueOffset;
                eventTextLength = valueLength;
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
        this.resetEventType();
        this.resetEventDate();
        this.resetEventPx();
        this.resetEventText();
        buffer = null;
        if (CODEC_VALIDATION_ENABLED)
        {
            invalidTagId = Decoder.NO_ERROR;
            rejectReason = Decoder.NO_ERROR;
            missingRequiredFields.clear();
        }
    }

    public void resetEventType()
    {
        hasEventType = false;
    }

    public void resetEventDate()
    {
        hasEventDate = false;
    }

    public void resetEventPx()
    {
        hasEventPx = false;
    }

    public void resetEventText()
    {
        hasEventText = false;
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
        builder.append("\"MessageName\": \"EventsGroup\",\n");
        if (hasEventType())
        {
            indent(builder, level);
            builder.append("\"EventType\": \"");
            builder.append(eventType);
            builder.append("\",\n");
        }

        if (hasEventDate())
        {
            indent(builder, level);
            builder.append("\"EventDate\": \"");
            appendData(builder, eventDate, eventDateLength);
            builder.append("\",\n");
        }

        if (hasEventPx())
        {
            indent(builder, level);
            builder.append("\"EventPx\": \"");
            eventPx.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasEventText())
        {
            indent(builder, level);
            builder.append("\"EventText\": \"");
            builder.append(this.eventText(), 0, eventTextLength());
            builder.append("\",\n");
        }
        indent(builder, level - 1);
        builder.append("}");
        return builder;
    }

    /**
     * {@inheritDoc}
     */
    public InstrumentEncoder.EventsGroupEncoder toEncoder(final Encoder encoder)
    {
        return toEncoder((InstrumentEncoder.EventsGroupEncoder)encoder);
    }

    public InstrumentEncoder.EventsGroupEncoder toEncoder(final InstrumentEncoder.EventsGroupEncoder encoder)
    {
        encoder.reset();
        if (hasEventType())
        {
            encoder.eventType(this.eventType());
        }

        if (hasEventDate())
        {
            encoder.eventDateAsCopy(this.eventDate(), 0, eventDateLength());
        }

        if (hasEventPx())
        {
            encoder.eventPx(this.eventPx());
        }

        if (hasEventText())
        {
            encoder.eventText(this.eventText(), 0, eventTextLength());
        }
        return encoder;
    }

}
    @Generated("uk.co.real_logic.artio")
    public class EventsGroupIterator implements Iterable<EventsGroupDecoder>, java.util.Iterator<EventsGroupDecoder>
    {
        private final InstrumentDecoder parent;
        private int remainder;
        private EventsGroupDecoder current;

        public EventsGroupIterator(final InstrumentDecoder parent)
        {
            this.parent = parent;
        }

        public boolean hasNext()
        {
            return remainder > 0 && current != null;
        }

        public EventsGroupDecoder next()
        {
            remainder--;
            final EventsGroupDecoder value = current;
            current = current.next();
            return value;
        }

        public int numberFieldValue()
        {
            return parent.hasNoEventsGroupCounter() ? parent.noEventsGroupCounter() : 0;
        }

        public void reset()
        {
            remainder = numberFieldValue();
            current = parent.eventsGroup();
        }

        public EventsGroupIterator iterator()
        {
            reset();
            return this;
        }

    }

    public EventsGroupIterator eventsGroupIterator();
    /* NoEventsGroupCounter = 864 */
    public int noEventsGroupCounter();
    /* NoEventsGroupCounter = 864 */
    public boolean hasNoEventsGroupCounter();
    public EventsGroupDecoder eventsGroup();
    /* DatedDate = 873 */
    public byte[] datedDate();
    /* DatedDate = 873 */
    public boolean hasDatedDate();
    /* DatedDate = 873 */
    public int datedDateLength();
    /* DatedDate = 873 */
    public AsciiSequenceView datedDate(AsciiSequenceView view);
    /* InterestAccrualDate = 874 */
    public byte[] interestAccrualDate();
    /* InterestAccrualDate = 874 */
    public boolean hasInterestAccrualDate();
    /* InterestAccrualDate = 874 */
    public int interestAccrualDateLength();
    /* InterestAccrualDate = 874 */
    public AsciiSequenceView interestAccrualDate(AsciiSequenceView view);

}
