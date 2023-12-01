/*
Problem Link: https://leetcode.com/problems/minimum-operations-to-collect-elements/
*/

import java.util.*;

class Solution {
    public int minOperations(List<Integer> nums, int k) {
       int count = 0;
        HashSet<Integer> collected = new HashSet<>();

        for (int i = nums.size() - 1; i >= 0; i--) {
            int num = nums.get(i);
            if (num <= k && !collected.contains(num)) {
                collected.add(num);
            }

            count++;

            if (collected.size() == k) {
                return count;
            }
        }
        
        return -1;     }
}