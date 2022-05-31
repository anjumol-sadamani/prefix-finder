package org.example;


import org.example.processor.PrefixTrie;
import org.example.reader.FileReader;
import org.example.reader.Reader;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PrefixFinderApp {
    private static final Logger logger = Logger.getLogger(PrefixFinderApp.class.getName());
    private final PrefixTrie prefixTrie;

    public PrefixFinderApp(Reader reader) throws InstantiationException {
        List<String> words = reader.getPrefixWords();
        if (words == null || words.isEmpty()) {
            throw new InstantiationException("Unable to get words");
        }
        prefixTrie = new PrefixTrie(words);
    }

    public void begin(InputStream source, PrintStream printStream) {
        Scanner input = new Scanner(source);
        String word;
        while (true) {
            printStream.print("Enter a word(press \\q to exit): ");
            word = input.next();
            if ("\\q".equals(word)) {
                break;
            }
            String prefix = prefixTrie.getLongestPrefix(word);
            if (prefix != null && !prefix.isBlank()) {
                printStream.println("Longest matching prefix: " + prefix);
            } else {
                printStream.println("No matching prefix found !!");
            }
        }
    }

    public static void main(String[] args) {
        Reader reader = new FileReader("config.properties");
        PrefixFinderApp prefixFinderApp;
        try {
            prefixFinderApp = new PrefixFinderApp(reader);
        } catch (InstantiationException e) {
            logger.log(Level.SEVERE, e.getMessage());
            return;
        }
        prefixFinderApp.begin(System.in, System.out);
    }
}

