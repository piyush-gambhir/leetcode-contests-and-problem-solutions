/*
Problem Link: 
*/

import java.util.*;

class Solution {
    public long maxScore(int[] nums, int x) {
        int n = nums.length;
        long[] dp = new long[n];
        dp[0] = nums[0];
        
        for (int i = 1; i < n; i++) {
            dp[i] = nums[i];
            for (int j = 0; j < i; j++) {
                long score = dp[j] + nums[i];
                if ((nums[j] % 2) != (nums[i] % 2)) {
                    score -= x;
                }
                dp[i] = Math.max(dp[i], score);
            }
        }
        
        long maxScore = Long.MIN_VALUE;
        for (long score : dp) {
            maxScore = Math.max(maxScore, score);
        }
        
        return maxScore;
    }
}
