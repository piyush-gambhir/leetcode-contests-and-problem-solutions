"""
Problem Link: https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/description
"""

"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""


class Solution:
    def connect(self, root: 'Node') -> 'Node':
        if (root == None):
            return

        queue = [root]

        while (queue):
            prev = None
            size = len(queue)
            while (size > 0):
                current = queue.pop(0)
                if (prev != None):
                    prev.next = current
                prev = current
                if (current.left != None):
                    queue.append(current.left)
                if (current.right != None):
                    queue.append(current.right)
                size -= 1
        return root
