/*
Problem Link: https://leetcode.com/contest/biweekly-contest-105/problems/extra-characters-in-a-string/
*/

import java.util.*;

class Solution {
    public int minExtraChar(String s, String[] dictionary) {

        Arrays.sort(dictionary, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return s2.length() - s1.length();
            }
        });

        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (String word : dictionary) {
            HashMap<Character, Integer> temp = new HashMap<>();
            for (char c : word.toCharArray()) {
                temp.put(c, temp.getOrDefault(c, 0) + 1);
            }

            boolean flag = true;
            for (char c : temp.keySet()) {
                if (!map.containsKey(c) || map.get(c) < temp.get(c)) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                for (char c : temp.keySet()) {
                    map.put(c, map.get(c) - temp.get(c));
                }
            }
        }
        int count = 0;
        for (char c : map.keySet()) {
            count += map.get(c);
        }

        return count;
    }
}
