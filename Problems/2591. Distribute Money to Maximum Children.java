/*
Problem Link: https://leetcode.com/problems/distribute-money-to-maximum-children/
*/

import java.util.*;

class Solution {
    public int distMoney(int money, int children) {
        if (children == 0) {
            return 0;
        }

        if (children > money) {
            return -1;
        }
    }
}