/*
Problem Link: https://leetcode.com/problems/calculate-delayed-arrival-time/
*/

import java.util.*;

class Solution {
    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        int totalHours = (arrivalTime + delayedTime) % 24;
        return totalHours;
    }
}