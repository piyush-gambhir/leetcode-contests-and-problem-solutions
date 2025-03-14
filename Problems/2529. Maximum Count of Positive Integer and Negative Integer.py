from typing import List


class Solution:
    def maximumCount(self, nums: List[int]) -> int:
        def find_first_positive(nums):
            left, right = 0, len(nums)
            while left < right:
                mid = left + (right - left) // 2
                if nums[mid] > 0:
                    right = mid
                else:
                    left = mid + 1
            return left

        def find_last_negative(nums):
            left, right = 0, len(nums)
            while left < right:
                mid = left + (right - left) // 2
                if nums[mid] < 0:
                    left = mid + 1
                else:
                    right = mid
            return left

        pos = len(nums) - find_first_positive(nums)
        neg = find_last_negative(nums)

        return max(pos, neg)
