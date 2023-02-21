/*
Problem Link: https://leetcode.com/problems/reverse-words-in-a-string-iii/
*/

class Solution {
    private String reverseWord(String word) {
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[chars.length - i - 1];
            chars[chars.length - i - 1] = temp;
        }
        return new String(chars);
    }

    public String reverseWords(String s) {
        String[] words = s.split(" ");

        for (int i = 0; i < words.length; i++) {
            words[i] = reverseWord(words[i]);
        }

        return String.join(" ", words);
    }
}