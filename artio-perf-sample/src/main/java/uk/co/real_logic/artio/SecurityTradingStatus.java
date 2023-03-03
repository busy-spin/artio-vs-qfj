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
public enum SecurityTradingStatus implements IntRepresentable
{
    OPENING_DELAY(1),
    TRADING_HALT(2),
    RESUME(3),
    NO_OPEN_NO_RESUME(4),
    PRICE_INDICATION(5),
    TRADING_RANGE_INDICATION(6),
    MARKET_IMBALANCE_BUY(7),
    MARKET_IMBALANCE_SELL(8),
    MARKET_ON_CLOSE_IMBALANCE_BUY(9),
    NULL_VAL(-2147483648),
    ARTIO_UNKNOWN(2147483647);

    private final int representation;

    SecurityTradingStatus(final int representation)
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
    public static SecurityTradingStatus decode(final int representation)
    {
        switch(representation)
        {
        case 1: return OPENING_DELAY;
        case 2: return TRADING_HALT;
        case 3: return RESUME;
        case 4: return NO_OPEN_NO_RESUME;
        case 5: return PRICE_INDICATION;
        case 6: return TRADING_RANGE_INDICATION;
        case 7: return MARKET_IMBALANCE_BUY;
        case 8: return MARKET_IMBALANCE_SELL;
        case 9: return MARKET_ON_CLOSE_IMBALANCE_BUY;
        default:
            return ARTIO_UNKNOWN;
        }
    }
}
