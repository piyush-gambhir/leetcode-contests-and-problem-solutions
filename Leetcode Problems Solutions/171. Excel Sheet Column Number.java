/*
Problem Link: https://leetcode.com/problems/excel-sheet-column-number/
*/

class Solution {
    public int titleToNumber(String columnTitle) {
        int columnNumber = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            columnNumber += (columnTitle.charAt(i) - 'A' + 1) * Math.pow(26, columnTitle.length() - i - 1);
        }
        return columnNumber;
    }
}