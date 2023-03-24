/*
Problem Link: https://leetcode.com/problems/di-string-match/
*/

import java.util.*;

class Solution {
    public int[] diStringMatch(String s) {
        int n = s.length();
        int[] permutation = new int[n + 1];

        int I = 0;
        int D = s.length();

        for (int i = 0; i < n + 1; i++) {
            if (i < n && s.charAt(i) == 'I') {
                permutation[i] = I++;
            } else {
                permutation[i] = D--;
            }
        }

        return permutation;
    }
}