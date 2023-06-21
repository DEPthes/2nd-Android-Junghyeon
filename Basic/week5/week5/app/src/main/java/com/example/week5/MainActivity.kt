package com.example.week5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.week5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.setOnClickListener {
            setFragmentFirst()
        }
        binding.button2.setOnClickListener {
            setFragmentSecond()
        }
    }
    private fun setFragmentFirst(){
        val transaction = supportFragmentManager.beginTransaction()
            .replace(R.id.framelayout,FirstFragment())
            .commit()
    }
    private fun setFragmentSecond(){
        val transaction = supportFragmentManager.beginTransaction()
            .replace(R.id.framelayout,SecondFragment())
            .commit()
    }
}