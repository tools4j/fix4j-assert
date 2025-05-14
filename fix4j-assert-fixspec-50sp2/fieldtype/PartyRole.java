package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class PartyRole extends BaseFieldType {
    public static final PartyRole INSTANCE = new PartyRole();

    private PartyRole() {
        super(
            "PartyRole",
            452,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field PRIME_BROKER_PROVIDING_GENERAL_TRADE_SERVICES = new Field(PartyRole.INSTANCE, Values.PRIME_BROKER_PROVIDING_GENERAL_TRADE_SERVICES.getOrdinal());
        public final Field ALLOCATION_ENTITY = new Field(PartyRole.INSTANCE, Values.ALLOCATION_ENTITY.getOrdinal());
        public final Field MARKET_DATA_MARKET = new Field(PartyRole.INSTANCE, Values.MARKET_DATA_MARKET.getOrdinal());
        public final Field LIQUIDITY_PROVIDER = new Field(PartyRole.INSTANCE, Values.LIQUIDITY_PROVIDER.getOrdinal());
        public final Field ENTERING_TRADER = new Field(PartyRole.INSTANCE, Values.ENTERING_TRADER.getOrdinal());
        public final Field INTERESTED_PARTY = new Field(PartyRole.INSTANCE, Values.INTERESTED_PARTY.getOrdinal());
        public final Field REGULATORY_BODY = new Field(PartyRole.INSTANCE, Values.REGULATORY_BODY.getOrdinal());
        public final Field CONTRA_INVESTOR_ID = new Field(PartyRole.INSTANCE, Values.CONTRA_INVESTOR_ID.getOrdinal());
        public final Field CONTRA_TRADER = new Field(PartyRole.INSTANCE, Values.CONTRA_TRADER.getOrdinal());
        public final Field POSITION_ACCOUNT = new Field(PartyRole.INSTANCE, Values.POSITION_ACCOUNT.getOrdinal());
        public final Field INTERNAL_CARRY_ACCOUNT = new Field(PartyRole.INSTANCE, Values.INTERNAL_CARRY_ACCOUNT.getOrdinal());
        public final Field CONTRA_EXCHANGE = new Field(PartyRole.INSTANCE, Values.CONTRA_EXCHANGE.getOrdinal());
        public final Field CONTRA_POSITION_ACCOUNT = new Field(PartyRole.INSTANCE, Values.CONTRA_POSITION_ACCOUNT.getOrdinal());
        public final Field TRANSFER_TO_FIRM = new Field(PartyRole.INSTANCE, Values.TRANSFER_TO_FIRM.getOrdinal());
        public final Field CENTRAL_REGISTRATION_DEPOSITORY_CRD = new Field(PartyRole.INSTANCE, Values.CENTRAL_REGISTRATION_DEPOSITORY_CRD.getOrdinal());
        public final Field CLEARING_ACCOUNT = new Field(PartyRole.INSTANCE, Values.CLEARING_ACCOUNT.getOrdinal());
        public final Field STEPOUT_FIRM_PRIME_BROKER = new Field(PartyRole.INSTANCE, Values.STEPOUT_FIRM_PRIME_BROKER.getOrdinal());
        public final Field BROKERCLEARINGID = new Field(PartyRole.INSTANCE, Values.BROKERCLEARINGID.getOrdinal());
        public final Field ACCEPTABLE_SETTLING_COUNTERPARTY = new Field(PartyRole.INSTANCE, Values.ACCEPTABLE_SETTLING_COUNTERPARTY.getOrdinal());
        public final Field UNACCEPTABLE_SETTLING_COUNTERPARTY = new Field(PartyRole.INSTANCE, Values.UNACCEPTABLE_SETTLING_COUNTERPARTY.getOrdinal());
        public final Field INVESTMENT_FIRM = new Field(PartyRole.INSTANCE, Values.INVESTMENT_FIRM.getOrdinal());
        public final Field MARKET_MAKER = new Field(PartyRole.INSTANCE, Values.MARKET_MAKER.getOrdinal());
        public final Field HOME_COMPETENT_AUTHORITY_HOME_CA = new Field(PartyRole.INSTANCE, Values.HOME_COMPETENT_AUTHORITY_HOME_CA.getOrdinal());
        public final Field HOST_COMPETENT_AUTHORITY_HOST_CA = new Field(PartyRole.INSTANCE, Values.HOST_COMPETENT_AUTHORITY_HOST_CA.getOrdinal());
        public final Field EXCHANGE = new Field(PartyRole.INSTANCE, Values.EXCHANGE.getOrdinal());
        public final Field CUSTOMER_ACCOUNT = new Field(PartyRole.INSTANCE, Values.CUSTOMER_ACCOUNT.getOrdinal());
        public final Field CORRESPONDENT_CLEARING_ORGANIZATION = new Field(PartyRole.INSTANCE, Values.CORRESPONDENT_CLEARING_ORGANIZATION.getOrdinal());
        public final Field CORRESPONDENT_BROKER = new Field(PartyRole.INSTANCE, Values.CORRESPONDENT_BROKER.getOrdinal());
        public final Field BUYERSELLER_RECEIVERDELIVERER = new Field(PartyRole.INSTANCE, Values.BUYERSELLER_RECEIVERDELIVERER.getOrdinal());
        public final Field CUSTODIAN = new Field(PartyRole.INSTANCE, Values.CUSTODIAN.getOrdinal());
        public final Field INTERMEDIARY = new Field(PartyRole.INSTANCE, Values.INTERMEDIARY.getOrdinal());
        public final Field CLIENT_ID_FORMERLY_FIX_42_CLIENTID = new Field(PartyRole.INSTANCE, Values.CLIENT_ID_FORMERLY_FIX_42_CLIENTID.getOrdinal());
        public final Field BROKER_OF_CREDIT_FORMERLY_FIX_42_BROKEROFCREDIT = new Field(PartyRole.INSTANCE, Values.BROKER_OF_CREDIT_FORMERLY_FIX_42_BROKEROFCREDIT.getOrdinal());
        public final Field EXECUTING_FIRM_FORMERLY_FIX_42_EXECBROKER = new Field(PartyRole.INSTANCE, Values.EXECUTING_FIRM_FORMERLY_FIX_42_EXECBROKER.getOrdinal());
        public final Field AGENT = new Field(PartyRole.INSTANCE, Values.AGENT.getOrdinal());
        public final Field ENTERING_FIRM = new Field(PartyRole.INSTANCE, Values.ENTERING_FIRM.getOrdinal());
        public final Field INTRODUCING_FIRM = new Field(PartyRole.INSTANCE, Values.INTRODUCING_FIRM.getOrdinal());
        public final Field BENEFICIARY = new Field(PartyRole.INSTANCE, Values.BENEFICIARY.getOrdinal());
        public final Field INVESTOR_ID = new Field(PartyRole.INSTANCE, Values.INVESTOR_ID.getOrdinal());
        public final Field SUBCUSTODIAN = new Field(PartyRole.INSTANCE, Values.SUBCUSTODIAN.getOrdinal());
        public final Field CLEARING_FIRM_FORMERLY_FIX_42_CLEARINGFIRM = new Field(PartyRole.INSTANCE, Values.CLEARING_FIRM_FORMERLY_FIX_42_CLEARINGFIRM.getOrdinal());
        public final Field COMPETENT_AUTHORITY_OF_THE_MOST_RELEVANT_MARKET_IN_TERMS_OF_LIQU = new Field(PartyRole.INSTANCE, Values.COMPETENT_AUTHORITY_OF_THE_MOST_RELEVANT_MARKET_IN_TERMS_OF_LIQU.getOrdinal());
        public final Field COMPETENT_AUTHORITY_OF_THE_TRANSACTION_EXECUTION_VENUE_CATV = new Field(PartyRole.INSTANCE, Values.COMPETENT_AUTHORITY_OF_THE_TRANSACTION_EXECUTION_VENUE_CATV.getOrdinal());
        public final Field FUND_MANAGER_CLIENT_ID_FOR_CIV = new Field(PartyRole.INSTANCE, Values.FUND_MANAGER_CLIENT_ID_FOR_CIV.getOrdinal());
        public final Field REPORTING_INTERMEDIARY_MEDIUMVENDOR_VIA_WHICH_REPORT_HAS_BEEN_PU = new Field(PartyRole.INSTANCE, Values.REPORTING_INTERMEDIARY_MEDIUMVENDOR_VIA_WHICH_REPORT_HAS_BEEN_PU.getOrdinal());
        public final Field LOCATE__LENDING_FIRM_FOR_SHORTSALES = new Field(PartyRole.INSTANCE, Values.LOCATE__LENDING_FIRM_FOR_SHORTSALES.getOrdinal());
        public final Field EXECUTION_VENUE = new Field(PartyRole.INSTANCE, Values.EXECUTION_VENUE.getOrdinal());
        public final Field MARKET_DATA_ENTRY_ORIGINATOR = new Field(PartyRole.INSTANCE, Values.MARKET_DATA_ENTRY_ORIGINATOR.getOrdinal());
        public final Field LOCATION_ID = new Field(PartyRole.INSTANCE, Values.LOCATION_ID.getOrdinal());
        public final Field DESK_ID = new Field(PartyRole.INSTANCE, Values.DESK_ID.getOrdinal());
        public final Field EXECUTING_UNIT = new Field(PartyRole.INSTANCE, Values.EXECUTING_UNIT.getOrdinal());
        public final Field ENTERING_UNIT = new Field(PartyRole.INSTANCE, Values.ENTERING_UNIT.getOrdinal());
        public final Field UNACCEPTABLE_COUNTERPARTY = new Field(PartyRole.INSTANCE, Values.UNACCEPTABLE_COUNTERPARTY.getOrdinal());
        public final Field ACCEPTABLE_COUNTERPARTY = new Field(PartyRole.INSTANCE, Values.ACCEPTABLE_COUNTERPARTY.getOrdinal());
        public final Field SPONSORING_FIRM = new Field(PartyRole.INSTANCE, Values.SPONSORING_FIRM.getOrdinal());
        public final Field SESSION_ID = new Field(PartyRole.INSTANCE, Values.SESSION_ID.getOrdinal());
        public final Field CONTRA_FIRM = new Field(PartyRole.INSTANCE, Values.CONTRA_FIRM.getOrdinal());
        public final Field CONTRA_CLEARING_FIRM = new Field(PartyRole.INSTANCE, Values.CONTRA_CLEARING_FIRM.getOrdinal());
        public final Field CORRESPONDANT_CLEARING_FIRM = new Field(PartyRole.INSTANCE, Values.CORRESPONDANT_CLEARING_FIRM.getOrdinal());
        public final Field EXECUTING_SYSTEM = new Field(PartyRole.INSTANCE, Values.EXECUTING_SYSTEM.getOrdinal());
        public final Field ORDER_ORIGINATION_FIRM_EG_BUYSIDE_FIRM = new Field(PartyRole.INSTANCE, Values.ORDER_ORIGINATION_FIRM_EG_BUYSIDE_FIRM.getOrdinal());
        public final Field GIVEUP_CLEARING_FIRM_FIRM_TO_WHICH_TRADE_IS_GIVEN_UP = new Field(PartyRole.INSTANCE, Values.GIVEUP_CLEARING_FIRM_FIRM_TO_WHICH_TRADE_IS_GIVEN_UP.getOrdinal());
        public final Field ORDER_ORIGINATION_TRADER_ASSOCIATED_WITH_ORDER_ORIGINATION_FIRM_ = new Field(PartyRole.INSTANCE, Values.ORDER_ORIGINATION_TRADER_ASSOCIATED_WITH_ORDER_ORIGINATION_FIRM_.getOrdinal());
        public final Field EXECUTING_TRADER_ASSOCIATED_WITH_EXECUTING_FIRM__ACTUALLY_EXECUT = new Field(PartyRole.INSTANCE, Values.EXECUTING_TRADER_ASSOCIATED_WITH_EXECUTING_FIRM__ACTUALLY_EXECUT.getOrdinal());
        public final Field CLEARING_ORGANIZATION = new Field(PartyRole.INSTANCE, Values.CLEARING_ORGANIZATION.getOrdinal());
        public final Field UNDERLYING_CONTRA_FIRM = new Field(PartyRole.INSTANCE, Values.UNDERLYING_CONTRA_FIRM.getOrdinal());
        public final Field MULTILATERAL_TRADING_FACILITY_MTF = new Field(PartyRole.INSTANCE, Values.MULTILATERAL_TRADING_FACILITY_MTF.getOrdinal());
        public final Field REGULATED_MARKET_RM = new Field(PartyRole.INSTANCE, Values.REGULATED_MARKET_RM.getOrdinal());
        public final Field REPORT_ORIGINATOR = new Field(PartyRole.INSTANCE, Values.REPORT_ORIGINATOR.getOrdinal());
        public final Field SYSTEMATIC_INTERNALISER_SI = new Field(PartyRole.INSTANCE, Values.SYSTEMATIC_INTERNALISER_SI.getOrdinal());
        public final Field INTRODUCING_BROKER = new Field(PartyRole.INSTANCE, Values.INTRODUCING_BROKER.getOrdinal());
        public final Field QUOTE_ORIGINATOR = new Field(PartyRole.INSTANCE, Values.QUOTE_ORIGINATOR.getOrdinal());
        public final Field ASSET_MANAGER = new Field(PartyRole.INSTANCE, Values.ASSET_MANAGER.getOrdinal());
        public final Field CLAIMING_ACCOUNT = new Field(PartyRole.INSTANCE, Values.CLAIMING_ACCOUNT.getOrdinal());
        public final Field SECONDARY_ACCOUNT_NUMBER = new Field(PartyRole.INSTANCE, Values.SECONDARY_ACCOUNT_NUMBER.getOrdinal());
        public final Field ORDER_ENTRY_OPERATOR_ID = new Field(PartyRole.INSTANCE, Values.ORDER_ENTRY_OPERATOR_ID.getOrdinal());
        public final Field THIRD_PARTY_ALLOCATION_FIRM = new Field(PartyRole.INSTANCE, Values.THIRD_PARTY_ALLOCATION_FIRM.getOrdinal());
        public final Field FOREIGN_FIRM = new Field(PartyRole.INSTANCE, Values.FOREIGN_FIRM.getOrdinal());
        public final Field SETTLEMENT_LOCATION_FORMERLY_FIX_42_SETTLLOCATION = new Field(PartyRole.INSTANCE, Values.SETTLEMENT_LOCATION_FORMERLY_FIX_42_SETTLLOCATION.getOrdinal());
        public final Field PLEDGEE_ACCOUNT = new Field(PartyRole.INSTANCE, Values.PLEDGEE_ACCOUNT.getOrdinal());
        public final Field LARGE_TRADER_REPORTABLE_ACCOUNT = new Field(PartyRole.INSTANCE, Values.LARGE_TRADER_REPORTABLE_ACCOUNT.getOrdinal());
        public final Field TRADER_MNEMONIC = new Field(PartyRole.INSTANCE, Values.TRADER_MNEMONIC.getOrdinal());
        public final Field SENDER_LOCATION = new Field(PartyRole.INSTANCE, Values.SENDER_LOCATION.getOrdinal());
        public final Field PLEDGOR_ACCOUNT = new Field(PartyRole.INSTANCE, Values.PLEDGOR_ACCOUNT.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        PRIME_BROKER_PROVIDING_GENERAL_TRADE_SERVICES("79"),
        ALLOCATION_ENTITY("78"),
        MARKET_DATA_MARKET("77"),
        LIQUIDITY_PROVIDER("35"),
        ENTERING_TRADER("36"),
        INTERESTED_PARTY("33"),
        REGULATORY_BODY("34"),
        CONTRA_INVESTOR_ID("39"),
        CONTRA_TRADER("37"),
        POSITION_ACCOUNT("38"),
        INTERNAL_CARRY_ACCOUNT("43"),
        CONTRA_EXCHANGE("42"),
        CONTRA_POSITION_ACCOUNT("41"),
        TRANSFER_TO_FIRM("40"),
        CENTRAL_REGISTRATION_DEPOSITORY_CRD("82"),
        CLEARING_ACCOUNT("83"),
        STEPOUT_FIRM_PRIME_BROKER("80"),
        BROKERCLEARINGID("81"),
        ACCEPTABLE_SETTLING_COUNTERPARTY("84"),
        UNACCEPTABLE_SETTLING_COUNTERPARTY("85"),
        INVESTMENT_FIRM("67"),
        MARKET_MAKER("66"),
        HOME_COMPETENT_AUTHORITY_HOME_CA("69"),
        HOST_COMPETENT_AUTHORITY_HOST_CA("68"),
        EXCHANGE("22"),
        CUSTOMER_ACCOUNT("24"),
        CORRESPONDENT_CLEARING_ORGANIZATION("25"),
        CORRESPONDENT_BROKER("26"),
        BUYERSELLER_RECEIVERDELIVERER("27"),
        CUSTODIAN("28"),
        INTERMEDIARY("29"),
        CLIENT_ID_FORMERLY_FIX_42_CLIENTID("3"),
        BROKER_OF_CREDIT_FORMERLY_FIX_42_BROKEROFCREDIT("2"),
        EXECUTING_FIRM_FORMERLY_FIX_42_EXECBROKER("1"),
        AGENT("30"),
        ENTERING_FIRM("7"),
        INTRODUCING_FIRM("6"),
        BENEFICIARY("32"),
        INVESTOR_ID("5"),
        SUBCUSTODIAN("31"),
        CLEARING_FIRM_FORMERLY_FIX_42_CLEARINGFIRM("4"),
        COMPETENT_AUTHORITY_OF_THE_MOST_RELEVANT_MARKET_IN_TERMS_OF_LIQU("70"),
        COMPETENT_AUTHORITY_OF_THE_TRANSACTION_EXECUTION_VENUE_CATV("71"),
        FUND_MANAGER_CLIENT_ID_FOR_CIV("9"),
        REPORTING_INTERMEDIARY_MEDIUMVENDOR_VIA_WHICH_REPORT_HAS_BEEN_PU("72"),
        LOCATE__LENDING_FIRM_FOR_SHORTSALES("8"),
        EXECUTION_VENUE("73"),
        MARKET_DATA_ENTRY_ORIGINATOR("74"),
        LOCATION_ID("75"),
        DESK_ID("76"),
        EXECUTING_UNIT("59"),
        ENTERING_UNIT("58"),
        UNACCEPTABLE_COUNTERPARTY("57"),
        ACCEPTABLE_COUNTERPARTY("56"),
        SPONSORING_FIRM("19"),
        SESSION_ID("55"),
        CONTRA_FIRM("17"),
        CONTRA_CLEARING_FIRM("18"),
        CORRESPONDANT_CLEARING_FIRM("15"),
        EXECUTING_SYSTEM("16"),
        ORDER_ORIGINATION_FIRM_EG_BUYSIDE_FIRM("13"),
        GIVEUP_CLEARING_FIRM_FIRM_TO_WHICH_TRADE_IS_GIVEN_UP("14"),
        ORDER_ORIGINATION_TRADER_ASSOCIATED_WITH_ORDER_ORIGINATION_FIRM_("11"),
        EXECUTING_TRADER_ASSOCIATED_WITH_EXECUTING_FIRM__ACTUALLY_EXECUT("12"),
        CLEARING_ORGANIZATION("21"),
        UNDERLYING_CONTRA_FIRM("20"),
        MULTILATERAL_TRADING_FACILITY_MTF("64"),
        REGULATED_MARKET_RM("65"),
        REPORT_ORIGINATOR("62"),
        SYSTEMATIC_INTERNALISER_SI("63"),
        INTRODUCING_BROKER("60"),
        QUOTE_ORIGINATOR("61"),
        ASSET_MANAGER("49"),
        CLAIMING_ACCOUNT("48"),
        SECONDARY_ACCOUNT_NUMBER("45"),
        ORDER_ENTRY_OPERATOR_ID("44"),
        THIRD_PARTY_ALLOCATION_FIRM("47"),
        FOREIGN_FIRM("46"),
        SETTLEMENT_LOCATION_FORMERLY_FIX_42_SETTLLOCATION("10"),
        PLEDGEE_ACCOUNT("51"),
        LARGE_TRADER_REPORTABLE_ACCOUNT("52"),
        TRADER_MNEMONIC("53"),
        SENDER_LOCATION("54"),
        PLEDGOR_ACCOUNT("50");

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
