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
public enum SettlInstMode implements CharRepresentable
{
    DEFAULT('0'),
    STANDING_INSTRUCTIONS_PROVIDED('1'),
    SPECIFIC_ORDER_FOR_A_SINGLE_ACCOUNT('4'),
    REQUEST_REJECT('5'),
    NULL_VAL(''),
    ARTIO_UNKNOWN('');

    private final char representation;

    SettlInstMode(final char representation)
    {
         this.representation = representation;
    }

    public final char representation() { return representation; }

    private static final IntHashSet intSet = new IntHashSet(8);
        static
    {
        intSet.add('0');
        intSet.add('1');
        intSet.add('4');
        intSet.add('5');
    }



    public static boolean isValid(final int representation)
    {
        return intSet.contains(representation);
    }
    public static SettlInstMode decode(final int representation)
    {
        switch(representation)
        {
        case '0': return DEFAULT;
        case '1': return STANDING_INSTRUCTIONS_PROVIDED;
        case '4': return SPECIFIC_ORDER_FOR_A_SINGLE_ACCOUNT;
        case '5': return REQUEST_REJECT;
        default:
            return ARTIO_UNKNOWN;
        }
    }
}