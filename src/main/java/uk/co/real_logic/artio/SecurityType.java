/* Generated Fix Gateway message codec */
package uk.co.real_logic.artio;

import uk.co.real_logic.artio.dictionary.CharArrayMap;
import uk.co.real_logic.artio.dictionary.CharArrayWrapper;
import org.agrona.collections.IntHashSet;
import java.util.Map;
import java.util.HashMap;
import uk.co.real_logic.artio.builder.StringRepresentable;
import uk.co.real_logic.artio.dictionary.Generated;

@Generated("uk.co.real_logic.artio")
public enum SecurityType implements StringRepresentable
{
    EURO_SUPRANATIONAL_COUPONS("EUSUPRA"),
    FEDERAL_AGENCY_COUPON("FAC"),
    FEDERAL_AGENCY_DISCOUNT_NOTE("FADN"),
    PRIVATE_EXPORT_FUNDING("PEF"),
    USD_SUPRANATIONAL_COUPONS("SUPRA"),
    FUTURE("FUT"),
    OPTION("OPT"),
    CORPORATE_BOND("CORP"),
    CORPORATE_PRIVATE_PLACEMENT("CPP"),
    CONVERTIBLE_BOND("CB"),
    DUAL_CURRENCY("DUAL"),
    EURO_CORPORATE_BOND("EUCORP"),
    INDEXED_LINKED("XLINKD"),
    STRUCTURED_NOTES("STRUCT"),
    YANKEE_CORPORATE_BOND("YANK"),
    FOREIGN_EXCHANGE_CONTRACT("FOR"),
    COMMON_STOCK("CS"),
    PREFERRED_STOCK("PS"),
    BRADY_BOND("BRADY"),
    EURO_SOVEREIGNS("EUSOV"),
    US_TREASURY_BOND("TBOND"),
    INTEREST_STRIP_FROM_ANY_BOND_OR_NOTE("TINT"),
    TREASURY_INFLATION_PROTECTED_SECURITIES("TIPS"),
    PRINCIPAL_STRIP_OF_A_CALLABLE_BOND_OR_NOTE("TCAL"),
    PRINCIPAL_STRIP_FROM_A_NON_CALLABLE_BOND_OR_NOTE("TPRN"),
    US_TREASURY_NOTE("TNOTE"),
    US_TREASURY_BILL("TBILL"),
    REPURCHASE("REPO"),
    FORWARD("FORWARD"),
    BUY_SELLBACK("BUYSELL"),
    SECURITIES_LOAN("SECLOAN"),
    SECURITIES_PLEDGE("SECPLEDGE"),
    TERM_LOAN("TERM"),
    REVOLVER_LOAN("RVLV"),
    REVOLVER_TERM_LOAN("RVLVTRM"),
    BRIDGE_LOAN("BRIDGE"),
    LETTER_OF_CREDIT("LOFC"),
    SWING_LINE_FACILITY("SWING"),
    DEBTOR_IN_POSSESSION("DINP"),
    DEFAULTED("DEFLTED"),
    WITHDRAWN("WITHDRN"),
    REPLACED("REPLACD"),
    MATURED("MATURED"),
    AMENDED_AND_RESTATED("AMENDED"),
    RETIRED("RETIRED"),
    BANKERS_ACCEPTANCE("BA"),
    BANK_NOTES("BN"),
    BILL_OF_EXCHANGES("BOX"),
    CERTIFICATE_OF_DEPOSIT("CD"),
    CALL_LOANS("CL"),
    COMMERCIAL_PAPER("CP"),
    DEPOSIT_NOTES("DN"),
    EURO_CERTIFICATE_OF_DEPOSIT("EUCD"),
    EURO_COMMERCIAL_PAPER("EUCP"),
    LIQUIDITY_NOTE("LQN"),
    MEDIUM_TERM_NOTES("MTN"),
    OVERNIGHT("ONITE"),
    PROMISSORY_NOTE("PN"),
    PLAZOS_FIJOS("PZFJ"),
    SHORT_TERM_LOAN_NOTE("STN"),
    TIME_DEPOSIT("TD"),
    EXTENDED_COMM_NOTE("XCN"),
    YANKEE_CERTIFICATE_OF_DEPOSIT("YCD"),
    ASSET_BACKED_SECURITIES("ABS"),
    CORP_MORTGAGE_BACKED_SECURITIES("CMBS"),
    COLLATERALIZED_MORTGAGE_OBLIGATION("CMO"),
    IOETTE_MORTGAGE("IET"),
    MORTGAGE_BACKED_SECURITIES("MBS"),
    MORTGAGE_INTEREST_ONLY("MIO"),
    MORTGAGE_PRINCIPAL_ONLY("MPO"),
    MORTGAGE_PRIVATE_PLACEMENT("MPP"),
    MISCELLANEOUS_PASS_THROUGH("MPT"),
    PFANDBRIEFE("PFAND"),
    TO_BE_ANNOUNCED("TBA"),
    OTHER_ANTICIPATION_NOTES("AN"),
    CERTIFICATE_OF_OBLIGATION("COFO"),
    CERTIFICATE_OF_PARTICIPATION("COFP"),
    GENERAL_OBLIGATION_BONDS("GO"),
    MANDATORY_TENDER("MT"),
    REVENUE_ANTICIPATION_NOTE("RAN"),
    REVENUE_BONDS("REV"),
    SPECIAL_ASSESSMENT("SPCLA"),
    SPECIAL_OBLIGATION("SPCLO"),
    SPECIAL_TAX("SPCLT"),
    TAX_ANTICIPATION_NOTE("TAN"),
    TAX_ALLOCATION("TAXA"),
    TAX_EXEMPT_COMMERCIAL_PAPER("TECP"),
    TAX_AND_REVENUE_ANTICIPATION_NOTE("TRAN"),
    VARIABLE_RATE_DEMAND_NOTE("VRDN"),
    WARRANT("WAR"),
    MUTUAL_FUND("MF"),
    MULTI_LEG_INSTRUMENT("MLEG"),
    NO_SECURITY_TYPE("NONE"),
    WILDCARD("?"),
    NULL_VAL(""),
    ARTIO_UNKNOWN("");

    private final String representation;

    SecurityType(final String representation)
    {
         this.representation = representation;
    }

    public final String representation() { return representation; }

    private static final CharArrayMap<SecurityType> charMap;
    static
    {
        final Map<String, SecurityType> stringMap = new HashMap<>();
        stringMap.put("EUSUPRA", EURO_SUPRANATIONAL_COUPONS);
        stringMap.put("FAC", FEDERAL_AGENCY_COUPON);
        stringMap.put("FADN", FEDERAL_AGENCY_DISCOUNT_NOTE);
        stringMap.put("PEF", PRIVATE_EXPORT_FUNDING);
        stringMap.put("SUPRA", USD_SUPRANATIONAL_COUPONS);
        stringMap.put("FUT", FUTURE);
        stringMap.put("OPT", OPTION);
        stringMap.put("CORP", CORPORATE_BOND);
        stringMap.put("CPP", CORPORATE_PRIVATE_PLACEMENT);
        stringMap.put("CB", CONVERTIBLE_BOND);
        stringMap.put("DUAL", DUAL_CURRENCY);
        stringMap.put("EUCORP", EURO_CORPORATE_BOND);
        stringMap.put("XLINKD", INDEXED_LINKED);
        stringMap.put("STRUCT", STRUCTURED_NOTES);
        stringMap.put("YANK", YANKEE_CORPORATE_BOND);
        stringMap.put("FOR", FOREIGN_EXCHANGE_CONTRACT);
        stringMap.put("CS", COMMON_STOCK);
        stringMap.put("PS", PREFERRED_STOCK);
        stringMap.put("BRADY", BRADY_BOND);
        stringMap.put("EUSOV", EURO_SOVEREIGNS);
        stringMap.put("TBOND", US_TREASURY_BOND);
        stringMap.put("TINT", INTEREST_STRIP_FROM_ANY_BOND_OR_NOTE);
        stringMap.put("TIPS", TREASURY_INFLATION_PROTECTED_SECURITIES);
        stringMap.put("TCAL", PRINCIPAL_STRIP_OF_A_CALLABLE_BOND_OR_NOTE);
        stringMap.put("TPRN", PRINCIPAL_STRIP_FROM_A_NON_CALLABLE_BOND_OR_NOTE);
        stringMap.put("TNOTE", US_TREASURY_NOTE);
        stringMap.put("TBILL", US_TREASURY_BILL);
        stringMap.put("REPO", REPURCHASE);
        stringMap.put("FORWARD", FORWARD);
        stringMap.put("BUYSELL", BUY_SELLBACK);
        stringMap.put("SECLOAN", SECURITIES_LOAN);
        stringMap.put("SECPLEDGE", SECURITIES_PLEDGE);
        stringMap.put("TERM", TERM_LOAN);
        stringMap.put("RVLV", REVOLVER_LOAN);
        stringMap.put("RVLVTRM", REVOLVER_TERM_LOAN);
        stringMap.put("BRIDGE", BRIDGE_LOAN);
        stringMap.put("LOFC", LETTER_OF_CREDIT);
        stringMap.put("SWING", SWING_LINE_FACILITY);
        stringMap.put("DINP", DEBTOR_IN_POSSESSION);
        stringMap.put("DEFLTED", DEFAULTED);
        stringMap.put("WITHDRN", WITHDRAWN);
        stringMap.put("REPLACD", REPLACED);
        stringMap.put("MATURED", MATURED);
        stringMap.put("AMENDED", AMENDED_AND_RESTATED);
        stringMap.put("RETIRED", RETIRED);
        stringMap.put("BA", BANKERS_ACCEPTANCE);
        stringMap.put("BN", BANK_NOTES);
        stringMap.put("BOX", BILL_OF_EXCHANGES);
        stringMap.put("CD", CERTIFICATE_OF_DEPOSIT);
        stringMap.put("CL", CALL_LOANS);
        stringMap.put("CP", COMMERCIAL_PAPER);
        stringMap.put("DN", DEPOSIT_NOTES);
        stringMap.put("EUCD", EURO_CERTIFICATE_OF_DEPOSIT);
        stringMap.put("EUCP", EURO_COMMERCIAL_PAPER);
        stringMap.put("LQN", LIQUIDITY_NOTE);
        stringMap.put("MTN", MEDIUM_TERM_NOTES);
        stringMap.put("ONITE", OVERNIGHT);
        stringMap.put("PN", PROMISSORY_NOTE);
        stringMap.put("PZFJ", PLAZOS_FIJOS);
        stringMap.put("STN", SHORT_TERM_LOAN_NOTE);
        stringMap.put("TD", TIME_DEPOSIT);
        stringMap.put("XCN", EXTENDED_COMM_NOTE);
        stringMap.put("YCD", YANKEE_CERTIFICATE_OF_DEPOSIT);
        stringMap.put("ABS", ASSET_BACKED_SECURITIES);
        stringMap.put("CMBS", CORP_MORTGAGE_BACKED_SECURITIES);
        stringMap.put("CMO", COLLATERALIZED_MORTGAGE_OBLIGATION);
        stringMap.put("IET", IOETTE_MORTGAGE);
        stringMap.put("MBS", MORTGAGE_BACKED_SECURITIES);
        stringMap.put("MIO", MORTGAGE_INTEREST_ONLY);
        stringMap.put("MPO", MORTGAGE_PRINCIPAL_ONLY);
        stringMap.put("MPP", MORTGAGE_PRIVATE_PLACEMENT);
        stringMap.put("MPT", MISCELLANEOUS_PASS_THROUGH);
        stringMap.put("PFAND", PFANDBRIEFE);
        stringMap.put("TBA", TO_BE_ANNOUNCED);
        stringMap.put("AN", OTHER_ANTICIPATION_NOTES);
        stringMap.put("COFO", CERTIFICATE_OF_OBLIGATION);
        stringMap.put("COFP", CERTIFICATE_OF_PARTICIPATION);
        stringMap.put("GO", GENERAL_OBLIGATION_BONDS);
        stringMap.put("MT", MANDATORY_TENDER);
        stringMap.put("RAN", REVENUE_ANTICIPATION_NOTE);
        stringMap.put("REV", REVENUE_BONDS);
        stringMap.put("SPCLA", SPECIAL_ASSESSMENT);
        stringMap.put("SPCLO", SPECIAL_OBLIGATION);
        stringMap.put("SPCLT", SPECIAL_TAX);
        stringMap.put("TAN", TAX_ANTICIPATION_NOTE);
        stringMap.put("TAXA", TAX_ALLOCATION);
        stringMap.put("TECP", TAX_EXEMPT_COMMERCIAL_PAPER);
        stringMap.put("TRAN", TAX_AND_REVENUE_ANTICIPATION_NOTE);
        stringMap.put("VRDN", VARIABLE_RATE_DEMAND_NOTE);
        stringMap.put("WAR", WARRANT);
        stringMap.put("MF", MUTUAL_FUND);
        stringMap.put("MLEG", MULTI_LEG_INSTRUMENT);
        stringMap.put("NONE", NO_SECURITY_TYPE);
        stringMap.put("?", WILDCARD);
        charMap = new CharArrayMap<>(stringMap);
    }

    public static SecurityType decode(final CharArrayWrapper key)
    {
        final SecurityType value = charMap.get(key);
        if (value == null)
        {
            return ARTIO_UNKNOWN;
        }
        return value;
    }
    public static boolean isValid(final CharArrayWrapper key)
    {
        return charMap.containsKey(key);
    }
    public static SecurityType decode(final String representation)
    {
        switch(representation)
        {
        case "EUSUPRA": return EURO_SUPRANATIONAL_COUPONS;
        case "FAC": return FEDERAL_AGENCY_COUPON;
        case "FADN": return FEDERAL_AGENCY_DISCOUNT_NOTE;
        case "PEF": return PRIVATE_EXPORT_FUNDING;
        case "SUPRA": return USD_SUPRANATIONAL_COUPONS;
        case "FUT": return FUTURE;
        case "OPT": return OPTION;
        case "CORP": return CORPORATE_BOND;
        case "CPP": return CORPORATE_PRIVATE_PLACEMENT;
        case "CB": return CONVERTIBLE_BOND;
        case "DUAL": return DUAL_CURRENCY;
        case "EUCORP": return EURO_CORPORATE_BOND;
        case "XLINKD": return INDEXED_LINKED;
        case "STRUCT": return STRUCTURED_NOTES;
        case "YANK": return YANKEE_CORPORATE_BOND;
        case "FOR": return FOREIGN_EXCHANGE_CONTRACT;
        case "CS": return COMMON_STOCK;
        case "PS": return PREFERRED_STOCK;
        case "BRADY": return BRADY_BOND;
        case "EUSOV": return EURO_SOVEREIGNS;
        case "TBOND": return US_TREASURY_BOND;
        case "TINT": return INTEREST_STRIP_FROM_ANY_BOND_OR_NOTE;
        case "TIPS": return TREASURY_INFLATION_PROTECTED_SECURITIES;
        case "TCAL": return PRINCIPAL_STRIP_OF_A_CALLABLE_BOND_OR_NOTE;
        case "TPRN": return PRINCIPAL_STRIP_FROM_A_NON_CALLABLE_BOND_OR_NOTE;
        case "TNOTE": return US_TREASURY_NOTE;
        case "TBILL": return US_TREASURY_BILL;
        case "REPO": return REPURCHASE;
        case "FORWARD": return FORWARD;
        case "BUYSELL": return BUY_SELLBACK;
        case "SECLOAN": return SECURITIES_LOAN;
        case "SECPLEDGE": return SECURITIES_PLEDGE;
        case "TERM": return TERM_LOAN;
        case "RVLV": return REVOLVER_LOAN;
        case "RVLVTRM": return REVOLVER_TERM_LOAN;
        case "BRIDGE": return BRIDGE_LOAN;
        case "LOFC": return LETTER_OF_CREDIT;
        case "SWING": return SWING_LINE_FACILITY;
        case "DINP": return DEBTOR_IN_POSSESSION;
        case "DEFLTED": return DEFAULTED;
        case "WITHDRN": return WITHDRAWN;
        case "REPLACD": return REPLACED;
        case "MATURED": return MATURED;
        case "AMENDED": return AMENDED_AND_RESTATED;
        case "RETIRED": return RETIRED;
        case "BA": return BANKERS_ACCEPTANCE;
        case "BN": return BANK_NOTES;
        case "BOX": return BILL_OF_EXCHANGES;
        case "CD": return CERTIFICATE_OF_DEPOSIT;
        case "CL": return CALL_LOANS;
        case "CP": return COMMERCIAL_PAPER;
        case "DN": return DEPOSIT_NOTES;
        case "EUCD": return EURO_CERTIFICATE_OF_DEPOSIT;
        case "EUCP": return EURO_COMMERCIAL_PAPER;
        case "LQN": return LIQUIDITY_NOTE;
        case "MTN": return MEDIUM_TERM_NOTES;
        case "ONITE": return OVERNIGHT;
        case "PN": return PROMISSORY_NOTE;
        case "PZFJ": return PLAZOS_FIJOS;
        case "STN": return SHORT_TERM_LOAN_NOTE;
        case "TD": return TIME_DEPOSIT;
        case "XCN": return EXTENDED_COMM_NOTE;
        case "YCD": return YANKEE_CERTIFICATE_OF_DEPOSIT;
        case "ABS": return ASSET_BACKED_SECURITIES;
        case "CMBS": return CORP_MORTGAGE_BACKED_SECURITIES;
        case "CMO": return COLLATERALIZED_MORTGAGE_OBLIGATION;
        case "IET": return IOETTE_MORTGAGE;
        case "MBS": return MORTGAGE_BACKED_SECURITIES;
        case "MIO": return MORTGAGE_INTEREST_ONLY;
        case "MPO": return MORTGAGE_PRINCIPAL_ONLY;
        case "MPP": return MORTGAGE_PRIVATE_PLACEMENT;
        case "MPT": return MISCELLANEOUS_PASS_THROUGH;
        case "PFAND": return PFANDBRIEFE;
        case "TBA": return TO_BE_ANNOUNCED;
        case "AN": return OTHER_ANTICIPATION_NOTES;
        case "COFO": return CERTIFICATE_OF_OBLIGATION;
        case "COFP": return CERTIFICATE_OF_PARTICIPATION;
        case "GO": return GENERAL_OBLIGATION_BONDS;
        case "MT": return MANDATORY_TENDER;
        case "RAN": return REVENUE_ANTICIPATION_NOTE;
        case "REV": return REVENUE_BONDS;
        case "SPCLA": return SPECIAL_ASSESSMENT;
        case "SPCLO": return SPECIAL_OBLIGATION;
        case "SPCLT": return SPECIAL_TAX;
        case "TAN": return TAX_ANTICIPATION_NOTE;
        case "TAXA": return TAX_ALLOCATION;
        case "TECP": return TAX_EXEMPT_COMMERCIAL_PAPER;
        case "TRAN": return TAX_AND_REVENUE_ANTICIPATION_NOTE;
        case "VRDN": return VARIABLE_RATE_DEMAND_NOTE;
        case "WAR": return WARRANT;
        case "MF": return MUTUAL_FUND;
        case "MLEG": return MULTI_LEG_INSTRUMENT;
        case "NONE": return NO_SECURITY_TYPE;
        case "?": return WILDCARD;
        default:
            return ARTIO_UNKNOWN;
        }
    }
}
