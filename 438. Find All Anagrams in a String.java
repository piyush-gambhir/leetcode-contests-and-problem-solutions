/*
Problem Link: https://leetcode.com/problems/find-all-anagrams-in-a-string/
*/

import java.util.*;

class Solution {
    private boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) {
            return result;
        }

        int n = s.length();
        int m = p.length();
        for (int i = 0; i <= n - m; i++) {
            if (isAnagram(s.substring(i, i + m), p)) {
                result.add(i);
            }
        }
        return result;
    }
}