/*
Problem Link: https://leetcode.com/problems/non-overlapping-intervals/
*/

import java.util.*;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0)
            return 0;
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int ans = 0, prev = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[prev][1])
                ans++;
            else
                prev = i;
        }
        return ans;
    }
}