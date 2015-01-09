package ${packageName};

import ${packageName}.msgtype.*;
import org.fix4j.test.fixspec.GroupKey;
import org.fix4j.test.fixspec.GroupType;
import org.fix4j.test.fixspec.MsgType;
import org.fix4j.test.fixspec.Tag;
import java.util.LinkedHashMap;
import java.util.Map;

public class MsgTypes {
    private static final Map<String, MsgType> msgTypesByTagStr = new LinkedHashMap<>();
    private static final Map<String, MsgType> msgTypesByName = new LinkedHashMap<>();
    private static final Map<GroupKey, GroupType> groupTypesByKey = new LinkedHashMap<>();
    <%
    def it = messages.iterator();
    while(it.hasNext()){
        def message = it.next();%>
    public static final ${message.name} ${message.name} = register(${packageName}.msgtype.${message.name}.INSTANCE);<%
    }
    %>

    private static <T extends MsgType> T register(final T msgType) {
        msgTypesByTagStr.put(msgType.getTag().getValue(), msgType);
        msgTypesByName.put(msgType.getName(), msgType);
        for(final GroupType groupType: msgType.getAllGroupTypesRecursively()){
            groupTypesByKey.put(groupType.getGroupKey(msgType), groupType);
        }
        return msgType;
    }

    //Private, as this sucker should not be instantiated
    private MsgTypes(){}

    public static MsgType getMsgTypeByTag(final Tag<String> tag) {
        return msgTypesByTagStr.get(tag.getValue());
    }

    public static GroupType getGroupTypeByKey(final GroupKey groupKey) {
        return groupTypesByKey.get(groupKey);
    }

    public static MsgType getMsgTypeByName(final String msgTypeName) {
        return msgTypesByName.get(msgTypeName);
    }
}
