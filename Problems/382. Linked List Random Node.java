/*
Problem Link: https://leetcode.com/problems/linked-list-random-node/
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
    ListNode h;

    public Solution(ListNode head) {
        h = head;
    }

    public int getRandom() {
        Random r = new Random();
        int res = 0;
        int count = 0;
        ListNode curr = h;
        while (curr != null) {
            if (r.nextInt(++count) == 0) {
                res = curr.val;
            }
            curr = curr.next;
        }
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */