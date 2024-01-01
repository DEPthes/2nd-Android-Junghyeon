package com.example.myapplication.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplication.entity.TextEntity

@Dao
interface TextDao {

    @Query("SELECT * FROM text_table")
    fun getAllData(): List<TextEntity>

    // 데이터 삽입시 primary key가 겹치면 덮어쓴다
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(text: TextEntity)

    @Query("DELETE FROM text_table")
    fun deleteAllData()
}