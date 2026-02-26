package com.in.utilites;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadPropertiesFile {

    private static Properties props;

    public static Properties loadFile() {

        if (props == null) {
            try (InputStream is = new FileInputStream("src/test/java/com/in/properties/properties.properties")) {

                props = new Properties();
                props.load(is);

            } catch (IOException e) {
                throw new RuntimeException("Failed to load properties file", e);
            }
        }

        return props;
    }
}