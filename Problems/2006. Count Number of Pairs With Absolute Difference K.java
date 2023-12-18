/*
Problem Link: https://leetcode.com/problems/count-number-of-pairs-with-absolute-difference-k
*/

import java.util.*;

class Solution {
    public int countKDifference(int[] nums, int k) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for (int i = 0; i < nums.length; i++) {
            int diff = nums[i] - k;
            if (map.containsKey(diff)) {
                count += map.get(diff);
            }
        }
        return count;
    }
}