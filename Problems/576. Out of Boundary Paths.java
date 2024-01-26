/*
Problem Link: https://leetcode.com/problems/out-of-boundary-paths/
*/

import java.util.*;

class Solution {
    private static final int MOD = 1000000007;

    private int helper(
            int m, int n, int maxMove, int startRow, int startColumn, int[][][] dp) {
        if (startRow < 0 || startRow >= m || startColumn < 0 || startColumn >= n) {
            return 1;
        }
        if (maxMove == 0) {
            return 0;
        }
        if (dp[startRow][startColumn][maxMove] != -1) {
            return dp[startRow][startColumn][maxMove];
        }
        int ans = 0;
        ans = (ans + helper(m, n, maxMove - 1, startRow - 1, startColumn, dp)) % MOD;
        ans = (ans + helper(m, n, maxMove - 1, startRow + 1, startColumn, dp)) % MOD;
        ans = (ans + helper(m, n, maxMove - 1, startRow, startColumn - 1, dp)) % MOD;
        ans = (ans + helper(m, n, maxMove - 1, startRow, startColumn + 1, dp)) % MOD;
        dp[startRow][startColumn][maxMove] = ans;
        return ans;
    }

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] dp = new int[m][n][maxMove + 1];
        for (int[][] arr : dp) {
            for (int[] row : arr) {
                Arrays.fill(row, -1);
            }
        }
        return helper(m, n, maxMove, startRow, startColumn, dp) % MOD;
    }
}