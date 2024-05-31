/*
Problem Link: https://leetcode.com/problems/single-number-iii/
*/

class Solution {
    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];

        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        int mask = 1;
        while ((xor & mask) == 0) {
            mask <<= 1;
        }

        for (int num : nums) {
            if ((num & mask) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }   

        return res;
        
    }
}