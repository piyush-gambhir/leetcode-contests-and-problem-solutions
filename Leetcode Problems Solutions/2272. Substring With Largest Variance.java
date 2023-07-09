/*
Problem Link: https://binarysearch.com/problems/Substring-With-Largest-Variance
*/

import java.util.*;

class Solution {
    public int largestVariance(String s) {
        int[] lastInd = new int[26];
        Arrays.fill(lastInd, -1);
        for (int i = s.length() - 1; i >= 0; i--)
            if (lastInd[s.charAt(i) - 'a'] == -1)
                lastInd[s.charAt(i) - 'a'] = i;
        int res = 0;
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if (i == j || lastInd[i] == -1 || lastInd[j] == -1)
                    continue;
                int majorC = 0, minorC = 0;
                char major = (char) ('a' + i), minor = (char) ('a' + j);
                for (int k = 0; k < s.length(); k++) {
                    char cur = s.charAt(k);
                    if (cur != major && cur != minor)
                        continue;
                    if (cur == major)
                        majorC++;
                    if (cur == minor)
                        minorC++;
                    if (majorC < minorC && k != lastInd[minor - 'a']) {
                        majorC = 0;
                        minorC = 0;
                    }
                    if (minorC > 0)
                        res = Math.max(res, majorC - minorC);
                }
            }
        }
        return res;
    }
}
