/*
Problem Link: https://leetcode.com/problems/difference-between-ones-and-zeros-in-row-and-column
*/

import java.util.*;

class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] oneRow = new int[n];
        int[] oneCol = new int[m];
        int[] zeroRow = new int[n];
        int[] zeroCol = new int[m];
        int[][] diff = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    oneRow[i]++;
                    oneCol[j]++;
                } else {
                    zeroRow[i]++;
                    zeroCol[j]++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                diff[i][j] = oneRow[i] - zeroRow[i] + oneCol[j] - zeroCol[j];
            }
        }

        return diff;
    }
}