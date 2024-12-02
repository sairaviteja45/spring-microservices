package javaFileHandling;

import java.io.*;
import java.util.*;

public class JavaFileHandlingMethods {

    public static void fileHandlingMethods() throws IOException {
        File file = new File("./sampleTextFile.txt");
        System.err.println(file.createNewFile());
        System.err.println(file.delete());
        System.err.println(file.exists());
        System.err.println(file.isHidden());
        System.err.println(file.canWrite());
        System.err.println(file.canRead());
        System.err.println(file.setWritable(true));
        System.err.println(file.canWrite());
        System.err.println(file.mkdir());
        System.err.println(file.mkdirs());
        System.err.println(Arrays.toString(file.list()));
        System.err.println(Objects.requireNonNull(file.list()).length);
        System.err.println(Arrays.toString(file.listFiles()));
        System.err.println(file.getName());
        System.err.println(file.getPath());
        System.err.println(file.getAbsolutePath());
        System.err.println(file.getAbsoluteFile());
        System.err.println(file.getParent());
        System.err.println(file.getParentFile());
        System.err.println(new Date(file.lastModified()));
        System.err.println(file.isDirectory());
        System.err.println(file.isFile());
    }
}
