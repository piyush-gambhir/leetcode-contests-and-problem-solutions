/*
Problem Link: https://leetcode.com/problems/two-sum/
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] indexes = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] + nums[j] == target && i != j) {
                    indexes[0] = i;
                    indexes[1] = j;
                    break;
                }
            }
        }
        return indexes;
    }
}