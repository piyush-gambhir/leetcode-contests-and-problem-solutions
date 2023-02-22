/*
Problem Link: https://leetcode.com/problems/reverse-nodes-in-k-group/
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
    private static ListNode reverse(ListNode prev, ListNode next) {
        ListNode last = prev.next;
        ListNode curr = last.next;

        while (curr != next) {
            last.next = curr.next;
            curr.next = prev.next;
            prev.next = curr;
            curr = last.next;
        }

        return last;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        ListNode next = null;
        int count = 0;

        while (curr != null) {
            count++;
            next = curr.next;
            if (count == k) {
                prev = reverse(prev, next);
                count = 0;
            }
            curr = next;
        }

        return dummy.next;
    }
}