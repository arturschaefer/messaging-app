package com.schaefer.messagelist.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.schaefer.messagelist.R
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
        setupToolbar()
    }

    private fun setupToolbar() {
        // TODO receive this info before open messageList
        binding.includeToolbar.apply {
            textViewTitle.text = "Sarah"
            Glide.with(this@MessageListActivity)
                .load(R.drawable.sarah_sample)
                .placeholder(R.drawable.ic_account_circle_24)
                .apply(RequestOptions.circleCropTransform())
                .into(imageViewAvatar)
        }
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
