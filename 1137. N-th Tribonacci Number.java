/*
Problem Link: https://leetcode.com/problems/n-th-tribonacci-number/
*/

import java.util.Arrays;

class Solution {
    private int tribonacci(int n, int[] dp) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (n == 2) {
            return 1;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        dp[n] = tribonacci(n - 1, dp) + tribonacci(n - 2, dp) + tribonacci(n - 3, dp);
        return dp[n];
    }

    public int tribonacci(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return tribonacci(n, dp);
    }
}