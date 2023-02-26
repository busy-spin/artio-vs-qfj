/* Generated Fix Gateway message codec */
package uk.co.real_logic.artio.builder;

import uk.co.real_logic.artio.dictionary.Generated;
import org.agrona.MutableDirectBuffer;
import org.agrona.AsciiSequenceView;
import static uk.co.real_logic.artio.dictionary.generation.CodecUtil.*;
import static uk.co.real_logic.artio.dictionary.SessionConstants.*;
import uk.co.real_logic.artio.builder.Encoder;
import uk.co.real_logic.artio.builder.HeaderEncoder;
import uk.co.real_logic.artio.builder.TrailerEncoder;
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
import org.agrona.DirectBuffer;
import org.agrona.MutableDirectBuffer;
import org.agrona.concurrent.UnsafeBuffer;
import org.agrona.AsciiSequenceView;
import static java.nio.charset.StandardCharsets.US_ASCII;
import static uk.co.real_logic.artio.builder.Validation.CODEC_VALIDATION_ENABLED;
import static uk.co.real_logic.artio.builder.RejectUnknownField.CODEC_REJECT_UNKNOWN_FIELD_ENABLED;
import static uk.co.real_logic.artio.builder.RejectUnknownEnumValue.CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED;
import uk.co.real_logic.artio.*;

@Generated("uk.co.real_logic.artio")
public class AllocationInstructionEncoder implements Encoder
{
    public long messageType()
    {
        return 74L;
    }

    public AllocationInstructionEncoder()
    {
        header.msgType("J");
    }

    private final TrailerEncoder trailer = new TrailerEncoder();

    public TrailerEncoder trailer()
    {
        return trailer;
    }

    private final HeaderEncoder header = new HeaderEncoder();

    public HeaderEncoder header()
    {
        return header;
    }

    private static final int allocIDHeaderLength = 3;
    private static final byte[] allocIDHeader = new byte[] {55, 48, (byte) '='};

    private static final int allocTransTypeHeaderLength = 3;
    private static final byte[] allocTransTypeHeader = new byte[] {55, 49, (byte) '='};

    private static final int allocTypeHeaderLength = 4;
    private static final byte[] allocTypeHeader = new byte[] {54, 50, 54, (byte) '='};

    private static final int secondaryAllocIDHeaderLength = 4;
    private static final byte[] secondaryAllocIDHeader = new byte[] {55, 57, 51, (byte) '='};

    private static final int refAllocIDHeaderLength = 3;
    private static final byte[] refAllocIDHeader = new byte[] {55, 50, (byte) '='};

    private static final int allocCancReplaceReasonHeaderLength = 4;
    private static final byte[] allocCancReplaceReasonHeader = new byte[] {55, 57, 54, (byte) '='};

    private static final int allocIntermedReqTypeHeaderLength = 4;
    private static final byte[] allocIntermedReqTypeHeader = new byte[] {56, 48, 56, (byte) '='};

    private static final int allocLinkIDHeaderLength = 4;
    private static final byte[] allocLinkIDHeader = new byte[] {49, 57, 54, (byte) '='};

    private static final int allocLinkTypeHeaderLength = 4;
    private static final byte[] allocLinkTypeHeader = new byte[] {49, 57, 55, (byte) '='};

    private static final int bookingRefIDHeaderLength = 4;
    private static final byte[] bookingRefIDHeader = new byte[] {52, 54, 54, (byte) '='};

    private static final int allocNoOrdersTypeHeaderLength = 4;
    private static final byte[] allocNoOrdersTypeHeader = new byte[] {56, 53, 55, (byte) '='};

    private static final int noOrdersGroupCounterHeaderLength = 3;
    private static final byte[] noOrdersGroupCounterHeader = new byte[] {55, 51, (byte) '='};

    private static final int noExecsGroupCounterHeaderLength = 4;
    private static final byte[] noExecsGroupCounterHeader = new byte[] {49, 50, 52, (byte) '='};

    private static final int previouslyReportedHeaderLength = 4;
    private static final byte[] previouslyReportedHeader = new byte[] {53, 55, 48, (byte) '='};

    private static final int reversalIndicatorHeaderLength = 4;
    private static final byte[] reversalIndicatorHeader = new byte[] {55, 48, 48, (byte) '='};

    private static final int matchTypeHeaderLength = 4;
    private static final byte[] matchTypeHeader = new byte[] {53, 55, 52, (byte) '='};

    private static final int sideHeaderLength = 3;
    private static final byte[] sideHeader = new byte[] {53, 52, (byte) '='};

    private static final int noUnderlyingsGroupCounterHeaderLength = 4;
    private static final byte[] noUnderlyingsGroupCounterHeader = new byte[] {55, 49, 49, (byte) '='};

    private static final int noLegsGroupCounterHeaderLength = 4;
    private static final byte[] noLegsGroupCounterHeader = new byte[] {53, 53, 53, (byte) '='};

    private static final int quantityHeaderLength = 3;
    private static final byte[] quantityHeader = new byte[] {53, 51, (byte) '='};

    private static final int qtyTypeHeaderLength = 4;
    private static final byte[] qtyTypeHeader = new byte[] {56, 53, 52, (byte) '='};

    private static final int lastMktHeaderLength = 3;
    private static final byte[] lastMktHeader = new byte[] {51, 48, (byte) '='};

    private static final int tradeOriginationDateHeaderLength = 4;
    private static final byte[] tradeOriginationDateHeader = new byte[] {50, 50, 57, (byte) '='};

    private static final int tradingSessionIDHeaderLength = 4;
    private static final byte[] tradingSessionIDHeader = new byte[] {51, 51, 54, (byte) '='};

    private static final int tradingSessionSubIDHeaderLength = 4;
    private static final byte[] tradingSessionSubIDHeader = new byte[] {54, 50, 53, (byte) '='};

    private static final int priceTypeHeaderLength = 4;
    private static final byte[] priceTypeHeader = new byte[] {52, 50, 51, (byte) '='};

    private static final int avgPxHeaderLength = 2;
    private static final byte[] avgPxHeader = new byte[] {54, (byte) '='};

    private static final int avgParPxHeaderLength = 4;
    private static final byte[] avgParPxHeader = new byte[] {56, 54, 48, (byte) '='};

    private static final int currencyHeaderLength = 3;
    private static final byte[] currencyHeader = new byte[] {49, 53, (byte) '='};

    private static final int avgPxPrecisionHeaderLength = 3;
    private static final byte[] avgPxPrecisionHeader = new byte[] {55, 52, (byte) '='};

    private static final int tradeDateHeaderLength = 3;
    private static final byte[] tradeDateHeader = new byte[] {55, 53, (byte) '='};

    private static final int transactTimeHeaderLength = 3;
    private static final byte[] transactTimeHeader = new byte[] {54, 48, (byte) '='};

    private static final int settlTypeHeaderLength = 3;
    private static final byte[] settlTypeHeader = new byte[] {54, 51, (byte) '='};

    private static final int settlDateHeaderLength = 3;
    private static final byte[] settlDateHeader = new byte[] {54, 52, (byte) '='};

    private static final int bookingTypeHeaderLength = 4;
    private static final byte[] bookingTypeHeader = new byte[] {55, 55, 53, (byte) '='};

    private static final int grossTradeAmtHeaderLength = 4;
    private static final byte[] grossTradeAmtHeader = new byte[] {51, 56, 49, (byte) '='};

    private static final int concessionHeaderLength = 4;
    private static final byte[] concessionHeader = new byte[] {50, 51, 56, (byte) '='};

    private static final int totalTakedownHeaderLength = 4;
    private static final byte[] totalTakedownHeader = new byte[] {50, 51, 55, (byte) '='};

    private static final int netMoneyHeaderLength = 4;
    private static final byte[] netMoneyHeader = new byte[] {49, 49, 56, (byte) '='};

    private static final int positionEffectHeaderLength = 3;
    private static final byte[] positionEffectHeader = new byte[] {55, 55, (byte) '='};

    private static final int autoAcceptIndicatorHeaderLength = 4;
    private static final byte[] autoAcceptIndicatorHeader = new byte[] {55, 53, 52, (byte) '='};

    private static final int textHeaderLength = 3;
    private static final byte[] textHeader = new byte[] {53, 56, (byte) '='};

    private static final int encodedTextLenHeaderLength = 4;
    private static final byte[] encodedTextLenHeader = new byte[] {51, 53, 52, (byte) '='};

    private static final int encodedTextHeaderLength = 4;
    private static final byte[] encodedTextHeader = new byte[] {51, 53, 53, (byte) '='};

    private static final int numDaysInterestHeaderLength = 4;
    private static final byte[] numDaysInterestHeader = new byte[] {49, 53, 55, (byte) '='};

    private static final int accruedInterestRateHeaderLength = 4;
    private static final byte[] accruedInterestRateHeader = new byte[] {49, 53, 56, (byte) '='};

    private static final int accruedInterestAmtHeaderLength = 4;
    private static final byte[] accruedInterestAmtHeader = new byte[] {49, 53, 57, (byte) '='};

    private static final int totalAccruedInterestAmtHeaderLength = 4;
    private static final byte[] totalAccruedInterestAmtHeader = new byte[] {53, 52, 48, (byte) '='};

    private static final int interestAtMaturityHeaderLength = 4;
    private static final byte[] interestAtMaturityHeader = new byte[] {55, 51, 56, (byte) '='};

    private static final int endAccruedInterestAmtHeaderLength = 4;
    private static final byte[] endAccruedInterestAmtHeader = new byte[] {57, 50, 48, (byte) '='};

    private static final int startCashHeaderLength = 4;
    private static final byte[] startCashHeader = new byte[] {57, 50, 49, (byte) '='};

    private static final int endCashHeaderLength = 4;
    private static final byte[] endCashHeader = new byte[] {57, 50, 50, (byte) '='};

    private static final int legalConfirmHeaderLength = 4;
    private static final byte[] legalConfirmHeader = new byte[] {54, 53, 48, (byte) '='};

    private static final int totNoAllocsHeaderLength = 4;
    private static final byte[] totNoAllocsHeader = new byte[] {56, 57, 50, (byte) '='};

    private static final int lastFragmentHeaderLength = 4;
    private static final byte[] lastFragmentHeader = new byte[] {56, 57, 51, (byte) '='};

    private static final int noAllocsGroupCounterHeaderLength = 3;
    private static final byte[] noAllocsGroupCounterHeader = new byte[] {55, 56, (byte) '='};

    private final MutableDirectBuffer allocID = new UnsafeBuffer();

    private int allocIDOffset = 0;

    private int allocIDLength = 0;

    /* AllocID = 70 */
    public AllocationInstructionEncoder allocID(final DirectBuffer value, final int offset, final int length)
    {
        allocID.wrap(value);
        allocIDOffset = offset;
        allocIDLength = length;
        return this;
    }

    /* AllocID = 70 */
    public AllocationInstructionEncoder allocID(final DirectBuffer value, final int length)
    {
        return allocID(value, 0, length);
    }

    /* AllocID = 70 */
    public AllocationInstructionEncoder allocID(final DirectBuffer value)
    {
        return allocID(value, 0, value.capacity());
    }

    /* AllocID = 70 */
    public AllocationInstructionEncoder allocID(final byte[] value, final int offset, final int length)
    {
        allocID.wrap(value);
        allocIDOffset = offset;
        allocIDLength = length;
        return this;
    }

    /* AllocID = 70 */
    public AllocationInstructionEncoder allocIDAsCopy(final byte[] value, final int offset, final int length)
    {
        copyInto(allocID, value, offset, length);
        allocIDOffset = offset;
        allocIDLength = length;
        return this;
    }

    /* AllocID = 70 */
    public AllocationInstructionEncoder allocID(final byte[] value, final int length)
    {
        return allocID(value, 0, length);
    }

    /* AllocID = 70 */
    public AllocationInstructionEncoder allocID(final byte[] value)
    {
        return allocID(value, 0, value.length);
    }

    /* AllocID = 70 */
    public boolean hasAllocID()
    {
        return allocIDLength > 0;
    }

    /* AllocID = 70 */
    public MutableDirectBuffer allocID()
    {
        return allocID;
    }

    /* AllocID = 70 */
    public String allocIDAsString()
    {
        return allocID.getStringWithoutLengthAscii(allocIDOffset, allocIDLength);
    }

    /* AllocID = 70 */
    public AllocationInstructionEncoder allocID(final CharSequence value)
    {
        toBytes(value, allocID);
        allocIDOffset = 0;
        allocIDLength = value.length();
        return this;
    }

    /* AllocID = 70 */
    public AllocationInstructionEncoder allocID(final AsciiSequenceView value)
    {
        final DirectBuffer buffer = value.buffer();
        if (buffer != null)
        {
            allocID.wrap(buffer);
            allocIDOffset = value.offset();
            allocIDLength = value.length();
        }
        return this;
    }

    /* AllocID = 70 */
    public AllocationInstructionEncoder allocID(final char[] value)
    {
        return allocID(value, 0, value.length);
    }

    /* AllocID = 70 */
    public AllocationInstructionEncoder allocID(final char[] value, final int length)
    {
        return allocID(value, 0, length);
    }

    /* AllocID = 70 */
    public AllocationInstructionEncoder allocID(final char[] value, final int offset, final int length)
    {
        toBytes(value, allocID, offset, length);
        allocIDOffset = 0;
        allocIDLength = length;
        return this;
    }

    private char allocTransType;

    private boolean hasAllocTransType;

    public boolean hasAllocTransType()
    {
        return hasAllocTransType;
    }

    /* AllocTransType = 71 */
    public AllocationInstructionEncoder allocTransType(char value)
    {
        allocTransType = value;
        hasAllocTransType = true;
        return this;
    }

    /* AllocTransType = 71 */
    public char allocTransType()
    {
        return allocTransType;
    }

    public AllocationInstructionEncoder allocTransType(AllocTransType value)
    {
        if (CODEC_VALIDATION_ENABLED)
        {
            if (value == AllocTransType.ARTIO_UNKNOWN)
            {
                throw new EncodingException("Invalid Value Field: allocTransType Value: " + value );
            }
            if (value == AllocTransType.NULL_VAL)
            {
                return this;
            }
        }
        return allocTransType(value.representation());
    }

    private int allocType;

    private boolean hasAllocType;

    public boolean hasAllocType()
    {
        return hasAllocType;
    }

    /* AllocType = 626 */
    public AllocationInstructionEncoder allocType(int value)
    {
        allocType = value;
        hasAllocType = true;
        return this;
    }

    /* AllocType = 626 */
    public int allocType()
    {
        return allocType;
    }

    public AllocationInstructionEncoder allocType(AllocType value)
    {
        if (CODEC_VALIDATION_ENABLED)
        {
            if (value == AllocType.ARTIO_UNKNOWN)
            {
                throw new EncodingException("Invalid Value Field: allocType Value: " + value );
            }
            if (value == AllocType.NULL_VAL)
            {
                return this;
            }
        }
        return allocType(value.representation());
    }

    private final MutableDirectBuffer secondaryAllocID = new UnsafeBuffer();

    private int secondaryAllocIDOffset = 0;

    private int secondaryAllocIDLength = 0;

    /* SecondaryAllocID = 793 */
    public AllocationInstructionEncoder secondaryAllocID(final DirectBuffer value, final int offset, final int length)
    {
        secondaryAllocID.wrap(value);
        secondaryAllocIDOffset = offset;
        secondaryAllocIDLength = length;
        return this;
    }

    /* SecondaryAllocID = 793 */
    public AllocationInstructionEncoder secondaryAllocID(final DirectBuffer value, final int length)
    {
        return secondaryAllocID(value, 0, length);
    }

    /* SecondaryAllocID = 793 */
    public AllocationInstructionEncoder secondaryAllocID(final DirectBuffer value)
    {
        return secondaryAllocID(value, 0, value.capacity());
    }

    /* SecondaryAllocID = 793 */
    public AllocationInstructionEncoder secondaryAllocID(final byte[] value, final int offset, final int length)
    {
        secondaryAllocID.wrap(value);
        secondaryAllocIDOffset = offset;
        secondaryAllocIDLength = length;
        return this;
    }

    /* SecondaryAllocID = 793 */
    public AllocationInstructionEncoder secondaryAllocIDAsCopy(final byte[] value, final int offset, final int length)
    {
        copyInto(secondaryAllocID, value, offset, length);
        secondaryAllocIDOffset = offset;
        secondaryAllocIDLength = length;
        return this;
    }

    /* SecondaryAllocID = 793 */
    public AllocationInstructionEncoder secondaryAllocID(final byte[] value, final int length)
    {
        return secondaryAllocID(value, 0, length);
    }

    /* SecondaryAllocID = 793 */
    public AllocationInstructionEncoder secondaryAllocID(final byte[] value)
    {
        return secondaryAllocID(value, 0, value.length);
    }

    /* SecondaryAllocID = 793 */
    public boolean hasSecondaryAllocID()
    {
        return secondaryAllocIDLength > 0;
    }

    /* SecondaryAllocID = 793 */
    public MutableDirectBuffer secondaryAllocID()
    {
        return secondaryAllocID;
    }

    /* SecondaryAllocID = 793 */
    public String secondaryAllocIDAsString()
    {
        return secondaryAllocID.getStringWithoutLengthAscii(secondaryAllocIDOffset, secondaryAllocIDLength);
    }

    /* SecondaryAllocID = 793 */
    public AllocationInstructionEncoder secondaryAllocID(final CharSequence value)
    {
        toBytes(value, secondaryAllocID);
        secondaryAllocIDOffset = 0;
        secondaryAllocIDLength = value.length();
        return this;
    }

    /* SecondaryAllocID = 793 */
    public AllocationInstructionEncoder secondaryAllocID(final AsciiSequenceView value)
    {
        final DirectBuffer buffer = value.buffer();
        if (buffer != null)
        {
            secondaryAllocID.wrap(buffer);
            secondaryAllocIDOffset = value.offset();
            secondaryAllocIDLength = value.length();
        }
        return this;
    }

    /* SecondaryAllocID = 793 */
    public AllocationInstructionEncoder secondaryAllocID(final char[] value)
    {
        return secondaryAllocID(value, 0, value.length);
    }

    /* SecondaryAllocID = 793 */
    public AllocationInstructionEncoder secondaryAllocID(final char[] value, final int length)
    {
        return secondaryAllocID(value, 0, length);
    }

    /* SecondaryAllocID = 793 */
    public AllocationInstructionEncoder secondaryAllocID(final char[] value, final int offset, final int length)
    {
        toBytes(value, secondaryAllocID, offset, length);
        secondaryAllocIDOffset = 0;
        secondaryAllocIDLength = length;
        return this;
    }

    private final MutableDirectBuffer refAllocID = new UnsafeBuffer();

    private int refAllocIDOffset = 0;

    private int refAllocIDLength = 0;

    /* RefAllocID = 72 */
    public AllocationInstructionEncoder refAllocID(final DirectBuffer value, final int offset, final int length)
    {
        refAllocID.wrap(value);
        refAllocIDOffset = offset;
        refAllocIDLength = length;
        return this;
    }

    /* RefAllocID = 72 */
    public AllocationInstructionEncoder refAllocID(final DirectBuffer value, final int length)
    {
        return refAllocID(value, 0, length);
    }

    /* RefAllocID = 72 */
    public AllocationInstructionEncoder refAllocID(final DirectBuffer value)
    {
        return refAllocID(value, 0, value.capacity());
    }

    /* RefAllocID = 72 */
    public AllocationInstructionEncoder refAllocID(final byte[] value, final int offset, final int length)
    {
        refAllocID.wrap(value);
        refAllocIDOffset = offset;
        refAllocIDLength = length;
        return this;
    }

    /* RefAllocID = 72 */
    public AllocationInstructionEncoder refAllocIDAsCopy(final byte[] value, final int offset, final int length)
    {
        copyInto(refAllocID, value, offset, length);
        refAllocIDOffset = offset;
        refAllocIDLength = length;
        return this;
    }

    /* RefAllocID = 72 */
    public AllocationInstructionEncoder refAllocID(final byte[] value, final int length)
    {
        return refAllocID(value, 0, length);
    }

    /* RefAllocID = 72 */
    public AllocationInstructionEncoder refAllocID(final byte[] value)
    {
        return refAllocID(value, 0, value.length);
    }

    /* RefAllocID = 72 */
    public boolean hasRefAllocID()
    {
        return refAllocIDLength > 0;
    }

    /* RefAllocID = 72 */
    public MutableDirectBuffer refAllocID()
    {
        return refAllocID;
    }

    /* RefAllocID = 72 */
    public String refAllocIDAsString()
    {
        return refAllocID.getStringWithoutLengthAscii(refAllocIDOffset, refAllocIDLength);
    }

    /* RefAllocID = 72 */
    public AllocationInstructionEncoder refAllocID(final CharSequence value)
    {
        toBytes(value, refAllocID);
        refAllocIDOffset = 0;
        refAllocIDLength = value.length();
        return this;
    }

    /* RefAllocID = 72 */
    public AllocationInstructionEncoder refAllocID(final AsciiSequenceView value)
    {
        final DirectBuffer buffer = value.buffer();
        if (buffer != null)
        {
            refAllocID.wrap(buffer);
            refAllocIDOffset = value.offset();
            refAllocIDLength = value.length();
        }
        return this;
    }

    /* RefAllocID = 72 */
    public AllocationInstructionEncoder refAllocID(final char[] value)
    {
        return refAllocID(value, 0, value.length);
    }

    /* RefAllocID = 72 */
    public AllocationInstructionEncoder refAllocID(final char[] value, final int length)
    {
        return refAllocID(value, 0, length);
    }

    /* RefAllocID = 72 */
    public AllocationInstructionEncoder refAllocID(final char[] value, final int offset, final int length)
    {
        toBytes(value, refAllocID, offset, length);
        refAllocIDOffset = 0;
        refAllocIDLength = length;
        return this;
    }

    private int allocCancReplaceReason;

    private boolean hasAllocCancReplaceReason;

    public boolean hasAllocCancReplaceReason()
    {
        return hasAllocCancReplaceReason;
    }

    /* AllocCancReplaceReason = 796 */
    public AllocationInstructionEncoder allocCancReplaceReason(int value)
    {
        allocCancReplaceReason = value;
        hasAllocCancReplaceReason = true;
        return this;
    }

    /* AllocCancReplaceReason = 796 */
    public int allocCancReplaceReason()
    {
        return allocCancReplaceReason;
    }

    public AllocationInstructionEncoder allocCancReplaceReason(AllocCancReplaceReason value)
    {
        if (CODEC_VALIDATION_ENABLED)
        {
            if (value == AllocCancReplaceReason.ARTIO_UNKNOWN)
            {
                throw new EncodingException("Invalid Value Field: allocCancReplaceReason Value: " + value );
            }
            if (value == AllocCancReplaceReason.NULL_VAL)
            {
                return this;
            }
        }
        return allocCancReplaceReason(value.representation());
    }

    private int allocIntermedReqType;

    private boolean hasAllocIntermedReqType;

    public boolean hasAllocIntermedReqType()
    {
        return hasAllocIntermedReqType;
    }

    /* AllocIntermedReqType = 808 */
    public AllocationInstructionEncoder allocIntermedReqType(int value)
    {
        allocIntermedReqType = value;
        hasAllocIntermedReqType = true;
        return this;
    }

    /* AllocIntermedReqType = 808 */
    public int allocIntermedReqType()
    {
        return allocIntermedReqType;
    }

    public AllocationInstructionEncoder allocIntermedReqType(AllocIntermedReqType value)
    {
        if (CODEC_VALIDATION_ENABLED)
        {
            if (value == AllocIntermedReqType.ARTIO_UNKNOWN)
            {
                throw new EncodingException("Invalid Value Field: allocIntermedReqType Value: " + value );
            }
            if (value == AllocIntermedReqType.NULL_VAL)
            {
                return this;
            }
        }
        return allocIntermedReqType(value.representation());
    }

    private final MutableDirectBuffer allocLinkID = new UnsafeBuffer();

    private int allocLinkIDOffset = 0;

    private int allocLinkIDLength = 0;

    /* AllocLinkID = 196 */
    public AllocationInstructionEncoder allocLinkID(final DirectBuffer value, final int offset, final int length)
    {
        allocLinkID.wrap(value);
        allocLinkIDOffset = offset;
        allocLinkIDLength = length;
        return this;
    }

    /* AllocLinkID = 196 */
    public AllocationInstructionEncoder allocLinkID(final DirectBuffer value, final int length)
    {
        return allocLinkID(value, 0, length);
    }

    /* AllocLinkID = 196 */
    public AllocationInstructionEncoder allocLinkID(final DirectBuffer value)
    {
        return allocLinkID(value, 0, value.capacity());
    }

    /* AllocLinkID = 196 */
    public AllocationInstructionEncoder allocLinkID(final byte[] value, final int offset, final int length)
    {
        allocLinkID.wrap(value);
        allocLinkIDOffset = offset;
        allocLinkIDLength = length;
        return this;
    }

    /* AllocLinkID = 196 */
    public AllocationInstructionEncoder allocLinkIDAsCopy(final byte[] value, final int offset, final int length)
    {
        copyInto(allocLinkID, value, offset, length);
        allocLinkIDOffset = offset;
        allocLinkIDLength = length;
        return this;
    }

    /* AllocLinkID = 196 */
    public AllocationInstructionEncoder allocLinkID(final byte[] value, final int length)
    {
        return allocLinkID(value, 0, length);
    }

    /* AllocLinkID = 196 */
    public AllocationInstructionEncoder allocLinkID(final byte[] value)
    {
        return allocLinkID(value, 0, value.length);
    }

    /* AllocLinkID = 196 */
    public boolean hasAllocLinkID()
    {
        return allocLinkIDLength > 0;
    }

    /* AllocLinkID = 196 */
    public MutableDirectBuffer allocLinkID()
    {
        return allocLinkID;
    }

    /* AllocLinkID = 196 */
    public String allocLinkIDAsString()
    {
        return allocLinkID.getStringWithoutLengthAscii(allocLinkIDOffset, allocLinkIDLength);
    }

    /* AllocLinkID = 196 */
    public AllocationInstructionEncoder allocLinkID(final CharSequence value)
    {
        toBytes(value, allocLinkID);
        allocLinkIDOffset = 0;
        allocLinkIDLength = value.length();
        return this;
    }

    /* AllocLinkID = 196 */
    public AllocationInstructionEncoder allocLinkID(final AsciiSequenceView value)
    {
        final DirectBuffer buffer = value.buffer();
        if (buffer != null)
        {
            allocLinkID.wrap(buffer);
            allocLinkIDOffset = value.offset();
            allocLinkIDLength = value.length();
        }
        return this;
    }

    /* AllocLinkID = 196 */
    public AllocationInstructionEncoder allocLinkID(final char[] value)
    {
        return allocLinkID(value, 0, value.length);
    }

    /* AllocLinkID = 196 */
    public AllocationInstructionEncoder allocLinkID(final char[] value, final int length)
    {
        return allocLinkID(value, 0, length);
    }

    /* AllocLinkID = 196 */
    public AllocationInstructionEncoder allocLinkID(final char[] value, final int offset, final int length)
    {
        toBytes(value, allocLinkID, offset, length);
        allocLinkIDOffset = 0;
        allocLinkIDLength = length;
        return this;
    }

    private int allocLinkType;

    private boolean hasAllocLinkType;

    public boolean hasAllocLinkType()
    {
        return hasAllocLinkType;
    }

    /* AllocLinkType = 197 */
    public AllocationInstructionEncoder allocLinkType(int value)
    {
        allocLinkType = value;
        hasAllocLinkType = true;
        return this;
    }

    /* AllocLinkType = 197 */
    public int allocLinkType()
    {
        return allocLinkType;
    }

    public AllocationInstructionEncoder allocLinkType(AllocLinkType value)
    {
        if (CODEC_VALIDATION_ENABLED)
        {
            if (value == AllocLinkType.ARTIO_UNKNOWN)
            {
                throw new EncodingException("Invalid Value Field: allocLinkType Value: " + value );
            }
            if (value == AllocLinkType.NULL_VAL)
            {
                return this;
            }
        }
        return allocLinkType(value.representation());
    }

    private final MutableDirectBuffer bookingRefID = new UnsafeBuffer();

    private int bookingRefIDOffset = 0;

    private int bookingRefIDLength = 0;

    /* BookingRefID = 466 */
    public AllocationInstructionEncoder bookingRefID(final DirectBuffer value, final int offset, final int length)
    {
        bookingRefID.wrap(value);
        bookingRefIDOffset = offset;
        bookingRefIDLength = length;
        return this;
    }

    /* BookingRefID = 466 */
    public AllocationInstructionEncoder bookingRefID(final DirectBuffer value, final int length)
    {
        return bookingRefID(value, 0, length);
    }

    /* BookingRefID = 466 */
    public AllocationInstructionEncoder bookingRefID(final DirectBuffer value)
    {
        return bookingRefID(value, 0, value.capacity());
    }

    /* BookingRefID = 466 */
    public AllocationInstructionEncoder bookingRefID(final byte[] value, final int offset, final int length)
    {
        bookingRefID.wrap(value);
        bookingRefIDOffset = offset;
        bookingRefIDLength = length;
        return this;
    }

    /* BookingRefID = 466 */
    public AllocationInstructionEncoder bookingRefIDAsCopy(final byte[] value, final int offset, final int length)
    {
        copyInto(bookingRefID, value, offset, length);
        bookingRefIDOffset = offset;
        bookingRefIDLength = length;
        return this;
    }

    /* BookingRefID = 466 */
    public AllocationInstructionEncoder bookingRefID(final byte[] value, final int length)
    {
        return bookingRefID(value, 0, length);
    }

    /* BookingRefID = 466 */
    public AllocationInstructionEncoder bookingRefID(final byte[] value)
    {
        return bookingRefID(value, 0, value.length);
    }

    /* BookingRefID = 466 */
    public boolean hasBookingRefID()
    {
        return bookingRefIDLength > 0;
    }

    /* BookingRefID = 466 */
    public MutableDirectBuffer bookingRefID()
    {
        return bookingRefID;
    }

    /* BookingRefID = 466 */
    public String bookingRefIDAsString()
    {
        return bookingRefID.getStringWithoutLengthAscii(bookingRefIDOffset, bookingRefIDLength);
    }

    /* BookingRefID = 466 */
    public AllocationInstructionEncoder bookingRefID(final CharSequence value)
    {
        toBytes(value, bookingRefID);
        bookingRefIDOffset = 0;
        bookingRefIDLength = value.length();
        return this;
    }

    /* BookingRefID = 466 */
    public AllocationInstructionEncoder bookingRefID(final AsciiSequenceView value)
    {
        final DirectBuffer buffer = value.buffer();
        if (buffer != null)
        {
            bookingRefID.wrap(buffer);
            bookingRefIDOffset = value.offset();
            bookingRefIDLength = value.length();
        }
        return this;
    }

    /* BookingRefID = 466 */
    public AllocationInstructionEncoder bookingRefID(final char[] value)
    {
        return bookingRefID(value, 0, value.length);
    }

    /* BookingRefID = 466 */
    public AllocationInstructionEncoder bookingRefID(final char[] value, final int length)
    {
        return bookingRefID(value, 0, length);
    }

    /* BookingRefID = 466 */
    public AllocationInstructionEncoder bookingRefID(final char[] value, final int offset, final int length)
    {
        toBytes(value, bookingRefID, offset, length);
        bookingRefIDOffset = 0;
        bookingRefIDLength = length;
        return this;
    }

    private int allocNoOrdersType;

    private boolean hasAllocNoOrdersType;

    public boolean hasAllocNoOrdersType()
    {
        return hasAllocNoOrdersType;
    }

    /* AllocNoOrdersType = 857 */
    public AllocationInstructionEncoder allocNoOrdersType(int value)
    {
        allocNoOrdersType = value;
        hasAllocNoOrdersType = true;
        return this;
    }

    /* AllocNoOrdersType = 857 */
    public int allocNoOrdersType()
    {
        return allocNoOrdersType;
    }

    public AllocationInstructionEncoder allocNoOrdersType(AllocNoOrdersType value)
    {
        if (CODEC_VALIDATION_ENABLED)
        {
            if (value == AllocNoOrdersType.ARTIO_UNKNOWN)
            {
                throw new EncodingException("Invalid Value Field: allocNoOrdersType Value: " + value );
            }
            if (value == AllocNoOrdersType.NULL_VAL)
            {
                return this;
            }
        }
        return allocNoOrdersType(value.representation());
    }


@Generated("uk.co.real_logic.artio")
public static class OrdersGroupEncoder
{
    private OrdersGroupEncoder next = null;

    public OrdersGroupEncoder next()
    {
        if (next == null)
        {
            next = new OrdersGroupEncoder();
        }
        return next;
    }

    private static final int clOrdIDHeaderLength = 3;
    private static final byte[] clOrdIDHeader = new byte[] {49, 49, (byte) '='};

    private static final int orderIDHeaderLength = 3;
    private static final byte[] orderIDHeader = new byte[] {51, 55, (byte) '='};

    private static final int secondaryOrderIDHeaderLength = 4;
    private static final byte[] secondaryOrderIDHeader = new byte[] {49, 57, 56, (byte) '='};

    private static final int secondaryClOrdIDHeaderLength = 4;
    private static final byte[] secondaryClOrdIDHeader = new byte[] {53, 50, 54, (byte) '='};

    private static final int listIDHeaderLength = 3;
    private static final byte[] listIDHeader = new byte[] {54, 54, (byte) '='};

    private static final int orderQtyHeaderLength = 3;
    private static final byte[] orderQtyHeader = new byte[] {51, 56, (byte) '='};

    private static final int orderAvgPxHeaderLength = 4;
    private static final byte[] orderAvgPxHeader = new byte[] {55, 57, 57, (byte) '='};

    private static final int orderBookingQtyHeaderLength = 4;
    private static final byte[] orderBookingQtyHeader = new byte[] {56, 48, 48, (byte) '='};

    private final MutableDirectBuffer clOrdID = new UnsafeBuffer();

    private int clOrdIDOffset = 0;

    private int clOrdIDLength = 0;

    /* ClOrdID = 11 */
    public OrdersGroupEncoder clOrdID(final DirectBuffer value, final int offset, final int length)
    {
        clOrdID.wrap(value);
        clOrdIDOffset = offset;
        clOrdIDLength = length;
        return this;
    }

    /* ClOrdID = 11 */
    public OrdersGroupEncoder clOrdID(final DirectBuffer value, final int length)
    {
        return clOrdID(value, 0, length);
    }

    /* ClOrdID = 11 */
    public OrdersGroupEncoder clOrdID(final DirectBuffer value)
    {
        return clOrdID(value, 0, value.capacity());
    }

    /* ClOrdID = 11 */
    public OrdersGroupEncoder clOrdID(final byte[] value, final int offset, final int length)
    {
        clOrdID.wrap(value);
        clOrdIDOffset = offset;
        clOrdIDLength = length;
        return this;
    }

    /* ClOrdID = 11 */
    public OrdersGroupEncoder clOrdIDAsCopy(final byte[] value, final int offset, final int length)
    {
        copyInto(clOrdID, value, offset, length);
        clOrdIDOffset = offset;
        clOrdIDLength = length;
        return this;
    }

    /* ClOrdID = 11 */
    public OrdersGroupEncoder clOrdID(final byte[] value, final int length)
    {
        return clOrdID(value, 0, length);
    }

    /* ClOrdID = 11 */
    public OrdersGroupEncoder clOrdID(final byte[] value)
    {
        return clOrdID(value, 0, value.length);
    }

    /* ClOrdID = 11 */
    public boolean hasClOrdID()
    {
        return clOrdIDLength > 0;
    }

    /* ClOrdID = 11 */
    public MutableDirectBuffer clOrdID()
    {
        return clOrdID;
    }

    /* ClOrdID = 11 */
    public String clOrdIDAsString()
    {
        return clOrdID.getStringWithoutLengthAscii(clOrdIDOffset, clOrdIDLength);
    }

    /* ClOrdID = 11 */
    public OrdersGroupEncoder clOrdID(final CharSequence value)
    {
        toBytes(value, clOrdID);
        clOrdIDOffset = 0;
        clOrdIDLength = value.length();
        return this;
    }

    /* ClOrdID = 11 */
    public OrdersGroupEncoder clOrdID(final AsciiSequenceView value)
    {
        final DirectBuffer buffer = value.buffer();
        if (buffer != null)
        {
            clOrdID.wrap(buffer);
            clOrdIDOffset = value.offset();
            clOrdIDLength = value.length();
        }
        return this;
    }

    /* ClOrdID = 11 */
    public OrdersGroupEncoder clOrdID(final char[] value)
    {
        return clOrdID(value, 0, value.length);
    }

    /* ClOrdID = 11 */
    public OrdersGroupEncoder clOrdID(final char[] value, final int length)
    {
        return clOrdID(value, 0, length);
    }

    /* ClOrdID = 11 */
    public OrdersGroupEncoder clOrdID(final char[] value, final int offset, final int length)
    {
        toBytes(value, clOrdID, offset, length);
        clOrdIDOffset = 0;
        clOrdIDLength = length;
        return this;
    }

    private final MutableDirectBuffer orderID = new UnsafeBuffer();

    private int orderIDOffset = 0;

    private int orderIDLength = 0;

    /* OrderID = 37 */
    public OrdersGroupEncoder orderID(final DirectBuffer value, final int offset, final int length)
    {
        orderID.wrap(value);
        orderIDOffset = offset;
        orderIDLength = length;
        return this;
    }

    /* OrderID = 37 */
    public OrdersGroupEncoder orderID(final DirectBuffer value, final int length)
    {
        return orderID(value, 0, length);
    }

    /* OrderID = 37 */
    public OrdersGroupEncoder orderID(final DirectBuffer value)
    {
        return orderID(value, 0, value.capacity());
    }

    /* OrderID = 37 */
    public OrdersGroupEncoder orderID(final byte[] value, final int offset, final int length)
    {
        orderID.wrap(value);
        orderIDOffset = offset;
        orderIDLength = length;
        return this;
    }

    /* OrderID = 37 */
    public OrdersGroupEncoder orderIDAsCopy(final byte[] value, final int offset, final int length)
    {
        copyInto(orderID, value, offset, length);
        orderIDOffset = offset;
        orderIDLength = length;
        return this;
    }

    /* OrderID = 37 */
    public OrdersGroupEncoder orderID(final byte[] value, final int length)
    {
        return orderID(value, 0, length);
    }

    /* OrderID = 37 */
    public OrdersGroupEncoder orderID(final byte[] value)
    {
        return orderID(value, 0, value.length);
    }

    /* OrderID = 37 */
    public boolean hasOrderID()
    {
        return orderIDLength > 0;
    }

    /* OrderID = 37 */
    public MutableDirectBuffer orderID()
    {
        return orderID;
    }

    /* OrderID = 37 */
    public String orderIDAsString()
    {
        return orderID.getStringWithoutLengthAscii(orderIDOffset, orderIDLength);
    }

    /* OrderID = 37 */
    public OrdersGroupEncoder orderID(final CharSequence value)
    {
        toBytes(value, orderID);
        orderIDOffset = 0;
        orderIDLength = value.length();
        return this;
    }

    /* OrderID = 37 */
    public OrdersGroupEncoder orderID(final AsciiSequenceView value)
    {
        final DirectBuffer buffer = value.buffer();
        if (buffer != null)
        {
            orderID.wrap(buffer);
            orderIDOffset = value.offset();
            orderIDLength = value.length();
        }
        return this;
    }

    /* OrderID = 37 */
    public OrdersGroupEncoder orderID(final char[] value)
    {
        return orderID(value, 0, value.length);
    }

    /* OrderID = 37 */
    public OrdersGroupEncoder orderID(final char[] value, final int length)
    {
        return orderID(value, 0, length);
    }

    /* OrderID = 37 */
    public OrdersGroupEncoder orderID(final char[] value, final int offset, final int length)
    {
        toBytes(value, orderID, offset, length);
        orderIDOffset = 0;
        orderIDLength = length;
        return this;
    }

    private final MutableDirectBuffer secondaryOrderID = new UnsafeBuffer();

    private int secondaryOrderIDOffset = 0;

    private int secondaryOrderIDLength = 0;

    /* SecondaryOrderID = 198 */
    public OrdersGroupEncoder secondaryOrderID(final DirectBuffer value, final int offset, final int length)
    {
        secondaryOrderID.wrap(value);
        secondaryOrderIDOffset = offset;
        secondaryOrderIDLength = length;
        return this;
    }

    /* SecondaryOrderID = 198 */
    public OrdersGroupEncoder secondaryOrderID(final DirectBuffer value, final int length)
    {
        return secondaryOrderID(value, 0, length);
    }

    /* SecondaryOrderID = 198 */
    public OrdersGroupEncoder secondaryOrderID(final DirectBuffer value)
    {
        return secondaryOrderID(value, 0, value.capacity());
    }

    /* SecondaryOrderID = 198 */
    public OrdersGroupEncoder secondaryOrderID(final byte[] value, final int offset, final int length)
    {
        secondaryOrderID.wrap(value);
        secondaryOrderIDOffset = offset;
        secondaryOrderIDLength = length;
        return this;
    }

    /* SecondaryOrderID = 198 */
    public OrdersGroupEncoder secondaryOrderIDAsCopy(final byte[] value, final int offset, final int length)
    {
        copyInto(secondaryOrderID, value, offset, length);
        secondaryOrderIDOffset = offset;
        secondaryOrderIDLength = length;
        return this;
    }

    /* SecondaryOrderID = 198 */
    public OrdersGroupEncoder secondaryOrderID(final byte[] value, final int length)
    {
        return secondaryOrderID(value, 0, length);
    }

    /* SecondaryOrderID = 198 */
    public OrdersGroupEncoder secondaryOrderID(final byte[] value)
    {
        return secondaryOrderID(value, 0, value.length);
    }

    /* SecondaryOrderID = 198 */
    public boolean hasSecondaryOrderID()
    {
        return secondaryOrderIDLength > 0;
    }

    /* SecondaryOrderID = 198 */
    public MutableDirectBuffer secondaryOrderID()
    {
        return secondaryOrderID;
    }

    /* SecondaryOrderID = 198 */
    public String secondaryOrderIDAsString()
    {
        return secondaryOrderID.getStringWithoutLengthAscii(secondaryOrderIDOffset, secondaryOrderIDLength);
    }

    /* SecondaryOrderID = 198 */
    public OrdersGroupEncoder secondaryOrderID(final CharSequence value)
    {
        toBytes(value, secondaryOrderID);
        secondaryOrderIDOffset = 0;
        secondaryOrderIDLength = value.length();
        return this;
    }

    /* SecondaryOrderID = 198 */
    public OrdersGroupEncoder secondaryOrderID(final AsciiSequenceView value)
    {
        final DirectBuffer buffer = value.buffer();
        if (buffer != null)
        {
            secondaryOrderID.wrap(buffer);
            secondaryOrderIDOffset = value.offset();
            secondaryOrderIDLength = value.length();
        }
        return this;
    }

    /* SecondaryOrderID = 198 */
    public OrdersGroupEncoder secondaryOrderID(final char[] value)
    {
        return secondaryOrderID(value, 0, value.length);
    }

    /* SecondaryOrderID = 198 */
    public OrdersGroupEncoder secondaryOrderID(final char[] value, final int length)
    {
        return secondaryOrderID(value, 0, length);
    }

    /* SecondaryOrderID = 198 */
    public OrdersGroupEncoder secondaryOrderID(final char[] value, final int offset, final int length)
    {
        toBytes(value, secondaryOrderID, offset, length);
        secondaryOrderIDOffset = 0;
        secondaryOrderIDLength = length;
        return this;
    }

    private final MutableDirectBuffer secondaryClOrdID = new UnsafeBuffer();

    private int secondaryClOrdIDOffset = 0;

    private int secondaryClOrdIDLength = 0;

    /* SecondaryClOrdID = 526 */
    public OrdersGroupEncoder secondaryClOrdID(final DirectBuffer value, final int offset, final int length)
    {
        secondaryClOrdID.wrap(value);
        secondaryClOrdIDOffset = offset;
        secondaryClOrdIDLength = length;
        return this;
    }

    /* SecondaryClOrdID = 526 */
    public OrdersGroupEncoder secondaryClOrdID(final DirectBuffer value, final int length)
    {
        return secondaryClOrdID(value, 0, length);
    }

    /* SecondaryClOrdID = 526 */
    public OrdersGroupEncoder secondaryClOrdID(final DirectBuffer value)
    {
        return secondaryClOrdID(value, 0, value.capacity());
    }

    /* SecondaryClOrdID = 526 */
    public OrdersGroupEncoder secondaryClOrdID(final byte[] value, final int offset, final int length)
    {
        secondaryClOrdID.wrap(value);
        secondaryClOrdIDOffset = offset;
        secondaryClOrdIDLength = length;
        return this;
    }

    /* SecondaryClOrdID = 526 */
    public OrdersGroupEncoder secondaryClOrdIDAsCopy(final byte[] value, final int offset, final int length)
    {
        copyInto(secondaryClOrdID, value, offset, length);
        secondaryClOrdIDOffset = offset;
        secondaryClOrdIDLength = length;
        return this;
    }

    /* SecondaryClOrdID = 526 */
    public OrdersGroupEncoder secondaryClOrdID(final byte[] value, final int length)
    {
        return secondaryClOrdID(value, 0, length);
    }

    /* SecondaryClOrdID = 526 */
    public OrdersGroupEncoder secondaryClOrdID(final byte[] value)
    {
        return secondaryClOrdID(value, 0, value.length);
    }

    /* SecondaryClOrdID = 526 */
    public boolean hasSecondaryClOrdID()
    {
        return secondaryClOrdIDLength > 0;
    }

    /* SecondaryClOrdID = 526 */
    public MutableDirectBuffer secondaryClOrdID()
    {
        return secondaryClOrdID;
    }

    /* SecondaryClOrdID = 526 */
    public String secondaryClOrdIDAsString()
    {
        return secondaryClOrdID.getStringWithoutLengthAscii(secondaryClOrdIDOffset, secondaryClOrdIDLength);
    }

    /* SecondaryClOrdID = 526 */
    public OrdersGroupEncoder secondaryClOrdID(final CharSequence value)
    {
        toBytes(value, secondaryClOrdID);
        secondaryClOrdIDOffset = 0;
        secondaryClOrdIDLength = value.length();
        return this;
    }

    /* SecondaryClOrdID = 526 */
    public OrdersGroupEncoder secondaryClOrdID(final AsciiSequenceView value)
    {
        final DirectBuffer buffer = value.buffer();
        if (buffer != null)
        {
            secondaryClOrdID.wrap(buffer);
            secondaryClOrdIDOffset = value.offset();
            secondaryClOrdIDLength = value.length();
        }
        return this;
    }

    /* SecondaryClOrdID = 526 */
    public OrdersGroupEncoder secondaryClOrdID(final char[] value)
    {
        return secondaryClOrdID(value, 0, value.length);
    }

    /* SecondaryClOrdID = 526 */
    public OrdersGroupEncoder secondaryClOrdID(final char[] value, final int length)
    {
        return secondaryClOrdID(value, 0, length);
    }

    /* SecondaryClOrdID = 526 */
    public OrdersGroupEncoder secondaryClOrdID(final char[] value, final int offset, final int length)
    {
        toBytes(value, secondaryClOrdID, offset, length);
        secondaryClOrdIDOffset = 0;
        secondaryClOrdIDLength = length;
        return this;
    }

    private final MutableDirectBuffer listID = new UnsafeBuffer();

    private int listIDOffset = 0;

    private int listIDLength = 0;

    /* ListID = 66 */
    public OrdersGroupEncoder listID(final DirectBuffer value, final int offset, final int length)
    {
        listID.wrap(value);
        listIDOffset = offset;
        listIDLength = length;
        return this;
    }

    /* ListID = 66 */
    public OrdersGroupEncoder listID(final DirectBuffer value, final int length)
    {
        return listID(value, 0, length);
    }

    /* ListID = 66 */
    public OrdersGroupEncoder listID(final DirectBuffer value)
    {
        return listID(value, 0, value.capacity());
    }

    /* ListID = 66 */
    public OrdersGroupEncoder listID(final byte[] value, final int offset, final int length)
    {
        listID.wrap(value);
        listIDOffset = offset;
        listIDLength = length;
        return this;
    }

    /* ListID = 66 */
    public OrdersGroupEncoder listIDAsCopy(final byte[] value, final int offset, final int length)
    {
        copyInto(listID, value, offset, length);
        listIDOffset = offset;
        listIDLength = length;
        return this;
    }

    /* ListID = 66 */
    public OrdersGroupEncoder listID(final byte[] value, final int length)
    {
        return listID(value, 0, length);
    }

    /* ListID = 66 */
    public OrdersGroupEncoder listID(final byte[] value)
    {
        return listID(value, 0, value.length);
    }

    /* ListID = 66 */
    public boolean hasListID()
    {
        return listIDLength > 0;
    }

    /* ListID = 66 */
    public MutableDirectBuffer listID()
    {
        return listID;
    }

    /* ListID = 66 */
    public String listIDAsString()
    {
        return listID.getStringWithoutLengthAscii(listIDOffset, listIDLength);
    }

    /* ListID = 66 */
    public OrdersGroupEncoder listID(final CharSequence value)
    {
        toBytes(value, listID);
        listIDOffset = 0;
        listIDLength = value.length();
        return this;
    }

    /* ListID = 66 */
    public OrdersGroupEncoder listID(final AsciiSequenceView value)
    {
        final DirectBuffer buffer = value.buffer();
        if (buffer != null)
        {
            listID.wrap(buffer);
            listIDOffset = value.offset();
            listIDLength = value.length();
        }
        return this;
    }

    /* ListID = 66 */
    public OrdersGroupEncoder listID(final char[] value)
    {
        return listID(value, 0, value.length);
    }

    /* ListID = 66 */
    public OrdersGroupEncoder listID(final char[] value, final int length)
    {
        return listID(value, 0, length);
    }

    /* ListID = 66 */
    public OrdersGroupEncoder listID(final char[] value, final int offset, final int length)
    {
        toBytes(value, listID, offset, length);
        listIDOffset = 0;
        listIDLength = length;
        return this;
    }

    private final NestedParties2Encoder nestedParties2 = new NestedParties2Encoder();
    public NestedParties2Encoder nestedParties2()
    {
        return nestedParties2;
    }

    private final DecimalFloat orderQty = new DecimalFloat();

    private boolean hasOrderQty;

    public boolean hasOrderQty()
    {
        return hasOrderQty;
    }

    /* OrderQty = 38 */
    public OrdersGroupEncoder orderQty(ReadOnlyDecimalFloat value)
    {
        orderQty.set(value);
        hasOrderQty = true;
        return this;
    }

    /* OrderQty = 38 */
    public OrdersGroupEncoder orderQty(long value, int scale)
    {
        orderQty.set(value, scale);
        hasOrderQty = true;
        return this;
    }

    /* OrderQty = 38 */
    public DecimalFloat orderQty()
    {
        return orderQty;
    }

    private final DecimalFloat orderAvgPx = new DecimalFloat();

    private boolean hasOrderAvgPx;

    public boolean hasOrderAvgPx()
    {
        return hasOrderAvgPx;
    }

    /* OrderAvgPx = 799 */
    public OrdersGroupEncoder orderAvgPx(ReadOnlyDecimalFloat value)
    {
        orderAvgPx.set(value);
        hasOrderAvgPx = true;
        return this;
    }

    /* OrderAvgPx = 799 */
    public OrdersGroupEncoder orderAvgPx(long value, int scale)
    {
        orderAvgPx.set(value, scale);
        hasOrderAvgPx = true;
        return this;
    }

    /* OrderAvgPx = 799 */
    public DecimalFloat orderAvgPx()
    {
        return orderAvgPx;
    }

    private final DecimalFloat orderBookingQty = new DecimalFloat();

    private boolean hasOrderBookingQty;

    public boolean hasOrderBookingQty()
    {
        return hasOrderBookingQty;
    }

    /* OrderBookingQty = 800 */
    public OrdersGroupEncoder orderBookingQty(ReadOnlyDecimalFloat value)
    {
        orderBookingQty.set(value);
        hasOrderBookingQty = true;
        return this;
    }

    /* OrderBookingQty = 800 */
    public OrdersGroupEncoder orderBookingQty(long value, int scale)
    {
        orderBookingQty.set(value, scale);
        hasOrderBookingQty = true;
        return this;
    }

    /* OrderBookingQty = 800 */
    public DecimalFloat orderBookingQty()
    {
        return orderBookingQty;
    }

    public int encode(final MutableAsciiBuffer buffer, final int offset, final int remainingElements)
    {
        if (remainingElements == 0)
        {
            return 0;
        }

        int position = offset;

        if (clOrdIDLength > 0)
        {
            buffer.putBytes(position, clOrdIDHeader, 0, clOrdIDHeaderLength);
            position += clOrdIDHeaderLength;
            buffer.putBytes(position, clOrdID, clOrdIDOffset, clOrdIDLength);
            position += clOrdIDLength;
            buffer.putSeparator(position);
            position++;
        }

        if (orderIDLength > 0)
        {
            buffer.putBytes(position, orderIDHeader, 0, orderIDHeaderLength);
            position += orderIDHeaderLength;
            buffer.putBytes(position, orderID, orderIDOffset, orderIDLength);
            position += orderIDLength;
            buffer.putSeparator(position);
            position++;
        }

        if (secondaryOrderIDLength > 0)
        {
            buffer.putBytes(position, secondaryOrderIDHeader, 0, secondaryOrderIDHeaderLength);
            position += secondaryOrderIDHeaderLength;
            buffer.putBytes(position, secondaryOrderID, secondaryOrderIDOffset, secondaryOrderIDLength);
            position += secondaryOrderIDLength;
            buffer.putSeparator(position);
            position++;
        }

        if (secondaryClOrdIDLength > 0)
        {
            buffer.putBytes(position, secondaryClOrdIDHeader, 0, secondaryClOrdIDHeaderLength);
            position += secondaryClOrdIDHeaderLength;
            buffer.putBytes(position, secondaryClOrdID, secondaryClOrdIDOffset, secondaryClOrdIDLength);
            position += secondaryClOrdIDLength;
            buffer.putSeparator(position);
            position++;
        }

        if (listIDLength > 0)
        {
            buffer.putBytes(position, listIDHeader, 0, listIDHeaderLength);
            position += listIDHeaderLength;
            buffer.putBytes(position, listID, listIDOffset, listIDLength);
            position += listIDLength;
            buffer.putSeparator(position);
            position++;
        }

            position += nestedParties2.encode(buffer, position);

        if (hasOrderQty)
        {
            buffer.putBytes(position, orderQtyHeader, 0, orderQtyHeaderLength);
            position += orderQtyHeaderLength;
            position += buffer.putFloatAscii(position, orderQty);
            buffer.putSeparator(position);
            position++;
        }

        if (hasOrderAvgPx)
        {
            buffer.putBytes(position, orderAvgPxHeader, 0, orderAvgPxHeaderLength);
            position += orderAvgPxHeaderLength;
            position += buffer.putFloatAscii(position, orderAvgPx);
            buffer.putSeparator(position);
            position++;
        }

        if (hasOrderBookingQty)
        {
            buffer.putBytes(position, orderBookingQtyHeader, 0, orderBookingQtyHeaderLength);
            position += orderBookingQtyHeaderLength;
            position += buffer.putFloatAscii(position, orderBookingQty);
            buffer.putSeparator(position);
            position++;
        }
        if (next != null)
        {
            position += next.encode(buffer, position, remainingElements - 1);
        }
        return position - offset;
    }

    public void reset()
    {
        this.resetClOrdID();
        this.resetOrderID();
        this.resetSecondaryOrderID();
        this.resetSecondaryClOrdID();
        this.resetListID();
        this.resetOrderQty();
        this.resetOrderAvgPx();
        this.resetOrderBookingQty();
        nestedParties2.reset();
        if (next != null)        {
            next.reset();
        }
    }

    public void resetClOrdID()
    {
        clOrdIDLength = 0;
    }

    public void resetOrderID()
    {
        orderIDLength = 0;
    }

    public void resetSecondaryOrderID()
    {
        secondaryOrderIDLength = 0;
    }

    public void resetSecondaryClOrdID()
    {
        secondaryClOrdIDLength = 0;
    }

    public void resetListID()
    {
        listIDLength = 0;
    }

    public void resetOrderQty()
    {
        hasOrderQty = false;
    }

    public void resetOrderAvgPx()
    {
        hasOrderAvgPx = false;
    }

    public void resetOrderBookingQty()
    {
        hasOrderBookingQty = false;
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
        builder.append("\"MessageName\": \"OrdersGroup\",\n");
        if (hasClOrdID())
        {
            indent(builder, level);
            builder.append("\"ClOrdID\": \"");
            appendBuffer(builder, clOrdID, clOrdIDOffset, clOrdIDLength);
            builder.append("\",\n");
        }

        if (hasOrderID())
        {
            indent(builder, level);
            builder.append("\"OrderID\": \"");
            appendBuffer(builder, orderID, orderIDOffset, orderIDLength);
            builder.append("\",\n");
        }

        if (hasSecondaryOrderID())
        {
            indent(builder, level);
            builder.append("\"SecondaryOrderID\": \"");
            appendBuffer(builder, secondaryOrderID, secondaryOrderIDOffset, secondaryOrderIDLength);
            builder.append("\",\n");
        }

        if (hasSecondaryClOrdID())
        {
            indent(builder, level);
            builder.append("\"SecondaryClOrdID\": \"");
            appendBuffer(builder, secondaryClOrdID, secondaryClOrdIDOffset, secondaryClOrdIDLength);
            builder.append("\",\n");
        }

        if (hasListID())
        {
            indent(builder, level);
            builder.append("\"ListID\": \"");
            appendBuffer(builder, listID, listIDOffset, listIDLength);
            builder.append("\",\n");
        }

    indent(builder, level);
    builder.append("\"NestedParties2\": ");
    nestedParties2.appendTo(builder, level + 1);
    builder.append("\n");

        if (hasOrderQty())
        {
            indent(builder, level);
            builder.append("\"OrderQty\": \"");
            orderQty.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasOrderAvgPx())
        {
            indent(builder, level);
            builder.append("\"OrderAvgPx\": \"");
            orderAvgPx.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasOrderBookingQty())
        {
            indent(builder, level);
            builder.append("\"OrderBookingQty\": \"");
            orderBookingQty.appendTo(builder);
            builder.append("\",\n");
        }
        indent(builder, level - 1);
        builder.append("}");
        return builder;
    }

    /**
     * {@inheritDoc}
     */
    public OrdersGroupEncoder copyTo(final Encoder encoder)
    {
        return copyTo((OrdersGroupEncoder)encoder);
    }

    public OrdersGroupEncoder copyTo(final OrdersGroupEncoder encoder)
    {
        encoder.reset();
        if (hasClOrdID())
        {
            encoder.clOrdIDAsCopy(clOrdID.byteArray(), 0, clOrdIDLength);
        }

        if (hasOrderID())
        {
            encoder.orderIDAsCopy(orderID.byteArray(), 0, orderIDLength);
        }

        if (hasSecondaryOrderID())
        {
            encoder.secondaryOrderIDAsCopy(secondaryOrderID.byteArray(), 0, secondaryOrderIDLength);
        }

        if (hasSecondaryClOrdID())
        {
            encoder.secondaryClOrdIDAsCopy(secondaryClOrdID.byteArray(), 0, secondaryClOrdIDLength);
        }

        if (hasListID())
        {
            encoder.listIDAsCopy(listID.byteArray(), 0, listIDLength);
        }


        nestedParties2.copyTo(encoder.nestedParties2());
        if (hasOrderQty())
        {
            encoder.orderQty(this.orderQty());
        }

        if (hasOrderAvgPx())
        {
            encoder.orderAvgPx(this.orderAvgPx());
        }

        if (hasOrderBookingQty())
        {
            encoder.orderBookingQty(this.orderBookingQty());
        }
        return encoder;
    }

}
    private int noOrdersGroupCounter;

    private boolean hasNoOrdersGroupCounter;

    public boolean hasNoOrdersGroupCounter()
    {
        return hasNoOrdersGroupCounter;
    }

    /* NoOrdersGroupCounter = 73 */
    public AllocationInstructionEncoder noOrdersGroupCounter(int value)
    {
        noOrdersGroupCounter = value;
        hasNoOrdersGroupCounter = true;
        return this;
    }

    /* NoOrdersGroupCounter = 73 */
    public int noOrdersGroupCounter()
    {
        return noOrdersGroupCounter;
    }


    private OrdersGroupEncoder ordersGroup = null;

    public OrdersGroupEncoder ordersGroup(final int numberOfElements)
    {
        hasNoOrdersGroupCounter = true;
        noOrdersGroupCounter = numberOfElements;
        if (ordersGroup == null)
        {
            ordersGroup = new OrdersGroupEncoder();
        }
        return ordersGroup;
    }


@Generated("uk.co.real_logic.artio")
public static class ExecsGroupEncoder
{
    private ExecsGroupEncoder next = null;

    public ExecsGroupEncoder next()
    {
        if (next == null)
        {
            next = new ExecsGroupEncoder();
        }
        return next;
    }

    private static final int lastQtyHeaderLength = 3;
    private static final byte[] lastQtyHeader = new byte[] {51, 50, (byte) '='};

    private static final int execIDHeaderLength = 3;
    private static final byte[] execIDHeader = new byte[] {49, 55, (byte) '='};

    private static final int secondaryExecIDHeaderLength = 4;
    private static final byte[] secondaryExecIDHeader = new byte[] {53, 50, 55, (byte) '='};

    private static final int lastPxHeaderLength = 3;
    private static final byte[] lastPxHeader = new byte[] {51, 49, (byte) '='};

    private static final int lastParPxHeaderLength = 4;
    private static final byte[] lastParPxHeader = new byte[] {54, 54, 57, (byte) '='};

    private static final int lastCapacityHeaderLength = 3;
    private static final byte[] lastCapacityHeader = new byte[] {50, 57, (byte) '='};

    private final DecimalFloat lastQty = new DecimalFloat();

    private boolean hasLastQty;

    public boolean hasLastQty()
    {
        return hasLastQty;
    }

    /* LastQty = 32 */
    public ExecsGroupEncoder lastQty(ReadOnlyDecimalFloat value)
    {
        lastQty.set(value);
        hasLastQty = true;
        return this;
    }

    /* LastQty = 32 */
    public ExecsGroupEncoder lastQty(long value, int scale)
    {
        lastQty.set(value, scale);
        hasLastQty = true;
        return this;
    }

    /* LastQty = 32 */
    public DecimalFloat lastQty()
    {
        return lastQty;
    }

    private final MutableDirectBuffer execID = new UnsafeBuffer();

    private int execIDOffset = 0;

    private int execIDLength = 0;

    /* ExecID = 17 */
    public ExecsGroupEncoder execID(final DirectBuffer value, final int offset, final int length)
    {
        execID.wrap(value);
        execIDOffset = offset;
        execIDLength = length;
        return this;
    }

    /* ExecID = 17 */
    public ExecsGroupEncoder execID(final DirectBuffer value, final int length)
    {
        return execID(value, 0, length);
    }

    /* ExecID = 17 */
    public ExecsGroupEncoder execID(final DirectBuffer value)
    {
        return execID(value, 0, value.capacity());
    }

    /* ExecID = 17 */
    public ExecsGroupEncoder execID(final byte[] value, final int offset, final int length)
    {
        execID.wrap(value);
        execIDOffset = offset;
        execIDLength = length;
        return this;
    }

    /* ExecID = 17 */
    public ExecsGroupEncoder execIDAsCopy(final byte[] value, final int offset, final int length)
    {
        copyInto(execID, value, offset, length);
        execIDOffset = offset;
        execIDLength = length;
        return this;
    }

    /* ExecID = 17 */
    public ExecsGroupEncoder execID(final byte[] value, final int length)
    {
        return execID(value, 0, length);
    }

    /* ExecID = 17 */
    public ExecsGroupEncoder execID(final byte[] value)
    {
        return execID(value, 0, value.length);
    }

    /* ExecID = 17 */
    public boolean hasExecID()
    {
        return execIDLength > 0;
    }

    /* ExecID = 17 */
    public MutableDirectBuffer execID()
    {
        return execID;
    }

    /* ExecID = 17 */
    public String execIDAsString()
    {
        return execID.getStringWithoutLengthAscii(execIDOffset, execIDLength);
    }

    /* ExecID = 17 */
    public ExecsGroupEncoder execID(final CharSequence value)
    {
        toBytes(value, execID);
        execIDOffset = 0;
        execIDLength = value.length();
        return this;
    }

    /* ExecID = 17 */
    public ExecsGroupEncoder execID(final AsciiSequenceView value)
    {
        final DirectBuffer buffer = value.buffer();
        if (buffer != null)
        {
            execID.wrap(buffer);
            execIDOffset = value.offset();
            execIDLength = value.length();
        }
        return this;
    }

    /* ExecID = 17 */
    public ExecsGroupEncoder execID(final char[] value)
    {
        return execID(value, 0, value.length);
    }

    /* ExecID = 17 */
    public ExecsGroupEncoder execID(final char[] value, final int length)
    {
        return execID(value, 0, length);
    }

    /* ExecID = 17 */
    public ExecsGroupEncoder execID(final char[] value, final int offset, final int length)
    {
        toBytes(value, execID, offset, length);
        execIDOffset = 0;
        execIDLength = length;
        return this;
    }

    private final MutableDirectBuffer secondaryExecID = new UnsafeBuffer();

    private int secondaryExecIDOffset = 0;

    private int secondaryExecIDLength = 0;

    /* SecondaryExecID = 527 */
    public ExecsGroupEncoder secondaryExecID(final DirectBuffer value, final int offset, final int length)
    {
        secondaryExecID.wrap(value);
        secondaryExecIDOffset = offset;
        secondaryExecIDLength = length;
        return this;
    }

    /* SecondaryExecID = 527 */
    public ExecsGroupEncoder secondaryExecID(final DirectBuffer value, final int length)
    {
        return secondaryExecID(value, 0, length);
    }

    /* SecondaryExecID = 527 */
    public ExecsGroupEncoder secondaryExecID(final DirectBuffer value)
    {
        return secondaryExecID(value, 0, value.capacity());
    }

    /* SecondaryExecID = 527 */
    public ExecsGroupEncoder secondaryExecID(final byte[] value, final int offset, final int length)
    {
        secondaryExecID.wrap(value);
        secondaryExecIDOffset = offset;
        secondaryExecIDLength = length;
        return this;
    }

    /* SecondaryExecID = 527 */
    public ExecsGroupEncoder secondaryExecIDAsCopy(final byte[] value, final int offset, final int length)
    {
        copyInto(secondaryExecID, value, offset, length);
        secondaryExecIDOffset = offset;
        secondaryExecIDLength = length;
        return this;
    }

    /* SecondaryExecID = 527 */
    public ExecsGroupEncoder secondaryExecID(final byte[] value, final int length)
    {
        return secondaryExecID(value, 0, length);
    }

    /* SecondaryExecID = 527 */
    public ExecsGroupEncoder secondaryExecID(final byte[] value)
    {
        return secondaryExecID(value, 0, value.length);
    }

    /* SecondaryExecID = 527 */
    public boolean hasSecondaryExecID()
    {
        return secondaryExecIDLength > 0;
    }

    /* SecondaryExecID = 527 */
    public MutableDirectBuffer secondaryExecID()
    {
        return secondaryExecID;
    }

    /* SecondaryExecID = 527 */
    public String secondaryExecIDAsString()
    {
        return secondaryExecID.getStringWithoutLengthAscii(secondaryExecIDOffset, secondaryExecIDLength);
    }

    /* SecondaryExecID = 527 */
    public ExecsGroupEncoder secondaryExecID(final CharSequence value)
    {
        toBytes(value, secondaryExecID);
        secondaryExecIDOffset = 0;
        secondaryExecIDLength = value.length();
        return this;
    }

    /* SecondaryExecID = 527 */
    public ExecsGroupEncoder secondaryExecID(final AsciiSequenceView value)
    {
        final DirectBuffer buffer = value.buffer();
        if (buffer != null)
        {
            secondaryExecID.wrap(buffer);
            secondaryExecIDOffset = value.offset();
            secondaryExecIDLength = value.length();
        }
        return this;
    }

    /* SecondaryExecID = 527 */
    public ExecsGroupEncoder secondaryExecID(final char[] value)
    {
        return secondaryExecID(value, 0, value.length);
    }

    /* SecondaryExecID = 527 */
    public ExecsGroupEncoder secondaryExecID(final char[] value, final int length)
    {
        return secondaryExecID(value, 0, length);
    }

    /* SecondaryExecID = 527 */
    public ExecsGroupEncoder secondaryExecID(final char[] value, final int offset, final int length)
    {
        toBytes(value, secondaryExecID, offset, length);
        secondaryExecIDOffset = 0;
        secondaryExecIDLength = length;
        return this;
    }

    private final DecimalFloat lastPx = new DecimalFloat();

    private boolean hasLastPx;

    public boolean hasLastPx()
    {
        return hasLastPx;
    }

    /* LastPx = 31 */
    public ExecsGroupEncoder lastPx(ReadOnlyDecimalFloat value)
    {
        lastPx.set(value);
        hasLastPx = true;
        return this;
    }

    /* LastPx = 31 */
    public ExecsGroupEncoder lastPx(long value, int scale)
    {
        lastPx.set(value, scale);
        hasLastPx = true;
        return this;
    }

    /* LastPx = 31 */
    public DecimalFloat lastPx()
    {
        return lastPx;
    }

    private final DecimalFloat lastParPx = new DecimalFloat();

    private boolean hasLastParPx;

    public boolean hasLastParPx()
    {
        return hasLastParPx;
    }

    /* LastParPx = 669 */
    public ExecsGroupEncoder lastParPx(ReadOnlyDecimalFloat value)
    {
        lastParPx.set(value);
        hasLastParPx = true;
        return this;
    }

    /* LastParPx = 669 */
    public ExecsGroupEncoder lastParPx(long value, int scale)
    {
        lastParPx.set(value, scale);
        hasLastParPx = true;
        return this;
    }

    /* LastParPx = 669 */
    public DecimalFloat lastParPx()
    {
        return lastParPx;
    }

    private char lastCapacity;

    private boolean hasLastCapacity;

    public boolean hasLastCapacity()
    {
        return hasLastCapacity;
    }

    /* LastCapacity = 29 */
    public ExecsGroupEncoder lastCapacity(char value)
    {
        lastCapacity = value;
        hasLastCapacity = true;
        return this;
    }

    /* LastCapacity = 29 */
    public char lastCapacity()
    {
        return lastCapacity;
    }

    public ExecsGroupEncoder lastCapacity(LastCapacity value)
    {
        if (CODEC_VALIDATION_ENABLED)
        {
            if (value == LastCapacity.ARTIO_UNKNOWN)
            {
                throw new EncodingException("Invalid Value Field: lastCapacity Value: " + value );
            }
            if (value == LastCapacity.NULL_VAL)
            {
                return this;
            }
        }
        return lastCapacity(value.representation());
    }

    public int encode(final MutableAsciiBuffer buffer, final int offset, final int remainingElements)
    {
        if (remainingElements == 0)
        {
            return 0;
        }

        int position = offset;

        if (hasLastQty)
        {
            buffer.putBytes(position, lastQtyHeader, 0, lastQtyHeaderLength);
            position += lastQtyHeaderLength;
            position += buffer.putFloatAscii(position, lastQty);
            buffer.putSeparator(position);
            position++;
        }

        if (execIDLength > 0)
        {
            buffer.putBytes(position, execIDHeader, 0, execIDHeaderLength);
            position += execIDHeaderLength;
            buffer.putBytes(position, execID, execIDOffset, execIDLength);
            position += execIDLength;
            buffer.putSeparator(position);
            position++;
        }

        if (secondaryExecIDLength > 0)
        {
            buffer.putBytes(position, secondaryExecIDHeader, 0, secondaryExecIDHeaderLength);
            position += secondaryExecIDHeaderLength;
            buffer.putBytes(position, secondaryExecID, secondaryExecIDOffset, secondaryExecIDLength);
            position += secondaryExecIDLength;
            buffer.putSeparator(position);
            position++;
        }

        if (hasLastPx)
        {
            buffer.putBytes(position, lastPxHeader, 0, lastPxHeaderLength);
            position += lastPxHeaderLength;
            position += buffer.putFloatAscii(position, lastPx);
            buffer.putSeparator(position);
            position++;
        }

        if (hasLastParPx)
        {
            buffer.putBytes(position, lastParPxHeader, 0, lastParPxHeaderLength);
            position += lastParPxHeaderLength;
            position += buffer.putFloatAscii(position, lastParPx);
            buffer.putSeparator(position);
            position++;
        }

        if (hasLastCapacity)
        {
            buffer.putBytes(position, lastCapacityHeader, 0, lastCapacityHeaderLength);
            position += lastCapacityHeaderLength;
            position += buffer.putCharAscii(position, lastCapacity);
            buffer.putSeparator(position);
            position++;
        }
        if (next != null)
        {
            position += next.encode(buffer, position, remainingElements - 1);
        }
        return position - offset;
    }

    public void reset()
    {
        this.resetLastQty();
        this.resetExecID();
        this.resetSecondaryExecID();
        this.resetLastPx();
        this.resetLastParPx();
        this.resetLastCapacity();
        if (next != null)        {
            next.reset();
        }
    }

    public void resetLastQty()
    {
        hasLastQty = false;
    }

    public void resetExecID()
    {
        execIDLength = 0;
    }

    public void resetSecondaryExecID()
    {
        secondaryExecIDLength = 0;
    }

    public void resetLastPx()
    {
        hasLastPx = false;
    }

    public void resetLastParPx()
    {
        hasLastParPx = false;
    }

    public void resetLastCapacity()
    {
        hasLastCapacity = false;
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
        builder.append("\"MessageName\": \"ExecsGroup\",\n");
        if (hasLastQty())
        {
            indent(builder, level);
            builder.append("\"LastQty\": \"");
            lastQty.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasExecID())
        {
            indent(builder, level);
            builder.append("\"ExecID\": \"");
            appendBuffer(builder, execID, execIDOffset, execIDLength);
            builder.append("\",\n");
        }

        if (hasSecondaryExecID())
        {
            indent(builder, level);
            builder.append("\"SecondaryExecID\": \"");
            appendBuffer(builder, secondaryExecID, secondaryExecIDOffset, secondaryExecIDLength);
            builder.append("\",\n");
        }

        if (hasLastPx())
        {
            indent(builder, level);
            builder.append("\"LastPx\": \"");
            lastPx.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasLastParPx())
        {
            indent(builder, level);
            builder.append("\"LastParPx\": \"");
            lastParPx.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasLastCapacity())
        {
            indent(builder, level);
            builder.append("\"LastCapacity\": \"");
            builder.append(lastCapacity);
            builder.append("\",\n");
        }
        indent(builder, level - 1);
        builder.append("}");
        return builder;
    }

    /**
     * {@inheritDoc}
     */
    public ExecsGroupEncoder copyTo(final Encoder encoder)
    {
        return copyTo((ExecsGroupEncoder)encoder);
    }

    public ExecsGroupEncoder copyTo(final ExecsGroupEncoder encoder)
    {
        encoder.reset();
        if (hasLastQty())
        {
            encoder.lastQty(this.lastQty());
        }

        if (hasExecID())
        {
            encoder.execIDAsCopy(execID.byteArray(), 0, execIDLength);
        }

        if (hasSecondaryExecID())
        {
            encoder.secondaryExecIDAsCopy(secondaryExecID.byteArray(), 0, secondaryExecIDLength);
        }

        if (hasLastPx())
        {
            encoder.lastPx(this.lastPx());
        }

        if (hasLastParPx())
        {
            encoder.lastParPx(this.lastParPx());
        }

        if (hasLastCapacity())
        {
            encoder.lastCapacity(this.lastCapacity());
        }
        return encoder;
    }

}
    private int noExecsGroupCounter;

    private boolean hasNoExecsGroupCounter;

    public boolean hasNoExecsGroupCounter()
    {
        return hasNoExecsGroupCounter;
    }

    /* NoExecsGroupCounter = 124 */
    public AllocationInstructionEncoder noExecsGroupCounter(int value)
    {
        noExecsGroupCounter = value;
        hasNoExecsGroupCounter = true;
        return this;
    }

    /* NoExecsGroupCounter = 124 */
    public int noExecsGroupCounter()
    {
        return noExecsGroupCounter;
    }


    private ExecsGroupEncoder execsGroup = null;

    public ExecsGroupEncoder execsGroup(final int numberOfElements)
    {
        hasNoExecsGroupCounter = true;
        noExecsGroupCounter = numberOfElements;
        if (execsGroup == null)
        {
            execsGroup = new ExecsGroupEncoder();
        }
        return execsGroup;
    }

    private boolean previouslyReported;

    private boolean hasPreviouslyReported;

    public boolean hasPreviouslyReported()
    {
        return hasPreviouslyReported;
    }

    /* PreviouslyReported = 570 */
    public AllocationInstructionEncoder previouslyReported(boolean value)
    {
        previouslyReported = value;
        hasPreviouslyReported = true;
        return this;
    }

    /* PreviouslyReported = 570 */
    public boolean previouslyReported()
    {
        return previouslyReported;
    }

    private boolean reversalIndicator;

    private boolean hasReversalIndicator;

    public boolean hasReversalIndicator()
    {
        return hasReversalIndicator;
    }

    /* ReversalIndicator = 700 */
    public AllocationInstructionEncoder reversalIndicator(boolean value)
    {
        reversalIndicator = value;
        hasReversalIndicator = true;
        return this;
    }

    /* ReversalIndicator = 700 */
    public boolean reversalIndicator()
    {
        return reversalIndicator;
    }

    private final MutableDirectBuffer matchType = new UnsafeBuffer();

    private int matchTypeOffset = 0;

    private int matchTypeLength = 0;

    /* MatchType = 574 */
    public AllocationInstructionEncoder matchType(final DirectBuffer value, final int offset, final int length)
    {
        matchType.wrap(value);
        matchTypeOffset = offset;
        matchTypeLength = length;
        return this;
    }

    /* MatchType = 574 */
    public AllocationInstructionEncoder matchType(final DirectBuffer value, final int length)
    {
        return matchType(value, 0, length);
    }

    /* MatchType = 574 */
    public AllocationInstructionEncoder matchType(final DirectBuffer value)
    {
        return matchType(value, 0, value.capacity());
    }

    /* MatchType = 574 */
    public AllocationInstructionEncoder matchType(final byte[] value, final int offset, final int length)
    {
        matchType.wrap(value);
        matchTypeOffset = offset;
        matchTypeLength = length;
        return this;
    }

    /* MatchType = 574 */
    public AllocationInstructionEncoder matchTypeAsCopy(final byte[] value, final int offset, final int length)
    {
        copyInto(matchType, value, offset, length);
        matchTypeOffset = offset;
        matchTypeLength = length;
        return this;
    }

    /* MatchType = 574 */
    public AllocationInstructionEncoder matchType(final byte[] value, final int length)
    {
        return matchType(value, 0, length);
    }

    /* MatchType = 574 */
    public AllocationInstructionEncoder matchType(final byte[] value)
    {
        return matchType(value, 0, value.length);
    }

    /* MatchType = 574 */
    public boolean hasMatchType()
    {
        return matchTypeLength > 0;
    }

    /* MatchType = 574 */
    public MutableDirectBuffer matchType()
    {
        return matchType;
    }

    /* MatchType = 574 */
    public String matchTypeAsString()
    {
        return matchType.getStringWithoutLengthAscii(matchTypeOffset, matchTypeLength);
    }

    /* MatchType = 574 */
    public AllocationInstructionEncoder matchType(final CharSequence value)
    {
        toBytes(value, matchType);
        matchTypeOffset = 0;
        matchTypeLength = value.length();
        return this;
    }

    /* MatchType = 574 */
    public AllocationInstructionEncoder matchType(final AsciiSequenceView value)
    {
        final DirectBuffer buffer = value.buffer();
        if (buffer != null)
        {
            matchType.wrap(buffer);
            matchTypeOffset = value.offset();
            matchTypeLength = value.length();
        }
        return this;
    }

    /* MatchType = 574 */
    public AllocationInstructionEncoder matchType(final char[] value)
    {
        return matchType(value, 0, value.length);
    }

    /* MatchType = 574 */
    public AllocationInstructionEncoder matchType(final char[] value, final int length)
    {
        return matchType(value, 0, length);
    }

    /* MatchType = 574 */
    public AllocationInstructionEncoder matchType(final char[] value, final int offset, final int length)
    {
        toBytes(value, matchType, offset, length);
        matchTypeOffset = 0;
        matchTypeLength = length;
        return this;
    }

    private char side;

    private boolean hasSide;

    public boolean hasSide()
    {
        return hasSide;
    }

    /* Side = 54 */
    public AllocationInstructionEncoder side(char value)
    {
        side = value;
        hasSide = true;
        return this;
    }

    /* Side = 54 */
    public char side()
    {
        return side;
    }

    public AllocationInstructionEncoder side(Side value)
    {
        if (CODEC_VALIDATION_ENABLED)
        {
            if (value == Side.ARTIO_UNKNOWN)
            {
                throw new EncodingException("Invalid Value Field: side Value: " + value );
            }
            if (value == Side.NULL_VAL)
            {
                return this;
            }
        }
        return side(value.representation());
    }

    private final InstrumentEncoder instrument = new InstrumentEncoder();
    public InstrumentEncoder instrument()
    {
        return instrument;
    }

    private final InstrumentExtensionEncoder instrumentExtension = new InstrumentExtensionEncoder();
    public InstrumentExtensionEncoder instrumentExtension()
    {
        return instrumentExtension;
    }

    private final FinancingDetailsEncoder financingDetails = new FinancingDetailsEncoder();
    public FinancingDetailsEncoder financingDetails()
    {
        return financingDetails;
    }


@Generated("uk.co.real_logic.artio")
public static class UnderlyingsGroupEncoder
{
    private UnderlyingsGroupEncoder next = null;

    public UnderlyingsGroupEncoder next()
    {
        if (next == null)
        {
            next = new UnderlyingsGroupEncoder();
        }
        return next;
    }

    private final UnderlyingInstrumentEncoder underlyingInstrument = new UnderlyingInstrumentEncoder();
    public UnderlyingInstrumentEncoder underlyingInstrument()
    {
        return underlyingInstrument;
    }

    public int encode(final MutableAsciiBuffer buffer, final int offset, final int remainingElements)
    {
        if (remainingElements == 0)
        {
            return 0;
        }

        int position = offset;

            position += underlyingInstrument.encode(buffer, position);
        if (next != null)
        {
            position += next.encode(buffer, position, remainingElements - 1);
        }
        return position - offset;
    }

    public void reset()
    {
        underlyingInstrument.reset();
        if (next != null)        {
            next.reset();
        }
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
        builder.append("\"MessageName\": \"UnderlyingsGroup\",\n");
    indent(builder, level);
    builder.append("\"UnderlyingInstrument\": ");
    underlyingInstrument.appendTo(builder, level + 1);
    builder.append("\n");
        indent(builder, level - 1);
        builder.append("}");
        return builder;
    }

    /**
     * {@inheritDoc}
     */
    public UnderlyingsGroupEncoder copyTo(final Encoder encoder)
    {
        return copyTo((UnderlyingsGroupEncoder)encoder);
    }

    public UnderlyingsGroupEncoder copyTo(final UnderlyingsGroupEncoder encoder)
    {
        encoder.reset();

        underlyingInstrument.copyTo(encoder.underlyingInstrument());        return encoder;
    }

}
    private int noUnderlyingsGroupCounter;

    private boolean hasNoUnderlyingsGroupCounter;

    public boolean hasNoUnderlyingsGroupCounter()
    {
        return hasNoUnderlyingsGroupCounter;
    }

    /* NoUnderlyingsGroupCounter = 711 */
    public AllocationInstructionEncoder noUnderlyingsGroupCounter(int value)
    {
        noUnderlyingsGroupCounter = value;
        hasNoUnderlyingsGroupCounter = true;
        return this;
    }

    /* NoUnderlyingsGroupCounter = 711 */
    public int noUnderlyingsGroupCounter()
    {
        return noUnderlyingsGroupCounter;
    }


    private UnderlyingsGroupEncoder underlyingsGroup = null;

    public UnderlyingsGroupEncoder underlyingsGroup(final int numberOfElements)
    {
        hasNoUnderlyingsGroupCounter = true;
        noUnderlyingsGroupCounter = numberOfElements;
        if (underlyingsGroup == null)
        {
            underlyingsGroup = new UnderlyingsGroupEncoder();
        }
        return underlyingsGroup;
    }


@Generated("uk.co.real_logic.artio")
public static class LegsGroupEncoder
{
    private LegsGroupEncoder next = null;

    public LegsGroupEncoder next()
    {
        if (next == null)
        {
            next = new LegsGroupEncoder();
        }
        return next;
    }

    private final InstrumentLegEncoder instrumentLeg = new InstrumentLegEncoder();
    public InstrumentLegEncoder instrumentLeg()
    {
        return instrumentLeg;
    }

    public int encode(final MutableAsciiBuffer buffer, final int offset, final int remainingElements)
    {
        if (remainingElements == 0)
        {
            return 0;
        }

        int position = offset;

            position += instrumentLeg.encode(buffer, position);
        if (next != null)
        {
            position += next.encode(buffer, position, remainingElements - 1);
        }
        return position - offset;
    }

    public void reset()
    {
        instrumentLeg.reset();
        if (next != null)        {
            next.reset();
        }
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
        builder.append("\"MessageName\": \"LegsGroup\",\n");
    indent(builder, level);
    builder.append("\"InstrumentLeg\": ");
    instrumentLeg.appendTo(builder, level + 1);
    builder.append("\n");
        indent(builder, level - 1);
        builder.append("}");
        return builder;
    }

    /**
     * {@inheritDoc}
     */
    public LegsGroupEncoder copyTo(final Encoder encoder)
    {
        return copyTo((LegsGroupEncoder)encoder);
    }

    public LegsGroupEncoder copyTo(final LegsGroupEncoder encoder)
    {
        encoder.reset();

        instrumentLeg.copyTo(encoder.instrumentLeg());        return encoder;
    }

}
    private int noLegsGroupCounter;

    private boolean hasNoLegsGroupCounter;

    public boolean hasNoLegsGroupCounter()
    {
        return hasNoLegsGroupCounter;
    }

    /* NoLegsGroupCounter = 555 */
    public AllocationInstructionEncoder noLegsGroupCounter(int value)
    {
        noLegsGroupCounter = value;
        hasNoLegsGroupCounter = true;
        return this;
    }

    /* NoLegsGroupCounter = 555 */
    public int noLegsGroupCounter()
    {
        return noLegsGroupCounter;
    }


    private LegsGroupEncoder legsGroup = null;

    public LegsGroupEncoder legsGroup(final int numberOfElements)
    {
        hasNoLegsGroupCounter = true;
        noLegsGroupCounter = numberOfElements;
        if (legsGroup == null)
        {
            legsGroup = new LegsGroupEncoder();
        }
        return legsGroup;
    }

    private final DecimalFloat quantity = new DecimalFloat();

    private boolean hasQuantity;

    public boolean hasQuantity()
    {
        return hasQuantity;
    }

    /* Quantity = 53 */
    public AllocationInstructionEncoder quantity(ReadOnlyDecimalFloat value)
    {
        quantity.set(value);
        hasQuantity = true;
        return this;
    }

    /* Quantity = 53 */
    public AllocationInstructionEncoder quantity(long value, int scale)
    {
        quantity.set(value, scale);
        hasQuantity = true;
        return this;
    }

    /* Quantity = 53 */
    public DecimalFloat quantity()
    {
        return quantity;
    }

    private int qtyType;

    private boolean hasQtyType;

    public boolean hasQtyType()
    {
        return hasQtyType;
    }

    /* QtyType = 854 */
    public AllocationInstructionEncoder qtyType(int value)
    {
        qtyType = value;
        hasQtyType = true;
        return this;
    }

    /* QtyType = 854 */
    public int qtyType()
    {
        return qtyType;
    }

    public AllocationInstructionEncoder qtyType(QtyType value)
    {
        if (CODEC_VALIDATION_ENABLED)
        {
            if (value == QtyType.ARTIO_UNKNOWN)
            {
                throw new EncodingException("Invalid Value Field: qtyType Value: " + value );
            }
            if (value == QtyType.NULL_VAL)
            {
                return this;
            }
        }
        return qtyType(value.representation());
    }

    private final MutableDirectBuffer lastMkt = new UnsafeBuffer();

    private int lastMktOffset = 0;

    private int lastMktLength = 0;

    /* LastMkt = 30 */
    public AllocationInstructionEncoder lastMkt(final DirectBuffer value, final int offset, final int length)
    {
        lastMkt.wrap(value);
        lastMktOffset = offset;
        lastMktLength = length;
        return this;
    }

    /* LastMkt = 30 */
    public AllocationInstructionEncoder lastMkt(final DirectBuffer value, final int length)
    {
        return lastMkt(value, 0, length);
    }

    /* LastMkt = 30 */
    public AllocationInstructionEncoder lastMkt(final DirectBuffer value)
    {
        return lastMkt(value, 0, value.capacity());
    }

    /* LastMkt = 30 */
    public AllocationInstructionEncoder lastMkt(final byte[] value, final int offset, final int length)
    {
        lastMkt.wrap(value);
        lastMktOffset = offset;
        lastMktLength = length;
        return this;
    }

    /* LastMkt = 30 */
    public AllocationInstructionEncoder lastMktAsCopy(final byte[] value, final int offset, final int length)
    {
        copyInto(lastMkt, value, offset, length);
        lastMktOffset = offset;
        lastMktLength = length;
        return this;
    }

    /* LastMkt = 30 */
    public AllocationInstructionEncoder lastMkt(final byte[] value, final int length)
    {
        return lastMkt(value, 0, length);
    }

    /* LastMkt = 30 */
    public AllocationInstructionEncoder lastMkt(final byte[] value)
    {
        return lastMkt(value, 0, value.length);
    }

    /* LastMkt = 30 */
    public boolean hasLastMkt()
    {
        return lastMktLength > 0;
    }

    /* LastMkt = 30 */
    public MutableDirectBuffer lastMkt()
    {
        return lastMkt;
    }

    /* LastMkt = 30 */
    public String lastMktAsString()
    {
        return lastMkt.getStringWithoutLengthAscii(lastMktOffset, lastMktLength);
    }

    /* LastMkt = 30 */
    public AllocationInstructionEncoder lastMkt(final CharSequence value)
    {
        toBytes(value, lastMkt);
        lastMktOffset = 0;
        lastMktLength = value.length();
        return this;
    }

    /* LastMkt = 30 */
    public AllocationInstructionEncoder lastMkt(final AsciiSequenceView value)
    {
        final DirectBuffer buffer = value.buffer();
        if (buffer != null)
        {
            lastMkt.wrap(buffer);
            lastMktOffset = value.offset();
            lastMktLength = value.length();
        }
        return this;
    }

    /* LastMkt = 30 */
    public AllocationInstructionEncoder lastMkt(final char[] value)
    {
        return lastMkt(value, 0, value.length);
    }

    /* LastMkt = 30 */
    public AllocationInstructionEncoder lastMkt(final char[] value, final int length)
    {
        return lastMkt(value, 0, length);
    }

    /* LastMkt = 30 */
    public AllocationInstructionEncoder lastMkt(final char[] value, final int offset, final int length)
    {
        toBytes(value, lastMkt, offset, length);
        lastMktOffset = 0;
        lastMktLength = length;
        return this;
    }

    private final MutableDirectBuffer tradeOriginationDate = new UnsafeBuffer();

    private int tradeOriginationDateOffset = 0;

    private int tradeOriginationDateLength = 0;

    /* TradeOriginationDate = 229 */
    public AllocationInstructionEncoder tradeOriginationDate(final DirectBuffer value, final int offset, final int length)
    {
        tradeOriginationDate.wrap(value);
        tradeOriginationDateOffset = offset;
        tradeOriginationDateLength = length;
        return this;
    }

    /* TradeOriginationDate = 229 */
    public AllocationInstructionEncoder tradeOriginationDate(final DirectBuffer value, final int length)
    {
        return tradeOriginationDate(value, 0, length);
    }

    /* TradeOriginationDate = 229 */
    public AllocationInstructionEncoder tradeOriginationDate(final DirectBuffer value)
    {
        return tradeOriginationDate(value, 0, value.capacity());
    }

    /* TradeOriginationDate = 229 */
    public AllocationInstructionEncoder tradeOriginationDate(final byte[] value, final int offset, final int length)
    {
        tradeOriginationDate.wrap(value);
        tradeOriginationDateOffset = offset;
        tradeOriginationDateLength = length;
        return this;
    }

    /* TradeOriginationDate = 229 */
    public AllocationInstructionEncoder tradeOriginationDateAsCopy(final byte[] value, final int offset, final int length)
    {
        copyInto(tradeOriginationDate, value, offset, length);
        tradeOriginationDateOffset = offset;
        tradeOriginationDateLength = length;
        return this;
    }

    /* TradeOriginationDate = 229 */
    public AllocationInstructionEncoder tradeOriginationDate(final byte[] value, final int length)
    {
        return tradeOriginationDate(value, 0, length);
    }

    /* TradeOriginationDate = 229 */
    public AllocationInstructionEncoder tradeOriginationDate(final byte[] value)
    {
        return tradeOriginationDate(value, 0, value.length);
    }

    /* TradeOriginationDate = 229 */
    public boolean hasTradeOriginationDate()
    {
        return tradeOriginationDateLength > 0;
    }

    /* TradeOriginationDate = 229 */
    public MutableDirectBuffer tradeOriginationDate()
    {
        return tradeOriginationDate;
    }

    /* TradeOriginationDate = 229 */
    public String tradeOriginationDateAsString()
    {
        return tradeOriginationDate.getStringWithoutLengthAscii(tradeOriginationDateOffset, tradeOriginationDateLength);
    }

    private final MutableDirectBuffer tradingSessionID = new UnsafeBuffer();

    private int tradingSessionIDOffset = 0;

    private int tradingSessionIDLength = 0;

    /* TradingSessionID = 336 */
    public AllocationInstructionEncoder tradingSessionID(final DirectBuffer value, final int offset, final int length)
    {
        tradingSessionID.wrap(value);
        tradingSessionIDOffset = offset;
        tradingSessionIDLength = length;
        return this;
    }

    /* TradingSessionID = 336 */
    public AllocationInstructionEncoder tradingSessionID(final DirectBuffer value, final int length)
    {
        return tradingSessionID(value, 0, length);
    }

    /* TradingSessionID = 336 */
    public AllocationInstructionEncoder tradingSessionID(final DirectBuffer value)
    {
        return tradingSessionID(value, 0, value.capacity());
    }

    /* TradingSessionID = 336 */
    public AllocationInstructionEncoder tradingSessionID(final byte[] value, final int offset, final int length)
    {
        tradingSessionID.wrap(value);
        tradingSessionIDOffset = offset;
        tradingSessionIDLength = length;
        return this;
    }

    /* TradingSessionID = 336 */
    public AllocationInstructionEncoder tradingSessionIDAsCopy(final byte[] value, final int offset, final int length)
    {
        copyInto(tradingSessionID, value, offset, length);
        tradingSessionIDOffset = offset;
        tradingSessionIDLength = length;
        return this;
    }

    /* TradingSessionID = 336 */
    public AllocationInstructionEncoder tradingSessionID(final byte[] value, final int length)
    {
        return tradingSessionID(value, 0, length);
    }

    /* TradingSessionID = 336 */
    public AllocationInstructionEncoder tradingSessionID(final byte[] value)
    {
        return tradingSessionID(value, 0, value.length);
    }

    /* TradingSessionID = 336 */
    public boolean hasTradingSessionID()
    {
        return tradingSessionIDLength > 0;
    }

    /* TradingSessionID = 336 */
    public MutableDirectBuffer tradingSessionID()
    {
        return tradingSessionID;
    }

    /* TradingSessionID = 336 */
    public String tradingSessionIDAsString()
    {
        return tradingSessionID.getStringWithoutLengthAscii(tradingSessionIDOffset, tradingSessionIDLength);
    }

    /* TradingSessionID = 336 */
    public AllocationInstructionEncoder tradingSessionID(final CharSequence value)
    {
        toBytes(value, tradingSessionID);
        tradingSessionIDOffset = 0;
        tradingSessionIDLength = value.length();
        return this;
    }

    /* TradingSessionID = 336 */
    public AllocationInstructionEncoder tradingSessionID(final AsciiSequenceView value)
    {
        final DirectBuffer buffer = value.buffer();
        if (buffer != null)
        {
            tradingSessionID.wrap(buffer);
            tradingSessionIDOffset = value.offset();
            tradingSessionIDLength = value.length();
        }
        return this;
    }

    /* TradingSessionID = 336 */
    public AllocationInstructionEncoder tradingSessionID(final char[] value)
    {
        return tradingSessionID(value, 0, value.length);
    }

    /* TradingSessionID = 336 */
    public AllocationInstructionEncoder tradingSessionID(final char[] value, final int length)
    {
        return tradingSessionID(value, 0, length);
    }

    /* TradingSessionID = 336 */
    public AllocationInstructionEncoder tradingSessionID(final char[] value, final int offset, final int length)
    {
        toBytes(value, tradingSessionID, offset, length);
        tradingSessionIDOffset = 0;
        tradingSessionIDLength = length;
        return this;
    }

    private final MutableDirectBuffer tradingSessionSubID = new UnsafeBuffer();

    private int tradingSessionSubIDOffset = 0;

    private int tradingSessionSubIDLength = 0;

    /* TradingSessionSubID = 625 */
    public AllocationInstructionEncoder tradingSessionSubID(final DirectBuffer value, final int offset, final int length)
    {
        tradingSessionSubID.wrap(value);
        tradingSessionSubIDOffset = offset;
        tradingSessionSubIDLength = length;
        return this;
    }

    /* TradingSessionSubID = 625 */
    public AllocationInstructionEncoder tradingSessionSubID(final DirectBuffer value, final int length)
    {
        return tradingSessionSubID(value, 0, length);
    }

    /* TradingSessionSubID = 625 */
    public AllocationInstructionEncoder tradingSessionSubID(final DirectBuffer value)
    {
        return tradingSessionSubID(value, 0, value.capacity());
    }

    /* TradingSessionSubID = 625 */
    public AllocationInstructionEncoder tradingSessionSubID(final byte[] value, final int offset, final int length)
    {
        tradingSessionSubID.wrap(value);
        tradingSessionSubIDOffset = offset;
        tradingSessionSubIDLength = length;
        return this;
    }

    /* TradingSessionSubID = 625 */
    public AllocationInstructionEncoder tradingSessionSubIDAsCopy(final byte[] value, final int offset, final int length)
    {
        copyInto(tradingSessionSubID, value, offset, length);
        tradingSessionSubIDOffset = offset;
        tradingSessionSubIDLength = length;
        return this;
    }

    /* TradingSessionSubID = 625 */
    public AllocationInstructionEncoder tradingSessionSubID(final byte[] value, final int length)
    {
        return tradingSessionSubID(value, 0, length);
    }

    /* TradingSessionSubID = 625 */
    public AllocationInstructionEncoder tradingSessionSubID(final byte[] value)
    {
        return tradingSessionSubID(value, 0, value.length);
    }

    /* TradingSessionSubID = 625 */
    public boolean hasTradingSessionSubID()
    {
        return tradingSessionSubIDLength > 0;
    }

    /* TradingSessionSubID = 625 */
    public MutableDirectBuffer tradingSessionSubID()
    {
        return tradingSessionSubID;
    }

    /* TradingSessionSubID = 625 */
    public String tradingSessionSubIDAsString()
    {
        return tradingSessionSubID.getStringWithoutLengthAscii(tradingSessionSubIDOffset, tradingSessionSubIDLength);
    }

    /* TradingSessionSubID = 625 */
    public AllocationInstructionEncoder tradingSessionSubID(final CharSequence value)
    {
        toBytes(value, tradingSessionSubID);
        tradingSessionSubIDOffset = 0;
        tradingSessionSubIDLength = value.length();
        return this;
    }

    /* TradingSessionSubID = 625 */
    public AllocationInstructionEncoder tradingSessionSubID(final AsciiSequenceView value)
    {
        final DirectBuffer buffer = value.buffer();
        if (buffer != null)
        {
            tradingSessionSubID.wrap(buffer);
            tradingSessionSubIDOffset = value.offset();
            tradingSessionSubIDLength = value.length();
        }
        return this;
    }

    /* TradingSessionSubID = 625 */
    public AllocationInstructionEncoder tradingSessionSubID(final char[] value)
    {
        return tradingSessionSubID(value, 0, value.length);
    }

    /* TradingSessionSubID = 625 */
    public AllocationInstructionEncoder tradingSessionSubID(final char[] value, final int length)
    {
        return tradingSessionSubID(value, 0, length);
    }

    /* TradingSessionSubID = 625 */
    public AllocationInstructionEncoder tradingSessionSubID(final char[] value, final int offset, final int length)
    {
        toBytes(value, tradingSessionSubID, offset, length);
        tradingSessionSubIDOffset = 0;
        tradingSessionSubIDLength = length;
        return this;
    }

    private int priceType;

    private boolean hasPriceType;

    public boolean hasPriceType()
    {
        return hasPriceType;
    }

    /* PriceType = 423 */
    public AllocationInstructionEncoder priceType(int value)
    {
        priceType = value;
        hasPriceType = true;
        return this;
    }

    /* PriceType = 423 */
    public int priceType()
    {
        return priceType;
    }

    public AllocationInstructionEncoder priceType(PriceType value)
    {
        if (CODEC_VALIDATION_ENABLED)
        {
            if (value == PriceType.ARTIO_UNKNOWN)
            {
                throw new EncodingException("Invalid Value Field: priceType Value: " + value );
            }
            if (value == PriceType.NULL_VAL)
            {
                return this;
            }
        }
        return priceType(value.representation());
    }

    private final DecimalFloat avgPx = new DecimalFloat();

    private boolean hasAvgPx;

    public boolean hasAvgPx()
    {
        return hasAvgPx;
    }

    /* AvgPx = 6 */
    public AllocationInstructionEncoder avgPx(ReadOnlyDecimalFloat value)
    {
        avgPx.set(value);
        hasAvgPx = true;
        return this;
    }

    /* AvgPx = 6 */
    public AllocationInstructionEncoder avgPx(long value, int scale)
    {
        avgPx.set(value, scale);
        hasAvgPx = true;
        return this;
    }

    /* AvgPx = 6 */
    public DecimalFloat avgPx()
    {
        return avgPx;
    }

    private final DecimalFloat avgParPx = new DecimalFloat();

    private boolean hasAvgParPx;

    public boolean hasAvgParPx()
    {
        return hasAvgParPx;
    }

    /* AvgParPx = 860 */
    public AllocationInstructionEncoder avgParPx(ReadOnlyDecimalFloat value)
    {
        avgParPx.set(value);
        hasAvgParPx = true;
        return this;
    }

    /* AvgParPx = 860 */
    public AllocationInstructionEncoder avgParPx(long value, int scale)
    {
        avgParPx.set(value, scale);
        hasAvgParPx = true;
        return this;
    }

    /* AvgParPx = 860 */
    public DecimalFloat avgParPx()
    {
        return avgParPx;
    }

    private final SpreadOrBenchmarkCurveDataEncoder spreadOrBenchmarkCurveData = new SpreadOrBenchmarkCurveDataEncoder();
    public SpreadOrBenchmarkCurveDataEncoder spreadOrBenchmarkCurveData()
    {
        return spreadOrBenchmarkCurveData;
    }

    private final MutableDirectBuffer currency = new UnsafeBuffer();

    private int currencyOffset = 0;

    private int currencyLength = 0;

    /* Currency = 15 */
    public AllocationInstructionEncoder currency(final DirectBuffer value, final int offset, final int length)
    {
        currency.wrap(value);
        currencyOffset = offset;
        currencyLength = length;
        return this;
    }

    /* Currency = 15 */
    public AllocationInstructionEncoder currency(final DirectBuffer value, final int length)
    {
        return currency(value, 0, length);
    }

    /* Currency = 15 */
    public AllocationInstructionEncoder currency(final DirectBuffer value)
    {
        return currency(value, 0, value.capacity());
    }

    /* Currency = 15 */
    public AllocationInstructionEncoder currency(final byte[] value, final int offset, final int length)
    {
        currency.wrap(value);
        currencyOffset = offset;
        currencyLength = length;
        return this;
    }

    /* Currency = 15 */
    public AllocationInstructionEncoder currencyAsCopy(final byte[] value, final int offset, final int length)
    {
        copyInto(currency, value, offset, length);
        currencyOffset = offset;
        currencyLength = length;
        return this;
    }

    /* Currency = 15 */
    public AllocationInstructionEncoder currency(final byte[] value, final int length)
    {
        return currency(value, 0, length);
    }

    /* Currency = 15 */
    public AllocationInstructionEncoder currency(final byte[] value)
    {
        return currency(value, 0, value.length);
    }

    /* Currency = 15 */
    public boolean hasCurrency()
    {
        return currencyLength > 0;
    }

    /* Currency = 15 */
    public MutableDirectBuffer currency()
    {
        return currency;
    }

    /* Currency = 15 */
    public String currencyAsString()
    {
        return currency.getStringWithoutLengthAscii(currencyOffset, currencyLength);
    }

    /* Currency = 15 */
    public AllocationInstructionEncoder currency(final CharSequence value)
    {
        toBytes(value, currency);
        currencyOffset = 0;
        currencyLength = value.length();
        return this;
    }

    /* Currency = 15 */
    public AllocationInstructionEncoder currency(final AsciiSequenceView value)
    {
        final DirectBuffer buffer = value.buffer();
        if (buffer != null)
        {
            currency.wrap(buffer);
            currencyOffset = value.offset();
            currencyLength = value.length();
        }
        return this;
    }

    /* Currency = 15 */
    public AllocationInstructionEncoder currency(final char[] value)
    {
        return currency(value, 0, value.length);
    }

    /* Currency = 15 */
    public AllocationInstructionEncoder currency(final char[] value, final int length)
    {
        return currency(value, 0, length);
    }

    /* Currency = 15 */
    public AllocationInstructionEncoder currency(final char[] value, final int offset, final int length)
    {
        toBytes(value, currency, offset, length);
        currencyOffset = 0;
        currencyLength = length;
        return this;
    }

    private int avgPxPrecision;

    private boolean hasAvgPxPrecision;

    public boolean hasAvgPxPrecision()
    {
        return hasAvgPxPrecision;
    }

    /* AvgPxPrecision = 74 */
    public AllocationInstructionEncoder avgPxPrecision(int value)
    {
        avgPxPrecision = value;
        hasAvgPxPrecision = true;
        return this;
    }

    /* AvgPxPrecision = 74 */
    public int avgPxPrecision()
    {
        return avgPxPrecision;
    }

    private final PartiesEncoder parties = new PartiesEncoder();
    public PartiesEncoder parties()
    {
        return parties;
    }

    private final MutableDirectBuffer tradeDate = new UnsafeBuffer();

    private int tradeDateOffset = 0;

    private int tradeDateLength = 0;

    /* TradeDate = 75 */
    public AllocationInstructionEncoder tradeDate(final DirectBuffer value, final int offset, final int length)
    {
        tradeDate.wrap(value);
        tradeDateOffset = offset;
        tradeDateLength = length;
        return this;
    }

    /* TradeDate = 75 */
    public AllocationInstructionEncoder tradeDate(final DirectBuffer value, final int length)
    {
        return tradeDate(value, 0, length);
    }

    /* TradeDate = 75 */
    public AllocationInstructionEncoder tradeDate(final DirectBuffer value)
    {
        return tradeDate(value, 0, value.capacity());
    }

    /* TradeDate = 75 */
    public AllocationInstructionEncoder tradeDate(final byte[] value, final int offset, final int length)
    {
        tradeDate.wrap(value);
        tradeDateOffset = offset;
        tradeDateLength = length;
        return this;
    }

    /* TradeDate = 75 */
    public AllocationInstructionEncoder tradeDateAsCopy(final byte[] value, final int offset, final int length)
    {
        copyInto(tradeDate, value, offset, length);
        tradeDateOffset = offset;
        tradeDateLength = length;
        return this;
    }

    /* TradeDate = 75 */
    public AllocationInstructionEncoder tradeDate(final byte[] value, final int length)
    {
        return tradeDate(value, 0, length);
    }

    /* TradeDate = 75 */
    public AllocationInstructionEncoder tradeDate(final byte[] value)
    {
        return tradeDate(value, 0, value.length);
    }

    /* TradeDate = 75 */
    public boolean hasTradeDate()
    {
        return tradeDateLength > 0;
    }

    /* TradeDate = 75 */
    public MutableDirectBuffer tradeDate()
    {
        return tradeDate;
    }

    /* TradeDate = 75 */
    public String tradeDateAsString()
    {
        return tradeDate.getStringWithoutLengthAscii(tradeDateOffset, tradeDateLength);
    }

    private final MutableDirectBuffer transactTime = new UnsafeBuffer();

    private int transactTimeOffset = 0;

    private int transactTimeLength = 0;

    /* TransactTime = 60 */
    public AllocationInstructionEncoder transactTime(final DirectBuffer value, final int offset, final int length)
    {
        transactTime.wrap(value);
        transactTimeOffset = offset;
        transactTimeLength = length;
        return this;
    }

    /* TransactTime = 60 */
    public AllocationInstructionEncoder transactTime(final DirectBuffer value, final int length)
    {
        return transactTime(value, 0, length);
    }

    /* TransactTime = 60 */
    public AllocationInstructionEncoder transactTime(final DirectBuffer value)
    {
        return transactTime(value, 0, value.capacity());
    }

    /* TransactTime = 60 */
    public AllocationInstructionEncoder transactTime(final byte[] value, final int offset, final int length)
    {
        transactTime.wrap(value);
        transactTimeOffset = offset;
        transactTimeLength = length;
        return this;
    }

    /* TransactTime = 60 */
    public AllocationInstructionEncoder transactTimeAsCopy(final byte[] value, final int offset, final int length)
    {
        copyInto(transactTime, value, offset, length);
        transactTimeOffset = offset;
        transactTimeLength = length;
        return this;
    }

    /* TransactTime = 60 */
    public AllocationInstructionEncoder transactTime(final byte[] value, final int length)
    {
        return transactTime(value, 0, length);
    }

    /* TransactTime = 60 */
    public AllocationInstructionEncoder transactTime(final byte[] value)
    {
        return transactTime(value, 0, value.length);
    }

    /* TransactTime = 60 */
    public boolean hasTransactTime()
    {
        return transactTimeLength > 0;
    }

    /* TransactTime = 60 */
    public MutableDirectBuffer transactTime()
    {
        return transactTime;
    }

    /* TransactTime = 60 */
    public String transactTimeAsString()
    {
        return transactTime.getStringWithoutLengthAscii(transactTimeOffset, transactTimeLength);
    }

    private char settlType;

    private boolean hasSettlType;

    public boolean hasSettlType()
    {
        return hasSettlType;
    }

    /* SettlType = 63 */
    public AllocationInstructionEncoder settlType(char value)
    {
        settlType = value;
        hasSettlType = true;
        return this;
    }

    /* SettlType = 63 */
    public char settlType()
    {
        return settlType;
    }

    public AllocationInstructionEncoder settlType(SettlType value)
    {
        if (CODEC_VALIDATION_ENABLED)
        {
            if (value == SettlType.ARTIO_UNKNOWN)
            {
                throw new EncodingException("Invalid Value Field: settlType Value: " + value );
            }
            if (value == SettlType.NULL_VAL)
            {
                return this;
            }
        }
        return settlType(value.representation());
    }

    private final MutableDirectBuffer settlDate = new UnsafeBuffer();

    private int settlDateOffset = 0;

    private int settlDateLength = 0;

    /* SettlDate = 64 */
    public AllocationInstructionEncoder settlDate(final DirectBuffer value, final int offset, final int length)
    {
        settlDate.wrap(value);
        settlDateOffset = offset;
        settlDateLength = length;
        return this;
    }

    /* SettlDate = 64 */
    public AllocationInstructionEncoder settlDate(final DirectBuffer value, final int length)
    {
        return settlDate(value, 0, length);
    }

    /* SettlDate = 64 */
    public AllocationInstructionEncoder settlDate(final DirectBuffer value)
    {
        return settlDate(value, 0, value.capacity());
    }

    /* SettlDate = 64 */
    public AllocationInstructionEncoder settlDate(final byte[] value, final int offset, final int length)
    {
        settlDate.wrap(value);
        settlDateOffset = offset;
        settlDateLength = length;
        return this;
    }

    /* SettlDate = 64 */
    public AllocationInstructionEncoder settlDateAsCopy(final byte[] value, final int offset, final int length)
    {
        copyInto(settlDate, value, offset, length);
        settlDateOffset = offset;
        settlDateLength = length;
        return this;
    }

    /* SettlDate = 64 */
    public AllocationInstructionEncoder settlDate(final byte[] value, final int length)
    {
        return settlDate(value, 0, length);
    }

    /* SettlDate = 64 */
    public AllocationInstructionEncoder settlDate(final byte[] value)
    {
        return settlDate(value, 0, value.length);
    }

    /* SettlDate = 64 */
    public boolean hasSettlDate()
    {
        return settlDateLength > 0;
    }

    /* SettlDate = 64 */
    public MutableDirectBuffer settlDate()
    {
        return settlDate;
    }

    /* SettlDate = 64 */
    public String settlDateAsString()
    {
        return settlDate.getStringWithoutLengthAscii(settlDateOffset, settlDateLength);
    }

    private int bookingType;

    private boolean hasBookingType;

    public boolean hasBookingType()
    {
        return hasBookingType;
    }

    /* BookingType = 775 */
    public AllocationInstructionEncoder bookingType(int value)
    {
        bookingType = value;
        hasBookingType = true;
        return this;
    }

    /* BookingType = 775 */
    public int bookingType()
    {
        return bookingType;
    }

    public AllocationInstructionEncoder bookingType(BookingType value)
    {
        if (CODEC_VALIDATION_ENABLED)
        {
            if (value == BookingType.ARTIO_UNKNOWN)
            {
                throw new EncodingException("Invalid Value Field: bookingType Value: " + value );
            }
            if (value == BookingType.NULL_VAL)
            {
                return this;
            }
        }
        return bookingType(value.representation());
    }

    private final DecimalFloat grossTradeAmt = new DecimalFloat();

    private boolean hasGrossTradeAmt;

    public boolean hasGrossTradeAmt()
    {
        return hasGrossTradeAmt;
    }

    /* GrossTradeAmt = 381 */
    public AllocationInstructionEncoder grossTradeAmt(ReadOnlyDecimalFloat value)
    {
        grossTradeAmt.set(value);
        hasGrossTradeAmt = true;
        return this;
    }

    /* GrossTradeAmt = 381 */
    public AllocationInstructionEncoder grossTradeAmt(long value, int scale)
    {
        grossTradeAmt.set(value, scale);
        hasGrossTradeAmt = true;
        return this;
    }

    /* GrossTradeAmt = 381 */
    public DecimalFloat grossTradeAmt()
    {
        return grossTradeAmt;
    }

    private final DecimalFloat concession = new DecimalFloat();

    private boolean hasConcession;

    public boolean hasConcession()
    {
        return hasConcession;
    }

    /* Concession = 238 */
    public AllocationInstructionEncoder concession(ReadOnlyDecimalFloat value)
    {
        concession.set(value);
        hasConcession = true;
        return this;
    }

    /* Concession = 238 */
    public AllocationInstructionEncoder concession(long value, int scale)
    {
        concession.set(value, scale);
        hasConcession = true;
        return this;
    }

    /* Concession = 238 */
    public DecimalFloat concession()
    {
        return concession;
    }

    private final DecimalFloat totalTakedown = new DecimalFloat();

    private boolean hasTotalTakedown;

    public boolean hasTotalTakedown()
    {
        return hasTotalTakedown;
    }

    /* TotalTakedown = 237 */
    public AllocationInstructionEncoder totalTakedown(ReadOnlyDecimalFloat value)
    {
        totalTakedown.set(value);
        hasTotalTakedown = true;
        return this;
    }

    /* TotalTakedown = 237 */
    public AllocationInstructionEncoder totalTakedown(long value, int scale)
    {
        totalTakedown.set(value, scale);
        hasTotalTakedown = true;
        return this;
    }

    /* TotalTakedown = 237 */
    public DecimalFloat totalTakedown()
    {
        return totalTakedown;
    }

    private final DecimalFloat netMoney = new DecimalFloat();

    private boolean hasNetMoney;

    public boolean hasNetMoney()
    {
        return hasNetMoney;
    }

    /* NetMoney = 118 */
    public AllocationInstructionEncoder netMoney(ReadOnlyDecimalFloat value)
    {
        netMoney.set(value);
        hasNetMoney = true;
        return this;
    }

    /* NetMoney = 118 */
    public AllocationInstructionEncoder netMoney(long value, int scale)
    {
        netMoney.set(value, scale);
        hasNetMoney = true;
        return this;
    }

    /* NetMoney = 118 */
    public DecimalFloat netMoney()
    {
        return netMoney;
    }

    private char positionEffect;

    private boolean hasPositionEffect;

    public boolean hasPositionEffect()
    {
        return hasPositionEffect;
    }

    /* PositionEffect = 77 */
    public AllocationInstructionEncoder positionEffect(char value)
    {
        positionEffect = value;
        hasPositionEffect = true;
        return this;
    }

    /* PositionEffect = 77 */
    public char positionEffect()
    {
        return positionEffect;
    }

    public AllocationInstructionEncoder positionEffect(PositionEffect value)
    {
        if (CODEC_VALIDATION_ENABLED)
        {
            if (value == PositionEffect.ARTIO_UNKNOWN)
            {
                throw new EncodingException("Invalid Value Field: positionEffect Value: " + value );
            }
            if (value == PositionEffect.NULL_VAL)
            {
                return this;
            }
        }
        return positionEffect(value.representation());
    }

    private boolean autoAcceptIndicator;

    private boolean hasAutoAcceptIndicator;

    public boolean hasAutoAcceptIndicator()
    {
        return hasAutoAcceptIndicator;
    }

    /* AutoAcceptIndicator = 754 */
    public AllocationInstructionEncoder autoAcceptIndicator(boolean value)
    {
        autoAcceptIndicator = value;
        hasAutoAcceptIndicator = true;
        return this;
    }

    /* AutoAcceptIndicator = 754 */
    public boolean autoAcceptIndicator()
    {
        return autoAcceptIndicator;
    }

    private final MutableDirectBuffer text = new UnsafeBuffer();

    private int textOffset = 0;

    private int textLength = 0;

    /* Text = 58 */
    public AllocationInstructionEncoder text(final DirectBuffer value, final int offset, final int length)
    {
        text.wrap(value);
        textOffset = offset;
        textLength = length;
        return this;
    }

    /* Text = 58 */
    public AllocationInstructionEncoder text(final DirectBuffer value, final int length)
    {
        return text(value, 0, length);
    }

    /* Text = 58 */
    public AllocationInstructionEncoder text(final DirectBuffer value)
    {
        return text(value, 0, value.capacity());
    }

    /* Text = 58 */
    public AllocationInstructionEncoder text(final byte[] value, final int offset, final int length)
    {
        text.wrap(value);
        textOffset = offset;
        textLength = length;
        return this;
    }

    /* Text = 58 */
    public AllocationInstructionEncoder textAsCopy(final byte[] value, final int offset, final int length)
    {
        copyInto(text, value, offset, length);
        textOffset = offset;
        textLength = length;
        return this;
    }

    /* Text = 58 */
    public AllocationInstructionEncoder text(final byte[] value, final int length)
    {
        return text(value, 0, length);
    }

    /* Text = 58 */
    public AllocationInstructionEncoder text(final byte[] value)
    {
        return text(value, 0, value.length);
    }

    /* Text = 58 */
    public boolean hasText()
    {
        return textLength > 0;
    }

    /* Text = 58 */
    public MutableDirectBuffer text()
    {
        return text;
    }

    /* Text = 58 */
    public String textAsString()
    {
        return text.getStringWithoutLengthAscii(textOffset, textLength);
    }

    /* Text = 58 */
    public AllocationInstructionEncoder text(final CharSequence value)
    {
        toBytes(value, text);
        textOffset = 0;
        textLength = value.length();
        return this;
    }

    /* Text = 58 */
    public AllocationInstructionEncoder text(final AsciiSequenceView value)
    {
        final DirectBuffer buffer = value.buffer();
        if (buffer != null)
        {
            text.wrap(buffer);
            textOffset = value.offset();
            textLength = value.length();
        }
        return this;
    }

    /* Text = 58 */
    public AllocationInstructionEncoder text(final char[] value)
    {
        return text(value, 0, value.length);
    }

    /* Text = 58 */
    public AllocationInstructionEncoder text(final char[] value, final int length)
    {
        return text(value, 0, length);
    }

    /* Text = 58 */
    public AllocationInstructionEncoder text(final char[] value, final int offset, final int length)
    {
        toBytes(value, text, offset, length);
        textOffset = 0;
        textLength = length;
        return this;
    }

    private int encodedTextLen;

    private boolean hasEncodedTextLen;

    public boolean hasEncodedTextLen()
    {
        return hasEncodedTextLen;
    }

    /* EncodedTextLen = 354 */
    public AllocationInstructionEncoder encodedTextLen(int value)
    {
        encodedTextLen = value;
        hasEncodedTextLen = true;
        return this;
    }

    /* EncodedTextLen = 354 */
    public int encodedTextLen()
    {
        return encodedTextLen;
    }

    private byte[] encodedText;

    private boolean hasEncodedText;

    public boolean hasEncodedText()
    {
        return hasEncodedText;
    }

    /* EncodedText = 355 */
    public AllocationInstructionEncoder encodedText(byte[] value)
    {
        encodedText = value;
        hasEncodedText = true;
        return this;
    }

    /* EncodedText = 355 */
    public byte[] encodedText()
    {
        return encodedText;
    }

    /* EncodedText = 355 */
    public AllocationInstructionEncoder encodedTextAsCopy(final byte[] value, final int offset, final int length)
    {
        encodedText = copyInto(encodedText, value, offset, length);
        hasEncodedText = true;
        return this;
    }

    private int numDaysInterest;

    private boolean hasNumDaysInterest;

    public boolean hasNumDaysInterest()
    {
        return hasNumDaysInterest;
    }

    /* NumDaysInterest = 157 */
    public AllocationInstructionEncoder numDaysInterest(int value)
    {
        numDaysInterest = value;
        hasNumDaysInterest = true;
        return this;
    }

    /* NumDaysInterest = 157 */
    public int numDaysInterest()
    {
        return numDaysInterest;
    }

    private final DecimalFloat accruedInterestRate = new DecimalFloat();

    private boolean hasAccruedInterestRate;

    public boolean hasAccruedInterestRate()
    {
        return hasAccruedInterestRate;
    }

    /* AccruedInterestRate = 158 */
    public AllocationInstructionEncoder accruedInterestRate(ReadOnlyDecimalFloat value)
    {
        accruedInterestRate.set(value);
        hasAccruedInterestRate = true;
        return this;
    }

    /* AccruedInterestRate = 158 */
    public AllocationInstructionEncoder accruedInterestRate(long value, int scale)
    {
        accruedInterestRate.set(value, scale);
        hasAccruedInterestRate = true;
        return this;
    }

    /* AccruedInterestRate = 158 */
    public DecimalFloat accruedInterestRate()
    {
        return accruedInterestRate;
    }

    private final DecimalFloat accruedInterestAmt = new DecimalFloat();

    private boolean hasAccruedInterestAmt;

    public boolean hasAccruedInterestAmt()
    {
        return hasAccruedInterestAmt;
    }

    /* AccruedInterestAmt = 159 */
    public AllocationInstructionEncoder accruedInterestAmt(ReadOnlyDecimalFloat value)
    {
        accruedInterestAmt.set(value);
        hasAccruedInterestAmt = true;
        return this;
    }

    /* AccruedInterestAmt = 159 */
    public AllocationInstructionEncoder accruedInterestAmt(long value, int scale)
    {
        accruedInterestAmt.set(value, scale);
        hasAccruedInterestAmt = true;
        return this;
    }

    /* AccruedInterestAmt = 159 */
    public DecimalFloat accruedInterestAmt()
    {
        return accruedInterestAmt;
    }

    private final DecimalFloat totalAccruedInterestAmt = new DecimalFloat();

    private boolean hasTotalAccruedInterestAmt;

    public boolean hasTotalAccruedInterestAmt()
    {
        return hasTotalAccruedInterestAmt;
    }

    /* TotalAccruedInterestAmt = 540 */
    public AllocationInstructionEncoder totalAccruedInterestAmt(ReadOnlyDecimalFloat value)
    {
        totalAccruedInterestAmt.set(value);
        hasTotalAccruedInterestAmt = true;
        return this;
    }

    /* TotalAccruedInterestAmt = 540 */
    public AllocationInstructionEncoder totalAccruedInterestAmt(long value, int scale)
    {
        totalAccruedInterestAmt.set(value, scale);
        hasTotalAccruedInterestAmt = true;
        return this;
    }

    /* TotalAccruedInterestAmt = 540 */
    public DecimalFloat totalAccruedInterestAmt()
    {
        return totalAccruedInterestAmt;
    }

    private final DecimalFloat interestAtMaturity = new DecimalFloat();

    private boolean hasInterestAtMaturity;

    public boolean hasInterestAtMaturity()
    {
        return hasInterestAtMaturity;
    }

    /* InterestAtMaturity = 738 */
    public AllocationInstructionEncoder interestAtMaturity(ReadOnlyDecimalFloat value)
    {
        interestAtMaturity.set(value);
        hasInterestAtMaturity = true;
        return this;
    }

    /* InterestAtMaturity = 738 */
    public AllocationInstructionEncoder interestAtMaturity(long value, int scale)
    {
        interestAtMaturity.set(value, scale);
        hasInterestAtMaturity = true;
        return this;
    }

    /* InterestAtMaturity = 738 */
    public DecimalFloat interestAtMaturity()
    {
        return interestAtMaturity;
    }

    private final DecimalFloat endAccruedInterestAmt = new DecimalFloat();

    private boolean hasEndAccruedInterestAmt;

    public boolean hasEndAccruedInterestAmt()
    {
        return hasEndAccruedInterestAmt;
    }

    /* EndAccruedInterestAmt = 920 */
    public AllocationInstructionEncoder endAccruedInterestAmt(ReadOnlyDecimalFloat value)
    {
        endAccruedInterestAmt.set(value);
        hasEndAccruedInterestAmt = true;
        return this;
    }

    /* EndAccruedInterestAmt = 920 */
    public AllocationInstructionEncoder endAccruedInterestAmt(long value, int scale)
    {
        endAccruedInterestAmt.set(value, scale);
        hasEndAccruedInterestAmt = true;
        return this;
    }

    /* EndAccruedInterestAmt = 920 */
    public DecimalFloat endAccruedInterestAmt()
    {
        return endAccruedInterestAmt;
    }

    private final DecimalFloat startCash = new DecimalFloat();

    private boolean hasStartCash;

    public boolean hasStartCash()
    {
        return hasStartCash;
    }

    /* StartCash = 921 */
    public AllocationInstructionEncoder startCash(ReadOnlyDecimalFloat value)
    {
        startCash.set(value);
        hasStartCash = true;
        return this;
    }

    /* StartCash = 921 */
    public AllocationInstructionEncoder startCash(long value, int scale)
    {
        startCash.set(value, scale);
        hasStartCash = true;
        return this;
    }

    /* StartCash = 921 */
    public DecimalFloat startCash()
    {
        return startCash;
    }

    private final DecimalFloat endCash = new DecimalFloat();

    private boolean hasEndCash;

    public boolean hasEndCash()
    {
        return hasEndCash;
    }

    /* EndCash = 922 */
    public AllocationInstructionEncoder endCash(ReadOnlyDecimalFloat value)
    {
        endCash.set(value);
        hasEndCash = true;
        return this;
    }

    /* EndCash = 922 */
    public AllocationInstructionEncoder endCash(long value, int scale)
    {
        endCash.set(value, scale);
        hasEndCash = true;
        return this;
    }

    /* EndCash = 922 */
    public DecimalFloat endCash()
    {
        return endCash;
    }

    private boolean legalConfirm;

    private boolean hasLegalConfirm;

    public boolean hasLegalConfirm()
    {
        return hasLegalConfirm;
    }

    /* LegalConfirm = 650 */
    public AllocationInstructionEncoder legalConfirm(boolean value)
    {
        legalConfirm = value;
        hasLegalConfirm = true;
        return this;
    }

    /* LegalConfirm = 650 */
    public boolean legalConfirm()
    {
        return legalConfirm;
    }

    private final StipulationsEncoder stipulations = new StipulationsEncoder();
    public StipulationsEncoder stipulations()
    {
        return stipulations;
    }

    private final YieldDataEncoder yieldData = new YieldDataEncoder();
    public YieldDataEncoder yieldData()
    {
        return yieldData;
    }

    private int totNoAllocs;

    private boolean hasTotNoAllocs;

    public boolean hasTotNoAllocs()
    {
        return hasTotNoAllocs;
    }

    /* TotNoAllocs = 892 */
    public AllocationInstructionEncoder totNoAllocs(int value)
    {
        totNoAllocs = value;
        hasTotNoAllocs = true;
        return this;
    }

    /* TotNoAllocs = 892 */
    public int totNoAllocs()
    {
        return totNoAllocs;
    }

    private boolean lastFragment;

    private boolean hasLastFragment;

    public boolean hasLastFragment()
    {
        return hasLastFragment;
    }

    /* LastFragment = 893 */
    public AllocationInstructionEncoder lastFragment(boolean value)
    {
        lastFragment = value;
        hasLastFragment = true;
        return this;
    }

    /* LastFragment = 893 */
    public boolean lastFragment()
    {
        return lastFragment;
    }


@Generated("uk.co.real_logic.artio")
public static class AllocsGroupEncoder
{
    private AllocsGroupEncoder next = null;

    public AllocsGroupEncoder next()
    {
        if (next == null)
        {
            next = new AllocsGroupEncoder();
        }
        return next;
    }

    private static final int allocAccountHeaderLength = 3;
    private static final byte[] allocAccountHeader = new byte[] {55, 57, (byte) '='};

    private static final int allocAcctIDSourceHeaderLength = 4;
    private static final byte[] allocAcctIDSourceHeader = new byte[] {54, 54, 49, (byte) '='};

    private static final int matchStatusHeaderLength = 4;
    private static final byte[] matchStatusHeader = new byte[] {53, 55, 51, (byte) '='};

    private static final int allocPriceHeaderLength = 4;
    private static final byte[] allocPriceHeader = new byte[] {51, 54, 54, (byte) '='};

    private static final int allocQtyHeaderLength = 3;
    private static final byte[] allocQtyHeader = new byte[] {56, 48, (byte) '='};

    private static final int individualAllocIDHeaderLength = 4;
    private static final byte[] individualAllocIDHeader = new byte[] {52, 54, 55, (byte) '='};

    private static final int processCodeHeaderLength = 3;
    private static final byte[] processCodeHeader = new byte[] {56, 49, (byte) '='};

    private static final int notifyBrokerOfCreditHeaderLength = 4;
    private static final byte[] notifyBrokerOfCreditHeader = new byte[] {50, 48, 56, (byte) '='};

    private static final int allocHandlInstHeaderLength = 4;
    private static final byte[] allocHandlInstHeader = new byte[] {50, 48, 57, (byte) '='};

    private static final int allocTextHeaderLength = 4;
    private static final byte[] allocTextHeader = new byte[] {49, 54, 49, (byte) '='};

    private static final int encodedAllocTextLenHeaderLength = 4;
    private static final byte[] encodedAllocTextLenHeader = new byte[] {51, 54, 48, (byte) '='};

    private static final int encodedAllocTextHeaderLength = 4;
    private static final byte[] encodedAllocTextHeader = new byte[] {51, 54, 49, (byte) '='};

    private static final int allocAvgPxHeaderLength = 4;
    private static final byte[] allocAvgPxHeader = new byte[] {49, 53, 51, (byte) '='};

    private static final int allocNetMoneyHeaderLength = 4;
    private static final byte[] allocNetMoneyHeader = new byte[] {49, 53, 52, (byte) '='};

    private static final int settlCurrAmtHeaderLength = 4;
    private static final byte[] settlCurrAmtHeader = new byte[] {49, 49, 57, (byte) '='};

    private static final int allocSettlCurrAmtHeaderLength = 4;
    private static final byte[] allocSettlCurrAmtHeader = new byte[] {55, 51, 55, (byte) '='};

    private static final int settlCurrencyHeaderLength = 4;
    private static final byte[] settlCurrencyHeader = new byte[] {49, 50, 48, (byte) '='};

    private static final int allocSettlCurrencyHeaderLength = 4;
    private static final byte[] allocSettlCurrencyHeader = new byte[] {55, 51, 54, (byte) '='};

    private static final int settlCurrFxRateHeaderLength = 4;
    private static final byte[] settlCurrFxRateHeader = new byte[] {49, 53, 53, (byte) '='};

    private static final int settlCurrFxRateCalcHeaderLength = 4;
    private static final byte[] settlCurrFxRateCalcHeader = new byte[] {49, 53, 54, (byte) '='};

    private static final int accruedInterestAmtHeaderLength = 4;
    private static final byte[] accruedInterestAmtHeader = new byte[] {49, 53, 57, (byte) '='};

    private static final int allocAccruedInterestAmtHeaderLength = 4;
    private static final byte[] allocAccruedInterestAmtHeader = new byte[] {55, 52, 50, (byte) '='};

    private static final int allocInterestAtMaturityHeaderLength = 4;
    private static final byte[] allocInterestAtMaturityHeader = new byte[] {55, 52, 49, (byte) '='};

    private static final int settlInstModeHeaderLength = 4;
    private static final byte[] settlInstModeHeader = new byte[] {49, 54, 48, (byte) '='};

    private static final int noMiscFeesGroupCounterHeaderLength = 4;
    private static final byte[] noMiscFeesGroupCounterHeader = new byte[] {49, 51, 54, (byte) '='};

    private static final int noClearingInstructionsHeaderLength = 4;
    private static final byte[] noClearingInstructionsHeader = new byte[] {53, 55, 54, (byte) '='};

    private static final int clearingInstructionHeaderLength = 4;
    private static final byte[] clearingInstructionHeader = new byte[] {53, 55, 55, (byte) '='};

    private static final int clearingFeeIndicatorHeaderLength = 4;
    private static final byte[] clearingFeeIndicatorHeader = new byte[] {54, 51, 53, (byte) '='};

    private static final int allocSettlInstTypeHeaderLength = 4;
    private static final byte[] allocSettlInstTypeHeader = new byte[] {55, 56, 48, (byte) '='};

    private final MutableDirectBuffer allocAccount = new UnsafeBuffer();

    private int allocAccountOffset = 0;

    private int allocAccountLength = 0;

    /* AllocAccount = 79 */
    public AllocsGroupEncoder allocAccount(final DirectBuffer value, final int offset, final int length)
    {
        allocAccount.wrap(value);
        allocAccountOffset = offset;
        allocAccountLength = length;
        return this;
    }

    /* AllocAccount = 79 */
    public AllocsGroupEncoder allocAccount(final DirectBuffer value, final int length)
    {
        return allocAccount(value, 0, length);
    }

    /* AllocAccount = 79 */
    public AllocsGroupEncoder allocAccount(final DirectBuffer value)
    {
        return allocAccount(value, 0, value.capacity());
    }

    /* AllocAccount = 79 */
    public AllocsGroupEncoder allocAccount(final byte[] value, final int offset, final int length)
    {
        allocAccount.wrap(value);
        allocAccountOffset = offset;
        allocAccountLength = length;
        return this;
    }

    /* AllocAccount = 79 */
    public AllocsGroupEncoder allocAccountAsCopy(final byte[] value, final int offset, final int length)
    {
        copyInto(allocAccount, value, offset, length);
        allocAccountOffset = offset;
        allocAccountLength = length;
        return this;
    }

    /* AllocAccount = 79 */
    public AllocsGroupEncoder allocAccount(final byte[] value, final int length)
    {
        return allocAccount(value, 0, length);
    }

    /* AllocAccount = 79 */
    public AllocsGroupEncoder allocAccount(final byte[] value)
    {
        return allocAccount(value, 0, value.length);
    }

    /* AllocAccount = 79 */
    public boolean hasAllocAccount()
    {
        return allocAccountLength > 0;
    }

    /* AllocAccount = 79 */
    public MutableDirectBuffer allocAccount()
    {
        return allocAccount;
    }

    /* AllocAccount = 79 */
    public String allocAccountAsString()
    {
        return allocAccount.getStringWithoutLengthAscii(allocAccountOffset, allocAccountLength);
    }

    /* AllocAccount = 79 */
    public AllocsGroupEncoder allocAccount(final CharSequence value)
    {
        toBytes(value, allocAccount);
        allocAccountOffset = 0;
        allocAccountLength = value.length();
        return this;
    }

    /* AllocAccount = 79 */
    public AllocsGroupEncoder allocAccount(final AsciiSequenceView value)
    {
        final DirectBuffer buffer = value.buffer();
        if (buffer != null)
        {
            allocAccount.wrap(buffer);
            allocAccountOffset = value.offset();
            allocAccountLength = value.length();
        }
        return this;
    }

    /* AllocAccount = 79 */
    public AllocsGroupEncoder allocAccount(final char[] value)
    {
        return allocAccount(value, 0, value.length);
    }

    /* AllocAccount = 79 */
    public AllocsGroupEncoder allocAccount(final char[] value, final int length)
    {
        return allocAccount(value, 0, length);
    }

    /* AllocAccount = 79 */
    public AllocsGroupEncoder allocAccount(final char[] value, final int offset, final int length)
    {
        toBytes(value, allocAccount, offset, length);
        allocAccountOffset = 0;
        allocAccountLength = length;
        return this;
    }

    private int allocAcctIDSource;

    private boolean hasAllocAcctIDSource;

    public boolean hasAllocAcctIDSource()
    {
        return hasAllocAcctIDSource;
    }

    /* AllocAcctIDSource = 661 */
    public AllocsGroupEncoder allocAcctIDSource(int value)
    {
        allocAcctIDSource = value;
        hasAllocAcctIDSource = true;
        return this;
    }

    /* AllocAcctIDSource = 661 */
    public int allocAcctIDSource()
    {
        return allocAcctIDSource;
    }

    private char matchStatus;

    private boolean hasMatchStatus;

    public boolean hasMatchStatus()
    {
        return hasMatchStatus;
    }

    /* MatchStatus = 573 */
    public AllocsGroupEncoder matchStatus(char value)
    {
        matchStatus = value;
        hasMatchStatus = true;
        return this;
    }

    /* MatchStatus = 573 */
    public char matchStatus()
    {
        return matchStatus;
    }

    public AllocsGroupEncoder matchStatus(MatchStatus value)
    {
        if (CODEC_VALIDATION_ENABLED)
        {
            if (value == MatchStatus.ARTIO_UNKNOWN)
            {
                throw new EncodingException("Invalid Value Field: matchStatus Value: " + value );
            }
            if (value == MatchStatus.NULL_VAL)
            {
                return this;
            }
        }
        return matchStatus(value.representation());
    }

    private final DecimalFloat allocPrice = new DecimalFloat();

    private boolean hasAllocPrice;

    public boolean hasAllocPrice()
    {
        return hasAllocPrice;
    }

    /* AllocPrice = 366 */
    public AllocsGroupEncoder allocPrice(ReadOnlyDecimalFloat value)
    {
        allocPrice.set(value);
        hasAllocPrice = true;
        return this;
    }

    /* AllocPrice = 366 */
    public AllocsGroupEncoder allocPrice(long value, int scale)
    {
        allocPrice.set(value, scale);
        hasAllocPrice = true;
        return this;
    }

    /* AllocPrice = 366 */
    public DecimalFloat allocPrice()
    {
        return allocPrice;
    }

    private final DecimalFloat allocQty = new DecimalFloat();

    private boolean hasAllocQty;

    public boolean hasAllocQty()
    {
        return hasAllocQty;
    }

    /* AllocQty = 80 */
    public AllocsGroupEncoder allocQty(ReadOnlyDecimalFloat value)
    {
        allocQty.set(value);
        hasAllocQty = true;
        return this;
    }

    /* AllocQty = 80 */
    public AllocsGroupEncoder allocQty(long value, int scale)
    {
        allocQty.set(value, scale);
        hasAllocQty = true;
        return this;
    }

    /* AllocQty = 80 */
    public DecimalFloat allocQty()
    {
        return allocQty;
    }

    private final MutableDirectBuffer individualAllocID = new UnsafeBuffer();

    private int individualAllocIDOffset = 0;

    private int individualAllocIDLength = 0;

    /* IndividualAllocID = 467 */
    public AllocsGroupEncoder individualAllocID(final DirectBuffer value, final int offset, final int length)
    {
        individualAllocID.wrap(value);
        individualAllocIDOffset = offset;
        individualAllocIDLength = length;
        return this;
    }

    /* IndividualAllocID = 467 */
    public AllocsGroupEncoder individualAllocID(final DirectBuffer value, final int length)
    {
        return individualAllocID(value, 0, length);
    }

    /* IndividualAllocID = 467 */
    public AllocsGroupEncoder individualAllocID(final DirectBuffer value)
    {
        return individualAllocID(value, 0, value.capacity());
    }

    /* IndividualAllocID = 467 */
    public AllocsGroupEncoder individualAllocID(final byte[] value, final int offset, final int length)
    {
        individualAllocID.wrap(value);
        individualAllocIDOffset = offset;
        individualAllocIDLength = length;
        return this;
    }

    /* IndividualAllocID = 467 */
    public AllocsGroupEncoder individualAllocIDAsCopy(final byte[] value, final int offset, final int length)
    {
        copyInto(individualAllocID, value, offset, length);
        individualAllocIDOffset = offset;
        individualAllocIDLength = length;
        return this;
    }

    /* IndividualAllocID = 467 */
    public AllocsGroupEncoder individualAllocID(final byte[] value, final int length)
    {
        return individualAllocID(value, 0, length);
    }

    /* IndividualAllocID = 467 */
    public AllocsGroupEncoder individualAllocID(final byte[] value)
    {
        return individualAllocID(value, 0, value.length);
    }

    /* IndividualAllocID = 467 */
    public boolean hasIndividualAllocID()
    {
        return individualAllocIDLength > 0;
    }

    /* IndividualAllocID = 467 */
    public MutableDirectBuffer individualAllocID()
    {
        return individualAllocID;
    }

    /* IndividualAllocID = 467 */
    public String individualAllocIDAsString()
    {
        return individualAllocID.getStringWithoutLengthAscii(individualAllocIDOffset, individualAllocIDLength);
    }

    /* IndividualAllocID = 467 */
    public AllocsGroupEncoder individualAllocID(final CharSequence value)
    {
        toBytes(value, individualAllocID);
        individualAllocIDOffset = 0;
        individualAllocIDLength = value.length();
        return this;
    }

    /* IndividualAllocID = 467 */
    public AllocsGroupEncoder individualAllocID(final AsciiSequenceView value)
    {
        final DirectBuffer buffer = value.buffer();
        if (buffer != null)
        {
            individualAllocID.wrap(buffer);
            individualAllocIDOffset = value.offset();
            individualAllocIDLength = value.length();
        }
        return this;
    }

    /* IndividualAllocID = 467 */
    public AllocsGroupEncoder individualAllocID(final char[] value)
    {
        return individualAllocID(value, 0, value.length);
    }

    /* IndividualAllocID = 467 */
    public AllocsGroupEncoder individualAllocID(final char[] value, final int length)
    {
        return individualAllocID(value, 0, length);
    }

    /* IndividualAllocID = 467 */
    public AllocsGroupEncoder individualAllocID(final char[] value, final int offset, final int length)
    {
        toBytes(value, individualAllocID, offset, length);
        individualAllocIDOffset = 0;
        individualAllocIDLength = length;
        return this;
    }

    private char processCode;

    private boolean hasProcessCode;

    public boolean hasProcessCode()
    {
        return hasProcessCode;
    }

    /* ProcessCode = 81 */
    public AllocsGroupEncoder processCode(char value)
    {
        processCode = value;
        hasProcessCode = true;
        return this;
    }

    /* ProcessCode = 81 */
    public char processCode()
    {
        return processCode;
    }

    public AllocsGroupEncoder processCode(ProcessCode value)
    {
        if (CODEC_VALIDATION_ENABLED)
        {
            if (value == ProcessCode.ARTIO_UNKNOWN)
            {
                throw new EncodingException("Invalid Value Field: processCode Value: " + value );
            }
            if (value == ProcessCode.NULL_VAL)
            {
                return this;
            }
        }
        return processCode(value.representation());
    }

    private final NestedPartiesEncoder nestedParties = new NestedPartiesEncoder();
    public NestedPartiesEncoder nestedParties()
    {
        return nestedParties;
    }

    private boolean notifyBrokerOfCredit;

    private boolean hasNotifyBrokerOfCredit;

    public boolean hasNotifyBrokerOfCredit()
    {
        return hasNotifyBrokerOfCredit;
    }

    /* NotifyBrokerOfCredit = 208 */
    public AllocsGroupEncoder notifyBrokerOfCredit(boolean value)
    {
        notifyBrokerOfCredit = value;
        hasNotifyBrokerOfCredit = true;
        return this;
    }

    /* NotifyBrokerOfCredit = 208 */
    public boolean notifyBrokerOfCredit()
    {
        return notifyBrokerOfCredit;
    }

    private int allocHandlInst;

    private boolean hasAllocHandlInst;

    public boolean hasAllocHandlInst()
    {
        return hasAllocHandlInst;
    }

    /* AllocHandlInst = 209 */
    public AllocsGroupEncoder allocHandlInst(int value)
    {
        allocHandlInst = value;
        hasAllocHandlInst = true;
        return this;
    }

    /* AllocHandlInst = 209 */
    public int allocHandlInst()
    {
        return allocHandlInst;
    }

    public AllocsGroupEncoder allocHandlInst(AllocHandlInst value)
    {
        if (CODEC_VALIDATION_ENABLED)
        {
            if (value == AllocHandlInst.ARTIO_UNKNOWN)
            {
                throw new EncodingException("Invalid Value Field: allocHandlInst Value: " + value );
            }
            if (value == AllocHandlInst.NULL_VAL)
            {
                return this;
            }
        }
        return allocHandlInst(value.representation());
    }

    private final MutableDirectBuffer allocText = new UnsafeBuffer();

    private int allocTextOffset = 0;

    private int allocTextLength = 0;

    /* AllocText = 161 */
    public AllocsGroupEncoder allocText(final DirectBuffer value, final int offset, final int length)
    {
        allocText.wrap(value);
        allocTextOffset = offset;
        allocTextLength = length;
        return this;
    }

    /* AllocText = 161 */
    public AllocsGroupEncoder allocText(final DirectBuffer value, final int length)
    {
        return allocText(value, 0, length);
    }

    /* AllocText = 161 */
    public AllocsGroupEncoder allocText(final DirectBuffer value)
    {
        return allocText(value, 0, value.capacity());
    }

    /* AllocText = 161 */
    public AllocsGroupEncoder allocText(final byte[] value, final int offset, final int length)
    {
        allocText.wrap(value);
        allocTextOffset = offset;
        allocTextLength = length;
        return this;
    }

    /* AllocText = 161 */
    public AllocsGroupEncoder allocTextAsCopy(final byte[] value, final int offset, final int length)
    {
        copyInto(allocText, value, offset, length);
        allocTextOffset = offset;
        allocTextLength = length;
        return this;
    }

    /* AllocText = 161 */
    public AllocsGroupEncoder allocText(final byte[] value, final int length)
    {
        return allocText(value, 0, length);
    }

    /* AllocText = 161 */
    public AllocsGroupEncoder allocText(final byte[] value)
    {
        return allocText(value, 0, value.length);
    }

    /* AllocText = 161 */
    public boolean hasAllocText()
    {
        return allocTextLength > 0;
    }

    /* AllocText = 161 */
    public MutableDirectBuffer allocText()
    {
        return allocText;
    }

    /* AllocText = 161 */
    public String allocTextAsString()
    {
        return allocText.getStringWithoutLengthAscii(allocTextOffset, allocTextLength);
    }

    /* AllocText = 161 */
    public AllocsGroupEncoder allocText(final CharSequence value)
    {
        toBytes(value, allocText);
        allocTextOffset = 0;
        allocTextLength = value.length();
        return this;
    }

    /* AllocText = 161 */
    public AllocsGroupEncoder allocText(final AsciiSequenceView value)
    {
        final DirectBuffer buffer = value.buffer();
        if (buffer != null)
        {
            allocText.wrap(buffer);
            allocTextOffset = value.offset();
            allocTextLength = value.length();
        }
        return this;
    }

    /* AllocText = 161 */
    public AllocsGroupEncoder allocText(final char[] value)
    {
        return allocText(value, 0, value.length);
    }

    /* AllocText = 161 */
    public AllocsGroupEncoder allocText(final char[] value, final int length)
    {
        return allocText(value, 0, length);
    }

    /* AllocText = 161 */
    public AllocsGroupEncoder allocText(final char[] value, final int offset, final int length)
    {
        toBytes(value, allocText, offset, length);
        allocTextOffset = 0;
        allocTextLength = length;
        return this;
    }

    private int encodedAllocTextLen;

    private boolean hasEncodedAllocTextLen;

    public boolean hasEncodedAllocTextLen()
    {
        return hasEncodedAllocTextLen;
    }

    /* EncodedAllocTextLen = 360 */
    public AllocsGroupEncoder encodedAllocTextLen(int value)
    {
        encodedAllocTextLen = value;
        hasEncodedAllocTextLen = true;
        return this;
    }

    /* EncodedAllocTextLen = 360 */
    public int encodedAllocTextLen()
    {
        return encodedAllocTextLen;
    }

    private byte[] encodedAllocText;

    private boolean hasEncodedAllocText;

    public boolean hasEncodedAllocText()
    {
        return hasEncodedAllocText;
    }

    /* EncodedAllocText = 361 */
    public AllocsGroupEncoder encodedAllocText(byte[] value)
    {
        encodedAllocText = value;
        hasEncodedAllocText = true;
        return this;
    }

    /* EncodedAllocText = 361 */
    public byte[] encodedAllocText()
    {
        return encodedAllocText;
    }

    /* EncodedAllocText = 361 */
    public AllocsGroupEncoder encodedAllocTextAsCopy(final byte[] value, final int offset, final int length)
    {
        encodedAllocText = copyInto(encodedAllocText, value, offset, length);
        hasEncodedAllocText = true;
        return this;
    }

    private final CommissionDataEncoder commissionData = new CommissionDataEncoder();
    public CommissionDataEncoder commissionData()
    {
        return commissionData;
    }

    private final DecimalFloat allocAvgPx = new DecimalFloat();

    private boolean hasAllocAvgPx;

    public boolean hasAllocAvgPx()
    {
        return hasAllocAvgPx;
    }

    /* AllocAvgPx = 153 */
    public AllocsGroupEncoder allocAvgPx(ReadOnlyDecimalFloat value)
    {
        allocAvgPx.set(value);
        hasAllocAvgPx = true;
        return this;
    }

    /* AllocAvgPx = 153 */
    public AllocsGroupEncoder allocAvgPx(long value, int scale)
    {
        allocAvgPx.set(value, scale);
        hasAllocAvgPx = true;
        return this;
    }

    /* AllocAvgPx = 153 */
    public DecimalFloat allocAvgPx()
    {
        return allocAvgPx;
    }

    private final DecimalFloat allocNetMoney = new DecimalFloat();

    private boolean hasAllocNetMoney;

    public boolean hasAllocNetMoney()
    {
        return hasAllocNetMoney;
    }

    /* AllocNetMoney = 154 */
    public AllocsGroupEncoder allocNetMoney(ReadOnlyDecimalFloat value)
    {
        allocNetMoney.set(value);
        hasAllocNetMoney = true;
        return this;
    }

    /* AllocNetMoney = 154 */
    public AllocsGroupEncoder allocNetMoney(long value, int scale)
    {
        allocNetMoney.set(value, scale);
        hasAllocNetMoney = true;
        return this;
    }

    /* AllocNetMoney = 154 */
    public DecimalFloat allocNetMoney()
    {
        return allocNetMoney;
    }

    private final DecimalFloat settlCurrAmt = new DecimalFloat();

    private boolean hasSettlCurrAmt;

    public boolean hasSettlCurrAmt()
    {
        return hasSettlCurrAmt;
    }

    /* SettlCurrAmt = 119 */
    public AllocsGroupEncoder settlCurrAmt(ReadOnlyDecimalFloat value)
    {
        settlCurrAmt.set(value);
        hasSettlCurrAmt = true;
        return this;
    }

    /* SettlCurrAmt = 119 */
    public AllocsGroupEncoder settlCurrAmt(long value, int scale)
    {
        settlCurrAmt.set(value, scale);
        hasSettlCurrAmt = true;
        return this;
    }

    /* SettlCurrAmt = 119 */
    public DecimalFloat settlCurrAmt()
    {
        return settlCurrAmt;
    }

    private final DecimalFloat allocSettlCurrAmt = new DecimalFloat();

    private boolean hasAllocSettlCurrAmt;

    public boolean hasAllocSettlCurrAmt()
    {
        return hasAllocSettlCurrAmt;
    }

    /* AllocSettlCurrAmt = 737 */
    public AllocsGroupEncoder allocSettlCurrAmt(ReadOnlyDecimalFloat value)
    {
        allocSettlCurrAmt.set(value);
        hasAllocSettlCurrAmt = true;
        return this;
    }

    /* AllocSettlCurrAmt = 737 */
    public AllocsGroupEncoder allocSettlCurrAmt(long value, int scale)
    {
        allocSettlCurrAmt.set(value, scale);
        hasAllocSettlCurrAmt = true;
        return this;
    }

    /* AllocSettlCurrAmt = 737 */
    public DecimalFloat allocSettlCurrAmt()
    {
        return allocSettlCurrAmt;
    }

    private final MutableDirectBuffer settlCurrency = new UnsafeBuffer();

    private int settlCurrencyOffset = 0;

    private int settlCurrencyLength = 0;

    /* SettlCurrency = 120 */
    public AllocsGroupEncoder settlCurrency(final DirectBuffer value, final int offset, final int length)
    {
        settlCurrency.wrap(value);
        settlCurrencyOffset = offset;
        settlCurrencyLength = length;
        return this;
    }

    /* SettlCurrency = 120 */
    public AllocsGroupEncoder settlCurrency(final DirectBuffer value, final int length)
    {
        return settlCurrency(value, 0, length);
    }

    /* SettlCurrency = 120 */
    public AllocsGroupEncoder settlCurrency(final DirectBuffer value)
    {
        return settlCurrency(value, 0, value.capacity());
    }

    /* SettlCurrency = 120 */
    public AllocsGroupEncoder settlCurrency(final byte[] value, final int offset, final int length)
    {
        settlCurrency.wrap(value);
        settlCurrencyOffset = offset;
        settlCurrencyLength = length;
        return this;
    }

    /* SettlCurrency = 120 */
    public AllocsGroupEncoder settlCurrencyAsCopy(final byte[] value, final int offset, final int length)
    {
        copyInto(settlCurrency, value, offset, length);
        settlCurrencyOffset = offset;
        settlCurrencyLength = length;
        return this;
    }

    /* SettlCurrency = 120 */
    public AllocsGroupEncoder settlCurrency(final byte[] value, final int length)
    {
        return settlCurrency(value, 0, length);
    }

    /* SettlCurrency = 120 */
    public AllocsGroupEncoder settlCurrency(final byte[] value)
    {
        return settlCurrency(value, 0, value.length);
    }

    /* SettlCurrency = 120 */
    public boolean hasSettlCurrency()
    {
        return settlCurrencyLength > 0;
    }

    /* SettlCurrency = 120 */
    public MutableDirectBuffer settlCurrency()
    {
        return settlCurrency;
    }

    /* SettlCurrency = 120 */
    public String settlCurrencyAsString()
    {
        return settlCurrency.getStringWithoutLengthAscii(settlCurrencyOffset, settlCurrencyLength);
    }

    /* SettlCurrency = 120 */
    public AllocsGroupEncoder settlCurrency(final CharSequence value)
    {
        toBytes(value, settlCurrency);
        settlCurrencyOffset = 0;
        settlCurrencyLength = value.length();
        return this;
    }

    /* SettlCurrency = 120 */
    public AllocsGroupEncoder settlCurrency(final AsciiSequenceView value)
    {
        final DirectBuffer buffer = value.buffer();
        if (buffer != null)
        {
            settlCurrency.wrap(buffer);
            settlCurrencyOffset = value.offset();
            settlCurrencyLength = value.length();
        }
        return this;
    }

    /* SettlCurrency = 120 */
    public AllocsGroupEncoder settlCurrency(final char[] value)
    {
        return settlCurrency(value, 0, value.length);
    }

    /* SettlCurrency = 120 */
    public AllocsGroupEncoder settlCurrency(final char[] value, final int length)
    {
        return settlCurrency(value, 0, length);
    }

    /* SettlCurrency = 120 */
    public AllocsGroupEncoder settlCurrency(final char[] value, final int offset, final int length)
    {
        toBytes(value, settlCurrency, offset, length);
        settlCurrencyOffset = 0;
        settlCurrencyLength = length;
        return this;
    }

    private final MutableDirectBuffer allocSettlCurrency = new UnsafeBuffer();

    private int allocSettlCurrencyOffset = 0;

    private int allocSettlCurrencyLength = 0;

    /* AllocSettlCurrency = 736 */
    public AllocsGroupEncoder allocSettlCurrency(final DirectBuffer value, final int offset, final int length)
    {
        allocSettlCurrency.wrap(value);
        allocSettlCurrencyOffset = offset;
        allocSettlCurrencyLength = length;
        return this;
    }

    /* AllocSettlCurrency = 736 */
    public AllocsGroupEncoder allocSettlCurrency(final DirectBuffer value, final int length)
    {
        return allocSettlCurrency(value, 0, length);
    }

    /* AllocSettlCurrency = 736 */
    public AllocsGroupEncoder allocSettlCurrency(final DirectBuffer value)
    {
        return allocSettlCurrency(value, 0, value.capacity());
    }

    /* AllocSettlCurrency = 736 */
    public AllocsGroupEncoder allocSettlCurrency(final byte[] value, final int offset, final int length)
    {
        allocSettlCurrency.wrap(value);
        allocSettlCurrencyOffset = offset;
        allocSettlCurrencyLength = length;
        return this;
    }

    /* AllocSettlCurrency = 736 */
    public AllocsGroupEncoder allocSettlCurrencyAsCopy(final byte[] value, final int offset, final int length)
    {
        copyInto(allocSettlCurrency, value, offset, length);
        allocSettlCurrencyOffset = offset;
        allocSettlCurrencyLength = length;
        return this;
    }

    /* AllocSettlCurrency = 736 */
    public AllocsGroupEncoder allocSettlCurrency(final byte[] value, final int length)
    {
        return allocSettlCurrency(value, 0, length);
    }

    /* AllocSettlCurrency = 736 */
    public AllocsGroupEncoder allocSettlCurrency(final byte[] value)
    {
        return allocSettlCurrency(value, 0, value.length);
    }

    /* AllocSettlCurrency = 736 */
    public boolean hasAllocSettlCurrency()
    {
        return allocSettlCurrencyLength > 0;
    }

    /* AllocSettlCurrency = 736 */
    public MutableDirectBuffer allocSettlCurrency()
    {
        return allocSettlCurrency;
    }

    /* AllocSettlCurrency = 736 */
    public String allocSettlCurrencyAsString()
    {
        return allocSettlCurrency.getStringWithoutLengthAscii(allocSettlCurrencyOffset, allocSettlCurrencyLength);
    }

    /* AllocSettlCurrency = 736 */
    public AllocsGroupEncoder allocSettlCurrency(final CharSequence value)
    {
        toBytes(value, allocSettlCurrency);
        allocSettlCurrencyOffset = 0;
        allocSettlCurrencyLength = value.length();
        return this;
    }

    /* AllocSettlCurrency = 736 */
    public AllocsGroupEncoder allocSettlCurrency(final AsciiSequenceView value)
    {
        final DirectBuffer buffer = value.buffer();
        if (buffer != null)
        {
            allocSettlCurrency.wrap(buffer);
            allocSettlCurrencyOffset = value.offset();
            allocSettlCurrencyLength = value.length();
        }
        return this;
    }

    /* AllocSettlCurrency = 736 */
    public AllocsGroupEncoder allocSettlCurrency(final char[] value)
    {
        return allocSettlCurrency(value, 0, value.length);
    }

    /* AllocSettlCurrency = 736 */
    public AllocsGroupEncoder allocSettlCurrency(final char[] value, final int length)
    {
        return allocSettlCurrency(value, 0, length);
    }

    /* AllocSettlCurrency = 736 */
    public AllocsGroupEncoder allocSettlCurrency(final char[] value, final int offset, final int length)
    {
        toBytes(value, allocSettlCurrency, offset, length);
        allocSettlCurrencyOffset = 0;
        allocSettlCurrencyLength = length;
        return this;
    }

    private final DecimalFloat settlCurrFxRate = new DecimalFloat();

    private boolean hasSettlCurrFxRate;

    public boolean hasSettlCurrFxRate()
    {
        return hasSettlCurrFxRate;
    }

    /* SettlCurrFxRate = 155 */
    public AllocsGroupEncoder settlCurrFxRate(ReadOnlyDecimalFloat value)
    {
        settlCurrFxRate.set(value);
        hasSettlCurrFxRate = true;
        return this;
    }

    /* SettlCurrFxRate = 155 */
    public AllocsGroupEncoder settlCurrFxRate(long value, int scale)
    {
        settlCurrFxRate.set(value, scale);
        hasSettlCurrFxRate = true;
        return this;
    }

    /* SettlCurrFxRate = 155 */
    public DecimalFloat settlCurrFxRate()
    {
        return settlCurrFxRate;
    }

    private char settlCurrFxRateCalc;

    private boolean hasSettlCurrFxRateCalc;

    public boolean hasSettlCurrFxRateCalc()
    {
        return hasSettlCurrFxRateCalc;
    }

    /* SettlCurrFxRateCalc = 156 */
    public AllocsGroupEncoder settlCurrFxRateCalc(char value)
    {
        settlCurrFxRateCalc = value;
        hasSettlCurrFxRateCalc = true;
        return this;
    }

    /* SettlCurrFxRateCalc = 156 */
    public char settlCurrFxRateCalc()
    {
        return settlCurrFxRateCalc;
    }

    public AllocsGroupEncoder settlCurrFxRateCalc(SettlCurrFxRateCalc value)
    {
        if (CODEC_VALIDATION_ENABLED)
        {
            if (value == SettlCurrFxRateCalc.ARTIO_UNKNOWN)
            {
                throw new EncodingException("Invalid Value Field: settlCurrFxRateCalc Value: " + value );
            }
            if (value == SettlCurrFxRateCalc.NULL_VAL)
            {
                return this;
            }
        }
        return settlCurrFxRateCalc(value.representation());
    }

    private final DecimalFloat accruedInterestAmt = new DecimalFloat();

    private boolean hasAccruedInterestAmt;

    public boolean hasAccruedInterestAmt()
    {
        return hasAccruedInterestAmt;
    }

    /* AccruedInterestAmt = 159 */
    public AllocsGroupEncoder accruedInterestAmt(ReadOnlyDecimalFloat value)
    {
        accruedInterestAmt.set(value);
        hasAccruedInterestAmt = true;
        return this;
    }

    /* AccruedInterestAmt = 159 */
    public AllocsGroupEncoder accruedInterestAmt(long value, int scale)
    {
        accruedInterestAmt.set(value, scale);
        hasAccruedInterestAmt = true;
        return this;
    }

    /* AccruedInterestAmt = 159 */
    public DecimalFloat accruedInterestAmt()
    {
        return accruedInterestAmt;
    }

    private final DecimalFloat allocAccruedInterestAmt = new DecimalFloat();

    private boolean hasAllocAccruedInterestAmt;

    public boolean hasAllocAccruedInterestAmt()
    {
        return hasAllocAccruedInterestAmt;
    }

    /* AllocAccruedInterestAmt = 742 */
    public AllocsGroupEncoder allocAccruedInterestAmt(ReadOnlyDecimalFloat value)
    {
        allocAccruedInterestAmt.set(value);
        hasAllocAccruedInterestAmt = true;
        return this;
    }

    /* AllocAccruedInterestAmt = 742 */
    public AllocsGroupEncoder allocAccruedInterestAmt(long value, int scale)
    {
        allocAccruedInterestAmt.set(value, scale);
        hasAllocAccruedInterestAmt = true;
        return this;
    }

    /* AllocAccruedInterestAmt = 742 */
    public DecimalFloat allocAccruedInterestAmt()
    {
        return allocAccruedInterestAmt;
    }

    private final DecimalFloat allocInterestAtMaturity = new DecimalFloat();

    private boolean hasAllocInterestAtMaturity;

    public boolean hasAllocInterestAtMaturity()
    {
        return hasAllocInterestAtMaturity;
    }

    /* AllocInterestAtMaturity = 741 */
    public AllocsGroupEncoder allocInterestAtMaturity(ReadOnlyDecimalFloat value)
    {
        allocInterestAtMaturity.set(value);
        hasAllocInterestAtMaturity = true;
        return this;
    }

    /* AllocInterestAtMaturity = 741 */
    public AllocsGroupEncoder allocInterestAtMaturity(long value, int scale)
    {
        allocInterestAtMaturity.set(value, scale);
        hasAllocInterestAtMaturity = true;
        return this;
    }

    /* AllocInterestAtMaturity = 741 */
    public DecimalFloat allocInterestAtMaturity()
    {
        return allocInterestAtMaturity;
    }

    private char settlInstMode;

    private boolean hasSettlInstMode;

    public boolean hasSettlInstMode()
    {
        return hasSettlInstMode;
    }

    /* SettlInstMode = 160 */
    public AllocsGroupEncoder settlInstMode(char value)
    {
        settlInstMode = value;
        hasSettlInstMode = true;
        return this;
    }

    /* SettlInstMode = 160 */
    public char settlInstMode()
    {
        return settlInstMode;
    }

    public AllocsGroupEncoder settlInstMode(SettlInstMode value)
    {
        if (CODEC_VALIDATION_ENABLED)
        {
            if (value == SettlInstMode.ARTIO_UNKNOWN)
            {
                throw new EncodingException("Invalid Value Field: settlInstMode Value: " + value );
            }
            if (value == SettlInstMode.NULL_VAL)
            {
                return this;
            }
        }
        return settlInstMode(value.representation());
    }


@Generated("uk.co.real_logic.artio")
public static class MiscFeesGroupEncoder
{
    private MiscFeesGroupEncoder next = null;

    public MiscFeesGroupEncoder next()
    {
        if (next == null)
        {
            next = new MiscFeesGroupEncoder();
        }
        return next;
    }

    private static final int miscFeeAmtHeaderLength = 4;
    private static final byte[] miscFeeAmtHeader = new byte[] {49, 51, 55, (byte) '='};

    private static final int miscFeeCurrHeaderLength = 4;
    private static final byte[] miscFeeCurrHeader = new byte[] {49, 51, 56, (byte) '='};

    private static final int miscFeeTypeHeaderLength = 4;
    private static final byte[] miscFeeTypeHeader = new byte[] {49, 51, 57, (byte) '='};

    private static final int miscFeeBasisHeaderLength = 4;
    private static final byte[] miscFeeBasisHeader = new byte[] {56, 57, 49, (byte) '='};

    private final DecimalFloat miscFeeAmt = new DecimalFloat();

    private boolean hasMiscFeeAmt;

    public boolean hasMiscFeeAmt()
    {
        return hasMiscFeeAmt;
    }

    /* MiscFeeAmt = 137 */
    public MiscFeesGroupEncoder miscFeeAmt(ReadOnlyDecimalFloat value)
    {
        miscFeeAmt.set(value);
        hasMiscFeeAmt = true;
        return this;
    }

    /* MiscFeeAmt = 137 */
    public MiscFeesGroupEncoder miscFeeAmt(long value, int scale)
    {
        miscFeeAmt.set(value, scale);
        hasMiscFeeAmt = true;
        return this;
    }

    /* MiscFeeAmt = 137 */
    public DecimalFloat miscFeeAmt()
    {
        return miscFeeAmt;
    }

    private final MutableDirectBuffer miscFeeCurr = new UnsafeBuffer();

    private int miscFeeCurrOffset = 0;

    private int miscFeeCurrLength = 0;

    /* MiscFeeCurr = 138 */
    public MiscFeesGroupEncoder miscFeeCurr(final DirectBuffer value, final int offset, final int length)
    {
        miscFeeCurr.wrap(value);
        miscFeeCurrOffset = offset;
        miscFeeCurrLength = length;
        return this;
    }

    /* MiscFeeCurr = 138 */
    public MiscFeesGroupEncoder miscFeeCurr(final DirectBuffer value, final int length)
    {
        return miscFeeCurr(value, 0, length);
    }

    /* MiscFeeCurr = 138 */
    public MiscFeesGroupEncoder miscFeeCurr(final DirectBuffer value)
    {
        return miscFeeCurr(value, 0, value.capacity());
    }

    /* MiscFeeCurr = 138 */
    public MiscFeesGroupEncoder miscFeeCurr(final byte[] value, final int offset, final int length)
    {
        miscFeeCurr.wrap(value);
        miscFeeCurrOffset = offset;
        miscFeeCurrLength = length;
        return this;
    }

    /* MiscFeeCurr = 138 */
    public MiscFeesGroupEncoder miscFeeCurrAsCopy(final byte[] value, final int offset, final int length)
    {
        copyInto(miscFeeCurr, value, offset, length);
        miscFeeCurrOffset = offset;
        miscFeeCurrLength = length;
        return this;
    }

    /* MiscFeeCurr = 138 */
    public MiscFeesGroupEncoder miscFeeCurr(final byte[] value, final int length)
    {
        return miscFeeCurr(value, 0, length);
    }

    /* MiscFeeCurr = 138 */
    public MiscFeesGroupEncoder miscFeeCurr(final byte[] value)
    {
        return miscFeeCurr(value, 0, value.length);
    }

    /* MiscFeeCurr = 138 */
    public boolean hasMiscFeeCurr()
    {
        return miscFeeCurrLength > 0;
    }

    /* MiscFeeCurr = 138 */
    public MutableDirectBuffer miscFeeCurr()
    {
        return miscFeeCurr;
    }

    /* MiscFeeCurr = 138 */
    public String miscFeeCurrAsString()
    {
        return miscFeeCurr.getStringWithoutLengthAscii(miscFeeCurrOffset, miscFeeCurrLength);
    }

    /* MiscFeeCurr = 138 */
    public MiscFeesGroupEncoder miscFeeCurr(final CharSequence value)
    {
        toBytes(value, miscFeeCurr);
        miscFeeCurrOffset = 0;
        miscFeeCurrLength = value.length();
        return this;
    }

    /* MiscFeeCurr = 138 */
    public MiscFeesGroupEncoder miscFeeCurr(final AsciiSequenceView value)
    {
        final DirectBuffer buffer = value.buffer();
        if (buffer != null)
        {
            miscFeeCurr.wrap(buffer);
            miscFeeCurrOffset = value.offset();
            miscFeeCurrLength = value.length();
        }
        return this;
    }

    /* MiscFeeCurr = 138 */
    public MiscFeesGroupEncoder miscFeeCurr(final char[] value)
    {
        return miscFeeCurr(value, 0, value.length);
    }

    /* MiscFeeCurr = 138 */
    public MiscFeesGroupEncoder miscFeeCurr(final char[] value, final int length)
    {
        return miscFeeCurr(value, 0, length);
    }

    /* MiscFeeCurr = 138 */
    public MiscFeesGroupEncoder miscFeeCurr(final char[] value, final int offset, final int length)
    {
        toBytes(value, miscFeeCurr, offset, length);
        miscFeeCurrOffset = 0;
        miscFeeCurrLength = length;
        return this;
    }

    private char miscFeeType;

    private boolean hasMiscFeeType;

    public boolean hasMiscFeeType()
    {
        return hasMiscFeeType;
    }

    /* MiscFeeType = 139 */
    public MiscFeesGroupEncoder miscFeeType(char value)
    {
        miscFeeType = value;
        hasMiscFeeType = true;
        return this;
    }

    /* MiscFeeType = 139 */
    public char miscFeeType()
    {
        return miscFeeType;
    }

    public MiscFeesGroupEncoder miscFeeType(MiscFeeType value)
    {
        if (CODEC_VALIDATION_ENABLED)
        {
            if (value == MiscFeeType.ARTIO_UNKNOWN)
            {
                throw new EncodingException("Invalid Value Field: miscFeeType Value: " + value );
            }
            if (value == MiscFeeType.NULL_VAL)
            {
                return this;
            }
        }
        return miscFeeType(value.representation());
    }

    private int miscFeeBasis;

    private boolean hasMiscFeeBasis;

    public boolean hasMiscFeeBasis()
    {
        return hasMiscFeeBasis;
    }

    /* MiscFeeBasis = 891 */
    public MiscFeesGroupEncoder miscFeeBasis(int value)
    {
        miscFeeBasis = value;
        hasMiscFeeBasis = true;
        return this;
    }

    /* MiscFeeBasis = 891 */
    public int miscFeeBasis()
    {
        return miscFeeBasis;
    }

    public MiscFeesGroupEncoder miscFeeBasis(MiscFeeBasis value)
    {
        if (CODEC_VALIDATION_ENABLED)
        {
            if (value == MiscFeeBasis.ARTIO_UNKNOWN)
            {
                throw new EncodingException("Invalid Value Field: miscFeeBasis Value: " + value );
            }
            if (value == MiscFeeBasis.NULL_VAL)
            {
                return this;
            }
        }
        return miscFeeBasis(value.representation());
    }

    public int encode(final MutableAsciiBuffer buffer, final int offset, final int remainingElements)
    {
        if (remainingElements == 0)
        {
            return 0;
        }

        int position = offset;

        if (hasMiscFeeAmt)
        {
            buffer.putBytes(position, miscFeeAmtHeader, 0, miscFeeAmtHeaderLength);
            position += miscFeeAmtHeaderLength;
            position += buffer.putFloatAscii(position, miscFeeAmt);
            buffer.putSeparator(position);
            position++;
        }

        if (miscFeeCurrLength > 0)
        {
            buffer.putBytes(position, miscFeeCurrHeader, 0, miscFeeCurrHeaderLength);
            position += miscFeeCurrHeaderLength;
            buffer.putBytes(position, miscFeeCurr, miscFeeCurrOffset, miscFeeCurrLength);
            position += miscFeeCurrLength;
            buffer.putSeparator(position);
            position++;
        }

        if (hasMiscFeeType)
        {
            buffer.putBytes(position, miscFeeTypeHeader, 0, miscFeeTypeHeaderLength);
            position += miscFeeTypeHeaderLength;
            position += buffer.putCharAscii(position, miscFeeType);
            buffer.putSeparator(position);
            position++;
        }

        if (hasMiscFeeBasis)
        {
            buffer.putBytes(position, miscFeeBasisHeader, 0, miscFeeBasisHeaderLength);
            position += miscFeeBasisHeaderLength;
            position += buffer.putIntAscii(position, miscFeeBasis);
            buffer.putSeparator(position);
            position++;
        }
        if (next != null)
        {
            position += next.encode(buffer, position, remainingElements - 1);
        }
        return position - offset;
    }

    public void reset()
    {
        this.resetMiscFeeAmt();
        this.resetMiscFeeCurr();
        this.resetMiscFeeType();
        this.resetMiscFeeBasis();
        if (next != null)        {
            next.reset();
        }
    }

    public void resetMiscFeeAmt()
    {
        hasMiscFeeAmt = false;
    }

    public void resetMiscFeeCurr()
    {
        miscFeeCurrLength = 0;
    }

    public void resetMiscFeeType()
    {
        hasMiscFeeType = false;
    }

    public void resetMiscFeeBasis()
    {
        hasMiscFeeBasis = false;
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
        builder.append("\"MessageName\": \"MiscFeesGroup\",\n");
        if (hasMiscFeeAmt())
        {
            indent(builder, level);
            builder.append("\"MiscFeeAmt\": \"");
            miscFeeAmt.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasMiscFeeCurr())
        {
            indent(builder, level);
            builder.append("\"MiscFeeCurr\": \"");
            appendBuffer(builder, miscFeeCurr, miscFeeCurrOffset, miscFeeCurrLength);
            builder.append("\",\n");
        }

        if (hasMiscFeeType())
        {
            indent(builder, level);
            builder.append("\"MiscFeeType\": \"");
            builder.append(miscFeeType);
            builder.append("\",\n");
        }

        if (hasMiscFeeBasis())
        {
            indent(builder, level);
            builder.append("\"MiscFeeBasis\": \"");
            builder.append(miscFeeBasis);
            builder.append("\",\n");
        }
        indent(builder, level - 1);
        builder.append("}");
        return builder;
    }

    /**
     * {@inheritDoc}
     */
    public MiscFeesGroupEncoder copyTo(final Encoder encoder)
    {
        return copyTo((MiscFeesGroupEncoder)encoder);
    }

    public MiscFeesGroupEncoder copyTo(final MiscFeesGroupEncoder encoder)
    {
        encoder.reset();
        if (hasMiscFeeAmt())
        {
            encoder.miscFeeAmt(this.miscFeeAmt());
        }

        if (hasMiscFeeCurr())
        {
            encoder.miscFeeCurrAsCopy(miscFeeCurr.byteArray(), 0, miscFeeCurrLength);
        }

        if (hasMiscFeeType())
        {
            encoder.miscFeeType(this.miscFeeType());
        }

        if (hasMiscFeeBasis())
        {
            encoder.miscFeeBasis(this.miscFeeBasis());
        }
        return encoder;
    }

}
    private int noMiscFeesGroupCounter;

    private boolean hasNoMiscFeesGroupCounter;

    public boolean hasNoMiscFeesGroupCounter()
    {
        return hasNoMiscFeesGroupCounter;
    }

    /* NoMiscFeesGroupCounter = 136 */
    public AllocsGroupEncoder noMiscFeesGroupCounter(int value)
    {
        noMiscFeesGroupCounter = value;
        hasNoMiscFeesGroupCounter = true;
        return this;
    }

    /* NoMiscFeesGroupCounter = 136 */
    public int noMiscFeesGroupCounter()
    {
        return noMiscFeesGroupCounter;
    }


    private MiscFeesGroupEncoder miscFeesGroup = null;

    public MiscFeesGroupEncoder miscFeesGroup(final int numberOfElements)
    {
        hasNoMiscFeesGroupCounter = true;
        noMiscFeesGroupCounter = numberOfElements;
        if (miscFeesGroup == null)
        {
            miscFeesGroup = new MiscFeesGroupEncoder();
        }
        return miscFeesGroup;
    }

    private int noClearingInstructions;

    private boolean hasNoClearingInstructions;

    public boolean hasNoClearingInstructions()
    {
        return hasNoClearingInstructions;
    }

    /* NoClearingInstructions = 576 */
    public AllocsGroupEncoder noClearingInstructions(int value)
    {
        noClearingInstructions = value;
        hasNoClearingInstructions = true;
        return this;
    }

    /* NoClearingInstructions = 576 */
    public int noClearingInstructions()
    {
        return noClearingInstructions;
    }

    private int clearingInstruction;

    private boolean hasClearingInstruction;

    public boolean hasClearingInstruction()
    {
        return hasClearingInstruction;
    }

    /* ClearingInstruction = 577 */
    public AllocsGroupEncoder clearingInstruction(int value)
    {
        clearingInstruction = value;
        hasClearingInstruction = true;
        return this;
    }

    /* ClearingInstruction = 577 */
    public int clearingInstruction()
    {
        return clearingInstruction;
    }

    public AllocsGroupEncoder clearingInstruction(ClearingInstruction value)
    {
        if (CODEC_VALIDATION_ENABLED)
        {
            if (value == ClearingInstruction.ARTIO_UNKNOWN)
            {
                throw new EncodingException("Invalid Value Field: clearingInstruction Value: " + value );
            }
            if (value == ClearingInstruction.NULL_VAL)
            {
                return this;
            }
        }
        return clearingInstruction(value.representation());
    }

    private final MutableDirectBuffer clearingFeeIndicator = new UnsafeBuffer();

    private int clearingFeeIndicatorOffset = 0;

    private int clearingFeeIndicatorLength = 0;

    /* ClearingFeeIndicator = 635 */
    public AllocsGroupEncoder clearingFeeIndicator(final DirectBuffer value, final int offset, final int length)
    {
        clearingFeeIndicator.wrap(value);
        clearingFeeIndicatorOffset = offset;
        clearingFeeIndicatorLength = length;
        return this;
    }

    /* ClearingFeeIndicator = 635 */
    public AllocsGroupEncoder clearingFeeIndicator(final DirectBuffer value, final int length)
    {
        return clearingFeeIndicator(value, 0, length);
    }

    /* ClearingFeeIndicator = 635 */
    public AllocsGroupEncoder clearingFeeIndicator(final DirectBuffer value)
    {
        return clearingFeeIndicator(value, 0, value.capacity());
    }

    /* ClearingFeeIndicator = 635 */
    public AllocsGroupEncoder clearingFeeIndicator(final byte[] value, final int offset, final int length)
    {
        clearingFeeIndicator.wrap(value);
        clearingFeeIndicatorOffset = offset;
        clearingFeeIndicatorLength = length;
        return this;
    }

    /* ClearingFeeIndicator = 635 */
    public AllocsGroupEncoder clearingFeeIndicatorAsCopy(final byte[] value, final int offset, final int length)
    {
        copyInto(clearingFeeIndicator, value, offset, length);
        clearingFeeIndicatorOffset = offset;
        clearingFeeIndicatorLength = length;
        return this;
    }

    /* ClearingFeeIndicator = 635 */
    public AllocsGroupEncoder clearingFeeIndicator(final byte[] value, final int length)
    {
        return clearingFeeIndicator(value, 0, length);
    }

    /* ClearingFeeIndicator = 635 */
    public AllocsGroupEncoder clearingFeeIndicator(final byte[] value)
    {
        return clearingFeeIndicator(value, 0, value.length);
    }

    /* ClearingFeeIndicator = 635 */
    public boolean hasClearingFeeIndicator()
    {
        return clearingFeeIndicatorLength > 0;
    }

    /* ClearingFeeIndicator = 635 */
    public MutableDirectBuffer clearingFeeIndicator()
    {
        return clearingFeeIndicator;
    }

    /* ClearingFeeIndicator = 635 */
    public String clearingFeeIndicatorAsString()
    {
        return clearingFeeIndicator.getStringWithoutLengthAscii(clearingFeeIndicatorOffset, clearingFeeIndicatorLength);
    }

    /* ClearingFeeIndicator = 635 */
    public AllocsGroupEncoder clearingFeeIndicator(final CharSequence value)
    {
        toBytes(value, clearingFeeIndicator);
        clearingFeeIndicatorOffset = 0;
        clearingFeeIndicatorLength = value.length();
        return this;
    }

    /* ClearingFeeIndicator = 635 */
    public AllocsGroupEncoder clearingFeeIndicator(final AsciiSequenceView value)
    {
        final DirectBuffer buffer = value.buffer();
        if (buffer != null)
        {
            clearingFeeIndicator.wrap(buffer);
            clearingFeeIndicatorOffset = value.offset();
            clearingFeeIndicatorLength = value.length();
        }
        return this;
    }

    /* ClearingFeeIndicator = 635 */
    public AllocsGroupEncoder clearingFeeIndicator(final char[] value)
    {
        return clearingFeeIndicator(value, 0, value.length);
    }

    /* ClearingFeeIndicator = 635 */
    public AllocsGroupEncoder clearingFeeIndicator(final char[] value, final int length)
    {
        return clearingFeeIndicator(value, 0, length);
    }

    /* ClearingFeeIndicator = 635 */
    public AllocsGroupEncoder clearingFeeIndicator(final char[] value, final int offset, final int length)
    {
        toBytes(value, clearingFeeIndicator, offset, length);
        clearingFeeIndicatorOffset = 0;
        clearingFeeIndicatorLength = length;
        return this;
    }

    public AllocsGroupEncoder clearingFeeIndicator(ClearingFeeIndicator value)
    {
        if (CODEC_VALIDATION_ENABLED)
        {
            if (value == ClearingFeeIndicator.ARTIO_UNKNOWN)
            {
                throw new EncodingException("Invalid Value Field: clearingFeeIndicator Value: " + value );
            }
            if (value == ClearingFeeIndicator.NULL_VAL)
            {
                return this;
            }
        }
        return clearingFeeIndicator(value.representation());
    }

    private int allocSettlInstType;

    private boolean hasAllocSettlInstType;

    public boolean hasAllocSettlInstType()
    {
        return hasAllocSettlInstType;
    }

    /* AllocSettlInstType = 780 */
    public AllocsGroupEncoder allocSettlInstType(int value)
    {
        allocSettlInstType = value;
        hasAllocSettlInstType = true;
        return this;
    }

    /* AllocSettlInstType = 780 */
    public int allocSettlInstType()
    {
        return allocSettlInstType;
    }

    public AllocsGroupEncoder allocSettlInstType(AllocSettlInstType value)
    {
        if (CODEC_VALIDATION_ENABLED)
        {
            if (value == AllocSettlInstType.ARTIO_UNKNOWN)
            {
                throw new EncodingException("Invalid Value Field: allocSettlInstType Value: " + value );
            }
            if (value == AllocSettlInstType.NULL_VAL)
            {
                return this;
            }
        }
        return allocSettlInstType(value.representation());
    }

    private final SettlInstructionsDataEncoder settlInstructionsData = new SettlInstructionsDataEncoder();
    public SettlInstructionsDataEncoder settlInstructionsData()
    {
        return settlInstructionsData;
    }

    public int encode(final MutableAsciiBuffer buffer, final int offset, final int remainingElements)
    {
        if (remainingElements == 0)
        {
            return 0;
        }

        int position = offset;

        if (allocAccountLength > 0)
        {
            buffer.putBytes(position, allocAccountHeader, 0, allocAccountHeaderLength);
            position += allocAccountHeaderLength;
            buffer.putBytes(position, allocAccount, allocAccountOffset, allocAccountLength);
            position += allocAccountLength;
            buffer.putSeparator(position);
            position++;
        }
        else if (CODEC_VALIDATION_ENABLED)
        {
            throw new EncodingException("Missing Field: AllocAccount");
        }

        if (hasAllocAcctIDSource)
        {
            buffer.putBytes(position, allocAcctIDSourceHeader, 0, allocAcctIDSourceHeaderLength);
            position += allocAcctIDSourceHeaderLength;
            position += buffer.putIntAscii(position, allocAcctIDSource);
            buffer.putSeparator(position);
            position++;
        }

        if (hasMatchStatus)
        {
            buffer.putBytes(position, matchStatusHeader, 0, matchStatusHeaderLength);
            position += matchStatusHeaderLength;
            position += buffer.putCharAscii(position, matchStatus);
            buffer.putSeparator(position);
            position++;
        }

        if (hasAllocPrice)
        {
            buffer.putBytes(position, allocPriceHeader, 0, allocPriceHeaderLength);
            position += allocPriceHeaderLength;
            position += buffer.putFloatAscii(position, allocPrice);
            buffer.putSeparator(position);
            position++;
        }

        if (hasAllocQty)
        {
            buffer.putBytes(position, allocQtyHeader, 0, allocQtyHeaderLength);
            position += allocQtyHeaderLength;
            position += buffer.putFloatAscii(position, allocQty);
            buffer.putSeparator(position);
            position++;
        }
        else if (CODEC_VALIDATION_ENABLED)
        {
            throw new EncodingException("Missing Field: AllocQty");
        }

        if (individualAllocIDLength > 0)
        {
            buffer.putBytes(position, individualAllocIDHeader, 0, individualAllocIDHeaderLength);
            position += individualAllocIDHeaderLength;
            buffer.putBytes(position, individualAllocID, individualAllocIDOffset, individualAllocIDLength);
            position += individualAllocIDLength;
            buffer.putSeparator(position);
            position++;
        }

        if (hasProcessCode)
        {
            buffer.putBytes(position, processCodeHeader, 0, processCodeHeaderLength);
            position += processCodeHeaderLength;
            position += buffer.putCharAscii(position, processCode);
            buffer.putSeparator(position);
            position++;
        }

            position += nestedParties.encode(buffer, position);

        if (hasNotifyBrokerOfCredit)
        {
            buffer.putBytes(position, notifyBrokerOfCreditHeader, 0, notifyBrokerOfCreditHeaderLength);
            position += notifyBrokerOfCreditHeaderLength;
            position += buffer.putBooleanAscii(position, notifyBrokerOfCredit);
            buffer.putSeparator(position);
            position++;
        }

        if (hasAllocHandlInst)
        {
            buffer.putBytes(position, allocHandlInstHeader, 0, allocHandlInstHeaderLength);
            position += allocHandlInstHeaderLength;
            position += buffer.putIntAscii(position, allocHandlInst);
            buffer.putSeparator(position);
            position++;
        }

        if (allocTextLength > 0)
        {
            buffer.putBytes(position, allocTextHeader, 0, allocTextHeaderLength);
            position += allocTextHeaderLength;
            buffer.putBytes(position, allocText, allocTextOffset, allocTextLength);
            position += allocTextLength;
            buffer.putSeparator(position);
            position++;
        }

        if (hasEncodedAllocTextLen)
        {
            buffer.putBytes(position, encodedAllocTextLenHeader, 0, encodedAllocTextLenHeaderLength);
            position += encodedAllocTextLenHeaderLength;
            position += buffer.putIntAscii(position, encodedAllocTextLen);
            buffer.putSeparator(position);
            position++;
        }

        if (hasEncodedAllocText)
        {
            buffer.putBytes(position, encodedAllocTextHeader, 0, encodedAllocTextHeaderLength);
            position += encodedAllocTextHeaderLength;
            buffer.putBytes(position, encodedAllocText);
            position += encodedAllocText.length;
            buffer.putSeparator(position);
            position++;
        }

            position += commissionData.encode(buffer, position);

        if (hasAllocAvgPx)
        {
            buffer.putBytes(position, allocAvgPxHeader, 0, allocAvgPxHeaderLength);
            position += allocAvgPxHeaderLength;
            position += buffer.putFloatAscii(position, allocAvgPx);
            buffer.putSeparator(position);
            position++;
        }

        if (hasAllocNetMoney)
        {
            buffer.putBytes(position, allocNetMoneyHeader, 0, allocNetMoneyHeaderLength);
            position += allocNetMoneyHeaderLength;
            position += buffer.putFloatAscii(position, allocNetMoney);
            buffer.putSeparator(position);
            position++;
        }

        if (hasSettlCurrAmt)
        {
            buffer.putBytes(position, settlCurrAmtHeader, 0, settlCurrAmtHeaderLength);
            position += settlCurrAmtHeaderLength;
            position += buffer.putFloatAscii(position, settlCurrAmt);
            buffer.putSeparator(position);
            position++;
        }

        if (hasAllocSettlCurrAmt)
        {
            buffer.putBytes(position, allocSettlCurrAmtHeader, 0, allocSettlCurrAmtHeaderLength);
            position += allocSettlCurrAmtHeaderLength;
            position += buffer.putFloatAscii(position, allocSettlCurrAmt);
            buffer.putSeparator(position);
            position++;
        }

        if (settlCurrencyLength > 0)
        {
            buffer.putBytes(position, settlCurrencyHeader, 0, settlCurrencyHeaderLength);
            position += settlCurrencyHeaderLength;
            buffer.putBytes(position, settlCurrency, settlCurrencyOffset, settlCurrencyLength);
            position += settlCurrencyLength;
            buffer.putSeparator(position);
            position++;
        }

        if (allocSettlCurrencyLength > 0)
        {
            buffer.putBytes(position, allocSettlCurrencyHeader, 0, allocSettlCurrencyHeaderLength);
            position += allocSettlCurrencyHeaderLength;
            buffer.putBytes(position, allocSettlCurrency, allocSettlCurrencyOffset, allocSettlCurrencyLength);
            position += allocSettlCurrencyLength;
            buffer.putSeparator(position);
            position++;
        }

        if (hasSettlCurrFxRate)
        {
            buffer.putBytes(position, settlCurrFxRateHeader, 0, settlCurrFxRateHeaderLength);
            position += settlCurrFxRateHeaderLength;
            position += buffer.putFloatAscii(position, settlCurrFxRate);
            buffer.putSeparator(position);
            position++;
        }

        if (hasSettlCurrFxRateCalc)
        {
            buffer.putBytes(position, settlCurrFxRateCalcHeader, 0, settlCurrFxRateCalcHeaderLength);
            position += settlCurrFxRateCalcHeaderLength;
            position += buffer.putCharAscii(position, settlCurrFxRateCalc);
            buffer.putSeparator(position);
            position++;
        }

        if (hasAccruedInterestAmt)
        {
            buffer.putBytes(position, accruedInterestAmtHeader, 0, accruedInterestAmtHeaderLength);
            position += accruedInterestAmtHeaderLength;
            position += buffer.putFloatAscii(position, accruedInterestAmt);
            buffer.putSeparator(position);
            position++;
        }

        if (hasAllocAccruedInterestAmt)
        {
            buffer.putBytes(position, allocAccruedInterestAmtHeader, 0, allocAccruedInterestAmtHeaderLength);
            position += allocAccruedInterestAmtHeaderLength;
            position += buffer.putFloatAscii(position, allocAccruedInterestAmt);
            buffer.putSeparator(position);
            position++;
        }

        if (hasAllocInterestAtMaturity)
        {
            buffer.putBytes(position, allocInterestAtMaturityHeader, 0, allocInterestAtMaturityHeaderLength);
            position += allocInterestAtMaturityHeaderLength;
            position += buffer.putFloatAscii(position, allocInterestAtMaturity);
            buffer.putSeparator(position);
            position++;
        }

        if (hasSettlInstMode)
        {
            buffer.putBytes(position, settlInstModeHeader, 0, settlInstModeHeaderLength);
            position += settlInstModeHeaderLength;
            position += buffer.putCharAscii(position, settlInstMode);
            buffer.putSeparator(position);
            position++;
        }

        if (hasNoMiscFeesGroupCounter)
        {
            buffer.putBytes(position, noMiscFeesGroupCounterHeader, 0, noMiscFeesGroupCounterHeaderLength);
            position += noMiscFeesGroupCounterHeaderLength;
            position += buffer.putIntAscii(position, noMiscFeesGroupCounter);
            buffer.putSeparator(position);
            position++;
        }

        if (miscFeesGroup != null)
        {
            position += miscFeesGroup.encode(buffer, position, noMiscFeesGroupCounter);
        }


        if (hasNoClearingInstructions)
        {
            buffer.putBytes(position, noClearingInstructionsHeader, 0, noClearingInstructionsHeaderLength);
            position += noClearingInstructionsHeaderLength;
            position += buffer.putIntAscii(position, noClearingInstructions);
            buffer.putSeparator(position);
            position++;
        }

        if (hasClearingInstruction)
        {
            buffer.putBytes(position, clearingInstructionHeader, 0, clearingInstructionHeaderLength);
            position += clearingInstructionHeaderLength;
            position += buffer.putIntAscii(position, clearingInstruction);
            buffer.putSeparator(position);
            position++;
        }

        if (clearingFeeIndicatorLength > 0)
        {
            buffer.putBytes(position, clearingFeeIndicatorHeader, 0, clearingFeeIndicatorHeaderLength);
            position += clearingFeeIndicatorHeaderLength;
            buffer.putBytes(position, clearingFeeIndicator, clearingFeeIndicatorOffset, clearingFeeIndicatorLength);
            position += clearingFeeIndicatorLength;
            buffer.putSeparator(position);
            position++;
        }

        if (hasAllocSettlInstType)
        {
            buffer.putBytes(position, allocSettlInstTypeHeader, 0, allocSettlInstTypeHeaderLength);
            position += allocSettlInstTypeHeaderLength;
            position += buffer.putIntAscii(position, allocSettlInstType);
            buffer.putSeparator(position);
            position++;
        }

            position += settlInstructionsData.encode(buffer, position);
        if (next != null)
        {
            position += next.encode(buffer, position, remainingElements - 1);
        }
        return position - offset;
    }

    public void reset()
    {
        this.resetAllocAccount();
        this.resetAllocAcctIDSource();
        this.resetMatchStatus();
        this.resetAllocPrice();
        this.resetAllocQty();
        this.resetIndividualAllocID();
        this.resetProcessCode();
        this.resetNotifyBrokerOfCredit();
        this.resetAllocHandlInst();
        this.resetAllocText();
        this.resetEncodedAllocTextLen();
        this.resetEncodedAllocText();
        this.resetAllocAvgPx();
        this.resetAllocNetMoney();
        this.resetSettlCurrAmt();
        this.resetAllocSettlCurrAmt();
        this.resetSettlCurrency();
        this.resetAllocSettlCurrency();
        this.resetSettlCurrFxRate();
        this.resetSettlCurrFxRateCalc();
        this.resetAccruedInterestAmt();
        this.resetAllocAccruedInterestAmt();
        this.resetAllocInterestAtMaturity();
        this.resetSettlInstMode();
        this.resetNoClearingInstructions();
        this.resetClearingInstruction();
        this.resetClearingFeeIndicator();
        this.resetAllocSettlInstType();
        nestedParties.reset();
        commissionData.reset();
        settlInstructionsData.reset();
        this.resetMiscFeesGroup();
        if (next != null)        {
            next.reset();
        }
    }

    public void resetAllocAccount()
    {
        allocAccountLength = 0;
    }

    public void resetAllocAcctIDSource()
    {
        hasAllocAcctIDSource = false;
    }

    public void resetMatchStatus()
    {
        hasMatchStatus = false;
    }

    public void resetAllocPrice()
    {
        hasAllocPrice = false;
    }

    public void resetAllocQty()
    {
        hasAllocQty = false;
    }

    public void resetIndividualAllocID()
    {
        individualAllocIDLength = 0;
    }

    public void resetProcessCode()
    {
        hasProcessCode = false;
    }

    public void resetNotifyBrokerOfCredit()
    {
        hasNotifyBrokerOfCredit = false;
    }

    public void resetAllocHandlInst()
    {
        hasAllocHandlInst = false;
    }

    public void resetAllocText()
    {
        allocTextLength = 0;
    }

    public void resetEncodedAllocTextLen()
    {
        hasEncodedAllocTextLen = false;
    }

    public void resetEncodedAllocText()
    {
        hasEncodedAllocText = false;
    }

    public void resetAllocAvgPx()
    {
        hasAllocAvgPx = false;
    }

    public void resetAllocNetMoney()
    {
        hasAllocNetMoney = false;
    }

    public void resetSettlCurrAmt()
    {
        hasSettlCurrAmt = false;
    }

    public void resetAllocSettlCurrAmt()
    {
        hasAllocSettlCurrAmt = false;
    }

    public void resetSettlCurrency()
    {
        settlCurrencyLength = 0;
    }

    public void resetAllocSettlCurrency()
    {
        allocSettlCurrencyLength = 0;
    }

    public void resetSettlCurrFxRate()
    {
        hasSettlCurrFxRate = false;
    }

    public void resetSettlCurrFxRateCalc()
    {
        hasSettlCurrFxRateCalc = false;
    }

    public void resetAccruedInterestAmt()
    {
        hasAccruedInterestAmt = false;
    }

    public void resetAllocAccruedInterestAmt()
    {
        hasAllocAccruedInterestAmt = false;
    }

    public void resetAllocInterestAtMaturity()
    {
        hasAllocInterestAtMaturity = false;
    }

    public void resetSettlInstMode()
    {
        hasSettlInstMode = false;
    }

    public void resetNoClearingInstructions()
    {
        hasNoClearingInstructions = false;
    }

    public void resetClearingInstruction()
    {
        hasClearingInstruction = false;
    }

    public void resetClearingFeeIndicator()
    {
        clearingFeeIndicatorLength = 0;
    }

    public void resetAllocSettlInstType()
    {
        hasAllocSettlInstType = false;
    }

    public void resetMiscFeesGroup()
    {
        if (miscFeesGroup != null)
        {
            miscFeesGroup.reset();
        }
        noMiscFeesGroupCounter = 0;
        hasNoMiscFeesGroupCounter = false;
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
        builder.append("\"MessageName\": \"AllocsGroup\",\n");
        if (hasAllocAccount())
        {
            indent(builder, level);
            builder.append("\"AllocAccount\": \"");
            appendBuffer(builder, allocAccount, allocAccountOffset, allocAccountLength);
            builder.append("\",\n");
        }

        if (hasAllocAcctIDSource())
        {
            indent(builder, level);
            builder.append("\"AllocAcctIDSource\": \"");
            builder.append(allocAcctIDSource);
            builder.append("\",\n");
        }

        if (hasMatchStatus())
        {
            indent(builder, level);
            builder.append("\"MatchStatus\": \"");
            builder.append(matchStatus);
            builder.append("\",\n");
        }

        if (hasAllocPrice())
        {
            indent(builder, level);
            builder.append("\"AllocPrice\": \"");
            allocPrice.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasAllocQty())
        {
            indent(builder, level);
            builder.append("\"AllocQty\": \"");
            allocQty.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasIndividualAllocID())
        {
            indent(builder, level);
            builder.append("\"IndividualAllocID\": \"");
            appendBuffer(builder, individualAllocID, individualAllocIDOffset, individualAllocIDLength);
            builder.append("\",\n");
        }

        if (hasProcessCode())
        {
            indent(builder, level);
            builder.append("\"ProcessCode\": \"");
            builder.append(processCode);
            builder.append("\",\n");
        }

    indent(builder, level);
    builder.append("\"NestedParties\": ");
    nestedParties.appendTo(builder, level + 1);
    builder.append("\n");

        if (hasNotifyBrokerOfCredit())
        {
            indent(builder, level);
            builder.append("\"NotifyBrokerOfCredit\": \"");
            builder.append(notifyBrokerOfCredit);
            builder.append("\",\n");
        }

        if (hasAllocHandlInst())
        {
            indent(builder, level);
            builder.append("\"AllocHandlInst\": \"");
            builder.append(allocHandlInst);
            builder.append("\",\n");
        }

        if (hasAllocText())
        {
            indent(builder, level);
            builder.append("\"AllocText\": \"");
            appendBuffer(builder, allocText, allocTextOffset, allocTextLength);
            builder.append("\",\n");
        }

        if (hasEncodedAllocTextLen())
        {
            indent(builder, level);
            builder.append("\"EncodedAllocTextLen\": \"");
            builder.append(encodedAllocTextLen);
            builder.append("\",\n");
        }

        if (hasEncodedAllocText())
        {
            indent(builder, level);
            builder.append("\"EncodedAllocText\": \"");
            appendData(builder, encodedAllocText, encodedAllocTextLen);
            builder.append("\",\n");
        }

    indent(builder, level);
    builder.append("\"CommissionData\": ");
    commissionData.appendTo(builder, level + 1);
    builder.append("\n");

        if (hasAllocAvgPx())
        {
            indent(builder, level);
            builder.append("\"AllocAvgPx\": \"");
            allocAvgPx.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasAllocNetMoney())
        {
            indent(builder, level);
            builder.append("\"AllocNetMoney\": \"");
            allocNetMoney.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasSettlCurrAmt())
        {
            indent(builder, level);
            builder.append("\"SettlCurrAmt\": \"");
            settlCurrAmt.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasAllocSettlCurrAmt())
        {
            indent(builder, level);
            builder.append("\"AllocSettlCurrAmt\": \"");
            allocSettlCurrAmt.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasSettlCurrency())
        {
            indent(builder, level);
            builder.append("\"SettlCurrency\": \"");
            appendBuffer(builder, settlCurrency, settlCurrencyOffset, settlCurrencyLength);
            builder.append("\",\n");
        }

        if (hasAllocSettlCurrency())
        {
            indent(builder, level);
            builder.append("\"AllocSettlCurrency\": \"");
            appendBuffer(builder, allocSettlCurrency, allocSettlCurrencyOffset, allocSettlCurrencyLength);
            builder.append("\",\n");
        }

        if (hasSettlCurrFxRate())
        {
            indent(builder, level);
            builder.append("\"SettlCurrFxRate\": \"");
            settlCurrFxRate.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasSettlCurrFxRateCalc())
        {
            indent(builder, level);
            builder.append("\"SettlCurrFxRateCalc\": \"");
            builder.append(settlCurrFxRateCalc);
            builder.append("\",\n");
        }

        if (hasAccruedInterestAmt())
        {
            indent(builder, level);
            builder.append("\"AccruedInterestAmt\": \"");
            accruedInterestAmt.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasAllocAccruedInterestAmt())
        {
            indent(builder, level);
            builder.append("\"AllocAccruedInterestAmt\": \"");
            allocAccruedInterestAmt.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasAllocInterestAtMaturity())
        {
            indent(builder, level);
            builder.append("\"AllocInterestAtMaturity\": \"");
            allocInterestAtMaturity.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasSettlInstMode())
        {
            indent(builder, level);
            builder.append("\"SettlInstMode\": \"");
            builder.append(settlInstMode);
            builder.append("\",\n");
        }

        if (hasNoMiscFeesGroupCounter)
        {
            indent(builder, level);
            builder.append("\"MiscFeesGroup\": [\n");
            final int noMiscFeesGroupCounter = this.noMiscFeesGroupCounter;
            MiscFeesGroupEncoder miscFeesGroup = this.miscFeesGroup;
            for (int i = 0; i < noMiscFeesGroupCounter; i++)
            {
                indent(builder, level);
                miscFeesGroup.appendTo(builder, level + 1);
                if (i < (noMiscFeesGroupCounter - 1))
                {
                    builder.append(',');
                }
                builder.append('\n');
                miscFeesGroup = miscFeesGroup.next();
            }
            indent(builder, level);
            builder.append("],\n");
        }

        if (hasNoClearingInstructions())
        {
            indent(builder, level);
            builder.append("\"NoClearingInstructions\": \"");
            builder.append(noClearingInstructions);
            builder.append("\",\n");
        }

        if (hasClearingInstruction())
        {
            indent(builder, level);
            builder.append("\"ClearingInstruction\": \"");
            builder.append(clearingInstruction);
            builder.append("\",\n");
        }

        if (hasClearingFeeIndicator())
        {
            indent(builder, level);
            builder.append("\"ClearingFeeIndicator\": \"");
            appendBuffer(builder, clearingFeeIndicator, clearingFeeIndicatorOffset, clearingFeeIndicatorLength);
            builder.append("\",\n");
        }

        if (hasAllocSettlInstType())
        {
            indent(builder, level);
            builder.append("\"AllocSettlInstType\": \"");
            builder.append(allocSettlInstType);
            builder.append("\",\n");
        }

    indent(builder, level);
    builder.append("\"SettlInstructionsData\": ");
    settlInstructionsData.appendTo(builder, level + 1);
    builder.append("\n");
        indent(builder, level - 1);
        builder.append("}");
        return builder;
    }

    /**
     * {@inheritDoc}
     */
    public AllocsGroupEncoder copyTo(final Encoder encoder)
    {
        return copyTo((AllocsGroupEncoder)encoder);
    }

    public AllocsGroupEncoder copyTo(final AllocsGroupEncoder encoder)
    {
        encoder.reset();
        if (hasAllocAccount())
        {
            encoder.allocAccountAsCopy(allocAccount.byteArray(), 0, allocAccountLength);
        }

        if (hasAllocAcctIDSource())
        {
            encoder.allocAcctIDSource(this.allocAcctIDSource());
        }

        if (hasMatchStatus())
        {
            encoder.matchStatus(this.matchStatus());
        }

        if (hasAllocPrice())
        {
            encoder.allocPrice(this.allocPrice());
        }

        if (hasAllocQty())
        {
            encoder.allocQty(this.allocQty());
        }

        if (hasIndividualAllocID())
        {
            encoder.individualAllocIDAsCopy(individualAllocID.byteArray(), 0, individualAllocIDLength);
        }

        if (hasProcessCode())
        {
            encoder.processCode(this.processCode());
        }


        nestedParties.copyTo(encoder.nestedParties());
        if (hasNotifyBrokerOfCredit())
        {
            encoder.notifyBrokerOfCredit(this.notifyBrokerOfCredit());
        }

        if (hasAllocHandlInst())
        {
            encoder.allocHandlInst(this.allocHandlInst());
        }

        if (hasAllocText())
        {
            encoder.allocTextAsCopy(allocText.byteArray(), 0, allocTextLength);
        }

        if (hasEncodedAllocTextLen())
        {
            encoder.encodedAllocTextLen(this.encodedAllocTextLen());
        }

        if (hasEncodedAllocText())
        {
            encoder.encodedAllocTextAsCopy(this.encodedAllocText(), 0, encodedAllocTextLen());
            encoder.encodedAllocTextLen(encodedAllocTextLen());
        }


        commissionData.copyTo(encoder.commissionData());
        if (hasAllocAvgPx())
        {
            encoder.allocAvgPx(this.allocAvgPx());
        }

        if (hasAllocNetMoney())
        {
            encoder.allocNetMoney(this.allocNetMoney());
        }

        if (hasSettlCurrAmt())
        {
            encoder.settlCurrAmt(this.settlCurrAmt());
        }

        if (hasAllocSettlCurrAmt())
        {
            encoder.allocSettlCurrAmt(this.allocSettlCurrAmt());
        }

        if (hasSettlCurrency())
        {
            encoder.settlCurrencyAsCopy(settlCurrency.byteArray(), 0, settlCurrencyLength);
        }

        if (hasAllocSettlCurrency())
        {
            encoder.allocSettlCurrencyAsCopy(allocSettlCurrency.byteArray(), 0, allocSettlCurrencyLength);
        }

        if (hasSettlCurrFxRate())
        {
            encoder.settlCurrFxRate(this.settlCurrFxRate());
        }

        if (hasSettlCurrFxRateCalc())
        {
            encoder.settlCurrFxRateCalc(this.settlCurrFxRateCalc());
        }

        if (hasAccruedInterestAmt())
        {
            encoder.accruedInterestAmt(this.accruedInterestAmt());
        }

        if (hasAllocAccruedInterestAmt())
        {
            encoder.allocAccruedInterestAmt(this.allocAccruedInterestAmt());
        }

        if (hasAllocInterestAtMaturity())
        {
            encoder.allocInterestAtMaturity(this.allocInterestAtMaturity());
        }

        if (hasSettlInstMode())
        {
            encoder.settlInstMode(this.settlInstMode());
        }

        if (hasNoMiscFeesGroupCounter)
        {
            final int size = this.noMiscFeesGroupCounter;
            MiscFeesGroupEncoder miscFeesGroup = this.miscFeesGroup;
            MiscFeesGroupEncoder miscFeesGroupEncoder = encoder.miscFeesGroup(size);
            for (int i = 0; i < size; i++)
            {
                if (miscFeesGroup != null)
                {
                    miscFeesGroup.copyTo(miscFeesGroupEncoder);
                    miscFeesGroup = miscFeesGroup.next();
                    miscFeesGroupEncoder = miscFeesGroupEncoder.next();
                }
            }
        }

        if (hasNoClearingInstructions())
        {
            encoder.noClearingInstructions(this.noClearingInstructions());
        }

        if (hasClearingInstruction())
        {
            encoder.clearingInstruction(this.clearingInstruction());
        }

        if (hasClearingFeeIndicator())
        {
            encoder.clearingFeeIndicatorAsCopy(clearingFeeIndicator.byteArray(), 0, clearingFeeIndicatorLength);
        }

        if (hasAllocSettlInstType())
        {
            encoder.allocSettlInstType(this.allocSettlInstType());
        }


        settlInstructionsData.copyTo(encoder.settlInstructionsData());        return encoder;
    }

}
    private int noAllocsGroupCounter;

    private boolean hasNoAllocsGroupCounter;

    public boolean hasNoAllocsGroupCounter()
    {
        return hasNoAllocsGroupCounter;
    }

    /* NoAllocsGroupCounter = 78 */
    public AllocationInstructionEncoder noAllocsGroupCounter(int value)
    {
        noAllocsGroupCounter = value;
        hasNoAllocsGroupCounter = true;
        return this;
    }

    /* NoAllocsGroupCounter = 78 */
    public int noAllocsGroupCounter()
    {
        return noAllocsGroupCounter;
    }


    private AllocsGroupEncoder allocsGroup = null;

    public AllocsGroupEncoder allocsGroup(final int numberOfElements)
    {
        hasNoAllocsGroupCounter = true;
        noAllocsGroupCounter = numberOfElements;
        if (allocsGroup == null)
        {
            allocsGroup = new AllocsGroupEncoder();
        }
        return allocsGroup;
    }

    public long encode(final MutableAsciiBuffer buffer, final int offset)
    {
        final long startMessageResult = header.startMessage(buffer, offset);
        final int bodyStart = Encoder.offset(startMessageResult);
        int position = bodyStart + Encoder.length(startMessageResult);

        if (allocIDLength > 0)
        {
            buffer.putBytes(position, allocIDHeader, 0, allocIDHeaderLength);
            position += allocIDHeaderLength;
            buffer.putBytes(position, allocID, allocIDOffset, allocIDLength);
            position += allocIDLength;
            buffer.putSeparator(position);
            position++;
        }
        else if (CODEC_VALIDATION_ENABLED)
        {
            throw new EncodingException("Missing Field: AllocID");
        }

        if (hasAllocTransType)
        {
            buffer.putBytes(position, allocTransTypeHeader, 0, allocTransTypeHeaderLength);
            position += allocTransTypeHeaderLength;
            position += buffer.putCharAscii(position, allocTransType);
            buffer.putSeparator(position);
            position++;
        }
        else if (CODEC_VALIDATION_ENABLED)
        {
            throw new EncodingException("Missing Field: AllocTransType");
        }

        if (hasAllocType)
        {
            buffer.putBytes(position, allocTypeHeader, 0, allocTypeHeaderLength);
            position += allocTypeHeaderLength;
            position += buffer.putIntAscii(position, allocType);
            buffer.putSeparator(position);
            position++;
        }
        else if (CODEC_VALIDATION_ENABLED)
        {
            throw new EncodingException("Missing Field: AllocType");
        }

        if (secondaryAllocIDLength > 0)
        {
            buffer.putBytes(position, secondaryAllocIDHeader, 0, secondaryAllocIDHeaderLength);
            position += secondaryAllocIDHeaderLength;
            buffer.putBytes(position, secondaryAllocID, secondaryAllocIDOffset, secondaryAllocIDLength);
            position += secondaryAllocIDLength;
            buffer.putSeparator(position);
            position++;
        }

        if (refAllocIDLength > 0)
        {
            buffer.putBytes(position, refAllocIDHeader, 0, refAllocIDHeaderLength);
            position += refAllocIDHeaderLength;
            buffer.putBytes(position, refAllocID, refAllocIDOffset, refAllocIDLength);
            position += refAllocIDLength;
            buffer.putSeparator(position);
            position++;
        }

        if (hasAllocCancReplaceReason)
        {
            buffer.putBytes(position, allocCancReplaceReasonHeader, 0, allocCancReplaceReasonHeaderLength);
            position += allocCancReplaceReasonHeaderLength;
            position += buffer.putIntAscii(position, allocCancReplaceReason);
            buffer.putSeparator(position);
            position++;
        }

        if (hasAllocIntermedReqType)
        {
            buffer.putBytes(position, allocIntermedReqTypeHeader, 0, allocIntermedReqTypeHeaderLength);
            position += allocIntermedReqTypeHeaderLength;
            position += buffer.putIntAscii(position, allocIntermedReqType);
            buffer.putSeparator(position);
            position++;
        }

        if (allocLinkIDLength > 0)
        {
            buffer.putBytes(position, allocLinkIDHeader, 0, allocLinkIDHeaderLength);
            position += allocLinkIDHeaderLength;
            buffer.putBytes(position, allocLinkID, allocLinkIDOffset, allocLinkIDLength);
            position += allocLinkIDLength;
            buffer.putSeparator(position);
            position++;
        }

        if (hasAllocLinkType)
        {
            buffer.putBytes(position, allocLinkTypeHeader, 0, allocLinkTypeHeaderLength);
            position += allocLinkTypeHeaderLength;
            position += buffer.putIntAscii(position, allocLinkType);
            buffer.putSeparator(position);
            position++;
        }

        if (bookingRefIDLength > 0)
        {
            buffer.putBytes(position, bookingRefIDHeader, 0, bookingRefIDHeaderLength);
            position += bookingRefIDHeaderLength;
            buffer.putBytes(position, bookingRefID, bookingRefIDOffset, bookingRefIDLength);
            position += bookingRefIDLength;
            buffer.putSeparator(position);
            position++;
        }

        if (hasAllocNoOrdersType)
        {
            buffer.putBytes(position, allocNoOrdersTypeHeader, 0, allocNoOrdersTypeHeaderLength);
            position += allocNoOrdersTypeHeaderLength;
            position += buffer.putIntAscii(position, allocNoOrdersType);
            buffer.putSeparator(position);
            position++;
        }
        else if (CODEC_VALIDATION_ENABLED)
        {
            throw new EncodingException("Missing Field: AllocNoOrdersType");
        }

        if (hasNoOrdersGroupCounter)
        {
            buffer.putBytes(position, noOrdersGroupCounterHeader, 0, noOrdersGroupCounterHeaderLength);
            position += noOrdersGroupCounterHeaderLength;
            position += buffer.putIntAscii(position, noOrdersGroupCounter);
            buffer.putSeparator(position);
            position++;
        }

        if (ordersGroup != null)
        {
            position += ordersGroup.encode(buffer, position, noOrdersGroupCounter);
        }


        if (hasNoExecsGroupCounter)
        {
            buffer.putBytes(position, noExecsGroupCounterHeader, 0, noExecsGroupCounterHeaderLength);
            position += noExecsGroupCounterHeaderLength;
            position += buffer.putIntAscii(position, noExecsGroupCounter);
            buffer.putSeparator(position);
            position++;
        }

        if (execsGroup != null)
        {
            position += execsGroup.encode(buffer, position, noExecsGroupCounter);
        }


        if (hasPreviouslyReported)
        {
            buffer.putBytes(position, previouslyReportedHeader, 0, previouslyReportedHeaderLength);
            position += previouslyReportedHeaderLength;
            position += buffer.putBooleanAscii(position, previouslyReported);
            buffer.putSeparator(position);
            position++;
        }

        if (hasReversalIndicator)
        {
            buffer.putBytes(position, reversalIndicatorHeader, 0, reversalIndicatorHeaderLength);
            position += reversalIndicatorHeaderLength;
            position += buffer.putBooleanAscii(position, reversalIndicator);
            buffer.putSeparator(position);
            position++;
        }

        if (matchTypeLength > 0)
        {
            buffer.putBytes(position, matchTypeHeader, 0, matchTypeHeaderLength);
            position += matchTypeHeaderLength;
            buffer.putBytes(position, matchType, matchTypeOffset, matchTypeLength);
            position += matchTypeLength;
            buffer.putSeparator(position);
            position++;
        }

        if (hasSide)
        {
            buffer.putBytes(position, sideHeader, 0, sideHeaderLength);
            position += sideHeaderLength;
            position += buffer.putCharAscii(position, side);
            buffer.putSeparator(position);
            position++;
        }
        else if (CODEC_VALIDATION_ENABLED)
        {
            throw new EncodingException("Missing Field: Side");
        }

            position += instrument.encode(buffer, position);

            position += instrumentExtension.encode(buffer, position);

            position += financingDetails.encode(buffer, position);

        if (hasNoUnderlyingsGroupCounter)
        {
            buffer.putBytes(position, noUnderlyingsGroupCounterHeader, 0, noUnderlyingsGroupCounterHeaderLength);
            position += noUnderlyingsGroupCounterHeaderLength;
            position += buffer.putIntAscii(position, noUnderlyingsGroupCounter);
            buffer.putSeparator(position);
            position++;
        }

        if (underlyingsGroup != null)
        {
            position += underlyingsGroup.encode(buffer, position, noUnderlyingsGroupCounter);
        }


        if (hasNoLegsGroupCounter)
        {
            buffer.putBytes(position, noLegsGroupCounterHeader, 0, noLegsGroupCounterHeaderLength);
            position += noLegsGroupCounterHeaderLength;
            position += buffer.putIntAscii(position, noLegsGroupCounter);
            buffer.putSeparator(position);
            position++;
        }

        if (legsGroup != null)
        {
            position += legsGroup.encode(buffer, position, noLegsGroupCounter);
        }


        if (hasQuantity)
        {
            buffer.putBytes(position, quantityHeader, 0, quantityHeaderLength);
            position += quantityHeaderLength;
            position += buffer.putFloatAscii(position, quantity);
            buffer.putSeparator(position);
            position++;
        }
        else if (CODEC_VALIDATION_ENABLED)
        {
            throw new EncodingException("Missing Field: Quantity");
        }

        if (hasQtyType)
        {
            buffer.putBytes(position, qtyTypeHeader, 0, qtyTypeHeaderLength);
            position += qtyTypeHeaderLength;
            position += buffer.putIntAscii(position, qtyType);
            buffer.putSeparator(position);
            position++;
        }

        if (lastMktLength > 0)
        {
            buffer.putBytes(position, lastMktHeader, 0, lastMktHeaderLength);
            position += lastMktHeaderLength;
            buffer.putBytes(position, lastMkt, lastMktOffset, lastMktLength);
            position += lastMktLength;
            buffer.putSeparator(position);
            position++;
        }

        if (tradeOriginationDateLength > 0)
        {
            buffer.putBytes(position, tradeOriginationDateHeader, 0, tradeOriginationDateHeaderLength);
            position += tradeOriginationDateHeaderLength;
            buffer.putBytes(position, tradeOriginationDate, tradeOriginationDateOffset, tradeOriginationDateLength);
            position += tradeOriginationDateLength;
            buffer.putSeparator(position);
            position++;
        }

        if (tradingSessionIDLength > 0)
        {
            buffer.putBytes(position, tradingSessionIDHeader, 0, tradingSessionIDHeaderLength);
            position += tradingSessionIDHeaderLength;
            buffer.putBytes(position, tradingSessionID, tradingSessionIDOffset, tradingSessionIDLength);
            position += tradingSessionIDLength;
            buffer.putSeparator(position);
            position++;
        }

        if (tradingSessionSubIDLength > 0)
        {
            buffer.putBytes(position, tradingSessionSubIDHeader, 0, tradingSessionSubIDHeaderLength);
            position += tradingSessionSubIDHeaderLength;
            buffer.putBytes(position, tradingSessionSubID, tradingSessionSubIDOffset, tradingSessionSubIDLength);
            position += tradingSessionSubIDLength;
            buffer.putSeparator(position);
            position++;
        }

        if (hasPriceType)
        {
            buffer.putBytes(position, priceTypeHeader, 0, priceTypeHeaderLength);
            position += priceTypeHeaderLength;
            position += buffer.putIntAscii(position, priceType);
            buffer.putSeparator(position);
            position++;
        }

        if (hasAvgPx)
        {
            buffer.putBytes(position, avgPxHeader, 0, avgPxHeaderLength);
            position += avgPxHeaderLength;
            position += buffer.putFloatAscii(position, avgPx);
            buffer.putSeparator(position);
            position++;
        }
        else if (CODEC_VALIDATION_ENABLED)
        {
            throw new EncodingException("Missing Field: AvgPx");
        }

        if (hasAvgParPx)
        {
            buffer.putBytes(position, avgParPxHeader, 0, avgParPxHeaderLength);
            position += avgParPxHeaderLength;
            position += buffer.putFloatAscii(position, avgParPx);
            buffer.putSeparator(position);
            position++;
        }

            position += spreadOrBenchmarkCurveData.encode(buffer, position);

        if (currencyLength > 0)
        {
            buffer.putBytes(position, currencyHeader, 0, currencyHeaderLength);
            position += currencyHeaderLength;
            buffer.putBytes(position, currency, currencyOffset, currencyLength);
            position += currencyLength;
            buffer.putSeparator(position);
            position++;
        }

        if (hasAvgPxPrecision)
        {
            buffer.putBytes(position, avgPxPrecisionHeader, 0, avgPxPrecisionHeaderLength);
            position += avgPxPrecisionHeaderLength;
            position += buffer.putIntAscii(position, avgPxPrecision);
            buffer.putSeparator(position);
            position++;
        }

            position += parties.encode(buffer, position);

        if (tradeDateLength > 0)
        {
            buffer.putBytes(position, tradeDateHeader, 0, tradeDateHeaderLength);
            position += tradeDateHeaderLength;
            buffer.putBytes(position, tradeDate, tradeDateOffset, tradeDateLength);
            position += tradeDateLength;
            buffer.putSeparator(position);
            position++;
        }
        else if (CODEC_VALIDATION_ENABLED)
        {
            throw new EncodingException("Missing Field: TradeDate");
        }

        if (transactTimeLength > 0)
        {
            buffer.putBytes(position, transactTimeHeader, 0, transactTimeHeaderLength);
            position += transactTimeHeaderLength;
            buffer.putBytes(position, transactTime, transactTimeOffset, transactTimeLength);
            position += transactTimeLength;
            buffer.putSeparator(position);
            position++;
        }

        if (hasSettlType)
        {
            buffer.putBytes(position, settlTypeHeader, 0, settlTypeHeaderLength);
            position += settlTypeHeaderLength;
            position += buffer.putCharAscii(position, settlType);
            buffer.putSeparator(position);
            position++;
        }

        if (settlDateLength > 0)
        {
            buffer.putBytes(position, settlDateHeader, 0, settlDateHeaderLength);
            position += settlDateHeaderLength;
            buffer.putBytes(position, settlDate, settlDateOffset, settlDateLength);
            position += settlDateLength;
            buffer.putSeparator(position);
            position++;
        }

        if (hasBookingType)
        {
            buffer.putBytes(position, bookingTypeHeader, 0, bookingTypeHeaderLength);
            position += bookingTypeHeaderLength;
            position += buffer.putIntAscii(position, bookingType);
            buffer.putSeparator(position);
            position++;
        }

        if (hasGrossTradeAmt)
        {
            buffer.putBytes(position, grossTradeAmtHeader, 0, grossTradeAmtHeaderLength);
            position += grossTradeAmtHeaderLength;
            position += buffer.putFloatAscii(position, grossTradeAmt);
            buffer.putSeparator(position);
            position++;
        }

        if (hasConcession)
        {
            buffer.putBytes(position, concessionHeader, 0, concessionHeaderLength);
            position += concessionHeaderLength;
            position += buffer.putFloatAscii(position, concession);
            buffer.putSeparator(position);
            position++;
        }

        if (hasTotalTakedown)
        {
            buffer.putBytes(position, totalTakedownHeader, 0, totalTakedownHeaderLength);
            position += totalTakedownHeaderLength;
            position += buffer.putFloatAscii(position, totalTakedown);
            buffer.putSeparator(position);
            position++;
        }

        if (hasNetMoney)
        {
            buffer.putBytes(position, netMoneyHeader, 0, netMoneyHeaderLength);
            position += netMoneyHeaderLength;
            position += buffer.putFloatAscii(position, netMoney);
            buffer.putSeparator(position);
            position++;
        }

        if (hasPositionEffect)
        {
            buffer.putBytes(position, positionEffectHeader, 0, positionEffectHeaderLength);
            position += positionEffectHeaderLength;
            position += buffer.putCharAscii(position, positionEffect);
            buffer.putSeparator(position);
            position++;
        }

        if (hasAutoAcceptIndicator)
        {
            buffer.putBytes(position, autoAcceptIndicatorHeader, 0, autoAcceptIndicatorHeaderLength);
            position += autoAcceptIndicatorHeaderLength;
            position += buffer.putBooleanAscii(position, autoAcceptIndicator);
            buffer.putSeparator(position);
            position++;
        }

        if (textLength > 0)
        {
            buffer.putBytes(position, textHeader, 0, textHeaderLength);
            position += textHeaderLength;
            buffer.putBytes(position, text, textOffset, textLength);
            position += textLength;
            buffer.putSeparator(position);
            position++;
        }

        if (hasEncodedTextLen)
        {
            buffer.putBytes(position, encodedTextLenHeader, 0, encodedTextLenHeaderLength);
            position += encodedTextLenHeaderLength;
            position += buffer.putIntAscii(position, encodedTextLen);
            buffer.putSeparator(position);
            position++;
        }

        if (hasEncodedText)
        {
            buffer.putBytes(position, encodedTextHeader, 0, encodedTextHeaderLength);
            position += encodedTextHeaderLength;
            buffer.putBytes(position, encodedText);
            position += encodedText.length;
            buffer.putSeparator(position);
            position++;
        }

        if (hasNumDaysInterest)
        {
            buffer.putBytes(position, numDaysInterestHeader, 0, numDaysInterestHeaderLength);
            position += numDaysInterestHeaderLength;
            position += buffer.putIntAscii(position, numDaysInterest);
            buffer.putSeparator(position);
            position++;
        }

        if (hasAccruedInterestRate)
        {
            buffer.putBytes(position, accruedInterestRateHeader, 0, accruedInterestRateHeaderLength);
            position += accruedInterestRateHeaderLength;
            position += buffer.putFloatAscii(position, accruedInterestRate);
            buffer.putSeparator(position);
            position++;
        }

        if (hasAccruedInterestAmt)
        {
            buffer.putBytes(position, accruedInterestAmtHeader, 0, accruedInterestAmtHeaderLength);
            position += accruedInterestAmtHeaderLength;
            position += buffer.putFloatAscii(position, accruedInterestAmt);
            buffer.putSeparator(position);
            position++;
        }

        if (hasTotalAccruedInterestAmt)
        {
            buffer.putBytes(position, totalAccruedInterestAmtHeader, 0, totalAccruedInterestAmtHeaderLength);
            position += totalAccruedInterestAmtHeaderLength;
            position += buffer.putFloatAscii(position, totalAccruedInterestAmt);
            buffer.putSeparator(position);
            position++;
        }

        if (hasInterestAtMaturity)
        {
            buffer.putBytes(position, interestAtMaturityHeader, 0, interestAtMaturityHeaderLength);
            position += interestAtMaturityHeaderLength;
            position += buffer.putFloatAscii(position, interestAtMaturity);
            buffer.putSeparator(position);
            position++;
        }

        if (hasEndAccruedInterestAmt)
        {
            buffer.putBytes(position, endAccruedInterestAmtHeader, 0, endAccruedInterestAmtHeaderLength);
            position += endAccruedInterestAmtHeaderLength;
            position += buffer.putFloatAscii(position, endAccruedInterestAmt);
            buffer.putSeparator(position);
            position++;
        }

        if (hasStartCash)
        {
            buffer.putBytes(position, startCashHeader, 0, startCashHeaderLength);
            position += startCashHeaderLength;
            position += buffer.putFloatAscii(position, startCash);
            buffer.putSeparator(position);
            position++;
        }

        if (hasEndCash)
        {
            buffer.putBytes(position, endCashHeader, 0, endCashHeaderLength);
            position += endCashHeaderLength;
            position += buffer.putFloatAscii(position, endCash);
            buffer.putSeparator(position);
            position++;
        }

        if (hasLegalConfirm)
        {
            buffer.putBytes(position, legalConfirmHeader, 0, legalConfirmHeaderLength);
            position += legalConfirmHeaderLength;
            position += buffer.putBooleanAscii(position, legalConfirm);
            buffer.putSeparator(position);
            position++;
        }

            position += stipulations.encode(buffer, position);

            position += yieldData.encode(buffer, position);

        if (hasTotNoAllocs)
        {
            buffer.putBytes(position, totNoAllocsHeader, 0, totNoAllocsHeaderLength);
            position += totNoAllocsHeaderLength;
            position += buffer.putIntAscii(position, totNoAllocs);
            buffer.putSeparator(position);
            position++;
        }

        if (hasLastFragment)
        {
            buffer.putBytes(position, lastFragmentHeader, 0, lastFragmentHeaderLength);
            position += lastFragmentHeaderLength;
            position += buffer.putBooleanAscii(position, lastFragment);
            buffer.putSeparator(position);
            position++;
        }

        if (hasNoAllocsGroupCounter)
        {
            buffer.putBytes(position, noAllocsGroupCounterHeader, 0, noAllocsGroupCounterHeaderLength);
            position += noAllocsGroupCounterHeaderLength;
            position += buffer.putIntAscii(position, noAllocsGroupCounter);
            buffer.putSeparator(position);
            position++;
        }

        if (allocsGroup != null)
        {
            position += allocsGroup.encode(buffer, position, noAllocsGroupCounter);
        }

        position += trailer.startTrailer(buffer, position);

        final int messageStart = header.finishHeader(buffer, bodyStart, position - bodyStart);
        return trailer.finishMessage(buffer, messageStart, position);
    }

    public void reset()
    {
        header.reset();
        trailer.reset();
        resetMessage();
    }

    public void resetMessage()
    {
        this.resetAllocID();
        this.resetAllocTransType();
        this.resetAllocType();
        this.resetSecondaryAllocID();
        this.resetRefAllocID();
        this.resetAllocCancReplaceReason();
        this.resetAllocIntermedReqType();
        this.resetAllocLinkID();
        this.resetAllocLinkType();
        this.resetBookingRefID();
        this.resetAllocNoOrdersType();
        this.resetPreviouslyReported();
        this.resetReversalIndicator();
        this.resetMatchType();
        this.resetSide();
        this.resetQuantity();
        this.resetQtyType();
        this.resetLastMkt();
        this.resetTradeOriginationDate();
        this.resetTradingSessionID();
        this.resetTradingSessionSubID();
        this.resetPriceType();
        this.resetAvgPx();
        this.resetAvgParPx();
        this.resetCurrency();
        this.resetAvgPxPrecision();
        this.resetTradeDate();
        this.resetTransactTime();
        this.resetSettlType();
        this.resetSettlDate();
        this.resetBookingType();
        this.resetGrossTradeAmt();
        this.resetConcession();
        this.resetTotalTakedown();
        this.resetNetMoney();
        this.resetPositionEffect();
        this.resetAutoAcceptIndicator();
        this.resetText();
        this.resetEncodedTextLen();
        this.resetEncodedText();
        this.resetNumDaysInterest();
        this.resetAccruedInterestRate();
        this.resetAccruedInterestAmt();
        this.resetTotalAccruedInterestAmt();
        this.resetInterestAtMaturity();
        this.resetEndAccruedInterestAmt();
        this.resetStartCash();
        this.resetEndCash();
        this.resetLegalConfirm();
        this.resetTotNoAllocs();
        this.resetLastFragment();
        instrument.reset();
        instrumentExtension.reset();
        financingDetails.reset();
        spreadOrBenchmarkCurveData.reset();
        parties.reset();
        stipulations.reset();
        yieldData.reset();
        this.resetOrdersGroup();
        this.resetExecsGroup();
        this.resetUnderlyingsGroup();
        this.resetLegsGroup();
        this.resetAllocsGroup();
    }

    public void resetAllocID()
    {
        allocIDLength = 0;
    }

    public void resetAllocTransType()
    {
        allocTransType = MISSING_CHAR;
    }

    public void resetAllocType()
    {
        hasAllocType = false;
    }

    public void resetSecondaryAllocID()
    {
        secondaryAllocIDLength = 0;
    }

    public void resetRefAllocID()
    {
        refAllocIDLength = 0;
    }

    public void resetAllocCancReplaceReason()
    {
        hasAllocCancReplaceReason = false;
    }

    public void resetAllocIntermedReqType()
    {
        hasAllocIntermedReqType = false;
    }

    public void resetAllocLinkID()
    {
        allocLinkIDLength = 0;
    }

    public void resetAllocLinkType()
    {
        hasAllocLinkType = false;
    }

    public void resetBookingRefID()
    {
        bookingRefIDLength = 0;
    }

    public void resetAllocNoOrdersType()
    {
        hasAllocNoOrdersType = false;
    }

    public void resetPreviouslyReported()
    {
        hasPreviouslyReported = false;
    }

    public void resetReversalIndicator()
    {
        hasReversalIndicator = false;
    }

    public void resetMatchType()
    {
        matchTypeLength = 0;
    }

    public void resetSide()
    {
        side = MISSING_CHAR;
    }

    public void resetQuantity()
    {
        hasQuantity = false;
    }

    public void resetQtyType()
    {
        hasQtyType = false;
    }

    public void resetLastMkt()
    {
        lastMktLength = 0;
    }

    public void resetTradeOriginationDate()
    {
        tradeOriginationDateLength = 0;
    }

    public void resetTradingSessionID()
    {
        tradingSessionIDLength = 0;
    }

    public void resetTradingSessionSubID()
    {
        tradingSessionSubIDLength = 0;
    }

    public void resetPriceType()
    {
        hasPriceType = false;
    }

    public void resetAvgPx()
    {
        hasAvgPx = false;
    }

    public void resetAvgParPx()
    {
        hasAvgParPx = false;
    }

    public void resetCurrency()
    {
        currencyLength = 0;
    }

    public void resetAvgPxPrecision()
    {
        hasAvgPxPrecision = false;
    }

    public void resetTradeDate()
    {
        tradeDateLength = 0;
    }

    public void resetTransactTime()
    {
        transactTimeLength = 0;
    }

    public void resetSettlType()
    {
        hasSettlType = false;
    }

    public void resetSettlDate()
    {
        settlDateLength = 0;
    }

    public void resetBookingType()
    {
        hasBookingType = false;
    }

    public void resetGrossTradeAmt()
    {
        hasGrossTradeAmt = false;
    }

    public void resetConcession()
    {
        hasConcession = false;
    }

    public void resetTotalTakedown()
    {
        hasTotalTakedown = false;
    }

    public void resetNetMoney()
    {
        hasNetMoney = false;
    }

    public void resetPositionEffect()
    {
        hasPositionEffect = false;
    }

    public void resetAutoAcceptIndicator()
    {
        hasAutoAcceptIndicator = false;
    }

    public void resetText()
    {
        textLength = 0;
    }

    public void resetEncodedTextLen()
    {
        hasEncodedTextLen = false;
    }

    public void resetEncodedText()
    {
        hasEncodedText = false;
    }

    public void resetNumDaysInterest()
    {
        hasNumDaysInterest = false;
    }

    public void resetAccruedInterestRate()
    {
        hasAccruedInterestRate = false;
    }

    public void resetAccruedInterestAmt()
    {
        hasAccruedInterestAmt = false;
    }

    public void resetTotalAccruedInterestAmt()
    {
        hasTotalAccruedInterestAmt = false;
    }

    public void resetInterestAtMaturity()
    {
        hasInterestAtMaturity = false;
    }

    public void resetEndAccruedInterestAmt()
    {
        hasEndAccruedInterestAmt = false;
    }

    public void resetStartCash()
    {
        hasStartCash = false;
    }

    public void resetEndCash()
    {
        hasEndCash = false;
    }

    public void resetLegalConfirm()
    {
        hasLegalConfirm = false;
    }

    public void resetTotNoAllocs()
    {
        hasTotNoAllocs = false;
    }

    public void resetLastFragment()
    {
        hasLastFragment = false;
    }

    public void resetOrdersGroup()
    {
        if (ordersGroup != null)
        {
            ordersGroup.reset();
        }
        noOrdersGroupCounter = 0;
        hasNoOrdersGroupCounter = false;
    }

    public void resetExecsGroup()
    {
        if (execsGroup != null)
        {
            execsGroup.reset();
        }
        noExecsGroupCounter = 0;
        hasNoExecsGroupCounter = false;
    }

    public void resetUnderlyingsGroup()
    {
        if (underlyingsGroup != null)
        {
            underlyingsGroup.reset();
        }
        noUnderlyingsGroupCounter = 0;
        hasNoUnderlyingsGroupCounter = false;
    }

    public void resetLegsGroup()
    {
        if (legsGroup != null)
        {
            legsGroup.reset();
        }
        noLegsGroupCounter = 0;
        hasNoLegsGroupCounter = false;
    }

    public void resetAllocsGroup()
    {
        if (allocsGroup != null)
        {
            allocsGroup.reset();
        }
        noAllocsGroupCounter = 0;
        hasNoAllocsGroupCounter = false;
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
        builder.append("\"MessageName\": \"AllocationInstruction\",\n");
        builder.append("  \"header\": ");
        header.appendTo(builder, level + 1);
        builder.append("\n");
        if (hasAllocID())
        {
            indent(builder, level);
            builder.append("\"AllocID\": \"");
            appendBuffer(builder, allocID, allocIDOffset, allocIDLength);
            builder.append("\",\n");
        }

        if (hasAllocTransType())
        {
            indent(builder, level);
            builder.append("\"AllocTransType\": \"");
            builder.append(allocTransType);
            builder.append("\",\n");
        }

        if (hasAllocType())
        {
            indent(builder, level);
            builder.append("\"AllocType\": \"");
            builder.append(allocType);
            builder.append("\",\n");
        }

        if (hasSecondaryAllocID())
        {
            indent(builder, level);
            builder.append("\"SecondaryAllocID\": \"");
            appendBuffer(builder, secondaryAllocID, secondaryAllocIDOffset, secondaryAllocIDLength);
            builder.append("\",\n");
        }

        if (hasRefAllocID())
        {
            indent(builder, level);
            builder.append("\"RefAllocID\": \"");
            appendBuffer(builder, refAllocID, refAllocIDOffset, refAllocIDLength);
            builder.append("\",\n");
        }

        if (hasAllocCancReplaceReason())
        {
            indent(builder, level);
            builder.append("\"AllocCancReplaceReason\": \"");
            builder.append(allocCancReplaceReason);
            builder.append("\",\n");
        }

        if (hasAllocIntermedReqType())
        {
            indent(builder, level);
            builder.append("\"AllocIntermedReqType\": \"");
            builder.append(allocIntermedReqType);
            builder.append("\",\n");
        }

        if (hasAllocLinkID())
        {
            indent(builder, level);
            builder.append("\"AllocLinkID\": \"");
            appendBuffer(builder, allocLinkID, allocLinkIDOffset, allocLinkIDLength);
            builder.append("\",\n");
        }

        if (hasAllocLinkType())
        {
            indent(builder, level);
            builder.append("\"AllocLinkType\": \"");
            builder.append(allocLinkType);
            builder.append("\",\n");
        }

        if (hasBookingRefID())
        {
            indent(builder, level);
            builder.append("\"BookingRefID\": \"");
            appendBuffer(builder, bookingRefID, bookingRefIDOffset, bookingRefIDLength);
            builder.append("\",\n");
        }

        if (hasAllocNoOrdersType())
        {
            indent(builder, level);
            builder.append("\"AllocNoOrdersType\": \"");
            builder.append(allocNoOrdersType);
            builder.append("\",\n");
        }

        if (hasNoOrdersGroupCounter)
        {
            indent(builder, level);
            builder.append("\"OrdersGroup\": [\n");
            final int noOrdersGroupCounter = this.noOrdersGroupCounter;
            OrdersGroupEncoder ordersGroup = this.ordersGroup;
            for (int i = 0; i < noOrdersGroupCounter; i++)
            {
                indent(builder, level);
                ordersGroup.appendTo(builder, level + 1);
                if (i < (noOrdersGroupCounter - 1))
                {
                    builder.append(',');
                }
                builder.append('\n');
                ordersGroup = ordersGroup.next();
            }
            indent(builder, level);
            builder.append("],\n");
        }

        if (hasNoExecsGroupCounter)
        {
            indent(builder, level);
            builder.append("\"ExecsGroup\": [\n");
            final int noExecsGroupCounter = this.noExecsGroupCounter;
            ExecsGroupEncoder execsGroup = this.execsGroup;
            for (int i = 0; i < noExecsGroupCounter; i++)
            {
                indent(builder, level);
                execsGroup.appendTo(builder, level + 1);
                if (i < (noExecsGroupCounter - 1))
                {
                    builder.append(',');
                }
                builder.append('\n');
                execsGroup = execsGroup.next();
            }
            indent(builder, level);
            builder.append("],\n");
        }

        if (hasPreviouslyReported())
        {
            indent(builder, level);
            builder.append("\"PreviouslyReported\": \"");
            builder.append(previouslyReported);
            builder.append("\",\n");
        }

        if (hasReversalIndicator())
        {
            indent(builder, level);
            builder.append("\"ReversalIndicator\": \"");
            builder.append(reversalIndicator);
            builder.append("\",\n");
        }

        if (hasMatchType())
        {
            indent(builder, level);
            builder.append("\"MatchType\": \"");
            appendBuffer(builder, matchType, matchTypeOffset, matchTypeLength);
            builder.append("\",\n");
        }

        if (hasSide())
        {
            indent(builder, level);
            builder.append("\"Side\": \"");
            builder.append(side);
            builder.append("\",\n");
        }

    indent(builder, level);
    builder.append("\"Instrument\": ");
    instrument.appendTo(builder, level + 1);
    builder.append("\n");

    indent(builder, level);
    builder.append("\"InstrumentExtension\": ");
    instrumentExtension.appendTo(builder, level + 1);
    builder.append("\n");

    indent(builder, level);
    builder.append("\"FinancingDetails\": ");
    financingDetails.appendTo(builder, level + 1);
    builder.append("\n");

        if (hasNoUnderlyingsGroupCounter)
        {
            indent(builder, level);
            builder.append("\"UnderlyingsGroup\": [\n");
            final int noUnderlyingsGroupCounter = this.noUnderlyingsGroupCounter;
            UnderlyingsGroupEncoder underlyingsGroup = this.underlyingsGroup;
            for (int i = 0; i < noUnderlyingsGroupCounter; i++)
            {
                indent(builder, level);
                underlyingsGroup.appendTo(builder, level + 1);
                if (i < (noUnderlyingsGroupCounter - 1))
                {
                    builder.append(',');
                }
                builder.append('\n');
                underlyingsGroup = underlyingsGroup.next();
            }
            indent(builder, level);
            builder.append("],\n");
        }

        if (hasNoLegsGroupCounter)
        {
            indent(builder, level);
            builder.append("\"LegsGroup\": [\n");
            final int noLegsGroupCounter = this.noLegsGroupCounter;
            LegsGroupEncoder legsGroup = this.legsGroup;
            for (int i = 0; i < noLegsGroupCounter; i++)
            {
                indent(builder, level);
                legsGroup.appendTo(builder, level + 1);
                if (i < (noLegsGroupCounter - 1))
                {
                    builder.append(',');
                }
                builder.append('\n');
                legsGroup = legsGroup.next();
            }
            indent(builder, level);
            builder.append("],\n");
        }

        if (hasQuantity())
        {
            indent(builder, level);
            builder.append("\"Quantity\": \"");
            quantity.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasQtyType())
        {
            indent(builder, level);
            builder.append("\"QtyType\": \"");
            builder.append(qtyType);
            builder.append("\",\n");
        }

        if (hasLastMkt())
        {
            indent(builder, level);
            builder.append("\"LastMkt\": \"");
            appendBuffer(builder, lastMkt, lastMktOffset, lastMktLength);
            builder.append("\",\n");
        }

        if (hasTradeOriginationDate())
        {
            indent(builder, level);
            builder.append("\"TradeOriginationDate\": \"");
            appendBuffer(builder, tradeOriginationDate, tradeOriginationDateOffset, tradeOriginationDateLength);
            builder.append("\",\n");
        }

        if (hasTradingSessionID())
        {
            indent(builder, level);
            builder.append("\"TradingSessionID\": \"");
            appendBuffer(builder, tradingSessionID, tradingSessionIDOffset, tradingSessionIDLength);
            builder.append("\",\n");
        }

        if (hasTradingSessionSubID())
        {
            indent(builder, level);
            builder.append("\"TradingSessionSubID\": \"");
            appendBuffer(builder, tradingSessionSubID, tradingSessionSubIDOffset, tradingSessionSubIDLength);
            builder.append("\",\n");
        }

        if (hasPriceType())
        {
            indent(builder, level);
            builder.append("\"PriceType\": \"");
            builder.append(priceType);
            builder.append("\",\n");
        }

        if (hasAvgPx())
        {
            indent(builder, level);
            builder.append("\"AvgPx\": \"");
            avgPx.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasAvgParPx())
        {
            indent(builder, level);
            builder.append("\"AvgParPx\": \"");
            avgParPx.appendTo(builder);
            builder.append("\",\n");
        }

    indent(builder, level);
    builder.append("\"SpreadOrBenchmarkCurveData\": ");
    spreadOrBenchmarkCurveData.appendTo(builder, level + 1);
    builder.append("\n");

        if (hasCurrency())
        {
            indent(builder, level);
            builder.append("\"Currency\": \"");
            appendBuffer(builder, currency, currencyOffset, currencyLength);
            builder.append("\",\n");
        }

        if (hasAvgPxPrecision())
        {
            indent(builder, level);
            builder.append("\"AvgPxPrecision\": \"");
            builder.append(avgPxPrecision);
            builder.append("\",\n");
        }

    indent(builder, level);
    builder.append("\"Parties\": ");
    parties.appendTo(builder, level + 1);
    builder.append("\n");

        if (hasTradeDate())
        {
            indent(builder, level);
            builder.append("\"TradeDate\": \"");
            appendBuffer(builder, tradeDate, tradeDateOffset, tradeDateLength);
            builder.append("\",\n");
        }

        if (hasTransactTime())
        {
            indent(builder, level);
            builder.append("\"TransactTime\": \"");
            appendBuffer(builder, transactTime, transactTimeOffset, transactTimeLength);
            builder.append("\",\n");
        }

        if (hasSettlType())
        {
            indent(builder, level);
            builder.append("\"SettlType\": \"");
            builder.append(settlType);
            builder.append("\",\n");
        }

        if (hasSettlDate())
        {
            indent(builder, level);
            builder.append("\"SettlDate\": \"");
            appendBuffer(builder, settlDate, settlDateOffset, settlDateLength);
            builder.append("\",\n");
        }

        if (hasBookingType())
        {
            indent(builder, level);
            builder.append("\"BookingType\": \"");
            builder.append(bookingType);
            builder.append("\",\n");
        }

        if (hasGrossTradeAmt())
        {
            indent(builder, level);
            builder.append("\"GrossTradeAmt\": \"");
            grossTradeAmt.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasConcession())
        {
            indent(builder, level);
            builder.append("\"Concession\": \"");
            concession.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasTotalTakedown())
        {
            indent(builder, level);
            builder.append("\"TotalTakedown\": \"");
            totalTakedown.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasNetMoney())
        {
            indent(builder, level);
            builder.append("\"NetMoney\": \"");
            netMoney.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasPositionEffect())
        {
            indent(builder, level);
            builder.append("\"PositionEffect\": \"");
            builder.append(positionEffect);
            builder.append("\",\n");
        }

        if (hasAutoAcceptIndicator())
        {
            indent(builder, level);
            builder.append("\"AutoAcceptIndicator\": \"");
            builder.append(autoAcceptIndicator);
            builder.append("\",\n");
        }

        if (hasText())
        {
            indent(builder, level);
            builder.append("\"Text\": \"");
            appendBuffer(builder, text, textOffset, textLength);
            builder.append("\",\n");
        }

        if (hasEncodedTextLen())
        {
            indent(builder, level);
            builder.append("\"EncodedTextLen\": \"");
            builder.append(encodedTextLen);
            builder.append("\",\n");
        }

        if (hasEncodedText())
        {
            indent(builder, level);
            builder.append("\"EncodedText\": \"");
            appendData(builder, encodedText, encodedTextLen);
            builder.append("\",\n");
        }

        if (hasNumDaysInterest())
        {
            indent(builder, level);
            builder.append("\"NumDaysInterest\": \"");
            builder.append(numDaysInterest);
            builder.append("\",\n");
        }

        if (hasAccruedInterestRate())
        {
            indent(builder, level);
            builder.append("\"AccruedInterestRate\": \"");
            accruedInterestRate.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasAccruedInterestAmt())
        {
            indent(builder, level);
            builder.append("\"AccruedInterestAmt\": \"");
            accruedInterestAmt.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasTotalAccruedInterestAmt())
        {
            indent(builder, level);
            builder.append("\"TotalAccruedInterestAmt\": \"");
            totalAccruedInterestAmt.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasInterestAtMaturity())
        {
            indent(builder, level);
            builder.append("\"InterestAtMaturity\": \"");
            interestAtMaturity.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasEndAccruedInterestAmt())
        {
            indent(builder, level);
            builder.append("\"EndAccruedInterestAmt\": \"");
            endAccruedInterestAmt.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasStartCash())
        {
            indent(builder, level);
            builder.append("\"StartCash\": \"");
            startCash.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasEndCash())
        {
            indent(builder, level);
            builder.append("\"EndCash\": \"");
            endCash.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasLegalConfirm())
        {
            indent(builder, level);
            builder.append("\"LegalConfirm\": \"");
            builder.append(legalConfirm);
            builder.append("\",\n");
        }

    indent(builder, level);
    builder.append("\"Stipulations\": ");
    stipulations.appendTo(builder, level + 1);
    builder.append("\n");

    indent(builder, level);
    builder.append("\"YieldData\": ");
    yieldData.appendTo(builder, level + 1);
    builder.append("\n");

        if (hasTotNoAllocs())
        {
            indent(builder, level);
            builder.append("\"TotNoAllocs\": \"");
            builder.append(totNoAllocs);
            builder.append("\",\n");
        }

        if (hasLastFragment())
        {
            indent(builder, level);
            builder.append("\"LastFragment\": \"");
            builder.append(lastFragment);
            builder.append("\",\n");
        }

        if (hasNoAllocsGroupCounter)
        {
            indent(builder, level);
            builder.append("\"AllocsGroup\": [\n");
            final int noAllocsGroupCounter = this.noAllocsGroupCounter;
            AllocsGroupEncoder allocsGroup = this.allocsGroup;
            for (int i = 0; i < noAllocsGroupCounter; i++)
            {
                indent(builder, level);
                allocsGroup.appendTo(builder, level + 1);
                if (i < (noAllocsGroupCounter - 1))
                {
                    builder.append(',');
                }
                builder.append('\n');
                allocsGroup = allocsGroup.next();
            }
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
    public AllocationInstructionEncoder copyTo(final Encoder encoder)
    {
        return copyTo((AllocationInstructionEncoder)encoder);
    }

    public AllocationInstructionEncoder copyTo(final AllocationInstructionEncoder encoder)
    {
        encoder.reset();
        if (hasAllocID())
        {
            encoder.allocIDAsCopy(allocID.byteArray(), 0, allocIDLength);
        }

        if (hasAllocTransType())
        {
            encoder.allocTransType(this.allocTransType());
        }

        if (hasAllocType())
        {
            encoder.allocType(this.allocType());
        }

        if (hasSecondaryAllocID())
        {
            encoder.secondaryAllocIDAsCopy(secondaryAllocID.byteArray(), 0, secondaryAllocIDLength);
        }

        if (hasRefAllocID())
        {
            encoder.refAllocIDAsCopy(refAllocID.byteArray(), 0, refAllocIDLength);
        }

        if (hasAllocCancReplaceReason())
        {
            encoder.allocCancReplaceReason(this.allocCancReplaceReason());
        }

        if (hasAllocIntermedReqType())
        {
            encoder.allocIntermedReqType(this.allocIntermedReqType());
        }

        if (hasAllocLinkID())
        {
            encoder.allocLinkIDAsCopy(allocLinkID.byteArray(), 0, allocLinkIDLength);
        }

        if (hasAllocLinkType())
        {
            encoder.allocLinkType(this.allocLinkType());
        }

        if (hasBookingRefID())
        {
            encoder.bookingRefIDAsCopy(bookingRefID.byteArray(), 0, bookingRefIDLength);
        }

        if (hasAllocNoOrdersType())
        {
            encoder.allocNoOrdersType(this.allocNoOrdersType());
        }

        if (hasNoOrdersGroupCounter)
        {
            final int size = this.noOrdersGroupCounter;
            OrdersGroupEncoder ordersGroup = this.ordersGroup;
            OrdersGroupEncoder ordersGroupEncoder = encoder.ordersGroup(size);
            for (int i = 0; i < size; i++)
            {
                if (ordersGroup != null)
                {
                    ordersGroup.copyTo(ordersGroupEncoder);
                    ordersGroup = ordersGroup.next();
                    ordersGroupEncoder = ordersGroupEncoder.next();
                }
            }
        }

        if (hasNoExecsGroupCounter)
        {
            final int size = this.noExecsGroupCounter;
            ExecsGroupEncoder execsGroup = this.execsGroup;
            ExecsGroupEncoder execsGroupEncoder = encoder.execsGroup(size);
            for (int i = 0; i < size; i++)
            {
                if (execsGroup != null)
                {
                    execsGroup.copyTo(execsGroupEncoder);
                    execsGroup = execsGroup.next();
                    execsGroupEncoder = execsGroupEncoder.next();
                }
            }
        }

        if (hasPreviouslyReported())
        {
            encoder.previouslyReported(this.previouslyReported());
        }

        if (hasReversalIndicator())
        {
            encoder.reversalIndicator(this.reversalIndicator());
        }

        if (hasMatchType())
        {
            encoder.matchTypeAsCopy(matchType.byteArray(), 0, matchTypeLength);
        }

        if (hasSide())
        {
            encoder.side(this.side());
        }


        instrument.copyTo(encoder.instrument());

        instrumentExtension.copyTo(encoder.instrumentExtension());

        financingDetails.copyTo(encoder.financingDetails());
        if (hasNoUnderlyingsGroupCounter)
        {
            final int size = this.noUnderlyingsGroupCounter;
            UnderlyingsGroupEncoder underlyingsGroup = this.underlyingsGroup;
            UnderlyingsGroupEncoder underlyingsGroupEncoder = encoder.underlyingsGroup(size);
            for (int i = 0; i < size; i++)
            {
                if (underlyingsGroup != null)
                {
                    underlyingsGroup.copyTo(underlyingsGroupEncoder);
                    underlyingsGroup = underlyingsGroup.next();
                    underlyingsGroupEncoder = underlyingsGroupEncoder.next();
                }
            }
        }

        if (hasNoLegsGroupCounter)
        {
            final int size = this.noLegsGroupCounter;
            LegsGroupEncoder legsGroup = this.legsGroup;
            LegsGroupEncoder legsGroupEncoder = encoder.legsGroup(size);
            for (int i = 0; i < size; i++)
            {
                if (legsGroup != null)
                {
                    legsGroup.copyTo(legsGroupEncoder);
                    legsGroup = legsGroup.next();
                    legsGroupEncoder = legsGroupEncoder.next();
                }
            }
        }

        if (hasQuantity())
        {
            encoder.quantity(this.quantity());
        }

        if (hasQtyType())
        {
            encoder.qtyType(this.qtyType());
        }

        if (hasLastMkt())
        {
            encoder.lastMktAsCopy(lastMkt.byteArray(), 0, lastMktLength);
        }

        if (hasTradeOriginationDate())
        {
            encoder.tradeOriginationDateAsCopy(tradeOriginationDate.byteArray(), 0, tradeOriginationDateLength);
        }

        if (hasTradingSessionID())
        {
            encoder.tradingSessionIDAsCopy(tradingSessionID.byteArray(), 0, tradingSessionIDLength);
        }

        if (hasTradingSessionSubID())
        {
            encoder.tradingSessionSubIDAsCopy(tradingSessionSubID.byteArray(), 0, tradingSessionSubIDLength);
        }

        if (hasPriceType())
        {
            encoder.priceType(this.priceType());
        }

        if (hasAvgPx())
        {
            encoder.avgPx(this.avgPx());
        }

        if (hasAvgParPx())
        {
            encoder.avgParPx(this.avgParPx());
        }


        spreadOrBenchmarkCurveData.copyTo(encoder.spreadOrBenchmarkCurveData());
        if (hasCurrency())
        {
            encoder.currencyAsCopy(currency.byteArray(), 0, currencyLength);
        }

        if (hasAvgPxPrecision())
        {
            encoder.avgPxPrecision(this.avgPxPrecision());
        }


        parties.copyTo(encoder.parties());
        if (hasTradeDate())
        {
            encoder.tradeDateAsCopy(tradeDate.byteArray(), 0, tradeDateLength);
        }

        if (hasTransactTime())
        {
            encoder.transactTimeAsCopy(transactTime.byteArray(), 0, transactTimeLength);
        }

        if (hasSettlType())
        {
            encoder.settlType(this.settlType());
        }

        if (hasSettlDate())
        {
            encoder.settlDateAsCopy(settlDate.byteArray(), 0, settlDateLength);
        }

        if (hasBookingType())
        {
            encoder.bookingType(this.bookingType());
        }

        if (hasGrossTradeAmt())
        {
            encoder.grossTradeAmt(this.grossTradeAmt());
        }

        if (hasConcession())
        {
            encoder.concession(this.concession());
        }

        if (hasTotalTakedown())
        {
            encoder.totalTakedown(this.totalTakedown());
        }

        if (hasNetMoney())
        {
            encoder.netMoney(this.netMoney());
        }

        if (hasPositionEffect())
        {
            encoder.positionEffect(this.positionEffect());
        }

        if (hasAutoAcceptIndicator())
        {
            encoder.autoAcceptIndicator(this.autoAcceptIndicator());
        }

        if (hasText())
        {
            encoder.textAsCopy(text.byteArray(), 0, textLength);
        }

        if (hasEncodedTextLen())
        {
            encoder.encodedTextLen(this.encodedTextLen());
        }

        if (hasEncodedText())
        {
            encoder.encodedTextAsCopy(this.encodedText(), 0, encodedTextLen());
            encoder.encodedTextLen(encodedTextLen());
        }

        if (hasNumDaysInterest())
        {
            encoder.numDaysInterest(this.numDaysInterest());
        }

        if (hasAccruedInterestRate())
        {
            encoder.accruedInterestRate(this.accruedInterestRate());
        }

        if (hasAccruedInterestAmt())
        {
            encoder.accruedInterestAmt(this.accruedInterestAmt());
        }

        if (hasTotalAccruedInterestAmt())
        {
            encoder.totalAccruedInterestAmt(this.totalAccruedInterestAmt());
        }

        if (hasInterestAtMaturity())
        {
            encoder.interestAtMaturity(this.interestAtMaturity());
        }

        if (hasEndAccruedInterestAmt())
        {
            encoder.endAccruedInterestAmt(this.endAccruedInterestAmt());
        }

        if (hasStartCash())
        {
            encoder.startCash(this.startCash());
        }

        if (hasEndCash())
        {
            encoder.endCash(this.endCash());
        }

        if (hasLegalConfirm())
        {
            encoder.legalConfirm(this.legalConfirm());
        }


        stipulations.copyTo(encoder.stipulations());

        yieldData.copyTo(encoder.yieldData());
        if (hasTotNoAllocs())
        {
            encoder.totNoAllocs(this.totNoAllocs());
        }

        if (hasLastFragment())
        {
            encoder.lastFragment(this.lastFragment());
        }

        if (hasNoAllocsGroupCounter)
        {
            final int size = this.noAllocsGroupCounter;
            AllocsGroupEncoder allocsGroup = this.allocsGroup;
            AllocsGroupEncoder allocsGroupEncoder = encoder.allocsGroup(size);
            for (int i = 0; i < size; i++)
            {
                if (allocsGroup != null)
                {
                    allocsGroup.copyTo(allocsGroupEncoder);
                    allocsGroup = allocsGroup.next();
                    allocsGroupEncoder = allocsGroupEncoder.next();
                }
            }
        }
        return encoder;
    }

}
