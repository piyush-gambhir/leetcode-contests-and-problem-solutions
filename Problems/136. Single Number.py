"""
Problem Link: https://leetcode.com/problems/single-number/
"""

class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        res = 0
        for num in nums:
            # XOR of a number with itself is 0
            # XOR of a number with 0 is the number itself
            res ^= num
        return res