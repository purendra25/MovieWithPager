package com.movie.moviewithpager.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.movie.moviewithpager.data.local.dao.FavouritesDao
import com.movie.moviewithpager.data.local.entity.Favorite

@Database(entities = [Favorite::class], version = 1)
abstract class FavouriteDatabase : RoomDatabase() {
    abstract fun favouriteDao(): FavouritesDao

}