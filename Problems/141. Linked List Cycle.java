/*
Problem Link: https://leetcode.com/problems/linked-list-cycle/
*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

import java.util.*;

public class Solution {
    public boolean hasCycle(ListNode head) {

        ListNode fastNode, slowNode;
        fastNode = head;
        slowNode = head;

        boolean hasLoop = false;

        while (slowNode != null && fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;

            if (slowNode == fastNode) {
                hasLoop = true;
                break;
            }
        }
        return hasLoop;
    }
}