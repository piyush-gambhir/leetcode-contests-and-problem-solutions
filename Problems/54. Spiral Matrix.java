/*
Problem Link: https://leetcode.com/problems/spiral-matrix/
*/

import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiralMatrix = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;

        int top = 0;
        int bottom = m - 1;

        int left = 0;
        int right = n - 1;

        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                spiralMatrix.add(matrix[top][i]);
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                spiralMatrix.add(matrix[i][right]);
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    spiralMatrix.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    spiralMatrix.add(matrix[i][left]);
                }
                left++;
            }
        }

        return spiralMatrix;
    }
}