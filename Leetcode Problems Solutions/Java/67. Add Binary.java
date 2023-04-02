/*
Problem Link: https://leetcode.com/problems/add-binary/
*/

class Solution {
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        String res = "";
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }
            res += (sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) {
            res = carry + res;
        }
        return res;
    }
}