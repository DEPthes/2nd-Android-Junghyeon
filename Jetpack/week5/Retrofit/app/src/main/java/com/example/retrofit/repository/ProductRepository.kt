package com.example.retrofit.repository

import com.example.retrofit.model.ProductResponse
import retrofit2.Response

interface ProductRepository {
    suspend fun getPost1(number: Int) : Response<ProductResponse>
}