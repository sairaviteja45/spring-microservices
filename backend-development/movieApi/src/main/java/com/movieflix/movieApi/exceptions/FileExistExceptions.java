package com.movieflix.movieApi.exceptions;

public class FileExistExceptions extends RuntimeException {

    public FileExistExceptions(String message) {
        super(message);
    }
}
