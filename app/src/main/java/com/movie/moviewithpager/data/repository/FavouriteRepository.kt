package com.movie.moviewithpager.data.repository

import com.movie.moviewithpager.data.local.entity.Favorite
import kotlinx.coroutines.flow.Flow

interface FavouriteRepository {
    suspend fun addFavourite(favorite: Favorite): Long
    suspend fun isFavourite(movieId: Int): Flow<Boolean>

}