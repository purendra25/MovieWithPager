package com.movie.moviewithpager.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.movie.moviewithpager.data.local.entity.Favorite
import com.movie.moviewithpager.utils.Constants
import kotlinx.coroutines.flow.Flow

@Dao
interface FavouritesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(favorite: Favorite): Long

    @Query("SELECT CASE WHEN COUNT(*) > 0 THEN 1 ELSE 0 END FROM ${Constants.TABLE_NAME} WHERE movieId = :movieId")
    fun isFavorite(movieId: Int): Flow<Boolean>
}