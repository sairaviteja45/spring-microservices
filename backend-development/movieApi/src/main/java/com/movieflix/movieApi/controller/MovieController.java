package com.movieflix.movieApi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.movieflix.movieApi.dto.*;
import com.movieflix.movieApi.exceptions.EmptyFileException;
import com.movieflix.movieApi.service.MovieService;
import com.movieflix.movieApi.util.AppContent;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/movie")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    /**
     * add movie
     **/
    @PostMapping("/add-movie")
    public ResponseEntity<MovieDto> addMovieHandler(@RequestPart MultipartFile multipartFile,
                                                    @RequestPart String movieDto) throws IOException, EmptyFileException {
        if (multipartFile.isEmpty()) {
            throw new EmptyFileException("File is Empty! Please send another file!");
        }
        MovieDto dto = convertToMovieDto(movieDto);
        return new ResponseEntity<>(movieService.addNewMovie(dto, multipartFile), HttpStatus.CREATED);
    }

    /**
     * get movie details by id
     **/
    @GetMapping("/getMovieDetailsById/{movieId}")
    public ResponseEntity<MovieDto> getMovieDetailsId(@PathVariable Integer movieId) {
        return ResponseEntity.ok(movieService.getMovieDetails(movieId));
    }

    /**
     * get all movies
     **/
    @GetMapping("/getAllMovies")
    public ResponseEntity<List<MovieDto>> getAllMovies() {
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    /**
     * updateMovieByMovieId
     **/
    @PutMapping("updateMovieByMovieId/{movieId}")
    public ResponseEntity<MovieDto> updateMovieByMovieId(@PathVariable Integer movieId,
                                                         @RequestPart MultipartFile multipartFile,
                                                         @RequestPart String movieDtoObj) throws Throwable {
        if (multipartFile.isEmpty()) multipartFile = null;
        MovieDto movieDto = convertToMovieDto(movieDtoObj);
        return ResponseEntity.ok(movieService.updateMovie(movieId, movieDto, multipartFile));
    }

    /**
     * deleteMovieByMovieId
     **/
    @DeleteMapping("/deleteMovieByMovieId/{movieId}")
    public ResponseEntity<String> deleteMovieByMovieId(@PathVariable Integer movieId) throws IOException {
        return ResponseEntity.ok(movieService.deleteMovie(movieId));
    }

    /**
     * get All Movies With Pagination
     **/
    @GetMapping("/getAllMoviesWithPagination")
    public ResponseEntity<MoviePageResponse> getAllMoviesWithPagination(@RequestParam(defaultValue = AppContent.PAGE_NUMBER, required = false) Integer pageNumber,
                                                                        @RequestParam(defaultValue = AppContent.PAGE_SIZE, required = false) Integer pageSize) {
        return ResponseEntity.ok(movieService.getAllMoviesWithPagination(pageNumber, pageSize));
    }

    /**
     * get All Movies With Pagination And Sorting
     **/
    @GetMapping("/getAllMoviesWithPaginationAndSorting")
    public ResponseEntity<MoviePageResponse> getAllMoviesWithPaginationAndSorting(@RequestParam(defaultValue = AppContent.PAGE_NUMBER, required = false) Integer pageNumber,
                                                                                  @RequestParam(defaultValue = AppContent.PAGE_SIZE, required = false) Integer pageSize,
                                                                                  @RequestParam(defaultValue = AppContent.SORT_BY, required = false) String sortBy,
                                                                                  @RequestParam(defaultValue = AppContent.SORT_DIR, required = false) String dir) {
        return ResponseEntity.ok(movieService.getAllMoviesWithPaginationAndSorting(pageNumber, pageSize, sortBy, dir));
    }

    /**
     * convert to movie dto
     **/
    private MovieDto convertToMovieDto(String movieObject) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(movieObject, MovieDto.class);
    }
}
