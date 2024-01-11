"""
Problem Link: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
"""


class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if (len(needle) > len(haystack)):
            return -1

        index = haystack.find(needle)
        return index
