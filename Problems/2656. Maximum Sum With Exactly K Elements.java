/*
Problem Link: https://www.geeksforgeeks.org/maximum-sum-exactly-k-elements-array/
*/

import java.util.*;

class Solution {
    public int maximizeSum(int[] nums, int k) {
        int maxScore = 0;
        Arrays.sort(nums);
        while (k-- > 0) {
            maxScore += nums[nums.length - 1];
            nums[nums.length - 1] = nums[nums.length - 1] + 1;
        }
        return maxScore;
    }
}

// Another Approach in O(n) Time Complexity.
class Solution {
    public int maximizeSum(int[] nums, int k) {
        int maxScore = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
            }
        }
        maxScore = (2 * max + k - 1) * k / 2;
        return maxScore;
    }
}