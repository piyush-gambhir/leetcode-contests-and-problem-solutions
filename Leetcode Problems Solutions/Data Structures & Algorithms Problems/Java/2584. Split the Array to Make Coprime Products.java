/*
Problem Link: https://leetcode.com/problems/split-the-array-to-make-coprime-products/
*/

import java.util.*;

class Solution {
    private long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public int findValidSplit(int[] nums) {
        int n = nums.length;
        
        long suffixSum = 1;
        for (int j = 1; j < n; j++) {
            suffixSum *= nums[j];
        }
        long prefixSum = nums[0];
        for (int i = 0; i < n - 1; i++) {

            if (gcd(prefixSum, suffixSum) == 1) {
                return i;
            }

            prefixSum *= nums[i + 1];
            suffixSum /= nums[i + 1];
            
        }
        return -1;
    }
}