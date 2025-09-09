

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PrescriptionDAO {
    private Connection conn;

    public PrescriptionDAO(Connection conn) {
        this.conn = conn;
    }

    public void insert(Prescription prescription) throws SQLException {
        String sql = "INSERT INTO prescription (checkup_id, medicine_name, dosage, duration) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, prescription.getCheckupId());
            stmt.setString(2, prescription.getMedicineName());
            stmt.setString(3, prescription.getDosage());
            stmt.setString(4, prescription.getDuration());
            stmt.executeUpdate();
        }
    }

    public List<Prescription> getAllPrescriptions() throws SQLException {
        List<Prescription> prescriptions = new ArrayList<>();
        String sql = "SELECT * FROM prescription";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Prescription prescription = new Prescription(
                        rs.getInt("prescription_id"),
                        rs.getInt("checkup_id"),
                        rs.getString("medicine_name"),
                        rs.getString("dosage"),
                        rs.getString("duration")
                );
                prescriptions.add(prescription);
            }
        }
        return prescriptions;
    }

    public void update(int prescriptionId, String medicineName, String dosage) throws SQLException {
        String sql = "UPDATE prescription SET medicine_name = ?, dosage = ? WHERE prescription_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, medicineName);
            stmt.setString(2, dosage);
            stmt.setInt(3, prescriptionId);
            stmt.executeUpdate();
        }
    }

    public void delete(int prescriptionId) throws SQLException {
        String sql = "DELETE FROM prescription WHERE prescription_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, prescriptionId);
            stmt.executeUpdate();
        }
    }
}
