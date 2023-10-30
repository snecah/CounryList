package com.example.counrylist.ui

import com.example.counrylist.adapterDelegation.DelegationAdapter
import com.example.counrylist.adapterDelegation.DisplayableItem
import com.example.counrylist.ui.duffUtil.BaseDiffUtilItemCallback

class CountriesAdapter(
) : DelegationAdapter<DisplayableItem>(BaseDiffUtilItemCallback()) {
    init {
        delegatesManager.addDelegate(CountriesListItemAdapterDelegate())
    }
}