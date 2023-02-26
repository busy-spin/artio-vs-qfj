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
public class ConfirmationEncoder implements Encoder
{
    public long messageType()
    {
        return 19265L;
    }

    public ConfirmationEncoder()
    {
        header.msgType("AK");
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

    private static final int confirmIDHeaderLength = 4;
    private static final byte[] confirmIDHeader = new byte[] {54, 54, 52, (byte) '='};

    private static final int confirmRefIDHeaderLength = 4;
    private static final byte[] confirmRefIDHeader = new byte[] {55, 55, 50, (byte) '='};

    private static final int confirmReqIDHeaderLength = 4;
    private static final byte[] confirmReqIDHeader = new byte[] {56, 53, 57, (byte) '='};

    private static final int confirmTransTypeHeaderLength = 4;
    private static final byte[] confirmTransTypeHeader = new byte[] {54, 54, 54, (byte) '='};

    private static final int confirmTypeHeaderLength = 4;
    private static final byte[] confirmTypeHeader = new byte[] {55, 55, 51, (byte) '='};

    private static final int copyMsgIndicatorHeaderLength = 4;
    private static final byte[] copyMsgIndicatorHeader = new byte[] {55, 57, 55, (byte) '='};

    private static final int legalConfirmHeaderLength = 4;
    private static final byte[] legalConfirmHeader = new byte[] {54, 53, 48, (byte) '='};

    private static final int confirmStatusHeaderLength = 4;
    private static final byte[] confirmStatusHeader = new byte[] {54, 54, 53, (byte) '='};

    private static final int noOrdersGroupCounterHeaderLength = 3;
    private static final byte[] noOrdersGroupCounterHeader = new byte[] {55, 51, (byte) '='};

    private static final int allocIDHeaderLength = 3;
    private static final byte[] allocIDHeader = new byte[] {55, 48, (byte) '='};

    private static final int secondaryAllocIDHeaderLength = 4;
    private static final byte[] secondaryAllocIDHeader = new byte[] {55, 57, 51, (byte) '='};

    private static final int individualAllocIDHeaderLength = 4;
    private static final byte[] individualAllocIDHeader = new byte[] {52, 54, 55, (byte) '='};

    private static final int transactTimeHeaderLength = 3;
    private static final byte[] transactTimeHeader = new byte[] {54, 48, (byte) '='};

    private static final int tradeDateHeaderLength = 3;
    private static final byte[] tradeDateHeader = new byte[] {55, 53, (byte) '='};

    private static final int noUnderlyingsGroupCounterHeaderLength = 4;
    private static final byte[] noUnderlyingsGroupCounterHeader = new byte[] {55, 49, 49, (byte) '='};

    private static final int noLegsGroupCounterHeaderLength = 4;
    private static final byte[] noLegsGroupCounterHeader = new byte[] {53, 53, 53, (byte) '='};

    private static final int allocQtyHeaderLength = 3;
    private static final byte[] allocQtyHeader = new byte[] {56, 48, (byte) '='};

    private static final int qtyTypeHeaderLength = 4;
    private static final byte[] qtyTypeHeader = new byte[] {56, 53, 52, (byte) '='};

    private static final int sideHeaderLength = 3;
    private static final byte[] sideHeader = new byte[] {53, 52, (byte) '='};

    private static final int currencyHeaderLength = 3;
    private static final byte[] currencyHeader = new byte[] {49, 53, (byte) '='};

    private static final int lastMktHeaderLength = 3;
    private static final byte[] lastMktHeader = new byte[] {51, 48, (byte) '='};

    private static final int noCapacitiesGroupCounterHeaderLength = 4;
    private static final byte[] noCapacitiesGroupCounterHeader = new byte[] {56, 54, 50, (byte) '='};

    private static final int allocAccountHeaderLength = 3;
    private static final byte[] allocAccountHeader = new byte[] {55, 57, (byte) '='};

    private static final int allocAcctIDSourceHeaderLength = 4;
    private static final byte[] allocAcctIDSourceHeader = new byte[] {54, 54, 49, (byte) '='};

    private static final int allocAccountTypeHeaderLength = 4;
    private static final byte[] allocAccountTypeHeader = new byte[] {55, 57, 56, (byte) '='};

    private static final int avgPxHeaderLength = 2;
    private static final byte[] avgPxHeader = new byte[] {54, (byte) '='};

    private static final int avgPxPrecisionHeaderLength = 3;
    private static final byte[] avgPxPrecisionHeader = new byte[] {55, 52, (byte) '='};

    private static final int priceTypeHeaderLength = 4;
    private static final byte[] priceTypeHeader = new byte[] {52, 50, 51, (byte) '='};

    private static final int avgParPxHeaderLength = 4;
    private static final byte[] avgParPxHeader = new byte[] {56, 54, 48, (byte) '='};

    private static final int reportedPxHeaderLength = 4;
    private static final byte[] reportedPxHeader = new byte[] {56, 54, 49, (byte) '='};

    private static final int textHeaderLength = 3;
    private static final byte[] textHeader = new byte[] {53, 56, (byte) '='};

    private static final int encodedTextLenHeaderLength = 4;
    private static final byte[] encodedTextLenHeader = new byte[] {51, 53, 52, (byte) '='};

    private static final int encodedTextHeaderLength = 4;
    private static final byte[] encodedTextHeader = new byte[] {51, 53, 53, (byte) '='};

    private static final int processCodeHeaderLength = 3;
    private static final byte[] processCodeHeader = new byte[] {56, 49, (byte) '='};

    private static final int grossTradeAmtHeaderLength = 4;
    private static final byte[] grossTradeAmtHeader = new byte[] {51, 56, 49, (byte) '='};

    private static final int numDaysInterestHeaderLength = 4;
    private static final byte[] numDaysInterestHeader = new byte[] {49, 53, 55, (byte) '='};

    private static final int exDateHeaderLength = 4;
    private static final byte[] exDateHeader = new byte[] {50, 51, 48, (byte) '='};

    private static final int accruedInterestRateHeaderLength = 4;
    private static final byte[] accruedInterestRateHeader = new byte[] {49, 53, 56, (byte) '='};

    private static final int accruedInterestAmtHeaderLength = 4;
    private static final byte[] accruedInterestAmtHeader = new byte[] {49, 53, 57, (byte) '='};

    private static final int interestAtMaturityHeaderLength = 4;
    private static final byte[] interestAtMaturityHeader = new byte[] {55, 51, 56, (byte) '='};

    private static final int endAccruedInterestAmtHeaderLength = 4;
    private static final byte[] endAccruedInterestAmtHeader = new byte[] {57, 50, 48, (byte) '='};

    private static final int startCashHeaderLength = 4;
    private static final byte[] startCashHeader = new byte[] {57, 50, 49, (byte) '='};

    private static final int endCashHeaderLength = 4;
    private static final byte[] endCashHeader = new byte[] {57, 50, 50, (byte) '='};

    private static final int concessionHeaderLength = 4;
    private static final byte[] concessionHeader = new byte[] {50, 51, 56, (byte) '='};

    private static final int totalTakedownHeaderLength = 4;
    private static final byte[] totalTakedownHeader = new byte[] {50, 51, 55, (byte) '='};

    private static final int netMoneyHeaderLength = 4;
    private static final byte[] netMoneyHeader = new byte[] {49, 49, 56, (byte) '='};

    private static final int maturityNetMoneyHeaderLength = 4;
    private static final byte[] maturityNetMoneyHeader = new byte[] {56, 57, 48, (byte) '='};

    private static final int settlCurrAmtHeaderLength = 4;
    private static final byte[] settlCurrAmtHeader = new byte[] {49, 49, 57, (byte) '='};

    private static final int settlCurrencyHeaderLength = 4;
    private static final byte[] settlCurrencyHeader = new byte[] {49, 50, 48, (byte) '='};

    private static final int settlCurrFxRateHeaderLength = 4;
    private static final byte[] settlCurrFxRateHeader = new byte[] {49, 53, 53, (byte) '='};

    private static final int settlCurrFxRateCalcHeaderLength = 4;
    private static final byte[] settlCurrFxRateCalcHeader = new byte[] {49, 53, 54, (byte) '='};

    private static final int settlTypeHeaderLength = 3;
    private static final byte[] settlTypeHeader = new byte[] {54, 51, (byte) '='};

    private static final int settlDateHeaderLength = 3;
    private static final byte[] settlDateHeader = new byte[] {54, 52, (byte) '='};

    private static final int sharedCommissionHeaderLength = 4;
    private static final byte[] sharedCommissionHeader = new byte[] {56, 53, 56, (byte) '='};

    private static final int noMiscFeesGroupCounterHeaderLength = 4;
    private static final byte[] noMiscFeesGroupCounterHeader = new byte[] {49, 51, 54, (byte) '='};

    private final MutableDirectBuffer confirmID = new UnsafeBuffer();

    private int confirmIDOffset = 0;

    private int confirmIDLength = 0;

    /* ConfirmID = 664 */
    public ConfirmationEncoder confirmID(final DirectBuffer value, final int offset, final int length)
    {
        confirmID.wrap(value);
        confirmIDOffset = offset;
        confirmIDLength = length;
        return this;
    }

    /* ConfirmID = 664 */
    public ConfirmationEncoder confirmID(final DirectBuffer value, final int length)
    {
        return confirmID(value, 0, length);
    }

    /* ConfirmID = 664 */
    public ConfirmationEncoder confirmID(final DirectBuffer value)
    {
        return confirmID(value, 0, value.capacity());
    }

    /* ConfirmID = 664 */
    public ConfirmationEncoder confirmID(final byte[] value, final int offset, final int length)
    {
        confirmID.wrap(value);
        confirmIDOffset = offset;
        confirmIDLength = length;
        return this;
    }

    /* ConfirmID = 664 */
    public ConfirmationEncoder confirmIDAsCopy(final byte[] value, final int offset, final int length)
    {
        copyInto(confirmID, value, offset, length);
        confirmIDOffset = offset;
        confirmIDLength = length;
        return this;
    }

    /* ConfirmID = 664 */
    public ConfirmationEncoder confirmID(final byte[] value, final int length)
    {
        return confirmID(value, 0, length);
    }

    /* ConfirmID = 664 */
    public ConfirmationEncoder confirmID(final byte[] value)
    {
        return confirmID(value, 0, value.length);
    }

    /* ConfirmID = 664 */
    public boolean hasConfirmID()
    {
        return confirmIDLength > 0;
    }

    /* ConfirmID = 664 */
    public MutableDirectBuffer confirmID()
    {
        return confirmID;
    }

    /* ConfirmID = 664 */
    public String confirmIDAsString()
    {
        return confirmID.getStringWithoutLengthAscii(confirmIDOffset, confirmIDLength);
    }

    /* ConfirmID = 664 */
    public ConfirmationEncoder confirmID(final CharSequence value)
    {
        toBytes(value, confirmID);
        confirmIDOffset = 0;
        confirmIDLength = value.length();
        return this;
    }

    /* ConfirmID = 664 */
    public ConfirmationEncoder confirmID(final AsciiSequenceView value)
    {
        final DirectBuffer buffer = value.buffer();
        if (buffer != null)
        {
            confirmID.wrap(buffer);
            confirmIDOffset = value.offset();
            confirmIDLength = value.length();
        }
        return this;
    }

    /* ConfirmID = 664 */
    public ConfirmationEncoder confirmID(final char[] value)
    {
        return confirmID(value, 0, value.length);
    }

    /* ConfirmID = 664 */
    public ConfirmationEncoder confirmID(final char[] value, final int length)
    {
        return confirmID(value, 0, length);
    }

    /* ConfirmID = 664 */
    public ConfirmationEncoder confirmID(final char[] value, final int offset, final int length)
    {
        toBytes(value, confirmID, offset, length);
        confirmIDOffset = 0;
        confirmIDLength = length;
        return this;
    }

    private final MutableDirectBuffer confirmRefID = new UnsafeBuffer();

    private int confirmRefIDOffset = 0;

    private int confirmRefIDLength = 0;

    /* ConfirmRefID = 772 */
    public ConfirmationEncoder confirmRefID(final DirectBuffer value, final int offset, final int length)
    {
        confirmRefID.wrap(value);
        confirmRefIDOffset = offset;
        confirmRefIDLength = length;
        return this;
    }

    /* ConfirmRefID = 772 */
    public ConfirmationEncoder confirmRefID(final DirectBuffer value, final int length)
    {
        return confirmRefID(value, 0, length);
    }

    /* ConfirmRefID = 772 */
    public ConfirmationEncoder confirmRefID(final DirectBuffer value)
    {
        return confirmRefID(value, 0, value.capacity());
    }

    /* ConfirmRefID = 772 */
    public ConfirmationEncoder confirmRefID(final byte[] value, final int offset, final int length)
    {
        confirmRefID.wrap(value);
        confirmRefIDOffset = offset;
        confirmRefIDLength = length;
        return this;
    }

    /* ConfirmRefID = 772 */
    public ConfirmationEncoder confirmRefIDAsCopy(final byte[] value, final int offset, final int length)
    {
        copyInto(confirmRefID, value, offset, length);
        confirmRefIDOffset = offset;
        confirmRefIDLength = length;
        return this;
    }

    /* ConfirmRefID = 772 */
    public ConfirmationEncoder confirmRefID(final byte[] value, final int length)
    {
        return confirmRefID(value, 0, length);
    }

    /* ConfirmRefID = 772 */
    public ConfirmationEncoder confirmRefID(final byte[] value)
    {
        return confirmRefID(value, 0, value.length);
    }

    /* ConfirmRefID = 772 */
    public boolean hasConfirmRefID()
    {
        return confirmRefIDLength > 0;
    }

    /* ConfirmRefID = 772 */
    public MutableDirectBuffer confirmRefID()
    {
        return confirmRefID;
    }

    /* ConfirmRefID = 772 */
    public String confirmRefIDAsString()
    {
        return confirmRefID.getStringWithoutLengthAscii(confirmRefIDOffset, confirmRefIDLength);
    }

    /* ConfirmRefID = 772 */
    public ConfirmationEncoder confirmRefID(final CharSequence value)
    {
        toBytes(value, confirmRefID);
        confirmRefIDOffset = 0;
        confirmRefIDLength = value.length();
        return this;
    }

    /* ConfirmRefID = 772 */
    public ConfirmationEncoder confirmRefID(final AsciiSequenceView value)
    {
        final DirectBuffer buffer = value.buffer();
        if (buffer != null)
        {
            confirmRefID.wrap(buffer);
            confirmRefIDOffset = value.offset();
            confirmRefIDLength = value.length();
        }
        return this;
    }

    /* ConfirmRefID = 772 */
    public ConfirmationEncoder confirmRefID(final char[] value)
    {
        return confirmRefID(value, 0, value.length);
    }

    /* ConfirmRefID = 772 */
    public ConfirmationEncoder confirmRefID(final char[] value, final int length)
    {
        return confirmRefID(value, 0, length);
    }

    /* ConfirmRefID = 772 */
    public ConfirmationEncoder confirmRefID(final char[] value, final int offset, final int length)
    {
        toBytes(value, confirmRefID, offset, length);
        confirmRefIDOffset = 0;
        confirmRefIDLength = length;
        return this;
    }

    private final MutableDirectBuffer confirmReqID = new UnsafeBuffer();

    private int confirmReqIDOffset = 0;

    private int confirmReqIDLength = 0;

    /* ConfirmReqID = 859 */
    public ConfirmationEncoder confirmReqID(final DirectBuffer value, final int offset, final int length)
    {
        confirmReqID.wrap(value);
        confirmReqIDOffset = offset;
        confirmReqIDLength = length;
        return this;
    }

    /* ConfirmReqID = 859 */
    public ConfirmationEncoder confirmReqID(final DirectBuffer value, final int length)
    {
        return confirmReqID(value, 0, length);
    }

    /* ConfirmReqID = 859 */
    public ConfirmationEncoder confirmReqID(final DirectBuffer value)
    {
        return confirmReqID(value, 0, value.capacity());
    }

    /* ConfirmReqID = 859 */
    public ConfirmationEncoder confirmReqID(final byte[] value, final int offset, final int length)
    {
        confirmReqID.wrap(value);
        confirmReqIDOffset = offset;
        confirmReqIDLength = length;
        return this;
    }

    /* ConfirmReqID = 859 */
    public ConfirmationEncoder confirmReqIDAsCopy(final byte[] value, final int offset, final int length)
    {
        copyInto(confirmReqID, value, offset, length);
        confirmReqIDOffset = offset;
        confirmReqIDLength = length;
        return this;
    }

    /* ConfirmReqID = 859 */
    public ConfirmationEncoder confirmReqID(final byte[] value, final int length)
    {
        return confirmReqID(value, 0, length);
    }

    /* ConfirmReqID = 859 */
    public ConfirmationEncoder confirmReqID(final byte[] value)
    {
        return confirmReqID(value, 0, value.length);
    }

    /* ConfirmReqID = 859 */
    public boolean hasConfirmReqID()
    {
        return confirmReqIDLength > 0;
    }

    /* ConfirmReqID = 859 */
    public MutableDirectBuffer confirmReqID()
    {
        return confirmReqID;
    }

    /* ConfirmReqID = 859 */
    public String confirmReqIDAsString()
    {
        return confirmReqID.getStringWithoutLengthAscii(confirmReqIDOffset, confirmReqIDLength);
    }

    /* ConfirmReqID = 859 */
    public ConfirmationEncoder confirmReqID(final CharSequence value)
    {
        toBytes(value, confirmReqID);
        confirmReqIDOffset = 0;
        confirmReqIDLength = value.length();
        return this;
    }

    /* ConfirmReqID = 859 */
    public ConfirmationEncoder confirmReqID(final AsciiSequenceView value)
    {
        final DirectBuffer buffer = value.buffer();
        if (buffer != null)
        {
            confirmReqID.wrap(buffer);
            confirmReqIDOffset = value.offset();
            confirmReqIDLength = value.length();
        }
        return this;
    }

    /* ConfirmReqID = 859 */
    public ConfirmationEncoder confirmReqID(final char[] value)
    {
        return confirmReqID(value, 0, value.length);
    }

    /* ConfirmReqID = 859 */
    public ConfirmationEncoder confirmReqID(final char[] value, final int length)
    {
        return confirmReqID(value, 0, length);
    }

    /* ConfirmReqID = 859 */
    public ConfirmationEncoder confirmReqID(final char[] value, final int offset, final int length)
    {
        toBytes(value, confirmReqID, offset, length);
        confirmReqIDOffset = 0;
        confirmReqIDLength = length;
        return this;
    }

    private int confirmTransType;

    private boolean hasConfirmTransType;

    public boolean hasConfirmTransType()
    {
        return hasConfirmTransType;
    }

    /* ConfirmTransType = 666 */
    public ConfirmationEncoder confirmTransType(int value)
    {
        confirmTransType = value;
        hasConfirmTransType = true;
        return this;
    }

    /* ConfirmTransType = 666 */
    public int confirmTransType()
    {
        return confirmTransType;
    }

    public ConfirmationEncoder confirmTransType(ConfirmTransType value)
    {
        if (CODEC_VALIDATION_ENABLED)
        {
            if (value == ConfirmTransType.ARTIO_UNKNOWN)
            {
                throw new EncodingException("Invalid Value Field: confirmTransType Value: " + value );
            }
            if (value == ConfirmTransType.NULL_VAL)
            {
                return this;
            }
        }
        return confirmTransType(value.representation());
    }

    private int confirmType;

    private boolean hasConfirmType;

    public boolean hasConfirmType()
    {
        return hasConfirmType;
    }

    /* ConfirmType = 773 */
    public ConfirmationEncoder confirmType(int value)
    {
        confirmType = value;
        hasConfirmType = true;
        return this;
    }

    /* ConfirmType = 773 */
    public int confirmType()
    {
        return confirmType;
    }

    public ConfirmationEncoder confirmType(ConfirmType value)
    {
        if (CODEC_VALIDATION_ENABLED)
        {
            if (value == ConfirmType.ARTIO_UNKNOWN)
            {
                throw new EncodingException("Invalid Value Field: confirmType Value: " + value );
            }
            if (value == ConfirmType.NULL_VAL)
            {
                return this;
            }
        }
        return confirmType(value.representation());
    }

    private boolean copyMsgIndicator;

    private boolean hasCopyMsgIndicator;

    public boolean hasCopyMsgIndicator()
    {
        return hasCopyMsgIndicator;
    }

    /* CopyMsgIndicator = 797 */
    public ConfirmationEncoder copyMsgIndicator(boolean value)
    {
        copyMsgIndicator = value;
        hasCopyMsgIndicator = true;
        return this;
    }

    /* CopyMsgIndicator = 797 */
    public boolean copyMsgIndicator()
    {
        return copyMsgIndicator;
    }

    private boolean legalConfirm;

    private boolean hasLegalConfirm;

    public boolean hasLegalConfirm()
    {
        return hasLegalConfirm;
    }

    /* LegalConfirm = 650 */
    public ConfirmationEncoder legalConfirm(boolean value)
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

    private int confirmStatus;

    private boolean hasConfirmStatus;

    public boolean hasConfirmStatus()
    {
        return hasConfirmStatus;
    }

    /* ConfirmStatus = 665 */
    public ConfirmationEncoder confirmStatus(int value)
    {
        confirmStatus = value;
        hasConfirmStatus = true;
        return this;
    }

    /* ConfirmStatus = 665 */
    public int confirmStatus()
    {
        return confirmStatus;
    }

    public ConfirmationEncoder confirmStatus(ConfirmStatus value)
    {
        if (CODEC_VALIDATION_ENABLED)
        {
            if (value == ConfirmStatus.ARTIO_UNKNOWN)
            {
                throw new EncodingException("Invalid Value Field: confirmStatus Value: " + value );
            }
            if (value == ConfirmStatus.NULL_VAL)
            {
                return this;
            }
        }
        return confirmStatus(value.representation());
    }

    private final PartiesEncoder parties = new PartiesEncoder();
    public PartiesEncoder parties()
    {
        return parties;
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
    public ConfirmationEncoder noOrdersGroupCounter(int value)
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

    private final MutableDirectBuffer allocID = new UnsafeBuffer();

    private int allocIDOffset = 0;

    private int allocIDLength = 0;

    /* AllocID = 70 */
    public ConfirmationEncoder allocID(final DirectBuffer value, final int offset, final int length)
    {
        allocID.wrap(value);
        allocIDOffset = offset;
        allocIDLength = length;
        return this;
    }

    /* AllocID = 70 */
    public ConfirmationEncoder allocID(final DirectBuffer value, final int length)
    {
        return allocID(value, 0, length);
    }

    /* AllocID = 70 */
    public ConfirmationEncoder allocID(final DirectBuffer value)
    {
        return allocID(value, 0, value.capacity());
    }

    /* AllocID = 70 */
    public ConfirmationEncoder allocID(final byte[] value, final int offset, final int length)
    {
        allocID.wrap(value);
        allocIDOffset = offset;
        allocIDLength = length;
        return this;
    }

    /* AllocID = 70 */
    public ConfirmationEncoder allocIDAsCopy(final byte[] value, final int offset, final int length)
    {
        copyInto(allocID, value, offset, length);
        allocIDOffset = offset;
        allocIDLength = length;
        return this;
    }

    /* AllocID = 70 */
    public ConfirmationEncoder allocID(final byte[] value, final int length)
    {
        return allocID(value, 0, length);
    }

    /* AllocID = 70 */
    public ConfirmationEncoder allocID(final byte[] value)
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
    public ConfirmationEncoder allocID(final CharSequence value)
    {
        toBytes(value, allocID);
        allocIDOffset = 0;
        allocIDLength = value.length();
        return this;
    }

    /* AllocID = 70 */
    public ConfirmationEncoder allocID(final AsciiSequenceView value)
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
    public ConfirmationEncoder allocID(final char[] value)
    {
        return allocID(value, 0, value.length);
    }

    /* AllocID = 70 */
    public ConfirmationEncoder allocID(final char[] value, final int length)
    {
        return allocID(value, 0, length);
    }

    /* AllocID = 70 */
    public ConfirmationEncoder allocID(final char[] value, final int offset, final int length)
    {
        toBytes(value, allocID, offset, length);
        allocIDOffset = 0;
        allocIDLength = length;
        return this;
    }

    private final MutableDirectBuffer secondaryAllocID = new UnsafeBuffer();

    private int secondaryAllocIDOffset = 0;

    private int secondaryAllocIDLength = 0;

    /* SecondaryAllocID = 793 */
    public ConfirmationEncoder secondaryAllocID(final DirectBuffer value, final int offset, final int length)
    {
        secondaryAllocID.wrap(value);
        secondaryAllocIDOffset = offset;
        secondaryAllocIDLength = length;
        return this;
    }

    /* SecondaryAllocID = 793 */
    public ConfirmationEncoder secondaryAllocID(final DirectBuffer value, final int length)
    {
        return secondaryAllocID(value, 0, length);
    }

    /* SecondaryAllocID = 793 */
    public ConfirmationEncoder secondaryAllocID(final DirectBuffer value)
    {
        return secondaryAllocID(value, 0, value.capacity());
    }

    /* SecondaryAllocID = 793 */
    public ConfirmationEncoder secondaryAllocID(final byte[] value, final int offset, final int length)
    {
        secondaryAllocID.wrap(value);
        secondaryAllocIDOffset = offset;
        secondaryAllocIDLength = length;
        return this;
    }

    /* SecondaryAllocID = 793 */
    public ConfirmationEncoder secondaryAllocIDAsCopy(final byte[] value, final int offset, final int length)
    {
        copyInto(secondaryAllocID, value, offset, length);
        secondaryAllocIDOffset = offset;
        secondaryAllocIDLength = length;
        return this;
    }

    /* SecondaryAllocID = 793 */
    public ConfirmationEncoder secondaryAllocID(final byte[] value, final int length)
    {
        return secondaryAllocID(value, 0, length);
    }

    /* SecondaryAllocID = 793 */
    public ConfirmationEncoder secondaryAllocID(final byte[] value)
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
    public ConfirmationEncoder secondaryAllocID(final CharSequence value)
    {
        toBytes(value, secondaryAllocID);
        secondaryAllocIDOffset = 0;
        secondaryAllocIDLength = value.length();
        return this;
    }

    /* SecondaryAllocID = 793 */
    public ConfirmationEncoder secondaryAllocID(final AsciiSequenceView value)
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
    public ConfirmationEncoder secondaryAllocID(final char[] value)
    {
        return secondaryAllocID(value, 0, value.length);
    }

    /* SecondaryAllocID = 793 */
    public ConfirmationEncoder secondaryAllocID(final char[] value, final int length)
    {
        return secondaryAllocID(value, 0, length);
    }

    /* SecondaryAllocID = 793 */
    public ConfirmationEncoder secondaryAllocID(final char[] value, final int offset, final int length)
    {
        toBytes(value, secondaryAllocID, offset, length);
        secondaryAllocIDOffset = 0;
        secondaryAllocIDLength = length;
        return this;
    }

    private final MutableDirectBuffer individualAllocID = new UnsafeBuffer();

    private int individualAllocIDOffset = 0;

    private int individualAllocIDLength = 0;

    /* IndividualAllocID = 467 */
    public ConfirmationEncoder individualAllocID(final DirectBuffer value, final int offset, final int length)
    {
        individualAllocID.wrap(value);
        individualAllocIDOffset = offset;
        individualAllocIDLength = length;
        return this;
    }

    /* IndividualAllocID = 467 */
    public ConfirmationEncoder individualAllocID(final DirectBuffer value, final int length)
    {
        return individualAllocID(value, 0, length);
    }

    /* IndividualAllocID = 467 */
    public ConfirmationEncoder individualAllocID(final DirectBuffer value)
    {
        return individualAllocID(value, 0, value.capacity());
    }

    /* IndividualAllocID = 467 */
    public ConfirmationEncoder individualAllocID(final byte[] value, final int offset, final int length)
    {
        individualAllocID.wrap(value);
        individualAllocIDOffset = offset;
        individualAllocIDLength = length;
        return this;
    }

    /* IndividualAllocID = 467 */
    public ConfirmationEncoder individualAllocIDAsCopy(final byte[] value, final int offset, final int length)
    {
        copyInto(individualAllocID, value, offset, length);
        individualAllocIDOffset = offset;
        individualAllocIDLength = length;
        return this;
    }

    /* IndividualAllocID = 467 */
    public ConfirmationEncoder individualAllocID(final byte[] value, final int length)
    {
        return individualAllocID(value, 0, length);
    }

    /* IndividualAllocID = 467 */
    public ConfirmationEncoder individualAllocID(final byte[] value)
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
    public ConfirmationEncoder individualAllocID(final CharSequence value)
    {
        toBytes(value, individualAllocID);
        individualAllocIDOffset = 0;
        individualAllocIDLength = value.length();
        return this;
    }

    /* IndividualAllocID = 467 */
    public ConfirmationEncoder individualAllocID(final AsciiSequenceView value)
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
    public ConfirmationEncoder individualAllocID(final char[] value)
    {
        return individualAllocID(value, 0, value.length);
    }

    /* IndividualAllocID = 467 */
    public ConfirmationEncoder individualAllocID(final char[] value, final int length)
    {
        return individualAllocID(value, 0, length);
    }

    /* IndividualAllocID = 467 */
    public ConfirmationEncoder individualAllocID(final char[] value, final int offset, final int length)
    {
        toBytes(value, individualAllocID, offset, length);
        individualAllocIDOffset = 0;
        individualAllocIDLength = length;
        return this;
    }

    private final MutableDirectBuffer transactTime = new UnsafeBuffer();

    private int transactTimeOffset = 0;

    private int transactTimeLength = 0;

    /* TransactTime = 60 */
    public ConfirmationEncoder transactTime(final DirectBuffer value, final int offset, final int length)
    {
        transactTime.wrap(value);
        transactTimeOffset = offset;
        transactTimeLength = length;
        return this;
    }

    /* TransactTime = 60 */
    public ConfirmationEncoder transactTime(final DirectBuffer value, final int length)
    {
        return transactTime(value, 0, length);
    }

    /* TransactTime = 60 */
    public ConfirmationEncoder transactTime(final DirectBuffer value)
    {
        return transactTime(value, 0, value.capacity());
    }

    /* TransactTime = 60 */
    public ConfirmationEncoder transactTime(final byte[] value, final int offset, final int length)
    {
        transactTime.wrap(value);
        transactTimeOffset = offset;
        transactTimeLength = length;
        return this;
    }

    /* TransactTime = 60 */
    public ConfirmationEncoder transactTimeAsCopy(final byte[] value, final int offset, final int length)
    {
        copyInto(transactTime, value, offset, length);
        transactTimeOffset = offset;
        transactTimeLength = length;
        return this;
    }

    /* TransactTime = 60 */
    public ConfirmationEncoder transactTime(final byte[] value, final int length)
    {
        return transactTime(value, 0, length);
    }

    /* TransactTime = 60 */
    public ConfirmationEncoder transactTime(final byte[] value)
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

    private final MutableDirectBuffer tradeDate = new UnsafeBuffer();

    private int tradeDateOffset = 0;

    private int tradeDateLength = 0;

    /* TradeDate = 75 */
    public ConfirmationEncoder tradeDate(final DirectBuffer value, final int offset, final int length)
    {
        tradeDate.wrap(value);
        tradeDateOffset = offset;
        tradeDateLength = length;
        return this;
    }

    /* TradeDate = 75 */
    public ConfirmationEncoder tradeDate(final DirectBuffer value, final int length)
    {
        return tradeDate(value, 0, length);
    }

    /* TradeDate = 75 */
    public ConfirmationEncoder tradeDate(final DirectBuffer value)
    {
        return tradeDate(value, 0, value.capacity());
    }

    /* TradeDate = 75 */
    public ConfirmationEncoder tradeDate(final byte[] value, final int offset, final int length)
    {
        tradeDate.wrap(value);
        tradeDateOffset = offset;
        tradeDateLength = length;
        return this;
    }

    /* TradeDate = 75 */
    public ConfirmationEncoder tradeDateAsCopy(final byte[] value, final int offset, final int length)
    {
        copyInto(tradeDate, value, offset, length);
        tradeDateOffset = offset;
        tradeDateLength = length;
        return this;
    }

    /* TradeDate = 75 */
    public ConfirmationEncoder tradeDate(final byte[] value, final int length)
    {
        return tradeDate(value, 0, length);
    }

    /* TradeDate = 75 */
    public ConfirmationEncoder tradeDate(final byte[] value)
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

    private final TrdRegTimestampsEncoder trdRegTimestamps = new TrdRegTimestampsEncoder();
    public TrdRegTimestampsEncoder trdRegTimestamps()
    {
        return trdRegTimestamps;
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
    public ConfirmationEncoder noUnderlyingsGroupCounter(int value)
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
    public ConfirmationEncoder noLegsGroupCounter(int value)
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

    private final YieldDataEncoder yieldData = new YieldDataEncoder();
    public YieldDataEncoder yieldData()
    {
        return yieldData;
    }

    private final DecimalFloat allocQty = new DecimalFloat();

    private boolean hasAllocQty;

    public boolean hasAllocQty()
    {
        return hasAllocQty;
    }

    /* AllocQty = 80 */
    public ConfirmationEncoder allocQty(ReadOnlyDecimalFloat value)
    {
        allocQty.set(value);
        hasAllocQty = true;
        return this;
    }

    /* AllocQty = 80 */
    public ConfirmationEncoder allocQty(long value, int scale)
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

    private int qtyType;

    private boolean hasQtyType;

    public boolean hasQtyType()
    {
        return hasQtyType;
    }

    /* QtyType = 854 */
    public ConfirmationEncoder qtyType(int value)
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

    public ConfirmationEncoder qtyType(QtyType value)
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

    private char side;

    private boolean hasSide;

    public boolean hasSide()
    {
        return hasSide;
    }

    /* Side = 54 */
    public ConfirmationEncoder side(char value)
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

    public ConfirmationEncoder side(Side value)
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

    private final MutableDirectBuffer currency = new UnsafeBuffer();

    private int currencyOffset = 0;

    private int currencyLength = 0;

    /* Currency = 15 */
    public ConfirmationEncoder currency(final DirectBuffer value, final int offset, final int length)
    {
        currency.wrap(value);
        currencyOffset = offset;
        currencyLength = length;
        return this;
    }

    /* Currency = 15 */
    public ConfirmationEncoder currency(final DirectBuffer value, final int length)
    {
        return currency(value, 0, length);
    }

    /* Currency = 15 */
    public ConfirmationEncoder currency(final DirectBuffer value)
    {
        return currency(value, 0, value.capacity());
    }

    /* Currency = 15 */
    public ConfirmationEncoder currency(final byte[] value, final int offset, final int length)
    {
        currency.wrap(value);
        currencyOffset = offset;
        currencyLength = length;
        return this;
    }

    /* Currency = 15 */
    public ConfirmationEncoder currencyAsCopy(final byte[] value, final int offset, final int length)
    {
        copyInto(currency, value, offset, length);
        currencyOffset = offset;
        currencyLength = length;
        return this;
    }

    /* Currency = 15 */
    public ConfirmationEncoder currency(final byte[] value, final int length)
    {
        return currency(value, 0, length);
    }

    /* Currency = 15 */
    public ConfirmationEncoder currency(final byte[] value)
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
    public ConfirmationEncoder currency(final CharSequence value)
    {
        toBytes(value, currency);
        currencyOffset = 0;
        currencyLength = value.length();
        return this;
    }

    /* Currency = 15 */
    public ConfirmationEncoder currency(final AsciiSequenceView value)
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
    public ConfirmationEncoder currency(final char[] value)
    {
        return currency(value, 0, value.length);
    }

    /* Currency = 15 */
    public ConfirmationEncoder currency(final char[] value, final int length)
    {
        return currency(value, 0, length);
    }

    /* Currency = 15 */
    public ConfirmationEncoder currency(final char[] value, final int offset, final int length)
    {
        toBytes(value, currency, offset, length);
        currencyOffset = 0;
        currencyLength = length;
        return this;
    }

    private final MutableDirectBuffer lastMkt = new UnsafeBuffer();

    private int lastMktOffset = 0;

    private int lastMktLength = 0;

    /* LastMkt = 30 */
    public ConfirmationEncoder lastMkt(final DirectBuffer value, final int offset, final int length)
    {
        lastMkt.wrap(value);
        lastMktOffset = offset;
        lastMktLength = length;
        return this;
    }

    /* LastMkt = 30 */
    public ConfirmationEncoder lastMkt(final DirectBuffer value, final int length)
    {
        return lastMkt(value, 0, length);
    }

    /* LastMkt = 30 */
    public ConfirmationEncoder lastMkt(final DirectBuffer value)
    {
        return lastMkt(value, 0, value.capacity());
    }

    /* LastMkt = 30 */
    public ConfirmationEncoder lastMkt(final byte[] value, final int offset, final int length)
    {
        lastMkt.wrap(value);
        lastMktOffset = offset;
        lastMktLength = length;
        return this;
    }

    /* LastMkt = 30 */
    public ConfirmationEncoder lastMktAsCopy(final byte[] value, final int offset, final int length)
    {
        copyInto(lastMkt, value, offset, length);
        lastMktOffset = offset;
        lastMktLength = length;
        return this;
    }

    /* LastMkt = 30 */
    public ConfirmationEncoder lastMkt(final byte[] value, final int length)
    {
        return lastMkt(value, 0, length);
    }

    /* LastMkt = 30 */
    public ConfirmationEncoder lastMkt(final byte[] value)
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
    public ConfirmationEncoder lastMkt(final CharSequence value)
    {
        toBytes(value, lastMkt);
        lastMktOffset = 0;
        lastMktLength = value.length();
        return this;
    }

    /* LastMkt = 30 */
    public ConfirmationEncoder lastMkt(final AsciiSequenceView value)
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
    public ConfirmationEncoder lastMkt(final char[] value)
    {
        return lastMkt(value, 0, value.length);
    }

    /* LastMkt = 30 */
    public ConfirmationEncoder lastMkt(final char[] value, final int length)
    {
        return lastMkt(value, 0, length);
    }

    /* LastMkt = 30 */
    public ConfirmationEncoder lastMkt(final char[] value, final int offset, final int length)
    {
        toBytes(value, lastMkt, offset, length);
        lastMktOffset = 0;
        lastMktLength = length;
        return this;
    }


@Generated("uk.co.real_logic.artio")
public static class CapacitiesGroupEncoder
{
    private CapacitiesGroupEncoder next = null;

    public CapacitiesGroupEncoder next()
    {
        if (next == null)
        {
            next = new CapacitiesGroupEncoder();
        }
        return next;
    }

    private static final int orderCapacityHeaderLength = 4;
    private static final byte[] orderCapacityHeader = new byte[] {53, 50, 56, (byte) '='};

    private static final int orderRestrictionsHeaderLength = 4;
    private static final byte[] orderRestrictionsHeader = new byte[] {53, 50, 57, (byte) '='};

    private static final int orderCapacityQtyHeaderLength = 4;
    private static final byte[] orderCapacityQtyHeader = new byte[] {56, 54, 51, (byte) '='};

    private char orderCapacity;

    private boolean hasOrderCapacity;

    public boolean hasOrderCapacity()
    {
        return hasOrderCapacity;
    }

    /* OrderCapacity = 528 */
    public CapacitiesGroupEncoder orderCapacity(char value)
    {
        orderCapacity = value;
        hasOrderCapacity = true;
        return this;
    }

    /* OrderCapacity = 528 */
    public char orderCapacity()
    {
        return orderCapacity;
    }

    public CapacitiesGroupEncoder orderCapacity(OrderCapacity value)
    {
        if (CODEC_VALIDATION_ENABLED)
        {
            if (value == OrderCapacity.ARTIO_UNKNOWN)
            {
                throw new EncodingException("Invalid Value Field: orderCapacity Value: " + value );
            }
            if (value == OrderCapacity.NULL_VAL)
            {
                return this;
            }
        }
        return orderCapacity(value.representation());
    }

    private final MutableDirectBuffer orderRestrictions = new UnsafeBuffer();

    private int orderRestrictionsOffset = 0;

    private int orderRestrictionsLength = 0;

    /* OrderRestrictions = 529 */
    public CapacitiesGroupEncoder orderRestrictions(final DirectBuffer value, final int offset, final int length)
    {
        orderRestrictions.wrap(value);
        orderRestrictionsOffset = offset;
        orderRestrictionsLength = length;
        return this;
    }

    /* OrderRestrictions = 529 */
    public CapacitiesGroupEncoder orderRestrictions(final DirectBuffer value, final int length)
    {
        return orderRestrictions(value, 0, length);
    }

    /* OrderRestrictions = 529 */
    public CapacitiesGroupEncoder orderRestrictions(final DirectBuffer value)
    {
        return orderRestrictions(value, 0, value.capacity());
    }

    /* OrderRestrictions = 529 */
    public CapacitiesGroupEncoder orderRestrictions(final byte[] value, final int offset, final int length)
    {
        orderRestrictions.wrap(value);
        orderRestrictionsOffset = offset;
        orderRestrictionsLength = length;
        return this;
    }

    /* OrderRestrictions = 529 */
    public CapacitiesGroupEncoder orderRestrictionsAsCopy(final byte[] value, final int offset, final int length)
    {
        copyInto(orderRestrictions, value, offset, length);
        orderRestrictionsOffset = offset;
        orderRestrictionsLength = length;
        return this;
    }

    /* OrderRestrictions = 529 */
    public CapacitiesGroupEncoder orderRestrictions(final byte[] value, final int length)
    {
        return orderRestrictions(value, 0, length);
    }

    /* OrderRestrictions = 529 */
    public CapacitiesGroupEncoder orderRestrictions(final byte[] value)
    {
        return orderRestrictions(value, 0, value.length);
    }

    /* OrderRestrictions = 529 */
    public boolean hasOrderRestrictions()
    {
        return orderRestrictionsLength > 0;
    }

    /* OrderRestrictions = 529 */
    public MutableDirectBuffer orderRestrictions()
    {
        return orderRestrictions;
    }

    /* OrderRestrictions = 529 */
    public String orderRestrictionsAsString()
    {
        return orderRestrictions.getStringWithoutLengthAscii(orderRestrictionsOffset, orderRestrictionsLength);
    }

    /* OrderRestrictions = 529 */
    public CapacitiesGroupEncoder orderRestrictions(final CharSequence value)
    {
        toBytes(value, orderRestrictions);
        orderRestrictionsOffset = 0;
        orderRestrictionsLength = value.length();
        return this;
    }

    /* OrderRestrictions = 529 */
    public CapacitiesGroupEncoder orderRestrictions(final AsciiSequenceView value)
    {
        final DirectBuffer buffer = value.buffer();
        if (buffer != null)
        {
            orderRestrictions.wrap(buffer);
            orderRestrictionsOffset = value.offset();
            orderRestrictionsLength = value.length();
        }
        return this;
    }

    /* OrderRestrictions = 529 */
    public CapacitiesGroupEncoder orderRestrictions(final char[] value)
    {
        return orderRestrictions(value, 0, value.length);
    }

    /* OrderRestrictions = 529 */
    public CapacitiesGroupEncoder orderRestrictions(final char[] value, final int length)
    {
        return orderRestrictions(value, 0, length);
    }

    /* OrderRestrictions = 529 */
    public CapacitiesGroupEncoder orderRestrictions(final char[] value, final int offset, final int length)
    {
        toBytes(value, orderRestrictions, offset, length);
        orderRestrictionsOffset = 0;
        orderRestrictionsLength = length;
        return this;
    }

    private final DecimalFloat orderCapacityQty = new DecimalFloat();

    private boolean hasOrderCapacityQty;

    public boolean hasOrderCapacityQty()
    {
        return hasOrderCapacityQty;
    }

    /* OrderCapacityQty = 863 */
    public CapacitiesGroupEncoder orderCapacityQty(ReadOnlyDecimalFloat value)
    {
        orderCapacityQty.set(value);
        hasOrderCapacityQty = true;
        return this;
    }

    /* OrderCapacityQty = 863 */
    public CapacitiesGroupEncoder orderCapacityQty(long value, int scale)
    {
        orderCapacityQty.set(value, scale);
        hasOrderCapacityQty = true;
        return this;
    }

    /* OrderCapacityQty = 863 */
    public DecimalFloat orderCapacityQty()
    {
        return orderCapacityQty;
    }

    public int encode(final MutableAsciiBuffer buffer, final int offset, final int remainingElements)
    {
        if (remainingElements == 0)
        {
            return 0;
        }

        int position = offset;

        if (hasOrderCapacity)
        {
            buffer.putBytes(position, orderCapacityHeader, 0, orderCapacityHeaderLength);
            position += orderCapacityHeaderLength;
            position += buffer.putCharAscii(position, orderCapacity);
            buffer.putSeparator(position);
            position++;
        }
        else if (CODEC_VALIDATION_ENABLED)
        {
            throw new EncodingException("Missing Field: OrderCapacity");
        }

        if (orderRestrictionsLength > 0)
        {
            buffer.putBytes(position, orderRestrictionsHeader, 0, orderRestrictionsHeaderLength);
            position += orderRestrictionsHeaderLength;
            buffer.putBytes(position, orderRestrictions, orderRestrictionsOffset, orderRestrictionsLength);
            position += orderRestrictionsLength;
            buffer.putSeparator(position);
            position++;
        }

        if (hasOrderCapacityQty)
        {
            buffer.putBytes(position, orderCapacityQtyHeader, 0, orderCapacityQtyHeaderLength);
            position += orderCapacityQtyHeaderLength;
            position += buffer.putFloatAscii(position, orderCapacityQty);
            buffer.putSeparator(position);
            position++;
        }
        else if (CODEC_VALIDATION_ENABLED)
        {
            throw new EncodingException("Missing Field: OrderCapacityQty");
        }
        if (next != null)
        {
            position += next.encode(buffer, position, remainingElements - 1);
        }
        return position - offset;
    }

    public void reset()
    {
        this.resetOrderCapacity();
        this.resetOrderRestrictions();
        this.resetOrderCapacityQty();
        if (next != null)        {
            next.reset();
        }
    }

    public void resetOrderCapacity()
    {
        orderCapacity = MISSING_CHAR;
    }

    public void resetOrderRestrictions()
    {
        orderRestrictionsLength = 0;
    }

    public void resetOrderCapacityQty()
    {
        hasOrderCapacityQty = false;
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
        builder.append("\"MessageName\": \"CapacitiesGroup\",\n");
        if (hasOrderCapacity())
        {
            indent(builder, level);
            builder.append("\"OrderCapacity\": \"");
            builder.append(orderCapacity);
            builder.append("\",\n");
        }

        if (hasOrderRestrictions())
        {
            indent(builder, level);
            builder.append("\"OrderRestrictions\": \"");
            appendBuffer(builder, orderRestrictions, orderRestrictionsOffset, orderRestrictionsLength);
            builder.append("\",\n");
        }

        if (hasOrderCapacityQty())
        {
            indent(builder, level);
            builder.append("\"OrderCapacityQty\": \"");
            orderCapacityQty.appendTo(builder);
            builder.append("\",\n");
        }
        indent(builder, level - 1);
        builder.append("}");
        return builder;
    }

    /**
     * {@inheritDoc}
     */
    public CapacitiesGroupEncoder copyTo(final Encoder encoder)
    {
        return copyTo((CapacitiesGroupEncoder)encoder);
    }

    public CapacitiesGroupEncoder copyTo(final CapacitiesGroupEncoder encoder)
    {
        encoder.reset();
        if (hasOrderCapacity())
        {
            encoder.orderCapacity(this.orderCapacity());
        }

        if (hasOrderRestrictions())
        {
            encoder.orderRestrictionsAsCopy(orderRestrictions.byteArray(), 0, orderRestrictionsLength);
        }

        if (hasOrderCapacityQty())
        {
            encoder.orderCapacityQty(this.orderCapacityQty());
        }
        return encoder;
    }

}
    private int noCapacitiesGroupCounter;

    private boolean hasNoCapacitiesGroupCounter;

    public boolean hasNoCapacitiesGroupCounter()
    {
        return hasNoCapacitiesGroupCounter;
    }

    /* NoCapacitiesGroupCounter = 862 */
    public ConfirmationEncoder noCapacitiesGroupCounter(int value)
    {
        noCapacitiesGroupCounter = value;
        hasNoCapacitiesGroupCounter = true;
        return this;
    }

    /* NoCapacitiesGroupCounter = 862 */
    public int noCapacitiesGroupCounter()
    {
        return noCapacitiesGroupCounter;
    }


    private CapacitiesGroupEncoder capacitiesGroup = null;

    public CapacitiesGroupEncoder capacitiesGroup(final int numberOfElements)
    {
        hasNoCapacitiesGroupCounter = true;
        noCapacitiesGroupCounter = numberOfElements;
        if (capacitiesGroup == null)
        {
            capacitiesGroup = new CapacitiesGroupEncoder();
        }
        return capacitiesGroup;
    }

    private final MutableDirectBuffer allocAccount = new UnsafeBuffer();

    private int allocAccountOffset = 0;

    private int allocAccountLength = 0;

    /* AllocAccount = 79 */
    public ConfirmationEncoder allocAccount(final DirectBuffer value, final int offset, final int length)
    {
        allocAccount.wrap(value);
        allocAccountOffset = offset;
        allocAccountLength = length;
        return this;
    }

    /* AllocAccount = 79 */
    public ConfirmationEncoder allocAccount(final DirectBuffer value, final int length)
    {
        return allocAccount(value, 0, length);
    }

    /* AllocAccount = 79 */
    public ConfirmationEncoder allocAccount(final DirectBuffer value)
    {
        return allocAccount(value, 0, value.capacity());
    }

    /* AllocAccount = 79 */
    public ConfirmationEncoder allocAccount(final byte[] value, final int offset, final int length)
    {
        allocAccount.wrap(value);
        allocAccountOffset = offset;
        allocAccountLength = length;
        return this;
    }

    /* AllocAccount = 79 */
    public ConfirmationEncoder allocAccountAsCopy(final byte[] value, final int offset, final int length)
    {
        copyInto(allocAccount, value, offset, length);
        allocAccountOffset = offset;
        allocAccountLength = length;
        return this;
    }

    /* AllocAccount = 79 */
    public ConfirmationEncoder allocAccount(final byte[] value, final int length)
    {
        return allocAccount(value, 0, length);
    }

    /* AllocAccount = 79 */
    public ConfirmationEncoder allocAccount(final byte[] value)
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
    public ConfirmationEncoder allocAccount(final CharSequence value)
    {
        toBytes(value, allocAccount);
        allocAccountOffset = 0;
        allocAccountLength = value.length();
        return this;
    }

    /* AllocAccount = 79 */
    public ConfirmationEncoder allocAccount(final AsciiSequenceView value)
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
    public ConfirmationEncoder allocAccount(final char[] value)
    {
        return allocAccount(value, 0, value.length);
    }

    /* AllocAccount = 79 */
    public ConfirmationEncoder allocAccount(final char[] value, final int length)
    {
        return allocAccount(value, 0, length);
    }

    /* AllocAccount = 79 */
    public ConfirmationEncoder allocAccount(final char[] value, final int offset, final int length)
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
    public ConfirmationEncoder allocAcctIDSource(int value)
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

    private int allocAccountType;

    private boolean hasAllocAccountType;

    public boolean hasAllocAccountType()
    {
        return hasAllocAccountType;
    }

    /* AllocAccountType = 798 */
    public ConfirmationEncoder allocAccountType(int value)
    {
        allocAccountType = value;
        hasAllocAccountType = true;
        return this;
    }

    /* AllocAccountType = 798 */
    public int allocAccountType()
    {
        return allocAccountType;
    }

    public ConfirmationEncoder allocAccountType(AllocAccountType value)
    {
        if (CODEC_VALIDATION_ENABLED)
        {
            if (value == AllocAccountType.ARTIO_UNKNOWN)
            {
                throw new EncodingException("Invalid Value Field: allocAccountType Value: " + value );
            }
            if (value == AllocAccountType.NULL_VAL)
            {
                return this;
            }
        }
        return allocAccountType(value.representation());
    }

    private final DecimalFloat avgPx = new DecimalFloat();

    private boolean hasAvgPx;

    public boolean hasAvgPx()
    {
        return hasAvgPx;
    }

    /* AvgPx = 6 */
    public ConfirmationEncoder avgPx(ReadOnlyDecimalFloat value)
    {
        avgPx.set(value);
        hasAvgPx = true;
        return this;
    }

    /* AvgPx = 6 */
    public ConfirmationEncoder avgPx(long value, int scale)
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

    private int avgPxPrecision;

    private boolean hasAvgPxPrecision;

    public boolean hasAvgPxPrecision()
    {
        return hasAvgPxPrecision;
    }

    /* AvgPxPrecision = 74 */
    public ConfirmationEncoder avgPxPrecision(int value)
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

    private int priceType;

    private boolean hasPriceType;

    public boolean hasPriceType()
    {
        return hasPriceType;
    }

    /* PriceType = 423 */
    public ConfirmationEncoder priceType(int value)
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

    public ConfirmationEncoder priceType(PriceType value)
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

    private final DecimalFloat avgParPx = new DecimalFloat();

    private boolean hasAvgParPx;

    public boolean hasAvgParPx()
    {
        return hasAvgParPx;
    }

    /* AvgParPx = 860 */
    public ConfirmationEncoder avgParPx(ReadOnlyDecimalFloat value)
    {
        avgParPx.set(value);
        hasAvgParPx = true;
        return this;
    }

    /* AvgParPx = 860 */
    public ConfirmationEncoder avgParPx(long value, int scale)
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

    private final DecimalFloat reportedPx = new DecimalFloat();

    private boolean hasReportedPx;

    public boolean hasReportedPx()
    {
        return hasReportedPx;
    }

    /* ReportedPx = 861 */
    public ConfirmationEncoder reportedPx(ReadOnlyDecimalFloat value)
    {
        reportedPx.set(value);
        hasReportedPx = true;
        return this;
    }

    /* ReportedPx = 861 */
    public ConfirmationEncoder reportedPx(long value, int scale)
    {
        reportedPx.set(value, scale);
        hasReportedPx = true;
        return this;
    }

    /* ReportedPx = 861 */
    public DecimalFloat reportedPx()
    {
        return reportedPx;
    }

    private final MutableDirectBuffer text = new UnsafeBuffer();

    private int textOffset = 0;

    private int textLength = 0;

    /* Text = 58 */
    public ConfirmationEncoder text(final DirectBuffer value, final int offset, final int length)
    {
        text.wrap(value);
        textOffset = offset;
        textLength = length;
        return this;
    }

    /* Text = 58 */
    public ConfirmationEncoder text(final DirectBuffer value, final int length)
    {
        return text(value, 0, length);
    }

    /* Text = 58 */
    public ConfirmationEncoder text(final DirectBuffer value)
    {
        return text(value, 0, value.capacity());
    }

    /* Text = 58 */
    public ConfirmationEncoder text(final byte[] value, final int offset, final int length)
    {
        text.wrap(value);
        textOffset = offset;
        textLength = length;
        return this;
    }

    /* Text = 58 */
    public ConfirmationEncoder textAsCopy(final byte[] value, final int offset, final int length)
    {
        copyInto(text, value, offset, length);
        textOffset = offset;
        textLength = length;
        return this;
    }

    /* Text = 58 */
    public ConfirmationEncoder text(final byte[] value, final int length)
    {
        return text(value, 0, length);
    }

    /* Text = 58 */
    public ConfirmationEncoder text(final byte[] value)
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
    public ConfirmationEncoder text(final CharSequence value)
    {
        toBytes(value, text);
        textOffset = 0;
        textLength = value.length();
        return this;
    }

    /* Text = 58 */
    public ConfirmationEncoder text(final AsciiSequenceView value)
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
    public ConfirmationEncoder text(final char[] value)
    {
        return text(value, 0, value.length);
    }

    /* Text = 58 */
    public ConfirmationEncoder text(final char[] value, final int length)
    {
        return text(value, 0, length);
    }

    /* Text = 58 */
    public ConfirmationEncoder text(final char[] value, final int offset, final int length)
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
    public ConfirmationEncoder encodedTextLen(int value)
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
    public ConfirmationEncoder encodedText(byte[] value)
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
    public ConfirmationEncoder encodedTextAsCopy(final byte[] value, final int offset, final int length)
    {
        encodedText = copyInto(encodedText, value, offset, length);
        hasEncodedText = true;
        return this;
    }

    private char processCode;

    private boolean hasProcessCode;

    public boolean hasProcessCode()
    {
        return hasProcessCode;
    }

    /* ProcessCode = 81 */
    public ConfirmationEncoder processCode(char value)
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

    public ConfirmationEncoder processCode(ProcessCode value)
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

    private final DecimalFloat grossTradeAmt = new DecimalFloat();

    private boolean hasGrossTradeAmt;

    public boolean hasGrossTradeAmt()
    {
        return hasGrossTradeAmt;
    }

    /* GrossTradeAmt = 381 */
    public ConfirmationEncoder grossTradeAmt(ReadOnlyDecimalFloat value)
    {
        grossTradeAmt.set(value);
        hasGrossTradeAmt = true;
        return this;
    }

    /* GrossTradeAmt = 381 */
    public ConfirmationEncoder grossTradeAmt(long value, int scale)
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

    private int numDaysInterest;

    private boolean hasNumDaysInterest;

    public boolean hasNumDaysInterest()
    {
        return hasNumDaysInterest;
    }

    /* NumDaysInterest = 157 */
    public ConfirmationEncoder numDaysInterest(int value)
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

    private final MutableDirectBuffer exDate = new UnsafeBuffer();

    private int exDateOffset = 0;

    private int exDateLength = 0;

    /* ExDate = 230 */
    public ConfirmationEncoder exDate(final DirectBuffer value, final int offset, final int length)
    {
        exDate.wrap(value);
        exDateOffset = offset;
        exDateLength = length;
        return this;
    }

    /* ExDate = 230 */
    public ConfirmationEncoder exDate(final DirectBuffer value, final int length)
    {
        return exDate(value, 0, length);
    }

    /* ExDate = 230 */
    public ConfirmationEncoder exDate(final DirectBuffer value)
    {
        return exDate(value, 0, value.capacity());
    }

    /* ExDate = 230 */
    public ConfirmationEncoder exDate(final byte[] value, final int offset, final int length)
    {
        exDate.wrap(value);
        exDateOffset = offset;
        exDateLength = length;
        return this;
    }

    /* ExDate = 230 */
    public ConfirmationEncoder exDateAsCopy(final byte[] value, final int offset, final int length)
    {
        copyInto(exDate, value, offset, length);
        exDateOffset = offset;
        exDateLength = length;
        return this;
    }

    /* ExDate = 230 */
    public ConfirmationEncoder exDate(final byte[] value, final int length)
    {
        return exDate(value, 0, length);
    }

    /* ExDate = 230 */
    public ConfirmationEncoder exDate(final byte[] value)
    {
        return exDate(value, 0, value.length);
    }

    /* ExDate = 230 */
    public boolean hasExDate()
    {
        return exDateLength > 0;
    }

    /* ExDate = 230 */
    public MutableDirectBuffer exDate()
    {
        return exDate;
    }

    /* ExDate = 230 */
    public String exDateAsString()
    {
        return exDate.getStringWithoutLengthAscii(exDateOffset, exDateLength);
    }

    private final DecimalFloat accruedInterestRate = new DecimalFloat();

    private boolean hasAccruedInterestRate;

    public boolean hasAccruedInterestRate()
    {
        return hasAccruedInterestRate;
    }

    /* AccruedInterestRate = 158 */
    public ConfirmationEncoder accruedInterestRate(ReadOnlyDecimalFloat value)
    {
        accruedInterestRate.set(value);
        hasAccruedInterestRate = true;
        return this;
    }

    /* AccruedInterestRate = 158 */
    public ConfirmationEncoder accruedInterestRate(long value, int scale)
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
    public ConfirmationEncoder accruedInterestAmt(ReadOnlyDecimalFloat value)
    {
        accruedInterestAmt.set(value);
        hasAccruedInterestAmt = true;
        return this;
    }

    /* AccruedInterestAmt = 159 */
    public ConfirmationEncoder accruedInterestAmt(long value, int scale)
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

    private final DecimalFloat interestAtMaturity = new DecimalFloat();

    private boolean hasInterestAtMaturity;

    public boolean hasInterestAtMaturity()
    {
        return hasInterestAtMaturity;
    }

    /* InterestAtMaturity = 738 */
    public ConfirmationEncoder interestAtMaturity(ReadOnlyDecimalFloat value)
    {
        interestAtMaturity.set(value);
        hasInterestAtMaturity = true;
        return this;
    }

    /* InterestAtMaturity = 738 */
    public ConfirmationEncoder interestAtMaturity(long value, int scale)
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
    public ConfirmationEncoder endAccruedInterestAmt(ReadOnlyDecimalFloat value)
    {
        endAccruedInterestAmt.set(value);
        hasEndAccruedInterestAmt = true;
        return this;
    }

    /* EndAccruedInterestAmt = 920 */
    public ConfirmationEncoder endAccruedInterestAmt(long value, int scale)
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
    public ConfirmationEncoder startCash(ReadOnlyDecimalFloat value)
    {
        startCash.set(value);
        hasStartCash = true;
        return this;
    }

    /* StartCash = 921 */
    public ConfirmationEncoder startCash(long value, int scale)
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
    public ConfirmationEncoder endCash(ReadOnlyDecimalFloat value)
    {
        endCash.set(value);
        hasEndCash = true;
        return this;
    }

    /* EndCash = 922 */
    public ConfirmationEncoder endCash(long value, int scale)
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

    private final DecimalFloat concession = new DecimalFloat();

    private boolean hasConcession;

    public boolean hasConcession()
    {
        return hasConcession;
    }

    /* Concession = 238 */
    public ConfirmationEncoder concession(ReadOnlyDecimalFloat value)
    {
        concession.set(value);
        hasConcession = true;
        return this;
    }

    /* Concession = 238 */
    public ConfirmationEncoder concession(long value, int scale)
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
    public ConfirmationEncoder totalTakedown(ReadOnlyDecimalFloat value)
    {
        totalTakedown.set(value);
        hasTotalTakedown = true;
        return this;
    }

    /* TotalTakedown = 237 */
    public ConfirmationEncoder totalTakedown(long value, int scale)
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
    public ConfirmationEncoder netMoney(ReadOnlyDecimalFloat value)
    {
        netMoney.set(value);
        hasNetMoney = true;
        return this;
    }

    /* NetMoney = 118 */
    public ConfirmationEncoder netMoney(long value, int scale)
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

    private final DecimalFloat maturityNetMoney = new DecimalFloat();

    private boolean hasMaturityNetMoney;

    public boolean hasMaturityNetMoney()
    {
        return hasMaturityNetMoney;
    }

    /* MaturityNetMoney = 890 */
    public ConfirmationEncoder maturityNetMoney(ReadOnlyDecimalFloat value)
    {
        maturityNetMoney.set(value);
        hasMaturityNetMoney = true;
        return this;
    }

    /* MaturityNetMoney = 890 */
    public ConfirmationEncoder maturityNetMoney(long value, int scale)
    {
        maturityNetMoney.set(value, scale);
        hasMaturityNetMoney = true;
        return this;
    }

    /* MaturityNetMoney = 890 */
    public DecimalFloat maturityNetMoney()
    {
        return maturityNetMoney;
    }

    private final DecimalFloat settlCurrAmt = new DecimalFloat();

    private boolean hasSettlCurrAmt;

    public boolean hasSettlCurrAmt()
    {
        return hasSettlCurrAmt;
    }

    /* SettlCurrAmt = 119 */
    public ConfirmationEncoder settlCurrAmt(ReadOnlyDecimalFloat value)
    {
        settlCurrAmt.set(value);
        hasSettlCurrAmt = true;
        return this;
    }

    /* SettlCurrAmt = 119 */
    public ConfirmationEncoder settlCurrAmt(long value, int scale)
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

    private final MutableDirectBuffer settlCurrency = new UnsafeBuffer();

    private int settlCurrencyOffset = 0;

    private int settlCurrencyLength = 0;

    /* SettlCurrency = 120 */
    public ConfirmationEncoder settlCurrency(final DirectBuffer value, final int offset, final int length)
    {
        settlCurrency.wrap(value);
        settlCurrencyOffset = offset;
        settlCurrencyLength = length;
        return this;
    }

    /* SettlCurrency = 120 */
    public ConfirmationEncoder settlCurrency(final DirectBuffer value, final int length)
    {
        return settlCurrency(value, 0, length);
    }

    /* SettlCurrency = 120 */
    public ConfirmationEncoder settlCurrency(final DirectBuffer value)
    {
        return settlCurrency(value, 0, value.capacity());
    }

    /* SettlCurrency = 120 */
    public ConfirmationEncoder settlCurrency(final byte[] value, final int offset, final int length)
    {
        settlCurrency.wrap(value);
        settlCurrencyOffset = offset;
        settlCurrencyLength = length;
        return this;
    }

    /* SettlCurrency = 120 */
    public ConfirmationEncoder settlCurrencyAsCopy(final byte[] value, final int offset, final int length)
    {
        copyInto(settlCurrency, value, offset, length);
        settlCurrencyOffset = offset;
        settlCurrencyLength = length;
        return this;
    }

    /* SettlCurrency = 120 */
    public ConfirmationEncoder settlCurrency(final byte[] value, final int length)
    {
        return settlCurrency(value, 0, length);
    }

    /* SettlCurrency = 120 */
    public ConfirmationEncoder settlCurrency(final byte[] value)
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
    public ConfirmationEncoder settlCurrency(final CharSequence value)
    {
        toBytes(value, settlCurrency);
        settlCurrencyOffset = 0;
        settlCurrencyLength = value.length();
        return this;
    }

    /* SettlCurrency = 120 */
    public ConfirmationEncoder settlCurrency(final AsciiSequenceView value)
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
    public ConfirmationEncoder settlCurrency(final char[] value)
    {
        return settlCurrency(value, 0, value.length);
    }

    /* SettlCurrency = 120 */
    public ConfirmationEncoder settlCurrency(final char[] value, final int length)
    {
        return settlCurrency(value, 0, length);
    }

    /* SettlCurrency = 120 */
    public ConfirmationEncoder settlCurrency(final char[] value, final int offset, final int length)
    {
        toBytes(value, settlCurrency, offset, length);
        settlCurrencyOffset = 0;
        settlCurrencyLength = length;
        return this;
    }

    private final DecimalFloat settlCurrFxRate = new DecimalFloat();

    private boolean hasSettlCurrFxRate;

    public boolean hasSettlCurrFxRate()
    {
        return hasSettlCurrFxRate;
    }

    /* SettlCurrFxRate = 155 */
    public ConfirmationEncoder settlCurrFxRate(ReadOnlyDecimalFloat value)
    {
        settlCurrFxRate.set(value);
        hasSettlCurrFxRate = true;
        return this;
    }

    /* SettlCurrFxRate = 155 */
    public ConfirmationEncoder settlCurrFxRate(long value, int scale)
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
    public ConfirmationEncoder settlCurrFxRateCalc(char value)
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

    public ConfirmationEncoder settlCurrFxRateCalc(SettlCurrFxRateCalc value)
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

    private char settlType;

    private boolean hasSettlType;

    public boolean hasSettlType()
    {
        return hasSettlType;
    }

    /* SettlType = 63 */
    public ConfirmationEncoder settlType(char value)
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

    public ConfirmationEncoder settlType(SettlType value)
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
    public ConfirmationEncoder settlDate(final DirectBuffer value, final int offset, final int length)
    {
        settlDate.wrap(value);
        settlDateOffset = offset;
        settlDateLength = length;
        return this;
    }

    /* SettlDate = 64 */
    public ConfirmationEncoder settlDate(final DirectBuffer value, final int length)
    {
        return settlDate(value, 0, length);
    }

    /* SettlDate = 64 */
    public ConfirmationEncoder settlDate(final DirectBuffer value)
    {
        return settlDate(value, 0, value.capacity());
    }

    /* SettlDate = 64 */
    public ConfirmationEncoder settlDate(final byte[] value, final int offset, final int length)
    {
        settlDate.wrap(value);
        settlDateOffset = offset;
        settlDateLength = length;
        return this;
    }

    /* SettlDate = 64 */
    public ConfirmationEncoder settlDateAsCopy(final byte[] value, final int offset, final int length)
    {
        copyInto(settlDate, value, offset, length);
        settlDateOffset = offset;
        settlDateLength = length;
        return this;
    }

    /* SettlDate = 64 */
    public ConfirmationEncoder settlDate(final byte[] value, final int length)
    {
        return settlDate(value, 0, length);
    }

    /* SettlDate = 64 */
    public ConfirmationEncoder settlDate(final byte[] value)
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

    private final SettlInstructionsDataEncoder settlInstructionsData = new SettlInstructionsDataEncoder();
    public SettlInstructionsDataEncoder settlInstructionsData()
    {
        return settlInstructionsData;
    }

    private final CommissionDataEncoder commissionData = new CommissionDataEncoder();
    public CommissionDataEncoder commissionData()
    {
        return commissionData;
    }

    private final DecimalFloat sharedCommission = new DecimalFloat();

    private boolean hasSharedCommission;

    public boolean hasSharedCommission()
    {
        return hasSharedCommission;
    }

    /* SharedCommission = 858 */
    public ConfirmationEncoder sharedCommission(ReadOnlyDecimalFloat value)
    {
        sharedCommission.set(value);
        hasSharedCommission = true;
        return this;
    }

    /* SharedCommission = 858 */
    public ConfirmationEncoder sharedCommission(long value, int scale)
    {
        sharedCommission.set(value, scale);
        hasSharedCommission = true;
        return this;
    }

    /* SharedCommission = 858 */
    public DecimalFloat sharedCommission()
    {
        return sharedCommission;
    }

    private final StipulationsEncoder stipulations = new StipulationsEncoder();
    public StipulationsEncoder stipulations()
    {
        return stipulations;
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
    public ConfirmationEncoder noMiscFeesGroupCounter(int value)
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

    public long encode(final MutableAsciiBuffer buffer, final int offset)
    {
        final long startMessageResult = header.startMessage(buffer, offset);
        final int bodyStart = Encoder.offset(startMessageResult);
        int position = bodyStart + Encoder.length(startMessageResult);

        if (confirmIDLength > 0)
        {
            buffer.putBytes(position, confirmIDHeader, 0, confirmIDHeaderLength);
            position += confirmIDHeaderLength;
            buffer.putBytes(position, confirmID, confirmIDOffset, confirmIDLength);
            position += confirmIDLength;
            buffer.putSeparator(position);
            position++;
        }
        else if (CODEC_VALIDATION_ENABLED)
        {
            throw new EncodingException("Missing Field: ConfirmID");
        }

        if (confirmRefIDLength > 0)
        {
            buffer.putBytes(position, confirmRefIDHeader, 0, confirmRefIDHeaderLength);
            position += confirmRefIDHeaderLength;
            buffer.putBytes(position, confirmRefID, confirmRefIDOffset, confirmRefIDLength);
            position += confirmRefIDLength;
            buffer.putSeparator(position);
            position++;
        }

        if (confirmReqIDLength > 0)
        {
            buffer.putBytes(position, confirmReqIDHeader, 0, confirmReqIDHeaderLength);
            position += confirmReqIDHeaderLength;
            buffer.putBytes(position, confirmReqID, confirmReqIDOffset, confirmReqIDLength);
            position += confirmReqIDLength;
            buffer.putSeparator(position);
            position++;
        }

        if (hasConfirmTransType)
        {
            buffer.putBytes(position, confirmTransTypeHeader, 0, confirmTransTypeHeaderLength);
            position += confirmTransTypeHeaderLength;
            position += buffer.putIntAscii(position, confirmTransType);
            buffer.putSeparator(position);
            position++;
        }
        else if (CODEC_VALIDATION_ENABLED)
        {
            throw new EncodingException("Missing Field: ConfirmTransType");
        }

        if (hasConfirmType)
        {
            buffer.putBytes(position, confirmTypeHeader, 0, confirmTypeHeaderLength);
            position += confirmTypeHeaderLength;
            position += buffer.putIntAscii(position, confirmType);
            buffer.putSeparator(position);
            position++;
        }
        else if (CODEC_VALIDATION_ENABLED)
        {
            throw new EncodingException("Missing Field: ConfirmType");
        }

        if (hasCopyMsgIndicator)
        {
            buffer.putBytes(position, copyMsgIndicatorHeader, 0, copyMsgIndicatorHeaderLength);
            position += copyMsgIndicatorHeaderLength;
            position += buffer.putBooleanAscii(position, copyMsgIndicator);
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

        if (hasConfirmStatus)
        {
            buffer.putBytes(position, confirmStatusHeader, 0, confirmStatusHeaderLength);
            position += confirmStatusHeaderLength;
            position += buffer.putIntAscii(position, confirmStatus);
            buffer.putSeparator(position);
            position++;
        }
        else if (CODEC_VALIDATION_ENABLED)
        {
            throw new EncodingException("Missing Field: ConfirmStatus");
        }

            position += parties.encode(buffer, position);

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


        if (allocIDLength > 0)
        {
            buffer.putBytes(position, allocIDHeader, 0, allocIDHeaderLength);
            position += allocIDHeaderLength;
            buffer.putBytes(position, allocID, allocIDOffset, allocIDLength);
            position += allocIDLength;
            buffer.putSeparator(position);
            position++;
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

        if (individualAllocIDLength > 0)
        {
            buffer.putBytes(position, individualAllocIDHeader, 0, individualAllocIDHeaderLength);
            position += individualAllocIDHeaderLength;
            buffer.putBytes(position, individualAllocID, individualAllocIDOffset, individualAllocIDLength);
            position += individualAllocIDLength;
            buffer.putSeparator(position);
            position++;
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
        else if (CODEC_VALIDATION_ENABLED)
        {
            throw new EncodingException("Missing Field: TransactTime");
        }

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

            position += trdRegTimestamps.encode(buffer, position);

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


            position += yieldData.encode(buffer, position);

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

        if (hasQtyType)
        {
            buffer.putBytes(position, qtyTypeHeader, 0, qtyTypeHeaderLength);
            position += qtyTypeHeaderLength;
            position += buffer.putIntAscii(position, qtyType);
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

        if (currencyLength > 0)
        {
            buffer.putBytes(position, currencyHeader, 0, currencyHeaderLength);
            position += currencyHeaderLength;
            buffer.putBytes(position, currency, currencyOffset, currencyLength);
            position += currencyLength;
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

        if (hasNoCapacitiesGroupCounter)
        {
            buffer.putBytes(position, noCapacitiesGroupCounterHeader, 0, noCapacitiesGroupCounterHeaderLength);
            position += noCapacitiesGroupCounterHeaderLength;
            position += buffer.putIntAscii(position, noCapacitiesGroupCounter);
            buffer.putSeparator(position);
            position++;
        }

        if (capacitiesGroup != null)
        {
            position += capacitiesGroup.encode(buffer, position, noCapacitiesGroupCounter);
        }


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

        if (hasAllocAccountType)
        {
            buffer.putBytes(position, allocAccountTypeHeader, 0, allocAccountTypeHeaderLength);
            position += allocAccountTypeHeaderLength;
            position += buffer.putIntAscii(position, allocAccountType);
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

        if (hasAvgPxPrecision)
        {
            buffer.putBytes(position, avgPxPrecisionHeader, 0, avgPxPrecisionHeaderLength);
            position += avgPxPrecisionHeaderLength;
            position += buffer.putIntAscii(position, avgPxPrecision);
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

        if (hasAvgParPx)
        {
            buffer.putBytes(position, avgParPxHeader, 0, avgParPxHeaderLength);
            position += avgParPxHeaderLength;
            position += buffer.putFloatAscii(position, avgParPx);
            buffer.putSeparator(position);
            position++;
        }

            position += spreadOrBenchmarkCurveData.encode(buffer, position);

        if (hasReportedPx)
        {
            buffer.putBytes(position, reportedPxHeader, 0, reportedPxHeaderLength);
            position += reportedPxHeaderLength;
            position += buffer.putFloatAscii(position, reportedPx);
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

        if (hasProcessCode)
        {
            buffer.putBytes(position, processCodeHeader, 0, processCodeHeaderLength);
            position += processCodeHeaderLength;
            position += buffer.putCharAscii(position, processCode);
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
        else if (CODEC_VALIDATION_ENABLED)
        {
            throw new EncodingException("Missing Field: GrossTradeAmt");
        }

        if (hasNumDaysInterest)
        {
            buffer.putBytes(position, numDaysInterestHeader, 0, numDaysInterestHeaderLength);
            position += numDaysInterestHeaderLength;
            position += buffer.putIntAscii(position, numDaysInterest);
            buffer.putSeparator(position);
            position++;
        }

        if (exDateLength > 0)
        {
            buffer.putBytes(position, exDateHeader, 0, exDateHeaderLength);
            position += exDateHeaderLength;
            buffer.putBytes(position, exDate, exDateOffset, exDateLength);
            position += exDateLength;
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
        else if (CODEC_VALIDATION_ENABLED)
        {
            throw new EncodingException("Missing Field: NetMoney");
        }

        if (hasMaturityNetMoney)
        {
            buffer.putBytes(position, maturityNetMoneyHeader, 0, maturityNetMoneyHeaderLength);
            position += maturityNetMoneyHeaderLength;
            position += buffer.putFloatAscii(position, maturityNetMoney);
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

        if (settlCurrencyLength > 0)
        {
            buffer.putBytes(position, settlCurrencyHeader, 0, settlCurrencyHeaderLength);
            position += settlCurrencyHeaderLength;
            buffer.putBytes(position, settlCurrency, settlCurrencyOffset, settlCurrencyLength);
            position += settlCurrencyLength;
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

            position += settlInstructionsData.encode(buffer, position);

            position += commissionData.encode(buffer, position);

        if (hasSharedCommission)
        {
            buffer.putBytes(position, sharedCommissionHeader, 0, sharedCommissionHeaderLength);
            position += sharedCommissionHeaderLength;
            position += buffer.putFloatAscii(position, sharedCommission);
            buffer.putSeparator(position);
            position++;
        }

            position += stipulations.encode(buffer, position);

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
        this.resetConfirmID();
        this.resetConfirmRefID();
        this.resetConfirmReqID();
        this.resetConfirmTransType();
        this.resetConfirmType();
        this.resetCopyMsgIndicator();
        this.resetLegalConfirm();
        this.resetConfirmStatus();
        this.resetAllocID();
        this.resetSecondaryAllocID();
        this.resetIndividualAllocID();
        this.resetTransactTime();
        this.resetTradeDate();
        this.resetAllocQty();
        this.resetQtyType();
        this.resetSide();
        this.resetCurrency();
        this.resetLastMkt();
        this.resetAllocAccount();
        this.resetAllocAcctIDSource();
        this.resetAllocAccountType();
        this.resetAvgPx();
        this.resetAvgPxPrecision();
        this.resetPriceType();
        this.resetAvgParPx();
        this.resetReportedPx();
        this.resetText();
        this.resetEncodedTextLen();
        this.resetEncodedText();
        this.resetProcessCode();
        this.resetGrossTradeAmt();
        this.resetNumDaysInterest();
        this.resetExDate();
        this.resetAccruedInterestRate();
        this.resetAccruedInterestAmt();
        this.resetInterestAtMaturity();
        this.resetEndAccruedInterestAmt();
        this.resetStartCash();
        this.resetEndCash();
        this.resetConcession();
        this.resetTotalTakedown();
        this.resetNetMoney();
        this.resetMaturityNetMoney();
        this.resetSettlCurrAmt();
        this.resetSettlCurrency();
        this.resetSettlCurrFxRate();
        this.resetSettlCurrFxRateCalc();
        this.resetSettlType();
        this.resetSettlDate();
        this.resetSharedCommission();
        parties.reset();
        trdRegTimestamps.reset();
        instrument.reset();
        instrumentExtension.reset();
        financingDetails.reset();
        yieldData.reset();
        spreadOrBenchmarkCurveData.reset();
        settlInstructionsData.reset();
        commissionData.reset();
        stipulations.reset();
        this.resetOrdersGroup();
        this.resetUnderlyingsGroup();
        this.resetLegsGroup();
        this.resetCapacitiesGroup();
        this.resetMiscFeesGroup();
    }

    public void resetConfirmID()
    {
        confirmIDLength = 0;
    }

    public void resetConfirmRefID()
    {
        confirmRefIDLength = 0;
    }

    public void resetConfirmReqID()
    {
        confirmReqIDLength = 0;
    }

    public void resetConfirmTransType()
    {
        hasConfirmTransType = false;
    }

    public void resetConfirmType()
    {
        hasConfirmType = false;
    }

    public void resetCopyMsgIndicator()
    {
        hasCopyMsgIndicator = false;
    }

    public void resetLegalConfirm()
    {
        hasLegalConfirm = false;
    }

    public void resetConfirmStatus()
    {
        hasConfirmStatus = false;
    }

    public void resetAllocID()
    {
        allocIDLength = 0;
    }

    public void resetSecondaryAllocID()
    {
        secondaryAllocIDLength = 0;
    }

    public void resetIndividualAllocID()
    {
        individualAllocIDLength = 0;
    }

    public void resetTransactTime()
    {
        transactTimeLength = 0;
    }

    public void resetTradeDate()
    {
        tradeDateLength = 0;
    }

    public void resetAllocQty()
    {
        hasAllocQty = false;
    }

    public void resetQtyType()
    {
        hasQtyType = false;
    }

    public void resetSide()
    {
        side = MISSING_CHAR;
    }

    public void resetCurrency()
    {
        currencyLength = 0;
    }

    public void resetLastMkt()
    {
        lastMktLength = 0;
    }

    public void resetAllocAccount()
    {
        allocAccountLength = 0;
    }

    public void resetAllocAcctIDSource()
    {
        hasAllocAcctIDSource = false;
    }

    public void resetAllocAccountType()
    {
        hasAllocAccountType = false;
    }

    public void resetAvgPx()
    {
        hasAvgPx = false;
    }

    public void resetAvgPxPrecision()
    {
        hasAvgPxPrecision = false;
    }

    public void resetPriceType()
    {
        hasPriceType = false;
    }

    public void resetAvgParPx()
    {
        hasAvgParPx = false;
    }

    public void resetReportedPx()
    {
        hasReportedPx = false;
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

    public void resetProcessCode()
    {
        hasProcessCode = false;
    }

    public void resetGrossTradeAmt()
    {
        hasGrossTradeAmt = false;
    }

    public void resetNumDaysInterest()
    {
        hasNumDaysInterest = false;
    }

    public void resetExDate()
    {
        exDateLength = 0;
    }

    public void resetAccruedInterestRate()
    {
        hasAccruedInterestRate = false;
    }

    public void resetAccruedInterestAmt()
    {
        hasAccruedInterestAmt = false;
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

    public void resetMaturityNetMoney()
    {
        hasMaturityNetMoney = false;
    }

    public void resetSettlCurrAmt()
    {
        hasSettlCurrAmt = false;
    }

    public void resetSettlCurrency()
    {
        settlCurrencyLength = 0;
    }

    public void resetSettlCurrFxRate()
    {
        hasSettlCurrFxRate = false;
    }

    public void resetSettlCurrFxRateCalc()
    {
        hasSettlCurrFxRateCalc = false;
    }

    public void resetSettlType()
    {
        hasSettlType = false;
    }

    public void resetSettlDate()
    {
        settlDateLength = 0;
    }

    public void resetSharedCommission()
    {
        hasSharedCommission = false;
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

    public void resetCapacitiesGroup()
    {
        if (capacitiesGroup != null)
        {
            capacitiesGroup.reset();
        }
        noCapacitiesGroupCounter = 0;
        hasNoCapacitiesGroupCounter = false;
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
        builder.append("\"MessageName\": \"Confirmation\",\n");
        builder.append("  \"header\": ");
        header.appendTo(builder, level + 1);
        builder.append("\n");
        if (hasConfirmID())
        {
            indent(builder, level);
            builder.append("\"ConfirmID\": \"");
            appendBuffer(builder, confirmID, confirmIDOffset, confirmIDLength);
            builder.append("\",\n");
        }

        if (hasConfirmRefID())
        {
            indent(builder, level);
            builder.append("\"ConfirmRefID\": \"");
            appendBuffer(builder, confirmRefID, confirmRefIDOffset, confirmRefIDLength);
            builder.append("\",\n");
        }

        if (hasConfirmReqID())
        {
            indent(builder, level);
            builder.append("\"ConfirmReqID\": \"");
            appendBuffer(builder, confirmReqID, confirmReqIDOffset, confirmReqIDLength);
            builder.append("\",\n");
        }

        if (hasConfirmTransType())
        {
            indent(builder, level);
            builder.append("\"ConfirmTransType\": \"");
            builder.append(confirmTransType);
            builder.append("\",\n");
        }

        if (hasConfirmType())
        {
            indent(builder, level);
            builder.append("\"ConfirmType\": \"");
            builder.append(confirmType);
            builder.append("\",\n");
        }

        if (hasCopyMsgIndicator())
        {
            indent(builder, level);
            builder.append("\"CopyMsgIndicator\": \"");
            builder.append(copyMsgIndicator);
            builder.append("\",\n");
        }

        if (hasLegalConfirm())
        {
            indent(builder, level);
            builder.append("\"LegalConfirm\": \"");
            builder.append(legalConfirm);
            builder.append("\",\n");
        }

        if (hasConfirmStatus())
        {
            indent(builder, level);
            builder.append("\"ConfirmStatus\": \"");
            builder.append(confirmStatus);
            builder.append("\",\n");
        }

    indent(builder, level);
    builder.append("\"Parties\": ");
    parties.appendTo(builder, level + 1);
    builder.append("\n");

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

        if (hasAllocID())
        {
            indent(builder, level);
            builder.append("\"AllocID\": \"");
            appendBuffer(builder, allocID, allocIDOffset, allocIDLength);
            builder.append("\",\n");
        }

        if (hasSecondaryAllocID())
        {
            indent(builder, level);
            builder.append("\"SecondaryAllocID\": \"");
            appendBuffer(builder, secondaryAllocID, secondaryAllocIDOffset, secondaryAllocIDLength);
            builder.append("\",\n");
        }

        if (hasIndividualAllocID())
        {
            indent(builder, level);
            builder.append("\"IndividualAllocID\": \"");
            appendBuffer(builder, individualAllocID, individualAllocIDOffset, individualAllocIDLength);
            builder.append("\",\n");
        }

        if (hasTransactTime())
        {
            indent(builder, level);
            builder.append("\"TransactTime\": \"");
            appendBuffer(builder, transactTime, transactTimeOffset, transactTimeLength);
            builder.append("\",\n");
        }

        if (hasTradeDate())
        {
            indent(builder, level);
            builder.append("\"TradeDate\": \"");
            appendBuffer(builder, tradeDate, tradeDateOffset, tradeDateLength);
            builder.append("\",\n");
        }

    indent(builder, level);
    builder.append("\"TrdRegTimestamps\": ");
    trdRegTimestamps.appendTo(builder, level + 1);
    builder.append("\n");

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

    indent(builder, level);
    builder.append("\"YieldData\": ");
    yieldData.appendTo(builder, level + 1);
    builder.append("\n");

        if (hasAllocQty())
        {
            indent(builder, level);
            builder.append("\"AllocQty\": \"");
            allocQty.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasQtyType())
        {
            indent(builder, level);
            builder.append("\"QtyType\": \"");
            builder.append(qtyType);
            builder.append("\",\n");
        }

        if (hasSide())
        {
            indent(builder, level);
            builder.append("\"Side\": \"");
            builder.append(side);
            builder.append("\",\n");
        }

        if (hasCurrency())
        {
            indent(builder, level);
            builder.append("\"Currency\": \"");
            appendBuffer(builder, currency, currencyOffset, currencyLength);
            builder.append("\",\n");
        }

        if (hasLastMkt())
        {
            indent(builder, level);
            builder.append("\"LastMkt\": \"");
            appendBuffer(builder, lastMkt, lastMktOffset, lastMktLength);
            builder.append("\",\n");
        }

        if (hasNoCapacitiesGroupCounter)
        {
            indent(builder, level);
            builder.append("\"CapacitiesGroup\": [\n");
            final int noCapacitiesGroupCounter = this.noCapacitiesGroupCounter;
            CapacitiesGroupEncoder capacitiesGroup = this.capacitiesGroup;
            for (int i = 0; i < noCapacitiesGroupCounter; i++)
            {
                indent(builder, level);
                capacitiesGroup.appendTo(builder, level + 1);
                if (i < (noCapacitiesGroupCounter - 1))
                {
                    builder.append(',');
                }
                builder.append('\n');
                capacitiesGroup = capacitiesGroup.next();
            }
            indent(builder, level);
            builder.append("],\n");
        }

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

        if (hasAllocAccountType())
        {
            indent(builder, level);
            builder.append("\"AllocAccountType\": \"");
            builder.append(allocAccountType);
            builder.append("\",\n");
        }

        if (hasAvgPx())
        {
            indent(builder, level);
            builder.append("\"AvgPx\": \"");
            avgPx.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasAvgPxPrecision())
        {
            indent(builder, level);
            builder.append("\"AvgPxPrecision\": \"");
            builder.append(avgPxPrecision);
            builder.append("\",\n");
        }

        if (hasPriceType())
        {
            indent(builder, level);
            builder.append("\"PriceType\": \"");
            builder.append(priceType);
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

        if (hasReportedPx())
        {
            indent(builder, level);
            builder.append("\"ReportedPx\": \"");
            reportedPx.appendTo(builder);
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

        if (hasProcessCode())
        {
            indent(builder, level);
            builder.append("\"ProcessCode\": \"");
            builder.append(processCode);
            builder.append("\",\n");
        }

        if (hasGrossTradeAmt())
        {
            indent(builder, level);
            builder.append("\"GrossTradeAmt\": \"");
            grossTradeAmt.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasNumDaysInterest())
        {
            indent(builder, level);
            builder.append("\"NumDaysInterest\": \"");
            builder.append(numDaysInterest);
            builder.append("\",\n");
        }

        if (hasExDate())
        {
            indent(builder, level);
            builder.append("\"ExDate\": \"");
            appendBuffer(builder, exDate, exDateOffset, exDateLength);
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

        if (hasMaturityNetMoney())
        {
            indent(builder, level);
            builder.append("\"MaturityNetMoney\": \"");
            maturityNetMoney.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasSettlCurrAmt())
        {
            indent(builder, level);
            builder.append("\"SettlCurrAmt\": \"");
            settlCurrAmt.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasSettlCurrency())
        {
            indent(builder, level);
            builder.append("\"SettlCurrency\": \"");
            appendBuffer(builder, settlCurrency, settlCurrencyOffset, settlCurrencyLength);
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

    indent(builder, level);
    builder.append("\"SettlInstructionsData\": ");
    settlInstructionsData.appendTo(builder, level + 1);
    builder.append("\n");

    indent(builder, level);
    builder.append("\"CommissionData\": ");
    commissionData.appendTo(builder, level + 1);
    builder.append("\n");

        if (hasSharedCommission())
        {
            indent(builder, level);
            builder.append("\"SharedCommission\": \"");
            sharedCommission.appendTo(builder);
            builder.append("\",\n");
        }

    indent(builder, level);
    builder.append("\"Stipulations\": ");
    stipulations.appendTo(builder, level + 1);
    builder.append("\n");

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
        indent(builder, level - 1);
        builder.append("}");
        return builder;
    }

    /**
     * {@inheritDoc}
     */
    public ConfirmationEncoder copyTo(final Encoder encoder)
    {
        return copyTo((ConfirmationEncoder)encoder);
    }

    public ConfirmationEncoder copyTo(final ConfirmationEncoder encoder)
    {
        encoder.reset();
        if (hasConfirmID())
        {
            encoder.confirmIDAsCopy(confirmID.byteArray(), 0, confirmIDLength);
        }

        if (hasConfirmRefID())
        {
            encoder.confirmRefIDAsCopy(confirmRefID.byteArray(), 0, confirmRefIDLength);
        }

        if (hasConfirmReqID())
        {
            encoder.confirmReqIDAsCopy(confirmReqID.byteArray(), 0, confirmReqIDLength);
        }

        if (hasConfirmTransType())
        {
            encoder.confirmTransType(this.confirmTransType());
        }

        if (hasConfirmType())
        {
            encoder.confirmType(this.confirmType());
        }

        if (hasCopyMsgIndicator())
        {
            encoder.copyMsgIndicator(this.copyMsgIndicator());
        }

        if (hasLegalConfirm())
        {
            encoder.legalConfirm(this.legalConfirm());
        }

        if (hasConfirmStatus())
        {
            encoder.confirmStatus(this.confirmStatus());
        }


        parties.copyTo(encoder.parties());
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

        if (hasAllocID())
        {
            encoder.allocIDAsCopy(allocID.byteArray(), 0, allocIDLength);
        }

        if (hasSecondaryAllocID())
        {
            encoder.secondaryAllocIDAsCopy(secondaryAllocID.byteArray(), 0, secondaryAllocIDLength);
        }

        if (hasIndividualAllocID())
        {
            encoder.individualAllocIDAsCopy(individualAllocID.byteArray(), 0, individualAllocIDLength);
        }

        if (hasTransactTime())
        {
            encoder.transactTimeAsCopy(transactTime.byteArray(), 0, transactTimeLength);
        }

        if (hasTradeDate())
        {
            encoder.tradeDateAsCopy(tradeDate.byteArray(), 0, tradeDateLength);
        }


        trdRegTimestamps.copyTo(encoder.trdRegTimestamps());

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


        yieldData.copyTo(encoder.yieldData());
        if (hasAllocQty())
        {
            encoder.allocQty(this.allocQty());
        }

        if (hasQtyType())
        {
            encoder.qtyType(this.qtyType());
        }

        if (hasSide())
        {
            encoder.side(this.side());
        }

        if (hasCurrency())
        {
            encoder.currencyAsCopy(currency.byteArray(), 0, currencyLength);
        }

        if (hasLastMkt())
        {
            encoder.lastMktAsCopy(lastMkt.byteArray(), 0, lastMktLength);
        }

        if (hasNoCapacitiesGroupCounter)
        {
            final int size = this.noCapacitiesGroupCounter;
            CapacitiesGroupEncoder capacitiesGroup = this.capacitiesGroup;
            CapacitiesGroupEncoder capacitiesGroupEncoder = encoder.capacitiesGroup(size);
            for (int i = 0; i < size; i++)
            {
                if (capacitiesGroup != null)
                {
                    capacitiesGroup.copyTo(capacitiesGroupEncoder);
                    capacitiesGroup = capacitiesGroup.next();
                    capacitiesGroupEncoder = capacitiesGroupEncoder.next();
                }
            }
        }

        if (hasAllocAccount())
        {
            encoder.allocAccountAsCopy(allocAccount.byteArray(), 0, allocAccountLength);
        }

        if (hasAllocAcctIDSource())
        {
            encoder.allocAcctIDSource(this.allocAcctIDSource());
        }

        if (hasAllocAccountType())
        {
            encoder.allocAccountType(this.allocAccountType());
        }

        if (hasAvgPx())
        {
            encoder.avgPx(this.avgPx());
        }

        if (hasAvgPxPrecision())
        {
            encoder.avgPxPrecision(this.avgPxPrecision());
        }

        if (hasPriceType())
        {
            encoder.priceType(this.priceType());
        }

        if (hasAvgParPx())
        {
            encoder.avgParPx(this.avgParPx());
        }


        spreadOrBenchmarkCurveData.copyTo(encoder.spreadOrBenchmarkCurveData());
        if (hasReportedPx())
        {
            encoder.reportedPx(this.reportedPx());
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

        if (hasProcessCode())
        {
            encoder.processCode(this.processCode());
        }

        if (hasGrossTradeAmt())
        {
            encoder.grossTradeAmt(this.grossTradeAmt());
        }

        if (hasNumDaysInterest())
        {
            encoder.numDaysInterest(this.numDaysInterest());
        }

        if (hasExDate())
        {
            encoder.exDateAsCopy(exDate.byteArray(), 0, exDateLength);
        }

        if (hasAccruedInterestRate())
        {
            encoder.accruedInterestRate(this.accruedInterestRate());
        }

        if (hasAccruedInterestAmt())
        {
            encoder.accruedInterestAmt(this.accruedInterestAmt());
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

        if (hasMaturityNetMoney())
        {
            encoder.maturityNetMoney(this.maturityNetMoney());
        }

        if (hasSettlCurrAmt())
        {
            encoder.settlCurrAmt(this.settlCurrAmt());
        }

        if (hasSettlCurrency())
        {
            encoder.settlCurrencyAsCopy(settlCurrency.byteArray(), 0, settlCurrencyLength);
        }

        if (hasSettlCurrFxRate())
        {
            encoder.settlCurrFxRate(this.settlCurrFxRate());
        }

        if (hasSettlCurrFxRateCalc())
        {
            encoder.settlCurrFxRateCalc(this.settlCurrFxRateCalc());
        }

        if (hasSettlType())
        {
            encoder.settlType(this.settlType());
        }

        if (hasSettlDate())
        {
            encoder.settlDateAsCopy(settlDate.byteArray(), 0, settlDateLength);
        }


        settlInstructionsData.copyTo(encoder.settlInstructionsData());

        commissionData.copyTo(encoder.commissionData());
        if (hasSharedCommission())
        {
            encoder.sharedCommission(this.sharedCommission());
        }


        stipulations.copyTo(encoder.stipulations());
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
        return encoder;
    }

}
