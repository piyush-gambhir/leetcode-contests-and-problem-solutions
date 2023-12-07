/*
Problem Link: https://leetcode.com/problems/successful-pairs-of-spells-and-potions/
*/

import java.util.*;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;

        int[] pairs = new int[n];
        Arrays.sort(potions);

        for (int i = 0; i < n; i++) {
            int low = 0;
            int high = m - 1;

            while (low <= high) {
                int mid = low + (high - low) / 2;
                long product = (long) spells[i] * potions[mid];
                if (product >= success) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            pairs[i] = m - low;
        }

        return pairs;
    }
}