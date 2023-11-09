package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        setCountText()

        binding.plus.setOnClickListener {
            viewModel.plus()
            setCountText()
        }
        binding.minus.setOnClickListener {
            viewModel.minus()
            setCountText()
        }

    }
    fun setCountText(){
        binding.text.text = viewModel.getCount().toString()
    }
}