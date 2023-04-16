/*
Problem Link: https://leetcode.com/problems/find-triangular-sum-of-an-array/
*/

import java.util.*;

class Solution {
    public int triangularSum(int[] nums) {
        while (nums.length > 1) {
            int n = nums.length;
            int[] newNums = new int[n - 1];
            for (int i = 0; i < n - 1; i++) {
                newNums[i] = (nums[i] + nums[i + 1]) % 10;
            }
            nums = newNums;
        }
        return nums[0];
    }
}