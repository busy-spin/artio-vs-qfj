/* Generated Fix Gateway message codec */
package uk.co.real_logic.artio.decoder;

import org.agrona.AsciiNumberFormatException;
import uk.co.real_logic.artio.dictionary.Generated;
import org.agrona.MutableDirectBuffer;
import org.agrona.AsciiSequenceView;
import static uk.co.real_logic.artio.dictionary.generation.CodecUtil.*;
import static uk.co.real_logic.artio.dictionary.SessionConstants.*;
import uk.co.real_logic.artio.builder.Decoder;
import uk.co.real_logic.artio.decoder.HeaderDecoder;
import uk.co.real_logic.artio.decoder.TrailerDecoder;
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
import uk.co.real_logic.artio.builder.Encoder;
import uk.co.real_logic.artio.builder.CommonDecoderImpl;
import static java.nio.charset.StandardCharsets.US_ASCII;
import static uk.co.real_logic.artio.builder.Validation.CODEC_VALIDATION_ENABLED;
import static uk.co.real_logic.artio.builder.RejectUnknownField.CODEC_REJECT_UNKNOWN_FIELD_ENABLED;
import static uk.co.real_logic.artio.builder.RejectUnknownEnumValue.CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED;
import uk.co.real_logic.artio.*;
import uk.co.real_logic.artio.builder.NewOrderListEncoder;
import static uk.co.real_logic.artio.builder.NewOrderListEncoder.OrdersGroupEncoder;
import uk.co.real_logic.artio.builder.PartiesEncoder;
import static uk.co.real_logic.artio.builder.PartiesEncoder.PartyIDsGroupEncoder;
import static uk.co.real_logic.artio.builder.PartiesEncoder.PartyIDsGroupEncoder.PartySubIDsGroupEncoder;
import static uk.co.real_logic.artio.builder.NewOrderListEncoder.OrdersGroupEncoder.AllocsGroupEncoder;
import uk.co.real_logic.artio.builder.NestedPartiesEncoder;
import static uk.co.real_logic.artio.builder.NestedPartiesEncoder.NestedPartyIDsGroupEncoder;
import static uk.co.real_logic.artio.builder.NestedPartiesEncoder.NestedPartyIDsGroupEncoder.NestedPartySubIDsGroupEncoder;
import static uk.co.real_logic.artio.builder.NewOrderListEncoder.OrdersGroupEncoder.TradingSessionsGroupEncoder;
import uk.co.real_logic.artio.builder.InstrumentEncoder;
import static uk.co.real_logic.artio.builder.InstrumentEncoder.SecurityAltIDGroupEncoder;
import static uk.co.real_logic.artio.builder.InstrumentEncoder.EventsGroupEncoder;
import static uk.co.real_logic.artio.builder.NewOrderListEncoder.OrdersGroupEncoder.UnderlyingsGroupEncoder;
import uk.co.real_logic.artio.builder.UnderlyingInstrumentEncoder;
import static uk.co.real_logic.artio.builder.UnderlyingInstrumentEncoder.UnderlyingSecurityAltIDGroupEncoder;
import uk.co.real_logic.artio.builder.UnderlyingStipulationsEncoder;
import static uk.co.real_logic.artio.builder.UnderlyingStipulationsEncoder.UnderlyingStipsGroupEncoder;
import uk.co.real_logic.artio.builder.StipulationsEncoder;
import static uk.co.real_logic.artio.builder.StipulationsEncoder.StipulationsGroupEncoder;
import uk.co.real_logic.artio.builder.OrderQtyDataEncoder;
import uk.co.real_logic.artio.builder.SpreadOrBenchmarkCurveDataEncoder;
import uk.co.real_logic.artio.builder.YieldDataEncoder;
import uk.co.real_logic.artio.builder.CommissionDataEncoder;
import uk.co.real_logic.artio.builder.PegInstructionsEncoder;
import uk.co.real_logic.artio.builder.DiscretionInstructionsEncoder;

@Generated("uk.co.real_logic.artio")
public class NewOrderListDecoder extends CommonDecoderImpl implements MessageDecoder
{
    public final IntHashSet REQUIRED_FIELDS = new IntHashSet(8);

    {
        if (CODEC_VALIDATION_ENABLED)
        {
            REQUIRED_FIELDS.add(Constants.LIST_ID);
            REQUIRED_FIELDS.add(Constants.BID_TYPE);
            REQUIRED_FIELDS.add(Constants.TOT_NO_ORDERS);
            REQUIRED_FIELDS.add(Constants.NO_ORDERS_GROUP_COUNTER);
        }
    }

    public final IntHashSet GROUP_FIELDS = new IntHashSet(36);

    {
        if (CODEC_VALIDATION_ENABLED)
        {
            GROUP_FIELDS.add(Constants.LIST_ID);
            GROUP_FIELDS.add(Constants.BID_ID);
            GROUP_FIELDS.add(Constants.CLIENT_BID_ID);
            GROUP_FIELDS.add(Constants.PROG_RPT_REQS);
            GROUP_FIELDS.add(Constants.BID_TYPE);
            GROUP_FIELDS.add(Constants.PROG_PERIOD_INTERVAL);
            GROUP_FIELDS.add(Constants.CANCELLATION_RIGHTS);
            GROUP_FIELDS.add(Constants.MONEY_LAUNDERING_STATUS);
            GROUP_FIELDS.add(Constants.REGIST_ID);
            GROUP_FIELDS.add(Constants.LIST_EXEC_INST_TYPE);
            GROUP_FIELDS.add(Constants.LIST_EXEC_INST);
            GROUP_FIELDS.add(Constants.ENCODED_LIST_EXEC_INST_LEN);
            GROUP_FIELDS.add(Constants.ENCODED_LIST_EXEC_INST);
            GROUP_FIELDS.add(Constants.ALLOWABLE_ONE_SIDEDNESS_PCT);
            GROUP_FIELDS.add(Constants.ALLOWABLE_ONE_SIDEDNESS_VALUE);
            GROUP_FIELDS.add(Constants.ALLOWABLE_ONE_SIDEDNESS_CURR);
            GROUP_FIELDS.add(Constants.TOT_NO_ORDERS);
            GROUP_FIELDS.add(Constants.LAST_FRAGMENT);
        }
    }

    private final IntHashSet alreadyVisitedFields = new IntHashSet(36);

    private final IntHashSet unknownFields = new IntHashSet(10);

    private final IntHashSet missingRequiredFields = new IntHashSet(8);

    public boolean validate()
    {
        if (rejectReason != Decoder.NO_ERROR)
        {
            return false;
        }
        final IntIterator missingFieldsIterator = missingRequiredFields.iterator();
        final IntIterator unknownFieldsIterator = unknownFields.iterator();
        if (CODEC_REJECT_UNKNOWN_FIELD_ENABLED && unknownFieldsIterator.hasNext())
        {
            invalidTagId = unknownFieldsIterator.nextValue();
            rejectReason = Constants.ALL_FIELDS.contains(invalidTagId) ? 2 : 0;
            return false;
        }
        if (!header.validate())
        {
            invalidTagId = header.invalidTagId();
            rejectReason = header.rejectReason();
            return false;
        }
        else if (!trailer.validate())
        {
            invalidTagId = trailer.invalidTagId();
            rejectReason = trailer.rejectReason();
            return false;
        }
        if (missingFieldsIterator.hasNext())
        {
            invalidTagId = missingFieldsIterator.nextValue();
            rejectReason = 1;
            return false;
        }
        if (hasProgRptReqs)
        {
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !ProgRptReqs.isValid(progRptReqs()))
        {
            invalidTagId = 414;
            rejectReason = 5;
            return false;
        }
        }

        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !BidType.isValid(bidType()))
        {
            invalidTagId = 394;
            rejectReason = 5;
            return false;
        }

        if (hasCancellationRights)
        {
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !CancellationRights.isValid(cancellationRights()))
        {
            invalidTagId = 480;
            rejectReason = 5;
            return false;
        }
        }

        if (hasMoneyLaunderingStatus)
        {
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !MoneyLaunderingStatus.isValid(moneyLaunderingStatus()))
        {
            invalidTagId = 481;
            rejectReason = 5;
            return false;
        }
        }

        if (hasListExecInstType)
        {
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !ListExecInstType.isValid(listExecInstType()))
        {
            invalidTagId = 433;
            rejectReason = 5;
            return false;
        }
        }
        {
            int count = 0;
            final OrdersGroupIterator iterator = ordersGroupIterator.iterator();
            for (final OrdersGroupDecoder group : iterator)
            {
                count++;                if (!group.validate())
                {
                    invalidTagId = group.invalidTagId();
                    rejectReason = group.rejectReason();
                    return false;
                }
            }
            if (count != iterator.numberFieldValue())
            {
                invalidTagId = 73;
                rejectReason = 16;
                return false;
            }
        }
        return true;
    }

    public static final long MESSAGE_TYPE = 69L;

    public static final String MESSAGE_TYPE_AS_STRING = "E";

    public static final char[] MESSAGE_TYPE_CHARS = MESSAGE_TYPE_AS_STRING.toCharArray();

    public static final byte[] MESSAGE_TYPE_BYTES = MESSAGE_TYPE_AS_STRING.getBytes(US_ASCII);

    public final IntHashSet messageFields = new IntHashSet(544);

    {
        messageFields.add(Constants.BEGIN_STRING);
        messageFields.add(Constants.BODY_LENGTH);
        messageFields.add(Constants.MSG_TYPE);
        messageFields.add(Constants.SENDER_COMP_ID);
        messageFields.add(Constants.TARGET_COMP_ID);
        messageFields.add(Constants.ON_BEHALF_OF_COMP_ID);
        messageFields.add(Constants.DELIVER_TO_COMP_ID);
        messageFields.add(Constants.SECURE_DATA_LEN);
        messageFields.add(Constants.SECURE_DATA);
        messageFields.add(Constants.MSG_SEQ_NUM);
        messageFields.add(Constants.SENDER_SUB_ID);
        messageFields.add(Constants.SENDER_LOCATION_ID);
        messageFields.add(Constants.TARGET_SUB_ID);
        messageFields.add(Constants.TARGET_LOCATION_ID);
        messageFields.add(Constants.ON_BEHALF_OF_SUB_ID);
        messageFields.add(Constants.ON_BEHALF_OF_LOCATION_ID);
        messageFields.add(Constants.DELIVER_TO_SUB_ID);
        messageFields.add(Constants.DELIVER_TO_LOCATION_ID);
        messageFields.add(Constants.POSS_DUP_FLAG);
        messageFields.add(Constants.POSS_RESEND);
        messageFields.add(Constants.SENDING_TIME);
        messageFields.add(Constants.ORIG_SENDING_TIME);
        messageFields.add(Constants.XML_DATA_LEN);
        messageFields.add(Constants.XML_DATA);
        messageFields.add(Constants.MESSAGE_ENCODING);
        messageFields.add(Constants.LAST_MSG_SEQ_NUM_PROCESSED);
        messageFields.add(Constants.LIST_ID);
        messageFields.add(Constants.BID_ID);
        messageFields.add(Constants.CLIENT_BID_ID);
        messageFields.add(Constants.PROG_RPT_REQS);
        messageFields.add(Constants.BID_TYPE);
        messageFields.add(Constants.PROG_PERIOD_INTERVAL);
        messageFields.add(Constants.CANCELLATION_RIGHTS);
        messageFields.add(Constants.MONEY_LAUNDERING_STATUS);
        messageFields.add(Constants.REGIST_ID);
        messageFields.add(Constants.LIST_EXEC_INST_TYPE);
        messageFields.add(Constants.LIST_EXEC_INST);
        messageFields.add(Constants.ENCODED_LIST_EXEC_INST_LEN);
        messageFields.add(Constants.ENCODED_LIST_EXEC_INST);
        messageFields.add(Constants.ALLOWABLE_ONE_SIDEDNESS_PCT);
        messageFields.add(Constants.ALLOWABLE_ONE_SIDEDNESS_VALUE);
        messageFields.add(Constants.ALLOWABLE_ONE_SIDEDNESS_CURR);
        messageFields.add(Constants.TOT_NO_ORDERS);
        messageFields.add(Constants.LAST_FRAGMENT);
        messageFields.add(Constants.NO_ORDERS_GROUP_COUNTER);
        messageFields.add(Constants.CL_ORD_ID);
        messageFields.add(Constants.SECONDARY_CL_ORD_ID);
        messageFields.add(Constants.LIST_SEQ_NO);
        messageFields.add(Constants.CL_ORD_LINK_ID);
        messageFields.add(Constants.SETTL_INST_MODE);
        messageFields.add(Constants.NO_PARTY_IDS_GROUP_COUNTER);
        messageFields.add(Constants.PARTY_ID);
        messageFields.add(Constants.PARTY_ID_SOURCE);
        messageFields.add(Constants.PARTY_ROLE);
        messageFields.add(Constants.NO_PARTY_SUB_IDS_GROUP_COUNTER);
        messageFields.add(Constants.PARTY_SUB_ID);
        messageFields.add(Constants.PARTY_SUB_ID_TYPE);
        messageFields.add(Constants.TRADE_ORIGINATION_DATE);
        messageFields.add(Constants.TRADE_DATE);
        messageFields.add(Constants.ACCOUNT);
        messageFields.add(Constants.ACCT_ID_SOURCE);
        messageFields.add(Constants.ACCOUNT_TYPE);
        messageFields.add(Constants.DAY_BOOKING_INST);
        messageFields.add(Constants.BOOKING_UNIT);
        messageFields.add(Constants.ALLOC_ID);
        messageFields.add(Constants.PREALLOC_METHOD);
        messageFields.add(Constants.NO_ALLOCS_GROUP_COUNTER);
        messageFields.add(Constants.ALLOC_ACCOUNT);
        messageFields.add(Constants.ALLOC_ACCT_ID_SOURCE);
        messageFields.add(Constants.ALLOC_SETTL_CURRENCY);
        messageFields.add(Constants.INDIVIDUAL_ALLOC_ID);
        messageFields.add(Constants.NO_NESTED_PARTY_IDS_GROUP_COUNTER);
        messageFields.add(Constants.NESTED_PARTY_ID);
        messageFields.add(Constants.NESTED_PARTY_ID_SOURCE);
        messageFields.add(Constants.NESTED_PARTY_ROLE);
        messageFields.add(Constants.NO_NESTED_PARTY_SUB_IDS_GROUP_COUNTER);
        messageFields.add(Constants.NESTED_PARTY_SUB_ID);
        messageFields.add(Constants.NESTED_PARTY_SUB_ID_TYPE);
        messageFields.add(Constants.ALLOC_QTY);
        messageFields.add(Constants.SETTL_TYPE);
        messageFields.add(Constants.SETTL_DATE);
        messageFields.add(Constants.CASH_MARGIN);
        messageFields.add(Constants.CLEARING_FEE_INDICATOR);
        messageFields.add(Constants.HANDL_INST);
        messageFields.add(Constants.EXEC_INST);
        messageFields.add(Constants.MIN_QTY);
        messageFields.add(Constants.MAX_FLOOR);
        messageFields.add(Constants.EX_DESTINATION);
        messageFields.add(Constants.NO_TRADING_SESSIONS_GROUP_COUNTER);
        messageFields.add(Constants.TRADING_SESSION_ID);
        messageFields.add(Constants.TRADING_SESSION_SUB_ID);
        messageFields.add(Constants.PROCESS_CODE);
        messageFields.add(Constants.SYMBOL);
        messageFields.add(Constants.SYMBOL_SFX);
        messageFields.add(Constants.SECURITY_ID);
        messageFields.add(Constants.SECURITY_ID_SOURCE);
        messageFields.add(Constants.NO_SECURITY_ALT_ID_GROUP_COUNTER);
        messageFields.add(Constants.SECURITY_ALT_ID);
        messageFields.add(Constants.SECURITY_ALT_ID_SOURCE);
        messageFields.add(Constants.PRODUCT);
        messageFields.add(Constants.C_F_I_CODE);
        messageFields.add(Constants.SECURITY_TYPE);
        messageFields.add(Constants.SECURITY_SUB_TYPE);
        messageFields.add(Constants.MATURITY_MONTH_YEAR);
        messageFields.add(Constants.MATURITY_DATE);
        messageFields.add(Constants.COUPON_PAYMENT_DATE);
        messageFields.add(Constants.ISSUE_DATE);
        messageFields.add(Constants.REPO_COLLATERAL_SECURITY_TYPE);
        messageFields.add(Constants.REPURCHASE_TERM);
        messageFields.add(Constants.REPURCHASE_RATE);
        messageFields.add(Constants.FACTOR);
        messageFields.add(Constants.CREDIT_RATING);
        messageFields.add(Constants.INSTR_REGISTRY);
        messageFields.add(Constants.COUNTRY_OF_ISSUE);
        messageFields.add(Constants.STATE_OR_PROVINCE_OF_ISSUE);
        messageFields.add(Constants.LOCALE_OF_ISSUE);
        messageFields.add(Constants.REDEMPTION_DATE);
        messageFields.add(Constants.STRIKE_PRICE);
        messageFields.add(Constants.STRIKE_CURRENCY);
        messageFields.add(Constants.OPT_ATTRIBUTE);
        messageFields.add(Constants.CONTRACT_MULTIPLIER);
        messageFields.add(Constants.COUPON_RATE);
        messageFields.add(Constants.SECURITY_EXCHANGE);
        messageFields.add(Constants.ISSUER);
        messageFields.add(Constants.ENCODED_ISSUER_LEN);
        messageFields.add(Constants.ENCODED_ISSUER);
        messageFields.add(Constants.SECURITY_DESC);
        messageFields.add(Constants.ENCODED_SECURITY_DESC_LEN);
        messageFields.add(Constants.ENCODED_SECURITY_DESC);
        messageFields.add(Constants.POOL);
        messageFields.add(Constants.CONTRACT_SETTL_MONTH);
        messageFields.add(Constants.C_P_PROGRAM);
        messageFields.add(Constants.C_P_REG_TYPE);
        messageFields.add(Constants.NO_EVENTS_GROUP_COUNTER);
        messageFields.add(Constants.EVENT_TYPE);
        messageFields.add(Constants.EVENT_DATE);
        messageFields.add(Constants.EVENT_PX);
        messageFields.add(Constants.EVENT_TEXT);
        messageFields.add(Constants.DATED_DATE);
        messageFields.add(Constants.INTEREST_ACCRUAL_DATE);
        messageFields.add(Constants.NO_UNDERLYINGS_GROUP_COUNTER);
        messageFields.add(Constants.UNDERLYING_SYMBOL);
        messageFields.add(Constants.UNDERLYING_SYMBOL_SFX);
        messageFields.add(Constants.UNDERLYING_SECURITY_ID);
        messageFields.add(Constants.UNDERLYING_SECURITY_ID_SOURCE);
        messageFields.add(Constants.NO_UNDERLYING_SECURITY_ALT_ID_GROUP_COUNTER);
        messageFields.add(Constants.UNDERLYING_SECURITY_ALT_ID);
        messageFields.add(Constants.UNDERLYING_SECURITY_ALT_ID_SOURCE);
        messageFields.add(Constants.UNDERLYING_PRODUCT);
        messageFields.add(Constants.UNDERLYING_C_F_I_CODE);
        messageFields.add(Constants.UNDERLYING_SECURITY_TYPE);
        messageFields.add(Constants.UNDERLYING_SECURITY_SUB_TYPE);
        messageFields.add(Constants.UNDERLYING_MATURITY_MONTH_YEAR);
        messageFields.add(Constants.UNDERLYING_MATURITY_DATE);
        messageFields.add(Constants.UNDERLYING_COUPON_PAYMENT_DATE);
        messageFields.add(Constants.UNDERLYING_ISSUE_DATE);
        messageFields.add(Constants.UNDERLYING_REPO_COLLATERAL_SECURITY_TYPE);
        messageFields.add(Constants.UNDERLYING_REPURCHASE_TERM);
        messageFields.add(Constants.UNDERLYING_REPURCHASE_RATE);
        messageFields.add(Constants.UNDERLYING_FACTOR);
        messageFields.add(Constants.UNDERLYING_CREDIT_RATING);
        messageFields.add(Constants.UNDERLYING_INSTR_REGISTRY);
        messageFields.add(Constants.UNDERLYING_COUNTRY_OF_ISSUE);
        messageFields.add(Constants.UNDERLYING_STATE_OR_PROVINCE_OF_ISSUE);
        messageFields.add(Constants.UNDERLYING_LOCALE_OF_ISSUE);
        messageFields.add(Constants.UNDERLYING_REDEMPTION_DATE);
        messageFields.add(Constants.UNDERLYING_STRIKE_PRICE);
        messageFields.add(Constants.UNDERLYING_STRIKE_CURRENCY);
        messageFields.add(Constants.UNDERLYING_OPT_ATTRIBUTE);
        messageFields.add(Constants.UNDERLYING_CONTRACT_MULTIPLIER);
        messageFields.add(Constants.UNDERLYING_COUPON_RATE);
        messageFields.add(Constants.UNDERLYING_SECURITY_EXCHANGE);
        messageFields.add(Constants.UNDERLYING_ISSUER);
        messageFields.add(Constants.ENCODED_UNDERLYING_ISSUER_LEN);
        messageFields.add(Constants.ENCODED_UNDERLYING_ISSUER);
        messageFields.add(Constants.UNDERLYING_SECURITY_DESC);
        messageFields.add(Constants.ENCODED_UNDERLYING_SECURITY_DESC_LEN);
        messageFields.add(Constants.ENCODED_UNDERLYING_SECURITY_DESC);
        messageFields.add(Constants.UNDERLYING_C_P_PROGRAM);
        messageFields.add(Constants.UNDERLYING_C_P_REG_TYPE);
        messageFields.add(Constants.UNDERLYING_CURRENCY);
        messageFields.add(Constants.UNDERLYING_QTY);
        messageFields.add(Constants.UNDERLYING_PX);
        messageFields.add(Constants.UNDERLYING_DIRTY_PRICE);
        messageFields.add(Constants.UNDERLYING_END_PRICE);
        messageFields.add(Constants.UNDERLYING_START_VALUE);
        messageFields.add(Constants.UNDERLYING_CURRENT_VALUE);
        messageFields.add(Constants.UNDERLYING_END_VALUE);
        messageFields.add(Constants.NO_UNDERLYING_STIPS_GROUP_COUNTER);
        messageFields.add(Constants.UNDERLYING_STIP_TYPE);
        messageFields.add(Constants.UNDERLYING_STIP_VALUE);
        messageFields.add(Constants.PREV_CLOSE_PX);
        messageFields.add(Constants.SIDE);
        messageFields.add(Constants.SIDE_VALUE_IND);
        messageFields.add(Constants.LOCATE_REQD);
        messageFields.add(Constants.TRANSACT_TIME);
        messageFields.add(Constants.NO_STIPULATIONS_GROUP_COUNTER);
        messageFields.add(Constants.STIPULATION_TYPE);
        messageFields.add(Constants.STIPULATION_VALUE);
        messageFields.add(Constants.QTY_TYPE);
        messageFields.add(Constants.ORDER_QTY);
        messageFields.add(Constants.CASH_ORDER_QTY);
        messageFields.add(Constants.ORDER_PERCENT);
        messageFields.add(Constants.ROUNDING_DIRECTION);
        messageFields.add(Constants.ROUNDING_MODULUS);
        messageFields.add(Constants.ORD_TYPE);
        messageFields.add(Constants.PRICE_TYPE);
        messageFields.add(Constants.PRICE);
        messageFields.add(Constants.STOP_PX);
        messageFields.add(Constants.SPREAD);
        messageFields.add(Constants.BENCHMARK_CURVE_CURRENCY);
        messageFields.add(Constants.BENCHMARK_CURVE_NAME);
        messageFields.add(Constants.BENCHMARK_CURVE_POINT);
        messageFields.add(Constants.BENCHMARK_PRICE);
        messageFields.add(Constants.BENCHMARK_PRICE_TYPE);
        messageFields.add(Constants.BENCHMARK_SECURITY_ID);
        messageFields.add(Constants.BENCHMARK_SECURITY_ID_SOURCE);
        messageFields.add(Constants.YIELD_TYPE);
        messageFields.add(Constants.YIELD);
        messageFields.add(Constants.YIELD_CALC_DATE);
        messageFields.add(Constants.YIELD_REDEMPTION_DATE);
        messageFields.add(Constants.YIELD_REDEMPTION_PRICE);
        messageFields.add(Constants.YIELD_REDEMPTION_PRICE_TYPE);
        messageFields.add(Constants.CURRENCY);
        messageFields.add(Constants.COMPLIANCE_ID);
        messageFields.add(Constants.SOLICITED_FLAG);
        messageFields.add(Constants.I_O_IID);
        messageFields.add(Constants.QUOTE_ID);
        messageFields.add(Constants.TIME_IN_FORCE);
        messageFields.add(Constants.EFFECTIVE_TIME);
        messageFields.add(Constants.EXPIRE_DATE);
        messageFields.add(Constants.EXPIRE_TIME);
        messageFields.add(Constants.G_T_BOOKING_INST);
        messageFields.add(Constants.COMMISSION);
        messageFields.add(Constants.COMM_TYPE);
        messageFields.add(Constants.COMM_CURRENCY);
        messageFields.add(Constants.FUND_RENEW_WAIV);
        messageFields.add(Constants.ORDER_CAPACITY);
        messageFields.add(Constants.ORDER_RESTRICTIONS);
        messageFields.add(Constants.CUST_ORDER_CAPACITY);
        messageFields.add(Constants.FOREX_REQ);
        messageFields.add(Constants.SETTL_CURRENCY);
        messageFields.add(Constants.BOOKING_TYPE);
        messageFields.add(Constants.TEXT);
        messageFields.add(Constants.ENCODED_TEXT_LEN);
        messageFields.add(Constants.ENCODED_TEXT);
        messageFields.add(Constants.SETTL_DATE2);
        messageFields.add(Constants.ORDER_QTY2);
        messageFields.add(Constants.PRICE2);
        messageFields.add(Constants.POSITION_EFFECT);
        messageFields.add(Constants.COVERED_OR_UNCOVERED);
        messageFields.add(Constants.MAX_SHOW);
        messageFields.add(Constants.PEG_OFFSET_VALUE);
        messageFields.add(Constants.PEG_MOVE_TYPE);
        messageFields.add(Constants.PEG_OFFSET_TYPE);
        messageFields.add(Constants.PEG_LIMIT_TYPE);
        messageFields.add(Constants.PEG_ROUND_DIRECTION);
        messageFields.add(Constants.PEG_SCOPE);
        messageFields.add(Constants.DISCRETION_INST);
        messageFields.add(Constants.DISCRETION_OFFSET_VALUE);
        messageFields.add(Constants.DISCRETION_MOVE_TYPE);
        messageFields.add(Constants.DISCRETION_OFFSET_TYPE);
        messageFields.add(Constants.DISCRETION_LIMIT_TYPE);
        messageFields.add(Constants.DISCRETION_ROUND_DIRECTION);
        messageFields.add(Constants.DISCRETION_SCOPE);
        messageFields.add(Constants.TARGET_STRATEGY);
        messageFields.add(Constants.TARGET_STRATEGY_PARAMETERS);
        messageFields.add(Constants.PARTICIPATION_RATE);
        messageFields.add(Constants.DESIGNATION);
        messageFields.add(Constants.SIGNATURE_LENGTH);
        messageFields.add(Constants.SIGNATURE);
        messageFields.add(Constants.CHECK_SUM);
    }

    private final TrailerDecoder trailer = new TrailerDecoder();

    public TrailerDecoder trailer()
    {
        return trailer;
    }

    private final HeaderDecoder header = new HeaderDecoder(trailer);

    public HeaderDecoder header()
    {
        return header;
    }

    private char[] listID = new char[1];

    /* ListID = 66 */
    public char[] listID()
    {
        return listID;
    }


    private int listIDOffset;

    private int listIDLength;

    /* ListID = 66 */
    public int listIDLength()
    {
        return listIDLength;
    }

    /* ListID = 66 */
    public String listIDAsString()
    {
        return new String(listID, 0, listIDLength);
    }

    /* ListID = 66 */
    public AsciiSequenceView listID(final AsciiSequenceView view)
    {
        return view.wrap(buffer, listIDOffset, listIDLength);
    }


    private final CharArrayWrapper listIDWrapper = new CharArrayWrapper();
    private char[] bidID = new char[1];

    private boolean hasBidID;

    /* BidID = 390 */
    public char[] bidID()
    {
        if (!hasBidID)
        {
            throw new IllegalArgumentException("No value for optional field: BidID");
        }

        return bidID;
    }

    public boolean hasBidID()
    {
        return hasBidID;
    }


    private int bidIDOffset;

    private int bidIDLength;

    /* BidID = 390 */
    public int bidIDLength()
    {
        if (!hasBidID)
        {
            throw new IllegalArgumentException("No value for optional field: BidID");
        }

        return bidIDLength;
    }

    /* BidID = 390 */
    public String bidIDAsString()
    {
        return hasBidID ? new String(bidID, 0, bidIDLength) : null;
    }

    /* BidID = 390 */
    public AsciiSequenceView bidID(final AsciiSequenceView view)
    {
        if (!hasBidID)
        {
            throw new IllegalArgumentException("No value for optional field: BidID");
        }

        return view.wrap(buffer, bidIDOffset, bidIDLength);
    }


    private final CharArrayWrapper bidIDWrapper = new CharArrayWrapper();
    private char[] clientBidID = new char[1];

    private boolean hasClientBidID;

    /* ClientBidID = 391 */
    public char[] clientBidID()
    {
        if (!hasClientBidID)
        {
            throw new IllegalArgumentException("No value for optional field: ClientBidID");
        }

        return clientBidID;
    }

    public boolean hasClientBidID()
    {
        return hasClientBidID;
    }


    private int clientBidIDOffset;

    private int clientBidIDLength;

    /* ClientBidID = 391 */
    public int clientBidIDLength()
    {
        if (!hasClientBidID)
        {
            throw new IllegalArgumentException("No value for optional field: ClientBidID");
        }

        return clientBidIDLength;
    }

    /* ClientBidID = 391 */
    public String clientBidIDAsString()
    {
        return hasClientBidID ? new String(clientBidID, 0, clientBidIDLength) : null;
    }

    /* ClientBidID = 391 */
    public AsciiSequenceView clientBidID(final AsciiSequenceView view)
    {
        if (!hasClientBidID)
        {
            throw new IllegalArgumentException("No value for optional field: ClientBidID");
        }

        return view.wrap(buffer, clientBidIDOffset, clientBidIDLength);
    }


    private final CharArrayWrapper clientBidIDWrapper = new CharArrayWrapper();
    private int progRptReqs = MISSING_INT;

    private boolean hasProgRptReqs;

    /* ProgRptReqs = 414 */
    public int progRptReqs()
    {
        if (!hasProgRptReqs)
        {
            throw new IllegalArgumentException("No value for optional field: ProgRptReqs");
        }

        return progRptReqs;
    }

    public boolean hasProgRptReqs()
    {
        return hasProgRptReqs;
    }



    private final CharArrayWrapper progRptReqsWrapper = new CharArrayWrapper();
    /* ProgRptReqs = 414 */
    public ProgRptReqs progRptReqsAsEnum()
    {
        if (!hasProgRptReqs)
 return ProgRptReqs.NULL_VAL;
        return ProgRptReqs.decode(progRptReqs);
    }

    private int bidType = MISSING_INT;

    /* BidType = 394 */
    public int bidType()
    {
        return bidType;
    }



    private final CharArrayWrapper bidTypeWrapper = new CharArrayWrapper();
    /* BidType = 394 */
    public BidType bidTypeAsEnum()
    {
        return BidType.decode(bidType);
    }

    private int progPeriodInterval = MISSING_INT;

    private boolean hasProgPeriodInterval;

    /* ProgPeriodInterval = 415 */
    public int progPeriodInterval()
    {
        if (!hasProgPeriodInterval)
        {
            throw new IllegalArgumentException("No value for optional field: ProgPeriodInterval");
        }

        return progPeriodInterval;
    }

    public boolean hasProgPeriodInterval()
    {
        return hasProgPeriodInterval;
    }



    private char cancellationRights = MISSING_CHAR;

    private boolean hasCancellationRights;

    /* CancellationRights = 480 */
    public char cancellationRights()
    {
        if (!hasCancellationRights)
        {
            throw new IllegalArgumentException("No value for optional field: CancellationRights");
        }

        return cancellationRights;
    }

    public boolean hasCancellationRights()
    {
        return hasCancellationRights;
    }



    private final CharArrayWrapper cancellationRightsWrapper = new CharArrayWrapper();
    /* CancellationRights = 480 */
    public CancellationRights cancellationRightsAsEnum()
    {
        if (!hasCancellationRights)
 return CancellationRights.NULL_VAL;
        return CancellationRights.decode(cancellationRights);
    }

    private char moneyLaunderingStatus = MISSING_CHAR;

    private boolean hasMoneyLaunderingStatus;

    /* MoneyLaunderingStatus = 481 */
    public char moneyLaunderingStatus()
    {
        if (!hasMoneyLaunderingStatus)
        {
            throw new IllegalArgumentException("No value for optional field: MoneyLaunderingStatus");
        }

        return moneyLaunderingStatus;
    }

    public boolean hasMoneyLaunderingStatus()
    {
        return hasMoneyLaunderingStatus;
    }



    private final CharArrayWrapper moneyLaunderingStatusWrapper = new CharArrayWrapper();
    /* MoneyLaunderingStatus = 481 */
    public MoneyLaunderingStatus moneyLaunderingStatusAsEnum()
    {
        if (!hasMoneyLaunderingStatus)
 return MoneyLaunderingStatus.NULL_VAL;
        return MoneyLaunderingStatus.decode(moneyLaunderingStatus);
    }

    private char[] registID = new char[1];

    private boolean hasRegistID;

    /* RegistID = 513 */
    public char[] registID()
    {
        if (!hasRegistID)
        {
            throw new IllegalArgumentException("No value for optional field: RegistID");
        }

        return registID;
    }

    public boolean hasRegistID()
    {
        return hasRegistID;
    }


    private int registIDOffset;

    private int registIDLength;

    /* RegistID = 513 */
    public int registIDLength()
    {
        if (!hasRegistID)
        {
            throw new IllegalArgumentException("No value for optional field: RegistID");
        }

        return registIDLength;
    }

    /* RegistID = 513 */
    public String registIDAsString()
    {
        return hasRegistID ? new String(registID, 0, registIDLength) : null;
    }

    /* RegistID = 513 */
    public AsciiSequenceView registID(final AsciiSequenceView view)
    {
        if (!hasRegistID)
        {
            throw new IllegalArgumentException("No value for optional field: RegistID");
        }

        return view.wrap(buffer, registIDOffset, registIDLength);
    }


    private final CharArrayWrapper registIDWrapper = new CharArrayWrapper();
    private char listExecInstType = MISSING_CHAR;

    private boolean hasListExecInstType;

    /* ListExecInstType = 433 */
    public char listExecInstType()
    {
        if (!hasListExecInstType)
        {
            throw new IllegalArgumentException("No value for optional field: ListExecInstType");
        }

        return listExecInstType;
    }

    public boolean hasListExecInstType()
    {
        return hasListExecInstType;
    }



    private final CharArrayWrapper listExecInstTypeWrapper = new CharArrayWrapper();
    /* ListExecInstType = 433 */
    public ListExecInstType listExecInstTypeAsEnum()
    {
        if (!hasListExecInstType)
 return ListExecInstType.NULL_VAL;
        return ListExecInstType.decode(listExecInstType);
    }

    private char[] listExecInst = new char[1];

    private boolean hasListExecInst;

    /* ListExecInst = 69 */
    public char[] listExecInst()
    {
        if (!hasListExecInst)
        {
            throw new IllegalArgumentException("No value for optional field: ListExecInst");
        }

        return listExecInst;
    }

    public boolean hasListExecInst()
    {
        return hasListExecInst;
    }


    private int listExecInstOffset;

    private int listExecInstLength;

    /* ListExecInst = 69 */
    public int listExecInstLength()
    {
        if (!hasListExecInst)
        {
            throw new IllegalArgumentException("No value for optional field: ListExecInst");
        }

        return listExecInstLength;
    }

    /* ListExecInst = 69 */
    public String listExecInstAsString()
    {
        return hasListExecInst ? new String(listExecInst, 0, listExecInstLength) : null;
    }

    /* ListExecInst = 69 */
    public AsciiSequenceView listExecInst(final AsciiSequenceView view)
    {
        if (!hasListExecInst)
        {
            throw new IllegalArgumentException("No value for optional field: ListExecInst");
        }

        return view.wrap(buffer, listExecInstOffset, listExecInstLength);
    }


    private final CharArrayWrapper listExecInstWrapper = new CharArrayWrapper();
    private int encodedListExecInstLen = MISSING_INT;

    private boolean hasEncodedListExecInstLen;

    /* EncodedListExecInstLen = 352 */
    public int encodedListExecInstLen()
    {
        if (!hasEncodedListExecInstLen)
        {
            throw new IllegalArgumentException("No value for optional field: EncodedListExecInstLen");
        }

        return encodedListExecInstLen;
    }

    public boolean hasEncodedListExecInstLen()
    {
        return hasEncodedListExecInstLen;
    }



    private byte[] encodedListExecInst = new byte[1];

    private boolean hasEncodedListExecInst;

    /* EncodedListExecInst = 353 */
    public byte[] encodedListExecInst()
    {
        if (!hasEncodedListExecInst)
        {
            throw new IllegalArgumentException("No value for optional field: EncodedListExecInst");
        }

        return encodedListExecInst;
    }

    public boolean hasEncodedListExecInst()
    {
        return hasEncodedListExecInst;
    }



    private DecimalFloat allowableOneSidednessPct = DecimalFloat.newNaNValue();

    private boolean hasAllowableOneSidednessPct;

    /* AllowableOneSidednessPct = 765 */
    public DecimalFloat allowableOneSidednessPct()
    {
        if (!hasAllowableOneSidednessPct)
        {
            throw new IllegalArgumentException("No value for optional field: AllowableOneSidednessPct");
        }

        return allowableOneSidednessPct;
    }

    public boolean hasAllowableOneSidednessPct()
    {
        return hasAllowableOneSidednessPct;
    }



    private DecimalFloat allowableOneSidednessValue = DecimalFloat.newNaNValue();

    private boolean hasAllowableOneSidednessValue;

    /* AllowableOneSidednessValue = 766 */
    public DecimalFloat allowableOneSidednessValue()
    {
        if (!hasAllowableOneSidednessValue)
        {
            throw new IllegalArgumentException("No value for optional field: AllowableOneSidednessValue");
        }

        return allowableOneSidednessValue;
    }

    public boolean hasAllowableOneSidednessValue()
    {
        return hasAllowableOneSidednessValue;
    }



    private char[] allowableOneSidednessCurr = new char[1];

    private boolean hasAllowableOneSidednessCurr;

    /* AllowableOneSidednessCurr = 767 */
    public char[] allowableOneSidednessCurr()
    {
        if (!hasAllowableOneSidednessCurr)
        {
            throw new IllegalArgumentException("No value for optional field: AllowableOneSidednessCurr");
        }

        return allowableOneSidednessCurr;
    }

    public boolean hasAllowableOneSidednessCurr()
    {
        return hasAllowableOneSidednessCurr;
    }


    private int allowableOneSidednessCurrOffset;

    private int allowableOneSidednessCurrLength;

    /* AllowableOneSidednessCurr = 767 */
    public int allowableOneSidednessCurrLength()
    {
        if (!hasAllowableOneSidednessCurr)
        {
            throw new IllegalArgumentException("No value for optional field: AllowableOneSidednessCurr");
        }

        return allowableOneSidednessCurrLength;
    }

    /* AllowableOneSidednessCurr = 767 */
    public String allowableOneSidednessCurrAsString()
    {
        return hasAllowableOneSidednessCurr ? new String(allowableOneSidednessCurr, 0, allowableOneSidednessCurrLength) : null;
    }

    /* AllowableOneSidednessCurr = 767 */
    public AsciiSequenceView allowableOneSidednessCurr(final AsciiSequenceView view)
    {
        if (!hasAllowableOneSidednessCurr)
        {
            throw new IllegalArgumentException("No value for optional field: AllowableOneSidednessCurr");
        }

        return view.wrap(buffer, allowableOneSidednessCurrOffset, allowableOneSidednessCurrLength);
    }


    private int totNoOrders = MISSING_INT;

    /* TotNoOrders = 68 */
    public int totNoOrders()
    {
        return totNoOrders;
    }



    private boolean lastFragment;

    private boolean hasLastFragment;

    /* LastFragment = 893 */
    public boolean lastFragment()
    {
        if (!hasLastFragment)
        {
            throw new IllegalArgumentException("No value for optional field: LastFragment");
        }

        return lastFragment;
    }

    public boolean hasLastFragment()
    {
        return hasLastFragment;
    }




@Generated("uk.co.real_logic.artio")
public class OrdersGroupDecoder extends CommonDecoderImpl implements PartiesDecoder, InstrumentDecoder, StipulationsDecoder, OrderQtyDataDecoder, SpreadOrBenchmarkCurveDataDecoder, YieldDataDecoder, CommissionDataDecoder, PegInstructionsDecoder, DiscretionInstructionsDecoder
{
    public final IntHashSet REQUIRED_FIELDS = new IntHashSet(8);

    {
        if (CODEC_VALIDATION_ENABLED)
        {
            REQUIRED_FIELDS.add(Constants.CL_ORD_ID);
            REQUIRED_FIELDS.add(Constants.LIST_SEQ_NO);
            REQUIRED_FIELDS.add(Constants.SYMBOL);
            REQUIRED_FIELDS.add(Constants.SIDE);
        }
    }

    public final IntHashSet GROUP_FIELDS = new IntHashSet(278);

    {
        if (CODEC_VALIDATION_ENABLED)
        {
            GROUP_FIELDS.add(Constants.CL_ORD_ID);
            GROUP_FIELDS.add(Constants.SECONDARY_CL_ORD_ID);
            GROUP_FIELDS.add(Constants.LIST_SEQ_NO);
            GROUP_FIELDS.add(Constants.CL_ORD_LINK_ID);
            GROUP_FIELDS.add(Constants.SETTL_INST_MODE);
            GROUP_FIELDS.add(Constants.TRADE_ORIGINATION_DATE);
            GROUP_FIELDS.add(Constants.TRADE_DATE);
            GROUP_FIELDS.add(Constants.ACCOUNT);
            GROUP_FIELDS.add(Constants.ACCT_ID_SOURCE);
            GROUP_FIELDS.add(Constants.ACCOUNT_TYPE);
            GROUP_FIELDS.add(Constants.DAY_BOOKING_INST);
            GROUP_FIELDS.add(Constants.BOOKING_UNIT);
            GROUP_FIELDS.add(Constants.ALLOC_ID);
            GROUP_FIELDS.add(Constants.PREALLOC_METHOD);
            GROUP_FIELDS.add(Constants.SETTL_TYPE);
            GROUP_FIELDS.add(Constants.SETTL_DATE);
            GROUP_FIELDS.add(Constants.CASH_MARGIN);
            GROUP_FIELDS.add(Constants.CLEARING_FEE_INDICATOR);
            GROUP_FIELDS.add(Constants.HANDL_INST);
            GROUP_FIELDS.add(Constants.EXEC_INST);
            GROUP_FIELDS.add(Constants.MIN_QTY);
            GROUP_FIELDS.add(Constants.MAX_FLOOR);
            GROUP_FIELDS.add(Constants.EX_DESTINATION);
            GROUP_FIELDS.add(Constants.PROCESS_CODE);
            GROUP_FIELDS.add(Constants.SYMBOL);
            GROUP_FIELDS.add(Constants.SYMBOL_SFX);
            GROUP_FIELDS.add(Constants.SECURITY_ID);
            GROUP_FIELDS.add(Constants.SECURITY_ID_SOURCE);
            GROUP_FIELDS.add(Constants.PRODUCT);
            GROUP_FIELDS.add(Constants.C_F_I_CODE);
            GROUP_FIELDS.add(Constants.SECURITY_TYPE);
            GROUP_FIELDS.add(Constants.SECURITY_SUB_TYPE);
            GROUP_FIELDS.add(Constants.MATURITY_MONTH_YEAR);
            GROUP_FIELDS.add(Constants.MATURITY_DATE);
            GROUP_FIELDS.add(Constants.COUPON_PAYMENT_DATE);
            GROUP_FIELDS.add(Constants.ISSUE_DATE);
            GROUP_FIELDS.add(Constants.REPO_COLLATERAL_SECURITY_TYPE);
            GROUP_FIELDS.add(Constants.REPURCHASE_TERM);
            GROUP_FIELDS.add(Constants.REPURCHASE_RATE);
            GROUP_FIELDS.add(Constants.FACTOR);
            GROUP_FIELDS.add(Constants.CREDIT_RATING);
            GROUP_FIELDS.add(Constants.INSTR_REGISTRY);
            GROUP_FIELDS.add(Constants.COUNTRY_OF_ISSUE);
            GROUP_FIELDS.add(Constants.STATE_OR_PROVINCE_OF_ISSUE);
            GROUP_FIELDS.add(Constants.LOCALE_OF_ISSUE);
            GROUP_FIELDS.add(Constants.REDEMPTION_DATE);
            GROUP_FIELDS.add(Constants.STRIKE_PRICE);
            GROUP_FIELDS.add(Constants.STRIKE_CURRENCY);
            GROUP_FIELDS.add(Constants.OPT_ATTRIBUTE);
            GROUP_FIELDS.add(Constants.CONTRACT_MULTIPLIER);
            GROUP_FIELDS.add(Constants.COUPON_RATE);
            GROUP_FIELDS.add(Constants.SECURITY_EXCHANGE);
            GROUP_FIELDS.add(Constants.ISSUER);
            GROUP_FIELDS.add(Constants.ENCODED_ISSUER_LEN);
            GROUP_FIELDS.add(Constants.ENCODED_ISSUER);
            GROUP_FIELDS.add(Constants.SECURITY_DESC);
            GROUP_FIELDS.add(Constants.ENCODED_SECURITY_DESC_LEN);
            GROUP_FIELDS.add(Constants.ENCODED_SECURITY_DESC);
            GROUP_FIELDS.add(Constants.POOL);
            GROUP_FIELDS.add(Constants.CONTRACT_SETTL_MONTH);
            GROUP_FIELDS.add(Constants.C_P_PROGRAM);
            GROUP_FIELDS.add(Constants.C_P_REG_TYPE);
            GROUP_FIELDS.add(Constants.DATED_DATE);
            GROUP_FIELDS.add(Constants.INTEREST_ACCRUAL_DATE);
            GROUP_FIELDS.add(Constants.PREV_CLOSE_PX);
            GROUP_FIELDS.add(Constants.SIDE);
            GROUP_FIELDS.add(Constants.SIDE_VALUE_IND);
            GROUP_FIELDS.add(Constants.LOCATE_REQD);
            GROUP_FIELDS.add(Constants.TRANSACT_TIME);
            GROUP_FIELDS.add(Constants.QTY_TYPE);
            GROUP_FIELDS.add(Constants.ORDER_QTY);
            GROUP_FIELDS.add(Constants.CASH_ORDER_QTY);
            GROUP_FIELDS.add(Constants.ORDER_PERCENT);
            GROUP_FIELDS.add(Constants.ROUNDING_DIRECTION);
            GROUP_FIELDS.add(Constants.ROUNDING_MODULUS);
            GROUP_FIELDS.add(Constants.ORD_TYPE);
            GROUP_FIELDS.add(Constants.PRICE_TYPE);
            GROUP_FIELDS.add(Constants.PRICE);
            GROUP_FIELDS.add(Constants.STOP_PX);
            GROUP_FIELDS.add(Constants.SPREAD);
            GROUP_FIELDS.add(Constants.BENCHMARK_CURVE_CURRENCY);
            GROUP_FIELDS.add(Constants.BENCHMARK_CURVE_NAME);
            GROUP_FIELDS.add(Constants.BENCHMARK_CURVE_POINT);
            GROUP_FIELDS.add(Constants.BENCHMARK_PRICE);
            GROUP_FIELDS.add(Constants.BENCHMARK_PRICE_TYPE);
            GROUP_FIELDS.add(Constants.BENCHMARK_SECURITY_ID);
            GROUP_FIELDS.add(Constants.BENCHMARK_SECURITY_ID_SOURCE);
            GROUP_FIELDS.add(Constants.YIELD_TYPE);
            GROUP_FIELDS.add(Constants.YIELD);
            GROUP_FIELDS.add(Constants.YIELD_CALC_DATE);
            GROUP_FIELDS.add(Constants.YIELD_REDEMPTION_DATE);
            GROUP_FIELDS.add(Constants.YIELD_REDEMPTION_PRICE);
            GROUP_FIELDS.add(Constants.YIELD_REDEMPTION_PRICE_TYPE);
            GROUP_FIELDS.add(Constants.CURRENCY);
            GROUP_FIELDS.add(Constants.COMPLIANCE_ID);
            GROUP_FIELDS.add(Constants.SOLICITED_FLAG);
            GROUP_FIELDS.add(Constants.I_O_IID);
            GROUP_FIELDS.add(Constants.QUOTE_ID);
            GROUP_FIELDS.add(Constants.TIME_IN_FORCE);
            GROUP_FIELDS.add(Constants.EFFECTIVE_TIME);
            GROUP_FIELDS.add(Constants.EXPIRE_DATE);
            GROUP_FIELDS.add(Constants.EXPIRE_TIME);
            GROUP_FIELDS.add(Constants.G_T_BOOKING_INST);
            GROUP_FIELDS.add(Constants.COMMISSION);
            GROUP_FIELDS.add(Constants.COMM_TYPE);
            GROUP_FIELDS.add(Constants.COMM_CURRENCY);
            GROUP_FIELDS.add(Constants.FUND_RENEW_WAIV);
            GROUP_FIELDS.add(Constants.ORDER_CAPACITY);
            GROUP_FIELDS.add(Constants.ORDER_RESTRICTIONS);
            GROUP_FIELDS.add(Constants.CUST_ORDER_CAPACITY);
            GROUP_FIELDS.add(Constants.FOREX_REQ);
            GROUP_FIELDS.add(Constants.SETTL_CURRENCY);
            GROUP_FIELDS.add(Constants.BOOKING_TYPE);
            GROUP_FIELDS.add(Constants.TEXT);
            GROUP_FIELDS.add(Constants.ENCODED_TEXT_LEN);
            GROUP_FIELDS.add(Constants.ENCODED_TEXT);
            GROUP_FIELDS.add(Constants.SETTL_DATE2);
            GROUP_FIELDS.add(Constants.ORDER_QTY2);
            GROUP_FIELDS.add(Constants.PRICE2);
            GROUP_FIELDS.add(Constants.POSITION_EFFECT);
            GROUP_FIELDS.add(Constants.COVERED_OR_UNCOVERED);
            GROUP_FIELDS.add(Constants.MAX_SHOW);
            GROUP_FIELDS.add(Constants.PEG_OFFSET_VALUE);
            GROUP_FIELDS.add(Constants.PEG_MOVE_TYPE);
            GROUP_FIELDS.add(Constants.PEG_OFFSET_TYPE);
            GROUP_FIELDS.add(Constants.PEG_LIMIT_TYPE);
            GROUP_FIELDS.add(Constants.PEG_ROUND_DIRECTION);
            GROUP_FIELDS.add(Constants.PEG_SCOPE);
            GROUP_FIELDS.add(Constants.DISCRETION_INST);
            GROUP_FIELDS.add(Constants.DISCRETION_OFFSET_VALUE);
            GROUP_FIELDS.add(Constants.DISCRETION_MOVE_TYPE);
            GROUP_FIELDS.add(Constants.DISCRETION_OFFSET_TYPE);
            GROUP_FIELDS.add(Constants.DISCRETION_LIMIT_TYPE);
            GROUP_FIELDS.add(Constants.DISCRETION_ROUND_DIRECTION);
            GROUP_FIELDS.add(Constants.DISCRETION_SCOPE);
            GROUP_FIELDS.add(Constants.TARGET_STRATEGY);
            GROUP_FIELDS.add(Constants.TARGET_STRATEGY_PARAMETERS);
            GROUP_FIELDS.add(Constants.PARTICIPATION_RATE);
            GROUP_FIELDS.add(Constants.DESIGNATION);
        }
    }

    public final IntHashSet ALL_GROUP_FIELDS = new IntHashSet(126);

    {
        if (CODEC_VALIDATION_ENABLED)
        {
            ALL_GROUP_FIELDS.add(Constants.CL_ORD_ID);
            ALL_GROUP_FIELDS.add(Constants.SECONDARY_CL_ORD_ID);
            ALL_GROUP_FIELDS.add(Constants.LIST_SEQ_NO);
            ALL_GROUP_FIELDS.add(Constants.CL_ORD_LINK_ID);
            ALL_GROUP_FIELDS.add(Constants.SETTL_INST_MODE);
            ALL_GROUP_FIELDS.add(Constants.TRADE_ORIGINATION_DATE);
            ALL_GROUP_FIELDS.add(Constants.TRADE_DATE);
            ALL_GROUP_FIELDS.add(Constants.ACCOUNT);
            ALL_GROUP_FIELDS.add(Constants.ACCT_ID_SOURCE);
            ALL_GROUP_FIELDS.add(Constants.ACCOUNT_TYPE);
            ALL_GROUP_FIELDS.add(Constants.DAY_BOOKING_INST);
            ALL_GROUP_FIELDS.add(Constants.BOOKING_UNIT);
            ALL_GROUP_FIELDS.add(Constants.ALLOC_ID);
            ALL_GROUP_FIELDS.add(Constants.PREALLOC_METHOD);
            ALL_GROUP_FIELDS.add(Constants.SETTL_TYPE);
            ALL_GROUP_FIELDS.add(Constants.SETTL_DATE);
            ALL_GROUP_FIELDS.add(Constants.CASH_MARGIN);
            ALL_GROUP_FIELDS.add(Constants.CLEARING_FEE_INDICATOR);
            ALL_GROUP_FIELDS.add(Constants.HANDL_INST);
            ALL_GROUP_FIELDS.add(Constants.EXEC_INST);
            ALL_GROUP_FIELDS.add(Constants.MIN_QTY);
            ALL_GROUP_FIELDS.add(Constants.MAX_FLOOR);
            ALL_GROUP_FIELDS.add(Constants.EX_DESTINATION);
            ALL_GROUP_FIELDS.add(Constants.PROCESS_CODE);
            ALL_GROUP_FIELDS.add(Constants.PREV_CLOSE_PX);
            ALL_GROUP_FIELDS.add(Constants.SIDE);
            ALL_GROUP_FIELDS.add(Constants.SIDE_VALUE_IND);
            ALL_GROUP_FIELDS.add(Constants.LOCATE_REQD);
            ALL_GROUP_FIELDS.add(Constants.TRANSACT_TIME);
            ALL_GROUP_FIELDS.add(Constants.QTY_TYPE);
            ALL_GROUP_FIELDS.add(Constants.ORD_TYPE);
            ALL_GROUP_FIELDS.add(Constants.PRICE_TYPE);
            ALL_GROUP_FIELDS.add(Constants.PRICE);
            ALL_GROUP_FIELDS.add(Constants.STOP_PX);
            ALL_GROUP_FIELDS.add(Constants.CURRENCY);
            ALL_GROUP_FIELDS.add(Constants.COMPLIANCE_ID);
            ALL_GROUP_FIELDS.add(Constants.SOLICITED_FLAG);
            ALL_GROUP_FIELDS.add(Constants.I_O_IID);
            ALL_GROUP_FIELDS.add(Constants.QUOTE_ID);
            ALL_GROUP_FIELDS.add(Constants.TIME_IN_FORCE);
            ALL_GROUP_FIELDS.add(Constants.EFFECTIVE_TIME);
            ALL_GROUP_FIELDS.add(Constants.EXPIRE_DATE);
            ALL_GROUP_FIELDS.add(Constants.EXPIRE_TIME);
            ALL_GROUP_FIELDS.add(Constants.G_T_BOOKING_INST);
            ALL_GROUP_FIELDS.add(Constants.ORDER_CAPACITY);
            ALL_GROUP_FIELDS.add(Constants.ORDER_RESTRICTIONS);
            ALL_GROUP_FIELDS.add(Constants.CUST_ORDER_CAPACITY);
            ALL_GROUP_FIELDS.add(Constants.FOREX_REQ);
            ALL_GROUP_FIELDS.add(Constants.SETTL_CURRENCY);
            ALL_GROUP_FIELDS.add(Constants.BOOKING_TYPE);
            ALL_GROUP_FIELDS.add(Constants.TEXT);
            ALL_GROUP_FIELDS.add(Constants.ENCODED_TEXT_LEN);
            ALL_GROUP_FIELDS.add(Constants.ENCODED_TEXT);
            ALL_GROUP_FIELDS.add(Constants.SETTL_DATE2);
            ALL_GROUP_FIELDS.add(Constants.ORDER_QTY2);
            ALL_GROUP_FIELDS.add(Constants.PRICE2);
            ALL_GROUP_FIELDS.add(Constants.POSITION_EFFECT);
            ALL_GROUP_FIELDS.add(Constants.COVERED_OR_UNCOVERED);
            ALL_GROUP_FIELDS.add(Constants.MAX_SHOW);
            ALL_GROUP_FIELDS.add(Constants.TARGET_STRATEGY);
            ALL_GROUP_FIELDS.add(Constants.TARGET_STRATEGY_PARAMETERS);
            ALL_GROUP_FIELDS.add(Constants.PARTICIPATION_RATE);
            ALL_GROUP_FIELDS.add(Constants.DESIGNATION);
        }
    }

    private final IntHashSet missingRequiredFields = new IntHashSet(8);

    public boolean validate()
    {
        if (rejectReason != Decoder.NO_ERROR)
        {
            return false;
        }
        final IntIterator missingFieldsIterator = missingRequiredFields.iterator();
        if (missingFieldsIterator.hasNext())
        {
            invalidTagId = missingFieldsIterator.nextValue();
            rejectReason = 1;
            return false;
        }
        if (hasSettlInstMode)
        {
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !SettlInstMode.isValid(settlInstMode()))
        {
            invalidTagId = 160;
            rejectReason = 5;
            return false;
        }
        }

        if (hasAcctIDSource)
        {
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !AcctIDSource.isValid(acctIDSource()))
        {
            invalidTagId = 660;
            rejectReason = 5;
            return false;
        }
        }

        if (hasAccountType)
        {
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !AccountType.isValid(accountType()))
        {
            invalidTagId = 581;
            rejectReason = 5;
            return false;
        }
        }

        if (hasDayBookingInst)
        {
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !DayBookingInst.isValid(dayBookingInst()))
        {
            invalidTagId = 589;
            rejectReason = 5;
            return false;
        }
        }

        if (hasBookingUnit)
        {
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !BookingUnit.isValid(bookingUnit()))
        {
            invalidTagId = 590;
            rejectReason = 5;
            return false;
        }
        }

        if (hasPreallocMethod)
        {
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !PreallocMethod.isValid(preallocMethod()))
        {
            invalidTagId = 591;
            rejectReason = 5;
            return false;
        }
        }

        if (hasSettlType)
        {
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !SettlType.isValid(settlType()))
        {
            invalidTagId = 63;
            rejectReason = 5;
            return false;
        }
        }

        if (hasCashMargin)
        {
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !CashMargin.isValid(cashMargin()))
        {
            invalidTagId = 544;
            rejectReason = 5;
            return false;
        }
        }

        if (hasClearingFeeIndicator)
        {
        clearingFeeIndicatorWrapper.wrap(this.clearingFeeIndicator(), clearingFeeIndicatorLength);
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !ClearingFeeIndicator.isValid(clearingFeeIndicatorWrapper))
        {
            invalidTagId = 635;
            rejectReason = 5;
            return false;
        }
        }

        if (hasHandlInst)
        {
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !HandlInst.isValid(handlInst()))
        {
            invalidTagId = 21;
            rejectReason = 5;
            return false;
        }
        }

        if (hasExecInst)
        {
          int execInstOffset = 0;
          for (int i = 0; i < execInstLength; i++)
          {
              if (this.execInst()[i] == ' ')
              {
                  execInstWrapper.wrap(this.execInst(), execInstOffset, i - execInstOffset);
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !ExecInst.isValid(execInstWrapper))
        {
            invalidTagId = 18;
            rejectReason = 5;
            return false;
        }
                  execInstOffset = i + 1;
              }
          }
          execInstWrapper.wrap(this.execInst(), execInstOffset, execInstLength - execInstOffset);
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !ExecInst.isValid(execInstWrapper))
        {
            invalidTagId = 18;
            rejectReason = 5;
            return false;
        }
        }

        if (hasProcessCode)
        {
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !ProcessCode.isValid(processCode()))
        {
            invalidTagId = 81;
            rejectReason = 5;
            return false;
        }
        }

        if (hasSymbolSfx)
        {
        symbolSfxWrapper.wrap(this.symbolSfx(), symbolSfxLength);
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !SymbolSfx.isValid(symbolSfxWrapper))
        {
            invalidTagId = 65;
            rejectReason = 5;
            return false;
        }
        }

        if (hasSecurityIDSource)
        {
        securityIDSourceWrapper.wrap(this.securityIDSource(), securityIDSourceLength);
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !SecurityIDSource.isValid(securityIDSourceWrapper))
        {
            invalidTagId = 22;
            rejectReason = 5;
            return false;
        }
        }

        if (hasProduct)
        {
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !Product.isValid(product()))
        {
            invalidTagId = 460;
            rejectReason = 5;
            return false;
        }
        }

        if (hasSecurityType)
        {
        securityTypeWrapper.wrap(this.securityType(), securityTypeLength);
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !SecurityType.isValid(securityTypeWrapper))
        {
            invalidTagId = 167;
            rejectReason = 5;
            return false;
        }
        }

        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !Side.isValid(side()))
        {
            invalidTagId = 54;
            rejectReason = 5;
            return false;
        }

        if (hasSideValueInd)
        {
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !SideValueInd.isValid(sideValueInd()))
        {
            invalidTagId = 401;
            rejectReason = 5;
            return false;
        }
        }

        if (hasQtyType)
        {
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !QtyType.isValid(qtyType()))
        {
            invalidTagId = 854;
            rejectReason = 5;
            return false;
        }
        }

        if (hasRoundingDirection)
        {
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !RoundingDirection.isValid(roundingDirection()))
        {
            invalidTagId = 468;
            rejectReason = 5;
            return false;
        }
        }

        if (hasOrdType)
        {
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !OrdType.isValid(ordType()))
        {
            invalidTagId = 40;
            rejectReason = 5;
            return false;
        }
        }

        if (hasPriceType)
        {
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !PriceType.isValid(priceType()))
        {
            invalidTagId = 423;
            rejectReason = 5;
            return false;
        }
        }

        if (hasBenchmarkCurveName)
        {
        benchmarkCurveNameWrapper.wrap(this.benchmarkCurveName(), benchmarkCurveNameLength);
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !BenchmarkCurveName.isValid(benchmarkCurveNameWrapper))
        {
            invalidTagId = 221;
            rejectReason = 5;
            return false;
        }
        }

        if (hasYieldType)
        {
        yieldTypeWrapper.wrap(this.yieldType(), yieldTypeLength);
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !YieldType.isValid(yieldTypeWrapper))
        {
            invalidTagId = 235;
            rejectReason = 5;
            return false;
        }
        }

        if (hasTimeInForce)
        {
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !TimeInForce.isValid(timeInForce()))
        {
            invalidTagId = 59;
            rejectReason = 5;
            return false;
        }
        }

        if (hasGTBookingInst)
        {
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !GTBookingInst.isValid(gTBookingInst()))
        {
            invalidTagId = 427;
            rejectReason = 5;
            return false;
        }
        }

        if (hasCommType)
        {
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !CommType.isValid(commType()))
        {
            invalidTagId = 13;
            rejectReason = 5;
            return false;
        }
        }

        if (hasFundRenewWaiv)
        {
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !FundRenewWaiv.isValid(fundRenewWaiv()))
        {
            invalidTagId = 497;
            rejectReason = 5;
            return false;
        }
        }

        if (hasOrderCapacity)
        {
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !OrderCapacity.isValid(orderCapacity()))
        {
            invalidTagId = 528;
            rejectReason = 5;
            return false;
        }
        }

        if (hasOrderRestrictions)
        {
          int orderRestrictionsOffset = 0;
          for (int i = 0; i < orderRestrictionsLength; i++)
          {
              if (this.orderRestrictions()[i] == ' ')
              {
                  orderRestrictionsWrapper.wrap(this.orderRestrictions(), orderRestrictionsOffset, i - orderRestrictionsOffset);
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !OrderRestrictions.isValid(orderRestrictionsWrapper))
        {
            invalidTagId = 529;
            rejectReason = 5;
            return false;
        }
                  orderRestrictionsOffset = i + 1;
              }
          }
          orderRestrictionsWrapper.wrap(this.orderRestrictions(), orderRestrictionsOffset, orderRestrictionsLength - orderRestrictionsOffset);
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !OrderRestrictions.isValid(orderRestrictionsWrapper))
        {
            invalidTagId = 529;
            rejectReason = 5;
            return false;
        }
        }

        if (hasCustOrderCapacity)
        {
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !CustOrderCapacity.isValid(custOrderCapacity()))
        {
            invalidTagId = 582;
            rejectReason = 5;
            return false;
        }
        }

        if (hasBookingType)
        {
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !BookingType.isValid(bookingType()))
        {
            invalidTagId = 775;
            rejectReason = 5;
            return false;
        }
        }

        if (hasPositionEffect)
        {
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !PositionEffect.isValid(positionEffect()))
        {
            invalidTagId = 77;
            rejectReason = 5;
            return false;
        }
        }

        if (hasCoveredOrUncovered)
        {
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !CoveredOrUncovered.isValid(coveredOrUncovered()))
        {
            invalidTagId = 203;
            rejectReason = 5;
            return false;
        }
        }

        if (hasPegMoveType)
        {
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !PegMoveType.isValid(pegMoveType()))
        {
            invalidTagId = 835;
            rejectReason = 5;
            return false;
        }
        }

        if (hasPegOffsetType)
        {
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !PegOffsetType.isValid(pegOffsetType()))
        {
            invalidTagId = 836;
            rejectReason = 5;
            return false;
        }
        }

        if (hasPegLimitType)
        {
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !PegLimitType.isValid(pegLimitType()))
        {
            invalidTagId = 837;
            rejectReason = 5;
            return false;
        }
        }

        if (hasPegRoundDirection)
        {
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !PegRoundDirection.isValid(pegRoundDirection()))
        {
            invalidTagId = 838;
            rejectReason = 5;
            return false;
        }
        }

        if (hasPegScope)
        {
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !PegScope.isValid(pegScope()))
        {
            invalidTagId = 840;
            rejectReason = 5;
            return false;
        }
        }

        if (hasDiscretionInst)
        {
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !DiscretionInst.isValid(discretionInst()))
        {
            invalidTagId = 388;
            rejectReason = 5;
            return false;
        }
        }

        if (hasDiscretionMoveType)
        {
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !DiscretionMoveType.isValid(discretionMoveType()))
        {
            invalidTagId = 841;
            rejectReason = 5;
            return false;
        }
        }

        if (hasDiscretionOffsetType)
        {
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !DiscretionOffsetType.isValid(discretionOffsetType()))
        {
            invalidTagId = 842;
            rejectReason = 5;
            return false;
        }
        }

        if (hasDiscretionLimitType)
        {
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !DiscretionLimitType.isValid(discretionLimitType()))
        {
            invalidTagId = 843;
            rejectReason = 5;
            return false;
        }
        }

        if (hasDiscretionRoundDirection)
        {
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !DiscretionRoundDirection.isValid(discretionRoundDirection()))
        {
            invalidTagId = 844;
            rejectReason = 5;
            return false;
        }
        }

        if (hasDiscretionScope)
        {
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !DiscretionScope.isValid(discretionScope()))
        {
            invalidTagId = 846;
            rejectReason = 5;
            return false;
        }
        }
        if (hasNoPartyIDsGroupCounter)
        {
            {
                int count = 0;
                final PartyIDsGroupIterator iterator = partyIDsGroupIterator.iterator();
                for (final PartyIDsGroupDecoder group : iterator)
                {
                    count++;                    if (!group.validate())
                    {
                        invalidTagId = group.invalidTagId();
                        rejectReason = group.rejectReason();
                        return false;
                    }
                }
                if (count != iterator.numberFieldValue())
                {
                    invalidTagId = 453;
                    rejectReason = 16;
                    return false;
                }
            }
        }

        if (hasNoAllocsGroupCounter)
        {
            {
                int count = 0;
                final AllocsGroupIterator iterator = allocsGroupIterator.iterator();
                for (final AllocsGroupDecoder group : iterator)
                {
                    count++;                    if (!group.validate())
                    {
                        invalidTagId = group.invalidTagId();
                        rejectReason = group.rejectReason();
                        return false;
                    }
                }
                if (count != iterator.numberFieldValue())
                {
                    invalidTagId = 78;
                    rejectReason = 16;
                    return false;
                }
            }
        }

        if (hasNoTradingSessionsGroupCounter)
        {
            {
                int count = 0;
                final TradingSessionsGroupIterator iterator = tradingSessionsGroupIterator.iterator();
                for (final TradingSessionsGroupDecoder group : iterator)
                {
                    count++;                    if (!group.validate())
                    {
                        invalidTagId = group.invalidTagId();
                        rejectReason = group.rejectReason();
                        return false;
                    }
                }
                if (count != iterator.numberFieldValue())
                {
                    invalidTagId = 386;
                    rejectReason = 16;
                    return false;
                }
            }
        }

        if (hasNoSecurityAltIDGroupCounter)
        {
            {
                int count = 0;
                final SecurityAltIDGroupIterator iterator = securityAltIDGroupIterator.iterator();
                for (final SecurityAltIDGroupDecoder group : iterator)
                {
                    count++;                    if (!group.validate())
                    {
                        invalidTagId = group.invalidTagId();
                        rejectReason = group.rejectReason();
                        return false;
                    }
                }
                if (count != iterator.numberFieldValue())
                {
                    invalidTagId = 454;
                    rejectReason = 16;
                    return false;
                }
            }
        }

        if (hasNoEventsGroupCounter)
        {
            {
                int count = 0;
                final EventsGroupIterator iterator = eventsGroupIterator.iterator();
                for (final EventsGroupDecoder group : iterator)
                {
                    count++;                    if (!group.validate())
                    {
                        invalidTagId = group.invalidTagId();
                        rejectReason = group.rejectReason();
                        return false;
                    }
                }
                if (count != iterator.numberFieldValue())
                {
                    invalidTagId = 864;
                    rejectReason = 16;
                    return false;
                }
            }
        }

        if (hasNoUnderlyingsGroupCounter)
        {
            {
                int count = 0;
                final UnderlyingsGroupIterator iterator = underlyingsGroupIterator.iterator();
                for (final UnderlyingsGroupDecoder group : iterator)
                {
                    count++;                    if (!group.validate())
                    {
                        invalidTagId = group.invalidTagId();
                        rejectReason = group.rejectReason();
                        return false;
                    }
                }
                if (count != iterator.numberFieldValue())
                {
                    invalidTagId = 711;
                    rejectReason = 16;
                    return false;
                }
            }
        }

        if (hasNoStipulationsGroupCounter)
        {
            {
                int count = 0;
                final StipulationsGroupIterator iterator = stipulationsGroupIterator.iterator();
                for (final StipulationsGroupDecoder group : iterator)
                {
                    count++;                    if (!group.validate())
                    {
                        invalidTagId = group.invalidTagId();
                        rejectReason = group.rejectReason();
                        return false;
                    }
                }
                if (count != iterator.numberFieldValue())
                {
                    invalidTagId = 232;
                    rejectReason = 16;
                    return false;
                }
            }
        }
        return true;
    }

    private final TrailerDecoder trailer;
    private final IntHashSet messageFields;
    public OrdersGroupDecoder(final TrailerDecoder trailer, final IntHashSet messageFields)
    {
        this.trailer = trailer;
        this.messageFields = messageFields;
    }

    private OrdersGroupDecoder next = null;

    public OrdersGroupDecoder next()
    {
        return next;
    }

    private IntHashSet seenFields = new IntHashSet(150);

    private char[] clOrdID = new char[1];

    /* ClOrdID = 11 */
    public char[] clOrdID()
    {
        return clOrdID;
    }


    private int clOrdIDOffset;

    private int clOrdIDLength;

    /* ClOrdID = 11 */
    public int clOrdIDLength()
    {
        return clOrdIDLength;
    }

    /* ClOrdID = 11 */
    public String clOrdIDAsString()
    {
        return new String(clOrdID, 0, clOrdIDLength);
    }

    /* ClOrdID = 11 */
    public AsciiSequenceView clOrdID(final AsciiSequenceView view)
    {
        return view.wrap(buffer, clOrdIDOffset, clOrdIDLength);
    }


    private final CharArrayWrapper clOrdIDWrapper = new CharArrayWrapper();
    private char[] secondaryClOrdID = new char[1];

    private boolean hasSecondaryClOrdID;

    /* SecondaryClOrdID = 526 */
    public char[] secondaryClOrdID()
    {
        if (!hasSecondaryClOrdID)
        {
            throw new IllegalArgumentException("No value for optional field: SecondaryClOrdID");
        }

        return secondaryClOrdID;
    }

    public boolean hasSecondaryClOrdID()
    {
        return hasSecondaryClOrdID;
    }


    private int secondaryClOrdIDOffset;

    private int secondaryClOrdIDLength;

    /* SecondaryClOrdID = 526 */
    public int secondaryClOrdIDLength()
    {
        if (!hasSecondaryClOrdID)
        {
            throw new IllegalArgumentException("No value for optional field: SecondaryClOrdID");
        }

        return secondaryClOrdIDLength;
    }

    /* SecondaryClOrdID = 526 */
    public String secondaryClOrdIDAsString()
    {
        return hasSecondaryClOrdID ? new String(secondaryClOrdID, 0, secondaryClOrdIDLength) : null;
    }

    /* SecondaryClOrdID = 526 */
    public AsciiSequenceView secondaryClOrdID(final AsciiSequenceView view)
    {
        if (!hasSecondaryClOrdID)
        {
            throw new IllegalArgumentException("No value for optional field: SecondaryClOrdID");
        }

        return view.wrap(buffer, secondaryClOrdIDOffset, secondaryClOrdIDLength);
    }


    private final CharArrayWrapper secondaryClOrdIDWrapper = new CharArrayWrapper();
    private int listSeqNo = MISSING_INT;

    /* ListSeqNo = 67 */
    public int listSeqNo()
    {
        return listSeqNo;
    }



    private char[] clOrdLinkID = new char[1];

    private boolean hasClOrdLinkID;

    /* ClOrdLinkID = 583 */
    public char[] clOrdLinkID()
    {
        if (!hasClOrdLinkID)
        {
            throw new IllegalArgumentException("No value for optional field: ClOrdLinkID");
        }

        return clOrdLinkID;
    }

    public boolean hasClOrdLinkID()
    {
        return hasClOrdLinkID;
    }


    private int clOrdLinkIDOffset;

    private int clOrdLinkIDLength;

    /* ClOrdLinkID = 583 */
    public int clOrdLinkIDLength()
    {
        if (!hasClOrdLinkID)
        {
            throw new IllegalArgumentException("No value for optional field: ClOrdLinkID");
        }

        return clOrdLinkIDLength;
    }

    /* ClOrdLinkID = 583 */
    public String clOrdLinkIDAsString()
    {
        return hasClOrdLinkID ? new String(clOrdLinkID, 0, clOrdLinkIDLength) : null;
    }

    /* ClOrdLinkID = 583 */
    public AsciiSequenceView clOrdLinkID(final AsciiSequenceView view)
    {
        if (!hasClOrdLinkID)
        {
            throw new IllegalArgumentException("No value for optional field: ClOrdLinkID");
        }

        return view.wrap(buffer, clOrdLinkIDOffset, clOrdLinkIDLength);
    }


    private final CharArrayWrapper clOrdLinkIDWrapper = new CharArrayWrapper();
    private char settlInstMode = MISSING_CHAR;

    private boolean hasSettlInstMode;

    /* SettlInstMode = 160 */
    public char settlInstMode()
    {
        if (!hasSettlInstMode)
        {
            throw new IllegalArgumentException("No value for optional field: SettlInstMode");
        }

        return settlInstMode;
    }

    public boolean hasSettlInstMode()
    {
        return hasSettlInstMode;
    }



    private final CharArrayWrapper settlInstModeWrapper = new CharArrayWrapper();
    /* SettlInstMode = 160 */
    public SettlInstMode settlInstModeAsEnum()
    {
        if (!hasSettlInstMode)
 return SettlInstMode.NULL_VAL;
        return SettlInstMode.decode(settlInstMode);
    }



    private PartyIDsGroupDecoder partyIDsGroup = null;
    public PartyIDsGroupDecoder partyIDsGroup()
    {
        return partyIDsGroup;
    }

    private int noPartyIDsGroupCounter = MISSING_INT;

    private boolean hasNoPartyIDsGroupCounter;

    /* NoPartyIDsGroupCounter = 453 */
    public int noPartyIDsGroupCounter()
    {
        if (!hasNoPartyIDsGroupCounter)
        {
            throw new IllegalArgumentException("No value for optional field: NoPartyIDsGroupCounter");
        }

        return noPartyIDsGroupCounter;
    }

    public boolean hasNoPartyIDsGroupCounter()
    {
        return hasNoPartyIDsGroupCounter;
    }




    private PartyIDsGroupIterator partyIDsGroupIterator = new PartyIDsGroupIterator(this);
    public PartyIDsGroupIterator partyIDsGroupIterator()
    {
        return partyIDsGroupIterator.iterator();
    }


    private byte[] tradeOriginationDate = new byte[8];

    private boolean hasTradeOriginationDate;

    /* TradeOriginationDate = 229 */
    public byte[] tradeOriginationDate()
    {
        if (!hasTradeOriginationDate)
        {
            throw new IllegalArgumentException("No value for optional field: TradeOriginationDate");
        }

        return tradeOriginationDate;
    }

    public boolean hasTradeOriginationDate()
    {
        return hasTradeOriginationDate;
    }


    private int tradeOriginationDateOffset;

    private int tradeOriginationDateLength;

    /* TradeOriginationDate = 229 */
    public int tradeOriginationDateLength()
    {
        if (!hasTradeOriginationDate)
        {
            throw new IllegalArgumentException("No value for optional field: TradeOriginationDate");
        }

        return tradeOriginationDateLength;
    }

    /* TradeOriginationDate = 229 */
    public String tradeOriginationDateAsString()
    {
        return hasTradeOriginationDate ? new String(tradeOriginationDate, 0, tradeOriginationDateLength) : null;
    }

    /* TradeOriginationDate = 229 */
    public AsciiSequenceView tradeOriginationDate(final AsciiSequenceView view)
    {
        if (!hasTradeOriginationDate)
        {
            throw new IllegalArgumentException("No value for optional field: TradeOriginationDate");
        }

        return view.wrap(buffer, tradeOriginationDateOffset, tradeOriginationDateLength);
    }


    private byte[] tradeDate = new byte[8];

    private boolean hasTradeDate;

    /* TradeDate = 75 */
    public byte[] tradeDate()
    {
        if (!hasTradeDate)
        {
            throw new IllegalArgumentException("No value for optional field: TradeDate");
        }

        return tradeDate;
    }

    public boolean hasTradeDate()
    {
        return hasTradeDate;
    }


    private int tradeDateOffset;

    private int tradeDateLength;

    /* TradeDate = 75 */
    public int tradeDateLength()
    {
        if (!hasTradeDate)
        {
            throw new IllegalArgumentException("No value for optional field: TradeDate");
        }

        return tradeDateLength;
    }

    /* TradeDate = 75 */
    public String tradeDateAsString()
    {
        return hasTradeDate ? new String(tradeDate, 0, tradeDateLength) : null;
    }

    /* TradeDate = 75 */
    public AsciiSequenceView tradeDate(final AsciiSequenceView view)
    {
        if (!hasTradeDate)
        {
            throw new IllegalArgumentException("No value for optional field: TradeDate");
        }

        return view.wrap(buffer, tradeDateOffset, tradeDateLength);
    }


    private char[] account = new char[1];

    private boolean hasAccount;

    /* Account = 1 */
    public char[] account()
    {
        if (!hasAccount)
        {
            throw new IllegalArgumentException("No value for optional field: Account");
        }

        return account;
    }

    public boolean hasAccount()
    {
        return hasAccount;
    }


    private int accountOffset;

    private int accountLength;

    /* Account = 1 */
    public int accountLength()
    {
        if (!hasAccount)
        {
            throw new IllegalArgumentException("No value for optional field: Account");
        }

        return accountLength;
    }

    /* Account = 1 */
    public String accountAsString()
    {
        return hasAccount ? new String(account, 0, accountLength) : null;
    }

    /* Account = 1 */
    public AsciiSequenceView account(final AsciiSequenceView view)
    {
        if (!hasAccount)
        {
            throw new IllegalArgumentException("No value for optional field: Account");
        }

        return view.wrap(buffer, accountOffset, accountLength);
    }


    private final CharArrayWrapper accountWrapper = new CharArrayWrapper();
    private int acctIDSource = MISSING_INT;

    private boolean hasAcctIDSource;

    /* AcctIDSource = 660 */
    public int acctIDSource()
    {
        if (!hasAcctIDSource)
        {
            throw new IllegalArgumentException("No value for optional field: AcctIDSource");
        }

        return acctIDSource;
    }

    public boolean hasAcctIDSource()
    {
        return hasAcctIDSource;
    }



    private final CharArrayWrapper acctIDSourceWrapper = new CharArrayWrapper();
    /* AcctIDSource = 660 */
    public AcctIDSource acctIDSourceAsEnum()
    {
        if (!hasAcctIDSource)
 return AcctIDSource.NULL_VAL;
        return AcctIDSource.decode(acctIDSource);
    }

    private int accountType = MISSING_INT;

    private boolean hasAccountType;

    /* AccountType = 581 */
    public int accountType()
    {
        if (!hasAccountType)
        {
            throw new IllegalArgumentException("No value for optional field: AccountType");
        }

        return accountType;
    }

    public boolean hasAccountType()
    {
        return hasAccountType;
    }



    private final CharArrayWrapper accountTypeWrapper = new CharArrayWrapper();
    /* AccountType = 581 */
    public AccountType accountTypeAsEnum()
    {
        if (!hasAccountType)
 return AccountType.NULL_VAL;
        return AccountType.decode(accountType);
    }

    private char dayBookingInst = MISSING_CHAR;

    private boolean hasDayBookingInst;

    /* DayBookingInst = 589 */
    public char dayBookingInst()
    {
        if (!hasDayBookingInst)
        {
            throw new IllegalArgumentException("No value for optional field: DayBookingInst");
        }

        return dayBookingInst;
    }

    public boolean hasDayBookingInst()
    {
        return hasDayBookingInst;
    }



    private final CharArrayWrapper dayBookingInstWrapper = new CharArrayWrapper();
    /* DayBookingInst = 589 */
    public DayBookingInst dayBookingInstAsEnum()
    {
        if (!hasDayBookingInst)
 return DayBookingInst.NULL_VAL;
        return DayBookingInst.decode(dayBookingInst);
    }

    private char bookingUnit = MISSING_CHAR;

    private boolean hasBookingUnit;

    /* BookingUnit = 590 */
    public char bookingUnit()
    {
        if (!hasBookingUnit)
        {
            throw new IllegalArgumentException("No value for optional field: BookingUnit");
        }

        return bookingUnit;
    }

    public boolean hasBookingUnit()
    {
        return hasBookingUnit;
    }



    private final CharArrayWrapper bookingUnitWrapper = new CharArrayWrapper();
    /* BookingUnit = 590 */
    public BookingUnit bookingUnitAsEnum()
    {
        if (!hasBookingUnit)
 return BookingUnit.NULL_VAL;
        return BookingUnit.decode(bookingUnit);
    }

    private char[] allocID = new char[1];

    private boolean hasAllocID;

    /* AllocID = 70 */
    public char[] allocID()
    {
        if (!hasAllocID)
        {
            throw new IllegalArgumentException("No value for optional field: AllocID");
        }

        return allocID;
    }

    public boolean hasAllocID()
    {
        return hasAllocID;
    }


    private int allocIDOffset;

    private int allocIDLength;

    /* AllocID = 70 */
    public int allocIDLength()
    {
        if (!hasAllocID)
        {
            throw new IllegalArgumentException("No value for optional field: AllocID");
        }

        return allocIDLength;
    }

    /* AllocID = 70 */
    public String allocIDAsString()
    {
        return hasAllocID ? new String(allocID, 0, allocIDLength) : null;
    }

    /* AllocID = 70 */
    public AsciiSequenceView allocID(final AsciiSequenceView view)
    {
        if (!hasAllocID)
        {
            throw new IllegalArgumentException("No value for optional field: AllocID");
        }

        return view.wrap(buffer, allocIDOffset, allocIDLength);
    }


    private final CharArrayWrapper allocIDWrapper = new CharArrayWrapper();
    private char preallocMethod = MISSING_CHAR;

    private boolean hasPreallocMethod;

    /* PreallocMethod = 591 */
    public char preallocMethod()
    {
        if (!hasPreallocMethod)
        {
            throw new IllegalArgumentException("No value for optional field: PreallocMethod");
        }

        return preallocMethod;
    }

    public boolean hasPreallocMethod()
    {
        return hasPreallocMethod;
    }



    private final CharArrayWrapper preallocMethodWrapper = new CharArrayWrapper();
    /* PreallocMethod = 591 */
    public PreallocMethod preallocMethodAsEnum()
    {
        if (!hasPreallocMethod)
 return PreallocMethod.NULL_VAL;
        return PreallocMethod.decode(preallocMethod);
    }


@Generated("uk.co.real_logic.artio")
public class AllocsGroupDecoder extends CommonDecoderImpl implements NestedPartiesDecoder
{
    public final IntHashSet REQUIRED_FIELDS = new IntHashSet(0);

    {
        if (CODEC_VALIDATION_ENABLED)
        {
        }
    }

    public final IntHashSet GROUP_FIELDS = new IntHashSet(10);

    {
        if (CODEC_VALIDATION_ENABLED)
        {
            GROUP_FIELDS.add(Constants.ALLOC_ACCOUNT);
            GROUP_FIELDS.add(Constants.ALLOC_ACCT_ID_SOURCE);
            GROUP_FIELDS.add(Constants.ALLOC_SETTL_CURRENCY);
            GROUP_FIELDS.add(Constants.INDIVIDUAL_ALLOC_ID);
            GROUP_FIELDS.add(Constants.ALLOC_QTY);
        }
    }

    public final IntHashSet ALL_GROUP_FIELDS = new IntHashSet(10);

    {
        if (CODEC_VALIDATION_ENABLED)
        {
            ALL_GROUP_FIELDS.add(Constants.ALLOC_ACCOUNT);
            ALL_GROUP_FIELDS.add(Constants.ALLOC_ACCT_ID_SOURCE);
            ALL_GROUP_FIELDS.add(Constants.ALLOC_SETTL_CURRENCY);
            ALL_GROUP_FIELDS.add(Constants.INDIVIDUAL_ALLOC_ID);
            ALL_GROUP_FIELDS.add(Constants.ALLOC_QTY);
        }
    }

    private final IntHashSet missingRequiredFields = new IntHashSet(0);

    public boolean validate()
    {
        if (rejectReason != Decoder.NO_ERROR)
        {
            return false;
        }
        final IntIterator missingFieldsIterator = missingRequiredFields.iterator();
        if (missingFieldsIterator.hasNext())
        {
            invalidTagId = missingFieldsIterator.nextValue();
            rejectReason = 1;
            return false;
        }
        if (hasNoNestedPartyIDsGroupCounter)
        {
            {
                int count = 0;
                final NestedPartyIDsGroupIterator iterator = nestedPartyIDsGroupIterator.iterator();
                for (final NestedPartyIDsGroupDecoder group : iterator)
                {
                    count++;                    if (!group.validate())
                    {
                        invalidTagId = group.invalidTagId();
                        rejectReason = group.rejectReason();
                        return false;
                    }
                }
                if (count != iterator.numberFieldValue())
                {
                    invalidTagId = 539;
                    rejectReason = 16;
                    return false;
                }
            }
        }
        return true;
    }

    private final TrailerDecoder trailer;
    private final IntHashSet messageFields;
    public AllocsGroupDecoder(final TrailerDecoder trailer, final IntHashSet messageFields)
    {
        this.trailer = trailer;
        this.messageFields = messageFields;
    }

    private AllocsGroupDecoder next = null;

    public AllocsGroupDecoder next()
    {
        return next;
    }

    private IntHashSet seenFields = new IntHashSet(12);

    private char[] allocAccount = new char[1];

    private boolean hasAllocAccount;

    /* AllocAccount = 79 */
    public char[] allocAccount()
    {
        if (!hasAllocAccount)
        {
            throw new IllegalArgumentException("No value for optional field: AllocAccount");
        }

        return allocAccount;
    }

    public boolean hasAllocAccount()
    {
        return hasAllocAccount;
    }


    private int allocAccountOffset;

    private int allocAccountLength;

    /* AllocAccount = 79 */
    public int allocAccountLength()
    {
        if (!hasAllocAccount)
        {
            throw new IllegalArgumentException("No value for optional field: AllocAccount");
        }

        return allocAccountLength;
    }

    /* AllocAccount = 79 */
    public String allocAccountAsString()
    {
        return hasAllocAccount ? new String(allocAccount, 0, allocAccountLength) : null;
    }

    /* AllocAccount = 79 */
    public AsciiSequenceView allocAccount(final AsciiSequenceView view)
    {
        if (!hasAllocAccount)
        {
            throw new IllegalArgumentException("No value for optional field: AllocAccount");
        }

        return view.wrap(buffer, allocAccountOffset, allocAccountLength);
    }


    private final CharArrayWrapper allocAccountWrapper = new CharArrayWrapper();
    private int allocAcctIDSource = MISSING_INT;

    private boolean hasAllocAcctIDSource;

    /* AllocAcctIDSource = 661 */
    public int allocAcctIDSource()
    {
        if (!hasAllocAcctIDSource)
        {
            throw new IllegalArgumentException("No value for optional field: AllocAcctIDSource");
        }

        return allocAcctIDSource;
    }

    public boolean hasAllocAcctIDSource()
    {
        return hasAllocAcctIDSource;
    }



    private char[] allocSettlCurrency = new char[1];

    private boolean hasAllocSettlCurrency;

    /* AllocSettlCurrency = 736 */
    public char[] allocSettlCurrency()
    {
        if (!hasAllocSettlCurrency)
        {
            throw new IllegalArgumentException("No value for optional field: AllocSettlCurrency");
        }

        return allocSettlCurrency;
    }

    public boolean hasAllocSettlCurrency()
    {
        return hasAllocSettlCurrency;
    }


    private int allocSettlCurrencyOffset;

    private int allocSettlCurrencyLength;

    /* AllocSettlCurrency = 736 */
    public int allocSettlCurrencyLength()
    {
        if (!hasAllocSettlCurrency)
        {
            throw new IllegalArgumentException("No value for optional field: AllocSettlCurrency");
        }

        return allocSettlCurrencyLength;
    }

    /* AllocSettlCurrency = 736 */
    public String allocSettlCurrencyAsString()
    {
        return hasAllocSettlCurrency ? new String(allocSettlCurrency, 0, allocSettlCurrencyLength) : null;
    }

    /* AllocSettlCurrency = 736 */
    public AsciiSequenceView allocSettlCurrency(final AsciiSequenceView view)
    {
        if (!hasAllocSettlCurrency)
        {
            throw new IllegalArgumentException("No value for optional field: AllocSettlCurrency");
        }

        return view.wrap(buffer, allocSettlCurrencyOffset, allocSettlCurrencyLength);
    }


    private char[] individualAllocID = new char[1];

    private boolean hasIndividualAllocID;

    /* IndividualAllocID = 467 */
    public char[] individualAllocID()
    {
        if (!hasIndividualAllocID)
        {
            throw new IllegalArgumentException("No value for optional field: IndividualAllocID");
        }

        return individualAllocID;
    }

    public boolean hasIndividualAllocID()
    {
        return hasIndividualAllocID;
    }


    private int individualAllocIDOffset;

    private int individualAllocIDLength;

    /* IndividualAllocID = 467 */
    public int individualAllocIDLength()
    {
        if (!hasIndividualAllocID)
        {
            throw new IllegalArgumentException("No value for optional field: IndividualAllocID");
        }

        return individualAllocIDLength;
    }

    /* IndividualAllocID = 467 */
    public String individualAllocIDAsString()
    {
        return hasIndividualAllocID ? new String(individualAllocID, 0, individualAllocIDLength) : null;
    }

    /* IndividualAllocID = 467 */
    public AsciiSequenceView individualAllocID(final AsciiSequenceView view)
    {
        if (!hasIndividualAllocID)
        {
            throw new IllegalArgumentException("No value for optional field: IndividualAllocID");
        }

        return view.wrap(buffer, individualAllocIDOffset, individualAllocIDLength);
    }


    private final CharArrayWrapper individualAllocIDWrapper = new CharArrayWrapper();


    private NestedPartyIDsGroupDecoder nestedPartyIDsGroup = null;
    public NestedPartyIDsGroupDecoder nestedPartyIDsGroup()
    {
        return nestedPartyIDsGroup;
    }

    private int noNestedPartyIDsGroupCounter = MISSING_INT;

    private boolean hasNoNestedPartyIDsGroupCounter;

    /* NoNestedPartyIDsGroupCounter = 539 */
    public int noNestedPartyIDsGroupCounter()
    {
        if (!hasNoNestedPartyIDsGroupCounter)
        {
            throw new IllegalArgumentException("No value for optional field: NoNestedPartyIDsGroupCounter");
        }

        return noNestedPartyIDsGroupCounter;
    }

    public boolean hasNoNestedPartyIDsGroupCounter()
    {
        return hasNoNestedPartyIDsGroupCounter;
    }




    private NestedPartyIDsGroupIterator nestedPartyIDsGroupIterator = new NestedPartyIDsGroupIterator(this);
    public NestedPartyIDsGroupIterator nestedPartyIDsGroupIterator()
    {
        return nestedPartyIDsGroupIterator.iterator();
    }


    private DecimalFloat allocQty = DecimalFloat.newNaNValue();

    private boolean hasAllocQty;

    /* AllocQty = 80 */
    public DecimalFloat allocQty()
    {
        if (!hasAllocQty)
        {
            throw new IllegalArgumentException("No value for optional field: AllocQty");
        }

        return allocQty;
    }

    public boolean hasAllocQty()
    {
        return hasAllocQty;
    }



    public int decode(final AsciiBuffer buffer, final int offset, final int length)
    {
        // Decode AllocsGroup
        int seenFieldCount = 0;
        if (CODEC_VALIDATION_ENABLED)
        {
            missingRequiredFields.copy(REQUIRED_FIELDS);
        }
        this.buffer = buffer;
        final int end = offset + length;
        int position = offset;
        seenFields.clear();
        int tag;

        while (position < end)
        {
            final int equalsPosition = buffer.scan(position, end, '=');
            if (equalsPosition == AsciiBuffer.UNKNOWN_INDEX)
            {
               return position;
            }
            tag = buffer.getInt(position, equalsPosition);
            if (!seenFields.add(tag))
            {
                if (next == null)
                {
                    next = new AllocsGroupDecoder(trailer, messageFields);
                }
                return position - offset;
            }
            final int valueOffset = equalsPosition + 1;
            int endOfField = buffer.scan(valueOffset, end, START_OF_HEADER);
            if (endOfField == AsciiBuffer.UNKNOWN_INDEX || equalsPosition == AsciiBuffer.UNKNOWN_INDEX)
            {
                rejectReason = 5;
                break;
            }
            final int valueLength = endOfField - valueOffset;
            if (CODEC_VALIDATION_ENABLED)
            {
                if (tag <= 0)
                {
                    invalidTagId = tag;
                    rejectReason = 0;
                }
                else if (valueLength == 0)
                {
                    invalidTagId = tag;
                    rejectReason = 4;
                }
                missingRequiredFields.remove(tag);
                seenFieldCount++;
            }

            switch (tag)
            {
            case Constants.ALLOC_ACCOUNT:
                hasAllocAccount = true;
                allocAccount = buffer.getChars(allocAccount, valueOffset, valueLength);
                allocAccountOffset = valueOffset;
                allocAccountLength = valueLength;
                break;

            case Constants.ALLOC_ACCT_ID_SOURCE:
                hasAllocAcctIDSource = true;
                allocAcctIDSource = getInt(buffer, valueOffset, endOfField, 661, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.ALLOC_SETTL_CURRENCY:
                hasAllocSettlCurrency = true;
                allocSettlCurrency = buffer.getChars(allocSettlCurrency, valueOffset, valueLength);
                allocSettlCurrencyOffset = valueOffset;
                allocSettlCurrencyLength = valueLength;
                break;

            case Constants.INDIVIDUAL_ALLOC_ID:
                hasIndividualAllocID = true;
                individualAllocID = buffer.getChars(individualAllocID, valueOffset, valueLength);
                individualAllocIDOffset = valueOffset;
                individualAllocIDLength = valueLength;
                break;

            case Constants.NO_NESTED_PARTY_IDS_GROUP_COUNTER:
                hasNoNestedPartyIDsGroupCounter = true;
                noNestedPartyIDsGroupCounter = getInt(buffer, valueOffset, endOfField, 539, CODEC_VALIDATION_ENABLED);
                if (nestedPartyIDsGroup == null)
                {
                    nestedPartyIDsGroup = new NestedPartyIDsGroupDecoder(trailer, messageFields);
                }
                NestedPartyIDsGroupDecoder nestedPartyIDsGroupCurrent = nestedPartyIDsGroup;
                position = endOfField + 1;
                final int noNestedPartyIDsGroupCounter = this.noNestedPartyIDsGroupCounter;
                for (int i = 0; i < noNestedPartyIDsGroupCounter && position < end; i++)
                {
                    if (nestedPartyIDsGroupCurrent != null)
                    {
                        position += nestedPartyIDsGroupCurrent.decode(buffer, position, end - position);
                        nestedPartyIDsGroupCurrent = nestedPartyIDsGroupCurrent.next();
                    }
                }
                if (CODEC_VALIDATION_ENABLED)
                {
                    final int checkEqualsPosition = buffer.scan(position, end, '=');
                    if (checkEqualsPosition != AsciiBuffer.UNKNOWN_INDEX)
                    {
                        final int checkTag = buffer.getInt(position, checkEqualsPosition);
                        if (nestedPartyIDsGroup.ALL_GROUP_FIELDS.contains(checkTag))
                        {
                            invalidTagId = tag;
                            rejectReason = 16;
                            return position;
                        }
                    }
                }
                break;


            case Constants.ALLOC_QTY:
                hasAllocQty = true;
                allocQty = getFloat(buffer, allocQty, valueOffset, valueLength, 80, CODEC_VALIDATION_ENABLED);
                break;

            default:
                if (!CODEC_REJECT_UNKNOWN_FIELD_ENABLED)
                {
                    seenFields.remove(tag);
                }
                if (CODEC_REJECT_UNKNOWN_FIELD_ENABLED || (trailer.REQUIRED_FIELDS.contains(tag) || messageFields.contains(tag)))
                {
                    return position - offset;
                }

            }

            if (position < (endOfField + 1))
            {
                position = endOfField + 1;
            }
        }
        return position - offset;
    }

    public void reset()
    {
        this.resetAllocAccount();
        this.resetAllocAcctIDSource();
        this.resetAllocSettlCurrency();
        this.resetIndividualAllocID();
        this.resetAllocQty();
        this.resetNestedPartyIDsGroup();
        buffer = null;
        if (CODEC_VALIDATION_ENABLED)
        {
            invalidTagId = Decoder.NO_ERROR;
            rejectReason = Decoder.NO_ERROR;
            missingRequiredFields.clear();
        }
    }

    public void resetAllocAccount()
    {
        hasAllocAccount = false;
    }

    public void resetAllocAcctIDSource()
    {
        hasAllocAcctIDSource = false;
    }

    public void resetAllocSettlCurrency()
    {
        hasAllocSettlCurrency = false;
    }

    public void resetIndividualAllocID()
    {
        hasIndividualAllocID = false;
    }

    public void resetAllocQty()
    {
        hasAllocQty = false;
    }

    public void resetNestedPartyIDsGroup()
    {
        for (final NestedPartyIDsGroupDecoder nestedPartyIDsGroupDecoder : nestedPartyIDsGroupIterator.iterator())
        {
            nestedPartyIDsGroupDecoder.reset();
            if (nestedPartyIDsGroupDecoder.next() == null)
            {
                break;
            }
        }
        noNestedPartyIDsGroupCounter = MISSING_INT;
        hasNoNestedPartyIDsGroupCounter = false;
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
        builder.append("\"MessageName\": \"AllocsGroup\",\n");
        if (hasAllocAccount())
        {
            indent(builder, level);
            builder.append("\"AllocAccount\": \"");
            builder.append(this.allocAccount(), 0, allocAccountLength());
            builder.append("\",\n");
        }

        if (hasAllocAcctIDSource())
        {
            indent(builder, level);
            builder.append("\"AllocAcctIDSource\": \"");
            builder.append(allocAcctIDSource);
            builder.append("\",\n");
        }

        if (hasAllocSettlCurrency())
        {
            indent(builder, level);
            builder.append("\"AllocSettlCurrency\": \"");
            builder.append(this.allocSettlCurrency(), 0, allocSettlCurrencyLength());
            builder.append("\",\n");
        }

        if (hasIndividualAllocID())
        {
            indent(builder, level);
            builder.append("\"IndividualAllocID\": \"");
            builder.append(this.individualAllocID(), 0, individualAllocIDLength());
            builder.append("\",\n");
        }

        if (hasNoNestedPartyIDsGroupCounter)
        {
            indent(builder, level);
            builder.append("\"NestedPartyIDsGroup\": [\n");
            NestedPartyIDsGroupDecoder nestedPartyIDsGroup = this.nestedPartyIDsGroup;
            for (int i = 0, size = this.noNestedPartyIDsGroupCounter; i < size; i++)
            {
                indent(builder, level);
                nestedPartyIDsGroup.appendTo(builder, level + 1);
                if (nestedPartyIDsGroup.next() != null)
                {
                    builder.append(',');
                }
                builder.append('\n');
                nestedPartyIDsGroup = nestedPartyIDsGroup.next();            }
            indent(builder, level);
            builder.append("],\n");
        }

        if (hasAllocQty())
        {
            indent(builder, level);
            builder.append("\"AllocQty\": \"");
            allocQty.appendTo(builder);
            builder.append("\",\n");
        }
        indent(builder, level - 1);
        builder.append("}");
        return builder;
    }

    /**
     * {@inheritDoc}
     */
    public OrdersGroupEncoder.AllocsGroupEncoder toEncoder(final Encoder encoder)
    {
        return toEncoder((OrdersGroupEncoder.AllocsGroupEncoder)encoder);
    }

    public OrdersGroupEncoder.AllocsGroupEncoder toEncoder(final OrdersGroupEncoder.AllocsGroupEncoder encoder)
    {
        encoder.reset();
        if (hasAllocAccount())
        {
            encoder.allocAccount(this.allocAccount(), 0, allocAccountLength());
        }

        if (hasAllocAcctIDSource())
        {
            encoder.allocAcctIDSource(this.allocAcctIDSource());
        }

        if (hasAllocSettlCurrency())
        {
            encoder.allocSettlCurrency(this.allocSettlCurrency(), 0, allocSettlCurrencyLength());
        }

        if (hasIndividualAllocID())
        {
            encoder.individualAllocID(this.individualAllocID(), 0, individualAllocIDLength());
        }


        final NestedPartiesEncoder nestedParties = encoder.nestedParties();        if (hasNoNestedPartyIDsGroupCounter)
        {
            final int size = this.noNestedPartyIDsGroupCounter;
            NestedPartyIDsGroupDecoder nestedPartyIDsGroup = this.nestedPartyIDsGroup;
            NestedPartyIDsGroupEncoder nestedPartyIDsGroupEncoder = nestedParties.nestedPartyIDsGroup(size);
            for (int i = 0; i < size; i++)
            {
                if (nestedPartyIDsGroup != null)
                {
                    nestedPartyIDsGroup.toEncoder(nestedPartyIDsGroupEncoder);
                    nestedPartyIDsGroup = nestedPartyIDsGroup.next();
                    nestedPartyIDsGroupEncoder = nestedPartyIDsGroupEncoder.next();
                }
            }
        }


        if (hasAllocQty())
        {
            encoder.allocQty(this.allocQty());
        }
        return encoder;
    }

}
    @Generated("uk.co.real_logic.artio")
    public class AllocsGroupIterator implements Iterable<AllocsGroupDecoder>, java.util.Iterator<AllocsGroupDecoder>
    {
        private final OrdersGroupDecoder parent;
        private int remainder;
        private AllocsGroupDecoder current;

        public AllocsGroupIterator(final OrdersGroupDecoder parent)
        {
            this.parent = parent;
        }

        public boolean hasNext()
        {
            return remainder > 0 && current != null;
        }

        public AllocsGroupDecoder next()
        {
            remainder--;
            final AllocsGroupDecoder value = current;
            current = current.next();
            return value;
        }

        public int numberFieldValue()
        {
            return parent.hasNoAllocsGroupCounter() ? parent.noAllocsGroupCounter() : 0;
        }

        public void reset()
        {
            remainder = numberFieldValue();
            current = parent.allocsGroup();
        }

        public AllocsGroupIterator iterator()
        {
            reset();
            return this;
        }

    }


    private AllocsGroupDecoder allocsGroup = null;
    public AllocsGroupDecoder allocsGroup()
    {
        return allocsGroup;
    }

    private int noAllocsGroupCounter = MISSING_INT;

    private boolean hasNoAllocsGroupCounter;

    /* NoAllocsGroupCounter = 78 */
    public int noAllocsGroupCounter()
    {
        if (!hasNoAllocsGroupCounter)
        {
            throw new IllegalArgumentException("No value for optional field: NoAllocsGroupCounter");
        }

        return noAllocsGroupCounter;
    }

    public boolean hasNoAllocsGroupCounter()
    {
        return hasNoAllocsGroupCounter;
    }




    private AllocsGroupIterator allocsGroupIterator = new AllocsGroupIterator(this);
    public AllocsGroupIterator allocsGroupIterator()
    {
        return allocsGroupIterator.iterator();
    }

    private char settlType = MISSING_CHAR;

    private boolean hasSettlType;

    /* SettlType = 63 */
    public char settlType()
    {
        if (!hasSettlType)
        {
            throw new IllegalArgumentException("No value for optional field: SettlType");
        }

        return settlType;
    }

    public boolean hasSettlType()
    {
        return hasSettlType;
    }



    private final CharArrayWrapper settlTypeWrapper = new CharArrayWrapper();
    /* SettlType = 63 */
    public SettlType settlTypeAsEnum()
    {
        if (!hasSettlType)
 return SettlType.NULL_VAL;
        return SettlType.decode(settlType);
    }

    private byte[] settlDate = new byte[8];

    private boolean hasSettlDate;

    /* SettlDate = 64 */
    public byte[] settlDate()
    {
        if (!hasSettlDate)
        {
            throw new IllegalArgumentException("No value for optional field: SettlDate");
        }

        return settlDate;
    }

    public boolean hasSettlDate()
    {
        return hasSettlDate;
    }


    private int settlDateOffset;

    private int settlDateLength;

    /* SettlDate = 64 */
    public int settlDateLength()
    {
        if (!hasSettlDate)
        {
            throw new IllegalArgumentException("No value for optional field: SettlDate");
        }

        return settlDateLength;
    }

    /* SettlDate = 64 */
    public String settlDateAsString()
    {
        return hasSettlDate ? new String(settlDate, 0, settlDateLength) : null;
    }

    /* SettlDate = 64 */
    public AsciiSequenceView settlDate(final AsciiSequenceView view)
    {
        if (!hasSettlDate)
        {
            throw new IllegalArgumentException("No value for optional field: SettlDate");
        }

        return view.wrap(buffer, settlDateOffset, settlDateLength);
    }


    private char cashMargin = MISSING_CHAR;

    private boolean hasCashMargin;

    /* CashMargin = 544 */
    public char cashMargin()
    {
        if (!hasCashMargin)
        {
            throw new IllegalArgumentException("No value for optional field: CashMargin");
        }

        return cashMargin;
    }

    public boolean hasCashMargin()
    {
        return hasCashMargin;
    }



    private final CharArrayWrapper cashMarginWrapper = new CharArrayWrapper();
    /* CashMargin = 544 */
    public CashMargin cashMarginAsEnum()
    {
        if (!hasCashMargin)
 return CashMargin.NULL_VAL;
        return CashMargin.decode(cashMargin);
    }

    private char[] clearingFeeIndicator = new char[1];

    private boolean hasClearingFeeIndicator;

    /* ClearingFeeIndicator = 635 */
    public char[] clearingFeeIndicator()
    {
        if (!hasClearingFeeIndicator)
        {
            throw new IllegalArgumentException("No value for optional field: ClearingFeeIndicator");
        }

        return clearingFeeIndicator;
    }

    public boolean hasClearingFeeIndicator()
    {
        return hasClearingFeeIndicator;
    }


    private int clearingFeeIndicatorOffset;

    private int clearingFeeIndicatorLength;

    /* ClearingFeeIndicator = 635 */
    public int clearingFeeIndicatorLength()
    {
        if (!hasClearingFeeIndicator)
        {
            throw new IllegalArgumentException("No value for optional field: ClearingFeeIndicator");
        }

        return clearingFeeIndicatorLength;
    }

    /* ClearingFeeIndicator = 635 */
    public String clearingFeeIndicatorAsString()
    {
        return hasClearingFeeIndicator ? new String(clearingFeeIndicator, 0, clearingFeeIndicatorLength) : null;
    }

    /* ClearingFeeIndicator = 635 */
    public AsciiSequenceView clearingFeeIndicator(final AsciiSequenceView view)
    {
        if (!hasClearingFeeIndicator)
        {
            throw new IllegalArgumentException("No value for optional field: ClearingFeeIndicator");
        }

        return view.wrap(buffer, clearingFeeIndicatorOffset, clearingFeeIndicatorLength);
    }


    private final CharArrayWrapper clearingFeeIndicatorWrapper = new CharArrayWrapper();
    /* ClearingFeeIndicator = 635 */
    public ClearingFeeIndicator clearingFeeIndicatorAsEnum()
    {
        if (!hasClearingFeeIndicator)
 return ClearingFeeIndicator.NULL_VAL;
        clearingFeeIndicatorWrapper.wrap(this.clearingFeeIndicator(), clearingFeeIndicatorLength);
        return ClearingFeeIndicator.decode(clearingFeeIndicatorWrapper);
    }

    private char handlInst = MISSING_CHAR;

    private boolean hasHandlInst;

    /* HandlInst = 21 */
    public char handlInst()
    {
        if (!hasHandlInst)
        {
            throw new IllegalArgumentException("No value for optional field: HandlInst");
        }

        return handlInst;
    }

    public boolean hasHandlInst()
    {
        return hasHandlInst;
    }



    private final CharArrayWrapper handlInstWrapper = new CharArrayWrapper();
    /* HandlInst = 21 */
    public HandlInst handlInstAsEnum()
    {
        if (!hasHandlInst)
 return HandlInst.NULL_VAL;
        return HandlInst.decode(handlInst);
    }

    private char[] execInst = new char[1];

    private boolean hasExecInst;

    /* ExecInst = 18 */
    public char[] execInst()
    {
        if (!hasExecInst)
        {
            throw new IllegalArgumentException("No value for optional field: ExecInst");
        }

        return execInst;
    }

    public boolean hasExecInst()
    {
        return hasExecInst;
    }


    private int execInstOffset;

    private int execInstLength;

    /* ExecInst = 18 */
    public int execInstLength()
    {
        if (!hasExecInst)
        {
            throw new IllegalArgumentException("No value for optional field: ExecInst");
        }

        return execInstLength;
    }

    /* ExecInst = 18 */
    public String execInstAsString()
    {
        return hasExecInst ? new String(execInst, 0, execInstLength) : null;
    }

    /* ExecInst = 18 */
    public AsciiSequenceView execInst(final AsciiSequenceView view)
    {
        if (!hasExecInst)
        {
            throw new IllegalArgumentException("No value for optional field: ExecInst");
        }

        return view.wrap(buffer, execInstOffset, execInstLength);
    }


    private final CharArrayWrapper execInstWrapper = new CharArrayWrapper();
    private DecimalFloat minQty = DecimalFloat.newNaNValue();

    private boolean hasMinQty;

    /* MinQty = 110 */
    public DecimalFloat minQty()
    {
        if (!hasMinQty)
        {
            throw new IllegalArgumentException("No value for optional field: MinQty");
        }

        return minQty;
    }

    public boolean hasMinQty()
    {
        return hasMinQty;
    }



    private DecimalFloat maxFloor = DecimalFloat.newNaNValue();

    private boolean hasMaxFloor;

    /* MaxFloor = 111 */
    public DecimalFloat maxFloor()
    {
        if (!hasMaxFloor)
        {
            throw new IllegalArgumentException("No value for optional field: MaxFloor");
        }

        return maxFloor;
    }

    public boolean hasMaxFloor()
    {
        return hasMaxFloor;
    }



    private char[] exDestination = new char[1];

    private boolean hasExDestination;

    /* ExDestination = 100 */
    public char[] exDestination()
    {
        if (!hasExDestination)
        {
            throw new IllegalArgumentException("No value for optional field: ExDestination");
        }

        return exDestination;
    }

    public boolean hasExDestination()
    {
        return hasExDestination;
    }


    private int exDestinationOffset;

    private int exDestinationLength;

    /* ExDestination = 100 */
    public int exDestinationLength()
    {
        if (!hasExDestination)
        {
            throw new IllegalArgumentException("No value for optional field: ExDestination");
        }

        return exDestinationLength;
    }

    /* ExDestination = 100 */
    public String exDestinationAsString()
    {
        return hasExDestination ? new String(exDestination, 0, exDestinationLength) : null;
    }

    /* ExDestination = 100 */
    public AsciiSequenceView exDestination(final AsciiSequenceView view)
    {
        if (!hasExDestination)
        {
            throw new IllegalArgumentException("No value for optional field: ExDestination");
        }

        return view.wrap(buffer, exDestinationOffset, exDestinationLength);
    }



@Generated("uk.co.real_logic.artio")
public class TradingSessionsGroupDecoder extends CommonDecoderImpl
{
    public final IntHashSet REQUIRED_FIELDS = new IntHashSet(0);

    {
        if (CODEC_VALIDATION_ENABLED)
        {
        }
    }

    public final IntHashSet ALL_GROUP_FIELDS = new IntHashSet(4);

    {
        if (CODEC_VALIDATION_ENABLED)
        {
            ALL_GROUP_FIELDS.add(Constants.TRADING_SESSION_ID);
            ALL_GROUP_FIELDS.add(Constants.TRADING_SESSION_SUB_ID);
        }
    }

    private final IntHashSet missingRequiredFields = new IntHashSet(0);

    public boolean validate()
    {
        if (rejectReason != Decoder.NO_ERROR)
        {
            return false;
        }
        final IntIterator missingFieldsIterator = missingRequiredFields.iterator();
        if (missingFieldsIterator.hasNext())
        {
            invalidTagId = missingFieldsIterator.nextValue();
            rejectReason = 1;
            return false;
        }
        return true;
    }

    private final TrailerDecoder trailer;
    private final IntHashSet messageFields;
    public TradingSessionsGroupDecoder(final TrailerDecoder trailer, final IntHashSet messageFields)
    {
        this.trailer = trailer;
        this.messageFields = messageFields;
    }

    private TradingSessionsGroupDecoder next = null;

    public TradingSessionsGroupDecoder next()
    {
        return next;
    }

    private IntHashSet seenFields = new IntHashSet(4);

    private char[] tradingSessionID = new char[1];

    private boolean hasTradingSessionID;

    /* TradingSessionID = 336 */
    public char[] tradingSessionID()
    {
        if (!hasTradingSessionID)
        {
            throw new IllegalArgumentException("No value for optional field: TradingSessionID");
        }

        return tradingSessionID;
    }

    public boolean hasTradingSessionID()
    {
        return hasTradingSessionID;
    }


    private int tradingSessionIDOffset;

    private int tradingSessionIDLength;

    /* TradingSessionID = 336 */
    public int tradingSessionIDLength()
    {
        if (!hasTradingSessionID)
        {
            throw new IllegalArgumentException("No value for optional field: TradingSessionID");
        }

        return tradingSessionIDLength;
    }

    /* TradingSessionID = 336 */
    public String tradingSessionIDAsString()
    {
        return hasTradingSessionID ? new String(tradingSessionID, 0, tradingSessionIDLength) : null;
    }

    /* TradingSessionID = 336 */
    public AsciiSequenceView tradingSessionID(final AsciiSequenceView view)
    {
        if (!hasTradingSessionID)
        {
            throw new IllegalArgumentException("No value for optional field: TradingSessionID");
        }

        return view.wrap(buffer, tradingSessionIDOffset, tradingSessionIDLength);
    }


    private final CharArrayWrapper tradingSessionIDWrapper = new CharArrayWrapper();
    private char[] tradingSessionSubID = new char[1];

    private boolean hasTradingSessionSubID;

    /* TradingSessionSubID = 625 */
    public char[] tradingSessionSubID()
    {
        if (!hasTradingSessionSubID)
        {
            throw new IllegalArgumentException("No value for optional field: TradingSessionSubID");
        }

        return tradingSessionSubID;
    }

    public boolean hasTradingSessionSubID()
    {
        return hasTradingSessionSubID;
    }


    private int tradingSessionSubIDOffset;

    private int tradingSessionSubIDLength;

    /* TradingSessionSubID = 625 */
    public int tradingSessionSubIDLength()
    {
        if (!hasTradingSessionSubID)
        {
            throw new IllegalArgumentException("No value for optional field: TradingSessionSubID");
        }

        return tradingSessionSubIDLength;
    }

    /* TradingSessionSubID = 625 */
    public String tradingSessionSubIDAsString()
    {
        return hasTradingSessionSubID ? new String(tradingSessionSubID, 0, tradingSessionSubIDLength) : null;
    }

    /* TradingSessionSubID = 625 */
    public AsciiSequenceView tradingSessionSubID(final AsciiSequenceView view)
    {
        if (!hasTradingSessionSubID)
        {
            throw new IllegalArgumentException("No value for optional field: TradingSessionSubID");
        }

        return view.wrap(buffer, tradingSessionSubIDOffset, tradingSessionSubIDLength);
    }


    private final CharArrayWrapper tradingSessionSubIDWrapper = new CharArrayWrapper();
    public int decode(final AsciiBuffer buffer, final int offset, final int length)
    {
        // Decode TradingSessionsGroup
        int seenFieldCount = 0;
        if (CODEC_VALIDATION_ENABLED)
        {
            missingRequiredFields.copy(REQUIRED_FIELDS);
        }
        this.buffer = buffer;
        final int end = offset + length;
        int position = offset;
        seenFields.clear();
        int tag;

        while (position < end)
        {
            final int equalsPosition = buffer.scan(position, end, '=');
            if (equalsPosition == AsciiBuffer.UNKNOWN_INDEX)
            {
               return position;
            }
            tag = buffer.getInt(position, equalsPosition);
            if (!seenFields.add(tag))
            {
                if (next == null)
                {
                    next = new TradingSessionsGroupDecoder(trailer, messageFields);
                }
                return position - offset;
            }
            final int valueOffset = equalsPosition + 1;
            int endOfField = buffer.scan(valueOffset, end, START_OF_HEADER);
            if (endOfField == AsciiBuffer.UNKNOWN_INDEX || equalsPosition == AsciiBuffer.UNKNOWN_INDEX)
            {
                rejectReason = 5;
                break;
            }
            final int valueLength = endOfField - valueOffset;
            if (CODEC_VALIDATION_ENABLED)
            {
                if (tag <= 0)
                {
                    invalidTagId = tag;
                    rejectReason = 0;
                }
                else if (valueLength == 0)
                {
                    invalidTagId = tag;
                    rejectReason = 4;
                }
                missingRequiredFields.remove(tag);
                seenFieldCount++;
            }

            switch (tag)
            {
            case Constants.TRADING_SESSION_ID:
                hasTradingSessionID = true;
                tradingSessionID = buffer.getChars(tradingSessionID, valueOffset, valueLength);
                tradingSessionIDOffset = valueOffset;
                tradingSessionIDLength = valueLength;
                break;

            case Constants.TRADING_SESSION_SUB_ID:
                hasTradingSessionSubID = true;
                tradingSessionSubID = buffer.getChars(tradingSessionSubID, valueOffset, valueLength);
                tradingSessionSubIDOffset = valueOffset;
                tradingSessionSubIDLength = valueLength;
                break;

            default:
                if (!CODEC_REJECT_UNKNOWN_FIELD_ENABLED)
                {
                    seenFields.remove(tag);
                }
                if (CODEC_REJECT_UNKNOWN_FIELD_ENABLED || (trailer.REQUIRED_FIELDS.contains(tag) || messageFields.contains(tag)))
                {
                    return position - offset;
                }

            }

            if (position < (endOfField + 1))
            {
                position = endOfField + 1;
            }
        }
        return position - offset;
    }

    public void reset()
    {
        this.resetTradingSessionID();
        this.resetTradingSessionSubID();
        buffer = null;
        if (CODEC_VALIDATION_ENABLED)
        {
            invalidTagId = Decoder.NO_ERROR;
            rejectReason = Decoder.NO_ERROR;
            missingRequiredFields.clear();
        }
    }

    public void resetTradingSessionID()
    {
        hasTradingSessionID = false;
    }

    public void resetTradingSessionSubID()
    {
        hasTradingSessionSubID = false;
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
        builder.append("\"MessageName\": \"TradingSessionsGroup\",\n");
        if (hasTradingSessionID())
        {
            indent(builder, level);
            builder.append("\"TradingSessionID\": \"");
            builder.append(this.tradingSessionID(), 0, tradingSessionIDLength());
            builder.append("\",\n");
        }

        if (hasTradingSessionSubID())
        {
            indent(builder, level);
            builder.append("\"TradingSessionSubID\": \"");
            builder.append(this.tradingSessionSubID(), 0, tradingSessionSubIDLength());
            builder.append("\",\n");
        }
        indent(builder, level - 1);
        builder.append("}");
        return builder;
    }

    /**
     * {@inheritDoc}
     */
    public OrdersGroupEncoder.TradingSessionsGroupEncoder toEncoder(final Encoder encoder)
    {
        return toEncoder((OrdersGroupEncoder.TradingSessionsGroupEncoder)encoder);
    }

    public OrdersGroupEncoder.TradingSessionsGroupEncoder toEncoder(final OrdersGroupEncoder.TradingSessionsGroupEncoder encoder)
    {
        encoder.reset();
        if (hasTradingSessionID())
        {
            encoder.tradingSessionID(this.tradingSessionID(), 0, tradingSessionIDLength());
        }

        if (hasTradingSessionSubID())
        {
            encoder.tradingSessionSubID(this.tradingSessionSubID(), 0, tradingSessionSubIDLength());
        }
        return encoder;
    }

}
    @Generated("uk.co.real_logic.artio")
    public class TradingSessionsGroupIterator implements Iterable<TradingSessionsGroupDecoder>, java.util.Iterator<TradingSessionsGroupDecoder>
    {
        private final OrdersGroupDecoder parent;
        private int remainder;
        private TradingSessionsGroupDecoder current;

        public TradingSessionsGroupIterator(final OrdersGroupDecoder parent)
        {
            this.parent = parent;
        }

        public boolean hasNext()
        {
            return remainder > 0 && current != null;
        }

        public TradingSessionsGroupDecoder next()
        {
            remainder--;
            final TradingSessionsGroupDecoder value = current;
            current = current.next();
            return value;
        }

        public int numberFieldValue()
        {
            return parent.hasNoTradingSessionsGroupCounter() ? parent.noTradingSessionsGroupCounter() : 0;
        }

        public void reset()
        {
            remainder = numberFieldValue();
            current = parent.tradingSessionsGroup();
        }

        public TradingSessionsGroupIterator iterator()
        {
            reset();
            return this;
        }

    }


    private TradingSessionsGroupDecoder tradingSessionsGroup = null;
    public TradingSessionsGroupDecoder tradingSessionsGroup()
    {
        return tradingSessionsGroup;
    }

    private int noTradingSessionsGroupCounter = MISSING_INT;

    private boolean hasNoTradingSessionsGroupCounter;

    /* NoTradingSessionsGroupCounter = 386 */
    public int noTradingSessionsGroupCounter()
    {
        if (!hasNoTradingSessionsGroupCounter)
        {
            throw new IllegalArgumentException("No value for optional field: NoTradingSessionsGroupCounter");
        }

        return noTradingSessionsGroupCounter;
    }

    public boolean hasNoTradingSessionsGroupCounter()
    {
        return hasNoTradingSessionsGroupCounter;
    }




    private TradingSessionsGroupIterator tradingSessionsGroupIterator = new TradingSessionsGroupIterator(this);
    public TradingSessionsGroupIterator tradingSessionsGroupIterator()
    {
        return tradingSessionsGroupIterator.iterator();
    }

    private char processCode = MISSING_CHAR;

    private boolean hasProcessCode;

    /* ProcessCode = 81 */
    public char processCode()
    {
        if (!hasProcessCode)
        {
            throw new IllegalArgumentException("No value for optional field: ProcessCode");
        }

        return processCode;
    }

    public boolean hasProcessCode()
    {
        return hasProcessCode;
    }



    private final CharArrayWrapper processCodeWrapper = new CharArrayWrapper();
    /* ProcessCode = 81 */
    public ProcessCode processCodeAsEnum()
    {
        if (!hasProcessCode)
 return ProcessCode.NULL_VAL;
        return ProcessCode.decode(processCode);
    }


    private char[] symbol = new char[1];

    /* Symbol = 55 */
    public char[] symbol()
    {
        return symbol;
    }


    private int symbolOffset;

    private int symbolLength;

    /* Symbol = 55 */
    public int symbolLength()
    {
        return symbolLength;
    }

    /* Symbol = 55 */
    public String symbolAsString()
    {
        return new String(symbol, 0, symbolLength);
    }

    /* Symbol = 55 */
    public AsciiSequenceView symbol(final AsciiSequenceView view)
    {
        return view.wrap(buffer, symbolOffset, symbolLength);
    }


    private final CharArrayWrapper symbolWrapper = new CharArrayWrapper();
    private char[] symbolSfx = new char[1];

    private boolean hasSymbolSfx;

    /* SymbolSfx = 65 */
    public char[] symbolSfx()
    {
        if (!hasSymbolSfx)
        {
            throw new IllegalArgumentException("No value for optional field: SymbolSfx");
        }

        return symbolSfx;
    }

    public boolean hasSymbolSfx()
    {
        return hasSymbolSfx;
    }


    private int symbolSfxOffset;

    private int symbolSfxLength;

    /* SymbolSfx = 65 */
    public int symbolSfxLength()
    {
        if (!hasSymbolSfx)
        {
            throw new IllegalArgumentException("No value for optional field: SymbolSfx");
        }

        return symbolSfxLength;
    }

    /* SymbolSfx = 65 */
    public String symbolSfxAsString()
    {
        return hasSymbolSfx ? new String(symbolSfx, 0, symbolSfxLength) : null;
    }

    /* SymbolSfx = 65 */
    public AsciiSequenceView symbolSfx(final AsciiSequenceView view)
    {
        if (!hasSymbolSfx)
        {
            throw new IllegalArgumentException("No value for optional field: SymbolSfx");
        }

        return view.wrap(buffer, symbolSfxOffset, symbolSfxLength);
    }


    private final CharArrayWrapper symbolSfxWrapper = new CharArrayWrapper();
    /* SymbolSfx = 65 */
    public SymbolSfx symbolSfxAsEnum()
    {
        if (!hasSymbolSfx)
 return SymbolSfx.NULL_VAL;
        symbolSfxWrapper.wrap(this.symbolSfx(), symbolSfxLength);
        return SymbolSfx.decode(symbolSfxWrapper);
    }

    private char[] securityID = new char[1];

    private boolean hasSecurityID;

    /* SecurityID = 48 */
    public char[] securityID()
    {
        if (!hasSecurityID)
        {
            throw new IllegalArgumentException("No value for optional field: SecurityID");
        }

        return securityID;
    }

    public boolean hasSecurityID()
    {
        return hasSecurityID;
    }


    private int securityIDOffset;

    private int securityIDLength;

    /* SecurityID = 48 */
    public int securityIDLength()
    {
        if (!hasSecurityID)
        {
            throw new IllegalArgumentException("No value for optional field: SecurityID");
        }

        return securityIDLength;
    }

    /* SecurityID = 48 */
    public String securityIDAsString()
    {
        return hasSecurityID ? new String(securityID, 0, securityIDLength) : null;
    }

    /* SecurityID = 48 */
    public AsciiSequenceView securityID(final AsciiSequenceView view)
    {
        if (!hasSecurityID)
        {
            throw new IllegalArgumentException("No value for optional field: SecurityID");
        }

        return view.wrap(buffer, securityIDOffset, securityIDLength);
    }


    private final CharArrayWrapper securityIDWrapper = new CharArrayWrapper();
    private char[] securityIDSource = new char[1];

    private boolean hasSecurityIDSource;

    /* SecurityIDSource = 22 */
    public char[] securityIDSource()
    {
        if (!hasSecurityIDSource)
        {
            throw new IllegalArgumentException("No value for optional field: SecurityIDSource");
        }

        return securityIDSource;
    }

    public boolean hasSecurityIDSource()
    {
        return hasSecurityIDSource;
    }


    private int securityIDSourceOffset;

    private int securityIDSourceLength;

    /* SecurityIDSource = 22 */
    public int securityIDSourceLength()
    {
        if (!hasSecurityIDSource)
        {
            throw new IllegalArgumentException("No value for optional field: SecurityIDSource");
        }

        return securityIDSourceLength;
    }

    /* SecurityIDSource = 22 */
    public String securityIDSourceAsString()
    {
        return hasSecurityIDSource ? new String(securityIDSource, 0, securityIDSourceLength) : null;
    }

    /* SecurityIDSource = 22 */
    public AsciiSequenceView securityIDSource(final AsciiSequenceView view)
    {
        if (!hasSecurityIDSource)
        {
            throw new IllegalArgumentException("No value for optional field: SecurityIDSource");
        }

        return view.wrap(buffer, securityIDSourceOffset, securityIDSourceLength);
    }


    private final CharArrayWrapper securityIDSourceWrapper = new CharArrayWrapper();
    /* SecurityIDSource = 22 */
    public SecurityIDSource securityIDSourceAsEnum()
    {
        if (!hasSecurityIDSource)
 return SecurityIDSource.NULL_VAL;
        securityIDSourceWrapper.wrap(this.securityIDSource(), securityIDSourceLength);
        return SecurityIDSource.decode(securityIDSourceWrapper);
    }


    private SecurityAltIDGroupDecoder securityAltIDGroup = null;
    public SecurityAltIDGroupDecoder securityAltIDGroup()
    {
        return securityAltIDGroup;
    }

    private int noSecurityAltIDGroupCounter = MISSING_INT;

    private boolean hasNoSecurityAltIDGroupCounter;

    /* NoSecurityAltIDGroupCounter = 454 */
    public int noSecurityAltIDGroupCounter()
    {
        if (!hasNoSecurityAltIDGroupCounter)
        {
            throw new IllegalArgumentException("No value for optional field: NoSecurityAltIDGroupCounter");
        }

        return noSecurityAltIDGroupCounter;
    }

    public boolean hasNoSecurityAltIDGroupCounter()
    {
        return hasNoSecurityAltIDGroupCounter;
    }




    private SecurityAltIDGroupIterator securityAltIDGroupIterator = new SecurityAltIDGroupIterator(this);
    public SecurityAltIDGroupIterator securityAltIDGroupIterator()
    {
        return securityAltIDGroupIterator.iterator();
    }

    private int product = MISSING_INT;

    private boolean hasProduct;

    /* Product = 460 */
    public int product()
    {
        if (!hasProduct)
        {
            throw new IllegalArgumentException("No value for optional field: Product");
        }

        return product;
    }

    public boolean hasProduct()
    {
        return hasProduct;
    }



    private final CharArrayWrapper productWrapper = new CharArrayWrapper();
    /* Product = 460 */
    public Product productAsEnum()
    {
        if (!hasProduct)
 return Product.NULL_VAL;
        return Product.decode(product);
    }

    private char[] cFICode = new char[1];

    private boolean hasCFICode;

    /* CFICode = 461 */
    public char[] cFICode()
    {
        if (!hasCFICode)
        {
            throw new IllegalArgumentException("No value for optional field: CFICode");
        }

        return cFICode;
    }

    public boolean hasCFICode()
    {
        return hasCFICode;
    }


    private int cFICodeOffset;

    private int cFICodeLength;

    /* CFICode = 461 */
    public int cFICodeLength()
    {
        if (!hasCFICode)
        {
            throw new IllegalArgumentException("No value for optional field: CFICode");
        }

        return cFICodeLength;
    }

    /* CFICode = 461 */
    public String cFICodeAsString()
    {
        return hasCFICode ? new String(cFICode, 0, cFICodeLength) : null;
    }

    /* CFICode = 461 */
    public AsciiSequenceView cFICode(final AsciiSequenceView view)
    {
        if (!hasCFICode)
        {
            throw new IllegalArgumentException("No value for optional field: CFICode");
        }

        return view.wrap(buffer, cFICodeOffset, cFICodeLength);
    }


    private final CharArrayWrapper cFICodeWrapper = new CharArrayWrapper();
    private char[] securityType = new char[1];

    private boolean hasSecurityType;

    /* SecurityType = 167 */
    public char[] securityType()
    {
        if (!hasSecurityType)
        {
            throw new IllegalArgumentException("No value for optional field: SecurityType");
        }

        return securityType;
    }

    public boolean hasSecurityType()
    {
        return hasSecurityType;
    }


    private int securityTypeOffset;

    private int securityTypeLength;

    /* SecurityType = 167 */
    public int securityTypeLength()
    {
        if (!hasSecurityType)
        {
            throw new IllegalArgumentException("No value for optional field: SecurityType");
        }

        return securityTypeLength;
    }

    /* SecurityType = 167 */
    public String securityTypeAsString()
    {
        return hasSecurityType ? new String(securityType, 0, securityTypeLength) : null;
    }

    /* SecurityType = 167 */
    public AsciiSequenceView securityType(final AsciiSequenceView view)
    {
        if (!hasSecurityType)
        {
            throw new IllegalArgumentException("No value for optional field: SecurityType");
        }

        return view.wrap(buffer, securityTypeOffset, securityTypeLength);
    }


    private final CharArrayWrapper securityTypeWrapper = new CharArrayWrapper();
    /* SecurityType = 167 */
    public SecurityType securityTypeAsEnum()
    {
        if (!hasSecurityType)
 return SecurityType.NULL_VAL;
        securityTypeWrapper.wrap(this.securityType(), securityTypeLength);
        return SecurityType.decode(securityTypeWrapper);
    }

    private char[] securitySubType = new char[1];

    private boolean hasSecuritySubType;

    /* SecuritySubType = 762 */
    public char[] securitySubType()
    {
        if (!hasSecuritySubType)
        {
            throw new IllegalArgumentException("No value for optional field: SecuritySubType");
        }

        return securitySubType;
    }

    public boolean hasSecuritySubType()
    {
        return hasSecuritySubType;
    }


    private int securitySubTypeOffset;

    private int securitySubTypeLength;

    /* SecuritySubType = 762 */
    public int securitySubTypeLength()
    {
        if (!hasSecuritySubType)
        {
            throw new IllegalArgumentException("No value for optional field: SecuritySubType");
        }

        return securitySubTypeLength;
    }

    /* SecuritySubType = 762 */
    public String securitySubTypeAsString()
    {
        return hasSecuritySubType ? new String(securitySubType, 0, securitySubTypeLength) : null;
    }

    /* SecuritySubType = 762 */
    public AsciiSequenceView securitySubType(final AsciiSequenceView view)
    {
        if (!hasSecuritySubType)
        {
            throw new IllegalArgumentException("No value for optional field: SecuritySubType");
        }

        return view.wrap(buffer, securitySubTypeOffset, securitySubTypeLength);
    }


    private final CharArrayWrapper securitySubTypeWrapper = new CharArrayWrapper();
    private byte[] maturityMonthYear = new byte[8];

    private boolean hasMaturityMonthYear;

    /* MaturityMonthYear = 200 */
    public byte[] maturityMonthYear()
    {
        if (!hasMaturityMonthYear)
        {
            throw new IllegalArgumentException("No value for optional field: MaturityMonthYear");
        }

        return maturityMonthYear;
    }

    public boolean hasMaturityMonthYear()
    {
        return hasMaturityMonthYear;
    }


    private int maturityMonthYearOffset;

    private int maturityMonthYearLength;

    /* MaturityMonthYear = 200 */
    public int maturityMonthYearLength()
    {
        if (!hasMaturityMonthYear)
        {
            throw new IllegalArgumentException("No value for optional field: MaturityMonthYear");
        }

        return maturityMonthYearLength;
    }

    /* MaturityMonthYear = 200 */
    public String maturityMonthYearAsString()
    {
        return hasMaturityMonthYear ? new String(maturityMonthYear, 0, maturityMonthYearLength) : null;
    }

    /* MaturityMonthYear = 200 */
    public AsciiSequenceView maturityMonthYear(final AsciiSequenceView view)
    {
        if (!hasMaturityMonthYear)
        {
            throw new IllegalArgumentException("No value for optional field: MaturityMonthYear");
        }

        return view.wrap(buffer, maturityMonthYearOffset, maturityMonthYearLength);
    }


    private byte[] maturityDate = new byte[8];

    private boolean hasMaturityDate;

    /* MaturityDate = 541 */
    public byte[] maturityDate()
    {
        if (!hasMaturityDate)
        {
            throw new IllegalArgumentException("No value for optional field: MaturityDate");
        }

        return maturityDate;
    }

    public boolean hasMaturityDate()
    {
        return hasMaturityDate;
    }


    private int maturityDateOffset;

    private int maturityDateLength;

    /* MaturityDate = 541 */
    public int maturityDateLength()
    {
        if (!hasMaturityDate)
        {
            throw new IllegalArgumentException("No value for optional field: MaturityDate");
        }

        return maturityDateLength;
    }

    /* MaturityDate = 541 */
    public String maturityDateAsString()
    {
        return hasMaturityDate ? new String(maturityDate, 0, maturityDateLength) : null;
    }

    /* MaturityDate = 541 */
    public AsciiSequenceView maturityDate(final AsciiSequenceView view)
    {
        if (!hasMaturityDate)
        {
            throw new IllegalArgumentException("No value for optional field: MaturityDate");
        }

        return view.wrap(buffer, maturityDateOffset, maturityDateLength);
    }


    private byte[] couponPaymentDate = new byte[8];

    private boolean hasCouponPaymentDate;

    /* CouponPaymentDate = 224 */
    public byte[] couponPaymentDate()
    {
        if (!hasCouponPaymentDate)
        {
            throw new IllegalArgumentException("No value for optional field: CouponPaymentDate");
        }

        return couponPaymentDate;
    }

    public boolean hasCouponPaymentDate()
    {
        return hasCouponPaymentDate;
    }


    private int couponPaymentDateOffset;

    private int couponPaymentDateLength;

    /* CouponPaymentDate = 224 */
    public int couponPaymentDateLength()
    {
        if (!hasCouponPaymentDate)
        {
            throw new IllegalArgumentException("No value for optional field: CouponPaymentDate");
        }

        return couponPaymentDateLength;
    }

    /* CouponPaymentDate = 224 */
    public String couponPaymentDateAsString()
    {
        return hasCouponPaymentDate ? new String(couponPaymentDate, 0, couponPaymentDateLength) : null;
    }

    /* CouponPaymentDate = 224 */
    public AsciiSequenceView couponPaymentDate(final AsciiSequenceView view)
    {
        if (!hasCouponPaymentDate)
        {
            throw new IllegalArgumentException("No value for optional field: CouponPaymentDate");
        }

        return view.wrap(buffer, couponPaymentDateOffset, couponPaymentDateLength);
    }


    private byte[] issueDate = new byte[8];

    private boolean hasIssueDate;

    /* IssueDate = 225 */
    public byte[] issueDate()
    {
        if (!hasIssueDate)
        {
            throw new IllegalArgumentException("No value for optional field: IssueDate");
        }

        return issueDate;
    }

    public boolean hasIssueDate()
    {
        return hasIssueDate;
    }


    private int issueDateOffset;

    private int issueDateLength;

    /* IssueDate = 225 */
    public int issueDateLength()
    {
        if (!hasIssueDate)
        {
            throw new IllegalArgumentException("No value for optional field: IssueDate");
        }

        return issueDateLength;
    }

    /* IssueDate = 225 */
    public String issueDateAsString()
    {
        return hasIssueDate ? new String(issueDate, 0, issueDateLength) : null;
    }

    /* IssueDate = 225 */
    public AsciiSequenceView issueDate(final AsciiSequenceView view)
    {
        if (!hasIssueDate)
        {
            throw new IllegalArgumentException("No value for optional field: IssueDate");
        }

        return view.wrap(buffer, issueDateOffset, issueDateLength);
    }


    private int repoCollateralSecurityType = MISSING_INT;

    private boolean hasRepoCollateralSecurityType;

    /* RepoCollateralSecurityType = 239 */
    public int repoCollateralSecurityType()
    {
        if (!hasRepoCollateralSecurityType)
        {
            throw new IllegalArgumentException("No value for optional field: RepoCollateralSecurityType");
        }

        return repoCollateralSecurityType;
    }

    public boolean hasRepoCollateralSecurityType()
    {
        return hasRepoCollateralSecurityType;
    }



    private int repurchaseTerm = MISSING_INT;

    private boolean hasRepurchaseTerm;

    /* RepurchaseTerm = 226 */
    public int repurchaseTerm()
    {
        if (!hasRepurchaseTerm)
        {
            throw new IllegalArgumentException("No value for optional field: RepurchaseTerm");
        }

        return repurchaseTerm;
    }

    public boolean hasRepurchaseTerm()
    {
        return hasRepurchaseTerm;
    }



    private DecimalFloat repurchaseRate = DecimalFloat.newNaNValue();

    private boolean hasRepurchaseRate;

    /* RepurchaseRate = 227 */
    public DecimalFloat repurchaseRate()
    {
        if (!hasRepurchaseRate)
        {
            throw new IllegalArgumentException("No value for optional field: RepurchaseRate");
        }

        return repurchaseRate;
    }

    public boolean hasRepurchaseRate()
    {
        return hasRepurchaseRate;
    }



    private DecimalFloat factor = DecimalFloat.newNaNValue();

    private boolean hasFactor;

    /* Factor = 228 */
    public DecimalFloat factor()
    {
        if (!hasFactor)
        {
            throw new IllegalArgumentException("No value for optional field: Factor");
        }

        return factor;
    }

    public boolean hasFactor()
    {
        return hasFactor;
    }



    private char[] creditRating = new char[1];

    private boolean hasCreditRating;

    /* CreditRating = 255 */
    public char[] creditRating()
    {
        if (!hasCreditRating)
        {
            throw new IllegalArgumentException("No value for optional field: CreditRating");
        }

        return creditRating;
    }

    public boolean hasCreditRating()
    {
        return hasCreditRating;
    }


    private int creditRatingOffset;

    private int creditRatingLength;

    /* CreditRating = 255 */
    public int creditRatingLength()
    {
        if (!hasCreditRating)
        {
            throw new IllegalArgumentException("No value for optional field: CreditRating");
        }

        return creditRatingLength;
    }

    /* CreditRating = 255 */
    public String creditRatingAsString()
    {
        return hasCreditRating ? new String(creditRating, 0, creditRatingLength) : null;
    }

    /* CreditRating = 255 */
    public AsciiSequenceView creditRating(final AsciiSequenceView view)
    {
        if (!hasCreditRating)
        {
            throw new IllegalArgumentException("No value for optional field: CreditRating");
        }

        return view.wrap(buffer, creditRatingOffset, creditRatingLength);
    }


    private final CharArrayWrapper creditRatingWrapper = new CharArrayWrapper();
    private char[] instrRegistry = new char[1];

    private boolean hasInstrRegistry;

    /* InstrRegistry = 543 */
    public char[] instrRegistry()
    {
        if (!hasInstrRegistry)
        {
            throw new IllegalArgumentException("No value for optional field: InstrRegistry");
        }

        return instrRegistry;
    }

    public boolean hasInstrRegistry()
    {
        return hasInstrRegistry;
    }


    private int instrRegistryOffset;

    private int instrRegistryLength;

    /* InstrRegistry = 543 */
    public int instrRegistryLength()
    {
        if (!hasInstrRegistry)
        {
            throw new IllegalArgumentException("No value for optional field: InstrRegistry");
        }

        return instrRegistryLength;
    }

    /* InstrRegistry = 543 */
    public String instrRegistryAsString()
    {
        return hasInstrRegistry ? new String(instrRegistry, 0, instrRegistryLength) : null;
    }

    /* InstrRegistry = 543 */
    public AsciiSequenceView instrRegistry(final AsciiSequenceView view)
    {
        if (!hasInstrRegistry)
        {
            throw new IllegalArgumentException("No value for optional field: InstrRegistry");
        }

        return view.wrap(buffer, instrRegistryOffset, instrRegistryLength);
    }


    private final CharArrayWrapper instrRegistryWrapper = new CharArrayWrapper();
    private char[] countryOfIssue = new char[1];

    private boolean hasCountryOfIssue;

    /* CountryOfIssue = 470 */
    public char[] countryOfIssue()
    {
        if (!hasCountryOfIssue)
        {
            throw new IllegalArgumentException("No value for optional field: CountryOfIssue");
        }

        return countryOfIssue;
    }

    public boolean hasCountryOfIssue()
    {
        return hasCountryOfIssue;
    }


    private int countryOfIssueOffset;

    private int countryOfIssueLength;

    /* CountryOfIssue = 470 */
    public int countryOfIssueLength()
    {
        if (!hasCountryOfIssue)
        {
            throw new IllegalArgumentException("No value for optional field: CountryOfIssue");
        }

        return countryOfIssueLength;
    }

    /* CountryOfIssue = 470 */
    public String countryOfIssueAsString()
    {
        return hasCountryOfIssue ? new String(countryOfIssue, 0, countryOfIssueLength) : null;
    }

    /* CountryOfIssue = 470 */
    public AsciiSequenceView countryOfIssue(final AsciiSequenceView view)
    {
        if (!hasCountryOfIssue)
        {
            throw new IllegalArgumentException("No value for optional field: CountryOfIssue");
        }

        return view.wrap(buffer, countryOfIssueOffset, countryOfIssueLength);
    }


    private char[] stateOrProvinceOfIssue = new char[1];

    private boolean hasStateOrProvinceOfIssue;

    /* StateOrProvinceOfIssue = 471 */
    public char[] stateOrProvinceOfIssue()
    {
        if (!hasStateOrProvinceOfIssue)
        {
            throw new IllegalArgumentException("No value for optional field: StateOrProvinceOfIssue");
        }

        return stateOrProvinceOfIssue;
    }

    public boolean hasStateOrProvinceOfIssue()
    {
        return hasStateOrProvinceOfIssue;
    }


    private int stateOrProvinceOfIssueOffset;

    private int stateOrProvinceOfIssueLength;

    /* StateOrProvinceOfIssue = 471 */
    public int stateOrProvinceOfIssueLength()
    {
        if (!hasStateOrProvinceOfIssue)
        {
            throw new IllegalArgumentException("No value for optional field: StateOrProvinceOfIssue");
        }

        return stateOrProvinceOfIssueLength;
    }

    /* StateOrProvinceOfIssue = 471 */
    public String stateOrProvinceOfIssueAsString()
    {
        return hasStateOrProvinceOfIssue ? new String(stateOrProvinceOfIssue, 0, stateOrProvinceOfIssueLength) : null;
    }

    /* StateOrProvinceOfIssue = 471 */
    public AsciiSequenceView stateOrProvinceOfIssue(final AsciiSequenceView view)
    {
        if (!hasStateOrProvinceOfIssue)
        {
            throw new IllegalArgumentException("No value for optional field: StateOrProvinceOfIssue");
        }

        return view.wrap(buffer, stateOrProvinceOfIssueOffset, stateOrProvinceOfIssueLength);
    }


    private final CharArrayWrapper stateOrProvinceOfIssueWrapper = new CharArrayWrapper();
    private char[] localeOfIssue = new char[1];

    private boolean hasLocaleOfIssue;

    /* LocaleOfIssue = 472 */
    public char[] localeOfIssue()
    {
        if (!hasLocaleOfIssue)
        {
            throw new IllegalArgumentException("No value for optional field: LocaleOfIssue");
        }

        return localeOfIssue;
    }

    public boolean hasLocaleOfIssue()
    {
        return hasLocaleOfIssue;
    }


    private int localeOfIssueOffset;

    private int localeOfIssueLength;

    /* LocaleOfIssue = 472 */
    public int localeOfIssueLength()
    {
        if (!hasLocaleOfIssue)
        {
            throw new IllegalArgumentException("No value for optional field: LocaleOfIssue");
        }

        return localeOfIssueLength;
    }

    /* LocaleOfIssue = 472 */
    public String localeOfIssueAsString()
    {
        return hasLocaleOfIssue ? new String(localeOfIssue, 0, localeOfIssueLength) : null;
    }

    /* LocaleOfIssue = 472 */
    public AsciiSequenceView localeOfIssue(final AsciiSequenceView view)
    {
        if (!hasLocaleOfIssue)
        {
            throw new IllegalArgumentException("No value for optional field: LocaleOfIssue");
        }

        return view.wrap(buffer, localeOfIssueOffset, localeOfIssueLength);
    }


    private final CharArrayWrapper localeOfIssueWrapper = new CharArrayWrapper();
    private byte[] redemptionDate = new byte[8];

    private boolean hasRedemptionDate;

    /* RedemptionDate = 240 */
    public byte[] redemptionDate()
    {
        if (!hasRedemptionDate)
        {
            throw new IllegalArgumentException("No value for optional field: RedemptionDate");
        }

        return redemptionDate;
    }

    public boolean hasRedemptionDate()
    {
        return hasRedemptionDate;
    }


    private int redemptionDateOffset;

    private int redemptionDateLength;

    /* RedemptionDate = 240 */
    public int redemptionDateLength()
    {
        if (!hasRedemptionDate)
        {
            throw new IllegalArgumentException("No value for optional field: RedemptionDate");
        }

        return redemptionDateLength;
    }

    /* RedemptionDate = 240 */
    public String redemptionDateAsString()
    {
        return hasRedemptionDate ? new String(redemptionDate, 0, redemptionDateLength) : null;
    }

    /* RedemptionDate = 240 */
    public AsciiSequenceView redemptionDate(final AsciiSequenceView view)
    {
        if (!hasRedemptionDate)
        {
            throw new IllegalArgumentException("No value for optional field: RedemptionDate");
        }

        return view.wrap(buffer, redemptionDateOffset, redemptionDateLength);
    }


    private DecimalFloat strikePrice = DecimalFloat.newNaNValue();

    private boolean hasStrikePrice;

    /* StrikePrice = 202 */
    public DecimalFloat strikePrice()
    {
        if (!hasStrikePrice)
        {
            throw new IllegalArgumentException("No value for optional field: StrikePrice");
        }

        return strikePrice;
    }

    public boolean hasStrikePrice()
    {
        return hasStrikePrice;
    }



    private char[] strikeCurrency = new char[1];

    private boolean hasStrikeCurrency;

    /* StrikeCurrency = 947 */
    public char[] strikeCurrency()
    {
        if (!hasStrikeCurrency)
        {
            throw new IllegalArgumentException("No value for optional field: StrikeCurrency");
        }

        return strikeCurrency;
    }

    public boolean hasStrikeCurrency()
    {
        return hasStrikeCurrency;
    }


    private int strikeCurrencyOffset;

    private int strikeCurrencyLength;

    /* StrikeCurrency = 947 */
    public int strikeCurrencyLength()
    {
        if (!hasStrikeCurrency)
        {
            throw new IllegalArgumentException("No value for optional field: StrikeCurrency");
        }

        return strikeCurrencyLength;
    }

    /* StrikeCurrency = 947 */
    public String strikeCurrencyAsString()
    {
        return hasStrikeCurrency ? new String(strikeCurrency, 0, strikeCurrencyLength) : null;
    }

    /* StrikeCurrency = 947 */
    public AsciiSequenceView strikeCurrency(final AsciiSequenceView view)
    {
        if (!hasStrikeCurrency)
        {
            throw new IllegalArgumentException("No value for optional field: StrikeCurrency");
        }

        return view.wrap(buffer, strikeCurrencyOffset, strikeCurrencyLength);
    }


    private char optAttribute = MISSING_CHAR;

    private boolean hasOptAttribute;

    /* OptAttribute = 206 */
    public char optAttribute()
    {
        if (!hasOptAttribute)
        {
            throw new IllegalArgumentException("No value for optional field: OptAttribute");
        }

        return optAttribute;
    }

    public boolean hasOptAttribute()
    {
        return hasOptAttribute;
    }



    private DecimalFloat contractMultiplier = DecimalFloat.newNaNValue();

    private boolean hasContractMultiplier;

    /* ContractMultiplier = 231 */
    public DecimalFloat contractMultiplier()
    {
        if (!hasContractMultiplier)
        {
            throw new IllegalArgumentException("No value for optional field: ContractMultiplier");
        }

        return contractMultiplier;
    }

    public boolean hasContractMultiplier()
    {
        return hasContractMultiplier;
    }



    private DecimalFloat couponRate = DecimalFloat.newNaNValue();

    private boolean hasCouponRate;

    /* CouponRate = 223 */
    public DecimalFloat couponRate()
    {
        if (!hasCouponRate)
        {
            throw new IllegalArgumentException("No value for optional field: CouponRate");
        }

        return couponRate;
    }

    public boolean hasCouponRate()
    {
        return hasCouponRate;
    }



    private char[] securityExchange = new char[1];

    private boolean hasSecurityExchange;

    /* SecurityExchange = 207 */
    public char[] securityExchange()
    {
        if (!hasSecurityExchange)
        {
            throw new IllegalArgumentException("No value for optional field: SecurityExchange");
        }

        return securityExchange;
    }

    public boolean hasSecurityExchange()
    {
        return hasSecurityExchange;
    }


    private int securityExchangeOffset;

    private int securityExchangeLength;

    /* SecurityExchange = 207 */
    public int securityExchangeLength()
    {
        if (!hasSecurityExchange)
        {
            throw new IllegalArgumentException("No value for optional field: SecurityExchange");
        }

        return securityExchangeLength;
    }

    /* SecurityExchange = 207 */
    public String securityExchangeAsString()
    {
        return hasSecurityExchange ? new String(securityExchange, 0, securityExchangeLength) : null;
    }

    /* SecurityExchange = 207 */
    public AsciiSequenceView securityExchange(final AsciiSequenceView view)
    {
        if (!hasSecurityExchange)
        {
            throw new IllegalArgumentException("No value for optional field: SecurityExchange");
        }

        return view.wrap(buffer, securityExchangeOffset, securityExchangeLength);
    }


    private char[] issuer = new char[1];

    private boolean hasIssuer;

    /* Issuer = 106 */
    public char[] issuer()
    {
        if (!hasIssuer)
        {
            throw new IllegalArgumentException("No value for optional field: Issuer");
        }

        return issuer;
    }

    public boolean hasIssuer()
    {
        return hasIssuer;
    }


    private int issuerOffset;

    private int issuerLength;

    /* Issuer = 106 */
    public int issuerLength()
    {
        if (!hasIssuer)
        {
            throw new IllegalArgumentException("No value for optional field: Issuer");
        }

        return issuerLength;
    }

    /* Issuer = 106 */
    public String issuerAsString()
    {
        return hasIssuer ? new String(issuer, 0, issuerLength) : null;
    }

    /* Issuer = 106 */
    public AsciiSequenceView issuer(final AsciiSequenceView view)
    {
        if (!hasIssuer)
        {
            throw new IllegalArgumentException("No value for optional field: Issuer");
        }

        return view.wrap(buffer, issuerOffset, issuerLength);
    }


    private final CharArrayWrapper issuerWrapper = new CharArrayWrapper();
    private int encodedIssuerLen = MISSING_INT;

    private boolean hasEncodedIssuerLen;

    /* EncodedIssuerLen = 348 */
    public int encodedIssuerLen()
    {
        if (!hasEncodedIssuerLen)
        {
            throw new IllegalArgumentException("No value for optional field: EncodedIssuerLen");
        }

        return encodedIssuerLen;
    }

    public boolean hasEncodedIssuerLen()
    {
        return hasEncodedIssuerLen;
    }



    private byte[] encodedIssuer = new byte[1];

    private boolean hasEncodedIssuer;

    /* EncodedIssuer = 349 */
    public byte[] encodedIssuer()
    {
        if (!hasEncodedIssuer)
        {
            throw new IllegalArgumentException("No value for optional field: EncodedIssuer");
        }

        return encodedIssuer;
    }

    public boolean hasEncodedIssuer()
    {
        return hasEncodedIssuer;
    }



    private char[] securityDesc = new char[1];

    private boolean hasSecurityDesc;

    /* SecurityDesc = 107 */
    public char[] securityDesc()
    {
        if (!hasSecurityDesc)
        {
            throw new IllegalArgumentException("No value for optional field: SecurityDesc");
        }

        return securityDesc;
    }

    public boolean hasSecurityDesc()
    {
        return hasSecurityDesc;
    }


    private int securityDescOffset;

    private int securityDescLength;

    /* SecurityDesc = 107 */
    public int securityDescLength()
    {
        if (!hasSecurityDesc)
        {
            throw new IllegalArgumentException("No value for optional field: SecurityDesc");
        }

        return securityDescLength;
    }

    /* SecurityDesc = 107 */
    public String securityDescAsString()
    {
        return hasSecurityDesc ? new String(securityDesc, 0, securityDescLength) : null;
    }

    /* SecurityDesc = 107 */
    public AsciiSequenceView securityDesc(final AsciiSequenceView view)
    {
        if (!hasSecurityDesc)
        {
            throw new IllegalArgumentException("No value for optional field: SecurityDesc");
        }

        return view.wrap(buffer, securityDescOffset, securityDescLength);
    }


    private final CharArrayWrapper securityDescWrapper = new CharArrayWrapper();
    private int encodedSecurityDescLen = MISSING_INT;

    private boolean hasEncodedSecurityDescLen;

    /* EncodedSecurityDescLen = 350 */
    public int encodedSecurityDescLen()
    {
        if (!hasEncodedSecurityDescLen)
        {
            throw new IllegalArgumentException("No value for optional field: EncodedSecurityDescLen");
        }

        return encodedSecurityDescLen;
    }

    public boolean hasEncodedSecurityDescLen()
    {
        return hasEncodedSecurityDescLen;
    }



    private byte[] encodedSecurityDesc = new byte[1];

    private boolean hasEncodedSecurityDesc;

    /* EncodedSecurityDesc = 351 */
    public byte[] encodedSecurityDesc()
    {
        if (!hasEncodedSecurityDesc)
        {
            throw new IllegalArgumentException("No value for optional field: EncodedSecurityDesc");
        }

        return encodedSecurityDesc;
    }

    public boolean hasEncodedSecurityDesc()
    {
        return hasEncodedSecurityDesc;
    }



    private char[] pool = new char[1];

    private boolean hasPool;

    /* Pool = 691 */
    public char[] pool()
    {
        if (!hasPool)
        {
            throw new IllegalArgumentException("No value for optional field: Pool");
        }

        return pool;
    }

    public boolean hasPool()
    {
        return hasPool;
    }


    private int poolOffset;

    private int poolLength;

    /* Pool = 691 */
    public int poolLength()
    {
        if (!hasPool)
        {
            throw new IllegalArgumentException("No value for optional field: Pool");
        }

        return poolLength;
    }

    /* Pool = 691 */
    public String poolAsString()
    {
        return hasPool ? new String(pool, 0, poolLength) : null;
    }

    /* Pool = 691 */
    public AsciiSequenceView pool(final AsciiSequenceView view)
    {
        if (!hasPool)
        {
            throw new IllegalArgumentException("No value for optional field: Pool");
        }

        return view.wrap(buffer, poolOffset, poolLength);
    }


    private final CharArrayWrapper poolWrapper = new CharArrayWrapper();
    private byte[] contractSettlMonth = new byte[8];

    private boolean hasContractSettlMonth;

    /* ContractSettlMonth = 667 */
    public byte[] contractSettlMonth()
    {
        if (!hasContractSettlMonth)
        {
            throw new IllegalArgumentException("No value for optional field: ContractSettlMonth");
        }

        return contractSettlMonth;
    }

    public boolean hasContractSettlMonth()
    {
        return hasContractSettlMonth;
    }


    private int contractSettlMonthOffset;

    private int contractSettlMonthLength;

    /* ContractSettlMonth = 667 */
    public int contractSettlMonthLength()
    {
        if (!hasContractSettlMonth)
        {
            throw new IllegalArgumentException("No value for optional field: ContractSettlMonth");
        }

        return contractSettlMonthLength;
    }

    /* ContractSettlMonth = 667 */
    public String contractSettlMonthAsString()
    {
        return hasContractSettlMonth ? new String(contractSettlMonth, 0, contractSettlMonthLength) : null;
    }

    /* ContractSettlMonth = 667 */
    public AsciiSequenceView contractSettlMonth(final AsciiSequenceView view)
    {
        if (!hasContractSettlMonth)
        {
            throw new IllegalArgumentException("No value for optional field: ContractSettlMonth");
        }

        return view.wrap(buffer, contractSettlMonthOffset, contractSettlMonthLength);
    }


    private int cPProgram = MISSING_INT;

    private boolean hasCPProgram;

    /* CPProgram = 875 */
    public int cPProgram()
    {
        if (!hasCPProgram)
        {
            throw new IllegalArgumentException("No value for optional field: CPProgram");
        }

        return cPProgram;
    }

    public boolean hasCPProgram()
    {
        return hasCPProgram;
    }



    private char[] cPRegType = new char[1];

    private boolean hasCPRegType;

    /* CPRegType = 876 */
    public char[] cPRegType()
    {
        if (!hasCPRegType)
        {
            throw new IllegalArgumentException("No value for optional field: CPRegType");
        }

        return cPRegType;
    }

    public boolean hasCPRegType()
    {
        return hasCPRegType;
    }


    private int cPRegTypeOffset;

    private int cPRegTypeLength;

    /* CPRegType = 876 */
    public int cPRegTypeLength()
    {
        if (!hasCPRegType)
        {
            throw new IllegalArgumentException("No value for optional field: CPRegType");
        }

        return cPRegTypeLength;
    }

    /* CPRegType = 876 */
    public String cPRegTypeAsString()
    {
        return hasCPRegType ? new String(cPRegType, 0, cPRegTypeLength) : null;
    }

    /* CPRegType = 876 */
    public AsciiSequenceView cPRegType(final AsciiSequenceView view)
    {
        if (!hasCPRegType)
        {
            throw new IllegalArgumentException("No value for optional field: CPRegType");
        }

        return view.wrap(buffer, cPRegTypeOffset, cPRegTypeLength);
    }


    private final CharArrayWrapper cPRegTypeWrapper = new CharArrayWrapper();

    private EventsGroupDecoder eventsGroup = null;
    public EventsGroupDecoder eventsGroup()
    {
        return eventsGroup;
    }

    private int noEventsGroupCounter = MISSING_INT;

    private boolean hasNoEventsGroupCounter;

    /* NoEventsGroupCounter = 864 */
    public int noEventsGroupCounter()
    {
        if (!hasNoEventsGroupCounter)
        {
            throw new IllegalArgumentException("No value for optional field: NoEventsGroupCounter");
        }

        return noEventsGroupCounter;
    }

    public boolean hasNoEventsGroupCounter()
    {
        return hasNoEventsGroupCounter;
    }




    private EventsGroupIterator eventsGroupIterator = new EventsGroupIterator(this);
    public EventsGroupIterator eventsGroupIterator()
    {
        return eventsGroupIterator.iterator();
    }

    private byte[] datedDate = new byte[8];

    private boolean hasDatedDate;

    /* DatedDate = 873 */
    public byte[] datedDate()
    {
        if (!hasDatedDate)
        {
            throw new IllegalArgumentException("No value for optional field: DatedDate");
        }

        return datedDate;
    }

    public boolean hasDatedDate()
    {
        return hasDatedDate;
    }


    private int datedDateOffset;

    private int datedDateLength;

    /* DatedDate = 873 */
    public int datedDateLength()
    {
        if (!hasDatedDate)
        {
            throw new IllegalArgumentException("No value for optional field: DatedDate");
        }

        return datedDateLength;
    }

    /* DatedDate = 873 */
    public String datedDateAsString()
    {
        return hasDatedDate ? new String(datedDate, 0, datedDateLength) : null;
    }

    /* DatedDate = 873 */
    public AsciiSequenceView datedDate(final AsciiSequenceView view)
    {
        if (!hasDatedDate)
        {
            throw new IllegalArgumentException("No value for optional field: DatedDate");
        }

        return view.wrap(buffer, datedDateOffset, datedDateLength);
    }


    private byte[] interestAccrualDate = new byte[8];

    private boolean hasInterestAccrualDate;

    /* InterestAccrualDate = 874 */
    public byte[] interestAccrualDate()
    {
        if (!hasInterestAccrualDate)
        {
            throw new IllegalArgumentException("No value for optional field: InterestAccrualDate");
        }

        return interestAccrualDate;
    }

    public boolean hasInterestAccrualDate()
    {
        return hasInterestAccrualDate;
    }


    private int interestAccrualDateOffset;

    private int interestAccrualDateLength;

    /* InterestAccrualDate = 874 */
    public int interestAccrualDateLength()
    {
        if (!hasInterestAccrualDate)
        {
            throw new IllegalArgumentException("No value for optional field: InterestAccrualDate");
        }

        return interestAccrualDateLength;
    }

    /* InterestAccrualDate = 874 */
    public String interestAccrualDateAsString()
    {
        return hasInterestAccrualDate ? new String(interestAccrualDate, 0, interestAccrualDateLength) : null;
    }

    /* InterestAccrualDate = 874 */
    public AsciiSequenceView interestAccrualDate(final AsciiSequenceView view)
    {
        if (!hasInterestAccrualDate)
        {
            throw new IllegalArgumentException("No value for optional field: InterestAccrualDate");
        }

        return view.wrap(buffer, interestAccrualDateOffset, interestAccrualDateLength);
    }




@Generated("uk.co.real_logic.artio")
public class UnderlyingsGroupDecoder extends CommonDecoderImpl implements UnderlyingInstrumentDecoder
{
    public final IntHashSet REQUIRED_FIELDS = new IntHashSet(0);

    {
        if (CODEC_VALIDATION_ENABLED)
        {
        }
    }

    public final IntHashSet GROUP_FIELDS = new IntHashSet(88);

    {
        if (CODEC_VALIDATION_ENABLED)
        {
            GROUP_FIELDS.add(Constants.UNDERLYING_SYMBOL);
            GROUP_FIELDS.add(Constants.UNDERLYING_SYMBOL_SFX);
            GROUP_FIELDS.add(Constants.UNDERLYING_SECURITY_ID);
            GROUP_FIELDS.add(Constants.UNDERLYING_SECURITY_ID_SOURCE);
            GROUP_FIELDS.add(Constants.UNDERLYING_PRODUCT);
            GROUP_FIELDS.add(Constants.UNDERLYING_C_F_I_CODE);
            GROUP_FIELDS.add(Constants.UNDERLYING_SECURITY_TYPE);
            GROUP_FIELDS.add(Constants.UNDERLYING_SECURITY_SUB_TYPE);
            GROUP_FIELDS.add(Constants.UNDERLYING_MATURITY_MONTH_YEAR);
            GROUP_FIELDS.add(Constants.UNDERLYING_MATURITY_DATE);
            GROUP_FIELDS.add(Constants.UNDERLYING_COUPON_PAYMENT_DATE);
            GROUP_FIELDS.add(Constants.UNDERLYING_ISSUE_DATE);
            GROUP_FIELDS.add(Constants.UNDERLYING_REPO_COLLATERAL_SECURITY_TYPE);
            GROUP_FIELDS.add(Constants.UNDERLYING_REPURCHASE_TERM);
            GROUP_FIELDS.add(Constants.UNDERLYING_REPURCHASE_RATE);
            GROUP_FIELDS.add(Constants.UNDERLYING_FACTOR);
            GROUP_FIELDS.add(Constants.UNDERLYING_CREDIT_RATING);
            GROUP_FIELDS.add(Constants.UNDERLYING_INSTR_REGISTRY);
            GROUP_FIELDS.add(Constants.UNDERLYING_COUNTRY_OF_ISSUE);
            GROUP_FIELDS.add(Constants.UNDERLYING_STATE_OR_PROVINCE_OF_ISSUE);
            GROUP_FIELDS.add(Constants.UNDERLYING_LOCALE_OF_ISSUE);
            GROUP_FIELDS.add(Constants.UNDERLYING_REDEMPTION_DATE);
            GROUP_FIELDS.add(Constants.UNDERLYING_STRIKE_PRICE);
            GROUP_FIELDS.add(Constants.UNDERLYING_STRIKE_CURRENCY);
            GROUP_FIELDS.add(Constants.UNDERLYING_OPT_ATTRIBUTE);
            GROUP_FIELDS.add(Constants.UNDERLYING_CONTRACT_MULTIPLIER);
            GROUP_FIELDS.add(Constants.UNDERLYING_COUPON_RATE);
            GROUP_FIELDS.add(Constants.UNDERLYING_SECURITY_EXCHANGE);
            GROUP_FIELDS.add(Constants.UNDERLYING_ISSUER);
            GROUP_FIELDS.add(Constants.ENCODED_UNDERLYING_ISSUER_LEN);
            GROUP_FIELDS.add(Constants.ENCODED_UNDERLYING_ISSUER);
            GROUP_FIELDS.add(Constants.UNDERLYING_SECURITY_DESC);
            GROUP_FIELDS.add(Constants.ENCODED_UNDERLYING_SECURITY_DESC_LEN);
            GROUP_FIELDS.add(Constants.ENCODED_UNDERLYING_SECURITY_DESC);
            GROUP_FIELDS.add(Constants.UNDERLYING_C_P_PROGRAM);
            GROUP_FIELDS.add(Constants.UNDERLYING_C_P_REG_TYPE);
            GROUP_FIELDS.add(Constants.UNDERLYING_CURRENCY);
            GROUP_FIELDS.add(Constants.UNDERLYING_QTY);
            GROUP_FIELDS.add(Constants.UNDERLYING_PX);
            GROUP_FIELDS.add(Constants.UNDERLYING_DIRTY_PRICE);
            GROUP_FIELDS.add(Constants.UNDERLYING_END_PRICE);
            GROUP_FIELDS.add(Constants.UNDERLYING_START_VALUE);
            GROUP_FIELDS.add(Constants.UNDERLYING_CURRENT_VALUE);
            GROUP_FIELDS.add(Constants.UNDERLYING_END_VALUE);
        }
    }

    public final IntHashSet ALL_GROUP_FIELDS = new IntHashSet(0);

    {
        if (CODEC_VALIDATION_ENABLED)
        {
        }
    }

    private final IntHashSet missingRequiredFields = new IntHashSet(0);

    public boolean validate()
    {
        if (rejectReason != Decoder.NO_ERROR)
        {
            return false;
        }
        final IntIterator missingFieldsIterator = missingRequiredFields.iterator();
        if (missingFieldsIterator.hasNext())
        {
            invalidTagId = missingFieldsIterator.nextValue();
            rejectReason = 1;
            return false;
        }
        if (hasNoUnderlyingSecurityAltIDGroupCounter)
        {
            {
                int count = 0;
                final UnderlyingSecurityAltIDGroupIterator iterator = underlyingSecurityAltIDGroupIterator.iterator();
                for (final UnderlyingSecurityAltIDGroupDecoder group : iterator)
                {
                    count++;                    if (!group.validate())
                    {
                        invalidTagId = group.invalidTagId();
                        rejectReason = group.rejectReason();
                        return false;
                    }
                }
                if (count != iterator.numberFieldValue())
                {
                    invalidTagId = 457;
                    rejectReason = 16;
                    return false;
                }
            }
        }

        if (hasNoUnderlyingStipsGroupCounter)
        {
            {
                int count = 0;
                final UnderlyingStipsGroupIterator iterator = underlyingStipsGroupIterator.iterator();
                for (final UnderlyingStipsGroupDecoder group : iterator)
                {
                    count++;                    if (!group.validate())
                    {
                        invalidTagId = group.invalidTagId();
                        rejectReason = group.rejectReason();
                        return false;
                    }
                }
                if (count != iterator.numberFieldValue())
                {
                    invalidTagId = 887;
                    rejectReason = 16;
                    return false;
                }
            }
        }
        return true;
    }

    private final TrailerDecoder trailer;
    private final IntHashSet messageFields;
    public UnderlyingsGroupDecoder(final TrailerDecoder trailer, final IntHashSet messageFields)
    {
        this.trailer = trailer;
        this.messageFields = messageFields;
    }

    private UnderlyingsGroupDecoder next = null;

    public UnderlyingsGroupDecoder next()
    {
        return next;
    }

    private IntHashSet seenFields = new IntHashSet(2);


    private char[] underlyingSymbol = new char[1];

    /* UnderlyingSymbol = 311 */
    public char[] underlyingSymbol()
    {
        return underlyingSymbol;
    }


    private int underlyingSymbolOffset;

    private int underlyingSymbolLength;

    /* UnderlyingSymbol = 311 */
    public int underlyingSymbolLength()
    {
        return underlyingSymbolLength;
    }

    /* UnderlyingSymbol = 311 */
    public String underlyingSymbolAsString()
    {
        return new String(underlyingSymbol, 0, underlyingSymbolLength);
    }

    /* UnderlyingSymbol = 311 */
    public AsciiSequenceView underlyingSymbol(final AsciiSequenceView view)
    {
        return view.wrap(buffer, underlyingSymbolOffset, underlyingSymbolLength);
    }


    private final CharArrayWrapper underlyingSymbolWrapper = new CharArrayWrapper();
    private char[] underlyingSymbolSfx = new char[1];

    private boolean hasUnderlyingSymbolSfx;

    /* UnderlyingSymbolSfx = 312 */
    public char[] underlyingSymbolSfx()
    {
        if (!hasUnderlyingSymbolSfx)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingSymbolSfx");
        }

        return underlyingSymbolSfx;
    }

    public boolean hasUnderlyingSymbolSfx()
    {
        return hasUnderlyingSymbolSfx;
    }


    private int underlyingSymbolSfxOffset;

    private int underlyingSymbolSfxLength;

    /* UnderlyingSymbolSfx = 312 */
    public int underlyingSymbolSfxLength()
    {
        if (!hasUnderlyingSymbolSfx)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingSymbolSfx");
        }

        return underlyingSymbolSfxLength;
    }

    /* UnderlyingSymbolSfx = 312 */
    public String underlyingSymbolSfxAsString()
    {
        return hasUnderlyingSymbolSfx ? new String(underlyingSymbolSfx, 0, underlyingSymbolSfxLength) : null;
    }

    /* UnderlyingSymbolSfx = 312 */
    public AsciiSequenceView underlyingSymbolSfx(final AsciiSequenceView view)
    {
        if (!hasUnderlyingSymbolSfx)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingSymbolSfx");
        }

        return view.wrap(buffer, underlyingSymbolSfxOffset, underlyingSymbolSfxLength);
    }


    private final CharArrayWrapper underlyingSymbolSfxWrapper = new CharArrayWrapper();
    private char[] underlyingSecurityID = new char[1];

    private boolean hasUnderlyingSecurityID;

    /* UnderlyingSecurityID = 309 */
    public char[] underlyingSecurityID()
    {
        if (!hasUnderlyingSecurityID)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingSecurityID");
        }

        return underlyingSecurityID;
    }

    public boolean hasUnderlyingSecurityID()
    {
        return hasUnderlyingSecurityID;
    }


    private int underlyingSecurityIDOffset;

    private int underlyingSecurityIDLength;

    /* UnderlyingSecurityID = 309 */
    public int underlyingSecurityIDLength()
    {
        if (!hasUnderlyingSecurityID)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingSecurityID");
        }

        return underlyingSecurityIDLength;
    }

    /* UnderlyingSecurityID = 309 */
    public String underlyingSecurityIDAsString()
    {
        return hasUnderlyingSecurityID ? new String(underlyingSecurityID, 0, underlyingSecurityIDLength) : null;
    }

    /* UnderlyingSecurityID = 309 */
    public AsciiSequenceView underlyingSecurityID(final AsciiSequenceView view)
    {
        if (!hasUnderlyingSecurityID)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingSecurityID");
        }

        return view.wrap(buffer, underlyingSecurityIDOffset, underlyingSecurityIDLength);
    }


    private final CharArrayWrapper underlyingSecurityIDWrapper = new CharArrayWrapper();
    private char[] underlyingSecurityIDSource = new char[1];

    private boolean hasUnderlyingSecurityIDSource;

    /* UnderlyingSecurityIDSource = 305 */
    public char[] underlyingSecurityIDSource()
    {
        if (!hasUnderlyingSecurityIDSource)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingSecurityIDSource");
        }

        return underlyingSecurityIDSource;
    }

    public boolean hasUnderlyingSecurityIDSource()
    {
        return hasUnderlyingSecurityIDSource;
    }


    private int underlyingSecurityIDSourceOffset;

    private int underlyingSecurityIDSourceLength;

    /* UnderlyingSecurityIDSource = 305 */
    public int underlyingSecurityIDSourceLength()
    {
        if (!hasUnderlyingSecurityIDSource)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingSecurityIDSource");
        }

        return underlyingSecurityIDSourceLength;
    }

    /* UnderlyingSecurityIDSource = 305 */
    public String underlyingSecurityIDSourceAsString()
    {
        return hasUnderlyingSecurityIDSource ? new String(underlyingSecurityIDSource, 0, underlyingSecurityIDSourceLength) : null;
    }

    /* UnderlyingSecurityIDSource = 305 */
    public AsciiSequenceView underlyingSecurityIDSource(final AsciiSequenceView view)
    {
        if (!hasUnderlyingSecurityIDSource)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingSecurityIDSource");
        }

        return view.wrap(buffer, underlyingSecurityIDSourceOffset, underlyingSecurityIDSourceLength);
    }


    private final CharArrayWrapper underlyingSecurityIDSourceWrapper = new CharArrayWrapper();

    private UnderlyingSecurityAltIDGroupDecoder underlyingSecurityAltIDGroup = null;
    public UnderlyingSecurityAltIDGroupDecoder underlyingSecurityAltIDGroup()
    {
        return underlyingSecurityAltIDGroup;
    }

    private int noUnderlyingSecurityAltIDGroupCounter = MISSING_INT;

    private boolean hasNoUnderlyingSecurityAltIDGroupCounter;

    /* NoUnderlyingSecurityAltIDGroupCounter = 457 */
    public int noUnderlyingSecurityAltIDGroupCounter()
    {
        if (!hasNoUnderlyingSecurityAltIDGroupCounter)
        {
            throw new IllegalArgumentException("No value for optional field: NoUnderlyingSecurityAltIDGroupCounter");
        }

        return noUnderlyingSecurityAltIDGroupCounter;
    }

    public boolean hasNoUnderlyingSecurityAltIDGroupCounter()
    {
        return hasNoUnderlyingSecurityAltIDGroupCounter;
    }




    private UnderlyingSecurityAltIDGroupIterator underlyingSecurityAltIDGroupIterator = new UnderlyingSecurityAltIDGroupIterator(this);
    public UnderlyingSecurityAltIDGroupIterator underlyingSecurityAltIDGroupIterator()
    {
        return underlyingSecurityAltIDGroupIterator.iterator();
    }

    private int underlyingProduct = MISSING_INT;

    private boolean hasUnderlyingProduct;

    /* UnderlyingProduct = 462 */
    public int underlyingProduct()
    {
        if (!hasUnderlyingProduct)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingProduct");
        }

        return underlyingProduct;
    }

    public boolean hasUnderlyingProduct()
    {
        return hasUnderlyingProduct;
    }



    private char[] underlyingCFICode = new char[1];

    private boolean hasUnderlyingCFICode;

    /* UnderlyingCFICode = 463 */
    public char[] underlyingCFICode()
    {
        if (!hasUnderlyingCFICode)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingCFICode");
        }

        return underlyingCFICode;
    }

    public boolean hasUnderlyingCFICode()
    {
        return hasUnderlyingCFICode;
    }


    private int underlyingCFICodeOffset;

    private int underlyingCFICodeLength;

    /* UnderlyingCFICode = 463 */
    public int underlyingCFICodeLength()
    {
        if (!hasUnderlyingCFICode)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingCFICode");
        }

        return underlyingCFICodeLength;
    }

    /* UnderlyingCFICode = 463 */
    public String underlyingCFICodeAsString()
    {
        return hasUnderlyingCFICode ? new String(underlyingCFICode, 0, underlyingCFICodeLength) : null;
    }

    /* UnderlyingCFICode = 463 */
    public AsciiSequenceView underlyingCFICode(final AsciiSequenceView view)
    {
        if (!hasUnderlyingCFICode)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingCFICode");
        }

        return view.wrap(buffer, underlyingCFICodeOffset, underlyingCFICodeLength);
    }


    private final CharArrayWrapper underlyingCFICodeWrapper = new CharArrayWrapper();
    private char[] underlyingSecurityType = new char[1];

    private boolean hasUnderlyingSecurityType;

    /* UnderlyingSecurityType = 310 */
    public char[] underlyingSecurityType()
    {
        if (!hasUnderlyingSecurityType)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingSecurityType");
        }

        return underlyingSecurityType;
    }

    public boolean hasUnderlyingSecurityType()
    {
        return hasUnderlyingSecurityType;
    }


    private int underlyingSecurityTypeOffset;

    private int underlyingSecurityTypeLength;

    /* UnderlyingSecurityType = 310 */
    public int underlyingSecurityTypeLength()
    {
        if (!hasUnderlyingSecurityType)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingSecurityType");
        }

        return underlyingSecurityTypeLength;
    }

    /* UnderlyingSecurityType = 310 */
    public String underlyingSecurityTypeAsString()
    {
        return hasUnderlyingSecurityType ? new String(underlyingSecurityType, 0, underlyingSecurityTypeLength) : null;
    }

    /* UnderlyingSecurityType = 310 */
    public AsciiSequenceView underlyingSecurityType(final AsciiSequenceView view)
    {
        if (!hasUnderlyingSecurityType)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingSecurityType");
        }

        return view.wrap(buffer, underlyingSecurityTypeOffset, underlyingSecurityTypeLength);
    }


    private final CharArrayWrapper underlyingSecurityTypeWrapper = new CharArrayWrapper();
    private char[] underlyingSecuritySubType = new char[1];

    private boolean hasUnderlyingSecuritySubType;

    /* UnderlyingSecuritySubType = 763 */
    public char[] underlyingSecuritySubType()
    {
        if (!hasUnderlyingSecuritySubType)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingSecuritySubType");
        }

        return underlyingSecuritySubType;
    }

    public boolean hasUnderlyingSecuritySubType()
    {
        return hasUnderlyingSecuritySubType;
    }


    private int underlyingSecuritySubTypeOffset;

    private int underlyingSecuritySubTypeLength;

    /* UnderlyingSecuritySubType = 763 */
    public int underlyingSecuritySubTypeLength()
    {
        if (!hasUnderlyingSecuritySubType)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingSecuritySubType");
        }

        return underlyingSecuritySubTypeLength;
    }

    /* UnderlyingSecuritySubType = 763 */
    public String underlyingSecuritySubTypeAsString()
    {
        return hasUnderlyingSecuritySubType ? new String(underlyingSecuritySubType, 0, underlyingSecuritySubTypeLength) : null;
    }

    /* UnderlyingSecuritySubType = 763 */
    public AsciiSequenceView underlyingSecuritySubType(final AsciiSequenceView view)
    {
        if (!hasUnderlyingSecuritySubType)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingSecuritySubType");
        }

        return view.wrap(buffer, underlyingSecuritySubTypeOffset, underlyingSecuritySubTypeLength);
    }


    private final CharArrayWrapper underlyingSecuritySubTypeWrapper = new CharArrayWrapper();
    private byte[] underlyingMaturityMonthYear = new byte[8];

    private boolean hasUnderlyingMaturityMonthYear;

    /* UnderlyingMaturityMonthYear = 313 */
    public byte[] underlyingMaturityMonthYear()
    {
        if (!hasUnderlyingMaturityMonthYear)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingMaturityMonthYear");
        }

        return underlyingMaturityMonthYear;
    }

    public boolean hasUnderlyingMaturityMonthYear()
    {
        return hasUnderlyingMaturityMonthYear;
    }


    private int underlyingMaturityMonthYearOffset;

    private int underlyingMaturityMonthYearLength;

    /* UnderlyingMaturityMonthYear = 313 */
    public int underlyingMaturityMonthYearLength()
    {
        if (!hasUnderlyingMaturityMonthYear)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingMaturityMonthYear");
        }

        return underlyingMaturityMonthYearLength;
    }

    /* UnderlyingMaturityMonthYear = 313 */
    public String underlyingMaturityMonthYearAsString()
    {
        return hasUnderlyingMaturityMonthYear ? new String(underlyingMaturityMonthYear, 0, underlyingMaturityMonthYearLength) : null;
    }

    /* UnderlyingMaturityMonthYear = 313 */
    public AsciiSequenceView underlyingMaturityMonthYear(final AsciiSequenceView view)
    {
        if (!hasUnderlyingMaturityMonthYear)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingMaturityMonthYear");
        }

        return view.wrap(buffer, underlyingMaturityMonthYearOffset, underlyingMaturityMonthYearLength);
    }


    private byte[] underlyingMaturityDate = new byte[8];

    private boolean hasUnderlyingMaturityDate;

    /* UnderlyingMaturityDate = 542 */
    public byte[] underlyingMaturityDate()
    {
        if (!hasUnderlyingMaturityDate)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingMaturityDate");
        }

        return underlyingMaturityDate;
    }

    public boolean hasUnderlyingMaturityDate()
    {
        return hasUnderlyingMaturityDate;
    }


    private int underlyingMaturityDateOffset;

    private int underlyingMaturityDateLength;

    /* UnderlyingMaturityDate = 542 */
    public int underlyingMaturityDateLength()
    {
        if (!hasUnderlyingMaturityDate)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingMaturityDate");
        }

        return underlyingMaturityDateLength;
    }

    /* UnderlyingMaturityDate = 542 */
    public String underlyingMaturityDateAsString()
    {
        return hasUnderlyingMaturityDate ? new String(underlyingMaturityDate, 0, underlyingMaturityDateLength) : null;
    }

    /* UnderlyingMaturityDate = 542 */
    public AsciiSequenceView underlyingMaturityDate(final AsciiSequenceView view)
    {
        if (!hasUnderlyingMaturityDate)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingMaturityDate");
        }

        return view.wrap(buffer, underlyingMaturityDateOffset, underlyingMaturityDateLength);
    }


    private byte[] underlyingCouponPaymentDate = new byte[8];

    private boolean hasUnderlyingCouponPaymentDate;

    /* UnderlyingCouponPaymentDate = 241 */
    public byte[] underlyingCouponPaymentDate()
    {
        if (!hasUnderlyingCouponPaymentDate)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingCouponPaymentDate");
        }

        return underlyingCouponPaymentDate;
    }

    public boolean hasUnderlyingCouponPaymentDate()
    {
        return hasUnderlyingCouponPaymentDate;
    }


    private int underlyingCouponPaymentDateOffset;

    private int underlyingCouponPaymentDateLength;

    /* UnderlyingCouponPaymentDate = 241 */
    public int underlyingCouponPaymentDateLength()
    {
        if (!hasUnderlyingCouponPaymentDate)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingCouponPaymentDate");
        }

        return underlyingCouponPaymentDateLength;
    }

    /* UnderlyingCouponPaymentDate = 241 */
    public String underlyingCouponPaymentDateAsString()
    {
        return hasUnderlyingCouponPaymentDate ? new String(underlyingCouponPaymentDate, 0, underlyingCouponPaymentDateLength) : null;
    }

    /* UnderlyingCouponPaymentDate = 241 */
    public AsciiSequenceView underlyingCouponPaymentDate(final AsciiSequenceView view)
    {
        if (!hasUnderlyingCouponPaymentDate)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingCouponPaymentDate");
        }

        return view.wrap(buffer, underlyingCouponPaymentDateOffset, underlyingCouponPaymentDateLength);
    }


    private byte[] underlyingIssueDate = new byte[8];

    private boolean hasUnderlyingIssueDate;

    /* UnderlyingIssueDate = 242 */
    public byte[] underlyingIssueDate()
    {
        if (!hasUnderlyingIssueDate)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingIssueDate");
        }

        return underlyingIssueDate;
    }

    public boolean hasUnderlyingIssueDate()
    {
        return hasUnderlyingIssueDate;
    }


    private int underlyingIssueDateOffset;

    private int underlyingIssueDateLength;

    /* UnderlyingIssueDate = 242 */
    public int underlyingIssueDateLength()
    {
        if (!hasUnderlyingIssueDate)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingIssueDate");
        }

        return underlyingIssueDateLength;
    }

    /* UnderlyingIssueDate = 242 */
    public String underlyingIssueDateAsString()
    {
        return hasUnderlyingIssueDate ? new String(underlyingIssueDate, 0, underlyingIssueDateLength) : null;
    }

    /* UnderlyingIssueDate = 242 */
    public AsciiSequenceView underlyingIssueDate(final AsciiSequenceView view)
    {
        if (!hasUnderlyingIssueDate)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingIssueDate");
        }

        return view.wrap(buffer, underlyingIssueDateOffset, underlyingIssueDateLength);
    }


    private int underlyingRepoCollateralSecurityType = MISSING_INT;

    private boolean hasUnderlyingRepoCollateralSecurityType;

    /* UnderlyingRepoCollateralSecurityType = 243 */
    public int underlyingRepoCollateralSecurityType()
    {
        if (!hasUnderlyingRepoCollateralSecurityType)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingRepoCollateralSecurityType");
        }

        return underlyingRepoCollateralSecurityType;
    }

    public boolean hasUnderlyingRepoCollateralSecurityType()
    {
        return hasUnderlyingRepoCollateralSecurityType;
    }



    private int underlyingRepurchaseTerm = MISSING_INT;

    private boolean hasUnderlyingRepurchaseTerm;

    /* UnderlyingRepurchaseTerm = 244 */
    public int underlyingRepurchaseTerm()
    {
        if (!hasUnderlyingRepurchaseTerm)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingRepurchaseTerm");
        }

        return underlyingRepurchaseTerm;
    }

    public boolean hasUnderlyingRepurchaseTerm()
    {
        return hasUnderlyingRepurchaseTerm;
    }



    private DecimalFloat underlyingRepurchaseRate = DecimalFloat.newNaNValue();

    private boolean hasUnderlyingRepurchaseRate;

    /* UnderlyingRepurchaseRate = 245 */
    public DecimalFloat underlyingRepurchaseRate()
    {
        if (!hasUnderlyingRepurchaseRate)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingRepurchaseRate");
        }

        return underlyingRepurchaseRate;
    }

    public boolean hasUnderlyingRepurchaseRate()
    {
        return hasUnderlyingRepurchaseRate;
    }



    private DecimalFloat underlyingFactor = DecimalFloat.newNaNValue();

    private boolean hasUnderlyingFactor;

    /* UnderlyingFactor = 246 */
    public DecimalFloat underlyingFactor()
    {
        if (!hasUnderlyingFactor)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingFactor");
        }

        return underlyingFactor;
    }

    public boolean hasUnderlyingFactor()
    {
        return hasUnderlyingFactor;
    }



    private char[] underlyingCreditRating = new char[1];

    private boolean hasUnderlyingCreditRating;

    /* UnderlyingCreditRating = 256 */
    public char[] underlyingCreditRating()
    {
        if (!hasUnderlyingCreditRating)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingCreditRating");
        }

        return underlyingCreditRating;
    }

    public boolean hasUnderlyingCreditRating()
    {
        return hasUnderlyingCreditRating;
    }


    private int underlyingCreditRatingOffset;

    private int underlyingCreditRatingLength;

    /* UnderlyingCreditRating = 256 */
    public int underlyingCreditRatingLength()
    {
        if (!hasUnderlyingCreditRating)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingCreditRating");
        }

        return underlyingCreditRatingLength;
    }

    /* UnderlyingCreditRating = 256 */
    public String underlyingCreditRatingAsString()
    {
        return hasUnderlyingCreditRating ? new String(underlyingCreditRating, 0, underlyingCreditRatingLength) : null;
    }

    /* UnderlyingCreditRating = 256 */
    public AsciiSequenceView underlyingCreditRating(final AsciiSequenceView view)
    {
        if (!hasUnderlyingCreditRating)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingCreditRating");
        }

        return view.wrap(buffer, underlyingCreditRatingOffset, underlyingCreditRatingLength);
    }


    private final CharArrayWrapper underlyingCreditRatingWrapper = new CharArrayWrapper();
    private char[] underlyingInstrRegistry = new char[1];

    private boolean hasUnderlyingInstrRegistry;

    /* UnderlyingInstrRegistry = 595 */
    public char[] underlyingInstrRegistry()
    {
        if (!hasUnderlyingInstrRegistry)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingInstrRegistry");
        }

        return underlyingInstrRegistry;
    }

    public boolean hasUnderlyingInstrRegistry()
    {
        return hasUnderlyingInstrRegistry;
    }


    private int underlyingInstrRegistryOffset;

    private int underlyingInstrRegistryLength;

    /* UnderlyingInstrRegistry = 595 */
    public int underlyingInstrRegistryLength()
    {
        if (!hasUnderlyingInstrRegistry)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingInstrRegistry");
        }

        return underlyingInstrRegistryLength;
    }

    /* UnderlyingInstrRegistry = 595 */
    public String underlyingInstrRegistryAsString()
    {
        return hasUnderlyingInstrRegistry ? new String(underlyingInstrRegistry, 0, underlyingInstrRegistryLength) : null;
    }

    /* UnderlyingInstrRegistry = 595 */
    public AsciiSequenceView underlyingInstrRegistry(final AsciiSequenceView view)
    {
        if (!hasUnderlyingInstrRegistry)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingInstrRegistry");
        }

        return view.wrap(buffer, underlyingInstrRegistryOffset, underlyingInstrRegistryLength);
    }


    private final CharArrayWrapper underlyingInstrRegistryWrapper = new CharArrayWrapper();
    private char[] underlyingCountryOfIssue = new char[1];

    private boolean hasUnderlyingCountryOfIssue;

    /* UnderlyingCountryOfIssue = 592 */
    public char[] underlyingCountryOfIssue()
    {
        if (!hasUnderlyingCountryOfIssue)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingCountryOfIssue");
        }

        return underlyingCountryOfIssue;
    }

    public boolean hasUnderlyingCountryOfIssue()
    {
        return hasUnderlyingCountryOfIssue;
    }


    private int underlyingCountryOfIssueOffset;

    private int underlyingCountryOfIssueLength;

    /* UnderlyingCountryOfIssue = 592 */
    public int underlyingCountryOfIssueLength()
    {
        if (!hasUnderlyingCountryOfIssue)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingCountryOfIssue");
        }

        return underlyingCountryOfIssueLength;
    }

    /* UnderlyingCountryOfIssue = 592 */
    public String underlyingCountryOfIssueAsString()
    {
        return hasUnderlyingCountryOfIssue ? new String(underlyingCountryOfIssue, 0, underlyingCountryOfIssueLength) : null;
    }

    /* UnderlyingCountryOfIssue = 592 */
    public AsciiSequenceView underlyingCountryOfIssue(final AsciiSequenceView view)
    {
        if (!hasUnderlyingCountryOfIssue)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingCountryOfIssue");
        }

        return view.wrap(buffer, underlyingCountryOfIssueOffset, underlyingCountryOfIssueLength);
    }


    private char[] underlyingStateOrProvinceOfIssue = new char[1];

    private boolean hasUnderlyingStateOrProvinceOfIssue;

    /* UnderlyingStateOrProvinceOfIssue = 593 */
    public char[] underlyingStateOrProvinceOfIssue()
    {
        if (!hasUnderlyingStateOrProvinceOfIssue)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingStateOrProvinceOfIssue");
        }

        return underlyingStateOrProvinceOfIssue;
    }

    public boolean hasUnderlyingStateOrProvinceOfIssue()
    {
        return hasUnderlyingStateOrProvinceOfIssue;
    }


    private int underlyingStateOrProvinceOfIssueOffset;

    private int underlyingStateOrProvinceOfIssueLength;

    /* UnderlyingStateOrProvinceOfIssue = 593 */
    public int underlyingStateOrProvinceOfIssueLength()
    {
        if (!hasUnderlyingStateOrProvinceOfIssue)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingStateOrProvinceOfIssue");
        }

        return underlyingStateOrProvinceOfIssueLength;
    }

    /* UnderlyingStateOrProvinceOfIssue = 593 */
    public String underlyingStateOrProvinceOfIssueAsString()
    {
        return hasUnderlyingStateOrProvinceOfIssue ? new String(underlyingStateOrProvinceOfIssue, 0, underlyingStateOrProvinceOfIssueLength) : null;
    }

    /* UnderlyingStateOrProvinceOfIssue = 593 */
    public AsciiSequenceView underlyingStateOrProvinceOfIssue(final AsciiSequenceView view)
    {
        if (!hasUnderlyingStateOrProvinceOfIssue)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingStateOrProvinceOfIssue");
        }

        return view.wrap(buffer, underlyingStateOrProvinceOfIssueOffset, underlyingStateOrProvinceOfIssueLength);
    }


    private final CharArrayWrapper underlyingStateOrProvinceOfIssueWrapper = new CharArrayWrapper();
    private char[] underlyingLocaleOfIssue = new char[1];

    private boolean hasUnderlyingLocaleOfIssue;

    /* UnderlyingLocaleOfIssue = 594 */
    public char[] underlyingLocaleOfIssue()
    {
        if (!hasUnderlyingLocaleOfIssue)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingLocaleOfIssue");
        }

        return underlyingLocaleOfIssue;
    }

    public boolean hasUnderlyingLocaleOfIssue()
    {
        return hasUnderlyingLocaleOfIssue;
    }


    private int underlyingLocaleOfIssueOffset;

    private int underlyingLocaleOfIssueLength;

    /* UnderlyingLocaleOfIssue = 594 */
    public int underlyingLocaleOfIssueLength()
    {
        if (!hasUnderlyingLocaleOfIssue)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingLocaleOfIssue");
        }

        return underlyingLocaleOfIssueLength;
    }

    /* UnderlyingLocaleOfIssue = 594 */
    public String underlyingLocaleOfIssueAsString()
    {
        return hasUnderlyingLocaleOfIssue ? new String(underlyingLocaleOfIssue, 0, underlyingLocaleOfIssueLength) : null;
    }

    /* UnderlyingLocaleOfIssue = 594 */
    public AsciiSequenceView underlyingLocaleOfIssue(final AsciiSequenceView view)
    {
        if (!hasUnderlyingLocaleOfIssue)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingLocaleOfIssue");
        }

        return view.wrap(buffer, underlyingLocaleOfIssueOffset, underlyingLocaleOfIssueLength);
    }


    private final CharArrayWrapper underlyingLocaleOfIssueWrapper = new CharArrayWrapper();
    private byte[] underlyingRedemptionDate = new byte[8];

    private boolean hasUnderlyingRedemptionDate;

    /* UnderlyingRedemptionDate = 247 */
    public byte[] underlyingRedemptionDate()
    {
        if (!hasUnderlyingRedemptionDate)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingRedemptionDate");
        }

        return underlyingRedemptionDate;
    }

    public boolean hasUnderlyingRedemptionDate()
    {
        return hasUnderlyingRedemptionDate;
    }


    private int underlyingRedemptionDateOffset;

    private int underlyingRedemptionDateLength;

    /* UnderlyingRedemptionDate = 247 */
    public int underlyingRedemptionDateLength()
    {
        if (!hasUnderlyingRedemptionDate)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingRedemptionDate");
        }

        return underlyingRedemptionDateLength;
    }

    /* UnderlyingRedemptionDate = 247 */
    public String underlyingRedemptionDateAsString()
    {
        return hasUnderlyingRedemptionDate ? new String(underlyingRedemptionDate, 0, underlyingRedemptionDateLength) : null;
    }

    /* UnderlyingRedemptionDate = 247 */
    public AsciiSequenceView underlyingRedemptionDate(final AsciiSequenceView view)
    {
        if (!hasUnderlyingRedemptionDate)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingRedemptionDate");
        }

        return view.wrap(buffer, underlyingRedemptionDateOffset, underlyingRedemptionDateLength);
    }


    private DecimalFloat underlyingStrikePrice = DecimalFloat.newNaNValue();

    private boolean hasUnderlyingStrikePrice;

    /* UnderlyingStrikePrice = 316 */
    public DecimalFloat underlyingStrikePrice()
    {
        if (!hasUnderlyingStrikePrice)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingStrikePrice");
        }

        return underlyingStrikePrice;
    }

    public boolean hasUnderlyingStrikePrice()
    {
        return hasUnderlyingStrikePrice;
    }



    private char[] underlyingStrikeCurrency = new char[1];

    private boolean hasUnderlyingStrikeCurrency;

    /* UnderlyingStrikeCurrency = 941 */
    public char[] underlyingStrikeCurrency()
    {
        if (!hasUnderlyingStrikeCurrency)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingStrikeCurrency");
        }

        return underlyingStrikeCurrency;
    }

    public boolean hasUnderlyingStrikeCurrency()
    {
        return hasUnderlyingStrikeCurrency;
    }


    private int underlyingStrikeCurrencyOffset;

    private int underlyingStrikeCurrencyLength;

    /* UnderlyingStrikeCurrency = 941 */
    public int underlyingStrikeCurrencyLength()
    {
        if (!hasUnderlyingStrikeCurrency)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingStrikeCurrency");
        }

        return underlyingStrikeCurrencyLength;
    }

    /* UnderlyingStrikeCurrency = 941 */
    public String underlyingStrikeCurrencyAsString()
    {
        return hasUnderlyingStrikeCurrency ? new String(underlyingStrikeCurrency, 0, underlyingStrikeCurrencyLength) : null;
    }

    /* UnderlyingStrikeCurrency = 941 */
    public AsciiSequenceView underlyingStrikeCurrency(final AsciiSequenceView view)
    {
        if (!hasUnderlyingStrikeCurrency)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingStrikeCurrency");
        }

        return view.wrap(buffer, underlyingStrikeCurrencyOffset, underlyingStrikeCurrencyLength);
    }


    private char underlyingOptAttribute = MISSING_CHAR;

    private boolean hasUnderlyingOptAttribute;

    /* UnderlyingOptAttribute = 317 */
    public char underlyingOptAttribute()
    {
        if (!hasUnderlyingOptAttribute)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingOptAttribute");
        }

        return underlyingOptAttribute;
    }

    public boolean hasUnderlyingOptAttribute()
    {
        return hasUnderlyingOptAttribute;
    }



    private DecimalFloat underlyingContractMultiplier = DecimalFloat.newNaNValue();

    private boolean hasUnderlyingContractMultiplier;

    /* UnderlyingContractMultiplier = 436 */
    public DecimalFloat underlyingContractMultiplier()
    {
        if (!hasUnderlyingContractMultiplier)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingContractMultiplier");
        }

        return underlyingContractMultiplier;
    }

    public boolean hasUnderlyingContractMultiplier()
    {
        return hasUnderlyingContractMultiplier;
    }



    private DecimalFloat underlyingCouponRate = DecimalFloat.newNaNValue();

    private boolean hasUnderlyingCouponRate;

    /* UnderlyingCouponRate = 435 */
    public DecimalFloat underlyingCouponRate()
    {
        if (!hasUnderlyingCouponRate)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingCouponRate");
        }

        return underlyingCouponRate;
    }

    public boolean hasUnderlyingCouponRate()
    {
        return hasUnderlyingCouponRate;
    }



    private char[] underlyingSecurityExchange = new char[1];

    private boolean hasUnderlyingSecurityExchange;

    /* UnderlyingSecurityExchange = 308 */
    public char[] underlyingSecurityExchange()
    {
        if (!hasUnderlyingSecurityExchange)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingSecurityExchange");
        }

        return underlyingSecurityExchange;
    }

    public boolean hasUnderlyingSecurityExchange()
    {
        return hasUnderlyingSecurityExchange;
    }


    private int underlyingSecurityExchangeOffset;

    private int underlyingSecurityExchangeLength;

    /* UnderlyingSecurityExchange = 308 */
    public int underlyingSecurityExchangeLength()
    {
        if (!hasUnderlyingSecurityExchange)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingSecurityExchange");
        }

        return underlyingSecurityExchangeLength;
    }

    /* UnderlyingSecurityExchange = 308 */
    public String underlyingSecurityExchangeAsString()
    {
        return hasUnderlyingSecurityExchange ? new String(underlyingSecurityExchange, 0, underlyingSecurityExchangeLength) : null;
    }

    /* UnderlyingSecurityExchange = 308 */
    public AsciiSequenceView underlyingSecurityExchange(final AsciiSequenceView view)
    {
        if (!hasUnderlyingSecurityExchange)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingSecurityExchange");
        }

        return view.wrap(buffer, underlyingSecurityExchangeOffset, underlyingSecurityExchangeLength);
    }


    private char[] underlyingIssuer = new char[1];

    private boolean hasUnderlyingIssuer;

    /* UnderlyingIssuer = 306 */
    public char[] underlyingIssuer()
    {
        if (!hasUnderlyingIssuer)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingIssuer");
        }

        return underlyingIssuer;
    }

    public boolean hasUnderlyingIssuer()
    {
        return hasUnderlyingIssuer;
    }


    private int underlyingIssuerOffset;

    private int underlyingIssuerLength;

    /* UnderlyingIssuer = 306 */
    public int underlyingIssuerLength()
    {
        if (!hasUnderlyingIssuer)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingIssuer");
        }

        return underlyingIssuerLength;
    }

    /* UnderlyingIssuer = 306 */
    public String underlyingIssuerAsString()
    {
        return hasUnderlyingIssuer ? new String(underlyingIssuer, 0, underlyingIssuerLength) : null;
    }

    /* UnderlyingIssuer = 306 */
    public AsciiSequenceView underlyingIssuer(final AsciiSequenceView view)
    {
        if (!hasUnderlyingIssuer)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingIssuer");
        }

        return view.wrap(buffer, underlyingIssuerOffset, underlyingIssuerLength);
    }


    private final CharArrayWrapper underlyingIssuerWrapper = new CharArrayWrapper();
    private int encodedUnderlyingIssuerLen = MISSING_INT;

    private boolean hasEncodedUnderlyingIssuerLen;

    /* EncodedUnderlyingIssuerLen = 362 */
    public int encodedUnderlyingIssuerLen()
    {
        if (!hasEncodedUnderlyingIssuerLen)
        {
            throw new IllegalArgumentException("No value for optional field: EncodedUnderlyingIssuerLen");
        }

        return encodedUnderlyingIssuerLen;
    }

    public boolean hasEncodedUnderlyingIssuerLen()
    {
        return hasEncodedUnderlyingIssuerLen;
    }



    private byte[] encodedUnderlyingIssuer = new byte[1];

    private boolean hasEncodedUnderlyingIssuer;

    /* EncodedUnderlyingIssuer = 363 */
    public byte[] encodedUnderlyingIssuer()
    {
        if (!hasEncodedUnderlyingIssuer)
        {
            throw new IllegalArgumentException("No value for optional field: EncodedUnderlyingIssuer");
        }

        return encodedUnderlyingIssuer;
    }

    public boolean hasEncodedUnderlyingIssuer()
    {
        return hasEncodedUnderlyingIssuer;
    }



    private char[] underlyingSecurityDesc = new char[1];

    private boolean hasUnderlyingSecurityDesc;

    /* UnderlyingSecurityDesc = 307 */
    public char[] underlyingSecurityDesc()
    {
        if (!hasUnderlyingSecurityDesc)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingSecurityDesc");
        }

        return underlyingSecurityDesc;
    }

    public boolean hasUnderlyingSecurityDesc()
    {
        return hasUnderlyingSecurityDesc;
    }


    private int underlyingSecurityDescOffset;

    private int underlyingSecurityDescLength;

    /* UnderlyingSecurityDesc = 307 */
    public int underlyingSecurityDescLength()
    {
        if (!hasUnderlyingSecurityDesc)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingSecurityDesc");
        }

        return underlyingSecurityDescLength;
    }

    /* UnderlyingSecurityDesc = 307 */
    public String underlyingSecurityDescAsString()
    {
        return hasUnderlyingSecurityDesc ? new String(underlyingSecurityDesc, 0, underlyingSecurityDescLength) : null;
    }

    /* UnderlyingSecurityDesc = 307 */
    public AsciiSequenceView underlyingSecurityDesc(final AsciiSequenceView view)
    {
        if (!hasUnderlyingSecurityDesc)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingSecurityDesc");
        }

        return view.wrap(buffer, underlyingSecurityDescOffset, underlyingSecurityDescLength);
    }


    private final CharArrayWrapper underlyingSecurityDescWrapper = new CharArrayWrapper();
    private int encodedUnderlyingSecurityDescLen = MISSING_INT;

    private boolean hasEncodedUnderlyingSecurityDescLen;

    /* EncodedUnderlyingSecurityDescLen = 364 */
    public int encodedUnderlyingSecurityDescLen()
    {
        if (!hasEncodedUnderlyingSecurityDescLen)
        {
            throw new IllegalArgumentException("No value for optional field: EncodedUnderlyingSecurityDescLen");
        }

        return encodedUnderlyingSecurityDescLen;
    }

    public boolean hasEncodedUnderlyingSecurityDescLen()
    {
        return hasEncodedUnderlyingSecurityDescLen;
    }



    private byte[] encodedUnderlyingSecurityDesc = new byte[1];

    private boolean hasEncodedUnderlyingSecurityDesc;

    /* EncodedUnderlyingSecurityDesc = 365 */
    public byte[] encodedUnderlyingSecurityDesc()
    {
        if (!hasEncodedUnderlyingSecurityDesc)
        {
            throw new IllegalArgumentException("No value for optional field: EncodedUnderlyingSecurityDesc");
        }

        return encodedUnderlyingSecurityDesc;
    }

    public boolean hasEncodedUnderlyingSecurityDesc()
    {
        return hasEncodedUnderlyingSecurityDesc;
    }



    private char[] underlyingCPProgram = new char[1];

    private boolean hasUnderlyingCPProgram;

    /* UnderlyingCPProgram = 877 */
    public char[] underlyingCPProgram()
    {
        if (!hasUnderlyingCPProgram)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingCPProgram");
        }

        return underlyingCPProgram;
    }

    public boolean hasUnderlyingCPProgram()
    {
        return hasUnderlyingCPProgram;
    }


    private int underlyingCPProgramOffset;

    private int underlyingCPProgramLength;

    /* UnderlyingCPProgram = 877 */
    public int underlyingCPProgramLength()
    {
        if (!hasUnderlyingCPProgram)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingCPProgram");
        }

        return underlyingCPProgramLength;
    }

    /* UnderlyingCPProgram = 877 */
    public String underlyingCPProgramAsString()
    {
        return hasUnderlyingCPProgram ? new String(underlyingCPProgram, 0, underlyingCPProgramLength) : null;
    }

    /* UnderlyingCPProgram = 877 */
    public AsciiSequenceView underlyingCPProgram(final AsciiSequenceView view)
    {
        if (!hasUnderlyingCPProgram)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingCPProgram");
        }

        return view.wrap(buffer, underlyingCPProgramOffset, underlyingCPProgramLength);
    }


    private final CharArrayWrapper underlyingCPProgramWrapper = new CharArrayWrapper();
    private char[] underlyingCPRegType = new char[1];

    private boolean hasUnderlyingCPRegType;

    /* UnderlyingCPRegType = 878 */
    public char[] underlyingCPRegType()
    {
        if (!hasUnderlyingCPRegType)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingCPRegType");
        }

        return underlyingCPRegType;
    }

    public boolean hasUnderlyingCPRegType()
    {
        return hasUnderlyingCPRegType;
    }


    private int underlyingCPRegTypeOffset;

    private int underlyingCPRegTypeLength;

    /* UnderlyingCPRegType = 878 */
    public int underlyingCPRegTypeLength()
    {
        if (!hasUnderlyingCPRegType)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingCPRegType");
        }

        return underlyingCPRegTypeLength;
    }

    /* UnderlyingCPRegType = 878 */
    public String underlyingCPRegTypeAsString()
    {
        return hasUnderlyingCPRegType ? new String(underlyingCPRegType, 0, underlyingCPRegTypeLength) : null;
    }

    /* UnderlyingCPRegType = 878 */
    public AsciiSequenceView underlyingCPRegType(final AsciiSequenceView view)
    {
        if (!hasUnderlyingCPRegType)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingCPRegType");
        }

        return view.wrap(buffer, underlyingCPRegTypeOffset, underlyingCPRegTypeLength);
    }


    private final CharArrayWrapper underlyingCPRegTypeWrapper = new CharArrayWrapper();
    private char[] underlyingCurrency = new char[1];

    private boolean hasUnderlyingCurrency;

    /* UnderlyingCurrency = 318 */
    public char[] underlyingCurrency()
    {
        if (!hasUnderlyingCurrency)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingCurrency");
        }

        return underlyingCurrency;
    }

    public boolean hasUnderlyingCurrency()
    {
        return hasUnderlyingCurrency;
    }


    private int underlyingCurrencyOffset;

    private int underlyingCurrencyLength;

    /* UnderlyingCurrency = 318 */
    public int underlyingCurrencyLength()
    {
        if (!hasUnderlyingCurrency)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingCurrency");
        }

        return underlyingCurrencyLength;
    }

    /* UnderlyingCurrency = 318 */
    public String underlyingCurrencyAsString()
    {
        return hasUnderlyingCurrency ? new String(underlyingCurrency, 0, underlyingCurrencyLength) : null;
    }

    /* UnderlyingCurrency = 318 */
    public AsciiSequenceView underlyingCurrency(final AsciiSequenceView view)
    {
        if (!hasUnderlyingCurrency)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingCurrency");
        }

        return view.wrap(buffer, underlyingCurrencyOffset, underlyingCurrencyLength);
    }


    private DecimalFloat underlyingQty = DecimalFloat.newNaNValue();

    private boolean hasUnderlyingQty;

    /* UnderlyingQty = 879 */
    public DecimalFloat underlyingQty()
    {
        if (!hasUnderlyingQty)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingQty");
        }

        return underlyingQty;
    }

    public boolean hasUnderlyingQty()
    {
        return hasUnderlyingQty;
    }



    private DecimalFloat underlyingPx = DecimalFloat.newNaNValue();

    private boolean hasUnderlyingPx;

    /* UnderlyingPx = 810 */
    public DecimalFloat underlyingPx()
    {
        if (!hasUnderlyingPx)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingPx");
        }

        return underlyingPx;
    }

    public boolean hasUnderlyingPx()
    {
        return hasUnderlyingPx;
    }



    private DecimalFloat underlyingDirtyPrice = DecimalFloat.newNaNValue();

    private boolean hasUnderlyingDirtyPrice;

    /* UnderlyingDirtyPrice = 882 */
    public DecimalFloat underlyingDirtyPrice()
    {
        if (!hasUnderlyingDirtyPrice)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingDirtyPrice");
        }

        return underlyingDirtyPrice;
    }

    public boolean hasUnderlyingDirtyPrice()
    {
        return hasUnderlyingDirtyPrice;
    }



    private DecimalFloat underlyingEndPrice = DecimalFloat.newNaNValue();

    private boolean hasUnderlyingEndPrice;

    /* UnderlyingEndPrice = 883 */
    public DecimalFloat underlyingEndPrice()
    {
        if (!hasUnderlyingEndPrice)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingEndPrice");
        }

        return underlyingEndPrice;
    }

    public boolean hasUnderlyingEndPrice()
    {
        return hasUnderlyingEndPrice;
    }



    private DecimalFloat underlyingStartValue = DecimalFloat.newNaNValue();

    private boolean hasUnderlyingStartValue;

    /* UnderlyingStartValue = 884 */
    public DecimalFloat underlyingStartValue()
    {
        if (!hasUnderlyingStartValue)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingStartValue");
        }

        return underlyingStartValue;
    }

    public boolean hasUnderlyingStartValue()
    {
        return hasUnderlyingStartValue;
    }



    private DecimalFloat underlyingCurrentValue = DecimalFloat.newNaNValue();

    private boolean hasUnderlyingCurrentValue;

    /* UnderlyingCurrentValue = 885 */
    public DecimalFloat underlyingCurrentValue()
    {
        if (!hasUnderlyingCurrentValue)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingCurrentValue");
        }

        return underlyingCurrentValue;
    }

    public boolean hasUnderlyingCurrentValue()
    {
        return hasUnderlyingCurrentValue;
    }



    private DecimalFloat underlyingEndValue = DecimalFloat.newNaNValue();

    private boolean hasUnderlyingEndValue;

    /* UnderlyingEndValue = 886 */
    public DecimalFloat underlyingEndValue()
    {
        if (!hasUnderlyingEndValue)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingEndValue");
        }

        return underlyingEndValue;
    }

    public boolean hasUnderlyingEndValue()
    {
        return hasUnderlyingEndValue;
    }





    private UnderlyingStipsGroupDecoder underlyingStipsGroup = null;
    public UnderlyingStipsGroupDecoder underlyingStipsGroup()
    {
        return underlyingStipsGroup;
    }

    private int noUnderlyingStipsGroupCounter = MISSING_INT;

    private boolean hasNoUnderlyingStipsGroupCounter;

    /* NoUnderlyingStipsGroupCounter = 887 */
    public int noUnderlyingStipsGroupCounter()
    {
        if (!hasNoUnderlyingStipsGroupCounter)
        {
            throw new IllegalArgumentException("No value for optional field: NoUnderlyingStipsGroupCounter");
        }

        return noUnderlyingStipsGroupCounter;
    }

    public boolean hasNoUnderlyingStipsGroupCounter()
    {
        return hasNoUnderlyingStipsGroupCounter;
    }




    private UnderlyingStipsGroupIterator underlyingStipsGroupIterator = new UnderlyingStipsGroupIterator(this);
    public UnderlyingStipsGroupIterator underlyingStipsGroupIterator()
    {
        return underlyingStipsGroupIterator.iterator();
    }



    public int decode(final AsciiBuffer buffer, final int offset, final int length)
    {
        // Decode UnderlyingsGroup
        int seenFieldCount = 0;
        if (CODEC_VALIDATION_ENABLED)
        {
            missingRequiredFields.copy(REQUIRED_FIELDS);
        }
        this.buffer = buffer;
        final int end = offset + length;
        int position = offset;
        seenFields.clear();
        int tag;

        while (position < end)
        {
            final int equalsPosition = buffer.scan(position, end, '=');
            if (equalsPosition == AsciiBuffer.UNKNOWN_INDEX)
            {
               return position;
            }
            tag = buffer.getInt(position, equalsPosition);
            if (!seenFields.add(tag))
            {
                if (next == null)
                {
                    next = new UnderlyingsGroupDecoder(trailer, messageFields);
                }
                return position - offset;
            }
            final int valueOffset = equalsPosition + 1;
            int endOfField = buffer.scan(valueOffset, end, START_OF_HEADER);
            if (endOfField == AsciiBuffer.UNKNOWN_INDEX || equalsPosition == AsciiBuffer.UNKNOWN_INDEX)
            {
                rejectReason = 5;
                break;
            }
            final int valueLength = endOfField - valueOffset;
            if (CODEC_VALIDATION_ENABLED)
            {
                if (tag <= 0)
                {
                    invalidTagId = tag;
                    rejectReason = 0;
                }
                else if (valueLength == 0)
                {
                    invalidTagId = tag;
                    rejectReason = 4;
                }
                missingRequiredFields.remove(tag);
                seenFieldCount++;
            }

            switch (tag)
            {
            case Constants.UNDERLYING_SYMBOL:
                underlyingSymbol = buffer.getChars(underlyingSymbol, valueOffset, valueLength);
                underlyingSymbolOffset = valueOffset;
                underlyingSymbolLength = valueLength;
                break;

            case Constants.UNDERLYING_SYMBOL_SFX:
                hasUnderlyingSymbolSfx = true;
                underlyingSymbolSfx = buffer.getChars(underlyingSymbolSfx, valueOffset, valueLength);
                underlyingSymbolSfxOffset = valueOffset;
                underlyingSymbolSfxLength = valueLength;
                break;

            case Constants.UNDERLYING_SECURITY_ID:
                hasUnderlyingSecurityID = true;
                underlyingSecurityID = buffer.getChars(underlyingSecurityID, valueOffset, valueLength);
                underlyingSecurityIDOffset = valueOffset;
                underlyingSecurityIDLength = valueLength;
                break;

            case Constants.UNDERLYING_SECURITY_ID_SOURCE:
                hasUnderlyingSecurityIDSource = true;
                underlyingSecurityIDSource = buffer.getChars(underlyingSecurityIDSource, valueOffset, valueLength);
                underlyingSecurityIDSourceOffset = valueOffset;
                underlyingSecurityIDSourceLength = valueLength;
                break;

            case Constants.NO_UNDERLYING_SECURITY_ALT_ID_GROUP_COUNTER:
                hasNoUnderlyingSecurityAltIDGroupCounter = true;
                noUnderlyingSecurityAltIDGroupCounter = getInt(buffer, valueOffset, endOfField, 457, CODEC_VALIDATION_ENABLED);
                if (underlyingSecurityAltIDGroup == null)
                {
                    underlyingSecurityAltIDGroup = new UnderlyingSecurityAltIDGroupDecoder(trailer, messageFields);
                }
                UnderlyingSecurityAltIDGroupDecoder underlyingSecurityAltIDGroupCurrent = underlyingSecurityAltIDGroup;
                position = endOfField + 1;
                final int noUnderlyingSecurityAltIDGroupCounter = this.noUnderlyingSecurityAltIDGroupCounter;
                for (int i = 0; i < noUnderlyingSecurityAltIDGroupCounter && position < end; i++)
                {
                    if (underlyingSecurityAltIDGroupCurrent != null)
                    {
                        position += underlyingSecurityAltIDGroupCurrent.decode(buffer, position, end - position);
                        underlyingSecurityAltIDGroupCurrent = underlyingSecurityAltIDGroupCurrent.next();
                    }
                }
                if (CODEC_VALIDATION_ENABLED)
                {
                    final int checkEqualsPosition = buffer.scan(position, end, '=');
                    if (checkEqualsPosition != AsciiBuffer.UNKNOWN_INDEX)
                    {
                        final int checkTag = buffer.getInt(position, checkEqualsPosition);
                        if (underlyingSecurityAltIDGroup.ALL_GROUP_FIELDS.contains(checkTag))
                        {
                            invalidTagId = tag;
                            rejectReason = 16;
                            return position;
                        }
                    }
                }
                break;

            case Constants.UNDERLYING_PRODUCT:
                hasUnderlyingProduct = true;
                underlyingProduct = getInt(buffer, valueOffset, endOfField, 462, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.UNDERLYING_C_F_I_CODE:
                hasUnderlyingCFICode = true;
                underlyingCFICode = buffer.getChars(underlyingCFICode, valueOffset, valueLength);
                underlyingCFICodeOffset = valueOffset;
                underlyingCFICodeLength = valueLength;
                break;

            case Constants.UNDERLYING_SECURITY_TYPE:
                hasUnderlyingSecurityType = true;
                underlyingSecurityType = buffer.getChars(underlyingSecurityType, valueOffset, valueLength);
                underlyingSecurityTypeOffset = valueOffset;
                underlyingSecurityTypeLength = valueLength;
                break;

            case Constants.UNDERLYING_SECURITY_SUB_TYPE:
                hasUnderlyingSecuritySubType = true;
                underlyingSecuritySubType = buffer.getChars(underlyingSecuritySubType, valueOffset, valueLength);
                underlyingSecuritySubTypeOffset = valueOffset;
                underlyingSecuritySubTypeLength = valueLength;
                break;

            case Constants.UNDERLYING_MATURITY_MONTH_YEAR:
                hasUnderlyingMaturityMonthYear = true;
                underlyingMaturityMonthYear = buffer.getBytes(underlyingMaturityMonthYear, valueOffset, valueLength);
                underlyingMaturityMonthYearOffset = valueOffset;
                underlyingMaturityMonthYearLength = valueLength;
                break;

            case Constants.UNDERLYING_MATURITY_DATE:
                hasUnderlyingMaturityDate = true;
                underlyingMaturityDate = buffer.getBytes(underlyingMaturityDate, valueOffset, valueLength);
                underlyingMaturityDateOffset = valueOffset;
                underlyingMaturityDateLength = valueLength;
                break;

            case Constants.UNDERLYING_COUPON_PAYMENT_DATE:
                hasUnderlyingCouponPaymentDate = true;
                underlyingCouponPaymentDate = buffer.getBytes(underlyingCouponPaymentDate, valueOffset, valueLength);
                underlyingCouponPaymentDateOffset = valueOffset;
                underlyingCouponPaymentDateLength = valueLength;
                break;

            case Constants.UNDERLYING_ISSUE_DATE:
                hasUnderlyingIssueDate = true;
                underlyingIssueDate = buffer.getBytes(underlyingIssueDate, valueOffset, valueLength);
                underlyingIssueDateOffset = valueOffset;
                underlyingIssueDateLength = valueLength;
                break;

            case Constants.UNDERLYING_REPO_COLLATERAL_SECURITY_TYPE:
                hasUnderlyingRepoCollateralSecurityType = true;
                underlyingRepoCollateralSecurityType = getInt(buffer, valueOffset, endOfField, 243, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.UNDERLYING_REPURCHASE_TERM:
                hasUnderlyingRepurchaseTerm = true;
                underlyingRepurchaseTerm = getInt(buffer, valueOffset, endOfField, 244, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.UNDERLYING_REPURCHASE_RATE:
                hasUnderlyingRepurchaseRate = true;
                underlyingRepurchaseRate = getFloat(buffer, underlyingRepurchaseRate, valueOffset, valueLength, 245, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.UNDERLYING_FACTOR:
                hasUnderlyingFactor = true;
                underlyingFactor = getFloat(buffer, underlyingFactor, valueOffset, valueLength, 246, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.UNDERLYING_CREDIT_RATING:
                hasUnderlyingCreditRating = true;
                underlyingCreditRating = buffer.getChars(underlyingCreditRating, valueOffset, valueLength);
                underlyingCreditRatingOffset = valueOffset;
                underlyingCreditRatingLength = valueLength;
                break;

            case Constants.UNDERLYING_INSTR_REGISTRY:
                hasUnderlyingInstrRegistry = true;
                underlyingInstrRegistry = buffer.getChars(underlyingInstrRegistry, valueOffset, valueLength);
                underlyingInstrRegistryOffset = valueOffset;
                underlyingInstrRegistryLength = valueLength;
                break;

            case Constants.UNDERLYING_COUNTRY_OF_ISSUE:
                hasUnderlyingCountryOfIssue = true;
                underlyingCountryOfIssue = buffer.getChars(underlyingCountryOfIssue, valueOffset, valueLength);
                underlyingCountryOfIssueOffset = valueOffset;
                underlyingCountryOfIssueLength = valueLength;
                break;

            case Constants.UNDERLYING_STATE_OR_PROVINCE_OF_ISSUE:
                hasUnderlyingStateOrProvinceOfIssue = true;
                underlyingStateOrProvinceOfIssue = buffer.getChars(underlyingStateOrProvinceOfIssue, valueOffset, valueLength);
                underlyingStateOrProvinceOfIssueOffset = valueOffset;
                underlyingStateOrProvinceOfIssueLength = valueLength;
                break;

            case Constants.UNDERLYING_LOCALE_OF_ISSUE:
                hasUnderlyingLocaleOfIssue = true;
                underlyingLocaleOfIssue = buffer.getChars(underlyingLocaleOfIssue, valueOffset, valueLength);
                underlyingLocaleOfIssueOffset = valueOffset;
                underlyingLocaleOfIssueLength = valueLength;
                break;

            case Constants.UNDERLYING_REDEMPTION_DATE:
                hasUnderlyingRedemptionDate = true;
                underlyingRedemptionDate = buffer.getBytes(underlyingRedemptionDate, valueOffset, valueLength);
                underlyingRedemptionDateOffset = valueOffset;
                underlyingRedemptionDateLength = valueLength;
                break;

            case Constants.UNDERLYING_STRIKE_PRICE:
                hasUnderlyingStrikePrice = true;
                underlyingStrikePrice = getFloat(buffer, underlyingStrikePrice, valueOffset, valueLength, 316, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.UNDERLYING_STRIKE_CURRENCY:
                hasUnderlyingStrikeCurrency = true;
                underlyingStrikeCurrency = buffer.getChars(underlyingStrikeCurrency, valueOffset, valueLength);
                underlyingStrikeCurrencyOffset = valueOffset;
                underlyingStrikeCurrencyLength = valueLength;
                break;

            case Constants.UNDERLYING_OPT_ATTRIBUTE:
                hasUnderlyingOptAttribute = true;
                underlyingOptAttribute = buffer.getChar(valueOffset);
                break;

            case Constants.UNDERLYING_CONTRACT_MULTIPLIER:
                hasUnderlyingContractMultiplier = true;
                underlyingContractMultiplier = getFloat(buffer, underlyingContractMultiplier, valueOffset, valueLength, 436, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.UNDERLYING_COUPON_RATE:
                hasUnderlyingCouponRate = true;
                underlyingCouponRate = getFloat(buffer, underlyingCouponRate, valueOffset, valueLength, 435, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.UNDERLYING_SECURITY_EXCHANGE:
                hasUnderlyingSecurityExchange = true;
                underlyingSecurityExchange = buffer.getChars(underlyingSecurityExchange, valueOffset, valueLength);
                underlyingSecurityExchangeOffset = valueOffset;
                underlyingSecurityExchangeLength = valueLength;
                break;

            case Constants.UNDERLYING_ISSUER:
                hasUnderlyingIssuer = true;
                underlyingIssuer = buffer.getChars(underlyingIssuer, valueOffset, valueLength);
                underlyingIssuerOffset = valueOffset;
                underlyingIssuerLength = valueLength;
                break;

            case Constants.ENCODED_UNDERLYING_ISSUER_LEN:
                hasEncodedUnderlyingIssuerLen = true;
                encodedUnderlyingIssuerLen = getInt(buffer, valueOffset, endOfField, 362, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.ENCODED_UNDERLYING_ISSUER:
                hasEncodedUnderlyingIssuer = true;
                encodedUnderlyingIssuer = buffer.getBytes(encodedUnderlyingIssuer, valueOffset, encodedUnderlyingIssuerLen);
                endOfField = valueOffset + encodedUnderlyingIssuerLen;
                break;

            case Constants.UNDERLYING_SECURITY_DESC:
                hasUnderlyingSecurityDesc = true;
                underlyingSecurityDesc = buffer.getChars(underlyingSecurityDesc, valueOffset, valueLength);
                underlyingSecurityDescOffset = valueOffset;
                underlyingSecurityDescLength = valueLength;
                break;

            case Constants.ENCODED_UNDERLYING_SECURITY_DESC_LEN:
                hasEncodedUnderlyingSecurityDescLen = true;
                encodedUnderlyingSecurityDescLen = getInt(buffer, valueOffset, endOfField, 364, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.ENCODED_UNDERLYING_SECURITY_DESC:
                hasEncodedUnderlyingSecurityDesc = true;
                encodedUnderlyingSecurityDesc = buffer.getBytes(encodedUnderlyingSecurityDesc, valueOffset, encodedUnderlyingSecurityDescLen);
                endOfField = valueOffset + encodedUnderlyingSecurityDescLen;
                break;

            case Constants.UNDERLYING_C_P_PROGRAM:
                hasUnderlyingCPProgram = true;
                underlyingCPProgram = buffer.getChars(underlyingCPProgram, valueOffset, valueLength);
                underlyingCPProgramOffset = valueOffset;
                underlyingCPProgramLength = valueLength;
                break;

            case Constants.UNDERLYING_C_P_REG_TYPE:
                hasUnderlyingCPRegType = true;
                underlyingCPRegType = buffer.getChars(underlyingCPRegType, valueOffset, valueLength);
                underlyingCPRegTypeOffset = valueOffset;
                underlyingCPRegTypeLength = valueLength;
                break;

            case Constants.UNDERLYING_CURRENCY:
                hasUnderlyingCurrency = true;
                underlyingCurrency = buffer.getChars(underlyingCurrency, valueOffset, valueLength);
                underlyingCurrencyOffset = valueOffset;
                underlyingCurrencyLength = valueLength;
                break;

            case Constants.UNDERLYING_QTY:
                hasUnderlyingQty = true;
                underlyingQty = getFloat(buffer, underlyingQty, valueOffset, valueLength, 879, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.UNDERLYING_PX:
                hasUnderlyingPx = true;
                underlyingPx = getFloat(buffer, underlyingPx, valueOffset, valueLength, 810, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.UNDERLYING_DIRTY_PRICE:
                hasUnderlyingDirtyPrice = true;
                underlyingDirtyPrice = getFloat(buffer, underlyingDirtyPrice, valueOffset, valueLength, 882, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.UNDERLYING_END_PRICE:
                hasUnderlyingEndPrice = true;
                underlyingEndPrice = getFloat(buffer, underlyingEndPrice, valueOffset, valueLength, 883, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.UNDERLYING_START_VALUE:
                hasUnderlyingStartValue = true;
                underlyingStartValue = getFloat(buffer, underlyingStartValue, valueOffset, valueLength, 884, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.UNDERLYING_CURRENT_VALUE:
                hasUnderlyingCurrentValue = true;
                underlyingCurrentValue = getFloat(buffer, underlyingCurrentValue, valueOffset, valueLength, 885, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.UNDERLYING_END_VALUE:
                hasUnderlyingEndValue = true;
                underlyingEndValue = getFloat(buffer, underlyingEndValue, valueOffset, valueLength, 886, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.NO_UNDERLYING_STIPS_GROUP_COUNTER:
                hasNoUnderlyingStipsGroupCounter = true;
                noUnderlyingStipsGroupCounter = getInt(buffer, valueOffset, endOfField, 887, CODEC_VALIDATION_ENABLED);
                if (underlyingStipsGroup == null)
                {
                    underlyingStipsGroup = new UnderlyingStipsGroupDecoder(trailer, messageFields);
                }
                UnderlyingStipsGroupDecoder underlyingStipsGroupCurrent = underlyingStipsGroup;
                position = endOfField + 1;
                final int noUnderlyingStipsGroupCounter = this.noUnderlyingStipsGroupCounter;
                for (int i = 0; i < noUnderlyingStipsGroupCounter && position < end; i++)
                {
                    if (underlyingStipsGroupCurrent != null)
                    {
                        position += underlyingStipsGroupCurrent.decode(buffer, position, end - position);
                        underlyingStipsGroupCurrent = underlyingStipsGroupCurrent.next();
                    }
                }
                if (CODEC_VALIDATION_ENABLED)
                {
                    final int checkEqualsPosition = buffer.scan(position, end, '=');
                    if (checkEqualsPosition != AsciiBuffer.UNKNOWN_INDEX)
                    {
                        final int checkTag = buffer.getInt(position, checkEqualsPosition);
                        if (underlyingStipsGroup.ALL_GROUP_FIELDS.contains(checkTag))
                        {
                            invalidTagId = tag;
                            rejectReason = 16;
                            return position;
                        }
                    }
                }
                break;



            default:
                if (!CODEC_REJECT_UNKNOWN_FIELD_ENABLED)
                {
                    seenFields.remove(tag);
                }
                if (CODEC_REJECT_UNKNOWN_FIELD_ENABLED || (trailer.REQUIRED_FIELDS.contains(tag) || messageFields.contains(tag)))
                {
                    return position - offset;
                }

            }

            if (position < (endOfField + 1))
            {
                position = endOfField + 1;
            }
        }
        return position - offset;
    }

    public void reset()
    {
        this.resetUnderlyingSymbol();
        this.resetUnderlyingSymbolSfx();
        this.resetUnderlyingSecurityID();
        this.resetUnderlyingSecurityIDSource();
        this.resetUnderlyingProduct();
        this.resetUnderlyingCFICode();
        this.resetUnderlyingSecurityType();
        this.resetUnderlyingSecuritySubType();
        this.resetUnderlyingMaturityMonthYear();
        this.resetUnderlyingMaturityDate();
        this.resetUnderlyingCouponPaymentDate();
        this.resetUnderlyingIssueDate();
        this.resetUnderlyingRepoCollateralSecurityType();
        this.resetUnderlyingRepurchaseTerm();
        this.resetUnderlyingRepurchaseRate();
        this.resetUnderlyingFactor();
        this.resetUnderlyingCreditRating();
        this.resetUnderlyingInstrRegistry();
        this.resetUnderlyingCountryOfIssue();
        this.resetUnderlyingStateOrProvinceOfIssue();
        this.resetUnderlyingLocaleOfIssue();
        this.resetUnderlyingRedemptionDate();
        this.resetUnderlyingStrikePrice();
        this.resetUnderlyingStrikeCurrency();
        this.resetUnderlyingOptAttribute();
        this.resetUnderlyingContractMultiplier();
        this.resetUnderlyingCouponRate();
        this.resetUnderlyingSecurityExchange();
        this.resetUnderlyingIssuer();
        this.resetEncodedUnderlyingIssuerLen();
        this.resetEncodedUnderlyingIssuer();
        this.resetUnderlyingSecurityDesc();
        this.resetEncodedUnderlyingSecurityDescLen();
        this.resetEncodedUnderlyingSecurityDesc();
        this.resetUnderlyingCPProgram();
        this.resetUnderlyingCPRegType();
        this.resetUnderlyingCurrency();
        this.resetUnderlyingQty();
        this.resetUnderlyingPx();
        this.resetUnderlyingDirtyPrice();
        this.resetUnderlyingEndPrice();
        this.resetUnderlyingStartValue();
        this.resetUnderlyingCurrentValue();
        this.resetUnderlyingEndValue();
        this.resetUnderlyingStipsGroup();
        this.resetUnderlyingSecurityAltIDGroup();
        buffer = null;
        if (CODEC_VALIDATION_ENABLED)
        {
            invalidTagId = Decoder.NO_ERROR;
            rejectReason = Decoder.NO_ERROR;
            missingRequiredFields.clear();
        }
    }

    public void resetUnderlyingSymbol()
    {
        underlyingSymbolOffset = 0;
        underlyingSymbolLength = 0;
    }

    public void resetUnderlyingSymbolSfx()
    {
        hasUnderlyingSymbolSfx = false;
    }

    public void resetUnderlyingSecurityID()
    {
        hasUnderlyingSecurityID = false;
    }

    public void resetUnderlyingSecurityIDSource()
    {
        hasUnderlyingSecurityIDSource = false;
    }

    public void resetUnderlyingProduct()
    {
        hasUnderlyingProduct = false;
    }

    public void resetUnderlyingCFICode()
    {
        hasUnderlyingCFICode = false;
    }

    public void resetUnderlyingSecurityType()
    {
        hasUnderlyingSecurityType = false;
    }

    public void resetUnderlyingSecuritySubType()
    {
        hasUnderlyingSecuritySubType = false;
    }

    public void resetUnderlyingMaturityMonthYear()
    {
        hasUnderlyingMaturityMonthYear = false;
    }

    public void resetUnderlyingMaturityDate()
    {
        hasUnderlyingMaturityDate = false;
    }

    public void resetUnderlyingCouponPaymentDate()
    {
        hasUnderlyingCouponPaymentDate = false;
    }

    public void resetUnderlyingIssueDate()
    {
        hasUnderlyingIssueDate = false;
    }

    public void resetUnderlyingRepoCollateralSecurityType()
    {
        hasUnderlyingRepoCollateralSecurityType = false;
    }

    public void resetUnderlyingRepurchaseTerm()
    {
        hasUnderlyingRepurchaseTerm = false;
    }

    public void resetUnderlyingRepurchaseRate()
    {
        hasUnderlyingRepurchaseRate = false;
    }

    public void resetUnderlyingFactor()
    {
        hasUnderlyingFactor = false;
    }

    public void resetUnderlyingCreditRating()
    {
        hasUnderlyingCreditRating = false;
    }

    public void resetUnderlyingInstrRegistry()
    {
        hasUnderlyingInstrRegistry = false;
    }

    public void resetUnderlyingCountryOfIssue()
    {
        hasUnderlyingCountryOfIssue = false;
    }

    public void resetUnderlyingStateOrProvinceOfIssue()
    {
        hasUnderlyingStateOrProvinceOfIssue = false;
    }

    public void resetUnderlyingLocaleOfIssue()
    {
        hasUnderlyingLocaleOfIssue = false;
    }

    public void resetUnderlyingRedemptionDate()
    {
        hasUnderlyingRedemptionDate = false;
    }

    public void resetUnderlyingStrikePrice()
    {
        hasUnderlyingStrikePrice = false;
    }

    public void resetUnderlyingStrikeCurrency()
    {
        hasUnderlyingStrikeCurrency = false;
    }

    public void resetUnderlyingOptAttribute()
    {
        hasUnderlyingOptAttribute = false;
    }

    public void resetUnderlyingContractMultiplier()
    {
        hasUnderlyingContractMultiplier = false;
    }

    public void resetUnderlyingCouponRate()
    {
        hasUnderlyingCouponRate = false;
    }

    public void resetUnderlyingSecurityExchange()
    {
        hasUnderlyingSecurityExchange = false;
    }

    public void resetUnderlyingIssuer()
    {
        hasUnderlyingIssuer = false;
    }

    public void resetEncodedUnderlyingIssuerLen()
    {
        hasEncodedUnderlyingIssuerLen = false;
    }

    public void resetEncodedUnderlyingIssuer()
    {
        hasEncodedUnderlyingIssuer = false;
    }

    public void resetUnderlyingSecurityDesc()
    {
        hasUnderlyingSecurityDesc = false;
    }

    public void resetEncodedUnderlyingSecurityDescLen()
    {
        hasEncodedUnderlyingSecurityDescLen = false;
    }

    public void resetEncodedUnderlyingSecurityDesc()
    {
        hasEncodedUnderlyingSecurityDesc = false;
    }

    public void resetUnderlyingCPProgram()
    {
        hasUnderlyingCPProgram = false;
    }

    public void resetUnderlyingCPRegType()
    {
        hasUnderlyingCPRegType = false;
    }

    public void resetUnderlyingCurrency()
    {
        hasUnderlyingCurrency = false;
    }

    public void resetUnderlyingQty()
    {
        hasUnderlyingQty = false;
    }

    public void resetUnderlyingPx()
    {
        hasUnderlyingPx = false;
    }

    public void resetUnderlyingDirtyPrice()
    {
        hasUnderlyingDirtyPrice = false;
    }

    public void resetUnderlyingEndPrice()
    {
        hasUnderlyingEndPrice = false;
    }

    public void resetUnderlyingStartValue()
    {
        hasUnderlyingStartValue = false;
    }

    public void resetUnderlyingCurrentValue()
    {
        hasUnderlyingCurrentValue = false;
    }

    public void resetUnderlyingEndValue()
    {
        hasUnderlyingEndValue = false;
    }

    public void resetUnderlyingStipsGroup()
    {
        for (final UnderlyingStipsGroupDecoder underlyingStipsGroupDecoder : underlyingStipsGroupIterator.iterator())
        {
            underlyingStipsGroupDecoder.reset();
            if (underlyingStipsGroupDecoder.next() == null)
            {
                break;
            }
        }
        noUnderlyingStipsGroupCounter = MISSING_INT;
        hasNoUnderlyingStipsGroupCounter = false;
    }

    public void resetUnderlyingSecurityAltIDGroup()
    {
        for (final UnderlyingSecurityAltIDGroupDecoder underlyingSecurityAltIDGroupDecoder : underlyingSecurityAltIDGroupIterator.iterator())
        {
            underlyingSecurityAltIDGroupDecoder.reset();
            if (underlyingSecurityAltIDGroupDecoder.next() == null)
            {
                break;
            }
        }
        noUnderlyingSecurityAltIDGroupCounter = MISSING_INT;
        hasNoUnderlyingSecurityAltIDGroupCounter = false;
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
        builder.append("\"MessageName\": \"UnderlyingsGroup\",\n");
        indent(builder, level);
        builder.append("\"UnderlyingSymbol\": \"");
        builder.append(this.underlyingSymbol(), 0, underlyingSymbolLength());
        builder.append("\",\n");

        if (hasUnderlyingSymbolSfx())
        {
            indent(builder, level);
            builder.append("\"UnderlyingSymbolSfx\": \"");
            builder.append(this.underlyingSymbolSfx(), 0, underlyingSymbolSfxLength());
            builder.append("\",\n");
        }

        if (hasUnderlyingSecurityID())
        {
            indent(builder, level);
            builder.append("\"UnderlyingSecurityID\": \"");
            builder.append(this.underlyingSecurityID(), 0, underlyingSecurityIDLength());
            builder.append("\",\n");
        }

        if (hasUnderlyingSecurityIDSource())
        {
            indent(builder, level);
            builder.append("\"UnderlyingSecurityIDSource\": \"");
            builder.append(this.underlyingSecurityIDSource(), 0, underlyingSecurityIDSourceLength());
            builder.append("\",\n");
        }

        if (hasNoUnderlyingSecurityAltIDGroupCounter)
        {
            indent(builder, level);
            builder.append("\"UnderlyingSecurityAltIDGroup\": [\n");
            UnderlyingSecurityAltIDGroupDecoder underlyingSecurityAltIDGroup = this.underlyingSecurityAltIDGroup;
            for (int i = 0, size = this.noUnderlyingSecurityAltIDGroupCounter; i < size; i++)
            {
                indent(builder, level);
                underlyingSecurityAltIDGroup.appendTo(builder, level + 1);
                if (underlyingSecurityAltIDGroup.next() != null)
                {
                    builder.append(',');
                }
                builder.append('\n');
                underlyingSecurityAltIDGroup = underlyingSecurityAltIDGroup.next();            }
            indent(builder, level);
            builder.append("],\n");
        }

        if (hasUnderlyingProduct())
        {
            indent(builder, level);
            builder.append("\"UnderlyingProduct\": \"");
            builder.append(underlyingProduct);
            builder.append("\",\n");
        }

        if (hasUnderlyingCFICode())
        {
            indent(builder, level);
            builder.append("\"UnderlyingCFICode\": \"");
            builder.append(this.underlyingCFICode(), 0, underlyingCFICodeLength());
            builder.append("\",\n");
        }

        if (hasUnderlyingSecurityType())
        {
            indent(builder, level);
            builder.append("\"UnderlyingSecurityType\": \"");
            builder.append(this.underlyingSecurityType(), 0, underlyingSecurityTypeLength());
            builder.append("\",\n");
        }

        if (hasUnderlyingSecuritySubType())
        {
            indent(builder, level);
            builder.append("\"UnderlyingSecuritySubType\": \"");
            builder.append(this.underlyingSecuritySubType(), 0, underlyingSecuritySubTypeLength());
            builder.append("\",\n");
        }

        if (hasUnderlyingMaturityMonthYear())
        {
            indent(builder, level);
            builder.append("\"UnderlyingMaturityMonthYear\": \"");
            appendData(builder, underlyingMaturityMonthYear, underlyingMaturityMonthYearLength);
            builder.append("\",\n");
        }

        if (hasUnderlyingMaturityDate())
        {
            indent(builder, level);
            builder.append("\"UnderlyingMaturityDate\": \"");
            appendData(builder, underlyingMaturityDate, underlyingMaturityDateLength);
            builder.append("\",\n");
        }

        if (hasUnderlyingCouponPaymentDate())
        {
            indent(builder, level);
            builder.append("\"UnderlyingCouponPaymentDate\": \"");
            appendData(builder, underlyingCouponPaymentDate, underlyingCouponPaymentDateLength);
            builder.append("\",\n");
        }

        if (hasUnderlyingIssueDate())
        {
            indent(builder, level);
            builder.append("\"UnderlyingIssueDate\": \"");
            appendData(builder, underlyingIssueDate, underlyingIssueDateLength);
            builder.append("\",\n");
        }

        if (hasUnderlyingRepoCollateralSecurityType())
        {
            indent(builder, level);
            builder.append("\"UnderlyingRepoCollateralSecurityType\": \"");
            builder.append(underlyingRepoCollateralSecurityType);
            builder.append("\",\n");
        }

        if (hasUnderlyingRepurchaseTerm())
        {
            indent(builder, level);
            builder.append("\"UnderlyingRepurchaseTerm\": \"");
            builder.append(underlyingRepurchaseTerm);
            builder.append("\",\n");
        }

        if (hasUnderlyingRepurchaseRate())
        {
            indent(builder, level);
            builder.append("\"UnderlyingRepurchaseRate\": \"");
            underlyingRepurchaseRate.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasUnderlyingFactor())
        {
            indent(builder, level);
            builder.append("\"UnderlyingFactor\": \"");
            underlyingFactor.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasUnderlyingCreditRating())
        {
            indent(builder, level);
            builder.append("\"UnderlyingCreditRating\": \"");
            builder.append(this.underlyingCreditRating(), 0, underlyingCreditRatingLength());
            builder.append("\",\n");
        }

        if (hasUnderlyingInstrRegistry())
        {
            indent(builder, level);
            builder.append("\"UnderlyingInstrRegistry\": \"");
            builder.append(this.underlyingInstrRegistry(), 0, underlyingInstrRegistryLength());
            builder.append("\",\n");
        }

        if (hasUnderlyingCountryOfIssue())
        {
            indent(builder, level);
            builder.append("\"UnderlyingCountryOfIssue\": \"");
            builder.append(this.underlyingCountryOfIssue(), 0, underlyingCountryOfIssueLength());
            builder.append("\",\n");
        }

        if (hasUnderlyingStateOrProvinceOfIssue())
        {
            indent(builder, level);
            builder.append("\"UnderlyingStateOrProvinceOfIssue\": \"");
            builder.append(this.underlyingStateOrProvinceOfIssue(), 0, underlyingStateOrProvinceOfIssueLength());
            builder.append("\",\n");
        }

        if (hasUnderlyingLocaleOfIssue())
        {
            indent(builder, level);
            builder.append("\"UnderlyingLocaleOfIssue\": \"");
            builder.append(this.underlyingLocaleOfIssue(), 0, underlyingLocaleOfIssueLength());
            builder.append("\",\n");
        }

        if (hasUnderlyingRedemptionDate())
        {
            indent(builder, level);
            builder.append("\"UnderlyingRedemptionDate\": \"");
            appendData(builder, underlyingRedemptionDate, underlyingRedemptionDateLength);
            builder.append("\",\n");
        }

        if (hasUnderlyingStrikePrice())
        {
            indent(builder, level);
            builder.append("\"UnderlyingStrikePrice\": \"");
            underlyingStrikePrice.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasUnderlyingStrikeCurrency())
        {
            indent(builder, level);
            builder.append("\"UnderlyingStrikeCurrency\": \"");
            builder.append(this.underlyingStrikeCurrency(), 0, underlyingStrikeCurrencyLength());
            builder.append("\",\n");
        }

        if (hasUnderlyingOptAttribute())
        {
            indent(builder, level);
            builder.append("\"UnderlyingOptAttribute\": \"");
            builder.append(underlyingOptAttribute);
            builder.append("\",\n");
        }

        if (hasUnderlyingContractMultiplier())
        {
            indent(builder, level);
            builder.append("\"UnderlyingContractMultiplier\": \"");
            underlyingContractMultiplier.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasUnderlyingCouponRate())
        {
            indent(builder, level);
            builder.append("\"UnderlyingCouponRate\": \"");
            underlyingCouponRate.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasUnderlyingSecurityExchange())
        {
            indent(builder, level);
            builder.append("\"UnderlyingSecurityExchange\": \"");
            builder.append(this.underlyingSecurityExchange(), 0, underlyingSecurityExchangeLength());
            builder.append("\",\n");
        }

        if (hasUnderlyingIssuer())
        {
            indent(builder, level);
            builder.append("\"UnderlyingIssuer\": \"");
            builder.append(this.underlyingIssuer(), 0, underlyingIssuerLength());
            builder.append("\",\n");
        }

        if (hasEncodedUnderlyingIssuerLen())
        {
            indent(builder, level);
            builder.append("\"EncodedUnderlyingIssuerLen\": \"");
            builder.append(encodedUnderlyingIssuerLen);
            builder.append("\",\n");
        }

        if (hasEncodedUnderlyingIssuer())
        {
            indent(builder, level);
            builder.append("\"EncodedUnderlyingIssuer\": \"");
            appendData(builder, encodedUnderlyingIssuer, encodedUnderlyingIssuerLen);
            builder.append("\",\n");
        }

        if (hasUnderlyingSecurityDesc())
        {
            indent(builder, level);
            builder.append("\"UnderlyingSecurityDesc\": \"");
            builder.append(this.underlyingSecurityDesc(), 0, underlyingSecurityDescLength());
            builder.append("\",\n");
        }

        if (hasEncodedUnderlyingSecurityDescLen())
        {
            indent(builder, level);
            builder.append("\"EncodedUnderlyingSecurityDescLen\": \"");
            builder.append(encodedUnderlyingSecurityDescLen);
            builder.append("\",\n");
        }

        if (hasEncodedUnderlyingSecurityDesc())
        {
            indent(builder, level);
            builder.append("\"EncodedUnderlyingSecurityDesc\": \"");
            appendData(builder, encodedUnderlyingSecurityDesc, encodedUnderlyingSecurityDescLen);
            builder.append("\",\n");
        }

        if (hasUnderlyingCPProgram())
        {
            indent(builder, level);
            builder.append("\"UnderlyingCPProgram\": \"");
            builder.append(this.underlyingCPProgram(), 0, underlyingCPProgramLength());
            builder.append("\",\n");
        }

        if (hasUnderlyingCPRegType())
        {
            indent(builder, level);
            builder.append("\"UnderlyingCPRegType\": \"");
            builder.append(this.underlyingCPRegType(), 0, underlyingCPRegTypeLength());
            builder.append("\",\n");
        }

        if (hasUnderlyingCurrency())
        {
            indent(builder, level);
            builder.append("\"UnderlyingCurrency\": \"");
            builder.append(this.underlyingCurrency(), 0, underlyingCurrencyLength());
            builder.append("\",\n");
        }

        if (hasUnderlyingQty())
        {
            indent(builder, level);
            builder.append("\"UnderlyingQty\": \"");
            underlyingQty.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasUnderlyingPx())
        {
            indent(builder, level);
            builder.append("\"UnderlyingPx\": \"");
            underlyingPx.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasUnderlyingDirtyPrice())
        {
            indent(builder, level);
            builder.append("\"UnderlyingDirtyPrice\": \"");
            underlyingDirtyPrice.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasUnderlyingEndPrice())
        {
            indent(builder, level);
            builder.append("\"UnderlyingEndPrice\": \"");
            underlyingEndPrice.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasUnderlyingStartValue())
        {
            indent(builder, level);
            builder.append("\"UnderlyingStartValue\": \"");
            underlyingStartValue.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasUnderlyingCurrentValue())
        {
            indent(builder, level);
            builder.append("\"UnderlyingCurrentValue\": \"");
            underlyingCurrentValue.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasUnderlyingEndValue())
        {
            indent(builder, level);
            builder.append("\"UnderlyingEndValue\": \"");
            underlyingEndValue.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasNoUnderlyingStipsGroupCounter)
        {
            indent(builder, level);
            builder.append("\"UnderlyingStipsGroup\": [\n");
            UnderlyingStipsGroupDecoder underlyingStipsGroup = this.underlyingStipsGroup;
            for (int i = 0, size = this.noUnderlyingStipsGroupCounter; i < size; i++)
            {
                indent(builder, level);
                underlyingStipsGroup.appendTo(builder, level + 1);
                if (underlyingStipsGroup.next() != null)
                {
                    builder.append(',');
                }
                builder.append('\n');
                underlyingStipsGroup = underlyingStipsGroup.next();            }
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
    public OrdersGroupEncoder.UnderlyingsGroupEncoder toEncoder(final Encoder encoder)
    {
        return toEncoder((OrdersGroupEncoder.UnderlyingsGroupEncoder)encoder);
    }

    public OrdersGroupEncoder.UnderlyingsGroupEncoder toEncoder(final OrdersGroupEncoder.UnderlyingsGroupEncoder encoder)
    {
        encoder.reset();

        final UnderlyingInstrumentEncoder underlyingInstrument = encoder.underlyingInstrument();        underlyingInstrument.underlyingSymbol(this.underlyingSymbol(), 0, underlyingSymbolLength());
        if (hasUnderlyingSymbolSfx())
        {
            underlyingInstrument.underlyingSymbolSfx(this.underlyingSymbolSfx(), 0, underlyingSymbolSfxLength());
        }

        if (hasUnderlyingSecurityID())
        {
            underlyingInstrument.underlyingSecurityID(this.underlyingSecurityID(), 0, underlyingSecurityIDLength());
        }

        if (hasUnderlyingSecurityIDSource())
        {
            underlyingInstrument.underlyingSecurityIDSource(this.underlyingSecurityIDSource(), 0, underlyingSecurityIDSourceLength());
        }

        if (hasNoUnderlyingSecurityAltIDGroupCounter)
        {
            final int size = this.noUnderlyingSecurityAltIDGroupCounter;
            UnderlyingSecurityAltIDGroupDecoder underlyingSecurityAltIDGroup = this.underlyingSecurityAltIDGroup;
            UnderlyingSecurityAltIDGroupEncoder underlyingSecurityAltIDGroupEncoder = underlyingInstrument.underlyingSecurityAltIDGroup(size);
            for (int i = 0; i < size; i++)
            {
                if (underlyingSecurityAltIDGroup != null)
                {
                    underlyingSecurityAltIDGroup.toEncoder(underlyingSecurityAltIDGroupEncoder);
                    underlyingSecurityAltIDGroup = underlyingSecurityAltIDGroup.next();
                    underlyingSecurityAltIDGroupEncoder = underlyingSecurityAltIDGroupEncoder.next();
                }
            }
        }

        if (hasUnderlyingProduct())
        {
            underlyingInstrument.underlyingProduct(this.underlyingProduct());
        }

        if (hasUnderlyingCFICode())
        {
            underlyingInstrument.underlyingCFICode(this.underlyingCFICode(), 0, underlyingCFICodeLength());
        }

        if (hasUnderlyingSecurityType())
        {
            underlyingInstrument.underlyingSecurityType(this.underlyingSecurityType(), 0, underlyingSecurityTypeLength());
        }

        if (hasUnderlyingSecuritySubType())
        {
            underlyingInstrument.underlyingSecuritySubType(this.underlyingSecuritySubType(), 0, underlyingSecuritySubTypeLength());
        }

        if (hasUnderlyingMaturityMonthYear())
        {
            underlyingInstrument.underlyingMaturityMonthYearAsCopy(this.underlyingMaturityMonthYear(), 0, underlyingMaturityMonthYearLength());
        }

        if (hasUnderlyingMaturityDate())
        {
            underlyingInstrument.underlyingMaturityDateAsCopy(this.underlyingMaturityDate(), 0, underlyingMaturityDateLength());
        }

        if (hasUnderlyingCouponPaymentDate())
        {
            underlyingInstrument.underlyingCouponPaymentDateAsCopy(this.underlyingCouponPaymentDate(), 0, underlyingCouponPaymentDateLength());
        }

        if (hasUnderlyingIssueDate())
        {
            underlyingInstrument.underlyingIssueDateAsCopy(this.underlyingIssueDate(), 0, underlyingIssueDateLength());
        }

        if (hasUnderlyingRepoCollateralSecurityType())
        {
            underlyingInstrument.underlyingRepoCollateralSecurityType(this.underlyingRepoCollateralSecurityType());
        }

        if (hasUnderlyingRepurchaseTerm())
        {
            underlyingInstrument.underlyingRepurchaseTerm(this.underlyingRepurchaseTerm());
        }

        if (hasUnderlyingRepurchaseRate())
        {
            underlyingInstrument.underlyingRepurchaseRate(this.underlyingRepurchaseRate());
        }

        if (hasUnderlyingFactor())
        {
            underlyingInstrument.underlyingFactor(this.underlyingFactor());
        }

        if (hasUnderlyingCreditRating())
        {
            underlyingInstrument.underlyingCreditRating(this.underlyingCreditRating(), 0, underlyingCreditRatingLength());
        }

        if (hasUnderlyingInstrRegistry())
        {
            underlyingInstrument.underlyingInstrRegistry(this.underlyingInstrRegistry(), 0, underlyingInstrRegistryLength());
        }

        if (hasUnderlyingCountryOfIssue())
        {
            underlyingInstrument.underlyingCountryOfIssue(this.underlyingCountryOfIssue(), 0, underlyingCountryOfIssueLength());
        }

        if (hasUnderlyingStateOrProvinceOfIssue())
        {
            underlyingInstrument.underlyingStateOrProvinceOfIssue(this.underlyingStateOrProvinceOfIssue(), 0, underlyingStateOrProvinceOfIssueLength());
        }

        if (hasUnderlyingLocaleOfIssue())
        {
            underlyingInstrument.underlyingLocaleOfIssue(this.underlyingLocaleOfIssue(), 0, underlyingLocaleOfIssueLength());
        }

        if (hasUnderlyingRedemptionDate())
        {
            underlyingInstrument.underlyingRedemptionDateAsCopy(this.underlyingRedemptionDate(), 0, underlyingRedemptionDateLength());
        }

        if (hasUnderlyingStrikePrice())
        {
            underlyingInstrument.underlyingStrikePrice(this.underlyingStrikePrice());
        }

        if (hasUnderlyingStrikeCurrency())
        {
            underlyingInstrument.underlyingStrikeCurrency(this.underlyingStrikeCurrency(), 0, underlyingStrikeCurrencyLength());
        }

        if (hasUnderlyingOptAttribute())
        {
            underlyingInstrument.underlyingOptAttribute(this.underlyingOptAttribute());
        }

        if (hasUnderlyingContractMultiplier())
        {
            underlyingInstrument.underlyingContractMultiplier(this.underlyingContractMultiplier());
        }

        if (hasUnderlyingCouponRate())
        {
            underlyingInstrument.underlyingCouponRate(this.underlyingCouponRate());
        }

        if (hasUnderlyingSecurityExchange())
        {
            underlyingInstrument.underlyingSecurityExchange(this.underlyingSecurityExchange(), 0, underlyingSecurityExchangeLength());
        }

        if (hasUnderlyingIssuer())
        {
            underlyingInstrument.underlyingIssuer(this.underlyingIssuer(), 0, underlyingIssuerLength());
        }

        if (hasEncodedUnderlyingIssuerLen())
        {
            underlyingInstrument.encodedUnderlyingIssuerLen(this.encodedUnderlyingIssuerLen());
        }

        if (hasEncodedUnderlyingIssuer())
        {
            underlyingInstrument.encodedUnderlyingIssuerAsCopy(this.encodedUnderlyingIssuer(), 0, encodedUnderlyingIssuerLen());
            underlyingInstrument.encodedUnderlyingIssuerLen(this.encodedUnderlyingIssuerLen());
        }

        if (hasUnderlyingSecurityDesc())
        {
            underlyingInstrument.underlyingSecurityDesc(this.underlyingSecurityDesc(), 0, underlyingSecurityDescLength());
        }

        if (hasEncodedUnderlyingSecurityDescLen())
        {
            underlyingInstrument.encodedUnderlyingSecurityDescLen(this.encodedUnderlyingSecurityDescLen());
        }

        if (hasEncodedUnderlyingSecurityDesc())
        {
            underlyingInstrument.encodedUnderlyingSecurityDescAsCopy(this.encodedUnderlyingSecurityDesc(), 0, encodedUnderlyingSecurityDescLen());
            underlyingInstrument.encodedUnderlyingSecurityDescLen(this.encodedUnderlyingSecurityDescLen());
        }

        if (hasUnderlyingCPProgram())
        {
            underlyingInstrument.underlyingCPProgram(this.underlyingCPProgram(), 0, underlyingCPProgramLength());
        }

        if (hasUnderlyingCPRegType())
        {
            underlyingInstrument.underlyingCPRegType(this.underlyingCPRegType(), 0, underlyingCPRegTypeLength());
        }

        if (hasUnderlyingCurrency())
        {
            underlyingInstrument.underlyingCurrency(this.underlyingCurrency(), 0, underlyingCurrencyLength());
        }

        if (hasUnderlyingQty())
        {
            underlyingInstrument.underlyingQty(this.underlyingQty());
        }

        if (hasUnderlyingPx())
        {
            underlyingInstrument.underlyingPx(this.underlyingPx());
        }

        if (hasUnderlyingDirtyPrice())
        {
            underlyingInstrument.underlyingDirtyPrice(this.underlyingDirtyPrice());
        }

        if (hasUnderlyingEndPrice())
        {
            underlyingInstrument.underlyingEndPrice(this.underlyingEndPrice());
        }

        if (hasUnderlyingStartValue())
        {
            underlyingInstrument.underlyingStartValue(this.underlyingStartValue());
        }

        if (hasUnderlyingCurrentValue())
        {
            underlyingInstrument.underlyingCurrentValue(this.underlyingCurrentValue());
        }

        if (hasUnderlyingEndValue())
        {
            underlyingInstrument.underlyingEndValue(this.underlyingEndValue());
        }


        final UnderlyingStipulationsEncoder underlyingStipulations = underlyingInstrument.underlyingStipulations();        if (hasNoUnderlyingStipsGroupCounter)
        {
            final int size = this.noUnderlyingStipsGroupCounter;
            UnderlyingStipsGroupDecoder underlyingStipsGroup = this.underlyingStipsGroup;
            UnderlyingStipsGroupEncoder underlyingStipsGroupEncoder = underlyingStipulations.underlyingStipsGroup(size);
            for (int i = 0; i < size; i++)
            {
                if (underlyingStipsGroup != null)
                {
                    underlyingStipsGroup.toEncoder(underlyingStipsGroupEncoder);
                    underlyingStipsGroup = underlyingStipsGroup.next();
                    underlyingStipsGroupEncoder = underlyingStipsGroupEncoder.next();
                }
            }
        }


        return encoder;
    }

}
    @Generated("uk.co.real_logic.artio")
    public class UnderlyingsGroupIterator implements Iterable<UnderlyingsGroupDecoder>, java.util.Iterator<UnderlyingsGroupDecoder>
    {
        private final OrdersGroupDecoder parent;
        private int remainder;
        private UnderlyingsGroupDecoder current;

        public UnderlyingsGroupIterator(final OrdersGroupDecoder parent)
        {
            this.parent = parent;
        }

        public boolean hasNext()
        {
            return remainder > 0 && current != null;
        }

        public UnderlyingsGroupDecoder next()
        {
            remainder--;
            final UnderlyingsGroupDecoder value = current;
            current = current.next();
            return value;
        }

        public int numberFieldValue()
        {
            return parent.hasNoUnderlyingsGroupCounter() ? parent.noUnderlyingsGroupCounter() : 0;
        }

        public void reset()
        {
            remainder = numberFieldValue();
            current = parent.underlyingsGroup();
        }

        public UnderlyingsGroupIterator iterator()
        {
            reset();
            return this;
        }

    }


    private UnderlyingsGroupDecoder underlyingsGroup = null;
    public UnderlyingsGroupDecoder underlyingsGroup()
    {
        return underlyingsGroup;
    }

    private int noUnderlyingsGroupCounter = MISSING_INT;

    private boolean hasNoUnderlyingsGroupCounter;

    /* NoUnderlyingsGroupCounter = 711 */
    public int noUnderlyingsGroupCounter()
    {
        if (!hasNoUnderlyingsGroupCounter)
        {
            throw new IllegalArgumentException("No value for optional field: NoUnderlyingsGroupCounter");
        }

        return noUnderlyingsGroupCounter;
    }

    public boolean hasNoUnderlyingsGroupCounter()
    {
        return hasNoUnderlyingsGroupCounter;
    }




    private UnderlyingsGroupIterator underlyingsGroupIterator = new UnderlyingsGroupIterator(this);
    public UnderlyingsGroupIterator underlyingsGroupIterator()
    {
        return underlyingsGroupIterator.iterator();
    }

    private DecimalFloat prevClosePx = DecimalFloat.newNaNValue();

    private boolean hasPrevClosePx;

    /* PrevClosePx = 140 */
    public DecimalFloat prevClosePx()
    {
        if (!hasPrevClosePx)
        {
            throw new IllegalArgumentException("No value for optional field: PrevClosePx");
        }

        return prevClosePx;
    }

    public boolean hasPrevClosePx()
    {
        return hasPrevClosePx;
    }



    private char side = MISSING_CHAR;

    /* Side = 54 */
    public char side()
    {
        return side;
    }



    private final CharArrayWrapper sideWrapper = new CharArrayWrapper();
    /* Side = 54 */
    public Side sideAsEnum()
    {
        return Side.decode(side);
    }

    private int sideValueInd = MISSING_INT;

    private boolean hasSideValueInd;

    /* SideValueInd = 401 */
    public int sideValueInd()
    {
        if (!hasSideValueInd)
        {
            throw new IllegalArgumentException("No value for optional field: SideValueInd");
        }

        return sideValueInd;
    }

    public boolean hasSideValueInd()
    {
        return hasSideValueInd;
    }



    private final CharArrayWrapper sideValueIndWrapper = new CharArrayWrapper();
    /* SideValueInd = 401 */
    public SideValueInd sideValueIndAsEnum()
    {
        if (!hasSideValueInd)
 return SideValueInd.NULL_VAL;
        return SideValueInd.decode(sideValueInd);
    }

    private boolean locateReqd;

    private boolean hasLocateReqd;

    /* LocateReqd = 114 */
    public boolean locateReqd()
    {
        if (!hasLocateReqd)
        {
            throw new IllegalArgumentException("No value for optional field: LocateReqd");
        }

        return locateReqd;
    }

    public boolean hasLocateReqd()
    {
        return hasLocateReqd;
    }



    private byte[] transactTime = new byte[24];

    private boolean hasTransactTime;

    /* TransactTime = 60 */
    public byte[] transactTime()
    {
        if (!hasTransactTime)
        {
            throw new IllegalArgumentException("No value for optional field: TransactTime");
        }

        return transactTime;
    }

    public boolean hasTransactTime()
    {
        return hasTransactTime;
    }


    private int transactTimeOffset;

    private int transactTimeLength;

    /* TransactTime = 60 */
    public int transactTimeLength()
    {
        if (!hasTransactTime)
        {
            throw new IllegalArgumentException("No value for optional field: TransactTime");
        }

        return transactTimeLength;
    }

    /* TransactTime = 60 */
    public String transactTimeAsString()
    {
        return hasTransactTime ? new String(transactTime, 0, transactTimeLength) : null;
    }

    /* TransactTime = 60 */
    public AsciiSequenceView transactTime(final AsciiSequenceView view)
    {
        if (!hasTransactTime)
        {
            throw new IllegalArgumentException("No value for optional field: TransactTime");
        }

        return view.wrap(buffer, transactTimeOffset, transactTimeLength);
    }




    private StipulationsGroupDecoder stipulationsGroup = null;
    public StipulationsGroupDecoder stipulationsGroup()
    {
        return stipulationsGroup;
    }

    private int noStipulationsGroupCounter = MISSING_INT;

    private boolean hasNoStipulationsGroupCounter;

    /* NoStipulationsGroupCounter = 232 */
    public int noStipulationsGroupCounter()
    {
        if (!hasNoStipulationsGroupCounter)
        {
            throw new IllegalArgumentException("No value for optional field: NoStipulationsGroupCounter");
        }

        return noStipulationsGroupCounter;
    }

    public boolean hasNoStipulationsGroupCounter()
    {
        return hasNoStipulationsGroupCounter;
    }




    private StipulationsGroupIterator stipulationsGroupIterator = new StipulationsGroupIterator(this);
    public StipulationsGroupIterator stipulationsGroupIterator()
    {
        return stipulationsGroupIterator.iterator();
    }


    private int qtyType = MISSING_INT;

    private boolean hasQtyType;

    /* QtyType = 854 */
    public int qtyType()
    {
        if (!hasQtyType)
        {
            throw new IllegalArgumentException("No value for optional field: QtyType");
        }

        return qtyType;
    }

    public boolean hasQtyType()
    {
        return hasQtyType;
    }



    private final CharArrayWrapper qtyTypeWrapper = new CharArrayWrapper();
    /* QtyType = 854 */
    public QtyType qtyTypeAsEnum()
    {
        if (!hasQtyType)
 return QtyType.NULL_VAL;
        return QtyType.decode(qtyType);
    }


    private DecimalFloat orderQty = DecimalFloat.newNaNValue();

    private boolean hasOrderQty;

    /* OrderQty = 38 */
    public DecimalFloat orderQty()
    {
        if (!hasOrderQty)
        {
            throw new IllegalArgumentException("No value for optional field: OrderQty");
        }

        return orderQty;
    }

    public boolean hasOrderQty()
    {
        return hasOrderQty;
    }



    private DecimalFloat cashOrderQty = DecimalFloat.newNaNValue();

    private boolean hasCashOrderQty;

    /* CashOrderQty = 152 */
    public DecimalFloat cashOrderQty()
    {
        if (!hasCashOrderQty)
        {
            throw new IllegalArgumentException("No value for optional field: CashOrderQty");
        }

        return cashOrderQty;
    }

    public boolean hasCashOrderQty()
    {
        return hasCashOrderQty;
    }



    private DecimalFloat orderPercent = DecimalFloat.newNaNValue();

    private boolean hasOrderPercent;

    /* OrderPercent = 516 */
    public DecimalFloat orderPercent()
    {
        if (!hasOrderPercent)
        {
            throw new IllegalArgumentException("No value for optional field: OrderPercent");
        }

        return orderPercent;
    }

    public boolean hasOrderPercent()
    {
        return hasOrderPercent;
    }



    private char roundingDirection = MISSING_CHAR;

    private boolean hasRoundingDirection;

    /* RoundingDirection = 468 */
    public char roundingDirection()
    {
        if (!hasRoundingDirection)
        {
            throw new IllegalArgumentException("No value for optional field: RoundingDirection");
        }

        return roundingDirection;
    }

    public boolean hasRoundingDirection()
    {
        return hasRoundingDirection;
    }



    private final CharArrayWrapper roundingDirectionWrapper = new CharArrayWrapper();
    /* RoundingDirection = 468 */
    public RoundingDirection roundingDirectionAsEnum()
    {
        if (!hasRoundingDirection)
 return RoundingDirection.NULL_VAL;
        return RoundingDirection.decode(roundingDirection);
    }

    private DecimalFloat roundingModulus = DecimalFloat.newNaNValue();

    private boolean hasRoundingModulus;

    /* RoundingModulus = 469 */
    public DecimalFloat roundingModulus()
    {
        if (!hasRoundingModulus)
        {
            throw new IllegalArgumentException("No value for optional field: RoundingModulus");
        }

        return roundingModulus;
    }

    public boolean hasRoundingModulus()
    {
        return hasRoundingModulus;
    }




    private char ordType = MISSING_CHAR;

    private boolean hasOrdType;

    /* OrdType = 40 */
    public char ordType()
    {
        if (!hasOrdType)
        {
            throw new IllegalArgumentException("No value for optional field: OrdType");
        }

        return ordType;
    }

    public boolean hasOrdType()
    {
        return hasOrdType;
    }



    private final CharArrayWrapper ordTypeWrapper = new CharArrayWrapper();
    /* OrdType = 40 */
    public OrdType ordTypeAsEnum()
    {
        if (!hasOrdType)
 return OrdType.NULL_VAL;
        return OrdType.decode(ordType);
    }

    private int priceType = MISSING_INT;

    private boolean hasPriceType;

    /* PriceType = 423 */
    public int priceType()
    {
        if (!hasPriceType)
        {
            throw new IllegalArgumentException("No value for optional field: PriceType");
        }

        return priceType;
    }

    public boolean hasPriceType()
    {
        return hasPriceType;
    }



    private final CharArrayWrapper priceTypeWrapper = new CharArrayWrapper();
    /* PriceType = 423 */
    public PriceType priceTypeAsEnum()
    {
        if (!hasPriceType)
 return PriceType.NULL_VAL;
        return PriceType.decode(priceType);
    }

    private DecimalFloat price = DecimalFloat.newNaNValue();

    private boolean hasPrice;

    /* Price = 44 */
    public DecimalFloat price()
    {
        if (!hasPrice)
        {
            throw new IllegalArgumentException("No value for optional field: Price");
        }

        return price;
    }

    public boolean hasPrice()
    {
        return hasPrice;
    }



    private DecimalFloat stopPx = DecimalFloat.newNaNValue();

    private boolean hasStopPx;

    /* StopPx = 99 */
    public DecimalFloat stopPx()
    {
        if (!hasStopPx)
        {
            throw new IllegalArgumentException("No value for optional field: StopPx");
        }

        return stopPx;
    }

    public boolean hasStopPx()
    {
        return hasStopPx;
    }




    private DecimalFloat spread = DecimalFloat.newNaNValue();

    private boolean hasSpread;

    /* Spread = 218 */
    public DecimalFloat spread()
    {
        if (!hasSpread)
        {
            throw new IllegalArgumentException("No value for optional field: Spread");
        }

        return spread;
    }

    public boolean hasSpread()
    {
        return hasSpread;
    }



    private char[] benchmarkCurveCurrency = new char[1];

    private boolean hasBenchmarkCurveCurrency;

    /* BenchmarkCurveCurrency = 220 */
    public char[] benchmarkCurveCurrency()
    {
        if (!hasBenchmarkCurveCurrency)
        {
            throw new IllegalArgumentException("No value for optional field: BenchmarkCurveCurrency");
        }

        return benchmarkCurveCurrency;
    }

    public boolean hasBenchmarkCurveCurrency()
    {
        return hasBenchmarkCurveCurrency;
    }


    private int benchmarkCurveCurrencyOffset;

    private int benchmarkCurveCurrencyLength;

    /* BenchmarkCurveCurrency = 220 */
    public int benchmarkCurveCurrencyLength()
    {
        if (!hasBenchmarkCurveCurrency)
        {
            throw new IllegalArgumentException("No value for optional field: BenchmarkCurveCurrency");
        }

        return benchmarkCurveCurrencyLength;
    }

    /* BenchmarkCurveCurrency = 220 */
    public String benchmarkCurveCurrencyAsString()
    {
        return hasBenchmarkCurveCurrency ? new String(benchmarkCurveCurrency, 0, benchmarkCurveCurrencyLength) : null;
    }

    /* BenchmarkCurveCurrency = 220 */
    public AsciiSequenceView benchmarkCurveCurrency(final AsciiSequenceView view)
    {
        if (!hasBenchmarkCurveCurrency)
        {
            throw new IllegalArgumentException("No value for optional field: BenchmarkCurveCurrency");
        }

        return view.wrap(buffer, benchmarkCurveCurrencyOffset, benchmarkCurveCurrencyLength);
    }


    private char[] benchmarkCurveName = new char[1];

    private boolean hasBenchmarkCurveName;

    /* BenchmarkCurveName = 221 */
    public char[] benchmarkCurveName()
    {
        if (!hasBenchmarkCurveName)
        {
            throw new IllegalArgumentException("No value for optional field: BenchmarkCurveName");
        }

        return benchmarkCurveName;
    }

    public boolean hasBenchmarkCurveName()
    {
        return hasBenchmarkCurveName;
    }


    private int benchmarkCurveNameOffset;

    private int benchmarkCurveNameLength;

    /* BenchmarkCurveName = 221 */
    public int benchmarkCurveNameLength()
    {
        if (!hasBenchmarkCurveName)
        {
            throw new IllegalArgumentException("No value for optional field: BenchmarkCurveName");
        }

        return benchmarkCurveNameLength;
    }

    /* BenchmarkCurveName = 221 */
    public String benchmarkCurveNameAsString()
    {
        return hasBenchmarkCurveName ? new String(benchmarkCurveName, 0, benchmarkCurveNameLength) : null;
    }

    /* BenchmarkCurveName = 221 */
    public AsciiSequenceView benchmarkCurveName(final AsciiSequenceView view)
    {
        if (!hasBenchmarkCurveName)
        {
            throw new IllegalArgumentException("No value for optional field: BenchmarkCurveName");
        }

        return view.wrap(buffer, benchmarkCurveNameOffset, benchmarkCurveNameLength);
    }


    private final CharArrayWrapper benchmarkCurveNameWrapper = new CharArrayWrapper();
    /* BenchmarkCurveName = 221 */
    public BenchmarkCurveName benchmarkCurveNameAsEnum()
    {
        if (!hasBenchmarkCurveName)
 return BenchmarkCurveName.NULL_VAL;
        benchmarkCurveNameWrapper.wrap(this.benchmarkCurveName(), benchmarkCurveNameLength);
        return BenchmarkCurveName.decode(benchmarkCurveNameWrapper);
    }

    private char[] benchmarkCurvePoint = new char[1];

    private boolean hasBenchmarkCurvePoint;

    /* BenchmarkCurvePoint = 222 */
    public char[] benchmarkCurvePoint()
    {
        if (!hasBenchmarkCurvePoint)
        {
            throw new IllegalArgumentException("No value for optional field: BenchmarkCurvePoint");
        }

        return benchmarkCurvePoint;
    }

    public boolean hasBenchmarkCurvePoint()
    {
        return hasBenchmarkCurvePoint;
    }


    private int benchmarkCurvePointOffset;

    private int benchmarkCurvePointLength;

    /* BenchmarkCurvePoint = 222 */
    public int benchmarkCurvePointLength()
    {
        if (!hasBenchmarkCurvePoint)
        {
            throw new IllegalArgumentException("No value for optional field: BenchmarkCurvePoint");
        }

        return benchmarkCurvePointLength;
    }

    /* BenchmarkCurvePoint = 222 */
    public String benchmarkCurvePointAsString()
    {
        return hasBenchmarkCurvePoint ? new String(benchmarkCurvePoint, 0, benchmarkCurvePointLength) : null;
    }

    /* BenchmarkCurvePoint = 222 */
    public AsciiSequenceView benchmarkCurvePoint(final AsciiSequenceView view)
    {
        if (!hasBenchmarkCurvePoint)
        {
            throw new IllegalArgumentException("No value for optional field: BenchmarkCurvePoint");
        }

        return view.wrap(buffer, benchmarkCurvePointOffset, benchmarkCurvePointLength);
    }


    private final CharArrayWrapper benchmarkCurvePointWrapper = new CharArrayWrapper();
    private DecimalFloat benchmarkPrice = DecimalFloat.newNaNValue();

    private boolean hasBenchmarkPrice;

    /* BenchmarkPrice = 662 */
    public DecimalFloat benchmarkPrice()
    {
        if (!hasBenchmarkPrice)
        {
            throw new IllegalArgumentException("No value for optional field: BenchmarkPrice");
        }

        return benchmarkPrice;
    }

    public boolean hasBenchmarkPrice()
    {
        return hasBenchmarkPrice;
    }



    private int benchmarkPriceType = MISSING_INT;

    private boolean hasBenchmarkPriceType;

    /* BenchmarkPriceType = 663 */
    public int benchmarkPriceType()
    {
        if (!hasBenchmarkPriceType)
        {
            throw new IllegalArgumentException("No value for optional field: BenchmarkPriceType");
        }

        return benchmarkPriceType;
    }

    public boolean hasBenchmarkPriceType()
    {
        return hasBenchmarkPriceType;
    }



    private char[] benchmarkSecurityID = new char[1];

    private boolean hasBenchmarkSecurityID;

    /* BenchmarkSecurityID = 699 */
    public char[] benchmarkSecurityID()
    {
        if (!hasBenchmarkSecurityID)
        {
            throw new IllegalArgumentException("No value for optional field: BenchmarkSecurityID");
        }

        return benchmarkSecurityID;
    }

    public boolean hasBenchmarkSecurityID()
    {
        return hasBenchmarkSecurityID;
    }


    private int benchmarkSecurityIDOffset;

    private int benchmarkSecurityIDLength;

    /* BenchmarkSecurityID = 699 */
    public int benchmarkSecurityIDLength()
    {
        if (!hasBenchmarkSecurityID)
        {
            throw new IllegalArgumentException("No value for optional field: BenchmarkSecurityID");
        }

        return benchmarkSecurityIDLength;
    }

    /* BenchmarkSecurityID = 699 */
    public String benchmarkSecurityIDAsString()
    {
        return hasBenchmarkSecurityID ? new String(benchmarkSecurityID, 0, benchmarkSecurityIDLength) : null;
    }

    /* BenchmarkSecurityID = 699 */
    public AsciiSequenceView benchmarkSecurityID(final AsciiSequenceView view)
    {
        if (!hasBenchmarkSecurityID)
        {
            throw new IllegalArgumentException("No value for optional field: BenchmarkSecurityID");
        }

        return view.wrap(buffer, benchmarkSecurityIDOffset, benchmarkSecurityIDLength);
    }


    private final CharArrayWrapper benchmarkSecurityIDWrapper = new CharArrayWrapper();
    private char[] benchmarkSecurityIDSource = new char[1];

    private boolean hasBenchmarkSecurityIDSource;

    /* BenchmarkSecurityIDSource = 761 */
    public char[] benchmarkSecurityIDSource()
    {
        if (!hasBenchmarkSecurityIDSource)
        {
            throw new IllegalArgumentException("No value for optional field: BenchmarkSecurityIDSource");
        }

        return benchmarkSecurityIDSource;
    }

    public boolean hasBenchmarkSecurityIDSource()
    {
        return hasBenchmarkSecurityIDSource;
    }


    private int benchmarkSecurityIDSourceOffset;

    private int benchmarkSecurityIDSourceLength;

    /* BenchmarkSecurityIDSource = 761 */
    public int benchmarkSecurityIDSourceLength()
    {
        if (!hasBenchmarkSecurityIDSource)
        {
            throw new IllegalArgumentException("No value for optional field: BenchmarkSecurityIDSource");
        }

        return benchmarkSecurityIDSourceLength;
    }

    /* BenchmarkSecurityIDSource = 761 */
    public String benchmarkSecurityIDSourceAsString()
    {
        return hasBenchmarkSecurityIDSource ? new String(benchmarkSecurityIDSource, 0, benchmarkSecurityIDSourceLength) : null;
    }

    /* BenchmarkSecurityIDSource = 761 */
    public AsciiSequenceView benchmarkSecurityIDSource(final AsciiSequenceView view)
    {
        if (!hasBenchmarkSecurityIDSource)
        {
            throw new IllegalArgumentException("No value for optional field: BenchmarkSecurityIDSource");
        }

        return view.wrap(buffer, benchmarkSecurityIDSourceOffset, benchmarkSecurityIDSourceLength);
    }


    private final CharArrayWrapper benchmarkSecurityIDSourceWrapper = new CharArrayWrapper();


    private char[] yieldType = new char[1];

    private boolean hasYieldType;

    /* YieldType = 235 */
    public char[] yieldType()
    {
        if (!hasYieldType)
        {
            throw new IllegalArgumentException("No value for optional field: YieldType");
        }

        return yieldType;
    }

    public boolean hasYieldType()
    {
        return hasYieldType;
    }


    private int yieldTypeOffset;

    private int yieldTypeLength;

    /* YieldType = 235 */
    public int yieldTypeLength()
    {
        if (!hasYieldType)
        {
            throw new IllegalArgumentException("No value for optional field: YieldType");
        }

        return yieldTypeLength;
    }

    /* YieldType = 235 */
    public String yieldTypeAsString()
    {
        return hasYieldType ? new String(yieldType, 0, yieldTypeLength) : null;
    }

    /* YieldType = 235 */
    public AsciiSequenceView yieldType(final AsciiSequenceView view)
    {
        if (!hasYieldType)
        {
            throw new IllegalArgumentException("No value for optional field: YieldType");
        }

        return view.wrap(buffer, yieldTypeOffset, yieldTypeLength);
    }


    private final CharArrayWrapper yieldTypeWrapper = new CharArrayWrapper();
    /* YieldType = 235 */
    public YieldType yieldTypeAsEnum()
    {
        if (!hasYieldType)
 return YieldType.NULL_VAL;
        yieldTypeWrapper.wrap(this.yieldType(), yieldTypeLength);
        return YieldType.decode(yieldTypeWrapper);
    }

    private DecimalFloat yield = DecimalFloat.newNaNValue();

    private boolean hasYield;

    /* Yield = 236 */
    public DecimalFloat yield()
    {
        if (!hasYield)
        {
            throw new IllegalArgumentException("No value for optional field: Yield");
        }

        return yield;
    }

    public boolean hasYield()
    {
        return hasYield;
    }



    private byte[] yieldCalcDate = new byte[8];

    private boolean hasYieldCalcDate;

    /* YieldCalcDate = 701 */
    public byte[] yieldCalcDate()
    {
        if (!hasYieldCalcDate)
        {
            throw new IllegalArgumentException("No value for optional field: YieldCalcDate");
        }

        return yieldCalcDate;
    }

    public boolean hasYieldCalcDate()
    {
        return hasYieldCalcDate;
    }


    private int yieldCalcDateOffset;

    private int yieldCalcDateLength;

    /* YieldCalcDate = 701 */
    public int yieldCalcDateLength()
    {
        if (!hasYieldCalcDate)
        {
            throw new IllegalArgumentException("No value for optional field: YieldCalcDate");
        }

        return yieldCalcDateLength;
    }

    /* YieldCalcDate = 701 */
    public String yieldCalcDateAsString()
    {
        return hasYieldCalcDate ? new String(yieldCalcDate, 0, yieldCalcDateLength) : null;
    }

    /* YieldCalcDate = 701 */
    public AsciiSequenceView yieldCalcDate(final AsciiSequenceView view)
    {
        if (!hasYieldCalcDate)
        {
            throw new IllegalArgumentException("No value for optional field: YieldCalcDate");
        }

        return view.wrap(buffer, yieldCalcDateOffset, yieldCalcDateLength);
    }


    private byte[] yieldRedemptionDate = new byte[8];

    private boolean hasYieldRedemptionDate;

    /* YieldRedemptionDate = 696 */
    public byte[] yieldRedemptionDate()
    {
        if (!hasYieldRedemptionDate)
        {
            throw new IllegalArgumentException("No value for optional field: YieldRedemptionDate");
        }

        return yieldRedemptionDate;
    }

    public boolean hasYieldRedemptionDate()
    {
        return hasYieldRedemptionDate;
    }


    private int yieldRedemptionDateOffset;

    private int yieldRedemptionDateLength;

    /* YieldRedemptionDate = 696 */
    public int yieldRedemptionDateLength()
    {
        if (!hasYieldRedemptionDate)
        {
            throw new IllegalArgumentException("No value for optional field: YieldRedemptionDate");
        }

        return yieldRedemptionDateLength;
    }

    /* YieldRedemptionDate = 696 */
    public String yieldRedemptionDateAsString()
    {
        return hasYieldRedemptionDate ? new String(yieldRedemptionDate, 0, yieldRedemptionDateLength) : null;
    }

    /* YieldRedemptionDate = 696 */
    public AsciiSequenceView yieldRedemptionDate(final AsciiSequenceView view)
    {
        if (!hasYieldRedemptionDate)
        {
            throw new IllegalArgumentException("No value for optional field: YieldRedemptionDate");
        }

        return view.wrap(buffer, yieldRedemptionDateOffset, yieldRedemptionDateLength);
    }


    private DecimalFloat yieldRedemptionPrice = DecimalFloat.newNaNValue();

    private boolean hasYieldRedemptionPrice;

    /* YieldRedemptionPrice = 697 */
    public DecimalFloat yieldRedemptionPrice()
    {
        if (!hasYieldRedemptionPrice)
        {
            throw new IllegalArgumentException("No value for optional field: YieldRedemptionPrice");
        }

        return yieldRedemptionPrice;
    }

    public boolean hasYieldRedemptionPrice()
    {
        return hasYieldRedemptionPrice;
    }



    private int yieldRedemptionPriceType = MISSING_INT;

    private boolean hasYieldRedemptionPriceType;

    /* YieldRedemptionPriceType = 698 */
    public int yieldRedemptionPriceType()
    {
        if (!hasYieldRedemptionPriceType)
        {
            throw new IllegalArgumentException("No value for optional field: YieldRedemptionPriceType");
        }

        return yieldRedemptionPriceType;
    }

    public boolean hasYieldRedemptionPriceType()
    {
        return hasYieldRedemptionPriceType;
    }




    private char[] currency = new char[1];

    private boolean hasCurrency;

    /* Currency = 15 */
    public char[] currency()
    {
        if (!hasCurrency)
        {
            throw new IllegalArgumentException("No value for optional field: Currency");
        }

        return currency;
    }

    public boolean hasCurrency()
    {
        return hasCurrency;
    }


    private int currencyOffset;

    private int currencyLength;

    /* Currency = 15 */
    public int currencyLength()
    {
        if (!hasCurrency)
        {
            throw new IllegalArgumentException("No value for optional field: Currency");
        }

        return currencyLength;
    }

    /* Currency = 15 */
    public String currencyAsString()
    {
        return hasCurrency ? new String(currency, 0, currencyLength) : null;
    }

    /* Currency = 15 */
    public AsciiSequenceView currency(final AsciiSequenceView view)
    {
        if (!hasCurrency)
        {
            throw new IllegalArgumentException("No value for optional field: Currency");
        }

        return view.wrap(buffer, currencyOffset, currencyLength);
    }


    private char[] complianceID = new char[1];

    private boolean hasComplianceID;

    /* ComplianceID = 376 */
    public char[] complianceID()
    {
        if (!hasComplianceID)
        {
            throw new IllegalArgumentException("No value for optional field: ComplianceID");
        }

        return complianceID;
    }

    public boolean hasComplianceID()
    {
        return hasComplianceID;
    }


    private int complianceIDOffset;

    private int complianceIDLength;

    /* ComplianceID = 376 */
    public int complianceIDLength()
    {
        if (!hasComplianceID)
        {
            throw new IllegalArgumentException("No value for optional field: ComplianceID");
        }

        return complianceIDLength;
    }

    /* ComplianceID = 376 */
    public String complianceIDAsString()
    {
        return hasComplianceID ? new String(complianceID, 0, complianceIDLength) : null;
    }

    /* ComplianceID = 376 */
    public AsciiSequenceView complianceID(final AsciiSequenceView view)
    {
        if (!hasComplianceID)
        {
            throw new IllegalArgumentException("No value for optional field: ComplianceID");
        }

        return view.wrap(buffer, complianceIDOffset, complianceIDLength);
    }


    private final CharArrayWrapper complianceIDWrapper = new CharArrayWrapper();
    private boolean solicitedFlag;

    private boolean hasSolicitedFlag;

    /* SolicitedFlag = 377 */
    public boolean solicitedFlag()
    {
        if (!hasSolicitedFlag)
        {
            throw new IllegalArgumentException("No value for optional field: SolicitedFlag");
        }

        return solicitedFlag;
    }

    public boolean hasSolicitedFlag()
    {
        return hasSolicitedFlag;
    }



    private char[] iOIid = new char[1];

    private boolean hasIOIid;

    /* IOIid = 23 */
    public char[] iOIid()
    {
        if (!hasIOIid)
        {
            throw new IllegalArgumentException("No value for optional field: IOIid");
        }

        return iOIid;
    }

    public boolean hasIOIid()
    {
        return hasIOIid;
    }


    private int iOIidOffset;

    private int iOIidLength;

    /* IOIid = 23 */
    public int iOIidLength()
    {
        if (!hasIOIid)
        {
            throw new IllegalArgumentException("No value for optional field: IOIid");
        }

        return iOIidLength;
    }

    /* IOIid = 23 */
    public String iOIidAsString()
    {
        return hasIOIid ? new String(iOIid, 0, iOIidLength) : null;
    }

    /* IOIid = 23 */
    public AsciiSequenceView iOIid(final AsciiSequenceView view)
    {
        if (!hasIOIid)
        {
            throw new IllegalArgumentException("No value for optional field: IOIid");
        }

        return view.wrap(buffer, iOIidOffset, iOIidLength);
    }


    private final CharArrayWrapper iOIidWrapper = new CharArrayWrapper();
    private char[] quoteID = new char[1];

    private boolean hasQuoteID;

    /* QuoteID = 117 */
    public char[] quoteID()
    {
        if (!hasQuoteID)
        {
            throw new IllegalArgumentException("No value for optional field: QuoteID");
        }

        return quoteID;
    }

    public boolean hasQuoteID()
    {
        return hasQuoteID;
    }


    private int quoteIDOffset;

    private int quoteIDLength;

    /* QuoteID = 117 */
    public int quoteIDLength()
    {
        if (!hasQuoteID)
        {
            throw new IllegalArgumentException("No value for optional field: QuoteID");
        }

        return quoteIDLength;
    }

    /* QuoteID = 117 */
    public String quoteIDAsString()
    {
        return hasQuoteID ? new String(quoteID, 0, quoteIDLength) : null;
    }

    /* QuoteID = 117 */
    public AsciiSequenceView quoteID(final AsciiSequenceView view)
    {
        if (!hasQuoteID)
        {
            throw new IllegalArgumentException("No value for optional field: QuoteID");
        }

        return view.wrap(buffer, quoteIDOffset, quoteIDLength);
    }


    private final CharArrayWrapper quoteIDWrapper = new CharArrayWrapper();
    private char timeInForce = MISSING_CHAR;

    private boolean hasTimeInForce;

    /* TimeInForce = 59 */
    public char timeInForce()
    {
        if (!hasTimeInForce)
        {
            throw new IllegalArgumentException("No value for optional field: TimeInForce");
        }

        return timeInForce;
    }

    public boolean hasTimeInForce()
    {
        return hasTimeInForce;
    }



    private final CharArrayWrapper timeInForceWrapper = new CharArrayWrapper();
    /* TimeInForce = 59 */
    public TimeInForce timeInForceAsEnum()
    {
        if (!hasTimeInForce)
 return TimeInForce.NULL_VAL;
        return TimeInForce.decode(timeInForce);
    }

    private byte[] effectiveTime = new byte[24];

    private boolean hasEffectiveTime;

    /* EffectiveTime = 168 */
    public byte[] effectiveTime()
    {
        if (!hasEffectiveTime)
        {
            throw new IllegalArgumentException("No value for optional field: EffectiveTime");
        }

        return effectiveTime;
    }

    public boolean hasEffectiveTime()
    {
        return hasEffectiveTime;
    }


    private int effectiveTimeOffset;

    private int effectiveTimeLength;

    /* EffectiveTime = 168 */
    public int effectiveTimeLength()
    {
        if (!hasEffectiveTime)
        {
            throw new IllegalArgumentException("No value for optional field: EffectiveTime");
        }

        return effectiveTimeLength;
    }

    /* EffectiveTime = 168 */
    public String effectiveTimeAsString()
    {
        return hasEffectiveTime ? new String(effectiveTime, 0, effectiveTimeLength) : null;
    }

    /* EffectiveTime = 168 */
    public AsciiSequenceView effectiveTime(final AsciiSequenceView view)
    {
        if (!hasEffectiveTime)
        {
            throw new IllegalArgumentException("No value for optional field: EffectiveTime");
        }

        return view.wrap(buffer, effectiveTimeOffset, effectiveTimeLength);
    }


    private byte[] expireDate = new byte[8];

    private boolean hasExpireDate;

    /* ExpireDate = 432 */
    public byte[] expireDate()
    {
        if (!hasExpireDate)
        {
            throw new IllegalArgumentException("No value for optional field: ExpireDate");
        }

        return expireDate;
    }

    public boolean hasExpireDate()
    {
        return hasExpireDate;
    }


    private int expireDateOffset;

    private int expireDateLength;

    /* ExpireDate = 432 */
    public int expireDateLength()
    {
        if (!hasExpireDate)
        {
            throw new IllegalArgumentException("No value for optional field: ExpireDate");
        }

        return expireDateLength;
    }

    /* ExpireDate = 432 */
    public String expireDateAsString()
    {
        return hasExpireDate ? new String(expireDate, 0, expireDateLength) : null;
    }

    /* ExpireDate = 432 */
    public AsciiSequenceView expireDate(final AsciiSequenceView view)
    {
        if (!hasExpireDate)
        {
            throw new IllegalArgumentException("No value for optional field: ExpireDate");
        }

        return view.wrap(buffer, expireDateOffset, expireDateLength);
    }


    private byte[] expireTime = new byte[24];

    private boolean hasExpireTime;

    /* ExpireTime = 126 */
    public byte[] expireTime()
    {
        if (!hasExpireTime)
        {
            throw new IllegalArgumentException("No value for optional field: ExpireTime");
        }

        return expireTime;
    }

    public boolean hasExpireTime()
    {
        return hasExpireTime;
    }


    private int expireTimeOffset;

    private int expireTimeLength;

    /* ExpireTime = 126 */
    public int expireTimeLength()
    {
        if (!hasExpireTime)
        {
            throw new IllegalArgumentException("No value for optional field: ExpireTime");
        }

        return expireTimeLength;
    }

    /* ExpireTime = 126 */
    public String expireTimeAsString()
    {
        return hasExpireTime ? new String(expireTime, 0, expireTimeLength) : null;
    }

    /* ExpireTime = 126 */
    public AsciiSequenceView expireTime(final AsciiSequenceView view)
    {
        if (!hasExpireTime)
        {
            throw new IllegalArgumentException("No value for optional field: ExpireTime");
        }

        return view.wrap(buffer, expireTimeOffset, expireTimeLength);
    }


    private int gTBookingInst = MISSING_INT;

    private boolean hasGTBookingInst;

    /* GTBookingInst = 427 */
    public int gTBookingInst()
    {
        if (!hasGTBookingInst)
        {
            throw new IllegalArgumentException("No value for optional field: GTBookingInst");
        }

        return gTBookingInst;
    }

    public boolean hasGTBookingInst()
    {
        return hasGTBookingInst;
    }



    private final CharArrayWrapper gTBookingInstWrapper = new CharArrayWrapper();
    /* GTBookingInst = 427 */
    public GTBookingInst gTBookingInstAsEnum()
    {
        if (!hasGTBookingInst)
 return GTBookingInst.NULL_VAL;
        return GTBookingInst.decode(gTBookingInst);
    }


    private DecimalFloat commission = DecimalFloat.newNaNValue();

    private boolean hasCommission;

    /* Commission = 12 */
    public DecimalFloat commission()
    {
        if (!hasCommission)
        {
            throw new IllegalArgumentException("No value for optional field: Commission");
        }

        return commission;
    }

    public boolean hasCommission()
    {
        return hasCommission;
    }



    private char commType = MISSING_CHAR;

    private boolean hasCommType;

    /* CommType = 13 */
    public char commType()
    {
        if (!hasCommType)
        {
            throw new IllegalArgumentException("No value for optional field: CommType");
        }

        return commType;
    }

    public boolean hasCommType()
    {
        return hasCommType;
    }



    private final CharArrayWrapper commTypeWrapper = new CharArrayWrapper();
    /* CommType = 13 */
    public CommType commTypeAsEnum()
    {
        if (!hasCommType)
 return CommType.NULL_VAL;
        return CommType.decode(commType);
    }

    private char[] commCurrency = new char[1];

    private boolean hasCommCurrency;

    /* CommCurrency = 479 */
    public char[] commCurrency()
    {
        if (!hasCommCurrency)
        {
            throw new IllegalArgumentException("No value for optional field: CommCurrency");
        }

        return commCurrency;
    }

    public boolean hasCommCurrency()
    {
        return hasCommCurrency;
    }


    private int commCurrencyOffset;

    private int commCurrencyLength;

    /* CommCurrency = 479 */
    public int commCurrencyLength()
    {
        if (!hasCommCurrency)
        {
            throw new IllegalArgumentException("No value for optional field: CommCurrency");
        }

        return commCurrencyLength;
    }

    /* CommCurrency = 479 */
    public String commCurrencyAsString()
    {
        return hasCommCurrency ? new String(commCurrency, 0, commCurrencyLength) : null;
    }

    /* CommCurrency = 479 */
    public AsciiSequenceView commCurrency(final AsciiSequenceView view)
    {
        if (!hasCommCurrency)
        {
            throw new IllegalArgumentException("No value for optional field: CommCurrency");
        }

        return view.wrap(buffer, commCurrencyOffset, commCurrencyLength);
    }


    private char fundRenewWaiv = MISSING_CHAR;

    private boolean hasFundRenewWaiv;

    /* FundRenewWaiv = 497 */
    public char fundRenewWaiv()
    {
        if (!hasFundRenewWaiv)
        {
            throw new IllegalArgumentException("No value for optional field: FundRenewWaiv");
        }

        return fundRenewWaiv;
    }

    public boolean hasFundRenewWaiv()
    {
        return hasFundRenewWaiv;
    }



    private final CharArrayWrapper fundRenewWaivWrapper = new CharArrayWrapper();
    /* FundRenewWaiv = 497 */
    public FundRenewWaiv fundRenewWaivAsEnum()
    {
        if (!hasFundRenewWaiv)
 return FundRenewWaiv.NULL_VAL;
        return FundRenewWaiv.decode(fundRenewWaiv);
    }


    private char orderCapacity = MISSING_CHAR;

    private boolean hasOrderCapacity;

    /* OrderCapacity = 528 */
    public char orderCapacity()
    {
        if (!hasOrderCapacity)
        {
            throw new IllegalArgumentException("No value for optional field: OrderCapacity");
        }

        return orderCapacity;
    }

    public boolean hasOrderCapacity()
    {
        return hasOrderCapacity;
    }



    private final CharArrayWrapper orderCapacityWrapper = new CharArrayWrapper();
    /* OrderCapacity = 528 */
    public OrderCapacity orderCapacityAsEnum()
    {
        if (!hasOrderCapacity)
 return OrderCapacity.NULL_VAL;
        return OrderCapacity.decode(orderCapacity);
    }

    private char[] orderRestrictions = new char[1];

    private boolean hasOrderRestrictions;

    /* OrderRestrictions = 529 */
    public char[] orderRestrictions()
    {
        if (!hasOrderRestrictions)
        {
            throw new IllegalArgumentException("No value for optional field: OrderRestrictions");
        }

        return orderRestrictions;
    }

    public boolean hasOrderRestrictions()
    {
        return hasOrderRestrictions;
    }


    private int orderRestrictionsOffset;

    private int orderRestrictionsLength;

    /* OrderRestrictions = 529 */
    public int orderRestrictionsLength()
    {
        if (!hasOrderRestrictions)
        {
            throw new IllegalArgumentException("No value for optional field: OrderRestrictions");
        }

        return orderRestrictionsLength;
    }

    /* OrderRestrictions = 529 */
    public String orderRestrictionsAsString()
    {
        return hasOrderRestrictions ? new String(orderRestrictions, 0, orderRestrictionsLength) : null;
    }

    /* OrderRestrictions = 529 */
    public AsciiSequenceView orderRestrictions(final AsciiSequenceView view)
    {
        if (!hasOrderRestrictions)
        {
            throw new IllegalArgumentException("No value for optional field: OrderRestrictions");
        }

        return view.wrap(buffer, orderRestrictionsOffset, orderRestrictionsLength);
    }


    private final CharArrayWrapper orderRestrictionsWrapper = new CharArrayWrapper();
    private int custOrderCapacity = MISSING_INT;

    private boolean hasCustOrderCapacity;

    /* CustOrderCapacity = 582 */
    public int custOrderCapacity()
    {
        if (!hasCustOrderCapacity)
        {
            throw new IllegalArgumentException("No value for optional field: CustOrderCapacity");
        }

        return custOrderCapacity;
    }

    public boolean hasCustOrderCapacity()
    {
        return hasCustOrderCapacity;
    }



    private final CharArrayWrapper custOrderCapacityWrapper = new CharArrayWrapper();
    /* CustOrderCapacity = 582 */
    public CustOrderCapacity custOrderCapacityAsEnum()
    {
        if (!hasCustOrderCapacity)
 return CustOrderCapacity.NULL_VAL;
        return CustOrderCapacity.decode(custOrderCapacity);
    }

    private boolean forexReq;

    private boolean hasForexReq;

    /* ForexReq = 121 */
    public boolean forexReq()
    {
        if (!hasForexReq)
        {
            throw new IllegalArgumentException("No value for optional field: ForexReq");
        }

        return forexReq;
    }

    public boolean hasForexReq()
    {
        return hasForexReq;
    }



    private char[] settlCurrency = new char[1];

    private boolean hasSettlCurrency;

    /* SettlCurrency = 120 */
    public char[] settlCurrency()
    {
        if (!hasSettlCurrency)
        {
            throw new IllegalArgumentException("No value for optional field: SettlCurrency");
        }

        return settlCurrency;
    }

    public boolean hasSettlCurrency()
    {
        return hasSettlCurrency;
    }


    private int settlCurrencyOffset;

    private int settlCurrencyLength;

    /* SettlCurrency = 120 */
    public int settlCurrencyLength()
    {
        if (!hasSettlCurrency)
        {
            throw new IllegalArgumentException("No value for optional field: SettlCurrency");
        }

        return settlCurrencyLength;
    }

    /* SettlCurrency = 120 */
    public String settlCurrencyAsString()
    {
        return hasSettlCurrency ? new String(settlCurrency, 0, settlCurrencyLength) : null;
    }

    /* SettlCurrency = 120 */
    public AsciiSequenceView settlCurrency(final AsciiSequenceView view)
    {
        if (!hasSettlCurrency)
        {
            throw new IllegalArgumentException("No value for optional field: SettlCurrency");
        }

        return view.wrap(buffer, settlCurrencyOffset, settlCurrencyLength);
    }


    private int bookingType = MISSING_INT;

    private boolean hasBookingType;

    /* BookingType = 775 */
    public int bookingType()
    {
        if (!hasBookingType)
        {
            throw new IllegalArgumentException("No value for optional field: BookingType");
        }

        return bookingType;
    }

    public boolean hasBookingType()
    {
        return hasBookingType;
    }



    private final CharArrayWrapper bookingTypeWrapper = new CharArrayWrapper();
    /* BookingType = 775 */
    public BookingType bookingTypeAsEnum()
    {
        if (!hasBookingType)
 return BookingType.NULL_VAL;
        return BookingType.decode(bookingType);
    }

    private char[] text = new char[1];

    private boolean hasText;

    /* Text = 58 */
    public char[] text()
    {
        if (!hasText)
        {
            throw new IllegalArgumentException("No value for optional field: Text");
        }

        return text;
    }

    public boolean hasText()
    {
        return hasText;
    }


    private int textOffset;

    private int textLength;

    /* Text = 58 */
    public int textLength()
    {
        if (!hasText)
        {
            throw new IllegalArgumentException("No value for optional field: Text");
        }

        return textLength;
    }

    /* Text = 58 */
    public String textAsString()
    {
        return hasText ? new String(text, 0, textLength) : null;
    }

    /* Text = 58 */
    public AsciiSequenceView text(final AsciiSequenceView view)
    {
        if (!hasText)
        {
            throw new IllegalArgumentException("No value for optional field: Text");
        }

        return view.wrap(buffer, textOffset, textLength);
    }


    private final CharArrayWrapper textWrapper = new CharArrayWrapper();
    private int encodedTextLen = MISSING_INT;

    private boolean hasEncodedTextLen;

    /* EncodedTextLen = 354 */
    public int encodedTextLen()
    {
        if (!hasEncodedTextLen)
        {
            throw new IllegalArgumentException("No value for optional field: EncodedTextLen");
        }

        return encodedTextLen;
    }

    public boolean hasEncodedTextLen()
    {
        return hasEncodedTextLen;
    }



    private byte[] encodedText = new byte[1];

    private boolean hasEncodedText;

    /* EncodedText = 355 */
    public byte[] encodedText()
    {
        if (!hasEncodedText)
        {
            throw new IllegalArgumentException("No value for optional field: EncodedText");
        }

        return encodedText;
    }

    public boolean hasEncodedText()
    {
        return hasEncodedText;
    }



    private byte[] settlDate2 = new byte[8];

    private boolean hasSettlDate2;

    /* SettlDate2 = 193 */
    public byte[] settlDate2()
    {
        if (!hasSettlDate2)
        {
            throw new IllegalArgumentException("No value for optional field: SettlDate2");
        }

        return settlDate2;
    }

    public boolean hasSettlDate2()
    {
        return hasSettlDate2;
    }


    private int settlDate2Offset;

    private int settlDate2Length;

    /* SettlDate2 = 193 */
    public int settlDate2Length()
    {
        if (!hasSettlDate2)
        {
            throw new IllegalArgumentException("No value for optional field: SettlDate2");
        }

        return settlDate2Length;
    }

    /* SettlDate2 = 193 */
    public String settlDate2AsString()
    {
        return hasSettlDate2 ? new String(settlDate2, 0, settlDate2Length) : null;
    }

    /* SettlDate2 = 193 */
    public AsciiSequenceView settlDate2(final AsciiSequenceView view)
    {
        if (!hasSettlDate2)
        {
            throw new IllegalArgumentException("No value for optional field: SettlDate2");
        }

        return view.wrap(buffer, settlDate2Offset, settlDate2Length);
    }


    private DecimalFloat orderQty2 = DecimalFloat.newNaNValue();

    private boolean hasOrderQty2;

    /* OrderQty2 = 192 */
    public DecimalFloat orderQty2()
    {
        if (!hasOrderQty2)
        {
            throw new IllegalArgumentException("No value for optional field: OrderQty2");
        }

        return orderQty2;
    }

    public boolean hasOrderQty2()
    {
        return hasOrderQty2;
    }



    private DecimalFloat price2 = DecimalFloat.newNaNValue();

    private boolean hasPrice2;

    /* Price2 = 640 */
    public DecimalFloat price2()
    {
        if (!hasPrice2)
        {
            throw new IllegalArgumentException("No value for optional field: Price2");
        }

        return price2;
    }

    public boolean hasPrice2()
    {
        return hasPrice2;
    }



    private char positionEffect = MISSING_CHAR;

    private boolean hasPositionEffect;

    /* PositionEffect = 77 */
    public char positionEffect()
    {
        if (!hasPositionEffect)
        {
            throw new IllegalArgumentException("No value for optional field: PositionEffect");
        }

        return positionEffect;
    }

    public boolean hasPositionEffect()
    {
        return hasPositionEffect;
    }



    private final CharArrayWrapper positionEffectWrapper = new CharArrayWrapper();
    /* PositionEffect = 77 */
    public PositionEffect positionEffectAsEnum()
    {
        if (!hasPositionEffect)
 return PositionEffect.NULL_VAL;
        return PositionEffect.decode(positionEffect);
    }

    private int coveredOrUncovered = MISSING_INT;

    private boolean hasCoveredOrUncovered;

    /* CoveredOrUncovered = 203 */
    public int coveredOrUncovered()
    {
        if (!hasCoveredOrUncovered)
        {
            throw new IllegalArgumentException("No value for optional field: CoveredOrUncovered");
        }

        return coveredOrUncovered;
    }

    public boolean hasCoveredOrUncovered()
    {
        return hasCoveredOrUncovered;
    }



    private final CharArrayWrapper coveredOrUncoveredWrapper = new CharArrayWrapper();
    /* CoveredOrUncovered = 203 */
    public CoveredOrUncovered coveredOrUncoveredAsEnum()
    {
        if (!hasCoveredOrUncovered)
 return CoveredOrUncovered.NULL_VAL;
        return CoveredOrUncovered.decode(coveredOrUncovered);
    }

    private DecimalFloat maxShow = DecimalFloat.newNaNValue();

    private boolean hasMaxShow;

    /* MaxShow = 210 */
    public DecimalFloat maxShow()
    {
        if (!hasMaxShow)
        {
            throw new IllegalArgumentException("No value for optional field: MaxShow");
        }

        return maxShow;
    }

    public boolean hasMaxShow()
    {
        return hasMaxShow;
    }




    private DecimalFloat pegOffsetValue = DecimalFloat.newNaNValue();

    private boolean hasPegOffsetValue;

    /* PegOffsetValue = 211 */
    public DecimalFloat pegOffsetValue()
    {
        if (!hasPegOffsetValue)
        {
            throw new IllegalArgumentException("No value for optional field: PegOffsetValue");
        }

        return pegOffsetValue;
    }

    public boolean hasPegOffsetValue()
    {
        return hasPegOffsetValue;
    }



    private int pegMoveType = MISSING_INT;

    private boolean hasPegMoveType;

    /* PegMoveType = 835 */
    public int pegMoveType()
    {
        if (!hasPegMoveType)
        {
            throw new IllegalArgumentException("No value for optional field: PegMoveType");
        }

        return pegMoveType;
    }

    public boolean hasPegMoveType()
    {
        return hasPegMoveType;
    }



    private final CharArrayWrapper pegMoveTypeWrapper = new CharArrayWrapper();
    /* PegMoveType = 835 */
    public PegMoveType pegMoveTypeAsEnum()
    {
        if (!hasPegMoveType)
 return PegMoveType.NULL_VAL;
        return PegMoveType.decode(pegMoveType);
    }

    private int pegOffsetType = MISSING_INT;

    private boolean hasPegOffsetType;

    /* PegOffsetType = 836 */
    public int pegOffsetType()
    {
        if (!hasPegOffsetType)
        {
            throw new IllegalArgumentException("No value for optional field: PegOffsetType");
        }

        return pegOffsetType;
    }

    public boolean hasPegOffsetType()
    {
        return hasPegOffsetType;
    }



    private final CharArrayWrapper pegOffsetTypeWrapper = new CharArrayWrapper();
    /* PegOffsetType = 836 */
    public PegOffsetType pegOffsetTypeAsEnum()
    {
        if (!hasPegOffsetType)
 return PegOffsetType.NULL_VAL;
        return PegOffsetType.decode(pegOffsetType);
    }

    private int pegLimitType = MISSING_INT;

    private boolean hasPegLimitType;

    /* PegLimitType = 837 */
    public int pegLimitType()
    {
        if (!hasPegLimitType)
        {
            throw new IllegalArgumentException("No value for optional field: PegLimitType");
        }

        return pegLimitType;
    }

    public boolean hasPegLimitType()
    {
        return hasPegLimitType;
    }



    private final CharArrayWrapper pegLimitTypeWrapper = new CharArrayWrapper();
    /* PegLimitType = 837 */
    public PegLimitType pegLimitTypeAsEnum()
    {
        if (!hasPegLimitType)
 return PegLimitType.NULL_VAL;
        return PegLimitType.decode(pegLimitType);
    }

    private int pegRoundDirection = MISSING_INT;

    private boolean hasPegRoundDirection;

    /* PegRoundDirection = 838 */
    public int pegRoundDirection()
    {
        if (!hasPegRoundDirection)
        {
            throw new IllegalArgumentException("No value for optional field: PegRoundDirection");
        }

        return pegRoundDirection;
    }

    public boolean hasPegRoundDirection()
    {
        return hasPegRoundDirection;
    }



    private final CharArrayWrapper pegRoundDirectionWrapper = new CharArrayWrapper();
    /* PegRoundDirection = 838 */
    public PegRoundDirection pegRoundDirectionAsEnum()
    {
        if (!hasPegRoundDirection)
 return PegRoundDirection.NULL_VAL;
        return PegRoundDirection.decode(pegRoundDirection);
    }

    private int pegScope = MISSING_INT;

    private boolean hasPegScope;

    /* PegScope = 840 */
    public int pegScope()
    {
        if (!hasPegScope)
        {
            throw new IllegalArgumentException("No value for optional field: PegScope");
        }

        return pegScope;
    }

    public boolean hasPegScope()
    {
        return hasPegScope;
    }



    private final CharArrayWrapper pegScopeWrapper = new CharArrayWrapper();
    /* PegScope = 840 */
    public PegScope pegScopeAsEnum()
    {
        if (!hasPegScope)
 return PegScope.NULL_VAL;
        return PegScope.decode(pegScope);
    }



    private char discretionInst = MISSING_CHAR;

    private boolean hasDiscretionInst;

    /* DiscretionInst = 388 */
    public char discretionInst()
    {
        if (!hasDiscretionInst)
        {
            throw new IllegalArgumentException("No value for optional field: DiscretionInst");
        }

        return discretionInst;
    }

    public boolean hasDiscretionInst()
    {
        return hasDiscretionInst;
    }



    private final CharArrayWrapper discretionInstWrapper = new CharArrayWrapper();
    /* DiscretionInst = 388 */
    public DiscretionInst discretionInstAsEnum()
    {
        if (!hasDiscretionInst)
 return DiscretionInst.NULL_VAL;
        return DiscretionInst.decode(discretionInst);
    }

    private DecimalFloat discretionOffsetValue = DecimalFloat.newNaNValue();

    private boolean hasDiscretionOffsetValue;

    /* DiscretionOffsetValue = 389 */
    public DecimalFloat discretionOffsetValue()
    {
        if (!hasDiscretionOffsetValue)
        {
            throw new IllegalArgumentException("No value for optional field: DiscretionOffsetValue");
        }

        return discretionOffsetValue;
    }

    public boolean hasDiscretionOffsetValue()
    {
        return hasDiscretionOffsetValue;
    }



    private int discretionMoveType = MISSING_INT;

    private boolean hasDiscretionMoveType;

    /* DiscretionMoveType = 841 */
    public int discretionMoveType()
    {
        if (!hasDiscretionMoveType)
        {
            throw new IllegalArgumentException("No value for optional field: DiscretionMoveType");
        }

        return discretionMoveType;
    }

    public boolean hasDiscretionMoveType()
    {
        return hasDiscretionMoveType;
    }



    private final CharArrayWrapper discretionMoveTypeWrapper = new CharArrayWrapper();
    /* DiscretionMoveType = 841 */
    public DiscretionMoveType discretionMoveTypeAsEnum()
    {
        if (!hasDiscretionMoveType)
 return DiscretionMoveType.NULL_VAL;
        return DiscretionMoveType.decode(discretionMoveType);
    }

    private int discretionOffsetType = MISSING_INT;

    private boolean hasDiscretionOffsetType;

    /* DiscretionOffsetType = 842 */
    public int discretionOffsetType()
    {
        if (!hasDiscretionOffsetType)
        {
            throw new IllegalArgumentException("No value for optional field: DiscretionOffsetType");
        }

        return discretionOffsetType;
    }

    public boolean hasDiscretionOffsetType()
    {
        return hasDiscretionOffsetType;
    }



    private final CharArrayWrapper discretionOffsetTypeWrapper = new CharArrayWrapper();
    /* DiscretionOffsetType = 842 */
    public DiscretionOffsetType discretionOffsetTypeAsEnum()
    {
        if (!hasDiscretionOffsetType)
 return DiscretionOffsetType.NULL_VAL;
        return DiscretionOffsetType.decode(discretionOffsetType);
    }

    private int discretionLimitType = MISSING_INT;

    private boolean hasDiscretionLimitType;

    /* DiscretionLimitType = 843 */
    public int discretionLimitType()
    {
        if (!hasDiscretionLimitType)
        {
            throw new IllegalArgumentException("No value for optional field: DiscretionLimitType");
        }

        return discretionLimitType;
    }

    public boolean hasDiscretionLimitType()
    {
        return hasDiscretionLimitType;
    }



    private final CharArrayWrapper discretionLimitTypeWrapper = new CharArrayWrapper();
    /* DiscretionLimitType = 843 */
    public DiscretionLimitType discretionLimitTypeAsEnum()
    {
        if (!hasDiscretionLimitType)
 return DiscretionLimitType.NULL_VAL;
        return DiscretionLimitType.decode(discretionLimitType);
    }

    private int discretionRoundDirection = MISSING_INT;

    private boolean hasDiscretionRoundDirection;

    /* DiscretionRoundDirection = 844 */
    public int discretionRoundDirection()
    {
        if (!hasDiscretionRoundDirection)
        {
            throw new IllegalArgumentException("No value for optional field: DiscretionRoundDirection");
        }

        return discretionRoundDirection;
    }

    public boolean hasDiscretionRoundDirection()
    {
        return hasDiscretionRoundDirection;
    }



    private final CharArrayWrapper discretionRoundDirectionWrapper = new CharArrayWrapper();
    /* DiscretionRoundDirection = 844 */
    public DiscretionRoundDirection discretionRoundDirectionAsEnum()
    {
        if (!hasDiscretionRoundDirection)
 return DiscretionRoundDirection.NULL_VAL;
        return DiscretionRoundDirection.decode(discretionRoundDirection);
    }

    private int discretionScope = MISSING_INT;

    private boolean hasDiscretionScope;

    /* DiscretionScope = 846 */
    public int discretionScope()
    {
        if (!hasDiscretionScope)
        {
            throw new IllegalArgumentException("No value for optional field: DiscretionScope");
        }

        return discretionScope;
    }

    public boolean hasDiscretionScope()
    {
        return hasDiscretionScope;
    }



    private final CharArrayWrapper discretionScopeWrapper = new CharArrayWrapper();
    /* DiscretionScope = 846 */
    public DiscretionScope discretionScopeAsEnum()
    {
        if (!hasDiscretionScope)
 return DiscretionScope.NULL_VAL;
        return DiscretionScope.decode(discretionScope);
    }


    private int targetStrategy = MISSING_INT;

    private boolean hasTargetStrategy;

    /* TargetStrategy = 847 */
    public int targetStrategy()
    {
        if (!hasTargetStrategy)
        {
            throw new IllegalArgumentException("No value for optional field: TargetStrategy");
        }

        return targetStrategy;
    }

    public boolean hasTargetStrategy()
    {
        return hasTargetStrategy;
    }



    private char[] targetStrategyParameters = new char[1];

    private boolean hasTargetStrategyParameters;

    /* TargetStrategyParameters = 848 */
    public char[] targetStrategyParameters()
    {
        if (!hasTargetStrategyParameters)
        {
            throw new IllegalArgumentException("No value for optional field: TargetStrategyParameters");
        }

        return targetStrategyParameters;
    }

    public boolean hasTargetStrategyParameters()
    {
        return hasTargetStrategyParameters;
    }


    private int targetStrategyParametersOffset;

    private int targetStrategyParametersLength;

    /* TargetStrategyParameters = 848 */
    public int targetStrategyParametersLength()
    {
        if (!hasTargetStrategyParameters)
        {
            throw new IllegalArgumentException("No value for optional field: TargetStrategyParameters");
        }

        return targetStrategyParametersLength;
    }

    /* TargetStrategyParameters = 848 */
    public String targetStrategyParametersAsString()
    {
        return hasTargetStrategyParameters ? new String(targetStrategyParameters, 0, targetStrategyParametersLength) : null;
    }

    /* TargetStrategyParameters = 848 */
    public AsciiSequenceView targetStrategyParameters(final AsciiSequenceView view)
    {
        if (!hasTargetStrategyParameters)
        {
            throw new IllegalArgumentException("No value for optional field: TargetStrategyParameters");
        }

        return view.wrap(buffer, targetStrategyParametersOffset, targetStrategyParametersLength);
    }


    private final CharArrayWrapper targetStrategyParametersWrapper = new CharArrayWrapper();
    private DecimalFloat participationRate = DecimalFloat.newNaNValue();

    private boolean hasParticipationRate;

    /* ParticipationRate = 849 */
    public DecimalFloat participationRate()
    {
        if (!hasParticipationRate)
        {
            throw new IllegalArgumentException("No value for optional field: ParticipationRate");
        }

        return participationRate;
    }

    public boolean hasParticipationRate()
    {
        return hasParticipationRate;
    }



    private char[] designation = new char[1];

    private boolean hasDesignation;

    /* Designation = 494 */
    public char[] designation()
    {
        if (!hasDesignation)
        {
            throw new IllegalArgumentException("No value for optional field: Designation");
        }

        return designation;
    }

    public boolean hasDesignation()
    {
        return hasDesignation;
    }


    private int designationOffset;

    private int designationLength;

    /* Designation = 494 */
    public int designationLength()
    {
        if (!hasDesignation)
        {
            throw new IllegalArgumentException("No value for optional field: Designation");
        }

        return designationLength;
    }

    /* Designation = 494 */
    public String designationAsString()
    {
        return hasDesignation ? new String(designation, 0, designationLength) : null;
    }

    /* Designation = 494 */
    public AsciiSequenceView designation(final AsciiSequenceView view)
    {
        if (!hasDesignation)
        {
            throw new IllegalArgumentException("No value for optional field: Designation");
        }

        return view.wrap(buffer, designationOffset, designationLength);
    }


    private final CharArrayWrapper designationWrapper = new CharArrayWrapper();
    public int decode(final AsciiBuffer buffer, final int offset, final int length)
    {
        // Decode OrdersGroup
        int seenFieldCount = 0;
        if (CODEC_VALIDATION_ENABLED)
        {
            missingRequiredFields.copy(REQUIRED_FIELDS);
        }
        this.buffer = buffer;
        final int end = offset + length;
        int position = offset;
        seenFields.clear();
        int tag;

        while (position < end)
        {
            final int equalsPosition = buffer.scan(position, end, '=');
            if (equalsPosition == AsciiBuffer.UNKNOWN_INDEX)
            {
               return position;
            }
            tag = buffer.getInt(position, equalsPosition);
            if (!seenFields.add(tag))
            {
                if (next == null)
                {
                    next = new OrdersGroupDecoder(trailer, messageFields);
                }
                return position - offset;
            }
            final int valueOffset = equalsPosition + 1;
            int endOfField = buffer.scan(valueOffset, end, START_OF_HEADER);
            if (endOfField == AsciiBuffer.UNKNOWN_INDEX || equalsPosition == AsciiBuffer.UNKNOWN_INDEX)
            {
                rejectReason = 5;
                break;
            }
            final int valueLength = endOfField - valueOffset;
            if (CODEC_VALIDATION_ENABLED)
            {
                if (tag <= 0)
                {
                    invalidTagId = tag;
                    rejectReason = 0;
                }
                else if (valueLength == 0)
                {
                    invalidTagId = tag;
                    rejectReason = 4;
                }
                missingRequiredFields.remove(tag);
                seenFieldCount++;
            }

            switch (tag)
            {
            case Constants.CL_ORD_ID:
                clOrdID = buffer.getChars(clOrdID, valueOffset, valueLength);
                clOrdIDOffset = valueOffset;
                clOrdIDLength = valueLength;
                break;

            case Constants.SECONDARY_CL_ORD_ID:
                hasSecondaryClOrdID = true;
                secondaryClOrdID = buffer.getChars(secondaryClOrdID, valueOffset, valueLength);
                secondaryClOrdIDOffset = valueOffset;
                secondaryClOrdIDLength = valueLength;
                break;

            case Constants.LIST_SEQ_NO:
                listSeqNo = getInt(buffer, valueOffset, endOfField, 67, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.CL_ORD_LINK_ID:
                hasClOrdLinkID = true;
                clOrdLinkID = buffer.getChars(clOrdLinkID, valueOffset, valueLength);
                clOrdLinkIDOffset = valueOffset;
                clOrdLinkIDLength = valueLength;
                break;

            case Constants.SETTL_INST_MODE:
                hasSettlInstMode = true;
                settlInstMode = buffer.getChar(valueOffset);
                break;

            case Constants.NO_PARTY_IDS_GROUP_COUNTER:
                hasNoPartyIDsGroupCounter = true;
                noPartyIDsGroupCounter = getInt(buffer, valueOffset, endOfField, 453, CODEC_VALIDATION_ENABLED);
                if (partyIDsGroup == null)
                {
                    partyIDsGroup = new PartyIDsGroupDecoder(trailer, messageFields);
                }
                PartyIDsGroupDecoder partyIDsGroupCurrent = partyIDsGroup;
                position = endOfField + 1;
                final int noPartyIDsGroupCounter = this.noPartyIDsGroupCounter;
                for (int i = 0; i < noPartyIDsGroupCounter && position < end; i++)
                {
                    if (partyIDsGroupCurrent != null)
                    {
                        position += partyIDsGroupCurrent.decode(buffer, position, end - position);
                        partyIDsGroupCurrent = partyIDsGroupCurrent.next();
                    }
                }
                if (CODEC_VALIDATION_ENABLED)
                {
                    final int checkEqualsPosition = buffer.scan(position, end, '=');
                    if (checkEqualsPosition != AsciiBuffer.UNKNOWN_INDEX)
                    {
                        final int checkTag = buffer.getInt(position, checkEqualsPosition);
                        if (partyIDsGroup.ALL_GROUP_FIELDS.contains(checkTag))
                        {
                            invalidTagId = tag;
                            rejectReason = 16;
                            return position;
                        }
                    }
                }
                break;


            case Constants.TRADE_ORIGINATION_DATE:
                hasTradeOriginationDate = true;
                tradeOriginationDate = buffer.getBytes(tradeOriginationDate, valueOffset, valueLength);
                tradeOriginationDateOffset = valueOffset;
                tradeOriginationDateLength = valueLength;
                break;

            case Constants.TRADE_DATE:
                hasTradeDate = true;
                tradeDate = buffer.getBytes(tradeDate, valueOffset, valueLength);
                tradeDateOffset = valueOffset;
                tradeDateLength = valueLength;
                break;

            case Constants.ACCOUNT:
                hasAccount = true;
                account = buffer.getChars(account, valueOffset, valueLength);
                accountOffset = valueOffset;
                accountLength = valueLength;
                break;

            case Constants.ACCT_ID_SOURCE:
                hasAcctIDSource = true;
                acctIDSource = getInt(buffer, valueOffset, endOfField, 660, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.ACCOUNT_TYPE:
                hasAccountType = true;
                accountType = getInt(buffer, valueOffset, endOfField, 581, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.DAY_BOOKING_INST:
                hasDayBookingInst = true;
                dayBookingInst = buffer.getChar(valueOffset);
                break;

            case Constants.BOOKING_UNIT:
                hasBookingUnit = true;
                bookingUnit = buffer.getChar(valueOffset);
                break;

            case Constants.ALLOC_ID:
                hasAllocID = true;
                allocID = buffer.getChars(allocID, valueOffset, valueLength);
                allocIDOffset = valueOffset;
                allocIDLength = valueLength;
                break;

            case Constants.PREALLOC_METHOD:
                hasPreallocMethod = true;
                preallocMethod = buffer.getChar(valueOffset);
                break;

            case Constants.NO_ALLOCS_GROUP_COUNTER:
                hasNoAllocsGroupCounter = true;
                noAllocsGroupCounter = getInt(buffer, valueOffset, endOfField, 78, CODEC_VALIDATION_ENABLED);
                if (allocsGroup == null)
                {
                    allocsGroup = new AllocsGroupDecoder(trailer, messageFields);
                }
                AllocsGroupDecoder allocsGroupCurrent = allocsGroup;
                position = endOfField + 1;
                final int noAllocsGroupCounter = this.noAllocsGroupCounter;
                for (int i = 0; i < noAllocsGroupCounter && position < end; i++)
                {
                    if (allocsGroupCurrent != null)
                    {
                        position += allocsGroupCurrent.decode(buffer, position, end - position);
                        allocsGroupCurrent = allocsGroupCurrent.next();
                    }
                }
                if (CODEC_VALIDATION_ENABLED)
                {
                    final int checkEqualsPosition = buffer.scan(position, end, '=');
                    if (checkEqualsPosition != AsciiBuffer.UNKNOWN_INDEX)
                    {
                        final int checkTag = buffer.getInt(position, checkEqualsPosition);
                        if (allocsGroup.ALL_GROUP_FIELDS.contains(checkTag))
                        {
                            invalidTagId = tag;
                            rejectReason = 16;
                            return position;
                        }
                    }
                }
                break;

            case Constants.SETTL_TYPE:
                hasSettlType = true;
                settlType = buffer.getChar(valueOffset);
                break;

            case Constants.SETTL_DATE:
                hasSettlDate = true;
                settlDate = buffer.getBytes(settlDate, valueOffset, valueLength);
                settlDateOffset = valueOffset;
                settlDateLength = valueLength;
                break;

            case Constants.CASH_MARGIN:
                hasCashMargin = true;
                cashMargin = buffer.getChar(valueOffset);
                break;

            case Constants.CLEARING_FEE_INDICATOR:
                hasClearingFeeIndicator = true;
                clearingFeeIndicator = buffer.getChars(clearingFeeIndicator, valueOffset, valueLength);
                clearingFeeIndicatorOffset = valueOffset;
                clearingFeeIndicatorLength = valueLength;
                break;

            case Constants.HANDL_INST:
                hasHandlInst = true;
                handlInst = buffer.getChar(valueOffset);
                break;

            case Constants.EXEC_INST:
                hasExecInst = true;
                execInst = buffer.getChars(execInst, valueOffset, valueLength);
                execInstOffset = valueOffset;
                execInstLength = valueLength;
                break;

            case Constants.MIN_QTY:
                hasMinQty = true;
                minQty = getFloat(buffer, minQty, valueOffset, valueLength, 110, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.MAX_FLOOR:
                hasMaxFloor = true;
                maxFloor = getFloat(buffer, maxFloor, valueOffset, valueLength, 111, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.EX_DESTINATION:
                hasExDestination = true;
                exDestination = buffer.getChars(exDestination, valueOffset, valueLength);
                exDestinationOffset = valueOffset;
                exDestinationLength = valueLength;
                break;

            case Constants.NO_TRADING_SESSIONS_GROUP_COUNTER:
                hasNoTradingSessionsGroupCounter = true;
                noTradingSessionsGroupCounter = getInt(buffer, valueOffset, endOfField, 386, CODEC_VALIDATION_ENABLED);
                if (tradingSessionsGroup == null)
                {
                    tradingSessionsGroup = new TradingSessionsGroupDecoder(trailer, messageFields);
                }
                TradingSessionsGroupDecoder tradingSessionsGroupCurrent = tradingSessionsGroup;
                position = endOfField + 1;
                final int noTradingSessionsGroupCounter = this.noTradingSessionsGroupCounter;
                for (int i = 0; i < noTradingSessionsGroupCounter && position < end; i++)
                {
                    if (tradingSessionsGroupCurrent != null)
                    {
                        position += tradingSessionsGroupCurrent.decode(buffer, position, end - position);
                        tradingSessionsGroupCurrent = tradingSessionsGroupCurrent.next();
                    }
                }
                if (CODEC_VALIDATION_ENABLED)
                {
                    final int checkEqualsPosition = buffer.scan(position, end, '=');
                    if (checkEqualsPosition != AsciiBuffer.UNKNOWN_INDEX)
                    {
                        final int checkTag = buffer.getInt(position, checkEqualsPosition);
                        if (tradingSessionsGroup.ALL_GROUP_FIELDS.contains(checkTag))
                        {
                            invalidTagId = tag;
                            rejectReason = 16;
                            return position;
                        }
                    }
                }
                break;

            case Constants.PROCESS_CODE:
                hasProcessCode = true;
                processCode = buffer.getChar(valueOffset);
                break;

            case Constants.SYMBOL:
                symbol = buffer.getChars(symbol, valueOffset, valueLength);
                symbolOffset = valueOffset;
                symbolLength = valueLength;
                break;

            case Constants.SYMBOL_SFX:
                hasSymbolSfx = true;
                symbolSfx = buffer.getChars(symbolSfx, valueOffset, valueLength);
                symbolSfxOffset = valueOffset;
                symbolSfxLength = valueLength;
                break;

            case Constants.SECURITY_ID:
                hasSecurityID = true;
                securityID = buffer.getChars(securityID, valueOffset, valueLength);
                securityIDOffset = valueOffset;
                securityIDLength = valueLength;
                break;

            case Constants.SECURITY_ID_SOURCE:
                hasSecurityIDSource = true;
                securityIDSource = buffer.getChars(securityIDSource, valueOffset, valueLength);
                securityIDSourceOffset = valueOffset;
                securityIDSourceLength = valueLength;
                break;

            case Constants.NO_SECURITY_ALT_ID_GROUP_COUNTER:
                hasNoSecurityAltIDGroupCounter = true;
                noSecurityAltIDGroupCounter = getInt(buffer, valueOffset, endOfField, 454, CODEC_VALIDATION_ENABLED);
                if (securityAltIDGroup == null)
                {
                    securityAltIDGroup = new SecurityAltIDGroupDecoder(trailer, messageFields);
                }
                SecurityAltIDGroupDecoder securityAltIDGroupCurrent = securityAltIDGroup;
                position = endOfField + 1;
                final int noSecurityAltIDGroupCounter = this.noSecurityAltIDGroupCounter;
                for (int i = 0; i < noSecurityAltIDGroupCounter && position < end; i++)
                {
                    if (securityAltIDGroupCurrent != null)
                    {
                        position += securityAltIDGroupCurrent.decode(buffer, position, end - position);
                        securityAltIDGroupCurrent = securityAltIDGroupCurrent.next();
                    }
                }
                if (CODEC_VALIDATION_ENABLED)
                {
                    final int checkEqualsPosition = buffer.scan(position, end, '=');
                    if (checkEqualsPosition != AsciiBuffer.UNKNOWN_INDEX)
                    {
                        final int checkTag = buffer.getInt(position, checkEqualsPosition);
                        if (securityAltIDGroup.ALL_GROUP_FIELDS.contains(checkTag))
                        {
                            invalidTagId = tag;
                            rejectReason = 16;
                            return position;
                        }
                    }
                }
                break;

            case Constants.PRODUCT:
                hasProduct = true;
                product = getInt(buffer, valueOffset, endOfField, 460, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.C_F_I_CODE:
                hasCFICode = true;
                cFICode = buffer.getChars(cFICode, valueOffset, valueLength);
                cFICodeOffset = valueOffset;
                cFICodeLength = valueLength;
                break;

            case Constants.SECURITY_TYPE:
                hasSecurityType = true;
                securityType = buffer.getChars(securityType, valueOffset, valueLength);
                securityTypeOffset = valueOffset;
                securityTypeLength = valueLength;
                break;

            case Constants.SECURITY_SUB_TYPE:
                hasSecuritySubType = true;
                securitySubType = buffer.getChars(securitySubType, valueOffset, valueLength);
                securitySubTypeOffset = valueOffset;
                securitySubTypeLength = valueLength;
                break;

            case Constants.MATURITY_MONTH_YEAR:
                hasMaturityMonthYear = true;
                maturityMonthYear = buffer.getBytes(maturityMonthYear, valueOffset, valueLength);
                maturityMonthYearOffset = valueOffset;
                maturityMonthYearLength = valueLength;
                break;

            case Constants.MATURITY_DATE:
                hasMaturityDate = true;
                maturityDate = buffer.getBytes(maturityDate, valueOffset, valueLength);
                maturityDateOffset = valueOffset;
                maturityDateLength = valueLength;
                break;

            case Constants.COUPON_PAYMENT_DATE:
                hasCouponPaymentDate = true;
                couponPaymentDate = buffer.getBytes(couponPaymentDate, valueOffset, valueLength);
                couponPaymentDateOffset = valueOffset;
                couponPaymentDateLength = valueLength;
                break;

            case Constants.ISSUE_DATE:
                hasIssueDate = true;
                issueDate = buffer.getBytes(issueDate, valueOffset, valueLength);
                issueDateOffset = valueOffset;
                issueDateLength = valueLength;
                break;

            case Constants.REPO_COLLATERAL_SECURITY_TYPE:
                hasRepoCollateralSecurityType = true;
                repoCollateralSecurityType = getInt(buffer, valueOffset, endOfField, 239, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.REPURCHASE_TERM:
                hasRepurchaseTerm = true;
                repurchaseTerm = getInt(buffer, valueOffset, endOfField, 226, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.REPURCHASE_RATE:
                hasRepurchaseRate = true;
                repurchaseRate = getFloat(buffer, repurchaseRate, valueOffset, valueLength, 227, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.FACTOR:
                hasFactor = true;
                factor = getFloat(buffer, factor, valueOffset, valueLength, 228, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.CREDIT_RATING:
                hasCreditRating = true;
                creditRating = buffer.getChars(creditRating, valueOffset, valueLength);
                creditRatingOffset = valueOffset;
                creditRatingLength = valueLength;
                break;

            case Constants.INSTR_REGISTRY:
                hasInstrRegistry = true;
                instrRegistry = buffer.getChars(instrRegistry, valueOffset, valueLength);
                instrRegistryOffset = valueOffset;
                instrRegistryLength = valueLength;
                break;

            case Constants.COUNTRY_OF_ISSUE:
                hasCountryOfIssue = true;
                countryOfIssue = buffer.getChars(countryOfIssue, valueOffset, valueLength);
                countryOfIssueOffset = valueOffset;
                countryOfIssueLength = valueLength;
                break;

            case Constants.STATE_OR_PROVINCE_OF_ISSUE:
                hasStateOrProvinceOfIssue = true;
                stateOrProvinceOfIssue = buffer.getChars(stateOrProvinceOfIssue, valueOffset, valueLength);
                stateOrProvinceOfIssueOffset = valueOffset;
                stateOrProvinceOfIssueLength = valueLength;
                break;

            case Constants.LOCALE_OF_ISSUE:
                hasLocaleOfIssue = true;
                localeOfIssue = buffer.getChars(localeOfIssue, valueOffset, valueLength);
                localeOfIssueOffset = valueOffset;
                localeOfIssueLength = valueLength;
                break;

            case Constants.REDEMPTION_DATE:
                hasRedemptionDate = true;
                redemptionDate = buffer.getBytes(redemptionDate, valueOffset, valueLength);
                redemptionDateOffset = valueOffset;
                redemptionDateLength = valueLength;
                break;

            case Constants.STRIKE_PRICE:
                hasStrikePrice = true;
                strikePrice = getFloat(buffer, strikePrice, valueOffset, valueLength, 202, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.STRIKE_CURRENCY:
                hasStrikeCurrency = true;
                strikeCurrency = buffer.getChars(strikeCurrency, valueOffset, valueLength);
                strikeCurrencyOffset = valueOffset;
                strikeCurrencyLength = valueLength;
                break;

            case Constants.OPT_ATTRIBUTE:
                hasOptAttribute = true;
                optAttribute = buffer.getChar(valueOffset);
                break;

            case Constants.CONTRACT_MULTIPLIER:
                hasContractMultiplier = true;
                contractMultiplier = getFloat(buffer, contractMultiplier, valueOffset, valueLength, 231, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.COUPON_RATE:
                hasCouponRate = true;
                couponRate = getFloat(buffer, couponRate, valueOffset, valueLength, 223, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.SECURITY_EXCHANGE:
                hasSecurityExchange = true;
                securityExchange = buffer.getChars(securityExchange, valueOffset, valueLength);
                securityExchangeOffset = valueOffset;
                securityExchangeLength = valueLength;
                break;

            case Constants.ISSUER:
                hasIssuer = true;
                issuer = buffer.getChars(issuer, valueOffset, valueLength);
                issuerOffset = valueOffset;
                issuerLength = valueLength;
                break;

            case Constants.ENCODED_ISSUER_LEN:
                hasEncodedIssuerLen = true;
                encodedIssuerLen = getInt(buffer, valueOffset, endOfField, 348, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.ENCODED_ISSUER:
                hasEncodedIssuer = true;
                encodedIssuer = buffer.getBytes(encodedIssuer, valueOffset, encodedIssuerLen);
                endOfField = valueOffset + encodedIssuerLen;
                break;

            case Constants.SECURITY_DESC:
                hasSecurityDesc = true;
                securityDesc = buffer.getChars(securityDesc, valueOffset, valueLength);
                securityDescOffset = valueOffset;
                securityDescLength = valueLength;
                break;

            case Constants.ENCODED_SECURITY_DESC_LEN:
                hasEncodedSecurityDescLen = true;
                encodedSecurityDescLen = getInt(buffer, valueOffset, endOfField, 350, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.ENCODED_SECURITY_DESC:
                hasEncodedSecurityDesc = true;
                encodedSecurityDesc = buffer.getBytes(encodedSecurityDesc, valueOffset, encodedSecurityDescLen);
                endOfField = valueOffset + encodedSecurityDescLen;
                break;

            case Constants.POOL:
                hasPool = true;
                pool = buffer.getChars(pool, valueOffset, valueLength);
                poolOffset = valueOffset;
                poolLength = valueLength;
                break;

            case Constants.CONTRACT_SETTL_MONTH:
                hasContractSettlMonth = true;
                contractSettlMonth = buffer.getBytes(contractSettlMonth, valueOffset, valueLength);
                contractSettlMonthOffset = valueOffset;
                contractSettlMonthLength = valueLength;
                break;

            case Constants.C_P_PROGRAM:
                hasCPProgram = true;
                cPProgram = getInt(buffer, valueOffset, endOfField, 875, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.C_P_REG_TYPE:
                hasCPRegType = true;
                cPRegType = buffer.getChars(cPRegType, valueOffset, valueLength);
                cPRegTypeOffset = valueOffset;
                cPRegTypeLength = valueLength;
                break;

            case Constants.NO_EVENTS_GROUP_COUNTER:
                hasNoEventsGroupCounter = true;
                noEventsGroupCounter = getInt(buffer, valueOffset, endOfField, 864, CODEC_VALIDATION_ENABLED);
                if (eventsGroup == null)
                {
                    eventsGroup = new EventsGroupDecoder(trailer, messageFields);
                }
                EventsGroupDecoder eventsGroupCurrent = eventsGroup;
                position = endOfField + 1;
                final int noEventsGroupCounter = this.noEventsGroupCounter;
                for (int i = 0; i < noEventsGroupCounter && position < end; i++)
                {
                    if (eventsGroupCurrent != null)
                    {
                        position += eventsGroupCurrent.decode(buffer, position, end - position);
                        eventsGroupCurrent = eventsGroupCurrent.next();
                    }
                }
                if (CODEC_VALIDATION_ENABLED)
                {
                    final int checkEqualsPosition = buffer.scan(position, end, '=');
                    if (checkEqualsPosition != AsciiBuffer.UNKNOWN_INDEX)
                    {
                        final int checkTag = buffer.getInt(position, checkEqualsPosition);
                        if (eventsGroup.ALL_GROUP_FIELDS.contains(checkTag))
                        {
                            invalidTagId = tag;
                            rejectReason = 16;
                            return position;
                        }
                    }
                }
                break;

            case Constants.DATED_DATE:
                hasDatedDate = true;
                datedDate = buffer.getBytes(datedDate, valueOffset, valueLength);
                datedDateOffset = valueOffset;
                datedDateLength = valueLength;
                break;

            case Constants.INTEREST_ACCRUAL_DATE:
                hasInterestAccrualDate = true;
                interestAccrualDate = buffer.getBytes(interestAccrualDate, valueOffset, valueLength);
                interestAccrualDateOffset = valueOffset;
                interestAccrualDateLength = valueLength;
                break;


            case Constants.NO_UNDERLYINGS_GROUP_COUNTER:
                hasNoUnderlyingsGroupCounter = true;
                noUnderlyingsGroupCounter = getInt(buffer, valueOffset, endOfField, 711, CODEC_VALIDATION_ENABLED);
                if (underlyingsGroup == null)
                {
                    underlyingsGroup = new UnderlyingsGroupDecoder(trailer, messageFields);
                }
                UnderlyingsGroupDecoder underlyingsGroupCurrent = underlyingsGroup;
                position = endOfField + 1;
                final int noUnderlyingsGroupCounter = this.noUnderlyingsGroupCounter;
                for (int i = 0; i < noUnderlyingsGroupCounter && position < end; i++)
                {
                    if (underlyingsGroupCurrent != null)
                    {
                        position += underlyingsGroupCurrent.decode(buffer, position, end - position);
                        underlyingsGroupCurrent = underlyingsGroupCurrent.next();
                    }
                }
                if (CODEC_VALIDATION_ENABLED)
                {
                    final int checkEqualsPosition = buffer.scan(position, end, '=');
                    if (checkEqualsPosition != AsciiBuffer.UNKNOWN_INDEX)
                    {
                        final int checkTag = buffer.getInt(position, checkEqualsPosition);
                        if (underlyingsGroup.ALL_GROUP_FIELDS.contains(checkTag))
                        {
                            invalidTagId = tag;
                            rejectReason = 16;
                            return position;
                        }
                    }
                }
                break;

            case Constants.PREV_CLOSE_PX:
                hasPrevClosePx = true;
                prevClosePx = getFloat(buffer, prevClosePx, valueOffset, valueLength, 140, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.SIDE:
                side = buffer.getChar(valueOffset);
                break;

            case Constants.SIDE_VALUE_IND:
                hasSideValueInd = true;
                sideValueInd = getInt(buffer, valueOffset, endOfField, 401, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.LOCATE_REQD:
                hasLocateReqd = true;
                locateReqd = buffer.getBoolean(valueOffset);
                break;

            case Constants.TRANSACT_TIME:
                hasTransactTime = true;
                transactTime = buffer.getBytes(transactTime, valueOffset, valueLength);
                transactTimeOffset = valueOffset;
                transactTimeLength = valueLength;
                break;

            case Constants.NO_STIPULATIONS_GROUP_COUNTER:
                hasNoStipulationsGroupCounter = true;
                noStipulationsGroupCounter = getInt(buffer, valueOffset, endOfField, 232, CODEC_VALIDATION_ENABLED);
                if (stipulationsGroup == null)
                {
                    stipulationsGroup = new StipulationsGroupDecoder(trailer, messageFields);
                }
                StipulationsGroupDecoder stipulationsGroupCurrent = stipulationsGroup;
                position = endOfField + 1;
                final int noStipulationsGroupCounter = this.noStipulationsGroupCounter;
                for (int i = 0; i < noStipulationsGroupCounter && position < end; i++)
                {
                    if (stipulationsGroupCurrent != null)
                    {
                        position += stipulationsGroupCurrent.decode(buffer, position, end - position);
                        stipulationsGroupCurrent = stipulationsGroupCurrent.next();
                    }
                }
                if (CODEC_VALIDATION_ENABLED)
                {
                    final int checkEqualsPosition = buffer.scan(position, end, '=');
                    if (checkEqualsPosition != AsciiBuffer.UNKNOWN_INDEX)
                    {
                        final int checkTag = buffer.getInt(position, checkEqualsPosition);
                        if (stipulationsGroup.ALL_GROUP_FIELDS.contains(checkTag))
                        {
                            invalidTagId = tag;
                            rejectReason = 16;
                            return position;
                        }
                    }
                }
                break;


            case Constants.QTY_TYPE:
                hasQtyType = true;
                qtyType = getInt(buffer, valueOffset, endOfField, 854, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.ORDER_QTY:
                hasOrderQty = true;
                orderQty = getFloat(buffer, orderQty, valueOffset, valueLength, 38, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.CASH_ORDER_QTY:
                hasCashOrderQty = true;
                cashOrderQty = getFloat(buffer, cashOrderQty, valueOffset, valueLength, 152, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.ORDER_PERCENT:
                hasOrderPercent = true;
                orderPercent = getFloat(buffer, orderPercent, valueOffset, valueLength, 516, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.ROUNDING_DIRECTION:
                hasRoundingDirection = true;
                roundingDirection = buffer.getChar(valueOffset);
                break;

            case Constants.ROUNDING_MODULUS:
                hasRoundingModulus = true;
                roundingModulus = getFloat(buffer, roundingModulus, valueOffset, valueLength, 469, CODEC_VALIDATION_ENABLED);
                break;


            case Constants.ORD_TYPE:
                hasOrdType = true;
                ordType = buffer.getChar(valueOffset);
                break;

            case Constants.PRICE_TYPE:
                hasPriceType = true;
                priceType = getInt(buffer, valueOffset, endOfField, 423, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.PRICE:
                hasPrice = true;
                price = getFloat(buffer, price, valueOffset, valueLength, 44, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.STOP_PX:
                hasStopPx = true;
                stopPx = getFloat(buffer, stopPx, valueOffset, valueLength, 99, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.SPREAD:
                hasSpread = true;
                spread = getFloat(buffer, spread, valueOffset, valueLength, 218, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.BENCHMARK_CURVE_CURRENCY:
                hasBenchmarkCurveCurrency = true;
                benchmarkCurveCurrency = buffer.getChars(benchmarkCurveCurrency, valueOffset, valueLength);
                benchmarkCurveCurrencyOffset = valueOffset;
                benchmarkCurveCurrencyLength = valueLength;
                break;

            case Constants.BENCHMARK_CURVE_NAME:
                hasBenchmarkCurveName = true;
                benchmarkCurveName = buffer.getChars(benchmarkCurveName, valueOffset, valueLength);
                benchmarkCurveNameOffset = valueOffset;
                benchmarkCurveNameLength = valueLength;
                break;

            case Constants.BENCHMARK_CURVE_POINT:
                hasBenchmarkCurvePoint = true;
                benchmarkCurvePoint = buffer.getChars(benchmarkCurvePoint, valueOffset, valueLength);
                benchmarkCurvePointOffset = valueOffset;
                benchmarkCurvePointLength = valueLength;
                break;

            case Constants.BENCHMARK_PRICE:
                hasBenchmarkPrice = true;
                benchmarkPrice = getFloat(buffer, benchmarkPrice, valueOffset, valueLength, 662, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.BENCHMARK_PRICE_TYPE:
                hasBenchmarkPriceType = true;
                benchmarkPriceType = getInt(buffer, valueOffset, endOfField, 663, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.BENCHMARK_SECURITY_ID:
                hasBenchmarkSecurityID = true;
                benchmarkSecurityID = buffer.getChars(benchmarkSecurityID, valueOffset, valueLength);
                benchmarkSecurityIDOffset = valueOffset;
                benchmarkSecurityIDLength = valueLength;
                break;

            case Constants.BENCHMARK_SECURITY_ID_SOURCE:
                hasBenchmarkSecurityIDSource = true;
                benchmarkSecurityIDSource = buffer.getChars(benchmarkSecurityIDSource, valueOffset, valueLength);
                benchmarkSecurityIDSourceOffset = valueOffset;
                benchmarkSecurityIDSourceLength = valueLength;
                break;


            case Constants.YIELD_TYPE:
                hasYieldType = true;
                yieldType = buffer.getChars(yieldType, valueOffset, valueLength);
                yieldTypeOffset = valueOffset;
                yieldTypeLength = valueLength;
                break;

            case Constants.YIELD:
                hasYield = true;
                yield = getFloat(buffer, yield, valueOffset, valueLength, 236, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.YIELD_CALC_DATE:
                hasYieldCalcDate = true;
                yieldCalcDate = buffer.getBytes(yieldCalcDate, valueOffset, valueLength);
                yieldCalcDateOffset = valueOffset;
                yieldCalcDateLength = valueLength;
                break;

            case Constants.YIELD_REDEMPTION_DATE:
                hasYieldRedemptionDate = true;
                yieldRedemptionDate = buffer.getBytes(yieldRedemptionDate, valueOffset, valueLength);
                yieldRedemptionDateOffset = valueOffset;
                yieldRedemptionDateLength = valueLength;
                break;

            case Constants.YIELD_REDEMPTION_PRICE:
                hasYieldRedemptionPrice = true;
                yieldRedemptionPrice = getFloat(buffer, yieldRedemptionPrice, valueOffset, valueLength, 697, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.YIELD_REDEMPTION_PRICE_TYPE:
                hasYieldRedemptionPriceType = true;
                yieldRedemptionPriceType = getInt(buffer, valueOffset, endOfField, 698, CODEC_VALIDATION_ENABLED);
                break;


            case Constants.CURRENCY:
                hasCurrency = true;
                currency = buffer.getChars(currency, valueOffset, valueLength);
                currencyOffset = valueOffset;
                currencyLength = valueLength;
                break;

            case Constants.COMPLIANCE_ID:
                hasComplianceID = true;
                complianceID = buffer.getChars(complianceID, valueOffset, valueLength);
                complianceIDOffset = valueOffset;
                complianceIDLength = valueLength;
                break;

            case Constants.SOLICITED_FLAG:
                hasSolicitedFlag = true;
                solicitedFlag = buffer.getBoolean(valueOffset);
                break;

            case Constants.I_O_IID:
                hasIOIid = true;
                iOIid = buffer.getChars(iOIid, valueOffset, valueLength);
                iOIidOffset = valueOffset;
                iOIidLength = valueLength;
                break;

            case Constants.QUOTE_ID:
                hasQuoteID = true;
                quoteID = buffer.getChars(quoteID, valueOffset, valueLength);
                quoteIDOffset = valueOffset;
                quoteIDLength = valueLength;
                break;

            case Constants.TIME_IN_FORCE:
                hasTimeInForce = true;
                timeInForce = buffer.getChar(valueOffset);
                break;

            case Constants.EFFECTIVE_TIME:
                hasEffectiveTime = true;
                effectiveTime = buffer.getBytes(effectiveTime, valueOffset, valueLength);
                effectiveTimeOffset = valueOffset;
                effectiveTimeLength = valueLength;
                break;

            case Constants.EXPIRE_DATE:
                hasExpireDate = true;
                expireDate = buffer.getBytes(expireDate, valueOffset, valueLength);
                expireDateOffset = valueOffset;
                expireDateLength = valueLength;
                break;

            case Constants.EXPIRE_TIME:
                hasExpireTime = true;
                expireTime = buffer.getBytes(expireTime, valueOffset, valueLength);
                expireTimeOffset = valueOffset;
                expireTimeLength = valueLength;
                break;

            case Constants.G_T_BOOKING_INST:
                hasGTBookingInst = true;
                gTBookingInst = getInt(buffer, valueOffset, endOfField, 427, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.COMMISSION:
                hasCommission = true;
                commission = getFloat(buffer, commission, valueOffset, valueLength, 12, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.COMM_TYPE:
                hasCommType = true;
                commType = buffer.getChar(valueOffset);
                break;

            case Constants.COMM_CURRENCY:
                hasCommCurrency = true;
                commCurrency = buffer.getChars(commCurrency, valueOffset, valueLength);
                commCurrencyOffset = valueOffset;
                commCurrencyLength = valueLength;
                break;

            case Constants.FUND_RENEW_WAIV:
                hasFundRenewWaiv = true;
                fundRenewWaiv = buffer.getChar(valueOffset);
                break;


            case Constants.ORDER_CAPACITY:
                hasOrderCapacity = true;
                orderCapacity = buffer.getChar(valueOffset);
                break;

            case Constants.ORDER_RESTRICTIONS:
                hasOrderRestrictions = true;
                orderRestrictions = buffer.getChars(orderRestrictions, valueOffset, valueLength);
                orderRestrictionsOffset = valueOffset;
                orderRestrictionsLength = valueLength;
                break;

            case Constants.CUST_ORDER_CAPACITY:
                hasCustOrderCapacity = true;
                custOrderCapacity = getInt(buffer, valueOffset, endOfField, 582, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.FOREX_REQ:
                hasForexReq = true;
                forexReq = buffer.getBoolean(valueOffset);
                break;

            case Constants.SETTL_CURRENCY:
                hasSettlCurrency = true;
                settlCurrency = buffer.getChars(settlCurrency, valueOffset, valueLength);
                settlCurrencyOffset = valueOffset;
                settlCurrencyLength = valueLength;
                break;

            case Constants.BOOKING_TYPE:
                hasBookingType = true;
                bookingType = getInt(buffer, valueOffset, endOfField, 775, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.TEXT:
                hasText = true;
                text = buffer.getChars(text, valueOffset, valueLength);
                textOffset = valueOffset;
                textLength = valueLength;
                break;

            case Constants.ENCODED_TEXT_LEN:
                hasEncodedTextLen = true;
                encodedTextLen = getInt(buffer, valueOffset, endOfField, 354, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.ENCODED_TEXT:
                hasEncodedText = true;
                encodedText = buffer.getBytes(encodedText, valueOffset, encodedTextLen);
                endOfField = valueOffset + encodedTextLen;
                break;

            case Constants.SETTL_DATE2:
                hasSettlDate2 = true;
                settlDate2 = buffer.getBytes(settlDate2, valueOffset, valueLength);
                settlDate2Offset = valueOffset;
                settlDate2Length = valueLength;
                break;

            case Constants.ORDER_QTY2:
                hasOrderQty2 = true;
                orderQty2 = getFloat(buffer, orderQty2, valueOffset, valueLength, 192, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.PRICE2:
                hasPrice2 = true;
                price2 = getFloat(buffer, price2, valueOffset, valueLength, 640, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.POSITION_EFFECT:
                hasPositionEffect = true;
                positionEffect = buffer.getChar(valueOffset);
                break;

            case Constants.COVERED_OR_UNCOVERED:
                hasCoveredOrUncovered = true;
                coveredOrUncovered = getInt(buffer, valueOffset, endOfField, 203, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.MAX_SHOW:
                hasMaxShow = true;
                maxShow = getFloat(buffer, maxShow, valueOffset, valueLength, 210, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.PEG_OFFSET_VALUE:
                hasPegOffsetValue = true;
                pegOffsetValue = getFloat(buffer, pegOffsetValue, valueOffset, valueLength, 211, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.PEG_MOVE_TYPE:
                hasPegMoveType = true;
                pegMoveType = getInt(buffer, valueOffset, endOfField, 835, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.PEG_OFFSET_TYPE:
                hasPegOffsetType = true;
                pegOffsetType = getInt(buffer, valueOffset, endOfField, 836, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.PEG_LIMIT_TYPE:
                hasPegLimitType = true;
                pegLimitType = getInt(buffer, valueOffset, endOfField, 837, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.PEG_ROUND_DIRECTION:
                hasPegRoundDirection = true;
                pegRoundDirection = getInt(buffer, valueOffset, endOfField, 838, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.PEG_SCOPE:
                hasPegScope = true;
                pegScope = getInt(buffer, valueOffset, endOfField, 840, CODEC_VALIDATION_ENABLED);
                break;


            case Constants.DISCRETION_INST:
                hasDiscretionInst = true;
                discretionInst = buffer.getChar(valueOffset);
                break;

            case Constants.DISCRETION_OFFSET_VALUE:
                hasDiscretionOffsetValue = true;
                discretionOffsetValue = getFloat(buffer, discretionOffsetValue, valueOffset, valueLength, 389, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.DISCRETION_MOVE_TYPE:
                hasDiscretionMoveType = true;
                discretionMoveType = getInt(buffer, valueOffset, endOfField, 841, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.DISCRETION_OFFSET_TYPE:
                hasDiscretionOffsetType = true;
                discretionOffsetType = getInt(buffer, valueOffset, endOfField, 842, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.DISCRETION_LIMIT_TYPE:
                hasDiscretionLimitType = true;
                discretionLimitType = getInt(buffer, valueOffset, endOfField, 843, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.DISCRETION_ROUND_DIRECTION:
                hasDiscretionRoundDirection = true;
                discretionRoundDirection = getInt(buffer, valueOffset, endOfField, 844, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.DISCRETION_SCOPE:
                hasDiscretionScope = true;
                discretionScope = getInt(buffer, valueOffset, endOfField, 846, CODEC_VALIDATION_ENABLED);
                break;


            case Constants.TARGET_STRATEGY:
                hasTargetStrategy = true;
                targetStrategy = getInt(buffer, valueOffset, endOfField, 847, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.TARGET_STRATEGY_PARAMETERS:
                hasTargetStrategyParameters = true;
                targetStrategyParameters = buffer.getChars(targetStrategyParameters, valueOffset, valueLength);
                targetStrategyParametersOffset = valueOffset;
                targetStrategyParametersLength = valueLength;
                break;

            case Constants.PARTICIPATION_RATE:
                hasParticipationRate = true;
                participationRate = getFloat(buffer, participationRate, valueOffset, valueLength, 849, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.DESIGNATION:
                hasDesignation = true;
                designation = buffer.getChars(designation, valueOffset, valueLength);
                designationOffset = valueOffset;
                designationLength = valueLength;
                break;

            default:
                if (!CODEC_REJECT_UNKNOWN_FIELD_ENABLED)
                {
                    seenFields.remove(tag);
                }
                if (CODEC_REJECT_UNKNOWN_FIELD_ENABLED || (trailer.REQUIRED_FIELDS.contains(tag) || messageFields.contains(tag)))
                {
                    return position - offset;
                }

            }

            if (position < (endOfField + 1))
            {
                position = endOfField + 1;
            }
        }
        return position - offset;
    }

    public void reset()
    {
        this.resetClOrdID();
        this.resetSecondaryClOrdID();
        this.resetListSeqNo();
        this.resetClOrdLinkID();
        this.resetSettlInstMode();
        this.resetTradeOriginationDate();
        this.resetTradeDate();
        this.resetAccount();
        this.resetAcctIDSource();
        this.resetAccountType();
        this.resetDayBookingInst();
        this.resetBookingUnit();
        this.resetAllocID();
        this.resetPreallocMethod();
        this.resetSettlType();
        this.resetSettlDate();
        this.resetCashMargin();
        this.resetClearingFeeIndicator();
        this.resetHandlInst();
        this.resetExecInst();
        this.resetMinQty();
        this.resetMaxFloor();
        this.resetExDestination();
        this.resetProcessCode();
        this.resetPrevClosePx();
        this.resetSide();
        this.resetSideValueInd();
        this.resetLocateReqd();
        this.resetTransactTime();
        this.resetQtyType();
        this.resetOrdType();
        this.resetPriceType();
        this.resetPrice();
        this.resetStopPx();
        this.resetCurrency();
        this.resetComplianceID();
        this.resetSolicitedFlag();
        this.resetIOIid();
        this.resetQuoteID();
        this.resetTimeInForce();
        this.resetEffectiveTime();
        this.resetExpireDate();
        this.resetExpireTime();
        this.resetGTBookingInst();
        this.resetOrderCapacity();
        this.resetOrderRestrictions();
        this.resetCustOrderCapacity();
        this.resetForexReq();
        this.resetSettlCurrency();
        this.resetBookingType();
        this.resetText();
        this.resetEncodedTextLen();
        this.resetEncodedText();
        this.resetSettlDate2();
        this.resetOrderQty2();
        this.resetPrice2();
        this.resetPositionEffect();
        this.resetCoveredOrUncovered();
        this.resetMaxShow();
        this.resetTargetStrategy();
        this.resetTargetStrategyParameters();
        this.resetParticipationRate();
        this.resetDesignation();
        this.resetPartyIDsGroup();
        this.resetSymbol();
        this.resetSymbolSfx();
        this.resetSecurityID();
        this.resetSecurityIDSource();
        this.resetProduct();
        this.resetCFICode();
        this.resetSecurityType();
        this.resetSecuritySubType();
        this.resetMaturityMonthYear();
        this.resetMaturityDate();
        this.resetCouponPaymentDate();
        this.resetIssueDate();
        this.resetRepoCollateralSecurityType();
        this.resetRepurchaseTerm();
        this.resetRepurchaseRate();
        this.resetFactor();
        this.resetCreditRating();
        this.resetInstrRegistry();
        this.resetCountryOfIssue();
        this.resetStateOrProvinceOfIssue();
        this.resetLocaleOfIssue();
        this.resetRedemptionDate();
        this.resetStrikePrice();
        this.resetStrikeCurrency();
        this.resetOptAttribute();
        this.resetContractMultiplier();
        this.resetCouponRate();
        this.resetSecurityExchange();
        this.resetIssuer();
        this.resetEncodedIssuerLen();
        this.resetEncodedIssuer();
        this.resetSecurityDesc();
        this.resetEncodedSecurityDescLen();
        this.resetEncodedSecurityDesc();
        this.resetPool();
        this.resetContractSettlMonth();
        this.resetCPProgram();
        this.resetCPRegType();
        this.resetDatedDate();
        this.resetInterestAccrualDate();
        this.resetSecurityAltIDGroup();
        this.resetEventsGroup();
        this.resetStipulationsGroup();
        this.resetOrderQty();
        this.resetCashOrderQty();
        this.resetOrderPercent();
        this.resetRoundingDirection();
        this.resetRoundingModulus();
        this.resetSpread();
        this.resetBenchmarkCurveCurrency();
        this.resetBenchmarkCurveName();
        this.resetBenchmarkCurvePoint();
        this.resetBenchmarkPrice();
        this.resetBenchmarkPriceType();
        this.resetBenchmarkSecurityID();
        this.resetBenchmarkSecurityIDSource();
        this.resetYieldType();
        this.resetYield();
        this.resetYieldCalcDate();
        this.resetYieldRedemptionDate();
        this.resetYieldRedemptionPrice();
        this.resetYieldRedemptionPriceType();
        this.resetCommission();
        this.resetCommType();
        this.resetCommCurrency();
        this.resetFundRenewWaiv();
        this.resetPegOffsetValue();
        this.resetPegMoveType();
        this.resetPegOffsetType();
        this.resetPegLimitType();
        this.resetPegRoundDirection();
        this.resetPegScope();
        this.resetDiscretionInst();
        this.resetDiscretionOffsetValue();
        this.resetDiscretionMoveType();
        this.resetDiscretionOffsetType();
        this.resetDiscretionLimitType();
        this.resetDiscretionRoundDirection();
        this.resetDiscretionScope();
        this.resetAllocsGroup();
        this.resetTradingSessionsGroup();
        this.resetUnderlyingsGroup();
        buffer = null;
        if (CODEC_VALIDATION_ENABLED)
        {
            invalidTagId = Decoder.NO_ERROR;
            rejectReason = Decoder.NO_ERROR;
            missingRequiredFields.clear();
        }
    }

    public void resetClOrdID()
    {
        clOrdIDOffset = 0;
        clOrdIDLength = 0;
    }

    public void resetSecondaryClOrdID()
    {
        hasSecondaryClOrdID = false;
    }

    public void resetListSeqNo()
    {
        listSeqNo = MISSING_INT;
    }

    public void resetClOrdLinkID()
    {
        hasClOrdLinkID = false;
    }

    public void resetSettlInstMode()
    {
        hasSettlInstMode = false;
    }

    public void resetTradeOriginationDate()
    {
        hasTradeOriginationDate = false;
    }

    public void resetTradeDate()
    {
        hasTradeDate = false;
    }

    public void resetAccount()
    {
        hasAccount = false;
    }

    public void resetAcctIDSource()
    {
        hasAcctIDSource = false;
    }

    public void resetAccountType()
    {
        hasAccountType = false;
    }

    public void resetDayBookingInst()
    {
        hasDayBookingInst = false;
    }

    public void resetBookingUnit()
    {
        hasBookingUnit = false;
    }

    public void resetAllocID()
    {
        hasAllocID = false;
    }

    public void resetPreallocMethod()
    {
        hasPreallocMethod = false;
    }

    public void resetSettlType()
    {
        hasSettlType = false;
    }

    public void resetSettlDate()
    {
        hasSettlDate = false;
    }

    public void resetCashMargin()
    {
        hasCashMargin = false;
    }

    public void resetClearingFeeIndicator()
    {
        hasClearingFeeIndicator = false;
    }

    public void resetHandlInst()
    {
        hasHandlInst = false;
    }

    public void resetExecInst()
    {
        hasExecInst = false;
    }

    public void resetMinQty()
    {
        hasMinQty = false;
    }

    public void resetMaxFloor()
    {
        hasMaxFloor = false;
    }

    public void resetExDestination()
    {
        hasExDestination = false;
    }

    public void resetProcessCode()
    {
        hasProcessCode = false;
    }

    public void resetPrevClosePx()
    {
        hasPrevClosePx = false;
    }

    public void resetSide()
    {
        side = MISSING_CHAR;
    }

    public void resetSideValueInd()
    {
        hasSideValueInd = false;
    }

    public void resetLocateReqd()
    {
        hasLocateReqd = false;
    }

    public void resetTransactTime()
    {
        hasTransactTime = false;
    }

    public void resetQtyType()
    {
        hasQtyType = false;
    }

    public void resetOrdType()
    {
        hasOrdType = false;
    }

    public void resetPriceType()
    {
        hasPriceType = false;
    }

    public void resetPrice()
    {
        hasPrice = false;
    }

    public void resetStopPx()
    {
        hasStopPx = false;
    }

    public void resetCurrency()
    {
        hasCurrency = false;
    }

    public void resetComplianceID()
    {
        hasComplianceID = false;
    }

    public void resetSolicitedFlag()
    {
        hasSolicitedFlag = false;
    }

    public void resetIOIid()
    {
        hasIOIid = false;
    }

    public void resetQuoteID()
    {
        hasQuoteID = false;
    }

    public void resetTimeInForce()
    {
        hasTimeInForce = false;
    }

    public void resetEffectiveTime()
    {
        hasEffectiveTime = false;
    }

    public void resetExpireDate()
    {
        hasExpireDate = false;
    }

    public void resetExpireTime()
    {
        hasExpireTime = false;
    }

    public void resetGTBookingInst()
    {
        hasGTBookingInst = false;
    }

    public void resetOrderCapacity()
    {
        hasOrderCapacity = false;
    }

    public void resetOrderRestrictions()
    {
        hasOrderRestrictions = false;
    }

    public void resetCustOrderCapacity()
    {
        hasCustOrderCapacity = false;
    }

    public void resetForexReq()
    {
        hasForexReq = false;
    }

    public void resetSettlCurrency()
    {
        hasSettlCurrency = false;
    }

    public void resetBookingType()
    {
        hasBookingType = false;
    }

    public void resetText()
    {
        hasText = false;
    }

    public void resetEncodedTextLen()
    {
        hasEncodedTextLen = false;
    }

    public void resetEncodedText()
    {
        hasEncodedText = false;
    }

    public void resetSettlDate2()
    {
        hasSettlDate2 = false;
    }

    public void resetOrderQty2()
    {
        hasOrderQty2 = false;
    }

    public void resetPrice2()
    {
        hasPrice2 = false;
    }

    public void resetPositionEffect()
    {
        hasPositionEffect = false;
    }

    public void resetCoveredOrUncovered()
    {
        hasCoveredOrUncovered = false;
    }

    public void resetMaxShow()
    {
        hasMaxShow = false;
    }

    public void resetTargetStrategy()
    {
        hasTargetStrategy = false;
    }

    public void resetTargetStrategyParameters()
    {
        hasTargetStrategyParameters = false;
    }

    public void resetParticipationRate()
    {
        hasParticipationRate = false;
    }

    public void resetDesignation()
    {
        hasDesignation = false;
    }

    public void resetPartyIDsGroup()
    {
        for (final PartyIDsGroupDecoder partyIDsGroupDecoder : partyIDsGroupIterator.iterator())
        {
            partyIDsGroupDecoder.reset();
            if (partyIDsGroupDecoder.next() == null)
            {
                break;
            }
        }
        noPartyIDsGroupCounter = MISSING_INT;
        hasNoPartyIDsGroupCounter = false;
    }

    public void resetSymbol()
    {
        symbolOffset = 0;
        symbolLength = 0;
    }

    public void resetSymbolSfx()
    {
        hasSymbolSfx = false;
    }

    public void resetSecurityID()
    {
        hasSecurityID = false;
    }

    public void resetSecurityIDSource()
    {
        hasSecurityIDSource = false;
    }

    public void resetProduct()
    {
        hasProduct = false;
    }

    public void resetCFICode()
    {
        hasCFICode = false;
    }

    public void resetSecurityType()
    {
        hasSecurityType = false;
    }

    public void resetSecuritySubType()
    {
        hasSecuritySubType = false;
    }

    public void resetMaturityMonthYear()
    {
        hasMaturityMonthYear = false;
    }

    public void resetMaturityDate()
    {
        hasMaturityDate = false;
    }

    public void resetCouponPaymentDate()
    {
        hasCouponPaymentDate = false;
    }

    public void resetIssueDate()
    {
        hasIssueDate = false;
    }

    public void resetRepoCollateralSecurityType()
    {
        hasRepoCollateralSecurityType = false;
    }

    public void resetRepurchaseTerm()
    {
        hasRepurchaseTerm = false;
    }

    public void resetRepurchaseRate()
    {
        hasRepurchaseRate = false;
    }

    public void resetFactor()
    {
        hasFactor = false;
    }

    public void resetCreditRating()
    {
        hasCreditRating = false;
    }

    public void resetInstrRegistry()
    {
        hasInstrRegistry = false;
    }

    public void resetCountryOfIssue()
    {
        hasCountryOfIssue = false;
    }

    public void resetStateOrProvinceOfIssue()
    {
        hasStateOrProvinceOfIssue = false;
    }

    public void resetLocaleOfIssue()
    {
        hasLocaleOfIssue = false;
    }

    public void resetRedemptionDate()
    {
        hasRedemptionDate = false;
    }

    public void resetStrikePrice()
    {
        hasStrikePrice = false;
    }

    public void resetStrikeCurrency()
    {
        hasStrikeCurrency = false;
    }

    public void resetOptAttribute()
    {
        hasOptAttribute = false;
    }

    public void resetContractMultiplier()
    {
        hasContractMultiplier = false;
    }

    public void resetCouponRate()
    {
        hasCouponRate = false;
    }

    public void resetSecurityExchange()
    {
        hasSecurityExchange = false;
    }

    public void resetIssuer()
    {
        hasIssuer = false;
    }

    public void resetEncodedIssuerLen()
    {
        hasEncodedIssuerLen = false;
    }

    public void resetEncodedIssuer()
    {
        hasEncodedIssuer = false;
    }

    public void resetSecurityDesc()
    {
        hasSecurityDesc = false;
    }

    public void resetEncodedSecurityDescLen()
    {
        hasEncodedSecurityDescLen = false;
    }

    public void resetEncodedSecurityDesc()
    {
        hasEncodedSecurityDesc = false;
    }

    public void resetPool()
    {
        hasPool = false;
    }

    public void resetContractSettlMonth()
    {
        hasContractSettlMonth = false;
    }

    public void resetCPProgram()
    {
        hasCPProgram = false;
    }

    public void resetCPRegType()
    {
        hasCPRegType = false;
    }

    public void resetDatedDate()
    {
        hasDatedDate = false;
    }

    public void resetInterestAccrualDate()
    {
        hasInterestAccrualDate = false;
    }

    public void resetSecurityAltIDGroup()
    {
        for (final SecurityAltIDGroupDecoder securityAltIDGroupDecoder : securityAltIDGroupIterator.iterator())
        {
            securityAltIDGroupDecoder.reset();
            if (securityAltIDGroupDecoder.next() == null)
            {
                break;
            }
        }
        noSecurityAltIDGroupCounter = MISSING_INT;
        hasNoSecurityAltIDGroupCounter = false;
    }

    public void resetEventsGroup()
    {
        for (final EventsGroupDecoder eventsGroupDecoder : eventsGroupIterator.iterator())
        {
            eventsGroupDecoder.reset();
            if (eventsGroupDecoder.next() == null)
            {
                break;
            }
        }
        noEventsGroupCounter = MISSING_INT;
        hasNoEventsGroupCounter = false;
    }

    public void resetStipulationsGroup()
    {
        for (final StipulationsGroupDecoder stipulationsGroupDecoder : stipulationsGroupIterator.iterator())
        {
            stipulationsGroupDecoder.reset();
            if (stipulationsGroupDecoder.next() == null)
            {
                break;
            }
        }
        noStipulationsGroupCounter = MISSING_INT;
        hasNoStipulationsGroupCounter = false;
    }

    public void resetOrderQty()
    {
        hasOrderQty = false;
    }

    public void resetCashOrderQty()
    {
        hasCashOrderQty = false;
    }

    public void resetOrderPercent()
    {
        hasOrderPercent = false;
    }

    public void resetRoundingDirection()
    {
        hasRoundingDirection = false;
    }

    public void resetRoundingModulus()
    {
        hasRoundingModulus = false;
    }

    public void resetSpread()
    {
        hasSpread = false;
    }

    public void resetBenchmarkCurveCurrency()
    {
        hasBenchmarkCurveCurrency = false;
    }

    public void resetBenchmarkCurveName()
    {
        hasBenchmarkCurveName = false;
    }

    public void resetBenchmarkCurvePoint()
    {
        hasBenchmarkCurvePoint = false;
    }

    public void resetBenchmarkPrice()
    {
        hasBenchmarkPrice = false;
    }

    public void resetBenchmarkPriceType()
    {
        hasBenchmarkPriceType = false;
    }

    public void resetBenchmarkSecurityID()
    {
        hasBenchmarkSecurityID = false;
    }

    public void resetBenchmarkSecurityIDSource()
    {
        hasBenchmarkSecurityIDSource = false;
    }

    public void resetYieldType()
    {
        hasYieldType = false;
    }

    public void resetYield()
    {
        hasYield = false;
    }

    public void resetYieldCalcDate()
    {
        hasYieldCalcDate = false;
    }

    public void resetYieldRedemptionDate()
    {
        hasYieldRedemptionDate = false;
    }

    public void resetYieldRedemptionPrice()
    {
        hasYieldRedemptionPrice = false;
    }

    public void resetYieldRedemptionPriceType()
    {
        hasYieldRedemptionPriceType = false;
    }

    public void resetCommission()
    {
        hasCommission = false;
    }

    public void resetCommType()
    {
        hasCommType = false;
    }

    public void resetCommCurrency()
    {
        hasCommCurrency = false;
    }

    public void resetFundRenewWaiv()
    {
        hasFundRenewWaiv = false;
    }

    public void resetPegOffsetValue()
    {
        hasPegOffsetValue = false;
    }

    public void resetPegMoveType()
    {
        hasPegMoveType = false;
    }

    public void resetPegOffsetType()
    {
        hasPegOffsetType = false;
    }

    public void resetPegLimitType()
    {
        hasPegLimitType = false;
    }

    public void resetPegRoundDirection()
    {
        hasPegRoundDirection = false;
    }

    public void resetPegScope()
    {
        hasPegScope = false;
    }

    public void resetDiscretionInst()
    {
        hasDiscretionInst = false;
    }

    public void resetDiscretionOffsetValue()
    {
        hasDiscretionOffsetValue = false;
    }

    public void resetDiscretionMoveType()
    {
        hasDiscretionMoveType = false;
    }

    public void resetDiscretionOffsetType()
    {
        hasDiscretionOffsetType = false;
    }

    public void resetDiscretionLimitType()
    {
        hasDiscretionLimitType = false;
    }

    public void resetDiscretionRoundDirection()
    {
        hasDiscretionRoundDirection = false;
    }

    public void resetDiscretionScope()
    {
        hasDiscretionScope = false;
    }

    public void resetAllocsGroup()
    {
        for (final AllocsGroupDecoder allocsGroupDecoder : allocsGroupIterator.iterator())
        {
            allocsGroupDecoder.reset();
            if (allocsGroupDecoder.next() == null)
            {
                break;
            }
        }
        noAllocsGroupCounter = MISSING_INT;
        hasNoAllocsGroupCounter = false;
    }

    public void resetTradingSessionsGroup()
    {
        for (final TradingSessionsGroupDecoder tradingSessionsGroupDecoder : tradingSessionsGroupIterator.iterator())
        {
            tradingSessionsGroupDecoder.reset();
            if (tradingSessionsGroupDecoder.next() == null)
            {
                break;
            }
        }
        noTradingSessionsGroupCounter = MISSING_INT;
        hasNoTradingSessionsGroupCounter = false;
    }

    public void resetUnderlyingsGroup()
    {
        for (final UnderlyingsGroupDecoder underlyingsGroupDecoder : underlyingsGroupIterator.iterator())
        {
            underlyingsGroupDecoder.reset();
            if (underlyingsGroupDecoder.next() == null)
            {
                break;
            }
        }
        noUnderlyingsGroupCounter = MISSING_INT;
        hasNoUnderlyingsGroupCounter = false;
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
        builder.append("\"MessageName\": \"OrdersGroup\",\n");
        indent(builder, level);
        builder.append("\"ClOrdID\": \"");
        builder.append(this.clOrdID(), 0, clOrdIDLength());
        builder.append("\",\n");

        if (hasSecondaryClOrdID())
        {
            indent(builder, level);
            builder.append("\"SecondaryClOrdID\": \"");
            builder.append(this.secondaryClOrdID(), 0, secondaryClOrdIDLength());
            builder.append("\",\n");
        }

        indent(builder, level);
        builder.append("\"ListSeqNo\": \"");
        builder.append(listSeqNo);
        builder.append("\",\n");

        if (hasClOrdLinkID())
        {
            indent(builder, level);
            builder.append("\"ClOrdLinkID\": \"");
            builder.append(this.clOrdLinkID(), 0, clOrdLinkIDLength());
            builder.append("\",\n");
        }

        if (hasSettlInstMode())
        {
            indent(builder, level);
            builder.append("\"SettlInstMode\": \"");
            builder.append(settlInstMode);
            builder.append("\",\n");
        }

        if (hasNoPartyIDsGroupCounter)
        {
            indent(builder, level);
            builder.append("\"PartyIDsGroup\": [\n");
            PartyIDsGroupDecoder partyIDsGroup = this.partyIDsGroup;
            for (int i = 0, size = this.noPartyIDsGroupCounter; i < size; i++)
            {
                indent(builder, level);
                partyIDsGroup.appendTo(builder, level + 1);
                if (partyIDsGroup.next() != null)
                {
                    builder.append(',');
                }
                builder.append('\n');
                partyIDsGroup = partyIDsGroup.next();            }
            indent(builder, level);
            builder.append("],\n");
        }

        if (hasTradeOriginationDate())
        {
            indent(builder, level);
            builder.append("\"TradeOriginationDate\": \"");
            appendData(builder, tradeOriginationDate, tradeOriginationDateLength);
            builder.append("\",\n");
        }

        if (hasTradeDate())
        {
            indent(builder, level);
            builder.append("\"TradeDate\": \"");
            appendData(builder, tradeDate, tradeDateLength);
            builder.append("\",\n");
        }

        if (hasAccount())
        {
            indent(builder, level);
            builder.append("\"Account\": \"");
            builder.append(this.account(), 0, accountLength());
            builder.append("\",\n");
        }

        if (hasAcctIDSource())
        {
            indent(builder, level);
            builder.append("\"AcctIDSource\": \"");
            builder.append(acctIDSource);
            builder.append("\",\n");
        }

        if (hasAccountType())
        {
            indent(builder, level);
            builder.append("\"AccountType\": \"");
            builder.append(accountType);
            builder.append("\",\n");
        }

        if (hasDayBookingInst())
        {
            indent(builder, level);
            builder.append("\"DayBookingInst\": \"");
            builder.append(dayBookingInst);
            builder.append("\",\n");
        }

        if (hasBookingUnit())
        {
            indent(builder, level);
            builder.append("\"BookingUnit\": \"");
            builder.append(bookingUnit);
            builder.append("\",\n");
        }

        if (hasAllocID())
        {
            indent(builder, level);
            builder.append("\"AllocID\": \"");
            builder.append(this.allocID(), 0, allocIDLength());
            builder.append("\",\n");
        }

        if (hasPreallocMethod())
        {
            indent(builder, level);
            builder.append("\"PreallocMethod\": \"");
            builder.append(preallocMethod);
            builder.append("\",\n");
        }

        if (hasNoAllocsGroupCounter)
        {
            indent(builder, level);
            builder.append("\"AllocsGroup\": [\n");
            AllocsGroupDecoder allocsGroup = this.allocsGroup;
            for (int i = 0, size = this.noAllocsGroupCounter; i < size; i++)
            {
                indent(builder, level);
                allocsGroup.appendTo(builder, level + 1);
                if (allocsGroup.next() != null)
                {
                    builder.append(',');
                }
                builder.append('\n');
                allocsGroup = allocsGroup.next();            }
            indent(builder, level);
            builder.append("],\n");
        }

        if (hasSettlType())
        {
            indent(builder, level);
            builder.append("\"SettlType\": \"");
            builder.append(settlType);
            builder.append("\",\n");
        }

        if (hasSettlDate())
        {
            indent(builder, level);
            builder.append("\"SettlDate\": \"");
            appendData(builder, settlDate, settlDateLength);
            builder.append("\",\n");
        }

        if (hasCashMargin())
        {
            indent(builder, level);
            builder.append("\"CashMargin\": \"");
            builder.append(cashMargin);
            builder.append("\",\n");
        }

        if (hasClearingFeeIndicator())
        {
            indent(builder, level);
            builder.append("\"ClearingFeeIndicator\": \"");
            builder.append(this.clearingFeeIndicator(), 0, clearingFeeIndicatorLength());
            builder.append("\",\n");
        }

        if (hasHandlInst())
        {
            indent(builder, level);
            builder.append("\"HandlInst\": \"");
            builder.append(handlInst);
            builder.append("\",\n");
        }

        if (hasExecInst())
        {
            indent(builder, level);
            builder.append("\"ExecInst\": \"");
            builder.append(this.execInst(), 0, execInstLength());
            builder.append("\",\n");
        }

        if (hasMinQty())
        {
            indent(builder, level);
            builder.append("\"MinQty\": \"");
            minQty.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasMaxFloor())
        {
            indent(builder, level);
            builder.append("\"MaxFloor\": \"");
            maxFloor.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasExDestination())
        {
            indent(builder, level);
            builder.append("\"ExDestination\": \"");
            builder.append(this.exDestination(), 0, exDestinationLength());
            builder.append("\",\n");
        }

        if (hasNoTradingSessionsGroupCounter)
        {
            indent(builder, level);
            builder.append("\"TradingSessionsGroup\": [\n");
            TradingSessionsGroupDecoder tradingSessionsGroup = this.tradingSessionsGroup;
            for (int i = 0, size = this.noTradingSessionsGroupCounter; i < size; i++)
            {
                indent(builder, level);
                tradingSessionsGroup.appendTo(builder, level + 1);
                if (tradingSessionsGroup.next() != null)
                {
                    builder.append(',');
                }
                builder.append('\n');
                tradingSessionsGroup = tradingSessionsGroup.next();            }
            indent(builder, level);
            builder.append("],\n");
        }

        if (hasProcessCode())
        {
            indent(builder, level);
            builder.append("\"ProcessCode\": \"");
            builder.append(processCode);
            builder.append("\",\n");
        }

        indent(builder, level);
        builder.append("\"Symbol\": \"");
        builder.append(this.symbol(), 0, symbolLength());
        builder.append("\",\n");

        if (hasSymbolSfx())
        {
            indent(builder, level);
            builder.append("\"SymbolSfx\": \"");
            builder.append(this.symbolSfx(), 0, symbolSfxLength());
            builder.append("\",\n");
        }

        if (hasSecurityID())
        {
            indent(builder, level);
            builder.append("\"SecurityID\": \"");
            builder.append(this.securityID(), 0, securityIDLength());
            builder.append("\",\n");
        }

        if (hasSecurityIDSource())
        {
            indent(builder, level);
            builder.append("\"SecurityIDSource\": \"");
            builder.append(this.securityIDSource(), 0, securityIDSourceLength());
            builder.append("\",\n");
        }

        if (hasNoSecurityAltIDGroupCounter)
        {
            indent(builder, level);
            builder.append("\"SecurityAltIDGroup\": [\n");
            SecurityAltIDGroupDecoder securityAltIDGroup = this.securityAltIDGroup;
            for (int i = 0, size = this.noSecurityAltIDGroupCounter; i < size; i++)
            {
                indent(builder, level);
                securityAltIDGroup.appendTo(builder, level + 1);
                if (securityAltIDGroup.next() != null)
                {
                    builder.append(',');
                }
                builder.append('\n');
                securityAltIDGroup = securityAltIDGroup.next();            }
            indent(builder, level);
            builder.append("],\n");
        }

        if (hasProduct())
        {
            indent(builder, level);
            builder.append("\"Product\": \"");
            builder.append(product);
            builder.append("\",\n");
        }

        if (hasCFICode())
        {
            indent(builder, level);
            builder.append("\"CFICode\": \"");
            builder.append(this.cFICode(), 0, cFICodeLength());
            builder.append("\",\n");
        }

        if (hasSecurityType())
        {
            indent(builder, level);
            builder.append("\"SecurityType\": \"");
            builder.append(this.securityType(), 0, securityTypeLength());
            builder.append("\",\n");
        }

        if (hasSecuritySubType())
        {
            indent(builder, level);
            builder.append("\"SecuritySubType\": \"");
            builder.append(this.securitySubType(), 0, securitySubTypeLength());
            builder.append("\",\n");
        }

        if (hasMaturityMonthYear())
        {
            indent(builder, level);
            builder.append("\"MaturityMonthYear\": \"");
            appendData(builder, maturityMonthYear, maturityMonthYearLength);
            builder.append("\",\n");
        }

        if (hasMaturityDate())
        {
            indent(builder, level);
            builder.append("\"MaturityDate\": \"");
            appendData(builder, maturityDate, maturityDateLength);
            builder.append("\",\n");
        }

        if (hasCouponPaymentDate())
        {
            indent(builder, level);
            builder.append("\"CouponPaymentDate\": \"");
            appendData(builder, couponPaymentDate, couponPaymentDateLength);
            builder.append("\",\n");
        }

        if (hasIssueDate())
        {
            indent(builder, level);
            builder.append("\"IssueDate\": \"");
            appendData(builder, issueDate, issueDateLength);
            builder.append("\",\n");
        }

        if (hasRepoCollateralSecurityType())
        {
            indent(builder, level);
            builder.append("\"RepoCollateralSecurityType\": \"");
            builder.append(repoCollateralSecurityType);
            builder.append("\",\n");
        }

        if (hasRepurchaseTerm())
        {
            indent(builder, level);
            builder.append("\"RepurchaseTerm\": \"");
            builder.append(repurchaseTerm);
            builder.append("\",\n");
        }

        if (hasRepurchaseRate())
        {
            indent(builder, level);
            builder.append("\"RepurchaseRate\": \"");
            repurchaseRate.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasFactor())
        {
            indent(builder, level);
            builder.append("\"Factor\": \"");
            factor.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasCreditRating())
        {
            indent(builder, level);
            builder.append("\"CreditRating\": \"");
            builder.append(this.creditRating(), 0, creditRatingLength());
            builder.append("\",\n");
        }

        if (hasInstrRegistry())
        {
            indent(builder, level);
            builder.append("\"InstrRegistry\": \"");
            builder.append(this.instrRegistry(), 0, instrRegistryLength());
            builder.append("\",\n");
        }

        if (hasCountryOfIssue())
        {
            indent(builder, level);
            builder.append("\"CountryOfIssue\": \"");
            builder.append(this.countryOfIssue(), 0, countryOfIssueLength());
            builder.append("\",\n");
        }

        if (hasStateOrProvinceOfIssue())
        {
            indent(builder, level);
            builder.append("\"StateOrProvinceOfIssue\": \"");
            builder.append(this.stateOrProvinceOfIssue(), 0, stateOrProvinceOfIssueLength());
            builder.append("\",\n");
        }

        if (hasLocaleOfIssue())
        {
            indent(builder, level);
            builder.append("\"LocaleOfIssue\": \"");
            builder.append(this.localeOfIssue(), 0, localeOfIssueLength());
            builder.append("\",\n");
        }

        if (hasRedemptionDate())
        {
            indent(builder, level);
            builder.append("\"RedemptionDate\": \"");
            appendData(builder, redemptionDate, redemptionDateLength);
            builder.append("\",\n");
        }

        if (hasStrikePrice())
        {
            indent(builder, level);
            builder.append("\"StrikePrice\": \"");
            strikePrice.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasStrikeCurrency())
        {
            indent(builder, level);
            builder.append("\"StrikeCurrency\": \"");
            builder.append(this.strikeCurrency(), 0, strikeCurrencyLength());
            builder.append("\",\n");
        }

        if (hasOptAttribute())
        {
            indent(builder, level);
            builder.append("\"OptAttribute\": \"");
            builder.append(optAttribute);
            builder.append("\",\n");
        }

        if (hasContractMultiplier())
        {
            indent(builder, level);
            builder.append("\"ContractMultiplier\": \"");
            contractMultiplier.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasCouponRate())
        {
            indent(builder, level);
            builder.append("\"CouponRate\": \"");
            couponRate.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasSecurityExchange())
        {
            indent(builder, level);
            builder.append("\"SecurityExchange\": \"");
            builder.append(this.securityExchange(), 0, securityExchangeLength());
            builder.append("\",\n");
        }

        if (hasIssuer())
        {
            indent(builder, level);
            builder.append("\"Issuer\": \"");
            builder.append(this.issuer(), 0, issuerLength());
            builder.append("\",\n");
        }

        if (hasEncodedIssuerLen())
        {
            indent(builder, level);
            builder.append("\"EncodedIssuerLen\": \"");
            builder.append(encodedIssuerLen);
            builder.append("\",\n");
        }

        if (hasEncodedIssuer())
        {
            indent(builder, level);
            builder.append("\"EncodedIssuer\": \"");
            appendData(builder, encodedIssuer, encodedIssuerLen);
            builder.append("\",\n");
        }

        if (hasSecurityDesc())
        {
            indent(builder, level);
            builder.append("\"SecurityDesc\": \"");
            builder.append(this.securityDesc(), 0, securityDescLength());
            builder.append("\",\n");
        }

        if (hasEncodedSecurityDescLen())
        {
            indent(builder, level);
            builder.append("\"EncodedSecurityDescLen\": \"");
            builder.append(encodedSecurityDescLen);
            builder.append("\",\n");
        }

        if (hasEncodedSecurityDesc())
        {
            indent(builder, level);
            builder.append("\"EncodedSecurityDesc\": \"");
            appendData(builder, encodedSecurityDesc, encodedSecurityDescLen);
            builder.append("\",\n");
        }

        if (hasPool())
        {
            indent(builder, level);
            builder.append("\"Pool\": \"");
            builder.append(this.pool(), 0, poolLength());
            builder.append("\",\n");
        }

        if (hasContractSettlMonth())
        {
            indent(builder, level);
            builder.append("\"ContractSettlMonth\": \"");
            appendData(builder, contractSettlMonth, contractSettlMonthLength);
            builder.append("\",\n");
        }

        if (hasCPProgram())
        {
            indent(builder, level);
            builder.append("\"CPProgram\": \"");
            builder.append(cPProgram);
            builder.append("\",\n");
        }

        if (hasCPRegType())
        {
            indent(builder, level);
            builder.append("\"CPRegType\": \"");
            builder.append(this.cPRegType(), 0, cPRegTypeLength());
            builder.append("\",\n");
        }

        if (hasNoEventsGroupCounter)
        {
            indent(builder, level);
            builder.append("\"EventsGroup\": [\n");
            EventsGroupDecoder eventsGroup = this.eventsGroup;
            for (int i = 0, size = this.noEventsGroupCounter; i < size; i++)
            {
                indent(builder, level);
                eventsGroup.appendTo(builder, level + 1);
                if (eventsGroup.next() != null)
                {
                    builder.append(',');
                }
                builder.append('\n');
                eventsGroup = eventsGroup.next();            }
            indent(builder, level);
            builder.append("],\n");
        }

        if (hasDatedDate())
        {
            indent(builder, level);
            builder.append("\"DatedDate\": \"");
            appendData(builder, datedDate, datedDateLength);
            builder.append("\",\n");
        }

        if (hasInterestAccrualDate())
        {
            indent(builder, level);
            builder.append("\"InterestAccrualDate\": \"");
            appendData(builder, interestAccrualDate, interestAccrualDateLength);
            builder.append("\",\n");
        }

        if (hasNoUnderlyingsGroupCounter)
        {
            indent(builder, level);
            builder.append("\"UnderlyingsGroup\": [\n");
            UnderlyingsGroupDecoder underlyingsGroup = this.underlyingsGroup;
            for (int i = 0, size = this.noUnderlyingsGroupCounter; i < size; i++)
            {
                indent(builder, level);
                underlyingsGroup.appendTo(builder, level + 1);
                if (underlyingsGroup.next() != null)
                {
                    builder.append(',');
                }
                builder.append('\n');
                underlyingsGroup = underlyingsGroup.next();            }
            indent(builder, level);
            builder.append("],\n");
        }

        if (hasPrevClosePx())
        {
            indent(builder, level);
            builder.append("\"PrevClosePx\": \"");
            prevClosePx.appendTo(builder);
            builder.append("\",\n");
        }

        indent(builder, level);
        builder.append("\"Side\": \"");
        builder.append(side);
        builder.append("\",\n");

        if (hasSideValueInd())
        {
            indent(builder, level);
            builder.append("\"SideValueInd\": \"");
            builder.append(sideValueInd);
            builder.append("\",\n");
        }

        if (hasLocateReqd())
        {
            indent(builder, level);
            builder.append("\"LocateReqd\": \"");
            builder.append(locateReqd);
            builder.append("\",\n");
        }

        if (hasTransactTime())
        {
            indent(builder, level);
            builder.append("\"TransactTime\": \"");
            appendData(builder, transactTime, transactTimeLength);
            builder.append("\",\n");
        }

        if (hasNoStipulationsGroupCounter)
        {
            indent(builder, level);
            builder.append("\"StipulationsGroup\": [\n");
            StipulationsGroupDecoder stipulationsGroup = this.stipulationsGroup;
            for (int i = 0, size = this.noStipulationsGroupCounter; i < size; i++)
            {
                indent(builder, level);
                stipulationsGroup.appendTo(builder, level + 1);
                if (stipulationsGroup.next() != null)
                {
                    builder.append(',');
                }
                builder.append('\n');
                stipulationsGroup = stipulationsGroup.next();            }
            indent(builder, level);
            builder.append("],\n");
        }

        if (hasQtyType())
        {
            indent(builder, level);
            builder.append("\"QtyType\": \"");
            builder.append(qtyType);
            builder.append("\",\n");
        }

        if (hasOrderQty())
        {
            indent(builder, level);
            builder.append("\"OrderQty\": \"");
            orderQty.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasCashOrderQty())
        {
            indent(builder, level);
            builder.append("\"CashOrderQty\": \"");
            cashOrderQty.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasOrderPercent())
        {
            indent(builder, level);
            builder.append("\"OrderPercent\": \"");
            orderPercent.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasRoundingDirection())
        {
            indent(builder, level);
            builder.append("\"RoundingDirection\": \"");
            builder.append(roundingDirection);
            builder.append("\",\n");
        }

        if (hasRoundingModulus())
        {
            indent(builder, level);
            builder.append("\"RoundingModulus\": \"");
            roundingModulus.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasOrdType())
        {
            indent(builder, level);
            builder.append("\"OrdType\": \"");
            builder.append(ordType);
            builder.append("\",\n");
        }

        if (hasPriceType())
        {
            indent(builder, level);
            builder.append("\"PriceType\": \"");
            builder.append(priceType);
            builder.append("\",\n");
        }

        if (hasPrice())
        {
            indent(builder, level);
            builder.append("\"Price\": \"");
            price.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasStopPx())
        {
            indent(builder, level);
            builder.append("\"StopPx\": \"");
            stopPx.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasSpread())
        {
            indent(builder, level);
            builder.append("\"Spread\": \"");
            spread.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasBenchmarkCurveCurrency())
        {
            indent(builder, level);
            builder.append("\"BenchmarkCurveCurrency\": \"");
            builder.append(this.benchmarkCurveCurrency(), 0, benchmarkCurveCurrencyLength());
            builder.append("\",\n");
        }

        if (hasBenchmarkCurveName())
        {
            indent(builder, level);
            builder.append("\"BenchmarkCurveName\": \"");
            builder.append(this.benchmarkCurveName(), 0, benchmarkCurveNameLength());
            builder.append("\",\n");
        }

        if (hasBenchmarkCurvePoint())
        {
            indent(builder, level);
            builder.append("\"BenchmarkCurvePoint\": \"");
            builder.append(this.benchmarkCurvePoint(), 0, benchmarkCurvePointLength());
            builder.append("\",\n");
        }

        if (hasBenchmarkPrice())
        {
            indent(builder, level);
            builder.append("\"BenchmarkPrice\": \"");
            benchmarkPrice.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasBenchmarkPriceType())
        {
            indent(builder, level);
            builder.append("\"BenchmarkPriceType\": \"");
            builder.append(benchmarkPriceType);
            builder.append("\",\n");
        }

        if (hasBenchmarkSecurityID())
        {
            indent(builder, level);
            builder.append("\"BenchmarkSecurityID\": \"");
            builder.append(this.benchmarkSecurityID(), 0, benchmarkSecurityIDLength());
            builder.append("\",\n");
        }

        if (hasBenchmarkSecurityIDSource())
        {
            indent(builder, level);
            builder.append("\"BenchmarkSecurityIDSource\": \"");
            builder.append(this.benchmarkSecurityIDSource(), 0, benchmarkSecurityIDSourceLength());
            builder.append("\",\n");
        }

        if (hasYieldType())
        {
            indent(builder, level);
            builder.append("\"YieldType\": \"");
            builder.append(this.yieldType(), 0, yieldTypeLength());
            builder.append("\",\n");
        }

        if (hasYield())
        {
            indent(builder, level);
            builder.append("\"Yield\": \"");
            yield.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasYieldCalcDate())
        {
            indent(builder, level);
            builder.append("\"YieldCalcDate\": \"");
            appendData(builder, yieldCalcDate, yieldCalcDateLength);
            builder.append("\",\n");
        }

        if (hasYieldRedemptionDate())
        {
            indent(builder, level);
            builder.append("\"YieldRedemptionDate\": \"");
            appendData(builder, yieldRedemptionDate, yieldRedemptionDateLength);
            builder.append("\",\n");
        }

        if (hasYieldRedemptionPrice())
        {
            indent(builder, level);
            builder.append("\"YieldRedemptionPrice\": \"");
            yieldRedemptionPrice.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasYieldRedemptionPriceType())
        {
            indent(builder, level);
            builder.append("\"YieldRedemptionPriceType\": \"");
            builder.append(yieldRedemptionPriceType);
            builder.append("\",\n");
        }

        if (hasCurrency())
        {
            indent(builder, level);
            builder.append("\"Currency\": \"");
            builder.append(this.currency(), 0, currencyLength());
            builder.append("\",\n");
        }

        if (hasComplianceID())
        {
            indent(builder, level);
            builder.append("\"ComplianceID\": \"");
            builder.append(this.complianceID(), 0, complianceIDLength());
            builder.append("\",\n");
        }

        if (hasSolicitedFlag())
        {
            indent(builder, level);
            builder.append("\"SolicitedFlag\": \"");
            builder.append(solicitedFlag);
            builder.append("\",\n");
        }

        if (hasIOIid())
        {
            indent(builder, level);
            builder.append("\"IOIid\": \"");
            builder.append(this.iOIid(), 0, iOIidLength());
            builder.append("\",\n");
        }

        if (hasQuoteID())
        {
            indent(builder, level);
            builder.append("\"QuoteID\": \"");
            builder.append(this.quoteID(), 0, quoteIDLength());
            builder.append("\",\n");
        }

        if (hasTimeInForce())
        {
            indent(builder, level);
            builder.append("\"TimeInForce\": \"");
            builder.append(timeInForce);
            builder.append("\",\n");
        }

        if (hasEffectiveTime())
        {
            indent(builder, level);
            builder.append("\"EffectiveTime\": \"");
            appendData(builder, effectiveTime, effectiveTimeLength);
            builder.append("\",\n");
        }

        if (hasExpireDate())
        {
            indent(builder, level);
            builder.append("\"ExpireDate\": \"");
            appendData(builder, expireDate, expireDateLength);
            builder.append("\",\n");
        }

        if (hasExpireTime())
        {
            indent(builder, level);
            builder.append("\"ExpireTime\": \"");
            appendData(builder, expireTime, expireTimeLength);
            builder.append("\",\n");
        }

        if (hasGTBookingInst())
        {
            indent(builder, level);
            builder.append("\"GTBookingInst\": \"");
            builder.append(gTBookingInst);
            builder.append("\",\n");
        }

        if (hasCommission())
        {
            indent(builder, level);
            builder.append("\"Commission\": \"");
            commission.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasCommType())
        {
            indent(builder, level);
            builder.append("\"CommType\": \"");
            builder.append(commType);
            builder.append("\",\n");
        }

        if (hasCommCurrency())
        {
            indent(builder, level);
            builder.append("\"CommCurrency\": \"");
            builder.append(this.commCurrency(), 0, commCurrencyLength());
            builder.append("\",\n");
        }

        if (hasFundRenewWaiv())
        {
            indent(builder, level);
            builder.append("\"FundRenewWaiv\": \"");
            builder.append(fundRenewWaiv);
            builder.append("\",\n");
        }

        if (hasOrderCapacity())
        {
            indent(builder, level);
            builder.append("\"OrderCapacity\": \"");
            builder.append(orderCapacity);
            builder.append("\",\n");
        }

        if (hasOrderRestrictions())
        {
            indent(builder, level);
            builder.append("\"OrderRestrictions\": \"");
            builder.append(this.orderRestrictions(), 0, orderRestrictionsLength());
            builder.append("\",\n");
        }

        if (hasCustOrderCapacity())
        {
            indent(builder, level);
            builder.append("\"CustOrderCapacity\": \"");
            builder.append(custOrderCapacity);
            builder.append("\",\n");
        }

        if (hasForexReq())
        {
            indent(builder, level);
            builder.append("\"ForexReq\": \"");
            builder.append(forexReq);
            builder.append("\",\n");
        }

        if (hasSettlCurrency())
        {
            indent(builder, level);
            builder.append("\"SettlCurrency\": \"");
            builder.append(this.settlCurrency(), 0, settlCurrencyLength());
            builder.append("\",\n");
        }

        if (hasBookingType())
        {
            indent(builder, level);
            builder.append("\"BookingType\": \"");
            builder.append(bookingType);
            builder.append("\",\n");
        }

        if (hasText())
        {
            indent(builder, level);
            builder.append("\"Text\": \"");
            builder.append(this.text(), 0, textLength());
            builder.append("\",\n");
        }

        if (hasEncodedTextLen())
        {
            indent(builder, level);
            builder.append("\"EncodedTextLen\": \"");
            builder.append(encodedTextLen);
            builder.append("\",\n");
        }

        if (hasEncodedText())
        {
            indent(builder, level);
            builder.append("\"EncodedText\": \"");
            appendData(builder, encodedText, encodedTextLen);
            builder.append("\",\n");
        }

        if (hasSettlDate2())
        {
            indent(builder, level);
            builder.append("\"SettlDate2\": \"");
            appendData(builder, settlDate2, settlDate2Length);
            builder.append("\",\n");
        }

        if (hasOrderQty2())
        {
            indent(builder, level);
            builder.append("\"OrderQty2\": \"");
            orderQty2.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasPrice2())
        {
            indent(builder, level);
            builder.append("\"Price2\": \"");
            price2.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasPositionEffect())
        {
            indent(builder, level);
            builder.append("\"PositionEffect\": \"");
            builder.append(positionEffect);
            builder.append("\",\n");
        }

        if (hasCoveredOrUncovered())
        {
            indent(builder, level);
            builder.append("\"CoveredOrUncovered\": \"");
            builder.append(coveredOrUncovered);
            builder.append("\",\n");
        }

        if (hasMaxShow())
        {
            indent(builder, level);
            builder.append("\"MaxShow\": \"");
            maxShow.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasPegOffsetValue())
        {
            indent(builder, level);
            builder.append("\"PegOffsetValue\": \"");
            pegOffsetValue.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasPegMoveType())
        {
            indent(builder, level);
            builder.append("\"PegMoveType\": \"");
            builder.append(pegMoveType);
            builder.append("\",\n");
        }

        if (hasPegOffsetType())
        {
            indent(builder, level);
            builder.append("\"PegOffsetType\": \"");
            builder.append(pegOffsetType);
            builder.append("\",\n");
        }

        if (hasPegLimitType())
        {
            indent(builder, level);
            builder.append("\"PegLimitType\": \"");
            builder.append(pegLimitType);
            builder.append("\",\n");
        }

        if (hasPegRoundDirection())
        {
            indent(builder, level);
            builder.append("\"PegRoundDirection\": \"");
            builder.append(pegRoundDirection);
            builder.append("\",\n");
        }

        if (hasPegScope())
        {
            indent(builder, level);
            builder.append("\"PegScope\": \"");
            builder.append(pegScope);
            builder.append("\",\n");
        }

        if (hasDiscretionInst())
        {
            indent(builder, level);
            builder.append("\"DiscretionInst\": \"");
            builder.append(discretionInst);
            builder.append("\",\n");
        }

        if (hasDiscretionOffsetValue())
        {
            indent(builder, level);
            builder.append("\"DiscretionOffsetValue\": \"");
            discretionOffsetValue.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasDiscretionMoveType())
        {
            indent(builder, level);
            builder.append("\"DiscretionMoveType\": \"");
            builder.append(discretionMoveType);
            builder.append("\",\n");
        }

        if (hasDiscretionOffsetType())
        {
            indent(builder, level);
            builder.append("\"DiscretionOffsetType\": \"");
            builder.append(discretionOffsetType);
            builder.append("\",\n");
        }

        if (hasDiscretionLimitType())
        {
            indent(builder, level);
            builder.append("\"DiscretionLimitType\": \"");
            builder.append(discretionLimitType);
            builder.append("\",\n");
        }

        if (hasDiscretionRoundDirection())
        {
            indent(builder, level);
            builder.append("\"DiscretionRoundDirection\": \"");
            builder.append(discretionRoundDirection);
            builder.append("\",\n");
        }

        if (hasDiscretionScope())
        {
            indent(builder, level);
            builder.append("\"DiscretionScope\": \"");
            builder.append(discretionScope);
            builder.append("\",\n");
        }

        if (hasTargetStrategy())
        {
            indent(builder, level);
            builder.append("\"TargetStrategy\": \"");
            builder.append(targetStrategy);
            builder.append("\",\n");
        }

        if (hasTargetStrategyParameters())
        {
            indent(builder, level);
            builder.append("\"TargetStrategyParameters\": \"");
            builder.append(this.targetStrategyParameters(), 0, targetStrategyParametersLength());
            builder.append("\",\n");
        }

        if (hasParticipationRate())
        {
            indent(builder, level);
            builder.append("\"ParticipationRate\": \"");
            participationRate.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasDesignation())
        {
            indent(builder, level);
            builder.append("\"Designation\": \"");
            builder.append(this.designation(), 0, designationLength());
            builder.append("\",\n");
        }
        indent(builder, level - 1);
        builder.append("}");
        return builder;
    }

    /**
     * {@inheritDoc}
     */
    public NewOrderListEncoder.OrdersGroupEncoder toEncoder(final Encoder encoder)
    {
        return toEncoder((NewOrderListEncoder.OrdersGroupEncoder)encoder);
    }

    public NewOrderListEncoder.OrdersGroupEncoder toEncoder(final NewOrderListEncoder.OrdersGroupEncoder encoder)
    {
        encoder.reset();
        encoder.clOrdID(this.clOrdID(), 0, clOrdIDLength());
        if (hasSecondaryClOrdID())
        {
            encoder.secondaryClOrdID(this.secondaryClOrdID(), 0, secondaryClOrdIDLength());
        }

        encoder.listSeqNo(this.listSeqNo());
        if (hasClOrdLinkID())
        {
            encoder.clOrdLinkID(this.clOrdLinkID(), 0, clOrdLinkIDLength());
        }

        if (hasSettlInstMode())
        {
            encoder.settlInstMode(this.settlInstMode());
        }


        final PartiesEncoder parties = encoder.parties();        if (hasNoPartyIDsGroupCounter)
        {
            final int size = this.noPartyIDsGroupCounter;
            PartyIDsGroupDecoder partyIDsGroup = this.partyIDsGroup;
            PartyIDsGroupEncoder partyIDsGroupEncoder = parties.partyIDsGroup(size);
            for (int i = 0; i < size; i++)
            {
                if (partyIDsGroup != null)
                {
                    partyIDsGroup.toEncoder(partyIDsGroupEncoder);
                    partyIDsGroup = partyIDsGroup.next();
                    partyIDsGroupEncoder = partyIDsGroupEncoder.next();
                }
            }
        }


        if (hasTradeOriginationDate())
        {
            encoder.tradeOriginationDateAsCopy(this.tradeOriginationDate(), 0, tradeOriginationDateLength());
        }

        if (hasTradeDate())
        {
            encoder.tradeDateAsCopy(this.tradeDate(), 0, tradeDateLength());
        }

        if (hasAccount())
        {
            encoder.account(this.account(), 0, accountLength());
        }

        if (hasAcctIDSource())
        {
            encoder.acctIDSource(this.acctIDSource());
        }

        if (hasAccountType())
        {
            encoder.accountType(this.accountType());
        }

        if (hasDayBookingInst())
        {
            encoder.dayBookingInst(this.dayBookingInst());
        }

        if (hasBookingUnit())
        {
            encoder.bookingUnit(this.bookingUnit());
        }

        if (hasAllocID())
        {
            encoder.allocID(this.allocID(), 0, allocIDLength());
        }

        if (hasPreallocMethod())
        {
            encoder.preallocMethod(this.preallocMethod());
        }

        if (hasNoAllocsGroupCounter)
        {
            final int size = this.noAllocsGroupCounter;
            AllocsGroupDecoder allocsGroup = this.allocsGroup;
            AllocsGroupEncoder allocsGroupEncoder = encoder.allocsGroup(size);
            for (int i = 0; i < size; i++)
            {
                if (allocsGroup != null)
                {
                    allocsGroup.toEncoder(allocsGroupEncoder);
                    allocsGroup = allocsGroup.next();
                    allocsGroupEncoder = allocsGroupEncoder.next();
                }
            }
        }

        if (hasSettlType())
        {
            encoder.settlType(this.settlType());
        }

        if (hasSettlDate())
        {
            encoder.settlDateAsCopy(this.settlDate(), 0, settlDateLength());
        }

        if (hasCashMargin())
        {
            encoder.cashMargin(this.cashMargin());
        }

        if (hasClearingFeeIndicator())
        {
            encoder.clearingFeeIndicator(this.clearingFeeIndicator(), 0, clearingFeeIndicatorLength());
        }

        if (hasHandlInst())
        {
            encoder.handlInst(this.handlInst());
        }

        if (hasExecInst())
        {
            encoder.execInst(this.execInst(), 0, execInstLength());
        }

        if (hasMinQty())
        {
            encoder.minQty(this.minQty());
        }

        if (hasMaxFloor())
        {
            encoder.maxFloor(this.maxFloor());
        }

        if (hasExDestination())
        {
            encoder.exDestination(this.exDestination(), 0, exDestinationLength());
        }

        if (hasNoTradingSessionsGroupCounter)
        {
            final int size = this.noTradingSessionsGroupCounter;
            TradingSessionsGroupDecoder tradingSessionsGroup = this.tradingSessionsGroup;
            TradingSessionsGroupEncoder tradingSessionsGroupEncoder = encoder.tradingSessionsGroup(size);
            for (int i = 0; i < size; i++)
            {
                if (tradingSessionsGroup != null)
                {
                    tradingSessionsGroup.toEncoder(tradingSessionsGroupEncoder);
                    tradingSessionsGroup = tradingSessionsGroup.next();
                    tradingSessionsGroupEncoder = tradingSessionsGroupEncoder.next();
                }
            }
        }

        if (hasProcessCode())
        {
            encoder.processCode(this.processCode());
        }


        final InstrumentEncoder instrument = encoder.instrument();        instrument.symbol(this.symbol(), 0, symbolLength());
        if (hasSymbolSfx())
        {
            instrument.symbolSfx(this.symbolSfx(), 0, symbolSfxLength());
        }

        if (hasSecurityID())
        {
            instrument.securityID(this.securityID(), 0, securityIDLength());
        }

        if (hasSecurityIDSource())
        {
            instrument.securityIDSource(this.securityIDSource(), 0, securityIDSourceLength());
        }

        if (hasNoSecurityAltIDGroupCounter)
        {
            final int size = this.noSecurityAltIDGroupCounter;
            SecurityAltIDGroupDecoder securityAltIDGroup = this.securityAltIDGroup;
            SecurityAltIDGroupEncoder securityAltIDGroupEncoder = instrument.securityAltIDGroup(size);
            for (int i = 0; i < size; i++)
            {
                if (securityAltIDGroup != null)
                {
                    securityAltIDGroup.toEncoder(securityAltIDGroupEncoder);
                    securityAltIDGroup = securityAltIDGroup.next();
                    securityAltIDGroupEncoder = securityAltIDGroupEncoder.next();
                }
            }
        }

        if (hasProduct())
        {
            instrument.product(this.product());
        }

        if (hasCFICode())
        {
            instrument.cFICode(this.cFICode(), 0, cFICodeLength());
        }

        if (hasSecurityType())
        {
            instrument.securityType(this.securityType(), 0, securityTypeLength());
        }

        if (hasSecuritySubType())
        {
            instrument.securitySubType(this.securitySubType(), 0, securitySubTypeLength());
        }

        if (hasMaturityMonthYear())
        {
            instrument.maturityMonthYearAsCopy(this.maturityMonthYear(), 0, maturityMonthYearLength());
        }

        if (hasMaturityDate())
        {
            instrument.maturityDateAsCopy(this.maturityDate(), 0, maturityDateLength());
        }

        if (hasCouponPaymentDate())
        {
            instrument.couponPaymentDateAsCopy(this.couponPaymentDate(), 0, couponPaymentDateLength());
        }

        if (hasIssueDate())
        {
            instrument.issueDateAsCopy(this.issueDate(), 0, issueDateLength());
        }

        if (hasRepoCollateralSecurityType())
        {
            instrument.repoCollateralSecurityType(this.repoCollateralSecurityType());
        }

        if (hasRepurchaseTerm())
        {
            instrument.repurchaseTerm(this.repurchaseTerm());
        }

        if (hasRepurchaseRate())
        {
            instrument.repurchaseRate(this.repurchaseRate());
        }

        if (hasFactor())
        {
            instrument.factor(this.factor());
        }

        if (hasCreditRating())
        {
            instrument.creditRating(this.creditRating(), 0, creditRatingLength());
        }

        if (hasInstrRegistry())
        {
            instrument.instrRegistry(this.instrRegistry(), 0, instrRegistryLength());
        }

        if (hasCountryOfIssue())
        {
            instrument.countryOfIssue(this.countryOfIssue(), 0, countryOfIssueLength());
        }

        if (hasStateOrProvinceOfIssue())
        {
            instrument.stateOrProvinceOfIssue(this.stateOrProvinceOfIssue(), 0, stateOrProvinceOfIssueLength());
        }

        if (hasLocaleOfIssue())
        {
            instrument.localeOfIssue(this.localeOfIssue(), 0, localeOfIssueLength());
        }

        if (hasRedemptionDate())
        {
            instrument.redemptionDateAsCopy(this.redemptionDate(), 0, redemptionDateLength());
        }

        if (hasStrikePrice())
        {
            instrument.strikePrice(this.strikePrice());
        }

        if (hasStrikeCurrency())
        {
            instrument.strikeCurrency(this.strikeCurrency(), 0, strikeCurrencyLength());
        }

        if (hasOptAttribute())
        {
            instrument.optAttribute(this.optAttribute());
        }

        if (hasContractMultiplier())
        {
            instrument.contractMultiplier(this.contractMultiplier());
        }

        if (hasCouponRate())
        {
            instrument.couponRate(this.couponRate());
        }

        if (hasSecurityExchange())
        {
            instrument.securityExchange(this.securityExchange(), 0, securityExchangeLength());
        }

        if (hasIssuer())
        {
            instrument.issuer(this.issuer(), 0, issuerLength());
        }

        if (hasEncodedIssuerLen())
        {
            instrument.encodedIssuerLen(this.encodedIssuerLen());
        }

        if (hasEncodedIssuer())
        {
            instrument.encodedIssuerAsCopy(this.encodedIssuer(), 0, encodedIssuerLen());
            instrument.encodedIssuerLen(this.encodedIssuerLen());
        }

        if (hasSecurityDesc())
        {
            instrument.securityDesc(this.securityDesc(), 0, securityDescLength());
        }

        if (hasEncodedSecurityDescLen())
        {
            instrument.encodedSecurityDescLen(this.encodedSecurityDescLen());
        }

        if (hasEncodedSecurityDesc())
        {
            instrument.encodedSecurityDescAsCopy(this.encodedSecurityDesc(), 0, encodedSecurityDescLen());
            instrument.encodedSecurityDescLen(this.encodedSecurityDescLen());
        }

        if (hasPool())
        {
            instrument.pool(this.pool(), 0, poolLength());
        }

        if (hasContractSettlMonth())
        {
            instrument.contractSettlMonthAsCopy(this.contractSettlMonth(), 0, contractSettlMonthLength());
        }

        if (hasCPProgram())
        {
            instrument.cPProgram(this.cPProgram());
        }

        if (hasCPRegType())
        {
            instrument.cPRegType(this.cPRegType(), 0, cPRegTypeLength());
        }

        if (hasNoEventsGroupCounter)
        {
            final int size = this.noEventsGroupCounter;
            EventsGroupDecoder eventsGroup = this.eventsGroup;
            EventsGroupEncoder eventsGroupEncoder = instrument.eventsGroup(size);
            for (int i = 0; i < size; i++)
            {
                if (eventsGroup != null)
                {
                    eventsGroup.toEncoder(eventsGroupEncoder);
                    eventsGroup = eventsGroup.next();
                    eventsGroupEncoder = eventsGroupEncoder.next();
                }
            }
        }

        if (hasDatedDate())
        {
            instrument.datedDateAsCopy(this.datedDate(), 0, datedDateLength());
        }

        if (hasInterestAccrualDate())
        {
            instrument.interestAccrualDateAsCopy(this.interestAccrualDate(), 0, interestAccrualDateLength());
        }


        if (hasNoUnderlyingsGroupCounter)
        {
            final int size = this.noUnderlyingsGroupCounter;
            UnderlyingsGroupDecoder underlyingsGroup = this.underlyingsGroup;
            UnderlyingsGroupEncoder underlyingsGroupEncoder = encoder.underlyingsGroup(size);
            for (int i = 0; i < size; i++)
            {
                if (underlyingsGroup != null)
                {
                    underlyingsGroup.toEncoder(underlyingsGroupEncoder);
                    underlyingsGroup = underlyingsGroup.next();
                    underlyingsGroupEncoder = underlyingsGroupEncoder.next();
                }
            }
        }

        if (hasPrevClosePx())
        {
            encoder.prevClosePx(this.prevClosePx());
        }

        encoder.side(this.side());
        if (hasSideValueInd())
        {
            encoder.sideValueInd(this.sideValueInd());
        }

        if (hasLocateReqd())
        {
            encoder.locateReqd(this.locateReqd());
        }

        if (hasTransactTime())
        {
            encoder.transactTimeAsCopy(this.transactTime(), 0, transactTimeLength());
        }


        final StipulationsEncoder stipulations = encoder.stipulations();        if (hasNoStipulationsGroupCounter)
        {
            final int size = this.noStipulationsGroupCounter;
            StipulationsGroupDecoder stipulationsGroup = this.stipulationsGroup;
            StipulationsGroupEncoder stipulationsGroupEncoder = stipulations.stipulationsGroup(size);
            for (int i = 0; i < size; i++)
            {
                if (stipulationsGroup != null)
                {
                    stipulationsGroup.toEncoder(stipulationsGroupEncoder);
                    stipulationsGroup = stipulationsGroup.next();
                    stipulationsGroupEncoder = stipulationsGroupEncoder.next();
                }
            }
        }


        if (hasQtyType())
        {
            encoder.qtyType(this.qtyType());
        }


        final OrderQtyDataEncoder orderQtyData = encoder.orderQtyData();        if (hasOrderQty())
        {
            orderQtyData.orderQty(this.orderQty());
        }

        if (hasCashOrderQty())
        {
            orderQtyData.cashOrderQty(this.cashOrderQty());
        }

        if (hasOrderPercent())
        {
            orderQtyData.orderPercent(this.orderPercent());
        }

        if (hasRoundingDirection())
        {
            orderQtyData.roundingDirection(this.roundingDirection());
        }

        if (hasRoundingModulus())
        {
            orderQtyData.roundingModulus(this.roundingModulus());
        }


        if (hasOrdType())
        {
            encoder.ordType(this.ordType());
        }

        if (hasPriceType())
        {
            encoder.priceType(this.priceType());
        }

        if (hasPrice())
        {
            encoder.price(this.price());
        }

        if (hasStopPx())
        {
            encoder.stopPx(this.stopPx());
        }


        final SpreadOrBenchmarkCurveDataEncoder spreadOrBenchmarkCurveData = encoder.spreadOrBenchmarkCurveData();        if (hasSpread())
        {
            spreadOrBenchmarkCurveData.spread(this.spread());
        }

        if (hasBenchmarkCurveCurrency())
        {
            spreadOrBenchmarkCurveData.benchmarkCurveCurrency(this.benchmarkCurveCurrency(), 0, benchmarkCurveCurrencyLength());
        }

        if (hasBenchmarkCurveName())
        {
            spreadOrBenchmarkCurveData.benchmarkCurveName(this.benchmarkCurveName(), 0, benchmarkCurveNameLength());
        }

        if (hasBenchmarkCurvePoint())
        {
            spreadOrBenchmarkCurveData.benchmarkCurvePoint(this.benchmarkCurvePoint(), 0, benchmarkCurvePointLength());
        }

        if (hasBenchmarkPrice())
        {
            spreadOrBenchmarkCurveData.benchmarkPrice(this.benchmarkPrice());
        }

        if (hasBenchmarkPriceType())
        {
            spreadOrBenchmarkCurveData.benchmarkPriceType(this.benchmarkPriceType());
        }

        if (hasBenchmarkSecurityID())
        {
            spreadOrBenchmarkCurveData.benchmarkSecurityID(this.benchmarkSecurityID(), 0, benchmarkSecurityIDLength());
        }

        if (hasBenchmarkSecurityIDSource())
        {
            spreadOrBenchmarkCurveData.benchmarkSecurityIDSource(this.benchmarkSecurityIDSource(), 0, benchmarkSecurityIDSourceLength());
        }



        final YieldDataEncoder yieldData = encoder.yieldData();        if (hasYieldType())
        {
            yieldData.yieldType(this.yieldType(), 0, yieldTypeLength());
        }

        if (hasYield())
        {
            yieldData.yield(this.yield());
        }

        if (hasYieldCalcDate())
        {
            yieldData.yieldCalcDateAsCopy(this.yieldCalcDate(), 0, yieldCalcDateLength());
        }

        if (hasYieldRedemptionDate())
        {
            yieldData.yieldRedemptionDateAsCopy(this.yieldRedemptionDate(), 0, yieldRedemptionDateLength());
        }

        if (hasYieldRedemptionPrice())
        {
            yieldData.yieldRedemptionPrice(this.yieldRedemptionPrice());
        }

        if (hasYieldRedemptionPriceType())
        {
            yieldData.yieldRedemptionPriceType(this.yieldRedemptionPriceType());
        }


        if (hasCurrency())
        {
            encoder.currency(this.currency(), 0, currencyLength());
        }

        if (hasComplianceID())
        {
            encoder.complianceID(this.complianceID(), 0, complianceIDLength());
        }

        if (hasSolicitedFlag())
        {
            encoder.solicitedFlag(this.solicitedFlag());
        }

        if (hasIOIid())
        {
            encoder.iOIid(this.iOIid(), 0, iOIidLength());
        }

        if (hasQuoteID())
        {
            encoder.quoteID(this.quoteID(), 0, quoteIDLength());
        }

        if (hasTimeInForce())
        {
            encoder.timeInForce(this.timeInForce());
        }

        if (hasEffectiveTime())
        {
            encoder.effectiveTimeAsCopy(this.effectiveTime(), 0, effectiveTimeLength());
        }

        if (hasExpireDate())
        {
            encoder.expireDateAsCopy(this.expireDate(), 0, expireDateLength());
        }

        if (hasExpireTime())
        {
            encoder.expireTimeAsCopy(this.expireTime(), 0, expireTimeLength());
        }

        if (hasGTBookingInst())
        {
            encoder.gTBookingInst(this.gTBookingInst());
        }


        final CommissionDataEncoder commissionData = encoder.commissionData();        if (hasCommission())
        {
            commissionData.commission(this.commission());
        }

        if (hasCommType())
        {
            commissionData.commType(this.commType());
        }

        if (hasCommCurrency())
        {
            commissionData.commCurrency(this.commCurrency(), 0, commCurrencyLength());
        }

        if (hasFundRenewWaiv())
        {
            commissionData.fundRenewWaiv(this.fundRenewWaiv());
        }


        if (hasOrderCapacity())
        {
            encoder.orderCapacity(this.orderCapacity());
        }

        if (hasOrderRestrictions())
        {
            encoder.orderRestrictions(this.orderRestrictions(), 0, orderRestrictionsLength());
        }

        if (hasCustOrderCapacity())
        {
            encoder.custOrderCapacity(this.custOrderCapacity());
        }

        if (hasForexReq())
        {
            encoder.forexReq(this.forexReq());
        }

        if (hasSettlCurrency())
        {
            encoder.settlCurrency(this.settlCurrency(), 0, settlCurrencyLength());
        }

        if (hasBookingType())
        {
            encoder.bookingType(this.bookingType());
        }

        if (hasText())
        {
            encoder.text(this.text(), 0, textLength());
        }

        if (hasEncodedTextLen())
        {
            encoder.encodedTextLen(this.encodedTextLen());
        }

        if (hasEncodedText())
        {
            encoder.encodedTextAsCopy(this.encodedText(), 0, encodedTextLen());
            encoder.encodedTextLen(this.encodedTextLen());
        }

        if (hasSettlDate2())
        {
            encoder.settlDate2AsCopy(this.settlDate2(), 0, settlDate2Length());
        }

        if (hasOrderQty2())
        {
            encoder.orderQty2(this.orderQty2());
        }

        if (hasPrice2())
        {
            encoder.price2(this.price2());
        }

        if (hasPositionEffect())
        {
            encoder.positionEffect(this.positionEffect());
        }

        if (hasCoveredOrUncovered())
        {
            encoder.coveredOrUncovered(this.coveredOrUncovered());
        }

        if (hasMaxShow())
        {
            encoder.maxShow(this.maxShow());
        }


        final PegInstructionsEncoder pegInstructions = encoder.pegInstructions();        if (hasPegOffsetValue())
        {
            pegInstructions.pegOffsetValue(this.pegOffsetValue());
        }

        if (hasPegMoveType())
        {
            pegInstructions.pegMoveType(this.pegMoveType());
        }

        if (hasPegOffsetType())
        {
            pegInstructions.pegOffsetType(this.pegOffsetType());
        }

        if (hasPegLimitType())
        {
            pegInstructions.pegLimitType(this.pegLimitType());
        }

        if (hasPegRoundDirection())
        {
            pegInstructions.pegRoundDirection(this.pegRoundDirection());
        }

        if (hasPegScope())
        {
            pegInstructions.pegScope(this.pegScope());
        }



        final DiscretionInstructionsEncoder discretionInstructions = encoder.discretionInstructions();        if (hasDiscretionInst())
        {
            discretionInstructions.discretionInst(this.discretionInst());
        }

        if (hasDiscretionOffsetValue())
        {
            discretionInstructions.discretionOffsetValue(this.discretionOffsetValue());
        }

        if (hasDiscretionMoveType())
        {
            discretionInstructions.discretionMoveType(this.discretionMoveType());
        }

        if (hasDiscretionOffsetType())
        {
            discretionInstructions.discretionOffsetType(this.discretionOffsetType());
        }

        if (hasDiscretionLimitType())
        {
            discretionInstructions.discretionLimitType(this.discretionLimitType());
        }

        if (hasDiscretionRoundDirection())
        {
            discretionInstructions.discretionRoundDirection(this.discretionRoundDirection());
        }

        if (hasDiscretionScope())
        {
            discretionInstructions.discretionScope(this.discretionScope());
        }


        if (hasTargetStrategy())
        {
            encoder.targetStrategy(this.targetStrategy());
        }

        if (hasTargetStrategyParameters())
        {
            encoder.targetStrategyParameters(this.targetStrategyParameters(), 0, targetStrategyParametersLength());
        }

        if (hasParticipationRate())
        {
            encoder.participationRate(this.participationRate());
        }

        if (hasDesignation())
        {
            encoder.designation(this.designation(), 0, designationLength());
        }
        return encoder;
    }

}
    @Generated("uk.co.real_logic.artio")
    public class OrdersGroupIterator implements Iterable<OrdersGroupDecoder>, java.util.Iterator<OrdersGroupDecoder>
    {
        private final NewOrderListDecoder parent;
        private int remainder;
        private OrdersGroupDecoder current;

        public OrdersGroupIterator(final NewOrderListDecoder parent)
        {
            this.parent = parent;
        }

        public boolean hasNext()
        {
            return remainder > 0 && current != null;
        }

        public OrdersGroupDecoder next()
        {
            remainder--;
            final OrdersGroupDecoder value = current;
            current = current.next();
            return value;
        }

        public int numberFieldValue()
        {
            return parent.hasNoOrdersGroupCounter() ? parent.noOrdersGroupCounter() : 0;
        }

        public void reset()
        {
            remainder = numberFieldValue();
            current = parent.ordersGroup();
        }

        public OrdersGroupIterator iterator()
        {
            reset();
            return this;
        }

    }


    private OrdersGroupDecoder ordersGroup = null;
    public OrdersGroupDecoder ordersGroup()
    {
        return ordersGroup;
    }

    private int noOrdersGroupCounter = MISSING_INT;

    private boolean hasNoOrdersGroupCounter;

    /* NoOrdersGroupCounter = 73 */
    public int noOrdersGroupCounter()
    {
        if (!hasNoOrdersGroupCounter)
        {
            throw new IllegalArgumentException("No value for optional field: NoOrdersGroupCounter");
        }

        return noOrdersGroupCounter;
    }

    public boolean hasNoOrdersGroupCounter()
    {
        return hasNoOrdersGroupCounter;
    }




    private OrdersGroupIterator ordersGroupIterator = new OrdersGroupIterator(this);
    public OrdersGroupIterator ordersGroupIterator()
    {
        return ordersGroupIterator.iterator();
    }

    public int decode(final AsciiBuffer buffer, final int offset, final int length)
    {
        // Decode NewOrderList
        int seenFieldCount = 0;
        if (CODEC_VALIDATION_ENABLED)
        {
            missingRequiredFields.copy(REQUIRED_FIELDS);
            alreadyVisitedFields.clear();
        }
        this.buffer = buffer;
        final int end = offset + length;
        int position = offset;
        position += header.decode(buffer, position, length);
        int tag;

        while (position < end)
        {
            final int equalsPosition = buffer.scan(position, end, '=');
            if (equalsPosition == AsciiBuffer.UNKNOWN_INDEX)
            {
               return position;
            }
            tag = buffer.getInt(position, equalsPosition);
            final int valueOffset = equalsPosition + 1;
            int endOfField = buffer.scan(valueOffset, end, START_OF_HEADER);
            if (endOfField == AsciiBuffer.UNKNOWN_INDEX || equalsPosition == AsciiBuffer.UNKNOWN_INDEX)
            {
                rejectReason = 5;
                break;
            }
            final int valueLength = endOfField - valueOffset;
            if (CODEC_VALIDATION_ENABLED)
            {
                if (tag <= 0)
                {
                    invalidTagId = tag;
                    rejectReason = 0;
                }
                else if (valueLength == 0)
                {
                    invalidTagId = tag;
                    rejectReason = 4;
                }
                if (!alreadyVisitedFields.add(tag))
                {
                    invalidTagId = tag;
                    rejectReason = 13;
                }
                missingRequiredFields.remove(tag);
                seenFieldCount++;
            }

            switch (tag)
            {
            case Constants.LIST_ID:
                listID = buffer.getChars(listID, valueOffset, valueLength);
                listIDOffset = valueOffset;
                listIDLength = valueLength;
                break;

            case Constants.BID_ID:
                hasBidID = true;
                bidID = buffer.getChars(bidID, valueOffset, valueLength);
                bidIDOffset = valueOffset;
                bidIDLength = valueLength;
                break;

            case Constants.CLIENT_BID_ID:
                hasClientBidID = true;
                clientBidID = buffer.getChars(clientBidID, valueOffset, valueLength);
                clientBidIDOffset = valueOffset;
                clientBidIDLength = valueLength;
                break;

            case Constants.PROG_RPT_REQS:
                hasProgRptReqs = true;
                progRptReqs = getInt(buffer, valueOffset, endOfField, 414, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.BID_TYPE:
                bidType = getInt(buffer, valueOffset, endOfField, 394, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.PROG_PERIOD_INTERVAL:
                hasProgPeriodInterval = true;
                progPeriodInterval = getInt(buffer, valueOffset, endOfField, 415, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.CANCELLATION_RIGHTS:
                hasCancellationRights = true;
                cancellationRights = buffer.getChar(valueOffset);
                break;

            case Constants.MONEY_LAUNDERING_STATUS:
                hasMoneyLaunderingStatus = true;
                moneyLaunderingStatus = buffer.getChar(valueOffset);
                break;

            case Constants.REGIST_ID:
                hasRegistID = true;
                registID = buffer.getChars(registID, valueOffset, valueLength);
                registIDOffset = valueOffset;
                registIDLength = valueLength;
                break;

            case Constants.LIST_EXEC_INST_TYPE:
                hasListExecInstType = true;
                listExecInstType = buffer.getChar(valueOffset);
                break;

            case Constants.LIST_EXEC_INST:
                hasListExecInst = true;
                listExecInst = buffer.getChars(listExecInst, valueOffset, valueLength);
                listExecInstOffset = valueOffset;
                listExecInstLength = valueLength;
                break;

            case Constants.ENCODED_LIST_EXEC_INST_LEN:
                hasEncodedListExecInstLen = true;
                encodedListExecInstLen = getInt(buffer, valueOffset, endOfField, 352, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.ENCODED_LIST_EXEC_INST:
                hasEncodedListExecInst = true;
                encodedListExecInst = buffer.getBytes(encodedListExecInst, valueOffset, encodedListExecInstLen);
                endOfField = valueOffset + encodedListExecInstLen;
                break;

            case Constants.ALLOWABLE_ONE_SIDEDNESS_PCT:
                hasAllowableOneSidednessPct = true;
                allowableOneSidednessPct = getFloat(buffer, allowableOneSidednessPct, valueOffset, valueLength, 765, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.ALLOWABLE_ONE_SIDEDNESS_VALUE:
                hasAllowableOneSidednessValue = true;
                allowableOneSidednessValue = getFloat(buffer, allowableOneSidednessValue, valueOffset, valueLength, 766, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.ALLOWABLE_ONE_SIDEDNESS_CURR:
                hasAllowableOneSidednessCurr = true;
                allowableOneSidednessCurr = buffer.getChars(allowableOneSidednessCurr, valueOffset, valueLength);
                allowableOneSidednessCurrOffset = valueOffset;
                allowableOneSidednessCurrLength = valueLength;
                break;

            case Constants.TOT_NO_ORDERS:
                totNoOrders = getInt(buffer, valueOffset, endOfField, 68, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.LAST_FRAGMENT:
                hasLastFragment = true;
                lastFragment = buffer.getBoolean(valueOffset);
                break;

            case Constants.NO_ORDERS_GROUP_COUNTER:
                hasNoOrdersGroupCounter = true;
                noOrdersGroupCounter = getInt(buffer, valueOffset, endOfField, 73, CODEC_VALIDATION_ENABLED);
                if (ordersGroup == null)
                {
                    ordersGroup = new OrdersGroupDecoder(trailer, messageFields);
                }
                OrdersGroupDecoder ordersGroupCurrent = ordersGroup;
                position = endOfField + 1;
                final int noOrdersGroupCounter = this.noOrdersGroupCounter;
                for (int i = 0; i < noOrdersGroupCounter && position < end; i++)
                {
                    if (ordersGroupCurrent != null)
                    {
                        position += ordersGroupCurrent.decode(buffer, position, end - position);
                        ordersGroupCurrent = ordersGroupCurrent.next();
                    }
                }
                if (CODEC_VALIDATION_ENABLED)
                {
                    final int checkEqualsPosition = buffer.scan(position, end, '=');
                    if (checkEqualsPosition != AsciiBuffer.UNKNOWN_INDEX)
                    {
                        final int checkTag = buffer.getInt(position, checkEqualsPosition);
                        if (ordersGroup.ALL_GROUP_FIELDS.contains(checkTag))
                        {
                            invalidTagId = tag;
                            rejectReason = 16;
                            return position;
                        }
                    }
                }
                break;

            default:
                if (!CODEC_REJECT_UNKNOWN_FIELD_ENABLED)
                {
                    alreadyVisitedFields.remove(tag);
                }
                else
                {
                    if (!(trailer.REQUIRED_FIELDS.contains(tag)))
                    {
                        unknownFields.add(tag);
                    }
                }
                if (CODEC_REJECT_UNKNOWN_FIELD_ENABLED || (trailer.REQUIRED_FIELDS.contains(tag)))
                {
                    position += trailer.decode(buffer, position, end - position);
                    return position - offset;
                }

            }

            if (position < (endOfField + 1))
            {
                position = endOfField + 1;
            }
        }
        position += trailer.decode(buffer, position, end - position);
        return position - offset;
    }

    public void reset()
    {
        header.reset();
        trailer.reset();
        resetMessage();
        buffer = null;
        if (CODEC_VALIDATION_ENABLED)
        {
            invalidTagId = Decoder.NO_ERROR;
            rejectReason = Decoder.NO_ERROR;
            missingRequiredFields.clear();
            unknownFields.clear();
            alreadyVisitedFields.clear();
        }
    }

    public void resetMessage()
    {
        this.resetListID();
        this.resetBidID();
        this.resetClientBidID();
        this.resetProgRptReqs();
        this.resetBidType();
        this.resetProgPeriodInterval();
        this.resetCancellationRights();
        this.resetMoneyLaunderingStatus();
        this.resetRegistID();
        this.resetListExecInstType();
        this.resetListExecInst();
        this.resetEncodedListExecInstLen();
        this.resetEncodedListExecInst();
        this.resetAllowableOneSidednessPct();
        this.resetAllowableOneSidednessValue();
        this.resetAllowableOneSidednessCurr();
        this.resetTotNoOrders();
        this.resetLastFragment();
        this.resetOrdersGroup();
    }

    public void resetListID()
    {
        listIDOffset = 0;
        listIDLength = 0;
    }

    public void resetBidID()
    {
        hasBidID = false;
    }

    public void resetClientBidID()
    {
        hasClientBidID = false;
    }

    public void resetProgRptReqs()
    {
        hasProgRptReqs = false;
    }

    public void resetBidType()
    {
        bidType = MISSING_INT;
    }

    public void resetProgPeriodInterval()
    {
        hasProgPeriodInterval = false;
    }

    public void resetCancellationRights()
    {
        hasCancellationRights = false;
    }

    public void resetMoneyLaunderingStatus()
    {
        hasMoneyLaunderingStatus = false;
    }

    public void resetRegistID()
    {
        hasRegistID = false;
    }

    public void resetListExecInstType()
    {
        hasListExecInstType = false;
    }

    public void resetListExecInst()
    {
        hasListExecInst = false;
    }

    public void resetEncodedListExecInstLen()
    {
        hasEncodedListExecInstLen = false;
    }

    public void resetEncodedListExecInst()
    {
        hasEncodedListExecInst = false;
    }

    public void resetAllowableOneSidednessPct()
    {
        hasAllowableOneSidednessPct = false;
    }

    public void resetAllowableOneSidednessValue()
    {
        hasAllowableOneSidednessValue = false;
    }

    public void resetAllowableOneSidednessCurr()
    {
        hasAllowableOneSidednessCurr = false;
    }

    public void resetTotNoOrders()
    {
        totNoOrders = MISSING_INT;
    }

    public void resetLastFragment()
    {
        hasLastFragment = false;
    }

    public void resetOrdersGroup()
    {
        for (final OrdersGroupDecoder ordersGroupDecoder : ordersGroupIterator.iterator())
        {
            ordersGroupDecoder.reset();
            if (ordersGroupDecoder.next() == null)
            {
                break;
            }
        }
        noOrdersGroupCounter = MISSING_INT;
        hasNoOrdersGroupCounter = false;
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
        builder.append("\"MessageName\": \"NewOrderList\",\n");
        builder.append("  \"header\": ");
        header.appendTo(builder, level + 1);
        builder.append("\n");
        indent(builder, level);
        builder.append("\"ListID\": \"");
        builder.append(this.listID(), 0, listIDLength());
        builder.append("\",\n");

        if (hasBidID())
        {
            indent(builder, level);
            builder.append("\"BidID\": \"");
            builder.append(this.bidID(), 0, bidIDLength());
            builder.append("\",\n");
        }

        if (hasClientBidID())
        {
            indent(builder, level);
            builder.append("\"ClientBidID\": \"");
            builder.append(this.clientBidID(), 0, clientBidIDLength());
            builder.append("\",\n");
        }

        if (hasProgRptReqs())
        {
            indent(builder, level);
            builder.append("\"ProgRptReqs\": \"");
            builder.append(progRptReqs);
            builder.append("\",\n");
        }

        indent(builder, level);
        builder.append("\"BidType\": \"");
        builder.append(bidType);
        builder.append("\",\n");

        if (hasProgPeriodInterval())
        {
            indent(builder, level);
            builder.append("\"ProgPeriodInterval\": \"");
            builder.append(progPeriodInterval);
            builder.append("\",\n");
        }

        if (hasCancellationRights())
        {
            indent(builder, level);
            builder.append("\"CancellationRights\": \"");
            builder.append(cancellationRights);
            builder.append("\",\n");
        }

        if (hasMoneyLaunderingStatus())
        {
            indent(builder, level);
            builder.append("\"MoneyLaunderingStatus\": \"");
            builder.append(moneyLaunderingStatus);
            builder.append("\",\n");
        }

        if (hasRegistID())
        {
            indent(builder, level);
            builder.append("\"RegistID\": \"");
            builder.append(this.registID(), 0, registIDLength());
            builder.append("\",\n");
        }

        if (hasListExecInstType())
        {
            indent(builder, level);
            builder.append("\"ListExecInstType\": \"");
            builder.append(listExecInstType);
            builder.append("\",\n");
        }

        if (hasListExecInst())
        {
            indent(builder, level);
            builder.append("\"ListExecInst\": \"");
            builder.append(this.listExecInst(), 0, listExecInstLength());
            builder.append("\",\n");
        }

        if (hasEncodedListExecInstLen())
        {
            indent(builder, level);
            builder.append("\"EncodedListExecInstLen\": \"");
            builder.append(encodedListExecInstLen);
            builder.append("\",\n");
        }

        if (hasEncodedListExecInst())
        {
            indent(builder, level);
            builder.append("\"EncodedListExecInst\": \"");
            appendData(builder, encodedListExecInst, encodedListExecInstLen);
            builder.append("\",\n");
        }

        if (hasAllowableOneSidednessPct())
        {
            indent(builder, level);
            builder.append("\"AllowableOneSidednessPct\": \"");
            allowableOneSidednessPct.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasAllowableOneSidednessValue())
        {
            indent(builder, level);
            builder.append("\"AllowableOneSidednessValue\": \"");
            allowableOneSidednessValue.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasAllowableOneSidednessCurr())
        {
            indent(builder, level);
            builder.append("\"AllowableOneSidednessCurr\": \"");
            builder.append(this.allowableOneSidednessCurr(), 0, allowableOneSidednessCurrLength());
            builder.append("\",\n");
        }

        indent(builder, level);
        builder.append("\"TotNoOrders\": \"");
        builder.append(totNoOrders);
        builder.append("\",\n");

        if (hasLastFragment())
        {
            indent(builder, level);
            builder.append("\"LastFragment\": \"");
            builder.append(lastFragment);
            builder.append("\",\n");
        }

        if (hasNoOrdersGroupCounter)
        {
            indent(builder, level);
            builder.append("\"OrdersGroup\": [\n");
            OrdersGroupDecoder ordersGroup = this.ordersGroup;
            for (int i = 0, size = this.noOrdersGroupCounter; i < size; i++)
            {
                indent(builder, level);
                ordersGroup.appendTo(builder, level + 1);
                if (ordersGroup.next() != null)
                {
                    builder.append(',');
                }
                builder.append('\n');
                ordersGroup = ordersGroup.next();            }
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
    public NewOrderListEncoder toEncoder(final Encoder encoder)
    {
        return toEncoder((NewOrderListEncoder)encoder);
    }

    public NewOrderListEncoder toEncoder(final NewOrderListEncoder encoder)
    {
        encoder.reset();
        encoder.listID(this.listID(), 0, listIDLength());
        if (hasBidID())
        {
            encoder.bidID(this.bidID(), 0, bidIDLength());
        }

        if (hasClientBidID())
        {
            encoder.clientBidID(this.clientBidID(), 0, clientBidIDLength());
        }

        if (hasProgRptReqs())
        {
            encoder.progRptReqs(this.progRptReqs());
        }

        encoder.bidType(this.bidType());
        if (hasProgPeriodInterval())
        {
            encoder.progPeriodInterval(this.progPeriodInterval());
        }

        if (hasCancellationRights())
        {
            encoder.cancellationRights(this.cancellationRights());
        }

        if (hasMoneyLaunderingStatus())
        {
            encoder.moneyLaunderingStatus(this.moneyLaunderingStatus());
        }

        if (hasRegistID())
        {
            encoder.registID(this.registID(), 0, registIDLength());
        }

        if (hasListExecInstType())
        {
            encoder.listExecInstType(this.listExecInstType());
        }

        if (hasListExecInst())
        {
            encoder.listExecInst(this.listExecInst(), 0, listExecInstLength());
        }

        if (hasEncodedListExecInstLen())
        {
            encoder.encodedListExecInstLen(this.encodedListExecInstLen());
        }

        if (hasEncodedListExecInst())
        {
            encoder.encodedListExecInstAsCopy(this.encodedListExecInst(), 0, encodedListExecInstLen());
            encoder.encodedListExecInstLen(this.encodedListExecInstLen());
        }

        if (hasAllowableOneSidednessPct())
        {
            encoder.allowableOneSidednessPct(this.allowableOneSidednessPct());
        }

        if (hasAllowableOneSidednessValue())
        {
            encoder.allowableOneSidednessValue(this.allowableOneSidednessValue());
        }

        if (hasAllowableOneSidednessCurr())
        {
            encoder.allowableOneSidednessCurr(this.allowableOneSidednessCurr(), 0, allowableOneSidednessCurrLength());
        }

        encoder.totNoOrders(this.totNoOrders());
        if (hasLastFragment())
        {
            encoder.lastFragment(this.lastFragment());
        }

        if (hasNoOrdersGroupCounter)
        {
            final int size = this.noOrdersGroupCounter;
            OrdersGroupDecoder ordersGroup = this.ordersGroup;
            OrdersGroupEncoder ordersGroupEncoder = encoder.ordersGroup(size);
            for (int i = 0; i < size; i++)
            {
                if (ordersGroup != null)
                {
                    ordersGroup.toEncoder(ordersGroupEncoder);
                    ordersGroup = ordersGroup.next();
                    ordersGroupEncoder = ordersGroupEncoder.next();
                }
            }
        }
        return encoder;
    }

}
