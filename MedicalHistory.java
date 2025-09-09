import java.sql.Date;

public class MedicalHistory {
    private int historyId;
    private int userId;
    private String conditionName;
    private Date diagnosisDate;
    private String treatment;

    public MedicalHistory() {}

    public MedicalHistory(int historyId, int userId, String conditionName, Date diagnosisDate, String treatment) {
        this.historyId = historyId;
        this.userId = userId;
        this.conditionName = conditionName;
        this.diagnosisDate = diagnosisDate;
        this.treatment = treatment;
    }

    // Getters and Setters
    public int getHistoryId() { return historyId; }
    public void setHistoryId(int historyId) { this.historyId = historyId; }
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
    public String getConditionName() { return conditionName; }
    public void setConditionName(String conditionName) { this.conditionName = conditionName; }
    public Date getDiagnosisDate() { return diagnosisDate; }
    public void setDiagnosisDate(Date diagnosisDate) { this.diagnosisDate = diagnosisDate; }
    public String getTreatment() { return treatment; }
    public void setTreatment(String treatment) { this.treatment = treatment; }

    @Override
    public String toString() {
        return historyId + ": User ID " + userId + " - Condition: " + conditionName + ", Diagnosis Date: " + diagnosisDate + ", Treatment: " + treatment;
    }
}