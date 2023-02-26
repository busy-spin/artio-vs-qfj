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
import uk.co.real_logic.artio.builder.OrderQtyDataEncoder;
import uk.co.real_logic.artio.dictionary.Generated;

@Generated("uk.co.real_logic.artio")
public interface OrderQtyDataDecoder 
{

    /* OrderQty = 38 */
    public DecimalFloat orderQty();
    /* OrderQty = 38 */
    public boolean hasOrderQty();
    /* CashOrderQty = 152 */
    public DecimalFloat cashOrderQty();
    /* CashOrderQty = 152 */
    public boolean hasCashOrderQty();
    /* OrderPercent = 516 */
    public DecimalFloat orderPercent();
    /* OrderPercent = 516 */
    public boolean hasOrderPercent();
    /* RoundingDirection = 468 */
    public char roundingDirection();
    /* RoundingDirection = 468 */
    public boolean hasRoundingDirection();
    /* RoundingDirection = 468 */
    public RoundingDirection roundingDirectionAsEnum();
    /* RoundingModulus = 469 */
    public DecimalFloat roundingModulus();
    /* RoundingModulus = 469 */
    public boolean hasRoundingModulus();

}