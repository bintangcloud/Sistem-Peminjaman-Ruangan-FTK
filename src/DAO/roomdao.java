/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import model.rooms;
import util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class roomdao {
    public List<rooms> getAll() {
        List<rooms> list = new ArrayList<>();

        String sql = "SELECT * FROM rooms ORDER BY id";

        try (Connection c = DatabaseConnection.getConnection();
             Statement s = c.createStatement();
             ResultSet rs = s.executeQuery(sql)) {

            while (rs.next()) {
                rooms r = new rooms();
                r.setId(rs.getInt("id"));
                r.setName(rs.getString("name"));
                r.setType(rs.getString("type"));
                r.setCapacity(rs.getInt("capacity"));
                r.setStatus(rs.getString("status"));
                list.add(r);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    // GET BY ID
    public rooms getById(int id) {
        String sql = "SELECT * FROM rooms WHERE id = ?";

        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement p = c.prepareStatement(sql)) {

            p.setInt(1, id);

            try (ResultSet rs = p.executeQuery()) {
                if (rs.next()) {
                    rooms r = new rooms();
                    r.setId(rs.getInt("id"));
                    r.setName(rs.getString("name"));
                    r.setType(rs.getString("type"));
                    r.setCapacity(rs.getInt("capacity"));
                    r.setStatus(rs.getString("status"));
                    return r;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


    // INSERT
    public boolean insert(rooms r) {
        String sql = "INSERT INTO rooms(name, type, capacity, status) VALUES (?, ?, ?, ?)";

        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement p = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            p.setString(1, r.getName());
            p.setString(2, r.getType());
            p.setInt(3, r.getCapacity());
            p.setString(4, r.getStatus() == null ? "available" : r.getStatus());

            int affected = p.executeUpdate();

            if (affected > 0) {
                try (ResultSet keys = p.getGeneratedKeys()) {
                    if (keys.next()) {
                        r.setId(keys.getInt(1));
                    }
                }
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    public boolean updateStatus(int id, String status) {
        String sql = "UPDATE rooms SET status = ? WHERE id = ?";

        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement p = c.prepareStatement(sql)) {

            p.setString(1, status);
            p.setInt(2, id);

            return p.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    public boolean delete(int id) {
        String sql = "DELETE FROM rooms WHERE id = ?";

        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement p = c.prepareStatement(sql)) {

            p.setInt(1, id);

            return p.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}

    