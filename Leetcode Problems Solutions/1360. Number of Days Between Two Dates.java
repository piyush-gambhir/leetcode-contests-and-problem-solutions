/*
Problem Link: https://leetcode.com/problems/number-of-days-between-two-dates/
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

    public int daysBetweenDates(String date1, String date2) {
        String[] date1Arr = date1.split("-");
        String[] date2Arr = date2.split("-");

        int year1 = Integer.parseInt(date1Arr[0]);
        int month1 = Integer.parseInt(date1Arr[1]);
        int day1 = Integer.parseInt(date1Arr[2]);

        int year2 = Integer.parseInt(date2Arr[0]);
        int month2 = Integer.parseInt(date2Arr[1]);
        int day2 = Integer.parseInt(date2Arr[2]);

        int[] daysOfNormalYear = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int[] daysOfLeapYear = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        
    }
}