/*
Problem Link: https://leetcode.com/problems/double-modular-exponentiation
*/

import java.util.*;

class Solution {

    private boolean isGoodIndex(int[] variables, int target) {
        int a = variables[0];
        int b = variables[1];
        int c = variables[2];
        int m = variables[3];

        int baseValue = 1;
        for (int i = 0; i < b; i++) {
            baseValue = (baseValue * a) % 10;
        }
        int formulaValue = 1;
        for (int i = 0; i < c; i++) {
            formulaValue = (formulaValue * baseValue) % m;
        }
        return formulaValue == target;
    }

    public List<Integer> getGoodIndices(int[][] variables, int target) {
        List<Integer> goodIndices = new ArrayList<>();
        for (int i = 0; i < variables.length; i++) {
            if (isGoodIndex(variables[i], target)) {
                goodIndices.add(i);
            }
        }
        return goodIndices;
    }
}