package org.fix4j.test.fixspec

import org.fix4j.spec.fix50sp2.FieldTypes
import org.fix4j.spec.fix50sp2.MsgTypes
import spock.lang.Specification

/**
 * User: ben
 * Date: 1/11/2014
 * Time: 6:09 AM
 */
class BaseFieldAndGroupTypesTest extends Specification {
    def "test GetAllGroupTypesRecursively"() {
        when:
        final MsgType msgType = MsgTypes.MarketDataIncrementalRefresh;

        then:
        final Set<GroupType> groupTypes = msgType.getAllGroupTypesRecursively();
        containsGroupTypeWithNoOfField(groupTypes, FieldTypes.NoComplexEventDates);
        containsGroupTypeWithNoOfField(groupTypes, FieldTypes.NoComplexEventTimes);
        containsGroupTypeWithNoOfField(groupTypes, FieldTypes.NoComplexEvents);
        containsGroupTypeWithNoOfField(groupTypes, FieldTypes.NoEvents);
        containsGroupTypeWithNoOfField(groupTypes, FieldTypes.NoInstrumentParties);
        containsGroupTypeWithNoOfField(groupTypes, FieldTypes.NoInstrumentPartySubIDs);
        containsGroupTypeWithNoOfField(groupTypes, FieldTypes.NoLegSecurityAltID);
        containsGroupTypeWithNoOfField(groupTypes, FieldTypes.NoLegs);
        containsGroupTypeWithNoOfField(groupTypes, FieldTypes.NoMDEntries);
        containsGroupTypeWithNoOfField(groupTypes, FieldTypes.NoOfSecSizes);
        containsGroupTypeWithNoOfField(groupTypes, FieldTypes.NoPartyIDs);
        containsGroupTypeWithNoOfField(groupTypes, FieldTypes.NoPartySubIDs);
        containsGroupTypeWithNoOfField(groupTypes, FieldTypes.NoRateSources);
        containsGroupTypeWithNoOfField(groupTypes, FieldTypes.NoRoutingIDs);
        containsGroupTypeWithNoOfField(groupTypes, FieldTypes.NoSecurityAltID);
        containsGroupTypeWithNoOfField(groupTypes, FieldTypes.NoStatsIndicators);
        containsGroupTypeWithNoOfField(groupTypes, FieldTypes.NoUnderlyingSecurityAltID);
        containsGroupTypeWithNoOfField(groupTypes, FieldTypes.NoUnderlyingStips);
        containsGroupTypeWithNoOfField(groupTypes, FieldTypes.NoUnderlyings);
        containsGroupTypeWithNoOfField(groupTypes, FieldTypes.NoUndlyInstrumentParties);
        containsGroupTypeWithNoOfField(groupTypes, FieldTypes.NoUndlyInstrumentPartySubIDs);
    }

    private boolean containsGroupTypeWithNoOfField(final Set<GroupType> groupTypes, final FieldType fieldType) {
        for (final GroupType groupType : groupTypes) {
            if(groupType.getNoOfFieldType().equals(fieldType)){
                return true;
            }
        }
        return false;
    }
}
