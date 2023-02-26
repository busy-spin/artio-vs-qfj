/* Generated Fix Gateway message codec */
package uk.co.real_logic.artio.builder;

import uk.co.real_logic.artio.dictionary.Generated;
import org.agrona.MutableDirectBuffer;
import org.agrona.AsciiSequenceView;
import static uk.co.real_logic.artio.dictionary.generation.CodecUtil.*;
import static uk.co.real_logic.artio.dictionary.SessionConstants.*;
import uk.co.real_logic.artio.builder.Encoder;
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
public class LegBenchmarkCurveDataEncoder
{
    private static final int legBenchmarkCurveCurrencyHeaderLength = 4;
    private static final byte[] legBenchmarkCurveCurrencyHeader = new byte[] {54, 55, 54, (byte) '='};

    private static final int legBenchmarkCurveNameHeaderLength = 4;
    private static final byte[] legBenchmarkCurveNameHeader = new byte[] {54, 55, 55, (byte) '='};

    private static final int legBenchmarkCurvePointHeaderLength = 4;
    private static final byte[] legBenchmarkCurvePointHeader = new byte[] {54, 55, 56, (byte) '='};

    private static final int legBenchmarkPriceHeaderLength = 4;
    private static final byte[] legBenchmarkPriceHeader = new byte[] {54, 55, 57, (byte) '='};

    private static final int legBenchmarkPriceTypeHeaderLength = 4;
    private static final byte[] legBenchmarkPriceTypeHeader = new byte[] {54, 56, 48, (byte) '='};

    private final MutableDirectBuffer legBenchmarkCurveCurrency = new UnsafeBuffer();

    private int legBenchmarkCurveCurrencyOffset = 0;

    private int legBenchmarkCurveCurrencyLength = 0;

    /* LegBenchmarkCurveCurrency = 676 */
    public LegBenchmarkCurveDataEncoder legBenchmarkCurveCurrency(final DirectBuffer value, final int offset, final int length)
    {
        legBenchmarkCurveCurrency.wrap(value);
        legBenchmarkCurveCurrencyOffset = offset;
        legBenchmarkCurveCurrencyLength = length;
        return this;
    }

    /* LegBenchmarkCurveCurrency = 676 */
    public LegBenchmarkCurveDataEncoder legBenchmarkCurveCurrency(final DirectBuffer value, final int length)
    {
        return legBenchmarkCurveCurrency(value, 0, length);
    }

    /* LegBenchmarkCurveCurrency = 676 */
    public LegBenchmarkCurveDataEncoder legBenchmarkCurveCurrency(final DirectBuffer value)
    {
        return legBenchmarkCurveCurrency(value, 0, value.capacity());
    }

    /* LegBenchmarkCurveCurrency = 676 */
    public LegBenchmarkCurveDataEncoder legBenchmarkCurveCurrency(final byte[] value, final int offset, final int length)
    {
        legBenchmarkCurveCurrency.wrap(value);
        legBenchmarkCurveCurrencyOffset = offset;
        legBenchmarkCurveCurrencyLength = length;
        return this;
    }

    /* LegBenchmarkCurveCurrency = 676 */
    public LegBenchmarkCurveDataEncoder legBenchmarkCurveCurrencyAsCopy(final byte[] value, final int offset, final int length)
    {
        copyInto(legBenchmarkCurveCurrency, value, offset, length);
        legBenchmarkCurveCurrencyOffset = offset;
        legBenchmarkCurveCurrencyLength = length;
        return this;
    }

    /* LegBenchmarkCurveCurrency = 676 */
    public LegBenchmarkCurveDataEncoder legBenchmarkCurveCurrency(final byte[] value, final int length)
    {
        return legBenchmarkCurveCurrency(value, 0, length);
    }

    /* LegBenchmarkCurveCurrency = 676 */
    public LegBenchmarkCurveDataEncoder legBenchmarkCurveCurrency(final byte[] value)
    {
        return legBenchmarkCurveCurrency(value, 0, value.length);
    }

    /* LegBenchmarkCurveCurrency = 676 */
    public boolean hasLegBenchmarkCurveCurrency()
    {
        return legBenchmarkCurveCurrencyLength > 0;
    }

    /* LegBenchmarkCurveCurrency = 676 */
    public MutableDirectBuffer legBenchmarkCurveCurrency()
    {
        return legBenchmarkCurveCurrency;
    }

    /* LegBenchmarkCurveCurrency = 676 */
    public String legBenchmarkCurveCurrencyAsString()
    {
        return legBenchmarkCurveCurrency.getStringWithoutLengthAscii(legBenchmarkCurveCurrencyOffset, legBenchmarkCurveCurrencyLength);
    }

    /* LegBenchmarkCurveCurrency = 676 */
    public LegBenchmarkCurveDataEncoder legBenchmarkCurveCurrency(final CharSequence value)
    {
        toBytes(value, legBenchmarkCurveCurrency);
        legBenchmarkCurveCurrencyOffset = 0;
        legBenchmarkCurveCurrencyLength = value.length();
        return this;
    }

    /* LegBenchmarkCurveCurrency = 676 */
    public LegBenchmarkCurveDataEncoder legBenchmarkCurveCurrency(final AsciiSequenceView value)
    {
        final DirectBuffer buffer = value.buffer();
        if (buffer != null)
        {
            legBenchmarkCurveCurrency.wrap(buffer);
            legBenchmarkCurveCurrencyOffset = value.offset();
            legBenchmarkCurveCurrencyLength = value.length();
        }
        return this;
    }

    /* LegBenchmarkCurveCurrency = 676 */
    public LegBenchmarkCurveDataEncoder legBenchmarkCurveCurrency(final char[] value)
    {
        return legBenchmarkCurveCurrency(value, 0, value.length);
    }

    /* LegBenchmarkCurveCurrency = 676 */
    public LegBenchmarkCurveDataEncoder legBenchmarkCurveCurrency(final char[] value, final int length)
    {
        return legBenchmarkCurveCurrency(value, 0, length);
    }

    /* LegBenchmarkCurveCurrency = 676 */
    public LegBenchmarkCurveDataEncoder legBenchmarkCurveCurrency(final char[] value, final int offset, final int length)
    {
        toBytes(value, legBenchmarkCurveCurrency, offset, length);
        legBenchmarkCurveCurrencyOffset = 0;
        legBenchmarkCurveCurrencyLength = length;
        return this;
    }

    private final MutableDirectBuffer legBenchmarkCurveName = new UnsafeBuffer();

    private int legBenchmarkCurveNameOffset = 0;

    private int legBenchmarkCurveNameLength = 0;

    /* LegBenchmarkCurveName = 677 */
    public LegBenchmarkCurveDataEncoder legBenchmarkCurveName(final DirectBuffer value, final int offset, final int length)
    {
        legBenchmarkCurveName.wrap(value);
        legBenchmarkCurveNameOffset = offset;
        legBenchmarkCurveNameLength = length;
        return this;
    }

    /* LegBenchmarkCurveName = 677 */
    public LegBenchmarkCurveDataEncoder legBenchmarkCurveName(final DirectBuffer value, final int length)
    {
        return legBenchmarkCurveName(value, 0, length);
    }

    /* LegBenchmarkCurveName = 677 */
    public LegBenchmarkCurveDataEncoder legBenchmarkCurveName(final DirectBuffer value)
    {
        return legBenchmarkCurveName(value, 0, value.capacity());
    }

    /* LegBenchmarkCurveName = 677 */
    public LegBenchmarkCurveDataEncoder legBenchmarkCurveName(final byte[] value, final int offset, final int length)
    {
        legBenchmarkCurveName.wrap(value);
        legBenchmarkCurveNameOffset = offset;
        legBenchmarkCurveNameLength = length;
        return this;
    }

    /* LegBenchmarkCurveName = 677 */
    public LegBenchmarkCurveDataEncoder legBenchmarkCurveNameAsCopy(final byte[] value, final int offset, final int length)
    {
        copyInto(legBenchmarkCurveName, value, offset, length);
        legBenchmarkCurveNameOffset = offset;
        legBenchmarkCurveNameLength = length;
        return this;
    }

    /* LegBenchmarkCurveName = 677 */
    public LegBenchmarkCurveDataEncoder legBenchmarkCurveName(final byte[] value, final int length)
    {
        return legBenchmarkCurveName(value, 0, length);
    }

    /* LegBenchmarkCurveName = 677 */
    public LegBenchmarkCurveDataEncoder legBenchmarkCurveName(final byte[] value)
    {
        return legBenchmarkCurveName(value, 0, value.length);
    }

    /* LegBenchmarkCurveName = 677 */
    public boolean hasLegBenchmarkCurveName()
    {
        return legBenchmarkCurveNameLength > 0;
    }

    /* LegBenchmarkCurveName = 677 */
    public MutableDirectBuffer legBenchmarkCurveName()
    {
        return legBenchmarkCurveName;
    }

    /* LegBenchmarkCurveName = 677 */
    public String legBenchmarkCurveNameAsString()
    {
        return legBenchmarkCurveName.getStringWithoutLengthAscii(legBenchmarkCurveNameOffset, legBenchmarkCurveNameLength);
    }

    /* LegBenchmarkCurveName = 677 */
    public LegBenchmarkCurveDataEncoder legBenchmarkCurveName(final CharSequence value)
    {
        toBytes(value, legBenchmarkCurveName);
        legBenchmarkCurveNameOffset = 0;
        legBenchmarkCurveNameLength = value.length();
        return this;
    }

    /* LegBenchmarkCurveName = 677 */
    public LegBenchmarkCurveDataEncoder legBenchmarkCurveName(final AsciiSequenceView value)
    {
        final DirectBuffer buffer = value.buffer();
        if (buffer != null)
        {
            legBenchmarkCurveName.wrap(buffer);
            legBenchmarkCurveNameOffset = value.offset();
            legBenchmarkCurveNameLength = value.length();
        }
        return this;
    }

    /* LegBenchmarkCurveName = 677 */
    public LegBenchmarkCurveDataEncoder legBenchmarkCurveName(final char[] value)
    {
        return legBenchmarkCurveName(value, 0, value.length);
    }

    /* LegBenchmarkCurveName = 677 */
    public LegBenchmarkCurveDataEncoder legBenchmarkCurveName(final char[] value, final int length)
    {
        return legBenchmarkCurveName(value, 0, length);
    }

    /* LegBenchmarkCurveName = 677 */
    public LegBenchmarkCurveDataEncoder legBenchmarkCurveName(final char[] value, final int offset, final int length)
    {
        toBytes(value, legBenchmarkCurveName, offset, length);
        legBenchmarkCurveNameOffset = 0;
        legBenchmarkCurveNameLength = length;
        return this;
    }

    private final MutableDirectBuffer legBenchmarkCurvePoint = new UnsafeBuffer();

    private int legBenchmarkCurvePointOffset = 0;

    private int legBenchmarkCurvePointLength = 0;

    /* LegBenchmarkCurvePoint = 678 */
    public LegBenchmarkCurveDataEncoder legBenchmarkCurvePoint(final DirectBuffer value, final int offset, final int length)
    {
        legBenchmarkCurvePoint.wrap(value);
        legBenchmarkCurvePointOffset = offset;
        legBenchmarkCurvePointLength = length;
        return this;
    }

    /* LegBenchmarkCurvePoint = 678 */
    public LegBenchmarkCurveDataEncoder legBenchmarkCurvePoint(final DirectBuffer value, final int length)
    {
        return legBenchmarkCurvePoint(value, 0, length);
    }

    /* LegBenchmarkCurvePoint = 678 */
    public LegBenchmarkCurveDataEncoder legBenchmarkCurvePoint(final DirectBuffer value)
    {
        return legBenchmarkCurvePoint(value, 0, value.capacity());
    }

    /* LegBenchmarkCurvePoint = 678 */
    public LegBenchmarkCurveDataEncoder legBenchmarkCurvePoint(final byte[] value, final int offset, final int length)
    {
        legBenchmarkCurvePoint.wrap(value);
        legBenchmarkCurvePointOffset = offset;
        legBenchmarkCurvePointLength = length;
        return this;
    }

    /* LegBenchmarkCurvePoint = 678 */
    public LegBenchmarkCurveDataEncoder legBenchmarkCurvePointAsCopy(final byte[] value, final int offset, final int length)
    {
        copyInto(legBenchmarkCurvePoint, value, offset, length);
        legBenchmarkCurvePointOffset = offset;
        legBenchmarkCurvePointLength = length;
        return this;
    }

    /* LegBenchmarkCurvePoint = 678 */
    public LegBenchmarkCurveDataEncoder legBenchmarkCurvePoint(final byte[] value, final int length)
    {
        return legBenchmarkCurvePoint(value, 0, length);
    }

    /* LegBenchmarkCurvePoint = 678 */
    public LegBenchmarkCurveDataEncoder legBenchmarkCurvePoint(final byte[] value)
    {
        return legBenchmarkCurvePoint(value, 0, value.length);
    }

    /* LegBenchmarkCurvePoint = 678 */
    public boolean hasLegBenchmarkCurvePoint()
    {
        return legBenchmarkCurvePointLength > 0;
    }

    /* LegBenchmarkCurvePoint = 678 */
    public MutableDirectBuffer legBenchmarkCurvePoint()
    {
        return legBenchmarkCurvePoint;
    }

    /* LegBenchmarkCurvePoint = 678 */
    public String legBenchmarkCurvePointAsString()
    {
        return legBenchmarkCurvePoint.getStringWithoutLengthAscii(legBenchmarkCurvePointOffset, legBenchmarkCurvePointLength);
    }

    /* LegBenchmarkCurvePoint = 678 */
    public LegBenchmarkCurveDataEncoder legBenchmarkCurvePoint(final CharSequence value)
    {
        toBytes(value, legBenchmarkCurvePoint);
        legBenchmarkCurvePointOffset = 0;
        legBenchmarkCurvePointLength = value.length();
        return this;
    }

    /* LegBenchmarkCurvePoint = 678 */
    public LegBenchmarkCurveDataEncoder legBenchmarkCurvePoint(final AsciiSequenceView value)
    {
        final DirectBuffer buffer = value.buffer();
        if (buffer != null)
        {
            legBenchmarkCurvePoint.wrap(buffer);
            legBenchmarkCurvePointOffset = value.offset();
            legBenchmarkCurvePointLength = value.length();
        }
        return this;
    }

    /* LegBenchmarkCurvePoint = 678 */
    public LegBenchmarkCurveDataEncoder legBenchmarkCurvePoint(final char[] value)
    {
        return legBenchmarkCurvePoint(value, 0, value.length);
    }

    /* LegBenchmarkCurvePoint = 678 */
    public LegBenchmarkCurveDataEncoder legBenchmarkCurvePoint(final char[] value, final int length)
    {
        return legBenchmarkCurvePoint(value, 0, length);
    }

    /* LegBenchmarkCurvePoint = 678 */
    public LegBenchmarkCurveDataEncoder legBenchmarkCurvePoint(final char[] value, final int offset, final int length)
    {
        toBytes(value, legBenchmarkCurvePoint, offset, length);
        legBenchmarkCurvePointOffset = 0;
        legBenchmarkCurvePointLength = length;
        return this;
    }

    private final DecimalFloat legBenchmarkPrice = new DecimalFloat();

    private boolean hasLegBenchmarkPrice;

    public boolean hasLegBenchmarkPrice()
    {
        return hasLegBenchmarkPrice;
    }

    /* LegBenchmarkPrice = 679 */
    public LegBenchmarkCurveDataEncoder legBenchmarkPrice(ReadOnlyDecimalFloat value)
    {
        legBenchmarkPrice.set(value);
        hasLegBenchmarkPrice = true;
        return this;
    }

    /* LegBenchmarkPrice = 679 */
    public LegBenchmarkCurveDataEncoder legBenchmarkPrice(long value, int scale)
    {
        legBenchmarkPrice.set(value, scale);
        hasLegBenchmarkPrice = true;
        return this;
    }

    /* LegBenchmarkPrice = 679 */
    public DecimalFloat legBenchmarkPrice()
    {
        return legBenchmarkPrice;
    }

    private int legBenchmarkPriceType;

    private boolean hasLegBenchmarkPriceType;

    public boolean hasLegBenchmarkPriceType()
    {
        return hasLegBenchmarkPriceType;
    }

    /* LegBenchmarkPriceType = 680 */
    public LegBenchmarkCurveDataEncoder legBenchmarkPriceType(int value)
    {
        legBenchmarkPriceType = value;
        hasLegBenchmarkPriceType = true;
        return this;
    }

    /* LegBenchmarkPriceType = 680 */
    public int legBenchmarkPriceType()
    {
        return legBenchmarkPriceType;
    }

    public int encode(final MutableAsciiBuffer buffer, final int offset)
    {
        int position = offset;

        if (legBenchmarkCurveCurrencyLength > 0)
        {
            buffer.putBytes(position, legBenchmarkCurveCurrencyHeader, 0, legBenchmarkCurveCurrencyHeaderLength);
            position += legBenchmarkCurveCurrencyHeaderLength;
            buffer.putBytes(position, legBenchmarkCurveCurrency, legBenchmarkCurveCurrencyOffset, legBenchmarkCurveCurrencyLength);
            position += legBenchmarkCurveCurrencyLength;
            buffer.putSeparator(position);
            position++;
        }

        if (legBenchmarkCurveNameLength > 0)
        {
            buffer.putBytes(position, legBenchmarkCurveNameHeader, 0, legBenchmarkCurveNameHeaderLength);
            position += legBenchmarkCurveNameHeaderLength;
            buffer.putBytes(position, legBenchmarkCurveName, legBenchmarkCurveNameOffset, legBenchmarkCurveNameLength);
            position += legBenchmarkCurveNameLength;
            buffer.putSeparator(position);
            position++;
        }

        if (legBenchmarkCurvePointLength > 0)
        {
            buffer.putBytes(position, legBenchmarkCurvePointHeader, 0, legBenchmarkCurvePointHeaderLength);
            position += legBenchmarkCurvePointHeaderLength;
            buffer.putBytes(position, legBenchmarkCurvePoint, legBenchmarkCurvePointOffset, legBenchmarkCurvePointLength);
            position += legBenchmarkCurvePointLength;
            buffer.putSeparator(position);
            position++;
        }

        if (hasLegBenchmarkPrice)
        {
            buffer.putBytes(position, legBenchmarkPriceHeader, 0, legBenchmarkPriceHeaderLength);
            position += legBenchmarkPriceHeaderLength;
            position += buffer.putFloatAscii(position, legBenchmarkPrice);
            buffer.putSeparator(position);
            position++;
        }

        if (hasLegBenchmarkPriceType)
        {
            buffer.putBytes(position, legBenchmarkPriceTypeHeader, 0, legBenchmarkPriceTypeHeaderLength);
            position += legBenchmarkPriceTypeHeaderLength;
            position += buffer.putIntAscii(position, legBenchmarkPriceType);
            buffer.putSeparator(position);
            position++;
        }
        return position - offset;
    }

    public void reset()
    {
        this.resetLegBenchmarkCurveCurrency();
        this.resetLegBenchmarkCurveName();
        this.resetLegBenchmarkCurvePoint();
        this.resetLegBenchmarkPrice();
        this.resetLegBenchmarkPriceType();
    }

    public void resetLegBenchmarkCurveCurrency()
    {
        legBenchmarkCurveCurrencyLength = 0;
    }

    public void resetLegBenchmarkCurveName()
    {
        legBenchmarkCurveNameLength = 0;
    }

    public void resetLegBenchmarkCurvePoint()
    {
        legBenchmarkCurvePointLength = 0;
    }

    public void resetLegBenchmarkPrice()
    {
        hasLegBenchmarkPrice = false;
    }

    public void resetLegBenchmarkPriceType()
    {
        hasLegBenchmarkPriceType = false;
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
        builder.append("\"MessageName\": \"LegBenchmarkCurveData\",\n");
        if (hasLegBenchmarkCurveCurrency())
        {
            indent(builder, level);
            builder.append("\"LegBenchmarkCurveCurrency\": \"");
            appendBuffer(builder, legBenchmarkCurveCurrency, legBenchmarkCurveCurrencyOffset, legBenchmarkCurveCurrencyLength);
            builder.append("\",\n");
        }

        if (hasLegBenchmarkCurveName())
        {
            indent(builder, level);
            builder.append("\"LegBenchmarkCurveName\": \"");
            appendBuffer(builder, legBenchmarkCurveName, legBenchmarkCurveNameOffset, legBenchmarkCurveNameLength);
            builder.append("\",\n");
        }

        if (hasLegBenchmarkCurvePoint())
        {
            indent(builder, level);
            builder.append("\"LegBenchmarkCurvePoint\": \"");
            appendBuffer(builder, legBenchmarkCurvePoint, legBenchmarkCurvePointOffset, legBenchmarkCurvePointLength);
            builder.append("\",\n");
        }

        if (hasLegBenchmarkPrice())
        {
            indent(builder, level);
            builder.append("\"LegBenchmarkPrice\": \"");
            legBenchmarkPrice.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasLegBenchmarkPriceType())
        {
            indent(builder, level);
            builder.append("\"LegBenchmarkPriceType\": \"");
            builder.append(legBenchmarkPriceType);
            builder.append("\",\n");
        }
        indent(builder, level - 1);
        builder.append("}");
        return builder;
    }

    /**
     * {@inheritDoc}
     */
    public LegBenchmarkCurveDataEncoder copyTo(final Encoder encoder)
    {
        return copyTo((LegBenchmarkCurveDataEncoder)encoder);
    }

    public LegBenchmarkCurveDataEncoder copyTo(final LegBenchmarkCurveDataEncoder encoder)
    {
        encoder.reset();
        if (hasLegBenchmarkCurveCurrency())
        {
            encoder.legBenchmarkCurveCurrencyAsCopy(legBenchmarkCurveCurrency.byteArray(), 0, legBenchmarkCurveCurrencyLength);
        }

        if (hasLegBenchmarkCurveName())
        {
            encoder.legBenchmarkCurveNameAsCopy(legBenchmarkCurveName.byteArray(), 0, legBenchmarkCurveNameLength);
        }

        if (hasLegBenchmarkCurvePoint())
        {
            encoder.legBenchmarkCurvePointAsCopy(legBenchmarkCurvePoint.byteArray(), 0, legBenchmarkCurvePointLength);
        }

        if (hasLegBenchmarkPrice())
        {
            encoder.legBenchmarkPrice(this.legBenchmarkPrice());
        }

        if (hasLegBenchmarkPriceType())
        {
            encoder.legBenchmarkPriceType(this.legBenchmarkPriceType());
        }
        return encoder;
    }

}
