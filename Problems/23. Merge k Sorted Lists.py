"""
Problem Link: https://leetcode.com/problems/merge-k-sorted-lists/
"""

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

import heapq


class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        heap_list = []
        for head in lists:
            while head:
                heapq.heappush(heap_list, head.val)
                head = head.next

        dummy = ListNode()
        curr = dummy
        while heap_list:
            curr.next = ListNode(heapq.heappop(heap_list))
            curr = curr.next
        return dummy.next
