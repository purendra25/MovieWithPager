package com.movie.moviewithpager.domain.usecase

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.movie.moviewithpager.data.api.ApiResult
import com.movie.moviewithpager.domain.model.Movie
import com.movie.moviewithpager.domain.model.MovieResponse

class MovieCategoryPagingSource(private val movieRepository: MovieByCategoryUseCase) :
    PagingSource<Int, Movie>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        val page = params.key ?: 1

        return try {
            val response = movieRepository.execute("now_playing", page).collect { values ->
                ApiResult.Success(values)
            }

            val movies = response as MovieResponse
            val prevKey = if (page == 1) null else page - 1
            val nextKey = if (movies.results.isEmpty()) null else page + 1
            LoadResult.Page(movies.results, prevKey, nextKey)

        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return null
    }
}