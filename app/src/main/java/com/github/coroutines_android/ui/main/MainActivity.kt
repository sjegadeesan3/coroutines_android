package com.github.coroutines_android.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.github.coroutines_android.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModel()
    private val TAG: String = MainActivity::class.java.simpleName


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUi()
    }

    private fun initUi() {
        lifecycleScope.launch {
            viewModel.welcomeMessage
                .flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
                .collect {
                    //In viewmodel, stateflow will emit the value after 10s delay.
                    //During the emit, if application is in background then collect won't get called.
                    //Once app get in foreground then collect will be called
                    binding.welcomeMessage.text = it
                }
        }
        viewModel.initWelcomeMessage()
    }
}