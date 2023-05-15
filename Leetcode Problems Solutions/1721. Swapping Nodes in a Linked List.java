/*
Problem Link: https://leetcode.com/problems/swapping-nodes-in-a-linked-list/
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
    private int listLength(ListNode head) {
        int listLength = 1;
        ListNode currentNode = head;

        while (currentNode != null) {
            listLength++;
            currentNode = currentNode.next;
        }
        return listLength;
    }

    public ListNode swapNodes(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        int listLength = listLength(head);

        if (listLength < k) {
            return head;
        }

        ListNode KthNodeFromStart = null;
        ListNode KthNodeFromEnd = null;

        ListNode currentNode = head;

        int counter = 1;
        while (currentNode != null) {
            if (counter == k) {
                KthNodeFromStart = currentNode;
            }
            if (counter == listLength - k) {
                KthNodeFromEnd = currentNode;
            }
            counter++;
            currentNode = currentNode.next;
        }

        int temp = KthNodeFromStart.val;
        KthNodeFromStart.val = KthNodeFromEnd.val;
        KthNodeFromEnd.val = temp;

        return head;
    }
}