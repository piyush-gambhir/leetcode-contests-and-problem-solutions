/*
Problem Link: https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        }

        int rootVal = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(rootVal);

        int rootIndex = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                rootIndex = i;
                break;  
            }
        }

        int[] inLeft = Arrays.copyOfRange(inorder, 0, rootIndex);
        int[] inRight = Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length);

        int[] postLeft = Arrays.copyOfRange(postorder, 0, rootIndex);
        int[] postRight = Arrays.copyOfRange(postorder, rootIndex, postorder.length - 1);

        root.left = buildTree(inLeft, postLeft);
        root.right = buildTree(inRight, postRight);

        return root;
    }
}