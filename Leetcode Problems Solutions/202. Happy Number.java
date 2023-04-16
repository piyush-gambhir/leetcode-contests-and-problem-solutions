/*
Problem Link: https://leetcode.com/problems/happy-number/
*/

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            int squaredDigitsSum = 0;
            while (n > 0) {
                int digit = n % 10;
                squaredDigitsSum += (digit * digit);
                n /= 10;
            }
            if (set.contains(squaredDigitsSum)) {
                return false;
            }
            set.add(squaredDigitsSum);
            n = squaredDigitsSum;
        }
        return true;
    }
}