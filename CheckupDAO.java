// CheckupDAO.java

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CheckupDAO {
    private Connection conn;

    public CheckupDAO(Connection conn) {
        this.conn = conn;
    }

    public void insert(Checkup checkup) throws SQLException {
        String sql = "INSERT INTO checkup (user_id, doctor_id, date, notes) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, checkup.getUserId());
            stmt.setInt(2, checkup.getDoctorId());
            stmt.setDate(3, checkup.getDate());
            stmt.setString(4, checkup.getNotes());
            stmt.executeUpdate();
        }
    }

    public List<Checkup> getAllCheckups() throws SQLException {
        List<Checkup> checkups = new ArrayList<>();
        String sql = "SELECT * FROM checkup";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Checkup checkup = new Checkup(
                        rs.getInt("checkup_id"),
                        rs.getInt("user_id"),
                        rs.getInt("doctor_id"),
                        rs.getDate("date"),
                        rs.getString("notes")
                );
                checkups.add(checkup);
            }
        }
        return checkups;
    }

    public void update(int checkupId, int doctorId, String notes) throws SQLException {
        String sql = "UPDATE checkup SET doctor_id = ?, notes = ? WHERE checkup_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, doctorId);
            stmt.setString(2, notes);
            stmt.setInt(3, checkupId);
            stmt.executeUpdate();
        }
    }

    public void delete(int checkupId) throws SQLException {
        String sql = "DELETE FROM checkup WHERE checkup_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, checkupId);
            stmt.executeUpdate();
        }
    }
}
