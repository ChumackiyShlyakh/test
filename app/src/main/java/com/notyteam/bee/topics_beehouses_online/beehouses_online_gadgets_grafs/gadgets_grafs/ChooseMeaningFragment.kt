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
import kotlinx.android.synthetic.main.fragment_choose_meaning.*
import kotlinx.android.synthetic.main.fragment_gadgets_grafs.*

class ChooseMeaningFragment : Fragment() {

    //  val rdgrp_fragment_choose_meaning: RadioGroup? = null
    var btn_fragment_choose_meaning_choose: Button? = null
    private var meanning: String? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_choose_meaning, container, false)

        val rdgrp_fragment_choose_meaning =
            view.findViewById(R.id.rdgrp_fragment_choose_meaning) as RadioGroup
        btn_fragment_choose_meaning_choose =
            view.findViewById(R.id.btn_fragment_choose_meaning_choose)

        rdgrp_fragment_choose_meaning.setOnCheckedChangeListener({ group, checkedId ->
            val radio: RadioButton = view.findViewById(checkedId)
            meanning = radio.text as String?
//                Toast.makeText(
//                    context, " On checked change : ${radio.text}",
//                    Toast.LENGTH_SHORT
//                ).show()
        })

        btn_fragment_choose_meaning_choose?.setOnClickListener({
            var id: Int = rdgrp_fragment_choose_meaning.checkedRadioButtonId
            if (id != -1) {
                val radio: RadioButton = view.findViewById(id)

                btn_fragment_gadgets_grafs_choose_meaning?.text = meanning
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
//            view.findViewById(rdgrp_fragment_choose_meaning.checkedRadioButtonId)
//        Toast.makeText(
//            context, "On click : ${radio.text}",
//            Toast.LENGTH_SHORT
//        ).show()
//    }
}