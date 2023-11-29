package com.example.retrofit.network

import com.example.retrofit.model.ProductResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {

    @GET("products/{number}")
    suspend fun getPost1(
        @Path("number") number : Int
    ): Response<ProductResponse>
}