/*
Problem Link: https://leetcode.com/problems/find-mode-in-binary-search-tree/
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

import java.util.*;

class Solution {
    private void dfs(TreeNode root, Map<Integer, Integer> map) {
        if (root == null)
            return;
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        dfs(root.left, map);
        dfs(root.right, map);
    }

    public int[] findMode(TreeNode root) {
        if (root == null)
            return new int[0];
        Map<Integer, Integer> map = new HashMap<>();
        dfs(root, map);
        int max = 0;
        for (int key : map.keySet()) {
            max = Math.max(max, map.get(key));
        }
        List<Integer> list = new ArrayList<>();
        for (int key : map.keySet()) {
            if (map.get(key) == max)
                list.add(key);
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}