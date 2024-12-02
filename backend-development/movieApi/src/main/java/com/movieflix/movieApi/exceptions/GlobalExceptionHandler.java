package com.movieflix.movieApi.exceptions;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MovieNotFoundException.class)
    public ProblemDetail handleMovieNotFoundException(MovieNotFoundException movieNotFoundException) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, movieNotFoundException.getMessage());
    }

    @ExceptionHandler(FileExistExceptions.class)
    public ProblemDetail handleFileExistExceptions(FileExistExceptions fileExistExceptions) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, fileExistExceptions.getMessage());
    }

    @ExceptionHandler(EmptyFileException.class)
    public ProblemDetail handlerEmptyFileException(EmptyFileException emptyFileException) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, emptyFileException.getMessage());
    }
}
