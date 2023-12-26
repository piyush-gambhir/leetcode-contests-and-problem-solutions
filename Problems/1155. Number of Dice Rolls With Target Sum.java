/*
Problem Link: https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/
*/

import java.util.*;

class Solution {
    public int solve(int n, int k, int target, int[][] dp) {
        if (n == 0 && target == 0)
            return dp[n][target] = 1;
        if (n == 0 || target == 0)
            return dp[n][target] = 0;
        if (dp[n][target] != -1)
            return dp[n][target];
        int count = 0;
        for (int i = 1; i <= k; i++) {
            if (target - i >= 0)
                count = (count + solve(n - 1, k, target - i, dp)) % 1000000007;
        }
        return dp[n][target] = count;
    }

    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n + 1][target + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return solve(n, k, target, dp);
    }
}