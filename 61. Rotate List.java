/*
Problem Link: https://leetcode.com/problems/rotate-list/
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

import java.util.*;

class Solution {
    private int size(ListNode head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }

        int size = size(head);
        k = k % size;
        if (k == 0) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = head;

        return newHead;
    }
}