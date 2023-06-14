package com.example.week3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.week3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonToEdittext.setOnClickListener {
            binding.textview.text = binding.edittext.text
            binding.edittext.text = null
        }
        binding.buttonToActivity.setOnClickListener {
            val intent = Intent(this,SecondActivity::class.java)
            startActivity(intent)
        }
    }
}