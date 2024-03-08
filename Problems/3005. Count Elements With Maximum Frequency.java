/*
Problem Link: https://leetcode.com/problems/count-elements-with-maximum-frequency/description/
*/

import java.util.*;

class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int count = map.get(nums[i]);
                map.put(nums[i], count + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        int max = 0;

        for (int key : map.keySet()) {
            if (map.get(key) > max) {
                max = map.get(key);
            }
        }

        int count = 0;
        for (int key : map.keySet()) {
            if (map.get(key) == max) {
                count++;
            }
        }

        return count * max;
    }
}