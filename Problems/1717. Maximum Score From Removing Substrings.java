/*
Problem Link: https://leetcode.com/problems/maximum-score-from-removing-substrings/
*/

import java.util.*;

class Solution {
    public int maximumGain(String s, int x, int y) {
        int score = 0;
        String a = "ab";
        String b = "ba";
        if (x < y) {
            a = "ba";
            b = "ab";
            int temp = x;
            x = y;
            y = temp;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == a.charAt(1) && !stack.isEmpty() && stack.peek() == a.charAt(0)) {
                stack.pop();
                score += x;
            } else {
                stack.push(c);
            }
        }
        Stack<Character> stack2 = new Stack<>();
        for (char c : stack) {
            if (c == b.charAt(1) && !stack2.isEmpty() && stack2.peek() == b.charAt(0)) {
                stack2.pop();
                score += y;
            } else {
                stack2.push(c);
            }
        }
        return score;
    }
}