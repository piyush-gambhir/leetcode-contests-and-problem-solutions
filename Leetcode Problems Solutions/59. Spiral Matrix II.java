/*
Problem Link: https://leetcode.com/problems/spiral-matrix-ii/
*/

import java.util.*;

class Solution {
    public int[][] generateMatrix(int n) {

        int row = n;
        int col = n;

        int[][] matrix = new int[row][col];

        int top = 0;
        int bottom = row - 1;
        int left = 0;
        int right = col - 1;

        int num = 1;

        while (top <= bottom && left <= right) {

            for (int i = left; i <= right; i++) {
                matrix[top][i] = num++;
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = num++;
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    matrix[bottom][i] = num++;
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    matrix[i][left] = num++;
                }
                left++;
            }
        }
        return matrix;
    }
}