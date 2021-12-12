package com.schaefer.messagelist.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import com.schaefer.messagelist.databinding.MessagingListFragmentBinding
import com.schaefer.messagelist.presentation.adapter.MessageListAdapter
import com.schaefer.messagelist.presentation.model.ChatInfoVO
import com.schaefer.navigation.BUNDLE_MESSAGE_LIST
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

internal class MessageListFragment : Fragment() {

    private var _binding: MessagingListFragmentBinding? = null
    private val binding get() = _binding!!

    private val chatInfoVO: ChatInfoVO by lazy {
        arguments?.getParcelable<ChatInfoVO>(BUNDLE_MESSAGE_LIST) as ChatInfoVO
    }
    private val messageListViewModel: MessageListViewModel by viewModel { parametersOf(chatInfoVO) }
    private val messageListAdapter: MessageListAdapter by lazy {
        MessageListAdapter(chatInfoVO.sendByUserId)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MessagingListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupListeners()
        setupObservers()
    }

    private fun setupListeners() {
        validateButtonState()
        binding.includeSendMessageLayout.apply {
            buttonSendMessage.setOnClickListener {
                messageListViewModel.sendMessage(editTextSendMessage.text.toString())
                editTextSendMessage.setText("")
            }
            editTextSendMessage.doAfterTextChanged {
                validateButtonState(it.toString())
            }
        }
    }

    private fun validateButtonState(value: String = "") {
        val pair = messageListViewModel.validateEditText(value)
        binding.includeSendMessageLayout.apply {
            buttonSendMessage.apply {
                isEnabled = pair.first
                alpha = pair.second
            }
        }
    }

    private fun setupRecyclerView() {
        binding.recyclerViewMessages.apply {
            adapter = messageListAdapter
        }
    }

    private fun setupObservers() {
        messageListViewModel.messageList.observe(viewLifecycleOwner) {
            messageListAdapter.messageList = it
            binding.recyclerViewMessages.smoothScrollToPosition(it.size)
        }
    }

    companion object {
        fun newInstance(chatInfoVO: ChatInfoVO): MessageListFragment {
            return MessageListFragment().apply {
                arguments = bundleOf(BUNDLE_MESSAGE_LIST to chatInfoVO)
            }
        }
    }
}
