package com.movie.moviewithpager.domain.usecase

import com.movie.moviewithpager.data.api.ApiResult
import com.movie.moviewithpager.data.local.entity.Favorite
import com.movie.moviewithpager.data.repository.FavouriteRepository

class AddFavouriteUseCase(private val favoriteRepository: FavouriteRepository) {
    suspend fun execute(
        favorite: Favorite
    ): ApiResult<Long> {
        return try {
            val insertedItemId = favoriteRepository.addFavourite(favorite)
            ApiResult.Success(insertedItemId)
        } catch (e: Exception) {
            ApiResult.Error("An error occurred", 500)
        }
    }
}
