package com.movie.moviewithpager.di

import com.movie.moviewithpager.domain.usecase.*
import com.movie.moviewithpager.data.repository.FavouriteRepository
import com.movie.moviewithpager.data.repository.MovieRepository
import com.movie.moviewithpager.domain.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Singleton
    @Provides
    fun provideMovieByCategoryUseCase(movieRepository: MovieRepository): MovieByCategoryUseCase {
        return MovieByCategoryUseCase(movieRepository)
    }

    @Singleton
    @Provides
    fun provideMovieDetailsByIDUseCase(movieRepository: MovieRepository): MovieDetailsByIDUseCase {
        return MovieDetailsByIDUseCase(movieRepository)
    }

    @Singleton
    @Provides
    fun provideMovieGenreListUseCase(movieRepository: MovieRepository): MovieGenreListUseCase {
        return MovieGenreListUseCase(movieRepository)
    }

    @Singleton
    @Provides
    fun provideMovieSearchUseCase(movieRepository: MovieRepository): MovieSearchUseCase {
        return MovieSearchUseCase(movieRepository)
    }

    @Singleton
    @Provides
    fun provideAddFavouriteUseCase(movieRepository: FavouriteRepository): AddFavouriteUseCase {
        return AddFavouriteUseCase(movieRepository)
    }

    @Singleton
    @Provides
    fun provideIsFavouriteUseCase(movieRepository: FavouriteRepository): IsFavouriteUseCase {
        return IsFavouriteUseCase(movieRepository)
    }
}