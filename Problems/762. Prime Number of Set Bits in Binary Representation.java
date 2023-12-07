/*
Problem Link: https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/
*/

import java.util.*;

class Solution {
    private boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static int countSetBits(int num) {
        int count = 0;
        while (num > 0) {
            count += num & 1;
            num >>= 1;
        }
        return count;
    }

    public int countPrimeSetBits(int left, int right) {
        int count = 0;
        while (left <= right) {
            if (isPrime(countSetBits(left))) {
                count++;
            }
            left++;
        }
        return count;
    }
}