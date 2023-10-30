package com.example.counrylist.ui.duffUtil

import androidx.recyclerview.widget.DiffUtil
import com.example.counrylist.adapterDelegation.DisplayableItem

class BaseDiffUtilItemCallback:DiffUtil.ItemCallback<DisplayableItem>() {
    override fun areItemsTheSame(oldItem: DisplayableItem, newItem: DisplayableItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: DisplayableItem, newItem: DisplayableItem): Boolean {
        return oldItem.equals(newItem)
    }
}