package com.example.myapplication

import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    var count = 0

    fun plus(){
        count ++
    }
}