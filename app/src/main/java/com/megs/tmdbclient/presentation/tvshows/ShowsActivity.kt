package com.megs.tmdbclient.presentation.tvshows

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.megs.tmdbclient.R
import com.megs.tmdbclient.data.model.movie.Movie
import com.megs.tmdbclient.data.model.tvshow.TVShow
import com.megs.tmdbclient.databinding.ActivityShowsBinding
import com.megs.tmdbclient.presentation.di.Injector
import com.megs.tmdbclient.presentation.movie.MovieAdapter
import com.megs.tmdbclient.presentation.movie.MovieViewModel
import javax.inject.Inject

class ShowsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityShowsBinding
    @Inject
    lateinit var factory: ShowsViewModelFactory
    private lateinit var viewModel: ShowsViewModel
    private lateinit var adapter: ShowAdapter
    private var listOfMovies = ArrayList<TVShow>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityShowsBinding.inflate(layoutInflater).also {
            binding = it
            setContentView(it.root)
        }

        (application as Injector).createShowsSubcomponent().inject(this)

        viewModel = ViewModelProvider(this, factory)[ShowsViewModel::class.java]

        initRecyclerView()


    }

    private fun initRecyclerView() {
        binding.moviesRv.layoutManager = LinearLayoutManager(this)
//        binding.moviesRv.layoutManager = GridLayoutManager(this, 2)
        adapter = ShowAdapter(listOfMovies)
        binding.moviesRv.adapter = adapter

        displayPopularShows()

    }

    private fun displayPopularShows() {
        binding.progressBar.visibility = View.VISIBLE
        val responseLiveData = viewModel.getShows();
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
        val response = viewModel.updateShows();
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