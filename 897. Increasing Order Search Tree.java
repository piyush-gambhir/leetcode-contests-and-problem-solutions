/*
Problem Link: https://leetcode.com/problems/increasing-order-search-tree/
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
    private TreeNode increasingBST(TreeNode root, TreeNode newTree) {
        if (root == null) {
            return newTree;
        }
        newTree = increasingBST(root.left, newTree);
        newTree.right = new TreeNode(root.val);
        newTree = newTree.right;
        newTree = increasingBST(root.right, newTree);
        return newTree;
    }

    public TreeNode increasingBST(TreeNode root) {
        TreeNode newTree = new TreeNode();
        increasingBST(root, newTree);
        return newTree.right;
    }
}