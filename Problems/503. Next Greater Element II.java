/*
Problem Link: https://leetcode.com/problems/next-greater-element-ii/
*/

import java.util.*;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] nextGreaterElement = new int[nums.length];
        Arrays.fill(nextGreaterElement, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length * 2; i++) {
            int num = nums[i % nums.length];
            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                nextGreaterElement[stack.pop()] = num;
            }
            if (i < nums.length) {
                stack.push(i);
            }
        }
        return nextGreaterElement;
    }
}