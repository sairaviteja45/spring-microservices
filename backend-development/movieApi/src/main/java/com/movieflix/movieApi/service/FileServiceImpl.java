package com.movieflix.movieApi.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.*;

@Service
public class FileServiceImpl implements FileService {
    @Override
    public String uploadFile(String path, MultipartFile multipartFile) throws IOException {
        /* get name of the file. */
        String fileName = multipartFile.getOriginalFilename();

        /* get the filePath. */
        String filePath = path + File.separator + fileName;

        /* create file object. */
        File file = new File(path);
        if (!file.exists()) {
            file.mkdir();
        }

        /* copy the file or upload the file to the path. */
        Files.copy(multipartFile.getInputStream(), Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);

        return fileName;
    }

    @Override
    public InputStream getResourceFile(String path, String filename) throws FileNotFoundException {
        String filePath = path + File.separator + filename;

        return new FileInputStream(filePath);
    }
}
