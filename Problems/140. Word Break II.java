
/*
Problem Link: https://leetcode.com/problems/word-break-ii/
*/

import java.util.*;

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        Map<String, List<String>> memo = new HashMap<>();
        return backtrack(s, wordSet, memo);
    }

    private List<String> backtrack(String s, Set<String> wordSet, Map<String, List<String>> memo) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }

        List<String> result = new ArrayList<>();

        if (wordSet.contains(s)) {
            result.add(s);
        }

        for (int i = 1; i < s.length(); i++) {
            String prefix = s.substring(0, i);
            String suffix = s.substring(i);

            if (wordSet.contains(prefix)) {
                List<String> suffixBreaks = backtrack(suffix, wordSet, memo);
                for (String suffixBreak : suffixBreaks) {
                    result.add(prefix + " " + suffixBreak);
                }
            }
        }

        memo.put(s, result);    
        return result;
    }
}
