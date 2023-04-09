/*
Problem Link: https://leetcode.com/problems/day-of-the-week/
*/

import java.util.*;

class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        String[] days = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
        int[] months = { 0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4 };
        if (month < 3) {
            year--;
        }
        return days[(year + year / 4 - year / 100 + year / 400 + months[month - 1] + day) % 7];
    }
}