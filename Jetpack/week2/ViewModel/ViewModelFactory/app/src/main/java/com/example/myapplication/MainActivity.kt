package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding :ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var viewModelFactory: MainViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        viewModelFactory = MainViewModelFactory("Android")
        viewModel = ViewModelProvider(this,viewModelFactory)[MainViewModel::class.java]
        binding.vm = viewModel
    }
    // UI 레이어는 Activity, ViewModel
    // Domain Layer - > 비즈니스 로직 레포지토리 패턴을
    // Data Layer  Retrofit RoomDB
}