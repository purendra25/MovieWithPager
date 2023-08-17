package com.movie.moviewithpager.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.movie.moviewithpager.data.api.ApiResult
import com.movie.moviewithpager.domain.model.GenreMovieListResponse
import com.movie.moviewithpager.domain.usecase.MovieGenreListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MovieGenreViewModel @Inject constructor(
    application: Application,
    private val movieGenreListUseCase: MovieGenreListUseCase,
) : AndroidViewModel(application) {

    private val _movieGenreResponse: MutableLiveData<ApiResult<GenreMovieListResponse>> =
        MutableLiveData()
    val movieGenreResponse: LiveData<ApiResult<GenreMovieListResponse>> =
        _movieGenreResponse


    fun getGenreLis() = viewModelScope.launch {
        _movieGenreResponse.value = ApiResult.Loading

        movieGenreListUseCase.execute().collect { values ->
            _movieGenreResponse.value = values
        }
    }
}

