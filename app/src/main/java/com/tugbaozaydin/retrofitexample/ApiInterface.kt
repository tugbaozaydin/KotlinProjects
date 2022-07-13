package com.tugbaozaydin.retrofitexample

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("users")
    fun getUserData(): Call<List<User>>

}