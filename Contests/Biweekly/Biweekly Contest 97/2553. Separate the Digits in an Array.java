/*
Problem Link: https://leetcode.com/contest/biweekly-contest-97/problems/separate-the-digits-in-an-array/
*/

import java.util.*;

class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            Stack<Integer> stack = new Stack<>();
            while (num > 0) {
                stack.push(num % 10);
                num /= 10;
            }
            while (!stack.isEmpty()) {
                list.add(stack.pop());
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}