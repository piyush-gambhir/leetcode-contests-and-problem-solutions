/*
Problem Link: https://leetcode.com/problems/squares-of-a-sorted-array/
*/

class Solution {
    public int[] sortedSquares(int[] nums) {

        int[] result = new int[nums.length];
        int i = 0, j = nums.length - 1, k = nums.length - 1;
        while (i <= j) {
            if (Math.abs(nums[i]) > Math.abs(nums[j])) {
                result[k--] = nums[i] * nums[i];
                i++;
            } else {
                result[k--] = nums[j] * nums[j];
                j--;
            }
        }
        return result;
    }
}