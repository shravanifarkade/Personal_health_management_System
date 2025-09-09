

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HealthDataDAO {
    private Connection conn;

    public HealthDataDAO(Connection conn) {
        this.conn = conn;
    }

    public void insert(HealthData healthData) throws SQLException {
        String sql = "INSERT INTO health_data (user_id, date_recorded, weight, blood_pressure, heart_rate) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, healthData.getUserId());
            stmt.setDate(2, healthData.getDateRecorded());
            stmt.setDouble(3, healthData.getWeight());
            stmt.setString(4, healthData.getBloodPressure());
            stmt.setInt(5, healthData.getHeartRate());
            stmt.executeUpdate();
        }
    }

    public List<HealthData> getAllHealthData() throws SQLException {
        List<HealthData> healthDataList = new ArrayList<>();
        String sql = "SELECT * FROM health_data";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                HealthData healthData = new HealthData(
                        rs.getInt("data_id"),
                        rs.getInt("user_id"),
                        rs.getDate("date_recorded"),
                        rs.getDouble("weight"),
                        rs.getString("blood_pressure"),
                        rs.getInt("heart_rate")
                );
                healthDataList.add(healthData);
            }
        }
        return healthDataList;
    }

    public void update(int dataId, double weight) throws SQLException {
        String sql = "UPDATE health_data SET weight = ? WHERE data_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, weight);
            stmt.setInt(2, dataId);
            stmt.executeUpdate();
        }
    }

    public void delete(int dataId) throws SQLException {
        String sql = "DELETE FROM health_data WHERE data_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, dataId);
            stmt.executeUpdate();
        }
    }
}
