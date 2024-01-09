"""
Problem Link: https://leetcode.com/problems/symmetric-tree/
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if (root == None):
            return True
        if (root.left == None and root.right == None):
            return True
        if (root.left == None or root.right == None):
            return False
        if (root.left.val != root.right.val):
            return False

        temp = root.left.right if root.left.right != None else None
        root.left.right = root.right.right if root.right.right != None else None
        root.right.right = temp
        return self.isSymmetric(root.left) and self.isSymmetric(root.right)
