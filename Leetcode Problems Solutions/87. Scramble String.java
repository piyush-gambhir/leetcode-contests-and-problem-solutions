/*
Problem Link: https://leetcode.com/problems/scramble-string/
*/

import java.util.*;
import java.util.*;

class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }
        int n = s1.length();
        boolean[][][] memo = new boolean[n][n][n + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
            for (int j = 0; j < n; j++) {
                memo[i][j][1] = s1.charAt(i) == s2.charAt(j);
            }
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                for (int j = 0; j <= n - len; j++) {
                    for (int k = 1; k < len; k++) {
                        boolean left = memo[i][j][k] && memo[i + k][j + k][len - k];
                        boolean right = memo[i][j + len - k][k] && memo[i + k][j][len - k];
                        if (left || right) {
                            memo[i][j][len] = true;
                            break;
                        }
                    }
                }
            }
        }
        return memo[0][0][n];
    }
}
