package com.movie.moviewithpager.domain.usecase

import com.movie.moviewithpager.data.repository.FavouriteRepository

class IsFavouriteUseCase(private val favoriteRepository: FavouriteRepository) {

    suspend fun execute(
        movieId: Int
    ) = favoriteRepository.isFavourite(movieId)
}

