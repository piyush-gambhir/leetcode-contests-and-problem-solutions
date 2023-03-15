/*
Problem Link: https://leetcode.com/problems/sort-the-people/
*/

import java.util.*;

class Solution {
    public String[] sortPeople(String[] names, int[] heights) {

        HashMap<Integer, String> map = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            map.put(heights[i], names[i]);
        }

        TreeMap<Integer, String> sortedMap = new TreeMap<>(Collections.reverseOrder());
        sortedMap.putAll(map);
        String[] ans = new String[names.length];
        int i = 0;
        for (Map.Entry<Integer, String> entry : sortedMap.entrySet()) {
            ans[i++] = entry.getValue();
        }
        return ans;
    }
}