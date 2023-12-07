/*
Problem Link: https://leetcode.com/problems/knight-probability-in-chessboard/
*/

import java.util.*;

class Solution {
    public double knightProbability(int n, int k, int row, int column) {
            if(k == 0){
                return 1;
            }

            int[][] moves = {{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1}};
            double[][] dp = new double[n][n];
            dp[row][column] = 1;

            for(int i = 0; i < k; i++){
                double[][] temp = new double[n][n];
                for(int j = 0; j < n; j++){
                    for(int l = 0; l < n; l++){
                        for(int[] move : moves){
                            int r = j + move[0];
                            int c = l + move[1];
                            if(r >= 0 && r < n && c >= 0 && c < n){
                                temp[r][c] += dp[j][l];
                            }
                        }
                    }
                }
                dp = temp;
            }

            double count = 0;

            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    count += dp[i][j];
                }
            }

            return count / Math.pow(8, k);
    }
}