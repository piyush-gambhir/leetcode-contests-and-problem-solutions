/*
Problem Link: https://leetcode.com/problems/truncate-sentence/
*/

import java.util.*;

class Solution {
    public String truncateSentence(String s, int k) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            sb.append(words[i]);
            if (i != k - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}