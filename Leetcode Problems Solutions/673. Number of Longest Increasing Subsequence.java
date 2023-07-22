/*
Problem Link: https://leetcode.com/problems/number-of-longest-increasing-subsequence/
*/

import java.util.*; 

class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] count = new int[n];
        
        int max = 0;
        int res = 0;
        
        for(int i=0; i<n; i++){
            dp[i] = 1;
            count[i] = 1;
            
            for(int j=0; j<i; j++){
                if(nums[i] > nums[j]){
                    if(dp[i] < dp[j]+1){
                        dp[i] = dp[j]+1;
                        count[i] = count[j];
                    }
                    else if(dp[i] == dp[j]+1){
                        count[i] += count[j];
                    }
                }
            }
            
            if(max < dp[i]){
                max = dp[i];
                res = count[i];
            }
            else if(max == dp[i]){
                res += count[i];
            }
        }
        
        return res;
    }
}