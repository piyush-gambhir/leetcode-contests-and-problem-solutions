/*
Problem Link: https://leetcode.com/contest/weekly-contest-344/problems/find-the-distinct-difference-array/
*/

import java.util.*;

class Solution {
    public int[] distinctDifferenceArray(int[] nums) {
        int n = nums.length;
        Set<Integer> distinctElements = new HashSet<>();
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int[] diff = new int[n];

        // Traverse from left to right to calculate prefix
        for (int i = 0; i < n; i++) {
            distinctElements.add(nums[i]);
            prefix[i] = distinctElements.size();
        }

        // Clear distinctElements set to reuse for suffix calculation
        distinctElements.clear();

        // Traverse from right to left to calculate suffix
        for (int i = n - 1; i >= 0; i--) {
            distinctElements.add(nums[i]);
            suffix[i] = distinctElements.size();
        }

        // Calculate distinct difference array
        for (int i = 0; i < n; i++) {
            diff[i] = prefix[i] - ((i + 1 < n) ? suffix[i + 1] : 0);
        }

        return diff;
    }
}
