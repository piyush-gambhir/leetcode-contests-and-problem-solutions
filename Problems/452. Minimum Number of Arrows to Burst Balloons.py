"""
Problem Link: https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
"""


class Solution(object):
    def findMinArrowShots(self, points):
        """
        :type points: List[List[int]]
        :rtype: int
        """
        points.sort(key=lambda x: x[1])
        arrows = 0
        end = points[0][1]

        for i in range(1, len(points)):
            if points[i][0] > end:
                arrows += 1
                end = points[i][1]

        return arrows + 1
