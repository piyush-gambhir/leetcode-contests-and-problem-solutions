"""
Problem Link: https://leetcode.com/problems/extra-characters-in-a-string/
"""


class Solution:
    def minExtraChar(self, s: str, dictionary: List[str]) -> int:
        n = len(s)

        dp = 