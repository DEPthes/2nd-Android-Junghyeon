package com.example.week4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.week4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val TAG = "LifeCycle"
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            val intent = Intent(this,SecondActivity::class.java)
            startActivity(intent)
            finish()
        }

        Log.d("onCreate","onCreate 실행")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG,"onStart 실행")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"onResume 실행")
    }
    override fun onPause() {
        super.onPause()
        Log.d(TAG,"onPause 실행")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"onStop 실행")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"onDestroy 실행")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG,"onRestart 실행")
    }
}