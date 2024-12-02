package serviceImplementationMethods;

import daoInterfaceMethods.JavaFileMethodsDaoInterface;
import entityTables.JavaFileMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositoryInterfaces.JavaFileMethodsRepository;
import serviceInterfaceMethods.JavaFileMethodsServiceInterfaceMethods;
import utility.ApiResponse;
import utility.Response;

@Service
public class JavaFileMethodsServiceImplementation implements JavaFileMethodsServiceInterfaceMethods {

    @Autowired
    private JavaFileMethodsRepository javaFileMethodsRepository;

    @Autowired
    private JavaFileMethodsDaoInterface javaFileMethods;

    /* 1.fileAddNewMethod */
    @Override
    public Response fileAddNewMethod(JavaFileMethods javaFileMethods) {
        Response response = new Response();
        try {
            // Count records before save
            long initialCount = javaFileMethodsRepository.count();

            // Save the new record
            JavaFileMethods newRecord = javaFileMethodsRepository.save(javaFileMethods);

            // Count records after save
            long finalCount = javaFileMethodsRepository.count();

            // Set response data
            response.setId(newRecord.getFileId());
            response.setData(newRecord);
            response.setMessage(ApiResponse.ADD_SUCCESS_MESSAGE);
            response.setStatus(ApiResponse.SUCCESS_STATUS);

            // Calculate and set the number of records saved
            long recordsAdded = finalCount - initialCount;
            response.setNumberOfRecords(Integer.parseInt(String.valueOf(recordsAdded)));

        } catch (Throwable ignored) {
            // Handle any exception during save
            response.setMessage(ApiResponse.ADD_FAILURE_MESSAGE);
            response.setStatus(ApiResponse.FAILURE_STATUS);
            response.setData(ignored.getMessage());
        }
        return response;
    }


    /* 2.fileUpdateMethod */
    @Override
    public Response fileUpdateMethod(JavaFileMethods javaFileMethods) {
        Response response = new Response();
        return response;
    }

    @Override
    public Response fileViewById(Integer fileId) {
        Response response = new Response();
        return response;
    }

    @Override
    public Response fileViewByMethodName(String fileMethodName) {
        Response response = new Response();
        return response;
    }

    @Override
    public Response fileMethodsList() {
        Response response = new Response();
        return response;
    }
}
