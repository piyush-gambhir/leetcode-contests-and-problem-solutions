/*
Problem Link: https://leetcode.com/contest/biweekly-contest-102/problems/find-the-score-of-all-prefixes-of-an-array/
*/

import java.util.*;

class Solution {
    public long[] findPrefixScore(int[] nums) {
        long[] conver = new long[nums.length];
        long max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            conver[i] = max + nums[i];
        }
        long[] ans = new long[nums.length];
        ans[0] = conver[0];
        for (int i = 1; i < nums.length; i++) {
            ans[i] = ans[i - 1] + conver[i];
        }
        return ans;
    }
}