/*
Problem Link: https://leetcode.com/problems/count-number-of-distinct-integers-after-reverse-operations/
*/

import java.util.*;

class Solution {
    private int reverseDigits(int n) {
        int reversed = 0;
        while (n > 0) {
            reversed = (reversed * 10) + (n % 10);
            n /= 10;
        }
        return reversed;
    }

    public int countDistinctIntegers(int[] nums) {
        Set<Integer> distinctIntegers = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            distinctIntegers.add(nums[i]);
            distinctIntegers.add(reverseDigits(nums[i]));
        }
        return distinctIntegers.size();
    }
}