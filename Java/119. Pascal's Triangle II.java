/*
 * Problem Link: https://leetcode.com/problems/pascals-triangle-ii/
 */

import java.util.*;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();

        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> pascalTriangleRow = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    pascalTriangleRow.add(1);
                } else {
                    pascalTriangleRow.add(pascalTriangle.get(i - 1).get(j - 1) + pascalTriangle.get(i - 1).get(j));
                }
            }
            pascalTriangle.add(pascalTriangleRow);
        }
        return pascalTriangle.get(rowIndex);
    }
}