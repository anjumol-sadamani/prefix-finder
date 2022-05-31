package org.example.processor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TrieNodeTest {

    TrieNode trieNode;

    @BeforeEach
    void init(){
        trieNode = new TrieNode();
    }

    @Test
    void getChildrenTest(){
        Assertions.assertTrue(trieNode.getChildren().isEmpty());
    }

    @Test
    void endOfWordFalseTest() {
        Assertions.assertFalse(trieNode.isEndOfWord());
    }

    @Test
    void endOfWordTrueTest() {
        trieNode.setEndOfWord(true);
        Assertions.assertTrue(trieNode.isEndOfWord());
    }
}
