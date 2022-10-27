package com.megs.tmdbclient.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.megs.tmdbclient.databinding.ActivityHomeBinding
import com.megs.tmdbclient.presentation.artists.ArtistsActivity
import com.megs.tmdbclient.presentation.movie.MoviesActivity
import com.megs.tmdbclient.presentation.tvshows.ShowsActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityHomeBinding.inflate(layoutInflater).also {
            binding = it
            setContentView(it.root)
        }

        binding.movieButton.setOnClickListener {
            val intent = Intent(this, MoviesActivity::class.java)
            startActivity(intent)
        }

        binding.tvButton.setOnClickListener {
            val intent = Intent(this, ShowsActivity::class.java)
            startActivity(intent)
        }

        binding.artistButton.setOnClickListener {
            val intent = Intent(this, ArtistsActivity::class.java)
            startActivity(intent)
        }
    }
}