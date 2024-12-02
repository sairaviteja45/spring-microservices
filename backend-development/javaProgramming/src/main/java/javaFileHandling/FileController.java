package javaFileHandling.fileController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import serviceInterfaceMethods.JavaFileMethodsServiceInterfaceMethods;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping(value = "/file/")
public class FileController {

    @Autowired
    private JavaFileMethodsServiceInterfaceMethods javaFileMethodsServiceInterfaceMethods;

    /* 1.addNewMethod */


    @RequestMapping(value = "fileHandlingMethods", method = RequestMethod.GET)
    public static Map<String, Object> fileHandlingMethods() throws IOException, FileNotFoundException {
        Map<String, Object> output = new LinkedHashMap<>();
        File file = new File("./sampleTextFile.txt");

        /* 1.Create File Method */
        Map<String, Object> createFileMethod = new LinkedHashMap<>();
        createFileMethod.put("Description","Create New File if it does not exist.");
        createFileMethod.put("methodName",file.createNewFile());
        output.put("createFileMethod",createFileMethod);
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

        return output;
    }
}
