"""
Problem Link: https://leetcode.com/problems/kth-largest-element-in-an-array/
"""

import heapq


class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        heapq = []
        for num in nums:
            heapq.heappush(heapq, num)
            if len(heapq) > k:
                heapq.heappop(heapq)
        return heapq[0]

