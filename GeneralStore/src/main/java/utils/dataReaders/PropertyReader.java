package utils.dataReaders;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Properties;

public class PropertyReader {

    // Load all .properties files from resources into a single Properties object
    public static Properties loadProperties() {
        Properties properties = new Properties();
        try {
            // Scan for all .properties files in resources
            Collection<File> propertiesFiles = FileUtils.listFiles(
                    new File("src/main/resources/test-data"),
                    new String[]{"properties"},
                    true // include subdirectories
            );

            // Load each file into the Properties object
            for (File file : propertiesFiles) {
                try (FileInputStream fis = new FileInputStream(file)) {
                    properties.load(fis);
                }
            }

        } catch (IOException e) {
            System.out.println("Error loading properties files: " + e.getMessage());
            return null;
        }
        return properties;
    }

    public static String getProperty(String key) {
        return loadProperties().getProperty(key);
    }

    public static String getPropertyValue(String key){
        Properties prop = PropertyReader.loadProperties();
        return prop.getProperty(key);
    }
}
