/*
Problem Link: https://leetcode.com/problems/house-robber-ii/
*/

class Solution {
    private static int rob(int[] nums, int start, int end) {
        int prev = 0;
        int curr = 0;
        for (int i = start; i <= end; i++) {
            int temp = curr;
            curr = Math.max(prev + nums[i], curr);
            prev = temp;
        }
        return curr;
    }

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }
}