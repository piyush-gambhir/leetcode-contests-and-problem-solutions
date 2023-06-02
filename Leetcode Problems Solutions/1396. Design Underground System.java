/*
Problem Link: https://leetcode.com/problems/design-underground-system/
*/

import java.util.*;

class UndergroundSystem {

    class Pair {
        String stationName;
        int t;

        Pair(String stationName, int t) {
            this.stationName = stationName;
            this.t = t;
        }
    }

    static Map<Integer, Pair> checkInMap;
    static Map<String, List<Integer>> checkOutMap;

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        checkOutMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new Pair(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Pair p = checkInMap.get(id);
        String key = p.stationName + "-" + stationName;
        List<Integer> list = checkOutMap.getOrDefault(key, new ArrayList<>());
        list.add(t - p.t);
        checkOutMap.put(key, list);
    }

    public double getAverageTime(String startStation, String endStation) {
        String key = startStation + "-" + endStation;
        List<Integer> list = checkOutMap.get(key);
        int sum = 0;
        for (int i : list) {
            sum += i;
        }
        return (double) sum / list.size();
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */