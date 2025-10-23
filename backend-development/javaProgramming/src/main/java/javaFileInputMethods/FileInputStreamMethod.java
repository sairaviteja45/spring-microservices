package javaFileInputMethods;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamMethod {
    static File file = new File("./sample.txt");

    /* 1.readMethod() */
    private static void readMethodExample1() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        int number;
        while ((number = fileInputStream.read()) != -1) {
            System.out.print((char) number);
        }
        fileInputStream.close();
    }

    private static void readMethodExample2() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        int number;
        StringBuilder textData = new StringBuilder();
        while ((number = fileInputStream.read()) != -1) {
            textData.append(number);
        }
        System.out.print(textData);
        fileInputStream.close();
    }


}
