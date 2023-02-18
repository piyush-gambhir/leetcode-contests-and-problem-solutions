/*
Problem Link: https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/
*/

class Solution {
    public double average(int[] salary) {
        int maxSalary = Integer.MIN_VALUE;
        int minSalary = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < salary.length; i++) {
            sum += salary[i];
            if (salary[i] < minSalary) {
                minSalary = salary[i];
            }
            if (salary[i] > maxSalary) {
                maxSalary = salary[i];
            }
        }
        sum -= maxSalary;
        sum -= minSalary;
        double averageSalary = sum / (double) (salary.length - 2);
        return (averageSalary);
    }
}