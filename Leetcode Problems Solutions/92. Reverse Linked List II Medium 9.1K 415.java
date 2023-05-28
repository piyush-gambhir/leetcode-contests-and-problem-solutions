/*
Problem Link: https://leetcode.com/problems/reverse-linked-list-ii/
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

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode currentNode = head;

        ListNode prevNode = null;
        ListNode nextNode = null;

        int counter = 1;
        while (counter < left) {
            if (counter == left - 1) {
                prevNode = currentNode;
            }
            counter++;
        }

        currentNode = currentNode.next;

        while (counter <= right) {
            nextNode = currentNode.next;
            currentNode.next = nextNode.next;
            nextNode.next = prevNode.next;
            prevNode.next = nextNode;
        }

        return head;
    }
}