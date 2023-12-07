/*
Problem Link: https://leetcode.com/problems/maximize-area-of-square-hole-in-grid/description/
*/

import java.util.*;

import java.util.Arrays;

class Solution {
    private int calculateMaxSequenceLength(int[] nums) {
        int maxLength = 0, currentLength = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] - nums[i] == 1)
                currentLength++;
            else {
                maxLength = Math.max(maxLength, currentLength + 1);
                currentLength = 1;
            }
        }
        maxLength = Math.max(maxLength, currentLength + 1);
        return maxLength;
    }

    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        int maxHorizontalSequenceLength = calculateMaxSequenceLength(hBars);
        int maxVerticalSequenceLength = calculateMaxSequenceLength(vBars);
        int maxSequenceLength = Math.min(maxHorizontalSequenceLength, maxVerticalSequenceLength);
        return maxSequenceLength * maxSequenceLength;
    }
}
