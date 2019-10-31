package com.notyteam.bee.topics.my_places.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ExpandableCardViewAdapter(var items: MutableList<Item>)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    data class Item(
        val type: Int = 0,
        var text: String = "Default",
        var children: List<Item>? = null
    )

    inner class ItemHolder(v: View) : RecyclerView.ViewHolder(v) {
//        var textView = v.item_text
//        val toggleImageView = v.item_toggle_button
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent?.context)
        var view: View? = null

        return ItemHolder(view!!)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val itemHolder = holder as? ItemHolder
        val item = items[position]

//        item_text = view.findViewById(R.id.item_text)
//        it.textView.setOnClickListener({ textView.setMaxLines(Integer.MAX_VALUE) })
    }

    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int): Int = items[position].type
}