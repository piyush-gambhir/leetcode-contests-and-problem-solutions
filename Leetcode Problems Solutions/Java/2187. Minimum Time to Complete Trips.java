/*
Problem Link: https://leetcode.com/problems/minimum-time-to-complete-trips/
*/

import java.util.*;

class Solution {
    private boolean canComplete(int[] time, int totalTrips, long maxT) {
        long count = 0;
        for (int t : time) {
            count += maxT / t;
        }
        return count >= totalTrips;
    }

    public long minimumTime(int[] time, int totalTrips) {
        int n = time.length;
        int leastTimeBus = Integer.MAX_VALUE, maxTimeBus = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            leastTimeBus = Math.min(leastTimeBus, time[i]);
            maxTimeBus = Math.max(maxTimeBus, time[i]);
        }
        long l = leastTimeBus, h = (long) maxTimeBus * totalTrips, ans = Integer.MAX_VALUE;

        while (l <= h) {
            long mid = l + (h - l) / 2;

            if (canComplete(time, totalTrips, mid)) {
                ans = mid;
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
}