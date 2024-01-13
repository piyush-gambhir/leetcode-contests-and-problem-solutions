/*
Problem Link: https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/description/
*/

import java.util.*;

class Solution {
    public int minSteps(String s, String t) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            freq[t.charAt(i) - 'a']--;
        }
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                ans += freq[i];
            }
        }
        return ans;
    }
}