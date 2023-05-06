/*
Problem Link: https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/
*/

import java.util.*;

class Solution {
    public int numSubseq(int[] nums, int target) {
        int MOD = (int) 1e9 + 7;
        int n = nums.length;
        Arrays.sort(nums);
        int[] pow2 = new int[n];
        pow2[0] = 1;
        for (int i = 1; i < n; i++) {
            pow2[i] = pow2[i - 1] * 2 % MOD;
        }
        int ans = 0;    
        int i = 0, j = n - 1;
        while (i <= j) {
            if (nums[i] + nums[j] <= target) {
                ans = (ans + pow2[j - i]) % MOD;
                i++;
            } else {
                j--;
            }
        }
        return ans;
    }
}
