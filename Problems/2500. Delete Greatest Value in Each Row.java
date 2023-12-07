/*
Problem Link: https://leetcode.com/problems/delete-greatest-value-in-each-row/
*/

class Solution {
    public int deleteGreatestValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int ans = 0;
        int columns = n;

        while (columns > 0) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < m; i++) {
                int rowMax = Integer.MIN_VALUE;
                int rowMaxIndex = -1;
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] > rowMax) {
                        rowMax = grid[i][j];
                        rowMaxIndex = j;
                    }
                }
                max = Math.max(max, rowMax);
                grid[i][rowMaxIndex] = Integer.MIN_VALUE;
            }
            ans += max;
            columns--;
        }
        return ans;
    }
}