/*
Problem Link: https://leetcode.com/problems/convert-the-temperature/
*/

class Solution {
    public double[] convertTemperature(double celsius) {
        double fahrenheit = (celsius * 9 / 5) + 32;
        double kelvin = celsius + 273.15;
        double[] ans = { kelvin, fahrenheit };
        return ans;
    }
}