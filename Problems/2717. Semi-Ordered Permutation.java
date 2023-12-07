/*
Problem Link: https://leetcode.com/problems/semi-ordered-permutation/ 
*/

import java.util.*;

class Solution {
    public int semiOrderedPermutation(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        int operationCount = 0;
        if (nums[0] == 1 && nums[n - 1] == n) {
            return operationCount;
        }

        int a = 0;
        int b = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                a = i;
            }
            if (nums[i] == n) {
                b = i;
            }
        }

        operationCount += a;

        if (b < a) {
            operationCount += n - b - 2;
        } else {
            operationCount += n - b - 1;
        }

        return operationCount;

    }
}