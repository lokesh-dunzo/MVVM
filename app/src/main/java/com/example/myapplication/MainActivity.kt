package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.databinding.AdapterMovieBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    lateinit var viewModel : MainViewModel
    val adaptor = MainAdaptor()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this, MyViewModelFactory(MainRepository(RetrofitService.getInstance()))).get(MainViewModel::class.java)
       // viewModel = ViewModelProvider(this , MyViewModelFactory(MainRepository(RetrofitService.retrofitService!!))).get(MainViewModel::class.java)

        binding.recyclerview.adapter = adaptor;

        viewModel.movieList.observe(this, Observer {
            adaptor.setMovieList(it);

        })
        viewModel.errorMessage.observe(this, Observer {

        })
        viewModel.getAllMovies()
    }
}