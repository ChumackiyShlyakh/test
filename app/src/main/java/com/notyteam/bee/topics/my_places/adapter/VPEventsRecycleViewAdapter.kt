package com.notyteam.bee.topics.my_places.adapter

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.notyteam.bee.R
import kotlinx.android.synthetic.main.dialog_myplaces_bottom.*

class VPEventsRecycleViewAdapter(
    private var context: Context,
    private var dataList: ArrayList<String>
) :
    RecyclerView.Adapter<VPEventsRecycleViewAdapter.ViewHolder>() {
    override fun getItemCount(): Int {
        return dataList.size;
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.cardview_vp_events,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tv_cardview_vp_object_text.text = dataList.get(position)

        holder.imgbtn_cardview_vp_events_controls.setOnClickListener({ v ->

            val dialog = Dialog(v.rootView.context)
            dialog.setCancelable(true)
            dialog.setContentView(R.layout.dialog_myplaces_bottom)
            dialog.show()

            val window = dialog.getWindow()
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            window?.setLayout(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
            )
            window?.setGravity(Gravity.BOTTOM)

            var ll_dialog_myplaces_bottom_edit =
                dialog.ll_dialog_myplaces_bottom_edit.findViewById<LinearLayout>(R.id.ll_dialog_myplaces_bottom_edit)
            var ll_dialog_myplaces_bottom_archive =
                dialog.ll_dialog_myplaces_bottom_archive.findViewById<LinearLayout>(R.id.ll_dialog_myplaces_bottom_archive)
            var ll_dialog_myplaces_bottom_delete =
                dialog.ll_dialog_myplaces_bottom_delete.findViewById<LinearLayout>(R.id.ll_dialog_myplaces_bottom_delete)

            ll_dialog_myplaces_bottom_edit.setOnClickListener {
                dialog.dismiss()
            }
            ll_dialog_myplaces_bottom_archive.setOnClickListener {
                dialog.dismiss()
            }
            ll_dialog_myplaces_bottom_delete.setOnClickListener {
                dialog.dismiss()
            }
        })
    }

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        var tv_cardview_vp_object_text: TextView =
            itemView!!.findViewById(R.id.tv_cardview_vp_object_text)
        var imgbtn_cardview_vp_events_controls: ImageButton =
            itemView!!.findViewById(R.id.imgbtn_cardview_vp_events_controls)
//        iv_cardview_vp_events_object
//        tv_cardview_vp_events_name
//        iv_cardview_vp_events_maps_flags
//        tv_cardview_vp_object_text
//        tv_cardview_vp_object_status
//        tv_cardview_vp_events_latitude_numbers
//        tv_cardview_vp_events_longitude_numbers
//        tv_cardview_vp_events_data_start
//        tv_cardview_vp_events_data_end
//        tv_cardview_vp_events_user_id
    }
}