package model;

import java.time.LocalDateTime;

public class booking {
    private int id;
    private int roomId;
    private String borrowerName;
    private String borrowerType;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public booking() {}

    public booking(int roomId, String borrowerName, String borrowerType, LocalDateTime startTime, LocalDateTime endTime) {
        this.roomId = roomId;
        this.borrowerName = borrowerName;
        this.borrowerType = borrowerType;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getRoomId() { return roomId; }
    public void setRoomId(int roomId) { this.roomId = roomId; }

    public String getBorrowerName() { return borrowerName; }
    public void setBorrowerName(String borrowerName) { this.borrowerName = borrowerName; }

    public String getBorrowerType() { return borrowerType; }
    public void setBorrowerType(String borrowerType) { this.borrowerType = borrowerType; }

    public LocalDateTime getStartTime() { return startTime; }
    public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }

    public LocalDateTime getEndTime() { return endTime; }
    public void setEndTime(LocalDateTime endTime) { this.endTime = endTime; }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", roomId=" + roomId +
                ", borrowerName='" + borrowerName + '\'' +
                ", borrowerType='" + borrowerType + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
