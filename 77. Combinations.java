/*
Problem Link: https://leetcode.com/problems/combinations/
*/

import java.util.*;

class Solution {
    private void helper(List<List<Integer>> result, List<Integer> temp, int n, int k, int start) {
        if (temp.size() == k) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i <= n; i++) {
            temp.add(i);
            helper(result, temp, n, k, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(result, temp, n, k, 1);
        return result;
    }
}