/*
Problem Link: https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/
*/

import java.util.*;

class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] charCount = new int[26];
        int count = 0;
        for (char c : chars.toCharArray()) {
            charCount[c - 'a']++;
        }
        for (String word : words) {
            int[] temp = Arrays.copyOf(charCount, charCount.length);
            boolean flag = true;
            for (char c : word.toCharArray()) {
                if (temp[c - 'a'] == 0) {
                    flag = false;
                    break;
                }
                temp[c - 'a']--;
            }
            if (flag) {
                count += word.length();
            }
        }
        return count;
    }
}