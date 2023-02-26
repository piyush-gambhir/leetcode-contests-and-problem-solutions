/*
Problem Link: https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/
*/

import java.util.*;

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] result = new int[k];
        int[] count = new int[mat.length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1)
                    count[i]++;
            }
        }
        int[] temp = new int[mat.length];
        for (int i = 0; i < mat.length; i++) {
            temp[i] = count[i];
        }
        Arrays.sort(count);
        int index = 0;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < mat.length; j++) {
                if (count[i] == temp[j]) {
                    result[index++] = j;
                    temp[j] = -1;
                    break;
                }
            }
        }
        return result;
    }
}