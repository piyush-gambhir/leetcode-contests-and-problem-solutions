/*
Problem Link: https://leetcode.com/problems/restore-the-array/
*/

import java.util.*;

class Solution {

    private int numberOfArrays(String s, int k, int i, int n, int[] dp) {
        if (i == n)
            return 1;
        if (s.charAt(i) == '0')
            return 0;

        if (dp[i] != 0)
            return dp[i];

        for (var j = i; j < n && Long.parseLong(s.substring(i, j + 1)) <= k; j++) {
            dp[i] += numberOfArrays(s, k, j + 1, n, dp);
            dp[i] %= 1000000007;
        }
        return dp[i];
    }

    public int numberOfArrays(String s, int k) {
        int n = s.length();
        int[] dp = new int[n];

        return numberOfArrays(s, k, 0, n, dp);
    }
}