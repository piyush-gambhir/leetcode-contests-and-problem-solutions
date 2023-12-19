/*
Problem Link: https://leetcode.com/contest/warm-up-contest/problems/lexicographical-numbers/
*/

import java.util.*;

class Solution {
    private void dfs(int curr, int n, List<Integer> list) {
        if (curr > n) {
            return;
        }
        list.add(curr);
        for (int i = 0; i <= 9; i++) {
            dfs(curr * 10 + i, n, list);
        }
    }

    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            dfs(i, n, list);
        }
        return list;

    }
}