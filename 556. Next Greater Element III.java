/*
Problem Link: https://leetcode.com/problems/next-greater-element-iii/
*/

import java.util.*;

class Solution {
    public int nextGreaterElement(int n) {
        char[] digits = Integer.toString(n).toCharArray();

        int i = digits.length - 2;
        while (i >= 0 && digits[i] >= digits[i + 1]) {
            i--;
        }

        if (i < 0) {
            return -1;
        }

        int j = digits.length - 1;
        while (j >= 0 && digits[j] <= digits[i]) {
            j--;
        }

        char temp = digits[i];
        digits[i] = digits[j];
        digits[j] = temp;

        int left = i + 1, right = digits.length - 1;
        while (left < right) {
            temp = digits[left];
            digits[left++] = digits[right];
            digits[right--] = temp;
        }

        long result = Long.parseLong(new String(digits));
        if (result > Integer.MAX_VALUE) {
            return -1;
        }
        return (int) result;
    }

}