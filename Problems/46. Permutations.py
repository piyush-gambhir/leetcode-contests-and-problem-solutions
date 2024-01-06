"""
Problem Link: https://leetcode.com/problems/permutations/
"""


class Solution:

    def permute_helper(self, nums, curr, result):
        if (len(nums) == 0):
            result.append(curr)
            return
        for i in range(len(nums)):
            current_digit = nums[i]
            remaining_digits = nums[:i] + nums[i+1:]
            self.permute_helper(remaining_digits, curr +
                                [current_digit], result)

    def permute(self, nums: List[int]) -> List[List[int]]:
        result = []
        self.permute_helper(nums, [], result)
        return result
