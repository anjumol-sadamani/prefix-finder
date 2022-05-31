package org.example.processor;

class Trie {
    protected TrieNode root;
    Trie() {
        root = new TrieNode();
    }
    public void insertWord(String word) {
        TrieNode current = root;
        for (char l : word.toCharArray()) {
            current = current.getChildren().computeIfAbsent(l, c -> new TrieNode());
        }
        current.setEndOfWord(true);
    }

    public boolean findWord(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.getChildren().get(ch);
            if (node == null) {
                return false;
            }
            current = node;
        }
        return current.isEndOfWord();
    }

}
