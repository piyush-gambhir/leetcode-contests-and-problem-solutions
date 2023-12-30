/*
Problem Link: https://leetcode.com/problems/redistribute-characters-to-make-all-strings-equal/
*/

import java.util.*;

class Solution {
    public boolean makeEqual(String[] words) {
        int n = words.length;
        int[] freq = new int[26];
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                freq[ch - 'a']++;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (freq[i] % n != 0) {
                return false;
            }
        }
        return true;
    }
}