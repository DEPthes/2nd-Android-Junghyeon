package com.example.week4_result

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.week4_result.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra("text",binding.edittext.text.toString())
            setResult(RESULT_OK,intent)
            finish()
        }
    }
}