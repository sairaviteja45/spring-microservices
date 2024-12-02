package com.movieflix.movieApi.controller;

import com.movieflix.movieApi.service.FileService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@RestController
@RequestMapping("/file/")
public class FileController {

    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @Value("${project.poster}")
    private String path;

    /** file upload **/
    @RequestMapping("/upload")
    public ResponseEntity<String> uploadFileHandler(@RequestPart MultipartFile multipartFile) throws IOException {
        String uploadedFileName = fileService.uploadFile(path, multipartFile);
        return ResponseEntity.ok("File Uploaded: " + uploadedFileName);
    }

    /** server file handler **/
    @GetMapping("/fileName/{fileName}")
    public void serverFileHandler(@PathVariable String fileName, HttpServletResponse httpServletResponse) throws IOException {
        InputStream inputStream = fileService.getResourceFile(path, fileName);
        httpServletResponse.setContentType(MediaType.IMAGE_PNG_VALUE);
        StreamUtils.copy(inputStream, httpServletResponse.getOutputStream());
    }
}
