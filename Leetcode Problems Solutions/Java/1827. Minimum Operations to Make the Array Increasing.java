/*
Problem Link: https://leetcode.com/problems/minimum-operations-to-make-the-array-increasing/
*/

import java.util.*;

class Solution {
    public int minOperations(int[] nums) {
        int minOperations = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] >= nums[i]) {
                minOperations += (nums[i - 1] - nums[i] + 1);
                nums[i] = nums[i - 1] + 1;
            }
        }
        return minOperations;
    }
}