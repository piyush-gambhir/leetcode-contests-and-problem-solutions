/*
Problem Link: https://leetcode.com/problems/minimum-time-to-make-rope-colorful/description/
*/

import java.util.*;

class Solution {

    public int minCost(String colors, int[] neededTime) {
        int sum = 0;
        char curr = colors.charAt(0);
        int maxTime = neededTime[0];
        for (int i = 1; i < neededTime.length; i++) {
            if (curr == colors.charAt(i)) {
                if (neededTime[i] > maxTime) {
                    sum += maxTime;
                    maxTime = neededTime[i];
                } else {
                    sum += neededTime[i];
                }
            } else {
                curr = colors.charAt(i);
                maxTime = neededTime[i];
            }
        }
        return sum;
    }
}