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
public enum PosReqResult implements IntRepresentable
{
    VALID_REQUEST(0),
    INVALID_OR_UNSUPPORTED_REQUEST(1),
    NO_POSITIONS_FOUND_THAT_MATCH_CRITERIA(2),
    NOT_AUTHORIZED_TO_REQUEST_POSITIONS(3),
    REQUEST_FOR_POSITION_NOT_SUPPORTED(4),
    NULL_VAL(-2147483648),
    ARTIO_UNKNOWN(2147483647);

    private final int representation;

    PosReqResult(final int representation)
    {
         this.representation = representation;
    }

    public final int representation() { return representation; }

    private static final IntHashSet intSet = new IntHashSet(10);
        static
    {
        intSet.add(0);
        intSet.add(1);
        intSet.add(2);
        intSet.add(3);
        intSet.add(4);
    }



    public static boolean isValid(final int representation)
    {
        return intSet.contains(representation);
    }
    public static PosReqResult decode(final int representation)
    {
        switch(representation)
        {
        case 0: return VALID_REQUEST;
        case 1: return INVALID_OR_UNSUPPORTED_REQUEST;
        case 2: return NO_POSITIONS_FOUND_THAT_MATCH_CRITERIA;
        case 3: return NOT_AUTHORIZED_TO_REQUEST_POSITIONS;
        case 4: return REQUEST_FOR_POSITION_NOT_SUPPORTED;
        default:
            return ARTIO_UNKNOWN;
        }
    }
}
