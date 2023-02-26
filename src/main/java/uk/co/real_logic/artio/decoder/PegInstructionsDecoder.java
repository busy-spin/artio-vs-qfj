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
import uk.co.real_logic.artio.builder.PegInstructionsEncoder;
import uk.co.real_logic.artio.dictionary.Generated;

@Generated("uk.co.real_logic.artio")
public interface PegInstructionsDecoder 
{

    /* PegOffsetValue = 211 */
    public DecimalFloat pegOffsetValue();
    /* PegOffsetValue = 211 */
    public boolean hasPegOffsetValue();
    /* PegMoveType = 835 */
    public int pegMoveType();
    /* PegMoveType = 835 */
    public boolean hasPegMoveType();
    /* PegMoveType = 835 */
    public PegMoveType pegMoveTypeAsEnum();
    /* PegOffsetType = 836 */
    public int pegOffsetType();
    /* PegOffsetType = 836 */
    public boolean hasPegOffsetType();
    /* PegOffsetType = 836 */
    public PegOffsetType pegOffsetTypeAsEnum();
    /* PegLimitType = 837 */
    public int pegLimitType();
    /* PegLimitType = 837 */
    public boolean hasPegLimitType();
    /* PegLimitType = 837 */
    public PegLimitType pegLimitTypeAsEnum();
    /* PegRoundDirection = 838 */
    public int pegRoundDirection();
    /* PegRoundDirection = 838 */
    public boolean hasPegRoundDirection();
    /* PegRoundDirection = 838 */
    public PegRoundDirection pegRoundDirectionAsEnum();
    /* PegScope = 840 */
    public int pegScope();
    /* PegScope = 840 */
    public boolean hasPegScope();
    /* PegScope = 840 */
    public PegScope pegScopeAsEnum();

}
