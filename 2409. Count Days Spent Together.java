/*
Problem Link: https://leetcode.com/problems/count-days-spent-together/
*/

class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] monthDays = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        int arriveAliceInt = Integer.parseInt(arriveAlice.replaceAll("-", ""));
        int leaveAliceInt = Integer.parseInt(leaveAlice.replaceAll("-", ""));
        int arriveBobInt = Integer.parseInt(arriveBob.replaceAll("-", ""));
        int leaveBobInt = Integer.parseInt(leaveBob.replaceAll("-", ""));

        int maxArrive = Math.max(arriveAliceInt, arriveBobInt);
        int minLeave = Math.min(leaveAliceInt, leaveBobInt);

        int overlapDays = 0;

        while (maxArrive <= minLeave) {
            int month = maxArrive / 100;
            int day = maxArrive % 100;
            overlapDays += 1;
            day += 1;
            if (day > monthDays[month]) {
                day = 1;
                month += 1;
            }
            maxArrive = month * 100 + day;
        }
        return overlapDays;
    }
}
