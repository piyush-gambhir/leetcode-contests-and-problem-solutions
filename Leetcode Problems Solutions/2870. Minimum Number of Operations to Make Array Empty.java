/*
Problem Link: https://leetcode.com/problems/minimum-number-of-operations-to-make-array-empty/
*/

import java.util.*;

class Solution {
    public int minOperations(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int minOperations = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int value = entry.getValue();
            if (value == 1) {
                return -1;
            }
            minOperations += value / 3 + (value % 3 == 0 ? 0 : 1);
        }
        return minOperations;

    }
}