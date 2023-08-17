package com.movie.moviewithpager.di

import android.app.Application
import androidx.room.Room
import com.movie.moviewithpager.data.local.FavouriteDatabase
import com.movie.moviewithpager.data.local.dao.FavouritesDao
import com.movie.moviewithpager.utils.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DBModule {

    @Provides
    @Singleton
    fun provideFavoritesDatabase(application: Application): FavouriteDatabase {
        return Room.databaseBuilder(
            application.applicationContext,
            FavouriteDatabase::class.java,
            DATABASE_NAME
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    fun provideFavoriteDao(database: FavouriteDatabase): FavouritesDao {
        return database.favouriteDao()
    }
}