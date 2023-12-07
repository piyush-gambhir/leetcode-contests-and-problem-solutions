/*
Problem Link: https://leetcode.com/problems/shortest-path-in-binary-matrix/
*/

import java.util.*;

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1)
            return -1;

        int[][] dir = { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 } };

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { 0, 0 });
        grid[0][0] = 1;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];

            if (x == n - 1 && y == n - 1)
                return grid[x][y];

            for (int i = 0; i < 8; i++) {
                int r = x + dir[i][0];
                int c = y + dir[i][1];

                if (r >= 0 && c >= 0 && r < n && c < n && grid[r][c] == 0) {
                    q.add(new int[] { r, c });
                    grid[r][c] = grid[x][y] + 1;
                }
            }
        }
        return -1;
    }
}
