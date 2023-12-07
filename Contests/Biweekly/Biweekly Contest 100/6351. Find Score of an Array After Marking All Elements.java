/*
Problem Link: 
*/

import java.util.Arrays;

class Solution {
    private int smallestIntegerWhichIsNotMarked(int[] nums, boolean markedIndex[]) {
        int smallestIntegerWhichIsNotMarked = -1;
        for (int i = 0; i < nums.length; i++) {
            if (markedIndex[i] == false) {
                if (smallestIntegerWhichIsNotMarked == -1) {
                    smallestIntegerWhichIsNotMarked = nums[i];
                } else {
                    if (nums[i] < smallestIntegerWhichIsNotMarked) {
                        smallestIntegerWhichIsNotMarked = nums[i];
                    }
                }
            }
        }
        return smallestIntegerWhichIsNotMarked;
    }

    public long findScore(int[] nums) {
        boolean[] markedIndex = new boolean[nums.length];
        int score = 0;
        while (true) {
            int smallestIntegerWhichIsNotMarked = smallestIntegerWhichIsNotMarked(nums, markedIndex);
            if (smallestIntegerWhichIsNotMarked == -1) {
                break;
            }
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] % smallestIntegerWhichIsNotMarked == 0) {
                    markedIndex[i] = true;
                }
            }
        }
    }
}