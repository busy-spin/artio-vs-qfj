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
import uk.co.real_logic.artio.builder.InstrumentLegEncoder;
import static uk.co.real_logic.artio.builder.InstrumentLegEncoder.LegSecurityAltIDGroupEncoder;
import uk.co.real_logic.artio.dictionary.Generated;

@Generated("uk.co.real_logic.artio")
public interface InstrumentLegDecoder 
{

    /* LegSymbol = 600 */
    public char[] legSymbol();
    /* LegSymbol = 600 */
    public int legSymbolLength();
    /* LegSymbol = 600 */
    public AsciiSequenceView legSymbol(AsciiSequenceView view);
    /* LegSymbolSfx = 601 */
    public char[] legSymbolSfx();
    /* LegSymbolSfx = 601 */
    public boolean hasLegSymbolSfx();
    /* LegSymbolSfx = 601 */
    public int legSymbolSfxLength();
    /* LegSymbolSfx = 601 */
    public AsciiSequenceView legSymbolSfx(AsciiSequenceView view);
    /* LegSecurityID = 602 */
    public char[] legSecurityID();
    /* LegSecurityID = 602 */
    public boolean hasLegSecurityID();
    /* LegSecurityID = 602 */
    public int legSecurityIDLength();
    /* LegSecurityID = 602 */
    public AsciiSequenceView legSecurityID(AsciiSequenceView view);
    /* LegSecurityIDSource = 603 */
    public char[] legSecurityIDSource();
    /* LegSecurityIDSource = 603 */
    public boolean hasLegSecurityIDSource();
    /* LegSecurityIDSource = 603 */
    public int legSecurityIDSourceLength();
    /* LegSecurityIDSource = 603 */
    public AsciiSequenceView legSecurityIDSource(AsciiSequenceView view);

@Generated("uk.co.real_logic.artio")
public class LegSecurityAltIDGroupDecoder extends CommonDecoderImpl
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
            ALL_GROUP_FIELDS.add(Constants.LEG_SECURITY_ALT_ID);
            ALL_GROUP_FIELDS.add(Constants.LEG_SECURITY_ALT_ID_SOURCE);
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
    public LegSecurityAltIDGroupDecoder(final TrailerDecoder trailer, final IntHashSet messageFields)
    {
        this.trailer = trailer;
        this.messageFields = messageFields;
    }

    private LegSecurityAltIDGroupDecoder next = null;

    public LegSecurityAltIDGroupDecoder next()
    {
        return next;
    }

    private IntHashSet seenFields = new IntHashSet(4);

    private char[] legSecurityAltID = new char[1];

    private boolean hasLegSecurityAltID;

    /* LegSecurityAltID = 605 */
    public char[] legSecurityAltID()
    {
        if (!hasLegSecurityAltID)
        {
            throw new IllegalArgumentException("No value for optional field: LegSecurityAltID");
        }

        return legSecurityAltID;
    }

    public boolean hasLegSecurityAltID()
    {
        return hasLegSecurityAltID;
    }


    private int legSecurityAltIDOffset;

    private int legSecurityAltIDLength;

    /* LegSecurityAltID = 605 */
    public int legSecurityAltIDLength()
    {
        if (!hasLegSecurityAltID)
        {
            throw new IllegalArgumentException("No value for optional field: LegSecurityAltID");
        }

        return legSecurityAltIDLength;
    }

    /* LegSecurityAltID = 605 */
    public String legSecurityAltIDAsString()
    {
        return hasLegSecurityAltID ? new String(legSecurityAltID, 0, legSecurityAltIDLength) : null;
    }

    /* LegSecurityAltID = 605 */
    public AsciiSequenceView legSecurityAltID(final AsciiSequenceView view)
    {
        if (!hasLegSecurityAltID)
        {
            throw new IllegalArgumentException("No value for optional field: LegSecurityAltID");
        }

        return view.wrap(buffer, legSecurityAltIDOffset, legSecurityAltIDLength);
    }


    private final CharArrayWrapper legSecurityAltIDWrapper = new CharArrayWrapper();
    private char[] legSecurityAltIDSource = new char[1];

    private boolean hasLegSecurityAltIDSource;

    /* LegSecurityAltIDSource = 606 */
    public char[] legSecurityAltIDSource()
    {
        if (!hasLegSecurityAltIDSource)
        {
            throw new IllegalArgumentException("No value for optional field: LegSecurityAltIDSource");
        }

        return legSecurityAltIDSource;
    }

    public boolean hasLegSecurityAltIDSource()
    {
        return hasLegSecurityAltIDSource;
    }


    private int legSecurityAltIDSourceOffset;

    private int legSecurityAltIDSourceLength;

    /* LegSecurityAltIDSource = 606 */
    public int legSecurityAltIDSourceLength()
    {
        if (!hasLegSecurityAltIDSource)
        {
            throw new IllegalArgumentException("No value for optional field: LegSecurityAltIDSource");
        }

        return legSecurityAltIDSourceLength;
    }

    /* LegSecurityAltIDSource = 606 */
    public String legSecurityAltIDSourceAsString()
    {
        return hasLegSecurityAltIDSource ? new String(legSecurityAltIDSource, 0, legSecurityAltIDSourceLength) : null;
    }

    /* LegSecurityAltIDSource = 606 */
    public AsciiSequenceView legSecurityAltIDSource(final AsciiSequenceView view)
    {
        if (!hasLegSecurityAltIDSource)
        {
            throw new IllegalArgumentException("No value for optional field: LegSecurityAltIDSource");
        }

        return view.wrap(buffer, legSecurityAltIDSourceOffset, legSecurityAltIDSourceLength);
    }


    private final CharArrayWrapper legSecurityAltIDSourceWrapper = new CharArrayWrapper();
    public int decode(final AsciiBuffer buffer, final int offset, final int length)
    {
        // Decode LegSecurityAltIDGroup
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
                    next = new LegSecurityAltIDGroupDecoder(trailer, messageFields);
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
            case Constants.LEG_SECURITY_ALT_ID:
                hasLegSecurityAltID = true;
                legSecurityAltID = buffer.getChars(legSecurityAltID, valueOffset, valueLength);
                legSecurityAltIDOffset = valueOffset;
                legSecurityAltIDLength = valueLength;
                break;

            case Constants.LEG_SECURITY_ALT_ID_SOURCE:
                hasLegSecurityAltIDSource = true;
                legSecurityAltIDSource = buffer.getChars(legSecurityAltIDSource, valueOffset, valueLength);
                legSecurityAltIDSourceOffset = valueOffset;
                legSecurityAltIDSourceLength = valueLength;
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
        this.resetLegSecurityAltID();
        this.resetLegSecurityAltIDSource();
        buffer = null;
        if (CODEC_VALIDATION_ENABLED)
        {
            invalidTagId = Decoder.NO_ERROR;
            rejectReason = Decoder.NO_ERROR;
            missingRequiredFields.clear();
        }
    }

    public void resetLegSecurityAltID()
    {
        hasLegSecurityAltID = false;
    }

    public void resetLegSecurityAltIDSource()
    {
        hasLegSecurityAltIDSource = false;
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
        builder.append("\"MessageName\": \"LegSecurityAltIDGroup\",\n");
        if (hasLegSecurityAltID())
        {
            indent(builder, level);
            builder.append("\"LegSecurityAltID\": \"");
            builder.append(this.legSecurityAltID(), 0, legSecurityAltIDLength());
            builder.append("\",\n");
        }

        if (hasLegSecurityAltIDSource())
        {
            indent(builder, level);
            builder.append("\"LegSecurityAltIDSource\": \"");
            builder.append(this.legSecurityAltIDSource(), 0, legSecurityAltIDSourceLength());
            builder.append("\",\n");
        }
        indent(builder, level - 1);
        builder.append("}");
        return builder;
    }

    /**
     * {@inheritDoc}
     */
    public InstrumentLegEncoder.LegSecurityAltIDGroupEncoder toEncoder(final Encoder encoder)
    {
        return toEncoder((InstrumentLegEncoder.LegSecurityAltIDGroupEncoder)encoder);
    }

    public InstrumentLegEncoder.LegSecurityAltIDGroupEncoder toEncoder(final InstrumentLegEncoder.LegSecurityAltIDGroupEncoder encoder)
    {
        encoder.reset();
        if (hasLegSecurityAltID())
        {
            encoder.legSecurityAltID(this.legSecurityAltID(), 0, legSecurityAltIDLength());
        }

        if (hasLegSecurityAltIDSource())
        {
            encoder.legSecurityAltIDSource(this.legSecurityAltIDSource(), 0, legSecurityAltIDSourceLength());
        }
        return encoder;
    }

}
    @Generated("uk.co.real_logic.artio")
    public class LegSecurityAltIDGroupIterator implements Iterable<LegSecurityAltIDGroupDecoder>, java.util.Iterator<LegSecurityAltIDGroupDecoder>
    {
        private final InstrumentLegDecoder parent;
        private int remainder;
        private LegSecurityAltIDGroupDecoder current;

        public LegSecurityAltIDGroupIterator(final InstrumentLegDecoder parent)
        {
            this.parent = parent;
        }

        public boolean hasNext()
        {
            return remainder > 0 && current != null;
        }

        public LegSecurityAltIDGroupDecoder next()
        {
            remainder--;
            final LegSecurityAltIDGroupDecoder value = current;
            current = current.next();
            return value;
        }

        public int numberFieldValue()
        {
            return parent.hasNoLegSecurityAltIDGroupCounter() ? parent.noLegSecurityAltIDGroupCounter() : 0;
        }

        public void reset()
        {
            remainder = numberFieldValue();
            current = parent.legSecurityAltIDGroup();
        }

        public LegSecurityAltIDGroupIterator iterator()
        {
            reset();
            return this;
        }

    }

    public LegSecurityAltIDGroupIterator legSecurityAltIDGroupIterator();
    /* NoLegSecurityAltIDGroupCounter = 604 */
    public int noLegSecurityAltIDGroupCounter();
    /* NoLegSecurityAltIDGroupCounter = 604 */
    public boolean hasNoLegSecurityAltIDGroupCounter();
    public LegSecurityAltIDGroupDecoder legSecurityAltIDGroup();
    /* LegProduct = 607 */
    public int legProduct();
    /* LegProduct = 607 */
    public boolean hasLegProduct();
    /* LegCFICode = 608 */
    public char[] legCFICode();
    /* LegCFICode = 608 */
    public boolean hasLegCFICode();
    /* LegCFICode = 608 */
    public int legCFICodeLength();
    /* LegCFICode = 608 */
    public AsciiSequenceView legCFICode(AsciiSequenceView view);
    /* LegSecurityType = 609 */
    public char[] legSecurityType();
    /* LegSecurityType = 609 */
    public boolean hasLegSecurityType();
    /* LegSecurityType = 609 */
    public int legSecurityTypeLength();
    /* LegSecurityType = 609 */
    public AsciiSequenceView legSecurityType(AsciiSequenceView view);
    /* LegSecuritySubType = 764 */
    public char[] legSecuritySubType();
    /* LegSecuritySubType = 764 */
    public boolean hasLegSecuritySubType();
    /* LegSecuritySubType = 764 */
    public int legSecuritySubTypeLength();
    /* LegSecuritySubType = 764 */
    public AsciiSequenceView legSecuritySubType(AsciiSequenceView view);
    /* LegMaturityMonthYear = 610 */
    public byte[] legMaturityMonthYear();
    /* LegMaturityMonthYear = 610 */
    public boolean hasLegMaturityMonthYear();
    /* LegMaturityMonthYear = 610 */
    public int legMaturityMonthYearLength();
    /* LegMaturityMonthYear = 610 */
    public AsciiSequenceView legMaturityMonthYear(AsciiSequenceView view);
    /* LegMaturityDate = 611 */
    public byte[] legMaturityDate();
    /* LegMaturityDate = 611 */
    public boolean hasLegMaturityDate();
    /* LegMaturityDate = 611 */
    public int legMaturityDateLength();
    /* LegMaturityDate = 611 */
    public AsciiSequenceView legMaturityDate(AsciiSequenceView view);
    /* LegCouponPaymentDate = 248 */
    public byte[] legCouponPaymentDate();
    /* LegCouponPaymentDate = 248 */
    public boolean hasLegCouponPaymentDate();
    /* LegCouponPaymentDate = 248 */
    public int legCouponPaymentDateLength();
    /* LegCouponPaymentDate = 248 */
    public AsciiSequenceView legCouponPaymentDate(AsciiSequenceView view);
    /* LegIssueDate = 249 */
    public byte[] legIssueDate();
    /* LegIssueDate = 249 */
    public boolean hasLegIssueDate();
    /* LegIssueDate = 249 */
    public int legIssueDateLength();
    /* LegIssueDate = 249 */
    public AsciiSequenceView legIssueDate(AsciiSequenceView view);
    /* LegRepoCollateralSecurityType = 250 */
    public int legRepoCollateralSecurityType();
    /* LegRepoCollateralSecurityType = 250 */
    public boolean hasLegRepoCollateralSecurityType();
    /* LegRepurchaseTerm = 251 */
    public int legRepurchaseTerm();
    /* LegRepurchaseTerm = 251 */
    public boolean hasLegRepurchaseTerm();
    /* LegRepurchaseRate = 252 */
    public DecimalFloat legRepurchaseRate();
    /* LegRepurchaseRate = 252 */
    public boolean hasLegRepurchaseRate();
    /* LegFactor = 253 */
    public DecimalFloat legFactor();
    /* LegFactor = 253 */
    public boolean hasLegFactor();
    /* LegCreditRating = 257 */
    public char[] legCreditRating();
    /* LegCreditRating = 257 */
    public boolean hasLegCreditRating();
    /* LegCreditRating = 257 */
    public int legCreditRatingLength();
    /* LegCreditRating = 257 */
    public AsciiSequenceView legCreditRating(AsciiSequenceView view);
    /* LegInstrRegistry = 599 */
    public char[] legInstrRegistry();
    /* LegInstrRegistry = 599 */
    public boolean hasLegInstrRegistry();
    /* LegInstrRegistry = 599 */
    public int legInstrRegistryLength();
    /* LegInstrRegistry = 599 */
    public AsciiSequenceView legInstrRegistry(AsciiSequenceView view);
    /* LegCountryOfIssue = 596 */
    public char[] legCountryOfIssue();
    /* LegCountryOfIssue = 596 */
    public boolean hasLegCountryOfIssue();
    /* LegCountryOfIssue = 596 */
    public int legCountryOfIssueLength();
    /* LegCountryOfIssue = 596 */
    public AsciiSequenceView legCountryOfIssue(AsciiSequenceView view);
    /* LegStateOrProvinceOfIssue = 597 */
    public char[] legStateOrProvinceOfIssue();
    /* LegStateOrProvinceOfIssue = 597 */
    public boolean hasLegStateOrProvinceOfIssue();
    /* LegStateOrProvinceOfIssue = 597 */
    public int legStateOrProvinceOfIssueLength();
    /* LegStateOrProvinceOfIssue = 597 */
    public AsciiSequenceView legStateOrProvinceOfIssue(AsciiSequenceView view);
    /* LegLocaleOfIssue = 598 */
    public char[] legLocaleOfIssue();
    /* LegLocaleOfIssue = 598 */
    public boolean hasLegLocaleOfIssue();
    /* LegLocaleOfIssue = 598 */
    public int legLocaleOfIssueLength();
    /* LegLocaleOfIssue = 598 */
    public AsciiSequenceView legLocaleOfIssue(AsciiSequenceView view);
    /* LegRedemptionDate = 254 */
    public byte[] legRedemptionDate();
    /* LegRedemptionDate = 254 */
    public boolean hasLegRedemptionDate();
    /* LegRedemptionDate = 254 */
    public int legRedemptionDateLength();
    /* LegRedemptionDate = 254 */
    public AsciiSequenceView legRedemptionDate(AsciiSequenceView view);
    /* LegStrikePrice = 612 */
    public DecimalFloat legStrikePrice();
    /* LegStrikePrice = 612 */
    public boolean hasLegStrikePrice();
    /* LegStrikeCurrency = 942 */
    public char[] legStrikeCurrency();
    /* LegStrikeCurrency = 942 */
    public boolean hasLegStrikeCurrency();
    /* LegStrikeCurrency = 942 */
    public int legStrikeCurrencyLength();
    /* LegStrikeCurrency = 942 */
    public AsciiSequenceView legStrikeCurrency(AsciiSequenceView view);
    /* LegOptAttribute = 613 */
    public char legOptAttribute();
    /* LegOptAttribute = 613 */
    public boolean hasLegOptAttribute();
    /* LegContractMultiplier = 614 */
    public DecimalFloat legContractMultiplier();
    /* LegContractMultiplier = 614 */
    public boolean hasLegContractMultiplier();
    /* LegCouponRate = 615 */
    public DecimalFloat legCouponRate();
    /* LegCouponRate = 615 */
    public boolean hasLegCouponRate();
    /* LegSecurityExchange = 616 */
    public char[] legSecurityExchange();
    /* LegSecurityExchange = 616 */
    public boolean hasLegSecurityExchange();
    /* LegSecurityExchange = 616 */
    public int legSecurityExchangeLength();
    /* LegSecurityExchange = 616 */
    public AsciiSequenceView legSecurityExchange(AsciiSequenceView view);
    /* LegIssuer = 617 */
    public char[] legIssuer();
    /* LegIssuer = 617 */
    public boolean hasLegIssuer();
    /* LegIssuer = 617 */
    public int legIssuerLength();
    /* LegIssuer = 617 */
    public AsciiSequenceView legIssuer(AsciiSequenceView view);
    /* EncodedLegIssuerLen = 618 */
    public int encodedLegIssuerLen();
    /* EncodedLegIssuerLen = 618 */
    public boolean hasEncodedLegIssuerLen();
    /* EncodedLegIssuer = 619 */
    public byte[] encodedLegIssuer();
    /* EncodedLegIssuer = 619 */
    public boolean hasEncodedLegIssuer();
    /* LegSecurityDesc = 620 */
    public char[] legSecurityDesc();
    /* LegSecurityDesc = 620 */
    public boolean hasLegSecurityDesc();
    /* LegSecurityDesc = 620 */
    public int legSecurityDescLength();
    /* LegSecurityDesc = 620 */
    public AsciiSequenceView legSecurityDesc(AsciiSequenceView view);
    /* EncodedLegSecurityDescLen = 621 */
    public int encodedLegSecurityDescLen();
    /* EncodedLegSecurityDescLen = 621 */
    public boolean hasEncodedLegSecurityDescLen();
    /* EncodedLegSecurityDesc = 622 */
    public byte[] encodedLegSecurityDesc();
    /* EncodedLegSecurityDesc = 622 */
    public boolean hasEncodedLegSecurityDesc();
    /* LegRatioQty = 623 */
    public DecimalFloat legRatioQty();
    /* LegRatioQty = 623 */
    public boolean hasLegRatioQty();
    /* LegSide = 624 */
    public char legSide();
    /* LegSide = 624 */
    public boolean hasLegSide();
    /* LegCurrency = 556 */
    public char[] legCurrency();
    /* LegCurrency = 556 */
    public boolean hasLegCurrency();
    /* LegCurrency = 556 */
    public int legCurrencyLength();
    /* LegCurrency = 556 */
    public AsciiSequenceView legCurrency(AsciiSequenceView view);
    /* LegPool = 740 */
    public char[] legPool();
    /* LegPool = 740 */
    public boolean hasLegPool();
    /* LegPool = 740 */
    public int legPoolLength();
    /* LegPool = 740 */
    public AsciiSequenceView legPool(AsciiSequenceView view);
    /* LegDatedDate = 739 */
    public byte[] legDatedDate();
    /* LegDatedDate = 739 */
    public boolean hasLegDatedDate();
    /* LegDatedDate = 739 */
    public int legDatedDateLength();
    /* LegDatedDate = 739 */
    public AsciiSequenceView legDatedDate(AsciiSequenceView view);
    /* LegContractSettlMonth = 955 */
    public byte[] legContractSettlMonth();
    /* LegContractSettlMonth = 955 */
    public boolean hasLegContractSettlMonth();
    /* LegContractSettlMonth = 955 */
    public int legContractSettlMonthLength();
    /* LegContractSettlMonth = 955 */
    public AsciiSequenceView legContractSettlMonth(AsciiSequenceView view);
    /* LegInterestAccrualDate = 956 */
    public byte[] legInterestAccrualDate();
    /* LegInterestAccrualDate = 956 */
    public boolean hasLegInterestAccrualDate();
    /* LegInterestAccrualDate = 956 */
    public int legInterestAccrualDateLength();
    /* LegInterestAccrualDate = 956 */
    public AsciiSequenceView legInterestAccrualDate(AsciiSequenceView view);

}
