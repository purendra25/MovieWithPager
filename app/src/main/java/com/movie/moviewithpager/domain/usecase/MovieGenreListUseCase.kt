package com.movie.moviewithpager.domain.usecase

import com.movie.moviewithpager.data.repository.MovieRepository


class MovieGenreListUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute() = movieRepository.getGenreMovieListRepo()
}