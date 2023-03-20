/*
Problem Link: https://leetcode.com/problems/flatten-nested-list-iterator/
*/

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

import java.util.*;

public class NestedIterator implements Iterator<Integer> {
    private Deque<NestedInteger> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
        // Initialize the stack with the nested list in reverse order
        stack = new ArrayDeque<>();
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        // Ensure there's a next element before returning it
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        // Pop the next element from the top of the stack
        NestedInteger element = stack.pop();

        // If it's an integer, return it
        if (element.isInteger()) {
            return element.getInteger();
        }

        // If it's a list, flatten it and push the elements onto the stack
        List<NestedInteger> list = element.getList();
        for (int i = list.size() - 1; i >= 0; i--) {
            stack.push(list.get(i));
        }

        // Recursively call next() to get the next integer in the flattened list
        return next();
    }

    @Override
    public boolean hasNext() {
        // Keep flattening the list until the stack is empty or an integer is found
        while (!stack.isEmpty()) {
            NestedInteger element = stack.peek();
            if (element.isInteger()) {
                return true;
            }
            List<NestedInteger> list = stack.pop().getList();
            for (int i = list.size() - 1; i >= 0; i--) {
                stack.push(list.get(i));
            }
        }
        return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */