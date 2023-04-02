/*
Problem Link: https://leetcode.com/contest/biweekly-contest-100/problems/distribute-money-to-maximum-children/
*/

class Solution {
    public int distMoney(int money, int children) {

        if (children == 0) {
            return 0;
        }

        if (money == 0 || money < children) {
            return -1;
        }

        int[] childernArray = new int[children];

        for (int i = 0; i < children; i++) {
            childernArray[i] = 1;
        }

        money = money - children;

        int maxStudentsGettingEightDollars = money / 7;
        int remainingMoney = money % 7;

        if (maxStudentsGettingEightDollars == children) {
            maxStudentsGettingEightDollars = children;
            return maxStudentsGettingEightDollars;
        }

        if (maxStudentsGettingEightDollars > children) {
            maxStudentsGettingEightDollars = children - 1;
            return maxStudentsGettingEightDollars;
        }

        if (maxStudentsGettingEightDollars < children) {
            if (remainingMoney != 0) {
                return maxStudentsGettingEightDollars - 2;
            }
        }
        return -1;
    }
}