/*
Problem Link: https://leetcode.com/problems/determine-whether-matrix-can-be-obtained-by-rotation/
*/

import java.util.Arrays;

class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;
        int[][] temp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][j] = mat[i][j];
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    mat[j][k] = temp[n - k - 1][j];
                }
            }
            if (Arrays.deepEquals(mat, target)) {
                return true;
            }
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    temp[j][k] = mat[j][k];
                }
            }
        }
        return false;
    }
}