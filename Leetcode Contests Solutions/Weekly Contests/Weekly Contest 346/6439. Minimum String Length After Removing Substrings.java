/*
Problem Link: https://leetcode.com/contest/weekly-contest-346/problems/minimum-string-length-after-removing-substrings/
*/

import java.util.*;

class Solution {
    public int minLength(String s) {
        Deque<Character> stack = new LinkedList<>();

        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peekLast() == 'A' && ch == 'B') {
                stack.removeLast(); // Remove 'A' from stack
            } else if (!stack.isEmpty() && stack.peekLast() == 'C' && ch == 'D') {
                stack.removeLast(); // Remove 'C' from stack
            } else {
                stack.addLast(ch);
            }
        }

        return stack.size();
    }
}