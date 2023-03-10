/*
Problem Link: https://leetcode.com/problems/single-number/
*/

import java.util.*;

class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        if (deck.length == 1) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < deck.length; i++) {
            map.put(deck[i], map.getOrDefault(deck[i], 0) + 1);
        }

        int min = Integer.MAX_VALUE;
        for (int key : map.keySet()) {
            min = Math.min(min, map.get(key));
        }

        for (int i = 2; i <= min; i++) {
            boolean flag = true;
            for (int key : map.keySet()) {
                if (map.get(key) % i != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            }
        }

        return false;
    }
}