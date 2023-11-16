package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.myapplication.databinding.ActivityMainBinding
/* MutableLiveData 가변성 LiveData */
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var mutableLiveData: MutableLiveData<Int> = MutableLiveData(0)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.vm = this
        binding.btn.setOnClickListener {
            mutableLiveData.value = mutableLiveData.value!!.plus(1)
        }

        mutableLiveData.observe(this, Observer {
            binding.text.text = mutableLiveData.value.toString()
        })
    }
}