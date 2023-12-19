/*
Problem Link: https://leetcode.com/contest/warm-up-contest/problems/first-unique-character-in-a-string/
*/

import java.util.*;

class Solution {
    public int firstUniqChar(String s) {
        int[] charCount = new int[256];

        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i)]++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (charCount[s.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;
    }
}