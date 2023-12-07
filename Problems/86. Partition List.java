/*
Problem Link: https://leetcode.com/problems/partition-list/
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
    public ListNode partition(ListNode head, int x) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode currentNode = head;
        ListNode small = new ListNode(0);
        ListNode smallHead = small;
        ListNode large = new ListNode(0);
        ListNode largeHead = large;

        while (currentNode != null) {
            if (currentNode.val < x) {
                small.next = currentNode;
                small = small.next;
            } else {
                large.next = currentNode;
                large = large.next;
            }
            currentNode = currentNode.next;
        }
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
    }
}