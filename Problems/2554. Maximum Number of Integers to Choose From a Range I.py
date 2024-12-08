"""
Problem Link: https://leetcode.com/problems/maximum-number-of-integers-to-choose-from-a-range-i/
"""


class Solution:
    def maxCount(self, banned: List[int], n: int, maxSum: int) -> int:
        banned = set(banned)
        count = 0
        for i in range(1, n + 1):
            if i not in banned:
                maxSum -= i
                if maxSum < 0:
                    break
                count += 1
        return count