/*
Problem Link: https://leetcode.com/problems/evaluate-division/
*/

import java.util.*;

class Solution {

    private double dfs(Map<String, Map<String, Double>> graph, String u, String v, Set<String> visited, double val) {

        if (u.equals(v)) {
            return val;
        }

        visited.add(u);

        for (Map.Entry<String, Double> entry : graph.get(u).entrySet()) {
            String next = entry.getKey();
            double w = entry.getValue();

            if (!visited.contains(next)) {
                double ans = dfs(graph, next, v, visited, val * w);
                if (ans != -1.0) {
                    return ans;
                }
            }
        }

        return -1.0;
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        Map<String, Map<String, Double>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double w = values[i];

            graph.putIfAbsent(u, new HashMap<>());
            graph.putIfAbsent(v, new HashMap<>());

            graph.get(u).put(v, w);
            graph.get(v).put(u, 1 / w);
        }

        double[] ans = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            String u = queries.get(i).get(0);
            String v = queries.get(i).get(1);

            if (!graph.containsKey(u) || !graph.containsKey(v)) {
                ans[i] = -1.0;
            } else {
                ans[i] = dfs(graph, u, v, new HashSet<>(), 1.0);
            }
        }

        return ans;
    }
}