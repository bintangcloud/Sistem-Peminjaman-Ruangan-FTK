/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ACER
 */

import java.time.LocalDateTime;

public class history {

public class History {
    private int id;
    private int roomId;
    private String borrowerName;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String status; // selesai / dibatalkan
    public History() {}
    public History(int roomId, String borrowerName, LocalDateTime startTime,
LocalDateTime endTime, String status) {
        this.roomId = roomId;
        this.borrowerName = borrowerName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
}
// getters & setters
public int getId() { return id; }
public void setId(int id) { this.id = id; }
public int getRoomId() { return roomId; }
    
public void setRoomId(int roomId) { this.roomId = roomId; }
public String getBorrowerName() { return borrowerName; }
public void setBorrowerName(String borrowerName) { this.borrowerName =
borrowerName; }
public LocalDateTime getStartTime() { return startTime; }
public void setStartTime(LocalDateTime startTime) { this.startTime =
startTime; }
public LocalDateTime getEndTime() { return endTime; }
public void setEndTime(LocalDateTime endTime) { this.endTime = endTime; }
public String getStatus() { return status; }
public void setStatus(String status) { this.status = status; }

@Override
public String toString() {
return "History{" +
"id=" + id +
", roomId=" + roomId +
", borrowerName='" + borrowerName + '\'' +
", startTime=" + startTime +
", endTime=" + endTime +
", status='" + status + '\'' +
'}';
}
}
}
