/* Generated Fix Gateway message codec */
package uk.co.real_logic.artio;

import uk.co.real_logic.artio.dictionary.CharArrayMap;
import uk.co.real_logic.artio.dictionary.CharArrayWrapper;
import org.agrona.collections.IntHashSet;
import java.util.Map;
import java.util.HashMap;
import uk.co.real_logic.artio.builder.IntRepresentable;
import uk.co.real_logic.artio.dictionary.Generated;

@Generated("uk.co.real_logic.artio")
public enum PriceType implements IntRepresentable
{
    PERCENTAGE(1),
    PER_UNIT(2),
    FIXED_AMOUNT(3),
    DISCOUNT(4),
    PREMIUM(5),
    SPREAD(6),
    TED_PRICE(7),
    TED_YIELD(8),
    YIELD(9),
    NULL_VAL(-2147483648),
    ARTIO_UNKNOWN(2147483647);

    private final int representation;

    PriceType(final int representation)
    {
         this.representation = representation;
    }

    public final int representation() { return representation; }

    private static final IntHashSet intSet = new IntHashSet(18);
        static
    {
        intSet.add(1);
        intSet.add(2);
        intSet.add(3);
        intSet.add(4);
        intSet.add(5);
        intSet.add(6);
        intSet.add(7);
        intSet.add(8);
        intSet.add(9);
    }



    public static boolean isValid(final int representation)
    {
        return intSet.contains(representation);
    }
    public static PriceType decode(final int representation)
    {
        switch(representation)
        {
        case 1: return PERCENTAGE;
        case 2: return PER_UNIT;
        case 3: return FIXED_AMOUNT;
        case 4: return DISCOUNT;
        case 5: return PREMIUM;
        case 6: return SPREAD;
        case 7: return TED_PRICE;
        case 8: return TED_YIELD;
        case 9: return YIELD;
        default:
            return ARTIO_UNKNOWN;
        }
    }
}
