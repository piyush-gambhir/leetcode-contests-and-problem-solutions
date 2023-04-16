/*
Problem Link: https://leetcode.com/problems/merge-strings-alternately/
*/

class Solution {
    public String mergeAlternately(String word1, String word2) {
        int i = 0, j = 0;
        String newString = "";
        while (i < word1.length() && j < word2.length()) {
            newString += word1.charAt(i);
            newString += word2.charAt(j);
            i++;
            j++;
        }
        while (i < word1.length()) {
            newString += word1.charAt(i);
            i++;
        }
        while (j < word2.length()) {
            newString += word2.charAt(j);
            j++;
        }
        return newString;
    }
}