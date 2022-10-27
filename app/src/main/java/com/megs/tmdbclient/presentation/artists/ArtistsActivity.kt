package com.megs.tmdbclient.presentation.artists

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.megs.tmdbclient.R
import com.megs.tmdbclient.data.model.artist.Artist
import com.megs.tmdbclient.data.model.tvshow.TVShow
import com.megs.tmdbclient.databinding.ActivityArtistsBinding
import com.megs.tmdbclient.databinding.ActivityShowsBinding
import com.megs.tmdbclient.presentation.di.Injector
import com.megs.tmdbclient.presentation.tvshows.ShowAdapter
import com.megs.tmdbclient.presentation.tvshows.ShowsViewModel
import com.megs.tmdbclient.presentation.tvshows.ShowsViewModelFactory
import javax.inject.Inject

class ArtistsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityArtistsBinding
    @Inject
    lateinit var factory: ArtistViewModelFactory
    private lateinit var viewModel: ArtistViewModel
    private lateinit var adapter: ArtistAdapter
    private var listOfMovies = ArrayList<Artist>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityArtistsBinding.inflate(layoutInflater).also {
            binding = it
            setContentView(it.root)
        }

        (application as Injector).createArtistsSubcomponent().inject(this)

        viewModel = ViewModelProvider(this, factory)[ArtistViewModel::class.java]

        initRecyclerView()


    }

    private fun initRecyclerView() {
        binding.moviesRv.layoutManager = LinearLayoutManager(this)
//        binding.moviesRv.layoutManager = GridLayoutManager(this, 2)
        adapter = ArtistAdapter(listOfMovies)
        binding.moviesRv.adapter = adapter

        displayPopularShows()

    }

    private fun displayPopularShows() {
        binding.progressBar.visibility = View.VISIBLE
        val responseLiveData = viewModel.getArtists();
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
        val response = viewModel.updateArtists();
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