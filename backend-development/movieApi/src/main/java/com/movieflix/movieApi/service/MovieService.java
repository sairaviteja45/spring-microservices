package com.movieflix.movieApi.service;

import com.movieflix.movieApi.dto.MovieDto;
import com.movieflix.movieApi.dto.MoviePageResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface MovieService {

    /**
     * add new movie
     **/
    MovieDto addNewMovie(MovieDto movieDto, MultipartFile multipartFile) throws IOException;

    /**
     * get movie details
     **/
    MovieDto getMovieDetails(Integer movieId);

    /**
     * get all movies
     **/
    List<MovieDto> getAllMovies();

    /**
     * updateMovie
     **/
    MovieDto updateMovie(Integer movieId, MovieDto movieDto, MultipartFile multipartFile) throws IOException;

    /**
     * deleteMovie
     **/
    String deleteMovie(Integer movieId) throws IOException;

    /**
     * getAllMoviesWithPagination
     **/
    MoviePageResponse getAllMoviesWithPagination(Integer pageNumber, Integer pageSize);

    /**
     * getAllMoviesWithPaginationAndSorting
     **/
    MoviePageResponse getAllMoviesWithPaginationAndSorting(Integer pageNumber, Integer pageSize, String sortBy, String dir);

}
