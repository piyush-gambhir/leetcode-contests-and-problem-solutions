/*
Problem Link: https://leetcode.com/problems/unique-length-3-palindromic-subsequences/
*/

import java.util.*;

class Solution {
    public int countPalindromicSubsequence(String s) {

        int n = s.length();
        int[][] dp = new int[n][26];

        dp[0][s.charAt(0) - 'a'] = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 26; j++) {
                dp[i][j] = dp[i - 1][j];
            }
            dp[i][s.charAt(i) - 'a']++;
        }

        HashSet<String> set = new HashSet<>();

        for (int i = 1; i < n - 1; i++) {
            for (int j = 0; j < 26; j++) {
                if (dp[i - 1][j] > 0 && dp[n - 1][j] - dp[i][j] > 0) {
                    set.add("" + (char) (j + 'a') + s.charAt(i) + (char) (j + 'a'));
                }
            }
        }

        return set.size();
    }
}