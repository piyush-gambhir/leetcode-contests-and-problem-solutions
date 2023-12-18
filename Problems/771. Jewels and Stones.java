/*
Problem Link: https://leetcode.com/problems/jewels-and-stones/
*/

import java.util.*;

class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        for (char stone : stones.toCharArray())
            if (jewels.indexOf(stone) != -1)
                count++;

        return count;
    }
}