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
public enum MiscFeeType implements CharRepresentable
{
    REGULATORY('1'),
    TAX('2'),
    LOCAL_COMMISSION('3'),
    EXCHANGE_FEES('4'),
    STAMP('5'),
    LEVY('6'),
    OTHER('7'),
    MARKUP('8'),
    CONSUMPTION_TAX('9'),
    NULL_VAL(''),
    ARTIO_UNKNOWN('');

    private final char representation;

    MiscFeeType(final char representation)
    {
         this.representation = representation;
    }

    public final char representation() { return representation; }

    private static final IntHashSet intSet = new IntHashSet(18);
        static
    {
        intSet.add('1');
        intSet.add('2');
        intSet.add('3');
        intSet.add('4');
        intSet.add('5');
        intSet.add('6');
        intSet.add('7');
        intSet.add('8');
        intSet.add('9');
    }



    public static boolean isValid(final int representation)
    {
        return intSet.contains(representation);
    }
    public static MiscFeeType decode(final int representation)
    {
        switch(representation)
        {
        case '1': return REGULATORY;
        case '2': return TAX;
        case '3': return LOCAL_COMMISSION;
        case '4': return EXCHANGE_FEES;
        case '5': return STAMP;
        case '6': return LEVY;
        case '7': return OTHER;
        case '8': return MARKUP;
        case '9': return CONSUMPTION_TAX;
        default:
            return ARTIO_UNKNOWN;
        }
    }
}
