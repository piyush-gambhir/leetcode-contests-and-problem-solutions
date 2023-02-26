
/*
Problem Link: https://leetcode.com/problems/rotting-oranges/
*/

import java.util.*;

class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        int time = 0;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[] { i, j });
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        if (fresh == 0) {
            return 0;
        }
        int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                for (int[] dir : dirs) {
                    int x = curr[0] + dir[0];
                    int y = curr[1] + dir[1];
                    if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        fresh--;
                        q.add(new int[] { x, y });
                    }
                }
            }
            time++;
        }
        return fresh == 0 ? time - 1 : -1;
    }
}