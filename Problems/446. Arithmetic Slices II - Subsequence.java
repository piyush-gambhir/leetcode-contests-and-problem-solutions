/*
Problem Link: https://leetcode.com/problems/arithmetic-slices-ii-subsequence/description/
*/

import java.util.*;

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int ans = 0;
        HashMap<Integer, Integer>[] map = new HashMap[n];

        for (int i = 0; i < n; i++) {
            map[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                long diff = (long) nums[i] - (long) nums[j];
                if (diff <= Integer.MIN_VALUE || diff >= Integer.MAX_VALUE)
                    continue;

                int d = (int) diff;
                int c1 = map[i].getOrDefault(d, 0);
                int c2 = map[j].getOrDefault(d, 0);
                ans += c2;
                map[i].put(d, c1 + c2 + 1);
            }
        }
        return ans;
    }
}