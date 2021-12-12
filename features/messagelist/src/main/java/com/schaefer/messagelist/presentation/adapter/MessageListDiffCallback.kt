package com.schaefer.messagelist.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.schaefer.messagelist.domain.model.MessageText

internal class MessageListDiffCallback(
    private val oldList: List<MessageText>,
    private val newList: List<MessageText>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].hashCode() == newList[newItemPosition].hashCode()
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}
