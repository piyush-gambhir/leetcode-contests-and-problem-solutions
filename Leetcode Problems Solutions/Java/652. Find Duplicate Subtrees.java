/*
Problem Link: https://leetcode.com/problems/find-duplicate-subtrees/
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
    private String helper(TreeNode root, Map<String, Integer> map, List<TreeNode> res) {
        if (root == null) {
            return "";
        }
        String left = helper(root.left, map, res);
        String right = helper(root.right, map, res);
        String path = left + "," + right + "," + root.val;
        map.put(path, map.getOrDefault(path, 0) + 1);
        if (map.get(path) == 2) {
            res.add(root);
        }
        return path;
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        helper(root, map, res);
        return res;
    }

}