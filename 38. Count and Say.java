/*
Problem Link: https://leetcode.com/problems/count-and-say/
*/

class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String prev = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 0; i < prev.length(); i++) {
            if (i + 1 < prev.length() && prev.charAt(i) == prev.charAt(i + 1)) {
                count++;
            } else {
                sb.append(count);
                sb.append(prev.charAt(i));
                count = 1;
            }
        }
        return sb.toString();
    }
}