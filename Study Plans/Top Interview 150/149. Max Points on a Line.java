/*
Problem Link: https://leetcode.com/problems/max-points-on-a-line/
*/

class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) {
            return n;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];

            for (int j = i + 1; j < n; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];

                int count = 0;
                for (int k = 0; k < n; k++) {
                    int x3 = points[k][0];
                    int y3 = points[k][1];

                    if ((y2 - y1) * (x3 - x2) == (y3 - y2) * (x2 - x1)) {
                        count++;
                    }
                }
                ans = Math.max(ans, count);
            }
        }
        return ans;
    }
}