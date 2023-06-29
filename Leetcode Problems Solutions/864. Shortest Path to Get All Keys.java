/*
Problem Link: https://leetcode.com/problems/shortest-path-to-get-all-keys/
*/

import java.util.*;

class Solution {
    public int shortestPathAllKeys(String[] grid) {
        int n = grid.length;
        int m = grid[0].length();
        int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        int[][][] visited = new int[n][m][64];
        Queue<int[]> q = new LinkedList<>();
        int allKeys = 0;
        int steps = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i].charAt(j) == '@') {
                    q.add(new int[] { i, j, 0 });
                    visited[i][j][0] = 1;
                }
                if (grid[i].charAt(j) >= 'a' && grid[i].charAt(j) <= 'f') {
                    allKeys = allKeys | (1 << (grid[i].charAt(j) - 'a'));
                }
            }
        }
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] curr = q.poll();
                int x = curr[0];
                int y = curr[1];
                int keys = curr[2];
                if (keys == allKeys) {
                    return steps;
                }
                for (int[] d : dir) {
                    int nx = x + d[0];
                    int ny = y + d[1];
                    int nkeys = keys;
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx].charAt(ny) != '#') {
                        if (grid[nx].charAt(ny) >= 'A' && grid[nx].charAt(ny) <= 'F') {
                            if ((nkeys & (1 << (grid[nx].charAt(ny) - 'A'))) == 0) {
                                continue;
                            }
                        }
                        if (grid[nx].charAt(ny) >= 'a' && grid[nx].charAt(ny) <= 'f') {
                            nkeys = nkeys | (1 << (grid[nx].charAt(ny) - 'a'));
                        }
                        if (visited[nx][ny][nkeys] == 0) {
                            visited[nx][ny][nkeys] = 1;
                            q.add(new int[] { nx, ny, nkeys });
                        }
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}