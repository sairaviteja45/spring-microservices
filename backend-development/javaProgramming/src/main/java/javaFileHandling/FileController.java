package javaFileHandling;

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

//  @Autowired
    private JavaFileMethodsServiceInterfaceMethods javaFileMethodsServiceInterfaceMethods;

    /* 1.addNewMethod */


    @RequestMapping(value = "fileHandlingMethods", method = RequestMethod.GET)
    public static Map<String, Object> fileHandlingMethods() throws IOException, FileNotFoundException {
        Map<String, Object> output = new LinkedHashMap<>();
        File file = new File("./sampleTextFile.txt");

        /* 1.Create File Method */
        Map<String, String> createFileMethod = new LinkedHashMap<>();
        createFileMethod.put("Description","Atomically creates a new, empty file named by this abstract pathname if and only if a file with this name does not yet exist.");
        createFileMethod.put("methodName","file.createNewFile()");
        output.put("createFileMethod",createFileMethod);
        System.err.println(file.createNewFile());

        /* 2.Delete File Method */
        Map<String, String> deleteFileMethod = new LinkedHashMap<>();
        deleteFileMethod.put("Description","Deletes the file or directory denoted by this abstract pathname.");
        deleteFileMethod.put("methodName","file.delete()");
        output.put("deleteFileMethod",deleteFileMethod);
        System.err.println(file.delete());

        /* 3.Exists File Method */
        Map<String,String> existsFileMethod = new LinkedHashMap<>();
        existsFileMethod.put("Description","Tests whether the file or directory denoted by this abstract pathname exists.");
        existsFileMethod.put("methodName","file.exists()");
        output.put("existsFileMethod",existsFileMethod);
        System.err.println(file.exists());

        /* 4.IsHidden File Method */
        Map<String,String> isHiddenFileMethod = new LinkedHashMap<>();
        isHiddenFileMethod.put("Description","Tests whether the file named by this abstract pathname is a hidden file.");
        isHiddenFileMethod.put("methodName","file.isHidden()");
        output.put("isHiddenFileMethod",isHiddenFileMethod);
        System.err.println(file.isHidden());

        /* 5.CamWrite File Method */
        Map<String,String> canWriteFileMethod = new LinkedHashMap<>();
        canWriteFileMethod.put("Description","Tests whether the application can modify the file denoted by this abstract pathname.");
        canWriteFileMethod.put("methodName","file.canWrite()");
        output.put("canWriteFileMethod",canWriteFileMethod);
        System.err.println(file.canWrite());

        /* 6.CanRead File Method */
        Map<String,String> canReadFileMethod = new LinkedHashMap<>();
        canReadFileMethod.put("Description","Tests whether the application can read the file denoted by this abstract pathname.");
        canReadFileMethod.put("methodName","file.canRead()");
        output.put("canReadFileMethod",canReadFileMethod);
        System.err.println(file.canRead());

        /* 7.SetWritable File Method */
        Map<String,String> setWritableFileMethod = new LinkedHashMap<>();
        setWritableFileMethod.put("Description","A convenience method to set the owner's write permission for this abstract pathname.");
        setWritableFileMethod.put("methodName","file.setWritable(true)");
        output.put("setWritableFileMethod", setWritableFileMethod);
        System.err.println(file.setWritable(true));

        /* 8.mrdir File Method */
        Map<String,String> mrdirFileMethod = new LinkedHashMap<>();
        mrdirFileMethod.put("Description", "Creates the directory named by this abstract pathname.");
        mrdirFileMethod.put("methodName","file.mkdir()");
        output.put("mrdirFileMethod", mrdirFileMethod);
        System.err.println(file.mkdir());

        /* 9.mkdirs File Method */
        Map<String,String> mkdirsFileMethod = new LinkedHashMap<>();
        mkdirsFileMethod.put("Description","Creates the directory named by this abstract pathname, including any necessary but nonexistent parent directories.");
        mkdirsFileMethod.put("methodName","file.mkdirs()");
        output.put("mkdirsFileMethod",mkdirsFileMethod);
        System.err.println(file.mkdirs());

        /* 10.list File Method */
        Map<String,String> listFileMethod = new LinkedHashMap<>();
        listFileMethod.put("Description", "Returns an array of strings naming the files and directories in the directory denoted by this abstract pathname.");
        listFileMethod.put("methodName","file.list()");
        output.put("listFileMethod",listFileMethod);
        System.err.println(Arrays.toString(file.list()));
        System.err.println(Objects.requireNonNull(file.list()).length);

        /* 11.listFiles File Method */
        Map<String,String> listFilesFileMethod= new LinkedHashMap<>();
        listFilesFileMethod.put("Description","Returns an array of abstract pathnames denoting the files in the directory denoted by this abstract pathname.");
        listFilesFileMethod.put("methodName","file.listFiles()");
        output.put("listFilesFileMethod",listFilesFileMethod);
        System.err.println(Arrays.toString(file.listFiles()));

        /* 12.getName File Method */
        Map<String,String> getNameFileMethod= new LinkedHashMap<>();
        getNameFileMethod.put("Description","Returns the name of the file or directory denoted by this abstract pathname.");
        getNameFileMethod.put("methodName","file.getName()");
        output.put("getNameFileMethod",getNameFileMethod);
        System.err.println(file.getName());

        /* 13.getPath File Name */
        Map<String,String> getPathFileName= new LinkedHashMap<>();
        getPathFileName.put("Description","Converts this abstract pathname into a pathname string.");
        getPathFileName.put("methodName","file.getPath()");
        output.put("getPathFileName",getPathFileName);
        System.err.println(file.getPath());

        /* 14.getAbsolutePath File Method */
        Map<String,String> getAbsolutePathFileMethod= new LinkedHashMap<>();
        getAbsolutePathFileMethod.put("Description", "Returns the absolute pathname string of this abstract pathname.");
        getAbsolutePathFileMethod.put("methodName","file.getAbsolutePath()");
        output.put("getAbsolutePathFileMethod",getAbsolutePathFileMethod);
        System.err.println(file.getAbsolutePath());

        /* 15.getAbsoluteFile File Method */
        Map<String,String> getAbsoluteFileFileMethod= new LinkedHashMap<>();
        getAbsoluteFileFileMethod.put("Description","Returns the absolute form of this abstract pathname");
        getAbsoluteFileFileMethod.put("methodName","file.getAbsoluteFile()");
        output.put("getAbsoluteFileFileMethod",getAbsoluteFileFileMethod);
        System.err.println(file.getAbsoluteFile());

        /* 16.getParent File Method */
        Map<String,String> getParentFileMethod = new LinkedHashMap<>();
        getParentFileMethod.put("Description","Returns the pathname string of this abstract pathname parent, or null if this pathname does not name a parent directory");
        getParentFileMethod.put("methodName", "file.getParent()");
        output.put("getParentFileMethod",getParentFileMethod);
        System.err.println(file.getParent());

        /* 17.getParentFile File Method */
        Map<String,String> getParentFileFileMethod= new LinkedHashMap<>();
        getParentFileFileMethod.put("Description","Returns the abstract pathname of this abstract pathname parent, or null if this pathname does not name a parent directory.");
        getParentFileFileMethod.put("methodName","file.getParentFile()");
        output.put("getParentFileFileMethod",getParentFileFileMethod);
        System.err.println(file.getParentFile());

        /* 18.lastModified File Method */
        Map<String,String> lastModifiedFileMethod = new LinkedHashMap<>();
        lastModifiedFileMethod.put("Description","Returns the time that the file denoted by this abstract pathname was last modified.");
        lastModifiedFileMethod.put("methodName","file.lastModified()");
        output.put("lastModifiedFileMethod",lastModifiedFileMethod);
        System.err.println(new Date(file.lastModified()));

        /* 19.isDirectory File Method */
        Map<String,String> isDirectoryFileMethod = new LinkedHashMap<>();
        isDirectoryFileMethod.put("Description","Tests whether the file denoted by this abstract pathname is a directory.");
        isDirectoryFileMethod.put("methodName","file.isDirectory()");
        output.put("isDirectoryFileMethod",isDirectoryFileMethod);
        System.err.println(file.isDirectory());

        /* 20.isFile File Method */
        Map<String,String> isFileFileMethod = new LinkedHashMap<>();
        isFileFileMethod.put("Description","Tests whether the file denoted by this abstract pathname is a normal file.");
        isFileFileMethod.put("methodName","file.isFile()");
        output.put("isFileFileMethod",isFileFileMethod);
        System.err.println(file.isFile());

        return output;
    }
}
