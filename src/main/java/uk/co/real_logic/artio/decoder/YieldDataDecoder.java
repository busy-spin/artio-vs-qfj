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
import uk.co.real_logic.artio.builder.YieldDataEncoder;
import uk.co.real_logic.artio.dictionary.Generated;

@Generated("uk.co.real_logic.artio")
public interface YieldDataDecoder 
{

    /* YieldType = 235 */
    public char[] yieldType();
    /* YieldType = 235 */
    public boolean hasYieldType();
    /* YieldType = 235 */
    public int yieldTypeLength();
    /* YieldType = 235 */
    public YieldType yieldTypeAsEnum();
    /* YieldType = 235 */
    public AsciiSequenceView yieldType(AsciiSequenceView view);
    /* Yield = 236 */
    public DecimalFloat yield();
    /* Yield = 236 */
    public boolean hasYield();
    /* YieldCalcDate = 701 */
    public byte[] yieldCalcDate();
    /* YieldCalcDate = 701 */
    public boolean hasYieldCalcDate();
    /* YieldCalcDate = 701 */
    public int yieldCalcDateLength();
    /* YieldCalcDate = 701 */
    public AsciiSequenceView yieldCalcDate(AsciiSequenceView view);
    /* YieldRedemptionDate = 696 */
    public byte[] yieldRedemptionDate();
    /* YieldRedemptionDate = 696 */
    public boolean hasYieldRedemptionDate();
    /* YieldRedemptionDate = 696 */
    public int yieldRedemptionDateLength();
    /* YieldRedemptionDate = 696 */
    public AsciiSequenceView yieldRedemptionDate(AsciiSequenceView view);
    /* YieldRedemptionPrice = 697 */
    public DecimalFloat yieldRedemptionPrice();
    /* YieldRedemptionPrice = 697 */
    public boolean hasYieldRedemptionPrice();
    /* YieldRedemptionPriceType = 698 */
    public int yieldRedemptionPriceType();
    /* YieldRedemptionPriceType = 698 */
    public boolean hasYieldRedemptionPriceType();

}
