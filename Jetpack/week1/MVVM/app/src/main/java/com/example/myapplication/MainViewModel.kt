package com.example.myapplication

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel(){

    var model = Model(0)

    var count = MutableLiveData<Int>(model.count)

    fun clickButton(){
        model.plus()
        count.value = model.count
    }
}