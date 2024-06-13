/*
Problem Link: https://leetcode.com/problems/minimum-number-of-moves-to-seat-everyone/
*/

/*
Solution: NlogN time complexity

import java.util.*;

class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int n = seats.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.abs(seats[i] - students[i]);
        }
        return ans;
    }
}

 */

class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        
    }
}
