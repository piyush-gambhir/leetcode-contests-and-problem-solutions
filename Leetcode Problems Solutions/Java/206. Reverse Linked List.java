/*
Problem Link: https://leetcode.com/problems/reverse-linked-list/
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
    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode currentNode, nextNode, prevNode;

        currentNode = head;
        nextNode = null;
        prevNode = null;

        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
        }
        head = prevNode;
        return head;
    }
}