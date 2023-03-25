/*
Problem Link: https://leetcode.com/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/
*/

import java.util.*;

class Solution {

    public int bfs(int i, boolean[] vis, List<List<Integer>> adj, int count) {
        Queue<Integer> qu = new LinkedList<>();
        qu.add(i);
        count++;
        while (!qu.isEmpty()) {
            int curr = qu.poll();
            for (int adjnode : adj.get(curr)) {
                if (!vis[adjnode]) {
                    qu.add(adjnode);
                    count++;
                    vis[adjnode] = true;
                }
            }
        }
        return count;
    }

    public long countPairs(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        long sum = n;
        long res = 0;
        boolean vis[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                vis[i] = true;
                int count = bfs(i, vis, adjList, 0);
                sum -= count;
                res += (sum * count);
            }
        }
        return res;
    }
}
