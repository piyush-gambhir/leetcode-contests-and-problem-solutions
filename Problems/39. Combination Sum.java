/*
Problem Link: https://leetcode.com/problems/combination-sum/
*/

import java.util.*;

class Solution {
    private void combinationSum(
            int[] candidates, int target, int index, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            current.add(candidates[i]);
            combinationSum(candidates, target - candidates[i], i, current, result);
            current.remove(current.size() - 1);
        }

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combinationSum(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }
}