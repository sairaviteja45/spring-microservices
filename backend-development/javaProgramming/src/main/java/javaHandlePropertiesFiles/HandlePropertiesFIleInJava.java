package javaHandlePropertiesFiles;

import java.io.*;
import java.util.*;

public class HandlePropertiesFIleInJava {

    static File file = new File("DataBaseConfiguration.properties");
    ;

    /**
     * 1.Creating new Properties File
     */
    public static void creatingNewPropertiesFile() throws Throwable {
        if (!file.exists()) {
            file.createNewFile();
            System.err.println("Properties File Created SuccessFully With Name: " + file.getName());
        } else {
            System.err.println("File Already Created With Name: " + file.getName());
        }
    }

    /**
     * 2.Delete Existing File
     */
    public static void deleteExistingFile() {
        if (file.exists()) {
            file.delete();
            System.err.println(file.getName() + " File Deleted SuccessFully");
        } else {
            System.err.println(file.getName() + " File Does Not Exist");
        }
    }

    /**
     * 3.Add Properties to File
     */
    public static void addPropertiesToFile() throws Throwable {
        Properties properties = new Properties();
        properties.setProperty("url", "jdbc:mysql//localhost:3306/dev");
        properties.setProperty("userName", "root");
        properties.setProperty("password", "Ij14NiK2j");

        FileOutputStream fileOutputStream = new FileOutputStream(file);
        properties.store(fileOutputStream, "File Properties");

        System.err.println("File Properties Added Successfully");
    }

    /**
     * 4.Display the File Property Keys Method1
     */
    public static void displayTheFilePropertyKeysMethod1() throws Throwable {
        FileInputStream fileInputStream = new FileInputStream(file);
        Properties properties = new Properties();
        properties.load(fileInputStream);

        Set<String> propertyKey = properties.stringPropertyNames();
        System.err.println(propertyKey);
    }

    /**
     * 5.Display the File Property Key Method2
     */
    public static void displayTheFilePropertyKeyMethod2() throws Throwable {
        FileInputStream fileInputStream = new FileInputStream(file);
        Properties properties = new Properties();
        properties.load(fileInputStream);

        Set<Object> propertyKey = properties.keySet();
        System.err.println(propertyKey);
    }

    /**
     * 6.Display the File Property Values
     */
    public static void displayTheFilePropertyValues() throws Throwable {
        FileInputStream fileInputStream = new FileInputStream(file);
        Properties properties = new Properties();
        properties.load(fileInputStream);

        Collection<Object> propertyValues = properties.values();
        System.err.println(propertyValues);

    }

    /**
     * 7.Get Specific File Property Value Based on Key
     */
    public static void getSpecificFilePropertyValueBasedOnKey() throws Throwable {
        FileInputStream fileInputStream = new FileInputStream(file);
        Properties properties = new Properties();
        properties.load(fileInputStream);

        System.err.println(properties.getProperty("password"));

    }

    /**
     * 8.FilePropertyGetPropertyMethodWithDefaultValue
     */
    public static void filePropertyGetPropertyMethodWithDefaultValue() throws Throwable {
        FileInputStream fileInputStream = new FileInputStream(file);
        Properties properties = new Properties();
        properties.load(fileInputStream);

        System.err.println(properties.getProperty("userPassword", "use Correct Key"));
    }

    /**
     * 9.Display PropertyFile Data
     */
    public static void displayPropertyFileData() throws Throwable {
        FileInputStream fileInputStream = new FileInputStream(file);
        Properties properties = new Properties();
        properties.load(fileInputStream);

        System.err.println(properties);
    }

    /**
     * 10. Display PropertyFile Data Method1
     */
    public static void displayPropertyFileDataMethod1() throws Throwable {
        FileInputStream fileInputStream = new FileInputStream(file);
        Properties properties = new Properties();
        properties.load(fileInputStream);

        Collection<Object> collection = properties.values();
        for (Object key : properties.keySet()) {
            System.err.println(key + " ->" + properties.getProperty((String) key));
        }
    }

    /**
     * 11.Display PropertyFile Data Method2
     */
    public static void displayPropertyFileDataMethod2() throws Throwable {
        FileInputStream fileInputStream = new FileInputStream(file);
        Properties properties = new Properties();
        properties.load(fileInputStream);

        Set<Map.Entry<Object, Object>> data = properties.entrySet();
        for (Map.Entry<Object, Object> entry : data) {
            System.err.println(entry.getKey() + "->" + entry.getValue());
        }
    }

    /**
     * 12.Update The Property File Value
     */
    public static void updateThePropertyFileValue() throws Throwable {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(file);
        properties.load(fileInputStream);
        properties.setProperty("password", "newPassword");

        FileOutputStream fileOutputStream = new FileOutputStream(file);
        properties.store(fileOutputStream, "PropertyFile Data Updated");

        System.err.println(file.getName() + " File Data Updated Successfully ");

    }

    /**
     * 13.Remove Data From Property File
     */
    public static void removeDataFromPropertyFile() throws Throwable {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(file);
        properties.load(fileInputStream);

        Object object = properties.remove("password");

        FileOutputStream fileOutputStream = new FileOutputStream(file);
        properties.store(fileOutputStream, null);

        if (object != null) {
            System.err.println(object + " Value Removed From Property File");
        } else {
            System.err.println(" Value Not Found in Property File");
        }
    }

    /*1.Properties Class is Extending to the HashTable and HashTable is Extending to the Map Interface. */
    /*2.We can Use All Map Functions in Properties. */

}
