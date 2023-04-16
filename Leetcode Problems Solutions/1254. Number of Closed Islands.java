/*
Problem Statement: https://leetcode.com/problems/number-of-closed-islands/
*/

class Solution {
    private boolean dfs(int[][] grid, int i, int j, int n, int m) {
        if (i < 0 || i >= n || j < 0 || j >= m)
            return false;
        if (grid[i][j] == 1)
            return true;
        grid[i][j] = 1;
        boolean left = dfs(grid, i, j - 1, n, m);
        boolean right = dfs(grid, i, j + 1, n, m);
        boolean up = dfs(grid, i - 1, j, n, m);
        boolean down = dfs(grid, i + 1, j, n, m);
        return left && right && up && down;
    }

    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    if (dfs(grid, i, j, n, m))
                        count++;
                }
            }
        }
        return count;
    }
}