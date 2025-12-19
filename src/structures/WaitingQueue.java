/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package structures;

/**
 *
 * @author binta
 */
public class WaitingQueue {
    private static class Node {
        String name;
        Node next;
        Node(String name) { 
            this.name = name; 
        }
    }
    
    private Node front, rear;
    
    public WaitingQueue() { 
        front = rear = null; 
    }
    
    public void enqueue(String name) {
        Node node = new Node(name);
        if (rear == null) {
            front = rear = node;
            return;
        }
        rear.next = node;
        rear = node;
    }
    
    public String dequeue() {
        if (front == null) return null;
        String val = front.name;
        front = front.next;
        if (front == null) rear = null;
        return val;
    }
    
    public boolean isEmpty() { return front == null; }
}

