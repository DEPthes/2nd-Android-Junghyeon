package com.example.navigation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    private var _fruit = MutableLiveData<String>(" ")
    val fruit: LiveData<String>
        get() = _fruit

    private var _animal = MutableLiveData<String>(" ")
    val animal: LiveData<String>
        get() = _animal

    private var _color = MutableLiveData<String>(" ")
    val color: LiveData<String>
        get() = _color

    fun setFruit(value: String){
        _fruit.value = value
    }
    fun setAnimal(value: String){
        _animal.value = value
    }
    fun setColor(value: String){
        _color.value = value
    }
}