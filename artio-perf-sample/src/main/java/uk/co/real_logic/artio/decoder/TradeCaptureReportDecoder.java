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
import uk.co.real_logic.artio.builder.TradeCaptureReportEncoder;
import uk.co.real_logic.artio.builder.InstrumentEncoder;
import static uk.co.real_logic.artio.builder.InstrumentEncoder.SecurityAltIDGroupEncoder;
import static uk.co.real_logic.artio.builder.InstrumentEncoder.EventsGroupEncoder;
import uk.co.real_logic.artio.builder.FinancingDetailsEncoder;
import uk.co.real_logic.artio.builder.OrderQtyDataEncoder;
import uk.co.real_logic.artio.builder.YieldDataEncoder;
import static uk.co.real_logic.artio.builder.TradeCaptureReportEncoder.UnderlyingsGroupEncoder;
import uk.co.real_logic.artio.builder.UnderlyingInstrumentEncoder;
import static uk.co.real_logic.artio.builder.UnderlyingInstrumentEncoder.UnderlyingSecurityAltIDGroupEncoder;
import uk.co.real_logic.artio.builder.UnderlyingStipulationsEncoder;
import static uk.co.real_logic.artio.builder.UnderlyingStipulationsEncoder.UnderlyingStipsGroupEncoder;
import uk.co.real_logic.artio.builder.SpreadOrBenchmarkCurveDataEncoder;
import uk.co.real_logic.artio.builder.PositionAmountDataEncoder;
import static uk.co.real_logic.artio.builder.TradeCaptureReportEncoder.LegsGroupEncoder;
import uk.co.real_logic.artio.builder.InstrumentLegEncoder;
import static uk.co.real_logic.artio.builder.InstrumentLegEncoder.LegSecurityAltIDGroupEncoder;
import uk.co.real_logic.artio.builder.LegStipulationsEncoder;
import static uk.co.real_logic.artio.builder.LegStipulationsEncoder.LegStipulationsGroupEncoder;
import uk.co.real_logic.artio.builder.NestedPartiesEncoder;
import static uk.co.real_logic.artio.builder.NestedPartiesEncoder.NestedPartyIDsGroupEncoder;
import static uk.co.real_logic.artio.builder.NestedPartiesEncoder.NestedPartyIDsGroupEncoder.NestedPartySubIDsGroupEncoder;
import uk.co.real_logic.artio.builder.TrdRegTimestampsEncoder;
import static uk.co.real_logic.artio.builder.TrdRegTimestampsEncoder.TrdRegTimestampsGroupEncoder;
import static uk.co.real_logic.artio.builder.TradeCaptureReportEncoder.SidesGroupEncoder;
import uk.co.real_logic.artio.builder.PartiesEncoder;
import static uk.co.real_logic.artio.builder.PartiesEncoder.PartyIDsGroupEncoder;
import static uk.co.real_logic.artio.builder.PartiesEncoder.PartyIDsGroupEncoder.PartySubIDsGroupEncoder;
import static uk.co.real_logic.artio.builder.TradeCaptureReportEncoder.SidesGroupEncoder.ClearingInstructionsGroupEncoder;
import uk.co.real_logic.artio.builder.CommissionDataEncoder;
import static uk.co.real_logic.artio.builder.TradeCaptureReportEncoder.SidesGroupEncoder.ContAmtsGroupEncoder;
import uk.co.real_logic.artio.builder.StipulationsEncoder;
import static uk.co.real_logic.artio.builder.StipulationsEncoder.StipulationsGroupEncoder;
import static uk.co.real_logic.artio.builder.TradeCaptureReportEncoder.SidesGroupEncoder.MiscFeesGroupEncoder;
import static uk.co.real_logic.artio.builder.TradeCaptureReportEncoder.SidesGroupEncoder.AllocsGroupEncoder;
import uk.co.real_logic.artio.builder.NestedParties2Encoder;
import static uk.co.real_logic.artio.builder.NestedParties2Encoder.Nested2PartyIDsGroupEncoder;
import static uk.co.real_logic.artio.builder.NestedParties2Encoder.Nested2PartyIDsGroupEncoder.Nested2PartySubIDsGroupEncoder;

@Generated("uk.co.real_logic.artio")
public class TradeCaptureReportDecoder extends CommonDecoderImpl implements InstrumentDecoder, FinancingDetailsDecoder, OrderQtyDataDecoder, YieldDataDecoder, SpreadOrBenchmarkCurveDataDecoder, PositionAmountDataDecoder, TrdRegTimestampsDecoder, MessageDecoder
{
    public final IntHashSet REQUIRED_FIELDS = new IntHashSet(16);

    {
        if (CODEC_VALIDATION_ENABLED)
        {
            REQUIRED_FIELDS.add(Constants.TRADE_REPORT_ID);
            REQUIRED_FIELDS.add(Constants.PREVIOUSLY_REPORTED);
            REQUIRED_FIELDS.add(Constants.SYMBOL);
            REQUIRED_FIELDS.add(Constants.LAST_QTY);
            REQUIRED_FIELDS.add(Constants.LAST_PX);
            REQUIRED_FIELDS.add(Constants.TRADE_DATE);
            REQUIRED_FIELDS.add(Constants.TRANSACT_TIME);
            REQUIRED_FIELDS.add(Constants.NO_SIDES_GROUP_COUNTER);
        }
    }

    public final IntHashSet GROUP_FIELDS = new IntHashSet(236);

    {
        if (CODEC_VALIDATION_ENABLED)
        {
            GROUP_FIELDS.add(Constants.TRADE_REPORT_ID);
            GROUP_FIELDS.add(Constants.TRADE_REPORT_TRANS_TYPE);
            GROUP_FIELDS.add(Constants.TRADE_REPORT_TYPE);
            GROUP_FIELDS.add(Constants.TRADE_REQUEST_ID);
            GROUP_FIELDS.add(Constants.TRD_TYPE);
            GROUP_FIELDS.add(Constants.TRD_SUB_TYPE);
            GROUP_FIELDS.add(Constants.SECONDARY_TRD_TYPE);
            GROUP_FIELDS.add(Constants.TRANSFER_REASON);
            GROUP_FIELDS.add(Constants.EXEC_TYPE);
            GROUP_FIELDS.add(Constants.TOT_NUM_TRADE_REPORTS);
            GROUP_FIELDS.add(Constants.LAST_RPT_REQUESTED);
            GROUP_FIELDS.add(Constants.UNSOLICITED_INDICATOR);
            GROUP_FIELDS.add(Constants.SUBSCRIPTION_REQUEST_TYPE);
            GROUP_FIELDS.add(Constants.TRADE_REPORT_REF_ID);
            GROUP_FIELDS.add(Constants.SECONDARY_TRADE_REPORT_REF_ID);
            GROUP_FIELDS.add(Constants.SECONDARY_TRADE_REPORT_ID);
            GROUP_FIELDS.add(Constants.TRADE_LINK_ID);
            GROUP_FIELDS.add(Constants.TRD_MATCH_ID);
            GROUP_FIELDS.add(Constants.EXEC_ID);
            GROUP_FIELDS.add(Constants.ORD_STATUS);
            GROUP_FIELDS.add(Constants.SECONDARY_EXEC_ID);
            GROUP_FIELDS.add(Constants.EXEC_RESTATEMENT_REASON);
            GROUP_FIELDS.add(Constants.PREVIOUSLY_REPORTED);
            GROUP_FIELDS.add(Constants.PRICE_TYPE);
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
            GROUP_FIELDS.add(Constants.AGREEMENT_DESC);
            GROUP_FIELDS.add(Constants.AGREEMENT_ID);
            GROUP_FIELDS.add(Constants.AGREEMENT_DATE);
            GROUP_FIELDS.add(Constants.AGREEMENT_CURRENCY);
            GROUP_FIELDS.add(Constants.TERMINATION_TYPE);
            GROUP_FIELDS.add(Constants.START_DATE);
            GROUP_FIELDS.add(Constants.END_DATE);
            GROUP_FIELDS.add(Constants.DELIVERY_TYPE);
            GROUP_FIELDS.add(Constants.MARGIN_RATIO);
            GROUP_FIELDS.add(Constants.ORDER_QTY);
            GROUP_FIELDS.add(Constants.CASH_ORDER_QTY);
            GROUP_FIELDS.add(Constants.ORDER_PERCENT);
            GROUP_FIELDS.add(Constants.ROUNDING_DIRECTION);
            GROUP_FIELDS.add(Constants.ROUNDING_MODULUS);
            GROUP_FIELDS.add(Constants.QTY_TYPE);
            GROUP_FIELDS.add(Constants.YIELD_TYPE);
            GROUP_FIELDS.add(Constants.YIELD);
            GROUP_FIELDS.add(Constants.YIELD_CALC_DATE);
            GROUP_FIELDS.add(Constants.YIELD_REDEMPTION_DATE);
            GROUP_FIELDS.add(Constants.YIELD_REDEMPTION_PRICE);
            GROUP_FIELDS.add(Constants.YIELD_REDEMPTION_PRICE_TYPE);
            GROUP_FIELDS.add(Constants.UNDERLYING_TRADING_SESSION_ID);
            GROUP_FIELDS.add(Constants.UNDERLYING_TRADING_SESSION_SUB_ID);
            GROUP_FIELDS.add(Constants.LAST_QTY);
            GROUP_FIELDS.add(Constants.LAST_PX);
            GROUP_FIELDS.add(Constants.LAST_PAR_PX);
            GROUP_FIELDS.add(Constants.LAST_SPOT_RATE);
            GROUP_FIELDS.add(Constants.LAST_FORWARD_POINTS);
            GROUP_FIELDS.add(Constants.LAST_MKT);
            GROUP_FIELDS.add(Constants.TRADE_DATE);
            GROUP_FIELDS.add(Constants.CLEARING_BUSINESS_DATE);
            GROUP_FIELDS.add(Constants.AVG_PX);
            GROUP_FIELDS.add(Constants.SPREAD);
            GROUP_FIELDS.add(Constants.BENCHMARK_CURVE_CURRENCY);
            GROUP_FIELDS.add(Constants.BENCHMARK_CURVE_NAME);
            GROUP_FIELDS.add(Constants.BENCHMARK_CURVE_POINT);
            GROUP_FIELDS.add(Constants.BENCHMARK_PRICE);
            GROUP_FIELDS.add(Constants.BENCHMARK_PRICE_TYPE);
            GROUP_FIELDS.add(Constants.BENCHMARK_SECURITY_ID);
            GROUP_FIELDS.add(Constants.BENCHMARK_SECURITY_ID_SOURCE);
            GROUP_FIELDS.add(Constants.AVG_PX_INDICATOR);
            GROUP_FIELDS.add(Constants.NO_POS_AMT);
            GROUP_FIELDS.add(Constants.POS_AMT_TYPE);
            GROUP_FIELDS.add(Constants.POS_AMT);
            GROUP_FIELDS.add(Constants.MULTI_LEG_REPORTING_TYPE);
            GROUP_FIELDS.add(Constants.TRADE_LEG_REF_ID);
            GROUP_FIELDS.add(Constants.TRANSACT_TIME);
            GROUP_FIELDS.add(Constants.SETTL_TYPE);
            GROUP_FIELDS.add(Constants.SETTL_DATE);
            GROUP_FIELDS.add(Constants.MATCH_STATUS);
            GROUP_FIELDS.add(Constants.MATCH_TYPE);
            GROUP_FIELDS.add(Constants.COPY_MSG_INDICATOR);
            GROUP_FIELDS.add(Constants.PUBLISH_TRD_INDICATOR);
            GROUP_FIELDS.add(Constants.SHORT_SALE_REASON);
        }
    }

    private final IntHashSet alreadyVisitedFields = new IntHashSet(236);

    private final IntHashSet unknownFields = new IntHashSet(10);

    private final IntHashSet missingRequiredFields = new IntHashSet(16);

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
        if (hasTradeReportTransType)
        {
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !TradeReportTransType.isValid(tradeReportTransType()))
        {
            invalidTagId = 487;
            rejectReason = 5;
            return false;
        }
        }

        if (hasTradeReportType)
        {
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !TradeReportType.isValid(tradeReportType()))
        {
            invalidTagId = 856;
            rejectReason = 5;
            return false;
        }
        }

        if (hasTrdType)
        {
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !TrdType.isValid(trdType()))
        {
            invalidTagId = 828;
            rejectReason = 5;
            return false;
        }
        }

        if (hasExecType)
        {
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !ExecType.isValid(execType()))
        {
            invalidTagId = 150;
            rejectReason = 5;
            return false;
        }
        }

        if (hasSubscriptionRequestType)
        {
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !SubscriptionRequestType.isValid(subscriptionRequestType()))
        {
            invalidTagId = 263;
            rejectReason = 5;
            return false;
        }
        }

        if (hasOrdStatus)
        {
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !OrdStatus.isValid(ordStatus()))
        {
            invalidTagId = 39;
            rejectReason = 5;
            return false;
        }
        }

        if (hasExecRestatementReason)
        {
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !ExecRestatementReason.isValid(execRestatementReason()))
        {
            invalidTagId = 378;
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

        if (hasTerminationType)
        {
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !TerminationType.isValid(terminationType()))
        {
            invalidTagId = 788;
            rejectReason = 5;
            return false;
        }
        }

        if (hasDeliveryType)
        {
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !DeliveryType.isValid(deliveryType()))
        {
            invalidTagId = 919;
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

        if (hasQtyType)
        {
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !QtyType.isValid(qtyType()))
        {
            invalidTagId = 854;
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

        if (hasAvgPxIndicator)
        {
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !AvgPxIndicator.isValid(avgPxIndicator()))
        {
            invalidTagId = 819;
            rejectReason = 5;
            return false;
        }
        }

        posAmtTypeWrapper.wrap(this.posAmtType(), posAmtTypeLength);
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !PosAmtType.isValid(posAmtTypeWrapper))
        {
            invalidTagId = 707;
            rejectReason = 5;
            return false;
        }

        if (hasMultiLegReportingType)
        {
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !MultiLegReportingType.isValid(multiLegReportingType()))
        {
            invalidTagId = 442;
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

        if (hasMatchStatus)
        {
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !MatchStatus.isValid(matchStatus()))
        {
            invalidTagId = 573;
            rejectReason = 5;
            return false;
        }
        }

        if (hasShortSaleReason)
        {
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !ShortSaleReason.isValid(shortSaleReason()))
        {
            invalidTagId = 853;
            rejectReason = 5;
            return false;
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

        if (hasNoLegsGroupCounter)
        {
            {
                int count = 0;
                final LegsGroupIterator iterator = legsGroupIterator.iterator();
                for (final LegsGroupDecoder group : iterator)
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
                    invalidTagId = 555;
                    rejectReason = 16;
                    return false;
                }
            }
        }

        {
            int count = 0;
            final TrdRegTimestampsGroupIterator iterator = trdRegTimestampsGroupIterator.iterator();
            for (final TrdRegTimestampsGroupDecoder group : iterator)
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
                invalidTagId = 768;
                rejectReason = 16;
                return false;
            }
        }

        {
            int count = 0;
            final SidesGroupIterator iterator = sidesGroupIterator.iterator();
            for (final SidesGroupDecoder group : iterator)
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
                invalidTagId = 552;
                rejectReason = 16;
                return false;
            }
        }
        return true;
    }

    public static final long MESSAGE_TYPE = 17729L;

    public static final String MESSAGE_TYPE_AS_STRING = "AE";

    public static final char[] MESSAGE_TYPE_CHARS = MESSAGE_TYPE_AS_STRING.toCharArray();

    public static final byte[] MESSAGE_TYPE_BYTES = MESSAGE_TYPE_AS_STRING.getBytes(US_ASCII);

    public final IntHashSet messageFields = new IntHashSet(730);

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
        messageFields.add(Constants.TRADE_REPORT_ID);
        messageFields.add(Constants.TRADE_REPORT_TRANS_TYPE);
        messageFields.add(Constants.TRADE_REPORT_TYPE);
        messageFields.add(Constants.TRADE_REQUEST_ID);
        messageFields.add(Constants.TRD_TYPE);
        messageFields.add(Constants.TRD_SUB_TYPE);
        messageFields.add(Constants.SECONDARY_TRD_TYPE);
        messageFields.add(Constants.TRANSFER_REASON);
        messageFields.add(Constants.EXEC_TYPE);
        messageFields.add(Constants.TOT_NUM_TRADE_REPORTS);
        messageFields.add(Constants.LAST_RPT_REQUESTED);
        messageFields.add(Constants.UNSOLICITED_INDICATOR);
        messageFields.add(Constants.SUBSCRIPTION_REQUEST_TYPE);
        messageFields.add(Constants.TRADE_REPORT_REF_ID);
        messageFields.add(Constants.SECONDARY_TRADE_REPORT_REF_ID);
        messageFields.add(Constants.SECONDARY_TRADE_REPORT_ID);
        messageFields.add(Constants.TRADE_LINK_ID);
        messageFields.add(Constants.TRD_MATCH_ID);
        messageFields.add(Constants.EXEC_ID);
        messageFields.add(Constants.ORD_STATUS);
        messageFields.add(Constants.SECONDARY_EXEC_ID);
        messageFields.add(Constants.EXEC_RESTATEMENT_REASON);
        messageFields.add(Constants.PREVIOUSLY_REPORTED);
        messageFields.add(Constants.PRICE_TYPE);
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
        messageFields.add(Constants.AGREEMENT_DESC);
        messageFields.add(Constants.AGREEMENT_ID);
        messageFields.add(Constants.AGREEMENT_DATE);
        messageFields.add(Constants.AGREEMENT_CURRENCY);
        messageFields.add(Constants.TERMINATION_TYPE);
        messageFields.add(Constants.START_DATE);
        messageFields.add(Constants.END_DATE);
        messageFields.add(Constants.DELIVERY_TYPE);
        messageFields.add(Constants.MARGIN_RATIO);
        messageFields.add(Constants.ORDER_QTY);
        messageFields.add(Constants.CASH_ORDER_QTY);
        messageFields.add(Constants.ORDER_PERCENT);
        messageFields.add(Constants.ROUNDING_DIRECTION);
        messageFields.add(Constants.ROUNDING_MODULUS);
        messageFields.add(Constants.QTY_TYPE);
        messageFields.add(Constants.YIELD_TYPE);
        messageFields.add(Constants.YIELD);
        messageFields.add(Constants.YIELD_CALC_DATE);
        messageFields.add(Constants.YIELD_REDEMPTION_DATE);
        messageFields.add(Constants.YIELD_REDEMPTION_PRICE);
        messageFields.add(Constants.YIELD_REDEMPTION_PRICE_TYPE);
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
        messageFields.add(Constants.UNDERLYING_TRADING_SESSION_ID);
        messageFields.add(Constants.UNDERLYING_TRADING_SESSION_SUB_ID);
        messageFields.add(Constants.LAST_QTY);
        messageFields.add(Constants.LAST_PX);
        messageFields.add(Constants.LAST_PAR_PX);
        messageFields.add(Constants.LAST_SPOT_RATE);
        messageFields.add(Constants.LAST_FORWARD_POINTS);
        messageFields.add(Constants.LAST_MKT);
        messageFields.add(Constants.TRADE_DATE);
        messageFields.add(Constants.CLEARING_BUSINESS_DATE);
        messageFields.add(Constants.AVG_PX);
        messageFields.add(Constants.SPREAD);
        messageFields.add(Constants.BENCHMARK_CURVE_CURRENCY);
        messageFields.add(Constants.BENCHMARK_CURVE_NAME);
        messageFields.add(Constants.BENCHMARK_CURVE_POINT);
        messageFields.add(Constants.BENCHMARK_PRICE);
        messageFields.add(Constants.BENCHMARK_PRICE_TYPE);
        messageFields.add(Constants.BENCHMARK_SECURITY_ID);
        messageFields.add(Constants.BENCHMARK_SECURITY_ID_SOURCE);
        messageFields.add(Constants.AVG_PX_INDICATOR);
        messageFields.add(Constants.NO_POS_AMT);
        messageFields.add(Constants.POS_AMT_TYPE);
        messageFields.add(Constants.POS_AMT);
        messageFields.add(Constants.MULTI_LEG_REPORTING_TYPE);
        messageFields.add(Constants.TRADE_LEG_REF_ID);
        messageFields.add(Constants.NO_LEGS_GROUP_COUNTER);
        messageFields.add(Constants.LEG_SYMBOL);
        messageFields.add(Constants.LEG_SYMBOL_SFX);
        messageFields.add(Constants.LEG_SECURITY_ID);
        messageFields.add(Constants.LEG_SECURITY_ID_SOURCE);
        messageFields.add(Constants.NO_LEG_SECURITY_ALT_ID_GROUP_COUNTER);
        messageFields.add(Constants.LEG_SECURITY_ALT_ID);
        messageFields.add(Constants.LEG_SECURITY_ALT_ID_SOURCE);
        messageFields.add(Constants.LEG_PRODUCT);
        messageFields.add(Constants.LEG_C_F_I_CODE);
        messageFields.add(Constants.LEG_SECURITY_TYPE);
        messageFields.add(Constants.LEG_SECURITY_SUB_TYPE);
        messageFields.add(Constants.LEG_MATURITY_MONTH_YEAR);
        messageFields.add(Constants.LEG_MATURITY_DATE);
        messageFields.add(Constants.LEG_COUPON_PAYMENT_DATE);
        messageFields.add(Constants.LEG_ISSUE_DATE);
        messageFields.add(Constants.LEG_REPO_COLLATERAL_SECURITY_TYPE);
        messageFields.add(Constants.LEG_REPURCHASE_TERM);
        messageFields.add(Constants.LEG_REPURCHASE_RATE);
        messageFields.add(Constants.LEG_FACTOR);
        messageFields.add(Constants.LEG_CREDIT_RATING);
        messageFields.add(Constants.LEG_INSTR_REGISTRY);
        messageFields.add(Constants.LEG_COUNTRY_OF_ISSUE);
        messageFields.add(Constants.LEG_STATE_OR_PROVINCE_OF_ISSUE);
        messageFields.add(Constants.LEG_LOCALE_OF_ISSUE);
        messageFields.add(Constants.LEG_REDEMPTION_DATE);
        messageFields.add(Constants.LEG_STRIKE_PRICE);
        messageFields.add(Constants.LEG_STRIKE_CURRENCY);
        messageFields.add(Constants.LEG_OPT_ATTRIBUTE);
        messageFields.add(Constants.LEG_CONTRACT_MULTIPLIER);
        messageFields.add(Constants.LEG_COUPON_RATE);
        messageFields.add(Constants.LEG_SECURITY_EXCHANGE);
        messageFields.add(Constants.LEG_ISSUER);
        messageFields.add(Constants.ENCODED_LEG_ISSUER_LEN);
        messageFields.add(Constants.ENCODED_LEG_ISSUER);
        messageFields.add(Constants.LEG_SECURITY_DESC);
        messageFields.add(Constants.ENCODED_LEG_SECURITY_DESC_LEN);
        messageFields.add(Constants.ENCODED_LEG_SECURITY_DESC);
        messageFields.add(Constants.LEG_RATIO_QTY);
        messageFields.add(Constants.LEG_SIDE);
        messageFields.add(Constants.LEG_CURRENCY);
        messageFields.add(Constants.LEG_POOL);
        messageFields.add(Constants.LEG_DATED_DATE);
        messageFields.add(Constants.LEG_CONTRACT_SETTL_MONTH);
        messageFields.add(Constants.LEG_INTEREST_ACCRUAL_DATE);
        messageFields.add(Constants.LEG_QTY);
        messageFields.add(Constants.LEG_SWAP_TYPE);
        messageFields.add(Constants.NO_LEG_STIPULATIONS_GROUP_COUNTER);
        messageFields.add(Constants.LEG_STIPULATION_TYPE);
        messageFields.add(Constants.LEG_STIPULATION_VALUE);
        messageFields.add(Constants.LEG_POSITION_EFFECT);
        messageFields.add(Constants.LEG_COVERED_OR_UNCOVERED);
        messageFields.add(Constants.NO_NESTED_PARTY_IDS_GROUP_COUNTER);
        messageFields.add(Constants.NESTED_PARTY_ID);
        messageFields.add(Constants.NESTED_PARTY_ID_SOURCE);
        messageFields.add(Constants.NESTED_PARTY_ROLE);
        messageFields.add(Constants.NO_NESTED_PARTY_SUB_IDS_GROUP_COUNTER);
        messageFields.add(Constants.NESTED_PARTY_SUB_ID);
        messageFields.add(Constants.NESTED_PARTY_SUB_ID_TYPE);
        messageFields.add(Constants.LEG_REF_ID);
        messageFields.add(Constants.LEG_PRICE);
        messageFields.add(Constants.LEG_SETTL_TYPE);
        messageFields.add(Constants.LEG_SETTL_DATE);
        messageFields.add(Constants.LEG_LAST_PX);
        messageFields.add(Constants.TRANSACT_TIME);
        messageFields.add(Constants.NO_TRD_REG_TIMESTAMPS_GROUP_COUNTER);
        messageFields.add(Constants.TRD_REG_TIMESTAMP);
        messageFields.add(Constants.TRD_REG_TIMESTAMP_TYPE);
        messageFields.add(Constants.TRD_REG_TIMESTAMP_ORIGIN);
        messageFields.add(Constants.SETTL_TYPE);
        messageFields.add(Constants.SETTL_DATE);
        messageFields.add(Constants.MATCH_STATUS);
        messageFields.add(Constants.MATCH_TYPE);
        messageFields.add(Constants.NO_SIDES_GROUP_COUNTER);
        messageFields.add(Constants.SIDE);
        messageFields.add(Constants.ORDER_ID);
        messageFields.add(Constants.SECONDARY_ORDER_ID);
        messageFields.add(Constants.CL_ORD_ID);
        messageFields.add(Constants.SECONDARY_CL_ORD_ID);
        messageFields.add(Constants.LIST_ID);
        messageFields.add(Constants.NO_PARTY_IDS_GROUP_COUNTER);
        messageFields.add(Constants.PARTY_ID);
        messageFields.add(Constants.PARTY_ID_SOURCE);
        messageFields.add(Constants.PARTY_ROLE);
        messageFields.add(Constants.NO_PARTY_SUB_IDS_GROUP_COUNTER);
        messageFields.add(Constants.PARTY_SUB_ID);
        messageFields.add(Constants.PARTY_SUB_ID_TYPE);
        messageFields.add(Constants.ACCOUNT);
        messageFields.add(Constants.ACCT_ID_SOURCE);
        messageFields.add(Constants.ACCOUNT_TYPE);
        messageFields.add(Constants.PROCESS_CODE);
        messageFields.add(Constants.ODD_LOT);
        messageFields.add(Constants.NO_CLEARING_INSTRUCTIONS_GROUP_COUNTER);
        messageFields.add(Constants.CLEARING_INSTRUCTION);
        messageFields.add(Constants.CLEARING_FEE_INDICATOR);
        messageFields.add(Constants.TRADE_INPUT_SOURCE);
        messageFields.add(Constants.TRADE_INPUT_DEVICE);
        messageFields.add(Constants.ORDER_INPUT_DEVICE);
        messageFields.add(Constants.CURRENCY);
        messageFields.add(Constants.COMPLIANCE_ID);
        messageFields.add(Constants.SOLICITED_FLAG);
        messageFields.add(Constants.ORDER_CAPACITY);
        messageFields.add(Constants.ORDER_RESTRICTIONS);
        messageFields.add(Constants.CUST_ORDER_CAPACITY);
        messageFields.add(Constants.ORD_TYPE);
        messageFields.add(Constants.EXEC_INST);
        messageFields.add(Constants.TRANS_BKD_TIME);
        messageFields.add(Constants.TRADING_SESSION_ID);
        messageFields.add(Constants.TRADING_SESSION_SUB_ID);
        messageFields.add(Constants.TIME_BRACKET);
        messageFields.add(Constants.COMMISSION);
        messageFields.add(Constants.COMM_TYPE);
        messageFields.add(Constants.COMM_CURRENCY);
        messageFields.add(Constants.FUND_RENEW_WAIV);
        messageFields.add(Constants.GROSS_TRADE_AMT);
        messageFields.add(Constants.NUM_DAYS_INTEREST);
        messageFields.add(Constants.EX_DATE);
        messageFields.add(Constants.ACCRUED_INTEREST_RATE);
        messageFields.add(Constants.ACCRUED_INTEREST_AMT);
        messageFields.add(Constants.INTEREST_AT_MATURITY);
        messageFields.add(Constants.END_ACCRUED_INTEREST_AMT);
        messageFields.add(Constants.START_CASH);
        messageFields.add(Constants.END_CASH);
        messageFields.add(Constants.CONCESSION);
        messageFields.add(Constants.TOTAL_TAKEDOWN);
        messageFields.add(Constants.NET_MONEY);
        messageFields.add(Constants.SETTL_CURR_AMT);
        messageFields.add(Constants.SETTL_CURRENCY);
        messageFields.add(Constants.SETTL_CURR_FX_RATE);
        messageFields.add(Constants.SETTL_CURR_FX_RATE_CALC);
        messageFields.add(Constants.POSITION_EFFECT);
        messageFields.add(Constants.TEXT);
        messageFields.add(Constants.ENCODED_TEXT_LEN);
        messageFields.add(Constants.ENCODED_TEXT);
        messageFields.add(Constants.SIDE_MULTI_LEG_REPORTING_TYPE);
        messageFields.add(Constants.NO_CONT_AMTS_GROUP_COUNTER);
        messageFields.add(Constants.CONT_AMT_TYPE);
        messageFields.add(Constants.CONT_AMT_VALUE);
        messageFields.add(Constants.CONT_AMT_CURR);
        messageFields.add(Constants.NO_STIPULATIONS_GROUP_COUNTER);
        messageFields.add(Constants.STIPULATION_TYPE);
        messageFields.add(Constants.STIPULATION_VALUE);
        messageFields.add(Constants.NO_MISC_FEES_GROUP_COUNTER);
        messageFields.add(Constants.MISC_FEE_AMT);
        messageFields.add(Constants.MISC_FEE_CURR);
        messageFields.add(Constants.MISC_FEE_TYPE);
        messageFields.add(Constants.MISC_FEE_BASIS);
        messageFields.add(Constants.EXCHANGE_RULE);
        messageFields.add(Constants.TRADE_ALLOC_INDICATOR);
        messageFields.add(Constants.PREALLOC_METHOD);
        messageFields.add(Constants.ALLOC_ID);
        messageFields.add(Constants.NO_ALLOCS_GROUP_COUNTER);
        messageFields.add(Constants.ALLOC_ACCOUNT);
        messageFields.add(Constants.ALLOC_ACCT_ID_SOURCE);
        messageFields.add(Constants.ALLOC_SETTL_CURRENCY);
        messageFields.add(Constants.INDIVIDUAL_ALLOC_ID);
        messageFields.add(Constants.NO_NESTED2_PARTY_IDS_GROUP_COUNTER);
        messageFields.add(Constants.NESTED2_PARTY_ID);
        messageFields.add(Constants.NESTED2_PARTY_ID_SOURCE);
        messageFields.add(Constants.NESTED2_PARTY_ROLE);
        messageFields.add(Constants.NO_NESTED2_PARTY_SUB_IDS_GROUP_COUNTER);
        messageFields.add(Constants.NESTED2_PARTY_SUB_ID);
        messageFields.add(Constants.NESTED2_PARTY_SUB_ID_TYPE);
        messageFields.add(Constants.ALLOC_QTY);
        messageFields.add(Constants.COPY_MSG_INDICATOR);
        messageFields.add(Constants.PUBLISH_TRD_INDICATOR);
        messageFields.add(Constants.SHORT_SALE_REASON);
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

    private char[] tradeReportID = new char[1];

    /* TradeReportID = 571 */
    public char[] tradeReportID()
    {
        return tradeReportID;
    }


    private int tradeReportIDOffset;

    private int tradeReportIDLength;

    /* TradeReportID = 571 */
    public int tradeReportIDLength()
    {
        return tradeReportIDLength;
    }

    /* TradeReportID = 571 */
    public String tradeReportIDAsString()
    {
        return new String(tradeReportID, 0, tradeReportIDLength);
    }

    /* TradeReportID = 571 */
    public AsciiSequenceView tradeReportID(final AsciiSequenceView view)
    {
        return view.wrap(buffer, tradeReportIDOffset, tradeReportIDLength);
    }


    private final CharArrayWrapper tradeReportIDWrapper = new CharArrayWrapper();
    private int tradeReportTransType = MISSING_INT;

    private boolean hasTradeReportTransType;

    /* TradeReportTransType = 487 */
    public int tradeReportTransType()
    {
        if (!hasTradeReportTransType)
        {
            throw new IllegalArgumentException("No value for optional field: TradeReportTransType");
        }

        return tradeReportTransType;
    }

    public boolean hasTradeReportTransType()
    {
        return hasTradeReportTransType;
    }



    private final CharArrayWrapper tradeReportTransTypeWrapper = new CharArrayWrapper();
    /* TradeReportTransType = 487 */
    public TradeReportTransType tradeReportTransTypeAsEnum()
    {
        if (!hasTradeReportTransType)
 return TradeReportTransType.NULL_VAL;
        return TradeReportTransType.decode(tradeReportTransType);
    }

    private int tradeReportType = MISSING_INT;

    private boolean hasTradeReportType;

    /* TradeReportType = 856 */
    public int tradeReportType()
    {
        if (!hasTradeReportType)
        {
            throw new IllegalArgumentException("No value for optional field: TradeReportType");
        }

        return tradeReportType;
    }

    public boolean hasTradeReportType()
    {
        return hasTradeReportType;
    }



    private final CharArrayWrapper tradeReportTypeWrapper = new CharArrayWrapper();
    /* TradeReportType = 856 */
    public TradeReportType tradeReportTypeAsEnum()
    {
        if (!hasTradeReportType)
 return TradeReportType.NULL_VAL;
        return TradeReportType.decode(tradeReportType);
    }

    private char[] tradeRequestID = new char[1];

    private boolean hasTradeRequestID;

    /* TradeRequestID = 568 */
    public char[] tradeRequestID()
    {
        if (!hasTradeRequestID)
        {
            throw new IllegalArgumentException("No value for optional field: TradeRequestID");
        }

        return tradeRequestID;
    }

    public boolean hasTradeRequestID()
    {
        return hasTradeRequestID;
    }


    private int tradeRequestIDOffset;

    private int tradeRequestIDLength;

    /* TradeRequestID = 568 */
    public int tradeRequestIDLength()
    {
        if (!hasTradeRequestID)
        {
            throw new IllegalArgumentException("No value for optional field: TradeRequestID");
        }

        return tradeRequestIDLength;
    }

    /* TradeRequestID = 568 */
    public String tradeRequestIDAsString()
    {
        return hasTradeRequestID ? new String(tradeRequestID, 0, tradeRequestIDLength) : null;
    }

    /* TradeRequestID = 568 */
    public AsciiSequenceView tradeRequestID(final AsciiSequenceView view)
    {
        if (!hasTradeRequestID)
        {
            throw new IllegalArgumentException("No value for optional field: TradeRequestID");
        }

        return view.wrap(buffer, tradeRequestIDOffset, tradeRequestIDLength);
    }


    private final CharArrayWrapper tradeRequestIDWrapper = new CharArrayWrapper();
    private int trdType = MISSING_INT;

    private boolean hasTrdType;

    /* TrdType = 828 */
    public int trdType()
    {
        if (!hasTrdType)
        {
            throw new IllegalArgumentException("No value for optional field: TrdType");
        }

        return trdType;
    }

    public boolean hasTrdType()
    {
        return hasTrdType;
    }



    private final CharArrayWrapper trdTypeWrapper = new CharArrayWrapper();
    /* TrdType = 828 */
    public TrdType trdTypeAsEnum()
    {
        if (!hasTrdType)
 return TrdType.NULL_VAL;
        return TrdType.decode(trdType);
    }

    private int trdSubType = MISSING_INT;

    private boolean hasTrdSubType;

    /* TrdSubType = 829 */
    public int trdSubType()
    {
        if (!hasTrdSubType)
        {
            throw new IllegalArgumentException("No value for optional field: TrdSubType");
        }

        return trdSubType;
    }

    public boolean hasTrdSubType()
    {
        return hasTrdSubType;
    }



    private int secondaryTrdType = MISSING_INT;

    private boolean hasSecondaryTrdType;

    /* SecondaryTrdType = 855 */
    public int secondaryTrdType()
    {
        if (!hasSecondaryTrdType)
        {
            throw new IllegalArgumentException("No value for optional field: SecondaryTrdType");
        }

        return secondaryTrdType;
    }

    public boolean hasSecondaryTrdType()
    {
        return hasSecondaryTrdType;
    }



    private char[] transferReason = new char[1];

    private boolean hasTransferReason;

    /* TransferReason = 830 */
    public char[] transferReason()
    {
        if (!hasTransferReason)
        {
            throw new IllegalArgumentException("No value for optional field: TransferReason");
        }

        return transferReason;
    }

    public boolean hasTransferReason()
    {
        return hasTransferReason;
    }


    private int transferReasonOffset;

    private int transferReasonLength;

    /* TransferReason = 830 */
    public int transferReasonLength()
    {
        if (!hasTransferReason)
        {
            throw new IllegalArgumentException("No value for optional field: TransferReason");
        }

        return transferReasonLength;
    }

    /* TransferReason = 830 */
    public String transferReasonAsString()
    {
        return hasTransferReason ? new String(transferReason, 0, transferReasonLength) : null;
    }

    /* TransferReason = 830 */
    public AsciiSequenceView transferReason(final AsciiSequenceView view)
    {
        if (!hasTransferReason)
        {
            throw new IllegalArgumentException("No value for optional field: TransferReason");
        }

        return view.wrap(buffer, transferReasonOffset, transferReasonLength);
    }


    private final CharArrayWrapper transferReasonWrapper = new CharArrayWrapper();
    private char execType = MISSING_CHAR;

    private boolean hasExecType;

    /* ExecType = 150 */
    public char execType()
    {
        if (!hasExecType)
        {
            throw new IllegalArgumentException("No value for optional field: ExecType");
        }

        return execType;
    }

    public boolean hasExecType()
    {
        return hasExecType;
    }



    private final CharArrayWrapper execTypeWrapper = new CharArrayWrapper();
    /* ExecType = 150 */
    public ExecType execTypeAsEnum()
    {
        if (!hasExecType)
 return ExecType.NULL_VAL;
        return ExecType.decode(execType);
    }

    private int totNumTradeReports = MISSING_INT;

    private boolean hasTotNumTradeReports;

    /* TotNumTradeReports = 748 */
    public int totNumTradeReports()
    {
        if (!hasTotNumTradeReports)
        {
            throw new IllegalArgumentException("No value for optional field: TotNumTradeReports");
        }

        return totNumTradeReports;
    }

    public boolean hasTotNumTradeReports()
    {
        return hasTotNumTradeReports;
    }



    private boolean lastRptRequested;

    private boolean hasLastRptRequested;

    /* LastRptRequested = 912 */
    public boolean lastRptRequested()
    {
        if (!hasLastRptRequested)
        {
            throw new IllegalArgumentException("No value for optional field: LastRptRequested");
        }

        return lastRptRequested;
    }

    public boolean hasLastRptRequested()
    {
        return hasLastRptRequested;
    }



    private boolean unsolicitedIndicator;

    private boolean hasUnsolicitedIndicator;

    /* UnsolicitedIndicator = 325 */
    public boolean unsolicitedIndicator()
    {
        if (!hasUnsolicitedIndicator)
        {
            throw new IllegalArgumentException("No value for optional field: UnsolicitedIndicator");
        }

        return unsolicitedIndicator;
    }

    public boolean hasUnsolicitedIndicator()
    {
        return hasUnsolicitedIndicator;
    }



    private char subscriptionRequestType = MISSING_CHAR;

    private boolean hasSubscriptionRequestType;

    /* SubscriptionRequestType = 263 */
    public char subscriptionRequestType()
    {
        if (!hasSubscriptionRequestType)
        {
            throw new IllegalArgumentException("No value for optional field: SubscriptionRequestType");
        }

        return subscriptionRequestType;
    }

    public boolean hasSubscriptionRequestType()
    {
        return hasSubscriptionRequestType;
    }



    private final CharArrayWrapper subscriptionRequestTypeWrapper = new CharArrayWrapper();
    /* SubscriptionRequestType = 263 */
    public SubscriptionRequestType subscriptionRequestTypeAsEnum()
    {
        if (!hasSubscriptionRequestType)
 return SubscriptionRequestType.NULL_VAL;
        return SubscriptionRequestType.decode(subscriptionRequestType);
    }

    private char[] tradeReportRefID = new char[1];

    private boolean hasTradeReportRefID;

    /* TradeReportRefID = 572 */
    public char[] tradeReportRefID()
    {
        if (!hasTradeReportRefID)
        {
            throw new IllegalArgumentException("No value for optional field: TradeReportRefID");
        }

        return tradeReportRefID;
    }

    public boolean hasTradeReportRefID()
    {
        return hasTradeReportRefID;
    }


    private int tradeReportRefIDOffset;

    private int tradeReportRefIDLength;

    /* TradeReportRefID = 572 */
    public int tradeReportRefIDLength()
    {
        if (!hasTradeReportRefID)
        {
            throw new IllegalArgumentException("No value for optional field: TradeReportRefID");
        }

        return tradeReportRefIDLength;
    }

    /* TradeReportRefID = 572 */
    public String tradeReportRefIDAsString()
    {
        return hasTradeReportRefID ? new String(tradeReportRefID, 0, tradeReportRefIDLength) : null;
    }

    /* TradeReportRefID = 572 */
    public AsciiSequenceView tradeReportRefID(final AsciiSequenceView view)
    {
        if (!hasTradeReportRefID)
        {
            throw new IllegalArgumentException("No value for optional field: TradeReportRefID");
        }

        return view.wrap(buffer, tradeReportRefIDOffset, tradeReportRefIDLength);
    }


    private final CharArrayWrapper tradeReportRefIDWrapper = new CharArrayWrapper();
    private char[] secondaryTradeReportRefID = new char[1];

    private boolean hasSecondaryTradeReportRefID;

    /* SecondaryTradeReportRefID = 881 */
    public char[] secondaryTradeReportRefID()
    {
        if (!hasSecondaryTradeReportRefID)
        {
            throw new IllegalArgumentException("No value for optional field: SecondaryTradeReportRefID");
        }

        return secondaryTradeReportRefID;
    }

    public boolean hasSecondaryTradeReportRefID()
    {
        return hasSecondaryTradeReportRefID;
    }


    private int secondaryTradeReportRefIDOffset;

    private int secondaryTradeReportRefIDLength;

    /* SecondaryTradeReportRefID = 881 */
    public int secondaryTradeReportRefIDLength()
    {
        if (!hasSecondaryTradeReportRefID)
        {
            throw new IllegalArgumentException("No value for optional field: SecondaryTradeReportRefID");
        }

        return secondaryTradeReportRefIDLength;
    }

    /* SecondaryTradeReportRefID = 881 */
    public String secondaryTradeReportRefIDAsString()
    {
        return hasSecondaryTradeReportRefID ? new String(secondaryTradeReportRefID, 0, secondaryTradeReportRefIDLength) : null;
    }

    /* SecondaryTradeReportRefID = 881 */
    public AsciiSequenceView secondaryTradeReportRefID(final AsciiSequenceView view)
    {
        if (!hasSecondaryTradeReportRefID)
        {
            throw new IllegalArgumentException("No value for optional field: SecondaryTradeReportRefID");
        }

        return view.wrap(buffer, secondaryTradeReportRefIDOffset, secondaryTradeReportRefIDLength);
    }


    private final CharArrayWrapper secondaryTradeReportRefIDWrapper = new CharArrayWrapper();
    private char[] secondaryTradeReportID = new char[1];

    private boolean hasSecondaryTradeReportID;

    /* SecondaryTradeReportID = 818 */
    public char[] secondaryTradeReportID()
    {
        if (!hasSecondaryTradeReportID)
        {
            throw new IllegalArgumentException("No value for optional field: SecondaryTradeReportID");
        }

        return secondaryTradeReportID;
    }

    public boolean hasSecondaryTradeReportID()
    {
        return hasSecondaryTradeReportID;
    }


    private int secondaryTradeReportIDOffset;

    private int secondaryTradeReportIDLength;

    /* SecondaryTradeReportID = 818 */
    public int secondaryTradeReportIDLength()
    {
        if (!hasSecondaryTradeReportID)
        {
            throw new IllegalArgumentException("No value for optional field: SecondaryTradeReportID");
        }

        return secondaryTradeReportIDLength;
    }

    /* SecondaryTradeReportID = 818 */
    public String secondaryTradeReportIDAsString()
    {
        return hasSecondaryTradeReportID ? new String(secondaryTradeReportID, 0, secondaryTradeReportIDLength) : null;
    }

    /* SecondaryTradeReportID = 818 */
    public AsciiSequenceView secondaryTradeReportID(final AsciiSequenceView view)
    {
        if (!hasSecondaryTradeReportID)
        {
            throw new IllegalArgumentException("No value for optional field: SecondaryTradeReportID");
        }

        return view.wrap(buffer, secondaryTradeReportIDOffset, secondaryTradeReportIDLength);
    }


    private final CharArrayWrapper secondaryTradeReportIDWrapper = new CharArrayWrapper();
    private char[] tradeLinkID = new char[1];

    private boolean hasTradeLinkID;

    /* TradeLinkID = 820 */
    public char[] tradeLinkID()
    {
        if (!hasTradeLinkID)
        {
            throw new IllegalArgumentException("No value for optional field: TradeLinkID");
        }

        return tradeLinkID;
    }

    public boolean hasTradeLinkID()
    {
        return hasTradeLinkID;
    }


    private int tradeLinkIDOffset;

    private int tradeLinkIDLength;

    /* TradeLinkID = 820 */
    public int tradeLinkIDLength()
    {
        if (!hasTradeLinkID)
        {
            throw new IllegalArgumentException("No value for optional field: TradeLinkID");
        }

        return tradeLinkIDLength;
    }

    /* TradeLinkID = 820 */
    public String tradeLinkIDAsString()
    {
        return hasTradeLinkID ? new String(tradeLinkID, 0, tradeLinkIDLength) : null;
    }

    /* TradeLinkID = 820 */
    public AsciiSequenceView tradeLinkID(final AsciiSequenceView view)
    {
        if (!hasTradeLinkID)
        {
            throw new IllegalArgumentException("No value for optional field: TradeLinkID");
        }

        return view.wrap(buffer, tradeLinkIDOffset, tradeLinkIDLength);
    }


    private final CharArrayWrapper tradeLinkIDWrapper = new CharArrayWrapper();
    private char[] trdMatchID = new char[1];

    private boolean hasTrdMatchID;

    /* TrdMatchID = 880 */
    public char[] trdMatchID()
    {
        if (!hasTrdMatchID)
        {
            throw new IllegalArgumentException("No value for optional field: TrdMatchID");
        }

        return trdMatchID;
    }

    public boolean hasTrdMatchID()
    {
        return hasTrdMatchID;
    }


    private int trdMatchIDOffset;

    private int trdMatchIDLength;

    /* TrdMatchID = 880 */
    public int trdMatchIDLength()
    {
        if (!hasTrdMatchID)
        {
            throw new IllegalArgumentException("No value for optional field: TrdMatchID");
        }

        return trdMatchIDLength;
    }

    /* TrdMatchID = 880 */
    public String trdMatchIDAsString()
    {
        return hasTrdMatchID ? new String(trdMatchID, 0, trdMatchIDLength) : null;
    }

    /* TrdMatchID = 880 */
    public AsciiSequenceView trdMatchID(final AsciiSequenceView view)
    {
        if (!hasTrdMatchID)
        {
            throw new IllegalArgumentException("No value for optional field: TrdMatchID");
        }

        return view.wrap(buffer, trdMatchIDOffset, trdMatchIDLength);
    }


    private final CharArrayWrapper trdMatchIDWrapper = new CharArrayWrapper();
    private char[] execID = new char[1];

    private boolean hasExecID;

    /* ExecID = 17 */
    public char[] execID()
    {
        if (!hasExecID)
        {
            throw new IllegalArgumentException("No value for optional field: ExecID");
        }

        return execID;
    }

    public boolean hasExecID()
    {
        return hasExecID;
    }


    private int execIDOffset;

    private int execIDLength;

    /* ExecID = 17 */
    public int execIDLength()
    {
        if (!hasExecID)
        {
            throw new IllegalArgumentException("No value for optional field: ExecID");
        }

        return execIDLength;
    }

    /* ExecID = 17 */
    public String execIDAsString()
    {
        return hasExecID ? new String(execID, 0, execIDLength) : null;
    }

    /* ExecID = 17 */
    public AsciiSequenceView execID(final AsciiSequenceView view)
    {
        if (!hasExecID)
        {
            throw new IllegalArgumentException("No value for optional field: ExecID");
        }

        return view.wrap(buffer, execIDOffset, execIDLength);
    }


    private final CharArrayWrapper execIDWrapper = new CharArrayWrapper();
    private char ordStatus = MISSING_CHAR;

    private boolean hasOrdStatus;

    /* OrdStatus = 39 */
    public char ordStatus()
    {
        if (!hasOrdStatus)
        {
            throw new IllegalArgumentException("No value for optional field: OrdStatus");
        }

        return ordStatus;
    }

    public boolean hasOrdStatus()
    {
        return hasOrdStatus;
    }



    private final CharArrayWrapper ordStatusWrapper = new CharArrayWrapper();
    /* OrdStatus = 39 */
    public OrdStatus ordStatusAsEnum()
    {
        if (!hasOrdStatus)
 return OrdStatus.NULL_VAL;
        return OrdStatus.decode(ordStatus);
    }

    private char[] secondaryExecID = new char[1];

    private boolean hasSecondaryExecID;

    /* SecondaryExecID = 527 */
    public char[] secondaryExecID()
    {
        if (!hasSecondaryExecID)
        {
            throw new IllegalArgumentException("No value for optional field: SecondaryExecID");
        }

        return secondaryExecID;
    }

    public boolean hasSecondaryExecID()
    {
        return hasSecondaryExecID;
    }


    private int secondaryExecIDOffset;

    private int secondaryExecIDLength;

    /* SecondaryExecID = 527 */
    public int secondaryExecIDLength()
    {
        if (!hasSecondaryExecID)
        {
            throw new IllegalArgumentException("No value for optional field: SecondaryExecID");
        }

        return secondaryExecIDLength;
    }

    /* SecondaryExecID = 527 */
    public String secondaryExecIDAsString()
    {
        return hasSecondaryExecID ? new String(secondaryExecID, 0, secondaryExecIDLength) : null;
    }

    /* SecondaryExecID = 527 */
    public AsciiSequenceView secondaryExecID(final AsciiSequenceView view)
    {
        if (!hasSecondaryExecID)
        {
            throw new IllegalArgumentException("No value for optional field: SecondaryExecID");
        }

        return view.wrap(buffer, secondaryExecIDOffset, secondaryExecIDLength);
    }


    private final CharArrayWrapper secondaryExecIDWrapper = new CharArrayWrapper();
    private int execRestatementReason = MISSING_INT;

    private boolean hasExecRestatementReason;

    /* ExecRestatementReason = 378 */
    public int execRestatementReason()
    {
        if (!hasExecRestatementReason)
        {
            throw new IllegalArgumentException("No value for optional field: ExecRestatementReason");
        }

        return execRestatementReason;
    }

    public boolean hasExecRestatementReason()
    {
        return hasExecRestatementReason;
    }



    private final CharArrayWrapper execRestatementReasonWrapper = new CharArrayWrapper();
    /* ExecRestatementReason = 378 */
    public ExecRestatementReason execRestatementReasonAsEnum()
    {
        if (!hasExecRestatementReason)
 return ExecRestatementReason.NULL_VAL;
        return ExecRestatementReason.decode(execRestatementReason);
    }

    private boolean previouslyReported;

    /* PreviouslyReported = 570 */
    public boolean previouslyReported()
    {
        return previouslyReported;
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




    private char[] agreementDesc = new char[1];

    private boolean hasAgreementDesc;

    /* AgreementDesc = 913 */
    public char[] agreementDesc()
    {
        if (!hasAgreementDesc)
        {
            throw new IllegalArgumentException("No value for optional field: AgreementDesc");
        }

        return agreementDesc;
    }

    public boolean hasAgreementDesc()
    {
        return hasAgreementDesc;
    }


    private int agreementDescOffset;

    private int agreementDescLength;

    /* AgreementDesc = 913 */
    public int agreementDescLength()
    {
        if (!hasAgreementDesc)
        {
            throw new IllegalArgumentException("No value for optional field: AgreementDesc");
        }

        return agreementDescLength;
    }

    /* AgreementDesc = 913 */
    public String agreementDescAsString()
    {
        return hasAgreementDesc ? new String(agreementDesc, 0, agreementDescLength) : null;
    }

    /* AgreementDesc = 913 */
    public AsciiSequenceView agreementDesc(final AsciiSequenceView view)
    {
        if (!hasAgreementDesc)
        {
            throw new IllegalArgumentException("No value for optional field: AgreementDesc");
        }

        return view.wrap(buffer, agreementDescOffset, agreementDescLength);
    }


    private final CharArrayWrapper agreementDescWrapper = new CharArrayWrapper();
    private char[] agreementID = new char[1];

    private boolean hasAgreementID;

    /* AgreementID = 914 */
    public char[] agreementID()
    {
        if (!hasAgreementID)
        {
            throw new IllegalArgumentException("No value for optional field: AgreementID");
        }

        return agreementID;
    }

    public boolean hasAgreementID()
    {
        return hasAgreementID;
    }


    private int agreementIDOffset;

    private int agreementIDLength;

    /* AgreementID = 914 */
    public int agreementIDLength()
    {
        if (!hasAgreementID)
        {
            throw new IllegalArgumentException("No value for optional field: AgreementID");
        }

        return agreementIDLength;
    }

    /* AgreementID = 914 */
    public String agreementIDAsString()
    {
        return hasAgreementID ? new String(agreementID, 0, agreementIDLength) : null;
    }

    /* AgreementID = 914 */
    public AsciiSequenceView agreementID(final AsciiSequenceView view)
    {
        if (!hasAgreementID)
        {
            throw new IllegalArgumentException("No value for optional field: AgreementID");
        }

        return view.wrap(buffer, agreementIDOffset, agreementIDLength);
    }


    private final CharArrayWrapper agreementIDWrapper = new CharArrayWrapper();
    private byte[] agreementDate = new byte[8];

    private boolean hasAgreementDate;

    /* AgreementDate = 915 */
    public byte[] agreementDate()
    {
        if (!hasAgreementDate)
        {
            throw new IllegalArgumentException("No value for optional field: AgreementDate");
        }

        return agreementDate;
    }

    public boolean hasAgreementDate()
    {
        return hasAgreementDate;
    }


    private int agreementDateOffset;

    private int agreementDateLength;

    /* AgreementDate = 915 */
    public int agreementDateLength()
    {
        if (!hasAgreementDate)
        {
            throw new IllegalArgumentException("No value for optional field: AgreementDate");
        }

        return agreementDateLength;
    }

    /* AgreementDate = 915 */
    public String agreementDateAsString()
    {
        return hasAgreementDate ? new String(agreementDate, 0, agreementDateLength) : null;
    }

    /* AgreementDate = 915 */
    public AsciiSequenceView agreementDate(final AsciiSequenceView view)
    {
        if (!hasAgreementDate)
        {
            throw new IllegalArgumentException("No value for optional field: AgreementDate");
        }

        return view.wrap(buffer, agreementDateOffset, agreementDateLength);
    }


    private char[] agreementCurrency = new char[1];

    private boolean hasAgreementCurrency;

    /* AgreementCurrency = 918 */
    public char[] agreementCurrency()
    {
        if (!hasAgreementCurrency)
        {
            throw new IllegalArgumentException("No value for optional field: AgreementCurrency");
        }

        return agreementCurrency;
    }

    public boolean hasAgreementCurrency()
    {
        return hasAgreementCurrency;
    }


    private int agreementCurrencyOffset;

    private int agreementCurrencyLength;

    /* AgreementCurrency = 918 */
    public int agreementCurrencyLength()
    {
        if (!hasAgreementCurrency)
        {
            throw new IllegalArgumentException("No value for optional field: AgreementCurrency");
        }

        return agreementCurrencyLength;
    }

    /* AgreementCurrency = 918 */
    public String agreementCurrencyAsString()
    {
        return hasAgreementCurrency ? new String(agreementCurrency, 0, agreementCurrencyLength) : null;
    }

    /* AgreementCurrency = 918 */
    public AsciiSequenceView agreementCurrency(final AsciiSequenceView view)
    {
        if (!hasAgreementCurrency)
        {
            throw new IllegalArgumentException("No value for optional field: AgreementCurrency");
        }

        return view.wrap(buffer, agreementCurrencyOffset, agreementCurrencyLength);
    }


    private int terminationType = MISSING_INT;

    private boolean hasTerminationType;

    /* TerminationType = 788 */
    public int terminationType()
    {
        if (!hasTerminationType)
        {
            throw new IllegalArgumentException("No value for optional field: TerminationType");
        }

        return terminationType;
    }

    public boolean hasTerminationType()
    {
        return hasTerminationType;
    }



    private final CharArrayWrapper terminationTypeWrapper = new CharArrayWrapper();
    /* TerminationType = 788 */
    public TerminationType terminationTypeAsEnum()
    {
        if (!hasTerminationType)
 return TerminationType.NULL_VAL;
        return TerminationType.decode(terminationType);
    }

    private byte[] startDate = new byte[8];

    private boolean hasStartDate;

    /* StartDate = 916 */
    public byte[] startDate()
    {
        if (!hasStartDate)
        {
            throw new IllegalArgumentException("No value for optional field: StartDate");
        }

        return startDate;
    }

    public boolean hasStartDate()
    {
        return hasStartDate;
    }


    private int startDateOffset;

    private int startDateLength;

    /* StartDate = 916 */
    public int startDateLength()
    {
        if (!hasStartDate)
        {
            throw new IllegalArgumentException("No value for optional field: StartDate");
        }

        return startDateLength;
    }

    /* StartDate = 916 */
    public String startDateAsString()
    {
        return hasStartDate ? new String(startDate, 0, startDateLength) : null;
    }

    /* StartDate = 916 */
    public AsciiSequenceView startDate(final AsciiSequenceView view)
    {
        if (!hasStartDate)
        {
            throw new IllegalArgumentException("No value for optional field: StartDate");
        }

        return view.wrap(buffer, startDateOffset, startDateLength);
    }


    private byte[] endDate = new byte[8];

    private boolean hasEndDate;

    /* EndDate = 917 */
    public byte[] endDate()
    {
        if (!hasEndDate)
        {
            throw new IllegalArgumentException("No value for optional field: EndDate");
        }

        return endDate;
    }

    public boolean hasEndDate()
    {
        return hasEndDate;
    }


    private int endDateOffset;

    private int endDateLength;

    /* EndDate = 917 */
    public int endDateLength()
    {
        if (!hasEndDate)
        {
            throw new IllegalArgumentException("No value for optional field: EndDate");
        }

        return endDateLength;
    }

    /* EndDate = 917 */
    public String endDateAsString()
    {
        return hasEndDate ? new String(endDate, 0, endDateLength) : null;
    }

    /* EndDate = 917 */
    public AsciiSequenceView endDate(final AsciiSequenceView view)
    {
        if (!hasEndDate)
        {
            throw new IllegalArgumentException("No value for optional field: EndDate");
        }

        return view.wrap(buffer, endDateOffset, endDateLength);
    }


    private int deliveryType = MISSING_INT;

    private boolean hasDeliveryType;

    /* DeliveryType = 919 */
    public int deliveryType()
    {
        if (!hasDeliveryType)
        {
            throw new IllegalArgumentException("No value for optional field: DeliveryType");
        }

        return deliveryType;
    }

    public boolean hasDeliveryType()
    {
        return hasDeliveryType;
    }



    private final CharArrayWrapper deliveryTypeWrapper = new CharArrayWrapper();
    /* DeliveryType = 919 */
    public DeliveryType deliveryTypeAsEnum()
    {
        if (!hasDeliveryType)
 return DeliveryType.NULL_VAL;
        return DeliveryType.decode(deliveryType);
    }

    private DecimalFloat marginRatio = DecimalFloat.newNaNValue();

    private boolean hasMarginRatio;

    /* MarginRatio = 898 */
    public DecimalFloat marginRatio()
    {
        if (!hasMarginRatio)
        {
            throw new IllegalArgumentException("No value for optional field: MarginRatio");
        }

        return marginRatio;
    }

    public boolean hasMarginRatio()
    {
        return hasMarginRatio;
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
    public TradeCaptureReportEncoder.UnderlyingsGroupEncoder toEncoder(final Encoder encoder)
    {
        return toEncoder((TradeCaptureReportEncoder.UnderlyingsGroupEncoder)encoder);
    }

    public TradeCaptureReportEncoder.UnderlyingsGroupEncoder toEncoder(final TradeCaptureReportEncoder.UnderlyingsGroupEncoder encoder)
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
        private final TradeCaptureReportDecoder parent;
        private int remainder;
        private UnderlyingsGroupDecoder current;

        public UnderlyingsGroupIterator(final TradeCaptureReportDecoder parent)
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

    private char[] underlyingTradingSessionID = new char[1];

    private boolean hasUnderlyingTradingSessionID;

    /* UnderlyingTradingSessionID = 822 */
    public char[] underlyingTradingSessionID()
    {
        if (!hasUnderlyingTradingSessionID)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingTradingSessionID");
        }

        return underlyingTradingSessionID;
    }

    public boolean hasUnderlyingTradingSessionID()
    {
        return hasUnderlyingTradingSessionID;
    }


    private int underlyingTradingSessionIDOffset;

    private int underlyingTradingSessionIDLength;

    /* UnderlyingTradingSessionID = 822 */
    public int underlyingTradingSessionIDLength()
    {
        if (!hasUnderlyingTradingSessionID)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingTradingSessionID");
        }

        return underlyingTradingSessionIDLength;
    }

    /* UnderlyingTradingSessionID = 822 */
    public String underlyingTradingSessionIDAsString()
    {
        return hasUnderlyingTradingSessionID ? new String(underlyingTradingSessionID, 0, underlyingTradingSessionIDLength) : null;
    }

    /* UnderlyingTradingSessionID = 822 */
    public AsciiSequenceView underlyingTradingSessionID(final AsciiSequenceView view)
    {
        if (!hasUnderlyingTradingSessionID)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingTradingSessionID");
        }

        return view.wrap(buffer, underlyingTradingSessionIDOffset, underlyingTradingSessionIDLength);
    }


    private final CharArrayWrapper underlyingTradingSessionIDWrapper = new CharArrayWrapper();
    private char[] underlyingTradingSessionSubID = new char[1];

    private boolean hasUnderlyingTradingSessionSubID;

    /* UnderlyingTradingSessionSubID = 823 */
    public char[] underlyingTradingSessionSubID()
    {
        if (!hasUnderlyingTradingSessionSubID)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingTradingSessionSubID");
        }

        return underlyingTradingSessionSubID;
    }

    public boolean hasUnderlyingTradingSessionSubID()
    {
        return hasUnderlyingTradingSessionSubID;
    }


    private int underlyingTradingSessionSubIDOffset;

    private int underlyingTradingSessionSubIDLength;

    /* UnderlyingTradingSessionSubID = 823 */
    public int underlyingTradingSessionSubIDLength()
    {
        if (!hasUnderlyingTradingSessionSubID)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingTradingSessionSubID");
        }

        return underlyingTradingSessionSubIDLength;
    }

    /* UnderlyingTradingSessionSubID = 823 */
    public String underlyingTradingSessionSubIDAsString()
    {
        return hasUnderlyingTradingSessionSubID ? new String(underlyingTradingSessionSubID, 0, underlyingTradingSessionSubIDLength) : null;
    }

    /* UnderlyingTradingSessionSubID = 823 */
    public AsciiSequenceView underlyingTradingSessionSubID(final AsciiSequenceView view)
    {
        if (!hasUnderlyingTradingSessionSubID)
        {
            throw new IllegalArgumentException("No value for optional field: UnderlyingTradingSessionSubID");
        }

        return view.wrap(buffer, underlyingTradingSessionSubIDOffset, underlyingTradingSessionSubIDLength);
    }


    private final CharArrayWrapper underlyingTradingSessionSubIDWrapper = new CharArrayWrapper();
    private DecimalFloat lastQty = DecimalFloat.newNaNValue();

    /* LastQty = 32 */
    public DecimalFloat lastQty()
    {
        return lastQty;
    }



    private DecimalFloat lastPx = DecimalFloat.newNaNValue();

    /* LastPx = 31 */
    public DecimalFloat lastPx()
    {
        return lastPx;
    }



    private DecimalFloat lastParPx = DecimalFloat.newNaNValue();

    private boolean hasLastParPx;

    /* LastParPx = 669 */
    public DecimalFloat lastParPx()
    {
        if (!hasLastParPx)
        {
            throw new IllegalArgumentException("No value for optional field: LastParPx");
        }

        return lastParPx;
    }

    public boolean hasLastParPx()
    {
        return hasLastParPx;
    }



    private DecimalFloat lastSpotRate = DecimalFloat.newNaNValue();

    private boolean hasLastSpotRate;

    /* LastSpotRate = 194 */
    public DecimalFloat lastSpotRate()
    {
        if (!hasLastSpotRate)
        {
            throw new IllegalArgumentException("No value for optional field: LastSpotRate");
        }

        return lastSpotRate;
    }

    public boolean hasLastSpotRate()
    {
        return hasLastSpotRate;
    }



    private DecimalFloat lastForwardPoints = DecimalFloat.newNaNValue();

    private boolean hasLastForwardPoints;

    /* LastForwardPoints = 195 */
    public DecimalFloat lastForwardPoints()
    {
        if (!hasLastForwardPoints)
        {
            throw new IllegalArgumentException("No value for optional field: LastForwardPoints");
        }

        return lastForwardPoints;
    }

    public boolean hasLastForwardPoints()
    {
        return hasLastForwardPoints;
    }



    private char[] lastMkt = new char[1];

    private boolean hasLastMkt;

    /* LastMkt = 30 */
    public char[] lastMkt()
    {
        if (!hasLastMkt)
        {
            throw new IllegalArgumentException("No value for optional field: LastMkt");
        }

        return lastMkt;
    }

    public boolean hasLastMkt()
    {
        return hasLastMkt;
    }


    private int lastMktOffset;

    private int lastMktLength;

    /* LastMkt = 30 */
    public int lastMktLength()
    {
        if (!hasLastMkt)
        {
            throw new IllegalArgumentException("No value for optional field: LastMkt");
        }

        return lastMktLength;
    }

    /* LastMkt = 30 */
    public String lastMktAsString()
    {
        return hasLastMkt ? new String(lastMkt, 0, lastMktLength) : null;
    }

    /* LastMkt = 30 */
    public AsciiSequenceView lastMkt(final AsciiSequenceView view)
    {
        if (!hasLastMkt)
        {
            throw new IllegalArgumentException("No value for optional field: LastMkt");
        }

        return view.wrap(buffer, lastMktOffset, lastMktLength);
    }


    private byte[] tradeDate = new byte[8];

    /* TradeDate = 75 */
    public byte[] tradeDate()
    {
        return tradeDate;
    }


    private int tradeDateOffset;

    private int tradeDateLength;

    /* TradeDate = 75 */
    public int tradeDateLength()
    {
        return tradeDateLength;
    }

    /* TradeDate = 75 */
    public String tradeDateAsString()
    {
        return new String(tradeDate, 0, tradeDateLength);
    }

    /* TradeDate = 75 */
    public AsciiSequenceView tradeDate(final AsciiSequenceView view)
    {
        return view.wrap(buffer, tradeDateOffset, tradeDateLength);
    }


    private byte[] clearingBusinessDate = new byte[8];

    private boolean hasClearingBusinessDate;

    /* ClearingBusinessDate = 715 */
    public byte[] clearingBusinessDate()
    {
        if (!hasClearingBusinessDate)
        {
            throw new IllegalArgumentException("No value for optional field: ClearingBusinessDate");
        }

        return clearingBusinessDate;
    }

    public boolean hasClearingBusinessDate()
    {
        return hasClearingBusinessDate;
    }


    private int clearingBusinessDateOffset;

    private int clearingBusinessDateLength;

    /* ClearingBusinessDate = 715 */
    public int clearingBusinessDateLength()
    {
        if (!hasClearingBusinessDate)
        {
            throw new IllegalArgumentException("No value for optional field: ClearingBusinessDate");
        }

        return clearingBusinessDateLength;
    }

    /* ClearingBusinessDate = 715 */
    public String clearingBusinessDateAsString()
    {
        return hasClearingBusinessDate ? new String(clearingBusinessDate, 0, clearingBusinessDateLength) : null;
    }

    /* ClearingBusinessDate = 715 */
    public AsciiSequenceView clearingBusinessDate(final AsciiSequenceView view)
    {
        if (!hasClearingBusinessDate)
        {
            throw new IllegalArgumentException("No value for optional field: ClearingBusinessDate");
        }

        return view.wrap(buffer, clearingBusinessDateOffset, clearingBusinessDateLength);
    }


    private DecimalFloat avgPx = DecimalFloat.newNaNValue();

    private boolean hasAvgPx;

    /* AvgPx = 6 */
    public DecimalFloat avgPx()
    {
        if (!hasAvgPx)
        {
            throw new IllegalArgumentException("No value for optional field: AvgPx");
        }

        return avgPx;
    }

    public boolean hasAvgPx()
    {
        return hasAvgPx;
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

    private int avgPxIndicator = MISSING_INT;

    private boolean hasAvgPxIndicator;

    /* AvgPxIndicator = 819 */
    public int avgPxIndicator()
    {
        if (!hasAvgPxIndicator)
        {
            throw new IllegalArgumentException("No value for optional field: AvgPxIndicator");
        }

        return avgPxIndicator;
    }

    public boolean hasAvgPxIndicator()
    {
        return hasAvgPxIndicator;
    }



    private final CharArrayWrapper avgPxIndicatorWrapper = new CharArrayWrapper();
    /* AvgPxIndicator = 819 */
    public AvgPxIndicator avgPxIndicatorAsEnum()
    {
        if (!hasAvgPxIndicator)
 return AvgPxIndicator.NULL_VAL;
        return AvgPxIndicator.decode(avgPxIndicator);
    }


    private int noPosAmt = MISSING_INT;

    /* NoPosAmt = 753 */
    public int noPosAmt()
    {
        return noPosAmt;
    }



    private char[] posAmtType = new char[1];

    /* PosAmtType = 707 */
    public char[] posAmtType()
    {
        return posAmtType;
    }


    private int posAmtTypeOffset;

    private int posAmtTypeLength;

    /* PosAmtType = 707 */
    public int posAmtTypeLength()
    {
        return posAmtTypeLength;
    }

    /* PosAmtType = 707 */
    public String posAmtTypeAsString()
    {
        return new String(posAmtType, 0, posAmtTypeLength);
    }

    /* PosAmtType = 707 */
    public AsciiSequenceView posAmtType(final AsciiSequenceView view)
    {
        return view.wrap(buffer, posAmtTypeOffset, posAmtTypeLength);
    }


    private final CharArrayWrapper posAmtTypeWrapper = new CharArrayWrapper();
    /* PosAmtType = 707 */
    public PosAmtType posAmtTypeAsEnum()
    {
        posAmtTypeWrapper.wrap(this.posAmtType(), posAmtTypeLength);
        return PosAmtType.decode(posAmtTypeWrapper);
    }

    private DecimalFloat posAmt = DecimalFloat.newNaNValue();

    /* PosAmt = 708 */
    public DecimalFloat posAmt()
    {
        return posAmt;
    }




    private char multiLegReportingType = MISSING_CHAR;

    private boolean hasMultiLegReportingType;

    /* MultiLegReportingType = 442 */
    public char multiLegReportingType()
    {
        if (!hasMultiLegReportingType)
        {
            throw new IllegalArgumentException("No value for optional field: MultiLegReportingType");
        }

        return multiLegReportingType;
    }

    public boolean hasMultiLegReportingType()
    {
        return hasMultiLegReportingType;
    }



    private final CharArrayWrapper multiLegReportingTypeWrapper = new CharArrayWrapper();
    /* MultiLegReportingType = 442 */
    public MultiLegReportingType multiLegReportingTypeAsEnum()
    {
        if (!hasMultiLegReportingType)
 return MultiLegReportingType.NULL_VAL;
        return MultiLegReportingType.decode(multiLegReportingType);
    }

    private char[] tradeLegRefID = new char[1];

    private boolean hasTradeLegRefID;

    /* TradeLegRefID = 824 */
    public char[] tradeLegRefID()
    {
        if (!hasTradeLegRefID)
        {
            throw new IllegalArgumentException("No value for optional field: TradeLegRefID");
        }

        return tradeLegRefID;
    }

    public boolean hasTradeLegRefID()
    {
        return hasTradeLegRefID;
    }


    private int tradeLegRefIDOffset;

    private int tradeLegRefIDLength;

    /* TradeLegRefID = 824 */
    public int tradeLegRefIDLength()
    {
        if (!hasTradeLegRefID)
        {
            throw new IllegalArgumentException("No value for optional field: TradeLegRefID");
        }

        return tradeLegRefIDLength;
    }

    /* TradeLegRefID = 824 */
    public String tradeLegRefIDAsString()
    {
        return hasTradeLegRefID ? new String(tradeLegRefID, 0, tradeLegRefIDLength) : null;
    }

    /* TradeLegRefID = 824 */
    public AsciiSequenceView tradeLegRefID(final AsciiSequenceView view)
    {
        if (!hasTradeLegRefID)
        {
            throw new IllegalArgumentException("No value for optional field: TradeLegRefID");
        }

        return view.wrap(buffer, tradeLegRefIDOffset, tradeLegRefIDLength);
    }


    private final CharArrayWrapper tradeLegRefIDWrapper = new CharArrayWrapper();

@Generated("uk.co.real_logic.artio")
public class LegsGroupDecoder extends CommonDecoderImpl implements InstrumentLegDecoder, LegStipulationsDecoder, NestedPartiesDecoder
{
    public final IntHashSet REQUIRED_FIELDS = new IntHashSet(0);

    {
        if (CODEC_VALIDATION_ENABLED)
        {
        }
    }

    public final IntHashSet GROUP_FIELDS = new IntHashSet(100);

    {
        if (CODEC_VALIDATION_ENABLED)
        {
            GROUP_FIELDS.add(Constants.LEG_SYMBOL);
            GROUP_FIELDS.add(Constants.LEG_SYMBOL_SFX);
            GROUP_FIELDS.add(Constants.LEG_SECURITY_ID);
            GROUP_FIELDS.add(Constants.LEG_SECURITY_ID_SOURCE);
            GROUP_FIELDS.add(Constants.LEG_PRODUCT);
            GROUP_FIELDS.add(Constants.LEG_C_F_I_CODE);
            GROUP_FIELDS.add(Constants.LEG_SECURITY_TYPE);
            GROUP_FIELDS.add(Constants.LEG_SECURITY_SUB_TYPE);
            GROUP_FIELDS.add(Constants.LEG_MATURITY_MONTH_YEAR);
            GROUP_FIELDS.add(Constants.LEG_MATURITY_DATE);
            GROUP_FIELDS.add(Constants.LEG_COUPON_PAYMENT_DATE);
            GROUP_FIELDS.add(Constants.LEG_ISSUE_DATE);
            GROUP_FIELDS.add(Constants.LEG_REPO_COLLATERAL_SECURITY_TYPE);
            GROUP_FIELDS.add(Constants.LEG_REPURCHASE_TERM);
            GROUP_FIELDS.add(Constants.LEG_REPURCHASE_RATE);
            GROUP_FIELDS.add(Constants.LEG_FACTOR);
            GROUP_FIELDS.add(Constants.LEG_CREDIT_RATING);
            GROUP_FIELDS.add(Constants.LEG_INSTR_REGISTRY);
            GROUP_FIELDS.add(Constants.LEG_COUNTRY_OF_ISSUE);
            GROUP_FIELDS.add(Constants.LEG_STATE_OR_PROVINCE_OF_ISSUE);
            GROUP_FIELDS.add(Constants.LEG_LOCALE_OF_ISSUE);
            GROUP_FIELDS.add(Constants.LEG_REDEMPTION_DATE);
            GROUP_FIELDS.add(Constants.LEG_STRIKE_PRICE);
            GROUP_FIELDS.add(Constants.LEG_STRIKE_CURRENCY);
            GROUP_FIELDS.add(Constants.LEG_OPT_ATTRIBUTE);
            GROUP_FIELDS.add(Constants.LEG_CONTRACT_MULTIPLIER);
            GROUP_FIELDS.add(Constants.LEG_COUPON_RATE);
            GROUP_FIELDS.add(Constants.LEG_SECURITY_EXCHANGE);
            GROUP_FIELDS.add(Constants.LEG_ISSUER);
            GROUP_FIELDS.add(Constants.ENCODED_LEG_ISSUER_LEN);
            GROUP_FIELDS.add(Constants.ENCODED_LEG_ISSUER);
            GROUP_FIELDS.add(Constants.LEG_SECURITY_DESC);
            GROUP_FIELDS.add(Constants.ENCODED_LEG_SECURITY_DESC_LEN);
            GROUP_FIELDS.add(Constants.ENCODED_LEG_SECURITY_DESC);
            GROUP_FIELDS.add(Constants.LEG_RATIO_QTY);
            GROUP_FIELDS.add(Constants.LEG_SIDE);
            GROUP_FIELDS.add(Constants.LEG_CURRENCY);
            GROUP_FIELDS.add(Constants.LEG_POOL);
            GROUP_FIELDS.add(Constants.LEG_DATED_DATE);
            GROUP_FIELDS.add(Constants.LEG_CONTRACT_SETTL_MONTH);
            GROUP_FIELDS.add(Constants.LEG_INTEREST_ACCRUAL_DATE);
            GROUP_FIELDS.add(Constants.LEG_QTY);
            GROUP_FIELDS.add(Constants.LEG_SWAP_TYPE);
            GROUP_FIELDS.add(Constants.LEG_POSITION_EFFECT);
            GROUP_FIELDS.add(Constants.LEG_COVERED_OR_UNCOVERED);
            GROUP_FIELDS.add(Constants.LEG_REF_ID);
            GROUP_FIELDS.add(Constants.LEG_PRICE);
            GROUP_FIELDS.add(Constants.LEG_SETTL_TYPE);
            GROUP_FIELDS.add(Constants.LEG_SETTL_DATE);
            GROUP_FIELDS.add(Constants.LEG_LAST_PX);
        }
    }

    public final IntHashSet ALL_GROUP_FIELDS = new IntHashSet(18);

    {
        if (CODEC_VALIDATION_ENABLED)
        {
            ALL_GROUP_FIELDS.add(Constants.LEG_QTY);
            ALL_GROUP_FIELDS.add(Constants.LEG_SWAP_TYPE);
            ALL_GROUP_FIELDS.add(Constants.LEG_POSITION_EFFECT);
            ALL_GROUP_FIELDS.add(Constants.LEG_COVERED_OR_UNCOVERED);
            ALL_GROUP_FIELDS.add(Constants.LEG_REF_ID);
            ALL_GROUP_FIELDS.add(Constants.LEG_PRICE);
            ALL_GROUP_FIELDS.add(Constants.LEG_SETTL_TYPE);
            ALL_GROUP_FIELDS.add(Constants.LEG_SETTL_DATE);
            ALL_GROUP_FIELDS.add(Constants.LEG_LAST_PX);
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
        if (hasLegSwapType)
        {
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !LegSwapType.isValid(legSwapType()))
        {
            invalidTagId = 690;
            rejectReason = 5;
            return false;
        }
        }
        if (hasNoLegSecurityAltIDGroupCounter)
        {
            {
                int count = 0;
                final LegSecurityAltIDGroupIterator iterator = legSecurityAltIDGroupIterator.iterator();
                for (final LegSecurityAltIDGroupDecoder group : iterator)
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
                    invalidTagId = 604;
                    rejectReason = 16;
                    return false;
                }
            }
        }

        if (hasNoLegStipulationsGroupCounter)
        {
            {
                int count = 0;
                final LegStipulationsGroupIterator iterator = legStipulationsGroupIterator.iterator();
                for (final LegStipulationsGroupDecoder group : iterator)
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
                    invalidTagId = 683;
                    rejectReason = 16;
                    return false;
                }
            }
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
    public LegsGroupDecoder(final TrailerDecoder trailer, final IntHashSet messageFields)
    {
        this.trailer = trailer;
        this.messageFields = messageFields;
    }

    private LegsGroupDecoder next = null;

    public LegsGroupDecoder next()
    {
        return next;
    }

    private IntHashSet seenFields = new IntHashSet(24);


    private char[] legSymbol = new char[1];

    /* LegSymbol = 600 */
    public char[] legSymbol()
    {
        return legSymbol;
    }


    private int legSymbolOffset;

    private int legSymbolLength;

    /* LegSymbol = 600 */
    public int legSymbolLength()
    {
        return legSymbolLength;
    }

    /* LegSymbol = 600 */
    public String legSymbolAsString()
    {
        return new String(legSymbol, 0, legSymbolLength);
    }

    /* LegSymbol = 600 */
    public AsciiSequenceView legSymbol(final AsciiSequenceView view)
    {
        return view.wrap(buffer, legSymbolOffset, legSymbolLength);
    }


    private final CharArrayWrapper legSymbolWrapper = new CharArrayWrapper();
    private char[] legSymbolSfx = new char[1];

    private boolean hasLegSymbolSfx;

    /* LegSymbolSfx = 601 */
    public char[] legSymbolSfx()
    {
        if (!hasLegSymbolSfx)
        {
            throw new IllegalArgumentException("No value for optional field: LegSymbolSfx");
        }

        return legSymbolSfx;
    }

    public boolean hasLegSymbolSfx()
    {
        return hasLegSymbolSfx;
    }


    private int legSymbolSfxOffset;

    private int legSymbolSfxLength;

    /* LegSymbolSfx = 601 */
    public int legSymbolSfxLength()
    {
        if (!hasLegSymbolSfx)
        {
            throw new IllegalArgumentException("No value for optional field: LegSymbolSfx");
        }

        return legSymbolSfxLength;
    }

    /* LegSymbolSfx = 601 */
    public String legSymbolSfxAsString()
    {
        return hasLegSymbolSfx ? new String(legSymbolSfx, 0, legSymbolSfxLength) : null;
    }

    /* LegSymbolSfx = 601 */
    public AsciiSequenceView legSymbolSfx(final AsciiSequenceView view)
    {
        if (!hasLegSymbolSfx)
        {
            throw new IllegalArgumentException("No value for optional field: LegSymbolSfx");
        }

        return view.wrap(buffer, legSymbolSfxOffset, legSymbolSfxLength);
    }


    private final CharArrayWrapper legSymbolSfxWrapper = new CharArrayWrapper();
    private char[] legSecurityID = new char[1];

    private boolean hasLegSecurityID;

    /* LegSecurityID = 602 */
    public char[] legSecurityID()
    {
        if (!hasLegSecurityID)
        {
            throw new IllegalArgumentException("No value for optional field: LegSecurityID");
        }

        return legSecurityID;
    }

    public boolean hasLegSecurityID()
    {
        return hasLegSecurityID;
    }


    private int legSecurityIDOffset;

    private int legSecurityIDLength;

    /* LegSecurityID = 602 */
    public int legSecurityIDLength()
    {
        if (!hasLegSecurityID)
        {
            throw new IllegalArgumentException("No value for optional field: LegSecurityID");
        }

        return legSecurityIDLength;
    }

    /* LegSecurityID = 602 */
    public String legSecurityIDAsString()
    {
        return hasLegSecurityID ? new String(legSecurityID, 0, legSecurityIDLength) : null;
    }

    /* LegSecurityID = 602 */
    public AsciiSequenceView legSecurityID(final AsciiSequenceView view)
    {
        if (!hasLegSecurityID)
        {
            throw new IllegalArgumentException("No value for optional field: LegSecurityID");
        }

        return view.wrap(buffer, legSecurityIDOffset, legSecurityIDLength);
    }


    private final CharArrayWrapper legSecurityIDWrapper = new CharArrayWrapper();
    private char[] legSecurityIDSource = new char[1];

    private boolean hasLegSecurityIDSource;

    /* LegSecurityIDSource = 603 */
    public char[] legSecurityIDSource()
    {
        if (!hasLegSecurityIDSource)
        {
            throw new IllegalArgumentException("No value for optional field: LegSecurityIDSource");
        }

        return legSecurityIDSource;
    }

    public boolean hasLegSecurityIDSource()
    {
        return hasLegSecurityIDSource;
    }


    private int legSecurityIDSourceOffset;

    private int legSecurityIDSourceLength;

    /* LegSecurityIDSource = 603 */
    public int legSecurityIDSourceLength()
    {
        if (!hasLegSecurityIDSource)
        {
            throw new IllegalArgumentException("No value for optional field: LegSecurityIDSource");
        }

        return legSecurityIDSourceLength;
    }

    /* LegSecurityIDSource = 603 */
    public String legSecurityIDSourceAsString()
    {
        return hasLegSecurityIDSource ? new String(legSecurityIDSource, 0, legSecurityIDSourceLength) : null;
    }

    /* LegSecurityIDSource = 603 */
    public AsciiSequenceView legSecurityIDSource(final AsciiSequenceView view)
    {
        if (!hasLegSecurityIDSource)
        {
            throw new IllegalArgumentException("No value for optional field: LegSecurityIDSource");
        }

        return view.wrap(buffer, legSecurityIDSourceOffset, legSecurityIDSourceLength);
    }


    private final CharArrayWrapper legSecurityIDSourceWrapper = new CharArrayWrapper();

    private LegSecurityAltIDGroupDecoder legSecurityAltIDGroup = null;
    public LegSecurityAltIDGroupDecoder legSecurityAltIDGroup()
    {
        return legSecurityAltIDGroup;
    }

    private int noLegSecurityAltIDGroupCounter = MISSING_INT;

    private boolean hasNoLegSecurityAltIDGroupCounter;

    /* NoLegSecurityAltIDGroupCounter = 604 */
    public int noLegSecurityAltIDGroupCounter()
    {
        if (!hasNoLegSecurityAltIDGroupCounter)
        {
            throw new IllegalArgumentException("No value for optional field: NoLegSecurityAltIDGroupCounter");
        }

        return noLegSecurityAltIDGroupCounter;
    }

    public boolean hasNoLegSecurityAltIDGroupCounter()
    {
        return hasNoLegSecurityAltIDGroupCounter;
    }




    private LegSecurityAltIDGroupIterator legSecurityAltIDGroupIterator = new LegSecurityAltIDGroupIterator(this);
    public LegSecurityAltIDGroupIterator legSecurityAltIDGroupIterator()
    {
        return legSecurityAltIDGroupIterator.iterator();
    }

    private int legProduct = MISSING_INT;

    private boolean hasLegProduct;

    /* LegProduct = 607 */
    public int legProduct()
    {
        if (!hasLegProduct)
        {
            throw new IllegalArgumentException("No value for optional field: LegProduct");
        }

        return legProduct;
    }

    public boolean hasLegProduct()
    {
        return hasLegProduct;
    }



    private char[] legCFICode = new char[1];

    private boolean hasLegCFICode;

    /* LegCFICode = 608 */
    public char[] legCFICode()
    {
        if (!hasLegCFICode)
        {
            throw new IllegalArgumentException("No value for optional field: LegCFICode");
        }

        return legCFICode;
    }

    public boolean hasLegCFICode()
    {
        return hasLegCFICode;
    }


    private int legCFICodeOffset;

    private int legCFICodeLength;

    /* LegCFICode = 608 */
    public int legCFICodeLength()
    {
        if (!hasLegCFICode)
        {
            throw new IllegalArgumentException("No value for optional field: LegCFICode");
        }

        return legCFICodeLength;
    }

    /* LegCFICode = 608 */
    public String legCFICodeAsString()
    {
        return hasLegCFICode ? new String(legCFICode, 0, legCFICodeLength) : null;
    }

    /* LegCFICode = 608 */
    public AsciiSequenceView legCFICode(final AsciiSequenceView view)
    {
        if (!hasLegCFICode)
        {
            throw new IllegalArgumentException("No value for optional field: LegCFICode");
        }

        return view.wrap(buffer, legCFICodeOffset, legCFICodeLength);
    }


    private final CharArrayWrapper legCFICodeWrapper = new CharArrayWrapper();
    private char[] legSecurityType = new char[1];

    private boolean hasLegSecurityType;

    /* LegSecurityType = 609 */
    public char[] legSecurityType()
    {
        if (!hasLegSecurityType)
        {
            throw new IllegalArgumentException("No value for optional field: LegSecurityType");
        }

        return legSecurityType;
    }

    public boolean hasLegSecurityType()
    {
        return hasLegSecurityType;
    }


    private int legSecurityTypeOffset;

    private int legSecurityTypeLength;

    /* LegSecurityType = 609 */
    public int legSecurityTypeLength()
    {
        if (!hasLegSecurityType)
        {
            throw new IllegalArgumentException("No value for optional field: LegSecurityType");
        }

        return legSecurityTypeLength;
    }

    /* LegSecurityType = 609 */
    public String legSecurityTypeAsString()
    {
        return hasLegSecurityType ? new String(legSecurityType, 0, legSecurityTypeLength) : null;
    }

    /* LegSecurityType = 609 */
    public AsciiSequenceView legSecurityType(final AsciiSequenceView view)
    {
        if (!hasLegSecurityType)
        {
            throw new IllegalArgumentException("No value for optional field: LegSecurityType");
        }

        return view.wrap(buffer, legSecurityTypeOffset, legSecurityTypeLength);
    }


    private final CharArrayWrapper legSecurityTypeWrapper = new CharArrayWrapper();
    private char[] legSecuritySubType = new char[1];

    private boolean hasLegSecuritySubType;

    /* LegSecuritySubType = 764 */
    public char[] legSecuritySubType()
    {
        if (!hasLegSecuritySubType)
        {
            throw new IllegalArgumentException("No value for optional field: LegSecuritySubType");
        }

        return legSecuritySubType;
    }

    public boolean hasLegSecuritySubType()
    {
        return hasLegSecuritySubType;
    }


    private int legSecuritySubTypeOffset;

    private int legSecuritySubTypeLength;

    /* LegSecuritySubType = 764 */
    public int legSecuritySubTypeLength()
    {
        if (!hasLegSecuritySubType)
        {
            throw new IllegalArgumentException("No value for optional field: LegSecuritySubType");
        }

        return legSecuritySubTypeLength;
    }

    /* LegSecuritySubType = 764 */
    public String legSecuritySubTypeAsString()
    {
        return hasLegSecuritySubType ? new String(legSecuritySubType, 0, legSecuritySubTypeLength) : null;
    }

    /* LegSecuritySubType = 764 */
    public AsciiSequenceView legSecuritySubType(final AsciiSequenceView view)
    {
        if (!hasLegSecuritySubType)
        {
            throw new IllegalArgumentException("No value for optional field: LegSecuritySubType");
        }

        return view.wrap(buffer, legSecuritySubTypeOffset, legSecuritySubTypeLength);
    }


    private final CharArrayWrapper legSecuritySubTypeWrapper = new CharArrayWrapper();
    private byte[] legMaturityMonthYear = new byte[8];

    private boolean hasLegMaturityMonthYear;

    /* LegMaturityMonthYear = 610 */
    public byte[] legMaturityMonthYear()
    {
        if (!hasLegMaturityMonthYear)
        {
            throw new IllegalArgumentException("No value for optional field: LegMaturityMonthYear");
        }

        return legMaturityMonthYear;
    }

    public boolean hasLegMaturityMonthYear()
    {
        return hasLegMaturityMonthYear;
    }


    private int legMaturityMonthYearOffset;

    private int legMaturityMonthYearLength;

    /* LegMaturityMonthYear = 610 */
    public int legMaturityMonthYearLength()
    {
        if (!hasLegMaturityMonthYear)
        {
            throw new IllegalArgumentException("No value for optional field: LegMaturityMonthYear");
        }

        return legMaturityMonthYearLength;
    }

    /* LegMaturityMonthYear = 610 */
    public String legMaturityMonthYearAsString()
    {
        return hasLegMaturityMonthYear ? new String(legMaturityMonthYear, 0, legMaturityMonthYearLength) : null;
    }

    /* LegMaturityMonthYear = 610 */
    public AsciiSequenceView legMaturityMonthYear(final AsciiSequenceView view)
    {
        if (!hasLegMaturityMonthYear)
        {
            throw new IllegalArgumentException("No value for optional field: LegMaturityMonthYear");
        }

        return view.wrap(buffer, legMaturityMonthYearOffset, legMaturityMonthYearLength);
    }


    private byte[] legMaturityDate = new byte[8];

    private boolean hasLegMaturityDate;

    /* LegMaturityDate = 611 */
    public byte[] legMaturityDate()
    {
        if (!hasLegMaturityDate)
        {
            throw new IllegalArgumentException("No value for optional field: LegMaturityDate");
        }

        return legMaturityDate;
    }

    public boolean hasLegMaturityDate()
    {
        return hasLegMaturityDate;
    }


    private int legMaturityDateOffset;

    private int legMaturityDateLength;

    /* LegMaturityDate = 611 */
    public int legMaturityDateLength()
    {
        if (!hasLegMaturityDate)
        {
            throw new IllegalArgumentException("No value for optional field: LegMaturityDate");
        }

        return legMaturityDateLength;
    }

    /* LegMaturityDate = 611 */
    public String legMaturityDateAsString()
    {
        return hasLegMaturityDate ? new String(legMaturityDate, 0, legMaturityDateLength) : null;
    }

    /* LegMaturityDate = 611 */
    public AsciiSequenceView legMaturityDate(final AsciiSequenceView view)
    {
        if (!hasLegMaturityDate)
        {
            throw new IllegalArgumentException("No value for optional field: LegMaturityDate");
        }

        return view.wrap(buffer, legMaturityDateOffset, legMaturityDateLength);
    }


    private byte[] legCouponPaymentDate = new byte[8];

    private boolean hasLegCouponPaymentDate;

    /* LegCouponPaymentDate = 248 */
    public byte[] legCouponPaymentDate()
    {
        if (!hasLegCouponPaymentDate)
        {
            throw new IllegalArgumentException("No value for optional field: LegCouponPaymentDate");
        }

        return legCouponPaymentDate;
    }

    public boolean hasLegCouponPaymentDate()
    {
        return hasLegCouponPaymentDate;
    }


    private int legCouponPaymentDateOffset;

    private int legCouponPaymentDateLength;

    /* LegCouponPaymentDate = 248 */
    public int legCouponPaymentDateLength()
    {
        if (!hasLegCouponPaymentDate)
        {
            throw new IllegalArgumentException("No value for optional field: LegCouponPaymentDate");
        }

        return legCouponPaymentDateLength;
    }

    /* LegCouponPaymentDate = 248 */
    public String legCouponPaymentDateAsString()
    {
        return hasLegCouponPaymentDate ? new String(legCouponPaymentDate, 0, legCouponPaymentDateLength) : null;
    }

    /* LegCouponPaymentDate = 248 */
    public AsciiSequenceView legCouponPaymentDate(final AsciiSequenceView view)
    {
        if (!hasLegCouponPaymentDate)
        {
            throw new IllegalArgumentException("No value for optional field: LegCouponPaymentDate");
        }

        return view.wrap(buffer, legCouponPaymentDateOffset, legCouponPaymentDateLength);
    }


    private byte[] legIssueDate = new byte[8];

    private boolean hasLegIssueDate;

    /* LegIssueDate = 249 */
    public byte[] legIssueDate()
    {
        if (!hasLegIssueDate)
        {
            throw new IllegalArgumentException("No value for optional field: LegIssueDate");
        }

        return legIssueDate;
    }

    public boolean hasLegIssueDate()
    {
        return hasLegIssueDate;
    }


    private int legIssueDateOffset;

    private int legIssueDateLength;

    /* LegIssueDate = 249 */
    public int legIssueDateLength()
    {
        if (!hasLegIssueDate)
        {
            throw new IllegalArgumentException("No value for optional field: LegIssueDate");
        }

        return legIssueDateLength;
    }

    /* LegIssueDate = 249 */
    public String legIssueDateAsString()
    {
        return hasLegIssueDate ? new String(legIssueDate, 0, legIssueDateLength) : null;
    }

    /* LegIssueDate = 249 */
    public AsciiSequenceView legIssueDate(final AsciiSequenceView view)
    {
        if (!hasLegIssueDate)
        {
            throw new IllegalArgumentException("No value for optional field: LegIssueDate");
        }

        return view.wrap(buffer, legIssueDateOffset, legIssueDateLength);
    }


    private int legRepoCollateralSecurityType = MISSING_INT;

    private boolean hasLegRepoCollateralSecurityType;

    /* LegRepoCollateralSecurityType = 250 */
    public int legRepoCollateralSecurityType()
    {
        if (!hasLegRepoCollateralSecurityType)
        {
            throw new IllegalArgumentException("No value for optional field: LegRepoCollateralSecurityType");
        }

        return legRepoCollateralSecurityType;
    }

    public boolean hasLegRepoCollateralSecurityType()
    {
        return hasLegRepoCollateralSecurityType;
    }



    private int legRepurchaseTerm = MISSING_INT;

    private boolean hasLegRepurchaseTerm;

    /* LegRepurchaseTerm = 251 */
    public int legRepurchaseTerm()
    {
        if (!hasLegRepurchaseTerm)
        {
            throw new IllegalArgumentException("No value for optional field: LegRepurchaseTerm");
        }

        return legRepurchaseTerm;
    }

    public boolean hasLegRepurchaseTerm()
    {
        return hasLegRepurchaseTerm;
    }



    private DecimalFloat legRepurchaseRate = DecimalFloat.newNaNValue();

    private boolean hasLegRepurchaseRate;

    /* LegRepurchaseRate = 252 */
    public DecimalFloat legRepurchaseRate()
    {
        if (!hasLegRepurchaseRate)
        {
            throw new IllegalArgumentException("No value for optional field: LegRepurchaseRate");
        }

        return legRepurchaseRate;
    }

    public boolean hasLegRepurchaseRate()
    {
        return hasLegRepurchaseRate;
    }



    private DecimalFloat legFactor = DecimalFloat.newNaNValue();

    private boolean hasLegFactor;

    /* LegFactor = 253 */
    public DecimalFloat legFactor()
    {
        if (!hasLegFactor)
        {
            throw new IllegalArgumentException("No value for optional field: LegFactor");
        }

        return legFactor;
    }

    public boolean hasLegFactor()
    {
        return hasLegFactor;
    }



    private char[] legCreditRating = new char[1];

    private boolean hasLegCreditRating;

    /* LegCreditRating = 257 */
    public char[] legCreditRating()
    {
        if (!hasLegCreditRating)
        {
            throw new IllegalArgumentException("No value for optional field: LegCreditRating");
        }

        return legCreditRating;
    }

    public boolean hasLegCreditRating()
    {
        return hasLegCreditRating;
    }


    private int legCreditRatingOffset;

    private int legCreditRatingLength;

    /* LegCreditRating = 257 */
    public int legCreditRatingLength()
    {
        if (!hasLegCreditRating)
        {
            throw new IllegalArgumentException("No value for optional field: LegCreditRating");
        }

        return legCreditRatingLength;
    }

    /* LegCreditRating = 257 */
    public String legCreditRatingAsString()
    {
        return hasLegCreditRating ? new String(legCreditRating, 0, legCreditRatingLength) : null;
    }

    /* LegCreditRating = 257 */
    public AsciiSequenceView legCreditRating(final AsciiSequenceView view)
    {
        if (!hasLegCreditRating)
        {
            throw new IllegalArgumentException("No value for optional field: LegCreditRating");
        }

        return view.wrap(buffer, legCreditRatingOffset, legCreditRatingLength);
    }


    private final CharArrayWrapper legCreditRatingWrapper = new CharArrayWrapper();
    private char[] legInstrRegistry = new char[1];

    private boolean hasLegInstrRegistry;

    /* LegInstrRegistry = 599 */
    public char[] legInstrRegistry()
    {
        if (!hasLegInstrRegistry)
        {
            throw new IllegalArgumentException("No value for optional field: LegInstrRegistry");
        }

        return legInstrRegistry;
    }

    public boolean hasLegInstrRegistry()
    {
        return hasLegInstrRegistry;
    }


    private int legInstrRegistryOffset;

    private int legInstrRegistryLength;

    /* LegInstrRegistry = 599 */
    public int legInstrRegistryLength()
    {
        if (!hasLegInstrRegistry)
        {
            throw new IllegalArgumentException("No value for optional field: LegInstrRegistry");
        }

        return legInstrRegistryLength;
    }

    /* LegInstrRegistry = 599 */
    public String legInstrRegistryAsString()
    {
        return hasLegInstrRegistry ? new String(legInstrRegistry, 0, legInstrRegistryLength) : null;
    }

    /* LegInstrRegistry = 599 */
    public AsciiSequenceView legInstrRegistry(final AsciiSequenceView view)
    {
        if (!hasLegInstrRegistry)
        {
            throw new IllegalArgumentException("No value for optional field: LegInstrRegistry");
        }

        return view.wrap(buffer, legInstrRegistryOffset, legInstrRegistryLength);
    }


    private final CharArrayWrapper legInstrRegistryWrapper = new CharArrayWrapper();
    private char[] legCountryOfIssue = new char[1];

    private boolean hasLegCountryOfIssue;

    /* LegCountryOfIssue = 596 */
    public char[] legCountryOfIssue()
    {
        if (!hasLegCountryOfIssue)
        {
            throw new IllegalArgumentException("No value for optional field: LegCountryOfIssue");
        }

        return legCountryOfIssue;
    }

    public boolean hasLegCountryOfIssue()
    {
        return hasLegCountryOfIssue;
    }


    private int legCountryOfIssueOffset;

    private int legCountryOfIssueLength;

    /* LegCountryOfIssue = 596 */
    public int legCountryOfIssueLength()
    {
        if (!hasLegCountryOfIssue)
        {
            throw new IllegalArgumentException("No value for optional field: LegCountryOfIssue");
        }

        return legCountryOfIssueLength;
    }

    /* LegCountryOfIssue = 596 */
    public String legCountryOfIssueAsString()
    {
        return hasLegCountryOfIssue ? new String(legCountryOfIssue, 0, legCountryOfIssueLength) : null;
    }

    /* LegCountryOfIssue = 596 */
    public AsciiSequenceView legCountryOfIssue(final AsciiSequenceView view)
    {
        if (!hasLegCountryOfIssue)
        {
            throw new IllegalArgumentException("No value for optional field: LegCountryOfIssue");
        }

        return view.wrap(buffer, legCountryOfIssueOffset, legCountryOfIssueLength);
    }


    private char[] legStateOrProvinceOfIssue = new char[1];

    private boolean hasLegStateOrProvinceOfIssue;

    /* LegStateOrProvinceOfIssue = 597 */
    public char[] legStateOrProvinceOfIssue()
    {
        if (!hasLegStateOrProvinceOfIssue)
        {
            throw new IllegalArgumentException("No value for optional field: LegStateOrProvinceOfIssue");
        }

        return legStateOrProvinceOfIssue;
    }

    public boolean hasLegStateOrProvinceOfIssue()
    {
        return hasLegStateOrProvinceOfIssue;
    }


    private int legStateOrProvinceOfIssueOffset;

    private int legStateOrProvinceOfIssueLength;

    /* LegStateOrProvinceOfIssue = 597 */
    public int legStateOrProvinceOfIssueLength()
    {
        if (!hasLegStateOrProvinceOfIssue)
        {
            throw new IllegalArgumentException("No value for optional field: LegStateOrProvinceOfIssue");
        }

        return legStateOrProvinceOfIssueLength;
    }

    /* LegStateOrProvinceOfIssue = 597 */
    public String legStateOrProvinceOfIssueAsString()
    {
        return hasLegStateOrProvinceOfIssue ? new String(legStateOrProvinceOfIssue, 0, legStateOrProvinceOfIssueLength) : null;
    }

    /* LegStateOrProvinceOfIssue = 597 */
    public AsciiSequenceView legStateOrProvinceOfIssue(final AsciiSequenceView view)
    {
        if (!hasLegStateOrProvinceOfIssue)
        {
            throw new IllegalArgumentException("No value for optional field: LegStateOrProvinceOfIssue");
        }

        return view.wrap(buffer, legStateOrProvinceOfIssueOffset, legStateOrProvinceOfIssueLength);
    }


    private final CharArrayWrapper legStateOrProvinceOfIssueWrapper = new CharArrayWrapper();
    private char[] legLocaleOfIssue = new char[1];

    private boolean hasLegLocaleOfIssue;

    /* LegLocaleOfIssue = 598 */
    public char[] legLocaleOfIssue()
    {
        if (!hasLegLocaleOfIssue)
        {
            throw new IllegalArgumentException("No value for optional field: LegLocaleOfIssue");
        }

        return legLocaleOfIssue;
    }

    public boolean hasLegLocaleOfIssue()
    {
        return hasLegLocaleOfIssue;
    }


    private int legLocaleOfIssueOffset;

    private int legLocaleOfIssueLength;

    /* LegLocaleOfIssue = 598 */
    public int legLocaleOfIssueLength()
    {
        if (!hasLegLocaleOfIssue)
        {
            throw new IllegalArgumentException("No value for optional field: LegLocaleOfIssue");
        }

        return legLocaleOfIssueLength;
    }

    /* LegLocaleOfIssue = 598 */
    public String legLocaleOfIssueAsString()
    {
        return hasLegLocaleOfIssue ? new String(legLocaleOfIssue, 0, legLocaleOfIssueLength) : null;
    }

    /* LegLocaleOfIssue = 598 */
    public AsciiSequenceView legLocaleOfIssue(final AsciiSequenceView view)
    {
        if (!hasLegLocaleOfIssue)
        {
            throw new IllegalArgumentException("No value for optional field: LegLocaleOfIssue");
        }

        return view.wrap(buffer, legLocaleOfIssueOffset, legLocaleOfIssueLength);
    }


    private final CharArrayWrapper legLocaleOfIssueWrapper = new CharArrayWrapper();
    private byte[] legRedemptionDate = new byte[8];

    private boolean hasLegRedemptionDate;

    /* LegRedemptionDate = 254 */
    public byte[] legRedemptionDate()
    {
        if (!hasLegRedemptionDate)
        {
            throw new IllegalArgumentException("No value for optional field: LegRedemptionDate");
        }

        return legRedemptionDate;
    }

    public boolean hasLegRedemptionDate()
    {
        return hasLegRedemptionDate;
    }


    private int legRedemptionDateOffset;

    private int legRedemptionDateLength;

    /* LegRedemptionDate = 254 */
    public int legRedemptionDateLength()
    {
        if (!hasLegRedemptionDate)
        {
            throw new IllegalArgumentException("No value for optional field: LegRedemptionDate");
        }

        return legRedemptionDateLength;
    }

    /* LegRedemptionDate = 254 */
    public String legRedemptionDateAsString()
    {
        return hasLegRedemptionDate ? new String(legRedemptionDate, 0, legRedemptionDateLength) : null;
    }

    /* LegRedemptionDate = 254 */
    public AsciiSequenceView legRedemptionDate(final AsciiSequenceView view)
    {
        if (!hasLegRedemptionDate)
        {
            throw new IllegalArgumentException("No value for optional field: LegRedemptionDate");
        }

        return view.wrap(buffer, legRedemptionDateOffset, legRedemptionDateLength);
    }


    private DecimalFloat legStrikePrice = DecimalFloat.newNaNValue();

    private boolean hasLegStrikePrice;

    /* LegStrikePrice = 612 */
    public DecimalFloat legStrikePrice()
    {
        if (!hasLegStrikePrice)
        {
            throw new IllegalArgumentException("No value for optional field: LegStrikePrice");
        }

        return legStrikePrice;
    }

    public boolean hasLegStrikePrice()
    {
        return hasLegStrikePrice;
    }



    private char[] legStrikeCurrency = new char[1];

    private boolean hasLegStrikeCurrency;

    /* LegStrikeCurrency = 942 */
    public char[] legStrikeCurrency()
    {
        if (!hasLegStrikeCurrency)
        {
            throw new IllegalArgumentException("No value for optional field: LegStrikeCurrency");
        }

        return legStrikeCurrency;
    }

    public boolean hasLegStrikeCurrency()
    {
        return hasLegStrikeCurrency;
    }


    private int legStrikeCurrencyOffset;

    private int legStrikeCurrencyLength;

    /* LegStrikeCurrency = 942 */
    public int legStrikeCurrencyLength()
    {
        if (!hasLegStrikeCurrency)
        {
            throw new IllegalArgumentException("No value for optional field: LegStrikeCurrency");
        }

        return legStrikeCurrencyLength;
    }

    /* LegStrikeCurrency = 942 */
    public String legStrikeCurrencyAsString()
    {
        return hasLegStrikeCurrency ? new String(legStrikeCurrency, 0, legStrikeCurrencyLength) : null;
    }

    /* LegStrikeCurrency = 942 */
    public AsciiSequenceView legStrikeCurrency(final AsciiSequenceView view)
    {
        if (!hasLegStrikeCurrency)
        {
            throw new IllegalArgumentException("No value for optional field: LegStrikeCurrency");
        }

        return view.wrap(buffer, legStrikeCurrencyOffset, legStrikeCurrencyLength);
    }


    private char legOptAttribute = MISSING_CHAR;

    private boolean hasLegOptAttribute;

    /* LegOptAttribute = 613 */
    public char legOptAttribute()
    {
        if (!hasLegOptAttribute)
        {
            throw new IllegalArgumentException("No value for optional field: LegOptAttribute");
        }

        return legOptAttribute;
    }

    public boolean hasLegOptAttribute()
    {
        return hasLegOptAttribute;
    }



    private DecimalFloat legContractMultiplier = DecimalFloat.newNaNValue();

    private boolean hasLegContractMultiplier;

    /* LegContractMultiplier = 614 */
    public DecimalFloat legContractMultiplier()
    {
        if (!hasLegContractMultiplier)
        {
            throw new IllegalArgumentException("No value for optional field: LegContractMultiplier");
        }

        return legContractMultiplier;
    }

    public boolean hasLegContractMultiplier()
    {
        return hasLegContractMultiplier;
    }



    private DecimalFloat legCouponRate = DecimalFloat.newNaNValue();

    private boolean hasLegCouponRate;

    /* LegCouponRate = 615 */
    public DecimalFloat legCouponRate()
    {
        if (!hasLegCouponRate)
        {
            throw new IllegalArgumentException("No value for optional field: LegCouponRate");
        }

        return legCouponRate;
    }

    public boolean hasLegCouponRate()
    {
        return hasLegCouponRate;
    }



    private char[] legSecurityExchange = new char[1];

    private boolean hasLegSecurityExchange;

    /* LegSecurityExchange = 616 */
    public char[] legSecurityExchange()
    {
        if (!hasLegSecurityExchange)
        {
            throw new IllegalArgumentException("No value for optional field: LegSecurityExchange");
        }

        return legSecurityExchange;
    }

    public boolean hasLegSecurityExchange()
    {
        return hasLegSecurityExchange;
    }


    private int legSecurityExchangeOffset;

    private int legSecurityExchangeLength;

    /* LegSecurityExchange = 616 */
    public int legSecurityExchangeLength()
    {
        if (!hasLegSecurityExchange)
        {
            throw new IllegalArgumentException("No value for optional field: LegSecurityExchange");
        }

        return legSecurityExchangeLength;
    }

    /* LegSecurityExchange = 616 */
    public String legSecurityExchangeAsString()
    {
        return hasLegSecurityExchange ? new String(legSecurityExchange, 0, legSecurityExchangeLength) : null;
    }

    /* LegSecurityExchange = 616 */
    public AsciiSequenceView legSecurityExchange(final AsciiSequenceView view)
    {
        if (!hasLegSecurityExchange)
        {
            throw new IllegalArgumentException("No value for optional field: LegSecurityExchange");
        }

        return view.wrap(buffer, legSecurityExchangeOffset, legSecurityExchangeLength);
    }


    private char[] legIssuer = new char[1];

    private boolean hasLegIssuer;

    /* LegIssuer = 617 */
    public char[] legIssuer()
    {
        if (!hasLegIssuer)
        {
            throw new IllegalArgumentException("No value for optional field: LegIssuer");
        }

        return legIssuer;
    }

    public boolean hasLegIssuer()
    {
        return hasLegIssuer;
    }


    private int legIssuerOffset;

    private int legIssuerLength;

    /* LegIssuer = 617 */
    public int legIssuerLength()
    {
        if (!hasLegIssuer)
        {
            throw new IllegalArgumentException("No value for optional field: LegIssuer");
        }

        return legIssuerLength;
    }

    /* LegIssuer = 617 */
    public String legIssuerAsString()
    {
        return hasLegIssuer ? new String(legIssuer, 0, legIssuerLength) : null;
    }

    /* LegIssuer = 617 */
    public AsciiSequenceView legIssuer(final AsciiSequenceView view)
    {
        if (!hasLegIssuer)
        {
            throw new IllegalArgumentException("No value for optional field: LegIssuer");
        }

        return view.wrap(buffer, legIssuerOffset, legIssuerLength);
    }


    private final CharArrayWrapper legIssuerWrapper = new CharArrayWrapper();
    private int encodedLegIssuerLen = MISSING_INT;

    private boolean hasEncodedLegIssuerLen;

    /* EncodedLegIssuerLen = 618 */
    public int encodedLegIssuerLen()
    {
        if (!hasEncodedLegIssuerLen)
        {
            throw new IllegalArgumentException("No value for optional field: EncodedLegIssuerLen");
        }

        return encodedLegIssuerLen;
    }

    public boolean hasEncodedLegIssuerLen()
    {
        return hasEncodedLegIssuerLen;
    }



    private byte[] encodedLegIssuer = new byte[1];

    private boolean hasEncodedLegIssuer;

    /* EncodedLegIssuer = 619 */
    public byte[] encodedLegIssuer()
    {
        if (!hasEncodedLegIssuer)
        {
            throw new IllegalArgumentException("No value for optional field: EncodedLegIssuer");
        }

        return encodedLegIssuer;
    }

    public boolean hasEncodedLegIssuer()
    {
        return hasEncodedLegIssuer;
    }



    private char[] legSecurityDesc = new char[1];

    private boolean hasLegSecurityDesc;

    /* LegSecurityDesc = 620 */
    public char[] legSecurityDesc()
    {
        if (!hasLegSecurityDesc)
        {
            throw new IllegalArgumentException("No value for optional field: LegSecurityDesc");
        }

        return legSecurityDesc;
    }

    public boolean hasLegSecurityDesc()
    {
        return hasLegSecurityDesc;
    }


    private int legSecurityDescOffset;

    private int legSecurityDescLength;

    /* LegSecurityDesc = 620 */
    public int legSecurityDescLength()
    {
        if (!hasLegSecurityDesc)
        {
            throw new IllegalArgumentException("No value for optional field: LegSecurityDesc");
        }

        return legSecurityDescLength;
    }

    /* LegSecurityDesc = 620 */
    public String legSecurityDescAsString()
    {
        return hasLegSecurityDesc ? new String(legSecurityDesc, 0, legSecurityDescLength) : null;
    }

    /* LegSecurityDesc = 620 */
    public AsciiSequenceView legSecurityDesc(final AsciiSequenceView view)
    {
        if (!hasLegSecurityDesc)
        {
            throw new IllegalArgumentException("No value for optional field: LegSecurityDesc");
        }

        return view.wrap(buffer, legSecurityDescOffset, legSecurityDescLength);
    }


    private final CharArrayWrapper legSecurityDescWrapper = new CharArrayWrapper();
    private int encodedLegSecurityDescLen = MISSING_INT;

    private boolean hasEncodedLegSecurityDescLen;

    /* EncodedLegSecurityDescLen = 621 */
    public int encodedLegSecurityDescLen()
    {
        if (!hasEncodedLegSecurityDescLen)
        {
            throw new IllegalArgumentException("No value for optional field: EncodedLegSecurityDescLen");
        }

        return encodedLegSecurityDescLen;
    }

    public boolean hasEncodedLegSecurityDescLen()
    {
        return hasEncodedLegSecurityDescLen;
    }



    private byte[] encodedLegSecurityDesc = new byte[1];

    private boolean hasEncodedLegSecurityDesc;

    /* EncodedLegSecurityDesc = 622 */
    public byte[] encodedLegSecurityDesc()
    {
        if (!hasEncodedLegSecurityDesc)
        {
            throw new IllegalArgumentException("No value for optional field: EncodedLegSecurityDesc");
        }

        return encodedLegSecurityDesc;
    }

    public boolean hasEncodedLegSecurityDesc()
    {
        return hasEncodedLegSecurityDesc;
    }



    private DecimalFloat legRatioQty = DecimalFloat.newNaNValue();

    private boolean hasLegRatioQty;

    /* LegRatioQty = 623 */
    public DecimalFloat legRatioQty()
    {
        if (!hasLegRatioQty)
        {
            throw new IllegalArgumentException("No value for optional field: LegRatioQty");
        }

        return legRatioQty;
    }

    public boolean hasLegRatioQty()
    {
        return hasLegRatioQty;
    }



    private char legSide = MISSING_CHAR;

    private boolean hasLegSide;

    /* LegSide = 624 */
    public char legSide()
    {
        if (!hasLegSide)
        {
            throw new IllegalArgumentException("No value for optional field: LegSide");
        }

        return legSide;
    }

    public boolean hasLegSide()
    {
        return hasLegSide;
    }



    private char[] legCurrency = new char[1];

    private boolean hasLegCurrency;

    /* LegCurrency = 556 */
    public char[] legCurrency()
    {
        if (!hasLegCurrency)
        {
            throw new IllegalArgumentException("No value for optional field: LegCurrency");
        }

        return legCurrency;
    }

    public boolean hasLegCurrency()
    {
        return hasLegCurrency;
    }


    private int legCurrencyOffset;

    private int legCurrencyLength;

    /* LegCurrency = 556 */
    public int legCurrencyLength()
    {
        if (!hasLegCurrency)
        {
            throw new IllegalArgumentException("No value for optional field: LegCurrency");
        }

        return legCurrencyLength;
    }

    /* LegCurrency = 556 */
    public String legCurrencyAsString()
    {
        return hasLegCurrency ? new String(legCurrency, 0, legCurrencyLength) : null;
    }

    /* LegCurrency = 556 */
    public AsciiSequenceView legCurrency(final AsciiSequenceView view)
    {
        if (!hasLegCurrency)
        {
            throw new IllegalArgumentException("No value for optional field: LegCurrency");
        }

        return view.wrap(buffer, legCurrencyOffset, legCurrencyLength);
    }


    private char[] legPool = new char[1];

    private boolean hasLegPool;

    /* LegPool = 740 */
    public char[] legPool()
    {
        if (!hasLegPool)
        {
            throw new IllegalArgumentException("No value for optional field: LegPool");
        }

        return legPool;
    }

    public boolean hasLegPool()
    {
        return hasLegPool;
    }


    private int legPoolOffset;

    private int legPoolLength;

    /* LegPool = 740 */
    public int legPoolLength()
    {
        if (!hasLegPool)
        {
            throw new IllegalArgumentException("No value for optional field: LegPool");
        }

        return legPoolLength;
    }

    /* LegPool = 740 */
    public String legPoolAsString()
    {
        return hasLegPool ? new String(legPool, 0, legPoolLength) : null;
    }

    /* LegPool = 740 */
    public AsciiSequenceView legPool(final AsciiSequenceView view)
    {
        if (!hasLegPool)
        {
            throw new IllegalArgumentException("No value for optional field: LegPool");
        }

        return view.wrap(buffer, legPoolOffset, legPoolLength);
    }


    private final CharArrayWrapper legPoolWrapper = new CharArrayWrapper();
    private byte[] legDatedDate = new byte[8];

    private boolean hasLegDatedDate;

    /* LegDatedDate = 739 */
    public byte[] legDatedDate()
    {
        if (!hasLegDatedDate)
        {
            throw new IllegalArgumentException("No value for optional field: LegDatedDate");
        }

        return legDatedDate;
    }

    public boolean hasLegDatedDate()
    {
        return hasLegDatedDate;
    }


    private int legDatedDateOffset;

    private int legDatedDateLength;

    /* LegDatedDate = 739 */
    public int legDatedDateLength()
    {
        if (!hasLegDatedDate)
        {
            throw new IllegalArgumentException("No value for optional field: LegDatedDate");
        }

        return legDatedDateLength;
    }

    /* LegDatedDate = 739 */
    public String legDatedDateAsString()
    {
        return hasLegDatedDate ? new String(legDatedDate, 0, legDatedDateLength) : null;
    }

    /* LegDatedDate = 739 */
    public AsciiSequenceView legDatedDate(final AsciiSequenceView view)
    {
        if (!hasLegDatedDate)
        {
            throw new IllegalArgumentException("No value for optional field: LegDatedDate");
        }

        return view.wrap(buffer, legDatedDateOffset, legDatedDateLength);
    }


    private byte[] legContractSettlMonth = new byte[8];

    private boolean hasLegContractSettlMonth;

    /* LegContractSettlMonth = 955 */
    public byte[] legContractSettlMonth()
    {
        if (!hasLegContractSettlMonth)
        {
            throw new IllegalArgumentException("No value for optional field: LegContractSettlMonth");
        }

        return legContractSettlMonth;
    }

    public boolean hasLegContractSettlMonth()
    {
        return hasLegContractSettlMonth;
    }


    private int legContractSettlMonthOffset;

    private int legContractSettlMonthLength;

    /* LegContractSettlMonth = 955 */
    public int legContractSettlMonthLength()
    {
        if (!hasLegContractSettlMonth)
        {
            throw new IllegalArgumentException("No value for optional field: LegContractSettlMonth");
        }

        return legContractSettlMonthLength;
    }

    /* LegContractSettlMonth = 955 */
    public String legContractSettlMonthAsString()
    {
        return hasLegContractSettlMonth ? new String(legContractSettlMonth, 0, legContractSettlMonthLength) : null;
    }

    /* LegContractSettlMonth = 955 */
    public AsciiSequenceView legContractSettlMonth(final AsciiSequenceView view)
    {
        if (!hasLegContractSettlMonth)
        {
            throw new IllegalArgumentException("No value for optional field: LegContractSettlMonth");
        }

        return view.wrap(buffer, legContractSettlMonthOffset, legContractSettlMonthLength);
    }


    private byte[] legInterestAccrualDate = new byte[8];

    private boolean hasLegInterestAccrualDate;

    /* LegInterestAccrualDate = 956 */
    public byte[] legInterestAccrualDate()
    {
        if (!hasLegInterestAccrualDate)
        {
            throw new IllegalArgumentException("No value for optional field: LegInterestAccrualDate");
        }

        return legInterestAccrualDate;
    }

    public boolean hasLegInterestAccrualDate()
    {
        return hasLegInterestAccrualDate;
    }


    private int legInterestAccrualDateOffset;

    private int legInterestAccrualDateLength;

    /* LegInterestAccrualDate = 956 */
    public int legInterestAccrualDateLength()
    {
        if (!hasLegInterestAccrualDate)
        {
            throw new IllegalArgumentException("No value for optional field: LegInterestAccrualDate");
        }

        return legInterestAccrualDateLength;
    }

    /* LegInterestAccrualDate = 956 */
    public String legInterestAccrualDateAsString()
    {
        return hasLegInterestAccrualDate ? new String(legInterestAccrualDate, 0, legInterestAccrualDateLength) : null;
    }

    /* LegInterestAccrualDate = 956 */
    public AsciiSequenceView legInterestAccrualDate(final AsciiSequenceView view)
    {
        if (!hasLegInterestAccrualDate)
        {
            throw new IllegalArgumentException("No value for optional field: LegInterestAccrualDate");
        }

        return view.wrap(buffer, legInterestAccrualDateOffset, legInterestAccrualDateLength);
    }



    private DecimalFloat legQty = DecimalFloat.newNaNValue();

    private boolean hasLegQty;

    /* LegQty = 687 */
    public DecimalFloat legQty()
    {
        if (!hasLegQty)
        {
            throw new IllegalArgumentException("No value for optional field: LegQty");
        }

        return legQty;
    }

    public boolean hasLegQty()
    {
        return hasLegQty;
    }



    private int legSwapType = MISSING_INT;

    private boolean hasLegSwapType;

    /* LegSwapType = 690 */
    public int legSwapType()
    {
        if (!hasLegSwapType)
        {
            throw new IllegalArgumentException("No value for optional field: LegSwapType");
        }

        return legSwapType;
    }

    public boolean hasLegSwapType()
    {
        return hasLegSwapType;
    }



    private final CharArrayWrapper legSwapTypeWrapper = new CharArrayWrapper();
    /* LegSwapType = 690 */
    public LegSwapType legSwapTypeAsEnum()
    {
        if (!hasLegSwapType)
 return LegSwapType.NULL_VAL;
        return LegSwapType.decode(legSwapType);
    }



    private LegStipulationsGroupDecoder legStipulationsGroup = null;
    public LegStipulationsGroupDecoder legStipulationsGroup()
    {
        return legStipulationsGroup;
    }

    private int noLegStipulationsGroupCounter = MISSING_INT;

    private boolean hasNoLegStipulationsGroupCounter;

    /* NoLegStipulationsGroupCounter = 683 */
    public int noLegStipulationsGroupCounter()
    {
        if (!hasNoLegStipulationsGroupCounter)
        {
            throw new IllegalArgumentException("No value for optional field: NoLegStipulationsGroupCounter");
        }

        return noLegStipulationsGroupCounter;
    }

    public boolean hasNoLegStipulationsGroupCounter()
    {
        return hasNoLegStipulationsGroupCounter;
    }




    private LegStipulationsGroupIterator legStipulationsGroupIterator = new LegStipulationsGroupIterator(this);
    public LegStipulationsGroupIterator legStipulationsGroupIterator()
    {
        return legStipulationsGroupIterator.iterator();
    }


    private char legPositionEffect = MISSING_CHAR;

    private boolean hasLegPositionEffect;

    /* LegPositionEffect = 564 */
    public char legPositionEffect()
    {
        if (!hasLegPositionEffect)
        {
            throw new IllegalArgumentException("No value for optional field: LegPositionEffect");
        }

        return legPositionEffect;
    }

    public boolean hasLegPositionEffect()
    {
        return hasLegPositionEffect;
    }



    private int legCoveredOrUncovered = MISSING_INT;

    private boolean hasLegCoveredOrUncovered;

    /* LegCoveredOrUncovered = 565 */
    public int legCoveredOrUncovered()
    {
        if (!hasLegCoveredOrUncovered)
        {
            throw new IllegalArgumentException("No value for optional field: LegCoveredOrUncovered");
        }

        return legCoveredOrUncovered;
    }

    public boolean hasLegCoveredOrUncovered()
    {
        return hasLegCoveredOrUncovered;
    }





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


    private char[] legRefID = new char[1];

    private boolean hasLegRefID;

    /* LegRefID = 654 */
    public char[] legRefID()
    {
        if (!hasLegRefID)
        {
            throw new IllegalArgumentException("No value for optional field: LegRefID");
        }

        return legRefID;
    }

    public boolean hasLegRefID()
    {
        return hasLegRefID;
    }


    private int legRefIDOffset;

    private int legRefIDLength;

    /* LegRefID = 654 */
    public int legRefIDLength()
    {
        if (!hasLegRefID)
        {
            throw new IllegalArgumentException("No value for optional field: LegRefID");
        }

        return legRefIDLength;
    }

    /* LegRefID = 654 */
    public String legRefIDAsString()
    {
        return hasLegRefID ? new String(legRefID, 0, legRefIDLength) : null;
    }

    /* LegRefID = 654 */
    public AsciiSequenceView legRefID(final AsciiSequenceView view)
    {
        if (!hasLegRefID)
        {
            throw new IllegalArgumentException("No value for optional field: LegRefID");
        }

        return view.wrap(buffer, legRefIDOffset, legRefIDLength);
    }


    private final CharArrayWrapper legRefIDWrapper = new CharArrayWrapper();
    private DecimalFloat legPrice = DecimalFloat.newNaNValue();

    private boolean hasLegPrice;

    /* LegPrice = 566 */
    public DecimalFloat legPrice()
    {
        if (!hasLegPrice)
        {
            throw new IllegalArgumentException("No value for optional field: LegPrice");
        }

        return legPrice;
    }

    public boolean hasLegPrice()
    {
        return hasLegPrice;
    }



    private char legSettlType = MISSING_CHAR;

    private boolean hasLegSettlType;

    /* LegSettlType = 587 */
    public char legSettlType()
    {
        if (!hasLegSettlType)
        {
            throw new IllegalArgumentException("No value for optional field: LegSettlType");
        }

        return legSettlType;
    }

    public boolean hasLegSettlType()
    {
        return hasLegSettlType;
    }



    private byte[] legSettlDate = new byte[8];

    private boolean hasLegSettlDate;

    /* LegSettlDate = 588 */
    public byte[] legSettlDate()
    {
        if (!hasLegSettlDate)
        {
            throw new IllegalArgumentException("No value for optional field: LegSettlDate");
        }

        return legSettlDate;
    }

    public boolean hasLegSettlDate()
    {
        return hasLegSettlDate;
    }


    private int legSettlDateOffset;

    private int legSettlDateLength;

    /* LegSettlDate = 588 */
    public int legSettlDateLength()
    {
        if (!hasLegSettlDate)
        {
            throw new IllegalArgumentException("No value for optional field: LegSettlDate");
        }

        return legSettlDateLength;
    }

    /* LegSettlDate = 588 */
    public String legSettlDateAsString()
    {
        return hasLegSettlDate ? new String(legSettlDate, 0, legSettlDateLength) : null;
    }

    /* LegSettlDate = 588 */
    public AsciiSequenceView legSettlDate(final AsciiSequenceView view)
    {
        if (!hasLegSettlDate)
        {
            throw new IllegalArgumentException("No value for optional field: LegSettlDate");
        }

        return view.wrap(buffer, legSettlDateOffset, legSettlDateLength);
    }


    private DecimalFloat legLastPx = DecimalFloat.newNaNValue();

    private boolean hasLegLastPx;

    /* LegLastPx = 637 */
    public DecimalFloat legLastPx()
    {
        if (!hasLegLastPx)
        {
            throw new IllegalArgumentException("No value for optional field: LegLastPx");
        }

        return legLastPx;
    }

    public boolean hasLegLastPx()
    {
        return hasLegLastPx;
    }



    public int decode(final AsciiBuffer buffer, final int offset, final int length)
    {
        // Decode LegsGroup
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
                    next = new LegsGroupDecoder(trailer, messageFields);
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
            case Constants.LEG_SYMBOL:
                legSymbol = buffer.getChars(legSymbol, valueOffset, valueLength);
                legSymbolOffset = valueOffset;
                legSymbolLength = valueLength;
                break;

            case Constants.LEG_SYMBOL_SFX:
                hasLegSymbolSfx = true;
                legSymbolSfx = buffer.getChars(legSymbolSfx, valueOffset, valueLength);
                legSymbolSfxOffset = valueOffset;
                legSymbolSfxLength = valueLength;
                break;

            case Constants.LEG_SECURITY_ID:
                hasLegSecurityID = true;
                legSecurityID = buffer.getChars(legSecurityID, valueOffset, valueLength);
                legSecurityIDOffset = valueOffset;
                legSecurityIDLength = valueLength;
                break;

            case Constants.LEG_SECURITY_ID_SOURCE:
                hasLegSecurityIDSource = true;
                legSecurityIDSource = buffer.getChars(legSecurityIDSource, valueOffset, valueLength);
                legSecurityIDSourceOffset = valueOffset;
                legSecurityIDSourceLength = valueLength;
                break;

            case Constants.NO_LEG_SECURITY_ALT_ID_GROUP_COUNTER:
                hasNoLegSecurityAltIDGroupCounter = true;
                noLegSecurityAltIDGroupCounter = getInt(buffer, valueOffset, endOfField, 604, CODEC_VALIDATION_ENABLED);
                if (legSecurityAltIDGroup == null)
                {
                    legSecurityAltIDGroup = new LegSecurityAltIDGroupDecoder(trailer, messageFields);
                }
                LegSecurityAltIDGroupDecoder legSecurityAltIDGroupCurrent = legSecurityAltIDGroup;
                position = endOfField + 1;
                final int noLegSecurityAltIDGroupCounter = this.noLegSecurityAltIDGroupCounter;
                for (int i = 0; i < noLegSecurityAltIDGroupCounter && position < end; i++)
                {
                    if (legSecurityAltIDGroupCurrent != null)
                    {
                        position += legSecurityAltIDGroupCurrent.decode(buffer, position, end - position);
                        legSecurityAltIDGroupCurrent = legSecurityAltIDGroupCurrent.next();
                    }
                }
                if (CODEC_VALIDATION_ENABLED)
                {
                    final int checkEqualsPosition = buffer.scan(position, end, '=');
                    if (checkEqualsPosition != AsciiBuffer.UNKNOWN_INDEX)
                    {
                        final int checkTag = buffer.getInt(position, checkEqualsPosition);
                        if (legSecurityAltIDGroup.ALL_GROUP_FIELDS.contains(checkTag))
                        {
                            invalidTagId = tag;
                            rejectReason = 16;
                            return position;
                        }
                    }
                }
                break;

            case Constants.LEG_PRODUCT:
                hasLegProduct = true;
                legProduct = getInt(buffer, valueOffset, endOfField, 607, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.LEG_C_F_I_CODE:
                hasLegCFICode = true;
                legCFICode = buffer.getChars(legCFICode, valueOffset, valueLength);
                legCFICodeOffset = valueOffset;
                legCFICodeLength = valueLength;
                break;

            case Constants.LEG_SECURITY_TYPE:
                hasLegSecurityType = true;
                legSecurityType = buffer.getChars(legSecurityType, valueOffset, valueLength);
                legSecurityTypeOffset = valueOffset;
                legSecurityTypeLength = valueLength;
                break;

            case Constants.LEG_SECURITY_SUB_TYPE:
                hasLegSecuritySubType = true;
                legSecuritySubType = buffer.getChars(legSecuritySubType, valueOffset, valueLength);
                legSecuritySubTypeOffset = valueOffset;
                legSecuritySubTypeLength = valueLength;
                break;

            case Constants.LEG_MATURITY_MONTH_YEAR:
                hasLegMaturityMonthYear = true;
                legMaturityMonthYear = buffer.getBytes(legMaturityMonthYear, valueOffset, valueLength);
                legMaturityMonthYearOffset = valueOffset;
                legMaturityMonthYearLength = valueLength;
                break;

            case Constants.LEG_MATURITY_DATE:
                hasLegMaturityDate = true;
                legMaturityDate = buffer.getBytes(legMaturityDate, valueOffset, valueLength);
                legMaturityDateOffset = valueOffset;
                legMaturityDateLength = valueLength;
                break;

            case Constants.LEG_COUPON_PAYMENT_DATE:
                hasLegCouponPaymentDate = true;
                legCouponPaymentDate = buffer.getBytes(legCouponPaymentDate, valueOffset, valueLength);
                legCouponPaymentDateOffset = valueOffset;
                legCouponPaymentDateLength = valueLength;
                break;

            case Constants.LEG_ISSUE_DATE:
                hasLegIssueDate = true;
                legIssueDate = buffer.getBytes(legIssueDate, valueOffset, valueLength);
                legIssueDateOffset = valueOffset;
                legIssueDateLength = valueLength;
                break;

            case Constants.LEG_REPO_COLLATERAL_SECURITY_TYPE:
                hasLegRepoCollateralSecurityType = true;
                legRepoCollateralSecurityType = getInt(buffer, valueOffset, endOfField, 250, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.LEG_REPURCHASE_TERM:
                hasLegRepurchaseTerm = true;
                legRepurchaseTerm = getInt(buffer, valueOffset, endOfField, 251, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.LEG_REPURCHASE_RATE:
                hasLegRepurchaseRate = true;
                legRepurchaseRate = getFloat(buffer, legRepurchaseRate, valueOffset, valueLength, 252, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.LEG_FACTOR:
                hasLegFactor = true;
                legFactor = getFloat(buffer, legFactor, valueOffset, valueLength, 253, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.LEG_CREDIT_RATING:
                hasLegCreditRating = true;
                legCreditRating = buffer.getChars(legCreditRating, valueOffset, valueLength);
                legCreditRatingOffset = valueOffset;
                legCreditRatingLength = valueLength;
                break;

            case Constants.LEG_INSTR_REGISTRY:
                hasLegInstrRegistry = true;
                legInstrRegistry = buffer.getChars(legInstrRegistry, valueOffset, valueLength);
                legInstrRegistryOffset = valueOffset;
                legInstrRegistryLength = valueLength;
                break;

            case Constants.LEG_COUNTRY_OF_ISSUE:
                hasLegCountryOfIssue = true;
                legCountryOfIssue = buffer.getChars(legCountryOfIssue, valueOffset, valueLength);
                legCountryOfIssueOffset = valueOffset;
                legCountryOfIssueLength = valueLength;
                break;

            case Constants.LEG_STATE_OR_PROVINCE_OF_ISSUE:
                hasLegStateOrProvinceOfIssue = true;
                legStateOrProvinceOfIssue = buffer.getChars(legStateOrProvinceOfIssue, valueOffset, valueLength);
                legStateOrProvinceOfIssueOffset = valueOffset;
                legStateOrProvinceOfIssueLength = valueLength;
                break;

            case Constants.LEG_LOCALE_OF_ISSUE:
                hasLegLocaleOfIssue = true;
                legLocaleOfIssue = buffer.getChars(legLocaleOfIssue, valueOffset, valueLength);
                legLocaleOfIssueOffset = valueOffset;
                legLocaleOfIssueLength = valueLength;
                break;

            case Constants.LEG_REDEMPTION_DATE:
                hasLegRedemptionDate = true;
                legRedemptionDate = buffer.getBytes(legRedemptionDate, valueOffset, valueLength);
                legRedemptionDateOffset = valueOffset;
                legRedemptionDateLength = valueLength;
                break;

            case Constants.LEG_STRIKE_PRICE:
                hasLegStrikePrice = true;
                legStrikePrice = getFloat(buffer, legStrikePrice, valueOffset, valueLength, 612, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.LEG_STRIKE_CURRENCY:
                hasLegStrikeCurrency = true;
                legStrikeCurrency = buffer.getChars(legStrikeCurrency, valueOffset, valueLength);
                legStrikeCurrencyOffset = valueOffset;
                legStrikeCurrencyLength = valueLength;
                break;

            case Constants.LEG_OPT_ATTRIBUTE:
                hasLegOptAttribute = true;
                legOptAttribute = buffer.getChar(valueOffset);
                break;

            case Constants.LEG_CONTRACT_MULTIPLIER:
                hasLegContractMultiplier = true;
                legContractMultiplier = getFloat(buffer, legContractMultiplier, valueOffset, valueLength, 614, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.LEG_COUPON_RATE:
                hasLegCouponRate = true;
                legCouponRate = getFloat(buffer, legCouponRate, valueOffset, valueLength, 615, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.LEG_SECURITY_EXCHANGE:
                hasLegSecurityExchange = true;
                legSecurityExchange = buffer.getChars(legSecurityExchange, valueOffset, valueLength);
                legSecurityExchangeOffset = valueOffset;
                legSecurityExchangeLength = valueLength;
                break;

            case Constants.LEG_ISSUER:
                hasLegIssuer = true;
                legIssuer = buffer.getChars(legIssuer, valueOffset, valueLength);
                legIssuerOffset = valueOffset;
                legIssuerLength = valueLength;
                break;

            case Constants.ENCODED_LEG_ISSUER_LEN:
                hasEncodedLegIssuerLen = true;
                encodedLegIssuerLen = getInt(buffer, valueOffset, endOfField, 618, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.ENCODED_LEG_ISSUER:
                hasEncodedLegIssuer = true;
                encodedLegIssuer = buffer.getBytes(encodedLegIssuer, valueOffset, encodedLegIssuerLen);
                endOfField = valueOffset + encodedLegIssuerLen;
                break;

            case Constants.LEG_SECURITY_DESC:
                hasLegSecurityDesc = true;
                legSecurityDesc = buffer.getChars(legSecurityDesc, valueOffset, valueLength);
                legSecurityDescOffset = valueOffset;
                legSecurityDescLength = valueLength;
                break;

            case Constants.ENCODED_LEG_SECURITY_DESC_LEN:
                hasEncodedLegSecurityDescLen = true;
                encodedLegSecurityDescLen = getInt(buffer, valueOffset, endOfField, 621, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.ENCODED_LEG_SECURITY_DESC:
                hasEncodedLegSecurityDesc = true;
                encodedLegSecurityDesc = buffer.getBytes(encodedLegSecurityDesc, valueOffset, encodedLegSecurityDescLen);
                endOfField = valueOffset + encodedLegSecurityDescLen;
                break;

            case Constants.LEG_RATIO_QTY:
                hasLegRatioQty = true;
                legRatioQty = getFloat(buffer, legRatioQty, valueOffset, valueLength, 623, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.LEG_SIDE:
                hasLegSide = true;
                legSide = buffer.getChar(valueOffset);
                break;

            case Constants.LEG_CURRENCY:
                hasLegCurrency = true;
                legCurrency = buffer.getChars(legCurrency, valueOffset, valueLength);
                legCurrencyOffset = valueOffset;
                legCurrencyLength = valueLength;
                break;

            case Constants.LEG_POOL:
                hasLegPool = true;
                legPool = buffer.getChars(legPool, valueOffset, valueLength);
                legPoolOffset = valueOffset;
                legPoolLength = valueLength;
                break;

            case Constants.LEG_DATED_DATE:
                hasLegDatedDate = true;
                legDatedDate = buffer.getBytes(legDatedDate, valueOffset, valueLength);
                legDatedDateOffset = valueOffset;
                legDatedDateLength = valueLength;
                break;

            case Constants.LEG_CONTRACT_SETTL_MONTH:
                hasLegContractSettlMonth = true;
                legContractSettlMonth = buffer.getBytes(legContractSettlMonth, valueOffset, valueLength);
                legContractSettlMonthOffset = valueOffset;
                legContractSettlMonthLength = valueLength;
                break;

            case Constants.LEG_INTEREST_ACCRUAL_DATE:
                hasLegInterestAccrualDate = true;
                legInterestAccrualDate = buffer.getBytes(legInterestAccrualDate, valueOffset, valueLength);
                legInterestAccrualDateOffset = valueOffset;
                legInterestAccrualDateLength = valueLength;
                break;


            case Constants.LEG_QTY:
                hasLegQty = true;
                legQty = getFloat(buffer, legQty, valueOffset, valueLength, 687, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.LEG_SWAP_TYPE:
                hasLegSwapType = true;
                legSwapType = getInt(buffer, valueOffset, endOfField, 690, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.NO_LEG_STIPULATIONS_GROUP_COUNTER:
                hasNoLegStipulationsGroupCounter = true;
                noLegStipulationsGroupCounter = getInt(buffer, valueOffset, endOfField, 683, CODEC_VALIDATION_ENABLED);
                if (legStipulationsGroup == null)
                {
                    legStipulationsGroup = new LegStipulationsGroupDecoder(trailer, messageFields);
                }
                LegStipulationsGroupDecoder legStipulationsGroupCurrent = legStipulationsGroup;
                position = endOfField + 1;
                final int noLegStipulationsGroupCounter = this.noLegStipulationsGroupCounter;
                for (int i = 0; i < noLegStipulationsGroupCounter && position < end; i++)
                {
                    if (legStipulationsGroupCurrent != null)
                    {
                        position += legStipulationsGroupCurrent.decode(buffer, position, end - position);
                        legStipulationsGroupCurrent = legStipulationsGroupCurrent.next();
                    }
                }
                if (CODEC_VALIDATION_ENABLED)
                {
                    final int checkEqualsPosition = buffer.scan(position, end, '=');
                    if (checkEqualsPosition != AsciiBuffer.UNKNOWN_INDEX)
                    {
                        final int checkTag = buffer.getInt(position, checkEqualsPosition);
                        if (legStipulationsGroup.ALL_GROUP_FIELDS.contains(checkTag))
                        {
                            invalidTagId = tag;
                            rejectReason = 16;
                            return position;
                        }
                    }
                }
                break;


            case Constants.LEG_POSITION_EFFECT:
                hasLegPositionEffect = true;
                legPositionEffect = buffer.getChar(valueOffset);
                break;

            case Constants.LEG_COVERED_OR_UNCOVERED:
                hasLegCoveredOrUncovered = true;
                legCoveredOrUncovered = getInt(buffer, valueOffset, endOfField, 565, CODEC_VALIDATION_ENABLED);
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


            case Constants.LEG_REF_ID:
                hasLegRefID = true;
                legRefID = buffer.getChars(legRefID, valueOffset, valueLength);
                legRefIDOffset = valueOffset;
                legRefIDLength = valueLength;
                break;

            case Constants.LEG_PRICE:
                hasLegPrice = true;
                legPrice = getFloat(buffer, legPrice, valueOffset, valueLength, 566, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.LEG_SETTL_TYPE:
                hasLegSettlType = true;
                legSettlType = buffer.getChar(valueOffset);
                break;

            case Constants.LEG_SETTL_DATE:
                hasLegSettlDate = true;
                legSettlDate = buffer.getBytes(legSettlDate, valueOffset, valueLength);
                legSettlDateOffset = valueOffset;
                legSettlDateLength = valueLength;
                break;

            case Constants.LEG_LAST_PX:
                hasLegLastPx = true;
                legLastPx = getFloat(buffer, legLastPx, valueOffset, valueLength, 637, CODEC_VALIDATION_ENABLED);
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
        this.resetLegQty();
        this.resetLegSwapType();
        this.resetLegPositionEffect();
        this.resetLegCoveredOrUncovered();
        this.resetLegRefID();
        this.resetLegPrice();
        this.resetLegSettlType();
        this.resetLegSettlDate();
        this.resetLegLastPx();
        this.resetLegSymbol();
        this.resetLegSymbolSfx();
        this.resetLegSecurityID();
        this.resetLegSecurityIDSource();
        this.resetLegProduct();
        this.resetLegCFICode();
        this.resetLegSecurityType();
        this.resetLegSecuritySubType();
        this.resetLegMaturityMonthYear();
        this.resetLegMaturityDate();
        this.resetLegCouponPaymentDate();
        this.resetLegIssueDate();
        this.resetLegRepoCollateralSecurityType();
        this.resetLegRepurchaseTerm();
        this.resetLegRepurchaseRate();
        this.resetLegFactor();
        this.resetLegCreditRating();
        this.resetLegInstrRegistry();
        this.resetLegCountryOfIssue();
        this.resetLegStateOrProvinceOfIssue();
        this.resetLegLocaleOfIssue();
        this.resetLegRedemptionDate();
        this.resetLegStrikePrice();
        this.resetLegStrikeCurrency();
        this.resetLegOptAttribute();
        this.resetLegContractMultiplier();
        this.resetLegCouponRate();
        this.resetLegSecurityExchange();
        this.resetLegIssuer();
        this.resetEncodedLegIssuerLen();
        this.resetEncodedLegIssuer();
        this.resetLegSecurityDesc();
        this.resetEncodedLegSecurityDescLen();
        this.resetEncodedLegSecurityDesc();
        this.resetLegRatioQty();
        this.resetLegSide();
        this.resetLegCurrency();
        this.resetLegPool();
        this.resetLegDatedDate();
        this.resetLegContractSettlMonth();
        this.resetLegInterestAccrualDate();
        this.resetLegSecurityAltIDGroup();
        this.resetLegStipulationsGroup();
        this.resetNestedPartyIDsGroup();
        buffer = null;
        if (CODEC_VALIDATION_ENABLED)
        {
            invalidTagId = Decoder.NO_ERROR;
            rejectReason = Decoder.NO_ERROR;
            missingRequiredFields.clear();
        }
    }

    public void resetLegQty()
    {
        hasLegQty = false;
    }

    public void resetLegSwapType()
    {
        hasLegSwapType = false;
    }

    public void resetLegPositionEffect()
    {
        hasLegPositionEffect = false;
    }

    public void resetLegCoveredOrUncovered()
    {
        hasLegCoveredOrUncovered = false;
    }

    public void resetLegRefID()
    {
        hasLegRefID = false;
    }

    public void resetLegPrice()
    {
        hasLegPrice = false;
    }

    public void resetLegSettlType()
    {
        hasLegSettlType = false;
    }

    public void resetLegSettlDate()
    {
        hasLegSettlDate = false;
    }

    public void resetLegLastPx()
    {
        hasLegLastPx = false;
    }

    public void resetLegSymbol()
    {
        legSymbolOffset = 0;
        legSymbolLength = 0;
    }

    public void resetLegSymbolSfx()
    {
        hasLegSymbolSfx = false;
    }

    public void resetLegSecurityID()
    {
        hasLegSecurityID = false;
    }

    public void resetLegSecurityIDSource()
    {
        hasLegSecurityIDSource = false;
    }

    public void resetLegProduct()
    {
        hasLegProduct = false;
    }

    public void resetLegCFICode()
    {
        hasLegCFICode = false;
    }

    public void resetLegSecurityType()
    {
        hasLegSecurityType = false;
    }

    public void resetLegSecuritySubType()
    {
        hasLegSecuritySubType = false;
    }

    public void resetLegMaturityMonthYear()
    {
        hasLegMaturityMonthYear = false;
    }

    public void resetLegMaturityDate()
    {
        hasLegMaturityDate = false;
    }

    public void resetLegCouponPaymentDate()
    {
        hasLegCouponPaymentDate = false;
    }

    public void resetLegIssueDate()
    {
        hasLegIssueDate = false;
    }

    public void resetLegRepoCollateralSecurityType()
    {
        hasLegRepoCollateralSecurityType = false;
    }

    public void resetLegRepurchaseTerm()
    {
        hasLegRepurchaseTerm = false;
    }

    public void resetLegRepurchaseRate()
    {
        hasLegRepurchaseRate = false;
    }

    public void resetLegFactor()
    {
        hasLegFactor = false;
    }

    public void resetLegCreditRating()
    {
        hasLegCreditRating = false;
    }

    public void resetLegInstrRegistry()
    {
        hasLegInstrRegistry = false;
    }

    public void resetLegCountryOfIssue()
    {
        hasLegCountryOfIssue = false;
    }

    public void resetLegStateOrProvinceOfIssue()
    {
        hasLegStateOrProvinceOfIssue = false;
    }

    public void resetLegLocaleOfIssue()
    {
        hasLegLocaleOfIssue = false;
    }

    public void resetLegRedemptionDate()
    {
        hasLegRedemptionDate = false;
    }

    public void resetLegStrikePrice()
    {
        hasLegStrikePrice = false;
    }

    public void resetLegStrikeCurrency()
    {
        hasLegStrikeCurrency = false;
    }

    public void resetLegOptAttribute()
    {
        hasLegOptAttribute = false;
    }

    public void resetLegContractMultiplier()
    {
        hasLegContractMultiplier = false;
    }

    public void resetLegCouponRate()
    {
        hasLegCouponRate = false;
    }

    public void resetLegSecurityExchange()
    {
        hasLegSecurityExchange = false;
    }

    public void resetLegIssuer()
    {
        hasLegIssuer = false;
    }

    public void resetEncodedLegIssuerLen()
    {
        hasEncodedLegIssuerLen = false;
    }

    public void resetEncodedLegIssuer()
    {
        hasEncodedLegIssuer = false;
    }

    public void resetLegSecurityDesc()
    {
        hasLegSecurityDesc = false;
    }

    public void resetEncodedLegSecurityDescLen()
    {
        hasEncodedLegSecurityDescLen = false;
    }

    public void resetEncodedLegSecurityDesc()
    {
        hasEncodedLegSecurityDesc = false;
    }

    public void resetLegRatioQty()
    {
        hasLegRatioQty = false;
    }

    public void resetLegSide()
    {
        hasLegSide = false;
    }

    public void resetLegCurrency()
    {
        hasLegCurrency = false;
    }

    public void resetLegPool()
    {
        hasLegPool = false;
    }

    public void resetLegDatedDate()
    {
        hasLegDatedDate = false;
    }

    public void resetLegContractSettlMonth()
    {
        hasLegContractSettlMonth = false;
    }

    public void resetLegInterestAccrualDate()
    {
        hasLegInterestAccrualDate = false;
    }

    public void resetLegSecurityAltIDGroup()
    {
        for (final LegSecurityAltIDGroupDecoder legSecurityAltIDGroupDecoder : legSecurityAltIDGroupIterator.iterator())
        {
            legSecurityAltIDGroupDecoder.reset();
            if (legSecurityAltIDGroupDecoder.next() == null)
            {
                break;
            }
        }
        noLegSecurityAltIDGroupCounter = MISSING_INT;
        hasNoLegSecurityAltIDGroupCounter = false;
    }

    public void resetLegStipulationsGroup()
    {
        for (final LegStipulationsGroupDecoder legStipulationsGroupDecoder : legStipulationsGroupIterator.iterator())
        {
            legStipulationsGroupDecoder.reset();
            if (legStipulationsGroupDecoder.next() == null)
            {
                break;
            }
        }
        noLegStipulationsGroupCounter = MISSING_INT;
        hasNoLegStipulationsGroupCounter = false;
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
        builder.append("\"MessageName\": \"LegsGroup\",\n");
        indent(builder, level);
        builder.append("\"LegSymbol\": \"");
        builder.append(this.legSymbol(), 0, legSymbolLength());
        builder.append("\",\n");

        if (hasLegSymbolSfx())
        {
            indent(builder, level);
            builder.append("\"LegSymbolSfx\": \"");
            builder.append(this.legSymbolSfx(), 0, legSymbolSfxLength());
            builder.append("\",\n");
        }

        if (hasLegSecurityID())
        {
            indent(builder, level);
            builder.append("\"LegSecurityID\": \"");
            builder.append(this.legSecurityID(), 0, legSecurityIDLength());
            builder.append("\",\n");
        }

        if (hasLegSecurityIDSource())
        {
            indent(builder, level);
            builder.append("\"LegSecurityIDSource\": \"");
            builder.append(this.legSecurityIDSource(), 0, legSecurityIDSourceLength());
            builder.append("\",\n");
        }

        if (hasNoLegSecurityAltIDGroupCounter)
        {
            indent(builder, level);
            builder.append("\"LegSecurityAltIDGroup\": [\n");
            LegSecurityAltIDGroupDecoder legSecurityAltIDGroup = this.legSecurityAltIDGroup;
            for (int i = 0, size = this.noLegSecurityAltIDGroupCounter; i < size; i++)
            {
                indent(builder, level);
                legSecurityAltIDGroup.appendTo(builder, level + 1);
                if (legSecurityAltIDGroup.next() != null)
                {
                    builder.append(',');
                }
                builder.append('\n');
                legSecurityAltIDGroup = legSecurityAltIDGroup.next();            }
            indent(builder, level);
            builder.append("],\n");
        }

        if (hasLegProduct())
        {
            indent(builder, level);
            builder.append("\"LegProduct\": \"");
            builder.append(legProduct);
            builder.append("\",\n");
        }

        if (hasLegCFICode())
        {
            indent(builder, level);
            builder.append("\"LegCFICode\": \"");
            builder.append(this.legCFICode(), 0, legCFICodeLength());
            builder.append("\",\n");
        }

        if (hasLegSecurityType())
        {
            indent(builder, level);
            builder.append("\"LegSecurityType\": \"");
            builder.append(this.legSecurityType(), 0, legSecurityTypeLength());
            builder.append("\",\n");
        }

        if (hasLegSecuritySubType())
        {
            indent(builder, level);
            builder.append("\"LegSecuritySubType\": \"");
            builder.append(this.legSecuritySubType(), 0, legSecuritySubTypeLength());
            builder.append("\",\n");
        }

        if (hasLegMaturityMonthYear())
        {
            indent(builder, level);
            builder.append("\"LegMaturityMonthYear\": \"");
            appendData(builder, legMaturityMonthYear, legMaturityMonthYearLength);
            builder.append("\",\n");
        }

        if (hasLegMaturityDate())
        {
            indent(builder, level);
            builder.append("\"LegMaturityDate\": \"");
            appendData(builder, legMaturityDate, legMaturityDateLength);
            builder.append("\",\n");
        }

        if (hasLegCouponPaymentDate())
        {
            indent(builder, level);
            builder.append("\"LegCouponPaymentDate\": \"");
            appendData(builder, legCouponPaymentDate, legCouponPaymentDateLength);
            builder.append("\",\n");
        }

        if (hasLegIssueDate())
        {
            indent(builder, level);
            builder.append("\"LegIssueDate\": \"");
            appendData(builder, legIssueDate, legIssueDateLength);
            builder.append("\",\n");
        }

        if (hasLegRepoCollateralSecurityType())
        {
            indent(builder, level);
            builder.append("\"LegRepoCollateralSecurityType\": \"");
            builder.append(legRepoCollateralSecurityType);
            builder.append("\",\n");
        }

        if (hasLegRepurchaseTerm())
        {
            indent(builder, level);
            builder.append("\"LegRepurchaseTerm\": \"");
            builder.append(legRepurchaseTerm);
            builder.append("\",\n");
        }

        if (hasLegRepurchaseRate())
        {
            indent(builder, level);
            builder.append("\"LegRepurchaseRate\": \"");
            legRepurchaseRate.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasLegFactor())
        {
            indent(builder, level);
            builder.append("\"LegFactor\": \"");
            legFactor.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasLegCreditRating())
        {
            indent(builder, level);
            builder.append("\"LegCreditRating\": \"");
            builder.append(this.legCreditRating(), 0, legCreditRatingLength());
            builder.append("\",\n");
        }

        if (hasLegInstrRegistry())
        {
            indent(builder, level);
            builder.append("\"LegInstrRegistry\": \"");
            builder.append(this.legInstrRegistry(), 0, legInstrRegistryLength());
            builder.append("\",\n");
        }

        if (hasLegCountryOfIssue())
        {
            indent(builder, level);
            builder.append("\"LegCountryOfIssue\": \"");
            builder.append(this.legCountryOfIssue(), 0, legCountryOfIssueLength());
            builder.append("\",\n");
        }

        if (hasLegStateOrProvinceOfIssue())
        {
            indent(builder, level);
            builder.append("\"LegStateOrProvinceOfIssue\": \"");
            builder.append(this.legStateOrProvinceOfIssue(), 0, legStateOrProvinceOfIssueLength());
            builder.append("\",\n");
        }

        if (hasLegLocaleOfIssue())
        {
            indent(builder, level);
            builder.append("\"LegLocaleOfIssue\": \"");
            builder.append(this.legLocaleOfIssue(), 0, legLocaleOfIssueLength());
            builder.append("\",\n");
        }

        if (hasLegRedemptionDate())
        {
            indent(builder, level);
            builder.append("\"LegRedemptionDate\": \"");
            appendData(builder, legRedemptionDate, legRedemptionDateLength);
            builder.append("\",\n");
        }

        if (hasLegStrikePrice())
        {
            indent(builder, level);
            builder.append("\"LegStrikePrice\": \"");
            legStrikePrice.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasLegStrikeCurrency())
        {
            indent(builder, level);
            builder.append("\"LegStrikeCurrency\": \"");
            builder.append(this.legStrikeCurrency(), 0, legStrikeCurrencyLength());
            builder.append("\",\n");
        }

        if (hasLegOptAttribute())
        {
            indent(builder, level);
            builder.append("\"LegOptAttribute\": \"");
            builder.append(legOptAttribute);
            builder.append("\",\n");
        }

        if (hasLegContractMultiplier())
        {
            indent(builder, level);
            builder.append("\"LegContractMultiplier\": \"");
            legContractMultiplier.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasLegCouponRate())
        {
            indent(builder, level);
            builder.append("\"LegCouponRate\": \"");
            legCouponRate.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasLegSecurityExchange())
        {
            indent(builder, level);
            builder.append("\"LegSecurityExchange\": \"");
            builder.append(this.legSecurityExchange(), 0, legSecurityExchangeLength());
            builder.append("\",\n");
        }

        if (hasLegIssuer())
        {
            indent(builder, level);
            builder.append("\"LegIssuer\": \"");
            builder.append(this.legIssuer(), 0, legIssuerLength());
            builder.append("\",\n");
        }

        if (hasEncodedLegIssuerLen())
        {
            indent(builder, level);
            builder.append("\"EncodedLegIssuerLen\": \"");
            builder.append(encodedLegIssuerLen);
            builder.append("\",\n");
        }

        if (hasEncodedLegIssuer())
        {
            indent(builder, level);
            builder.append("\"EncodedLegIssuer\": \"");
            appendData(builder, encodedLegIssuer, encodedLegIssuerLen);
            builder.append("\",\n");
        }

        if (hasLegSecurityDesc())
        {
            indent(builder, level);
            builder.append("\"LegSecurityDesc\": \"");
            builder.append(this.legSecurityDesc(), 0, legSecurityDescLength());
            builder.append("\",\n");
        }

        if (hasEncodedLegSecurityDescLen())
        {
            indent(builder, level);
            builder.append("\"EncodedLegSecurityDescLen\": \"");
            builder.append(encodedLegSecurityDescLen);
            builder.append("\",\n");
        }

        if (hasEncodedLegSecurityDesc())
        {
            indent(builder, level);
            builder.append("\"EncodedLegSecurityDesc\": \"");
            appendData(builder, encodedLegSecurityDesc, encodedLegSecurityDescLen);
            builder.append("\",\n");
        }

        if (hasLegRatioQty())
        {
            indent(builder, level);
            builder.append("\"LegRatioQty\": \"");
            legRatioQty.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasLegSide())
        {
            indent(builder, level);
            builder.append("\"LegSide\": \"");
            builder.append(legSide);
            builder.append("\",\n");
        }

        if (hasLegCurrency())
        {
            indent(builder, level);
            builder.append("\"LegCurrency\": \"");
            builder.append(this.legCurrency(), 0, legCurrencyLength());
            builder.append("\",\n");
        }

        if (hasLegPool())
        {
            indent(builder, level);
            builder.append("\"LegPool\": \"");
            builder.append(this.legPool(), 0, legPoolLength());
            builder.append("\",\n");
        }

        if (hasLegDatedDate())
        {
            indent(builder, level);
            builder.append("\"LegDatedDate\": \"");
            appendData(builder, legDatedDate, legDatedDateLength);
            builder.append("\",\n");
        }

        if (hasLegContractSettlMonth())
        {
            indent(builder, level);
            builder.append("\"LegContractSettlMonth\": \"");
            appendData(builder, legContractSettlMonth, legContractSettlMonthLength);
            builder.append("\",\n");
        }

        if (hasLegInterestAccrualDate())
        {
            indent(builder, level);
            builder.append("\"LegInterestAccrualDate\": \"");
            appendData(builder, legInterestAccrualDate, legInterestAccrualDateLength);
            builder.append("\",\n");
        }

        if (hasLegQty())
        {
            indent(builder, level);
            builder.append("\"LegQty\": \"");
            legQty.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasLegSwapType())
        {
            indent(builder, level);
            builder.append("\"LegSwapType\": \"");
            builder.append(legSwapType);
            builder.append("\",\n");
        }

        if (hasNoLegStipulationsGroupCounter)
        {
            indent(builder, level);
            builder.append("\"LegStipulationsGroup\": [\n");
            LegStipulationsGroupDecoder legStipulationsGroup = this.legStipulationsGroup;
            for (int i = 0, size = this.noLegStipulationsGroupCounter; i < size; i++)
            {
                indent(builder, level);
                legStipulationsGroup.appendTo(builder, level + 1);
                if (legStipulationsGroup.next() != null)
                {
                    builder.append(',');
                }
                builder.append('\n');
                legStipulationsGroup = legStipulationsGroup.next();            }
            indent(builder, level);
            builder.append("],\n");
        }

        if (hasLegPositionEffect())
        {
            indent(builder, level);
            builder.append("\"LegPositionEffect\": \"");
            builder.append(legPositionEffect);
            builder.append("\",\n");
        }

        if (hasLegCoveredOrUncovered())
        {
            indent(builder, level);
            builder.append("\"LegCoveredOrUncovered\": \"");
            builder.append(legCoveredOrUncovered);
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

        if (hasLegRefID())
        {
            indent(builder, level);
            builder.append("\"LegRefID\": \"");
            builder.append(this.legRefID(), 0, legRefIDLength());
            builder.append("\",\n");
        }

        if (hasLegPrice())
        {
            indent(builder, level);
            builder.append("\"LegPrice\": \"");
            legPrice.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasLegSettlType())
        {
            indent(builder, level);
            builder.append("\"LegSettlType\": \"");
            builder.append(legSettlType);
            builder.append("\",\n");
        }

        if (hasLegSettlDate())
        {
            indent(builder, level);
            builder.append("\"LegSettlDate\": \"");
            appendData(builder, legSettlDate, legSettlDateLength);
            builder.append("\",\n");
        }

        if (hasLegLastPx())
        {
            indent(builder, level);
            builder.append("\"LegLastPx\": \"");
            legLastPx.appendTo(builder);
            builder.append("\",\n");
        }
        indent(builder, level - 1);
        builder.append("}");
        return builder;
    }

    /**
     * {@inheritDoc}
     */
    public TradeCaptureReportEncoder.LegsGroupEncoder toEncoder(final Encoder encoder)
    {
        return toEncoder((TradeCaptureReportEncoder.LegsGroupEncoder)encoder);
    }

    public TradeCaptureReportEncoder.LegsGroupEncoder toEncoder(final TradeCaptureReportEncoder.LegsGroupEncoder encoder)
    {
        encoder.reset();

        final InstrumentLegEncoder instrumentLeg = encoder.instrumentLeg();        instrumentLeg.legSymbol(this.legSymbol(), 0, legSymbolLength());
        if (hasLegSymbolSfx())
        {
            instrumentLeg.legSymbolSfx(this.legSymbolSfx(), 0, legSymbolSfxLength());
        }

        if (hasLegSecurityID())
        {
            instrumentLeg.legSecurityID(this.legSecurityID(), 0, legSecurityIDLength());
        }

        if (hasLegSecurityIDSource())
        {
            instrumentLeg.legSecurityIDSource(this.legSecurityIDSource(), 0, legSecurityIDSourceLength());
        }

        if (hasNoLegSecurityAltIDGroupCounter)
        {
            final int size = this.noLegSecurityAltIDGroupCounter;
            LegSecurityAltIDGroupDecoder legSecurityAltIDGroup = this.legSecurityAltIDGroup;
            LegSecurityAltIDGroupEncoder legSecurityAltIDGroupEncoder = instrumentLeg.legSecurityAltIDGroup(size);
            for (int i = 0; i < size; i++)
            {
                if (legSecurityAltIDGroup != null)
                {
                    legSecurityAltIDGroup.toEncoder(legSecurityAltIDGroupEncoder);
                    legSecurityAltIDGroup = legSecurityAltIDGroup.next();
                    legSecurityAltIDGroupEncoder = legSecurityAltIDGroupEncoder.next();
                }
            }
        }

        if (hasLegProduct())
        {
            instrumentLeg.legProduct(this.legProduct());
        }

        if (hasLegCFICode())
        {
            instrumentLeg.legCFICode(this.legCFICode(), 0, legCFICodeLength());
        }

        if (hasLegSecurityType())
        {
            instrumentLeg.legSecurityType(this.legSecurityType(), 0, legSecurityTypeLength());
        }

        if (hasLegSecuritySubType())
        {
            instrumentLeg.legSecuritySubType(this.legSecuritySubType(), 0, legSecuritySubTypeLength());
        }

        if (hasLegMaturityMonthYear())
        {
            instrumentLeg.legMaturityMonthYearAsCopy(this.legMaturityMonthYear(), 0, legMaturityMonthYearLength());
        }

        if (hasLegMaturityDate())
        {
            instrumentLeg.legMaturityDateAsCopy(this.legMaturityDate(), 0, legMaturityDateLength());
        }

        if (hasLegCouponPaymentDate())
        {
            instrumentLeg.legCouponPaymentDateAsCopy(this.legCouponPaymentDate(), 0, legCouponPaymentDateLength());
        }

        if (hasLegIssueDate())
        {
            instrumentLeg.legIssueDateAsCopy(this.legIssueDate(), 0, legIssueDateLength());
        }

        if (hasLegRepoCollateralSecurityType())
        {
            instrumentLeg.legRepoCollateralSecurityType(this.legRepoCollateralSecurityType());
        }

        if (hasLegRepurchaseTerm())
        {
            instrumentLeg.legRepurchaseTerm(this.legRepurchaseTerm());
        }

        if (hasLegRepurchaseRate())
        {
            instrumentLeg.legRepurchaseRate(this.legRepurchaseRate());
        }

        if (hasLegFactor())
        {
            instrumentLeg.legFactor(this.legFactor());
        }

        if (hasLegCreditRating())
        {
            instrumentLeg.legCreditRating(this.legCreditRating(), 0, legCreditRatingLength());
        }

        if (hasLegInstrRegistry())
        {
            instrumentLeg.legInstrRegistry(this.legInstrRegistry(), 0, legInstrRegistryLength());
        }

        if (hasLegCountryOfIssue())
        {
            instrumentLeg.legCountryOfIssue(this.legCountryOfIssue(), 0, legCountryOfIssueLength());
        }

        if (hasLegStateOrProvinceOfIssue())
        {
            instrumentLeg.legStateOrProvinceOfIssue(this.legStateOrProvinceOfIssue(), 0, legStateOrProvinceOfIssueLength());
        }

        if (hasLegLocaleOfIssue())
        {
            instrumentLeg.legLocaleOfIssue(this.legLocaleOfIssue(), 0, legLocaleOfIssueLength());
        }

        if (hasLegRedemptionDate())
        {
            instrumentLeg.legRedemptionDateAsCopy(this.legRedemptionDate(), 0, legRedemptionDateLength());
        }

        if (hasLegStrikePrice())
        {
            instrumentLeg.legStrikePrice(this.legStrikePrice());
        }

        if (hasLegStrikeCurrency())
        {
            instrumentLeg.legStrikeCurrency(this.legStrikeCurrency(), 0, legStrikeCurrencyLength());
        }

        if (hasLegOptAttribute())
        {
            instrumentLeg.legOptAttribute(this.legOptAttribute());
        }

        if (hasLegContractMultiplier())
        {
            instrumentLeg.legContractMultiplier(this.legContractMultiplier());
        }

        if (hasLegCouponRate())
        {
            instrumentLeg.legCouponRate(this.legCouponRate());
        }

        if (hasLegSecurityExchange())
        {
            instrumentLeg.legSecurityExchange(this.legSecurityExchange(), 0, legSecurityExchangeLength());
        }

        if (hasLegIssuer())
        {
            instrumentLeg.legIssuer(this.legIssuer(), 0, legIssuerLength());
        }

        if (hasEncodedLegIssuerLen())
        {
            instrumentLeg.encodedLegIssuerLen(this.encodedLegIssuerLen());
        }

        if (hasEncodedLegIssuer())
        {
            instrumentLeg.encodedLegIssuerAsCopy(this.encodedLegIssuer(), 0, encodedLegIssuerLen());
            instrumentLeg.encodedLegIssuerLen(this.encodedLegIssuerLen());
        }

        if (hasLegSecurityDesc())
        {
            instrumentLeg.legSecurityDesc(this.legSecurityDesc(), 0, legSecurityDescLength());
        }

        if (hasEncodedLegSecurityDescLen())
        {
            instrumentLeg.encodedLegSecurityDescLen(this.encodedLegSecurityDescLen());
        }

        if (hasEncodedLegSecurityDesc())
        {
            instrumentLeg.encodedLegSecurityDescAsCopy(this.encodedLegSecurityDesc(), 0, encodedLegSecurityDescLen());
            instrumentLeg.encodedLegSecurityDescLen(this.encodedLegSecurityDescLen());
        }

        if (hasLegRatioQty())
        {
            instrumentLeg.legRatioQty(this.legRatioQty());
        }

        if (hasLegSide())
        {
            instrumentLeg.legSide(this.legSide());
        }

        if (hasLegCurrency())
        {
            instrumentLeg.legCurrency(this.legCurrency(), 0, legCurrencyLength());
        }

        if (hasLegPool())
        {
            instrumentLeg.legPool(this.legPool(), 0, legPoolLength());
        }

        if (hasLegDatedDate())
        {
            instrumentLeg.legDatedDateAsCopy(this.legDatedDate(), 0, legDatedDateLength());
        }

        if (hasLegContractSettlMonth())
        {
            instrumentLeg.legContractSettlMonthAsCopy(this.legContractSettlMonth(), 0, legContractSettlMonthLength());
        }

        if (hasLegInterestAccrualDate())
        {
            instrumentLeg.legInterestAccrualDateAsCopy(this.legInterestAccrualDate(), 0, legInterestAccrualDateLength());
        }


        if (hasLegQty())
        {
            encoder.legQty(this.legQty());
        }

        if (hasLegSwapType())
        {
            encoder.legSwapType(this.legSwapType());
        }


        final LegStipulationsEncoder legStipulations = encoder.legStipulations();        if (hasNoLegStipulationsGroupCounter)
        {
            final int size = this.noLegStipulationsGroupCounter;
            LegStipulationsGroupDecoder legStipulationsGroup = this.legStipulationsGroup;
            LegStipulationsGroupEncoder legStipulationsGroupEncoder = legStipulations.legStipulationsGroup(size);
            for (int i = 0; i < size; i++)
            {
                if (legStipulationsGroup != null)
                {
                    legStipulationsGroup.toEncoder(legStipulationsGroupEncoder);
                    legStipulationsGroup = legStipulationsGroup.next();
                    legStipulationsGroupEncoder = legStipulationsGroupEncoder.next();
                }
            }
        }


        if (hasLegPositionEffect())
        {
            encoder.legPositionEffect(this.legPositionEffect());
        }

        if (hasLegCoveredOrUncovered())
        {
            encoder.legCoveredOrUncovered(this.legCoveredOrUncovered());
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


        if (hasLegRefID())
        {
            encoder.legRefID(this.legRefID(), 0, legRefIDLength());
        }

        if (hasLegPrice())
        {
            encoder.legPrice(this.legPrice());
        }

        if (hasLegSettlType())
        {
            encoder.legSettlType(this.legSettlType());
        }

        if (hasLegSettlDate())
        {
            encoder.legSettlDateAsCopy(this.legSettlDate(), 0, legSettlDateLength());
        }

        if (hasLegLastPx())
        {
            encoder.legLastPx(this.legLastPx());
        }
        return encoder;
    }

}
    @Generated("uk.co.real_logic.artio")
    public class LegsGroupIterator implements Iterable<LegsGroupDecoder>, java.util.Iterator<LegsGroupDecoder>
    {
        private final TradeCaptureReportDecoder parent;
        private int remainder;
        private LegsGroupDecoder current;

        public LegsGroupIterator(final TradeCaptureReportDecoder parent)
        {
            this.parent = parent;
        }

        public boolean hasNext()
        {
            return remainder > 0 && current != null;
        }

        public LegsGroupDecoder next()
        {
            remainder--;
            final LegsGroupDecoder value = current;
            current = current.next();
            return value;
        }

        public int numberFieldValue()
        {
            return parent.hasNoLegsGroupCounter() ? parent.noLegsGroupCounter() : 0;
        }

        public void reset()
        {
            remainder = numberFieldValue();
            current = parent.legsGroup();
        }

        public LegsGroupIterator iterator()
        {
            reset();
            return this;
        }

    }


    private LegsGroupDecoder legsGroup = null;
    public LegsGroupDecoder legsGroup()
    {
        return legsGroup;
    }

    private int noLegsGroupCounter = MISSING_INT;

    private boolean hasNoLegsGroupCounter;

    /* NoLegsGroupCounter = 555 */
    public int noLegsGroupCounter()
    {
        if (!hasNoLegsGroupCounter)
        {
            throw new IllegalArgumentException("No value for optional field: NoLegsGroupCounter");
        }

        return noLegsGroupCounter;
    }

    public boolean hasNoLegsGroupCounter()
    {
        return hasNoLegsGroupCounter;
    }




    private LegsGroupIterator legsGroupIterator = new LegsGroupIterator(this);
    public LegsGroupIterator legsGroupIterator()
    {
        return legsGroupIterator.iterator();
    }

    private byte[] transactTime = new byte[24];

    /* TransactTime = 60 */
    public byte[] transactTime()
    {
        return transactTime;
    }


    private int transactTimeOffset;

    private int transactTimeLength;

    /* TransactTime = 60 */
    public int transactTimeLength()
    {
        return transactTimeLength;
    }

    /* TransactTime = 60 */
    public String transactTimeAsString()
    {
        return new String(transactTime, 0, transactTimeLength);
    }

    /* TransactTime = 60 */
    public AsciiSequenceView transactTime(final AsciiSequenceView view)
    {
        return view.wrap(buffer, transactTimeOffset, transactTimeLength);
    }




    private TrdRegTimestampsGroupDecoder trdRegTimestampsGroup = null;
    public TrdRegTimestampsGroupDecoder trdRegTimestampsGroup()
    {
        return trdRegTimestampsGroup;
    }

    private int noTrdRegTimestampsGroupCounter = MISSING_INT;

    private boolean hasNoTrdRegTimestampsGroupCounter;

    /* NoTrdRegTimestampsGroupCounter = 768 */
    public int noTrdRegTimestampsGroupCounter()
    {
        if (!hasNoTrdRegTimestampsGroupCounter)
        {
            throw new IllegalArgumentException("No value for optional field: NoTrdRegTimestampsGroupCounter");
        }

        return noTrdRegTimestampsGroupCounter;
    }

    public boolean hasNoTrdRegTimestampsGroupCounter()
    {
        return hasNoTrdRegTimestampsGroupCounter;
    }




    private TrdRegTimestampsGroupIterator trdRegTimestampsGroupIterator = new TrdRegTimestampsGroupIterator(this);
    public TrdRegTimestampsGroupIterator trdRegTimestampsGroupIterator()
    {
        return trdRegTimestampsGroupIterator.iterator();
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


    private char matchStatus = MISSING_CHAR;

    private boolean hasMatchStatus;

    /* MatchStatus = 573 */
    public char matchStatus()
    {
        if (!hasMatchStatus)
        {
            throw new IllegalArgumentException("No value for optional field: MatchStatus");
        }

        return matchStatus;
    }

    public boolean hasMatchStatus()
    {
        return hasMatchStatus;
    }



    private final CharArrayWrapper matchStatusWrapper = new CharArrayWrapper();
    /* MatchStatus = 573 */
    public MatchStatus matchStatusAsEnum()
    {
        if (!hasMatchStatus)
 return MatchStatus.NULL_VAL;
        return MatchStatus.decode(matchStatus);
    }

    private char[] matchType = new char[1];

    private boolean hasMatchType;

    /* MatchType = 574 */
    public char[] matchType()
    {
        if (!hasMatchType)
        {
            throw new IllegalArgumentException("No value for optional field: MatchType");
        }

        return matchType;
    }

    public boolean hasMatchType()
    {
        return hasMatchType;
    }


    private int matchTypeOffset;

    private int matchTypeLength;

    /* MatchType = 574 */
    public int matchTypeLength()
    {
        if (!hasMatchType)
        {
            throw new IllegalArgumentException("No value for optional field: MatchType");
        }

        return matchTypeLength;
    }

    /* MatchType = 574 */
    public String matchTypeAsString()
    {
        return hasMatchType ? new String(matchType, 0, matchTypeLength) : null;
    }

    /* MatchType = 574 */
    public AsciiSequenceView matchType(final AsciiSequenceView view)
    {
        if (!hasMatchType)
        {
            throw new IllegalArgumentException("No value for optional field: MatchType");
        }

        return view.wrap(buffer, matchTypeOffset, matchTypeLength);
    }


    private final CharArrayWrapper matchTypeWrapper = new CharArrayWrapper();

@Generated("uk.co.real_logic.artio")
public class SidesGroupDecoder extends CommonDecoderImpl implements PartiesDecoder, CommissionDataDecoder, StipulationsDecoder
{
    public final IntHashSet REQUIRED_FIELDS = new IntHashSet(4);

    {
        if (CODEC_VALIDATION_ENABLED)
        {
            REQUIRED_FIELDS.add(Constants.SIDE);
            REQUIRED_FIELDS.add(Constants.ORDER_ID);
        }
    }

    public final IntHashSet GROUP_FIELDS = new IntHashSet(112);

    {
        if (CODEC_VALIDATION_ENABLED)
        {
            GROUP_FIELDS.add(Constants.SIDE);
            GROUP_FIELDS.add(Constants.ORDER_ID);
            GROUP_FIELDS.add(Constants.SECONDARY_ORDER_ID);
            GROUP_FIELDS.add(Constants.CL_ORD_ID);
            GROUP_FIELDS.add(Constants.SECONDARY_CL_ORD_ID);
            GROUP_FIELDS.add(Constants.LIST_ID);
            GROUP_FIELDS.add(Constants.ACCOUNT);
            GROUP_FIELDS.add(Constants.ACCT_ID_SOURCE);
            GROUP_FIELDS.add(Constants.ACCOUNT_TYPE);
            GROUP_FIELDS.add(Constants.PROCESS_CODE);
            GROUP_FIELDS.add(Constants.ODD_LOT);
            GROUP_FIELDS.add(Constants.CLEARING_FEE_INDICATOR);
            GROUP_FIELDS.add(Constants.TRADE_INPUT_SOURCE);
            GROUP_FIELDS.add(Constants.TRADE_INPUT_DEVICE);
            GROUP_FIELDS.add(Constants.ORDER_INPUT_DEVICE);
            GROUP_FIELDS.add(Constants.CURRENCY);
            GROUP_FIELDS.add(Constants.COMPLIANCE_ID);
            GROUP_FIELDS.add(Constants.SOLICITED_FLAG);
            GROUP_FIELDS.add(Constants.ORDER_CAPACITY);
            GROUP_FIELDS.add(Constants.ORDER_RESTRICTIONS);
            GROUP_FIELDS.add(Constants.CUST_ORDER_CAPACITY);
            GROUP_FIELDS.add(Constants.ORD_TYPE);
            GROUP_FIELDS.add(Constants.EXEC_INST);
            GROUP_FIELDS.add(Constants.TRANS_BKD_TIME);
            GROUP_FIELDS.add(Constants.TRADING_SESSION_ID);
            GROUP_FIELDS.add(Constants.TRADING_SESSION_SUB_ID);
            GROUP_FIELDS.add(Constants.TIME_BRACKET);
            GROUP_FIELDS.add(Constants.COMMISSION);
            GROUP_FIELDS.add(Constants.COMM_TYPE);
            GROUP_FIELDS.add(Constants.COMM_CURRENCY);
            GROUP_FIELDS.add(Constants.FUND_RENEW_WAIV);
            GROUP_FIELDS.add(Constants.GROSS_TRADE_AMT);
            GROUP_FIELDS.add(Constants.NUM_DAYS_INTEREST);
            GROUP_FIELDS.add(Constants.EX_DATE);
            GROUP_FIELDS.add(Constants.ACCRUED_INTEREST_RATE);
            GROUP_FIELDS.add(Constants.ACCRUED_INTEREST_AMT);
            GROUP_FIELDS.add(Constants.INTEREST_AT_MATURITY);
            GROUP_FIELDS.add(Constants.END_ACCRUED_INTEREST_AMT);
            GROUP_FIELDS.add(Constants.START_CASH);
            GROUP_FIELDS.add(Constants.END_CASH);
            GROUP_FIELDS.add(Constants.CONCESSION);
            GROUP_FIELDS.add(Constants.TOTAL_TAKEDOWN);
            GROUP_FIELDS.add(Constants.NET_MONEY);
            GROUP_FIELDS.add(Constants.SETTL_CURR_AMT);
            GROUP_FIELDS.add(Constants.SETTL_CURRENCY);
            GROUP_FIELDS.add(Constants.SETTL_CURR_FX_RATE);
            GROUP_FIELDS.add(Constants.SETTL_CURR_FX_RATE_CALC);
            GROUP_FIELDS.add(Constants.POSITION_EFFECT);
            GROUP_FIELDS.add(Constants.TEXT);
            GROUP_FIELDS.add(Constants.ENCODED_TEXT_LEN);
            GROUP_FIELDS.add(Constants.ENCODED_TEXT);
            GROUP_FIELDS.add(Constants.SIDE_MULTI_LEG_REPORTING_TYPE);
            GROUP_FIELDS.add(Constants.EXCHANGE_RULE);
            GROUP_FIELDS.add(Constants.TRADE_ALLOC_INDICATOR);
            GROUP_FIELDS.add(Constants.PREALLOC_METHOD);
            GROUP_FIELDS.add(Constants.ALLOC_ID);
        }
    }

    public final IntHashSet ALL_GROUP_FIELDS = new IntHashSet(104);

    {
        if (CODEC_VALIDATION_ENABLED)
        {
            ALL_GROUP_FIELDS.add(Constants.SIDE);
            ALL_GROUP_FIELDS.add(Constants.ORDER_ID);
            ALL_GROUP_FIELDS.add(Constants.SECONDARY_ORDER_ID);
            ALL_GROUP_FIELDS.add(Constants.CL_ORD_ID);
            ALL_GROUP_FIELDS.add(Constants.SECONDARY_CL_ORD_ID);
            ALL_GROUP_FIELDS.add(Constants.LIST_ID);
            ALL_GROUP_FIELDS.add(Constants.ACCOUNT);
            ALL_GROUP_FIELDS.add(Constants.ACCT_ID_SOURCE);
            ALL_GROUP_FIELDS.add(Constants.ACCOUNT_TYPE);
            ALL_GROUP_FIELDS.add(Constants.PROCESS_CODE);
            ALL_GROUP_FIELDS.add(Constants.ODD_LOT);
            ALL_GROUP_FIELDS.add(Constants.CLEARING_FEE_INDICATOR);
            ALL_GROUP_FIELDS.add(Constants.TRADE_INPUT_SOURCE);
            ALL_GROUP_FIELDS.add(Constants.TRADE_INPUT_DEVICE);
            ALL_GROUP_FIELDS.add(Constants.ORDER_INPUT_DEVICE);
            ALL_GROUP_FIELDS.add(Constants.CURRENCY);
            ALL_GROUP_FIELDS.add(Constants.COMPLIANCE_ID);
            ALL_GROUP_FIELDS.add(Constants.SOLICITED_FLAG);
            ALL_GROUP_FIELDS.add(Constants.ORDER_CAPACITY);
            ALL_GROUP_FIELDS.add(Constants.ORDER_RESTRICTIONS);
            ALL_GROUP_FIELDS.add(Constants.CUST_ORDER_CAPACITY);
            ALL_GROUP_FIELDS.add(Constants.ORD_TYPE);
            ALL_GROUP_FIELDS.add(Constants.EXEC_INST);
            ALL_GROUP_FIELDS.add(Constants.TRANS_BKD_TIME);
            ALL_GROUP_FIELDS.add(Constants.TRADING_SESSION_ID);
            ALL_GROUP_FIELDS.add(Constants.TRADING_SESSION_SUB_ID);
            ALL_GROUP_FIELDS.add(Constants.TIME_BRACKET);
            ALL_GROUP_FIELDS.add(Constants.GROSS_TRADE_AMT);
            ALL_GROUP_FIELDS.add(Constants.NUM_DAYS_INTEREST);
            ALL_GROUP_FIELDS.add(Constants.EX_DATE);
            ALL_GROUP_FIELDS.add(Constants.ACCRUED_INTEREST_RATE);
            ALL_GROUP_FIELDS.add(Constants.ACCRUED_INTEREST_AMT);
            ALL_GROUP_FIELDS.add(Constants.INTEREST_AT_MATURITY);
            ALL_GROUP_FIELDS.add(Constants.END_ACCRUED_INTEREST_AMT);
            ALL_GROUP_FIELDS.add(Constants.START_CASH);
            ALL_GROUP_FIELDS.add(Constants.END_CASH);
            ALL_GROUP_FIELDS.add(Constants.CONCESSION);
            ALL_GROUP_FIELDS.add(Constants.TOTAL_TAKEDOWN);
            ALL_GROUP_FIELDS.add(Constants.NET_MONEY);
            ALL_GROUP_FIELDS.add(Constants.SETTL_CURR_AMT);
            ALL_GROUP_FIELDS.add(Constants.SETTL_CURRENCY);
            ALL_GROUP_FIELDS.add(Constants.SETTL_CURR_FX_RATE);
            ALL_GROUP_FIELDS.add(Constants.SETTL_CURR_FX_RATE_CALC);
            ALL_GROUP_FIELDS.add(Constants.POSITION_EFFECT);
            ALL_GROUP_FIELDS.add(Constants.TEXT);
            ALL_GROUP_FIELDS.add(Constants.ENCODED_TEXT_LEN);
            ALL_GROUP_FIELDS.add(Constants.ENCODED_TEXT);
            ALL_GROUP_FIELDS.add(Constants.SIDE_MULTI_LEG_REPORTING_TYPE);
            ALL_GROUP_FIELDS.add(Constants.EXCHANGE_RULE);
            ALL_GROUP_FIELDS.add(Constants.TRADE_ALLOC_INDICATOR);
            ALL_GROUP_FIELDS.add(Constants.PREALLOC_METHOD);
            ALL_GROUP_FIELDS.add(Constants.ALLOC_ID);
        }
    }

    private final IntHashSet missingRequiredFields = new IntHashSet(4);

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
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !Side.isValid(side()))
        {
            invalidTagId = 54;
            rejectReason = 5;
            return false;
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

        if (hasProcessCode)
        {
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !ProcessCode.isValid(processCode()))
        {
            invalidTagId = 81;
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

        if (hasOrdType)
        {
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !OrdType.isValid(ordType()))
        {
            invalidTagId = 40;
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

        if (hasSettlCurrFxRateCalc)
        {
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !SettlCurrFxRateCalc.isValid(settlCurrFxRateCalc()))
        {
            invalidTagId = 156;
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

        if (hasSideMultiLegReportingType)
        {
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !SideMultiLegReportingType.isValid(sideMultiLegReportingType()))
        {
            invalidTagId = 752;
            rejectReason = 5;
            return false;
        }
        }

        if (hasTradeAllocIndicator)
        {
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !TradeAllocIndicator.isValid(tradeAllocIndicator()))
        {
            invalidTagId = 826;
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

        if (hasNoClearingInstructionsGroupCounter)
        {
            {
                int count = 0;
                final ClearingInstructionsGroupIterator iterator = clearingInstructionsGroupIterator.iterator();
                for (final ClearingInstructionsGroupDecoder group : iterator)
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
                    invalidTagId = 576;
                    rejectReason = 16;
                    return false;
                }
            }
        }

        if (hasNoContAmtsGroupCounter)
        {
            {
                int count = 0;
                final ContAmtsGroupIterator iterator = contAmtsGroupIterator.iterator();
                for (final ContAmtsGroupDecoder group : iterator)
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
                    invalidTagId = 518;
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

        if (hasNoMiscFeesGroupCounter)
        {
            {
                int count = 0;
                final MiscFeesGroupIterator iterator = miscFeesGroupIterator.iterator();
                for (final MiscFeesGroupDecoder group : iterator)
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
                    invalidTagId = 136;
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
        return true;
    }

    private final TrailerDecoder trailer;
    private final IntHashSet messageFields;
    public SidesGroupDecoder(final TrailerDecoder trailer, final IntHashSet messageFields)
    {
        this.trailer = trailer;
        this.messageFields = messageFields;
    }

    private SidesGroupDecoder next = null;

    public SidesGroupDecoder next()
    {
        return next;
    }

    private IntHashSet seenFields = new IntHashSet(118);

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

    private char[] orderID = new char[1];

    /* OrderID = 37 */
    public char[] orderID()
    {
        return orderID;
    }


    private int orderIDOffset;

    private int orderIDLength;

    /* OrderID = 37 */
    public int orderIDLength()
    {
        return orderIDLength;
    }

    /* OrderID = 37 */
    public String orderIDAsString()
    {
        return new String(orderID, 0, orderIDLength);
    }

    /* OrderID = 37 */
    public AsciiSequenceView orderID(final AsciiSequenceView view)
    {
        return view.wrap(buffer, orderIDOffset, orderIDLength);
    }


    private final CharArrayWrapper orderIDWrapper = new CharArrayWrapper();
    private char[] secondaryOrderID = new char[1];

    private boolean hasSecondaryOrderID;

    /* SecondaryOrderID = 198 */
    public char[] secondaryOrderID()
    {
        if (!hasSecondaryOrderID)
        {
            throw new IllegalArgumentException("No value for optional field: SecondaryOrderID");
        }

        return secondaryOrderID;
    }

    public boolean hasSecondaryOrderID()
    {
        return hasSecondaryOrderID;
    }


    private int secondaryOrderIDOffset;

    private int secondaryOrderIDLength;

    /* SecondaryOrderID = 198 */
    public int secondaryOrderIDLength()
    {
        if (!hasSecondaryOrderID)
        {
            throw new IllegalArgumentException("No value for optional field: SecondaryOrderID");
        }

        return secondaryOrderIDLength;
    }

    /* SecondaryOrderID = 198 */
    public String secondaryOrderIDAsString()
    {
        return hasSecondaryOrderID ? new String(secondaryOrderID, 0, secondaryOrderIDLength) : null;
    }

    /* SecondaryOrderID = 198 */
    public AsciiSequenceView secondaryOrderID(final AsciiSequenceView view)
    {
        if (!hasSecondaryOrderID)
        {
            throw new IllegalArgumentException("No value for optional field: SecondaryOrderID");
        }

        return view.wrap(buffer, secondaryOrderIDOffset, secondaryOrderIDLength);
    }


    private final CharArrayWrapper secondaryOrderIDWrapper = new CharArrayWrapper();
    private char[] clOrdID = new char[1];

    private boolean hasClOrdID;

    /* ClOrdID = 11 */
    public char[] clOrdID()
    {
        if (!hasClOrdID)
        {
            throw new IllegalArgumentException("No value for optional field: ClOrdID");
        }

        return clOrdID;
    }

    public boolean hasClOrdID()
    {
        return hasClOrdID;
    }


    private int clOrdIDOffset;

    private int clOrdIDLength;

    /* ClOrdID = 11 */
    public int clOrdIDLength()
    {
        if (!hasClOrdID)
        {
            throw new IllegalArgumentException("No value for optional field: ClOrdID");
        }

        return clOrdIDLength;
    }

    /* ClOrdID = 11 */
    public String clOrdIDAsString()
    {
        return hasClOrdID ? new String(clOrdID, 0, clOrdIDLength) : null;
    }

    /* ClOrdID = 11 */
    public AsciiSequenceView clOrdID(final AsciiSequenceView view)
    {
        if (!hasClOrdID)
        {
            throw new IllegalArgumentException("No value for optional field: ClOrdID");
        }

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
    private char[] listID = new char[1];

    private boolean hasListID;

    /* ListID = 66 */
    public char[] listID()
    {
        if (!hasListID)
        {
            throw new IllegalArgumentException("No value for optional field: ListID");
        }

        return listID;
    }

    public boolean hasListID()
    {
        return hasListID;
    }


    private int listIDOffset;

    private int listIDLength;

    /* ListID = 66 */
    public int listIDLength()
    {
        if (!hasListID)
        {
            throw new IllegalArgumentException("No value for optional field: ListID");
        }

        return listIDLength;
    }

    /* ListID = 66 */
    public String listIDAsString()
    {
        return hasListID ? new String(listID, 0, listIDLength) : null;
    }

    /* ListID = 66 */
    public AsciiSequenceView listID(final AsciiSequenceView view)
    {
        if (!hasListID)
        {
            throw new IllegalArgumentException("No value for optional field: ListID");
        }

        return view.wrap(buffer, listIDOffset, listIDLength);
    }


    private final CharArrayWrapper listIDWrapper = new CharArrayWrapper();


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

    private boolean oddLot;

    private boolean hasOddLot;

    /* OddLot = 575 */
    public boolean oddLot()
    {
        if (!hasOddLot)
        {
            throw new IllegalArgumentException("No value for optional field: OddLot");
        }

        return oddLot;
    }

    public boolean hasOddLot()
    {
        return hasOddLot;
    }




@Generated("uk.co.real_logic.artio")
public class ClearingInstructionsGroupDecoder extends CommonDecoderImpl
{
    public final IntHashSet REQUIRED_FIELDS = new IntHashSet(0);

    {
        if (CODEC_VALIDATION_ENABLED)
        {
        }
    }

    public final IntHashSet ALL_GROUP_FIELDS = new IntHashSet(2);

    {
        if (CODEC_VALIDATION_ENABLED)
        {
            ALL_GROUP_FIELDS.add(Constants.CLEARING_INSTRUCTION);
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
        if (hasClearingInstruction)
        {
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !ClearingInstruction.isValid(clearingInstruction()))
        {
            invalidTagId = 577;
            rejectReason = 5;
            return false;
        }
        }
        return true;
    }

    private final TrailerDecoder trailer;
    private final IntHashSet messageFields;
    public ClearingInstructionsGroupDecoder(final TrailerDecoder trailer, final IntHashSet messageFields)
    {
        this.trailer = trailer;
        this.messageFields = messageFields;
    }

    private ClearingInstructionsGroupDecoder next = null;

    public ClearingInstructionsGroupDecoder next()
    {
        return next;
    }

    private IntHashSet seenFields = new IntHashSet(2);

    private int clearingInstruction = MISSING_INT;

    private boolean hasClearingInstruction;

    /* ClearingInstruction = 577 */
    public int clearingInstruction()
    {
        if (!hasClearingInstruction)
        {
            throw new IllegalArgumentException("No value for optional field: ClearingInstruction");
        }

        return clearingInstruction;
    }

    public boolean hasClearingInstruction()
    {
        return hasClearingInstruction;
    }



    private final CharArrayWrapper clearingInstructionWrapper = new CharArrayWrapper();
    /* ClearingInstruction = 577 */
    public ClearingInstruction clearingInstructionAsEnum()
    {
        if (!hasClearingInstruction)
 return ClearingInstruction.NULL_VAL;
        return ClearingInstruction.decode(clearingInstruction);
    }

    public int decode(final AsciiBuffer buffer, final int offset, final int length)
    {
        // Decode ClearingInstructionsGroup
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
                    next = new ClearingInstructionsGroupDecoder(trailer, messageFields);
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
            case Constants.CLEARING_INSTRUCTION:
                hasClearingInstruction = true;
                clearingInstruction = getInt(buffer, valueOffset, endOfField, 577, CODEC_VALIDATION_ENABLED);
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
        this.resetClearingInstruction();
        buffer = null;
        if (CODEC_VALIDATION_ENABLED)
        {
            invalidTagId = Decoder.NO_ERROR;
            rejectReason = Decoder.NO_ERROR;
            missingRequiredFields.clear();
        }
    }

    public void resetClearingInstruction()
    {
        hasClearingInstruction = false;
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
        builder.append("\"MessageName\": \"ClearingInstructionsGroup\",\n");
        if (hasClearingInstruction())
        {
            indent(builder, level);
            builder.append("\"ClearingInstruction\": \"");
            builder.append(clearingInstruction);
            builder.append("\",\n");
        }
        indent(builder, level - 1);
        builder.append("}");
        return builder;
    }

    /**
     * {@inheritDoc}
     */
    public SidesGroupEncoder.ClearingInstructionsGroupEncoder toEncoder(final Encoder encoder)
    {
        return toEncoder((SidesGroupEncoder.ClearingInstructionsGroupEncoder)encoder);
    }

    public SidesGroupEncoder.ClearingInstructionsGroupEncoder toEncoder(final SidesGroupEncoder.ClearingInstructionsGroupEncoder encoder)
    {
        encoder.reset();
        if (hasClearingInstruction())
        {
            encoder.clearingInstruction(this.clearingInstruction());
        }
        return encoder;
    }

}
    @Generated("uk.co.real_logic.artio")
    public class ClearingInstructionsGroupIterator implements Iterable<ClearingInstructionsGroupDecoder>, java.util.Iterator<ClearingInstructionsGroupDecoder>
    {
        private final SidesGroupDecoder parent;
        private int remainder;
        private ClearingInstructionsGroupDecoder current;

        public ClearingInstructionsGroupIterator(final SidesGroupDecoder parent)
        {
            this.parent = parent;
        }

        public boolean hasNext()
        {
            return remainder > 0 && current != null;
        }

        public ClearingInstructionsGroupDecoder next()
        {
            remainder--;
            final ClearingInstructionsGroupDecoder value = current;
            current = current.next();
            return value;
        }

        public int numberFieldValue()
        {
            return parent.hasNoClearingInstructionsGroupCounter() ? parent.noClearingInstructionsGroupCounter() : 0;
        }

        public void reset()
        {
            remainder = numberFieldValue();
            current = parent.clearingInstructionsGroup();
        }

        public ClearingInstructionsGroupIterator iterator()
        {
            reset();
            return this;
        }

    }


    private ClearingInstructionsGroupDecoder clearingInstructionsGroup = null;
    public ClearingInstructionsGroupDecoder clearingInstructionsGroup()
    {
        return clearingInstructionsGroup;
    }

    private int noClearingInstructionsGroupCounter = MISSING_INT;

    private boolean hasNoClearingInstructionsGroupCounter;

    /* NoClearingInstructionsGroupCounter = 576 */
    public int noClearingInstructionsGroupCounter()
    {
        if (!hasNoClearingInstructionsGroupCounter)
        {
            throw new IllegalArgumentException("No value for optional field: NoClearingInstructionsGroupCounter");
        }

        return noClearingInstructionsGroupCounter;
    }

    public boolean hasNoClearingInstructionsGroupCounter()
    {
        return hasNoClearingInstructionsGroupCounter;
    }




    private ClearingInstructionsGroupIterator clearingInstructionsGroupIterator = new ClearingInstructionsGroupIterator(this);
    public ClearingInstructionsGroupIterator clearingInstructionsGroupIterator()
    {
        return clearingInstructionsGroupIterator.iterator();
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

    private char[] tradeInputSource = new char[1];

    private boolean hasTradeInputSource;

    /* TradeInputSource = 578 */
    public char[] tradeInputSource()
    {
        if (!hasTradeInputSource)
        {
            throw new IllegalArgumentException("No value for optional field: TradeInputSource");
        }

        return tradeInputSource;
    }

    public boolean hasTradeInputSource()
    {
        return hasTradeInputSource;
    }


    private int tradeInputSourceOffset;

    private int tradeInputSourceLength;

    /* TradeInputSource = 578 */
    public int tradeInputSourceLength()
    {
        if (!hasTradeInputSource)
        {
            throw new IllegalArgumentException("No value for optional field: TradeInputSource");
        }

        return tradeInputSourceLength;
    }

    /* TradeInputSource = 578 */
    public String tradeInputSourceAsString()
    {
        return hasTradeInputSource ? new String(tradeInputSource, 0, tradeInputSourceLength) : null;
    }

    /* TradeInputSource = 578 */
    public AsciiSequenceView tradeInputSource(final AsciiSequenceView view)
    {
        if (!hasTradeInputSource)
        {
            throw new IllegalArgumentException("No value for optional field: TradeInputSource");
        }

        return view.wrap(buffer, tradeInputSourceOffset, tradeInputSourceLength);
    }


    private final CharArrayWrapper tradeInputSourceWrapper = new CharArrayWrapper();
    private char[] tradeInputDevice = new char[1];

    private boolean hasTradeInputDevice;

    /* TradeInputDevice = 579 */
    public char[] tradeInputDevice()
    {
        if (!hasTradeInputDevice)
        {
            throw new IllegalArgumentException("No value for optional field: TradeInputDevice");
        }

        return tradeInputDevice;
    }

    public boolean hasTradeInputDevice()
    {
        return hasTradeInputDevice;
    }


    private int tradeInputDeviceOffset;

    private int tradeInputDeviceLength;

    /* TradeInputDevice = 579 */
    public int tradeInputDeviceLength()
    {
        if (!hasTradeInputDevice)
        {
            throw new IllegalArgumentException("No value for optional field: TradeInputDevice");
        }

        return tradeInputDeviceLength;
    }

    /* TradeInputDevice = 579 */
    public String tradeInputDeviceAsString()
    {
        return hasTradeInputDevice ? new String(tradeInputDevice, 0, tradeInputDeviceLength) : null;
    }

    /* TradeInputDevice = 579 */
    public AsciiSequenceView tradeInputDevice(final AsciiSequenceView view)
    {
        if (!hasTradeInputDevice)
        {
            throw new IllegalArgumentException("No value for optional field: TradeInputDevice");
        }

        return view.wrap(buffer, tradeInputDeviceOffset, tradeInputDeviceLength);
    }


    private final CharArrayWrapper tradeInputDeviceWrapper = new CharArrayWrapper();
    private char[] orderInputDevice = new char[1];

    private boolean hasOrderInputDevice;

    /* OrderInputDevice = 821 */
    public char[] orderInputDevice()
    {
        if (!hasOrderInputDevice)
        {
            throw new IllegalArgumentException("No value for optional field: OrderInputDevice");
        }

        return orderInputDevice;
    }

    public boolean hasOrderInputDevice()
    {
        return hasOrderInputDevice;
    }


    private int orderInputDeviceOffset;

    private int orderInputDeviceLength;

    /* OrderInputDevice = 821 */
    public int orderInputDeviceLength()
    {
        if (!hasOrderInputDevice)
        {
            throw new IllegalArgumentException("No value for optional field: OrderInputDevice");
        }

        return orderInputDeviceLength;
    }

    /* OrderInputDevice = 821 */
    public String orderInputDeviceAsString()
    {
        return hasOrderInputDevice ? new String(orderInputDevice, 0, orderInputDeviceLength) : null;
    }

    /* OrderInputDevice = 821 */
    public AsciiSequenceView orderInputDevice(final AsciiSequenceView view)
    {
        if (!hasOrderInputDevice)
        {
            throw new IllegalArgumentException("No value for optional field: OrderInputDevice");
        }

        return view.wrap(buffer, orderInputDeviceOffset, orderInputDeviceLength);
    }


    private final CharArrayWrapper orderInputDeviceWrapper = new CharArrayWrapper();
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
    private byte[] transBkdTime = new byte[24];

    private boolean hasTransBkdTime;

    /* TransBkdTime = 483 */
    public byte[] transBkdTime()
    {
        if (!hasTransBkdTime)
        {
            throw new IllegalArgumentException("No value for optional field: TransBkdTime");
        }

        return transBkdTime;
    }

    public boolean hasTransBkdTime()
    {
        return hasTransBkdTime;
    }


    private int transBkdTimeOffset;

    private int transBkdTimeLength;

    /* TransBkdTime = 483 */
    public int transBkdTimeLength()
    {
        if (!hasTransBkdTime)
        {
            throw new IllegalArgumentException("No value for optional field: TransBkdTime");
        }

        return transBkdTimeLength;
    }

    /* TransBkdTime = 483 */
    public String transBkdTimeAsString()
    {
        return hasTransBkdTime ? new String(transBkdTime, 0, transBkdTimeLength) : null;
    }

    /* TransBkdTime = 483 */
    public AsciiSequenceView transBkdTime(final AsciiSequenceView view)
    {
        if (!hasTransBkdTime)
        {
            throw new IllegalArgumentException("No value for optional field: TransBkdTime");
        }

        return view.wrap(buffer, transBkdTimeOffset, transBkdTimeLength);
    }


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
    private char[] timeBracket = new char[1];

    private boolean hasTimeBracket;

    /* TimeBracket = 943 */
    public char[] timeBracket()
    {
        if (!hasTimeBracket)
        {
            throw new IllegalArgumentException("No value for optional field: TimeBracket");
        }

        return timeBracket;
    }

    public boolean hasTimeBracket()
    {
        return hasTimeBracket;
    }


    private int timeBracketOffset;

    private int timeBracketLength;

    /* TimeBracket = 943 */
    public int timeBracketLength()
    {
        if (!hasTimeBracket)
        {
            throw new IllegalArgumentException("No value for optional field: TimeBracket");
        }

        return timeBracketLength;
    }

    /* TimeBracket = 943 */
    public String timeBracketAsString()
    {
        return hasTimeBracket ? new String(timeBracket, 0, timeBracketLength) : null;
    }

    /* TimeBracket = 943 */
    public AsciiSequenceView timeBracket(final AsciiSequenceView view)
    {
        if (!hasTimeBracket)
        {
            throw new IllegalArgumentException("No value for optional field: TimeBracket");
        }

        return view.wrap(buffer, timeBracketOffset, timeBracketLength);
    }


    private final CharArrayWrapper timeBracketWrapper = new CharArrayWrapper();

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


    private DecimalFloat grossTradeAmt = DecimalFloat.newNaNValue();

    private boolean hasGrossTradeAmt;

    /* GrossTradeAmt = 381 */
    public DecimalFloat grossTradeAmt()
    {
        if (!hasGrossTradeAmt)
        {
            throw new IllegalArgumentException("No value for optional field: GrossTradeAmt");
        }

        return grossTradeAmt;
    }

    public boolean hasGrossTradeAmt()
    {
        return hasGrossTradeAmt;
    }



    private int numDaysInterest = MISSING_INT;

    private boolean hasNumDaysInterest;

    /* NumDaysInterest = 157 */
    public int numDaysInterest()
    {
        if (!hasNumDaysInterest)
        {
            throw new IllegalArgumentException("No value for optional field: NumDaysInterest");
        }

        return numDaysInterest;
    }

    public boolean hasNumDaysInterest()
    {
        return hasNumDaysInterest;
    }



    private byte[] exDate = new byte[8];

    private boolean hasExDate;

    /* ExDate = 230 */
    public byte[] exDate()
    {
        if (!hasExDate)
        {
            throw new IllegalArgumentException("No value for optional field: ExDate");
        }

        return exDate;
    }

    public boolean hasExDate()
    {
        return hasExDate;
    }


    private int exDateOffset;

    private int exDateLength;

    /* ExDate = 230 */
    public int exDateLength()
    {
        if (!hasExDate)
        {
            throw new IllegalArgumentException("No value for optional field: ExDate");
        }

        return exDateLength;
    }

    /* ExDate = 230 */
    public String exDateAsString()
    {
        return hasExDate ? new String(exDate, 0, exDateLength) : null;
    }

    /* ExDate = 230 */
    public AsciiSequenceView exDate(final AsciiSequenceView view)
    {
        if (!hasExDate)
        {
            throw new IllegalArgumentException("No value for optional field: ExDate");
        }

        return view.wrap(buffer, exDateOffset, exDateLength);
    }


    private DecimalFloat accruedInterestRate = DecimalFloat.newNaNValue();

    private boolean hasAccruedInterestRate;

    /* AccruedInterestRate = 158 */
    public DecimalFloat accruedInterestRate()
    {
        if (!hasAccruedInterestRate)
        {
            throw new IllegalArgumentException("No value for optional field: AccruedInterestRate");
        }

        return accruedInterestRate;
    }

    public boolean hasAccruedInterestRate()
    {
        return hasAccruedInterestRate;
    }



    private DecimalFloat accruedInterestAmt = DecimalFloat.newNaNValue();

    private boolean hasAccruedInterestAmt;

    /* AccruedInterestAmt = 159 */
    public DecimalFloat accruedInterestAmt()
    {
        if (!hasAccruedInterestAmt)
        {
            throw new IllegalArgumentException("No value for optional field: AccruedInterestAmt");
        }

        return accruedInterestAmt;
    }

    public boolean hasAccruedInterestAmt()
    {
        return hasAccruedInterestAmt;
    }



    private DecimalFloat interestAtMaturity = DecimalFloat.newNaNValue();

    private boolean hasInterestAtMaturity;

    /* InterestAtMaturity = 738 */
    public DecimalFloat interestAtMaturity()
    {
        if (!hasInterestAtMaturity)
        {
            throw new IllegalArgumentException("No value for optional field: InterestAtMaturity");
        }

        return interestAtMaturity;
    }

    public boolean hasInterestAtMaturity()
    {
        return hasInterestAtMaturity;
    }



    private DecimalFloat endAccruedInterestAmt = DecimalFloat.newNaNValue();

    private boolean hasEndAccruedInterestAmt;

    /* EndAccruedInterestAmt = 920 */
    public DecimalFloat endAccruedInterestAmt()
    {
        if (!hasEndAccruedInterestAmt)
        {
            throw new IllegalArgumentException("No value for optional field: EndAccruedInterestAmt");
        }

        return endAccruedInterestAmt;
    }

    public boolean hasEndAccruedInterestAmt()
    {
        return hasEndAccruedInterestAmt;
    }



    private DecimalFloat startCash = DecimalFloat.newNaNValue();

    private boolean hasStartCash;

    /* StartCash = 921 */
    public DecimalFloat startCash()
    {
        if (!hasStartCash)
        {
            throw new IllegalArgumentException("No value for optional field: StartCash");
        }

        return startCash;
    }

    public boolean hasStartCash()
    {
        return hasStartCash;
    }



    private DecimalFloat endCash = DecimalFloat.newNaNValue();

    private boolean hasEndCash;

    /* EndCash = 922 */
    public DecimalFloat endCash()
    {
        if (!hasEndCash)
        {
            throw new IllegalArgumentException("No value for optional field: EndCash");
        }

        return endCash;
    }

    public boolean hasEndCash()
    {
        return hasEndCash;
    }



    private DecimalFloat concession = DecimalFloat.newNaNValue();

    private boolean hasConcession;

    /* Concession = 238 */
    public DecimalFloat concession()
    {
        if (!hasConcession)
        {
            throw new IllegalArgumentException("No value for optional field: Concession");
        }

        return concession;
    }

    public boolean hasConcession()
    {
        return hasConcession;
    }



    private DecimalFloat totalTakedown = DecimalFloat.newNaNValue();

    private boolean hasTotalTakedown;

    /* TotalTakedown = 237 */
    public DecimalFloat totalTakedown()
    {
        if (!hasTotalTakedown)
        {
            throw new IllegalArgumentException("No value for optional field: TotalTakedown");
        }

        return totalTakedown;
    }

    public boolean hasTotalTakedown()
    {
        return hasTotalTakedown;
    }



    private DecimalFloat netMoney = DecimalFloat.newNaNValue();

    private boolean hasNetMoney;

    /* NetMoney = 118 */
    public DecimalFloat netMoney()
    {
        if (!hasNetMoney)
        {
            throw new IllegalArgumentException("No value for optional field: NetMoney");
        }

        return netMoney;
    }

    public boolean hasNetMoney()
    {
        return hasNetMoney;
    }



    private DecimalFloat settlCurrAmt = DecimalFloat.newNaNValue();

    private boolean hasSettlCurrAmt;

    /* SettlCurrAmt = 119 */
    public DecimalFloat settlCurrAmt()
    {
        if (!hasSettlCurrAmt)
        {
            throw new IllegalArgumentException("No value for optional field: SettlCurrAmt");
        }

        return settlCurrAmt;
    }

    public boolean hasSettlCurrAmt()
    {
        return hasSettlCurrAmt;
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


    private DecimalFloat settlCurrFxRate = DecimalFloat.newNaNValue();

    private boolean hasSettlCurrFxRate;

    /* SettlCurrFxRate = 155 */
    public DecimalFloat settlCurrFxRate()
    {
        if (!hasSettlCurrFxRate)
        {
            throw new IllegalArgumentException("No value for optional field: SettlCurrFxRate");
        }

        return settlCurrFxRate;
    }

    public boolean hasSettlCurrFxRate()
    {
        return hasSettlCurrFxRate;
    }



    private char settlCurrFxRateCalc = MISSING_CHAR;

    private boolean hasSettlCurrFxRateCalc;

    /* SettlCurrFxRateCalc = 156 */
    public char settlCurrFxRateCalc()
    {
        if (!hasSettlCurrFxRateCalc)
        {
            throw new IllegalArgumentException("No value for optional field: SettlCurrFxRateCalc");
        }

        return settlCurrFxRateCalc;
    }

    public boolean hasSettlCurrFxRateCalc()
    {
        return hasSettlCurrFxRateCalc;
    }



    private final CharArrayWrapper settlCurrFxRateCalcWrapper = new CharArrayWrapper();
    /* SettlCurrFxRateCalc = 156 */
    public SettlCurrFxRateCalc settlCurrFxRateCalcAsEnum()
    {
        if (!hasSettlCurrFxRateCalc)
 return SettlCurrFxRateCalc.NULL_VAL;
        return SettlCurrFxRateCalc.decode(settlCurrFxRateCalc);
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



    private int sideMultiLegReportingType = MISSING_INT;

    private boolean hasSideMultiLegReportingType;

    /* SideMultiLegReportingType = 752 */
    public int sideMultiLegReportingType()
    {
        if (!hasSideMultiLegReportingType)
        {
            throw new IllegalArgumentException("No value for optional field: SideMultiLegReportingType");
        }

        return sideMultiLegReportingType;
    }

    public boolean hasSideMultiLegReportingType()
    {
        return hasSideMultiLegReportingType;
    }



    private final CharArrayWrapper sideMultiLegReportingTypeWrapper = new CharArrayWrapper();
    /* SideMultiLegReportingType = 752 */
    public SideMultiLegReportingType sideMultiLegReportingTypeAsEnum()
    {
        if (!hasSideMultiLegReportingType)
 return SideMultiLegReportingType.NULL_VAL;
        return SideMultiLegReportingType.decode(sideMultiLegReportingType);
    }


@Generated("uk.co.real_logic.artio")
public class ContAmtsGroupDecoder extends CommonDecoderImpl
{
    public final IntHashSet REQUIRED_FIELDS = new IntHashSet(0);

    {
        if (CODEC_VALIDATION_ENABLED)
        {
        }
    }

    public final IntHashSet ALL_GROUP_FIELDS = new IntHashSet(6);

    {
        if (CODEC_VALIDATION_ENABLED)
        {
            ALL_GROUP_FIELDS.add(Constants.CONT_AMT_TYPE);
            ALL_GROUP_FIELDS.add(Constants.CONT_AMT_VALUE);
            ALL_GROUP_FIELDS.add(Constants.CONT_AMT_CURR);
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
        if (hasContAmtType)
        {
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !ContAmtType.isValid(contAmtType()))
        {
            invalidTagId = 519;
            rejectReason = 5;
            return false;
        }
        }
        return true;
    }

    private final TrailerDecoder trailer;
    private final IntHashSet messageFields;
    public ContAmtsGroupDecoder(final TrailerDecoder trailer, final IntHashSet messageFields)
    {
        this.trailer = trailer;
        this.messageFields = messageFields;
    }

    private ContAmtsGroupDecoder next = null;

    public ContAmtsGroupDecoder next()
    {
        return next;
    }

    private IntHashSet seenFields = new IntHashSet(6);

    private int contAmtType = MISSING_INT;

    private boolean hasContAmtType;

    /* ContAmtType = 519 */
    public int contAmtType()
    {
        if (!hasContAmtType)
        {
            throw new IllegalArgumentException("No value for optional field: ContAmtType");
        }

        return contAmtType;
    }

    public boolean hasContAmtType()
    {
        return hasContAmtType;
    }



    private final CharArrayWrapper contAmtTypeWrapper = new CharArrayWrapper();
    /* ContAmtType = 519 */
    public ContAmtType contAmtTypeAsEnum()
    {
        if (!hasContAmtType)
 return ContAmtType.NULL_VAL;
        return ContAmtType.decode(contAmtType);
    }

    private DecimalFloat contAmtValue = DecimalFloat.newNaNValue();

    private boolean hasContAmtValue;

    /* ContAmtValue = 520 */
    public DecimalFloat contAmtValue()
    {
        if (!hasContAmtValue)
        {
            throw new IllegalArgumentException("No value for optional field: ContAmtValue");
        }

        return contAmtValue;
    }

    public boolean hasContAmtValue()
    {
        return hasContAmtValue;
    }



    private char[] contAmtCurr = new char[1];

    private boolean hasContAmtCurr;

    /* ContAmtCurr = 521 */
    public char[] contAmtCurr()
    {
        if (!hasContAmtCurr)
        {
            throw new IllegalArgumentException("No value for optional field: ContAmtCurr");
        }

        return contAmtCurr;
    }

    public boolean hasContAmtCurr()
    {
        return hasContAmtCurr;
    }


    private int contAmtCurrOffset;

    private int contAmtCurrLength;

    /* ContAmtCurr = 521 */
    public int contAmtCurrLength()
    {
        if (!hasContAmtCurr)
        {
            throw new IllegalArgumentException("No value for optional field: ContAmtCurr");
        }

        return contAmtCurrLength;
    }

    /* ContAmtCurr = 521 */
    public String contAmtCurrAsString()
    {
        return hasContAmtCurr ? new String(contAmtCurr, 0, contAmtCurrLength) : null;
    }

    /* ContAmtCurr = 521 */
    public AsciiSequenceView contAmtCurr(final AsciiSequenceView view)
    {
        if (!hasContAmtCurr)
        {
            throw new IllegalArgumentException("No value for optional field: ContAmtCurr");
        }

        return view.wrap(buffer, contAmtCurrOffset, contAmtCurrLength);
    }


    public int decode(final AsciiBuffer buffer, final int offset, final int length)
    {
        // Decode ContAmtsGroup
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
                    next = new ContAmtsGroupDecoder(trailer, messageFields);
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
            case Constants.CONT_AMT_TYPE:
                hasContAmtType = true;
                contAmtType = getInt(buffer, valueOffset, endOfField, 519, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.CONT_AMT_VALUE:
                hasContAmtValue = true;
                contAmtValue = getFloat(buffer, contAmtValue, valueOffset, valueLength, 520, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.CONT_AMT_CURR:
                hasContAmtCurr = true;
                contAmtCurr = buffer.getChars(contAmtCurr, valueOffset, valueLength);
                contAmtCurrOffset = valueOffset;
                contAmtCurrLength = valueLength;
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
        this.resetContAmtType();
        this.resetContAmtValue();
        this.resetContAmtCurr();
        buffer = null;
        if (CODEC_VALIDATION_ENABLED)
        {
            invalidTagId = Decoder.NO_ERROR;
            rejectReason = Decoder.NO_ERROR;
            missingRequiredFields.clear();
        }
    }

    public void resetContAmtType()
    {
        hasContAmtType = false;
    }

    public void resetContAmtValue()
    {
        hasContAmtValue = false;
    }

    public void resetContAmtCurr()
    {
        hasContAmtCurr = false;
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
        builder.append("\"MessageName\": \"ContAmtsGroup\",\n");
        if (hasContAmtType())
        {
            indent(builder, level);
            builder.append("\"ContAmtType\": \"");
            builder.append(contAmtType);
            builder.append("\",\n");
        }

        if (hasContAmtValue())
        {
            indent(builder, level);
            builder.append("\"ContAmtValue\": \"");
            contAmtValue.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasContAmtCurr())
        {
            indent(builder, level);
            builder.append("\"ContAmtCurr\": \"");
            builder.append(this.contAmtCurr(), 0, contAmtCurrLength());
            builder.append("\",\n");
        }
        indent(builder, level - 1);
        builder.append("}");
        return builder;
    }

    /**
     * {@inheritDoc}
     */
    public SidesGroupEncoder.ContAmtsGroupEncoder toEncoder(final Encoder encoder)
    {
        return toEncoder((SidesGroupEncoder.ContAmtsGroupEncoder)encoder);
    }

    public SidesGroupEncoder.ContAmtsGroupEncoder toEncoder(final SidesGroupEncoder.ContAmtsGroupEncoder encoder)
    {
        encoder.reset();
        if (hasContAmtType())
        {
            encoder.contAmtType(this.contAmtType());
        }

        if (hasContAmtValue())
        {
            encoder.contAmtValue(this.contAmtValue());
        }

        if (hasContAmtCurr())
        {
            encoder.contAmtCurr(this.contAmtCurr(), 0, contAmtCurrLength());
        }
        return encoder;
    }

}
    @Generated("uk.co.real_logic.artio")
    public class ContAmtsGroupIterator implements Iterable<ContAmtsGroupDecoder>, java.util.Iterator<ContAmtsGroupDecoder>
    {
        private final SidesGroupDecoder parent;
        private int remainder;
        private ContAmtsGroupDecoder current;

        public ContAmtsGroupIterator(final SidesGroupDecoder parent)
        {
            this.parent = parent;
        }

        public boolean hasNext()
        {
            return remainder > 0 && current != null;
        }

        public ContAmtsGroupDecoder next()
        {
            remainder--;
            final ContAmtsGroupDecoder value = current;
            current = current.next();
            return value;
        }

        public int numberFieldValue()
        {
            return parent.hasNoContAmtsGroupCounter() ? parent.noContAmtsGroupCounter() : 0;
        }

        public void reset()
        {
            remainder = numberFieldValue();
            current = parent.contAmtsGroup();
        }

        public ContAmtsGroupIterator iterator()
        {
            reset();
            return this;
        }

    }


    private ContAmtsGroupDecoder contAmtsGroup = null;
    public ContAmtsGroupDecoder contAmtsGroup()
    {
        return contAmtsGroup;
    }

    private int noContAmtsGroupCounter = MISSING_INT;

    private boolean hasNoContAmtsGroupCounter;

    /* NoContAmtsGroupCounter = 518 */
    public int noContAmtsGroupCounter()
    {
        if (!hasNoContAmtsGroupCounter)
        {
            throw new IllegalArgumentException("No value for optional field: NoContAmtsGroupCounter");
        }

        return noContAmtsGroupCounter;
    }

    public boolean hasNoContAmtsGroupCounter()
    {
        return hasNoContAmtsGroupCounter;
    }




    private ContAmtsGroupIterator contAmtsGroupIterator = new ContAmtsGroupIterator(this);
    public ContAmtsGroupIterator contAmtsGroupIterator()
    {
        return contAmtsGroupIterator.iterator();
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



@Generated("uk.co.real_logic.artio")
public class MiscFeesGroupDecoder extends CommonDecoderImpl
{
    public final IntHashSet REQUIRED_FIELDS = new IntHashSet(0);

    {
        if (CODEC_VALIDATION_ENABLED)
        {
        }
    }

    public final IntHashSet ALL_GROUP_FIELDS = new IntHashSet(8);

    {
        if (CODEC_VALIDATION_ENABLED)
        {
            ALL_GROUP_FIELDS.add(Constants.MISC_FEE_AMT);
            ALL_GROUP_FIELDS.add(Constants.MISC_FEE_CURR);
            ALL_GROUP_FIELDS.add(Constants.MISC_FEE_TYPE);
            ALL_GROUP_FIELDS.add(Constants.MISC_FEE_BASIS);
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
        if (hasMiscFeeType)
        {
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !MiscFeeType.isValid(miscFeeType()))
        {
            invalidTagId = 139;
            rejectReason = 5;
            return false;
        }
        }

        if (hasMiscFeeBasis)
        {
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !MiscFeeBasis.isValid(miscFeeBasis()))
        {
            invalidTagId = 891;
            rejectReason = 5;
            return false;
        }
        }
        return true;
    }

    private final TrailerDecoder trailer;
    private final IntHashSet messageFields;
    public MiscFeesGroupDecoder(final TrailerDecoder trailer, final IntHashSet messageFields)
    {
        this.trailer = trailer;
        this.messageFields = messageFields;
    }

    private MiscFeesGroupDecoder next = null;

    public MiscFeesGroupDecoder next()
    {
        return next;
    }

    private IntHashSet seenFields = new IntHashSet(8);

    private DecimalFloat miscFeeAmt = DecimalFloat.newNaNValue();

    private boolean hasMiscFeeAmt;

    /* MiscFeeAmt = 137 */
    public DecimalFloat miscFeeAmt()
    {
        if (!hasMiscFeeAmt)
        {
            throw new IllegalArgumentException("No value for optional field: MiscFeeAmt");
        }

        return miscFeeAmt;
    }

    public boolean hasMiscFeeAmt()
    {
        return hasMiscFeeAmt;
    }



    private char[] miscFeeCurr = new char[1];

    private boolean hasMiscFeeCurr;

    /* MiscFeeCurr = 138 */
    public char[] miscFeeCurr()
    {
        if (!hasMiscFeeCurr)
        {
            throw new IllegalArgumentException("No value for optional field: MiscFeeCurr");
        }

        return miscFeeCurr;
    }

    public boolean hasMiscFeeCurr()
    {
        return hasMiscFeeCurr;
    }


    private int miscFeeCurrOffset;

    private int miscFeeCurrLength;

    /* MiscFeeCurr = 138 */
    public int miscFeeCurrLength()
    {
        if (!hasMiscFeeCurr)
        {
            throw new IllegalArgumentException("No value for optional field: MiscFeeCurr");
        }

        return miscFeeCurrLength;
    }

    /* MiscFeeCurr = 138 */
    public String miscFeeCurrAsString()
    {
        return hasMiscFeeCurr ? new String(miscFeeCurr, 0, miscFeeCurrLength) : null;
    }

    /* MiscFeeCurr = 138 */
    public AsciiSequenceView miscFeeCurr(final AsciiSequenceView view)
    {
        if (!hasMiscFeeCurr)
        {
            throw new IllegalArgumentException("No value for optional field: MiscFeeCurr");
        }

        return view.wrap(buffer, miscFeeCurrOffset, miscFeeCurrLength);
    }


    private char miscFeeType = MISSING_CHAR;

    private boolean hasMiscFeeType;

    /* MiscFeeType = 139 */
    public char miscFeeType()
    {
        if (!hasMiscFeeType)
        {
            throw new IllegalArgumentException("No value for optional field: MiscFeeType");
        }

        return miscFeeType;
    }

    public boolean hasMiscFeeType()
    {
        return hasMiscFeeType;
    }



    private final CharArrayWrapper miscFeeTypeWrapper = new CharArrayWrapper();
    /* MiscFeeType = 139 */
    public MiscFeeType miscFeeTypeAsEnum()
    {
        if (!hasMiscFeeType)
 return MiscFeeType.NULL_VAL;
        return MiscFeeType.decode(miscFeeType);
    }

    private int miscFeeBasis = MISSING_INT;

    private boolean hasMiscFeeBasis;

    /* MiscFeeBasis = 891 */
    public int miscFeeBasis()
    {
        if (!hasMiscFeeBasis)
        {
            throw new IllegalArgumentException("No value for optional field: MiscFeeBasis");
        }

        return miscFeeBasis;
    }

    public boolean hasMiscFeeBasis()
    {
        return hasMiscFeeBasis;
    }



    private final CharArrayWrapper miscFeeBasisWrapper = new CharArrayWrapper();
    /* MiscFeeBasis = 891 */
    public MiscFeeBasis miscFeeBasisAsEnum()
    {
        if (!hasMiscFeeBasis)
 return MiscFeeBasis.NULL_VAL;
        return MiscFeeBasis.decode(miscFeeBasis);
    }

    public int decode(final AsciiBuffer buffer, final int offset, final int length)
    {
        // Decode MiscFeesGroup
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
                    next = new MiscFeesGroupDecoder(trailer, messageFields);
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
            case Constants.MISC_FEE_AMT:
                hasMiscFeeAmt = true;
                miscFeeAmt = getFloat(buffer, miscFeeAmt, valueOffset, valueLength, 137, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.MISC_FEE_CURR:
                hasMiscFeeCurr = true;
                miscFeeCurr = buffer.getChars(miscFeeCurr, valueOffset, valueLength);
                miscFeeCurrOffset = valueOffset;
                miscFeeCurrLength = valueLength;
                break;

            case Constants.MISC_FEE_TYPE:
                hasMiscFeeType = true;
                miscFeeType = buffer.getChar(valueOffset);
                break;

            case Constants.MISC_FEE_BASIS:
                hasMiscFeeBasis = true;
                miscFeeBasis = getInt(buffer, valueOffset, endOfField, 891, CODEC_VALIDATION_ENABLED);
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
        this.resetMiscFeeAmt();
        this.resetMiscFeeCurr();
        this.resetMiscFeeType();
        this.resetMiscFeeBasis();
        buffer = null;
        if (CODEC_VALIDATION_ENABLED)
        {
            invalidTagId = Decoder.NO_ERROR;
            rejectReason = Decoder.NO_ERROR;
            missingRequiredFields.clear();
        }
    }

    public void resetMiscFeeAmt()
    {
        hasMiscFeeAmt = false;
    }

    public void resetMiscFeeCurr()
    {
        hasMiscFeeCurr = false;
    }

    public void resetMiscFeeType()
    {
        hasMiscFeeType = false;
    }

    public void resetMiscFeeBasis()
    {
        hasMiscFeeBasis = false;
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
        builder.append("\"MessageName\": \"MiscFeesGroup\",\n");
        if (hasMiscFeeAmt())
        {
            indent(builder, level);
            builder.append("\"MiscFeeAmt\": \"");
            miscFeeAmt.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasMiscFeeCurr())
        {
            indent(builder, level);
            builder.append("\"MiscFeeCurr\": \"");
            builder.append(this.miscFeeCurr(), 0, miscFeeCurrLength());
            builder.append("\",\n");
        }

        if (hasMiscFeeType())
        {
            indent(builder, level);
            builder.append("\"MiscFeeType\": \"");
            builder.append(miscFeeType);
            builder.append("\",\n");
        }

        if (hasMiscFeeBasis())
        {
            indent(builder, level);
            builder.append("\"MiscFeeBasis\": \"");
            builder.append(miscFeeBasis);
            builder.append("\",\n");
        }
        indent(builder, level - 1);
        builder.append("}");
        return builder;
    }

    /**
     * {@inheritDoc}
     */
    public SidesGroupEncoder.MiscFeesGroupEncoder toEncoder(final Encoder encoder)
    {
        return toEncoder((SidesGroupEncoder.MiscFeesGroupEncoder)encoder);
    }

    public SidesGroupEncoder.MiscFeesGroupEncoder toEncoder(final SidesGroupEncoder.MiscFeesGroupEncoder encoder)
    {
        encoder.reset();
        if (hasMiscFeeAmt())
        {
            encoder.miscFeeAmt(this.miscFeeAmt());
        }

        if (hasMiscFeeCurr())
        {
            encoder.miscFeeCurr(this.miscFeeCurr(), 0, miscFeeCurrLength());
        }

        if (hasMiscFeeType())
        {
            encoder.miscFeeType(this.miscFeeType());
        }

        if (hasMiscFeeBasis())
        {
            encoder.miscFeeBasis(this.miscFeeBasis());
        }
        return encoder;
    }

}
    @Generated("uk.co.real_logic.artio")
    public class MiscFeesGroupIterator implements Iterable<MiscFeesGroupDecoder>, java.util.Iterator<MiscFeesGroupDecoder>
    {
        private final SidesGroupDecoder parent;
        private int remainder;
        private MiscFeesGroupDecoder current;

        public MiscFeesGroupIterator(final SidesGroupDecoder parent)
        {
            this.parent = parent;
        }

        public boolean hasNext()
        {
            return remainder > 0 && current != null;
        }

        public MiscFeesGroupDecoder next()
        {
            remainder--;
            final MiscFeesGroupDecoder value = current;
            current = current.next();
            return value;
        }

        public int numberFieldValue()
        {
            return parent.hasNoMiscFeesGroupCounter() ? parent.noMiscFeesGroupCounter() : 0;
        }

        public void reset()
        {
            remainder = numberFieldValue();
            current = parent.miscFeesGroup();
        }

        public MiscFeesGroupIterator iterator()
        {
            reset();
            return this;
        }

    }


    private MiscFeesGroupDecoder miscFeesGroup = null;
    public MiscFeesGroupDecoder miscFeesGroup()
    {
        return miscFeesGroup;
    }

    private int noMiscFeesGroupCounter = MISSING_INT;

    private boolean hasNoMiscFeesGroupCounter;

    /* NoMiscFeesGroupCounter = 136 */
    public int noMiscFeesGroupCounter()
    {
        if (!hasNoMiscFeesGroupCounter)
        {
            throw new IllegalArgumentException("No value for optional field: NoMiscFeesGroupCounter");
        }

        return noMiscFeesGroupCounter;
    }

    public boolean hasNoMiscFeesGroupCounter()
    {
        return hasNoMiscFeesGroupCounter;
    }




    private MiscFeesGroupIterator miscFeesGroupIterator = new MiscFeesGroupIterator(this);
    public MiscFeesGroupIterator miscFeesGroupIterator()
    {
        return miscFeesGroupIterator.iterator();
    }

    private char[] exchangeRule = new char[1];

    private boolean hasExchangeRule;

    /* ExchangeRule = 825 */
    public char[] exchangeRule()
    {
        if (!hasExchangeRule)
        {
            throw new IllegalArgumentException("No value for optional field: ExchangeRule");
        }

        return exchangeRule;
    }

    public boolean hasExchangeRule()
    {
        return hasExchangeRule;
    }


    private int exchangeRuleOffset;

    private int exchangeRuleLength;

    /* ExchangeRule = 825 */
    public int exchangeRuleLength()
    {
        if (!hasExchangeRule)
        {
            throw new IllegalArgumentException("No value for optional field: ExchangeRule");
        }

        return exchangeRuleLength;
    }

    /* ExchangeRule = 825 */
    public String exchangeRuleAsString()
    {
        return hasExchangeRule ? new String(exchangeRule, 0, exchangeRuleLength) : null;
    }

    /* ExchangeRule = 825 */
    public AsciiSequenceView exchangeRule(final AsciiSequenceView view)
    {
        if (!hasExchangeRule)
        {
            throw new IllegalArgumentException("No value for optional field: ExchangeRule");
        }

        return view.wrap(buffer, exchangeRuleOffset, exchangeRuleLength);
    }


    private final CharArrayWrapper exchangeRuleWrapper = new CharArrayWrapper();
    private int tradeAllocIndicator = MISSING_INT;

    private boolean hasTradeAllocIndicator;

    /* TradeAllocIndicator = 826 */
    public int tradeAllocIndicator()
    {
        if (!hasTradeAllocIndicator)
        {
            throw new IllegalArgumentException("No value for optional field: TradeAllocIndicator");
        }

        return tradeAllocIndicator;
    }

    public boolean hasTradeAllocIndicator()
    {
        return hasTradeAllocIndicator;
    }



    private final CharArrayWrapper tradeAllocIndicatorWrapper = new CharArrayWrapper();
    /* TradeAllocIndicator = 826 */
    public TradeAllocIndicator tradeAllocIndicatorAsEnum()
    {
        if (!hasTradeAllocIndicator)
 return TradeAllocIndicator.NULL_VAL;
        return TradeAllocIndicator.decode(tradeAllocIndicator);
    }

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

@Generated("uk.co.real_logic.artio")
public class AllocsGroupDecoder extends CommonDecoderImpl implements NestedParties2Decoder
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
        if (hasNoNested2PartyIDsGroupCounter)
        {
            {
                int count = 0;
                final Nested2PartyIDsGroupIterator iterator = nested2PartyIDsGroupIterator.iterator();
                for (final Nested2PartyIDsGroupDecoder group : iterator)
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
                    invalidTagId = 756;
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


    private Nested2PartyIDsGroupDecoder nested2PartyIDsGroup = null;
    public Nested2PartyIDsGroupDecoder nested2PartyIDsGroup()
    {
        return nested2PartyIDsGroup;
    }

    private int noNested2PartyIDsGroupCounter = MISSING_INT;

    private boolean hasNoNested2PartyIDsGroupCounter;

    /* NoNested2PartyIDsGroupCounter = 756 */
    public int noNested2PartyIDsGroupCounter()
    {
        if (!hasNoNested2PartyIDsGroupCounter)
        {
            throw new IllegalArgumentException("No value for optional field: NoNested2PartyIDsGroupCounter");
        }

        return noNested2PartyIDsGroupCounter;
    }

    public boolean hasNoNested2PartyIDsGroupCounter()
    {
        return hasNoNested2PartyIDsGroupCounter;
    }




    private Nested2PartyIDsGroupIterator nested2PartyIDsGroupIterator = new Nested2PartyIDsGroupIterator(this);
    public Nested2PartyIDsGroupIterator nested2PartyIDsGroupIterator()
    {
        return nested2PartyIDsGroupIterator.iterator();
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

            case Constants.NO_NESTED2_PARTY_IDS_GROUP_COUNTER:
                hasNoNested2PartyIDsGroupCounter = true;
                noNested2PartyIDsGroupCounter = getInt(buffer, valueOffset, endOfField, 756, CODEC_VALIDATION_ENABLED);
                if (nested2PartyIDsGroup == null)
                {
                    nested2PartyIDsGroup = new Nested2PartyIDsGroupDecoder(trailer, messageFields);
                }
                Nested2PartyIDsGroupDecoder nested2PartyIDsGroupCurrent = nested2PartyIDsGroup;
                position = endOfField + 1;
                final int noNested2PartyIDsGroupCounter = this.noNested2PartyIDsGroupCounter;
                for (int i = 0; i < noNested2PartyIDsGroupCounter && position < end; i++)
                {
                    if (nested2PartyIDsGroupCurrent != null)
                    {
                        position += nested2PartyIDsGroupCurrent.decode(buffer, position, end - position);
                        nested2PartyIDsGroupCurrent = nested2PartyIDsGroupCurrent.next();
                    }
                }
                if (CODEC_VALIDATION_ENABLED)
                {
                    final int checkEqualsPosition = buffer.scan(position, end, '=');
                    if (checkEqualsPosition != AsciiBuffer.UNKNOWN_INDEX)
                    {
                        final int checkTag = buffer.getInt(position, checkEqualsPosition);
                        if (nested2PartyIDsGroup.ALL_GROUP_FIELDS.contains(checkTag))
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
        this.resetNested2PartyIDsGroup();
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

    public void resetNested2PartyIDsGroup()
    {
        for (final Nested2PartyIDsGroupDecoder nested2PartyIDsGroupDecoder : nested2PartyIDsGroupIterator.iterator())
        {
            nested2PartyIDsGroupDecoder.reset();
            if (nested2PartyIDsGroupDecoder.next() == null)
            {
                break;
            }
        }
        noNested2PartyIDsGroupCounter = MISSING_INT;
        hasNoNested2PartyIDsGroupCounter = false;
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

        if (hasNoNested2PartyIDsGroupCounter)
        {
            indent(builder, level);
            builder.append("\"Nested2PartyIDsGroup\": [\n");
            Nested2PartyIDsGroupDecoder nested2PartyIDsGroup = this.nested2PartyIDsGroup;
            for (int i = 0, size = this.noNested2PartyIDsGroupCounter; i < size; i++)
            {
                indent(builder, level);
                nested2PartyIDsGroup.appendTo(builder, level + 1);
                if (nested2PartyIDsGroup.next() != null)
                {
                    builder.append(',');
                }
                builder.append('\n');
                nested2PartyIDsGroup = nested2PartyIDsGroup.next();            }
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
    public SidesGroupEncoder.AllocsGroupEncoder toEncoder(final Encoder encoder)
    {
        return toEncoder((SidesGroupEncoder.AllocsGroupEncoder)encoder);
    }

    public SidesGroupEncoder.AllocsGroupEncoder toEncoder(final SidesGroupEncoder.AllocsGroupEncoder encoder)
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


        final NestedParties2Encoder nestedParties2 = encoder.nestedParties2();        if (hasNoNested2PartyIDsGroupCounter)
        {
            final int size = this.noNested2PartyIDsGroupCounter;
            Nested2PartyIDsGroupDecoder nested2PartyIDsGroup = this.nested2PartyIDsGroup;
            Nested2PartyIDsGroupEncoder nested2PartyIDsGroupEncoder = nestedParties2.nested2PartyIDsGroup(size);
            for (int i = 0; i < size; i++)
            {
                if (nested2PartyIDsGroup != null)
                {
                    nested2PartyIDsGroup.toEncoder(nested2PartyIDsGroupEncoder);
                    nested2PartyIDsGroup = nested2PartyIDsGroup.next();
                    nested2PartyIDsGroupEncoder = nested2PartyIDsGroupEncoder.next();
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
        private final SidesGroupDecoder parent;
        private int remainder;
        private AllocsGroupDecoder current;

        public AllocsGroupIterator(final SidesGroupDecoder parent)
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

    public int decode(final AsciiBuffer buffer, final int offset, final int length)
    {
        // Decode SidesGroup
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
                    next = new SidesGroupDecoder(trailer, messageFields);
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
            case Constants.SIDE:
                side = buffer.getChar(valueOffset);
                break;

            case Constants.ORDER_ID:
                orderID = buffer.getChars(orderID, valueOffset, valueLength);
                orderIDOffset = valueOffset;
                orderIDLength = valueLength;
                break;

            case Constants.SECONDARY_ORDER_ID:
                hasSecondaryOrderID = true;
                secondaryOrderID = buffer.getChars(secondaryOrderID, valueOffset, valueLength);
                secondaryOrderIDOffset = valueOffset;
                secondaryOrderIDLength = valueLength;
                break;

            case Constants.CL_ORD_ID:
                hasClOrdID = true;
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

            case Constants.LIST_ID:
                hasListID = true;
                listID = buffer.getChars(listID, valueOffset, valueLength);
                listIDOffset = valueOffset;
                listIDLength = valueLength;
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

            case Constants.PROCESS_CODE:
                hasProcessCode = true;
                processCode = buffer.getChar(valueOffset);
                break;

            case Constants.ODD_LOT:
                hasOddLot = true;
                oddLot = buffer.getBoolean(valueOffset);
                break;

            case Constants.NO_CLEARING_INSTRUCTIONS_GROUP_COUNTER:
                hasNoClearingInstructionsGroupCounter = true;
                noClearingInstructionsGroupCounter = getInt(buffer, valueOffset, endOfField, 576, CODEC_VALIDATION_ENABLED);
                if (clearingInstructionsGroup == null)
                {
                    clearingInstructionsGroup = new ClearingInstructionsGroupDecoder(trailer, messageFields);
                }
                ClearingInstructionsGroupDecoder clearingInstructionsGroupCurrent = clearingInstructionsGroup;
                position = endOfField + 1;
                final int noClearingInstructionsGroupCounter = this.noClearingInstructionsGroupCounter;
                for (int i = 0; i < noClearingInstructionsGroupCounter && position < end; i++)
                {
                    if (clearingInstructionsGroupCurrent != null)
                    {
                        position += clearingInstructionsGroupCurrent.decode(buffer, position, end - position);
                        clearingInstructionsGroupCurrent = clearingInstructionsGroupCurrent.next();
                    }
                }
                if (CODEC_VALIDATION_ENABLED)
                {
                    final int checkEqualsPosition = buffer.scan(position, end, '=');
                    if (checkEqualsPosition != AsciiBuffer.UNKNOWN_INDEX)
                    {
                        final int checkTag = buffer.getInt(position, checkEqualsPosition);
                        if (clearingInstructionsGroup.ALL_GROUP_FIELDS.contains(checkTag))
                        {
                            invalidTagId = tag;
                            rejectReason = 16;
                            return position;
                        }
                    }
                }
                break;

            case Constants.CLEARING_FEE_INDICATOR:
                hasClearingFeeIndicator = true;
                clearingFeeIndicator = buffer.getChars(clearingFeeIndicator, valueOffset, valueLength);
                clearingFeeIndicatorOffset = valueOffset;
                clearingFeeIndicatorLength = valueLength;
                break;

            case Constants.TRADE_INPUT_SOURCE:
                hasTradeInputSource = true;
                tradeInputSource = buffer.getChars(tradeInputSource, valueOffset, valueLength);
                tradeInputSourceOffset = valueOffset;
                tradeInputSourceLength = valueLength;
                break;

            case Constants.TRADE_INPUT_DEVICE:
                hasTradeInputDevice = true;
                tradeInputDevice = buffer.getChars(tradeInputDevice, valueOffset, valueLength);
                tradeInputDeviceOffset = valueOffset;
                tradeInputDeviceLength = valueLength;
                break;

            case Constants.ORDER_INPUT_DEVICE:
                hasOrderInputDevice = true;
                orderInputDevice = buffer.getChars(orderInputDevice, valueOffset, valueLength);
                orderInputDeviceOffset = valueOffset;
                orderInputDeviceLength = valueLength;
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

            case Constants.ORD_TYPE:
                hasOrdType = true;
                ordType = buffer.getChar(valueOffset);
                break;

            case Constants.EXEC_INST:
                hasExecInst = true;
                execInst = buffer.getChars(execInst, valueOffset, valueLength);
                execInstOffset = valueOffset;
                execInstLength = valueLength;
                break;

            case Constants.TRANS_BKD_TIME:
                hasTransBkdTime = true;
                transBkdTime = buffer.getBytes(transBkdTime, valueOffset, valueLength);
                transBkdTimeOffset = valueOffset;
                transBkdTimeLength = valueLength;
                break;

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

            case Constants.TIME_BRACKET:
                hasTimeBracket = true;
                timeBracket = buffer.getChars(timeBracket, valueOffset, valueLength);
                timeBracketOffset = valueOffset;
                timeBracketLength = valueLength;
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


            case Constants.GROSS_TRADE_AMT:
                hasGrossTradeAmt = true;
                grossTradeAmt = getFloat(buffer, grossTradeAmt, valueOffset, valueLength, 381, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.NUM_DAYS_INTEREST:
                hasNumDaysInterest = true;
                numDaysInterest = getInt(buffer, valueOffset, endOfField, 157, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.EX_DATE:
                hasExDate = true;
                exDate = buffer.getBytes(exDate, valueOffset, valueLength);
                exDateOffset = valueOffset;
                exDateLength = valueLength;
                break;

            case Constants.ACCRUED_INTEREST_RATE:
                hasAccruedInterestRate = true;
                accruedInterestRate = getFloat(buffer, accruedInterestRate, valueOffset, valueLength, 158, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.ACCRUED_INTEREST_AMT:
                hasAccruedInterestAmt = true;
                accruedInterestAmt = getFloat(buffer, accruedInterestAmt, valueOffset, valueLength, 159, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.INTEREST_AT_MATURITY:
                hasInterestAtMaturity = true;
                interestAtMaturity = getFloat(buffer, interestAtMaturity, valueOffset, valueLength, 738, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.END_ACCRUED_INTEREST_AMT:
                hasEndAccruedInterestAmt = true;
                endAccruedInterestAmt = getFloat(buffer, endAccruedInterestAmt, valueOffset, valueLength, 920, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.START_CASH:
                hasStartCash = true;
                startCash = getFloat(buffer, startCash, valueOffset, valueLength, 921, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.END_CASH:
                hasEndCash = true;
                endCash = getFloat(buffer, endCash, valueOffset, valueLength, 922, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.CONCESSION:
                hasConcession = true;
                concession = getFloat(buffer, concession, valueOffset, valueLength, 238, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.TOTAL_TAKEDOWN:
                hasTotalTakedown = true;
                totalTakedown = getFloat(buffer, totalTakedown, valueOffset, valueLength, 237, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.NET_MONEY:
                hasNetMoney = true;
                netMoney = getFloat(buffer, netMoney, valueOffset, valueLength, 118, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.SETTL_CURR_AMT:
                hasSettlCurrAmt = true;
                settlCurrAmt = getFloat(buffer, settlCurrAmt, valueOffset, valueLength, 119, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.SETTL_CURRENCY:
                hasSettlCurrency = true;
                settlCurrency = buffer.getChars(settlCurrency, valueOffset, valueLength);
                settlCurrencyOffset = valueOffset;
                settlCurrencyLength = valueLength;
                break;

            case Constants.SETTL_CURR_FX_RATE:
                hasSettlCurrFxRate = true;
                settlCurrFxRate = getFloat(buffer, settlCurrFxRate, valueOffset, valueLength, 155, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.SETTL_CURR_FX_RATE_CALC:
                hasSettlCurrFxRateCalc = true;
                settlCurrFxRateCalc = buffer.getChar(valueOffset);
                break;

            case Constants.POSITION_EFFECT:
                hasPositionEffect = true;
                positionEffect = buffer.getChar(valueOffset);
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

            case Constants.SIDE_MULTI_LEG_REPORTING_TYPE:
                hasSideMultiLegReportingType = true;
                sideMultiLegReportingType = getInt(buffer, valueOffset, endOfField, 752, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.NO_CONT_AMTS_GROUP_COUNTER:
                hasNoContAmtsGroupCounter = true;
                noContAmtsGroupCounter = getInt(buffer, valueOffset, endOfField, 518, CODEC_VALIDATION_ENABLED);
                if (contAmtsGroup == null)
                {
                    contAmtsGroup = new ContAmtsGroupDecoder(trailer, messageFields);
                }
                ContAmtsGroupDecoder contAmtsGroupCurrent = contAmtsGroup;
                position = endOfField + 1;
                final int noContAmtsGroupCounter = this.noContAmtsGroupCounter;
                for (int i = 0; i < noContAmtsGroupCounter && position < end; i++)
                {
                    if (contAmtsGroupCurrent != null)
                    {
                        position += contAmtsGroupCurrent.decode(buffer, position, end - position);
                        contAmtsGroupCurrent = contAmtsGroupCurrent.next();
                    }
                }
                if (CODEC_VALIDATION_ENABLED)
                {
                    final int checkEqualsPosition = buffer.scan(position, end, '=');
                    if (checkEqualsPosition != AsciiBuffer.UNKNOWN_INDEX)
                    {
                        final int checkTag = buffer.getInt(position, checkEqualsPosition);
                        if (contAmtsGroup.ALL_GROUP_FIELDS.contains(checkTag))
                        {
                            invalidTagId = tag;
                            rejectReason = 16;
                            return position;
                        }
                    }
                }
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


            case Constants.NO_MISC_FEES_GROUP_COUNTER:
                hasNoMiscFeesGroupCounter = true;
                noMiscFeesGroupCounter = getInt(buffer, valueOffset, endOfField, 136, CODEC_VALIDATION_ENABLED);
                if (miscFeesGroup == null)
                {
                    miscFeesGroup = new MiscFeesGroupDecoder(trailer, messageFields);
                }
                MiscFeesGroupDecoder miscFeesGroupCurrent = miscFeesGroup;
                position = endOfField + 1;
                final int noMiscFeesGroupCounter = this.noMiscFeesGroupCounter;
                for (int i = 0; i < noMiscFeesGroupCounter && position < end; i++)
                {
                    if (miscFeesGroupCurrent != null)
                    {
                        position += miscFeesGroupCurrent.decode(buffer, position, end - position);
                        miscFeesGroupCurrent = miscFeesGroupCurrent.next();
                    }
                }
                if (CODEC_VALIDATION_ENABLED)
                {
                    final int checkEqualsPosition = buffer.scan(position, end, '=');
                    if (checkEqualsPosition != AsciiBuffer.UNKNOWN_INDEX)
                    {
                        final int checkTag = buffer.getInt(position, checkEqualsPosition);
                        if (miscFeesGroup.ALL_GROUP_FIELDS.contains(checkTag))
                        {
                            invalidTagId = tag;
                            rejectReason = 16;
                            return position;
                        }
                    }
                }
                break;

            case Constants.EXCHANGE_RULE:
                hasExchangeRule = true;
                exchangeRule = buffer.getChars(exchangeRule, valueOffset, valueLength);
                exchangeRuleOffset = valueOffset;
                exchangeRuleLength = valueLength;
                break;

            case Constants.TRADE_ALLOC_INDICATOR:
                hasTradeAllocIndicator = true;
                tradeAllocIndicator = getInt(buffer, valueOffset, endOfField, 826, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.PREALLOC_METHOD:
                hasPreallocMethod = true;
                preallocMethod = buffer.getChar(valueOffset);
                break;

            case Constants.ALLOC_ID:
                hasAllocID = true;
                allocID = buffer.getChars(allocID, valueOffset, valueLength);
                allocIDOffset = valueOffset;
                allocIDLength = valueLength;
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
        this.resetSide();
        this.resetOrderID();
        this.resetSecondaryOrderID();
        this.resetClOrdID();
        this.resetSecondaryClOrdID();
        this.resetListID();
        this.resetAccount();
        this.resetAcctIDSource();
        this.resetAccountType();
        this.resetProcessCode();
        this.resetOddLot();
        this.resetClearingFeeIndicator();
        this.resetTradeInputSource();
        this.resetTradeInputDevice();
        this.resetOrderInputDevice();
        this.resetCurrency();
        this.resetComplianceID();
        this.resetSolicitedFlag();
        this.resetOrderCapacity();
        this.resetOrderRestrictions();
        this.resetCustOrderCapacity();
        this.resetOrdType();
        this.resetExecInst();
        this.resetTransBkdTime();
        this.resetTradingSessionID();
        this.resetTradingSessionSubID();
        this.resetTimeBracket();
        this.resetGrossTradeAmt();
        this.resetNumDaysInterest();
        this.resetExDate();
        this.resetAccruedInterestRate();
        this.resetAccruedInterestAmt();
        this.resetInterestAtMaturity();
        this.resetEndAccruedInterestAmt();
        this.resetStartCash();
        this.resetEndCash();
        this.resetConcession();
        this.resetTotalTakedown();
        this.resetNetMoney();
        this.resetSettlCurrAmt();
        this.resetSettlCurrency();
        this.resetSettlCurrFxRate();
        this.resetSettlCurrFxRateCalc();
        this.resetPositionEffect();
        this.resetText();
        this.resetEncodedTextLen();
        this.resetEncodedText();
        this.resetSideMultiLegReportingType();
        this.resetExchangeRule();
        this.resetTradeAllocIndicator();
        this.resetPreallocMethod();
        this.resetAllocID();
        this.resetPartyIDsGroup();
        this.resetCommission();
        this.resetCommType();
        this.resetCommCurrency();
        this.resetFundRenewWaiv();
        this.resetStipulationsGroup();
        this.resetClearingInstructionsGroup();
        this.resetContAmtsGroup();
        this.resetMiscFeesGroup();
        this.resetAllocsGroup();
        buffer = null;
        if (CODEC_VALIDATION_ENABLED)
        {
            invalidTagId = Decoder.NO_ERROR;
            rejectReason = Decoder.NO_ERROR;
            missingRequiredFields.clear();
        }
    }

    public void resetSide()
    {
        side = MISSING_CHAR;
    }

    public void resetOrderID()
    {
        orderIDOffset = 0;
        orderIDLength = 0;
    }

    public void resetSecondaryOrderID()
    {
        hasSecondaryOrderID = false;
    }

    public void resetClOrdID()
    {
        hasClOrdID = false;
    }

    public void resetSecondaryClOrdID()
    {
        hasSecondaryClOrdID = false;
    }

    public void resetListID()
    {
        hasListID = false;
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

    public void resetProcessCode()
    {
        hasProcessCode = false;
    }

    public void resetOddLot()
    {
        hasOddLot = false;
    }

    public void resetClearingFeeIndicator()
    {
        hasClearingFeeIndicator = false;
    }

    public void resetTradeInputSource()
    {
        hasTradeInputSource = false;
    }

    public void resetTradeInputDevice()
    {
        hasTradeInputDevice = false;
    }

    public void resetOrderInputDevice()
    {
        hasOrderInputDevice = false;
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

    public void resetOrdType()
    {
        hasOrdType = false;
    }

    public void resetExecInst()
    {
        hasExecInst = false;
    }

    public void resetTransBkdTime()
    {
        hasTransBkdTime = false;
    }

    public void resetTradingSessionID()
    {
        hasTradingSessionID = false;
    }

    public void resetTradingSessionSubID()
    {
        hasTradingSessionSubID = false;
    }

    public void resetTimeBracket()
    {
        hasTimeBracket = false;
    }

    public void resetGrossTradeAmt()
    {
        hasGrossTradeAmt = false;
    }

    public void resetNumDaysInterest()
    {
        hasNumDaysInterest = false;
    }

    public void resetExDate()
    {
        hasExDate = false;
    }

    public void resetAccruedInterestRate()
    {
        hasAccruedInterestRate = false;
    }

    public void resetAccruedInterestAmt()
    {
        hasAccruedInterestAmt = false;
    }

    public void resetInterestAtMaturity()
    {
        hasInterestAtMaturity = false;
    }

    public void resetEndAccruedInterestAmt()
    {
        hasEndAccruedInterestAmt = false;
    }

    public void resetStartCash()
    {
        hasStartCash = false;
    }

    public void resetEndCash()
    {
        hasEndCash = false;
    }

    public void resetConcession()
    {
        hasConcession = false;
    }

    public void resetTotalTakedown()
    {
        hasTotalTakedown = false;
    }

    public void resetNetMoney()
    {
        hasNetMoney = false;
    }

    public void resetSettlCurrAmt()
    {
        hasSettlCurrAmt = false;
    }

    public void resetSettlCurrency()
    {
        hasSettlCurrency = false;
    }

    public void resetSettlCurrFxRate()
    {
        hasSettlCurrFxRate = false;
    }

    public void resetSettlCurrFxRateCalc()
    {
        hasSettlCurrFxRateCalc = false;
    }

    public void resetPositionEffect()
    {
        hasPositionEffect = false;
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

    public void resetSideMultiLegReportingType()
    {
        hasSideMultiLegReportingType = false;
    }

    public void resetExchangeRule()
    {
        hasExchangeRule = false;
    }

    public void resetTradeAllocIndicator()
    {
        hasTradeAllocIndicator = false;
    }

    public void resetPreallocMethod()
    {
        hasPreallocMethod = false;
    }

    public void resetAllocID()
    {
        hasAllocID = false;
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

    public void resetClearingInstructionsGroup()
    {
        for (final ClearingInstructionsGroupDecoder clearingInstructionsGroupDecoder : clearingInstructionsGroupIterator.iterator())
        {
            clearingInstructionsGroupDecoder.reset();
            if (clearingInstructionsGroupDecoder.next() == null)
            {
                break;
            }
        }
        noClearingInstructionsGroupCounter = MISSING_INT;
        hasNoClearingInstructionsGroupCounter = false;
    }

    public void resetContAmtsGroup()
    {
        for (final ContAmtsGroupDecoder contAmtsGroupDecoder : contAmtsGroupIterator.iterator())
        {
            contAmtsGroupDecoder.reset();
            if (contAmtsGroupDecoder.next() == null)
            {
                break;
            }
        }
        noContAmtsGroupCounter = MISSING_INT;
        hasNoContAmtsGroupCounter = false;
    }

    public void resetMiscFeesGroup()
    {
        for (final MiscFeesGroupDecoder miscFeesGroupDecoder : miscFeesGroupIterator.iterator())
        {
            miscFeesGroupDecoder.reset();
            if (miscFeesGroupDecoder.next() == null)
            {
                break;
            }
        }
        noMiscFeesGroupCounter = MISSING_INT;
        hasNoMiscFeesGroupCounter = false;
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
        builder.append("\"MessageName\": \"SidesGroup\",\n");
        indent(builder, level);
        builder.append("\"Side\": \"");
        builder.append(side);
        builder.append("\",\n");

        indent(builder, level);
        builder.append("\"OrderID\": \"");
        builder.append(this.orderID(), 0, orderIDLength());
        builder.append("\",\n");

        if (hasSecondaryOrderID())
        {
            indent(builder, level);
            builder.append("\"SecondaryOrderID\": \"");
            builder.append(this.secondaryOrderID(), 0, secondaryOrderIDLength());
            builder.append("\",\n");
        }

        if (hasClOrdID())
        {
            indent(builder, level);
            builder.append("\"ClOrdID\": \"");
            builder.append(this.clOrdID(), 0, clOrdIDLength());
            builder.append("\",\n");
        }

        if (hasSecondaryClOrdID())
        {
            indent(builder, level);
            builder.append("\"SecondaryClOrdID\": \"");
            builder.append(this.secondaryClOrdID(), 0, secondaryClOrdIDLength());
            builder.append("\",\n");
        }

        if (hasListID())
        {
            indent(builder, level);
            builder.append("\"ListID\": \"");
            builder.append(this.listID(), 0, listIDLength());
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

        if (hasProcessCode())
        {
            indent(builder, level);
            builder.append("\"ProcessCode\": \"");
            builder.append(processCode);
            builder.append("\",\n");
        }

        if (hasOddLot())
        {
            indent(builder, level);
            builder.append("\"OddLot\": \"");
            builder.append(oddLot);
            builder.append("\",\n");
        }

        if (hasNoClearingInstructionsGroupCounter)
        {
            indent(builder, level);
            builder.append("\"ClearingInstructionsGroup\": [\n");
            ClearingInstructionsGroupDecoder clearingInstructionsGroup = this.clearingInstructionsGroup;
            for (int i = 0, size = this.noClearingInstructionsGroupCounter; i < size; i++)
            {
                indent(builder, level);
                clearingInstructionsGroup.appendTo(builder, level + 1);
                if (clearingInstructionsGroup.next() != null)
                {
                    builder.append(',');
                }
                builder.append('\n');
                clearingInstructionsGroup = clearingInstructionsGroup.next();            }
            indent(builder, level);
            builder.append("],\n");
        }

        if (hasClearingFeeIndicator())
        {
            indent(builder, level);
            builder.append("\"ClearingFeeIndicator\": \"");
            builder.append(this.clearingFeeIndicator(), 0, clearingFeeIndicatorLength());
            builder.append("\",\n");
        }

        if (hasTradeInputSource())
        {
            indent(builder, level);
            builder.append("\"TradeInputSource\": \"");
            builder.append(this.tradeInputSource(), 0, tradeInputSourceLength());
            builder.append("\",\n");
        }

        if (hasTradeInputDevice())
        {
            indent(builder, level);
            builder.append("\"TradeInputDevice\": \"");
            builder.append(this.tradeInputDevice(), 0, tradeInputDeviceLength());
            builder.append("\",\n");
        }

        if (hasOrderInputDevice())
        {
            indent(builder, level);
            builder.append("\"OrderInputDevice\": \"");
            builder.append(this.orderInputDevice(), 0, orderInputDeviceLength());
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

        if (hasOrdType())
        {
            indent(builder, level);
            builder.append("\"OrdType\": \"");
            builder.append(ordType);
            builder.append("\",\n");
        }

        if (hasExecInst())
        {
            indent(builder, level);
            builder.append("\"ExecInst\": \"");
            builder.append(this.execInst(), 0, execInstLength());
            builder.append("\",\n");
        }

        if (hasTransBkdTime())
        {
            indent(builder, level);
            builder.append("\"TransBkdTime\": \"");
            appendData(builder, transBkdTime, transBkdTimeLength);
            builder.append("\",\n");
        }

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

        if (hasTimeBracket())
        {
            indent(builder, level);
            builder.append("\"TimeBracket\": \"");
            builder.append(this.timeBracket(), 0, timeBracketLength());
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

        if (hasGrossTradeAmt())
        {
            indent(builder, level);
            builder.append("\"GrossTradeAmt\": \"");
            grossTradeAmt.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasNumDaysInterest())
        {
            indent(builder, level);
            builder.append("\"NumDaysInterest\": \"");
            builder.append(numDaysInterest);
            builder.append("\",\n");
        }

        if (hasExDate())
        {
            indent(builder, level);
            builder.append("\"ExDate\": \"");
            appendData(builder, exDate, exDateLength);
            builder.append("\",\n");
        }

        if (hasAccruedInterestRate())
        {
            indent(builder, level);
            builder.append("\"AccruedInterestRate\": \"");
            accruedInterestRate.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasAccruedInterestAmt())
        {
            indent(builder, level);
            builder.append("\"AccruedInterestAmt\": \"");
            accruedInterestAmt.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasInterestAtMaturity())
        {
            indent(builder, level);
            builder.append("\"InterestAtMaturity\": \"");
            interestAtMaturity.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasEndAccruedInterestAmt())
        {
            indent(builder, level);
            builder.append("\"EndAccruedInterestAmt\": \"");
            endAccruedInterestAmt.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasStartCash())
        {
            indent(builder, level);
            builder.append("\"StartCash\": \"");
            startCash.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasEndCash())
        {
            indent(builder, level);
            builder.append("\"EndCash\": \"");
            endCash.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasConcession())
        {
            indent(builder, level);
            builder.append("\"Concession\": \"");
            concession.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasTotalTakedown())
        {
            indent(builder, level);
            builder.append("\"TotalTakedown\": \"");
            totalTakedown.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasNetMoney())
        {
            indent(builder, level);
            builder.append("\"NetMoney\": \"");
            netMoney.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasSettlCurrAmt())
        {
            indent(builder, level);
            builder.append("\"SettlCurrAmt\": \"");
            settlCurrAmt.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasSettlCurrency())
        {
            indent(builder, level);
            builder.append("\"SettlCurrency\": \"");
            builder.append(this.settlCurrency(), 0, settlCurrencyLength());
            builder.append("\",\n");
        }

        if (hasSettlCurrFxRate())
        {
            indent(builder, level);
            builder.append("\"SettlCurrFxRate\": \"");
            settlCurrFxRate.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasSettlCurrFxRateCalc())
        {
            indent(builder, level);
            builder.append("\"SettlCurrFxRateCalc\": \"");
            builder.append(settlCurrFxRateCalc);
            builder.append("\",\n");
        }

        if (hasPositionEffect())
        {
            indent(builder, level);
            builder.append("\"PositionEffect\": \"");
            builder.append(positionEffect);
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

        if (hasSideMultiLegReportingType())
        {
            indent(builder, level);
            builder.append("\"SideMultiLegReportingType\": \"");
            builder.append(sideMultiLegReportingType);
            builder.append("\",\n");
        }

        if (hasNoContAmtsGroupCounter)
        {
            indent(builder, level);
            builder.append("\"ContAmtsGroup\": [\n");
            ContAmtsGroupDecoder contAmtsGroup = this.contAmtsGroup;
            for (int i = 0, size = this.noContAmtsGroupCounter; i < size; i++)
            {
                indent(builder, level);
                contAmtsGroup.appendTo(builder, level + 1);
                if (contAmtsGroup.next() != null)
                {
                    builder.append(',');
                }
                builder.append('\n');
                contAmtsGroup = contAmtsGroup.next();            }
            indent(builder, level);
            builder.append("],\n");
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

        if (hasNoMiscFeesGroupCounter)
        {
            indent(builder, level);
            builder.append("\"MiscFeesGroup\": [\n");
            MiscFeesGroupDecoder miscFeesGroup = this.miscFeesGroup;
            for (int i = 0, size = this.noMiscFeesGroupCounter; i < size; i++)
            {
                indent(builder, level);
                miscFeesGroup.appendTo(builder, level + 1);
                if (miscFeesGroup.next() != null)
                {
                    builder.append(',');
                }
                builder.append('\n');
                miscFeesGroup = miscFeesGroup.next();            }
            indent(builder, level);
            builder.append("],\n");
        }

        if (hasExchangeRule())
        {
            indent(builder, level);
            builder.append("\"ExchangeRule\": \"");
            builder.append(this.exchangeRule(), 0, exchangeRuleLength());
            builder.append("\",\n");
        }

        if (hasTradeAllocIndicator())
        {
            indent(builder, level);
            builder.append("\"TradeAllocIndicator\": \"");
            builder.append(tradeAllocIndicator);
            builder.append("\",\n");
        }

        if (hasPreallocMethod())
        {
            indent(builder, level);
            builder.append("\"PreallocMethod\": \"");
            builder.append(preallocMethod);
            builder.append("\",\n");
        }

        if (hasAllocID())
        {
            indent(builder, level);
            builder.append("\"AllocID\": \"");
            builder.append(this.allocID(), 0, allocIDLength());
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
        indent(builder, level - 1);
        builder.append("}");
        return builder;
    }

    /**
     * {@inheritDoc}
     */
    public TradeCaptureReportEncoder.SidesGroupEncoder toEncoder(final Encoder encoder)
    {
        return toEncoder((TradeCaptureReportEncoder.SidesGroupEncoder)encoder);
    }

    public TradeCaptureReportEncoder.SidesGroupEncoder toEncoder(final TradeCaptureReportEncoder.SidesGroupEncoder encoder)
    {
        encoder.reset();
        encoder.side(this.side());
        encoder.orderID(this.orderID(), 0, orderIDLength());
        if (hasSecondaryOrderID())
        {
            encoder.secondaryOrderID(this.secondaryOrderID(), 0, secondaryOrderIDLength());
        }

        if (hasClOrdID())
        {
            encoder.clOrdID(this.clOrdID(), 0, clOrdIDLength());
        }

        if (hasSecondaryClOrdID())
        {
            encoder.secondaryClOrdID(this.secondaryClOrdID(), 0, secondaryClOrdIDLength());
        }

        if (hasListID())
        {
            encoder.listID(this.listID(), 0, listIDLength());
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

        if (hasProcessCode())
        {
            encoder.processCode(this.processCode());
        }

        if (hasOddLot())
        {
            encoder.oddLot(this.oddLot());
        }

        if (hasNoClearingInstructionsGroupCounter)
        {
            final int size = this.noClearingInstructionsGroupCounter;
            ClearingInstructionsGroupDecoder clearingInstructionsGroup = this.clearingInstructionsGroup;
            ClearingInstructionsGroupEncoder clearingInstructionsGroupEncoder = encoder.clearingInstructionsGroup(size);
            for (int i = 0; i < size; i++)
            {
                if (clearingInstructionsGroup != null)
                {
                    clearingInstructionsGroup.toEncoder(clearingInstructionsGroupEncoder);
                    clearingInstructionsGroup = clearingInstructionsGroup.next();
                    clearingInstructionsGroupEncoder = clearingInstructionsGroupEncoder.next();
                }
            }
        }

        if (hasClearingFeeIndicator())
        {
            encoder.clearingFeeIndicator(this.clearingFeeIndicator(), 0, clearingFeeIndicatorLength());
        }

        if (hasTradeInputSource())
        {
            encoder.tradeInputSource(this.tradeInputSource(), 0, tradeInputSourceLength());
        }

        if (hasTradeInputDevice())
        {
            encoder.tradeInputDevice(this.tradeInputDevice(), 0, tradeInputDeviceLength());
        }

        if (hasOrderInputDevice())
        {
            encoder.orderInputDevice(this.orderInputDevice(), 0, orderInputDeviceLength());
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

        if (hasOrdType())
        {
            encoder.ordType(this.ordType());
        }

        if (hasExecInst())
        {
            encoder.execInst(this.execInst(), 0, execInstLength());
        }

        if (hasTransBkdTime())
        {
            encoder.transBkdTimeAsCopy(this.transBkdTime(), 0, transBkdTimeLength());
        }

        if (hasTradingSessionID())
        {
            encoder.tradingSessionID(this.tradingSessionID(), 0, tradingSessionIDLength());
        }

        if (hasTradingSessionSubID())
        {
            encoder.tradingSessionSubID(this.tradingSessionSubID(), 0, tradingSessionSubIDLength());
        }

        if (hasTimeBracket())
        {
            encoder.timeBracket(this.timeBracket(), 0, timeBracketLength());
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


        if (hasGrossTradeAmt())
        {
            encoder.grossTradeAmt(this.grossTradeAmt());
        }

        if (hasNumDaysInterest())
        {
            encoder.numDaysInterest(this.numDaysInterest());
        }

        if (hasExDate())
        {
            encoder.exDateAsCopy(this.exDate(), 0, exDateLength());
        }

        if (hasAccruedInterestRate())
        {
            encoder.accruedInterestRate(this.accruedInterestRate());
        }

        if (hasAccruedInterestAmt())
        {
            encoder.accruedInterestAmt(this.accruedInterestAmt());
        }

        if (hasInterestAtMaturity())
        {
            encoder.interestAtMaturity(this.interestAtMaturity());
        }

        if (hasEndAccruedInterestAmt())
        {
            encoder.endAccruedInterestAmt(this.endAccruedInterestAmt());
        }

        if (hasStartCash())
        {
            encoder.startCash(this.startCash());
        }

        if (hasEndCash())
        {
            encoder.endCash(this.endCash());
        }

        if (hasConcession())
        {
            encoder.concession(this.concession());
        }

        if (hasTotalTakedown())
        {
            encoder.totalTakedown(this.totalTakedown());
        }

        if (hasNetMoney())
        {
            encoder.netMoney(this.netMoney());
        }

        if (hasSettlCurrAmt())
        {
            encoder.settlCurrAmt(this.settlCurrAmt());
        }

        if (hasSettlCurrency())
        {
            encoder.settlCurrency(this.settlCurrency(), 0, settlCurrencyLength());
        }

        if (hasSettlCurrFxRate())
        {
            encoder.settlCurrFxRate(this.settlCurrFxRate());
        }

        if (hasSettlCurrFxRateCalc())
        {
            encoder.settlCurrFxRateCalc(this.settlCurrFxRateCalc());
        }

        if (hasPositionEffect())
        {
            encoder.positionEffect(this.positionEffect());
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

        if (hasSideMultiLegReportingType())
        {
            encoder.sideMultiLegReportingType(this.sideMultiLegReportingType());
        }

        if (hasNoContAmtsGroupCounter)
        {
            final int size = this.noContAmtsGroupCounter;
            ContAmtsGroupDecoder contAmtsGroup = this.contAmtsGroup;
            ContAmtsGroupEncoder contAmtsGroupEncoder = encoder.contAmtsGroup(size);
            for (int i = 0; i < size; i++)
            {
                if (contAmtsGroup != null)
                {
                    contAmtsGroup.toEncoder(contAmtsGroupEncoder);
                    contAmtsGroup = contAmtsGroup.next();
                    contAmtsGroupEncoder = contAmtsGroupEncoder.next();
                }
            }
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


        if (hasNoMiscFeesGroupCounter)
        {
            final int size = this.noMiscFeesGroupCounter;
            MiscFeesGroupDecoder miscFeesGroup = this.miscFeesGroup;
            MiscFeesGroupEncoder miscFeesGroupEncoder = encoder.miscFeesGroup(size);
            for (int i = 0; i < size; i++)
            {
                if (miscFeesGroup != null)
                {
                    miscFeesGroup.toEncoder(miscFeesGroupEncoder);
                    miscFeesGroup = miscFeesGroup.next();
                    miscFeesGroupEncoder = miscFeesGroupEncoder.next();
                }
            }
        }

        if (hasExchangeRule())
        {
            encoder.exchangeRule(this.exchangeRule(), 0, exchangeRuleLength());
        }

        if (hasTradeAllocIndicator())
        {
            encoder.tradeAllocIndicator(this.tradeAllocIndicator());
        }

        if (hasPreallocMethod())
        {
            encoder.preallocMethod(this.preallocMethod());
        }

        if (hasAllocID())
        {
            encoder.allocID(this.allocID(), 0, allocIDLength());
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
        return encoder;
    }

}
    @Generated("uk.co.real_logic.artio")
    public class SidesGroupIterator implements Iterable<SidesGroupDecoder>, java.util.Iterator<SidesGroupDecoder>
    {
        private final TradeCaptureReportDecoder parent;
        private int remainder;
        private SidesGroupDecoder current;

        public SidesGroupIterator(final TradeCaptureReportDecoder parent)
        {
            this.parent = parent;
        }

        public boolean hasNext()
        {
            return remainder > 0 && current != null;
        }

        public SidesGroupDecoder next()
        {
            remainder--;
            final SidesGroupDecoder value = current;
            current = current.next();
            return value;
        }

        public int numberFieldValue()
        {
            return parent.hasNoSidesGroupCounter() ? parent.noSidesGroupCounter() : 0;
        }

        public void reset()
        {
            remainder = numberFieldValue();
            current = parent.sidesGroup();
        }

        public SidesGroupIterator iterator()
        {
            reset();
            return this;
        }

    }


    private SidesGroupDecoder sidesGroup = null;
    public SidesGroupDecoder sidesGroup()
    {
        return sidesGroup;
    }

    private int noSidesGroupCounter = MISSING_INT;

    private boolean hasNoSidesGroupCounter;

    /* NoSidesGroupCounter = 552 */
    public int noSidesGroupCounter()
    {
        if (!hasNoSidesGroupCounter)
        {
            throw new IllegalArgumentException("No value for optional field: NoSidesGroupCounter");
        }

        return noSidesGroupCounter;
    }

    public boolean hasNoSidesGroupCounter()
    {
        return hasNoSidesGroupCounter;
    }




    private SidesGroupIterator sidesGroupIterator = new SidesGroupIterator(this);
    public SidesGroupIterator sidesGroupIterator()
    {
        return sidesGroupIterator.iterator();
    }

    private boolean copyMsgIndicator;

    private boolean hasCopyMsgIndicator;

    /* CopyMsgIndicator = 797 */
    public boolean copyMsgIndicator()
    {
        if (!hasCopyMsgIndicator)
        {
            throw new IllegalArgumentException("No value for optional field: CopyMsgIndicator");
        }

        return copyMsgIndicator;
    }

    public boolean hasCopyMsgIndicator()
    {
        return hasCopyMsgIndicator;
    }



    private boolean publishTrdIndicator;

    private boolean hasPublishTrdIndicator;

    /* PublishTrdIndicator = 852 */
    public boolean publishTrdIndicator()
    {
        if (!hasPublishTrdIndicator)
        {
            throw new IllegalArgumentException("No value for optional field: PublishTrdIndicator");
        }

        return publishTrdIndicator;
    }

    public boolean hasPublishTrdIndicator()
    {
        return hasPublishTrdIndicator;
    }



    private int shortSaleReason = MISSING_INT;

    private boolean hasShortSaleReason;

    /* ShortSaleReason = 853 */
    public int shortSaleReason()
    {
        if (!hasShortSaleReason)
        {
            throw new IllegalArgumentException("No value for optional field: ShortSaleReason");
        }

        return shortSaleReason;
    }

    public boolean hasShortSaleReason()
    {
        return hasShortSaleReason;
    }



    private final CharArrayWrapper shortSaleReasonWrapper = new CharArrayWrapper();
    /* ShortSaleReason = 853 */
    public ShortSaleReason shortSaleReasonAsEnum()
    {
        if (!hasShortSaleReason)
 return ShortSaleReason.NULL_VAL;
        return ShortSaleReason.decode(shortSaleReason);
    }

    public int decode(final AsciiBuffer buffer, final int offset, final int length)
    {
        // Decode TradeCaptureReport
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
            case Constants.TRADE_REPORT_ID:
                tradeReportID = buffer.getChars(tradeReportID, valueOffset, valueLength);
                tradeReportIDOffset = valueOffset;
                tradeReportIDLength = valueLength;
                break;

            case Constants.TRADE_REPORT_TRANS_TYPE:
                hasTradeReportTransType = true;
                tradeReportTransType = getInt(buffer, valueOffset, endOfField, 487, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.TRADE_REPORT_TYPE:
                hasTradeReportType = true;
                tradeReportType = getInt(buffer, valueOffset, endOfField, 856, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.TRADE_REQUEST_ID:
                hasTradeRequestID = true;
                tradeRequestID = buffer.getChars(tradeRequestID, valueOffset, valueLength);
                tradeRequestIDOffset = valueOffset;
                tradeRequestIDLength = valueLength;
                break;

            case Constants.TRD_TYPE:
                hasTrdType = true;
                trdType = getInt(buffer, valueOffset, endOfField, 828, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.TRD_SUB_TYPE:
                hasTrdSubType = true;
                trdSubType = getInt(buffer, valueOffset, endOfField, 829, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.SECONDARY_TRD_TYPE:
                hasSecondaryTrdType = true;
                secondaryTrdType = getInt(buffer, valueOffset, endOfField, 855, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.TRANSFER_REASON:
                hasTransferReason = true;
                transferReason = buffer.getChars(transferReason, valueOffset, valueLength);
                transferReasonOffset = valueOffset;
                transferReasonLength = valueLength;
                break;

            case Constants.EXEC_TYPE:
                hasExecType = true;
                execType = buffer.getChar(valueOffset);
                break;

            case Constants.TOT_NUM_TRADE_REPORTS:
                hasTotNumTradeReports = true;
                totNumTradeReports = getInt(buffer, valueOffset, endOfField, 748, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.LAST_RPT_REQUESTED:
                hasLastRptRequested = true;
                lastRptRequested = buffer.getBoolean(valueOffset);
                break;

            case Constants.UNSOLICITED_INDICATOR:
                hasUnsolicitedIndicator = true;
                unsolicitedIndicator = buffer.getBoolean(valueOffset);
                break;

            case Constants.SUBSCRIPTION_REQUEST_TYPE:
                hasSubscriptionRequestType = true;
                subscriptionRequestType = buffer.getChar(valueOffset);
                break;

            case Constants.TRADE_REPORT_REF_ID:
                hasTradeReportRefID = true;
                tradeReportRefID = buffer.getChars(tradeReportRefID, valueOffset, valueLength);
                tradeReportRefIDOffset = valueOffset;
                tradeReportRefIDLength = valueLength;
                break;

            case Constants.SECONDARY_TRADE_REPORT_REF_ID:
                hasSecondaryTradeReportRefID = true;
                secondaryTradeReportRefID = buffer.getChars(secondaryTradeReportRefID, valueOffset, valueLength);
                secondaryTradeReportRefIDOffset = valueOffset;
                secondaryTradeReportRefIDLength = valueLength;
                break;

            case Constants.SECONDARY_TRADE_REPORT_ID:
                hasSecondaryTradeReportID = true;
                secondaryTradeReportID = buffer.getChars(secondaryTradeReportID, valueOffset, valueLength);
                secondaryTradeReportIDOffset = valueOffset;
                secondaryTradeReportIDLength = valueLength;
                break;

            case Constants.TRADE_LINK_ID:
                hasTradeLinkID = true;
                tradeLinkID = buffer.getChars(tradeLinkID, valueOffset, valueLength);
                tradeLinkIDOffset = valueOffset;
                tradeLinkIDLength = valueLength;
                break;

            case Constants.TRD_MATCH_ID:
                hasTrdMatchID = true;
                trdMatchID = buffer.getChars(trdMatchID, valueOffset, valueLength);
                trdMatchIDOffset = valueOffset;
                trdMatchIDLength = valueLength;
                break;

            case Constants.EXEC_ID:
                hasExecID = true;
                execID = buffer.getChars(execID, valueOffset, valueLength);
                execIDOffset = valueOffset;
                execIDLength = valueLength;
                break;

            case Constants.ORD_STATUS:
                hasOrdStatus = true;
                ordStatus = buffer.getChar(valueOffset);
                break;

            case Constants.SECONDARY_EXEC_ID:
                hasSecondaryExecID = true;
                secondaryExecID = buffer.getChars(secondaryExecID, valueOffset, valueLength);
                secondaryExecIDOffset = valueOffset;
                secondaryExecIDLength = valueLength;
                break;

            case Constants.EXEC_RESTATEMENT_REASON:
                hasExecRestatementReason = true;
                execRestatementReason = getInt(buffer, valueOffset, endOfField, 378, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.PREVIOUSLY_REPORTED:
                previouslyReported = buffer.getBoolean(valueOffset);
                break;

            case Constants.PRICE_TYPE:
                hasPriceType = true;
                priceType = getInt(buffer, valueOffset, endOfField, 423, CODEC_VALIDATION_ENABLED);
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


            case Constants.AGREEMENT_DESC:
                hasAgreementDesc = true;
                agreementDesc = buffer.getChars(agreementDesc, valueOffset, valueLength);
                agreementDescOffset = valueOffset;
                agreementDescLength = valueLength;
                break;

            case Constants.AGREEMENT_ID:
                hasAgreementID = true;
                agreementID = buffer.getChars(agreementID, valueOffset, valueLength);
                agreementIDOffset = valueOffset;
                agreementIDLength = valueLength;
                break;

            case Constants.AGREEMENT_DATE:
                hasAgreementDate = true;
                agreementDate = buffer.getBytes(agreementDate, valueOffset, valueLength);
                agreementDateOffset = valueOffset;
                agreementDateLength = valueLength;
                break;

            case Constants.AGREEMENT_CURRENCY:
                hasAgreementCurrency = true;
                agreementCurrency = buffer.getChars(agreementCurrency, valueOffset, valueLength);
                agreementCurrencyOffset = valueOffset;
                agreementCurrencyLength = valueLength;
                break;

            case Constants.TERMINATION_TYPE:
                hasTerminationType = true;
                terminationType = getInt(buffer, valueOffset, endOfField, 788, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.START_DATE:
                hasStartDate = true;
                startDate = buffer.getBytes(startDate, valueOffset, valueLength);
                startDateOffset = valueOffset;
                startDateLength = valueLength;
                break;

            case Constants.END_DATE:
                hasEndDate = true;
                endDate = buffer.getBytes(endDate, valueOffset, valueLength);
                endDateOffset = valueOffset;
                endDateLength = valueLength;
                break;

            case Constants.DELIVERY_TYPE:
                hasDeliveryType = true;
                deliveryType = getInt(buffer, valueOffset, endOfField, 919, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.MARGIN_RATIO:
                hasMarginRatio = true;
                marginRatio = getFloat(buffer, marginRatio, valueOffset, valueLength, 898, CODEC_VALIDATION_ENABLED);
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


            case Constants.QTY_TYPE:
                hasQtyType = true;
                qtyType = getInt(buffer, valueOffset, endOfField, 854, CODEC_VALIDATION_ENABLED);
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

            case Constants.UNDERLYING_TRADING_SESSION_ID:
                hasUnderlyingTradingSessionID = true;
                underlyingTradingSessionID = buffer.getChars(underlyingTradingSessionID, valueOffset, valueLength);
                underlyingTradingSessionIDOffset = valueOffset;
                underlyingTradingSessionIDLength = valueLength;
                break;

            case Constants.UNDERLYING_TRADING_SESSION_SUB_ID:
                hasUnderlyingTradingSessionSubID = true;
                underlyingTradingSessionSubID = buffer.getChars(underlyingTradingSessionSubID, valueOffset, valueLength);
                underlyingTradingSessionSubIDOffset = valueOffset;
                underlyingTradingSessionSubIDLength = valueLength;
                break;

            case Constants.LAST_QTY:
                lastQty = getFloat(buffer, lastQty, valueOffset, valueLength, 32, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.LAST_PX:
                lastPx = getFloat(buffer, lastPx, valueOffset, valueLength, 31, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.LAST_PAR_PX:
                hasLastParPx = true;
                lastParPx = getFloat(buffer, lastParPx, valueOffset, valueLength, 669, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.LAST_SPOT_RATE:
                hasLastSpotRate = true;
                lastSpotRate = getFloat(buffer, lastSpotRate, valueOffset, valueLength, 194, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.LAST_FORWARD_POINTS:
                hasLastForwardPoints = true;
                lastForwardPoints = getFloat(buffer, lastForwardPoints, valueOffset, valueLength, 195, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.LAST_MKT:
                hasLastMkt = true;
                lastMkt = buffer.getChars(lastMkt, valueOffset, valueLength);
                lastMktOffset = valueOffset;
                lastMktLength = valueLength;
                break;

            case Constants.TRADE_DATE:
                tradeDate = buffer.getBytes(tradeDate, valueOffset, valueLength);
                tradeDateOffset = valueOffset;
                tradeDateLength = valueLength;
                break;

            case Constants.CLEARING_BUSINESS_DATE:
                hasClearingBusinessDate = true;
                clearingBusinessDate = buffer.getBytes(clearingBusinessDate, valueOffset, valueLength);
                clearingBusinessDateOffset = valueOffset;
                clearingBusinessDateLength = valueLength;
                break;

            case Constants.AVG_PX:
                hasAvgPx = true;
                avgPx = getFloat(buffer, avgPx, valueOffset, valueLength, 6, CODEC_VALIDATION_ENABLED);
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


            case Constants.AVG_PX_INDICATOR:
                hasAvgPxIndicator = true;
                avgPxIndicator = getInt(buffer, valueOffset, endOfField, 819, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.NO_POS_AMT:
                noPosAmt = getInt(buffer, valueOffset, endOfField, 753, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.POS_AMT_TYPE:
                posAmtType = buffer.getChars(posAmtType, valueOffset, valueLength);
                posAmtTypeOffset = valueOffset;
                posAmtTypeLength = valueLength;
                break;

            case Constants.POS_AMT:
                posAmt = getFloat(buffer, posAmt, valueOffset, valueLength, 708, CODEC_VALIDATION_ENABLED);
                break;


            case Constants.MULTI_LEG_REPORTING_TYPE:
                hasMultiLegReportingType = true;
                multiLegReportingType = buffer.getChar(valueOffset);
                break;

            case Constants.TRADE_LEG_REF_ID:
                hasTradeLegRefID = true;
                tradeLegRefID = buffer.getChars(tradeLegRefID, valueOffset, valueLength);
                tradeLegRefIDOffset = valueOffset;
                tradeLegRefIDLength = valueLength;
                break;

            case Constants.NO_LEGS_GROUP_COUNTER:
                hasNoLegsGroupCounter = true;
                noLegsGroupCounter = getInt(buffer, valueOffset, endOfField, 555, CODEC_VALIDATION_ENABLED);
                if (legsGroup == null)
                {
                    legsGroup = new LegsGroupDecoder(trailer, messageFields);
                }
                LegsGroupDecoder legsGroupCurrent = legsGroup;
                position = endOfField + 1;
                final int noLegsGroupCounter = this.noLegsGroupCounter;
                for (int i = 0; i < noLegsGroupCounter && position < end; i++)
                {
                    if (legsGroupCurrent != null)
                    {
                        position += legsGroupCurrent.decode(buffer, position, end - position);
                        legsGroupCurrent = legsGroupCurrent.next();
                    }
                }
                if (CODEC_VALIDATION_ENABLED)
                {
                    final int checkEqualsPosition = buffer.scan(position, end, '=');
                    if (checkEqualsPosition != AsciiBuffer.UNKNOWN_INDEX)
                    {
                        final int checkTag = buffer.getInt(position, checkEqualsPosition);
                        if (legsGroup.ALL_GROUP_FIELDS.contains(checkTag))
                        {
                            invalidTagId = tag;
                            rejectReason = 16;
                            return position;
                        }
                    }
                }
                break;

            case Constants.TRANSACT_TIME:
                transactTime = buffer.getBytes(transactTime, valueOffset, valueLength);
                transactTimeOffset = valueOffset;
                transactTimeLength = valueLength;
                break;

            case Constants.NO_TRD_REG_TIMESTAMPS_GROUP_COUNTER:
                hasNoTrdRegTimestampsGroupCounter = true;
                noTrdRegTimestampsGroupCounter = getInt(buffer, valueOffset, endOfField, 768, CODEC_VALIDATION_ENABLED);
                if (trdRegTimestampsGroup == null)
                {
                    trdRegTimestampsGroup = new TrdRegTimestampsGroupDecoder(trailer, messageFields);
                }
                TrdRegTimestampsGroupDecoder trdRegTimestampsGroupCurrent = trdRegTimestampsGroup;
                position = endOfField + 1;
                final int noTrdRegTimestampsGroupCounter = this.noTrdRegTimestampsGroupCounter;
                for (int i = 0; i < noTrdRegTimestampsGroupCounter && position < end; i++)
                {
                    if (trdRegTimestampsGroupCurrent != null)
                    {
                        position += trdRegTimestampsGroupCurrent.decode(buffer, position, end - position);
                        trdRegTimestampsGroupCurrent = trdRegTimestampsGroupCurrent.next();
                    }
                }
                if (CODEC_VALIDATION_ENABLED)
                {
                    final int checkEqualsPosition = buffer.scan(position, end, '=');
                    if (checkEqualsPosition != AsciiBuffer.UNKNOWN_INDEX)
                    {
                        final int checkTag = buffer.getInt(position, checkEqualsPosition);
                        if (trdRegTimestampsGroup.ALL_GROUP_FIELDS.contains(checkTag))
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

            case Constants.MATCH_STATUS:
                hasMatchStatus = true;
                matchStatus = buffer.getChar(valueOffset);
                break;

            case Constants.MATCH_TYPE:
                hasMatchType = true;
                matchType = buffer.getChars(matchType, valueOffset, valueLength);
                matchTypeOffset = valueOffset;
                matchTypeLength = valueLength;
                break;

            case Constants.NO_SIDES_GROUP_COUNTER:
                hasNoSidesGroupCounter = true;
                noSidesGroupCounter = getInt(buffer, valueOffset, endOfField, 552, CODEC_VALIDATION_ENABLED);
                if (sidesGroup == null)
                {
                    sidesGroup = new SidesGroupDecoder(trailer, messageFields);
                }
                SidesGroupDecoder sidesGroupCurrent = sidesGroup;
                position = endOfField + 1;
                final int noSidesGroupCounter = this.noSidesGroupCounter;
                for (int i = 0; i < noSidesGroupCounter && position < end; i++)
                {
                    if (sidesGroupCurrent != null)
                    {
                        position += sidesGroupCurrent.decode(buffer, position, end - position);
                        sidesGroupCurrent = sidesGroupCurrent.next();
                    }
                }
                if (CODEC_VALIDATION_ENABLED)
                {
                    final int checkEqualsPosition = buffer.scan(position, end, '=');
                    if (checkEqualsPosition != AsciiBuffer.UNKNOWN_INDEX)
                    {
                        final int checkTag = buffer.getInt(position, checkEqualsPosition);
                        if (sidesGroup.ALL_GROUP_FIELDS.contains(checkTag))
                        {
                            invalidTagId = tag;
                            rejectReason = 16;
                            return position;
                        }
                    }
                }
                break;

            case Constants.COPY_MSG_INDICATOR:
                hasCopyMsgIndicator = true;
                copyMsgIndicator = buffer.getBoolean(valueOffset);
                break;

            case Constants.PUBLISH_TRD_INDICATOR:
                hasPublishTrdIndicator = true;
                publishTrdIndicator = buffer.getBoolean(valueOffset);
                break;

            case Constants.SHORT_SALE_REASON:
                hasShortSaleReason = true;
                shortSaleReason = getInt(buffer, valueOffset, endOfField, 853, CODEC_VALIDATION_ENABLED);
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
        this.resetTradeReportID();
        this.resetTradeReportTransType();
        this.resetTradeReportType();
        this.resetTradeRequestID();
        this.resetTrdType();
        this.resetTrdSubType();
        this.resetSecondaryTrdType();
        this.resetTransferReason();
        this.resetExecType();
        this.resetTotNumTradeReports();
        this.resetLastRptRequested();
        this.resetUnsolicitedIndicator();
        this.resetSubscriptionRequestType();
        this.resetTradeReportRefID();
        this.resetSecondaryTradeReportRefID();
        this.resetSecondaryTradeReportID();
        this.resetTradeLinkID();
        this.resetTrdMatchID();
        this.resetExecID();
        this.resetOrdStatus();
        this.resetSecondaryExecID();
        this.resetExecRestatementReason();
        this.resetPreviouslyReported();
        this.resetPriceType();
        this.resetQtyType();
        this.resetUnderlyingTradingSessionID();
        this.resetUnderlyingTradingSessionSubID();
        this.resetLastQty();
        this.resetLastPx();
        this.resetLastParPx();
        this.resetLastSpotRate();
        this.resetLastForwardPoints();
        this.resetLastMkt();
        this.resetTradeDate();
        this.resetClearingBusinessDate();
        this.resetAvgPx();
        this.resetAvgPxIndicator();
        this.resetMultiLegReportingType();
        this.resetTradeLegRefID();
        this.resetTransactTime();
        this.resetSettlType();
        this.resetSettlDate();
        this.resetMatchStatus();
        this.resetMatchType();
        this.resetCopyMsgIndicator();
        this.resetPublishTrdIndicator();
        this.resetShortSaleReason();
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
        this.resetAgreementDesc();
        this.resetAgreementID();
        this.resetAgreementDate();
        this.resetAgreementCurrency();
        this.resetTerminationType();
        this.resetStartDate();
        this.resetEndDate();
        this.resetDeliveryType();
        this.resetMarginRatio();
        this.resetOrderQty();
        this.resetCashOrderQty();
        this.resetOrderPercent();
        this.resetRoundingDirection();
        this.resetRoundingModulus();
        this.resetYieldType();
        this.resetYield();
        this.resetYieldCalcDate();
        this.resetYieldRedemptionDate();
        this.resetYieldRedemptionPrice();
        this.resetYieldRedemptionPriceType();
        this.resetSpread();
        this.resetBenchmarkCurveCurrency();
        this.resetBenchmarkCurveName();
        this.resetBenchmarkCurvePoint();
        this.resetBenchmarkPrice();
        this.resetBenchmarkPriceType();
        this.resetBenchmarkSecurityID();
        this.resetBenchmarkSecurityIDSource();
        this.resetNoPosAmt();
        this.resetPosAmtType();
        this.resetPosAmt();
        this.resetTrdRegTimestampsGroup();
        this.resetUnderlyingsGroup();
        this.resetLegsGroup();
        this.resetSidesGroup();
    }

    public void resetTradeReportID()
    {
        tradeReportIDOffset = 0;
        tradeReportIDLength = 0;
    }

    public void resetTradeReportTransType()
    {
        hasTradeReportTransType = false;
    }

    public void resetTradeReportType()
    {
        hasTradeReportType = false;
    }

    public void resetTradeRequestID()
    {
        hasTradeRequestID = false;
    }

    public void resetTrdType()
    {
        hasTrdType = false;
    }

    public void resetTrdSubType()
    {
        hasTrdSubType = false;
    }

    public void resetSecondaryTrdType()
    {
        hasSecondaryTrdType = false;
    }

    public void resetTransferReason()
    {
        hasTransferReason = false;
    }

    public void resetExecType()
    {
        hasExecType = false;
    }

    public void resetTotNumTradeReports()
    {
        hasTotNumTradeReports = false;
    }

    public void resetLastRptRequested()
    {
        hasLastRptRequested = false;
    }

    public void resetUnsolicitedIndicator()
    {
        hasUnsolicitedIndicator = false;
    }

    public void resetSubscriptionRequestType()
    {
        hasSubscriptionRequestType = false;
    }

    public void resetTradeReportRefID()
    {
        hasTradeReportRefID = false;
    }

    public void resetSecondaryTradeReportRefID()
    {
        hasSecondaryTradeReportRefID = false;
    }

    public void resetSecondaryTradeReportID()
    {
        hasSecondaryTradeReportID = false;
    }

    public void resetTradeLinkID()
    {
        hasTradeLinkID = false;
    }

    public void resetTrdMatchID()
    {
        hasTrdMatchID = false;
    }

    public void resetExecID()
    {
        hasExecID = false;
    }

    public void resetOrdStatus()
    {
        hasOrdStatus = false;
    }

    public void resetSecondaryExecID()
    {
        hasSecondaryExecID = false;
    }

    public void resetExecRestatementReason()
    {
        hasExecRestatementReason = false;
    }

    public void resetPreviouslyReported()
    {
        previouslyReported = false;
    }

    public void resetPriceType()
    {
        hasPriceType = false;
    }

    public void resetQtyType()
    {
        hasQtyType = false;
    }

    public void resetUnderlyingTradingSessionID()
    {
        hasUnderlyingTradingSessionID = false;
    }

    public void resetUnderlyingTradingSessionSubID()
    {
        hasUnderlyingTradingSessionSubID = false;
    }

    public void resetLastQty()
    {
        lastQty.reset();
    }

    public void resetLastPx()
    {
        lastPx.reset();
    }

    public void resetLastParPx()
    {
        hasLastParPx = false;
    }

    public void resetLastSpotRate()
    {
        hasLastSpotRate = false;
    }

    public void resetLastForwardPoints()
    {
        hasLastForwardPoints = false;
    }

    public void resetLastMkt()
    {
        hasLastMkt = false;
    }

    public void resetTradeDate()
    {
    }

    public void resetClearingBusinessDate()
    {
        hasClearingBusinessDate = false;
    }

    public void resetAvgPx()
    {
        hasAvgPx = false;
    }

    public void resetAvgPxIndicator()
    {
        hasAvgPxIndicator = false;
    }

    public void resetMultiLegReportingType()
    {
        hasMultiLegReportingType = false;
    }

    public void resetTradeLegRefID()
    {
        hasTradeLegRefID = false;
    }

    public void resetTransactTime()
    {
    }

    public void resetSettlType()
    {
        hasSettlType = false;
    }

    public void resetSettlDate()
    {
        hasSettlDate = false;
    }

    public void resetMatchStatus()
    {
        hasMatchStatus = false;
    }

    public void resetMatchType()
    {
        hasMatchType = false;
    }

    public void resetCopyMsgIndicator()
    {
        hasCopyMsgIndicator = false;
    }

    public void resetPublishTrdIndicator()
    {
        hasPublishTrdIndicator = false;
    }

    public void resetShortSaleReason()
    {
        hasShortSaleReason = false;
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

    public void resetAgreementDesc()
    {
        hasAgreementDesc = false;
    }

    public void resetAgreementID()
    {
        hasAgreementID = false;
    }

    public void resetAgreementDate()
    {
        hasAgreementDate = false;
    }

    public void resetAgreementCurrency()
    {
        hasAgreementCurrency = false;
    }

    public void resetTerminationType()
    {
        hasTerminationType = false;
    }

    public void resetStartDate()
    {
        hasStartDate = false;
    }

    public void resetEndDate()
    {
        hasEndDate = false;
    }

    public void resetDeliveryType()
    {
        hasDeliveryType = false;
    }

    public void resetMarginRatio()
    {
        hasMarginRatio = false;
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

    public void resetNoPosAmt()
    {
        noPosAmt = MISSING_INT;
    }

    public void resetPosAmtType()
    {
        posAmtTypeOffset = 0;
        posAmtTypeLength = 0;
    }

    public void resetPosAmt()
    {
        posAmt.reset();
    }

    public void resetTrdRegTimestampsGroup()
    {
        for (final TrdRegTimestampsGroupDecoder trdRegTimestampsGroupDecoder : trdRegTimestampsGroupIterator.iterator())
        {
            trdRegTimestampsGroupDecoder.reset();
            if (trdRegTimestampsGroupDecoder.next() == null)
            {
                break;
            }
        }
        noTrdRegTimestampsGroupCounter = MISSING_INT;
        hasNoTrdRegTimestampsGroupCounter = false;
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

    public void resetLegsGroup()
    {
        for (final LegsGroupDecoder legsGroupDecoder : legsGroupIterator.iterator())
        {
            legsGroupDecoder.reset();
            if (legsGroupDecoder.next() == null)
            {
                break;
            }
        }
        noLegsGroupCounter = MISSING_INT;
        hasNoLegsGroupCounter = false;
    }

    public void resetSidesGroup()
    {
        for (final SidesGroupDecoder sidesGroupDecoder : sidesGroupIterator.iterator())
        {
            sidesGroupDecoder.reset();
            if (sidesGroupDecoder.next() == null)
            {
                break;
            }
        }
        noSidesGroupCounter = MISSING_INT;
        hasNoSidesGroupCounter = false;
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
        builder.append("\"MessageName\": \"TradeCaptureReport\",\n");
        builder.append("  \"header\": ");
        header.appendTo(builder, level + 1);
        builder.append("\n");
        indent(builder, level);
        builder.append("\"TradeReportID\": \"");
        builder.append(this.tradeReportID(), 0, tradeReportIDLength());
        builder.append("\",\n");

        if (hasTradeReportTransType())
        {
            indent(builder, level);
            builder.append("\"TradeReportTransType\": \"");
            builder.append(tradeReportTransType);
            builder.append("\",\n");
        }

        if (hasTradeReportType())
        {
            indent(builder, level);
            builder.append("\"TradeReportType\": \"");
            builder.append(tradeReportType);
            builder.append("\",\n");
        }

        if (hasTradeRequestID())
        {
            indent(builder, level);
            builder.append("\"TradeRequestID\": \"");
            builder.append(this.tradeRequestID(), 0, tradeRequestIDLength());
            builder.append("\",\n");
        }

        if (hasTrdType())
        {
            indent(builder, level);
            builder.append("\"TrdType\": \"");
            builder.append(trdType);
            builder.append("\",\n");
        }

        if (hasTrdSubType())
        {
            indent(builder, level);
            builder.append("\"TrdSubType\": \"");
            builder.append(trdSubType);
            builder.append("\",\n");
        }

        if (hasSecondaryTrdType())
        {
            indent(builder, level);
            builder.append("\"SecondaryTrdType\": \"");
            builder.append(secondaryTrdType);
            builder.append("\",\n");
        }

        if (hasTransferReason())
        {
            indent(builder, level);
            builder.append("\"TransferReason\": \"");
            builder.append(this.transferReason(), 0, transferReasonLength());
            builder.append("\",\n");
        }

        if (hasExecType())
        {
            indent(builder, level);
            builder.append("\"ExecType\": \"");
            builder.append(execType);
            builder.append("\",\n");
        }

        if (hasTotNumTradeReports())
        {
            indent(builder, level);
            builder.append("\"TotNumTradeReports\": \"");
            builder.append(totNumTradeReports);
            builder.append("\",\n");
        }

        if (hasLastRptRequested())
        {
            indent(builder, level);
            builder.append("\"LastRptRequested\": \"");
            builder.append(lastRptRequested);
            builder.append("\",\n");
        }

        if (hasUnsolicitedIndicator())
        {
            indent(builder, level);
            builder.append("\"UnsolicitedIndicator\": \"");
            builder.append(unsolicitedIndicator);
            builder.append("\",\n");
        }

        if (hasSubscriptionRequestType())
        {
            indent(builder, level);
            builder.append("\"SubscriptionRequestType\": \"");
            builder.append(subscriptionRequestType);
            builder.append("\",\n");
        }

        if (hasTradeReportRefID())
        {
            indent(builder, level);
            builder.append("\"TradeReportRefID\": \"");
            builder.append(this.tradeReportRefID(), 0, tradeReportRefIDLength());
            builder.append("\",\n");
        }

        if (hasSecondaryTradeReportRefID())
        {
            indent(builder, level);
            builder.append("\"SecondaryTradeReportRefID\": \"");
            builder.append(this.secondaryTradeReportRefID(), 0, secondaryTradeReportRefIDLength());
            builder.append("\",\n");
        }

        if (hasSecondaryTradeReportID())
        {
            indent(builder, level);
            builder.append("\"SecondaryTradeReportID\": \"");
            builder.append(this.secondaryTradeReportID(), 0, secondaryTradeReportIDLength());
            builder.append("\",\n");
        }

        if (hasTradeLinkID())
        {
            indent(builder, level);
            builder.append("\"TradeLinkID\": \"");
            builder.append(this.tradeLinkID(), 0, tradeLinkIDLength());
            builder.append("\",\n");
        }

        if (hasTrdMatchID())
        {
            indent(builder, level);
            builder.append("\"TrdMatchID\": \"");
            builder.append(this.trdMatchID(), 0, trdMatchIDLength());
            builder.append("\",\n");
        }

        if (hasExecID())
        {
            indent(builder, level);
            builder.append("\"ExecID\": \"");
            builder.append(this.execID(), 0, execIDLength());
            builder.append("\",\n");
        }

        if (hasOrdStatus())
        {
            indent(builder, level);
            builder.append("\"OrdStatus\": \"");
            builder.append(ordStatus);
            builder.append("\",\n");
        }

        if (hasSecondaryExecID())
        {
            indent(builder, level);
            builder.append("\"SecondaryExecID\": \"");
            builder.append(this.secondaryExecID(), 0, secondaryExecIDLength());
            builder.append("\",\n");
        }

        if (hasExecRestatementReason())
        {
            indent(builder, level);
            builder.append("\"ExecRestatementReason\": \"");
            builder.append(execRestatementReason);
            builder.append("\",\n");
        }

        indent(builder, level);
        builder.append("\"PreviouslyReported\": \"");
        builder.append(previouslyReported);
        builder.append("\",\n");

        if (hasPriceType())
        {
            indent(builder, level);
            builder.append("\"PriceType\": \"");
            builder.append(priceType);
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

        if (hasAgreementDesc())
        {
            indent(builder, level);
            builder.append("\"AgreementDesc\": \"");
            builder.append(this.agreementDesc(), 0, agreementDescLength());
            builder.append("\",\n");
        }

        if (hasAgreementID())
        {
            indent(builder, level);
            builder.append("\"AgreementID\": \"");
            builder.append(this.agreementID(), 0, agreementIDLength());
            builder.append("\",\n");
        }

        if (hasAgreementDate())
        {
            indent(builder, level);
            builder.append("\"AgreementDate\": \"");
            appendData(builder, agreementDate, agreementDateLength);
            builder.append("\",\n");
        }

        if (hasAgreementCurrency())
        {
            indent(builder, level);
            builder.append("\"AgreementCurrency\": \"");
            builder.append(this.agreementCurrency(), 0, agreementCurrencyLength());
            builder.append("\",\n");
        }

        if (hasTerminationType())
        {
            indent(builder, level);
            builder.append("\"TerminationType\": \"");
            builder.append(terminationType);
            builder.append("\",\n");
        }

        if (hasStartDate())
        {
            indent(builder, level);
            builder.append("\"StartDate\": \"");
            appendData(builder, startDate, startDateLength);
            builder.append("\",\n");
        }

        if (hasEndDate())
        {
            indent(builder, level);
            builder.append("\"EndDate\": \"");
            appendData(builder, endDate, endDateLength);
            builder.append("\",\n");
        }

        if (hasDeliveryType())
        {
            indent(builder, level);
            builder.append("\"DeliveryType\": \"");
            builder.append(deliveryType);
            builder.append("\",\n");
        }

        if (hasMarginRatio())
        {
            indent(builder, level);
            builder.append("\"MarginRatio\": \"");
            marginRatio.appendTo(builder);
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

        if (hasQtyType())
        {
            indent(builder, level);
            builder.append("\"QtyType\": \"");
            builder.append(qtyType);
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

        if (hasUnderlyingTradingSessionID())
        {
            indent(builder, level);
            builder.append("\"UnderlyingTradingSessionID\": \"");
            builder.append(this.underlyingTradingSessionID(), 0, underlyingTradingSessionIDLength());
            builder.append("\",\n");
        }

        if (hasUnderlyingTradingSessionSubID())
        {
            indent(builder, level);
            builder.append("\"UnderlyingTradingSessionSubID\": \"");
            builder.append(this.underlyingTradingSessionSubID(), 0, underlyingTradingSessionSubIDLength());
            builder.append("\",\n");
        }

        indent(builder, level);
        builder.append("\"LastQty\": \"");
        lastQty.appendTo(builder);
        builder.append("\",\n");

        indent(builder, level);
        builder.append("\"LastPx\": \"");
        lastPx.appendTo(builder);
        builder.append("\",\n");

        if (hasLastParPx())
        {
            indent(builder, level);
            builder.append("\"LastParPx\": \"");
            lastParPx.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasLastSpotRate())
        {
            indent(builder, level);
            builder.append("\"LastSpotRate\": \"");
            lastSpotRate.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasLastForwardPoints())
        {
            indent(builder, level);
            builder.append("\"LastForwardPoints\": \"");
            lastForwardPoints.appendTo(builder);
            builder.append("\",\n");
        }

        if (hasLastMkt())
        {
            indent(builder, level);
            builder.append("\"LastMkt\": \"");
            builder.append(this.lastMkt(), 0, lastMktLength());
            builder.append("\",\n");
        }

        indent(builder, level);
        builder.append("\"TradeDate\": \"");
        appendData(builder, tradeDate, tradeDateLength);
        builder.append("\",\n");

        if (hasClearingBusinessDate())
        {
            indent(builder, level);
            builder.append("\"ClearingBusinessDate\": \"");
            appendData(builder, clearingBusinessDate, clearingBusinessDateLength);
            builder.append("\",\n");
        }

        if (hasAvgPx())
        {
            indent(builder, level);
            builder.append("\"AvgPx\": \"");
            avgPx.appendTo(builder);
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

        if (hasAvgPxIndicator())
        {
            indent(builder, level);
            builder.append("\"AvgPxIndicator\": \"");
            builder.append(avgPxIndicator);
            builder.append("\",\n");
        }

        indent(builder, level);
        builder.append("\"NoPosAmt\": \"");
        builder.append(noPosAmt);
        builder.append("\",\n");

        indent(builder, level);
        builder.append("\"PosAmtType\": \"");
        builder.append(this.posAmtType(), 0, posAmtTypeLength());
        builder.append("\",\n");

        indent(builder, level);
        builder.append("\"PosAmt\": \"");
        posAmt.appendTo(builder);
        builder.append("\",\n");

        if (hasMultiLegReportingType())
        {
            indent(builder, level);
            builder.append("\"MultiLegReportingType\": \"");
            builder.append(multiLegReportingType);
            builder.append("\",\n");
        }

        if (hasTradeLegRefID())
        {
            indent(builder, level);
            builder.append("\"TradeLegRefID\": \"");
            builder.append(this.tradeLegRefID(), 0, tradeLegRefIDLength());
            builder.append("\",\n");
        }

        if (hasNoLegsGroupCounter)
        {
            indent(builder, level);
            builder.append("\"LegsGroup\": [\n");
            LegsGroupDecoder legsGroup = this.legsGroup;
            for (int i = 0, size = this.noLegsGroupCounter; i < size; i++)
            {
                indent(builder, level);
                legsGroup.appendTo(builder, level + 1);
                if (legsGroup.next() != null)
                {
                    builder.append(',');
                }
                builder.append('\n');
                legsGroup = legsGroup.next();            }
            indent(builder, level);
            builder.append("],\n");
        }

        indent(builder, level);
        builder.append("\"TransactTime\": \"");
        appendData(builder, transactTime, transactTimeLength);
        builder.append("\",\n");

        if (hasNoTrdRegTimestampsGroupCounter)
        {
            indent(builder, level);
            builder.append("\"TrdRegTimestampsGroup\": [\n");
            TrdRegTimestampsGroupDecoder trdRegTimestampsGroup = this.trdRegTimestampsGroup;
            for (int i = 0, size = this.noTrdRegTimestampsGroupCounter; i < size; i++)
            {
                indent(builder, level);
                trdRegTimestampsGroup.appendTo(builder, level + 1);
                if (trdRegTimestampsGroup.next() != null)
                {
                    builder.append(',');
                }
                builder.append('\n');
                trdRegTimestampsGroup = trdRegTimestampsGroup.next();            }
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

        if (hasMatchStatus())
        {
            indent(builder, level);
            builder.append("\"MatchStatus\": \"");
            builder.append(matchStatus);
            builder.append("\",\n");
        }

        if (hasMatchType())
        {
            indent(builder, level);
            builder.append("\"MatchType\": \"");
            builder.append(this.matchType(), 0, matchTypeLength());
            builder.append("\",\n");
        }

        if (hasNoSidesGroupCounter)
        {
            indent(builder, level);
            builder.append("\"SidesGroup\": [\n");
            SidesGroupDecoder sidesGroup = this.sidesGroup;
            for (int i = 0, size = this.noSidesGroupCounter; i < size; i++)
            {
                indent(builder, level);
                sidesGroup.appendTo(builder, level + 1);
                if (sidesGroup.next() != null)
                {
                    builder.append(',');
                }
                builder.append('\n');
                sidesGroup = sidesGroup.next();            }
            indent(builder, level);
            builder.append("],\n");
        }

        if (hasCopyMsgIndicator())
        {
            indent(builder, level);
            builder.append("\"CopyMsgIndicator\": \"");
            builder.append(copyMsgIndicator);
            builder.append("\",\n");
        }

        if (hasPublishTrdIndicator())
        {
            indent(builder, level);
            builder.append("\"PublishTrdIndicator\": \"");
            builder.append(publishTrdIndicator);
            builder.append("\",\n");
        }

        if (hasShortSaleReason())
        {
            indent(builder, level);
            builder.append("\"ShortSaleReason\": \"");
            builder.append(shortSaleReason);
            builder.append("\",\n");
        }
        indent(builder, level - 1);
        builder.append("}");
        return builder;
    }

    /**
     * {@inheritDoc}
     */
    public TradeCaptureReportEncoder toEncoder(final Encoder encoder)
    {
        return toEncoder((TradeCaptureReportEncoder)encoder);
    }

    public TradeCaptureReportEncoder toEncoder(final TradeCaptureReportEncoder encoder)
    {
        encoder.reset();
        encoder.tradeReportID(this.tradeReportID(), 0, tradeReportIDLength());
        if (hasTradeReportTransType())
        {
            encoder.tradeReportTransType(this.tradeReportTransType());
        }

        if (hasTradeReportType())
        {
            encoder.tradeReportType(this.tradeReportType());
        }

        if (hasTradeRequestID())
        {
            encoder.tradeRequestID(this.tradeRequestID(), 0, tradeRequestIDLength());
        }

        if (hasTrdType())
        {
            encoder.trdType(this.trdType());
        }

        if (hasTrdSubType())
        {
            encoder.trdSubType(this.trdSubType());
        }

        if (hasSecondaryTrdType())
        {
            encoder.secondaryTrdType(this.secondaryTrdType());
        }

        if (hasTransferReason())
        {
            encoder.transferReason(this.transferReason(), 0, transferReasonLength());
        }

        if (hasExecType())
        {
            encoder.execType(this.execType());
        }

        if (hasTotNumTradeReports())
        {
            encoder.totNumTradeReports(this.totNumTradeReports());
        }

        if (hasLastRptRequested())
        {
            encoder.lastRptRequested(this.lastRptRequested());
        }

        if (hasUnsolicitedIndicator())
        {
            encoder.unsolicitedIndicator(this.unsolicitedIndicator());
        }

        if (hasSubscriptionRequestType())
        {
            encoder.subscriptionRequestType(this.subscriptionRequestType());
        }

        if (hasTradeReportRefID())
        {
            encoder.tradeReportRefID(this.tradeReportRefID(), 0, tradeReportRefIDLength());
        }

        if (hasSecondaryTradeReportRefID())
        {
            encoder.secondaryTradeReportRefID(this.secondaryTradeReportRefID(), 0, secondaryTradeReportRefIDLength());
        }

        if (hasSecondaryTradeReportID())
        {
            encoder.secondaryTradeReportID(this.secondaryTradeReportID(), 0, secondaryTradeReportIDLength());
        }

        if (hasTradeLinkID())
        {
            encoder.tradeLinkID(this.tradeLinkID(), 0, tradeLinkIDLength());
        }

        if (hasTrdMatchID())
        {
            encoder.trdMatchID(this.trdMatchID(), 0, trdMatchIDLength());
        }

        if (hasExecID())
        {
            encoder.execID(this.execID(), 0, execIDLength());
        }

        if (hasOrdStatus())
        {
            encoder.ordStatus(this.ordStatus());
        }

        if (hasSecondaryExecID())
        {
            encoder.secondaryExecID(this.secondaryExecID(), 0, secondaryExecIDLength());
        }

        if (hasExecRestatementReason())
        {
            encoder.execRestatementReason(this.execRestatementReason());
        }

        encoder.previouslyReported(this.previouslyReported());
        if (hasPriceType())
        {
            encoder.priceType(this.priceType());
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



        final FinancingDetailsEncoder financingDetails = encoder.financingDetails();        if (hasAgreementDesc())
        {
            financingDetails.agreementDesc(this.agreementDesc(), 0, agreementDescLength());
        }

        if (hasAgreementID())
        {
            financingDetails.agreementID(this.agreementID(), 0, agreementIDLength());
        }

        if (hasAgreementDate())
        {
            financingDetails.agreementDateAsCopy(this.agreementDate(), 0, agreementDateLength());
        }

        if (hasAgreementCurrency())
        {
            financingDetails.agreementCurrency(this.agreementCurrency(), 0, agreementCurrencyLength());
        }

        if (hasTerminationType())
        {
            financingDetails.terminationType(this.terminationType());
        }

        if (hasStartDate())
        {
            financingDetails.startDateAsCopy(this.startDate(), 0, startDateLength());
        }

        if (hasEndDate())
        {
            financingDetails.endDateAsCopy(this.endDate(), 0, endDateLength());
        }

        if (hasDeliveryType())
        {
            financingDetails.deliveryType(this.deliveryType());
        }

        if (hasMarginRatio())
        {
            financingDetails.marginRatio(this.marginRatio());
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


        if (hasQtyType())
        {
            encoder.qtyType(this.qtyType());
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

        if (hasUnderlyingTradingSessionID())
        {
            encoder.underlyingTradingSessionID(this.underlyingTradingSessionID(), 0, underlyingTradingSessionIDLength());
        }

        if (hasUnderlyingTradingSessionSubID())
        {
            encoder.underlyingTradingSessionSubID(this.underlyingTradingSessionSubID(), 0, underlyingTradingSessionSubIDLength());
        }

        encoder.lastQty(this.lastQty());
        encoder.lastPx(this.lastPx());
        if (hasLastParPx())
        {
            encoder.lastParPx(this.lastParPx());
        }

        if (hasLastSpotRate())
        {
            encoder.lastSpotRate(this.lastSpotRate());
        }

        if (hasLastForwardPoints())
        {
            encoder.lastForwardPoints(this.lastForwardPoints());
        }

        if (hasLastMkt())
        {
            encoder.lastMkt(this.lastMkt(), 0, lastMktLength());
        }

        encoder.tradeDateAsCopy(this.tradeDate(), 0, tradeDateLength());
        if (hasClearingBusinessDate())
        {
            encoder.clearingBusinessDateAsCopy(this.clearingBusinessDate(), 0, clearingBusinessDateLength());
        }

        if (hasAvgPx())
        {
            encoder.avgPx(this.avgPx());
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


        if (hasAvgPxIndicator())
        {
            encoder.avgPxIndicator(this.avgPxIndicator());
        }


        final PositionAmountDataEncoder positionAmountData = encoder.positionAmountData();
        positionAmountData.posAmtType(this.posAmtType(), 0, posAmtTypeLength());
        positionAmountData.posAmt(this.posAmt());

        if (hasMultiLegReportingType())
        {
            encoder.multiLegReportingType(this.multiLegReportingType());
        }

        if (hasTradeLegRefID())
        {
            encoder.tradeLegRefID(this.tradeLegRefID(), 0, tradeLegRefIDLength());
        }

        if (hasNoLegsGroupCounter)
        {
            final int size = this.noLegsGroupCounter;
            LegsGroupDecoder legsGroup = this.legsGroup;
            LegsGroupEncoder legsGroupEncoder = encoder.legsGroup(size);
            for (int i = 0; i < size; i++)
            {
                if (legsGroup != null)
                {
                    legsGroup.toEncoder(legsGroupEncoder);
                    legsGroup = legsGroup.next();
                    legsGroupEncoder = legsGroupEncoder.next();
                }
            }
        }

        encoder.transactTimeAsCopy(this.transactTime(), 0, transactTimeLength());

        final TrdRegTimestampsEncoder trdRegTimestamps = encoder.trdRegTimestamps();        if (hasNoTrdRegTimestampsGroupCounter)
        {
            final int size = this.noTrdRegTimestampsGroupCounter;
            TrdRegTimestampsGroupDecoder trdRegTimestampsGroup = this.trdRegTimestampsGroup;
            TrdRegTimestampsGroupEncoder trdRegTimestampsGroupEncoder = trdRegTimestamps.trdRegTimestampsGroup(size);
            for (int i = 0; i < size; i++)
            {
                if (trdRegTimestampsGroup != null)
                {
                    trdRegTimestampsGroup.toEncoder(trdRegTimestampsGroupEncoder);
                    trdRegTimestampsGroup = trdRegTimestampsGroup.next();
                    trdRegTimestampsGroupEncoder = trdRegTimestampsGroupEncoder.next();
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

        if (hasMatchStatus())
        {
            encoder.matchStatus(this.matchStatus());
        }

        if (hasMatchType())
        {
            encoder.matchType(this.matchType(), 0, matchTypeLength());
        }

        if (hasNoSidesGroupCounter)
        {
            final int size = this.noSidesGroupCounter;
            SidesGroupDecoder sidesGroup = this.sidesGroup;
            SidesGroupEncoder sidesGroupEncoder = encoder.sidesGroup(size);
            for (int i = 0; i < size; i++)
            {
                if (sidesGroup != null)
                {
                    sidesGroup.toEncoder(sidesGroupEncoder);
                    sidesGroup = sidesGroup.next();
                    sidesGroupEncoder = sidesGroupEncoder.next();
                }
            }
        }

        if (hasCopyMsgIndicator())
        {
            encoder.copyMsgIndicator(this.copyMsgIndicator());
        }

        if (hasPublishTrdIndicator())
        {
            encoder.publishTrdIndicator(this.publishTrdIndicator());
        }

        if (hasShortSaleReason())
        {
            encoder.shortSaleReason(this.shortSaleReason());
        }
        return encoder;
    }

}
