/*
Problem Link: https://leetcode.com/problems/maximize-score-after-n-operations/
*/

import java.util.*;

class Solution {
    private int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    private int dfs(int[] nums, int mask, int round, int[][] dp) {
        int n = nums.length;
        if (round > n / 2)
            return 0;
        if (dp[mask][round] != -1)
            return dp[mask][round];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if ((mask & (1 << i)) == 0) {
                for (int j = i + 1; j < n; j++) {
                    if ((mask & (1 << j)) == 0) {
                        int newMask = mask | (1 << i) | (1 << j);
                        ans = Math.max(ans, round * gcd(nums[i], nums[j]) + dfs(nums, newMask, round + 1, dp));
                    }
                }
            }
        }
        return dp[mask][round] = ans;
    }

    public int maxScore(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[1 << n][n / 2 + 1];
        for (int[] d : dp)
            Arrays.fill(d, -1);
        return dfs(nums, 0, 1, dp);
    }
}