package com.movie.moviewithpager.data.repository

import com.movie.moviewithpager.data.api.ApiResult
import com.movie.moviewithpager.domain.model.GenreMovieListResponse
import com.movie.moviewithpager.domain.model.MovieDetailsResponse
import com.movie.moviewithpager.domain.model.MovieResponse
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    suspend fun getMovieByCategoryRepo(
        movieCategory: String,
        page: Int
    ): Flow<ApiResult<MovieResponse>>

    suspend fun getMovieDetailsByIDRepo(
        movieID: Int
    ): Flow<ApiResult<MovieDetailsResponse>>

    suspend fun getGenreMovieListRepo(): Flow<ApiResult<GenreMovieListResponse>>

    suspend fun getSearchMovieDataSource(
        query: String,
        page: Int
    ): Flow<ApiResult<MovieResponse>>


}