/*
Problem Link: https://leetcode.com/problems/ipo/
*/

import java.util.*;

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = capital[i];
            arr[i][1] = profits[i];
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int i = 0;
        while (k-- > 0) {
            while (i < n && arr[i][0] <= w) {
                pq.add(arr[i][1]);
                i++;
            }
            if (pq.isEmpty())
                break;
            w += pq.poll();
        }
        return w;
    }
}