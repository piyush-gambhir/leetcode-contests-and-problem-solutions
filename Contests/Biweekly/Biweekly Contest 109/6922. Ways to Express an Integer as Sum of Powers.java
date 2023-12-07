/*
Problem Link: 
*/

import java.util.*;

class Solution {
    private static final int MOD = 1_000_000_007;
    private Integer[][] memo;

    public int numberOfWays(int n, int x) {
        memo = new Integer[n + 1][n + 1];
        return backtrack(n, n, x);
    }

    private int backtrack(int n, int maxNum, int x) {
        if (n < 0) return 0;
        if (n == 0) return 1;
        if (maxNum <= 0) return 0;
        
        if (memo[n][maxNum] != null) return memo[n][maxNum];
        
        int consider = (int) Math.pow(maxNum, x);
        if (consider > n) return backtrack(n, maxNum - 1, x);
        
        int count = 0;
        count = (count + backtrack(n - consider, maxNum - 1, x)) % MOD;
        count = (count + backtrack(n, maxNum - 1, x)) % MOD;
        
        memo[n][maxNum] = count;
        return count;
    }
}
