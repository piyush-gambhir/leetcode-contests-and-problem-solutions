/*
Problem Link: https://leetcode.com/problems/similar-string-groups/
*/

import java.util.*;

class UnionFind {
    int[] parent;
    int[] rank;
    int count;

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        count = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if (parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
    }

    public void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px == py)
            return;
        if (rank[px] > rank[py]) {
            parent[py] = px;
        } else if (rank[px] < rank[py]) {
            parent[px] = py;
        } else {
            parent[py] = px;
            rank[px]++;
        }
        count--;
    }
}

class Solution {
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isSimilar(strs[i], strs[j])) {
                    uf.union(i, j);
                }
            }
        }
        return uf.count;
    }

    private boolean isSimilar(String s1, String s2) {
        if (s1.equals(s2))
            return true;
        int n = s1.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
            }
        }
        return count == 2;
    }
}
