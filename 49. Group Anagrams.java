/*
Problem Link: https://leetcode.com/problems/group-anagrams/
*/

import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        for (String key : map.keySet()) {
            result.add(map.get(key));
        }
        return result;
    }
}