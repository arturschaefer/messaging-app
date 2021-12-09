package com.schaefer.messagelist.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import com.schaefer.messagelist.databinding.MessagingListFragmentBinding
import com.schaefer.messagelist.presentation.adapter.MessageListAdapter
import com.schaefer.messagelist.presentation.model.MessageListVO
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

internal class MessageListFragment : Fragment() {

    private var _binding: MessagingListFragmentBinding? = null
    private val binding get() = _binding!!

    // TODO receive this value from argument or sharedViewModel
    private val messageListViewModel: MessageListViewModel by viewModel {
        parametersOf(MessageListVO("1234"))
    }
    private val messageListAdapter = MessageListAdapter()

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
        binding.includeSendMessageLayout.apply {
            buttonSendMessage.setOnClickListener {
                messageListViewModel.sendMessage("1234", this.editTextSendMessage.text.toString())
                editTextSendMessage.setText("")
            }
            buttonSendMessage.setOnLongClickListener { messageListViewModel.sendMessages() }
            editTextSendMessage.doAfterTextChanged {
                val pair = messageListViewModel.validateEditText(it.toString())
                buttonSendMessage.apply {
                    isClickable = pair.first
                    isEnabled = pair.first
                    alpha = pair.second
                }
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
}
