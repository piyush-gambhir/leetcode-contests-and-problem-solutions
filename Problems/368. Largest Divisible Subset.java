/*
Prboblem Link: https://leetcode.com/problems/largest-divisible-subset/
*/

import java.util.*;

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return new ArrayList<>();
        Arrays.sort(nums);
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int max = 1;
        int maxIndex = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    if (dp[i] > max) {
                        max = dp[i];
                        maxIndex = i;
                    }
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        int prev = nums[maxIndex];
        for (int i = maxIndex; i >= 0; i--) {
            if (prev % nums[i] == 0 && dp[i] == max) {
                res.add(nums[i]);
                prev = nums[i];
                max--;
            }
        }
        return res;
    }
}