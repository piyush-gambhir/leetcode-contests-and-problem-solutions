/*
Problem Link: https://leetcode.com/problems/design-browser-history/
*/

import java.util.*;

class BrowserHistory {
    static class DoublyLinkedListNode<T> {
        private T data;
        private DoublyLinkedListNode<T> prev;
        private DoublyLinkedListNode<T> next;

        public DoublyLinkedListNode(T data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }

        public T getData() {
            return data;
        }

        public DoublyLinkedListNode<T> getPrev() {
            return prev;
        }

        public void setPrev(DoublyLinkedListNode<T> prev) {
            this.prev = prev;
        }

        public DoublyLinkedListNode<T> getNext() {
            return next;
        }

        public void setNext(DoublyLinkedListNode<T> next) {
            this.next = next;
        }
    }

    static DoublyLinkedListNode<String> homePageNode;
    static DoublyLinkedListNode<String> currentPageNode;

    public BrowserHistory(String homepage) {
        DoublyLinkedListNode<String> homepageNode = new DoublyLinkedListNode<>(homepage);
        homePageNode = homepageNode;
        currentPageNode = homepageNode;
    }

    public void visit(String url) {
        DoublyLinkedListNode<String> newNode = new DoublyLinkedListNode<>(url);
        currentPageNode.setNext(newNode);
        newNode.setPrev(currentPageNode);
        currentPageNode = newNode;
    }

    public String back(int steps) {
        while (steps-- > 0 && currentPageNode.getPrev() != null) {
            currentPageNode = currentPageNode.getPrev();
        }
        return currentPageNode.getData();
    }

    public String forward(int steps) {
        while (steps-- > 0 && currentPageNode.getNext() != null) {
            currentPageNode = currentPageNode.getNext();
        }
        return currentPageNode.getData();
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */