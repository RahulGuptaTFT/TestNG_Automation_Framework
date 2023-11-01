package project.Utils;

//import Tests.allTests;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class propertiesFile {
    private static Properties p1 = new Properties();
     private String id;
     private String pass;

    public void getProperties() {

        try {
            InputStream input = new FileInputStream("C:/Users/Rahul Gupta/IdeaProjects/Test_Automation_Framework/src/main/java/project/Utils/credentials.properties");
            p1.load(input);
            id = p1.getProperty("id");
            pass = p1.getProperty("pass");

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            e.printStackTrace();
        }
    }

    public void setProperties(String key, String value) {
        try {
            OutputStream output = new FileOutputStream("C:/Users/Rahul Gupta/IdeaProjects/Test_Automation_Framework/src/test/java/Utils/credentials.properties");
            p1.setProperty(key, value);
            p1.store(output, null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            e.printStackTrace();
        }
    }

    public String getId() {
         getProperties();
         return id;
    }
    public String getPass(){
        getProperties();
        return pass;
    }
}
