"""
Problem Link: https://leetcode.com/problems/ipo/
"""

import heapq


class Solution:
    def findMaximizedCapital(self, k: int, w: int, profits: List[int], capital: List[int]) -> int:
        projects = sorted(zip(capital, profits), key=lambda x: x[0])
        maxHeap = []
        i = 0
        for _ in range(k):
            while i < len(projects) and projects[i][0] <= w:
                heapq.heappush(maxHeap, -projects[i][1])
                i += 1
            if maxHeap:
                w -= heapq.heappop(maxHeap)
            else:
                break
        return w
