/*
Problem Link: https://leetcode.com/problems/count-tested-devices-after-test-operations/description/
*/

import java.util.*;

class Solution {
    public int countTestedDevices(int[] batteryPercentages) {
        int tested = 0;
        for (int i = 0; i < batteryPercentages.length; i++) {
            if (batteryPercentages[i] > 0) {
                tested++;
                for (int j = i + 1; j < batteryPercentages.length; j++) {
                    batteryPercentages[j] = Math.max(batteryPercentages[j] - 1, 0);
                }
            }
        }
        return tested;
    }
}