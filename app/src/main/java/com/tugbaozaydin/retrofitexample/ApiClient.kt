package com.tugbaozaydin.retrofitexample

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private var retrofit:Retrofit? = null

    fun getClient(): Retrofit {
        if(retrofit == null){
            retrofit = Retrofit.Builder().baseUrl("https://624d4c0ed71863d7a815b024.mockapi.io/")
                .addConverterFactory(GsonConverterFactory.create()).build()
        }
        return retrofit as Retrofit
    }
}