/*
Problem Link: https://leetcode.com/problems/number-of-operations-to-make-network-connected/
*/

import java.util.*;

class Solution {
    private int find(int[] parent, int u) {
        if (parent[u] == u) {
            return u;
        }
        return parent[u] = find(parent, parent[u]);
    }

    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int[] connection : connections) {
            int u = connection[0];
            int v = connection[1];
            int pu = find(parent, u);
            int pv = find(parent, v);
            if (pu != pv) {
                parent[pu] = pv;
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) {
                count++;
            }
        }
        return count - 1;
    }
}