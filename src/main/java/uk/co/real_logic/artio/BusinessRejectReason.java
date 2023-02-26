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
public enum BusinessRejectReason implements IntRepresentable
{
    OTHER(0),
    UNKOWN_ID(1),
    UNKNOWN_SECURITY(2),
    UNSUPPORTED_MESSAGE_TYPE(3),
    APPLICATION_NOT_AVAILABLE(4),
    CONDITIONALLY_REQUIRED_FIELD_MISSING(5),
    NOT_AUTHORIZED(6),
    DELIVERTO_FIRM_NOT_AVAILABLE_AT_THIS_TIME(7),
    NULL_VAL(-2147483648),
    ARTIO_UNKNOWN(2147483647);

    private final int representation;

    BusinessRejectReason(final int representation)
    {
         this.representation = representation;
    }

    public final int representation() { return representation; }

    private static final IntHashSet intSet = new IntHashSet(16);
        static
    {
        intSet.add(0);
        intSet.add(1);
        intSet.add(2);
        intSet.add(3);
        intSet.add(4);
        intSet.add(5);
        intSet.add(6);
        intSet.add(7);
    }



    public static boolean isValid(final int representation)
    {
        return intSet.contains(representation);
    }
    public static BusinessRejectReason decode(final int representation)
    {
        switch(representation)
        {
        case 0: return OTHER;
        case 1: return UNKOWN_ID;
        case 2: return UNKNOWN_SECURITY;
        case 3: return UNSUPPORTED_MESSAGE_TYPE;
        case 4: return APPLICATION_NOT_AVAILABLE;
        case 5: return CONDITIONALLY_REQUIRED_FIELD_MISSING;
        case 6: return NOT_AUTHORIZED;
        case 7: return DELIVERTO_FIRM_NOT_AVAILABLE_AT_THIS_TIME;
        default:
            return ARTIO_UNKNOWN;
        }
    }
}
