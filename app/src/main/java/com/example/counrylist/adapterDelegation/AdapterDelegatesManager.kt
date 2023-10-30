package com.example.counrylist.adapterDelegation

import android.view.ViewGroup
import androidx.collection.SparseArrayCompat
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class AdapterDelegatesManager<T>(vararg delegates: AdapterDelegate<T>) {
    private val delegates: SparseArrayCompat<AdapterDelegate<T>> = SparseArrayCompat()

    init {
        for (element in delegates)
            addDelegate(element)
    }

    fun addDelegate(delegate: AdapterDelegate<T>) {
        var viewType = delegates.size()
        while (delegates[viewType] != null) {
            viewType++
        }
        delegates.put(viewType, delegate)
    }

    fun onCreateViewHolder(parent: ViewGroup, viewType:Int): ViewHolder {
        val delegate: AdapterDelegate<T> = delegates[viewType] ?: throw NullPointerException("No AdapterDelegates for this viewType")

        return delegate.onCreateViewHolder(parent)
    }

    fun onBindViewHolder(items:List<T>, position:Int, holder:ViewHolder) {
        val delegate:AdapterDelegate<T> = delegates[holder.itemViewType] ?: throw NullPointerException("No delegate for item at position")

        delegate.onBindViewHolder(holder, items, position)
    }

}