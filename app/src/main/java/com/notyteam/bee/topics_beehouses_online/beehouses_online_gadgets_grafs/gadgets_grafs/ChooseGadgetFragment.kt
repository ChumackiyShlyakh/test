package com.notyteam.bee.topics_beehouses_online.beehouses_online_gadgets_grafs.gadgets_grafs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.notyteam.bee.R
import com.notyteam.bee.topics_beehouses_online.beehouses_online_gadgets_grafs.fragment.GadgetsGrafsFragment
import kotlinx.android.synthetic.main.fragment_gadgets_grafs.*

class ChooseGadgetFragment : Fragment() {

    var btn_fragment_choose_gadget_choose: Button? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_choose_gadget, container, false)

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

                btn_fragment_gadgets_grafs_choose_meaning?.text = radio.text
                fragmentManager?.beginTransaction()?.replace(
                    R.id.fragment_container_main_activity,
                    GadgetsGrafsFragment()
                )?.commit()
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