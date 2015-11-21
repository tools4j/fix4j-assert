package org.fix4j.test.fixmodel

import org.fix4j.test.expression.MessageExpression
import org.fix4j.test.expression.FlexibleMessageExpressionParser
import org.fix4j.spec.fix50sp2.FixSpec
import org.fix4j.test.properties.ApplicationProperties
import org.fix4j.test.properties.ApplicationPropertiesFactory
import org.fix4j.test.properties.MapPropertySource
import org.fix4j.test.properties.PropertyKeysAndDefaultValues
import spock.lang.Specification

/**
 * User: ben
 * Date: 31/10/2014
 * Time: 7:50 PM
 */
class PrettyStripperTest extends Specification {
    public static final FixSpec FIXSPEC = FixSpec.INSTANCE
    private PrettyStripper prettyStripper;

    def setup(){
        prettyStripper = new PrettyStripper();
    }

    def cleanup(){
        final String customDelimiter = PropertyKeysAndDefaultValues.FIX_FIELD_DELIM.defaultValue;
        ApplicationProperties.Singleton.setInstance(new ApplicationPropertiesFactory().createApplicationProperties(new MapPropertySource([(PropertyKeysAndDefaultValues.FIX_FIELD_DELIM.getKey()): customDelimiter], "test.prefs")));
    }

    def "test strip group repeats which start with numbers"(){
        given:
        final String prettyMessage =
                "    1. First repeat field 1\n" +
                "       First repeat field 2\n" +
                "    2. Second repeat field 1\n" +
                "       Second repeat field 2\n";

        expect:
        PrettyStripper.stripPrettiness(prettyMessage) == "First repeat field 1|First repeat field 2|Second repeat field 1|Second repeat field 2";
    }

    def "test strip spaces from start and end of string"(){
        given:
        final String prettyMessage =
                "    blah\n" +
                "    blah\n" +
                "blah    ";

        expect:
        PrettyStripper.stripPrettiness(prettyMessage) == "blah|blah|blah";
    }

    def "test strip line feed characters"(){
        given:
        final String prettyMessage =
                "blah\n\r" +
                "blah";

        expect:
        PrettyStripper.stripPrettiness(prettyMessage) == "blah|blah";
    }

    def "test strip lines with just whitespace"(){
        given:
        final String prettyMessage =
                "blah\n" +
                "     \n" +
                "blah";

        expect:
        PrettyStripper.stripPrettiness(prettyMessage) == "blah|blah";
    }

    def "test strip empty lines"(){
        given:
        final String prettyMessage =
                "blah\n" +
                "\n" +
                "blah\n" +
                "\n" +
                "\n" +
                "blah";

        expect:
        PrettyStripper.stripPrettiness(prettyMessage) == "blah|blah|blah";
    }

    def "test strip group repeats which start with numbers, display delim not equal to fix delim"(){
        setup:
        final String customDelimiter = ";";
        ApplicationProperties.Singleton.setInstance(new ApplicationPropertiesFactory().createApplicationProperties(new MapPropertySource([(PropertyKeysAndDefaultValues.FIX_FIELD_DELIM.getKey()): customDelimiter], "test.prefs")));

        when:
        final String prettyMessage =
                "    1. First repeat field 1\n" +
                "       First repeat field 2\n" +
                "    2. Second repeat field 1\n" +
                "       Second repeat field 2\n";

        then:
        PrettyStripper.stripPrettiness(prettyMessage) == "First repeat field 1|First repeat field 2|Second repeat field 1|Second repeat field 2";
    }

    def "test strip spaces from start and end of string, display delim not equal to fix delim"(){
        setup:
        final String customDelimiter = ";";
        ApplicationProperties.Singleton.setInstance(new ApplicationPropertiesFactory().createApplicationProperties(new MapPropertySource([(PropertyKeysAndDefaultValues.FIX_FIELD_DELIM.getKey()): customDelimiter], "test.prefs")));

        when:
        final String prettyMessage =
                "    blah\n" +
                "    blah\n" +
                "blah    ";

        then:
        PrettyStripper.stripPrettiness(prettyMessage) == "blah|blah|blah";
    }


    def "test strip string with delim at end of string, display delim not equal to fix delim"(){
        setup:
        final String customDelimiter = ";";
        ApplicationProperties.Singleton.setInstance(new ApplicationPropertiesFactory().createApplicationProperties(new MapPropertySource([(PropertyKeysAndDefaultValues.FIX_FIELD_DELIM.getKey()): customDelimiter], "test.prefs")));

        when:
        final String prettyMessage = "    blah;blah;blah;    ";

        then:
        PrettyStripper.stripPrettiness(prettyMessage) == "blah|blah|blah";
    }

    def "test strip line feed characters, display delim not fix delim"(){
        setup:
        final String customDelimiter = ";";
        ApplicationProperties.Singleton.setInstance(new ApplicationPropertiesFactory().createApplicationProperties(new MapPropertySource([(PropertyKeysAndDefaultValues.FIX_FIELD_DELIM.getKey()): customDelimiter], "test.prefs")));

        when:
        final String prettyMessage =
                "blah\n\r" +
                "blah";

        then:
        PrettyStripper.stripPrettiness(prettyMessage) == "blah|blah";
    }

    def "test strip lines with just whitespace, display delim not equal to fix delim"(){
        setup:
        final String customDelimiter = ";";
        ApplicationProperties.Singleton.setInstance(new ApplicationPropertiesFactory().createApplicationProperties(new MapPropertySource([(PropertyKeysAndDefaultValues.FIX_FIELD_DELIM.getKey()): customDelimiter], "test.prefs")));

        when:
        final String prettyMessage =
                "blah\n" +
                "     \n" +
                "blah";

        then:
        PrettyStripper.stripPrettiness(prettyMessage) == "blah|blah";
    }

    def "test strip empty lines, display delim not equal to fix delim"(){
        setup:
        final String customDelimiter = ";";
        ApplicationProperties.Singleton.setInstance(new ApplicationPropertiesFactory().createApplicationProperties(new MapPropertySource([(PropertyKeysAndDefaultValues.FIX_FIELD_DELIM.getKey()): customDelimiter], "test.prefs")));

        when:
        final String prettyMessage =
                "blah\n" +
                        "\n" +
                        "blah\n" +
                        "\n" +
                        "\n" +
                        "blah";

        then:
        PrettyStripper.stripPrettiness(prettyMessage) == "blah|blah|blah";
    }

    def "test StripPrettiness from real message"() {
        given:
        final String prettyMessage =
                "------------------------------------------------------\n" +
                "Logon\n" +
                "------------------------------------------------------\n" +
                "Header\n" +
                "    [BeginString]8=string\n" +
                "    [BodyLength]9=11\n" +
                "    [MsgType]35=A[LOGON]\n" +
                "    [ApplVerID]1128=3[FIX41]\n" +
                "    [CstmApplVerID]1129=string\n" +
                "    [ApplExtID]1156=1234\n" +
                "    [SenderCompID]49=string\n" +
                "    [TargetCompID]56=string\n" +
                "    [OnBehalfOfCompID]115=string\n" +
                "    [DeliverToCompID]128=string\n" +
                "    [SecureDataLen]90=11\n" +
                "    [SecureData]91=data\n" +
                "    [MsgSeqNum]34=2\n" +
                "    [SenderSubID]50=string\n" +
                "    [SenderLocationID]142=string\n" +
                "    [TargetSubID]57=string\n" +
                "    [TargetLocationID]143=string\n" +
                "    [OnBehalfOfSubID]116=string\n" +
                "    [OnBehalfOfLocationID]144=string\n" +
                "    [DeliverToSubID]129=string\n" +
                "    [DeliverToLocationID]145=string\n" +
                "    [PossDupFlag]43=N[ORIGINAL_TRANSMISSION]\n" +
                "    [PossResend]97=N[ORIGINAL_TRANSMISSION]\n" +
                "    [SendingTime]52=20140727-10:00:00.000\n" +
                "    [OrigSendingTime]122=20140727-10:00:00.000\n" +
                "    [XmlDataLen]212=11\n" +
                "    [XmlData]213=data\n" +
                "    [MessageEncoding]347=string\n" +
                "    [LastMsgSeqNumProcessed]369=2\n" +
                "    [NoHops]627=3\n" +
                "      1.[HopCompID]628=string\n" +
                "        [HopSendingTime]629=20140727-10:00:00.000\n" +
                "        [HopRefID]630=2\n" +
                "      2.[HopCompID]628=string\n" +
                "        [HopSendingTime]629=20140727-10:00:00.000\n" +
                "        [HopRefID]630=2\n" +
                "      3.[HopCompID]628=string\n" +
                "        [HopSendingTime]629=20140727-10:00:00.000\n" +
                "        [HopRefID]630=2\n" +
                "Body\n" +
                "    [EncryptMethod]98=3[PKCS__DES_PROPRIETARY]\n" +
                "    [HeartBtInt]108=1234\n" +
                "    [RawDataLength]95=11\n" +
                "    [RawData]96=data\n" +
                "    [ResetSeqNumFlag]141=N[NO]\n" +
                "    [NextExpectedMsgSeqNum]789=2\n" +
                "    [MaxMessageSize]383=11\n" +
                "    [TestMessageIndicator]464=N[FALES_PRODUCTION]\n" +
                "    [Username]553=string\n" +
                "    [Password]554=string\n" +
                "    [NewPassword]925=string\n" +
                "    [EncryptedPasswordMethod]1400=1234\n" +
                "    [EncryptedPasswordLen]1401=11\n" +
                "    [EncryptedPassword]1402=data\n" +
                "    [EncryptedNewPasswordLen]1403=11\n" +
                "    [EncryptedNewPassword]1404=data\n" +
                "    [SessionStatus]1409=3[NEW_SESSION_PASSWORD_DOES_NOT_COMPLY_WITH_POLICY]\n" +
                "    [DefaultApplVerID]1137=string\n" +
                "    [DefaultApplExtID]1407=1234\n" +
                "    [DefaultCstmApplVerID]1408=string\n" +
                "    [Text]58=string\n" +
                "    [EncodedTextLen]354=11\n" +
                "    [EncodedText]355=data\n" +
                "    [NoMsgTypes]384=3\n" +
                "      1.[RefMsgType]372=string\n" +
                "        [MsgDirection]385=S[SEND]\n" +
                "        [RefApplVerID]1130=string\n" +
                "        [RefCstmApplVerID]1131=string\n" +
                "        [RefApplExtID]1406=1234\n" +
                "        [DefaultVerIndicator]1410=true\n" +
                "      2.[RefMsgType]372=string\n" +
                "        [MsgDirection]385=S[SEND]\n" +
                "        [RefApplVerID]1130=string\n" +
                "        [RefCstmApplVerID]1131=string\n" +
                "        [RefApplExtID]1406=1234\n" +
                "        [DefaultVerIndicator]1410=true\n" +
                "      3.[RefMsgType]372=string\n" +
                "        [MsgDirection]385=S[SEND]\n" +
                "        [RefApplVerID]1130=string\n" +
                "        [RefCstmApplVerID]1131=string\n" +
                "        [RefApplExtID]1406=1234\n" +
                "        [DefaultVerIndicator]1410=true\n" +
                "Trailer\n" +
                "    [SignatureLength]93=11\n" +
                "    [Signature]89=data\n" +
                "    [CheckSum]10=1234\n";

        when:
        final rawFixExpression = PrettyStripper.stripPrettiness(prettyMessage);
        final MessageExpression messageExpression = (new FlexibleMessageExpressionParser(FIXSPEC)).parse(rawFixExpression);
        final FixMessage fixMessage = messageExpression.asMessage(FIXSPEC);
        final String prettyMessageAfterBeingStrippedAndRebuilt = fixMessage.toPrettyString();

        then:
        assert prettyMessage == prettyMessageAfterBeingStrippedAndRebuilt;
    }
}
