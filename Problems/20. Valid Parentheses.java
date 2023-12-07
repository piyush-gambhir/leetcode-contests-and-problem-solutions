/*
Problem Link: https://leetcode.com/problems/valid-parentheses/
*/

import java.util.*;

class Solution {
    public boolean isValid(String s) {
        if (s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            }
            if (stack.isEmpty()) {
                return false;
            }
            char check;
            switch (s.charAt(i)) {
                case ')':
                    check = stack.pop();
                    if (check == '{' || check == '[')
                        return false;
                    break;

                case '}':
                    check = stack.pop();
                    if (check == '(' || check == '[')
                        return false;
                    break;

                case ']':
                    check = stack.pop();
                    if (check == '(' || check == '{')
                        return false;
                    break;
            }
        }

        // Check Empty Stack
        return (stack.isEmpty());

    }
}