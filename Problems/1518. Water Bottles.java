/*
Problem Link: https://leetcode.com/problems/water-bottles/
*/

import java.util.*;

 class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int total = numBottles;
        int empty = numBottles;
        while(empty >= numExchange){
            int newBottles = empty / numExchange;
            total += newBottles;
            empty = newBottles + (empty % numExchange);
        }
        return total;
    }
}