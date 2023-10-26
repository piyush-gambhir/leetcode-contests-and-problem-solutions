/*
Problem Link: https://leetcode.com/problems/binary-trees-with-factors/
*/

import java.util.*;

class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        long[] dp = new long[n];
        Arrays.fill(dp, 1);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0) {
                    int right = arr[i] / arr[j];
                    if (map.containsKey(right)) {
                        dp[i] = (dp[i] + dp[j] * dp[map.get(right)]) % 1000000007;
                    }
                }
            }
        }
        long ans = 0;
        for (long x : dp) {
            ans += x;
        }
        return (int) (ans % 1000000007);
    }
}