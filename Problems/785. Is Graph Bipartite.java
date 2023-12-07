/*
Problem Link: https://leetcode.com/problems/is-graph-bipartite/
*/

import java.util.*;

class Solution {
    private boolean validColor(int[][] graph, int[] color, int c, int node) {
        if (color[node] != 0)
            return color[node] == c;

        color[node] = c;
        for (int next : graph[node]) {
            if (!validColor(graph, color, -c, next))
                return false;
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];

        for (int i = 0; i < n; i++) {
            if (color[i] == 0 && !validColor(graph, color, 1, i))
                return false;
        }
        return true;
    }
}