/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package structures;

/**
 *
 * @author binta
 */
public class BorrowerBST {
    public static class Node {
        String name;
        String room;
        Node left, right;
        public Node(String name, String room) {
            this.name = name;
            this.room = room;
        }
    }
    
    public Node root;
    
    public BorrowerBST() { root = null; }
    
    public void insert(String name, String room) {
        root = insertRec(root, name, room);
    }
    
    private Node insertRec(Node cur, String name, String room) {
        if (cur == null) return new Node(name, room);
        int cmp = name.compareToIgnoreCase(cur.name);
        if (cmp < 0) cur.left = insertRec(cur.left, name, room);
        else cur.right = insertRec(cur.right, name, room);
        return cur;
    }
    
    public Node search(String name) {
        Node cur = root;
        while (cur != null) {
            int cmp = name.compareToIgnoreCase(cur.name);
            if (cmp == 0) return cur;
            if (cmp < 0) cur = cur.left; else cur = cur.right;
        }
        return null;
    }
}
