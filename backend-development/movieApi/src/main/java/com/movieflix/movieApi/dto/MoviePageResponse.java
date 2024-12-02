package com.movieflix.movieApi.dto;

import java.util.List;

public record MoviePageResponse(List<MovieDto> movieDto,
                                Integer pageNumber,
                                Integer pageSize,
                                int totalElements,
                                int totalPages,
                                boolean isList) {
}
