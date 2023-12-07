/*
Problem Link: https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/
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
    private static void dfs(TreeNode root, int[] ans, int left, int right) {
        if (root == null) {
            return;
        }

        ans[0] = Math.max(ans[0], Math.max(left, right));
        dfs(root.left, ans, right + 1, 0);
        dfs(root.right, ans, 0, left + 1);

    }

    public int longestZigZag(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] ans = new int[1];
        dfs(root, ans, 0, 0);
        return ans[0];
    }
}