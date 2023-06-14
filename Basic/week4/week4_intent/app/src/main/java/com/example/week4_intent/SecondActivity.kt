package com.example.week4_intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.week4_intent.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.textview.text = intent.getStringExtra("text").toString()
    }
}