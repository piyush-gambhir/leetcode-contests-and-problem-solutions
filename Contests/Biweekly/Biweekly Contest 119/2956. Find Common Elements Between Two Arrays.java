/*
Problem Link: https://leetcode.com/contest/biweekly-contest-119/problems/find-common-elements-between-two-arrays/
*/

import java.util.*;

class Solution {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) {
            map1.put(nums1[i], map1.getOrDefault(nums1[i], 0) + 1);
        }

        for (int i = 0; i < nums2.length; i++) {
            map2.put(nums2[i], map2.getOrDefault(nums2[i], 0) + 1);
        }

        int[] result = new int[2];

        for (int i = 0; i < nums1.length; i++) {
            if (map2.containsKey(nums1[i])) {
                result[0] += 1;
            }

        }

        for (int i = 0; i < nums2.length; i++) {
            if (map1.containsKey(nums2[i])) {
                result[1] += 1;
            }

        }

        return result;

    }
}