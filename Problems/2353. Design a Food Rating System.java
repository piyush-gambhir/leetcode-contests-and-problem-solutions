/*
Problem Link: https://leetcode.com/problems/design-a-food-rating-system  
*/

import java.util.*;

class FoodRatings {

    String[] foods;
    String[] cuisines;
    int[] ratings;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        this.foods = foods;
        this.cuisines = cuisines;
        this.ratings = ratings;
    }

    public void changeRating(String food, int newRating) {
        for (int i = 0; i < foods.length; i++) {
            if (foods[i].equals(food)) {
                ratings[i] = newRating;
                break;
            }
        }
    }

    public String highestRated(String cuisine) {
        int max = Integer.MIN_VALUE;
        int highestRatedFood = -1;
        for (int i = 0; i < foods.length; i++) {
            if (cuisines[i].equals(cuisine)) {
                if (ratings[i] > max) {
                    max = ratings[i];
                    highestRatedFood = i;
                } else if (ratings[i] == max && foods[i].compareTo(foods[highestRatedFood]) < 0) {
                    highestRatedFood = i;
                }
            }
        }
        return foods[highestRatedFood];
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food, newRating);
 * String param_2 = obj.highestRated(cuisine);
 */
