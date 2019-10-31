package com.notyteam.bee.profile_fragments.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.notyteam.bee.R
import com.notyteam.bee.profile_fragments.adapter.model.SectionModel
import java.util.ArrayList

class SectionRecyclerViewAdapter(
    private val context: Context,
    private val sectionModelArrayList: ArrayList<SectionModel>
) :
    RecyclerView.Adapter<SectionRecyclerViewAdapter.SectionViewHolder>() {

    val LOG_TAG: String = "myLogs";

    inner class SectionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var sectionLabel: TextView? = null
        var showAllButton: TextView? = null
        var itemRecyclerView: RecyclerView? = null

        init {
            sectionLabel = itemView.findViewById(R.id.section_label) as TextView
//            showAllButton = itemView.findViewById(R.id.section_show_all_button) as TextView
            itemRecyclerView = itemView.findViewById(R.id.item_recycler_view) as RecyclerView
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SectionViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.section_custom_row_layout, parent, false)
        Log.d(LOG_TAG, "SectionRecyclerViewAdapter onCreateViewHolder: " + " ");
        return SectionViewHolder(view)
    }

    override fun onBindViewHolder(holder: SectionViewHolder, position: Int) {
        val sectionModel = sectionModelArrayList[position]
        holder.sectionLabel?.setText(sectionModel.sectionLabel)

        //recycler view for items
        holder.itemRecyclerView?.setHasFixedSize(true)
        holder.itemRecyclerView?.isNestedScrollingEnabled = false

        Log.d(LOG_TAG, "SectionRecyclerViewAdapter onBindViewHolder: " + " ");

        val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        holder.itemRecyclerView?.layoutManager = linearLayoutManager

        val adapter = ItemRecyclerViewAdapter(context, sectionModel.itemArrayList)
        holder.itemRecyclerView?.adapter = adapter

        //show toast on click of show all button
//        holder.showAllButton?.setOnClickListener {
//            Toast.makeText(
//                context,
//                "You clicked on Show All of : " + sectionModel.sectionLabel,
//                Toast.LENGTH_SHORT
//            ).show()
//        }
    }

    override fun getItemCount(): Int {
        return sectionModelArrayList.size
    }
}
