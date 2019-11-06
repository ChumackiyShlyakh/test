package com.notyteam.bee.topics_beehouses_online.beehouses_online_gadgets_grafs.gadgets_grafs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.notyteam.bee.R
import com.notyteam.bee.topics_beehouses_online.beehouses_online_gadgets_grafs.GadgetsGrafsFragment
import com.notyteam.bee.utils.OnBackPressed
import kotlinx.android.synthetic.main.app_bar_main.*

class ChooseMeaningFragment : Fragment(), OnBackPressed {

    //  val rdgrp_fragment_choose_meaning: RadioGroup? = null
    var imgbtn_fragment_choose_meaning_back: ImageButton? = null
    var btn_fragment_choose_meaning_choose: Button? = null
    private var meanning: String? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_choose_meaning, container, false)

        imgbtn_fragment_choose_meaning_back = view.findViewById(R.id.imgbtn_fragment_choose_meaning_back)
        imgbtn_fragment_choose_meaning_back?.setOnClickListener({
            fragmentManager?.beginTransaction()?.replace(
                R.id.fragment_container_main_activity,
                GadgetsGrafsFragment()
            )?.commit()
            (activity as AppCompatActivity).toolbar_main_drawer?.visibility = View.VISIBLE
        })

        val rdgrp_fragment_choose_meaning =
            view.findViewById(R.id.rdgrp_fragment_choose_meaning) as RadioGroup
        btn_fragment_choose_meaning_choose =
            view.findViewById(R.id.btn_fragment_choose_meaning_choose)

        rdgrp_fragment_choose_meaning.setOnCheckedChangeListener({ group, checkedId ->
            val radio: RadioButton = view.findViewById(checkedId)
            meanning = radio.text as String?
        })

        btn_fragment_choose_meaning_choose?.setOnClickListener({
            var id: Int = rdgrp_fragment_choose_meaning.checkedRadioButtonId
            if (id != -1) {
                val radio: RadioButton = view.findViewById(id)

                val bundle = Bundle()
                bundle.putString("message_meaning", radio.text.toString())
                val gadgetsGrafsFragment =
                    GadgetsGrafsFragment()
                gadgetsGrafsFragment.setArguments(bundle)

                fragmentManager?.beginTransaction()?.replace(
                    R.id.fragment_container_main_activity,
                    gadgetsGrafsFragment
                )?.commit()
                (activity as AppCompatActivity).toolbar_main_drawer?.visibility = View.VISIBLE
            } else {
                Toast.makeText(
                    context, "On button click : nothing selected",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })

        return view
    }

    override fun onBackPressed() {
        fragmentManager?.beginTransaction()?.replace(
            R.id.fragment_container_main_activity,
            GadgetsGrafsFragment()
        )?.commit()
        (activity as AppCompatActivity).toolbar_main_drawer?.visibility = View.VISIBLE
    }
}