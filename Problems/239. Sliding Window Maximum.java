/*
Problem Link: https://leetcode.com/problems/sliding-window-maximum/
*/

import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Deque<Integer> dq = new LinkedList<>();

        int i = 0;
        for (; i < k; i++) {
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.removeLast();
            }
            dq.addLast(i);
        }

        for (; i < n; i++) {
            ans[i - k] = nums[dq.peekFirst()];

            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.removeFirst();
            }

            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.removeLast();
            }
            dq.addLast(i);
        }
        ans[i - k] = nums[dq.peekFirst()];

        return ans;
    }
}