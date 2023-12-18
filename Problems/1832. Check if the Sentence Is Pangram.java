/*
Problem Link: https://leetcode.com/problems/check-if-the-sentence-is-pangram
*/

import java.util.*;

class Solution {
    public boolean checkIfPangram(String sentence) {
        int hash[] = new int[26];
        for (int i = 0; i < sentence.length(); i++) {
            char ch = sentence.charAt(i);
            hash[ch - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (hash[i] == 0)
                return false;
        }

        return true;
    }
}