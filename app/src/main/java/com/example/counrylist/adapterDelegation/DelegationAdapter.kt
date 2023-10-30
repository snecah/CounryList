package com.example.counrylist.adapterDelegation

import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

abstract class DelegationAdapter<T>(private val callback: ItemCallback<T>,
) : RecyclerView.Adapter<ViewHolder>() {

    private val differ by  lazy{ AsyncListDiffer(this, callback)}

    val delegatesManager = AdapterDelegatesManager<T>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return delegatesManager.onCreateViewHolder(parent, viewType)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        return delegatesManager.onBindViewHolder(differ.currentList, position, holder)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    fun setItems(items: List<T>) {
        differ.submitList(items)
    }

}