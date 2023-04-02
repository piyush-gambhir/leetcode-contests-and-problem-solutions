/*
Problem Link: https://leetcode.com/problems/add-two-numbers-ii/
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
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null || l2 == null) {
            return null;
        }

        if (l1 == null && l2 != null) {
            return l1;
        }

        if (l1 != null && l2 == null) {
            return l2;
        }

        // ListNode l1Reversed = reverseList(l1);
        // ListNode l2Reversed = reverseList(l2);

        // ListNode dummy = new ListNode(0);
        // ListNode node = dummy;

        // int carry = 0;

        // while (l1Reversed != null || l2Reversed != null) {
        // int sum = carry;

        // if (l1Reversed != null) {
        // sum += l1Reversed.val;
        // l1Reversed = l1Reversed.next;
        // }

        // if (l2Reversed != null) {
        // sum += l2Reversed.val;
        // l2Reversed = l2Reversed.next;
        // }

        // carry = sum / 10;

        // node.next = new ListNode(sum % 10);
        // node = node.next;
        // }

        // if (carry != 0) {
        // node.next = new ListNode(carry);
        // }

        // return dummy.next;

        Stack<Integer> l1Stack = new Stack<>();
        Stack<Integer> l2Stack = new Stack<>();

        ListNode temp1 = l1;
        ListNode temp2 = l2;

        ListNode dummy = new ListNode(0);
        ListNode node = dummy;

        while (temp1 != null && temp2 != null) {
            if (temp1 != null) {
                l1Stack.push(temp1.val);
                temp1 = temp1.next;
            }

            if (temp2 != null) {
                l2Stack.push(temp2.val);
                temp2 = temp2.next;
            }
        }

        int carry = 0;
        while (!l1Stack.isEmpty() && !l2Stack.isEmpty()) {
            int sum = carry;
            if (!l1Stack.isEmpty()) {
                sum += l1Stack.pop();
            }
            if (!l2Stack.isEmpty()) {
                sum += l2Stack.pop();
            }
            carry = sum / 10;
            node.next = new ListNode(sum % 10);
            node = node.next;
        }

        if (carry != 0) {
            node.next = new ListNode(carry);
        }

        return dummy.next;
    }
}