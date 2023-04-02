/*
Problem Link: https://leetcode.com/contest/biweekly-contest-100/problems/maximize-greatness-of-an-array/
*/

import java.util.*;

class Solution {

    public int maximizeGreatness(int[] nums) {
        int n = nums.length;
        int[] sortedNums = Arrays.copyOf(nums, n);
        Arrays.sort(sortedNums);

        int count = 0;
        int[] freq = new int[n + 1];
        for (int i = 0; i < n; i++) {
            freq[nums[i]]++;
            if (nums[i] < sortedNums[n - count - 1]) {
                count++;
            }
        }

        int[] prefixSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + freq[i - 1];
        }

        int[] perm = new int[n];
        for (int i = 0; i < n; i++) {
            int index = prefixSum[nums[i]]++;
            if (index <= count) {
                perm[i] = sortedNums[n - index];
            } else {
                perm[i] = nums[i];
            }
        }

        int greatness = 0;
        for (int i = 0; i < n; i++) {
            if (perm[i] > nums[i]) {
                greatness++;
            }
        }

        return greatness;
    }
}