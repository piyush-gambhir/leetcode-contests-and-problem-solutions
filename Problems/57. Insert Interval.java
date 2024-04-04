/*
Problem Link: https://leetcode.com/problems/insert-interval/
*/

import java.util.*;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i++]);
        }
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i++][1]);
        }
        result.add(newInterval);
        while (i < intervals.length) {
            result.add(intervals[i++]);
        }
        return result.toArray(new int[result.size()][]);
    }
}