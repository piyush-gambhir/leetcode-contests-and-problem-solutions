/*
Problem Link: https://leetcode.com/problems/average-waiting-time/
*/

class Solution {
    public double averageWaitingTime(int[][] customers) {
        int n = customers.length;
        double waitTime = 0;
        int time = 0;
        for (int i = 0; i < n; i++) {
            if (customers[i][0] > time) {
                time = customers[i][0];
            }
            time += customers[i][1];
            waitTime += time - customers[i][0];
        }
        return waitTime / n;
    }
}