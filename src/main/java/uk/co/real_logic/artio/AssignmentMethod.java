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
public enum AssignmentMethod implements CharRepresentable
{
    RANDOM('R'),
    PRORATA('P'),
    NULL_VAL(''),
    ARTIO_UNKNOWN('');

    private final char representation;

    AssignmentMethod(final char representation)
    {
         this.representation = representation;
    }

    public final char representation() { return representation; }

    private static final IntHashSet intSet = new IntHashSet(4);
        static
    {
        intSet.add('R');
        intSet.add('P');
    }



    public static boolean isValid(final int representation)
    {
        return intSet.contains(representation);
    }
    public static AssignmentMethod decode(final int representation)
    {
        switch(representation)
        {
        case 'R': return RANDOM;
        case 'P': return PRORATA;
        default:
            return ARTIO_UNKNOWN;
        }
    }
}
