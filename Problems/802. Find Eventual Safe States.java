/*
Problem Link: https://leetcode.com/problems/find-eventual-safe-states/
*/

import java.util.*;

class Solution {
    public boolean dfs(int[][] graph, int node, int[] color){
        if(color[node] > 0)
            return color[node] == 2;
        
        color[node] = 1;
        for(int nei : graph[node]){
            if(color[nei] == 2)
                continue;
            if(color[nei] == 1 || !dfs(graph, nei, color))
                return false;
        }
        color[node] = 2;
        return true;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        List<Integer> ans = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            if(dfs(graph, i, color))
                ans.add(i);
        }
        return ans;
    }
}