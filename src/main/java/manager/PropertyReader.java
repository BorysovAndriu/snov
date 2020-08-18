package manager;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyReader {
   private Properties properties;

   private PropertyReader(String file){

       properties = new Properties();

       try {
           properties.load(new FileInputStream(new File(file)));
       } catch (IOException e) {
           e.printStackTrace();
       }
   }

    public Properties getProperties() {
        return properties;
    }

    public static Map<String, String> getMap(String fileName){
       PropertyReader propertyReader = new PropertyReader(fileName);
       return new HashMap(propertyReader.getProperties());
    }
}
