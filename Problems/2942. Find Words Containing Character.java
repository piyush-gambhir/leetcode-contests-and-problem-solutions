/*
Problem Link: https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/
*/

import java.util.*;

class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].indexOf(x) != -1) {
                result.add(i);
            }
        }
        return result;
    }
}