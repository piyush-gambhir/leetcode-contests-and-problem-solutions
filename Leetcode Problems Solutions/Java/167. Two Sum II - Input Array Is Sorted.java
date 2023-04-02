/*
Problem Link: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
*/

class Solution {
    private int binarySearch(int[] numbers, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (numbers[mid] == target) {
                return mid;
            } else if (numbers[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public int[] twoSum(int[] numbers, int target) {
        for (int i = 1; i <= numbers.length; i++) {
            int index = binarySearch(numbers, i, numbers.length - 1, target - numbers[i - 1]);
            if (index != -1) {
                return new int[] { i, index + 1 };
            }
        }
        return new int[] { -1, -1 };
    }
}