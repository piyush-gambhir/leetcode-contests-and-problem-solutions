/*
Problem Link: https://leetcode.com/problems/count-pairs-whose-sum-is-less-than-target/description/
*/

import java.util.*;

class Solution {
    public int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);
        int count = 0;
        int i = 0, j = nums.size() - 1;
        while (i < j) {
            if (nums.get(i) + nums.get(j) < target) {
                count += j - i;
                i++;
            } else {
                j--;
            }
        }
        return count;
    }
}