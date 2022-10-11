package com.example.recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null
    private var movieAdapter:MovieAdapter? = null
    private var movies:ArrayList<MovieModel>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        movies = ArrayList<MovieModel>()

        movies?.add(MovieModel(R.drawable.shreck1,getString(R.string.shreck1), getString(R.string.Long1),
            getString(R.string.shreck1Actors),getString(R.string.shreck1Rating)))
        movies?.add(
            MovieModel(R.drawable.shreck2, getString(R.string.shreck2), getString(R.string.Long2),
                getString(R.string.shreck2Actors), getString(R.string.shreck2Rating))
        )
        movies?.add(
            MovieModel(R.drawable.shreck3, getString(R.string.shreck3), getString(R.string.Long3),
                getString(R.string.shreck3Actors), getString(R.string.shreck3Rating))
        )
        movies?.add(
            MovieModel(R.drawable.shreck4, getString(R.string.shreck4), getString(R.string.Long4),
                getString(R.string.shreck4Actors), getString(R.string.shreck4Rating))
        )
        movies?.add(
            MovieModel(R.drawable.shreck5, getString(R.string.shreck5), getString(R.string.Long5),
                getString(R.string.shreck1Actors), getString(R.string.shreck5Rating))
        )
        movies?.add(
            MovieModel(R.drawable.shreck6, getString(R.string.shreck6), getString(R.string.Long6),
                getString(R.string.shreck6Actors), getString(R.string.shreck6Rating))
        )
        movies?.add(
            MovieModel(R.drawable.shreck7, getString(R.string.shreck7), getString(R.string.Long7),
                getString(R.string.shreck7Actors), getString(R.string.shreck7Rating))
        )
        movies?.add(
            MovieModel(R.drawable.shreck8, getString(R.string.shreck8), getString(R.string.Long8),
                getString(R.string.shreck8Actors), getString(R.string.shreck8Rating))
        )

        binding?.catalogMovies?.layoutManager = LinearLayoutManager(this)
        movieAdapter = MovieAdapter({movieModel: MovieModel->action(movieModel)}, movies!!)
        binding?.catalogMovies?.adapter = movieAdapter

    }


    private fun action(movieModel: MovieModel) {

        val detailsMovie = DetailsMovie()
        val parameters = Bundle()
        parameters.putString("nameMovie", movieModel.nameMovie)
        parameters.putString("longMovie", movieModel.longMovie)
        parameters.putString("actorsMovie", movieModel.actorsMovie)
        parameters.putString("ratingMovie", movieModel.ratingMovie)

        detailsMovie.arguments = parameters

        detailsMovie.show(supportFragmentManager, "details")

    }


}