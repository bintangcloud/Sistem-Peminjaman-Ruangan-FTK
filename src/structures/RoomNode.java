/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package structures;
import model.rooms;
/**
 *
 * @author binta
 */
public class RoomNode {
    public rooms data;
    public RoomNode next;
    
    public RoomNode(rooms data) {
        this.data = data;
        this.next = null;
}
}
