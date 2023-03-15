/*
Problem Link: https://leetcode.com/problems/filter-restaurants-by-vegan-friendly-price-and-distance/
*/

import java.util.*;

class Solution {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < restaurants.length; i++) {
            if (restaurants[i][2] >= veganFriendly && restaurants[i][3] <= maxPrice
                    && restaurants[i][4] <= maxDistance) {
                result.add(restaurants[i][0]);
            }
        }

        Collections.sort(result, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                for (int i = 0; i < restaurants.length; i++) {
                    if (restaurants[i][0] == o1) {
                        for (int j = 0; j < restaurants.length; j++) {
                            if (restaurants[j][0] == o2) {
                                if (restaurants[i][1] == restaurants[j][1]) {
                                    return restaurants[j][0] - restaurants[i][0];
                                } else {
                                    return restaurants[j][1] - restaurants[i][1];
                                }
                            }
                        }
                    }
                }
                return 0;
            }
        });

        return result;

    }
}