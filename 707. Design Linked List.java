/*
Problem Link: https://leetcode.com/problems/design-linked-list/
*/

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

import java.util.*;

class MyLinkedList {

    class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    int size;
    Node head;
    Node tail;

    public MyLinkedList() {
        size = 0;
        head = null;
        tail = null;
    }

    public int get(int index) {
        if (index < 0 || index >= size)
            return -1;
        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;
        if (tail == null) {
            tail = head;
        }
        size++;
    }

    public void addAtTail(int val) {
        Node node = new Node(val);
        if (tail == null) {
            tail = node;
            head = tail;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size)
            return;
        if (index == 0) {
            addAtHead(val);
            return;
        }
        if (index == size) {
            addAtTail(val);
            return;
        }
        Node node = new Node(val);
        Node cur = head;
        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
        }
        node.next = cur.next;
        cur.next = node;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size)
            return;
        if (index == 0) {
            head = head.next;
            if (head == null)
                tail = null;
            size--;
            return;
        }
        Node cur = head;
        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        if (cur.next == null)
            tail = cur;
        size--;
    }
}
