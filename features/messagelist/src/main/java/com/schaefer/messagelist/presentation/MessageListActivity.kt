package com.schaefer.messagelist.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.schaefer.messagelist.databinding.MessagingListActivityBinding
import com.schaefer.uishared.extensions.toast

internal class MessageListActivity : AppCompatActivity() {
    private lateinit var binding: MessagingListActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MessagingListActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.includeToolbar.apply {
            imageButtonBack.setOnClickListener { onBackPressed() }
            imageButtonMore.setOnClickListener { toast(message = "More options clicked") }
            imageViewAvatar.setOnClickListener { toast(message = "Image avatar clicked") }
            textViewTitle.setOnClickListener { toast(message = "Text title clicked") }
        }
    }
}
