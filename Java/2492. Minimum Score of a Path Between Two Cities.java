/*
Problem Link: https://leetcode.com/problems/minimum-score-of-a-path-between-two-cities/
*/

import java.util.*;

class Solution {
    public int minScore(int n, int[][] roads) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());
        for (int[] e : roads) {
            graph.get(e[0] - 1).add(new int[] { e[1] - 1, e[2] });
            graph.get(e[1] - 1).add(new int[] { e[0] - 1, e[2] });
        }
        return getMin(0, new boolean[n], graph);
    }

    private int getMin(int node, boolean[] visited, List<List<int[]>> graph) {
        int minScore = Integer.MAX_VALUE;
        visited[node] = true;
        for (int[] child : graph.get(node)) {
            minScore = Math.min(minScore, child[1]);
            if (!visited[child[0]]) {
                minScore = Math.min(minScore, getMin(child[0], visited, graph));
            }
        }
        return minScore;
    }
}