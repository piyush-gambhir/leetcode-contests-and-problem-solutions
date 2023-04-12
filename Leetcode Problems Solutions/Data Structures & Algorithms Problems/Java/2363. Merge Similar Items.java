/*
Problem Link: https://leetcode.com/problems/merge-similar-items/
*/

import java.util.*;

class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < items1.length; i++) {
            map.put(items1[i][0], items1[i][1]);
        }

        for (int i = 0; i < items2.length; i++) {
            if (map.containsKey(items2[i][0])) {
                map.put(items2[i][0], map.get(items2[i][0]) + items2[i][1]);
            } else {
                map.put(items2[i][0], items2[i][1]);
            }
        }

        TreeMap<Integer, Integer> sortedMap = new TreeMap<>(map);

        List<List<Integer>> ans = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : sortedMap.entrySet()) {
            List<Integer> temp = new ArrayList<>();
            temp.add(entry.getKey());
            temp.add(entry.getValue());
            ans.add(temp);
        }

        return ans;
    }
}