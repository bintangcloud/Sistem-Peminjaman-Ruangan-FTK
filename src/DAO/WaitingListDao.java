/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author trila
 */
import util.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WaitingListDao {

    // INSERT ke waiting list
    public boolean insert(int roomId, String name) {
        String sql = "INSERT INTO waiting_list (room_id, name) VALUES (?, ?)";

        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement p = c.prepareStatement(sql)) {

            p.setInt(1, roomId);
            p.setString(2, name);
            return p.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // GET waiting list berdasarkan room
    public List<String> getByRoomId(int roomId) {
        List<String> list = new ArrayList<>();
        String sql = "SELECT name FROM waiting_list " +
                     "WHERE room_id = ? ORDER BY request_time";

        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement p = c.prepareStatement(sql)) {

            p.setInt(1, roomId);

            try (ResultSet rs = p.executeQuery()) {
                while (rs.next()) {
                    list.add(rs.getString("name"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    // DELETE antrean paling lama
    public boolean deleteOldest(int roomId) {
        String sql = "DELETE FROM waiting_list WHERE id = (" +
                     "SELECT id FROM (" +
                     "SELECT id FROM waiting_list WHERE room_id = ? " +
                     "ORDER BY request_time LIMIT 1" +
                     ") x)";

        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement p = c.prepareStatement(sql)) {

            p.setInt(1, roomId);
            return p.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
