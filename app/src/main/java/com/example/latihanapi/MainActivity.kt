package com.example.latihanapi

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.latihanapi.databinding.ActivityMainBinding
import com.example.latihanapi.model.Movie
import com.example.latihanapi.model.Result
import com.example.latihanapi.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    private val listMovie = mutableListOf<Result>()
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getMovie()
    }

    fun getMovie() {
        RetrofitClient.instance.getPopularMovies(
            apiKey = "e73ba4baa44323fa06e5497760f26ab5",
            page = 1
        ).enqueue(object : Callback<Movie<Result>>{
            override fun onResponse(call: Call<Movie<Result>>, response: Response<Movie<Result>>) {
                if (response.isSuccessful){
                    binding.rvcon.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
                    val movieresponse = response.body()
                    if(movieresponse != null){
                        listMovie.addAll(movieresponse.results)
                        binding.rvcon.adapter = MovieAdapter(listMovie)
                    }
                }else{
                    Toast.makeText(this@MainActivity, "Failed LOAD DATA", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<Movie<Result>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Failed LOAD DATA", Toast.LENGTH_SHORT).show()
            }

        })


    }
}




