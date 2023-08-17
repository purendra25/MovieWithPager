package com.movie.moviewithpager.ui.features

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.movie.moviewithpager.data.api.ApiResult
import com.movie.moviewithpager.databinding.FragmentTopRatedBinding
import com.movie.moviewithpager.domain.model.Movie
import com.movie.moviewithpager.ui.adapter.MovieItemAdapter
import com.movie.moviewithpager.ui.viewmodel.MovieByCategoryViewModel
import com.movie.moviewithpager.utils.Constants
import com.movie.moviewithpager.utils.Constants.ARGUMENT_KEY_CATEGORY
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class TopRatedFragment : Fragment() {
    private var _binding: FragmentTopRatedBinding? = null
    private val binding get() = _binding!!
    private val movieByCategoryViewModel: MovieByCategoryViewModel by viewModels()
    private lateinit var movieItemAdapter: MovieItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTopRatedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val category = arguments?.getString(ARGUMENT_KEY_CATEGORY)

        if (!category.isNullOrEmpty()) {

            binding.apply {
                rvMovieList.visibility = View.VISIBLE

                val layoutManager = GridLayoutManager(requireActivity(), 2)
                rvMovieList.layoutManager = layoutManager
                rvMovieList.setHasFixedSize(true)

                movieItemAdapter = MovieItemAdapter(requireActivity())
                rvMovieList.adapter = movieItemAdapter

            }

            observeMovieByCategory()
            callMovieByCategoryAPI(category, 1)
        }
    }

    private fun callMovieByCategoryAPI(category: String, page: Int) {
        movieByCategoryViewModel.getMovieByCategory(category, page)
    }

    private fun observeMovieByCategory() {
        movieByCategoryViewModel.movieCategoryResponse.observe(this) { response ->

            when (response) {
                is ApiResult.Loading -> {}

                is ApiResult.Success -> {

                    if (!Objects.isNull(response.data)) {

                        response.data.let {
                            if (it.results.isNotEmpty()) {
                                showList(it.results)
                            }
                        }
                    }

                }
                is ApiResult.Error -> {}

            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun showList(results: List<Movie>) {

        binding.apply {
            rvMovieList.visibility = View.VISIBLE
            movieItemAdapter.jobList += results
            movieItemAdapter.notifyDataSetChanged()

            movieItemAdapter.onClick = { movieID ->
                val intent = Intent(context, MovieDetailsActivity::class.java)
                intent.putExtra(Constants.MOVIE_ID, movieID)
                startActivity(intent)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}