/*
Problem Link: https://leetcode.com/problems/verifying-an-alien-dictionary/
*/

class Solution {
    public boolean isSorted(String word1, String word2, int[] orderMap) {
        int i = 0;
        while (i < word1.length() && i < word2.length()) {
            if (word1.charAt(i) != word2.charAt(i)) {
                return orderMap[word1.charAt(i) - 'a'] < orderMap[word2.charAt(i) - 'a'];
            }
            i++;
        }
        return word1.length() <= word2.length();
    }

    public boolean isAlienSorted(String[] words, String order) {
        int[] orderMap = new int[26];
        for (int i = 0; i < order.length(); i++) {
            orderMap[order.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < words.length - 1; i++) {
            if (!isSorted(words[i], words[i + 1], orderMap)) {
                return false;
            }
        }
        return true;
    }
}