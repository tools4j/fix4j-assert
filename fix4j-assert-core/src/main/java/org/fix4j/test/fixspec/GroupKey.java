package org.fix4j.test.fixspec;

/**
 * User: ben
 * Date: 13/10/2014
 * Time: 7:38 PM
 */
public class GroupKey {
    private final MsgType msgType;
    private final FieldType noOfFieldType;

    public GroupKey(final MsgType msgType, final FieldType noOfFieldType) {
        this.msgType = msgType;
        this.noOfFieldType = noOfFieldType;
    }

    public MsgType getMsgType() {
        return msgType;
    }

    public FieldType getNoOfFieldType() {
        return noOfFieldType;
    }

    @Override
    public String toString() {
        return "GroupKey{" +
                "msgType=" + msgType +
                ", noOfFieldType=" + noOfFieldType +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof GroupKey)) return false;
        final GroupKey groupKey = (GroupKey) o;
        if (!msgType.equals(groupKey.msgType)) return false;
        if (!noOfFieldType.equals(groupKey.noOfFieldType)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = msgType.hashCode();
        result = 31 * result + noOfFieldType.hashCode();
        return result;
    }
}
