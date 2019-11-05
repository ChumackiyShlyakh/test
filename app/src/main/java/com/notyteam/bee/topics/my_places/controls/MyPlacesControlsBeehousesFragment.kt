package com.notyteam.bee.topics.my_places.controls

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import com.notyteam.bee.R
import com.notyteam.bee.topics.my_places.MyPlacesFragment
import com.notyteam.bee.topics.my_places.viewpager_fragments.VPApiaryFragment

class MyPlacesControlsBeehousesFragment : Fragment() {

    var imgbtn_fragment_myplaces_controls_beehouses_back: ImageButton? = null
    var btn_fragment_myplaces_controls_beehouses_apply: Button? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view: View? = inflater.inflate(R.layout.fragment_myplaces_controls_beehouses, container, false);

        imgbtn_fragment_myplaces_controls_beehouses_back = view?.findViewById(R.id.imgbtn_fragment_myplaces_controls_beehouses_back)
        btn_fragment_myplaces_controls_beehouses_apply = view?.findViewById(R.id.btn_fragment_myplaces_controls_beehouses_apply)

        imgbtn_fragment_myplaces_controls_beehouses_back?.setOnClickListener({
            fragmentManager?.beginTransaction()?.replace(R.id.fragment_container_main_activity,
                MyPlacesFragment())?.commit()
        })

        btn_fragment_myplaces_controls_beehouses_apply?.setOnClickListener({
            fragmentManager?.beginTransaction()?.replace(R.id.fragment_container_main_activity,
                MyPlacesFragment())?.commit()
        })

        return view
    }
}