/*
Problem Link: https://leetcode.com/problems/fair-candy-swap/
*/

import java.util.*;

class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int bobSum = 0;
        for (int i = 0; i < bobSizes.length; i++) {
            bobSum += bobSizes[i];
        }
        int aliceSum = 0;
        for (int i = 0; i < aliceSizes.length; i++) {
            aliceSum += aliceSizes[i];
        }

        int diff = (bobSum - aliceSum) / 2;

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < bobSizes.length; i++) {
            set.add(bobSizes[i]);
        }

        for (int i = 0; i < aliceSizes.length; i++) {
            if (set.contains(aliceSizes[i] + diff)) {
                return new int[] { aliceSizes[i], aliceSizes[i] + diff };
            }
        }

        return new int[] { 0, 0 };
    }
}