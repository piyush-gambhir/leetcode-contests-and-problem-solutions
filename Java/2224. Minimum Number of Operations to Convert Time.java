/*
Problem Link: https://leetcode.com/problems/minimum-number-of-operations-to-convert-time/
*/

import java.util.*;

class Solution {
    public int convertTime(String current, String correct) {
        int currentHour = Integer.parseInt(current.substring(0, 2));
        int currentMinute = Integer.parseInt(current.substring(3, 5));
        int correctHour = Integer.parseInt(correct.substring(0, 2));
        int correctMinute = Integer.parseInt(correct.substring(3, 5));
        int hourDifference = correctHour - currentHour;
        int minuteDifference = correctMinute - currentMinute;
        if (hourDifference < 0) {
            hourDifference += 24;
        }
        if (minuteDifference < 0) {
            minuteDifference += 60;
            hourDifference--;
        }

        int minOperations = 0;
        minOperations += hourDifference;

        while (minuteDifference > 0) {
            if (minuteDifference >= 15) {
                minuteDifference -= 15;
                minOperations += 1;
            } else if (minuteDifference >= 5) {
                minuteDifference -= 5;
                minOperations += 1;
            } else if (minuteDifference >= 1) {
                minuteDifference -= 1;
                minOperations += 1;
            }
        }

        return minOperations;
    }
}