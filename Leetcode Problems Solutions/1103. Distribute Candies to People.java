/*
Problem Link: https://leetcode.com/problems/distribute-candies-to-people/
*/

import java.util.*;

class Solution {
    public int[] distributeCandies(int candies, int num_people) {

        int[] sumCandies = new int[num_people];
        for (int i = 0; candies > 0; i++) {
            sumCandies[i % num_people] += Math.min(candies, i + 1);
            candies -= i + 1;
        }
        return sumCandies;
    }
}