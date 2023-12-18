/*
Problem Link: https://leetcode.com/problems/find-missing-and-repeated-values/
*/

import java.util.*;

class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int a = 0, b = 0;
        int[] ans = new int[2];
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (set.contains(grid[i][j])) {
                    a = grid[i][j];
                }
                set.add(grid[i][j]);

            }
        }

        int n_sqaure = n * n;

        for (int i = 1; i <= n_sqaure; i++) {
            if (!set.contains(i)) {
                b = i;
                break;
            }
        }

        ans[0] = a;
        ans[1] = b;
        return ans;
    }
}