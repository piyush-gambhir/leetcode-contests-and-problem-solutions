/*
Problem Link: https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/
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
    public int maxLevelSum(TreeNode root) {
        if (root == null)
            return 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int maxSum = Integer.MIN_VALUE;
        int maxLevel = 0;
        int level = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            int sum = 0;
            level++;

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                sum += curr.val;

                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
            }

            if (sum > maxSum) {
                maxSum = sum;
                maxLevel = level;
            }
        }
        return maxLevel;
    }
}