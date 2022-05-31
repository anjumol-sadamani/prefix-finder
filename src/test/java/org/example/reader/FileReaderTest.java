package org.example.reader;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileReaderTest {

    @Test
    void getPrefixWordsTest() {
        FileReader fileReader = new FileReader("test.properties");
        List<String> result = fileReader.getPrefixWords();
        assertEquals(6, result.size());
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc.properties","empty.properties","invalid.properties"})
    void getPrefixWordsOnInvalidConfigTest(String configFile) {
        FileReader fileReader = new FileReader(configFile);
        List<String> result = fileReader.getPrefixWords();
        assertEquals(0, result.size());
    }

}