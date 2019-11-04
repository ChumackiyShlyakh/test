package com.notyteam.bee.google_map_controls

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.notyteam.bee.R
import com.notyteam.bee.topics.google_map.fragment.GoogleMapsFragment
import kotlinx.android.synthetic.main.app_bar_main.*

class GoogleMapControlsFragment : Fragment() {

    private var imgbtn_fragment_google_maps_controls_back: ImageButton? = null
    private var btn_fragment_google_maps_controls_objects: Button? = null
    private var btn_fragment_google_maps_controls_events: Button? = null
    private var btn_fragment_google_maps_controls_apply: Button? = null
    private var btnGoogleObjectsTrueEventFalseClick: Boolean? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_google_maps_controls, container, false)

        imgbtn_fragment_google_maps_controls_back =
            view.findViewById(R.id.imgbtn_fragment_google_maps_controls_back)
        btn_fragment_google_maps_controls_objects =
            view.findViewById(R.id.btn_fragment_google_maps_controls_objects)
        btn_fragment_google_maps_controls_events =
            view.findViewById(R.id.btn_fragment_google_maps_controls_events)
        btn_fragment_google_maps_controls_apply =
            view.findViewById(R.id.btn_fragment_google_maps_controls_apply)

        imgbtn_fragment_google_maps_controls_back?.setOnClickListener({
            fragmentManager?.beginTransaction()?.replace(
                R.id.fragment_container_main_activity,
                GoogleMapsFragment()
            )?.commit()
            (activity as AppCompatActivity).toolbar_main_drawer?.visibility = View.VISIBLE
        })

        btn_fragment_google_maps_controls_objects?.setOnClickListener({
            btnGoogleObjectsTrueEventFalseClick = true
            isButtonObjectsTrueEventFalsClick()
        })

        btn_fragment_google_maps_controls_events?.setOnClickListener({
            btnGoogleObjectsTrueEventFalseClick = false
            isButtonObjectsTrueEventFalsClick()
        })

        btn_fragment_google_maps_controls_apply?.setOnClickListener({
            fragmentManager?.beginTransaction()?.replace(
                R.id.fragment_container_main_activity,
                GoogleMapsFragment()
            )?.commit()
            (activity as AppCompatActivity).toolbar_main_drawer?.visibility = View.VISIBLE
        })

        return view
    }

    private fun isButtonObjectsTrueEventFalsClick(){
        if(btnGoogleObjectsTrueEventFalseClick!!){
            btn_fragment_google_maps_controls_events?.setBackgroundResource(R.drawable.ed_border_grey)
            btn_fragment_google_maps_controls_events?.setTextColor(getResources().getColor(R.color.black))
            btn_fragment_google_maps_controls_objects?.setBackgroundResource(R.drawable.button_orange)
            btn_fragment_google_maps_controls_objects?.setTextColor(getResources().getColor(R.color.white))
        } else {
            btn_fragment_google_maps_controls_events?.setBackgroundResource(R.drawable.button_orange)
            btn_fragment_google_maps_controls_events?.setTextColor(getResources().getColor(R.color.white))
            btn_fragment_google_maps_controls_objects?.setBackgroundResource(R.drawable.ed_border_grey)
            btn_fragment_google_maps_controls_objects?.setTextColor(getResources().getColor(R.color.black))
        }
    }
}