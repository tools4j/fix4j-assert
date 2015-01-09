package org.fix4j.test.session;

/**
 * User: ben
 * Date: 20/08/2014
 * Time: 5:51 AM
 */
public class FixSessionId {
    private final String beginString;
    private final String senderCompId;
    private final String targetCompId;

    public FixSessionId(final String beginString, final String senderCompId, final String targetCompId) {
        this.beginString = beginString;
        this.senderCompId = senderCompId;
        this.targetCompId = targetCompId;
    }

    public String getBeginString() {
        return beginString;
    }

    public String getSenderCompId() {
        return senderCompId;
    }

    public String getTargetCompId() {
        return targetCompId;
    }

    @Override
    public String toString() {
        return beginString + ":" + senderCompId + "->" + targetCompId;
    }

    /**
     * @return A FixSessionId with sender and target compIDs switched.
     */
    public FixSessionId reverse(){
        return new FixSessionId(beginString, targetCompId, senderCompId);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof FixSessionId)) return false;

        final FixSessionId that = (FixSessionId) o;

        if (!beginString.equals(that.beginString)) return false;
        if (!senderCompId.equals(that.senderCompId)) return false;
        if (!targetCompId.equals(that.targetCompId)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = beginString.hashCode();
        result = 31 * result + senderCompId.hashCode();
        result = 31 * result + targetCompId.hashCode();
        return result;
    }
}
