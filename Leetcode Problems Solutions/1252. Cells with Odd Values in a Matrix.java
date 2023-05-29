/*
Problem Link: https://leetcode.com/problems/cells-with-odd-values-in-a-matrix/
*/

class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        int oddValuedCells = 0;

        int[][] matrix = new int[m][n];

        for (int i = 0; i < indices.length; i++) {
            for (int j = 0; j < n; j++) {
                matrix[indices[i][0]][j]++;
            }
            for (int j = 0; j < m; j++) {
                matrix[j][indices[i][1]]++;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] % 2 != 0) {
                    oddValuedCells++;
                }
            }
        }
        return oddValuedCells;
    }
}