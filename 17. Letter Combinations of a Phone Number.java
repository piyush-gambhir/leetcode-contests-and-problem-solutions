/*
Problem Link: https://leetcode.com/problems/letter-combinations-of-a-phone-number/
*/

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<String>();
        }

        String[] map = new String[] {
                "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        List<String> res = new ArrayList<String>();

    }
}