/*
Problem Link: https://leetcode.com/problems/sort-the-matrix-diagonally/
*/

class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        for (int i = 0; i < m; i++) {
            int[] temp = new int[Math.min(m - i, n)];
            for (int j = 0; j < temp.length; j++) {
                temp[j] = mat[i + j][j];
            }
            Arrays.sort(temp);
            for (int j = 0; j < temp.length; j++) {
                mat[i + j][j] = temp[j];
            }
        }

        for (int j = 1; j < n; j++) {
            int[] temp = new int[Math.min(m, n - j)];
            for (int i = 0; i < temp.length; i++) {
                temp[i] = mat[i][j + i];
            }
            Arrays.sort(temp);
            for (int i = 0; i < temp.length; i++) {
                mat[i][j + i] = temp[i];
            }
        }

        return mat;
    }
}