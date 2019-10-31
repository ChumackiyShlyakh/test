package com.notyteam.bee.topics_beehouses_online.beehouses_online_gadgets_grafs.gadgets_grafs.grafs.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import com.notyteam.bee.R

class MeaningGrafsFiltrFragment : Fragment() {

    var imgbtn_fragment_meaning_grafs_filtr_back: ImageButton? = null
    var fragment_meaning_grafs_filtr_period_build: Button? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view = inflater.inflate(R.layout.fragment_meaning_grafs_filtr, container,false)

        imgbtn_fragment_meaning_grafs_filtr_back = view?.findViewById(R.id.imgbtn_fragment_meaning_grafs_filtr_back)
        fragment_meaning_grafs_filtr_period_build = view?.findViewById(R.id.fragment_meaning_grafs_filtr_period_build)

        imgbtn_fragment_meaning_grafs_filtr_back?.setOnClickListener({
            fragmentManager?.beginTransaction()?.replace(
                R.id.fragment_container_main_activity,
                MeaningGrafsFragment()
            )?.commit()
        })

        fragment_meaning_grafs_filtr_period_build?.setOnClickListener({
            fragmentManager?.beginTransaction()?.replace(
                R.id.fragment_container_main_activity,
                MeaningGrafsFragment()
            )?.commit()
        })

        return view
    }
}