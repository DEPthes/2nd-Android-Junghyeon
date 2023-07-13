package com.example.week8
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface RetrofitService {
    @Headers("Content-Type: application/json")
    @GET("/products")
    fun getProduct(): Call<ProductResponse>
}