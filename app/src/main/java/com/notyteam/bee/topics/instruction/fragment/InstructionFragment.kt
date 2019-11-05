package com.notyteam.bee.topics.aboutus.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import com.notyteam.bee.R
import com.notyteam.bee.topics.google_map.fragment.GoogleMapsFragment
import kotlinx.android.synthetic.main.fragment_aboutus.*

class InstructionFragment : Fragment() {

    private lateinit var imgbtn_about_us_back: ImageButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_instcruction, container, false)

//        imgbtn_about_us_back = view.findViewById(R.id.imgbtn_about_us_back) as ImageButton
//        imgbtn_about_us_back.setOnClickListener {
//            fragmentManager?.beginTransaction()?.replace(
//                R.id.fragment_container_main_activity,
//                GoogleMapsFragment()
//            )?.commit()
//        }

        return view
    }
}