/*
Problem Link: https://leetcode.com/problems/predict-the-winner/
*/

import java.util.*;

class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        
        for(int i=0; i<n; i++)
            dp[i][i] = nums[i];
        
        for(int i=1; i<n; i++){
            for(int j=0; j<n-i; j++){
                dp[j][j+i] = Math.max(nums[j+i]-dp[j][j+i-1], nums[j]-dp[j+1][j+i]);
            }
        }
        
        return dp[0][n-1] >= 0;
    }
}