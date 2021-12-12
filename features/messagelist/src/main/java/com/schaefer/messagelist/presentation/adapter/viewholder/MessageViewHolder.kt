package com.schaefer.messagelist.presentation.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.schaefer.messagelist.domain.model.MessageText

internal open class MessageViewHolder(view: ViewBinding) : RecyclerView.ViewHolder(view.root) {
    open fun bind(message: MessageText, hasTimeVisible: Boolean = false) {}
}
