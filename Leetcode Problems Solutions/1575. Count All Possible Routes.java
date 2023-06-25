/*
Problem Link: https://leetcode.com/problems/count-all-possible-routes/
*/

import java.util.*;

class Solution {

    private int helper(int[] locations, int start, int finish, int fuel, int[][] dp) {
        int n = locations.length;
        if (fuel < 0) {
            return 0;
        }
        if (dp[start][fuel] != -1) {
            return dp[start][fuel];
        }
        int ans = start == finish ? 1 : 0;
        for (int i = 0; i < n; i++) {
            if (i != start) {
                ans = (ans + helper(locations, i, finish, fuel - Math.abs(locations[start] - locations[i]), dp))
                        % 1000000007;
            }
        }
        return dp[start][fuel] = ans;
    }

    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int n = locations.length;
        int[][] dp = new int[n][fuel + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return helper(locations, start, finish, fuel, dp);
    }
}