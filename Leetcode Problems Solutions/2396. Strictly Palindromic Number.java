/*
Problem Link: https://leetcode.com/problems/strictly-palindromic-numbers/
*/

class Solution {

    private boolean isPalindromic(String n) {
        int i = 0;
        int j = n.length() - 1;
        while (i < j) {
            if (n.charAt(i) != n.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private int converToBase(int n, int base) {
        int result = 0;
        int power = 1;
        while (n > 0) {
            int digit = n % base;
            result += digit * power;
            power *= 10;
            n /= base;
        }
        return result;
    }

    public boolean isStrictlyPalindromic(int n) {
        for (int base = 2; base <= n; base++) {
            int converted = converToBase(n, base);
            if (!isPalindromic(String.valueOf(converted))) {
                return false;
            }
        }
        return true;
    }
}