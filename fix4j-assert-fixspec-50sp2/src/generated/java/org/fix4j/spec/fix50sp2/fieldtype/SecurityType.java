package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class SecurityType extends BaseFieldType {
    public static final SecurityType INSTANCE = new SecurityType();

    private SecurityType() {
        super(
            "SecurityType",
            167,
            FieldClassLookup.lookup("STRING"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field CORP_MORTGAGEBACKED_SECURITIES = new Field(SecurityType.INSTANCE, Values.CORP_MORTGAGEBACKED_SECURITIES.getOrdinal());
        public final Field VARIABLE_RATE_DEMAND_NOTE = new Field(SecurityType.INSTANCE, Values.VARIABLE_RATE_DEMAND_NOTE.getOrdinal());
        public final Field TERM_LIQUIDITY_NOTE = new Field(SecurityType.INSTANCE, Values.TERM_LIQUIDITY_NOTE.getOrdinal());
        public final Field PFANDBRIEFE_ = new Field(SecurityType.INSTANCE, Values.PFANDBRIEFE_.getOrdinal());
        public final Field FEDERAL_AGENCY_COUPON = new Field(SecurityType.INSTANCE, Values.FEDERAL_AGENCY_COUPON.getOrdinal());
        public final Field CASH = new Field(SecurityType.INSTANCE, Values.CASH.getOrdinal());
        public final Field TAX_EXEMPT_COMMERCIAL_PAPER = new Field(SecurityType.INSTANCE, Values.TAX_EXEMPT_COMMERCIAL_PAPER.getOrdinal());
        public final Field MUTUAL_FUND = new Field(SecurityType.INSTANCE, Values.MUTUAL_FUND.getOrdinal());
        public final Field DEPOSIT_NOTES = new Field(SecurityType.INSTANCE, Values.DEPOSIT_NOTES.getOrdinal());
        public final Field EURO_CORPORATE_FLOATING_RATE_NOTES = new Field(SecurityType.INSTANCE, Values.EURO_CORPORATE_FLOATING_RATE_NOTES.getOrdinal());
        public final Field TAX_REVENUE_ANTICIPATION_NOTE = new Field(SecurityType.INSTANCE, Values.TAX_REVENUE_ANTICIPATION_NOTE.getOrdinal());
        public final Field REVOLVERTERM_LOAN = new Field(SecurityType.INSTANCE, Values.REVOLVERTERM_LOAN.getOrdinal());
        public final Field US_CORPORATE_FLOATING_RATE_NOTES = new Field(SecurityType.INSTANCE, Values.US_CORPORATE_FLOATING_RATE_NOTES.getOrdinal());
        public final Field REVENUE_BONDS = new Field(SecurityType.INSTANCE, Values.REVENUE_BONDS.getOrdinal());
        public final Field OPTIONS_ON_PHYSICAL__USE_NOT_RECOMMENDED = new Field(SecurityType.INSTANCE, Values.OPTIONS_ON_PHYSICAL__USE_NOT_RECOMMENDED.getOrdinal());
        public final Field REVENUE_ANTICIPATION_NOTE = new Field(SecurityType.INSTANCE, Values.REVENUE_ANTICIPATION_NOTE.getOrdinal());
        public final Field EURO_CERTIFICATE_OF_DEPOSIT = new Field(SecurityType.INSTANCE, Values.EURO_CERTIFICATE_OF_DEPOSIT.getOrdinal());
        public final Field WITHDRAWN = new Field(SecurityType.INSTANCE, Values.WITHDRAWN.getOrdinal());
        public final Field EURO_COMMERCIAL_PAPER = new Field(SecurityType.INSTANCE, Values.EURO_COMMERCIAL_PAPER.getOrdinal());
        public final Field TAX_ANTICIPATION_NOTE = new Field(SecurityType.INSTANCE, Values.TAX_ANTICIPATION_NOTE.getOrdinal());
        public final Field FX_SWAP = new Field(SecurityType.INSTANCE, Values.FX_SWAP.getOrdinal());
        public final Field MANDATORY_TENDER = new Field(SecurityType.INSTANCE, Values.MANDATORY_TENDER.getOrdinal());
        public final Field BUY_SELLBACK = new Field(SecurityType.INSTANCE, Values.BUY_SELLBACK.getOrdinal());
        public final Field OPTIONS_ON_COMBO = new Field(SecurityType.INSTANCE, Values.OPTIONS_ON_COMBO.getOrdinal());
        public final Field FX_SPOT = new Field(SecurityType.INSTANCE, Values.FX_SPOT.getOrdinal());
        public final Field OPTIONS_ON_FUTURES = new Field(SecurityType.INSTANCE, Values.OPTIONS_ON_FUTURES.getOrdinal());
        public final Field IOETTE_MORTGAGE = new Field(SecurityType.INSTANCE, Values.IOETTE_MORTGAGE.getOrdinal());
        public final Field TO_BE_ANNOUNCED = new Field(SecurityType.INSTANCE, Values.TO_BE_ANNOUNCED.getOrdinal());
        public final Field WILDCARD_ENTRY_FOR_USE_ON_SECURITY_DEFINITION_REQUEST = new Field(SecurityType.INSTANCE, Values.WILDCARD_ENTRY_FOR_USE_ON_SECURITY_DEFINITION_REQUEST.getOrdinal());
        public final Field LETTER_OF_CREDIT = new Field(SecurityType.INSTANCE, Values.LETTER_OF_CREDIT.getOrdinal());
        public final Field DUAL_CURRENCY = new Field(SecurityType.INSTANCE, Values.DUAL_CURRENCY.getOrdinal());
        public final Field US_TREASURY_BILL_DEPRECATED_VALUE_USE_TBILL = new Field(SecurityType.INSTANCE, Values.US_TREASURY_BILL_DEPRECATED_VALUE_USE_TBILL.getOrdinal());
        public final Field FUTURE = new Field(SecurityType.INSTANCE, Values.FUTURE.getOrdinal());
        public final Field LIQUIDITY_NOTE = new Field(SecurityType.INSTANCE, Values.LIQUIDITY_NOTE.getOrdinal());
        public final Field NONDELIVERABLE_FORWARD = new Field(SecurityType.INSTANCE, Values.NONDELIVERABLE_FORWARD.getOrdinal());
        public final Field BRIDGE_LOAN = new Field(SecurityType.INSTANCE, Values.BRIDGE_LOAN.getOrdinal());
        public final Field TREASURY_INFLATION_PROTECTED_SECURITIES = new Field(SecurityType.INSTANCE, Values.TREASURY_INFLATION_PROTECTED_SECURITIES.getOrdinal());
        public final Field CREDIT_DEFAULT_SWAP = new Field(SecurityType.INSTANCE, Values.CREDIT_DEFAULT_SWAP.getOrdinal());
        public final Field US_TREASURY_NOTE = new Field(SecurityType.INSTANCE, Values.US_TREASURY_NOTE.getOrdinal());
        public final Field US_TREASURY_BILL = new Field(SecurityType.INSTANCE, Values.US_TREASURY_BILL.getOrdinal());
        public final Field CANADIAN_MORTGAGE_BONDS = new Field(SecurityType.INSTANCE, Values.CANADIAN_MORTGAGE_BONDS.getOrdinal());
        public final Field CANADIAN_MONEY_MARKETS = new Field(SecurityType.INSTANCE, Values.CANADIAN_MONEY_MARKETS.getOrdinal());
        public final Field USD_SUPRANATIONAL_COUPONS_ = new Field(SecurityType.INSTANCE, Values.USD_SUPRANATIONAL_COUPONS_.getOrdinal());
        public final Field BANK_DEPOSITORY_NOTE = new Field(SecurityType.INSTANCE, Values.BANK_DEPOSITORY_NOTE.getOrdinal());
        public final Field EXTENDED_COMM_NOTE = new Field(SecurityType.INSTANCE, Values.EXTENDED_COMM_NOTE.getOrdinal());
        public final Field ASSETBACKED_SECURITIES = new Field(SecurityType.INSTANCE, Values.ASSETBACKED_SECURITIES.getOrdinal());
        public final Field RETIRED = new Field(SecurityType.INSTANCE, Values.RETIRED.getOrdinal());
        public final Field SECURITIES_LOAN = new Field(SecurityType.INSTANCE, Values.SECURITIES_LOAN.getOrdinal());
        public final Field US_TREASURY_NOTE_DEPRECATED_VALUE_USE_TNOTE = new Field(SecurityType.INSTANCE, Values.US_TREASURY_NOTE_DEPRECATED_VALUE_USE_TNOTE.getOrdinal());
        public final Field DEFAULTED = new Field(SecurityType.INSTANCE, Values.DEFAULTED.getOrdinal());
        public final Field COLLATERALIZED_MORTGAGE_OBLIGATION = new Field(SecurityType.INSTANCE, Values.COLLATERALIZED_MORTGAGE_OBLIGATION.getOrdinal());
        public final Field NO_SECURITY_TYPE = new Field(SecurityType.INSTANCE, Values.NO_SECURITY_TYPE.getOrdinal());
        public final Field SPECIAL_ASSESSMENT = new Field(SecurityType.INSTANCE, Values.SPECIAL_ASSESSMENT.getOrdinal());
        public final Field PROMISSORY_NOTE = new Field(SecurityType.INSTANCE, Values.PROMISSORY_NOTE.getOrdinal());
        public final Field FX_FORWARD = new Field(SecurityType.INSTANCE, Values.FX_FORWARD.getOrdinal());
        public final Field GENERAL_OBLIGATION_BONDS = new Field(SecurityType.INSTANCE, Values.GENERAL_OBLIGATION_BONDS.getOrdinal());
        public final Field CORPORATE_BOND = new Field(SecurityType.INSTANCE, Values.CORPORATE_BOND.getOrdinal());
        public final Field MEDIUM_TERM_NOTES = new Field(SecurityType.INSTANCE, Values.MEDIUM_TERM_NOTES.getOrdinal());
        public final Field DEBTOR_IN_POSSESSION = new Field(SecurityType.INSTANCE, Values.DEBTOR_IN_POSSESSION.getOrdinal());
        public final Field PRINCIPAL_STRIP_FROM_A_NONCALLABLE_BOND_OR_NOTE = new Field(SecurityType.INSTANCE, Values.PRINCIPAL_STRIP_FROM_A_NONCALLABLE_BOND_OR_NOTE.getOrdinal());
        public final Field TERM_LOAN = new Field(SecurityType.INSTANCE, Values.TERM_LOAN.getOrdinal());
        public final Field FORWARD = new Field(SecurityType.INSTANCE, Values.FORWARD.getOrdinal());
        public final Field MORTGAGEBACKED_SECURITIES = new Field(SecurityType.INSTANCE, Values.MORTGAGEBACKED_SECURITIES.getOrdinal());
        public final Field SPECIAL_TAX = new Field(SecurityType.INSTANCE, Values.SPECIAL_TAX.getOrdinal());
        public final Field SECURITIES_PLEDGE = new Field(SecurityType.INSTANCE, Values.SECURITIES_PLEDGE.getOrdinal());
        public final Field SPECIAL_OBLIGATION = new Field(SecurityType.INSTANCE, Values.SPECIAL_OBLIGATION.getOrdinal());
        public final Field REVOLVER_LOAN = new Field(SecurityType.INSTANCE, Values.REVOLVER_LOAN.getOrdinal());
        public final Field FOREIGN_EXCHANGE_CONTRACT = new Field(SecurityType.INSTANCE, Values.FOREIGN_EXCHANGE_CONTRACT.getOrdinal());
        public final Field CANADIAN_PROVINCIAL_BONDS = new Field(SecurityType.INSTANCE, Values.CANADIAN_PROVINCIAL_BONDS.getOrdinal());
        public final Field INTEREST_STRIP_FROM_ANY_BOND_OR_NOTE = new Field(SecurityType.INSTANCE, Values.INTEREST_STRIP_FROM_ANY_BOND_OR_NOTE.getOrdinal());
        public final Field CANADIAN_TREASURY_NOTES = new Field(SecurityType.INSTANCE, Values.CANADIAN_TREASURY_NOTES.getOrdinal());
        public final Field SECURED_LIQUIDITY_NOTE = new Field(SecurityType.INSTANCE, Values.SECURED_LIQUIDITY_NOTE.getOrdinal());
        public final Field BILL_OF_EXCHANGES = new Field(SecurityType.INSTANCE, Values.BILL_OF_EXCHANGES.getOrdinal());
        public final Field YANKEE_CERTIFICATE_OF_DEPOSIT = new Field(SecurityType.INSTANCE, Values.YANKEE_CERTIFICATE_OF_DEPOSIT.getOrdinal());
        public final Field INTEREST_RATE_SWAP = new Field(SecurityType.INSTANCE, Values.INTEREST_RATE_SWAP.getOrdinal());
        public final Field REPURCHASE = new Field(SecurityType.INSTANCE, Values.REPURCHASE.getOrdinal());
        public final Field BANKERS_ACCEPTANCE = new Field(SecurityType.INSTANCE, Values.BANKERS_ACCEPTANCE.getOrdinal());
        public final Field REPLACED = new Field(SecurityType.INSTANCE, Values.REPLACED.getOrdinal());
        public final Field WARRANT = new Field(SecurityType.INSTANCE, Values.WARRANT.getOrdinal());
        public final Field MATURED = new Field(SecurityType.INSTANCE, Values.MATURED.getOrdinal());
        public final Field CANADIAN_TREASURY_BILLS = new Field(SecurityType.INSTANCE, Values.CANADIAN_TREASURY_BILLS.getOrdinal());
        public final Field YANKEE_CORPORATE_BOND = new Field(SecurityType.INSTANCE, Values.YANKEE_CORPORATE_BOND.getOrdinal());
        public final Field PREFERRED_STOCK = new Field(SecurityType.INSTANCE, Values.PREFERRED_STOCK.getOrdinal());
        public final Field SHORT_TERM_LOAN_NOTE = new Field(SecurityType.INSTANCE, Values.SHORT_TERM_LOAN_NOTE.getOrdinal());
        public final Field OTHER_ANTICIPATION_NOTES_BAN_GAN_ETC = new Field(SecurityType.INSTANCE, Values.OTHER_ANTICIPATION_NOTES_BAN_GAN_ETC.getOrdinal());
        public final Field PRINCIPAL_STRIP_OF_A_CALLABLE_BOND_OR_NOTE = new Field(SecurityType.INSTANCE, Values.PRINCIPAL_STRIP_OF_A_CALLABLE_BOND_OR_NOTE.getOrdinal());
        public final Field CORPORATE_PRIVATE_PLACEMENT = new Field(SecurityType.INSTANCE, Values.CORPORATE_PRIVATE_PLACEMENT.getOrdinal());
        public final Field PLAZOS_FIJOS = new Field(SecurityType.INSTANCE, Values.PLAZOS_FIJOS.getOrdinal());
        public final Field TIME_DEPOSIT = new Field(SecurityType.INSTANCE, Values.TIME_DEPOSIT.getOrdinal());
        public final Field MULTILEG_INSTRUMENT = new Field(SecurityType.INSTANCE, Values.MULTILEG_INSTRUMENT.getOrdinal());
        public final Field PRIVATE_EXPORT_FUNDING_ = new Field(SecurityType.INSTANCE, Values.PRIVATE_EXPORT_FUNDING_.getOrdinal());
        public final Field TAXABLE_MUNICIPAL_CP = new Field(SecurityType.INSTANCE, Values.TAXABLE_MUNICIPAL_CP.getOrdinal());
        public final Field CONVERTIBLE_BOND = new Field(SecurityType.INSTANCE, Values.CONVERTIBLE_BOND.getOrdinal());
        public final Field BRADY_BOND = new Field(SecurityType.INSTANCE, Values.BRADY_BOND.getOrdinal());
        public final Field OPTION = new Field(SecurityType.INSTANCE, Values.OPTION.getOrdinal());
        public final Field AMENDED__RESTATED = new Field(SecurityType.INSTANCE, Values.AMENDED__RESTATED.getOrdinal());
        public final Field OVERNIGHT = new Field(SecurityType.INSTANCE, Values.OVERNIGHT.getOrdinal());
        public final Field STRUCTURED_NOTES = new Field(SecurityType.INSTANCE, Values.STRUCTURED_NOTES.getOrdinal());
        public final Field EURO_CORPORATE_BOND = new Field(SecurityType.INSTANCE, Values.EURO_CORPORATE_BOND.getOrdinal());
        public final Field MORTGAGE_INTEREST_ONLY = new Field(SecurityType.INSTANCE, Values.MORTGAGE_INTEREST_ONLY.getOrdinal());
        public final Field BANK_NOTES = new Field(SecurityType.INSTANCE, Values.BANK_NOTES.getOrdinal());
        public final Field FEDERAL_AGENCY_DISCOUNT_NOTE = new Field(SecurityType.INSTANCE, Values.FEDERAL_AGENCY_DISCOUNT_NOTE.getOrdinal());
        public final Field TREASURY_BILL__NON_US = new Field(SecurityType.INSTANCE, Values.TREASURY_BILL__NON_US.getOrdinal());
        public final Field US_TREASURY_BOND = new Field(SecurityType.INSTANCE, Values.US_TREASURY_BOND.getOrdinal());
        public final Field EURO_SUPRANATIONAL_COUPONS_ = new Field(SecurityType.INSTANCE, Values.EURO_SUPRANATIONAL_COUPONS_.getOrdinal());
        public final Field MISCELLANEOUS_PASSTHROUGH = new Field(SecurityType.INSTANCE, Values.MISCELLANEOUS_PASSTHROUGH.getOrdinal());
        public final Field EURO_SOVEREIGNS_ = new Field(SecurityType.INSTANCE, Values.EURO_SOVEREIGNS_.getOrdinal());
        public final Field COMMON_STOCK = new Field(SecurityType.INSTANCE, Values.COMMON_STOCK.getOrdinal());
        public final Field INDEXED_LINKED = new Field(SecurityType.INSTANCE, Values.INDEXED_LINKED.getOrdinal());
        public final Field CERTIFICATE_OF_DEPOSIT = new Field(SecurityType.INSTANCE, Values.CERTIFICATE_OF_DEPOSIT.getOrdinal());
        public final Field MORTGAGE_PRIVATE_PLACEMENT = new Field(SecurityType.INSTANCE, Values.MORTGAGE_PRIVATE_PLACEMENT.getOrdinal());
        public final Field SWING_LINE_FACILITY = new Field(SecurityType.INSTANCE, Values.SWING_LINE_FACILITY.getOrdinal());
        public final Field TAX_ALLOCATION = new Field(SecurityType.INSTANCE, Values.TAX_ALLOCATION.getOrdinal());
        public final Field MORTGAGE_PRINCIPAL_ONLY = new Field(SecurityType.INSTANCE, Values.MORTGAGE_PRINCIPAL_ONLY.getOrdinal());
        public final Field COMMERCIAL_PAPER = new Field(SecurityType.INSTANCE, Values.COMMERCIAL_PAPER.getOrdinal());
        public final Field CERTIFICATE_OF_OBLIGATION = new Field(SecurityType.INSTANCE, Values.CERTIFICATE_OF_OBLIGATION.getOrdinal());
        public final Field CERTIFICATE_OF_PARTICIPATION = new Field(SecurityType.INSTANCE, Values.CERTIFICATE_OF_PARTICIPATION.getOrdinal());
        public final Field CALL_LOANS = new Field(SecurityType.INSTANCE, Values.CALL_LOANS.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        CORP_MORTGAGEBACKED_SECURITIES("CMBS"),
        VARIABLE_RATE_DEMAND_NOTE("VRDN"),
        TERM_LIQUIDITY_NOTE("TLQN"),
        PFANDBRIEFE_("PFAND"),
        FEDERAL_AGENCY_COUPON("FAC"),
        CASH("CASH"),
        TAX_EXEMPT_COMMERCIAL_PAPER("TECP"),
        MUTUAL_FUND("MF"),
        DEPOSIT_NOTES("DN"),
        EURO_CORPORATE_FLOATING_RATE_NOTES("EUFRN"),
        TAX_REVENUE_ANTICIPATION_NOTE("TRAN"),
        REVOLVERTERM_LOAN("RVLVTRM"),
        US_CORPORATE_FLOATING_RATE_NOTES("FRN"),
        REVENUE_BONDS("REV"),
        OPTIONS_ON_PHYSICAL__USE_NOT_RECOMMENDED("OOP"),
        REVENUE_ANTICIPATION_NOTE("RAN"),
        EURO_CERTIFICATE_OF_DEPOSIT("EUCD"),
        WITHDRAWN("WITHDRN"),
        EURO_COMMERCIAL_PAPER("EUCP"),
        TAX_ANTICIPATION_NOTE("TAN"),
        FX_SWAP("FXSWAP"),
        MANDATORY_TENDER("MT"),
        BUY_SELLBACK("BUYSELL"),
        OPTIONS_ON_COMBO("OOC"),
        FX_SPOT("FXSPOT"),
        OPTIONS_ON_FUTURES("OOF"),
        IOETTE_MORTGAGE("IET"),
        TO_BE_ANNOUNCED("TBA"),
        WILDCARD_ENTRY_FOR_USE_ON_SECURITY_DEFINITION_REQUEST("?"),
        LETTER_OF_CREDIT("LOFC"),
        DUAL_CURRENCY("DUAL"),
        US_TREASURY_BILL_DEPRECATED_VALUE_USE_TBILL("USTB"),
        FUTURE("FUT"),
        LIQUIDITY_NOTE("LQN"),
        NONDELIVERABLE_FORWARD("FXNDF"),
        BRIDGE_LOAN("BRIDGE"),
        TREASURY_INFLATION_PROTECTED_SECURITIES("TIPS"),
        CREDIT_DEFAULT_SWAP("CDS"),
        US_TREASURY_NOTE("TNOTE"),
        US_TREASURY_BILL("TBILL"),
        CANADIAN_MORTGAGE_BONDS("CMB"),
        CANADIAN_MONEY_MARKETS("CAMM"),
        USD_SUPRANATIONAL_COUPONS_("SUPRA"),
        BANK_DEPOSITORY_NOTE("BDN"),
        EXTENDED_COMM_NOTE("XCN"),
        ASSETBACKED_SECURITIES("ABS"),
        RETIRED("RETIRED"),
        SECURITIES_LOAN("SECLOAN"),
        US_TREASURY_NOTE_DEPRECATED_VALUE_USE_TNOTE("UST"),
        DEFAULTED("DEFLTED"),
        COLLATERALIZED_MORTGAGE_OBLIGATION("CMO"),
        NO_SECURITY_TYPE("NONE"),
        SPECIAL_ASSESSMENT("SPCLA"),
        PROMISSORY_NOTE("PN"),
        FX_FORWARD("FXFWD"),
        GENERAL_OBLIGATION_BONDS("GO"),
        CORPORATE_BOND("CORP"),
        MEDIUM_TERM_NOTES("MTN"),
        DEBTOR_IN_POSSESSION("DINP"),
        PRINCIPAL_STRIP_FROM_A_NONCALLABLE_BOND_OR_NOTE("TPRN"),
        TERM_LOAN("TERM"),
        FORWARD("FORWARD"),
        MORTGAGEBACKED_SECURITIES("MBS"),
        SPECIAL_TAX("SPCLT"),
        SECURITIES_PLEDGE("SECPLEDGE"),
        SPECIAL_OBLIGATION("SPCLO"),
        REVOLVER_LOAN("RVLV"),
        FOREIGN_EXCHANGE_CONTRACT("FOR"),
        CANADIAN_PROVINCIAL_BONDS("PROV"),
        INTEREST_STRIP_FROM_ANY_BOND_OR_NOTE("TINT"),
        CANADIAN_TREASURY_NOTES("CAN"),
        SECURED_LIQUIDITY_NOTE("SLQN"),
        BILL_OF_EXCHANGES("BOX"),
        YANKEE_CERTIFICATE_OF_DEPOSIT("YCD"),
        INTEREST_RATE_SWAP("IRS"),
        REPURCHASE("REPO"),
        BANKERS_ACCEPTANCE("BA"),
        REPLACED("REPLACD"),
        WARRANT("WAR"),
        MATURED("MATURED"),
        CANADIAN_TREASURY_BILLS("CTB"),
        YANKEE_CORPORATE_BOND("YANK"),
        PREFERRED_STOCK("PS"),
        SHORT_TERM_LOAN_NOTE("STN"),
        OTHER_ANTICIPATION_NOTES_BAN_GAN_ETC("AN"),
        PRINCIPAL_STRIP_OF_A_CALLABLE_BOND_OR_NOTE("TCAL"),
        CORPORATE_PRIVATE_PLACEMENT("CPP"),
        PLAZOS_FIJOS("PZFJ"),
        TIME_DEPOSIT("TD"),
        MULTILEG_INSTRUMENT("MLEG"),
        PRIVATE_EXPORT_FUNDING_("PEF"),
        TAXABLE_MUNICIPAL_CP("TMCP"),
        CONVERTIBLE_BOND("CB"),
        BRADY_BOND("BRADY"),
        OPTION("OPT"),
        AMENDED__RESTATED("AMENDED"),
        OVERNIGHT("ONITE"),
        STRUCTURED_NOTES("STRUCT"),
        EURO_CORPORATE_BOND("EUCORP"),
        MORTGAGE_INTEREST_ONLY("MIO"),
        BANK_NOTES("BN"),
        FEDERAL_AGENCY_DISCOUNT_NOTE("FADN"),
        TREASURY_BILL__NON_US("TB"),
        US_TREASURY_BOND("TBOND"),
        EURO_SUPRANATIONAL_COUPONS_("EUSUPRA"),
        MISCELLANEOUS_PASSTHROUGH("MPT"),
        EURO_SOVEREIGNS_("EUSOV"),
        COMMON_STOCK("CS"),
        INDEXED_LINKED("XLINKD"),
        CERTIFICATE_OF_DEPOSIT("CD"),
        MORTGAGE_PRIVATE_PLACEMENT("MPP"),
        SWING_LINE_FACILITY("SWING"),
        TAX_ALLOCATION("TAXA"),
        MORTGAGE_PRINCIPAL_ONLY("MPO"),
        COMMERCIAL_PAPER("CP"),
        CERTIFICATE_OF_OBLIGATION("COFO"),
        CERTIFICATE_OF_PARTICIPATION("COFP"),
        CALL_LOANS("CL");

        private final String ordinal;

        private Values(final String ordinal) {
            this.ordinal = ordinal;
        }

        @Override
        public String getOrdinal() {
            return ordinal;
        }
    }
}
