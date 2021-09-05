package com.andreyborey.learningviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.andreyborey.learningviewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel
    private lateinit var observer: Observer<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel = ViewModelProvider(this, MainFactory(application, "Some text")).get(MainViewModel::class.java)
        observer = Observer<String> {
            binding.textView1.text = it
        }
    }

    override fun onStart() {
        super.onStart()
        mainViewModel.startTimer(5)
        mainViewModel.liveData.observe(this, observer)
    }

    override fun onStop() {
        super.onStop()
        mainViewModel.liveData.removeObserver(observer)
    }
}