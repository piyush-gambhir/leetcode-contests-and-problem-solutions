/*
Problem Link: https://leetcode.com/problems/knight-dialer/
*/

import java.util.*;

class Solution {
    private int dfs(int n, int i, int[][] moves, int[][] dp, int mod) {
        if (n == 0) {
            return 1;
        }
        if (dp[n][i] != -1) {
            return dp[n][i];
        }
        int ans = 0;
        for (int move : moves[i]) {
            ans = (ans + dfs(n - 1, move, moves, dp, mod)) % mod;
        }
        dp[n][i] = ans;
        return ans;
    }

    public int knightDialer(int n) {
        int[][] moves = new int[][] { { 4, 6 }, { 6, 8 }, { 7, 9 }, { 4, 8 }, { 0, 3, 9 }, {}, { 0, 1, 7 }, { 2, 6 },
                { 1, 3 }, { 2, 4 } };
        int[][] dp = new int[n][10];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        int mod = 1000000007;
        int ans = 0;
        for (int i = 0; i < 10; i++) {
            ans = (ans + dfs(n - 1, i, moves, dp, mod)) % mod;
        }
        return ans;
    }
}