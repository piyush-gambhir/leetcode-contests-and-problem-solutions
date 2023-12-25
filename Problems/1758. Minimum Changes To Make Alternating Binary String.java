/*
Problem Link: https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string/
*/

class Solution {
    public int minOperations(String s) {
        int count0 = 0, count1 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                if (s.charAt(i) == '1')
                    count0++;
                else
                    count1++;
            } else {
                if (s.charAt(i) == '0')
                    count0++;
                else
                    count1++;
            }
        }
        return Math.min(count0, count1);
    }
}