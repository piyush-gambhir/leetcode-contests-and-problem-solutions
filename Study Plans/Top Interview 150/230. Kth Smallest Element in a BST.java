/*
Problem Link: https://leetcode.com/problems/kth-smallest-element-in-a-bst/
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
    private void inorder(TreeNode root, ArrayList<TreeNode> inorder) {
        if (root == null) {
            return;
        }
        inorder(root.left, inorder);
        inorder.add(root);
        inorder(root.right, inorder);
    }

    public int kthSmallest(TreeNode root, int k) {

        ArrayList<TreeNode> inorder = new ArrayList<TreeNode>();
        inorder(root, inorder);
        return inorder.get(k - 1).val;
    }
}