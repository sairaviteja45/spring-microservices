package serviceImplementationMethods;

import daoInterfaceMethods.JavaFileMethodsDaoInterface;
import entityTables.JavaFileMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositoryInterfaces.JavaFileMethodsRepository;
import serviceInterfaceMethods.JavaFileMethodsServiceInterfaceMethods;
import utility.ApiResponse;
import utility.Response;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class JavaFileMethodsServiceImplementation {

    @Autowired
    private JavaFileMethodsRepository javaFileMethodsRepository;

    @Autowired
    private JavaFileMethodsDaoInterface javaFileMethods;

    /* 1.fileAddNewMethod */
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
    public Response fileUpdateMethod(JavaFileMethods javaFileMethods) {
        Response response = new Response();
        try {
            Optional<JavaFileMethods> findByFileId = javaFileMethodsRepository.findById(javaFileMethods.getFileId());
            JavaFileMethods existingRecord = findByFileId.get();
            existingRecord.setFileMethodName(javaFileMethods.getFileMethodName());
            existingRecord.setMethodDescription(javaFileMethods.getMethodDescription());
            existingRecord.setMethodResponse(javaFileMethods.getMethodResponse());

            javaFileMethodsRepository.save(existingRecord);

            response.setId(javaFileMethods.getFileId());
            response.setData(existingRecord);
            response.setStatus(ApiResponse.SUCCESS_STATUS);
            response.setMessage(ApiResponse.UPDATE_SUCCESS_MESSAGE);
        } catch (Throwable ignored) {
            response.setMessage(ApiResponse.UPDATE_FAILURE_MESSAGE);
            response.setStatus(ApiResponse.FAILURE_STATUS);
            response.setData(ignored.getMessage());
        }
        return response;
    }

    /* 3.fileViewById */
    public Response fileViewById(Integer fileId) {
        Response response = new Response();
        try {
            JavaFileMethods findByFileId = javaFileMethodsRepository.getReferenceById(fileId);
            response.setId(fileId);
            response.setData(findByFileId);
            response.setStatus(ApiResponse.SUCCESS_STATUS);
            response.setMessage(ApiResponse.DATA_DISPLAYING_SUCCESS_MESSAGE);
            response.setNumberOfRecords(1);
        } catch (Exception exception) {
            response.setStatus(ApiResponse.FAILURE_STATUS);
            response.setMessage(ApiResponse.DATA_DISPLAYING_FAILURE_MESSAGE);
            response.setData(exception.getMessage());
        }
        return response;
    }

    /* 4.fileViewByMethodName */
    public Response fileViewByMethodName(String fileMethodName) {
        Response response = new Response();
        try {
            JavaFileMethods findByMethodName = javaFileMethodsRepository.findByFileMethodName(fileMethodName);
            response.setId(findByMethodName.getFileId());
            response.setData(findByMethodName);
            response.setStatus(ApiResponse.SUCCESS_STATUS);
            response.setMessage(ApiResponse.DATA_DISPLAYING_SUCCESS_MESSAGE);
            response.setNumberOfRecords(1);
        } catch (Exception exception) {
            response.setStatus(ApiResponse.FAILURE_STATUS);
            response.setMessage(ApiResponse.DATA_DISPLAYING_FAILURE_MESSAGE);
            response.setData(exception.getMessage());
        }
        return response;
    }

    /* 5.fileMethodsList */
    public Response fileMethodsList() {
        Response response = new Response();
        try {
            // Fetch all data from the repository
            List<JavaFileMethods> data = javaFileMethodsRepository.findAll();

            // Check if the data is empty
            if (data.isEmpty()) {
                response.setStatus(ApiResponse.SUCCESS_STATUS);
                response.setMessage("No records found.");
                response.setData(Collections.emptyList());
                response.setNumberOfRecords(0);
                return response;
            }

            // Set the successful response with data
            response.setData(data);
            response.setMessage(ApiResponse.DATA_DISPLAYING_SUCCESS_MESSAGE);
            response.setStatus(ApiResponse.SUCCESS_STATUS);
            response.setNumberOfRecords(data.size());
        } catch (Exception exception) {
            // Log the error for debugging purposes
            exception.printStackTrace(); // Replace with proper logging in production

            // Set failure response
            response.setStatus(ApiResponse.FAILURE_STATUS);
            response.setMessage(ApiResponse.DATA_DISPLAYING_FAILURE_MESSAGE);
            response.setData(Collections.emptyList());
            response.setNumberOfRecords(0);
        }
        return response;
    }

}
