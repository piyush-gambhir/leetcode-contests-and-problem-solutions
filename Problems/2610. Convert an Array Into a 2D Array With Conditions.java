/*
Problem Link: https://leetcode.com/problems/convert-an-array-into-a-2d-array-with-conditions/description
*/

import java.util.*;

class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        List<List<Integer>> res = new ArrayList<>();
        while (!map.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            for (int key : map.keySet()) {
                temp.add(key);
                map.put(key, map.get(key) - 1);
            }
            res.add(temp);
            map.entrySet().removeIf(entry -> entry.getValue() == 0);
        }
        return res;
    }
}