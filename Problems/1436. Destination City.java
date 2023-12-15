/*
Problem Links: https://leetcode.com/problems/destination-city/
*/

import java.util.*;

class Solution {
    public String destCity(List<List<String>> paths) {
        Set<String> sourceCities = new HashSet<>();
        for (List<String> path : paths) {
            sourceCities.add(path.get(0));
        }
        for (List<String> path : paths) {
            if (!sourceCities.contains(path.get(1))) {
                return path.get(1);
            }
        }

        return "";
    }
}