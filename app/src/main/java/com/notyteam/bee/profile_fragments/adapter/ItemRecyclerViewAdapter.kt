package com.notyteam.bee.profile_fragments.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.notyteam.bee.R
import java.util.ArrayList

internal class ItemRecyclerViewAdapter(
    private val context: Context,
    private val arrayList: ArrayList<String>
) :
    RecyclerView.Adapter<ItemRecyclerViewAdapter.ItemViewHolder>() {

    internal inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //        internal val itemLabel: TextView
        internal val tv_item_custom_row_layout_money_left: TextView
        internal val tv_item_custom_row_layout_money_sign: TextView
        internal val tv_item_custom_row_layout_user_name: TextView
        internal val tv_item_custom_row_layout_status: TextView
        internal val tv_item_custom_row_layout_date: TextView

        init {
            tv_item_custom_row_layout_money_left = itemView.findViewById<View>(R.id.tv_item_custom_row_layout_money_left) as TextView
            tv_item_custom_row_layout_money_sign = itemView.findViewById<View>(R.id.tv_item_custom_row_layout_money_sign) as TextView
            tv_item_custom_row_layout_user_name = itemView.findViewById<View>(R.id.tv_item_custom_row_layout_user_name) as TextView
            tv_item_custom_row_layout_status = itemView.findViewById<View>(R.id.tv_item_custom_row_layout_status) as TextView
            tv_item_custom_row_layout_date = itemView.findViewById<View>(R.id.tv_item_custom_row_layout_date) as TextView
        }
    }

    val LOG_TAG: String = "myLogs";
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_custom_row_layout, parent, false)
        Log.d(LOG_TAG, "ItemRecyclerViewAdapter onBindViewHolder: " + " ");
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.tv_item_custom_row_layout_money_left.text = arrayList[position]
//        holder.tv_item_custom_row_layout_money_sign.text = arrayList[position]
//        holder.tv_item_custom_row_layout_user_name.text = arrayList[position]
//        holder.tv_item_custom_row_layout_status.text = arrayList[position]
//        holder.tv_item_custom_row_layout_date.text = arrayList[position]

    }

    override fun getItemCount(): Int {
        return arrayList.size
    }
}
