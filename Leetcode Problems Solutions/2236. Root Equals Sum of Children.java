/*
Problem Link: https://leetcode.com/problems/path-sum-iii/
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
    public boolean checkTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (root.left == null && root.right == null) {
            return false;
        }

        int sumChildren = 0;
        if (root.left != null) {
            sumChildren += root.left.val;
        }
        if (root.right != null) {
            sumChildren += root.right.val;
        }

        return root.val == sumChildren;
    }
}