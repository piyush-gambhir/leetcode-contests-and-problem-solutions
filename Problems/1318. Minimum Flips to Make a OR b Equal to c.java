/*
Problem Link: https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c/
*/

import java.util.*;

class Solution {

    public int minFlips(int a, int b, int c) {
        int count = 0;
        while (a > 0 || b > 0 || c > 0) {
            int bitA = a & 1;
            int bitB = b & 1;
            int bitC = c & 1;
            if (bitC == 0) {
                if (bitA == 1 && bitB == 1) {
                    count += 2;
                } else if (bitA == 1 || bitB == 1) {
                    count += 1;
                }
            } else {
                if (bitA == 0 && bitB == 0) {
                    count += 1;
                }
            }
            a = a >> 1;
            b = b >> 1;
            c = c >> 1;
        }
        return count;
    }
}