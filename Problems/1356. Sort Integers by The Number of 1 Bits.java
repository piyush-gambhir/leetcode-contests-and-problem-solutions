/*
Problem Link: https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/
*/

import java.util.*;

class Solution {
    public int[] sortByBits(int[] arr) {
        Arrays.sort(arr);
        Integer[] newArr = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        Arrays.sort(newArr, (a,
                b) -> Integer.bitCount(a) != Integer.bitCount(b) ? Integer.bitCount(a) - Integer.bitCount(b) : a - b);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = newArr[i];
        }
        return arr;
    }
}