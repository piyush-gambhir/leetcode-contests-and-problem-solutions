/*
Problem Link: https://leetcode.com/problems/decode-string/
*/

import java.util.*;

class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        int count = 0;
        String result = "";
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                count = count * 10 + c - '0';
            } else if (c == '[') {
                countStack.push(count);
                stringStack.push(result);
                count = 0;
                result = "";
            } else if (c == ']') {
                int times = countStack.pop();
                StringBuilder sb = new StringBuilder(stringStack.pop());
                for (int i = 0; i < times; i++) {
                    sb.append(result);
                }
                result = sb.toString();
            } else {
                result += c;
            }
        }
        return result;
    }
}