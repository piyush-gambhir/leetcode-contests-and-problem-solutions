"""
Problem Link: https://leetcode.com/problems/median-of-two-sorted-arrays/
"""


class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        merged = []
        i = j = 0
        while (i < len(nums1) and j < len(nums2)):
            if nums1[i] < nums2[j]:
                merged.append(nums1[i])
                i += 1
            else:
                merged.append(nums2[j])
                j += 1

        while (i < len(nums1)):
            merged.append(nums1[i])
            i += 1

        while (j < len(nums2)):
            merged.append(nums2[j])
            j += 1

        if len(merged) % 2 == 0:
            return (merged[len(merged)//2] + merged[len(merged)//2 - 1])/2

        return merged[len(merged)//2]
