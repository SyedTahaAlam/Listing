package com.example.productlisting.data.model

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import retrofit2.http.GET

interface Api {

    @GET("products")
     fun  getAllProduct(): Call<List<Product>>
//
//    @GET("products/categories")
//    suspend fun  getProuctByCategories(): Call<Song>

    companion object {
        operator fun invoke(): Api {
            return Retrofit.Builder()
                    .addConverterFactory(JacksonConverterFactory.create())
                    .baseUrl("https://fakestoreapi.com/")
                    .build()
                    .create(Api::class.java)
        }
    }

}