/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ACER
 */

import java.time.LocalDate;
import java.time.LocalTime;

public class WaitingList {

    private int id;
    private int roomId;
    private String borrowerName;
    private LocalDate bookingDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private String status; 
    // waiting | accepted | expired

    // 🔹 Constructor untuk insert baru (id auto dari DB)
    public WaitingList(int roomId, String borrowerName,
                       LocalDate bookingDate,
                       LocalTime startTime,
                       LocalTime endTime) {
        this.roomId = roomId;
        this.borrowerName = borrowerName;
        this.bookingDate = bookingDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = "waiting";
    }

    // 🔹 Constructor lengkap (biasanya dipakai DAO saat ambil dari DB)
    public WaitingList(int id, int roomId, String borrowerName,
                       LocalDate bookingDate,
                       LocalTime startTime,
                       LocalTime endTime,
                       String status) {
        this.id = id;
        this.roomId = roomId;
        this.borrowerName = borrowerName;
        this.bookingDate = bookingDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
    }

    // ================= GETTER =================

    public int getId() {
        return id;
    }

    public int getRoomId() {
        return roomId;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public String getStatus() {
        return status;
    }

    // ================= SETTER =================

    public void setId(int id) {
        this.id = id;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}