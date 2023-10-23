package com.abn.mymoviesabt

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.abn.mymoviesabt.databinding.ActivityMainBinding
import com.abn.mymoviesabt.model.MovieDBClient
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recycler.adapter = MoviesAdapter(
            listOf(
                Movie("Title 1", "https://loremflickr.com/320/240?lock=1"),
                Movie("Title 2", "https://loremflickr.com/320/240?lock=2"),
                Movie("Title 3", "https://loremflickr.com/320/240?lock=3"),
                Movie("Title 4", "https://loremflickr.com/320/240?lock=4"),
                Movie("Title 5", "https://loremflickr.com/320/240?lock=5"),
                Movie("Title 6", "https://loremflickr.com/320/240?lock=6"),
            )
        ) { movie ->
            Toast.makeText(
                this@MainActivity,
                movie.title,
                Toast.LENGTH_SHORT
            ).show()
        }

        thread {
            val apikey = getString(R.string.api_key)
            val popularMovies = MovieDBClient.service.listPopularMovies(apikey)
            val body = popularMovies.execute().body()
            if (body != null)  Log.d("MainActivity", "Movie count: ${body.results.size}" )
        }

        Log.d("MainActivity", "OnCreate")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d("MainActivity", "OnDetroy")
    }
}