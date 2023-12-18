/*
Problem Link: https://leetcode.com/problems/number-of-employees-who-met-the-target/
*/

import java.util.*;

class Solution {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int count = 0;
        for (int hour : hours)
            if (hour >= target)
                count++;
        return count;
    }
}