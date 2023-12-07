/*
Problem Link: https://leetcode.com/problems/shortest-bridge/
*/

import java.util.*;

class Solution {
    public void dfs(int[][] grid, int i, int j, boolean[][] vis, Queue<int[]> q) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || vis[i][j] || grid[i][j] == 0)
            return;
        vis[i][j] = true;
        q.add(new int[] { i, j });
        dfs(grid, i + 1, j, vis, q);
        dfs(grid, i, j + 1, vis, q);
        dfs(grid, i - 1, j, vis, q);
        dfs(grid, i, j - 1, vis, q);
    }

    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            if (flag)
                break;
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, vis, q);
                    flag = true;
                    break;
                }
            }
        }
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] rem = q.poll();
                for (int i = 0; i < 4; i++) {
                    int x = rem[0] + dir[i][0];
                    int y = rem[1] + dir[i][1];
                    if (x >= 0 && y >= 0 && x < n && y < m && !vis[x][y]) {
                        if (grid[x][y] == 1)
                            return level;
                        vis[x][y] = true;
                        q.add(new int[] { x, y });
                    }
                }
            }
            level++;
        }
        return -1;
    }
}