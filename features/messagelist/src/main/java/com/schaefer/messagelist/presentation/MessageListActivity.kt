package com.schaefer.messagelist.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.schaefer.messagelist.R
import com.schaefer.messagelist.databinding.MessagingListActivityBinding
import com.schaefer.messagelist.presentation.model.ChatInfoVO
import com.schaefer.navigation.BUNDLE_MESSAGE_LIST
import com.schaefer.uishared.extensions.toast

internal class MessageListActivity : AppCompatActivity() {
    private lateinit var binding: MessagingListActivityBinding
    private val chatInfoVO: ChatInfoVO? by lazy {
        intent.extras?.getParcelable(BUNDLE_MESSAGE_LIST)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MessagingListActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        chatInfoVO?.let {
            supportFragmentManager.beginTransaction()
                .replace(
                    R.id.containerList,
                    MessageListFragment.newInstance(it)
                )
                .commitAllowingStateLoss()
        }

        setupClickListeners()
        setupToolbar()
    }

    private fun setupToolbar() {
        chatInfoVO?.sendTo?.let {
            binding.includeToolbar.apply {
                textViewTitle.text = it.firstName
                Glide.with(this@MessageListActivity)
                    .load(it.imageUrl)
                    .placeholder(R.drawable.placeholder_user)
                    .apply(RequestOptions.circleCropTransform())
                    .into(imageViewAvatar)
            }
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
