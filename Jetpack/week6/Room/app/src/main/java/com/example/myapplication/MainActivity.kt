package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.adapter.TextCustomAdapter
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.repository.TextRepositoryImpl

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var viewModelFactory: MainViewModelProviderFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val textRepository = TextRepositoryImpl(this)
        viewModelFactory = MainViewModelProviderFactory(textRepository)
        viewModel = ViewModelProvider(this,viewModelFactory)[MainViewModel::class.java]


        viewModel.getData()

        binding.btnInsert.setOnClickListener {
            viewModel.insertData(binding.etEdit.text.toString())
            binding.etEdit.setText("")
        }

        viewModel.textList.observe(this, Observer {
            val textCustomAdapter = TextCustomAdapter(it)
            binding.rv.adapter = textCustomAdapter
            binding.rv.layoutManager = LinearLayoutManager(this)
        })
        binding.btnGet.setOnClickListener {
            viewModel.getData()
        }
        binding.btnDelete.setOnClickListener {
            viewModel.removeData()
        }
    }
}