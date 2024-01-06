"""
Problem Link: https://leetcode.com/problems/combination-sum/
"""


class Solution:

    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        def combinationSum(candidates, target, index, current, result):
            if (target == 0):
                result.append(list(current))
                return
            if (target < 0):
                return
            if (index >= len(candidates)):
                return
            current.append(candidates[index])
            combinationSum(candidates, target -
                           candidates[index], index, current, result)
            current.pop()
            combinationSum(candidates, target, index + 1, current, result)
        result = []
        combinationSum(candidates, target, 0, [], result)
        return result
