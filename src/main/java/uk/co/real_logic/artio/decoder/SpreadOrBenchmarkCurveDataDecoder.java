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
import uk.co.real_logic.artio.builder.SpreadOrBenchmarkCurveDataEncoder;
import uk.co.real_logic.artio.dictionary.Generated;

@Generated("uk.co.real_logic.artio")
public interface SpreadOrBenchmarkCurveDataDecoder 
{

    /* Spread = 218 */
    public DecimalFloat spread();
    /* Spread = 218 */
    public boolean hasSpread();
    /* BenchmarkCurveCurrency = 220 */
    public char[] benchmarkCurveCurrency();
    /* BenchmarkCurveCurrency = 220 */
    public boolean hasBenchmarkCurveCurrency();
    /* BenchmarkCurveCurrency = 220 */
    public int benchmarkCurveCurrencyLength();
    /* BenchmarkCurveCurrency = 220 */
    public AsciiSequenceView benchmarkCurveCurrency(AsciiSequenceView view);
    /* BenchmarkCurveName = 221 */
    public char[] benchmarkCurveName();
    /* BenchmarkCurveName = 221 */
    public boolean hasBenchmarkCurveName();
    /* BenchmarkCurveName = 221 */
    public int benchmarkCurveNameLength();
    /* BenchmarkCurveName = 221 */
    public BenchmarkCurveName benchmarkCurveNameAsEnum();
    /* BenchmarkCurveName = 221 */
    public AsciiSequenceView benchmarkCurveName(AsciiSequenceView view);
    /* BenchmarkCurvePoint = 222 */
    public char[] benchmarkCurvePoint();
    /* BenchmarkCurvePoint = 222 */
    public boolean hasBenchmarkCurvePoint();
    /* BenchmarkCurvePoint = 222 */
    public int benchmarkCurvePointLength();
    /* BenchmarkCurvePoint = 222 */
    public AsciiSequenceView benchmarkCurvePoint(AsciiSequenceView view);
    /* BenchmarkPrice = 662 */
    public DecimalFloat benchmarkPrice();
    /* BenchmarkPrice = 662 */
    public boolean hasBenchmarkPrice();
    /* BenchmarkPriceType = 663 */
    public int benchmarkPriceType();
    /* BenchmarkPriceType = 663 */
    public boolean hasBenchmarkPriceType();
    /* BenchmarkSecurityID = 699 */
    public char[] benchmarkSecurityID();
    /* BenchmarkSecurityID = 699 */
    public boolean hasBenchmarkSecurityID();
    /* BenchmarkSecurityID = 699 */
    public int benchmarkSecurityIDLength();
    /* BenchmarkSecurityID = 699 */
    public AsciiSequenceView benchmarkSecurityID(AsciiSequenceView view);
    /* BenchmarkSecurityIDSource = 761 */
    public char[] benchmarkSecurityIDSource();
    /* BenchmarkSecurityIDSource = 761 */
    public boolean hasBenchmarkSecurityIDSource();
    /* BenchmarkSecurityIDSource = 761 */
    public int benchmarkSecurityIDSourceLength();
    /* BenchmarkSecurityIDSource = 761 */
    public AsciiSequenceView benchmarkSecurityIDSource(AsciiSequenceView view);

}
