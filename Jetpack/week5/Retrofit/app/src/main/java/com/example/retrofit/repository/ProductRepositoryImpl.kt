package com.example.retrofit.repository

import com.example.retrofit.model.ProductResponse
import com.example.retrofit.network.RetrofitInstance.api
import retrofit2.Response

class ProductRepositoryImpl: ProductRepository {
    override suspend fun getPost1(number: Int): Response<ProductResponse> {
        return api.getPost1(number)
    }
}