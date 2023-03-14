/*
Problem Link: https://leetcode.com/problems/smallest-range-ii/
*/

import java.util.*;

class Solution {
    public int smallestRangeII(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int score = nums[n - 1] - nums[0];
        for (int i = 0; i < n - 1; i++) {
            int a = nums[i];
            int b = nums[i + 1];
            int max = Math.max(nums[n - 1] - k, a + k);
            int min = Math.min(nums[0] + k, b - k);
            score = Math.min(score, max - min);
        }
        return score;
    }
}