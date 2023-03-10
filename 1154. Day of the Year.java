/*
Problem Link: https://leetcode.com/problems/day-of-the-year/
*/

class Solution {
    private boolean isLeapYear(int year) {
        if (year % 4 == 0 && year % 100 != 0) {
            return true;
        } else if (year % 400 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int dayOfYear(String date) {
        int[] daysOfNormalYear = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int[] daysOfLeapYear = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        String[] dateArr = date.split("-");

        int year = Integer.parseInt(dateArr[0]);
        int month = Integer.parseInt(dateArr[1]);
        int day = Integer.parseInt(dateArr[2]);

        boolean isLeapYear = isLeapYear(year);

        int dayOfTheYear = 0;

        if (isLeapYear) {
            for (int i = 0; i < month - 1; i++) {
                dayOfTheYear += daysOfLeapYear[i];
            }
        } else {
            for (int i = 0; i < month - 1; i++) {
                dayOfTheYear += daysOfNormalYear[i];
            }
        }

        dayOfTheYear += day;

        return dayOfTheYear;
    }
}