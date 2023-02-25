/*
Problem Link: https://leetcode.com/problems/validate-binary-search-tree/
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
    public boolean isValidBST(TreeNode root) {

        return isValidBST(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    boolean isValidBST(TreeNode root, long max, long min) {

        if (root == null) {
            return true;
        }

        if (min >= root.val || max <= root.val) {
            return false;
        }

        return isValidBST(root.left, root.val, min) && isValidBST(root.right, max, root.val);
    }
}