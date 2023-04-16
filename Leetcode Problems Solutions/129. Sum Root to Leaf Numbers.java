/*
Problem Link: https://leetcode.com/problems/sum-root-to-leaf-numbers/
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
    private void rootToLeafPath(TreeNode root, ArrayList<String> paths, String path) {
        if (root == null) {
            return;
        }
        path += root.val;
        if (root.left == null && root.right == null) {
            paths.add(path);
            return;
        }
        rootToLeafPath(root.left, paths, path);
        rootToLeafPath(root.right, paths, path);
    }

    public int sumNumbers(TreeNode root) {
        ArrayList<String> paths = new ArrayList<>();
        rootToLeafPath(root, paths, "");
        int sum = 0;
        for (String path : paths) {
            sum += Integer.parseInt(path);
        }
        return sum;
    }
}