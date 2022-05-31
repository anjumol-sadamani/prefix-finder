package org.example.reader;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Properties;
import java.util.logging.Logger;

import static java.util.logging.Level.SEVERE;

public class FileReader implements Reader {
    private static final Logger logger = Logger.getLogger(FileReader.class.getName());
    private final String rootPath;
    private final String appConfigPath;
    public FileReader(String configFilePath) {
        rootPath = Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("")).getPath();
        appConfigPath = rootPath + configFilePath;
    }

    public List<String> getPrefixWords() {
        Properties prop = new Properties();
        List<String> data;
        try (InputStream inputStream = new FileInputStream(appConfigPath)) {
            prop.load(inputStream);
            String path = prop.getProperty("filepath");
            if(path == null) throw new IOException("File path not set in properties");
            data = FileUtils.readLines(new File(rootPath + path), StandardCharsets.UTF_8);
        } catch (IOException e) {
            logger.log(SEVERE, e.getMessage());
            return Collections.emptyList();
        }
        return data;
    }
}
