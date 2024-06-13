/*
Problem Link: https://leetcode.com/problems/append-characters-to-string-to-make-subsequence/
*/
class Solution {
    public int appendCharacters(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        int sIndex = 0;
        int tIndex = 0;

        while (sIndex < sLen && tIndex < tLen) {
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                tIndex++;
            }
            sIndex++;
        }

        return tLen - tIndex;
    }
}
