


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlertDAO {
    private Connection conn;

    public AlertDAO(Connection conn) {
        this.conn = conn;
    }

    public void insert(Alert alert) throws SQLException {
        String sql = "INSERT INTO alerts (user_id, alert_message, alert_date) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, alert.getUserId());
            stmt.setString(2, alert.getAlertMessage());
            stmt.setTimestamp(3, alert.getAlertDate());
            stmt.executeUpdate();
        }
    }

    public List<Alert> getAllAlerts() throws SQLException {
        List<Alert> alerts = new ArrayList<>();
        String sql = "SELECT * FROM alerts";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Alert alert = new Alert(
                        rs.getInt("alert_id"),
                        rs.getInt("user_id"),
                        rs.getString("alert_message"),
                        rs.getTimestamp("alert_date")
                );
                alerts.add(alert);
            }
        }
        return alerts;
    }

    public void update(int alertId, String alertMessage) throws SQLException {
        String sql = "UPDATE alerts SET alert_message = ? WHERE alert_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, alertMessage);
            stmt.setInt(2, alertId);
            stmt.executeUpdate();
        }
    }

    public void delete(int alertId) throws SQLException {
        String sql = "DELETE FROM alerts WHERE alert_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, alertId);
            stmt.executeUpdate();
        }
    }
}
