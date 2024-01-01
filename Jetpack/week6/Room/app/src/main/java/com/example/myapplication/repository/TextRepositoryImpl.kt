package com.example.myapplication.repository

import android.content.Context
import com.example.myapplication.db.TextDatabase
import com.example.myapplication.entity.TextEntity

class TextRepositoryImpl(context: Context) : DBRepository {
    private val db = TextDatabase.getDatabase(context)

    override fun getTextList() = db.textDao().getAllData()

    override fun insertTextData(text: String) = db.textDao().insert(TextEntity(0, text))

    override fun deleteTextData() = db.textDao().deleteAllData()
}