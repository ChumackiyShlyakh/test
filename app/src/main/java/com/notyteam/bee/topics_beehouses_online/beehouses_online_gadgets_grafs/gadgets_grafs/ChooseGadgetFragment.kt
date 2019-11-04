package com.notyteam.bee.topics_beehouses_online.beehouses_online_gadgets_grafs.gadgets_grafs

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.notyteam.bee.R
import com.notyteam.bee.topics_beehouses_online.beehouses_online_gadgets_grafs.fragment.GadgetsGrafsFragment
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.fragment_gadgets_grafs.*

class ChooseGadgetFragment : Fragment() {

    var imgbtn_fragment_choose_gadget_back: ImageButton? = null
    var btn_fragment_choose_gadget_choose: Button? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_choose_gadget, container, false)

        imgbtn_fragment_choose_gadget_back =
            view.findViewById(R.id.imgbtn_fragment_choose_gadget_back)
        imgbtn_fragment_choose_gadget_back?.setOnClickListener({
            fragmentManager?.beginTransaction()?.replace(
                R.id.fragment_container_main_activity,
                GadgetsGrafsFragment()
            )?.commit()
            (activity as AppCompatActivity).toolbar_main_drawer?.visibility = View.VISIBLE
        })

        val rdgrp_fragment_choose_gadget =
            view.findViewById(R.id.rdgrp_fragment_choose_gadget) as RadioGroup
        btn_fragment_choose_gadget_choose =
            view.findViewById(R.id.btn_fragment_choose_gadget_choose)

        rdgrp_fragment_choose_gadget.setOnCheckedChangeListener({ group, checkedId ->
            val radio: RadioButton = view.findViewById(checkedId)

        })

        btn_fragment_choose_gadget_choose?.setOnClickListener({
            var id: Int = rdgrp_fragment_choose_gadget.checkedRadioButtonId
            if (id != -1) {
                val radio: RadioButton = view.findViewById(id)

                activity?.btn_gadgets_grafs_choose_gadget?.setText(radio.text)

                val bundle = Bundle()
                bundle.putString("message_gadget", radio.text.toString())
                //set Fragmentclass Arguments
                val gadgetsGrafsFragment = GadgetsGrafsFragment()
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

//    fun radio_button_click(view: View) {
//        // Get the clicked radio button instance
//        val radio: RadioButton =
//            view.findViewById(rdgrp_fragment_choose_gadget.checkedRadioButtonId)
//        Toast.makeText(
//            context, "On click : ${radio.text}",
//            Toast.LENGTH_SHORT
//        ).show()
//    }
}