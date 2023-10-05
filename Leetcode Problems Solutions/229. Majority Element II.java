/*
Problem Link: https://leetcode.com/problems/majority-element-ii/
*/

import java.util.*;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> elementCount = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (elementCount.containsKey(nums[i])) {
                elementCount.put(nums[i], elementCount.get(nums[i]) + 1);
            } else {
                elementCount.put(nums[i], 1);
            }
            if (elementCount.get(nums[i]) > nums.length / 3) {
                if (!result.contains(nums[i])) {
                    result.add(nums[i]);
                }
            }
        }
        return result;
    }
}