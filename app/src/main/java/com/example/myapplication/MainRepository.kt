package com.example.myapplication

class MainRepository(private val retrofitService : RetrofitService) {
    fun getAllMovies() = retrofitService.getAllMovies()
}