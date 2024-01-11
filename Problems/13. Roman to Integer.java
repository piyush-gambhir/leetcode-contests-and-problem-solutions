/*
Problem Link: https://leetcode.com/problems/roman-to-integer/
*/

class Solution {
    public int romanToIntValue(String s) {
        int value = 0;
        if (s.equalsIgnoreCase("I"))
            value = 1;
        else if (s.equalsIgnoreCase("V"))
            value = 5;
        else if (s.equalsIgnoreCase("X"))
            value = 10;
        else if (s.equalsIgnoreCase("L"))
            value = 50;
        else if (s.equalsIgnoreCase("C"))
            value = 100;
        else if (s.equalsIgnoreCase("D"))
            value = 500;
        else if (s.equalsIgnoreCase("M"))
            value = 1000;
        return value;
    }

    public int romanToInt(String s) {
        int integer = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int s1 = romanToIntValue(String.valueOf(s.charAt(i)));
            int s2 = romanToIntValue(String.valueOf(s.charAt(i + 1)));
            if (s1 >= s2)
                integer += s1;
            else
                integer -= s1;
        }
        integer += romanToIntValue(String.valueOf(s.charAt(s.length() - 1)));
        return integer;
    }
}