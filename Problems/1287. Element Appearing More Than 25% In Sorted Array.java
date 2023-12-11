/*
Problem Link: https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/
 */

import java.util.*;

class Solution {
    public int findSpecialInteger(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > n / 4) {
                return entry.getKey();
            }
        }

        return -1;
    }
}