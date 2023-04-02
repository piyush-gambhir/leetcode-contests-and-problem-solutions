/*
Problem Link: https://leetcode.com/problems/keys-and-rooms/?envType=study-plan&id=graph-i
*/

import java.util.*;

class Solution {
    private void dfs(List<List<Integer>> rooms, int i, boolean[] visited) {
        if (visited[i]) {
            return;
        }
        visited[i] = true;
        for (int j : rooms.get(i)) {
            dfs(rooms, j, visited);
        }
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        dfs(rooms, 0, visited);
        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }
        return true;
    }
}