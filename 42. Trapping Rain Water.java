/*
Problem Statement: https://leetcode.com/problems/trapping-rain-water/
*/

class Solution {
    public int trap(int[] height) {

        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        for (int i = 1; i < n; i++)
            leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);

        for (int i = n - 2; i >= 0; i--)
            rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);

        int water = 0;
        for (int i = 0; i < n; i++) {
            int level = Math.min(leftMax[i], rightMax[i]);
            if (level > height[i])
                water += level - height[i];
        }

        return water;
    }
}