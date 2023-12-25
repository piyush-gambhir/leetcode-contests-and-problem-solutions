/*
Problem Link: https://leetcode.com/contest/biweekly-contest-120/problems/find-polygon-with-the-largest-perimeter/
*/

import java.util.*;

class Solution {
    public long findLargestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int index = 0;
        long sum = 0, current = 0;
        sum = 1L * (nums[0] + nums[1]);
        index = 2;
        for (int i = 2; i < nums.length; i++) {
            if (1L * nums[i] < sum) {
                sum += 1L * nums[i];
                current = sum;
                index++;
            } else {
                sum += 1L * nums[i];
            }
        }
        if (index == 2) {
            return -1;
        }
        return current;
    }
}