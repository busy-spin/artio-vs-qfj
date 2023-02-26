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
import uk.co.real_logic.artio.builder.DiscretionInstructionsEncoder;
import uk.co.real_logic.artio.dictionary.Generated;

@Generated("uk.co.real_logic.artio")
public interface DiscretionInstructionsDecoder 
{

    /* DiscretionInst = 388 */
    public char discretionInst();
    /* DiscretionInst = 388 */
    public boolean hasDiscretionInst();
    /* DiscretionInst = 388 */
    public DiscretionInst discretionInstAsEnum();
    /* DiscretionOffsetValue = 389 */
    public DecimalFloat discretionOffsetValue();
    /* DiscretionOffsetValue = 389 */
    public boolean hasDiscretionOffsetValue();
    /* DiscretionMoveType = 841 */
    public int discretionMoveType();
    /* DiscretionMoveType = 841 */
    public boolean hasDiscretionMoveType();
    /* DiscretionMoveType = 841 */
    public DiscretionMoveType discretionMoveTypeAsEnum();
    /* DiscretionOffsetType = 842 */
    public int discretionOffsetType();
    /* DiscretionOffsetType = 842 */
    public boolean hasDiscretionOffsetType();
    /* DiscretionOffsetType = 842 */
    public DiscretionOffsetType discretionOffsetTypeAsEnum();
    /* DiscretionLimitType = 843 */
    public int discretionLimitType();
    /* DiscretionLimitType = 843 */
    public boolean hasDiscretionLimitType();
    /* DiscretionLimitType = 843 */
    public DiscretionLimitType discretionLimitTypeAsEnum();
    /* DiscretionRoundDirection = 844 */
    public int discretionRoundDirection();
    /* DiscretionRoundDirection = 844 */
    public boolean hasDiscretionRoundDirection();
    /* DiscretionRoundDirection = 844 */
    public DiscretionRoundDirection discretionRoundDirectionAsEnum();
    /* DiscretionScope = 846 */
    public int discretionScope();
    /* DiscretionScope = 846 */
    public boolean hasDiscretionScope();
    /* DiscretionScope = 846 */
    public DiscretionScope discretionScopeAsEnum();

}
