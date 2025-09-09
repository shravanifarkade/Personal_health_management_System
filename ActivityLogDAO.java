

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActivityLogDAO {
    private Connection conn;

    public ActivityLogDAO(Connection conn) {
        this.conn = conn;
    }

    public void insert(ActivityLog activityLog) throws SQLException {
        String sql = "INSERT INTO activity_log (user_id, activity, activity_date) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, activityLog.getUserId());
            stmt.setString(2, activityLog.getActivity());
            stmt.setTimestamp(3, activityLog.getActivityDate());
            stmt.executeUpdate();
        }
    }

    public List<ActivityLog> getAllActivityLogs() throws SQLException {
        List<ActivityLog> activityLogs = new ArrayList<>();
        String sql = "SELECT * FROM activity_log";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                ActivityLog activityLog = new ActivityLog(
                        rs.getInt("log_id"),
                        rs.getInt("user_id"),
                        rs.getString("activity"),
                        rs.getTimestamp("activity_date")
                );
                activityLogs.add(activityLog);
            }
        }
        return activityLogs;
    }

    public void update(int logId, String activity) throws SQLException {
        String sql = "UPDATE activity_log SET activity = ? WHERE log_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, activity);
            stmt.setInt(2, logId);
            stmt.executeUpdate();
        }
    }

    public void delete(int logId) throws SQLException {
        String sql = "DELETE FROM activity_log WHERE log_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, logId);
            stmt.executeUpdate();
        }
    }
}
