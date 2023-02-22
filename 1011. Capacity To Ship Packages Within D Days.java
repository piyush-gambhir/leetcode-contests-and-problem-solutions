/*
Problem Link: https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
*/

class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int max = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, weights[i]);
            sum += weights[i];
        }
        int l = max;
        int r = sum;
        while (l < r) {
            int mid = l + (r - l) / 2;
            int d = 1;
            int cur = 0;
            for (int i = 0; i < n; i++) {
                if (cur + weights[i] > mid) {
                    d++;
                    cur = 0;
                }
                cur += weights[i];
            }
            if (d > days) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}