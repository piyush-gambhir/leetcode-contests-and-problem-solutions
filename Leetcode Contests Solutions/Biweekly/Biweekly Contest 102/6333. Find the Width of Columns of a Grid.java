/*
Problem Link: https://leetcode.com/contest/biweekly-contest-102/problems/find-the-width-of-columns-of-a-grid/
*/

import java.util.*;

class Solution {
    public int[] findColumnWidth(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] max_widths = new int[n];

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                int num = grid[i][j];
                int width = Integer.toString(num).length();
                max_widths[j] = Math.max(max_widths[j], width);
            }
        }

        return max_widths;
    }
}
