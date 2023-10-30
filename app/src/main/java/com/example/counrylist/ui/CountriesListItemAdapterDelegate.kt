package com.example.counrylist.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.counrylist.adapterDelegation.DisplayableItem
import com.example.counrylist.adapterDelegation.ListItemAdapterDelegate
import com.example.counrylist.databinding.CountryItemBinding
import com.example.counrylist.ui.model.CountryItem

internal class CountriesListItemAdapterDelegate :
    ListItemAdapterDelegate<CountryItem, DisplayableItem, CountriesListItemAdapterDelegate.CountryViewHolder>() {


    inner class CountryViewHolder(private val binding: CountryItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(country: CountryItem) {
            with(binding) {
                countryImage.setImageResource(country.flagResId)
                countryName.text = country.name
                idNumber.text = country.countryId.toString()
            }
        }
    }

    override fun isForViewType(item: DisplayableItem): Boolean {
        return item is CountryItem
    }

    override fun onCreateViewHolder(parent: ViewGroup): CountryViewHolder {
        val binding = CountryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CountryViewHolder(binding)
    }

    override fun onBindViewHolder(
        item: CountryItem,
        holder: CountryViewHolder
    ) {
        holder.bind(item)
    }
}