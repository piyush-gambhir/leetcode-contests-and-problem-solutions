/*
Problem Link: https://leetcode.com/problems/n-queens/
*/

import java.util.*;

class Solution {
    private boolean isSafe(List<List<String>> board, int[] queens, int row, int column) {
        for (int i = 0; i < column; i++) {
            if (queens[i] == row) {
                return false;
            }
        }

        for (int i = row, j = column; i >= 0 && j >= 0; i--, j--) {
            if (queens[j] == i) {
                return false;
            }
        }

        for (int i = row, j = column; i < queens.length && j >= 0; i++, j--) {
            if (queens[j] == i) {
                return false;
            }
        }

        return true;
    }

    private void solveNQueens(List<List<String>> board, int[] queens, int column, int n) {
        if (column == n) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (queens[j] == i) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                list.add(sb.toString());
            }
            board.add(list);
            return;
        }

        for (int row = 0; row < n; row++) {
            if (isSafe(board, queens, row, column)) {
                queens[column] = row;
                solveNQueens(board, queens, column + 1, n);
                queens[column] = -1;
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        solveNQueens(result, queens, 0, n);
        return result;
    }
}
