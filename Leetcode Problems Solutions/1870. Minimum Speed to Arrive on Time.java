/*
Problem Link: https://leetcode.com/problems/minimum-speed-to-arrive-on-time/
*/

class Solution {
    public boolean canReach(int[] dist, double hour, int speed) {
        double time = 0;
        for (int i = 0; i < dist.length - 1; i++) {
            time += Math.ceil((double) dist[i] / speed);
        }
        time += (double) dist[dist.length - 1] / speed;
        return time <= hour;
    }

    public int minSpeedOnTime(int[] dist, double hour) {
        int n = dist.length;
        if (hour < n - 1)
            return -1;
        int l = 1, r = 10000000;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (canReach(dist, hour, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return canReach(dist, hour, l) ? l : -1;
    }
}