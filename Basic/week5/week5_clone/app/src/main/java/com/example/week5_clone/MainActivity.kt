package com.example.week5_clone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Profile
import android.util.Log
import com.example.week5_clone.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().replace(R.id.framelayout,HomeFragment()).commit()
        binding.bottomNav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home->{
                    supportFragmentManager.beginTransaction().replace(R.id.framelayout,HomeFragment()).commit()
                    Log.d("test","home")
                }
                R.id.profile->{
                    supportFragmentManager.beginTransaction().replace(R.id.framelayout,ProfileFragment()).commit()
                    Log.d("test","profile")
                }
                R.id.setting->{
                    supportFragmentManager.beginTransaction().replace(R.id.framelayout,SettingFragment()).commit()
                    Log.d("test","setting")
                }
            }
            true
        }
    }
}