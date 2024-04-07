/*
Problem Link: https://leetcode.com/problems/valid-parenthesis-string/
*/

import java.util.*;

class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> open = new Stack<>();
        Stack<Integer> star = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                open.push(i);
            } else if (s.charAt(i) == '*') {
                star.push(i);
            } else {
                if (!open.isEmpty()) {
                    open.pop();
                } else if (!star.isEmpty()) {
                    star.pop();
                } else {
                    return false;
                }
            }
        }

        while (!open.isEmpty() && !star.isEmpty()) {
            if (open.peek() > star.peek()) {
                return false;
            }
            open.pop();
            star.pop();
        }

        return open.isEmpty();
    }
}