/*
Problem Link: https://leetcode.com/problems/implement-trie-prefix-tree/
*/

import java.util.*;

class Trie {
    static class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        public TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }
    }

    static TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        int level = 0;
        int length = word.length();
        int index = 0;

        TrieNode currentNode = root;
        while (level < length) {
            index = word.charAt(level) - 'a';
            if (currentNode.children[index] == null) {
                currentNode.children[index] = new TrieNode();
            }
            currentNode = currentNode.children[index];
            level++;
        }

        currentNode.isEnd = true;
    }

    public boolean search(String word) {
        int level = 0;
        int length = word.length();
        int index = 0;

        TrieNode currentNode = root;
        while (level < length) {
            index = word.charAt(level) - 'a';
            if (currentNode.children[index] == null) {
                return false;
            }
            currentNode = currentNode.children[index];
            level++;
        }

        return currentNode.isEnd;
    }

    public boolean startsWith(String prefix) {
        int level = 0;
        int length = prefix.length();
        int index = 0;

        TrieNode currentNode = root;
        while (level < length) {
            index = prefix.charAt(level) - 'a';
            if (currentNode.children[index] == null) {
                return false;
            }
            currentNode = currentNode.children[index];
            level++;
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */