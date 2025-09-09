// MedicalHistoryDAO.java

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedicalHistoryDAO {
    private Connection conn;

    public MedicalHistoryDAO(Connection conn) {
        this.conn = conn;
    }

    public void insert(MedicalHistory medicalHistory) throws SQLException {
        String sql = "INSERT INTO medical_history (user_id, condition_name, diagnosis_date, treatment) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, medicalHistory.getUserId());
            stmt.setString(2, medicalHistory.getConditionName());
            stmt.setDate(3, medicalHistory.getDiagnosisDate());
            stmt.setString(4, medicalHistory.getTreatment());
            stmt.executeUpdate();
        }
    }

    public List<MedicalHistory> getAllMedicalHistories() throws SQLException {
        List<MedicalHistory> medicalHistories = new ArrayList<>();
        String sql = "SELECT * FROM medical_history";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                MedicalHistory medicalHistory = new MedicalHistory(
                        rs.getInt("history_id"),
                        rs.getInt("user_id"),
                        rs.getString("condition_name"),
                        rs.getDate("diagnosis_date"),
                        rs.getString("treatment")
                );
                medicalHistories.add(medicalHistory);
            }
        }
        return medicalHistories;
    }

    public void update(int historyId, String treatment) throws SQLException {
        String sql = "UPDATE medical_history SET treatment = ? WHERE history_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, treatment);
            stmt.setInt(2, historyId);
            stmt.executeUpdate();
        }
    }

    public void delete(int historyId) throws SQLException {
        String sql = "DELETE FROM medical_history WHERE history_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, historyId);
            stmt.executeUpdate();
        }
    }
}