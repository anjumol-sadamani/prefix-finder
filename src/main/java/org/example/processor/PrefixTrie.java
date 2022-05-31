package org.example.processor;

import java.util.List;

public class PrefixTrie extends Trie {

    public PrefixTrie(List<String> words) {
        super();
        words.forEach(super::insertWord);
    }
    public String getLongestPrefix(String word) {
        if(word == null || word.isBlank()){
            return "";
        }
        TrieNode current = root;
        StringBuilder longestPrefixBuilder = new StringBuilder();
        int longestPrefixBuilderLength = 0;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.getChildren().get(ch);
            if (node == null) {
                break;
            }
            longestPrefixBuilder.append(ch);
            if(node.isEndOfWord()){
                longestPrefixBuilderLength = i + 1;
            }
            current = node;
        }
        return longestPrefixBuilder.substring(0, longestPrefixBuilderLength);
    }
}
