package DAO;

import model.history;
import util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class historydao {

    // INSERT ke tabel history
    public boolean insert(history h) {
        String sql = "INSERT INTO history " +
                     "(room_id, borrower_name, start_time, end_time, status) " +
                     "VALUES (?, ?, ?, ?, ?)";

        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement p = c.prepareStatement(
                     sql, Statement.RETURN_GENERATED_KEYS)) {

            p.setInt(1, h.getRoomId());
            p.setString(2, h.getBorrowerName());
            p.setTimestamp(3, Timestamp.valueOf(h.getStartTime()));
            p.setTimestamp(4, Timestamp.valueOf(h.getEndTime()));
            p.setString(5, h.getStatus());

            int affected = p.executeUpdate();

            if (affected > 0) {
                try (ResultSet keys = p.getGeneratedKeys()) {
                    if (keys.next()) {
                        h.setId(keys.getInt(1));
                    }
                }
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // GET semua data history
    public List<history> getAll() {
        List<history> list = new ArrayList<>();
        String sql = "SELECT * FROM history ORDER BY start_time DESC";

        try (Connection c = DatabaseConnection.getConnection();
             Statement s = c.createStatement();
             ResultSet rs = s.executeQuery(sql)) {

            while (rs.next()) {
                history h = new history();
                h.setId(rs.getInt("id"));
                h.setRoomId(rs.getInt("room_id"));
                h.setBorrowerName(rs.getString("borrower_name"));
                h.setStartTime(rs.getTimestamp("start_time").toLocalDateTime());
                h.setEndTime(rs.getTimestamp("end_time").toLocalDateTime());
                h.setStatus(rs.getString("status"));
                list.add(h);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
