package com.notyteam.bee.topics_beehouses_online.beehouses_online_gadgets_grafs.gadgets_grafs.tables.fragment.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.notyteam.bee.R

class MeaningTablesRecycleViewAdapter (
    private var context: Context,
    private var dataList: ArrayList<String>
) :
    RecyclerView.Adapter<MeaningTablesRecycleViewAdapter.ViewHolder>() {
    override fun getItemCount(): Int {
        return dataList.size;
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.cardview_fragment_meaning_tables,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.tv_fragment_meaning_tables_data.text = dataList.get(position)
        holder.tv_fragment_meaning_tables_meaning.text = dataList.get(position)

    }

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        //        var textView: TextView = itemView!!.findViewById(R.id.tv_recyclerview)
        var tv_fragment_meaning_tables_data: TextView = itemView!!.findViewById(R.id.tv_fragment_meaning_tables_data)
        var tv_fragment_meaning_tables_meaning: TextView = itemView!!.findViewById(R.id.tv_fragment_meaning_tables_meaning)
    }
}