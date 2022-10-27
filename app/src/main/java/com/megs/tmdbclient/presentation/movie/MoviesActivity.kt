package com.megs.tmdbclient.presentation.movie

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.megs.tmdbclient.R
import com.megs.tmdbclient.data.model.movie.Movie
import com.megs.tmdbclient.databinding.ActivityMoviesBinding
import com.megs.tmdbclient.presentation.di.Injector
import javax.inject.Inject


class MoviesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMoviesBinding

    @Inject
    lateinit var factory: MovieViewModelFactory
    private lateinit var viewModel: MovieViewModel
    private lateinit var adapter: MovieAdapter
    private var listOfMovies = ArrayList<Movie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityMoviesBinding.inflate(layoutInflater).also {
            binding = it
            setContentView(it.root)
        }

        (application as Injector).createMoviesSubcomponent().inject(this)


        viewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]

        initRecyclerView()


    }

    private fun initRecyclerView() {
        binding.moviesRv.layoutManager = LinearLayoutManager(this)
//        binding.moviesRv.layoutManager = GridLayoutManager(this, 2)
        adapter = MovieAdapter(listOfMovies)
        binding.moviesRv.adapter = adapter

        displayPopularMovies()

    }

    private fun displayPopularMovies() {
        binding.progressBar.visibility = View.VISIBLE
        val responseLiveData = viewModel.getMovies();
        responseLiveData.observe(this) {
            if (it != null) {
                listOfMovies.addAll(it)
                adapter.notifyDataSetChanged()
            }

            binding.progressBar.visibility = View.GONE
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflator: MenuInflater = menuInflater
        inflator.inflate(R.menu.update, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.update) {
            updateMovies()
            return true
        }


        return super.onOptionsItemSelected(item)

    }

    private fun updateMovies() {
        binding.progressBar.visibility = View.VISIBLE
        val response = viewModel.updateMovies();
        response.observe(this, Observer {
            if (it != null) {
                listOfMovies.clear()
                listOfMovies.addAll(it)
                adapter.notifyDataSetChanged()
            }

            binding.progressBar.visibility = View.GONE
        })
    }
}