package org.example.processor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TrieTest {

    @Test
    void testInsert() {
        Trie trie = new Trie();
        trie.insertWord("test");
        assertTrue(trie.findWord("test"));
        assertFalse(trie.findWord("tes"));
        assertFalse(trie.findWord("tests"));
        assertFalse(trie.findWord("q"));
    }
}
