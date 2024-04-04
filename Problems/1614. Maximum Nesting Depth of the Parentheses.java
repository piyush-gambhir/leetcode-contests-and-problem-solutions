/*
Problem Link: https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/
*/

import java.util.*;

class Solution {
    public int maxDepth(String s) {
        int maxDepth = 0;
        int currentDepth = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                currentDepth++;
                maxDepth = Math.max(maxDepth, currentDepth);
            } else if (s.charAt(i) == ')') {
                currentDepth--;
            }
        }
        return maxDepth;
    }
}