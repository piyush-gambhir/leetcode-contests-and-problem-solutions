/*
Problem Link: https://leetcode.com/contest/biweekly-contest-131/problems/find-the-xor-of-numbers-which-appear-twice/
*/
import java.util.HashMap;

class Solution {
    public int duplicateNumbersXOR(int[] nums) {
        int XOR = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                XOR ^= nums[i];
            } else {
                map.put(nums[i], 1);
            }
        }

        return XOR;

    }
}