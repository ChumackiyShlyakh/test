package com.notyteam.bee.topics.my_places.controls

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.notyteam.bee.R
import com.notyteam.bee.topics.my_places.MyPlacesFragment
import com.notyteam.bee.topics.my_places.viewpager_fragments.VPObjectsFragment
import com.notyteam.bee.utils.OnBackPressed
import kotlinx.android.synthetic.main.app_bar_main.*

class MyPlacesControlsObjectFragment : Fragment(), OnBackPressed {

    var imgbtn_fragment_myplaces_controls_object_back: ImageButton? = null
    var btn_fragment_myplaces_controls_object_applay: Button? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view: View? =
            inflater.inflate(R.layout.fragment_myplaces_controls_objects, container, false);

        imgbtn_fragment_myplaces_controls_object_back = view?.findViewById(R.id.imgbtn_fragment_myplaces_controls_object_back)
        btn_fragment_myplaces_controls_object_applay = view?.findViewById(R.id.btn_fragment_myplaces_controls_object_applay)

        imgbtn_fragment_myplaces_controls_object_back?.setOnClickListener({
            fragmentManager?.beginTransaction()?.replace(R.id.fragment_container_main_activity,
                VPObjectsFragment())?.commit()
            (activity as AppCompatActivity).toolbar_main_drawer?.visibility = View.VISIBLE
        })

        btn_fragment_myplaces_controls_object_applay?.setOnClickListener({
            fragmentManager?.beginTransaction()?.replace(R.id.fragment_container_main_activity,
                VPObjectsFragment())?.commit()
            (activity as AppCompatActivity).toolbar_main_drawer?.visibility = View.VISIBLE
        })

        return view
    }

    override fun onBackPressed() {
        fragmentManager?.beginTransaction()?.replace(
            R.id.fragment_container_main_activity,
            MyPlacesFragment()
        )?.commit()
        (activity as AppCompatActivity).toolbar_main_drawer?.visibility = View.VISIBLE
    }
}