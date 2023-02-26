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
public enum TrdRegTimestampType implements IntRepresentable
{
    EXECUTION_TIME(1),
    TIME_IN(2),
    TIME_OUT(3),
    BROKER_RECEIPT(4),
    BROKER_EXECUTION(5),
    NULL_VAL(-2147483648),
    ARTIO_UNKNOWN(2147483647);

    private final int representation;

    TrdRegTimestampType(final int representation)
    {
         this.representation = representation;
    }

    public final int representation() { return representation; }

    private static final IntHashSet intSet = new IntHashSet(10);
        static
    {
        intSet.add(1);
        intSet.add(2);
        intSet.add(3);
        intSet.add(4);
        intSet.add(5);
    }



    public static boolean isValid(final int representation)
    {
        return intSet.contains(representation);
    }
    public static TrdRegTimestampType decode(final int representation)
    {
        switch(representation)
        {
        case 1: return EXECUTION_TIME;
        case 2: return TIME_IN;
        case 3: return TIME_OUT;
        case 4: return BROKER_RECEIPT;
        case 5: return BROKER_EXECUTION;
        default:
            return ARTIO_UNKNOWN;
        }
    }
}
