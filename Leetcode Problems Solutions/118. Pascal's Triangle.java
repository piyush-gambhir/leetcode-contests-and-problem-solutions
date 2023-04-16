/*
Problem Link: https://leetcode.com/problems/pascals-triangle/
*/

import java.util.*;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (numRows == 0) {
            return result;
        }
        List<Integer> firstRow = new ArrayList<Integer>();
        firstRow.add(1);
        result.add(firstRow);
        for (int i = 1; i < numRows; i++) {
            List<Integer> prevRow = result.get(i - 1);
            List<Integer> row = new ArrayList<Integer>();
            row.add(1);
            for (int j = 1; j < i; j++) {
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }
            row.add(1);
            result.add(row);
        }
        return result;
    }
}