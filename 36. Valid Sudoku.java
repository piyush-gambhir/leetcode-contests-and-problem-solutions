/*
Problem Link: https://leetcode.com/problems/valid-sudoku/
*/

class Solution {
    private boolean isSafe(char[][] board, char number, int row, int column) {
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == number && i != column) {
                return false;
            }
            if (board[i][column] == number && i != row) {
                return false;
            }
        }

        int r = (row / 3) * 3;
        int c = (column / 3) * 3;

        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (board[i][j] == number && i != row && j != column) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '.') {
                    continue;
                } else {
                    if (!isSafe(board, board[i][j], i, j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}