/*
Problem Link: https://leetcode.com/problems/largest-submatrix-with-rearrangements/description/
*/

import java.util.*;

class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] dp = new int[n][m];
        for (int j = 0; j < m; j++) {
            dp[0][j] = matrix[0][j];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) {
                    dp[i][j] = dp[i - 1][j] + 1;
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            Arrays.sort(dp[i]);
            for (int j = 0; j < m; j++) {
                maxArea = Math.max(maxArea, dp[i][j] * (m - j));
            }
        }

        return maxArea;
    }
}