/* 
Problem Link: https://leetcode.com/problems/binary-search-tree-iterator/
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

class BSTIterator {
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        pushLeftSubtree(root);
    }

    public int next() {
        TreeNode result = stack.pop();
        pushLeftSubtree(result.right);
        return result.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public void pushLeftSubtree(TreeNode root) {
        if (root == null) {
            return;
        }

        stack.push(root);
        pushLeftSubtree(root.left);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */