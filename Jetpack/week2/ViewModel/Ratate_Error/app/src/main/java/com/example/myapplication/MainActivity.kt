package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myapplication.databinding.ActivityMainBinding

// 화면 회전 테스트, 화면이 회전 되었을 때 LifeCycle
class MainActivity : AppCompatActivity() {
    val TAG = "LifeCycle"
    private lateinit var binding: ActivityMainBinding
    private var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.text.text = count.toString()

        binding.button.setOnClickListener {
            count ++
            binding.text.text = count.toString()
        }
    }

    override fun onStart() {
        Log.d(TAG,"onStart | count${count}")
        super.onStart()
    }

    override fun onResume() {
        Log.d(TAG,"onResume | count${count}")
        super.onResume()
    }

    override fun onPause() {
        Log.d(TAG,"onPause | count${count}")
        super.onPause()
    }

    override fun onStop() {
        Log.d(TAG,"onStop | count${count}")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d(TAG,"onDestroy | count${count}")
        super.onDestroy()
    }
}