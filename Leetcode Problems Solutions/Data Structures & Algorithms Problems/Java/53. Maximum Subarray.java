/*
Problem Statement: https://leetcode.com/problems/maximum-subarray/
*/

class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int sum = 0;
        for (int num: nums) {
            sum += num;
            maxSum = Math.max(maxSum, sum);
            sum = Math.max(sum, 0);
        }
        return maxSum;
    }
}