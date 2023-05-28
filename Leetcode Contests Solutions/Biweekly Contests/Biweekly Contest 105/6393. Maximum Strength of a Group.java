/*
Problem Link: https://leetcode.com/contest/biweekly-contest-105/problems/maximum-strength-of-a-group/   
*/

import java.util.*;

class Solution {
    public long maxStrength(int[] nums) {

        if(nums.length == 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        int negativeCount = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                negativeCount++;
            }
        }

        int lastNegativeIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                lastNegativeIndex = i;
            }
        }

        long maxStrength = 1;
        if (negativeCount % 2 == 0) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    maxStrength = maxStrength * nums[i];
                }
            }

            return maxStrength;
        }

        int flag = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0 && i != lastNegativeIndex) {
                maxStrength = maxStrength * nums[i];
                flag = 1;
            }
        }

        if (flag == 0) {
            return 0;
        }

        return maxStrength;
    }
}