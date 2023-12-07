/*
Problem Link: https://leetcode.com/problems/buddy-strings/
*/

class Solution {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length())
            return false;
        if (s.equals(goal)) {
            HashSet<Character> set = new HashSet<>();
            for (char c : s.toCharArray())
                set.add(c);
            return set.size() < s.length();
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i))
                list.add(i);
        }
        if (list.size() == 2) {
            int i = list.get(0);
            int j = list.get(1);
            return s.charAt(i) == goal.charAt(j) && s.charAt(j) == goal.charAt(i);
        }
        return false;
    }
}