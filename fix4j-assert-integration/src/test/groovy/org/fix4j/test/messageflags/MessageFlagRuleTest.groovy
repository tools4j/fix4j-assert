package org.fix4j.test.messageflags

import org.fix4j.test.fixmodel.FixMessage
import org.fix4j.test.fixspec.FixSpecification
import org.fix4j.spec.fix50sp2.FieldTypes
import org.fix4j.spec.fix50sp2.FixSpec
import org.fix4j.spec.fix50sp2.MsgTypes
import org.fix4j.test.util.Consts
import spock.lang.Specification

/**
 * User: ben
 * Date: 10/11/2014
 * Time: 4:46 PM
 */
class MessageFlagRuleTest extends Specification {
    private FixSpecification fixSpecification;

    def setup(){
        this.fixSpecification = FixSpec.INSTANCE;
    }


    def "test IsTriggered - triggered on MsgType"() {
        given:
        final FixMessage message = fixSpecification.parse("[MsgType]35=3[REJECT]|[SenderCompID]49=SERVER_COMP_ID|[SendingTime]52=20141110-05:44:53.291|[TargetCompID]56=CLIENT_COMP_ID|[RefSeqNum]45=9|[Text]58=Tag appears more than once|[RefTagID]371=64|[RefMsgType]372=V|[SessionRejectReason]373=13[TAG_APPEARS_MORE_THAN_ONCE]")

        when:
        final SimpleMessageFlagRule rule = new SimpleMessageFlagRule(MsgTypes.Reject, "Triggered!");

        then:
        assert rule.isTriggered(message);
    }

    def "test IsTriggered - NOT triggered on MsgType"() {
        given:
        final FixMessage message = fixSpecification.parse("[MsgType]35=A|[SenderCompID]49=SERVER_COMP_ID|[SendingTime]52=20141110-05:44:53.291|[TargetCompID]56=CLIENT_COMP_ID|[RefSeqNum]45=9|[Text]58=Tag appears more than once|[RefTagID]371=64|[RefMsgType]372=V|[SessionRejectReason]373=13[TAG_APPEARS_MORE_THAN_ONCE]")

        when:
        final SimpleMessageFlagRule rule = new SimpleMessageFlagRule(MsgTypes.Reject, "Triggered!");

        then:
        assert !rule.isTriggered(message);
    }

    def "test IsTriggered - triggered on expression"() {
        given:
        final FixMessage message = fixSpecification.parse("[MsgType]35=3[REJECT]|[SenderCompID]49=SERVER_COMP_ID|[SendingTime]52=20141110-05:44:53.291|[TargetCompID]56=CLIENT_COMP_ID|[RefSeqNum]45=9|[Text]58=Tag appears more than once|[RefTagID]371=64|[RefMsgType]372=V|[SessionRejectReason]373=13[TAG_APPEARS_MORE_THAN_ONCE]")

        when:
        final SimpleMessageFlagRule rule = new SimpleMessageFlagRule(fixSpecification, "35=3|49=SERVER_COMP_ID", "Triggered!");

        then:
        assert rule.isTriggered(message);
    }

    def "test IsTriggered - NOT triggered on expression"() {
        given:
        final FixMessage message = fixSpecification.parse("[MsgType]35=A|[SenderCompID]49=SERVER_COMP_ID|[SendingTime]52=20141110-05:44:53.291|[TargetCompID]56=CLIENT_COMP_ID|[RefSeqNum]45=9|[Text]58=Tag appears more than once|[RefTagID]371=64|[RefMsgType]372=V|[SessionRejectReason]373=13[TAG_APPEARS_MORE_THAN_ONCE]")

        when:
        final SimpleMessageFlagRule rule = new SimpleMessageFlagRule(fixSpecification, "35=3|49=BLAH", "Triggered!");

        then:
        assert !rule.isTriggered(message);
    }

    def "test GetMessageFlag"() {
        given:
        final FixMessage message = fixSpecification.parse("[MsgType]35=3[REJECT]|[SenderCompID]49=SERVER_COMP_ID|[SendingTime]52=20141110-05:44:53.291|[TargetCompID]56=CLIENT_COMP_ID|[RefSeqNum]45=9|[Text]58=Tag appears more than once|[RefTagID]371=64|[RefMsgType]372=V|[SessionRejectReason]373=13[TAG_APPEARS_MORE_THAN_ONCE]")

        when:
        final SimpleMessageFlagRule rule = new SimpleMessageFlagRule(fixSpecification, "35=3|49=SERVER_COMP_ID", "Triggered!");

        then:
        final MessageFlags flags = rule.getMessageFlags(message);
        flags.getFixMessage() == message;
    }

    def "test ForAnyValueOfField - matches"() {
        given:
        final FixMessage message = fixSpecification.parse("[MsgType]35=3[REJECT]|[SenderCompID]49=SERVER_COMP_ID|[SendingTime]52=20141110-05:44:53.291|[TargetCompID]56=CLIENT_COMP_ID|[RefSeqNum]45=9|[Text]58=Tag appears more than once|[RefTagID]371=64|[RefMsgType]372=V|[SessionRejectReason]373=13[TAG_APPEARS_MORE_THAN_ONCE]")

        when:
        final SimpleMessageFlagRule rule = SimpleMessageFlagRule.forAnyValueOfField(FieldTypes.SenderCompID, "alert!");

        then:
        assert rule.isTriggered(message);
        assert rule.getMessageFlags(message).getReportAsString() == message.toDelimitedMessageWithDescriptors() + Consts.EOL + Consts.INDENT + "1.   alert!" + Consts.EOL;
    }

    def "test ForAnyValueOfField - does NOT match"() {
        given:
        final FixMessage message = fixSpecification.parse("[MsgType]35=3[REJECT]|[SenderCompID]49=SERVER_COMP_ID|[SendingTime]52=20141110-05:44:53.291|[TargetCompID]56=CLIENT_COMP_ID|[RefSeqNum]45=9|[Text]58=Tag appears more than once|[RefTagID]371=64|[RefMsgType]372=V|[SessionRejectReason]373=13[TAG_APPEARS_MORE_THAN_ONCE]")

        when:
        final SimpleMessageFlagRule rule = SimpleMessageFlagRule.forAnyValueOfField(FieldTypes.BasisFeatureDate, "alert!");

        then:
        assert !rule.isTriggered(message);
    }

    def "test alert contains fields"() {
        given:
        final FixMessage message = fixSpecification.parse("[MsgType]35=3[REJECT]|[SenderCompID]49=SERVER_COMP_ID|[SendingTime]52=20141110-05:44:53.291|[TargetCompID]56=CLIENT_COMP_ID|[RefSeqNum]45=9|[Text]58=Tag appears more than once|[RefTagID]371=64|[RefMsgType]372=V|[SessionRejectReason]373=13[TAG_APPEARS_MORE_THAN_ONCE]")

        when:
        final SimpleMessageFlagRule rule = new SimpleMessageFlagRule(MsgTypes.Reject, 'alert ${373} and ${58}');

        then:
        assert rule.isTriggered(message);
        assert rule.getMessageFlags(message).getReportAsString() == message.toDelimitedMessageWithDescriptors() + Consts.EOL + Consts.INDENT + "1.   alert 13[TAG_APPEARS_MORE_THAN_ONCE] and Tag appears more than once" + Consts.EOL;
    }
}
