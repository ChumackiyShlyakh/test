package com.notyteam.bee.topics.my_places.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.notyteam.bee.R

class VPBeehousesRecycleViewAdapter(
    private var context: Context,
    private var dataList: ArrayList<String>
) :
    RecyclerView.Adapter<VPBeehousesRecycleViewAdapter.ViewHolder>() {
    override fun getItemCount(): Int {
        return dataList.size;
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.cardview_vp_beehouses,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.textView.text = dataList.get(position);
//        holder.textView.setOnClickListener({ holder.textView.setMaxLines(Int.MAX_VALUE) })

        holder.tv_cardview_vp_text.text = dataList.get(position);
        holder.tv_cardview_vp_text.setOnClickListener({ holder.tv_cardview_vp_text.setMaxLines(Int.MAX_VALUE) })
    }

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        //        var textView: TextView = itemView!!.findViewById(R.id.tv_recyclerview)
        var tv_cardview_vp_text: TextView = itemView!!.findViewById(R.id.tv_cardview_vp_text)
//        var ll_cardview_vp_open: LinearLayout = itemView!!.findViewById(R.id.ll_cardview_vp_open)
    }
}