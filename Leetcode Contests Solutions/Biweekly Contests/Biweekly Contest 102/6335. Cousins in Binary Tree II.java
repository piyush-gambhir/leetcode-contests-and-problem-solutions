/*
Problem Link: https://leetcode.com/contest/biweekly-contest-102/problems/cousins-in-binary-tree-ii/
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
    public TreeNode replaceValueInTree(TreeNode root) {
        if (root == null) {
            return null;
        }

    }

    private TreeNode traverseTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        if (root.left != null && root.right != null) {
            root.val = root.left.val + root.right.val;
        } else if (root.left != null) {
            root.val = root.left.val;
        } else if (root.right != null) {
            root.val = root.right.val;
        }

        traverseTree(root.left);
        traverseTree(root.right);

        return root;
    }

    public int sumOfCousins(TreeNode root, int nodeVal) {
        if (root == null)
            return 0;

        // find the depth and parent of the target node
        int depth = getDepth(root, nodeVal, 1);
        TreeNode parent = getParent(root, nodeVal);
        if (depth == -1 || parent == null)
            return 0;

        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr.left != null && curr.left != parent) {
                    queue.offer(curr.left);
                    if (getDepth(curr.left, nodeVal, 1) == depth) {
                        sum += curr.left.val;
                    }
                }
                if (curr.right != null && curr.right != parent) {
                    queue.offer(curr.right);
                    if (getDepth(curr.right, nodeVal, 1) == depth) {
                        sum += curr.right.val;
                    }
                }
            }
        }

        return sum;
    }

    private int getDepth(TreeNode root, int nodeVal, int depth) {
        if (root == null)
            return -1;
        if (root.val == nodeVal)
            return depth;
        int leftDepth = getDepth(root.left, nodeVal, depth + 1);
        if (leftDepth != -1)
            return leftDepth;
        int rightDepth = getDepth(root.right, nodeVal, depth + 1);
        return rightDepth;
    }

    private TreeNode getParent(TreeNode root, int nodeVal) {
        if (root == null)
            return null;
        if (root.left != null && root.left.val == nodeVal)
            return root;
        if (root.right != null && root.right.val == nodeVal)
            return root;
        TreeNode leftParent = getParent(root.left, nodeVal);
        if (leftParent != null)
            return leftParent;
        TreeNode rightParent = getParent(root.right, nodeVal);
        return rightParent;
    }
}