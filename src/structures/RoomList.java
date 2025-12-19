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
public class RoomList {
    public RoomNode head;
    
    public RoomList() 
    { 
        head = null; 
    }
    
    public void add(rooms r) {
        RoomNode node = new RoomNode(r);
        if (head == null) {
        head = node;
        return;
        }  
        RoomNode cur = head;
        while (cur.next != null) cur = cur.next;
        cur.next = node;
    }
    
    public RoomNode findById(int id) {
        RoomNode cur = head;
        while (cur != null) {
            if (cur.data.getId() == id) 
                return cur;
            cur = cur.next;
        }
        return null;
    }
    
    public boolean removeById(int id) {
        if (head == null) return false;
        if (head.data.getId() == id) {
            head = head.next;
            return true;
    }
        
    RoomNode cur = head;
        while (cur.next != null) {
            if (cur.next.data.getId() == id) {
                cur.next = cur.next.next;
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
}
