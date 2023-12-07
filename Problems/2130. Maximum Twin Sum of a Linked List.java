/*
Problem Link:  https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/
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
    private ListNode midNode(ListNode head) {
        ListNode slowNode = head;
        ListNode fastNode = head;

        while (fastNode.next != null && fastNode.next.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }

        return slowNode;
    }

    private ListNode reverseList(ListNode head) {
        ListNode currentNode = head;
        ListNode nextNode = null;
        ListNode prevNode = null;

        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = prevNode;

            prevNode = currentNode;
            currentNode = nextNode;
        }

        return prevNode;
    }

    public int pairSum(ListNode head) {
        if (head == null) {
            return -1;
        }

        ListNode midNode = midNode(head);
        ListNode head2 = midNode.next;
        midNode.next = null;

        head2 = reverseList(head2);

        ListNode currentNode1 = head;
        ListNode currentNode2 = head2;

        int maxSum = Integer.MIN_VALUE;
        while (currentNode1 != null && currentNode2 != null) {
            maxSum = Math.max(maxSum, currentNode1.val + currentNode2.val);
            currentNode1 = currentNode1.next;
            currentNode2 = currentNode2.next;
        }

        return maxSum;
    }
}