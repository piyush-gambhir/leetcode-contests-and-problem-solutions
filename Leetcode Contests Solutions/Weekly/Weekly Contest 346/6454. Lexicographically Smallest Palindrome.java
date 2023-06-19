/*
Problem Link: https://leetcode.com/contest/weekly-contest-346/problems/lexicographically-smallest-palindrome/
*/

import java.util.*;

class Solution {
    public String makeSmallestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;

        for (int i = 0; i < n / 2; i++) {
            int j = n - 1 - i;

            if (chars[i] != chars[j]) {
                chars[j] = chars[i] = (char) Math.min(chars[i], chars[j]);
            }
        }

        return new String(chars);
    }
}