package com.movie.moviewithpager.di


import com.movie.moviewithpager.data.local.dao.FavouritesDao
import com.movie.moviewithpager.data.remote.MovieDataSource
import com.movie.moviewithpager.data.repository.FavouriteRepository
import com.movie.moviewithpager.data.repository.FavouriteRepositoryImpl
import com.movie.moviewithpager.data.repository.MovieRepository
import com.movie.moviewithpager.data.repository.MovieRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun providesMovieRepository(movieDataSource: MovieDataSource): MovieRepository {
        return MovieRepositoryImpl(movieDataSource)
    }
    @Singleton
    @Provides
    fun providesFavouriteRepository(favouriteSource: FavouritesDao): FavouriteRepository {
        return FavouriteRepositoryImpl(favouriteSource)
    }
}