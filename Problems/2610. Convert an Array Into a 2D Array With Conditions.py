"""
Problem Link: https://leetcode.com/problems/convert-an-array-into-a-2d-array-with-conditions/description
"""

from collections import defaultdict


class Solution(object):
    def findMatrix(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """

        freq = [0] * (len(nums) + 1)
        ans = []

        for c in nums:
            if freq[c] >= len(ans):
                ans.append([])
            ans[freq[c]].append(c)
            freq[c] += 1

        return ans
