package com.movie.moviewithpager.domain.usecase

import com.movie.moviewithpager.data.repository.MovieRepository

class MovieByCategoryUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute(
        movieCategory: String,
        page: Int
    ) = movieRepository.getMovieByCategoryRepo(movieCategory, page)
}