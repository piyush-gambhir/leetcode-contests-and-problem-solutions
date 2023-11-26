/*
Problem Link: https://leetcode.com/problems/minimum-number-of-coins-for-fruits/
*/

import java.util.Arrays;

public class Solution {
    private int[][] memo;

    private int calculateMinimumCoins(int index, int freeCount, int[] prices) {
        if (index >= prices.length) {
            return 0;
        }

        if (memo[index][freeCount] != -1) {
            return memo[index][freeCount];
        }

        int spend = prices[index] + calculateMinimumCoins(index + 1, index + 1, prices);
        int freebie = (freeCount > 0) ? calculateMinimumCoins(index + 1, freeCount - 1, prices) : Integer.MAX_VALUE;
        memo[index][freeCount] = Math.min(spend, freebie);

        return memo[index][freeCount];
    }

    public int minimumCoins(int[] prices) {
        int n = prices.length;
        memo = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }

        return prices[0] + calculateMinimumCoins(1, 1, prices);
    }
}
