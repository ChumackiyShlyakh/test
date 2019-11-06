package com.notyteam.bee.core.arch

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.notyteam.bee.R


class DialogCustomListView(var activity: Activity, internal var adapter: RecyclerView.Adapter<*>) : Dialog(activity),
    View.OnClickListener {
    var dialog: Dialog? = null

    internal var recyclerView: RecyclerView? = null
    private var layoutManager: RecyclerView.LayoutManager? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_custom_layout)

        recyclerView = findViewById(R.id.recycler_view_custom_dialog)
        layoutManager = LinearLayoutManager(activity)
        recyclerView?.layoutManager = layoutManager
        recyclerView?.adapter = adapter

//        radiobtn_item_bees?.setOnClickListener(this)
    }

    override fun onClick(v: View) {
//        when (v.id) {
////            R.id.yes -> {
////            }
////            R.id.no -> dismiss()
//            else -> {
//            }
//        }//Do Something
//        dismiss()
    }
}