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
public enum PartyRole implements IntRepresentable
{
    EXECUTING_FIRM(1),
    BROKER_OF_CREDIT(2),
    CLIENT_ID(3),
    CLEARING_FIRM(4),
    INVESTOR_ID(5),
    INTRODUCING_FIRM(6),
    ENTERING_FIRM(7),
    LOCATE_LENDING_FIRM(8),
    FUND_MANAGER_CLIENT_ID(9),
    NULL_VAL(-2147483648),
    ARTIO_UNKNOWN(2147483647);

    private final int representation;

    PartyRole(final int representation)
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
    public static PartyRole decode(final int representation)
    {
        switch(representation)
        {
        case 1: return EXECUTING_FIRM;
        case 2: return BROKER_OF_CREDIT;
        case 3: return CLIENT_ID;
        case 4: return CLEARING_FIRM;
        case 5: return INVESTOR_ID;
        case 6: return INTRODUCING_FIRM;
        case 7: return ENTERING_FIRM;
        case 8: return LOCATE_LENDING_FIRM;
        case 9: return FUND_MANAGER_CLIENT_ID;
        default:
            return ARTIO_UNKNOWN;
        }
    }
}
