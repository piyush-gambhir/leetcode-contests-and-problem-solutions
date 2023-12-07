/*
Problem Link: https://leetcode.com/problems/find-winner-on-a-tic-tac-toe-game/
*/

import java.util.*;

class Solution {
    public String tictactoe(int[][] moves) {

        int[] rows = new int[3];
        int[] cols = new int[3];
        int diag = 0, antiDiag = 0;

        int player = 1;

        for (int[] move : moves) {

            int row = move[0];
            int col = move[1];

            rows[row] += player;
            cols[col] += player;

            if (row == col) {
                diag += player;
            }

            if (row + col == 2) {
                antiDiag += player;
            }

            if (Math.abs(rows[row]) == 3 || Math.abs(cols[col]) == 3 || Math.abs(diag) == 3
                    || Math.abs(antiDiag) == 3) {
                return player == 1 ? "A" : "B";
            }

            player *= -1;
        }

        return moves.length == 9 ? "Draw" : "Pending";
    }
}