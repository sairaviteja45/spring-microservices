package serviceInterfaceMethods;

import entityTables.JavaFileMethods;
import utility.Response;

public interface JavaFileMethodsServiceInterfaceMethods {

    /* 1.fileAddNewMethod */
    Response fileAddNewMethod(JavaFileMethods javaFileMethods);

    /* 2.fileUpdateMethod */
    Response fileUpdateMethod(JavaFileMethods javaFileMethods);

    /* 3.fileViewById */
    Response fileViewById(Integer fileId);

    /* 4.fileViewByMethodName */
    Response fileViewByMethodName(String fileMethodName);

    /* 5.fileMethodsList */
    Response fileMethodsList();

}
