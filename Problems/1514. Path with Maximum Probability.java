/*
Problem Link: https://leetcode.com/problems/path-with-maximum-probability/
*/

import java.util.*;

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, List<double[]>> graph = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.putIfAbsent(edge[1], new ArrayList<>());
            graph.get(edge[0]).add(new double[] { edge[1], succProb[i] });
            graph.get(edge[1]).add(new double[] { edge[0], succProb[i] });
        }
        double[] prob = new double[n];
        prob[start] = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (double[] next : graph.getOrDefault(node, new ArrayList<>())) {
                int nextNode = (int) next[0];
                double nextProb = next[1];
                if (prob[node] * nextProb > prob[nextNode]) {
                    prob[nextNode] = prob[node] * nextProb;
                    queue.add(nextNode);
                }
            }
        }
        return prob[end];
    }
}