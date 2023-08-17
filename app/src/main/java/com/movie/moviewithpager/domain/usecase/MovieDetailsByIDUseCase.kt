package com.movie.moviewithpager.domain.usecase

import com.movie.moviewithpager.data.repository.MovieRepository


class MovieDetailsByIDUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute(movieID: Int) = movieRepository.getMovieDetailsByIDRepo(movieID)
}