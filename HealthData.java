
import java.sql.Date;

public class HealthData {
    private int dataId;
    private int userId;
    private Date dateRecorded;
    private double weight;
    private String bloodPressure;
    private int heartRate;

    public HealthData() {}

    public HealthData(int dataId, int userId, Date dateRecorded, double weight, String bloodPressure, int heartRate) {
        this.dataId = dataId;
        this.userId = userId;
        this.dateRecorded = dateRecorded;
        this.weight = weight;
        this.bloodPressure = bloodPressure;
        this.heartRate = heartRate;
    }

    // Getters and Setters
    public int getDataId() { return dataId; }
    public void setDataId(int dataId) { this.dataId = dataId; }
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
    public Date getDateRecorded() { return dateRecorded; }
    public void setDateRecorded(Date dateRecorded) { this.dateRecorded = dateRecorded; }
    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }
    public String getBloodPressure() { return bloodPressure; }
    public void setBloodPressure(String bloodPressure) { this.bloodPressure = bloodPressure; }
    public int getHeartRate() { return heartRate; }
    public void setHeartRate(int heartRate) { this.heartRate = heartRate; }

    @Override
    public String toString() {
        return dataId + ": User ID " + userId + " - Recorded on " + dateRecorded + " - Weight: " + weight + ", BP: " + bloodPressure + ", HR: " + heartRate;
    }
}
