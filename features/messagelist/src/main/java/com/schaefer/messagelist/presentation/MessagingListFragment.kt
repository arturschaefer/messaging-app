package com.schaefer.messagelist.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.schaefer.messagelist.databinding.MessagingListFragmentBinding

internal class MessagingListFragment : Fragment() {

    private var _binding: MessagingListFragmentBinding? = null
    private val binding get() = _binding!!
//    private val messagingListViewModel: MessagingListViewModel by viewModel()

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
}
