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
public enum SettlInstReqRejCode implements IntRepresentable
{
    UNABLE_TO_PROCESS_REQUEST(0),
    UNKNOWN_ACCOUNT(1),
    NO_MATCHING_SETTLEMENT_INSTRUCTIONS_FOUND(2),
    NULL_VAL(-2147483648),
    ARTIO_UNKNOWN(2147483647);

    private final int representation;

    SettlInstReqRejCode(final int representation)
    {
         this.representation = representation;
    }

    public final int representation() { return representation; }

    private static final IntHashSet intSet = new IntHashSet(6);
        static
    {
        intSet.add(0);
        intSet.add(1);
        intSet.add(2);
    }



    public static boolean isValid(final int representation)
    {
        return intSet.contains(representation);
    }
    public static SettlInstReqRejCode decode(final int representation)
    {
        switch(representation)
        {
        case 0: return UNABLE_TO_PROCESS_REQUEST;
        case 1: return UNKNOWN_ACCOUNT;
        case 2: return NO_MATCHING_SETTLEMENT_INSTRUCTIONS_FOUND;
        default:
            return ARTIO_UNKNOWN;
        }
    }
}
