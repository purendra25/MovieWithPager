package com.movie.moviewithpager.di


import com.movie.moviewithpager.data.api.SpectrumApi
import com.movie.moviewithpager.data.remote.MovieDataSource
import com.movie.moviewithpager.data.remote.MovieDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {

    @Singleton
    @Provides
    fun provideMovieDataSource(spectrumApi: SpectrumApi): MovieDataSource {
        return MovieDataSourceImpl(spectrumApi)
    }
}