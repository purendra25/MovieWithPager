package com.movie.moviewithpager.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.movie.moviewithpager.data.api.ApiResult
import com.movie.moviewithpager.domain.model.MovieDetailsResponse
import com.movie.moviewithpager.domain.usecase.MovieDetailsByIDUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MovieDetailsByIDViewModel @Inject constructor(
    application: Application,
    private val movieDetailsByIDUseCase: MovieDetailsByIDUseCase,
) : AndroidViewModel(application) {

    private val _movieDetailsResponse: MutableLiveData<ApiResult<MovieDetailsResponse>> =
        MutableLiveData()
    val movieDetailsResponse: LiveData<ApiResult<MovieDetailsResponse>> =
        _movieDetailsResponse


    fun getMovieDetailsByID(movieID: Int) = viewModelScope.launch {
        _movieDetailsResponse.value = ApiResult.Loading

        movieDetailsByIDUseCase.execute(movieID).collect { values ->
            _movieDetailsResponse.value = values
        }
    }
}

