/*
Problem Link: https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import java.util.*;

class Solution {
    private Map<TreeNode, TreeNode> parentMap;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
        parentMap = new HashMap<>();

        populateParentMap(root, null);
        dfs(target, k, result, new HashSet<>());

        return result;
    }

    private void populateParentMap(TreeNode node, TreeNode parent) {
        if (node == null) return;

        parentMap.put(node, parent);
        populateParentMap(node.left, node);
        populateParentMap(node.right, node);
    }

    private void dfs(TreeNode node, int k, List<Integer> result, Set<TreeNode> visited) {
        if (node == null || visited.contains(node)) return;

        visited.add(node);

        if (k == 0) {
            result.add(node.val);
            return;
        }

        dfs(node.left, k - 1, result, visited);
        dfs(node.right, k - 1, result, visited);

        TreeNode parentNode = parentMap.get(node);
        dfs(parentNode, k - 1, result, visited);
    }
}
