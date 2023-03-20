/*
Problem Link: https://leetcode.com/problems/jump-game-iv/
*/

import java.util.*;

class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if (n == 1)
            return 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        boolean[] visited = new boolean[n];
        visited[0] = true;
        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int curr = q.poll();
                if (curr == n - 1)
                    return steps;
                if (curr - 1 >= 0 && !visited[curr - 1]) {
                    q.add(curr - 1);
                    visited[curr - 1] = true;
                }
                if (curr + 1 < n && !visited[curr + 1]) {
                    q.add(curr + 1);
                    visited[curr + 1] = true;
                }
                for (int next : map.get(arr[curr])) {
                    if (!visited[next]) {
                        q.add(next);
                        visited[next] = true;
                    }
                }
                map.get(arr[curr]).clear();
            }
            steps++;
        }
        return -1;
    }
}