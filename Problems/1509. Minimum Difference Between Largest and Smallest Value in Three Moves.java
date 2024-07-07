/*
Problem Link: https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves/
*/

import java.util.Arrays;

class Solution {
    public int minDifference(int[] nums) {
        if (nums.length <= 4)
            return 0;
        Arrays.sort(nums);
        int n = nums.length;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            res = Math.min(res, nums[n - 4 + i] - nums[i]);
        }
        return res;
    }
}