package com.schaefer.messagelist.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.schaefer.messagelist.databinding.MessagingListFragmentBinding
import com.schaefer.messagelist.presentation.adapter.MessageListAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

internal class MessageListFragment : Fragment() {

    private var _binding: MessagingListFragmentBinding? = null
    private val binding get() = _binding!!
    private val messageListViewModel: MessageListViewModel by viewModel()
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
        val list = messageListViewModel.getMessageList()
        binding.recyclerViewMessages.apply {
            adapter = messageListAdapter
        }
        messageListAdapter.messageList = list
    }
}
