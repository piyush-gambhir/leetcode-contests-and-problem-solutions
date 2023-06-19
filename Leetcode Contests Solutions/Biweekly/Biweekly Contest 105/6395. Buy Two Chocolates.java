/*
 Problem Link: https://leetcode.com/contest/biweekly-contest-105/problems/buy-two-chocolates/
*/

import java.util.*;

class Solution {
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);

        if (prices[0] + prices[1] > money) {
            return money;
        }

        return money - prices[0] - prices[1];
    }
}