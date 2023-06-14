package com.example.week4_result

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import com.example.week4_result.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val KEY = "RESULT_OK"
    lateinit var launcher: ActivityResultLauncher<Intent>
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
            if(result.resultCode == Activity.RESULT_OK){
                binding.textview.text = result.data?.getStringExtra("text")
            }
        }
        binding.button.setOnClickListener {
            val intent = Intent(this,SecondActivity::class.java)
            launcher.launch(intent)
        }

    }

}