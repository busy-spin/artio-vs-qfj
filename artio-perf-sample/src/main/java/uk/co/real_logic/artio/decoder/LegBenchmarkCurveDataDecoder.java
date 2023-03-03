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
import uk.co.real_logic.artio.builder.LegBenchmarkCurveDataEncoder;
import uk.co.real_logic.artio.dictionary.Generated;

@Generated("uk.co.real_logic.artio")
public interface LegBenchmarkCurveDataDecoder 
{

    /* LegBenchmarkCurveCurrency = 676 */
    public char[] legBenchmarkCurveCurrency();
    /* LegBenchmarkCurveCurrency = 676 */
    public boolean hasLegBenchmarkCurveCurrency();
    /* LegBenchmarkCurveCurrency = 676 */
    public int legBenchmarkCurveCurrencyLength();
    /* LegBenchmarkCurveCurrency = 676 */
    public AsciiSequenceView legBenchmarkCurveCurrency(AsciiSequenceView view);
    /* LegBenchmarkCurveName = 677 */
    public char[] legBenchmarkCurveName();
    /* LegBenchmarkCurveName = 677 */
    public boolean hasLegBenchmarkCurveName();
    /* LegBenchmarkCurveName = 677 */
    public int legBenchmarkCurveNameLength();
    /* LegBenchmarkCurveName = 677 */
    public AsciiSequenceView legBenchmarkCurveName(AsciiSequenceView view);
    /* LegBenchmarkCurvePoint = 678 */
    public char[] legBenchmarkCurvePoint();
    /* LegBenchmarkCurvePoint = 678 */
    public boolean hasLegBenchmarkCurvePoint();
    /* LegBenchmarkCurvePoint = 678 */
    public int legBenchmarkCurvePointLength();
    /* LegBenchmarkCurvePoint = 678 */
    public AsciiSequenceView legBenchmarkCurvePoint(AsciiSequenceView view);
    /* LegBenchmarkPrice = 679 */
    public DecimalFloat legBenchmarkPrice();
    /* LegBenchmarkPrice = 679 */
    public boolean hasLegBenchmarkPrice();
    /* LegBenchmarkPriceType = 680 */
    public int legBenchmarkPriceType();
    /* LegBenchmarkPriceType = 680 */
    public boolean hasLegBenchmarkPriceType();

}
