/*
Problem Link: https://leetcode.com/problems/snapshot-array/
*/

import java.util.*;

class SnapshotArray {
    private List<TreeMap<Integer, Integer>> array;
    private int snapId;

    public SnapshotArray(int length) {
        array = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            array.add(new TreeMap<>());
            array.get(i).put(0, 0);
        }
        snapId = 0;
    }

    public void set(int index, int val) {
        array.get(index).put(snapId, val);
    }

    public int snap() {
        return snapId++;
    }

    public int get(int index, int snapId) {
        TreeMap<Integer, Integer> history = array.get(index);
        return history.floorEntry(snapId).getValue();
    }
}
/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */