/*
Problem Link: https://leetcode.com/problems/find-the-town-judge/
*/

import java.util.*;

class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] trustCount = new int[n + 1];
        for (int[] t : trust) {
            trustCount[t[0]]--;
            trustCount[t[1]]++;
        }
        for (int i = 1; i <= n; i++) {
            if (trustCount[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }
}