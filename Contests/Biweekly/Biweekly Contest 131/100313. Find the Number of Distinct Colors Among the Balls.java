/*
Problem Link: https://leetcode.com/contest/biweekly-contest-131/problems/find-the-number-of-distinct-colors-among-the-balls/
*/

import java.util.*;

class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer, Integer> ballToColor = new HashMap<>();
        Map<Integer, Integer> colorFrequency = new HashMap<>();
        int[] results = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int ballIndex = queries[i][0];
            int newColor = queries[i][1];

            if (ballToColor.containsKey(ballIndex)) {
                int previousColor = ballToColor.get(ballIndex);
                colorFrequency.put(previousColor, colorFrequency.get(previousColor) - 1);
                if (colorFrequency.get(previousColor) == 0) {
                    colorFrequency.remove(previousColor);
                }
            }

            ballToColor.put(ballIndex, newColor);
            colorFrequency.put(newColor, colorFrequency.getOrDefault(newColor, 0) + 1);

            results[i] = colorFrequency.size();
        }

        return results;
    }
}
