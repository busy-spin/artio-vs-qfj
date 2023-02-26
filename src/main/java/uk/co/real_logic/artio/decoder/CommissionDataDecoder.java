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
import uk.co.real_logic.artio.builder.CommissionDataEncoder;
import uk.co.real_logic.artio.dictionary.Generated;

@Generated("uk.co.real_logic.artio")
public interface CommissionDataDecoder 
{

    /* Commission = 12 */
    public DecimalFloat commission();
    /* Commission = 12 */
    public boolean hasCommission();
    /* CommType = 13 */
    public char commType();
    /* CommType = 13 */
    public boolean hasCommType();
    /* CommType = 13 */
    public CommType commTypeAsEnum();
    /* CommCurrency = 479 */
    public char[] commCurrency();
    /* CommCurrency = 479 */
    public boolean hasCommCurrency();
    /* CommCurrency = 479 */
    public int commCurrencyLength();
    /* CommCurrency = 479 */
    public AsciiSequenceView commCurrency(AsciiSequenceView view);
    /* FundRenewWaiv = 497 */
    public char fundRenewWaiv();
    /* FundRenewWaiv = 497 */
    public boolean hasFundRenewWaiv();
    /* FundRenewWaiv = 497 */
    public FundRenewWaiv fundRenewWaivAsEnum();

}
