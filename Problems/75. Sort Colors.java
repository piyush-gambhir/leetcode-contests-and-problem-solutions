/*
Problem Link: https://leetcode.com/problems/sort-colors/
*/

import java.util.*;

class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;

        int countRed = 0;
        int countWhite = 0;
        int countBlue = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                countRed++;
            } else if (nums[i] == 1) {
                countWhite++;
            } else {
                countBlue++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (countRed > 0) {
                nums[i] = 0;
                countRed--;
            } else if (countWhite > 0) {
                nums[i] = 1;
                countWhite--;
            } else {
                nums[i] = 2;
                countBlue--;
            }
        }
    }
}