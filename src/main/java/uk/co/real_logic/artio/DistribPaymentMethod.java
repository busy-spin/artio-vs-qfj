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
public enum DistribPaymentMethod implements IntRepresentable
{
    CREST(1),
    NSCC(2),
    EUROCLEAR(3),
    CLEARSTREAM(4),
    CHEQUE(5),
    TELEGRAPHIC_TRANSFER(6),
    FEDWIRE(7),
    DIRECT_CREDIT(8),
    ACH_CREDIT(9),
    NULL_VAL(-2147483648),
    ARTIO_UNKNOWN(2147483647);

    private final int representation;

    DistribPaymentMethod(final int representation)
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
    public static DistribPaymentMethod decode(final int representation)
    {
        switch(representation)
        {
        case 1: return CREST;
        case 2: return NSCC;
        case 3: return EUROCLEAR;
        case 4: return CLEARSTREAM;
        case 5: return CHEQUE;
        case 6: return TELEGRAPHIC_TRANSFER;
        case 7: return FEDWIRE;
        case 8: return DIRECT_CREDIT;
        case 9: return ACH_CREDIT;
        default:
            return ARTIO_UNKNOWN;
        }
    }
}
