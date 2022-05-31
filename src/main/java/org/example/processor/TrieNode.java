package org.example.processor;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    private final Map<Character, TrieNode> children;
    private boolean endOfWord;

    public TrieNode() {
        children = new HashMap<>();
    }
    public Map<Character, TrieNode> getChildren() {
        return children;
    }

    public boolean isEndOfWord() {
        return endOfWord;
    }

    public void setEndOfWord(boolean endOfWord) {
        this.endOfWord = endOfWord;
    }
}
