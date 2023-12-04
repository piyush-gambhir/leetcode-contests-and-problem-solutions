/*
Problem Link: https://leetcode.com/problems/last-visited-integers/description/
*/

import java.util.*;

class Solution {
    public List<Integer> lastVisitedIntegers(List<String> words) {
        List<Integer> reverseIntegers = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        int prev = 0;
        for (String word : words) {
            if ("prev".equals(word)) {
                prev++;
                int i = reverseIntegers.size() - prev;
                result.add(0 <= i ? reverseIntegers.get(i) : -1);
            } else {
                prev = 0;
                reverseIntegers.add(Integer.parseInt(word));
            }
        }
        return result;
    }
}