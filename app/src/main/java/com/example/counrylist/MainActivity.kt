package com.example.counrylist

import android.graphics.drawable.GradientDrawable
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.counrylist.databinding.ActivityMainBinding
import com.example.counrylist.ui.CountriesAdapter
import com.example.counrylist.ui.model.CountryItem
import java.util.Collections


class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val hardcodedCountries = listOf(
        CountryItem("Afghanistan", 0, R.drawable.afghanistan),
        CountryItem("Albania", 1, R.drawable.albania),
        CountryItem("Armenia", 2, R.drawable.armenia),
        CountryItem("Australia", 3, R.drawable.australia),
        CountryItem("Belarus", 4, R.drawable.belarus),
        CountryItem("Brazil", 5, R.drawable.brazil),
        CountryItem("Bulgaria", 6, R.drawable.bulgaria),
        CountryItem("Canada", 7, R.drawable.canada),
        CountryItem("China", 8, R.drawable.china),
        CountryItem("Cuba", 9, R.drawable.cuba),
        CountryItem("Czechia", 10, R.drawable.czechia),
        CountryItem("Denmark", 11, R.drawable.denmark),
        CountryItem("Egypt", 12, R.drawable.egypt),
        CountryItem("Estonia", 13, R.drawable.estonia),
        CountryItem("Finland", 14, R.drawable.finland),
        CountryItem("France", 15, R.drawable.france),
        CountryItem("Germany", 16, R.drawable.germany),
        CountryItem("Greece", 17, R.drawable.greece),
        CountryItem("Hungary", 18, R.drawable.hungary),
        CountryItem("India", 19, R.drawable.india),
        CountryItem("Iran", 20, R.drawable.iran),
        CountryItem("Island", 21, R.drawable.island),
        CountryItem("Israel", 22, R.drawable.israel),
        CountryItem("Italy", 23, R.drawable.italy),
        CountryItem("Japan", 24, R.drawable.japan),
        CountryItem("Kazakhstan", 25, R.drawable.kazakhstan),
        CountryItem("Mexico", 26, R.drawable.mexico),
        CountryItem("New Zealand", 27, R.drawable.new_zealand),
        CountryItem("Norway", 28, R.drawable.norway),
        CountryItem("Russia", 29, R.drawable.russia),
    )

    private val binding by viewBinding(ActivityMainBinding::bind)
    private val adapter by lazy { CountriesAdapter() }

    override fun onStart() {
        super.onStart()

        adapter.setItems(hardcodedCountries)
        binding.recyclerView.adapter = adapter
        setUpItemDivider()
        setUpDragsAndDrops()
    }

    private fun setUpDragsAndDrops() {
        val itemTouchCallback =
            object : ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP or ItemTouchHelper.DOWN, 0) {
                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    target: RecyclerView.ViewHolder
                ): Boolean {
                    val fromPosition = viewHolder.adapterPosition
                    val toPosition = target.adapterPosition
                    Collections.swap(hardcodedCountries, fromPosition, toPosition)
                    recyclerView.adapter?.notifyItemMoved(fromPosition, toPosition)
                    return true
                }

                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {}
            }

        val itemTouchHelper = ItemTouchHelper(itemTouchCallback)
        itemTouchHelper.attachToRecyclerView(binding.recyclerView)
    }

    private fun setUpItemDivider() {
        val line = GradientDrawable(
            GradientDrawable.Orientation.BOTTOM_TOP,
            intArrayOf(-0x80809, -0x80809)
        )
        line.setColor(getColor(R.color.black))
        line.setSize(5, 5)
        val itemDecoration =
            DividerItemDecoration(applicationContext, DividerItemDecoration.VERTICAL)
        itemDecoration.setDrawable(line)
        binding.recyclerView.addItemDecoration(itemDecoration)
    }
}