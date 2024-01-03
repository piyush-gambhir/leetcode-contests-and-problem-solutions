"""
Problem Link: https://leetcode.com/problems/combinations/
"""


class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        if (n == 0 or k == 0):
            return []

        result = []
        for i in range(1, n + 1):
            result.append([i])

        for i in range(1, k):
            temp = []
            for j in range(len(result)):
                for k in range(result[j][-1] + 1, n + 1):
                    temp.append(result[j] + [k])
            result = temp

        return result
