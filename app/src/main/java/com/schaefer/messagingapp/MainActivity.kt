package com.schaefer.messagingapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.schaefer.messagingapp.databinding.ActivityMainBinding
import com.schaefer.navigation.MessageListNavigation
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val messageListNavigation: MessageListNavigation by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.helloWolrd.setOnClickListener {
            messageListNavigation.openMessageList(this)
            finish()
        }
    }
}
