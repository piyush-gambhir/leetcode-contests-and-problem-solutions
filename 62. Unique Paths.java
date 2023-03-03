/*
Problem Link: https://leetcode.com/problems/unique-paths
*/

import java.util.*;

class Solution {

    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m + 1][n + 1];

        grid[0][0] = 1;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1) {
                    grid[i][j] = 1;
                } else {
                    grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
                }
            }
        }

        return grid[m][n];
    }
}