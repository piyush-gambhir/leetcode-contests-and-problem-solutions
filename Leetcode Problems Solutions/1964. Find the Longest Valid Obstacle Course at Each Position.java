/*
Problem Link: https://leetcode.com/problems/find-the-longest-valid-obstacle-course-at-each-position/
*/

import java.util.*;

class Solution {
    private int binarySearch(List<Integer> list, int val) {
        int lo = 0, hi = list.size() - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int midVal = list.get(mid);
            if (midVal <= val) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }

    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n = obstacles.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        List<Integer> list = new ArrayList<>();
        list.add(obstacles[0]);

        for (int i = 1; i < n; i++) {
            int val = obstacles[i];
            if (val >= list.get(list.size() - 1)) {
                list.add(val);
                dp[i] = list.size();
            } else {
                int idx = binarySearch(list, val);
                list.set(idx, val);
                dp[i] = idx + 1;
            }
        }
        return dp;
    }
}