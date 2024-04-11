/*
Problem Link: https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/
*/

import java.util.*;

class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int[] count = new int[2];
        for (int student : students)
            count[student]++;
        for (int sandwich : sandwiches) {
            if (count[sandwich] == 0)
                break;
            count[sandwich]--;
        }
        return count[0] + count[1];
    }
}