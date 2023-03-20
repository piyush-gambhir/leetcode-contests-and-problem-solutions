/*
Problem Link: https://leetcode.com/problems/remove-duplicates-from-sorted-list/
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
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode currentNode = head;

        while (currentNode != null) {
            ListNode temp = currentNode;
            while (temp != null && temp.val == currentNode.val) {
                temp = temp.next;
            }
            currentNode.next = temp;
            currentNode = currentNode.next;
        }
        return head;
    }
}