package com.example.myapplication.repository

import com.example.myapplication.entity.TextEntity

interface DBRepository{
     fun getTextList(): List<TextEntity>
     fun insertTextData(text: String)
     fun deleteTextData()
}