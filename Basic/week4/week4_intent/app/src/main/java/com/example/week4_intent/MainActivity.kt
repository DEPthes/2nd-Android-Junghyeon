package com.example.week4_intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.week4_intent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            val intent = Intent(this,SecondActivity::class.java)
            intent.putExtra("text",binding.edittext.text.toString())
            startActivity(intent)
        }
    }
}