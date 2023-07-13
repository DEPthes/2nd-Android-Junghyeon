package com.example.week8

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.week8.DetailActivity
import com.example.week8.GVAdapter
import com.example.week8.ProductData
import com.example.week8.ProductResponse
import com.example.week8.RetrofitBuilder
import com.example.week8.RetrofitService
import com.example.week8.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var retrofit: Retrofit
    private lateinit var myAPI: RetrofitService
    private var dataList: ArrayList<ProductData> = arrayListOf()
    private lateinit var dataAdapter: GVAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        setRetrofit()
        getAllProduct()

    }

    private fun setRetrofit() {
        retrofit = RetrofitBuilder.getInstnace()
        myAPI = retrofit.create(RetrofitService::class.java)
    }

    private fun getAllProduct() {
        myAPI.getProduct().enqueue(object : Callback<ProductResponse> {
            override fun onResponse(
                call: Call<ProductResponse>,
                response: Response<ProductResponse>
            ) {
                Log.d("Response", "success")
                runOnUiThread {
                    for (i in 0 until response.body()!!.products.size) {
                        dataList.add(response.body()!!.products[i])
                    }
                    setAdapter()
                    clickImage()
                }
            }

            override fun onFailure(call: Call<ProductResponse>, t: Throwable) {
                Log.d("Response", t.toString())
            }

        })
    }

    private fun setAdapter() {
        dataAdapter = GVAdapter(this,dataList)
        binding.gvMain.adapter = dataAdapter
    }

    private fun clickImage() {
        dataAdapter.setOnItemClickListener(object : GVAdapter.OnItemClickListener {
            override fun onItemClick(v: View, data: ProductData, position: Int) {
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra("product",data)
                startActivity(intent)
            }
        })
    }
}