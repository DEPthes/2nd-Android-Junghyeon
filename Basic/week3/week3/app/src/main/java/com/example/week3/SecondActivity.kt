package com.example.week3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.week3.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.imagebutton1.setOnClickListener {
            binding.imageview.setImageResource(R.drawable.image1)
        }
        binding.imagebutton2.setOnClickListener {
            binding.imageview.setImageResource(R.drawable.image2)

        }
        binding.imagebutton3.setOnClickListener {
            binding.imageview.setImageResource(R.drawable.image3)

        }
    }
}