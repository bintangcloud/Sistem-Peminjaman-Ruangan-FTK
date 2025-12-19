/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import model.booking;
import util.DatabaseConnection;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class bookingdao {
    public boolean insert(booking b) {
        String sql = "INSERT INTO bookings(room_id, borrower_name, borrower_type, start_time, end_time) " +
                     "VALUES(?, ?, ?, ?, ?)";
        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement p = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            p.setInt(1, b.getRoomId());
            p.setString(2, b.getBorrowerName());
            p.setString(3, b.getBorrowerType());
            p.setTimestamp(4, Timestamp.valueOf(b.getStartTime()));
            p.setTimestamp(5, Timestamp.valueOf(b.getEndTime()));

            int affected = p.executeUpdate();
            if (affected > 0) {
                try (ResultSet keys = p.getGeneratedKeys()) {
                    if (keys.next()) b.setId(keys.getInt(1));
                }
                return true;
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return false;
    }

    public List<booking> getByRoomId(int roomId) {
        List<booking> list = new ArrayList<>();
        String sql = "SELECT * FROM bookings WHERE room_id = ? ORDER BY start_time";
        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement p = c.prepareStatement(sql)) {

            p.setInt(1, roomId);
            try (ResultSet rs = p.executeQuery()) {
                while (rs.next()) {
                    booking b = new booking();
                    b.setId(rs.getInt("booking_id"));
                    b.setRoomId(rs.getInt("room_id"));
                    b.setBorrowerName(rs.getString("borrower_name"));
                    b.setBorrowerType(rs.getString("borrower_type"));
                    Timestamp tsStart = rs.getTimestamp("start_time");
                    Timestamp tsEnd = rs.getTimestamp("end_time");
                    if (tsStart != null) b.setStartTime(tsStart.toLocalDateTime());
                    if (tsEnd != null) b.setEndTime(tsEnd.toLocalDateTime());
                    list.add(b);
                }
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }

    public boolean delete(int bookingId) {
        String sql = "DELETE FROM bookings WHERE booking_id = ?";
        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement p = c.prepareStatement(sql)) {
            p.setInt(1, bookingId);
            return p.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); }
        return false;
    }

    public boolean isConflict(int roomId, LocalDateTime start, LocalDateTime end) {
        String sql = "SELECT COUNT(*) AS cnt FROM bookings WHERE room_id = ? AND (start_time < ? AND end_time > ?)";
        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement p = c.prepareStatement(sql)) {

            p.setInt(1, roomId);
            p.setTimestamp(2, Timestamp.valueOf(end));
            p.setTimestamp(3, Timestamp.valueOf(start));

            try (ResultSet rs = p.executeQuery()) {
                if (rs.next()) return rs.getInt("cnt") > 0;
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return false;
    }

    public List<booking> getAll() {
        List<booking> list = new ArrayList<>();
        String sql = "SELECT * FROM bookings ORDER BY start_time";
        try (Connection c = DatabaseConnection.getConnection();
             Statement s = c.createStatement();
             ResultSet rs = s.executeQuery(sql)) {

            while (rs.next()) {
                booking b = new booking();
                b.setId(rs.getInt("booking_id"));
                b.setRoomId(rs.getInt("room_id"));
                b.setBorrowerName(rs.getString("borrower_name"));
                b.setBorrowerType(rs.getString("borrower_type"));
                Timestamp tsStart = rs.getTimestamp("start_time");
                Timestamp tsEnd = rs.getTimestamp("end_time");
                if (tsStart != null) b.setStartTime(tsStart.toLocalDateTime());
                if (tsEnd != null) b.setEndTime(tsEnd.toLocalDateTime());
                list.add(b);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }
}
