"""
Problem Link: https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
"""

import heapq
from typing import List


class Solution:
    def kSmallestPairs(self, nums1: List[int], nums2: List[int], k: int) -> List[List[int]]:
        if not nums1 or not nums2:
            return []

        heap = []
        result = []

        for i in range(min(k, len(nums1))):
            heapq.heappush(heap, (nums1[i] + nums2[0], nums1[i], nums2[0], 0))

        while heap and k > 0:
            _, num1, num2, idx = heapq.heappop(heap)
            result.append([num1, num2])
            if idx + 1 < len(nums2):
                heapq.heappush(
                    heap, (num1 + nums2[idx + 1], num1, nums2[idx + 1], idx + 1))
            k -= 1

        return result
