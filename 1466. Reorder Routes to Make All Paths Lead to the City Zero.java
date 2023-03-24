/*
Problem Link: https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/
*/

import java.util.*;

class Solution {
    public int minReorder(int n, int[][] connections) {
        int ans = 0;
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] connection : connections) {
            graph[connection[0]].add(connection[1]);
            graph[connection[1]].add(-connection[0]);
        }
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int child : graph[node]) {
                if (child > 0 && !visited[child]) {
                    ans++;
                    queue.add(child);
                    visited[child] = true;
                } else if (child < 0 && !visited[-child]) {
                    queue.add(-child);
                    visited[-child] = true;
                }
            }
        }
        return ans;
    }
}