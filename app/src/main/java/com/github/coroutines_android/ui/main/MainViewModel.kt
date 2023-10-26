package com.github.coroutines_android.ui.main

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    fun getHello(): String {
        return "Hello"
    }
}