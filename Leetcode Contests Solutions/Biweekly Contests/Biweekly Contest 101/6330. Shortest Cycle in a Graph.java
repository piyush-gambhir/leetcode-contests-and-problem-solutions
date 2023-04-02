
/*
There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1. The edges in the graph are represented by a given 2D integer array edges, where edges[i] = [ui, vi] denotes an edge between vertex ui and vertex vi. Every vertex pair is connected by at most one edge, and no vertex has an edge to itself.

Return the length of the shortest cycle in the graph. If no cycle exists, return -1.

A cycle is a path that starts and ends at the same node, and each edge in the path is used only once.

Input: n = 7, edges = [[0,1],[1,2],[2,0],[3,4],[4,5],[5,6],[6,3]]
Output: 3
Explanation: The cycle with the smallest length is : 0 -> 1 -> 2 -> 0 


Input: n = 4, edges = [[0,1],[0,2]]
Output: -1
Explanation: There are no cycles in this graph.
*/

import java.util.*;

class Solution {
    public int findShortestCycle(int n, int[][] edges) {
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        int minCycle = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int[] dist = new int[n];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[i] = 0;
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            while (!q.isEmpty()) {
                int node = q.poll();
                for (int neighbor : adj[node]) {
                    if (dist[neighbor] == Integer.MAX_VALUE) {
                        dist[neighbor] = dist[node] + 1;
                        q.add(neighbor);
                    } else if (neighbor != i) {
                        minCycle = Math.min(minCycle, dist[node] + dist[neighbor] + 1);
                    }
                }
            }
        }
        return minCycle == Integer.MAX_VALUE ? -1 : minCycle;
    }
}
