package com.example.kotlin_study_sqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.kotlin_study_sqlite.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding :ActivityMainBinding
    lateinit var db : SQLiteHelperSample
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        db = SQLiteHelperSample(this)

        binding.insert.setOnClickListener {
            val inputText = binding.inputArea.text.toString()
            db.insert(inputText)
            binding.inputArea.setText("")
        }
        binding.getAll.setOnClickListener {
            val arr = db.getAllData()
            binding.resultArea.text = arr.toString()
        }
        binding.deleteAll.setOnClickListener {
            db.deleteAll()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        db.close()
    }
}