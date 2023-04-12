/*
Problem Link: https://leetcode.com/problems/split-a-string-in-balanced-strings/
*/

import java.util.*;

class Solution {
    public int balancedStringSplit(String s) {
        int countL = 0;
        int countR = 0;
        int maxBalancedStrings = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                countL++;
            }

            if (s.charAt(i) == 'R') {
                countR++;
            }

            if (countL == countR) {
                maxBalancedStrings++;
                countL = 0;
                countR = 0;
            }
        }
        return maxBalancedStrings;
    }
}