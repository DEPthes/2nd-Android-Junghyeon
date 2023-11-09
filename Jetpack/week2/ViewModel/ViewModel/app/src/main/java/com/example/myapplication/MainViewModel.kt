package com.example.myapplication

import android.util.Log
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private var count = 0

    fun plus(){
        count ++
        Log.d("plus()","count = ${count}")
    }
    fun minus(){
        count --
        Log.d("minus()","count = ${count}")
    }
    fun getCount(): Int{
        return count
    }
}