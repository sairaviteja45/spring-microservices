package com.movieflix.movieApi.service;

import com.movieflix.movieApi.dto.MovieDto;
import com.movieflix.movieApi.dto.MoviePageResponse;
import com.movieflix.movieApi.entities.Movie;
import com.movieflix.movieApi.exceptions.*;
import com.movieflix.movieApi.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.*;
import java.util.*;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    private final FileService fileService;

    @Value("${project.poster}")
    private String path;

    @Value("${base.url}")
    private String baseUrl;

    public MovieServiceImpl(MovieRepository movieRepository, FileService fileService) {
        this.movieRepository = movieRepository;
        this.fileService = fileService;
    }

    /**
     * add new movie
     **/
    @Override
    public MovieDto addNewMovie(MovieDto movieDto, MultipartFile multipartFile) throws IOException {

        if (Files.exists(Paths.get(path + File.separator + multipartFile.getOriginalFilename()))) {
            throw new FileExistExceptions("File already exists! Please enter another file name!");
        }

        /* 1.upload the file. */
        String uploadedFileName = fileService.uploadFile(path, multipartFile);

        /* 2.set the value of field poster as fileName. */
        movieDto.setPoster(uploadedFileName);

        /* 3.map dto to movie object. */
        Movie movie = new Movie(
                null,
                movieDto.getTitle(),
                movieDto.getDirector(),
                movieDto.getStudio(),
                movieDto.getMovieCast(),
                movieDto.getReleaseYear(),
                movieDto.getPoster()
        );

        /* 4.save the movie object -> saved movie Object. */
        Movie saveMovie = movieRepository.save(movie);

        /* 5.generate the poster URL. */
        String posterUrl = baseUrl + "/file/" + uploadedFileName;

        /* 6.map Movie object to DTO object and return it. */

        return new MovieDto(
                saveMovie.getMovieId(),
                saveMovie.getTitle(),
                saveMovie.getDirector(),
                saveMovie.getStudio(),
                saveMovie.getMovieCast(),
                saveMovie.getReleaseYear(),
                saveMovie.getPoster(),
                posterUrl
        );
    }

    /**
     * get movie details
     **/
    @Override
    public MovieDto getMovieDetails(Integer movieId) {

        /* 1.check the movie data in database and if exists, fetch the data of given ID. */
        Movie movie = movieRepository.findById(movieId).orElseThrow(() -> new MovieNotFoundException("Movie Not Found With given Id = " + movieId));

        /* 2.generate posterUrl. */
        String posterUrl = baseUrl + "/file/" + movie.getPoster();

        /* 3.map to MovieDto object and return it. */
        return new MovieDto(
                movie.getMovieId(),
                movie.getTitle(),
                movie.getDirector(),
                movie.getStudio(),
                movie.getMovieCast(),
                movie.getReleaseYear(),
                movie.getPoster(),
                posterUrl
        );
    }

    /**
     * get all movies
     **/
    @Override
    public List<MovieDto> getAllMovies() {
        /* 1.Fetch all data from DB. */
        List<Movie> movies = movieRepository.findAll();

        List<MovieDto> movieDtos = new ArrayList<>();

        /* 2.iterate through the list, generate postalUrl for each movie obj, and map to MovieDto obj. */
        for (Movie movie : movies) {
            String posterUrl = baseUrl + "/file/" + movie.getPoster();

            MovieDto movieDto = new MovieDto(
                    movie.getMovieId(),
                    movie.getTitle(),
                    movie.getDirector(),
                    movie.getStudio(),
                    movie.getMovieCast(),
                    movie.getReleaseYear(),
                    movie.getPoster(),
                    posterUrl
            );
            movieDtos.add(movieDto);
        }
        return movieDtos;
    }

    /**
     * updateMovie
     */
    @Override
    public MovieDto updateMovie(Integer movieId, MovieDto movieDto, MultipartFile multipartFile) throws IOException {

        /** 1.check if movie object exists with given movieId. **/
        Movie movieById = movieRepository.findById(movieId).orElseThrow(() -> new MovieNotFoundException("Movie Not Found With given Id = " + movieId));

        /** 2.if file is null, do nothing, if file is not null ,then delete existing file associated with the record, and upload the new file. **/
        String fileName = movieById.getPoster();
        if (multipartFile != null) {
            Files.deleteIfExists(Paths.get(path + File.separator + fileName));
            fileName = fileService.uploadFile(path, multipartFile);
        }

        /** 3.set movieDto's poster value, according to step. **/
        movieDto.setPoster(fileName);

        /** 4.map it to movie object. **/
        Movie movie = new Movie(
                movieById.getMovieId(),
                movieDto.getTitle(),
                movieDto.getDirector(),
                movieDto.getStudio(),
                movieDto.getMovieCast(),
                movieDto.getReleaseYear(),
                movieDto.getPoster()
        );

        /** 5.save the movie object -> return saved movie object. **/
        Movie updatedMovie = movieRepository.save(movie);

        /** 6.generate posterUrl for it. **/
        String posterUrl = baseUrl + "/file/" + fileName;

        /** 7.map to MovieDto and return it. **/
        return new MovieDto(
                movie.getMovieId(),
                movie.getTitle(),
                movie.getDirector(),
                movie.getStudio(),
                movie.getMovieCast(),
                movie.getReleaseYear(),
                movie.getPoster(),
                posterUrl
        );
    }

    /**
     * deleteMovie
     **/
    @Override
    public String deleteMovie(Integer movieId) throws IOException {

        /** 1.check if movie object exists in DB. **/
        Movie movieById = movieRepository.findById(movieId).orElseThrow(() -> new MovieNotFoundException("Movie Not Found With given Id = " + movieId));

        /** 2.delete the file associated with this object. **/
        Files.deleteIfExists(Paths.get(path + File.separator + movieById.getPoster()));

        /** 3.delete the movie object. **/
        movieRepository.delete(movieById);

        return "Movie Deleted With MovieId = " + movieById;

    }

    /**
     * getAllMoviesWithPagination
     **/
    @Override
    public MoviePageResponse getAllMoviesWithPagination(Integer pageNumber, Integer pageSize) {

        Pageable pageable = PageRequest.of(pageNumber, pageSize);

        Page<Movie> moviePages = movieRepository.findAll(pageable);

        List<Movie> movies = moviePages.getContent();

        List<MovieDto> movieDtos = new ArrayList<>();

        for (Movie movie : movies) {
            String posterUrl = baseUrl + "/file" + movie.getPoster();
            MovieDto movieDto = new MovieDto(
                    movie.getMovieId(),
                    movie.getTitle(),
                    movie.getDirector(),
                    movie.getStudio(),
                    movie.getMovieCast(),
                    movie.getReleaseYear(),
                    movie.getPoster(),
                    posterUrl
            );
            movieDtos.add(movieDto);
        }
        return new MoviePageResponse(movieDtos, pageNumber, pageSize, (int) moviePages.getTotalElements(),moviePages.getTotalPages(), moviePages.isLast());
    }

    /**
     * getAllMoviesWithPaginationAndSorting
     **/
    @Override
    public MoviePageResponse getAllMoviesWithPaginationAndSorting(Integer pageNumber, Integer pageSize, String sortBy, String dir) {

        Sort sort = dir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);

        Page<Movie> moviePages = movieRepository.findAll(pageable);

        List<Movie> movies = moviePages.getContent();

        List<MovieDto> movieDtos = new ArrayList<>();

        for (Movie movie : movies) {
            String posterUrl = baseUrl + "/file" + movie.getPoster();
            MovieDto movieDto = new MovieDto(
                    movie.getMovieId(),
                    movie.getTitle(),
                    movie.getDirector(),
                    movie.getStudio(),
                    movie.getMovieCast(),
                    movie.getReleaseYear(),
                    movie.getPoster(),
                    posterUrl
            );
            movieDtos.add(movieDto);
        }
        return new MoviePageResponse(movieDtos, pageNumber, pageSize, (int) moviePages.getTotalElements(),moviePages.getTotalPages(), moviePages.isLast());
    }
}
