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
import uk.co.real_logic.artio.builder.UnderlyingInstrumentEncoder;
import static uk.co.real_logic.artio.builder.UnderlyingInstrumentEncoder.UnderlyingSecurityAltIDGroupEncoder;
import uk.co.real_logic.artio.builder.UnderlyingStipulationsEncoder;
import static uk.co.real_logic.artio.builder.UnderlyingStipulationsEncoder.UnderlyingStipsGroupEncoder;
import uk.co.real_logic.artio.dictionary.Generated;

@Generated("uk.co.real_logic.artio")
public interface UnderlyingInstrumentDecoder  extends UnderlyingStipulationsDecoder
{

    /* UnderlyingSymbol = 311 */
    public char[] underlyingSymbol();
    /* UnderlyingSymbol = 311 */
    public int underlyingSymbolLength();
    /* UnderlyingSymbol = 311 */
    public AsciiSequenceView underlyingSymbol(AsciiSequenceView view);
    /* UnderlyingSymbolSfx = 312 */
    public char[] underlyingSymbolSfx();
    /* UnderlyingSymbolSfx = 312 */
    public boolean hasUnderlyingSymbolSfx();
    /* UnderlyingSymbolSfx = 312 */
    public int underlyingSymbolSfxLength();
    /* UnderlyingSymbolSfx = 312 */
    public AsciiSequenceView underlyingSymbolSfx(AsciiSequenceView view);
    /* UnderlyingSecurityID = 309 */
    public char[] underlyingSecurityID();
    /* UnderlyingSecurityID = 309 */
    public boolean hasUnderlyingSecurityID();
    /* UnderlyingSecurityID = 309 */
    public int underlyingSecurityIDLength();
    /* UnderlyingSecurityID = 309 */
    public AsciiSequenceView underlyingSecurityID(AsciiSequenceView view);
    /* UnderlyingSecurityIDSource = 305 */
    public char[] underlyingSecurityIDSource();
    /* UnderlyingSecurityIDSource = 305 */
    public boolean hasUnderlyingSecurityIDSource();
    /* UnderlyingSecurityIDSource = 305 */
    public int underlyingSecurityIDSourceLength();
    /* UnderlyingSecurityIDSource = 305 */
    public AsciiSequenceView underlyingSecurityIDSource(AsciiSequenceView view);

@Generated("uk.co.real_logic.artio")
public class UnderlyingSecurityAltIDGroupDecoder extends CommonDecoderImpl
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
            ALL_GROUP_FIELDS.add(Constants.UNDERLYING_SECURITY_ALT_ID);
            ALL_GROUP_FIELDS.add(Constants.UNDERLYING_SECURITY_ALT_ID_SOURCE);
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
    public UnderlyingSecurityAltIDGroupDecoder(final TrailerDecoder trailer, final IntHashSet messageFields)
    {
        this.trailer = trailer;
        this.messageFields = messageFields;
    }

    private UnderlyingSecurityAltIDGroupDecoder next = null;

    public UnderlyingSecurityAltIDGroupDecoder next()
    {
        return next;
    }

    private IntHashSet seenFields = new IntHashSet(4);

    private char[] underlyingSecurityAltID = new char[1];

    private boolean hasUnderlyingSecurityAltID;

    /* UnderlyingSecurityAltID = 458 */
    public char[] underlyingSecurityAltID()
    {
        if (!hasUnderlyingSecurityAltID)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingSecurityAltID");
        }

        return underlyingSecurityAltID;
    }

    public boolean hasUnderlyingSecurityAltID()
    {
        return hasUnderlyingSecurityAltID;
    }


    private int underlyingSecurityAltIDOffset;

    private int underlyingSecurityAltIDLength;

    /* UnderlyingSecurityAltID = 458 */
    public int underlyingSecurityAltIDLength()
    {
        if (!hasUnderlyingSecurityAltID)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingSecurityAltID");
        }

        return underlyingSecurityAltIDLength;
    }

    /* UnderlyingSecurityAltID = 458 */
    public String underlyingSecurityAltIDAsString()
    {
        return hasUnderlyingSecurityAltID ? new String(underlyingSecurityAltID, 0, underlyingSecurityAltIDLength) : null;
    }

    /* UnderlyingSecurityAltID = 458 */
    public AsciiSequenceView underlyingSecurityAltID(final AsciiSequenceView view)
    {
        if (!hasUnderlyingSecurityAltID)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingSecurityAltID");
        }

        return view.wrap(buffer, underlyingSecurityAltIDOffset, underlyingSecurityAltIDLength);
    }


    private final CharArrayWrapper underlyingSecurityAltIDWrapper = new CharArrayWrapper();
    private char[] underlyingSecurityAltIDSource = new char[1];

    private boolean hasUnderlyingSecurityAltIDSource;

    /* UnderlyingSecurityAltIDSource = 459 */
    public char[] underlyingSecurityAltIDSource()
    {
        if (!hasUnderlyingSecurityAltIDSource)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingSecurityAltIDSource");
        }

        return underlyingSecurityAltIDSource;
    }

    public boolean hasUnderlyingSecurityAltIDSource()
    {
        return hasUnderlyingSecurityAltIDSource;
    }


    private int underlyingSecurityAltIDSourceOffset;

    private int underlyingSecurityAltIDSourceLength;

    /* UnderlyingSecurityAltIDSource = 459 */
    public int underlyingSecurityAltIDSourceLength()
    {
        if (!hasUnderlyingSecurityAltIDSource)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingSecurityAltIDSource");
        }

        return underlyingSecurityAltIDSourceLength;
    }

    /* UnderlyingSecurityAltIDSource = 459 */
    public String underlyingSecurityAltIDSourceAsString()
    {
        return hasUnderlyingSecurityAltIDSource ? new String(underlyingSecurityAltIDSource, 0, underlyingSecurityAltIDSourceLength) : null;
    }

    /* UnderlyingSecurityAltIDSource = 459 */
    public AsciiSequenceView underlyingSecurityAltIDSource(final AsciiSequenceView view)
    {
        if (!hasUnderlyingSecurityAltIDSource)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingSecurityAltIDSource");
        }

        return view.wrap(buffer, underlyingSecurityAltIDSourceOffset, underlyingSecurityAltIDSourceLength);
    }


    private final CharArrayWrapper underlyingSecurityAltIDSourceWrapper = new CharArrayWrapper();
    public int decode(final AsciiBuffer buffer, final int offset, final int length)
    {
        // Decode UnderlyingSecurityAltIDGroup
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
                    next = new UnderlyingSecurityAltIDGroupDecoder(trailer, messageFields);
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
            case Constants.UNDERLYING_SECURITY_ALT_ID:
                hasUnderlyingSecurityAltID = true;
                underlyingSecurityAltID = buffer.getChars(underlyingSecurityAltID, valueOffset, valueLength);
                underlyingSecurityAltIDOffset = valueOffset;
                underlyingSecurityAltIDLength = valueLength;
                break;

            case Constants.UNDERLYING_SECURITY_ALT_ID_SOURCE:
                hasUnderlyingSecurityAltIDSource = true;
                underlyingSecurityAltIDSource = buffer.getChars(underlyingSecurityAltIDSource, valueOffset, valueLength);
                underlyingSecurityAltIDSourceOffset = valueOffset;
                underlyingSecurityAltIDSourceLength = valueLength;
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
        this.resetUnderlyingSecurityAltID();
        this.resetUnderlyingSecurityAltIDSource();
        buffer = null;
        if (CODEC_VALIDATION_ENABLED)
        {
            invalidTagId = Decoder.NO_ERROR;
            rejectReason = Decoder.NO_ERROR;
            missingRequiredFields.clear();
        }
    }

    public void resetUnderlyingSecurityAltID()
    {
        hasUnderlyingSecurityAltID = false;
    }

    public void resetUnderlyingSecurityAltIDSource()
    {
        hasUnderlyingSecurityAltIDSource = false;
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
        builder.append("\"MessageName\": \"UnderlyingSecurityAltIDGroup\",\n");
        if (hasUnderlyingSecurityAltID())
        {
            indent(builder, level);
            builder.append("\"UnderlyingSecurityAltID\": \"");
            builder.append(this.underlyingSecurityAltID(), 0, underlyingSecurityAltIDLength());
            builder.append("\",\n");
        }

        if (hasUnderlyingSecurityAltIDSource())
        {
            indent(builder, level);
            builder.append("\"UnderlyingSecurityAltIDSource\": \"");
            builder.append(this.underlyingSecurityAltIDSource(), 0, underlyingSecurityAltIDSourceLength());
            builder.append("\",\n");
        }
        indent(builder, level - 1);
        builder.append("}");
        return builder;
    }

    /**
     * {@inheritDoc}
     */
    public UnderlyingInstrumentEncoder.UnderlyingSecurityAltIDGroupEncoder toEncoder(final Encoder encoder)
    {
        return toEncoder((UnderlyingInstrumentEncoder.UnderlyingSecurityAltIDGroupEncoder)encoder);
    }

    public UnderlyingInstrumentEncoder.UnderlyingSecurityAltIDGroupEncoder toEncoder(final UnderlyingInstrumentEncoder.UnderlyingSecurityAltIDGroupEncoder encoder)
    {
        encoder.reset();
        if (hasUnderlyingSecurityAltID())
        {
            encoder.underlyingSecurityAltID(this.underlyingSecurityAltID(), 0, underlyingSecurityAltIDLength());
        }

        if (hasUnderlyingSecurityAltIDSource())
        {
            encoder.underlyingSecurityAltIDSource(this.underlyingSecurityAltIDSource(), 0, underlyingSecurityAltIDSourceLength());
        }
        return encoder;
    }

}
    @Generated("uk.co.real_logic.artio")
    public class UnderlyingSecurityAltIDGroupIterator implements Iterable<UnderlyingSecurityAltIDGroupDecoder>, java.util.Iterator<UnderlyingSecurityAltIDGroupDecoder>
    {
        private final UnderlyingInstrumentDecoder parent;
        private int remainder;
        private UnderlyingSecurityAltIDGroupDecoder current;

        public UnderlyingSecurityAltIDGroupIterator(final UnderlyingInstrumentDecoder parent)
        {
            this.parent = parent;
        }

        public boolean hasNext()
        {
            return remainder > 0 && current != null;
        }

        public UnderlyingSecurityAltIDGroupDecoder next()
        {
            remainder--;
            final UnderlyingSecurityAltIDGroupDecoder value = current;
            current = current.next();
            return value;
        }

        public int numberFieldValue()
        {
            return parent.hasNoUnderlyingSecurityAltIDGroupCounter() ? parent.noUnderlyingSecurityAltIDGroupCounter() : 0;
        }

        public void reset()
        {
            remainder = numberFieldValue();
            current = parent.underlyingSecurityAltIDGroup();
        }

        public UnderlyingSecurityAltIDGroupIterator iterator()
        {
            reset();
            return this;
        }

    }

    public UnderlyingSecurityAltIDGroupIterator underlyingSecurityAltIDGroupIterator();
    /* NoUnderlyingSecurityAltIDGroupCounter = 457 */
    public int noUnderlyingSecurityAltIDGroupCounter();
    /* NoUnderlyingSecurityAltIDGroupCounter = 457 */
    public boolean hasNoUnderlyingSecurityAltIDGroupCounter();
    public UnderlyingSecurityAltIDGroupDecoder underlyingSecurityAltIDGroup();
    /* UnderlyingProduct = 462 */
    public int underlyingProduct();
    /* UnderlyingProduct = 462 */
    public boolean hasUnderlyingProduct();
    /* UnderlyingCFICode = 463 */
    public char[] underlyingCFICode();
    /* UnderlyingCFICode = 463 */
    public boolean hasUnderlyingCFICode();
    /* UnderlyingCFICode = 463 */
    public int underlyingCFICodeLength();
    /* UnderlyingCFICode = 463 */
    public AsciiSequenceView underlyingCFICode(AsciiSequenceView view);
    /* UnderlyingSecurityType = 310 */
    public char[] underlyingSecurityType();
    /* UnderlyingSecurityType = 310 */
    public boolean hasUnderlyingSecurityType();
    /* UnderlyingSecurityType = 310 */
    public int underlyingSecurityTypeLength();
    /* UnderlyingSecurityType = 310 */
    public AsciiSequenceView underlyingSecurityType(AsciiSequenceView view);
    /* UnderlyingSecuritySubType = 763 */
    public char[] underlyingSecuritySubType();
    /* UnderlyingSecuritySubType = 763 */
    public boolean hasUnderlyingSecuritySubType();
    /* UnderlyingSecuritySubType = 763 */
    public int underlyingSecuritySubTypeLength();
    /* UnderlyingSecuritySubType = 763 */
    public AsciiSequenceView underlyingSecuritySubType(AsciiSequenceView view);
    /* UnderlyingMaturityMonthYear = 313 */
    public byte[] underlyingMaturityMonthYear();
    /* UnderlyingMaturityMonthYear = 313 */
    public boolean hasUnderlyingMaturityMonthYear();
    /* UnderlyingMaturityMonthYear = 313 */
    public int underlyingMaturityMonthYearLength();
    /* UnderlyingMaturityMonthYear = 313 */
    public AsciiSequenceView underlyingMaturityMonthYear(AsciiSequenceView view);
    /* UnderlyingMaturityDate = 542 */
    public byte[] underlyingMaturityDate();
    /* UnderlyingMaturityDate = 542 */
    public boolean hasUnderlyingMaturityDate();
    /* UnderlyingMaturityDate = 542 */
    public int underlyingMaturityDateLength();
    /* UnderlyingMaturityDate = 542 */
    public AsciiSequenceView underlyingMaturityDate(AsciiSequenceView view);
    /* UnderlyingCouponPaymentDate = 241 */
    public byte[] underlyingCouponPaymentDate();
    /* UnderlyingCouponPaymentDate = 241 */
    public boolean hasUnderlyingCouponPaymentDate();
    /* UnderlyingCouponPaymentDate = 241 */
    public int underlyingCouponPaymentDateLength();
    /* UnderlyingCouponPaymentDate = 241 */
    public AsciiSequenceView underlyingCouponPaymentDate(AsciiSequenceView view);
    /* UnderlyingIssueDate = 242 */
    public byte[] underlyingIssueDate();
    /* UnderlyingIssueDate = 242 */
    public boolean hasUnderlyingIssueDate();
    /* UnderlyingIssueDate = 242 */
    public int underlyingIssueDateLength();
    /* UnderlyingIssueDate = 242 */
    public AsciiSequenceView underlyingIssueDate(AsciiSequenceView view);
    /* UnderlyingRepoCollateralSecurityType = 243 */
    public int underlyingRepoCollateralSecurityType();
    /* UnderlyingRepoCollateralSecurityType = 243 */
    public boolean hasUnderlyingRepoCollateralSecurityType();
    /* UnderlyingRepurchaseTerm = 244 */
    public int underlyingRepurchaseTerm();
    /* UnderlyingRepurchaseTerm = 244 */
    public boolean hasUnderlyingRepurchaseTerm();
    /* UnderlyingRepurchaseRate = 245 */
    public DecimalFloat underlyingRepurchaseRate();
    /* UnderlyingRepurchaseRate = 245 */
    public boolean hasUnderlyingRepurchaseRate();
    /* UnderlyingFactor = 246 */
    public DecimalFloat underlyingFactor();
    /* UnderlyingFactor = 246 */
    public boolean hasUnderlyingFactor();
    /* UnderlyingCreditRating = 256 */
    public char[] underlyingCreditRating();
    /* UnderlyingCreditRating = 256 */
    public boolean hasUnderlyingCreditRating();
    /* UnderlyingCreditRating = 256 */
    public int underlyingCreditRatingLength();
    /* UnderlyingCreditRating = 256 */
    public AsciiSequenceView underlyingCreditRating(AsciiSequenceView view);
    /* UnderlyingInstrRegistry = 595 */
    public char[] underlyingInstrRegistry();
    /* UnderlyingInstrRegistry = 595 */
    public boolean hasUnderlyingInstrRegistry();
    /* UnderlyingInstrRegistry = 595 */
    public int underlyingInstrRegistryLength();
    /* UnderlyingInstrRegistry = 595 */
    public AsciiSequenceView underlyingInstrRegistry(AsciiSequenceView view);
    /* UnderlyingCountryOfIssue = 592 */
    public char[] underlyingCountryOfIssue();
    /* UnderlyingCountryOfIssue = 592 */
    public boolean hasUnderlyingCountryOfIssue();
    /* UnderlyingCountryOfIssue = 592 */
    public int underlyingCountryOfIssueLength();
    /* UnderlyingCountryOfIssue = 592 */
    public AsciiSequenceView underlyingCountryOfIssue(AsciiSequenceView view);
    /* UnderlyingStateOrProvinceOfIssue = 593 */
    public char[] underlyingStateOrProvinceOfIssue();
    /* UnderlyingStateOrProvinceOfIssue = 593 */
    public boolean hasUnderlyingStateOrProvinceOfIssue();
    /* UnderlyingStateOrProvinceOfIssue = 593 */
    public int underlyingStateOrProvinceOfIssueLength();
    /* UnderlyingStateOrProvinceOfIssue = 593 */
    public AsciiSequenceView underlyingStateOrProvinceOfIssue(AsciiSequenceView view);
    /* UnderlyingLocaleOfIssue = 594 */
    public char[] underlyingLocaleOfIssue();
    /* UnderlyingLocaleOfIssue = 594 */
    public boolean hasUnderlyingLocaleOfIssue();
    /* UnderlyingLocaleOfIssue = 594 */
    public int underlyingLocaleOfIssueLength();
    /* UnderlyingLocaleOfIssue = 594 */
    public AsciiSequenceView underlyingLocaleOfIssue(AsciiSequenceView view);
    /* UnderlyingRedemptionDate = 247 */
    public byte[] underlyingRedemptionDate();
    /* UnderlyingRedemptionDate = 247 */
    public boolean hasUnderlyingRedemptionDate();
    /* UnderlyingRedemptionDate = 247 */
    public int underlyingRedemptionDateLength();
    /* UnderlyingRedemptionDate = 247 */
    public AsciiSequenceView underlyingRedemptionDate(AsciiSequenceView view);
    /* UnderlyingStrikePrice = 316 */
    public DecimalFloat underlyingStrikePrice();
    /* UnderlyingStrikePrice = 316 */
    public boolean hasUnderlyingStrikePrice();
    /* UnderlyingStrikeCurrency = 941 */
    public char[] underlyingStrikeCurrency();
    /* UnderlyingStrikeCurrency = 941 */
    public boolean hasUnderlyingStrikeCurrency();
    /* UnderlyingStrikeCurrency = 941 */
    public int underlyingStrikeCurrencyLength();
    /* UnderlyingStrikeCurrency = 941 */
    public AsciiSequenceView underlyingStrikeCurrency(AsciiSequenceView view);
    /* UnderlyingOptAttribute = 317 */
    public char underlyingOptAttribute();
    /* UnderlyingOptAttribute = 317 */
    public boolean hasUnderlyingOptAttribute();
    /* UnderlyingContractMultiplier = 436 */
    public DecimalFloat underlyingContractMultiplier();
    /* UnderlyingContractMultiplier = 436 */
    public boolean hasUnderlyingContractMultiplier();
    /* UnderlyingCouponRate = 435 */
    public DecimalFloat underlyingCouponRate();
    /* UnderlyingCouponRate = 435 */
    public boolean hasUnderlyingCouponRate();
    /* UnderlyingSecurityExchange = 308 */
    public char[] underlyingSecurityExchange();
    /* UnderlyingSecurityExchange = 308 */
    public boolean hasUnderlyingSecurityExchange();
    /* UnderlyingSecurityExchange = 308 */
    public int underlyingSecurityExchangeLength();
    /* UnderlyingSecurityExchange = 308 */
    public AsciiSequenceView underlyingSecurityExchange(AsciiSequenceView view);
    /* UnderlyingIssuer = 306 */
    public char[] underlyingIssuer();
    /* UnderlyingIssuer = 306 */
    public boolean hasUnderlyingIssuer();
    /* UnderlyingIssuer = 306 */
    public int underlyingIssuerLength();
    /* UnderlyingIssuer = 306 */
    public AsciiSequenceView underlyingIssuer(AsciiSequenceView view);
    /* EncodedUnderlyingIssuerLen = 362 */
    public int encodedUnderlyingIssuerLen();
    /* EncodedUnderlyingIssuerLen = 362 */
    public boolean hasEncodedUnderlyingIssuerLen();
    /* EncodedUnderlyingIssuer = 363 */
    public byte[] encodedUnderlyingIssuer();
    /* EncodedUnderlyingIssuer = 363 */
    public boolean hasEncodedUnderlyingIssuer();
    /* UnderlyingSecurityDesc = 307 */
    public char[] underlyingSecurityDesc();
    /* UnderlyingSecurityDesc = 307 */
    public boolean hasUnderlyingSecurityDesc();
    /* UnderlyingSecurityDesc = 307 */
    public int underlyingSecurityDescLength();
    /* UnderlyingSecurityDesc = 307 */
    public AsciiSequenceView underlyingSecurityDesc(AsciiSequenceView view);
    /* EncodedUnderlyingSecurityDescLen = 364 */
    public int encodedUnderlyingSecurityDescLen();
    /* EncodedUnderlyingSecurityDescLen = 364 */
    public boolean hasEncodedUnderlyingSecurityDescLen();
    /* EncodedUnderlyingSecurityDesc = 365 */
    public byte[] encodedUnderlyingSecurityDesc();
    /* EncodedUnderlyingSecurityDesc = 365 */
    public boolean hasEncodedUnderlyingSecurityDesc();
    /* UnderlyingCPProgram = 877 */
    public char[] underlyingCPProgram();
    /* UnderlyingCPProgram = 877 */
    public boolean hasUnderlyingCPProgram();
    /* UnderlyingCPProgram = 877 */
    public int underlyingCPProgramLength();
    /* UnderlyingCPProgram = 877 */
    public AsciiSequenceView underlyingCPProgram(AsciiSequenceView view);
    /* UnderlyingCPRegType = 878 */
    public char[] underlyingCPRegType();
    /* UnderlyingCPRegType = 878 */
    public boolean hasUnderlyingCPRegType();
    /* UnderlyingCPRegType = 878 */
    public int underlyingCPRegTypeLength();
    /* UnderlyingCPRegType = 878 */
    public AsciiSequenceView underlyingCPRegType(AsciiSequenceView view);
    /* UnderlyingCurrency = 318 */
    public char[] underlyingCurrency();
    /* UnderlyingCurrency = 318 */
    public boolean hasUnderlyingCurrency();
    /* UnderlyingCurrency = 318 */
    public int underlyingCurrencyLength();
    /* UnderlyingCurrency = 318 */
    public AsciiSequenceView underlyingCurrency(AsciiSequenceView view);
    /* UnderlyingQty = 879 */
    public DecimalFloat underlyingQty();
    /* UnderlyingQty = 879 */
    public boolean hasUnderlyingQty();
    /* UnderlyingPx = 810 */
    public DecimalFloat underlyingPx();
    /* UnderlyingPx = 810 */
    public boolean hasUnderlyingPx();
    /* UnderlyingDirtyPrice = 882 */
    public DecimalFloat underlyingDirtyPrice();
    /* UnderlyingDirtyPrice = 882 */
    public boolean hasUnderlyingDirtyPrice();
    /* UnderlyingEndPrice = 883 */
    public DecimalFloat underlyingEndPrice();
    /* UnderlyingEndPrice = 883 */
    public boolean hasUnderlyingEndPrice();
    /* UnderlyingStartValue = 884 */
    public DecimalFloat underlyingStartValue();
    /* UnderlyingStartValue = 884 */
    public boolean hasUnderlyingStartValue();
    /* UnderlyingCurrentValue = 885 */
    public DecimalFloat underlyingCurrentValue();
    /* UnderlyingCurrentValue = 885 */
    public boolean hasUnderlyingCurrentValue();
    /* UnderlyingEndValue = 886 */
    public DecimalFloat underlyingEndValue();
    /* UnderlyingEndValue = 886 */
    public boolean hasUnderlyingEndValue();

}
