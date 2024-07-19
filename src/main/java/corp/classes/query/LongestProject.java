package corp.classes.query;

public class LongestProject {
    private final String clientName;
    private final int monthCount;

    public LongestProject(String clientName, int monthCount) {
        this.clientName = clientName;
        this.monthCount = monthCount;
    }

    public String getClientName() {
        return clientName;
    }

    public int getMonthCount() {
        return monthCount;
    }
}
