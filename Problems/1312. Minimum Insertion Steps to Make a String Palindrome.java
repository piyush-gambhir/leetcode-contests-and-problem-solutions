/*
Problem Link: https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/
*/

import java.util.*;

class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    dp[i][j] = 0;
                } else if (i + 1 == j) {
                    dp[i][j] = s.charAt(i) == s.charAt(j) ? 0 : 1;
                } else {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[i + 1][j - 1];
                    } else {
                        dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
                    }
                }
            }
        }
        return dp[0][n - 1];
    }
}