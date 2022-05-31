package org.example.processor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class PrefixTrieTest {

    @Test
    void getLongestPrefixPositiveTest(){
    PrefixTrie prefixTrie = new PrefixTrie(Arrays.asList("test1","test"));
    Assertions.assertEquals("test1", prefixTrie.getLongestPrefix("test123"));
    }

    @Test
    void getLongestPrefixInvalidInputTest(){
        PrefixTrie prefixTrie = new PrefixTrie(Arrays.asList("test1","test"));
        Assertions.assertEquals("", prefixTrie.getLongestPrefix("empty"));
    }

    @Test
    void getLongestPrefixEmptyPrefixTest(){
        PrefixTrie prefixTrie = new PrefixTrie(List.of());
        Assertions.assertEquals("", prefixTrie.getLongestPrefix("test123"));
    }

    @Test
    void getLongestPrefixOnNullInputTest(){
        PrefixTrie prefixTrie = new PrefixTrie(List.of());
        Assertions.assertEquals("", prefixTrie.getLongestPrefix(null));
    }
}
