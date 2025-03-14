from typing import List


class Solution:
    def maximumCandies(self, candies: List[int], k: int) -> int:
        left, right = 1, max(candies)

        while left <= right:
            mid = left + (right - left) // 2
            total = 0
            for pile in candies:
                total += pile // mid

            if total >= k:
                left = mid + 1
            else:
                right = mid - 1
        return right
