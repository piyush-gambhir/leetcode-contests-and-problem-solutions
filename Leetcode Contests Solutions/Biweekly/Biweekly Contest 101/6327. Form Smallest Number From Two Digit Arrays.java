import java.util.*;

class Solution {
    public int minNumber(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int number = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    return nums1[i];
                }
            }
        }
        if (nums1[0] > nums2[0]) {
            number += nums2[0] * 10;
            number += nums1[0];
        } else {
            number += nums1[0] * 10;
            number += nums2[0];
        }

        return number;
    }
}