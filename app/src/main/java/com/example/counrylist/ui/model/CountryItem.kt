package com.example.counrylist.ui.model

import com.example.counrylist.adapterDelegation.DisplayableItem

data class CountryItem(val name: String, val countryId: Int, val flagResId: Int) : DisplayableItem {
    override val id: Int
        get() = this.hashCode()
}
