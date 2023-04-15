/*
Problem Link: https://leetcode.com/problems/maximum-value-of-k-coins-from-piles/
*/

import java.util.*;

class Solution {
    private int maxValueOfCoins(int i, int k, List<List<Integer>> piles, int[][] dp) {
        if (dp[i][k] > 0)
            return dp[i][k];
        if (i == piles.size() || k == 0)
            return 0;
        int res = maxValueOfCoins(i + 1, k, piles, dp), cur = 0;
        for (int j = 0; j < piles.get(i).size() && j < k; ++j) {
            cur += piles.get(i).get(j);
            res = Math.max(res, maxValueOfCoins(i + 1, k - j - 1, piles, dp) + cur);
        }
        dp[i][k] = res;
        return res;
    }

    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int n = piles.size();
        int[][] dp = new int[n + 1][k + 1];
        return maxValueOfCoins(0, k, piles, dp);

    }
}