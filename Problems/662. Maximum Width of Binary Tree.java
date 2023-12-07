/*
Problem Link: https://leetcode.com/problems/maximum-width-of-binary-tree/
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
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> indexQueue = new LinkedList<>();
        queue.add(root);
        indexQueue.add(1);
        int maxWidth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int left = 0;
            int right = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                int index = indexQueue.poll();
                if (i == 0) {
                    left = index;
                }
                if (i == size - 1) {
                    right = index;
                }
                if (node.left != null) {
                    queue.add(node.left);
                    indexQueue.add(index * 2);
                }
                if (node.right != null) {
                    queue.add(node.right);
                    indexQueue.add(index * 2 + 1);
                }
            }
            maxWidth = Math.max(maxWidth, right - left + 1);
        }
        return maxWidth;
    }
}