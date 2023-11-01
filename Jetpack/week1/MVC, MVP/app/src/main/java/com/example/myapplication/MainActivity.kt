package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding

// MVP
class MainActivity : AppCompatActivity(),ViewInterface {

    private lateinit var binding: ActivityMainBinding

    var presenter = Presenter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            clickButton()
        }
    }
    private fun clickButton(){
       presenter.clickButton()
    }

    override fun toastMessage(i: Int) {
        Toast.makeText(this, "$i 번 클릭했습니다", Toast.LENGTH_LONG).show()
    }

    override fun plusCount(count: Int) {
        binding.textview.text = count.toString()
    }

}