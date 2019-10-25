package com.notyteam.bee.google_map_controls

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.fragment.app.Fragment
import com.notyteam.bee.R
import com.notyteam.bee.core.arch.DialogCustomListView
import com.notyteam.bee.core.arch.DialogDataAdapter
import kotlinx.android.synthetic.main.dialog_custom_layout.*
import kotlinx.android.synthetic.main.fragment_google_maps_new_event.*
import kotlinx.android.synthetic.main.fragment_google_maps_new_object.*

class GoogleMapNewEventFragment : Fragment(), DialogDataAdapter.RecyclerViewItemClickListener {

    internal var customDialog: DialogCustomListView? = null
    var meaning: String = "meaning"

    var textItems = arrayOf("Сhemical treatment", "Flowering of honey plants")
    var imagesItems = intArrayOf(
        R.drawable.event_chemicals,
        R.drawable.event_flowering
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_google_maps_new_event, container, false)

        btn_google_maps_new_event_save.setOnClickListener {
            tv_dialogcustom.setText(R.string.choose_event)
            showItems(this) }

        return view
    }

    private fun showItems(view: GoogleMapNewEventFragment) {
        val dataAdapter = DialogDataAdapter(meaning, textItems, imagesItems, this)
        customDialog = activity?.let { DialogCustomListView(it, dataAdapter) }
        customDialog?.show()
        val window = customDialog?.getWindow()
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        window?.setLayout(
            RelativeLayout.LayoutParams.MATCH_PARENT,
            RelativeLayout.LayoutParams.MATCH_PARENT
        )
        customDialog?.setCanceledOnTouchOutside(false)
    }

    override fun clickOnItem(data: String) {
        btn_google_maps_new_object_save.text = data
        if (customDialog != null) {
            customDialog?.dismiss()
        }
    }

    override fun clickOnItemLanguage(data: String) {
    }
}