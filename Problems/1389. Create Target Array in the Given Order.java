/*
Problem Link: https://leetcode.com/problems/create-target-array-in-the-given-order
*/

import java.util.*;

class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        int n = nums.length;
        List<Integer> targetList = new ArrayList<>();
        int target[] = new int[n];
        for (int i = 0; i < n; i++) {
            int valueIndex = index[i];
            int value = nums[i];

            targetList.add(valueIndex, value);
        }

        for (int i = 0; i < n; i++) {
            target[i] = targetList.get(i);
        }

        return target;

    }
}