"""
Problem Link: https://leetcode.com/problems/leaf-similar-trees/description/
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


class Solution:
    def leafSimilar(self, root1: Optional[TreeNode], root2: Optional[TreeNode]) -> bool:
        def getTreeLeafs(root, leafs):
            if (root == None):
                return
            if (root.left == None and root.right == None):
                leafs.append(root.val)
                return

            getTreeLeafs(root.left, leafs)
            getTreeLeafs(root.right, leafs)

        leafsRoot1 = []
        getTreeLeafs(root1, leafsRoot1)
        leafsRoot2 = []
        getTreeLeafs(root2, leafsRoot2)

        if (len(leafsRoot1) != len(leafsRoot2)):
            return False

        for i in range(len(leafsRoot1)):
            if (leafsRoot1[i] != leafsRoot2[i]):
                return False

        return True
