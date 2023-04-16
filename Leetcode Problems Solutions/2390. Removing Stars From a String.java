/*
Problem Link: https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
*/

import java.util.*;

class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '*') {
                stack.push(s.charAt(i));
            } else {
                stack.pop();
            }
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.reverse().toString();
    }
}