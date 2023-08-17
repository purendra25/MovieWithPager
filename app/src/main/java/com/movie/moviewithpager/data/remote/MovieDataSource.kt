package com.movie.moviewithpager.data.remote

import com.movie.moviewithpager.domain.model.GenreMovieListResponse
import com.movie.moviewithpager.domain.model.MovieDetailsResponse
import com.movie.moviewithpager.domain.model.MovieResponse
import retrofit2.Response

interface MovieDataSource {
    suspend fun getMovieByCategoryDataSource(movieCategory: String, page: Int): Response<MovieResponse>
    suspend fun getMovieDetailsByIDDataSource(movieID: Int): Response<MovieDetailsResponse>
    suspend fun getGenreMovieListDataSource(): Response<GenreMovieListResponse>
    suspend fun getSearchMovieDataSource(query: String, page: Int): Response<MovieResponse>
}