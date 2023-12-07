/*
 * Problem Link: https://leetcode.com/problems/smallest-range-i/
 */

import java.util.*;

class Solution {
    public int smallestRangeI(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }

        return (max - k) - (min + k);
    }
}