/*
Problem Link: https://leetcode.com/problems/mean-of-array-after-removing-some-elements/
*/

import java.util.*;

class Solution {
    public double trimMean(int[] arr) {
        int percent = (int) (arr.length * 0.05);
        Arrays.sort(arr);

        double sum = 0;
        for (int i = percent; i < arr.length - percent; i++) {
            sum += arr[i];
        }

        return sum / (arr.length - 2 * percent);
    }
}