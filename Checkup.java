// Checkup.java

import java.sql.Date;

public class Checkup {
    private int checkupId;
    private int userId;
    private int doctorId;
    private Date date;
    private String notes;

    public Checkup() {}

    public Checkup(int checkupId, int userId, int doctorId, Date date, String notes) {
        this.checkupId = checkupId;
        this.userId = userId;
        this.doctorId = doctorId;
        this.date = date;
        this.notes = notes;
    }

    // Getters and Setters
    public int getCheckupId() { return checkupId; }
    public void setCheckupId(int checkupId) { this.checkupId = checkupId; }
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
    public int getDoctorId() { return doctorId; }
    public void setDoctorId(int doctorId) { this.doctorId = doctorId; }
    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    @Override
    public String toString() {
        return checkupId + ": User ID " + userId + " - Doctor ID " + doctorId + " on " + date + " - Notes: " + notes;
    }
}
