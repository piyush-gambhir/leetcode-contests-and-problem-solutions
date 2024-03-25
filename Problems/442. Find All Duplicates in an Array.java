/*
Problem Link: https://leetcode.com/problems/find-all-duplicates-in-an-array/
*/

import java.util.*;

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        HashMap map = new HashMap();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                list.add(nums[i]);
            } else {
                map.put(nums[i], 1);
            }
        }
        return list;
    }
}