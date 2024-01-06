package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map

class MainViewModel : ViewModel() {

    private val _state = MutableLiveData<Int>(0)
    val state: LiveData<Int> = _state

    val batteryState: LiveData<BatteryState> = _state.map {
        when {
            it == 100 -> {
                BatteryState.FULL
            }

            it > 60 -> {
                BatteryState.HIGH
            }

            it > 20 -> {
                BatteryState.LOW
            }

            else -> {
                BatteryState.CRITICAL
            }
        }
    }

    fun statePlus() {
        _state.value = _state.value?.plus(10)
    }
}

enum class BatteryState {
    FULL,
    HIGH,
    LOW,
    CRITICAL
}