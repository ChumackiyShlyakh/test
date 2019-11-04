package com.notyteam.bee.topics_beehouses_online.beehouses_online_gadgets_grafs.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.notyteam.bee.R
import com.notyteam.bee.topics_beehouses_online.beehouses_online_gadgets_grafs.gadgets_grafs.ChooseGadgetFragment
import com.notyteam.bee.topics_beehouses_online.beehouses_online_gadgets_grafs.gadgets_grafs.ChooseMeaningFragment
import com.notyteam.bee.topics_beehouses_online.beehouses_online_gadgets_grafs.gadgets_grafs.grafs.fragment.MeaningGrafsFragment
import com.notyteam.bee.topics_beehouses_online.beehouses_online_gadgets_grafs.gadgets_grafs.tables.fragment.MeaningTablesFragment
import kotlinx.android.synthetic.main.app_bar_main.*

class GadgetsGrafsFragment : Fragment() {

    var rb_fragment_gadgets_grafs_table: RadioButton? = null
    var rb_fragment_gadgets_grafs_graf: RadioButton? = null
    var btn_fragment_gadgets_grafs_choose_meaning: Button? = null
    var btn_gadgets_grafs_choose_gadget: Button? = null
    var btn_fragment_gadgets_grafs_build: Button? = null
    var text_btn_gadgets_grafs_choose_gadget: String? = null
    var text_btn_gadgets_grafs_choose_meaning: String? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_gadgets_grafs, container, false)

        if (arguments?.getString("message_meaning") == null){
            text_btn_gadgets_grafs_choose_meaning = getString(R.string.choose_meaning)
        } else {
            text_btn_gadgets_grafs_choose_meaning = arguments?.getString("message_meaning")
        }

        if (arguments?.getString("message_gadget") == null){
            text_btn_gadgets_grafs_choose_gadget = getString(R.string.choose_gadget)
        } else {
            text_btn_gadgets_grafs_choose_gadget = arguments?.getString("message_gadget")
        }

        val rdgrp_fragment_gadgets_grafs =
            view.findViewById(R.id.rdgrp_fragment_gadgets_grafs) as RadioGroup

        rb_fragment_gadgets_grafs_table = view.findViewById(R.id.rb_fragment_gadgets_grafs_table)
        rb_fragment_gadgets_grafs_graf = view.findViewById(R.id.rb_fragment_gadgets_grafs_graf)

        btn_fragment_gadgets_grafs_choose_meaning = view.findViewById(R.id.btn_fragment_gadgets_grafs_choose_meaning)
        btn_gadgets_grafs_choose_gadget = view.findViewById(R.id.btn_gadgets_grafs_choose_gadget)
        btn_fragment_gadgets_grafs_build = view.findViewById(R.id.btn_fragment_gadgets_grafs_build)

        btn_fragment_gadgets_grafs_choose_meaning?.setText(text_btn_gadgets_grafs_choose_meaning)
        btn_gadgets_grafs_choose_gadget?.setText(text_btn_gadgets_grafs_choose_gadget)

        rdgrp_fragment_gadgets_grafs.setOnCheckedChangeListener({ group, checkedId ->
            val radio: RadioButton = view.findViewById(checkedId)

        })

        btn_fragment_gadgets_grafs_choose_meaning?.setOnClickListener({
            fragmentManager?.beginTransaction()?.replace(
                R.id.fragment_container_main_activity,
                ChooseMeaningFragment()
            )?.commit()
            (activity as AppCompatActivity).toolbar_main_drawer?.visibility = View.GONE
        })

        btn_gadgets_grafs_choose_gadget?.setOnClickListener({
            fragmentManager?.beginTransaction()?.replace(
                R.id.fragment_container_main_activity,
                ChooseGadgetFragment()
            )?.commit()
            (activity as AppCompatActivity).toolbar_main_drawer?.visibility = View.GONE
        })

        btn_fragment_gadgets_grafs_build?.setOnClickListener({
            var id: Int = rdgrp_fragment_gadgets_grafs.checkedRadioButtonId
            if (id != -1) {
                val radio: RadioButton = view.findViewById(id)

                Log.d("btn_fragment", "btn_fragment_gadgets_grafs_build " + id + " radio: " + radio)

                if (radio.equals(rb_fragment_gadgets_grafs_table)){
                    fragmentManager?.beginTransaction()?.replace(
                        R.id.fragment_container_main_activity,
                        MeaningTablesFragment()
                    )?.commit()
                } else if (radio == rb_fragment_gadgets_grafs_graf){
                    fragmentManager?.beginTransaction()?.replace(
                        R.id.fragment_container_main_activity,
                        MeaningGrafsFragment()
                    )?.commit()
                }
                (activity as AppCompatActivity).toolbar_main_drawer?.visibility = View.GONE
            } else {
                Toast.makeText(
                    context, "On button click : nothing selected",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
        return view
    }
}