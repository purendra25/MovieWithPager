package com.movie.moviewithpager.data.remote

import com.movie.moviewithpager.data.api.MoviesApi
import com.movie.moviewithpager.domain.model.GenreMovieListResponse
import com.movie.moviewithpager.domain.model.MovieDetailsResponse
import com.movie.moviewithpager.domain.model.MovieResponse
import retrofit2.Response
import javax.inject.Inject

class MovieDataSourceImpl @Inject constructor(private var spectrumApi: MoviesApi) :
    MovieDataSource {
    override suspend fun getMovieByCategoryDataSource(
        movieCategory: String,
        page: Int
    ): Response<MovieResponse> {
        return spectrumApi.getMovieByCategory(movieCategory, page)
    }

    override suspend fun getMovieDetailsByIDDataSource(movieID: Int): Response<MovieDetailsResponse> {
        return spectrumApi.getMovieDetailsByID(movieID)
    }

    override suspend fun getGenreMovieListDataSource(): Response<GenreMovieListResponse> {
        return spectrumApi.getGenreMovieList()
    }

    override suspend fun getSearchMovieDataSource(query: String, page: Int): Response<MovieResponse> {
        return spectrumApi.getSearchMovie(query, page)
    }
}