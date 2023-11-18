/*
Problem Link: https://leetcode.com/problems/find-unique-binary-string/
*/

class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        String ans = "";
        for (int i = 0; i < n; i++) {
            if (nums[i].charAt(i) == '0') {
                ans += '1';
            } else {
                ans += '0';
            }
        }
        return ans;
    }
}