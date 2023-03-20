/*
Problem Statement: https://leetcode.com/problems/missing-number/
*/

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums)
            sum += num;
        return n * (n + 1) / 2 - sum;       
    }
}