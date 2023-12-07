/*
Problem Link: https://leetcode.com/problems/minimize-string-length/
*/

import java.util.*;

class Solution {
    public int minimizedStringLength(String s) {
        int minimizedStringLength = 0;
        boolean[] charList = new boolean[26];

        for (int i = 0; i < s.length(); i++) {
            if (!charList[s.charAt(i) - 'a']) {
                minimizedStringLength++;
            }
            charList[s.charAt(i) - 'a'] = true;;
        }
        return minimizedStringLength;
    }
}