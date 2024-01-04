"""
Problem Link: https://leetcode.com/problems/permutations/
"""


class Solution:

    def permute_helper(self, nums, curr, result):
        if len(nums) == 0:
            result.append(curr)
            return

        for i in range(len(nums)):
            self.permute_helper(nums[:i] + nums[i+1:],
                                curr + [nums[i]], result)

    def permute(self, nums: List[int]) -> List[List[int]]:
        result = []
        self.permute_helper(nums, [], result)
        return result
    