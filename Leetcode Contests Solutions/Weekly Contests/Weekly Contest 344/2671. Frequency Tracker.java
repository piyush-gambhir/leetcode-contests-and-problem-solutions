/*
Problem Link: https://leetcode.com/contest/weekly-contest-344/problems/frequency-tracker/
*/

import java.util.HashMap;
import java.util.Map;

class FrequencyTracker {
    private Map<Integer, Integer> valueToFrequency;
    private Map<Integer, Integer> frequencyToCount;

    public FrequencyTracker() {
        valueToFrequency = new HashMap<>();
        frequencyToCount = new HashMap<>();
    }

    public void add(int number) {
        int currentFrequency = valueToFrequency.getOrDefault(number, 0);
        valueToFrequency.put(number, currentFrequency + 1);

        frequencyToCount.put(currentFrequency, frequencyToCount.getOrDefault(currentFrequency, 0) - 1);
        frequencyToCount.put(currentFrequency + 1, frequencyToCount.getOrDefault(currentFrequency + 1, 0) + 1);
    }

    public void deleteOne(int number) {
        if (!valueToFrequency.containsKey(number)) {
            return;
        }

        int currentFrequency = valueToFrequency.get(number);
        valueToFrequency.put(number, currentFrequency - 1);

        if (currentFrequency == 1) {
            valueToFrequency.remove(number);
        }

        frequencyToCount.put(currentFrequency, frequencyToCount.get(currentFrequency) - 1);
        frequencyToCount.put(currentFrequency - 1, frequencyToCount.getOrDefault(currentFrequency - 1, 0) + 1);
    }

    public boolean hasFrequency(int frequency) {
        return frequencyToCount.getOrDefault(frequency, 0) > 0;
    }
}

/**
 * Your FrequencyTracker object will be instantiated and called as such:
 * FrequencyTracker obj = new FrequencyTracker();
 * obj.add(number);
 * obj.deleteOne(number);
 * boolean param_3 = obj.hasFrequency(frequency);
 */
