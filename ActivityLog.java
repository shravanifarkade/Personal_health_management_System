import java.sql.Timestamp;

public class ActivityLog {
    private int logId;
    private int userId;
    private String activity;
    private Timestamp activityDate;

    public ActivityLog() {}

    public ActivityLog(int logId, int userId, String activity, Timestamp activityDate) {
        this.logId = logId;
        this.userId = userId;
        this.activity = activity;
        this.activityDate = activityDate;
    }

    // Getters and Setters
    public int getLogId() { return logId; }
    public void setLogId(int logId) { this.logId = logId; }
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
    public String getActivity() { return activity; }
    public void setActivity(String activity) { this.activity = activity; }
    public Timestamp getActivityDate() { return activityDate; }
    public void setActivityDate(Timestamp activityDate) { this.activityDate = activityDate; }

    @Override
    public String toString() {
        return logId + ": User ID " + userId + " - Activity: " + activity + " on " + activityDate;
    }
}
