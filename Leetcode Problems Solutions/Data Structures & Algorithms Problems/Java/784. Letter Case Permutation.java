/*
Poblem Link: https://leetcode.com/problems/letter-case-permutation/
*/

import java.util.*;

class Solution {
    private void helper(List<String> result, String s, int index) {
        if (index == s.length()) {
            result.add(s);
            return;
        }
        if (Character.isDigit(s.charAt(index))) {
            helper(result, s, index + 1);
        } else {
            char[] chars = s.toCharArray();
            chars[index] = Character.toLowerCase(chars[index]);
            helper(result, String.valueOf(chars), index + 1);
            chars[index] = Character.toUpperCase(chars[index]);
            helper(result, String.valueOf(chars), index + 1);
        }
    }

    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        helper(result, s, 0);
        return result;
    }
}