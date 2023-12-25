/*
Problem Link: https://leetcode.com/problems/count-the-number-of-incremovable-subarrays-i/description/
*/


import java.util.*;

class Solution {
    public int incremovableSubarrayCount(int[] nums) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int[] rem = new int[i + n - j - 1];
                int idx = 0;
                for (int k = 0; k < i; k++) {
                    rem[idx++] = nums[k];
                }
                for (int k = j + 1; k < n; k++) {
                    rem[idx++] = nums[k];
                }
                boolean isIncreasing = true;
                for (int k = 0; k < rem.length - 1; k++) {
                    if (rem[k] >= rem[k + 1]) {
                        isIncreasing = false;
                        break;
                    }
                }
                if (isIncreasing) {
                    count++;
                }
            }
        }
        return count;
    }
}