/*
Problem Link: https://leetcode.com/problems/number-of-zero-filled-subarrays/
*/

import java.util.*;

class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long count = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                count += right - left + 1;
            } else {
                left = right + 1;
            }
        }
        return count;
    }
}