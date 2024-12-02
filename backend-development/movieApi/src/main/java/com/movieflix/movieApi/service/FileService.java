package com.movieflix.movieApi.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;

public interface FileService {

    /** upload file **/
    String uploadFile(String path, MultipartFile multipartFile) throws IOException;

    /** get resource file **/
    InputStream getResourceFile(String path, String name) throws FileNotFoundException;



}
