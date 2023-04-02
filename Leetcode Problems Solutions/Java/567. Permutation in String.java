/*
Problem Link: https://leetcode.com/problems/ransom-note/
*/

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] counter = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            counter[s1.charAt(i) - 'a']++;
        }
        int i = 0;
        int j = 0;
        while (j < s2.length()) {
            if (counter[s2.charAt(j) - 'a'] > 0) {
                counter[s2.charAt(j) - 'a']--;
                j++;
                if (j - i == s1.length()) {
                    return true;
                }
            } else {
                counter[s2.charAt(i) - 'a']++;
                i++;
            }
        }
        return false;
    }
}