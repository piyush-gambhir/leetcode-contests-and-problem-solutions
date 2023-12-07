/*
Problem Link: https://leetcode.com/problems/minimum-time-to-type-word-using-special-typewriter/
*/

import java.util.*;

class Solution {
    public int minTimeToType(String word) {
        int seconds = word.length();

        char currentChar = 'a';
        for (char c : word.toCharArray()) {
            int diff = Math.abs(c - currentChar);
            seconds += Math.min(diff, 26 - diff);
            currentChar = c;
        }
        return seconds;
    }
}