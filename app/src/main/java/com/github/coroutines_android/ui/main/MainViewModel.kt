package com.github.coroutines_android.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.coroutines_android.util.getCurrentTimeMillis
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _welcomeMessage: MutableStateFlow<String> = MutableStateFlow(getCurrentTimeMillis())
    val welcomeMessage: StateFlow<String>
        get() = _welcomeMessage

    fun initWelcomeMessage() {
        viewModelScope.launch {
            repeat(20) {
                delay(1000)
                _welcomeMessage.emit("Hello World ${it}")
            }
        }
    }


}

// Learning
// ViewModel classes should prefer creating coroutines instead of exposing suspend functions to perform business logic.