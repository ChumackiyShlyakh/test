package com.notyteam.bee.topics.my_places.controls

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import com.notyteam.bee.R
import com.notyteam.bee.topics.my_places.viewpager_fragments.VPEventsFragment

class MyPlacesControlsEventsFragment : Fragment() {

    var imgbtn_fragment_myplaces_controls_events_back: ImageButton? = null
    var btn_fragment_myplaces_controls_events_apply: ImageButton? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view: View? =
            inflater.inflate(R.layout.fragment_myplaces_controls_events, container, false);

        imgbtn_fragment_myplaces_controls_events_back = view?.findViewById(R.id.imgbtn_fragment_myplaces_controls_events_back)
        btn_fragment_myplaces_controls_events_apply = view?.findViewById(R.id.btn_fragment_myplaces_controls_events_apply)

        imgbtn_fragment_myplaces_controls_events_back?.setOnClickListener({
            fragmentManager?.beginTransaction()?.replace(R.id.fragment_container_main_activity,
                VPEventsFragment())?.commit()
        })

        btn_fragment_myplaces_controls_events_apply?.setOnClickListener({
            fragmentManager?.beginTransaction()?.replace(R.id.fragment_container_main_activity,
                VPEventsFragment())?.commit()
        })

        return view
    }
}