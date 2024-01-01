package com.example.myapplication

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.entity.TextEntity
import com.example.myapplication.repository.DBRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val dbRepository: DBRepository):  ViewModel() {


    // LiveData
    private var _textList = MutableLiveData<List<TextEntity>>()
    val textList: LiveData<List<TextEntity>>
        get() = _textList


    fun getData() = viewModelScope.launch(Dispatchers.IO) {
        _textList.postValue(dbRepository.getTextList())
    }

    fun insertData(text: String) = viewModelScope.launch(Dispatchers.IO) {
        dbRepository.insertTextData(text)
    }

    fun removeData() = viewModelScope.launch(Dispatchers.IO) {
        dbRepository.deleteTextData()
    }
}