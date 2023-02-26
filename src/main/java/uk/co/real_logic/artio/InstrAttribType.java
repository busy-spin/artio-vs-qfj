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
public enum InstrAttribType implements IntRepresentable
{
    FLAT(1),
    ZERO_COUPON(2),
    INTEREST_BEARING(3),
    NO_PERIODIC_PAYMENTS(4),
    VARIABLE_RATE(5),
    LESS_FEE_FOR_PUT(6),
    STEPPED_COUPON(7),
    COUPON_PERIOD(8),
    WHEN_AND_IF_ISSUED(9),
    NULL_VAL(-2147483648),
    ARTIO_UNKNOWN(2147483647);

    private final int representation;

    InstrAttribType(final int representation)
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
    public static InstrAttribType decode(final int representation)
    {
        switch(representation)
        {
        case 1: return FLAT;
        case 2: return ZERO_COUPON;
        case 3: return INTEREST_BEARING;
        case 4: return NO_PERIODIC_PAYMENTS;
        case 5: return VARIABLE_RATE;
        case 6: return LESS_FEE_FOR_PUT;
        case 7: return STEPPED_COUPON;
        case 8: return COUPON_PERIOD;
        case 9: return WHEN_AND_IF_ISSUED;
        default:
            return ARTIO_UNKNOWN;
        }
    }
}
