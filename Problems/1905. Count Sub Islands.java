/*
Problem Link: https://leetcode.com/problems/count-sub-islands/
*/

class Solution {
    private boolean dfs(int[][] grid1, int[][] grid2, int i, int j) {
        if (i < 0 || i >= grid2.length || j < 0 || j >= grid2[0].length || grid2[i][j] == 0) {
            return true;
        }
        grid2[i][j] = 0;
        boolean left = dfs(grid1, grid2, i, j - 1);
        boolean right = dfs(grid1, grid2, i, j + 1);
        boolean up = dfs(grid1, grid2, i - 1, j);
        boolean down = dfs(grid1, grid2, i + 1, j);
        return left && right && up && down && grid1[i][j] == 1;
    }

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int count = 0;
        for (int i = 0; i < grid2.length; i++) {
            for (int j = 0; j < grid2[0].length; j++) {
                if (grid2[i][j] == 1) {
                    if (dfs(grid1, grid2, i, j)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}