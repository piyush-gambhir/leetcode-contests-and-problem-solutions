/*
Problem Link: https://leetcode.com/problems/design-skiplist/
*/

import java.util.*;

class Skiplist {
    LinkedList<Integer> list;

    public Skiplist() {
        list = new LinkedList<>();
    }

    public boolean search(int target) {
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) == target) {
                return true;
            } else if (list.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public void add(int num) {
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) == num) {
                list.add(mid, num);
                return;
            } else if (list.get(mid) < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        list.add(left, num);
    }

    public boolean erase(int num) {
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) == num) {
                list.remove(mid);
                return true;
            } else if (list.get(mid) < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}

/**
 * Your Skiplist object will be instantiated and called as such:
 * Skiplist obj = new Skiplist();
 * boolean param_1 = obj.search(target);
 * obj.add(num);
 * boolean param_3 = obj.erase(num);
 */