/*
Problem Link: https://leetcode.com/problems/subarrays-with-k-different-integers/
*/

import java.util.*;

class Solution {
    public int atMostK(int[] nums, int k) {
        int n = nums.length;
        int i = 0;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int j = 0; j < n; j++) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            while (map.size() > k) {
                map.put(nums[i], map.get(nums[i]) - 1);
                if (map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }
                i++;
            }
            res += j - i + 1;
        }
        return res;
    }
    

    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);   
    }
}