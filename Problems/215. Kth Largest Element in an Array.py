"""
Problem Link: https://leetcode.com/problems/kth-largest-element-in-an-array/
"""

import heapq
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        heapq.heapify(nums)

        for _ in range(len(nums)-k):
            heapq.heappop(nums)

        return nums[0]
