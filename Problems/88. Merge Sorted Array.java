/*
Problem Link: https://leetcode.com/problems/merge-sorted-array/
*/

import java.util.*;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] mergedArray = new int[m + n];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                mergedArray[k++] = nums1[i++];
            } else {
                mergedArray[k++] = nums2[j++];
            }
        }

        while (i < m) {
            mergedArray[k++] = nums1[i++];
        }

        while (j < n) {
            mergedArray[k++] = nums2[j++];
        }
        int temp = 0;
        while (temp < mergedArray.length) {
            nums1[temp] = mergedArray[temp];
            temp++;
        }
    }
}