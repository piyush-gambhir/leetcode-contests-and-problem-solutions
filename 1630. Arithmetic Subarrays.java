/*
Problem Link: https://leetcode.com/problems/arithmetic-subarrays/
*/

import java.util.*;

class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            int[] sub = Arrays.copyOfRange(nums, l[i], r[i] + 1);
            Arrays.sort(sub);
            boolean isArithmetic = true;
            for (int j = 1; j < sub.length - 1; j++) {
                if (sub[j] - sub[j - 1] != sub[j + 1] - sub[j]) {
                    isArithmetic = false;
                    break;
                }
            }
            res.add(isArithmetic);
        }
        return res;
    }
}