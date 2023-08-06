/*
Problem Link: https://leetcode.com/problems/number-of-music-playlists/
*/

import java.util.Arrays;

class Solution {
    public long helper(int n, int goal, int k, long[][] dp, int mod) {
        if (goal == 0 && n == 0)
            return 1;
        if (goal < 0 || n < 0)
            return 0;
        if (dp[goal][n] != -1)
            return dp[goal][n];
        long ans = 0;
        ans = (ans + helper(n - 1, goal - 1, k, dp, mod) * (n)) % mod;
        ans = (ans + helper(n, goal - 1, k, dp, mod) * Math.max(n - k, 0)) % mod;
        return dp[goal][n] = ans;
    }

    public int numMusicPlaylists(int n, int goal, int k) {
        int mod = (int) 1e9 + 7;
        long[][] dp = new long[goal + 1][n + 1];
        for (long[] d : dp)
            Arrays.fill(d, -1);
        return (int) helper(n, goal, k, dp, mod);
    }
}