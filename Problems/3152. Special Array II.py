"""
Problem Link: https://leetcode.com/problems/special-array-ii/
"""


# class Solution:
#     def isArraySpecial(self, nums: List[int], queries: List[List[int]]) -> List[bool]:
#         def isSubarraySpecial(nums, left, right):
#             n = right - left + 1

#             if n == 1:
#                 return True

#             for i in range(left, right):
#                 if nums[i] % 2 == nums[i + 1] % 2:
#                     return False

#             return True

#         res = []
#         for query in queries:
#             left, right = query
#             res.append(isSubarraySpecial(nums, left, right))


#         return res

class Solution:
    def isArraySpecial(self, nums: List[int], queries: List[List[int]]) -> List[bool]:
        n = len(nums)
        prefix = [0] * n

        for i in range(1, n):
            prefix[i] = prefix[i - 1]
            if (nums[i - 1] % 2 == 0 and nums[i] % 2 == 0) or (
                nums[i - 1] % 2 != 0 and nums[i] % 2 != 0
            ):
                prefix[i] += 1

        result = []

        for left, right in queries:
            special_count = prefix[right] - (prefix[left] if left > 0 else 0)
            result.append(special_count == 0)

        return result
