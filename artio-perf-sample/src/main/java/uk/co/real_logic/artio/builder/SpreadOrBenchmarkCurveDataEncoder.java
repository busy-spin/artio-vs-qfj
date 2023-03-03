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
public class SpreadOrBenchmarkCurveDataEncoder
{
    private static final int spreadHeaderLength = 4;
    private static final byte[] spreadHeader = new byte[] {50, 49, 56, (byte) '='};

    private static final int benchmarkCurveCurrencyHeaderLength = 4;
    private static final byte[] benchmarkCurveCurrencyHeader = new byte[] {50, 50, 48, (byte) '='};

    private static final int benchmarkCurveNameHeaderLength = 4;
    private static final byte[] benchmarkCurveNameHeader = new byte[] {50, 50, 49, (byte) '='};

    private static final int benchmarkCurvePointHeaderLength = 4;
    private static final byte[] benchmarkCurvePointHeader = new byte[] {50, 50, 50, (byte) '='};

    private static final int benchmarkPriceHeaderLength = 4;
    private static final byte[] benchmarkPriceHeader = new byte[] {54, 54, 50, (byte) '='};

    private static final int benchmarkPriceTypeHeaderLength = 4;
    private static final byte[] benchmarkPriceTypeHeader = new byte[] {54, 54, 51, (byte) '='};

    private static final int benchmarkSecurityIDHeaderLength = 4;
    private static final byte[] benchmarkSecurityIDHeader = new byte[] {54, 57, 57, (byte) '='};

    private static final int benchmarkSecurityIDSourceHeaderLength = 4;
    private static final byte[] benchmarkSecurityIDSourceHeader = new byte[] {55, 54, 49, (byte) '='};

    private final DecimalFloat spread = new DecimalFloat();

    private boolean hasSpread;

    public boolean hasSpread()
    {
        return hasSpread;
    }

    /* Spread = 218 */
    public SpreadOrBenchmarkCurveDataEncoder spread(ReadOnlyDecimalFloat value)
    {
        spread.set(value);
        hasSpread = true;
        return this;
    }

    /* Spread = 218 */
    public SpreadOrBenchmarkCurveDataEncoder spread(long value, int scale)
    {
        spread.set(value, scale);
        hasSpread = true;
        return this;
    }

    /* Spread = 218 */
    public DecimalFloat spread()
    {
        return spread;
    }

    private final MutableDirectBuffer benchmarkCurveCurrency = new UnsafeBuffer();

    private int benchmarkCurveCurrencyOffset = 0;

    private int benchmarkCurveCurrencyLength = 0;

    /* BenchmarkCurveCurrency = 220 */
    public SpreadOrBenchmarkCurveDataEncoder benchmarkCurveCurrency(final DirectBuffer value, final int offset, final int length)
    {
        benchmarkCurveCurrency.wrap(value);
        benchmarkCurveCurrencyOffset = offset;
        benchmarkCurveCurrencyLength = length;
        return this;
    }

    /* BenchmarkCurveCurrency = 220 */
    public SpreadOrBenchmarkCurveDataEncoder benchmarkCurveCurrency(final DirectBuffer value, final int length)
    {
        return benchmarkCurveCurrency(value, 0, length);
    }

    /* BenchmarkCurveCurrency = 220 */
    public SpreadOrBenchmarkCurveDataEncoder benchmarkCurveCurrency(final DirectBuffer value)
    {
        return benchmarkCurveCurrency(value, 0, value.capacity());
    }

    /* BenchmarkCurveCurrency = 220 */
    public SpreadOrBenchmarkCurveDataEncoder benchmarkCurveCurrency(final byte[] value, final int offset, final int length)
    {
        benchmarkCurveCurrency.wrap(value);
        benchmarkCurveCurrencyOffset = offset;
        benchmarkCurveCurrencyLength = length;
        return this;
    }

    /* BenchmarkCurveCurrency = 220 */
    public SpreadOrBenchmarkCurveDataEncoder benchmarkCurveCurrencyAsCopy(final byte[] value, final int offset, final int length)
    {
        copyInto(benchmarkCurveCurrency, value, offset, length);
        benchmarkCurveCurrencyOffset = offset;
        benchmarkCurveCurrencyLength = length;
        return this;
    }

    /* BenchmarkCurveCurrency = 220 */
    public SpreadOrBenchmarkCurveDataEncoder benchmarkCurveCurrency(final byte[] value, final int length)
    {
        return benchmarkCurveCurrency(value, 0, length);
    }

    /* BenchmarkCurveCurrency = 220 */
    public SpreadOrBenchmarkCurveDataEncoder benchmarkCurveCurrency(final byte[] value)
    {
        return benchmarkCurveCurrency(value, 0, value.length);
    }

    /* BenchmarkCurveCurrency = 220 */
    public boolean hasBenchmarkCurveCurrency()
    {
        return benchmarkCurveCurrencyLength > 0;
    }

    /* BenchmarkCurveCurrency = 220 */
    public MutableDirectBuffer benchmarkCurveCurrency()
    {
        return benchmarkCurveCurrency;
    }

    /* BenchmarkCurveCurrency = 220 */
    public String benchmarkCurveCurrencyAsString()
    {
        return benchmarkCurveCurrency.getStringWithoutLengthAscii(benchmarkCurveCurrencyOffset, benchmarkCurveCurrencyLength);
    }

    /* BenchmarkCurveCurrency = 220 */
    public SpreadOrBenchmarkCurveDataEncoder benchmarkCurveCurrency(final CharSequence value)
    {
        toBytes(value, benchmarkCurveCurrency);
        benchmarkCurveCurrencyOffset = 0;
        benchmarkCurveCurrencyLength = value.length();
        return this;
    }

    /* BenchmarkCurveCurrency = 220 */
    public SpreadOrBenchmarkCurveDataEncoder benchmarkCurveCurrency(final AsciiSequenceView value)
    {
        final DirectBuffer buffer = value.buffer();
        if (buffer != null)
        {
            benchmarkCurveCurrency.wrap(buffer);
            benchmarkCurveCurrencyOffset = value.offset();
            benchmarkCurveCurrencyLength = value.length();
        }
        return this;
    }

    /* BenchmarkCurveCurrency = 220 */
    public SpreadOrBenchmarkCurveDataEncoder benchmarkCurveCurrency(final char[] value)
    {
        return benchmarkCurveCurrency(value, 0, value.length);
    }

    /* BenchmarkCurveCurrency = 220 */
    public SpreadOrBenchmarkCurveDataEncoder benchmarkCurveCurrency(final char[] value, final int length)
    {
        return benchmarkCurveCurrency(value, 0, length);
    }

    /* BenchmarkCurveCurrency = 220 */
    public SpreadOrBenchmarkCurveDataEncoder benchmarkCurveCurrency(final char[] value, final int offset, final int length)
    {
        toBytes(value, benchmarkCurveCurrency, offset, length);
        benchmarkCurveCurrencyOffset = 0;
        benchmarkCurveCurrencyLength = length;
        return this;
    }

    private final MutableDirectBuffer benchmarkCurveName = new UnsafeBuffer();

    private int benchmarkCurveNameOffset = 0;

    private int benchmarkCurveNameLength = 0;

    /* BenchmarkCurveName = 221 */
    public SpreadOrBenchmarkCurveDataEncoder benchmarkCurveName(final DirectBuffer value, final int offset, final int length)
    {
        benchmarkCurveName.wrap(value);
        benchmarkCurveNameOffset = offset;
        benchmarkCurveNameLength = length;
        return this;
    }

    /* BenchmarkCurveName = 221 */
    public SpreadOrBenchmarkCurveDataEncoder benchmarkCurveName(final DirectBuffer value, final int length)
    {
        return benchmarkCurveName(value, 0, length);
    }

    /* BenchmarkCurveName = 221 */
    public SpreadOrBenchmarkCurveDataEncoder benchmarkCurveName(final DirectBuffer value)
    {
        return benchmarkCurveName(value, 0, value.capacity());
    }

    /* BenchmarkCurveName = 221 */
    public SpreadOrBenchmarkCurveDataEncoder benchmarkCurveName(final byte[] value, final int offset, final int length)
    {
        benchmarkCurveName.wrap(value);
        benchmarkCurveNameOffset = offset;
        benchmarkCurveNameLength = length;
        return this;
    }

    /* BenchmarkCurveName = 221 */
    public SpreadOrBenchmarkCurveDataEncoder benchmarkCurveNameAsCopy(final byte[] value, final int offset, final int length)
    {
        copyInto(benchmarkCurveName, value, offset, length);
        benchmarkCurveNameOffset = offset;
        benchmarkCurveNameLength = length;
        return this;
    }

    /* BenchmarkCurveName = 221 */
    public SpreadOrBenchmarkCurveDataEncoder benchmarkCurveName(final byte[] value, final int length)
    {
        return benchmarkCurveName(value, 0, length);
    }

    /* BenchmarkCurveName = 221 */
    public SpreadOrBenchmarkCurveDataEncoder benchmarkCurveName(final byte[] value)
    {
        return benchmarkCurveName(value, 0, value.length);
    }

    /* BenchmarkCurveName = 221 */
    public boolean hasBenchmarkCurveName()
    {
        return benchmarkCurveNameLength > 0;
    }

    /* BenchmarkCurveName = 221 */
    public MutableDirectBuffer benchmarkCurveName()
    {
        return benchmarkCurveName;
    }

    /* BenchmarkCurveName = 221 */
    public String benchmarkCurveNameAsString()
    {
        return benchmarkCurveName.getStringWithoutLengthAscii(benchmarkCurveNameOffset, benchmarkCurveNameLength);
    }

    /* BenchmarkCurveName = 221 */
    public SpreadOrBenchmarkCurveDataEncoder benchmarkCurveName(final CharSequence value)
    {
        toBytes(value, benchmarkCurveName);
        benchmarkCurveNameOffset = 0;
        benchmarkCurveNameLength = value.length();
        return this;
    }

    /* BenchmarkCurveName = 221 */
    public SpreadOrBenchmarkCurveDataEncoder benchmarkCurveName(final AsciiSequenceView value)
    {
        final DirectBuffer buffer = value.buffer();
        if (buffer != null)
        {
            benchmarkCurveName.wrap(buffer);
            benchmarkCurveNameOffset = value.offset();
            benchmarkCurveNameLength = value.length();
        }
        return this;
    }

    /* BenchmarkCurveName = 221 */
    public SpreadOrBenchmarkCurveDataEncoder benchmarkCurveName(final char[] value)
    {
        return benchmarkCurveName(value, 0, value.length);
    }

    /* BenchmarkCurveName = 221 */
    public SpreadOrBenchmarkCurveDataEncoder benchmarkCurveName(final char[] value, final int length)
    {
        return benchmarkCurveName(value, 0, length);
    }

    /* BenchmarkCurveName = 221 */
    public SpreadOrBenchmarkCurveDataEncoder benchmarkCurveName(final char[] value, final int offset, final int length)
    {
        toBytes(value, benchmarkCurveName, offset, length);
        benchmarkCurveNameOffset = 0;
        benchmarkCurveNameLength = length;
        return this;
    }

    public SpreadOrBenchmarkCurveDataEncoder benchmarkCurveName(BenchmarkCurveName value)
    {
        if (CODEC_VALIDATION_ENABLED)
        {
            if (value == BenchmarkCurveName.ARTIO_UNKNOWN)
            {
                throw new EncodingException("Invalid Value Field: benchmarkCurveName Value: " + value );
            }
            if (value == BenchmarkCurveName.NULL_VAL)
            {
                return this;
            }
        }
        return benchmarkCurveName(value.representation());
    }

    private final MutableDirectBuffer benchmarkCurvePoint = new UnsafeBuffer();

    private int benchmarkCurvePointOffset = 0;

    private int benchmarkCurvePointLength = 0;

    /* BenchmarkCurvePoint = 222 */
    public SpreadOrBenchmarkCurveDataEncoder benchmarkCurvePoint(final DirectBuffer value, final int offset, final int length)
    {
        benchmarkCurvePoint.wrap(value);
        benchmarkCurvePointOffset = offset;
        benchmarkCurvePointLength = length;
        return this;
    }

    /* BenchmarkCurvePoint = 222 */
    public SpreadOrBenchmarkCurveDataEncoder benchmarkCurvePoint(final DirectBuffer value, final int length)
    {
        return benchmarkCurvePoint(value, 0, length);
    }

    /* BenchmarkCurvePoint = 222 */
    public SpreadOrBenchmarkCurveDataEncoder benchmarkCurvePoint(final DirectBuffer value)
    {
        return benchmarkCurvePoint(value, 0, value.capacity());
    }

    /* BenchmarkCurvePoint = 222 */
    public SpreadOrBenchmarkCurveDataEncoder benchmarkCurvePoint(final byte[] value, final int offset, final int length)
    {
        benchmarkCurvePoint.wrap(value);
        benchmarkCurvePointOffset = offset;
        benchmarkCurvePointLength = length;
        return this;
    }

    /* BenchmarkCurvePoint = 222 */
    public SpreadOrBenchmarkCurveDataEncoder benchmarkCurvePointAsCopy(final byte[] value, final int offset, final int length)
    {
        copyInto(benchmarkCurvePoint, value, offset, length);
        benchmarkCurvePointOffset = offset;
        benchmarkCurvePointLength = length;
        return this;
    }

    /* BenchmarkCurvePoint = 222 */
    public SpreadOrBenchmarkCurveDataEncoder benchmarkCurvePoint(final byte[] value, final int length)
    {
        return benchmarkCurvePoint(value, 0, length);
    }

    /* BenchmarkCurvePoint = 222 */
    public SpreadOrBenchmarkCurveDataEncoder benchmarkCurvePoint(final byte[] value)
    {
        return benchmarkCurvePoint(value, 0, value.length);
    }

    /* BenchmarkCurvePoint = 222 */
    public boolean hasBenchmarkCurvePoint()
    {
        return benchmarkCurvePointLength > 0;
    }

    /* BenchmarkCurvePoint = 222 */
    public MutableDirectBuffer benchmarkCurvePoint()
    {
        return benchmarkCurvePoint;
    }

    /* BenchmarkCurvePoint = 222 */
    public String benchmarkCurvePointAsString()
    {
        return benchmarkCurvePoint.getStringWithoutLengthAscii(benchmarkCurvePointOffset, benchmarkCurvePointLength);
    }

    /* BenchmarkCurvePoint = 222 */
    public SpreadOrBenchmarkCurveDataEncoder benchmarkCurvePoint(final CharSequence value)
    {
        toBytes(value, benchmarkCurvePoint);
        benchmarkCurvePointOffset = 0;
        benchmarkCurvePointLength = value.length();
        return this;
    }

    /* BenchmarkCurvePoint = 222 */
    public SpreadOrBenchmarkCurveDataEncoder benchmarkCurvePoint(final AsciiSequenceView value)
    {
        final DirectBuffer buffer = value.buffer();
        if (buffer != null)
        {
            benchmarkCurvePoint.wrap(buffer);
            benchmarkCurvePointOffset = value.offset();
            benchmarkCurvePointLength = value.length();
        }
        return this;
    }

    /* BenchmarkCurvePoint = 222 */
    public SpreadOrBenchmarkCurveDataEncoder benchmarkCurvePoint(final char[] value)
    {
        return benchmarkCurvePoint(value, 0, value.length);
    }

    /* BenchmarkCurvePoint = 222 */
    public SpreadOrBenchmarkCurveDataEncoder benchmarkCurvePoint(final char[] value, final int length)
    {
        return benchmarkCurvePoint(value, 0, length);
    }

    /* BenchmarkCurvePoint = 222 */
    public SpreadOrBenchmarkCurveDataEncoder benchmarkCurvePoint(final char[] value, final int offset, final int length)
    {
        toBytes(value, benchmarkCurvePoint, offset, length);
        benchmarkCurvePointOffset = 0;
        benchmarkCurvePointLength = length;
        return this;
    }

    private final DecimalFloat benchmarkPrice = new DecimalFloat();

    private boolean hasBenchmarkPrice;

    public boolean hasBenchmarkPrice()
    {
        return hasBenchmarkPrice;
    }

    /* BenchmarkPrice = 662 */
    public SpreadOrBenchmarkCurveDataEncoder benchmarkPrice(ReadOnlyDecimalFloat value)
    {
        benchmarkPrice.set(value);
        hasBenchmarkPrice = true;
        return this;
    }

    /* BenchmarkPrice = 662 */
    public SpreadOrBenchmarkCurveDataEncoder benchmarkPrice(long value, int scale)
    {
        benchmarkPrice.set(value, scale);
        hasBenchmarkPrice = true;
        return this;
    }

    /* BenchmarkPrice = 662 */
    public DecimalFloat benchmarkPrice()
    {
        return benchmarkPrice;
    }

    private int benchmarkPriceType;

    private boolean hasBenchmarkPriceType;

    public boolean hasBenchmarkPriceType()
    {
        return hasBenchmarkPriceType;
    }

    /* BenchmarkPriceType = 663 */
    public SpreadOrBenchmarkCurveDataEncoder benchmarkPriceType(int value)
    {
        benchmarkPriceType = value;
        hasBenchmarkPriceType = true;
        return this;
    }

    /* BenchmarkPriceType = 663 */
    public int benchmarkPriceType()
    {
        return benchmarkPriceType;
    }

    private final MutableDirectBuffer benchmarkSecurityID = new UnsafeBuffer();

    private int benchmarkSecurityIDOffset = 0;

    private int benchmarkSecurityIDLength = 0;

    /* BenchmarkSecurityID = 699 */
    public SpreadOrBenchmarkCurveDataEncoder benchmarkSecurityID(final DirectBuffer value, final int offset, final int length)
    {
        benchmarkSecurityID.wrap(value);
        benchmarkSecurityIDOffset = offset;
        benchmarkSecurityIDLength = length;
        return this;
    }

    /* BenchmarkSecurityID = 699 */
    public SpreadOrBenchmarkCurveDataEncoder benchmarkSecurityID(final DirectBuffer value, final int length)
    {
        return benchmarkSecurityID(value, 0, length);
    }

    /* BenchmarkSecurityID = 699 */
    public SpreadOrBenchmarkCurveDataEncoder benchmarkSecurityID(final DirectBuffer value)
    {
        return benchmarkSecurityID(value, 0, value.capacity());
    }

    /* BenchmarkSecurityID = 699 */
    public SpreadOrBenchmarkCurveDataEncoder benchmarkSecurityID(final byte[] value, final int offset, final int length)
    {
        benchmarkSecurityID.wrap(value);
        benchmarkSecurityIDOffset = offset;
        benchmarkSecurityIDLength = length;
        return this;
    }

    /* BenchmarkSecurityID = 699 */
    public SpreadOrBenchmarkCurveDataEncoder benchmarkSecurityIDAsCopy(final byte[] value, final int offset, final int length)
    {
        copyInto(benchmarkSecurityID, value, offset, length);
        benchmarkSecurityIDOffset = offset;
        benchmarkSecurityIDLength = length;
        return this;
    }

    /* BenchmarkSecurityID = 699 */
    public SpreadOrBenchmarkCurveDataEncoder benchmarkSecurityID(final byte[] value, final int length)
    {
        return benchmarkSecurityID(value, 0, length);
    }

    /* BenchmarkSecurityID = 699 */
    public SpreadOrBenchmarkCurveDataEncoder benchmarkSecurityID(final byte[] value)
    {
        return benchmarkSecurityID(value, 0, value.length);
    }

    /* BenchmarkSecurityID = 699 */
    public boolean hasBenchmarkSecurityID()
    {
        return benchmarkSecurityIDLength > 0;
    }

    /* BenchmarkSecurityID = 699 */
    public MutableDirectBuffer benchmarkSecurityID()
    {
        return benchmarkSecurityID;
    }

    /* BenchmarkSecurityID = 699 */
    public String benchmarkSecurityIDAsString()
    {
        return benchmarkSecurityID.getStringWithoutLengthAscii(benchmarkSecurityIDOffset, benchmarkSecurityIDLength);
    }

    /* BenchmarkSecurityID = 699 */
    public SpreadOrBenchmarkCurveDataEncoder benchmarkSecurityID(final CharSequence value)
    {
        toBytes(value, benchmarkSecurityID);
        benchmarkSecurityIDOffset = 0;
        benchmarkSecurityIDLength = value.length();
        return this;
    }

    /* BenchmarkSecurityID = 699 */
    public SpreadOrBenchmarkCurveDataEncoder benchmarkSecurityID(final AsciiSequenceView value)
    {
        final DirectBuffer buffer = value.buffer();
        if (buffer != null)
        {
            benchmarkSecurityID.wrap(buffer);
            benchmarkSecurityIDOffset = value.offset();
            benchmarkSecurityIDLength = value.length();
        }
        return this;
    }

    /* BenchmarkSecurityID = 699 */
    public SpreadOrBenchmarkCurveDataEncoder benchmarkSecurityID(final char[] value)
    {
        return benchmarkSecurityID(value, 0, value.length);
    }

    /* BenchmarkSecurityID = 699 */
    public SpreadOrBenchmarkCurveDataEncoder benchmarkSecurityID(final char[] value, final int length)
    {
        return benchmarkSecurityID(value, 0, length);
    }

    /* BenchmarkSecurityID = 699 */
    public SpreadOrBenchmarkCurveDataEncoder benchmarkSecurityID(final char[] value, final int offset, final int length)
    {
        toBytes(value, benchmarkSecurityID, offset, length);
        benchmarkSecurityIDOffset = 0;
        benchmarkSecurityIDLength = length;
        return this;
    }

    private final MutableDirectBuffer benchmarkSecurityIDSource = new UnsafeBuffer();

    private int benchmarkSecurityIDSourceOffset = 0;

    private int benchmarkSecurityIDSourceLength = 0;

    /* BenchmarkSecurityIDSource = 761 */
    public SpreadOrBenchmarkCurveDataEncoder benchmarkSecurityIDSource(final DirectBuffer value, final int offset, final int length)
    {
        benchmarkSecurityIDSource.wrap(value);
        benchmarkSecurityIDSourceOffset = offset;
        benchmarkSecurityIDSourceLength = length;
        return this;
    }

    /* BenchmarkSecurityIDSource = 761 */
    public SpreadOrBenchmarkCurveDataEncoder benchmarkSecurityIDSource(final DirectBuffer value, final int length)
    {
        return benchmarkSecurityIDSource(value, 0, length);
    }

    /* BenchmarkSecurityIDSource = 761 */
    public SpreadOrBenchmarkCurveDataEncoder benchmarkSecurityIDSource(final DirectBuffer value)
    {
        return benchmarkSecurityIDSource(value, 0, value.capacity());
    }

    /* BenchmarkSecurityIDSource = 761 */
    public SpreadOrBenchmarkCurveDataEncoder benchmarkSecurityIDSource(final byte[] value, final int offset, final int length)
    {
        benchmarkSecurityIDSource.wrap(value);
        benchmarkSecurityIDSourceOffset = offset;
        benchmarkSecurityIDSourceLength = length;
        return this;
    }

    /* BenchmarkSecurityIDSource = 761 */
    public SpreadOrBenchmarkCurveDataEncoder benchmarkSecurityIDSourceAsCopy(final byte[] value, final int offset, final int length)
    {
        copyInto(benchmarkSecurityIDSource, value, offset, length);
        benchmarkSecurityIDSourceOffset = offset;
        benchmarkSecurityIDSourceLength = length;
        return this;
    }

    /* BenchmarkSecurityIDSource = 761 */
    public SpreadOrBenchmarkCurveDataEncoder benchmarkSecurityIDSource(final byte[] value, final int length)
    {
        return benchmarkSecurityIDSource(value, 0, length);
    }

    /* BenchmarkSecurityIDSource = 761 */
    public SpreadOrBenchmarkCurveDataEncoder benchmarkSecurityIDSource(final byte[] value)
    {
        return benchmarkSecurityIDSource(value, 0, value.length);
    }

    /* BenchmarkSecurityIDSource = 761 */
    public boolean hasBenchmarkSecurityIDSource()
    {
        return benchmarkSecurityIDSourceLength > 0;
    }

    /* BenchmarkSecurityIDSource = 761 */
    public MutableDirectBuffer benchmarkSecurityIDSource()
    {
        return benchmarkSecurityIDSource;
    }

    /* BenchmarkSecurityIDSource = 761 */
    public String benchmarkSecurityIDSourceAsString()
    {
        return benchmarkSecurityIDSource.getStringWithoutLengthAscii(benchmarkSecurityIDSourceOffset, benchmarkSecurityIDSourceLength);
    }

    /* BenchmarkSecurityIDSource = 761 */
    public SpreadOrBenchmarkCurveDataEncoder benchmarkSecurityIDSource(final CharSequence value)
    {
        toBytes(value, benchmarkSecurityIDSource);
        benchmarkSecurityIDSourceOffset = 0;
        benchmarkSecurityIDSourceLength = value.length();
        return this;
    }

    /* BenchmarkSecurityIDSource = 761 */
    public SpreadOrBenchmarkCurveDataEncoder benchmarkSecurityIDSource(final AsciiSequenceView value)
    {
        final DirectBuffer buffer = value.buffer();
        if (buffer != null)
        {
            benchmarkSecurityIDSource.wrap(buffer);
            benchmarkSecurityIDSourceOffset = value.offset();
            benchmarkSecurityIDSourceLength = value.length();
        }
        return this;
    }

    /* BenchmarkSecurityIDSource = 761 */
    public SpreadOrBenchmarkCurveDataEncoder benchmarkSecurityIDSource(final char[] value)
    {
        return benchmarkSecurityIDSource(value, 0, value.length);
    }

    /* BenchmarkSecurityIDSource = 761 */
    public SpreadOrBenchmarkCurveDataEncoder benchmarkSecurityIDSource(final char[] value, final int length)
    {
        return benchmarkSecurityIDSource(value, 0, length);
    }

    /* BenchmarkSecurityIDSource = 761 */
    public SpreadOrBenchmarkCurveDataEncoder benchmarkSecurityIDSource(final char[] value, final int offset, final int length)
    {
        toBytes(value, benchmarkSecurityIDSource, offset, length);
        benchmarkSecurityIDSourceOffset = 0;
        benchmarkSecurityIDSourceLength = length;
        return this;
    }

    public int encode(final MutableAsciiBuffer buffer, final int offset)
    {
        int position = offset;

        if (hasSpread)
        {
            buffer.putBytes(position, spreadHeader, 0, spreadHeaderLength);
            position += spreadHeaderLength;
            position += buffer.putFloatAscii(position, spread);
            buffer.putSeparator(position);
            position++;
        }

        if (benchmarkCurveCurrencyLength > 0)
        {
            buffer.putBytes(position, benchmarkCurveCurrencyHeader, 0, benchmarkCurveCurrencyHeaderLength);
            position += benchmarkCurveCurrencyHeaderLength;
            buffer.putBytes(position, benchmarkCurveCurrency, benchmarkCurveCurrencyOffset, benchmarkCurveCurrencyLength);
            position += benchmarkCurveCurrencyLength;
            buffer.putSeparator(position);
            position++;
        }

        if (benchmarkCurveNameLength > 0)
        {
            buffer.putBytes(position, benchmarkCurveNameHeader, 0, benchmarkCurveNameHeaderLength);
            position += benchmarkCurveNameHeaderLength;
            buffer.putBytes(position, benchmarkCurveName, benchmarkCurveNameOffset, benchmarkCurveNameLength);
            position += benchmarkCurveNameLength;
            buffer.putSeparator(position);
            position++;
        }

        if (benchmarkCurvePointLength > 0)
        {
            buffer.putBytes(position, benchmarkCurvePointHeader, 0, benchmarkCurvePointHeaderLength);
            position += benchmarkCurvePointHeaderLength;
            buffer.putBytes(position, benchmarkCurvePoint, benchmarkCurvePointOffset, benchmarkCurvePointLength);
            position += benchmarkCurvePointLength;
            buffer.putSeparator(position);
            position++;
        }

        if (hasBenchmarkPrice)
        {
            buffer.putBytes(position, benchmarkPriceHeader, 0, benchmarkPriceHeaderLength);
            position += benchmarkPriceHeaderLength;
            position += buffer.putFloatAscii(position, benchmarkPrice);
            buffer.putSeparator(position);
            position++;
        }

        if (hasBenchmarkPriceType)
        {
            buffer.putBytes(position, benchmarkPriceTypeHeader, 0, benchmarkPriceTypeHeaderLength);
            position += benchmarkPriceTypeHeaderLength;
            position += buffer.putIntAscii(position, benchmarkPriceType);
            buffer.putSeparator(position);
            position++;
        }

        if (benchmarkSecurityIDLength > 0)
        {
            buffer.putBytes(position, benchmarkSecurityIDHeader, 0, benchmarkSecurityIDHeaderLength);
            position += benchmarkSecurityIDHeaderLength;
            buffer.putBytes(position, benchmarkSecurityID, benchmarkSecurityIDOffset, benchmarkSecurityIDLength);
            position += benchmarkSecurityIDLength;
            buffer.putSeparator(position);
            position++;
        }

        if (benchmarkSecurityIDSourceLength > 0)
        {
            buffer.putBytes(position, benchmarkSecurityIDSourceHeader, 0, benchmarkSecurityIDSourceHeaderLength);
            position += benchmarkSecurityIDSourceHeaderLength;
            buffer.putBytes(position, benchmarkSecurityIDSource, benchmarkSecurityIDSourceOffset, benchmarkSecurityIDSourceLength);
            position += benchmarkSecurityIDSourceLength;
            buffer.putSeparator(position);
            position++;
        }
        return position - offset;
    }

    public void reset()
    {
        this.resetSpread();
        this.resetBenchmarkCurveCurrency();
        this.resetBenchmarkCurveName();
        this.resetBenchmarkCurvePoint();
        this.resetBenchmarkPrice();
        this.resetBenchmarkPriceType();
        this.resetBenchmarkSecurityID();
        this.resetBenchmarkSecurityIDSource();
    }

    public void resetSpread()
    {
        hasSpread = false;
    }

    public void resetBenchmarkCurveCurrency()
    {
        benchmarkCurveCurrencyLength = 0;
    }

    public void resetBenchmarkCurveName()
    {
        benchmarkCurveNameLength = 0;
    }

    public void resetBenchmarkCurvePoint()
    {
        benchmarkCurvePointLength = 0;
    }

    public void resetBenchmarkPrice()
    {
        hasBenchmarkPrice = false;
    }

    public void resetBenchmarkPriceType()
    {
        hasBenchmarkPriceType = false;
    }

    public void resetBenchmarkSecurityID()
    {
        benchmarkSecurityIDLength = 0;
    }

    public void resetBenchmarkSecurityIDSource()
    {
        benchmarkSecurityIDSourceLength = 0;
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
        builder.append("\"MessageName\": \"SpreadOrBenchmarkCurveData\",\n");
        if (hasSpread())
        {
            indent(builder, level);
            builder.append("\"Spread\": \"");
            spread.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasBenchmarkCurveCurrency())
        {
            indent(builder, level);
            builder.append("\"BenchmarkCurveCurrency\": \"");
            appendBuffer(builder, benchmarkCurveCurrency, benchmarkCurveCurrencyOffset, benchmarkCurveCurrencyLength);
            builder.append("\",\n");
        }

        if (hasBenchmarkCurveName())
        {
            indent(builder, level);
            builder.append("\"BenchmarkCurveName\": \"");
            appendBuffer(builder, benchmarkCurveName, benchmarkCurveNameOffset, benchmarkCurveNameLength);
            builder.append("\",\n");
        }

        if (hasBenchmarkCurvePoint())
        {
            indent(builder, level);
            builder.append("\"BenchmarkCurvePoint\": \"");
            appendBuffer(builder, benchmarkCurvePoint, benchmarkCurvePointOffset, benchmarkCurvePointLength);
            builder.append("\",\n");
        }

        if (hasBenchmarkPrice())
        {
            indent(builder, level);
            builder.append("\"BenchmarkPrice\": \"");
            benchmarkPrice.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasBenchmarkPriceType())
        {
            indent(builder, level);
            builder.append("\"BenchmarkPriceType\": \"");
            builder.append(benchmarkPriceType);
            builder.append("\",\n");
        }

        if (hasBenchmarkSecurityID())
        {
            indent(builder, level);
            builder.append("\"BenchmarkSecurityID\": \"");
            appendBuffer(builder, benchmarkSecurityID, benchmarkSecurityIDOffset, benchmarkSecurityIDLength);
            builder.append("\",\n");
        }

        if (hasBenchmarkSecurityIDSource())
        {
            indent(builder, level);
            builder.append("\"BenchmarkSecurityIDSource\": \"");
            appendBuffer(builder, benchmarkSecurityIDSource, benchmarkSecurityIDSourceOffset, benchmarkSecurityIDSourceLength);
            builder.append("\",\n");
        }
        indent(builder, level - 1);
        builder.append("}");
        return builder;
    }

    /**
     * {@inheritDoc}
     */
    public SpreadOrBenchmarkCurveDataEncoder copyTo(final Encoder encoder)
    {
        return copyTo((SpreadOrBenchmarkCurveDataEncoder)encoder);
    }

    public SpreadOrBenchmarkCurveDataEncoder copyTo(final SpreadOrBenchmarkCurveDataEncoder encoder)
    {
        encoder.reset();
        if (hasSpread())
        {
            encoder.spread(this.spread());
        }

        if (hasBenchmarkCurveCurrency())
        {
            encoder.benchmarkCurveCurrencyAsCopy(benchmarkCurveCurrency.byteArray(), 0, benchmarkCurveCurrencyLength);
        }

        if (hasBenchmarkCurveName())
        {
            encoder.benchmarkCurveNameAsCopy(benchmarkCurveName.byteArray(), 0, benchmarkCurveNameLength);
        }

        if (hasBenchmarkCurvePoint())
        {
            encoder.benchmarkCurvePointAsCopy(benchmarkCurvePoint.byteArray(), 0, benchmarkCurvePointLength);
        }

        if (hasBenchmarkPrice())
        {
            encoder.benchmarkPrice(this.benchmarkPrice());
        }

        if (hasBenchmarkPriceType())
        {
            encoder.benchmarkPriceType(this.benchmarkPriceType());
        }

        if (hasBenchmarkSecurityID())
        {
            encoder.benchmarkSecurityIDAsCopy(benchmarkSecurityID.byteArray(), 0, benchmarkSecurityIDLength);
        }

        if (hasBenchmarkSecurityIDSource())
        {
            encoder.benchmarkSecurityIDSourceAsCopy(benchmarkSecurityIDSource.byteArray(), 0, benchmarkSecurityIDSourceLength);
        }
        return encoder;
    }

}
