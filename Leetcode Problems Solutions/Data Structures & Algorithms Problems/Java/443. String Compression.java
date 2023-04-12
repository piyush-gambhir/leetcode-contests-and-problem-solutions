/*
Problem Link: https://leetcode.com/problems/string-compression/
*/

class Solution {
    public int compress(char[] chars) {
        int i = 0, j = 0;
        while (i < chars.length) {
            int count = 0;
            char c = chars[i];
            while (i < chars.length && chars[i] == c) {
                i++;
                count++;
            }
            chars[j++] = c;
            if (count > 1) {
                for (char ch : Integer.toString(count).toCharArray()) {
                    chars[j++] = ch;
                }
            }
        }
        return j;
    }
}