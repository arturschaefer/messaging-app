package com.schaefer.messagingapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import com.schaefer.messagelist.presentation.model.ChatInfoVO
import com.schaefer.messagelist.presentation.model.UserVO
import com.schaefer.messagingapp.databinding.ActivityMainBinding
import com.schaefer.navigation.BUNDLE_MESSAGE_LIST
import com.schaefer.navigation.MessageListNavigation
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val messageListNavigation: MessageListNavigation by inject()

    // TODO create a viewModel, repository and datasource to receive this data
    private val chatId = "f1ad1f33a32e609250ecc006dca617da"
    private val firstUserId = "723c4a9ca31c8016f44e59a459516cb4"
    private val secondUserId = "3a1bf6714ac13316ae700b8a20d2a099"
    private val firstUser = UserVO(userId = secondUserId, firstName = "Ronaldo", imageUrl = "")
    private val secondUser = UserVO(userId = firstUserId, firstName = "Sarah", imageUrl = "")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textViewFirstUser.setOnClickListener {
            messageListNavigation.openMessageList(
                context = this,
                bundle = bundleOf(
                    BUNDLE_MESSAGE_LIST to ChatInfoVO(
                        chatId,
                        firstUserId,
                        firstUser
                    )
                )
            )
        }
        binding.textViewSecondUser.setOnClickListener {
            messageListNavigation.openMessageList(
                context = this,
                bundle = bundleOf(
                    BUNDLE_MESSAGE_LIST to ChatInfoVO(
                        chatId,
                        secondUserId,
                        secondUser
                    )
                )
            )
        }
    }
}
