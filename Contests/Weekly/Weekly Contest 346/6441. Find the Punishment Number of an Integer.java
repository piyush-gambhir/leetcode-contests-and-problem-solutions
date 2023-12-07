/*
Problem Link: https://leetcode.com/contest/weekly-contest-346/problems/find-the-punishment-number-of-an-integer/
*/

import java.util.*;

class Solution {
    public int punishmentNumber(int n) {
        int punishmentNumber = 0;
        for (int i = 1; i <= n; i++) {
            int square = i * i;
            if (canSplitToSum(square, i)) {
                punishmentNumber += square;
            }
        }
        return punishmentNumber;
    }

    private boolean canSplitToSum(int num, int target) {
        String str = String.valueOf(num);
        return canSplitToSum(str, target, 0, 0);
    }

    private boolean canSplitToSum(String str, int target, int index, int sum) {
        if (index == str.length()) {
            return sum == target;
        }
        for (int i = index + 1; i <= str.length(); i++) {
            int val = Integer.parseInt(str.substring(index, i));
            if (sum + val > target) {
                break;
            }
            if (canSplitToSum(str, target, i, sum + val)) {
                return true;
            }
        }
        return false;
    }
}
