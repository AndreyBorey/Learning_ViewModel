package com.andreyborey.learningviewmodel

import android.app.Application
import android.os.CountDownTimer
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel(application: Application, val text:String): AndroidViewModel(application) {

    val liveData = MutableLiveData<String>()


    fun startTimer(sec:Int){
        object : CountDownTimer(sec*1000.toLong(), 1000){
            override fun onTick(p0: Long) {
                liveData.value = (p0/1000).toString() + text
            }

            override fun onFinish() {
                Toast.makeText(getApplication(), "Hello! ${text}", Toast.LENGTH_SHORT).show()
            }

        }.start()

    }
}