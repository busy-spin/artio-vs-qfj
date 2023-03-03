/* Generated Fix Gateway message codec */
package uk.co.real_logic.artio;

import uk.co.real_logic.artio.dictionary.CharArrayMap;
import uk.co.real_logic.artio.dictionary.CharArrayWrapper;
import org.agrona.collections.IntHashSet;
import java.util.Map;
import java.util.HashMap;
import uk.co.real_logic.artio.builder.CharRepresentable;
import uk.co.real_logic.artio.dictionary.Generated;

@Generated("uk.co.real_logic.artio")
public enum MassCancelRejectReason implements CharRepresentable
{
    MASS_CANCEL_NOT_SUPPORTED('0'),
    INVALID_OR_UNKNOWN_SECURITY('1'),
    INVALID_OR_UNKNOWN_UNDERLYING('2'),
    INVALID_OR_UNKNOWN_PRODUCT('3'),
    INVALID_OR_UNKNOWN_CFICODE('4'),
    INVALID_OR_UNKNOWN_SECURITY_TYPE('5'),
    INVALID_OR_UNKNOWN_TRADING_SESSION('6'),
    NULL_VAL(''),
    ARTIO_UNKNOWN('');

    private final char representation;

    MassCancelRejectReason(final char representation)
    {
         this.representation = representation;
    }

    public final char representation() { return representation; }

    private static final IntHashSet intSet = new IntHashSet(14);
        static
    {
        intSet.add('0');
        intSet.add('1');
        intSet.add('2');
        intSet.add('3');
        intSet.add('4');
        intSet.add('5');
        intSet.add('6');
    }



    public static boolean isValid(final int representation)
    {
        return intSet.contains(representation);
    }
    public static MassCancelRejectReason decode(final int representation)
    {
        switch(representation)
        {
        case '0': return MASS_CANCEL_NOT_SUPPORTED;
        case '1': return INVALID_OR_UNKNOWN_SECURITY;
        case '2': return INVALID_OR_UNKNOWN_UNDERLYING;
        case '3': return INVALID_OR_UNKNOWN_PRODUCT;
        case '4': return INVALID_OR_UNKNOWN_CFICODE;
        case '5': return INVALID_OR_UNKNOWN_SECURITY_TYPE;
        case '6': return INVALID_OR_UNKNOWN_TRADING_SESSION;
        default:
            return ARTIO_UNKNOWN;
        }
    }
}
