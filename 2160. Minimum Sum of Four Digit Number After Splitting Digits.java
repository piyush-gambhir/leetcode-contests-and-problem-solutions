/*
 * Problem Link:
 * https://leetcode.com/problems/minimum-sum-of-four-digit-numbers-after-splitting-digits/
 */

import java.util.*;

class Solution {
    public int minimumSum(int num) {
        int sum = 0;
        int[] arr = new int[4];
        int i = 0;
        while (num > 0) {
            arr[i] = num % 10;
            num /= 10;
            i++;
        }

        Arrays.sort(arr);

        sum += arr[0] * 10 + arr[2];
        sum += arr[1] * 10 + arr[3];

        return sum;
    }
}
