/*
Problem Link: https://leetcode.com/problems/minimum-cost-for-tickets/
*/

import java.util.*;

class Solution {
    private int mincostTickets(int[] days, int[] costs, int i, int[] dp) {
        if (i >= days.length) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int ans = Integer.MAX_VALUE;
        int j = i;
        while (j < days.length && days[j] - days[i] < 7) {
            j++;
        }
        ans = Math.min(ans, mincostTickets(days, costs, j, dp) + costs[1]);
        j = i;
        while (j < days.length && days[j] - days[i] < 30) {
            j++;
        }
        ans = Math.min(ans, mincostTickets(days, costs, j, dp) + costs[2]);
        ans = Math.min(ans, mincostTickets(days, costs, i + 1, dp) + costs[0]);
        return dp[i] = ans;
    }

    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days.length];
        Arrays.fill(dp, -1);
        return mincostTickets(days, costs, 0, dp);
    }
}