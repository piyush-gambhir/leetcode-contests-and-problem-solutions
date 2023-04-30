/*
Problem Link: https://leetcode.com/problems/checking-existence-of-edge-length-limited-paths/
*/

import java.util.*;

class Solution {
    class UnionFind {
        int[] parent;
        int[] rank;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] == x) {
                return x;
            }
            return parent[x] = find(parent[x]);
        }

        public void union(int x, int y) {
            int lx = find(x);
            int ly = find(y);
            if (lx != ly) {
                if (rank[lx] > rank[ly]) {
                    parent[ly] = lx;
                } else if (rank[lx] < rank[ly]) {
                    parent[lx] = ly;
                } else {
                    parent[lx] = ly;
                    rank[ly]++;
                }
            }
        }
    }

    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);
        int m = queries.length;
        int[][] newQueries = new int[m][4];
        for (int i = 0; i < m; i++) {
            newQueries[i][0] = queries[i][0];
            newQueries[i][1] = queries[i][1];
            newQueries[i][2] = queries[i][2];
            newQueries[i][3] = i;
        }
        Arrays.sort(newQueries, (a, b) -> a[2] - b[2]);
        boolean[] ans = new boolean[m];
        UnionFind uf = new UnionFind(n);
        int i = 0;
        for (int[] query : newQueries) {
            int u = query[0];
            int v = query[1];
            int limit = query[2];
            int index = query[3];
            while (i < edgeList.length && edgeList[i][2] < limit) {
                uf.union(edgeList[i][0], edgeList[i][1]);
                i++;
            }
            ans[index] = uf.find(u) == uf.find(v);
        }
        return ans;
    }
}