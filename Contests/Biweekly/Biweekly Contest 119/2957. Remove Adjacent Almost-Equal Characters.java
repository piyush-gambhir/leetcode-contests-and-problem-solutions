/*
Problem Link: https://leetcode.com/contest/biweekly-contest-119/problems/remove-adjacent-almost-equal-characters/
*/

import java.util.*;

class Solution {
    private boolean isAdjacent(char ch1, char ch2) {
        if (ch1 == ch2) {
            return true;
        }
        if (ch1 + 1 == ch2 || ch1 == ch2 + 1) {
            return true;
        }
        return false;
    }

    public int removeAlmostEqualCharacters(String word) {
        int n = word.length();
        int count = 0;
        int i = 0;
        while (i < n - 1) {
            if (isAdjacent(word.charAt(i), word.charAt(i + 1))) {
                count++;
                i++;
            }
            i++;
        }
        return count;
    }
}