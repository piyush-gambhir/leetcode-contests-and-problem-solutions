/*
Problem Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
*/

import java.util.*;

class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[] buy = new int[n];
        int[] sell = new int[n];

        buy[0] = -prices[0];
        sell[0] = 0;

        for  (int  i  = 1 ;  i < n;  i++) {
            buy[i] = Math.max(buy[i   - 1], sell [ i  -  1] - prices[i]);
            sell[i] = Math.max(sell[i   - 1], buy [ i  -  1] + pri c es[i] - fee);
        }

        return sell[n   - 1];
    }
}