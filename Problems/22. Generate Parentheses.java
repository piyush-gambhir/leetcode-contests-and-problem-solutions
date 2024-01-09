/*
Problem Link: https://leetcode.com/problems/generate-parentheses/
*/

import java.util.*;

class Solution {
    public void helper(List<String> ans, String curr, int open, int close, int max) {
        if (curr.length() == max * 2) {
            ans.add(curr);
            return;
        }

        if (open < max) {
            helper(ans, curr + "(", open + 1, close, max);
        }
        if (close < open) {
            helper(ans, curr + ")", open, close + 1, max);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        helper(ans, "", 0, 0, n);
        return ans;
    }
}