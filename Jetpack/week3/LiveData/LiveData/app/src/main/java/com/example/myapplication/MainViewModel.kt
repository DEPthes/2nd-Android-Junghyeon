package com.example.myapplication

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    // LiveData 캡슐화
    // MutableLiveData는 ViewModel 내부에서 get / set 이 가능 (읽기, 쓰기)
    // LiveData는 외부에서 get 이 가능 (읽기)

    private var _data: MutableLiveData<Int> = MutableLiveData(10)
    val data: LiveData<Int> get() = _data!!


    fun plus(){
        _data.value = _data.value!!.plus(1)
        Log.d("Mutable Live Data",_data.value.toString())
        Log.d("Live Data",data.value.toString())
    }

    fun minus(){
        _data.value = _data.value!!.minus(1)
        Log.d("Mutable Live Data",_data.value.toString())
        Log.d("Live Data",data.value.toString())
    }
}