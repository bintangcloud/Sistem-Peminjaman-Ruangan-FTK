/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author binta
 */
public class rooms {
    private int id; 
    private String name; 
    private String type; 
    private int capacity;
    private String status; // available / booked public Room() {}

    public rooms(int id, String name, String type, int capacity, String status) {
        this.id = id; 
        this.name = name; 
        this.type = type;
        this.capacity = capacity; 
        this.status = status;
}

public rooms(String name, String type, int capacity) { 
    this.name = name;
    this.type = type; 
    this.capacity = capacity; 
    this.status = "available";
}

    public rooms() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

// getters & setters
public int getId() { return id; }
public void setId(int id) { this.id = id; } 
public String getName() { return name; }
public void setName(String name) { this.name = name; } 
public String getType() { return type; }
public void setType(String type) { this.type = type; } 
public int getCapacity() { return capacity; }
public void setCapacity(int capacity) { this.capacity = capacity; } 
public String getStatus() { return status; }
public void setStatus(String status) { this.status = status; }

@Override
public String toString() { return "Room{" +
"id=" + id +
", name='" + name + '\'' +
", type='" + type + '\'' + ", capacity=" + capacity +
", status='" + status + '\'' + '}';
}
    
};
