// Prescription.java

public class Prescription {
    private int prescriptionId;
    private int checkupId;
    private String medicineName;
    private String dosage;
    private String duration;

    public Prescription() {}

    public Prescription(int prescriptionId, int checkupId, String medicineName, String dosage, String duration) {
        this.prescriptionId = prescriptionId;
        this.checkupId = checkupId;
        this.medicineName = medicineName;
        this.dosage = dosage;
        this.duration = duration;
    }

    // Getters and Setters
    public int getPrescriptionId() { return prescriptionId; }
    public void setPrescriptionId(int prescriptionId) { this.prescriptionId = prescriptionId; }
    public int getCheckupId() { return checkupId; }
    public void setCheckupId(int checkupId) { this.checkupId = checkupId; }
    public String getMedicineName() { return medicineName; }
    public void setMedicineName(String medicineName) { this.medicineName = medicineName; }
    public String getDosage() { return dosage; }
    public void setDosage(String dosage) { this.dosage = dosage; }
    public String getDuration() { return duration; }
    public void setDuration(String duration) { this.duration = duration; }

    @Override
    public String toString() {
        return prescriptionId + ": Checkup ID " + checkupId + " - Medicine: " + medicineName + ", Dosage: " + dosage + ", Duration: " + duration;
    }
}
