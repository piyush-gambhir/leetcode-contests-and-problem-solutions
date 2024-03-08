/*
Problem Link: https://leetcode.com/problems/maximum-odd-binary-number/
*/

import java.util.*;

class Solution {
    public String maximumOddBinaryNumber(String s) {
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                cnt += 1;
            }
        }

        if (cnt == 0)
            return "";

        for (int i = 1; i < cnt; i++) {
            sb.append(1);
        }
        for (int i = cnt; i < s.length(); i++) {
            sb.append(0);
        }
        sb.append(1);

        return sb.toString();
    }
}