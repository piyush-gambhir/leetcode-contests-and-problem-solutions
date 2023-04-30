/*
Problem Link: https://leetcode.com/problems/remove-max-number-of-edges-to-keep-graph-fully-traversable/
*/

import java.util.*;

class Solution {
    public int findParent(int[] parent, int node) {
        if (parent[node] == node) {
            return node;
        }
        return parent[node] = findParent(parent, parent[node]);
    }

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int ans = 0;
        int[] parentA = new int[n + 1];
        int[] parentB = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parentA[i] = i;
            parentB[i] = i;
        }
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                int parent1 = findParent(parentA, edge[1]);
                int parent2 = findParent(parentA, edge[2]);
                if (parent1 == parent2) {
                    ans++;
                } else {
                    parentA[parent1] = parent2;
                    parentB[parent1] = parent2;
                }
            }
        }
        for (int[] edge : edges) {
            if (edge[0] == 1) {
                int parent1 = findParent(parentA, edge[1]);
                int parent2 = findParent(parentA, edge[2]);
                if (parent1 == parent2) {
                    ans++;
                } else {
                    parentA[parent1] = parent2;
                }
            } else if (edge[0] == 2) {
                int parent1 = findParent(parentB, edge[1]);
                int parent2 = findParent(parentB, edge[2]);
                if (parent1 == parent2) {
                    ans++;
                } else {
                    parentB[parent1] = parent2;
                }
            }
        }
        int countA = 0;
        int countB = 0;
        for (int i = 1; i <= n; i++) {
            if (parentA[i] == i) {
                countA++;
            }
            if (parentB[i] == i) {
                countB++;
            }
        }
        if (countA > 1 || countB > 1) {
            return -1;
        }
        return ans;
    }
}