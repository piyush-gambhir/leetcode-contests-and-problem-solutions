/*
Problem Link: https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/
*/

import java.util.*;

class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                count = 0;
            }
            left[i] = count;
        }
        count = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] == 1) {
                count++;
            } else {
                count = 0;
            }
            right[i] = count;
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                max = Math.max(max, right[i + 1]);
            } else if (i == n - 1) {
                max = Math.max(max, left[i - 1]);
            } else {
                max = Math.max(max, left[i - 1] + right[i + 1]);
            }
        }
        return max;
    }
}