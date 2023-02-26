/* Generated Fix Gateway message codec */
package uk.co.real_logic.artio.builder;

import uk.co.real_logic.artio.dictionary.Generated;
import org.agrona.MutableDirectBuffer;
import org.agrona.AsciiSequenceView;
import static uk.co.real_logic.artio.dictionary.generation.CodecUtil.*;
import static uk.co.real_logic.artio.dictionary.SessionConstants.*;
import uk.co.real_logic.artio.builder.Encoder;
import uk.co.real_logic.artio.fields.ReadOnlyDecimalFloat;
import uk.co.real_logic.artio.fields.DecimalFloat;
import uk.co.real_logic.artio.util.MutableAsciiBuffer;
import uk.co.real_logic.artio.util.AsciiBuffer;
import uk.co.real_logic.artio.fields.LocalMktDateEncoder;
import uk.co.real_logic.artio.fields.UtcTimestampEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import uk.co.real_logic.artio.dictionary.CharArraySet;
import org.agrona.collections.IntHashSet;
import org.agrona.collections.IntHashSet.IntIterator;
import uk.co.real_logic.artio.EncodingException;
import uk.co.real_logic.artio.dictionary.CharArrayWrapper;
import org.agrona.DirectBuffer;
import org.agrona.MutableDirectBuffer;
import org.agrona.concurrent.UnsafeBuffer;
import org.agrona.AsciiSequenceView;
import static java.nio.charset.StandardCharsets.US_ASCII;
import static uk.co.real_logic.artio.builder.Validation.CODEC_VALIDATION_ENABLED;
import static uk.co.real_logic.artio.builder.RejectUnknownField.CODEC_REJECT_UNKNOWN_FIELD_ENABLED;
import static uk.co.real_logic.artio.builder.RejectUnknownEnumValue.CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED;
import uk.co.real_logic.artio.*;

@Generated("uk.co.real_logic.artio")
public class SettlPartiesEncoder
{
    private static final int noSettlPartyIDsGroupCounterHeaderLength = 4;
    private static final byte[] noSettlPartyIDsGroupCounterHeader = new byte[] {55, 56, 49, (byte) '='};


@Generated("uk.co.real_logic.artio")
public static class SettlPartyIDsGroupEncoder
{
    private SettlPartyIDsGroupEncoder next = null;

    public SettlPartyIDsGroupEncoder next()
    {
        if (next == null)
        {
            next = new SettlPartyIDsGroupEncoder();
        }
        return next;
    }

    private static final int settlPartyIDHeaderLength = 4;
    private static final byte[] settlPartyIDHeader = new byte[] {55, 56, 50, (byte) '='};

    private static final int settlPartyIDSourceHeaderLength = 4;
    private static final byte[] settlPartyIDSourceHeader = new byte[] {55, 56, 51, (byte) '='};

    private static final int settlPartyRoleHeaderLength = 4;
    private static final byte[] settlPartyRoleHeader = new byte[] {55, 56, 52, (byte) '='};

    private static final int noSettlPartySubIDsGroupCounterHeaderLength = 4;
    private static final byte[] noSettlPartySubIDsGroupCounterHeader = new byte[] {56, 48, 49, (byte) '='};

    private final MutableDirectBuffer settlPartyID = new UnsafeBuffer();

    private int settlPartyIDOffset = 0;

    private int settlPartyIDLength = 0;

    /* SettlPartyID = 782 */
    public SettlPartyIDsGroupEncoder settlPartyID(final DirectBuffer value, final int offset, final int length)
    {
        settlPartyID.wrap(value);
        settlPartyIDOffset = offset;
        settlPartyIDLength = length;
        return this;
    }

    /* SettlPartyID = 782 */
    public SettlPartyIDsGroupEncoder settlPartyID(final DirectBuffer value, final int length)
    {
        return settlPartyID(value, 0, length);
    }

    /* SettlPartyID = 782 */
    public SettlPartyIDsGroupEncoder settlPartyID(final DirectBuffer value)
    {
        return settlPartyID(value, 0, value.capacity());
    }

    /* SettlPartyID = 782 */
    public SettlPartyIDsGroupEncoder settlPartyID(final byte[] value, final int offset, final int length)
    {
        settlPartyID.wrap(value);
        settlPartyIDOffset = offset;
        settlPartyIDLength = length;
        return this;
    }

    /* SettlPartyID = 782 */
    public SettlPartyIDsGroupEncoder settlPartyIDAsCopy(final byte[] value, final int offset, final int length)
    {
        copyInto(settlPartyID, value, offset, length);
        settlPartyIDOffset = offset;
        settlPartyIDLength = length;
        return this;
    }

    /* SettlPartyID = 782 */
    public SettlPartyIDsGroupEncoder settlPartyID(final byte[] value, final int length)
    {
        return settlPartyID(value, 0, length);
    }

    /* SettlPartyID = 782 */
    public SettlPartyIDsGroupEncoder settlPartyID(final byte[] value)
    {
        return settlPartyID(value, 0, value.length);
    }

    /* SettlPartyID = 782 */
    public boolean hasSettlPartyID()
    {
        return settlPartyIDLength > 0;
    }

    /* SettlPartyID = 782 */
    public MutableDirectBuffer settlPartyID()
    {
        return settlPartyID;
    }

    /* SettlPartyID = 782 */
    public String settlPartyIDAsString()
    {
        return settlPartyID.getStringWithoutLengthAscii(settlPartyIDOffset, settlPartyIDLength);
    }

    /* SettlPartyID = 782 */
    public SettlPartyIDsGroupEncoder settlPartyID(final CharSequence value)
    {
        toBytes(value, settlPartyID);
        settlPartyIDOffset = 0;
        settlPartyIDLength = value.length();
        return this;
    }

    /* SettlPartyID = 782 */
    public SettlPartyIDsGroupEncoder settlPartyID(final AsciiSequenceView value)
    {
        final DirectBuffer buffer = value.buffer();
        if (buffer != null)
        {
            settlPartyID.wrap(buffer);
            settlPartyIDOffset = value.offset();
            settlPartyIDLength = value.length();
        }
        return this;
    }

    /* SettlPartyID = 782 */
    public SettlPartyIDsGroupEncoder settlPartyID(final char[] value)
    {
        return settlPartyID(value, 0, value.length);
    }

    /* SettlPartyID = 782 */
    public SettlPartyIDsGroupEncoder settlPartyID(final char[] value, final int length)
    {
        return settlPartyID(value, 0, length);
    }

    /* SettlPartyID = 782 */
    public SettlPartyIDsGroupEncoder settlPartyID(final char[] value, final int offset, final int length)
    {
        toBytes(value, settlPartyID, offset, length);
        settlPartyIDOffset = 0;
        settlPartyIDLength = length;
        return this;
    }

    private char settlPartyIDSource;

    private boolean hasSettlPartyIDSource;

    public boolean hasSettlPartyIDSource()
    {
        return hasSettlPartyIDSource;
    }

    /* SettlPartyIDSource = 783 */
    public SettlPartyIDsGroupEncoder settlPartyIDSource(char value)
    {
        settlPartyIDSource = value;
        hasSettlPartyIDSource = true;
        return this;
    }

    /* SettlPartyIDSource = 783 */
    public char settlPartyIDSource()
    {
        return settlPartyIDSource;
    }

    private int settlPartyRole;

    private boolean hasSettlPartyRole;

    public boolean hasSettlPartyRole()
    {
        return hasSettlPartyRole;
    }

    /* SettlPartyRole = 784 */
    public SettlPartyIDsGroupEncoder settlPartyRole(int value)
    {
        settlPartyRole = value;
        hasSettlPartyRole = true;
        return this;
    }

    /* SettlPartyRole = 784 */
    public int settlPartyRole()
    {
        return settlPartyRole;
    }


@Generated("uk.co.real_logic.artio")
public static class SettlPartySubIDsGroupEncoder
{
    private SettlPartySubIDsGroupEncoder next = null;

    public SettlPartySubIDsGroupEncoder next()
    {
        if (next == null)
        {
            next = new SettlPartySubIDsGroupEncoder();
        }
        return next;
    }

    private static final int settlPartySubIDHeaderLength = 4;
    private static final byte[] settlPartySubIDHeader = new byte[] {55, 56, 53, (byte) '='};

    private static final int settlPartySubIDTypeHeaderLength = 4;
    private static final byte[] settlPartySubIDTypeHeader = new byte[] {55, 56, 54, (byte) '='};

    private final MutableDirectBuffer settlPartySubID = new UnsafeBuffer();

    private int settlPartySubIDOffset = 0;

    private int settlPartySubIDLength = 0;

    /* SettlPartySubID = 785 */
    public SettlPartySubIDsGroupEncoder settlPartySubID(final DirectBuffer value, final int offset, final int length)
    {
        settlPartySubID.wrap(value);
        settlPartySubIDOffset = offset;
        settlPartySubIDLength = length;
        return this;
    }

    /* SettlPartySubID = 785 */
    public SettlPartySubIDsGroupEncoder settlPartySubID(final DirectBuffer value, final int length)
    {
        return settlPartySubID(value, 0, length);
    }

    /* SettlPartySubID = 785 */
    public SettlPartySubIDsGroupEncoder settlPartySubID(final DirectBuffer value)
    {
        return settlPartySubID(value, 0, value.capacity());
    }

    /* SettlPartySubID = 785 */
    public SettlPartySubIDsGroupEncoder settlPartySubID(final byte[] value, final int offset, final int length)
    {
        settlPartySubID.wrap(value);
        settlPartySubIDOffset = offset;
        settlPartySubIDLength = length;
        return this;
    }

    /* SettlPartySubID = 785 */
    public SettlPartySubIDsGroupEncoder settlPartySubIDAsCopy(final byte[] value, final int offset, final int length)
    {
        copyInto(settlPartySubID, value, offset, length);
        settlPartySubIDOffset = offset;
        settlPartySubIDLength = length;
        return this;
    }

    /* SettlPartySubID = 785 */
    public SettlPartySubIDsGroupEncoder settlPartySubID(final byte[] value, final int length)
    {
        return settlPartySubID(value, 0, length);
    }

    /* SettlPartySubID = 785 */
    public SettlPartySubIDsGroupEncoder settlPartySubID(final byte[] value)
    {
        return settlPartySubID(value, 0, value.length);
    }

    /* SettlPartySubID = 785 */
    public boolean hasSettlPartySubID()
    {
        return settlPartySubIDLength > 0;
    }

    /* SettlPartySubID = 785 */
    public MutableDirectBuffer settlPartySubID()
    {
        return settlPartySubID;
    }

    /* SettlPartySubID = 785 */
    public String settlPartySubIDAsString()
    {
        return settlPartySubID.getStringWithoutLengthAscii(settlPartySubIDOffset, settlPartySubIDLength);
    }

    /* SettlPartySubID = 785 */
    public SettlPartySubIDsGroupEncoder settlPartySubID(final CharSequence value)
    {
        toBytes(value, settlPartySubID);
        settlPartySubIDOffset = 0;
        settlPartySubIDLength = value.length();
        return this;
    }

    /* SettlPartySubID = 785 */
    public SettlPartySubIDsGroupEncoder settlPartySubID(final AsciiSequenceView value)
    {
        final DirectBuffer buffer = value.buffer();
        if (buffer != null)
        {
            settlPartySubID.wrap(buffer);
            settlPartySubIDOffset = value.offset();
            settlPartySubIDLength = value.length();
        }
        return this;
    }

    /* SettlPartySubID = 785 */
    public SettlPartySubIDsGroupEncoder settlPartySubID(final char[] value)
    {
        return settlPartySubID(value, 0, value.length);
    }

    /* SettlPartySubID = 785 */
    public SettlPartySubIDsGroupEncoder settlPartySubID(final char[] value, final int length)
    {
        return settlPartySubID(value, 0, length);
    }

    /* SettlPartySubID = 785 */
    public SettlPartySubIDsGroupEncoder settlPartySubID(final char[] value, final int offset, final int length)
    {
        toBytes(value, settlPartySubID, offset, length);
        settlPartySubIDOffset = 0;
        settlPartySubIDLength = length;
        return this;
    }

    private int settlPartySubIDType;

    private boolean hasSettlPartySubIDType;

    public boolean hasSettlPartySubIDType()
    {
        return hasSettlPartySubIDType;
    }

    /* SettlPartySubIDType = 786 */
    public SettlPartySubIDsGroupEncoder settlPartySubIDType(int value)
    {
        settlPartySubIDType = value;
        hasSettlPartySubIDType = true;
        return this;
    }

    /* SettlPartySubIDType = 786 */
    public int settlPartySubIDType()
    {
        return settlPartySubIDType;
    }

    public int encode(final MutableAsciiBuffer buffer, final int offset, final int remainingElements)
    {
        if (remainingElements == 0)
        {
            return 0;
        }

        int position = offset;

        if (settlPartySubIDLength > 0)
        {
            buffer.putBytes(position, settlPartySubIDHeader, 0, settlPartySubIDHeaderLength);
            position += settlPartySubIDHeaderLength;
            buffer.putBytes(position, settlPartySubID, settlPartySubIDOffset, settlPartySubIDLength);
            position += settlPartySubIDLength;
            buffer.putSeparator(position);
            position++;
        }

        if (hasSettlPartySubIDType)
        {
            buffer.putBytes(position, settlPartySubIDTypeHeader, 0, settlPartySubIDTypeHeaderLength);
            position += settlPartySubIDTypeHeaderLength;
            position += buffer.putIntAscii(position, settlPartySubIDType);
            buffer.putSeparator(position);
            position++;
        }
        if (next != null)
        {
            position += next.encode(buffer, position, remainingElements - 1);
        }
        return position - offset;
    }

    public void reset()
    {
        this.resetSettlPartySubID();
        this.resetSettlPartySubIDType();
        if (next != null)        {
            next.reset();
        }
    }

    public void resetSettlPartySubID()
    {
        settlPartySubIDLength = 0;
    }

    public void resetSettlPartySubIDType()
    {
        hasSettlPartySubIDType = false;
    }

    public String toString()
    {
        return appendTo(new StringBuilder()).toString();
    }

    public StringBuilder appendTo(final StringBuilder builder)
    {
        return appendTo(builder, 1);
    }

    public StringBuilder appendTo(final StringBuilder builder, final int level)
    {
        builder.append("{\n");        indent(builder, level);
        builder.append("\"MessageName\": \"SettlPartySubIDsGroup\",\n");
        if (hasSettlPartySubID())
        {
            indent(builder, level);
            builder.append("\"SettlPartySubID\": \"");
            appendBuffer(builder, settlPartySubID, settlPartySubIDOffset, settlPartySubIDLength);
            builder.append("\",\n");
        }

        if (hasSettlPartySubIDType())
        {
            indent(builder, level);
            builder.append("\"SettlPartySubIDType\": \"");
            builder.append(settlPartySubIDType);
            builder.append("\",\n");
        }
        indent(builder, level - 1);
        builder.append("}");
        return builder;
    }

    /**
     * {@inheritDoc}
     */
    public SettlPartySubIDsGroupEncoder copyTo(final Encoder encoder)
    {
        return copyTo((SettlPartySubIDsGroupEncoder)encoder);
    }

    public SettlPartySubIDsGroupEncoder copyTo(final SettlPartySubIDsGroupEncoder encoder)
    {
        encoder.reset();
        if (hasSettlPartySubID())
        {
            encoder.settlPartySubIDAsCopy(settlPartySubID.byteArray(), 0, settlPartySubIDLength);
        }

        if (hasSettlPartySubIDType())
        {
            encoder.settlPartySubIDType(this.settlPartySubIDType());
        }
        return encoder;
    }

}
    private int noSettlPartySubIDsGroupCounter;

    private boolean hasNoSettlPartySubIDsGroupCounter;

    public boolean hasNoSettlPartySubIDsGroupCounter()
    {
        return hasNoSettlPartySubIDsGroupCounter;
    }

    /* NoSettlPartySubIDsGroupCounter = 801 */
    public SettlPartyIDsGroupEncoder noSettlPartySubIDsGroupCounter(int value)
    {
        noSettlPartySubIDsGroupCounter = value;
        hasNoSettlPartySubIDsGroupCounter = true;
        return this;
    }

    /* NoSettlPartySubIDsGroupCounter = 801 */
    public int noSettlPartySubIDsGroupCounter()
    {
        return noSettlPartySubIDsGroupCounter;
    }


    private SettlPartySubIDsGroupEncoder settlPartySubIDsGroup = null;

    public SettlPartySubIDsGroupEncoder settlPartySubIDsGroup(final int numberOfElements)
    {
        hasNoSettlPartySubIDsGroupCounter = true;
        noSettlPartySubIDsGroupCounter = numberOfElements;
        if (settlPartySubIDsGroup == null)
        {
            settlPartySubIDsGroup = new SettlPartySubIDsGroupEncoder();
        }
        return settlPartySubIDsGroup;
    }

    public int encode(final MutableAsciiBuffer buffer, final int offset, final int remainingElements)
    {
        if (remainingElements == 0)
        {
            return 0;
        }

        int position = offset;

        if (settlPartyIDLength > 0)
        {
            buffer.putBytes(position, settlPartyIDHeader, 0, settlPartyIDHeaderLength);
            position += settlPartyIDHeaderLength;
            buffer.putBytes(position, settlPartyID, settlPartyIDOffset, settlPartyIDLength);
            position += settlPartyIDLength;
            buffer.putSeparator(position);
            position++;
        }

        if (hasSettlPartyIDSource)
        {
            buffer.putBytes(position, settlPartyIDSourceHeader, 0, settlPartyIDSourceHeaderLength);
            position += settlPartyIDSourceHeaderLength;
            position += buffer.putCharAscii(position, settlPartyIDSource);
            buffer.putSeparator(position);
            position++;
        }

        if (hasSettlPartyRole)
        {
            buffer.putBytes(position, settlPartyRoleHeader, 0, settlPartyRoleHeaderLength);
            position += settlPartyRoleHeaderLength;
            position += buffer.putIntAscii(position, settlPartyRole);
            buffer.putSeparator(position);
            position++;
        }

        if (hasNoSettlPartySubIDsGroupCounter)
        {
            buffer.putBytes(position, noSettlPartySubIDsGroupCounterHeader, 0, noSettlPartySubIDsGroupCounterHeaderLength);
            position += noSettlPartySubIDsGroupCounterHeaderLength;
            position += buffer.putIntAscii(position, noSettlPartySubIDsGroupCounter);
            buffer.putSeparator(position);
            position++;
        }

        if (settlPartySubIDsGroup != null)
        {
            position += settlPartySubIDsGroup.encode(buffer, position, noSettlPartySubIDsGroupCounter);
        }

        if (next != null)
        {
            position += next.encode(buffer, position, remainingElements - 1);
        }
        return position - offset;
    }

    public void reset()
    {
        this.resetSettlPartyID();
        this.resetSettlPartyIDSource();
        this.resetSettlPartyRole();
        this.resetSettlPartySubIDsGroup();
        if (next != null)        {
            next.reset();
        }
    }

    public void resetSettlPartyID()
    {
        settlPartyIDLength = 0;
    }

    public void resetSettlPartyIDSource()
    {
        hasSettlPartyIDSource = false;
    }

    public void resetSettlPartyRole()
    {
        hasSettlPartyRole = false;
    }

    public void resetSettlPartySubIDsGroup()
    {
        if (settlPartySubIDsGroup != null)
        {
            settlPartySubIDsGroup.reset();
        }
        noSettlPartySubIDsGroupCounter = 0;
        hasNoSettlPartySubIDsGroupCounter = false;
    }

    public String toString()
    {
        return appendTo(new StringBuilder()).toString();
    }

    public StringBuilder appendTo(final StringBuilder builder)
    {
        return appendTo(builder, 1);
    }

    public StringBuilder appendTo(final StringBuilder builder, final int level)
    {
        builder.append("{\n");        indent(builder, level);
        builder.append("\"MessageName\": \"SettlPartyIDsGroup\",\n");
        if (hasSettlPartyID())
        {
            indent(builder, level);
            builder.append("\"SettlPartyID\": \"");
            appendBuffer(builder, settlPartyID, settlPartyIDOffset, settlPartyIDLength);
            builder.append("\",\n");
        }

        if (hasSettlPartyIDSource())
        {
            indent(builder, level);
            builder.append("\"SettlPartyIDSource\": \"");
            builder.append(settlPartyIDSource);
            builder.append("\",\n");
        }

        if (hasSettlPartyRole())
        {
            indent(builder, level);
            builder.append("\"SettlPartyRole\": \"");
            builder.append(settlPartyRole);
            builder.append("\",\n");
        }

        if (hasNoSettlPartySubIDsGroupCounter)
        {
            indent(builder, level);
            builder.append("\"SettlPartySubIDsGroup\": [\n");
            final int noSettlPartySubIDsGroupCounter = this.noSettlPartySubIDsGroupCounter;
            SettlPartySubIDsGroupEncoder settlPartySubIDsGroup = this.settlPartySubIDsGroup;
            for (int i = 0; i < noSettlPartySubIDsGroupCounter; i++)
            {
                indent(builder, level);
                settlPartySubIDsGroup.appendTo(builder, level + 1);
                if (i < (noSettlPartySubIDsGroupCounter - 1))
                {
                    builder.append(',');
                }
                builder.append('\n');
                settlPartySubIDsGroup = settlPartySubIDsGroup.next();
            }
            indent(builder, level);
            builder.append("],\n");
        }
        indent(builder, level - 1);
        builder.append("}");
        return builder;
    }

    /**
     * {@inheritDoc}
     */
    public SettlPartyIDsGroupEncoder copyTo(final Encoder encoder)
    {
        return copyTo((SettlPartyIDsGroupEncoder)encoder);
    }

    public SettlPartyIDsGroupEncoder copyTo(final SettlPartyIDsGroupEncoder encoder)
    {
        encoder.reset();
        if (hasSettlPartyID())
        {
            encoder.settlPartyIDAsCopy(settlPartyID.byteArray(), 0, settlPartyIDLength);
        }

        if (hasSettlPartyIDSource())
        {
            encoder.settlPartyIDSource(this.settlPartyIDSource());
        }

        if (hasSettlPartyRole())
        {
            encoder.settlPartyRole(this.settlPartyRole());
        }

        if (hasNoSettlPartySubIDsGroupCounter)
        {
            final int size = this.noSettlPartySubIDsGroupCounter;
            SettlPartySubIDsGroupEncoder settlPartySubIDsGroup = this.settlPartySubIDsGroup;
            SettlPartySubIDsGroupEncoder settlPartySubIDsGroupEncoder = encoder.settlPartySubIDsGroup(size);
            for (int i = 0; i < size; i++)
            {
                if (settlPartySubIDsGroup != null)
                {
                    settlPartySubIDsGroup.copyTo(settlPartySubIDsGroupEncoder);
                    settlPartySubIDsGroup = settlPartySubIDsGroup.next();
                    settlPartySubIDsGroupEncoder = settlPartySubIDsGroupEncoder.next();
                }
            }
        }
        return encoder;
    }

}
    private int noSettlPartyIDsGroupCounter;

    private boolean hasNoSettlPartyIDsGroupCounter;

    public boolean hasNoSettlPartyIDsGroupCounter()
    {
        return hasNoSettlPartyIDsGroupCounter;
    }

    /* NoSettlPartyIDsGroupCounter = 781 */
    public SettlPartiesEncoder noSettlPartyIDsGroupCounter(int value)
    {
        noSettlPartyIDsGroupCounter = value;
        hasNoSettlPartyIDsGroupCounter = true;
        return this;
    }

    /* NoSettlPartyIDsGroupCounter = 781 */
    public int noSettlPartyIDsGroupCounter()
    {
        return noSettlPartyIDsGroupCounter;
    }


    private SettlPartyIDsGroupEncoder settlPartyIDsGroup = null;

    public SettlPartyIDsGroupEncoder settlPartyIDsGroup(final int numberOfElements)
    {
        hasNoSettlPartyIDsGroupCounter = true;
        noSettlPartyIDsGroupCounter = numberOfElements;
        if (settlPartyIDsGroup == null)
        {
            settlPartyIDsGroup = new SettlPartyIDsGroupEncoder();
        }
        return settlPartyIDsGroup;
    }

    public int encode(final MutableAsciiBuffer buffer, final int offset)
    {
        int position = offset;

        if (hasNoSettlPartyIDsGroupCounter)
        {
            buffer.putBytes(position, noSettlPartyIDsGroupCounterHeader, 0, noSettlPartyIDsGroupCounterHeaderLength);
            position += noSettlPartyIDsGroupCounterHeaderLength;
            position += buffer.putIntAscii(position, noSettlPartyIDsGroupCounter);
            buffer.putSeparator(position);
            position++;
        }

        if (settlPartyIDsGroup != null)
        {
            position += settlPartyIDsGroup.encode(buffer, position, noSettlPartyIDsGroupCounter);
        }

        return position - offset;
    }

    public void reset()
    {
        this.resetSettlPartyIDsGroup();
    }

    public void resetSettlPartyIDsGroup()
    {
        if (settlPartyIDsGroup != null)
        {
            settlPartyIDsGroup.reset();
        }
        noSettlPartyIDsGroupCounter = 0;
        hasNoSettlPartyIDsGroupCounter = false;
    }

    public String toString()
    {
        return appendTo(new StringBuilder()).toString();
    }

    public StringBuilder appendTo(final StringBuilder builder)
    {
        return appendTo(builder, 1);
    }

    public StringBuilder appendTo(final StringBuilder builder, final int level)
    {
        builder.append("{\n");        indent(builder, level);
        builder.append("\"MessageName\": \"SettlParties\",\n");
        if (hasNoSettlPartyIDsGroupCounter)
        {
            indent(builder, level);
            builder.append("\"SettlPartyIDsGroup\": [\n");
            final int noSettlPartyIDsGroupCounter = this.noSettlPartyIDsGroupCounter;
            SettlPartyIDsGroupEncoder settlPartyIDsGroup = this.settlPartyIDsGroup;
            for (int i = 0; i < noSettlPartyIDsGroupCounter; i++)
            {
                indent(builder, level);
                settlPartyIDsGroup.appendTo(builder, level + 1);
                if (i < (noSettlPartyIDsGroupCounter - 1))
                {
                    builder.append(',');
                }
                builder.append('\n');
                settlPartyIDsGroup = settlPartyIDsGroup.next();
            }
            indent(builder, level);
            builder.append("],\n");
        }
        indent(builder, level - 1);
        builder.append("}");
        return builder;
    }

    /**
     * {@inheritDoc}
     */
    public SettlPartiesEncoder copyTo(final Encoder encoder)
    {
        return copyTo((SettlPartiesEncoder)encoder);
    }

    public SettlPartiesEncoder copyTo(final SettlPartiesEncoder encoder)
    {
        encoder.reset();
        if (hasNoSettlPartyIDsGroupCounter)
        {
            final int size = this.noSettlPartyIDsGroupCounter;
            SettlPartyIDsGroupEncoder settlPartyIDsGroup = this.settlPartyIDsGroup;
            SettlPartyIDsGroupEncoder settlPartyIDsGroupEncoder = encoder.settlPartyIDsGroup(size);
            for (int i = 0; i < size; i++)
            {
                if (settlPartyIDsGroup != null)
                {
                    settlPartyIDsGroup.copyTo(settlPartyIDsGroupEncoder);
                    settlPartyIDsGroup = settlPartyIDsGroup.next();
                    settlPartyIDsGroupEncoder = settlPartyIDsGroupEncoder.next();
                }
            }
        }
        return encoder;
    }

}
