package com.example.week8
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    private var instance: Retrofit? = null

    fun getInstnace(): Retrofit {
        if (instance == null) {
            instance = Retrofit.Builder()
                .baseUrl("https://dummyjson.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return instance!!
    }
}