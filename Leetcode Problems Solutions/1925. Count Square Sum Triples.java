/*
Problem Link: https://leetcode.com/problems/count-square-sum-triples/
*/

import java.util.*;

class Solution {
    public int countTriples(int n) {
        int count = 0;

        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                int cSquare = a * a + b * b;
                int c = (int) Math.sqrt(cSquare);
                if (c <= n && c * c == cSquare) {
                    count++;
                }
            }
        }

        return count;
    }
}
