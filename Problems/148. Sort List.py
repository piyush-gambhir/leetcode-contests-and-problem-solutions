"""
Problem Link: https://leetcode.com/problems/sort-list/
"""

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

import heapq


class Solution:
    def sortList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        heap_list = []
        while head:
            heap_list.append(head.val)
            head = head.next

        heapq.heapify(heap_list)
        dummy = ListNode()
        curr = dummy
        while heap_list:
            curr.next = ListNode(heapq.heappop(heap_list))
            curr = curr.next
        return dummy.next
