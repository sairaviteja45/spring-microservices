package com.movieflix.movieApi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto {

    private Integer movieId;
    @NotBlank(message = "Please provide movie's title!")

    private String title;
    @NotBlank(message = "Please provide movie's director!")

    private String director;
    @NotBlank(message = "Please provide movie's studio!")

    private String studio;

    private Set<String> movieCast;

    private Integer releaseYear;

    @NotBlank(message = "Please provide movie's poster!")
    private String poster;

    @NotBlank(message = "Please provide poster's URL!")
    private String posterUrl;
}
