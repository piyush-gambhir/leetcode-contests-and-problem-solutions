/*
Problem Link: https://leetcode.com/problems/k-closest-points-to-origin/
*/

import java.util.*;

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] kClosestPoints = new int[k][2];
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]));
        for (int[] point : points) {
            maxHeap.add(point);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        for (int i = 0; i < k; i++) {
            kClosestPoints[i] = maxHeap.poll();
        }
        return kClosestPoints;
    }
}