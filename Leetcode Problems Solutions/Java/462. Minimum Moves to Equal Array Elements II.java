/*
Problem Link: https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/
*/

import java.util.*;

class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int median = nums[nums.length / 2];
        int moves = 0;
        for (int num : nums) {
            moves += Math.abs(num - median);
        }
        return moves;
    }
}