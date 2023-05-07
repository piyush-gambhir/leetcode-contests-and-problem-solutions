/*
Problem Link: https://leetcode.com/contest/weekly-contest-344/problems/number-of-adjacent-elements-with-the-same-color/
*/

import java.util.*;

class Solution {
    public int[] colorTheArray(int n, int[][] queries) {
        int[] nums = new int[n];
        int[] answer = new int[queries.length];
        int sameColorCount;

        for (int i = 0; i < queries.length; i++) {
            int index = queries[i][0];
            int color = queries[i][1];
            sameColorCount = 0;
            nums[index] = color;
            for (int j = 0; j < n - 1; j++) {
                if ((nums[j] == nums[j + 1]) && nums[j] != 0) {
                    sameColorCount++;
                }
            }
            answer[i] = sameColorCount;
        }
        return answer;
    }
}
