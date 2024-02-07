package ExamProductStore;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Config {
    public String CONFIG_FILE = "config.properties";


    public String getProperties(String key){

        Properties properties = new Properties();
        try (FileReader reader = new FileReader(CONFIG_FILE)){
            try {
                properties.load(reader);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }catch(IOException ioException){

            System.out.println(ioException);
        }

        return properties.getProperty(key);
    }


}


