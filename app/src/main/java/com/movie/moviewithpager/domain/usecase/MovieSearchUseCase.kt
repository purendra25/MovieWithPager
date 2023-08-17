package com.movie.moviewithpager.domain.usecase

import com.movie.moviewithpager.data.repository.MovieRepository


class MovieSearchUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute(
        query: String,
        page: Int
    ) = movieRepository.getSearchMovieDataSource(query, page)
}