/*
Problem Link: https://leetcode.com/problems/maximum-69-number/
*/

import java.util.*;

class Solution {
    public int maximum69Number(int num) {
        String numString = Integer.toString(num);
        String resultString = "";
        boolean changed = false;
        for (int i = 0; i < numString.length(); i++) {
            if (numString.charAt(i) - '0' == 6 && !changed) {
                resultString += '9';
                changed = true;
                continue;
            }
            resultString += numString.charAt(i);
        }
        return Integer.parseInt(resultString);
    }
}