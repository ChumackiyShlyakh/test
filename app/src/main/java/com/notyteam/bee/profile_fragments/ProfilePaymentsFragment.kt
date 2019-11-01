package com.notyteam.bee.profile_fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.notyteam.bee.R
import com.notyteam.bee.topics.profile.fragment.ProfileFragment
import kotlinx.android.synthetic.main.app_bar_main.*

class ProfilePaymentsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile_payments, container, false)

        val imgbtn_fragment_profile_payments_back =  view.findViewById<ImageButton>(R.id.imgbtn_fragment_profile_payments_back)
        val ll_fragment_profile_payments_account = view.findViewById<LinearLayout>(R.id.ll_fragment_profile_payments_account_details)
        val ll_profile_payments_refill_account =  view.findViewById<LinearLayout>(R.id.ll_profile_payments_refill_account)

        imgbtn_fragment_profile_payments_back?.setOnClickListener(View.OnClickListener {
            fragmentManager?.beginTransaction()?.replace(
                R.id.fragment_container_main_activity,
                ProfileFragment()
            )?.commit()
            (activity as AppCompatActivity).toolbar_main_drawer?.visibility = View.VISIBLE
        })
        ll_fragment_profile_payments_account?.setOnClickListener(View.OnClickListener {
            fragmentManager?.beginTransaction()?.replace(
                R.id.fragment_container_main_activity,
                ProfileAccountDetailFragment()
            )?.commit()
        })
        ll_profile_payments_refill_account?.setOnClickListener(View.OnClickListener {
            fragmentManager?.beginTransaction()?.replace(
                R.id.fragment_container_main_activity,
                ProfileRefillFragment()
            )?.commit()
        })

        return view
//        return binding.root
    }
}