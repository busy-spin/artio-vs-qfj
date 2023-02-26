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
import uk.co.real_logic.artio.builder.FinancingDetailsEncoder;
import uk.co.real_logic.artio.dictionary.Generated;

@Generated("uk.co.real_logic.artio")
public interface FinancingDetailsDecoder 
{

    /* AgreementDesc = 913 */
    public char[] agreementDesc();
    /* AgreementDesc = 913 */
    public boolean hasAgreementDesc();
    /* AgreementDesc = 913 */
    public int agreementDescLength();
    /* AgreementDesc = 913 */
    public AsciiSequenceView agreementDesc(AsciiSequenceView view);
    /* AgreementID = 914 */
    public char[] agreementID();
    /* AgreementID = 914 */
    public boolean hasAgreementID();
    /* AgreementID = 914 */
    public int agreementIDLength();
    /* AgreementID = 914 */
    public AsciiSequenceView agreementID(AsciiSequenceView view);
    /* AgreementDate = 915 */
    public byte[] agreementDate();
    /* AgreementDate = 915 */
    public boolean hasAgreementDate();
    /* AgreementDate = 915 */
    public int agreementDateLength();
    /* AgreementDate = 915 */
    public AsciiSequenceView agreementDate(AsciiSequenceView view);
    /* AgreementCurrency = 918 */
    public char[] agreementCurrency();
    /* AgreementCurrency = 918 */
    public boolean hasAgreementCurrency();
    /* AgreementCurrency = 918 */
    public int agreementCurrencyLength();
    /* AgreementCurrency = 918 */
    public AsciiSequenceView agreementCurrency(AsciiSequenceView view);
    /* TerminationType = 788 */
    public int terminationType();
    /* TerminationType = 788 */
    public boolean hasTerminationType();
    /* TerminationType = 788 */
    public TerminationType terminationTypeAsEnum();
    /* StartDate = 916 */
    public byte[] startDate();
    /* StartDate = 916 */
    public boolean hasStartDate();
    /* StartDate = 916 */
    public int startDateLength();
    /* StartDate = 916 */
    public AsciiSequenceView startDate(AsciiSequenceView view);
    /* EndDate = 917 */
    public byte[] endDate();
    /* EndDate = 917 */
    public boolean hasEndDate();
    /* EndDate = 917 */
    public int endDateLength();
    /* EndDate = 917 */
    public AsciiSequenceView endDate(AsciiSequenceView view);
    /* DeliveryType = 919 */
    public int deliveryType();
    /* DeliveryType = 919 */
    public boolean hasDeliveryType();
    /* DeliveryType = 919 */
    public DeliveryType deliveryTypeAsEnum();
    /* MarginRatio = 898 */
    public DecimalFloat marginRatio();
    /* MarginRatio = 898 */
    public boolean hasMarginRatio();

}
