package org.example;

import org.example.reader.FileReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PrefixFinderAppTest {


    @Test
    void prefixFinderAppTest(){
        Assertions.assertThrows(InstantiationException.class,
                () -> new PrefixFinderApp(new FileReader("empty.properties")));
    }

    @Test
    void beginTest() throws InstantiationException {
        PrefixFinderApp prefixFinderApp = new PrefixFinderApp(new FileReader("test.properties"));
        String inputWord = "1auIqUsss\n\\q\n";
        InputStream is = new ByteArrayInputStream(inputWord.getBytes());

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);

        String expected = "Enter a word(press \\q to exit): Longest matching prefix: 1auIqU\n" +
                "Enter a word(press \\q to exit): ";

        prefixFinderApp.begin(is, ps);
        String output = os.toString(StandardCharsets.UTF_8);

        assertEquals(expected, output);
    }

    @Test
    void beginNoMatchTest() throws InstantiationException {
        PrefixFinderApp prefixFinderApp = new PrefixFinderApp(new FileReader("test.properties"));
        String inputWord = "uIqUsss\n\\q\n";
        InputStream is = new ByteArrayInputStream(inputWord.getBytes());

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);

        String expected = "Enter a word(press \\q to exit): No matching prefix found !!\n" +
                "Enter a word(press \\q to exit): ";

        prefixFinderApp.begin(is, ps);
        String output = os.toString(StandardCharsets.UTF_8);

        assertEquals(expected, output);
    }



}
