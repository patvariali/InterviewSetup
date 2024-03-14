package utilities;


import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Slf4j
public class ConfigurationReader {
    private static Properties properties = new Properties();

    static {
        try{
            FileInputStream file = new FileInputStream("src/configuration.properties");
            properties.load(file);
            file.close();
        }catch (IOException e){
            log.error("Properties file not found");
        }
    }

    public static String getProperty(String keyWord) {
        return properties.getProperty(keyWord);
    }

}
