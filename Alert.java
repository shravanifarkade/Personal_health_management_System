// Alert.java

import java.sql.Timestamp;

public class Alert {
    private int alertId;
    private int userId;
    private String alertMessage;
    private Timestamp alertDate;

    public Alert() {}

    public Alert(int alertId, int userId, String alertMessage, Timestamp alertDate) {
        this.alertId = alertId;
        this.userId = userId;
        this.alertMessage = alertMessage;
        this.alertDate = alertDate;
    }

    // Getters and Setters
    public int getAlertId() { return alertId; }
    public void setAlertId(int alertId) { this.alertId = alertId; }
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
    public String getAlertMessage() { return alertMessage; }
    public void setAlertMessage(String alertMessage) { this.alertMessage = alertMessage; }
    public Timestamp getAlertDate() { return alertDate; }
    public void setAlertDate(Timestamp alertDate) { this.alertDate = alertDate; }

    @Override
    public String toString() {
        return alertId + ": User ID " + userId + " - " + alertMessage + " on " + alertDate;
    }
}
