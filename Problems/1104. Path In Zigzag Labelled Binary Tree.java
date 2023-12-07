/*
Problem Link: https://leetcode.com/problems/path-in-zigzag-labelled-binary-tree/
*/

import java.util.*;

class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> ans = new ArrayList<>();
        int level = (int) (Math.log(label) / Math.log(2));
        while (level >= 0) {
            ans.add(label);
            int start = (int) Math.pow(2, level);
            int end = (int) Math.pow(2, level + 1) - 1;
            label = start + end - label;
            label /= 2;
            level--;
        }
        Collections.reverse(ans);
        return ans;
    }
}