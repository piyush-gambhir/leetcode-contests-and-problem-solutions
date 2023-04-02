/*
Problem Link: https://leetcode.com/contest/biweekly-contest-100/problems/minimum-time-to-repair-cars/
*/

import java.util.*;

class Solution {

    public long repairCars(int[] ranks, int cars) {

        Arrays.sort(ranks, Collections.reverseOrder());
        for (int i = 0; i < ranks.length / 2; i++) {
            int temp = ranks[i];
            ranks[i] = ranks[ranks.length - i - 1];
            ranks[ranks.length - i - 1] = temp;
        }

        int n = ranks.length;

        int time = 0;
        for (int i = 0; i < n; i++) {
            int numCars = Math.min(cars, i + 1);
            int time_i = ranks[i] * numCars * numCars;
            time = Math.max(time, time_i);
            cars -= numCars;
            if (cars == 0)
                break;
        }

        return time;
    }
}