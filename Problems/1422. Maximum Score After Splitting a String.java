/*
Problem Link: https://leetcode.com/problems/maximum-score-after-splitting-a-string/
*/

import java.util.*;

class Solution {
    public int maxScore(String s) {
        int n = s.length();
        int[] left = new int[n];
        int[] right = new int[n];

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                count++;
            }
            left[i] = count;
        }

        count = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                count++;
            }
            right[i] = count;
        }

        int max = 0;
        for (int i = 0; i < n - 1; i++) {
            max = Math.max(max, left[i] + right[i + 1]);
        }

        return max;
    }
}