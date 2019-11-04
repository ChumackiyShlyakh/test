package com.notyteam.bee.topics.my_places.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.notyteam.bee.R

class VPApiaryRecycleViewAdapter(
    private var context: Context,
    private var dataList: ArrayList<String>
) :
    RecyclerView.Adapter<VPApiaryRecycleViewAdapter.ViewHolder>() {
    override fun getItemCount(): Int {
        return dataList.size;
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.cardview_vp_apiary,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.tv_cardview_vp_apiary_status.text = dataList.get(position)
    }

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        var tv_cardview_vp_apiary_status: TextView = itemView!!.findViewById(R.id.tv_cardview_vp_apiary_status)
//        tv_cardview_vp_apiary_events
//        tv_cardview_vp_apiary_data_start
//        tv_cardview_vp_apiary_data_time_start
//        tv_cardview_vp_apiary_data_end
//        tv_cardview_vp_apiary_data_time_end
//        tv_cardview_vp_apiary_date_message
//        tv_cardview_vp_apiary_id
//        tv_cardview_vp_apiary_user_id
    }
}