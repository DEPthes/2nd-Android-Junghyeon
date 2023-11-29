package com.example.retrofit.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.retrofit.R
import com.example.retrofit.databinding.ActivityMainBinding
import com.example.retrofit.repository.ProductRepositoryImpl
import com.example.retrofit.viewModel.MainViewModel
import com.example.retrofit.viewModel.MainViewModelProviderFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var viewModelFactory: MainViewModelProviderFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val productRepository = ProductRepositoryImpl()
        viewModelFactory = MainViewModelProviderFactory(productRepository)
        viewModel = ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)
        binding.vm = viewModel


        binding.btnLoad.setOnClickListener {
            if(binding.etNum.text.toString() != ""){
                viewModel.getPost(Integer.parseInt(binding.etNum.text.toString()))
            }else{
                Toast.makeText(this,"숫자를 입력해주세요",Toast.LENGTH_SHORT).show()
            }
        }
        viewModel.image.observe(this, Observer {
            Glide.with(this).load(it).fitCenter().into(binding.ivImage)
        })
        viewModel.title.observe(this, Observer {
            binding.tvTitle.text = it.toString()
        })
        viewModel.description.observe(this, Observer {
            binding.tvBody.text = it.toString()
        })

    }

}