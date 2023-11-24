/*
Problem Link: https://leetcode.com/problems/maximum-number-of-coins-you-can-get/
*/

import java.util.*;

class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int n = piles.length;
        int ans = 0;
        int i = 0;
        int j = n - 2;
        while (i < j) {
            ans += piles[j];
            i++;
            j -= 2;
        }
        return ans;
    }
}